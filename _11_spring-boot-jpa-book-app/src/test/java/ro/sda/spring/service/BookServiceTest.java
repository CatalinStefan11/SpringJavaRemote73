package ro.sda.spring.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import ro.sda.spring.dto.Book;
import ro.sda.spring.exception.BookAppException;
import ro.sda.spring.repository.BookRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BookServiceTest {
    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    @Test
    void testAddBook() {
        Book book = new Book();
        bookService.addBook(book);

        verify(bookRepository, times(1)).save(book);
    }

    @Test
    void testGetAllBooks() {
        Pageable pageable = PageRequest.of(0, 5);
        List<Book> bookList = Arrays.asList(new Book(), new Book());
        Page<Book> bookPage = new PageImpl<>(bookList, pageable, bookList.size());

        when(bookRepository.findAll(pageable)).thenReturn(bookPage);

        Page<Book> result = bookService.getAllBooks(pageable);

        assertEquals(2, result.getContent().size());
        verify(bookRepository, times(1)).findAll(pageable);
    }

    @Test
    void testGetById_BookExists() {
        Book book = new Book();
        book.setId(1L);

        when(bookRepository.findById(1L)).thenReturn(Optional.of(book));

        Book result = bookService.getById(1L);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        verify(bookRepository, times(1)).findById(1L);
    }

    @Test
    void testGetById_BookDoesNotExist() {
        when(bookRepository.findById(1L)).thenReturn(Optional.empty());

        Exception exception = assertThrows(BookAppException.class, () -> bookService.getById(1L));
        assertEquals("Book with id 1 not found", exception.getMessage());

        verify(bookRepository, times(1)).findById(1L);
    }

    @Test
    void testDeleteById_BookExists() {
        when(bookRepository.existsById(1L)).thenReturn(true);

        bookService.deleteById(1L);

        verify(bookRepository, times(1)).existsById(1L);
        verify(bookRepository, times(1)).deleteById(1L);
    }

    @Test
    void testDeleteById_BookDoesNotExist() {
        when(bookRepository.existsById(1L)).thenReturn(false);

        Exception exception = assertThrows(BookAppException.class, () -> bookService.deleteById(1L));
        assertEquals("Book with id 1 not found. Nothing to delete", exception.getMessage());

        verify(bookRepository, times(1)).existsById(1L);
        verify(bookRepository, never()).deleteById(1L);
    }

    @Test
    void testUpdateById_BookExists() {
        Book bookToUpdate = new Book();
        bookToUpdate.setTitle("Updated Title");

        when(bookRepository.existsById(1L)).thenReturn(true);

        bookService.updateById(1L, bookToUpdate);

        verify(bookRepository, times(1)).existsById(1L);
        verify(bookRepository, times(1)).save(bookToUpdate);
        assertEquals(1L, bookToUpdate.getId());
    }

    @Test
    void testUpdateById_BookDoesNotExist() {
        Book bookToUpdate = new Book();

        when(bookRepository.existsById(1L)).thenReturn(false);

        Exception exception = assertThrows(BookAppException.class, () -> bookService.updateById(1L, bookToUpdate));
        assertEquals("Book with id 1 not found! Nothing to update", exception.getMessage());

        verify(bookRepository, times(1)).existsById(1L);
        verify(bookRepository, never()).save(any(Book.class));
    }

    @Test
    void testGetBooksUsingFilters_PriceAndTitle() {
        List<Book> books = Arrays.asList(new Book(), new Book());

        when(bookRepository.findByPriceGreaterThanAndTitleContains(20.0, "Java")).thenReturn(books);

        List<Book> result = bookService.getBooksUsingFilters(20.0, "Java");

        assertEquals(2, result.size());
        verify(bookRepository, times(1)).findByPriceGreaterThanAndTitleContains(20.0, "Java");
    }

    @Test
    void testGetBooksUsingFilters_OnlyPrice() {
        List<Book> books = Arrays.asList(new Book(), new Book());

        when(bookRepository.findByPriceGreaterThan(20.0)).thenReturn(books);

        List<Book> result = bookService.getBooksUsingFilters(20.0, null);

        assertEquals(2, result.size());
        verify(bookRepository, times(1)).findByPriceGreaterThan(20.0);
    }

    @Test
    void testGetBooksUsingFilters_OnlyTitle() {
        List<Book> books = Arrays.asList(new Book(), new Book());

        when(bookRepository.findByTitleContains("Java")).thenReturn(books);

        List<Book> result = bookService.getBooksUsingFilters(0, "Java");

        assertEquals(2, result.size());
        verify(bookRepository, times(1)).findByTitleContains("Java");
    }
}

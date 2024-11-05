package ro.sda.spring.service;

import jakarta.annotation.Nullable;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ro.sda.spring.dto.Book;
import ro.sda.spring.exception.BookAppException;
import ro.sda.spring.repository.BookRepository;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class BookService {
    //    private static final Logger logger = LoggerFactory.getLogger(BookService.class);
    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(Book book) {
        log.info("Attempt to add book to the database {}", book);
        bookRepository.save(book);
    }

    public Page<Book> getAllBooks(Pageable pageable) {
        log.info("Attempt to retrieve all the books from the database");
        return bookRepository.findAll(pageable);
    }

    public Book getById(long id) {
        log.info("Attempt to retrieve book with id {} from the database", id);

        Optional<Book> bookOptional = bookRepository.findById(id);

        if (bookOptional.isPresent())
            return bookOptional.get();

        throw new BookAppException("Book with id " + id + " not found");
    }

    public void deleteById(long id) {
        log.info("Attempt to delete book with id {} from the database", id);

        if (!bookRepository.existsById(id))
            throw new BookAppException("Book with id " + id + " not found. Nothing to delete");

        bookRepository.deleteById(id);
    }

    public void updateById(long id, Book toUpdate) {
        log.info("Attempt to update book with id {} from the database", id);

        if (!bookRepository.existsById(id))
            throw new BookAppException("Book with id " + id + " not found! Nothing to update");

        toUpdate.setId(id);
        bookRepository.save(toUpdate);
    }

    public List<Book> getBooksUsingFilters(double price, @Nullable String title) {
        log.info("Attempt to retrieve books using filters from the database.");

        List<Book> bookList;

        if (title != null && price > 0)
            bookList = bookRepository.findByPriceGreaterThanAndTitleContains(price, title);
        else if (price > 0)
            bookList = bookRepository.findByPriceGreaterThan(price);
        else
            bookList = bookRepository.findByTitleContains(title);

        return bookList;
    }
}

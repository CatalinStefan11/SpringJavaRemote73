package ro.sda.spring.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ro.sda.spring.dto.Book;
import ro.sda.spring.service.BookService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

@RestController
public class BookController {
    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/book")
    @ResponseStatus(HttpStatus.CREATED)
    public void addBook(@Valid @RequestBody Book b) {
        bookService.addBook(b);
    }

    @GetMapping("/book")
    public Page<Book> getAllBooks(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "2") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        return bookService.getAllBooks(pageable);
    }

    @GetMapping("/book/{i}")
    public Book getById(@PathVariable("i") int id) {
        return bookService.getById(id);
    }

    @DeleteMapping("/book/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("id") long id) {
        bookService.deleteById(id);
    }

    @PutMapping("/book/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateById(@Valid @RequestBody Book b, @PathVariable("id") long id) {
        bookService.updateById(id, b);
    }

    @GetMapping("/filter-book")
    public List<Book> getBooksUsingFilters(
            @RequestParam(value = "price", required = false, defaultValue = "0") double price,
            @RequestParam(value = "title", required = false) String title
    ) {
        return bookService.getBooksUsingFilters(price, title);
    }
}

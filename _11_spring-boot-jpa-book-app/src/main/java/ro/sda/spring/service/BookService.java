package ro.sda.spring.service;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ro.sda.spring.dto.Book;
import ro.sda.spring.repository.BookRepository;

import java.util.List;

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

    public List<Book> getAllBooks() {
        log.info("Attempt to retrieve all the books from the database");
        return bookRepository.findAll();
    }
}

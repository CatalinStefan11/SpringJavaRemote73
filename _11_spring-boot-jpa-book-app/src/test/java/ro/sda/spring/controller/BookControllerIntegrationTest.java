package ro.sda.spring.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import ro.sda.spring.dto.Book;
import ro.sda.spring.repository.BookRepository;

import java.util.Arrays;

import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles("test")
@SpringBootTest
@AutoConfigureMockMvc
class BookControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        bookRepository.deleteAll();
    }

    @Test
    void testAddBook() throws Exception {
        Book book = new Book(0, "New Book", "John Doe", 19.99, "FICTION");

        mockMvc.perform(post("/book")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(book)))
                .andExpect(status().isCreated());

        // Verify that the book was saved to the database
        assertEquals(1, bookRepository.count());
    }

    @Test
    void testGetAllBooks() throws Exception {
        Book book1 = new Book(0, "Book One", "Author A", 10.0, "NOVEL");
        Book book2 = new Book(0, "Book Two", "Author B", 15.0, "HISTORY");

        bookRepository.save(book1);
        bookRepository.save(book2);

        mockMvc.perform(get("/book")
                .param("page", "0")
                .param("size", "2"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content", hasSize(2)))
                .andExpect(jsonPath("$.content[0].title", is("Book One")))
                .andExpect(jsonPath("$.content[1].title", is("Book Two")));
    }

    @Test
    void testGetBookById_BookExists() throws Exception {
        Book book = new Book(0, "Book by ID", "Author C", 12.99, "SELF_DEVELOPMENT");
        book = bookRepository.save(book);

        mockMvc.perform(get("/book/{id}", book.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title", is("Book by ID")))
                .andExpect(jsonPath("$.author", is("Author C")));
    }

    @Test
    void testGetBookById_BookDoesNotExist() throws Exception {
        mockMvc.perform(get("/book/{id}", 999))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message[0]", is("Book not found")));
    }

    @Test
    void testDeleteBookById_BookExists() throws Exception {
        Book book = new Book(0, "Book to Delete", "Author D", 9.99, "NOVEL");
        book = bookRepository.save(book);

        mockMvc.perform(delete("/book/{id}", book.getId()))
                .andExpect(status().isNoContent());

        // Verify that the book was deleted from the database
        assertFalse(bookRepository.existsById(book.getId()));
    }

    @Test
    void testDeleteBookById_BookDoesNotExist() throws Exception {
        mockMvc.perform(delete("/book/{id}", 999))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message[0]", is("Book not found")));
    }

    @Test
    void testUpdateBookById_BookExists() throws Exception {
        Book book = new Book(0, "Original Title", "Original Author", 10.0, "FICTION");
        book = bookRepository.save(book);

        Book updatedBook = new Book(0, "Updated Title", "Updated Author", 15.0, "HISTORY");

        mockMvc.perform(put("/book/{id}", book.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(updatedBook)))
                .andExpect(status().isAccepted());

        Book retrievedBook = bookRepository.findById(book.getId()).orElseThrow();
        assertEquals("Updated Title", retrievedBook.getTitle());
        assertEquals("Updated Author", retrievedBook.getAuthor());
        assertEquals(15.0, retrievedBook.getPrice());
    }

    @Test
    void testUpdateBookById_BookDoesNotExist() throws Exception {
        Book updatedBook = new Book(0, "Updated Title", "Updated Author", 15.0, "HISTORY");

        mockMvc.perform(put("/book/{id}", 999)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(updatedBook)))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message[0]", is("Book not found")));
    }

    @Test
    void testGetBooksUsingFilters_PriceAndTitle() throws Exception {
        Book book1 = new Book(0, "Java Basics", "Author X", 25.0, "SELF_DEVELOPMENT");
        Book book2 = new Book(0, "Advanced Java", "Author Y", 35.0, "SELF_DEVELOPMENT");
        Book book3 = new Book(0, "Python Basics", "Author Z", 20.0, "NOVEL");
        bookRepository.saveAll(Arrays.asList(book1, book2, book3));

        mockMvc.perform(get("/filter-book")
                .param("price", "30")
                .param("title", "Java"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].title", is("Advanced Java")));
    }

    @Test
    void testValidationErrorOnAddBook() throws Exception {
        Book invalidBook = new Book(0, "", "", -10.0, "UNKNOWN");

        mockMvc.perform(post("/book")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(invalidBook)))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message", hasItems(
                        "Title is required. Cannot be empty",
                        "Author is required. Cannot be empty",
                        "Price must be a positive number",
                        "Invalid genre"
                )));
    }
}

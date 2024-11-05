package ro.sda.spring.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.sda.spring.dto.Book;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    // derived query -> JPA framework derives the query from the method name
    // so choosing an appropriate name will tell JPA that it needs to use certain
    // criteria in order to query for the data
    // @Query in order to write the SQL query when needed
    List<Book> findByPriceGreaterThan(double price);

    List<Book> findByTitleContains(String title);

    List<Book> findByPriceGreaterThanAndTitleContains(double price, String title);

    Page<Book> findAll(Pageable pageable);
}

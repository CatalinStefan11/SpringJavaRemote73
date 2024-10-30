package ro.sda.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.sda.spring.dto.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}

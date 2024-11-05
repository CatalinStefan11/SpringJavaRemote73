package ro.sda.spring.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import ro.sda.spring.validation.ValidGenre;

@Entity(name = "book")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Title is required. Cannot be empty")
    private String title;

    @NotBlank(message = "Author is required. Cannot be empty")
    private String author;

    @Min(value = 0, message = "Price must be a positive number")
    private double price;

    @ValidGenre
    private String genre;
}

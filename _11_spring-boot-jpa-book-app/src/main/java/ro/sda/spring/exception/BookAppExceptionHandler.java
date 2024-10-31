package ro.sda.spring.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ro.sda.spring.exception.model.ClientError;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Slf4j
@RestControllerAdvice
public class BookAppExceptionHandler {
    private static final String NOT_FOUND_MESSAGE = "Book not found";

    @ExceptionHandler(value = BookAppException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ClientError handleBookAppException(BookAppException exception) {
        log.warn("An exception has occurred: {}", exception.getMessage());
        return new ClientError(LocalDateTime.now(), Collections.singletonList(NOT_FOUND_MESSAGE), HttpStatus.NOT_FOUND.value());
    }


    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ClientError handleValidationException(MethodArgumentNotValidException ex) {
        log.warn("An exception has occurred: {}", ex.getMessage());

//        ArrayList<String> result = new ArrayList<>();
//        for (var obj : ex.getDetailMessageArguments()) {
//            String s = obj.toString();
//            if (!s.isEmpty()) {
//                result.add(s);
//            }
//        }

        //  "price: Price must be a positive number, and author: Author is required. Cannot be empty, and title: Name is required. Cannot be empty"
        List<String> messageList = Arrays.stream(ex.getDetailMessageArguments())
                .map((Object obj) -> obj.toString())
                .filter((String s) -> !s.isEmpty())
                .toList();


        List<String> messageToReturnList = new ArrayList<>();

        if(!messageList.isEmpty()) {
            // 0 -> price: Price must be a positive number
            // 1 -> and author: Author is required. Cannot be empty
            // 2 -> and title: Name is required. Cannot be empty
            String[] splitByComma =  messageList.get(0).split(",");

            for(String s : splitByComma) {
                // 0 -> price
                // 1 -> Price must be a positive number
                messageToReturnList.add(s.split(":")[1].trim());
            }
        }
        return new ClientError(LocalDateTime.now(), messageToReturnList, HttpStatus.BAD_REQUEST.value());
    }


}

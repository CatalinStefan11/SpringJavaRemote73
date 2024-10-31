package ro.sda.spring.exception;

public class BookAppException extends RuntimeException {

    public BookAppException(String message) {
        super(message);
    }
}

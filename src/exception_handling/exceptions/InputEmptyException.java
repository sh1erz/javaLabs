package exception_handling.exceptions;

public class InputEmptyException extends RuntimeException{
    public InputEmptyException(String message) {
        super(message);
    }
}

package exception_handling.exceptions;

public class IncorrectMenuNumberException extends IllegalArgumentException {
    public IncorrectMenuNumberException(String s) {
        super(s);
    }
}

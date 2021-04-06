package exception_handling.exceptions;

public class PriceLessThanZeroException extends RuntimeException{
    public PriceLessThanZeroException(String message) {
        super(message);
    }
}

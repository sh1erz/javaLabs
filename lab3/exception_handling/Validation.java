package exception_handling;

import exception_handling.exceptions.IncorrectMenuNumberException;
import exception_handling.exceptions.PriceLessThanZeroException;
import exception_handling.exceptions.InputEmptyException;
import exception_handling.exceptions.StringNumericException;


public class Validation {
    public static void checkMenu(int input) throws IncorrectMenuNumberException {
        if (input < 0 || input > 3) {
            throw new IncorrectMenuNumberException("Choice is out of bounds");
        }
    }

    public static void checkPrice(int input) throws PriceLessThanZeroException {
        if (input <= 0) {
            throw new PriceLessThanZeroException("Price can't be zero and less");
        }
    }

    public static void checkEmpty(String input) throws InputEmptyException {
        if (input.strip().isEmpty()) {
            throw new InputEmptyException("Input can't be empty");
        }
    }

    public static void checkStringNotNumeric(String input) throws StringNumericException {
        if (input.matches("\\d+")) {
            throw new StringNumericException("This value can't be numeric");
        }
    }
}

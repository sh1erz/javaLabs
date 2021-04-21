package view;

import exception_handling.Validation;
import exception_handling.exceptions.IncorrectMenuNumberException;

import java.util.Scanner;

public class InputUtility {
    private static Scanner sc = new Scanner(System.in);

    public static String saveList(PlumbingView view) {
        view.printMessage("Would you like to save? y/n");
        return sc.nextLine();

    }

    public static String inputStringValue(PlumbingView view, String input_string) {
        view.printMessage(input_string);
        return sc.nextLine();
    }

    public static int inputPriceValue(PlumbingView view) {
        view.printMessage(PlumbingView.INPUT_PRICE);
        return returnInt(view);
    }

    public static int inputMenuChoice(PlumbingView view) {
        view.printMessage(PlumbingView.MENU);
        while (true) {
            int input = returnInt(view);
            try {
                Validation.checkMenu(input);
                return input;
            } catch (IncorrectMenuNumberException e) {
                view.printMessage(e.getMessage());
            }
        }
    }

    private static int returnInt(PlumbingView view) {
        while (!sc.hasNextInt()) {
            view.printMessage(PlumbingView.WRONG_INPUT_INT);
            sc.next();
        }
        int output = sc.nextInt();
        sc.nextLine();
        return output;
    }

}


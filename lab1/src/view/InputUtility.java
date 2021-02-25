package view;

import java.util.Scanner;

public class InputUtility {
    private static Scanner sc = new Scanner(System.in);

    public static String inputStringValue(PlumbingView view, String input_string) {
        view.printMessage(input_string);
        sc.nextLine();
        return sc.nextLine();
    }

    public static int inputPriceValue(PlumbingView view) {
        view.printMessage(PlumbingView.INPUT_PRICE);
        while (!sc.hasNextInt()) {
            view.printMessage(PlumbingView.WRONG_INPUT);
            sc.next();
        }
        int input = sc.nextInt();
        while (input <= 0) {
            view.printMessage(PlumbingView.WRONG_INPUT);
            input = sc.nextInt();
        }
        return input;
    }

    public static int inputMenuChoice(PlumbingView view) {
        view.printMessage(PlumbingView.MENU);
        while (!sc.hasNextInt()) {
            view.printMessage(PlumbingView.WRONG_INPUT);
            sc.next();
        }
        int input = sc.nextInt();
        while (input < 0 || input > 4) {
            view.printMessage(PlumbingView.WRONG_INPUT);
            input = sc.nextInt();
        }
        return input;
    }

}


package view;

import model.Plumbing;
import model.FormatPlumbing;


public class PlumbingView {
    public static final String MENU = "Show list - 1 |  Find by firm - 2 | Find by type and max price - 3 | Exit - 0";
    public static final String WRONG_INPUT = "Wrong input, repeat";
    public static final String WRONG_INPUT_INT = "Wrong input, numeric value required";
    public static final String INPUT_TYPE = "Enter type: ";
    public static final String INPUT_FIRM = "Enter firm: ";
    public static final String INPUT_PRICE = "Enter price: ";
    public static final String OUTPUT_LIST = "Found:";
    public static final String ADD_ITEM = "Item is successfully added";
    public static final String DATA_SAVED = "Data was successfully saved";
    public static final String TABLE = "id\tprice\tamount\tname\tmodel\ttype\tfirm\n";

    public static final String NOT_FOUND = "Nothing found";

    public PlumbingView() {
        run();
    }

    private void run(){

    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printMessage(String message, Plumbing[] plumbingArr) {
        if (plumbingArr.length == 0) {
            printMessage(NOT_FOUND);
        } else {
            printMessage(message);
            printMessage(TABLE + FormatPlumbing.formatPlumbingArrToString(plumbingArr));
        }
    }





}

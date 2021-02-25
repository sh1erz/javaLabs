package view;

import model.Plumbing;


public class PlumbingView {
    public static final String MENU = "Show list - 1 | Add - 2 | Find by firm - 3 | Find by type and max price - 4 | Exit - 0";
    public static final String WRONG_INPUT = "Wrong input, repeat";
    public static final String INPUT_TYPE = "Enter type: ";
    public static final String INPUT_FIRM = "Enter firm: ";
    public static final String INPUT_PRICE = "Enter price: ";
    public static final String OUTPUT_LIST = "Found:";
    public static final String ADD_ITEM = "Item is successfully added";
    public static final String NOT_FOUND = "Nothing found";

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printMessage(String message, Plumbing[] plumbingArr) {
        if (plumbingArr.length == 0) {
            printMessage(NOT_FOUND);
        } else {
            printMessage(message);
            printMessage(formatPlumbingArr(plumbingArr));
        }
    }

    private String formatPlumbingArr(Plumbing[] plumbingArr){
        String[] outputArr = new String[plumbingArr.length + 1];
        outputArr[0] = "id\tprice\tamount\tname\tmodel\ttype\tfirm";
        for (int i = 1; i < plumbingArr.length + 1; i++) {
            String[] temp = formatPlumbing(plumbingArr[i - 1]).split(",");
            outputArr[i] = String.format("%2s\t%4s\t%2s\t%8s\t%4s\t%4s\t%2s", temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6]);
        }
        return String.join("\n", outputArr);
    }

    private String formatPlumbing(Plumbing plumbing){
        return String.format("%d,%d,%d,%s,%s,%s,%s", plumbing.getId(), plumbing.getPrice(), plumbing.getAmount(),
                plumbing.getName(), plumbing.getModel(), plumbing.getType(), plumbing.getFirm());
    }

}

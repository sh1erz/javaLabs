package controller;


import exception_handling.Validation;
import exception_handling.exceptions.PriceLessThanZeroException;
import exception_handling.exceptions.InputEmptyException;
import exception_handling.exceptions.StringNumericException;
import model.Plumbing;
import model.PlumbingModel;
import view.InputUtility;
import view.PlumbingView;

public class PlumbingController {
    private final PlumbingModel model = new PlumbingModel();
    private final PlumbingView view = new PlumbingView();
    private Plumbing[] tempData;

    public void run() {
        while (true) {
            switch (InputUtility.inputMenuChoice(view)) {
                case 0:
                    model.saveData(view.formatPlumbingArr(tempData));
                    System.exit(0);
                case 1:
                    view.printMessage(PlumbingView.OUTPUT_LIST, model.getPlumbingList());
                    break;
                case 2:
                    CaseFindByFirm();
                    break;
                case 3:
                    CaseFindByTypeMaxPrice();
                    break;
            }
        }
    }


    private void CaseFindByFirm() {
        boolean isOkay = false;
        String firm = null;
        while (!isOkay) {
            try {
                firm = InputUtility.inputStringValue(view, PlumbingView.INPUT_FIRM);
                Validation.checkEmpty(firm);
                Validation.checkStringNotNumeric(firm);
                isOkay = true;
            } catch (InputEmptyException | StringNumericException e) {
                System.out.println(e.getMessage());
            }
        }
        tempData = model.getPlumbingByFirm(firm);
        view.printMessage(PlumbingView.OUTPUT_LIST, tempData);
        if (InputUtility.saveList(view).equals("y")) {
            model.saveData("Found by firm: " + firm + view.formatPlumbingArr(tempData));
        }
    }

    private void CaseFindByTypeMaxPrice() {
        boolean isOkay = false;
        String type = null;
        int price = 0;
        while (!isOkay) {
            try {
                type = InputUtility.inputStringValue(view, PlumbingView.INPUT_TYPE);
                Validation.checkEmpty(type);
                Validation.checkStringNotNumeric(type);
                isOkay = true;
            } catch (InputEmptyException | StringNumericException e) {
                view.printMessage(e.getMessage());
            }
        }
        isOkay = false;
        while (!isOkay) {
            try {
                price = InputUtility.inputPriceValue(view);
                Validation.checkPrice(price);
                isOkay = true;
            } catch (PriceLessThanZeroException e) {
                view.printMessage(e.getMessage());
            }
        }
        tempData = model.getPlumbingByTypeAndPrice(type, price);
        view.printMessage(PlumbingView.OUTPUT_LIST, tempData);
        if (InputUtility.saveList(view).equals("y")) {
            model.saveData("Found by type: " + type + " and price: " + price + view.formatPlumbingArr(tempData));
        }
    }
}

package controller;


import exception_handling.Validation;
import exception_handling.exceptions.PriceLessThanZeroException;
import exception_handling.exceptions.InputEmptyException;
import exception_handling.exceptions.StringNumericException;
import model.DataSource;
import model.PlumbingModel;
import view.InputUtility;
import view.PlumbingView;

public class PlumbingController {
    private final PlumbingModel model = new PlumbingModel();
    private final PlumbingView view = new PlumbingView();

    public void run() {
        while (true) {
            switch (InputUtility.inputMenuChoice(view)) {
                case 0 -> System.exit(0);
                case 1 -> view.printMessage(PlumbingView.OUTPUT_LIST, model.getPlumbingList());
                case 2 -> {
                    model.addElement(DataSource.createPlumbingModel());
                    view.printMessage(PlumbingView.ADD_ITEM, model.getPlumbingList());
                }
                case 3 -> CaseFindByFirm();
                case 4 -> CaseFindByTypeMaxPrice();
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
        view.printMessage(PlumbingView.OUTPUT_LIST, model.getPlumbingByFirm(firm));
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
                System.out.println(e.getMessage());
            }
        }
        isOkay = false;
        while (!isOkay) {
            try {
                price = InputUtility.inputPriceValue(view);
                Validation.checkPrice(price);
                isOkay = true;
            } catch (PriceLessThanZeroException e) {
                System.out.println(e.getMessage());
            }
        }
        view.printMessage(PlumbingView.OUTPUT_LIST, model.getPlumbingByTypeAndPrice(type, price));

    }
}

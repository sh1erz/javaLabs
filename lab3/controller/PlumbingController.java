package controller;


import exception_handling.Validation;
import exception_handling.exceptions.PriceLessThanZeroException;
import exception_handling.exceptions.InputEmptyException;
import exception_handling.exceptions.StringNumericException;
import model.Plumbing;
import model.PlumbingModel;
import view.InputUtility;
import view.PlumbingView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class PlumbingController {
    private PlumbingModel model;
    private final PlumbingView view = new PlumbingView();

    public PlumbingController() {
        try {
            model = new PlumbingModel();
        } catch (FileNotFoundException e) {
            view.printMessage("File wasn't found");
            System.exit(0);
        } catch (IOException e) {
            view.printMessage("Getting data was not successful, an error occurred");
            System.exit(0);
        }
    }

    public void run() {
        while (true) {
            switch (InputUtility.inputMenuChoice(view)) {
                case 0:
                    try {
                        model.saveData();
                        view.printMessage(PlumbingView.DATA_SAVED);
                    } catch (FileNotFoundException e) {
                        view.printMessage("File wasn't found");
                    } catch (IOException e) {
                        view.printMessage("Saving data was not successful, an error occurred");
                        System.exit(0);
                    }
                    System.exit(0);

                case 1:
                    view.printMessage(PlumbingView.OUTPUT_LIST, model.getPlumbingList());
                    break;
                case 2:
                    caseFindByFirm();
                    break;
                case 3:
                    caseFindByTypeMaxPrice();
                    break;
            }
        }
    }

    private void saveTempData() {
        if (InputUtility.saveList(view).equals("y")) {
            try {
                String file = InputUtility.inputStringValue(view, "Enter file name: ");
                model.saveData(file);
                view.printMessage(PlumbingView.DATA_SAVED);
            } catch (FileNotFoundException e) {
                view.printMessage("File wasn't found");
            } catch (IOException e) {
                view.printMessage("Saving data was not successful, an error occurred");
            }

        }
    }

    private void caseFindByFirm() {
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
        model.setTempData(model.getPlumbingByFirm(firm));
        view.printMessage(PlumbingView.OUTPUT_LIST, model.getTempData());
        saveTempData();
    }

    private void caseFindByTypeMaxPrice() {
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
        model.setTempData(model.getPlumbingByTypeAndPrice(type, price));
        view.printMessage(PlumbingView.OUTPUT_LIST, model.getTempData());
        saveTempData();
    }
}

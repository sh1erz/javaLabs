package controller;


import model.DataSource;
import model.PlumbingModel;
import view.InputUtility;
import view.PlumbingView;

public class PlumbingController {
    private final PlumbingModel model = new PlumbingModel(10);
    private final PlumbingView view = new PlumbingView();

    public void run() {
        while (true) {
            switch (InputUtility.inputMenuChoice(view)) {
                case 0:
                    System.exit(0);
                case 1:
                    view.printMessage(PlumbingView.OUTPUT_LIST, model.getPlumbingList());
                    break;
                case 2:
                    model.addElement(DataSource.createPlumbingModel());
                    view.printMessage(PlumbingView.ADD_ITEM, model.getPlumbingList());
                    break;
                case 3:
                    view.printMessage(PlumbingView.OUTPUT_LIST,
                            model.getPlumbingByFirm(InputUtility.inputStringValue(view, PlumbingView.INPUT_FIRM)));
                    break;
                case 4:
                    view.printMessage(PlumbingView.OUTPUT_LIST,
                            model.getPlumbingByTypeAndPrice(InputUtility.inputStringValue(view, PlumbingView.INPUT_TYPE),
                                    InputUtility.inputPriceValue(view)));
                    break;
            }
        }
    }
}

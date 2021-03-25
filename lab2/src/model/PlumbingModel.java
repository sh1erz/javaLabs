package model;

public class PlumbingModel {
    private Plumbing[] plumbingList;

    public PlumbingModel() {
        plumbingList = DataSource.createPlumbingModelArray();
    }

    public Plumbing[] getPlumbingByFirm(String firm) {
        Plumbing[] temp = new Plumbing[getPlumbingListLength()];
        int index = 0;
        for (int i = 0; i < plumbingList.length; i++) {
            if (plumbingList[i].getFirm().equals(firm)) {
                System.arraycopy(plumbingList, i, temp, index, 1);
                index++;
            }
        }
        Plumbing[] out = new Plumbing[index];
        System.arraycopy(temp, 0, out, 0, index);
        return out;
    }

    public Plumbing[] getPlumbingByTypeAndPrice(String type, int price) {
        Plumbing[] temp = new Plumbing[getPlumbingListLength()];
        int index = 0;
        for (int i = 0; i < plumbingList.length; i++) {
            if (plumbingList[i].getType().equals(type) && plumbingList[i].getPrice() <= price) {
                System.arraycopy(plumbingList, i, temp, index, 1);
                index++;
            }
        }
        Plumbing[] out = new Plumbing[index];
        System.arraycopy(temp, 0, out, 0, index);
        return out;
    }

    public Plumbing[] getPlumbingList() {
        return plumbingList;
    }

    public int getPlumbingListLength() {
        return plumbingList.length;
    }

    public void addElement(Plumbing newItem) {
        Plumbing[] temp = new Plumbing[plumbingList.length + 1];
        System.arraycopy(plumbingList, 0, temp, 0, plumbingList.length);
        temp[temp.length - 1] = newItem;
        plumbingList = temp;
    }
}

package model;

import java.io.IOException;

public class PlumbingModel {
    private Plumbing[] plumbingList;
    private Plumbing[] tempData;
    DataSourceFile dataSourceFile = new DataSourceFile();

    public PlumbingModel() throws IOException {
        plumbingList = dataSourceFile.getData();
    }

    public void saveData() throws IOException{
        dataSourceFile.saveData(plumbingList);
    }
    public void saveData(String fileName) throws IOException {
        if (tempData != null) {
            dataSourceFile.saveData(tempData, fileName);
        }
    }

    public void setTempData(Plumbing[] tempData){
        this.tempData = tempData;
    }

    public Plumbing[] getTempData() {
        return tempData;
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

}

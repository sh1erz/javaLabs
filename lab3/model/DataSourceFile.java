package model;

import java.io.*;



public class DataSourceFile {
    private static final String filePath = "C:\\Users\\Karina\\IdeaProjects\\labj3\\src\\model\\files\\";
    private static final String file = "maindata.txt";

    public Plumbing[] getData() throws IOException {
        String src = filePath + file;
        char[] arr = new char[1000];
        FileReader input = new FileReader(src);
        input.read(arr);
        return FormatPlumbing.formatStringToPlumbingArray(new String(arr));
    }

    public void saveData(Plumbing[] array) throws IOException {
        String src = filePath + file;
        FileWriter fw = new FileWriter(src);
        fw.write(FormatPlumbing.formatPlumbingArrToString(array));
        fw.close();
    }

    public void saveData(Plumbing[] array, String fileName) throws IOException {
        String src = filePath + fileName;
        FileWriter fw = new FileWriter(src, true);
        fw.write(FormatPlumbing.formatPlumbingArrToString(array));
        fw.append("\n\n");
        fw.close();
    }


}
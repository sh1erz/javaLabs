package model;

import java.io.*;


public class DataSourceFile {


    public static Plumbing[] getDataFromSource() {
        String src = "C:\\Users\\Karina\\IdeaProjects\\labj3\\src\\model\\files\\input.txt";
        char[] arr = new char[1000];
        try (FileReader input = new FileReader(src)) {
            input.read(arr);
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println("IOEx");
        }
        return formatToPlumbingArray(arr);
    }

    private static Plumbing[] formatToPlumbingArray(char[] arr) {
        String s = new String(arr);
        String[] lines = s.split("\n");
        int length = lines.length;
        int[] price = new int[length];
        int[] amount = new int[length];
        String[] name = new String[length];
        String[] model = new String[length];
        String[] type = new String[length];
        String[] firm = new String[length];
        for (int i = 0; i < length; i++) {
            String[] temp = lines[i].trim().split("\\s+");
            price[i] = Integer.parseInt(temp[1]);
            amount[i] = Integer.parseInt(temp[2]);
            name[i] = temp[3];
            model[i] = temp[4];
            type[i] = temp[5];
            firm[i] = temp[6];
        }
        Plumbing[] plumbArr = new Plumbing[length];
        for (int i = 0; i < length; i++) {
            plumbArr[i] = new Plumbing(price[i], amount[i], name[i], model[i], type[i], firm[i]);
        }
        return plumbArr;
    }

    public static void saveData(String arr){
        String src = "C:\\Users\\Karina\\IdeaProjects\\labj3\\src\\model\\files\\output.txt";
        try(FileWriter fw = new FileWriter(src, true)){
            fw.write(arr);
            fw.append("\n\n");
            fw.flush();
        }catch (FileNotFoundException ex) {
            System.out.println("No such file");
        } catch (IOException ex) {
            System.out.println("File can't be opened");
        }
    }
}
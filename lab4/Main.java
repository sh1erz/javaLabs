import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<ArrayList<String>> arrays = new ArrayList<>(3);
        System.out.println("ArrayLists:");
        for (int i = 0; i < 3; i++) {
            arrays.add(fillArray());
            printArrayLists(arrays.get(i));
        }
        ArrayList<String> input = new ArrayList<>(3);
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 3 numbers: ");
        for (int i = 0; i < 3; i++) {
            while (!sc.hasNextInt()) {
                System.out.println("input not integer");
                sc.nextLine();
            }
            input.add(sc.nextLine());
        }
        printArrayLists(input);
        for (ArrayList<String> arr : arrays) {
            System.out.println(isInList(arr, input));
        }

    }

    public static <T> boolean isInList(ArrayList<T> arr, ArrayList<T> elem) {
        if (arr.size() < 3) {
            return false;
        }
        ArrayList<T> arr3 = new ArrayList<>(arr.subList(0, 3));
        return arr3.equals(elem);
    }


    public static ArrayList<String> fillArray() {
        int length = (int) (Math.random() * 8);
        ArrayList<String> out = new ArrayList<>(length);
        for (int i = 0; i < length; i++) {
            out.add(Integer.toString((int) (Math.random() * 10000)));
        }
        return out;
    }

    public static <T> void printArrayLists(ArrayList<T>... lists) {
        for (ArrayList<T> arraylist : lists) {
            for (T t : arraylist) {
                System.out.print(t + " ");
            }
            System.out.println();
        }
    }
}

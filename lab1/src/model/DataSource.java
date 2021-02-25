package model;

public class DataSource {

    private static String[] names = {"раковина", "ванна", "котел", "душ", "кран"};
    private static String[] models = {"мод1", "мод2", "мод3", "мод4", "мод5"};
    private static String[] types = {"тип1", "тип2", "тип3", "тип4", "тип5"};
    private static String[] firms = {"ф1", "ф2", "ф3", "ф4", "ф5"};

    public static Plumbing[] createPlumbingModelArray(int length) {
        Plumbing[] arr = new Plumbing[length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = createPlumbingModel();
            for (int j = 0; j < i; j++) {
                if (arr[i].equals(arr[j])) {
                    i--;
                }
            }
        }
        return arr;
    }

    public static Plumbing createPlumbingModel() {
        return new Plumbing(100 + (int) (Math.random() * 901), (int) (Math.random() * 50),
                names[(int) (Math.random() * 5)], models[(int) (Math.random() * 5)], types[(int) (Math.random() * 5)],
                firms[(int) (Math.random() * 5)]);
    }
}

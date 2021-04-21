package model;

public class FormatPlumbing {
    public static String formatPlumbingArrToString(Plumbing[] plumbingArr) {
        if (plumbingArr == null) {
            return null;
        }
        String[] outputArr = new String[plumbingArr.length];
        for (int i = 0; i < plumbingArr.length; i++) {
            String[] temp = formatPlumbingToString(plumbingArr[i]).split(",");
            outputArr[i] = String.format("%2s\t%4s\t%2s\t%8s\t%4s\t%4s\t%2s", temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6]);
        }
        return String.join("\n", outputArr);
    }

    public static String formatPlumbingToString(Plumbing plumbing) {
        return String.format("%d,%d,%d,%s,%s,%s,%s", plumbing.getId(), plumbing.getPrice(), plumbing.getAmount(),
                plumbing.getName(), plumbing.getModel(), plumbing.getType(), plumbing.getFirm());
    }

    public static Plumbing[] formatStringToPlumbingArray(String s) {
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
}

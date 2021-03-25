package model;

public class Plumbing {
    private int id;
    private int price;
    private int amount;

    private String name;
    private String model;
    private String type;
    private String firm;
    private static int ID = 0;

    public Plumbing() {
        id = ID++;
        price = 0;
        amount = 0;
        name = null;
        model = null;
        type = null;
        firm = null;
    }


    public Plumbing(int price, int amount, String name, String model, String type, String firm) {
        this.id = ID++;
        this.price = price;
        this.amount = amount;
        this.name = name;
        this.model = model;
        this.type = type;
        this.firm = firm;

    }

    public boolean equals(Plumbing newPlumbing) {
        return newPlumbing.name.equals(this.name) && newPlumbing.model.equals(this.model) &&
                newPlumbing.type.equals(this.type) && newPlumbing.firm.equals(this.firm);
    }

    public static int getID() {
        return ID;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFirm() {
        return firm;
    }

    public void setFirm(String firm) {
        this.firm = firm;
    }



}

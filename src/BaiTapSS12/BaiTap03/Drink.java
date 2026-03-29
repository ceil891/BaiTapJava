package BaiTapSS12.BaiTap03;

abstract class Drink {
    private int id;
    private String name;
    private double price;

    public Drink(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public abstract void prepare();

    // Getter & Setter
    public int getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }

    public void setPrice(double price) {
        this.price = price;
    }

    public void showInfo() {
        System.out.println("ID: " + id + " | " + name + " | Price: " + price);
    }
}

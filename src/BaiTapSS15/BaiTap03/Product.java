package BaiTapSS15.BaiTap03;

public class Product {
    private int id;
    private String name;
    private double price;

    public Product(int id, String name, double price) throws InvalidPriceException {
        if (price <= 0) throw new InvalidPriceException("Giá sản phẩm phải > 0!");
        this.id = id;
        this.name = name;
        this.price = price;
    }

    // Getters / Setters
    public int getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }

    @Override
    public String toString() {
        return String.format("ID: %d | Tên: %-15s | Giá: %,.0f VNĐ", id, name, price);
    }
}
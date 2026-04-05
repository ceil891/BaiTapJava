package BaiTapSS15.BaiTap03;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private int orderId;
    private List<Product> products;

    public Order(int orderId) {
        this.orderId = orderId;
        this.products = new ArrayList<>();
    }

    public void addProduct(Product p) {
        products.add(p);
    }

    public double calculateTotal() {
        return products.stream().mapToDouble(Product::getPrice).sum();
    }

    public void showOrderDetails() {
        System.out.println("Mã đơn hàng: " + orderId);
        products.forEach(p -> System.out.println(" - " + p.getName() + ": " + p.getPrice()));
        System.out.println("=> Tổng cộng: " + String.format("%,.0f", calculateTotal()) + " VNĐ");
    }
}
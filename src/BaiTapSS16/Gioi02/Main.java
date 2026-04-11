package BaiTapSS16.Gioi02;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<Product> products = new ArrayList<>();

        products.add(new Product("Laptop", 1200));
        products.add(new Product("Chuột", 50));
        products.add(new Product("Bàn phím", 80));
        products.add(new Product("Màn hình", 200));

        ProductProcessor processor = new ProductProcessorImpl();

        // 🔹 Kiểm tra sản phẩm đắt tiền
        if (processor.hasExpensiveProduct(products)) {
            System.out.println(" Có sản phẩm đắt tiền (>100)");
        } else {
            System.out.println(" Không có sản phẩm đắt tiền");
        }

        // 🔹 Tính tổng giá trị
        double total = processor.calculateTotalValue(products);
        System.out.println("💰 Tổng giá trị: " + total);

        // 🔹 In danh sách
        ProductProcessor.printProductList(products);
    }
}
package BaiTapSS16.Gioi02;

import java.util.List;
import java.util.function.Predicate;

public interface ProductProcessor {

    // 🔹 Abstract method
    double calculateTotalValue(List<Product> products);

    // 🔹 Static method
    static void printProductList(List<Product> products) {
        System.out.println("\n=== DANH SÁCH SẢN PHẨM ===");
        products.forEach(System.out::println);
    }

    // 🔹 Default method
    default boolean hasExpensiveProduct(List<Product> products) {
        Predicate<Product> expensive = p -> p.getPrice() > 100;

        return products.stream().anyMatch(expensive);
    }
}

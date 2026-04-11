package BaiTapSS16.Gioi02;

import java.util.List;

public class ProductProcessorImpl implements ProductProcessor {

    @Override
    public double calculateTotalValue(List<Product> products) {
        double total = 0;

        // dùng for-each (đúng yêu cầu đề)
        for (Product p : products) {
            total += p.getPrice();
        }

        return total;
    }

    // (nâng cao) dùng Stream
    public double calculateTotalValueStream(List<Product> products) {
        return products.stream()
                .mapToDouble(Product::getPrice)
                .sum();
    }
}
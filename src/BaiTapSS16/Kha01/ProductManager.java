package BaiTapSS16.Kha01;

import java.util.*;

public class ProductManager {

    private Map<Integer, Product> productMap = new HashMap<>();
    private Scanner sc = new Scanner(System.in);

    // 1. Thêm
    public void addProduct() {
        System.out.print("Nhập ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        if (productMap.containsKey(id)) {
            System.out.println("ID đã tồn tại!");
            return;
        }

        System.out.print("Nhập tên: ");
        String name = sc.nextLine();

        System.out.print("Nhập giá: ");
        double price = sc.nextDouble();

        productMap.put(id, new Product(name, id, price));
    }

    // 2. Sửa
    public void updateProduct() {
        System.out.print("Nhập ID cần sửa: ");
        int id = sc.nextInt();
        sc.nextLine();

        Product p = productMap.get(id);

        if (p != null) {
            System.out.print("Tên mới: ");
            p.setName(sc.nextLine());

            System.out.print("Giá mới: ");
            p.setPrice(sc.nextDouble());
        } else {
            System.out.println("Không tìm thấy!");
        }
    }

    // 3. Xóa
    public void deleteProduct() {
        System.out.print("Nhập ID cần xóa: ");
        int id = sc.nextInt();

        if (productMap.remove(id) != null) {
            System.out.println("Đã xóa!");
        } else {
            System.out.println("Không tồn tại!");
        }
    }

    // 4. Hiển thị
    public void showProducts() {
        if (productMap.isEmpty()) {
            System.out.println("Danh sách trống!");
            return;
        }
        productMap.values().forEach(System.out::println);
    }

    // 5. Lọc
    public void filterProducts() {
        productMap.values().stream()
                .filter(p -> p.getPrice() > 100)
                .forEach(System.out::println);
    }

    // 6. Tổng tiền
    public void totalPrice() {
        double total = productMap.values().stream()
                .mapToDouble(Product::getPrice)
                .sum();

        System.out.println("Tổng tiền: " + total);
    }
}
package BaiTapSS15.BaiTap03;

import java.util.*;

public class StoreManagement {
    private static List<Product> inventory = new ArrayList<>();
    private static Map<String, Order> orderMap = new HashMap<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n========= HỆ THỐNG CỬA HÀNG =========");
            System.out.println("1. Thêm sản phẩm vào kho");
            System.out.println("2. Hiển thị kho hàng");
            System.out.println("3. Xóa sản phẩm khỏi kho");
            System.out.println("4. Tạo đơn hàng mới");
            System.out.println("5. Xem chi tiết đơn hàng");
            System.out.println("6. Thoát");
            System.out.print("Lựa chọn: ");

            try {
                int choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1: addProductToInventory(); break;
                    case 2: displayInventory(); break;
                    case 3: deleteProduct(); break;
                    case 4: createOrder(); break;
                    case 5: viewOrder(); break;
                    case 6: return;
                }
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Vui lòng nhập số!");
            } catch (Exception e) {
                System.out.println("Lỗi phát sinh: " + e.getMessage());
            }
        }
    }

    private static void addProductToInventory() throws InvalidPriceException {
        System.out.print("Nhập ID: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.print("Nhập tên: ");
        String name = sc.nextLine();
        System.out.print("Nhập giá: ");
        double price = Double.parseDouble(sc.nextLine());
        inventory.add(new Product(id, name, price));
        System.out.println("Thêm thành công!");
    }

    private static void displayInventory() {
        if (inventory.isEmpty()) System.out.println("Kho hàng trống!");
        else inventory.forEach(System.out::println);
    }

    private static void deleteProduct() {
        System.out.print("Nhập ID sản phẩm cần xóa: ");
        int id = Integer.parseInt(sc.nextLine());
        boolean removed = inventory.removeIf(p -> p.getId() == id);
        if (!removed) throw new ResourceNotFoundException("Không tìm thấy sản phẩm ID " + id + " để xóa!");
        System.out.println("Đã xóa sản phẩm.");
    }

    private static void createOrder() {
        System.out.print("Nhập mã định danh đơn hàng (VD: ORDER01): ");
        String code = sc.nextLine();
        Order newOrder = new Order(new Random().nextInt(1000));

        while (true) {
            displayInventory();
            System.out.print("Nhập ID sản phẩm muốn thêm vào đơn (0 để hoàn tất): ");
            int id = Integer.parseInt(sc.nextLine());
            if (id == 0) break;

            Product p = inventory.stream()
                    .filter(item -> item.getId() == id)
                    .findFirst()
                    .orElseThrow(() -> new ResourceNotFoundException("Sản phẩm không tồn tại!"));

            newOrder.addProduct(p);
            System.out.println("Đã thêm " + p.getName());
        }
        orderMap.put(code, newOrder);
        System.out.println("Đơn hàng " + code + " đã được lưu.");
    }

    private static void viewOrder() {
        System.out.print("Nhập mã đơn hàng cần xem: ");
        String code = sc.nextLine();
        Order order = orderMap.get(code);
        if (order == null) throw new ResourceNotFoundException("Đơn hàng " + code + " không tồn tại!");
        order.showOrderDetails();
    }
}
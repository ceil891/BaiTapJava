package BaiTapSS13.Gioi02;

import java.util.ArrayList;

public class OrderManager implements Manage<Order> {
    private ArrayList<Order> orderList = new ArrayList<>();

    @Override
    public void add(Order item) {
        orderList.add(item);
        System.out.println("Đơn hàng đã được thêm thành công.");
    }

    // Ở đây chúng ta cập nhật dựa trên mã đơn hàng (Order Code) để giống mẫu console
    public void updateByCode(String code, Order newItem) {
        for (Order o : orderList) {
            if (o.getOrderCode().equalsIgnoreCase(code)) {
                o.setCustomerName(newItem.getCustomerName());
                System.out.println("Đơn hàng đã được sửa thành công.");
                return;
            }
        }
        System.out.println("Không tìm thấy mã đơn hàng cần sửa.");
    }

    // Xóa dựa trên mã đơn hàng
    public void deleteByCode(String code) {
        boolean removed = orderList.removeIf(o -> o.getOrderCode().equalsIgnoreCase(code));
        if (removed) {
            System.out.println("Đơn hàng đã được xóa thành công.");
        } else {
            System.out.println("Không tìm thấy mã đơn hàng để xóa.");
        }
    }

    @Override
    public void display() {
        if (orderList.isEmpty()) {
            System.out.println("Danh sách đơn hàng trống.");
        } else {
            for (int i = 0; i < orderList.size(); i++) {
                System.out.println((i + 1) + ". " + orderList.get(i).toString());
            }
        }
    }

    // Các phương thức interface bắt buộc phải override (có thể để trống nếu dùng phương thức theo Code)
    @Override public void update(int index, Order item) {}
    @Override public void delete(int index) {}
}
package BaiTapSS13.Gioi01;

import java.util.ArrayList;

public class InvoiceManager implements Manage<Invoice> {
    private ArrayList<Invoice> list = new ArrayList<>();

    @Override
    public void add(Invoice item) {
        list.add(item);
        System.out.println("Hóa đơn đã được thêm thành công.");
    }

    @Override
    public void update(int id, Invoice newItem) {
        for (Invoice inv : list) {
            if (inv.getId() == id) {
                inv.setCode(newItem.getCode());
                inv.setAmount(newItem.getAmount());
                System.out.println("Hóa đơn đã được sửa thành công.");
                return;
            }
        }
        System.out.println("Không tìm thấy hóa đơn nào có id = " + id);
    }

    @Override
    public void delete(int id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                list.remove(i);
                System.out.println("Hóa đơn đã được xóa thành công.");
                return;
            }
        }
        System.out.println("Không tìm thấy hóa đơn nào có id = " + id);
    }

    @Override
    public void display() {
        if (list.isEmpty()) {
            System.out.println("Danh sách hóa đơn trống.");
        } else {
            for (Invoice inv : list) {
                System.out.println(inv.toString());
            }
        }
    }
}

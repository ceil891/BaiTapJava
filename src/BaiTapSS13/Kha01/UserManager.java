package BaiTapSS13.Kha01;

import java.util.*;

public class UserManager {

    static LinkedList<Person> list = new LinkedList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n===== MENU QUẢN LÝ NGƯỜI DÙNG =====");
            System.out.println("1. Thêm người dùng");
            System.out.println("2. Xóa người dùng");
            System.out.println("3. Hiển thị danh sách");
            System.out.println("4. Thoát");
            System.out.print("Chọn: ");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    addUser();
                    break;
                case 2:
                    deleteUser();
                    break;
                case 3:
                    displayUsers();
                    break;
                case 4:
                    System.out.println("Thoát...");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    // Thêm người dùng
    static void addUser() {
        System.out.print("Nhập tên: ");
        String name = sc.nextLine();

        System.out.print("Nhập email: ");
        String email = sc.nextLine();

        System.out.print("Nhập SĐT: ");
        String phone = sc.nextLine();

        list.add(new Person(name, email, phone));
        System.out.println("Thêm thành công!");
    }

    // Xóa theo email (dùng Iterator cho đúng chuẩn)
    static void deleteUser() {
        System.out.print("Nhập email cần xóa: ");
        String email = sc.nextLine();

        Iterator<Person> it = list.iterator();
        boolean found = false;

        while (it.hasNext()) {
            Person p = it.next();
            if (p.getEmail().equals(email)) {
                it.remove(); // ✔ xóa an toàn
                found = true;
                System.out.println("Đã xóa thành công!");
                break;
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy!");
        }
    }

    // Hiển thị danh sách
    static void displayUsers() {
        if (list.isEmpty()) {
            System.out.println("Danh sách rỗng!");
            return;
        }

        System.out.println("\nDanh sách người dùng:");
        for (Person p : list) {
            System.out.println(p);
        }
    }
}
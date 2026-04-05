package BaiTapSS13.Gioi02;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        OrderManager manager = new OrderManager();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n************** MENU QUẢN LÝ ĐƠN HÀNG **************");
            System.out.println("1. Thêm đơn hàng");
            System.out.println("2. Sửa đơn hàng");
            System.out.println("3. Xóa đơn hàng");
            System.out.println("4. Hiển thị danh sách đơn hàng");
            System.out.println("5. Thoát");
            System.out.print("Lựa chọn của bạn: ");

            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    String code;
                    while (true) {
                        System.out.print("Nhập mã đơn hàng: \n");
                        code = sc.nextLine();
                        if (!code.trim().isEmpty()) break;
                        System.out.println("Vui lòng ko để trống !");
                    }
                    System.out.print("Nhập tên khách hàng: \n");
                    String name = sc.nextLine();
                    manager.add(new Order(code, name));
                    break;

                case 2:
                    manager.display();
                    System.out.print("Nhập mã đơn hàng cần sửa: \n");
                    String editCode = sc.nextLine();
                    System.out.print("Nhập tên khách hàng mới: \n");
                    String newName = sc.nextLine();
                    manager.updateByCode(editCode, new Order(editCode, newName));
                    break;

                case 3:
                    manager.display();
                    System.out.print("Nhập mã đơn hàng cần xóa: \n");
                    String delCode = sc.nextLine();
                    manager.deleteByCode(delCode);
                    break;

                case 4:
                    manager.display();
                    break;

                case 5:
                    System.out.println("Thoát chương trình.");
                    break;
            }
        } while (choice != 5);
        sc.close();
    }
}
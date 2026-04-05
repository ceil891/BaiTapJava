package BaiTapSS13.Gioi01;
import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        InvoiceManager manager = new InvoiceManager();
        int choice;

        do {
            System.out.println("\n************** MENU QUẢN LÝ HÓA ĐƠN **************");
            System.out.println("1. Thêm hóa đơn");
            System.out.println("2. Sửa hóa đơn");
            System.out.println("3. Xóa hóa đơn");
            System.out.println("4. Hiển thị danh sách hóa đơn");
            System.out.println("5. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Nhập mã hóa đơn: ");
                    String code = sc.nextLine();
                    double amount = inputAmount();
                    manager.add(new Invoice(code, amount));
                    break;

                case 2:
                    manager.display();
                    System.out.print("Nhập id hóa đơn cần sửa: ");
                    int idEdit = Integer.parseInt(sc.nextLine());

                    System.out.print("Nhập mã hóa đơn mới: ");
                    String newCode = sc.nextLine();
                    while (newCode.trim().isEmpty()) {
                        System.out.println("Vui lòng không để trống !");
                        System.out.print("Nhập mã hóa đơn mới: ");
                        newCode = sc.nextLine();
                    }

                    double newAmount = inputAmount();
                    manager.update(idEdit, new Invoice(newCode, newAmount));
                    break;

                case 3:
                    manager.display();
                    System.out.print("Nhập id hóa đơn cần xóa: ");
                    int idDel = Integer.parseInt(sc.nextLine());
                    manager.delete(idDel);
                    break;

                case 4:
                    manager.display();
                    break;

                case 5:
                    System.out.println("Tạm biệt!");
                    break;
            }
        } while (choice != 5);
    }

    // Hàm bổ trợ để kiểm tra số tiền dương
    private static double inputAmount() {
        double amount;
        while (true) {
            System.out.print("Nhập số tiền: ");
            amount = Double.parseDouble(sc.nextLine());
            if (amount >= 0) break;
            System.out.println("Vui lòng nhập số thực >= 0 !");
        }
        return amount;
    }
}
package BaiTapSS16.Kha01;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProductManager manager = new ProductManager();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Thêm");
            System.out.println("2. Sửa");
            System.out.println("3. Xóa");
            System.out.println("4. Hiển thị");
            System.out.println("5. Lọc > 100");
            System.out.println("6. Tổng tiền");
            System.out.println("0. Thoát");

            int choice = sc.nextInt();

            switch (choice) {
                case 1: manager.addProduct(); break;
                case 2: manager.updateProduct(); break;
                case 3: manager.deleteProduct(); break;
                case 4: manager.showProducts(); break;
                case 5: manager.filterProducts(); break;
                case 6: manager.totalPrice(); break;
                case 0: return;
                default: System.out.println("Sai!");
            }
        }
    }
}
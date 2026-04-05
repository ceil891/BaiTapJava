package BaiTapSS14.Gioi01;

import java.util.Scanner;
import java.util.InputMismatchException;

public class ATMSystem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Khởi tạo các biến số dư theo yêu cầu
        double balance = 1000000;      // 1.000.000 đồng
        final double MIN_BALANCE = 50000; // 50.000 đồng số dư tối thiểu

        System.out.println("=== CHƯƠNG TRÌNH MÔ PHỎNG ATM ===");
        System.out.println("Số dư hiện tại: " + String.format("%,.0f", balance) + " VNĐ");

        try {
            System.out.print("Nhập số tiền bạn muốn rút: ");
            // Đọc dữ liệu đầu vào
            double withdrawalAmount = sc.nextDouble();

            // 1. Kiểm tra số tiền rút có hợp lệ (phải là số dương)
            if (withdrawalAmount <= 0) {
                System.out.println("Lỗi: Số tiền rút phải lớn hơn 0!");
            }
            // 2. Kiểm tra nếu số tiền rút lớn hơn số dư hiện có
            else if (withdrawalAmount > balance) {
                System.out.println("Lỗi: Số tiền rút vượt quá số dư!");
            }
            // 3. Kiểm tra điều kiện số dư tối thiểu (balance - withdrawal < 50.000)
            else if ((balance - withdrawalAmount) < MIN_BALANCE) {
                System.out.println("Lỗi: Tài khoản phải duy trì số dư tối thiểu 50.000 VNĐ!");
            }
            // 4. Giao dịch thành công
            else {
                balance -= withdrawalAmount;
                System.out.println("\n--- GIAO DỊCH THÀNH CÔNG ---");
                System.out.println("Số tiền đã rút: " + String.format("%,.0f", withdrawalAmount) + " VNĐ");
                System.out.println("Số dư còn lại: " + String.format("%,.0f", balance) + " VNĐ");
            }

        } catch (InputMismatchException e) {
            // Xử lý khi người dùng nhập chữ hoặc ký tự đặc biệt
            System.out.println("Lỗi: Vui lòng nhập một số hợp lệ!");
        } finally {
            sc.close();
            System.out.println("Cảm ơn bạn đã sử dụng dịch vụ!");
        }
    }
}
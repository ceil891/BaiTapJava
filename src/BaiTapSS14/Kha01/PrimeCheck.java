package BaiTapSS14.Kha01;

import java.util.Scanner;
import java.util.InputMismatchException;

public class PrimeCheck {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Nhập một số nguyên dương để kiểm tra: ");
            // Đọc dữ liệu đầu vào
            int number = sc.nextInt();

            // 1. Kiểm tra số không hợp lệ (<= 0)
            if (number <= 0) {
                System.out.println("Lỗi: Số nhập vào phải lớn hơn 0 để kiểm tra số nguyên tố.");
            } else {
                // 2. Tiến hành kiểm tra số nguyên tố
                if (isPrime(number)) {
                    System.out.println(number + " là số nguyên tố.");
                } else {
                    System.out.println(number + " không phải là số nguyên tố.");
                }
            }

        } catch (InputMismatchException e) {
            // 3. Xử lý ngoại lệ khi nhập chữ, ký tự đặc biệt hoặc số thực
            System.out.println("Lỗi: Dữ liệu nhập vào không phải là số nguyên hợp lệ!");
        } finally {
            sc.close(); // Đóng tài nguyên Scanner
        }
    }

    /**
     * Hàm kiểm tra số nguyên tố
     * Số nguyên tố là số lớn hơn 1 và chỉ chia hết cho 1 và chính nó.
     */
    public static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        // Kiểm tra từ 2 đến căn bậc hai của n để tối ưu hóa hiệu suất
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false; // Chia hết cho số khác ngoài 1 và n
            }
        }
        return true;
    }
}
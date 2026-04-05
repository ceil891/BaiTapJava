package BaiTapSS14.Kha02;

import java.util.ArrayList;
import java.util.Scanner;

public class StringToIntConverter {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Danh sách lưu trữ các số nguyên chuyển đổi thành công
        ArrayList<Integer> validNumbers = new ArrayList<>();

        // Biến đếm số lượng chuỗi không hợp lệ
        int invalidCount = 0;

        System.out.println("--- CHƯƠNG TRÌNH CHUYỂN ĐỔI CHUỖI THÀNH SỐ ---");
        System.out.println("Nhập các chuỗi (Nhập 'exit' để kết thúc và xem kết quả):");

        while (true) {
            System.out.print("Nhập giá trị: ");
            String input = sc.nextLine();

            // Kiểm tra điều kiện thoát
            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            try {
                // Thực hiện chuyển đổi chuỗi sang số nguyên
                int number = Integer.parseInt(input);

                // Nếu thành công (không nhảy vào catch), lưu vào danh sách
                validNumbers.add(number);

            } catch (NumberFormatException e) {
                // Nếu xảy ra lỗi định dạng số (ví dụ: nhập "abc", "1.5", "10a")
                invalidCount++;
                System.out.println("  -> Lỗi: '" + input + "' không phải là số nguyên hợp lệ.");
            }
        }

        // --- Thống kê và hiển thị kết quả ---
        System.out.println("\n-------------------------------------------");
        System.out.println("KẾT QUẢ THỐNG KÊ:");
        System.out.println("1. Số lượng chuỗi hợp lệ: " + validNumbers.size());
        System.out.println("2. Số lượng chuỗi không hợp lệ: " + invalidCount);

        System.out.print("3. Danh sách các số nguyên hợp lệ: ");
        if (validNumbers.isEmpty()) {
            System.out.println("(Trống)");
        } else {
            System.out.println(validNumbers);
        }
        System.out.println("-------------------------------------------");

        sc.close();
    }
}
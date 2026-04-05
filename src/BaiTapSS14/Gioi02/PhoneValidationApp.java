package BaiTapSS14.Gioi02;

import java.util.ArrayList;
import java.util.Scanner;

public class PhoneValidationApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<String> validList = new ArrayList<>();
        ArrayList<String> invalidList = new ArrayList<>();

        System.out.println("--- CHƯƠNG TRÌNH KIỂM TRA SỐ ĐIỆN THOẠI ---");
        System.out.println("Nhập các số điện thoại (ngăn cách bởi dấu phẩy):");
        String input = sc.nextLine();

        // Tách chuỗi bằng dấu phẩy
        String[] phoneNumbers = input.split(",");

        for (String phone : phoneNumbers) {
            String trimmedPhone = phone.trim(); // Loại bỏ khoảng trắng thừa ở hai đầu nếu có

            try {
                // Gọi phương thức kiểm tra trong Custom Exception
                InvalidPhoneNumberException.validate(trimmedPhone);

                // Nếu không có ngoại lệ ném ra -> Hợp lệ
                validList.add(trimmedPhone);

            } catch (InvalidPhoneNumberException e) {
                // Nếu có ngoại lệ -> Không hợp lệ, lưu kèm lý do
                invalidList.add(trimmedPhone + " -> Lý do: " + e.getMessage());
            }
        }

        // --- HIỂN THỊ KẾT QUẢ ---
        System.out.println("\n================ KẾT QUẢ ================");

        System.out.println("SUCCESS - DANH SÁCH HỢP LỆ:");
        if (validList.isEmpty()) System.out.println("(Trống)");
        else validList.forEach(p -> System.out.println(" + " + p));

        System.out.println("\nFAILED - DANH SÁCH KHÔNG HỢP LỆ:");
        if (invalidList.isEmpty()) System.out.println("(Trống)");
        else invalidList.forEach(p -> System.out.println(" x " + p));

        System.out.println("==========================================");
        sc.close();
    }
}
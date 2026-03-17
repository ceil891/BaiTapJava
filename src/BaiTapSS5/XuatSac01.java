package BaiTapSS5;

import java.util.Scanner;

public class XuatSac01 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = "";
        int choice;

        while (true) {
            System.out.println("\n************* MENU *************");
            System.out.println("1. Nhập chuỗi");
            System.out.println("2. Đếm số ký tự thường, hoa, số, đặc biệt");
            System.out.println("3. Đảo ngược chuỗi");
            System.out.println("4. Kiểm tra Palindrome");
            System.out.println("5. Chuẩn hóa chuỗi");
            System.out.println("6. Thoát");
            System.out.print("Lựa chọn của bạn: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Nhập chuỗi: ");
                    str = sc.nextLine();
                    break;

                case 2:
                    int thuong = 0, hoa = 0, so = 0, dacbiet = 0;

                    for (int i = 0; i < str.length(); i++) {
                        char c = str.charAt(i);

                        if (c >= 'a' && c <= 'z') {
                            thuong++;
                        } else if (c >= 'A' && c <= 'Z') {
                            hoa++;
                        } else if (c >= '0' && c <= '9') {
                            so++;
                        } else {
                            dacbiet++;
                        }
                    }

                    System.out.println("Chữ thường: " + thuong);
                    System.out.println("Chữ hoa: " + hoa);
                    System.out.println("Chữ số: " + so);
                    System.out.println("Ký tự đặc biệt: " + dacbiet);
                    break;

                case 3:
                    String reversed = new StringBuilder(str).reverse().toString();
                    System.out.println("Chuỗi đảo ngược: " + reversed);
                    break;

                case 4:
                    String rev = new StringBuilder(str).reverse().toString();

                    if (str.equals(rev)) {
                        System.out.println("Chuỗi là Palindrome");
                    } else {
                        System.out.println("Chuỗi không phải Palindrome");
                    }
                    break;

                case 5:
                    str = str.trim().replaceAll("\\s+", " ");
                    String[] words = str.split(" ");
                    String result = "";

                    for (String w : words) {
                        result += Character.toUpperCase(w.charAt(0)) + w.substring(1) + " ";
                    }

                    System.out.println("Chuỗi sau khi chuẩn hóa: " + result.trim());
                    break;

                case 6:
                    System.out.println("Thoát chương trình.");
                    return;

                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }
}
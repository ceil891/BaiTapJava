package BaiTapSS2;

import java.util.Scanner;

public class Gioi02 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int a, b, c;

        System.out.print("Nhập cạnh a: ");
        a = input.nextInt();

        System.out.print("Nhập cạnh b: ");
        b = input.nextInt();

        System.out.print("Nhập cạnh c: ");
        c = input.nextInt();

        // Kiểm tra tam giác hợp lệ
        if (a + b <= c || a + c <= b || b + c <= a) {
            System.out.println("Ba cạnh không tạo thành tam giác");
        }
        else {

            // Tam giác đều
            if (a == b && b == c) {
                System.out.println("Đây là tam giác đều");
            }

            // Tam giác cân
            else if (a == b || a == c || b == c) {
                System.out.println("Đây là tam giác cân");
            }

            // Tam giác vuông
            else if (a*a + b*b == c*c ||
                    a*a + c*c == b*b ||
                    b*b + c*c == a*a) {
                System.out.println("Đây là tam giác vuông");
            }

            // Tam giác thường
            else {
                System.out.println("Đây là tam giác thường");
            }
        }
    }
}
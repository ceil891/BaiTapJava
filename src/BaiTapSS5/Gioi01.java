package BaiTapSS5;

import java.util.Scanner;

public class Gioi01 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập mật khẩu: ");
        String matkhau = sc.nextLine();

        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=]).{8,}$";

        if (matkhau.matches(regex)) {
            System.out.println("Mật khẩu hợp lệ");
        } else {
            System.out.println("Mật khẩu không hợp lệ");
        }
    }
}
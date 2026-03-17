package BaiTapSS5;

import java.util.Random;
import java.util.Scanner;

public class Gioi02 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập n: ");
        int n = sc.nextInt();

        if (n < 1 || n > 1000) {
            System.out.println("Giá trị n không hợp lệ");
            return;
        }

        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        Random random = new Random();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int index = random.nextInt(chars.length());
            result.append(chars.charAt(index));
        }

        System.out.println("Chuỗi ngẫu nhiên: " + result.toString());
    }
}
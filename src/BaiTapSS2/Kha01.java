package BaiTapSS2;

import java.util.Scanner;

public class Kha01 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int n;
        int sum = 0;

        System.out.print("Nhập n: ");
        n = input.nextInt();

        if (n <= 0) {
            System.out.println("Số nhập vào không hợp lệ");
        } else {

            for (int i = 1; i <= n; i++) {
                sum = sum + i;
            }

            System.out.println("Tổng từ 1 đến " + n + " là: " + sum);
        }
    }
}
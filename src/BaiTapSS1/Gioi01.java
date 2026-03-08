package BaiTapSS1;

import java.util.Scanner;

public class Gioi01 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int a, b, c, d;

        System.out.print("Nhập số a: ");
        a = input.nextInt();

        System.out.print("Nhập số b: ");
        b = input.nextInt();

        System.out.print("Nhập số c: ");
        c = input.nextInt();

        System.out.print("Nhập số d: ");
        d = input.nextInt();

        int tu = a * d + b * c;
        int mau = b * d;

        System.out.println("Tổng hai phân số: " + tu + "/" + mau);
    }
}
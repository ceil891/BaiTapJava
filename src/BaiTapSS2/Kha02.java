package BaiTapSS2;

import java.util.Scanner;

public class Kha02 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int n;

        System.out.print("Nhập tháng: ");
        n = input.nextInt();

        switch (n) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                System.out.println("Tháng " + n + " có 31 ngày");
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                System.out.println("Tháng " + n + " có 30 ngày");
                break;
            case 2:
                System.out.println("Tháng 2 có 28 hoặc 29 ngày");
                break;
            default:
                System.out.println("Tháng không hợp lệ");
        }
    }
}
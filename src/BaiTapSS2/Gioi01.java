package BaiTapSS2;
import java.util.Scanner;


public class Gioi01 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int N;
        int sum = 0;

        System.out.print("Nhập số nguyên N: ");
        N = input.nextInt();


        if (N < 0) {
            N = -N;
        }


        while (N > 0) {

            int digit = N % 10;
            sum = sum + digit;

            N = N / 10;
        }


        System.out.println("Tổng các chữ số là: " + sum);
    }
}
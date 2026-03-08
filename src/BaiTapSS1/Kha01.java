package BaiTapSS1;

import java.util.Scanner;

public class Kha01 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
       double radius;
        System.out.print("Nhập radius: ");
         radius = input.nextDouble();

        double area = Math.PI * Math.pow(radius, 2);
        System.out.printf("Diện tích :%2f", area);

    }
}

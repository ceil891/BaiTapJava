package BaiTapSS1;

import java.util.Scanner;

public class Gioi02 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double width = 0 ;
        double height = 0 ;
       double area = width * height;
        double perimeter = 2 * (width + height);
        System.out.print("Nhập số Chiều dài :");
        width = input.nextDouble();
        System.out.print("Nhập số Chiều rộng :");
        height = input.nextDouble();

        System.out.println("Diện tích hình chữ nhật: " + area);
        System.out.println("Chu vi hình chữ nhật: " + perimeter);

    }
}

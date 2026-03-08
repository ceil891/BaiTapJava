package BaiTapSS1;

import java.util.Scanner;

public class Kha02 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int firstNumber = 0;
        int secondNumber = 0;
        System.out.print("Nhập số firstNumber :" );
        firstNumber = input.nextInt();
        System.out.print("Nhập số lastNumber : " );
        secondNumber = input.nextInt();
        int  tong = firstNumber + secondNumber;
        int  hieu = firstNumber - secondNumber;
        int  tich = firstNumber * secondNumber;
        float  thuong = (float) (firstNumber/secondNumber);
        float  laydu = firstNumber % secondNumber;


        System.out.println( "Số thứ nhất :" + firstNumber);
        System.out.println("Số thứ hai : "+ secondNumber);
        System.out.println("Tổng :" + tong );
        System.out.println("Hiệu :" + hieu );
        System.out.println("Tích :"+ tich);
        System.out.println("Lấy dư:"+ laydu);

    }
}

package BaiTapSS4;

import java.util.Scanner;

public class   Kha01 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Nhập kích thước mảng
        System.out.print("Nhập kích thước mảng: ");
        int n = input.nextInt();

        int[] arr = new int[n];

        // Nhập các phần tử
        for (int i = 0; i < n; i++) {
            System.out.print("Nhập phần tử thứ " + (i + 1) + ": ");
            arr[i] = input.nextInt();
        }

        // Sắp xếp nổi bọt giảm dần
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] < arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        // In mảng sau khi sắp xếp
        System.out.println("Mảng sau khi sắp xếp giảm dần:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
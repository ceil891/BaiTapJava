package BaiTapSS4;

import java.util.Scanner;

public class Kha02 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int rows;
        int cols;

        System.out.print("Nhập số hàng của mảng : ");
        rows = sc.nextInt();

        System.out.print("Nhập số cột của mảng: ");
        cols = sc.nextInt();

        int[][] arr = new int[rows][cols];

        // Nhập mảng
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("Nhập phần tử [" + i + "][" + j + "]: ");
                arr[i][j] = sc.nextInt();
            }
        }

        int tongChan = 0;
        int tongLe = 0;

        // Duyệt mảng để tính tổng
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (arr[i][j] % 2 == 0) {
                    tongChan += arr[i][j];
                } else {
                    tongLe += arr[i][j];
                }
            }
        }

        System.out.println("Tổng chẵn: " + tongChan);
        System.out.println("Tổng lẻ: " + tongLe);
    }
}
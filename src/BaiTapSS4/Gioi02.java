package BaiTapSS4;



import java.util.Scanner;

public class Gioi02 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập số phần tử của mảng: ");
        int n = sc.nextInt();

        if (n == 0) {
            System.out.println("Mảng không có phần tử");
            return;
        }

        int[] arr = new int[n];

        // Nhập mảng
        for (int i = 0; i < n; i++) {
            System.out.print("Nhập phần tử thứ " + (i + 1) + ": ");
            arr[i] = sc.nextInt();
        }

        int[] result = new int[n];
        int index = 0;

        // Lấy số chẵn trước
        for (int i = 0; i < n; i++) {
            if (arr[i] % 2 == 0) {
                result[index] = arr[i];
                index++;
            }
        }

        // Lấy số lẻ sau
        for (int i = 0; i < n; i++) {
            if (arr[i] % 2 != 0) {
                result[index] = arr[i];
                index++;
            }
        }

        // In mảng sau khi sắp xếp
        System.out.println("Mảng sau khi sắp xếp:");
        for (int i = 0; i < n; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
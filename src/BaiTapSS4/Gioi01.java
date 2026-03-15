package BaiTapSS4;

import java.util.Scanner;

public class Gioi01 {
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

        // Selection Sort giảm dần
        for (int i = 0; i < n - 1; i++) {
            int maxIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[maxIndex]) {
                    maxIndex = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[maxIndex];
            arr[maxIndex] = temp;
        }

        // In mảng sau khi sắp xếp
        System.out.println("Mảng sau khi sắp xếp:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

        // Nhập số cần tìm
        System.out.print("\nNhập số cần tìm: ");
        int x = input.nextInt();

        // Linear Search
        boolean found = false;
        int posLinear = -1;

        for (int i = 0; i < n; i++) {
            if (arr[i] == x) {
                found = true;
                posLinear = i;
                break;
            }
        }

        if (found) {
            System.out.println("Tìm tuyến tính: thấy tại vị trí " + posLinear);
        } else {
            System.out.println("Tìm tuyến tính: Không tìm thấy");
        }

        // Binary Search (mảng giảm dần)
        int left = 0;
        int right = n - 1;
        int posBinary = -1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == x) {
                posBinary = mid;
                break;
            }

            if (x > arr[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        if (posBinary != -1) {
            System.out.println("Tìm nhị phân: thấy tại vị trí " + posBinary);
        } else {
            System.out.println("Tìm nhị phân: Không tìm thấy");
        }
    }
}
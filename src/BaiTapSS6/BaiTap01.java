package BaiTapSS6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BaiTap01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Double> dsDiem = new ArrayList<>();

        while (true) {
            System.out.println("\n===== QUAN LY DIEM =====");
            System.out.println("1. Nhap diem");
            System.out.println("2. Xuat diem");
            System.out.println("3. Trung binh");
            System.out.println("4. Max/Min");
            System.out.println("5. Dau/Truot");
            System.out.println("6. Sap xep");
            System.out.println("7. Gioi");
            System.out.println("8. Thoat");

            System.out.print("Chon: ");
            int chon = Integer.parseInt(sc.nextLine());

            switch (chon) {
                case 1:
                    while (true) {
                        System.out.print("Nhap diem (q de dung): ");
                        String s = sc.nextLine();
                        if (s.equalsIgnoreCase("q")) break;

                        try {
                            double diem = Double.parseDouble(s);
                            if (diem < 0 || diem > 10) {
                                System.out.println("Diem khong hop le!");
                            } else {
                                dsDiem.add(diem);
                            }
                        } catch (Exception e) {
                            System.out.println("Nhap sai!");
                        }
                    }
                    break;

                case 2:
                    if (dsDiem.isEmpty()) {
                        System.out.println("Danh sach rong!");
                        break;
                    }
                    for (double d : dsDiem) {
                        System.out.println(d);
                    }
                    break;

                case 3:
                    if (dsDiem.isEmpty()) {
                        System.out.println("Danh sach rong!");
                        break;
                    }
                    double sum = 0;
                    for (double d : dsDiem) sum += d;
                    System.out.println("Trung binh: " + (sum / dsDiem.size()));
                    break;

                case 4:
                    if (dsDiem.isEmpty()) {
                        System.out.println("Danh sach rong!");
                        break;
                    }
                    double max = Collections.max(dsDiem);
                    double min = Collections.min(dsDiem);
                    System.out.println("Max: " + max);
                    System.out.println("Min: " + min);
                    break;

                case 5:
                    if (dsDiem.isEmpty()) {
                        System.out.println("Danh sach rong!");
                        break;
                    }
                    int dau = 0, truot = 0;
                    for (double d : dsDiem) {
                        if (d >= 5) dau++;
                        else truot++;
                    }
                    System.out.println("Dau: " + dau);
                    System.out.println("Truot: " + truot);
                    break;

                case 6:
                    if (dsDiem.isEmpty()) {
                        System.out.println("Danh sach rong!");
                        break;
                    }
                    Collections.sort(dsDiem);
                    System.out.println("Da sap xep!");
                    break;

                case 7:
                    if (dsDiem.isEmpty()) {
                        System.out.println("Danh sach rong!");
                        break;
                    }
                    int gioi = 0;
                    for (double d : dsDiem) {
                        if (d >= 8) gioi++;
                    }
                    System.out.println("So SV gioi/xuat sac: " + gioi);
                    break;

                case 8:
                    System.out.println("Thoat!");
                    return;

                default:
                    System.out.println("Chon sai!");
            }
        }
    }
}
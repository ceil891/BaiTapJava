package BaiTapSS6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BaiTap03 {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<String> list = new ArrayList<>();

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n===== QUAN LY BIEN SO XE =====");
            System.out.println("1. Them bien so");
            System.out.println("2. Hien thi danh sach");
            System.out.println("3. Tim bien so");
            System.out.println("4. Tim theo ma tinh");
            System.out.println("5. Sap xep tang dan");
            System.out.println("6. Thoat");

            System.out.print("Chon: ");
            int chon = Integer.parseInt(sc.nextLine());

            switch (chon) {
                case 1:
                    themBienSo();
                    break;
                case 2:
                    hienThi();
                    break;
                case 3:
                    timBienSo();
                    break;
                case 4:
                    timTheoMaTinh();
                    break;
                case 5:
                    sapXep();
                    break;
                case 6:
                    System.out.println("Thoat!");
                    return;
                default:
                    System.out.println("Chon sai!");
            }
        }
    }



    // 1. Thêm biển số
    static void themBienSo() {
        System.out.print("Nhap bien so (vd: 30F-123.45): ");
        String bienSo = sc.nextLine();

        // Regex kiểm tra định dạng
        String regex = "^\\d{2}[A-Z]-\\d{3}\\.\\d{2}$";

        if (bienSo.matches(regex)) {
            list.add(bienSo);
            System.out.println("Da them!");
        } else {
            System.out.println("Sai dinh dang!");
        }
    }

    // 2. Hiển thị
    static void hienThi() {
        if (list.isEmpty()) {
            System.out.println("Danh sach rong!");
            return;
        }

        for (String bs : list) {
            System.out.println(bs);
        }
    }

    // 3. Tìm chính xác
    static void timBienSo() {
        if (list.isEmpty()) {
            System.out.println("Danh sach rong!");
            return;
        }

        System.out.print("Nhap bien so can tim: ");
        String x = sc.nextLine();

        boolean found = false;
        for (String bs : list) {
            if (bs.equalsIgnoreCase(x)) {
                System.out.println("Tim thay: " + bs);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Khong tim thay!");
        }
    }

    // 4. Tìm theo mã tỉnh
    static void timTheoMaTinh() {
        if (list.isEmpty()) {
            System.out.println("Danh sach rong!");
            return;
        }

        System.out.print("Nhap ma tinh (vd: 30): ");
        String ma = sc.nextLine();

        boolean found = false;
        for (String bs : list) {
            if (bs.startsWith(ma)) {
                System.out.println(bs);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Khong co bien so nao!");
        }
    }

    // 5. Sắp xếp
    static void sapXep() {
        if (list.isEmpty()) {
            System.out.println("Danh sach rong!");
            return;
        }

        Collections.sort(list);
        System.out.println("Da sap xep!");
    }
}
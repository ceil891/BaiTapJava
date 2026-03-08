package BaiTapSS3;

import java.util.Scanner;

public class LuyenTap03 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int soNhanVien = 0;
        double tongLuong = 0;
        double luongMax = -1;
        double luongMin = 500000000;
        double tongThuong = 0;

        while (true) {

            System.out.println("\n===== MENU =====");
            System.out.println("1. Nhập lương nhân viên");
            System.out.println("2. Hiển thị thống kê");
            System.out.println("3. Tính tổng tiền thưởng");
            System.out.println("4. Thoát chương trình");
            System.out.print("Chọn chức năng: ");

            int chon = input.nextInt();

            switch (chon) {

                case 1:
                    while (true) {

                        System.out.print("Nhập lương (-1 để kết thúc): ");
                        double luong = input.nextDouble();

                        if (luong == -1) {
                            break;
                        }

                        if (luong < 0 || luong > 500000000) {
                            System.out.println("Lương không hợp lệ!");
                            continue;
                        }

                        soNhanVien++;
                        tongLuong += luong;

                        if (luong > luongMax) {
                            luongMax = luong;
                        }

                        if (luong < luongMin) {
                            luongMin = luong;
                        }

                        double thuong = 0;

                        if (luong < 5000000) {
                            System.out.println("Thu nhập thấp");
                            thuong = luong * 0.05;
                        } else if (luong <= 15000000) {
                            System.out.println("Thu nhập trung bình");
                            thuong = luong * 0.10;
                        } else if (luong <= 50000000) {
                            System.out.println("Thu nhập khá");
                            thuong = luong * 0.15;
                        } else if (luong <= 100000000) {
                            System.out.println("Thu nhập cao");
                            thuong = luong * 0.20;
                        } else {
                            System.out.println("Thu nhập cao");
                            thuong = luong * 0.25;
                        }

                        tongThuong += thuong;
                    }
                    break;

                case 2:

                    if (soNhanVien == 0) {
                        System.out.println("Chưa có dữ liệu");
                    } else {

                        double luongTB = tongLuong / soNhanVien;

                        System.out.println("Số nhân viên: " + soNhanVien);
                        System.out.println("Lương trung bình: " + luongTB);
                        System.out.println("Lương cao nhất: " + luongMax);
                        System.out.println("Lương thấp nhất: " + luongMin);
                        System.out.println("Tổng lương: " + tongLuong);
                    }

                    break;

                case 3:

                    if (soNhanVien == 0) {
                        System.out.println("Chưa có dữ liệu");
                    } else {
                        System.out.println("Tổng tiền thưởng cho nhân viên: " + tongThuong);
                    }

                    break;

                case 4:

                    System.out.println("Kết thúc chương trình!");
                    System.exit(0);

                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }
}
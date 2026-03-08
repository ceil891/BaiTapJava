package BaiTapSS3;
import java.util.Scanner;

public class LuyenTap02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int soHocVien = 0;
        double tongDiem = 0;
        double diemMax = -1;
        double diemMin = 11;

        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Nhập điểm học viên");
            System.out.println("2. Hiển thị thống kê");
            System.out.println("3. Thoát chương trình");
            System.out.print("Chọn chức năng: ");
            int chon = sc.nextInt();

            switch (chon) {

                case 1:
                    while (true) {
                        System.out.print("Nhập điểm (-1 để kết thúc): ");
                        double diem = sc.nextDouble();

                        if (diem == -1) {
                            break;
                        }

                        if (diem < 0 || diem > 10) {
                            System.out.println("Điểm không hợp lệ! Nhập lại.");
                            continue;
                        }

                        soHocVien++;
                        tongDiem += diem;

                        if (diem > diemMax) {
                            diemMax = diem;
                        }

                        if (diem < diemMin) {
                            diemMin = diem;
                        }

                        System.out.print("Xếp loại: ");

                        if (diem < 5) {
                            System.out.println("Yếu");
                        } else if (diem < 7) {
                            System.out.println("Trung Bình");
                        } else if (diem < 8) {
                            System.out.println("Khá");
                        } else if (diem < 9) {
                            System.out.println("Giỏi");
                        } else {
                            System.out.println("Xuất sắc");
                        }
                    }
                    break;

                case 2:
                    if (soHocVien == 0) {
                        System.out.println("Chưa có dữ liệu");
                    } else {
                        double diemTB = tongDiem / soHocVien;

                        System.out.println("Số học viên: " + soHocVien);
                        System.out.println("Điểm trung bình: " + diemTB);
                        System.out.println("Điểm cao nhất: " + diemMax);
                        System.out.println("Điểm thấp nhất: " + diemMin);
                    }
                    break;

                case 3:
                    System.out.println("Kết thúc chương trình");
                    System.exit(0);

                default:
                    System.out.println("Chọn sai chức năng!");
            }
        }
    }
}
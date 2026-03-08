package BaiTapSS3;

import java.util.Scanner;

public class LuyenTap01 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String tenkhach;
        String sanpham;
        double gia;
        int soluong;
        boolean thanhvien;
        double thanhtien;
        double giamgia;
        double vat;
        double tongtien;

        System.out.print("Nhập tên khách hàng: ");
        tenkhach = input.nextLine();

        System.out.print("Nhập tên sản phẩm: ");
        sanpham = input.nextLine();

        System.out.print("Nhập giá sản phẩm: ");
        gia = input.nextDouble();

        System.out.print("Nhập số lượng mua: ");
        soluong = input.nextInt();

        System.out.print("Khách có thẻ thành viên (true/false): ");
        thanhvien = input.nextBoolean();

        thanhtien = gia * soluong;

        if (thanhvien == true ) {
            giamgia = thanhtien * 0.10;
        } else {
            giamgia = 0;
        }

        vat = thanhtien * 0.08;

        tongtien = thanhtien - giamgia + vat;

        System.out.println("===== HÓA ĐƠN =====");
        System.out.println("Khách hàng: " + tenkhach);
        System.out.println("Sản phẩm: " + sanpham);
        System.out.println("Số lượng: " + soluong);
        System.out.println("Đơn giá: " + gia + " VND");
        System.out.println("Thành tiền: " + thanhtien + " VND");
        System.out.println("Giảm giá: " + giamgia + " VND");
        System.out.println("Tiền VAT: " + vat + " VND");
        System.out.println("Tổng tiền thanh toán: " + tongtien + " VND");
    }
}
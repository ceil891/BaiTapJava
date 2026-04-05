package BaiTapSS13.Kha02;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AttendanceManager manager = new AttendanceManager();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n**************** MENU QUẢN LÝ ĐIỂM DANH ****************");
            System.out.println("1. Thêm sinh viên");
            System.out.println("2. Sửa sinh viên");
            System.out.println("3. Xóa sinh viên");
            System.out.println("4. Hiển thị danh sách sinh viên");
            System.out.println("5. Thoát");
            System.out.print("Lựa chọn của bạn: ");

            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Nhập id sinh viên : \n");
                    int idAdd = Integer.parseInt(sc.nextLine());
                    System.out.print("Nhập tên sinh viên: \n");
                    String nameAdd = sc.nextLine();
                    manager.add(new Student(idAdd, nameAdd));
                    break;

                case 2:
                    manager.display();
                    System.out.print("Nhập id sinh viên cần sửa: \n");
                    int idUpdate = Integer.parseInt(sc.nextLine());
                    System.out.print("Nhập tên mới sinh viên: \n");
                    String nameUpdate = sc.nextLine();
                    manager.update(idUpdate, new Student(idUpdate, nameUpdate));
                    break;

                case 3:
                    manager.display();
                    System.out.print("Nhập id sinh viên cần xóa: \n");
                    int idDel = Integer.parseInt(sc.nextLine());
                    manager.delete(idDel);
                    break;

                case 4:
                    manager.display();
                    break;

                case 5:
                    System.out.println("Đang thoát chương trình...");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 5);
        sc.close();
    }
}
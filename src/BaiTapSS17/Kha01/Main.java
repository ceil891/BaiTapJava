package BaiTapSS17.Kha01;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MovieManagement mm = new MovieManagement();

        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Thêm phim");
            System.out.println("2. Danh sách phim");
            System.out.println("3. Sửa phim");
            System.out.println("4. Xóa phim");
            System.out.println("0. Thoát");

            System.out.print("Chọn: ");
            int choice;

            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Nhập sai kiểu dữ liệu!");
                continue;
            }

            switch (choice) {
                case 1:
                    try {
                        System.out.print("Tiêu đề: ");
                        String title = sc.nextLine();

                        System.out.print("Đạo diễn: ");
                        String director = sc.nextLine();

                        System.out.print("Năm: ");
                        int year = Integer.parseInt(sc.nextLine());

                        if (title.isEmpty() || director.isEmpty()) {
                            throw new Exception("Không được để trống!");
                        }

                        mm.addMovie(title, director, year);

                    } catch (Exception e) {
                        System.out.println(" Lỗi: " + e.getMessage());
                    }
                    break;

                case 2:
                    mm.listMovies();
                    break;

                case 3:
                    try {
                        System.out.print("ID: ");
                        int id = Integer.parseInt(sc.nextLine());

                        System.out.print("Tiêu đề mới: ");
                        String title = sc.nextLine();

                        System.out.print("Đạo diễn mới: ");
                        String director = sc.nextLine();

                        System.out.print("Năm mới: ");
                        int year = Integer.parseInt(sc.nextLine());

                        mm.updateMovie(id, title, director, year);

                    } catch (Exception e) {
                        System.out.println("Lỗi nhập!");
                    }
                    break;

                case 4:
                    try {
                        System.out.print("ID cần xóa: ");
                        int id = Integer.parseInt(sc.nextLine());
                        mm.deleteMovie(id);
                    } catch (Exception e) {
                        System.out.println("Lỗi nhập!");
                    }
                    break;

                case 0:
                    System.out.println("Thoát chương trình!");
                    return;

                default:
                    System.out.println(" Chọn sai!");
            }
        }
    }
}
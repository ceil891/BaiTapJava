package BaiTapSS17.Kha02;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TaskManagement tm = new TaskManagement();

        while (true) {
            System.out.println("\n===== TODO MENU =====");
            System.out.println("1. Thêm");
            System.out.println("2. Danh sách");
            System.out.println("3. Cập nhật");
            System.out.println("4. Xóa");
            System.out.println("5. Tìm kiếm");
            System.out.println("6. Thống kê");
            System.out.println("0. Thoát");

            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println(" Nhập sai!");
                continue;
            }

            switch (choice) {
                case 1:
                    try {
                        System.out.print("Tên: ");
                        String name = sc.nextLine();

                        System.out.print("Trạng thái: ");
                        String status = sc.nextLine();

                        if (name.isEmpty() || status.isEmpty()) {
                            throw new Exception("Không được để trống");
                        }

                        tm.addTask(name, status);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 2:
                    tm.listTasks();
                    break;

                case 3:
                    try {
                        System.out.print("ID: ");
                        int id = Integer.parseInt(sc.nextLine());

                        System.out.print("Trạng thái: ");
                        String status = sc.nextLine();

                        tm.updateTaskStatus(id, status);
                    } catch (Exception e) {
                        System.out.println(" Lỗi nhập");
                    }
                    break;

                case 4:
                    try {
                        System.out.print("ID: ");
                        int id = Integer.parseInt(sc.nextLine());
                        tm.deleteTask(id);
                    } catch (Exception e) {
                        System.out.println(" Lỗi");
                    }
                    break;

                case 5:
                    System.out.print("Nhập tên: ");
                    String name = sc.nextLine();
                    tm.searchTaskByName(name);
                    break;

                case 6:
                    tm.taskStatistics();
                    break;

                case 0:
                    return;

                default:
                    System.out.println(" Sai lựa chọn");
            }
        }
    }
}

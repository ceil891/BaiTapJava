package BaiTapSS17.Gioi01;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BookManager bm = new BookManager();

        while (true) {
            System.out.println("\n===== LIBRARY MENU =====");
            System.out.println("1. Thêm sách");
            System.out.println("2. Cập nhật");
            System.out.println("3. Xóa");
            System.out.println("4. Tìm theo tác giả");
            System.out.println("5. Danh sách");
            System.out.println("0. Thoát");

            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Nhập sai!");
                continue;
            }

            switch (choice) {
                case 1:
                    try {
                        System.out.print("Title: ");
                        String title = sc.nextLine();

                        System.out.print("Author: ");
                        String author = sc.nextLine();

                        System.out.print("Year: ");
                        int year = Integer.parseInt(sc.nextLine());

                        System.out.print("Price: ");
                        double price = Double.parseDouble(sc.nextLine());

                        if (title.isEmpty() || author.isEmpty()) {
                            throw new Exception("Không được để trống");
                        }

                        bm.addBook(new Book(title, author, year, price));

                    } catch (Exception e) {
                        System.out.println("Lỗi nhập!");
                    }
                    break;

                case 2:
                    try {
                        System.out.print("ID: ");
                        int id = Integer.parseInt(sc.nextLine());

                        System.out.print("Title: ");
                        String title = sc.nextLine();

                        System.out.print("Author: ");
                        String author = sc.nextLine();

                        System.out.print("Year: ");
                        int year = Integer.parseInt(sc.nextLine());

                        System.out.print("Price: ");
                        double price = Double.parseDouble(sc.nextLine());

                        bm.updateBook(id, new Book(title, author, year, price));

                    } catch (Exception e) {
                        System.out.println(" Lỗi");
                    }
                    break;

                case 3:
                    try {
                        System.out.print("ID: ");
                        int id = Integer.parseInt(sc.nextLine());
                        bm.deleteBook(id);
                    } catch (Exception e) {
                        System.out.println(" Lỗi");
                    }
                    break;

                case 4:
                    System.out.print("Author: ");
                    String author = sc.nextLine();
                    bm.findBooksByAuthor(author);
                    break;

                case 5:
                    bm.listAllBooks();
                    break;

                case 0:
                    return;

                default:
                    System.out.println("Sai lựa chọn");
            }
        }
    }
}
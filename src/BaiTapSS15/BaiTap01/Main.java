package BaiTapSS15.BaiTap01;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static MovieManager<Movie> manager = new MovieManager<>();
    private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nChọn chức năng:");
            System.out.println("1. Thêm phim");
            System.out.println("2. Xóa phim");
            System.out.println("3. Sửa phim");
            System.out.println("4. Hiển thị phim");
            System.out.println("5. Tìm kiếm phim theo tên");
            System.out.println("6. Lọc phim theo rating");
            System.out.println("7. Thoát");
            System.out.print("Lựa chọn: ");

            try {
                int choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1: addMovie(); break;
                    case 2: deleteMovie(); break;
                    case 3: updateMovie(); break;
                    case 4: manager.displayAll(); break;
                    case 5: searchMovie(); break;
                    case 6: filterMovie(); break;
                    case 7: System.exit(0);
                    default: System.out.println("Vui lòng chọn từ 1-7.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Vui lòng nhập số cho lựa chọn menu!");
            }
        }
    }

    private static void addMovie() {
        try {
            System.out.print("Nhập ID phim: ");
            int id = Integer.parseInt(sc.nextLine());
            System.out.print("Nhập tiêu đề phim: ");
            String title = sc.nextLine();
            System.out.print("Nhập đạo diễn: ");
            String director = sc.nextLine();
            System.out.print("Nhập ngày phát hành (dd-MM-yyyy): ");
            LocalDate date = LocalDate.parse(sc.nextLine(), dtf);
            System.out.print("Nhập rating: ");
            double rating = Double.parseDouble(sc.nextLine());

            manager.add(new Movie(id, title, director, date, rating));
        } catch (DateTimeParseException e) {
            System.out.println("Lỗi: Định dạng ngày không hợp lệ (dd-MM-yyyy)!");
        } catch (NumberFormatException e) {
            System.out.println("Lỗi: ID hoặc Rating phải là chữ số!");
        }
    }

    private static void deleteMovie() {
        System.out.print("Nhập ID phim cần xóa: ");
        int id = Integer.parseInt(sc.nextLine());
        manager.delete(id);
    }

    private static void updateMovie() {
        System.out.print("Mời nhập ID phim muốn sửa: ");
        int id = Integer.parseInt(sc.nextLine());
        Movie movie = manager.findById(id);
        if (movie != null) {
            try {
                System.out.print("Nhập tiêu đề mới: ");
                movie.setTitle(sc.nextLine());
                System.out.print("Nhập đạo diễn mới: ");
                movie.setDirector(sc.nextLine());
                System.out.print("Nhập ngày mới (dd-MM-yyyy): ");
                movie.setReleaseDate(LocalDate.parse(sc.nextLine(), dtf));
                System.out.print("Nhập rating mới: ");
                movie.setRating(Double.parseDouble(sc.nextLine()));
                System.out.println("Cập nhật phim thành công!");
            } catch (Exception e) {
                System.out.println("Lỗi nhập liệu, cập nhật thất bại!");
            }
        } else {
            System.out.println("Không tìm thấy phim với ID = " + id);
        }
    }

    private static void searchMovie() {
        System.out.print("Nhập tên phim cần tìm: ");
        manager.searchByTitle(sc.nextLine());
    }

    private static void filterMovie() {
        System.out.print("Nhập rating tối thiểu để lọc: ");
        double r = Double.parseDouble(sc.nextLine());
        manager.filterByRating(r);
    }
}
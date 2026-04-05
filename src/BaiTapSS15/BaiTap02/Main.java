package BaiTapSS15.BaiTap02;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static SubjectManager<Subject> manager = new SubjectManager<>();
    private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- QUẢN LÝ MÔN HỌC ---");
            System.out.println("1. Hiển thị danh sách");
            System.out.println("2. Thêm môn học");
            System.out.println("3. Xóa môn học theo mã");
            System.out.println("4. Tìm kiếm theo tên");
            System.out.println("5. Lọc môn học > 3 tín chỉ");
            System.out.println("6. Thoát");
            System.out.print("Lựa chọn: ");

            try {
                int choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1: manager.displayAll(); break;
                    case 2: addSubject(); break;
                    case 3: deleteSubject(); break;
                    case 4: searchSubject(); break;
                    case 5: manager.filterHighCredits(); break;
                    case 6: System.out.println("Tạm biệt!"); return;
                    default: System.out.println("Vui lòng chọn 1-6.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Vui lòng nhập số hợp lệ!");
            }
        }
    }

    private static void addSubject() {
        try {
            System.out.print("Nhập mã môn học: ");
            String code = sc.nextLine();
            System.out.print("Nhập tên môn học: ");
            String name = sc.nextLine();

            System.out.print("Nhập số tín chỉ: ");
            int credits = Integer.parseInt(sc.nextLine());
            // Kiểm tra ngoại lệ nghiệp vụ
            if (credits <= 0 || credits > 10) {
                throw new IllegalArgumentException("Số tín chỉ không hợp lệ (phải từ 1-10)!");
            }

            System.out.print("Nhập ngày bắt đầu (dd/mm/yyyy): ");
            LocalDate startDate = LocalDate.parse(sc.nextLine(), dtf);

            manager.add(new Subject(code, name, credits, startDate));

        } catch (IllegalArgumentException e) {
            System.out.println("Lỗi nghiệp vụ: " + e.getMessage());
        } catch (DateTimeParseException e) {
            System.out.println("Lỗi: Định dạng ngày tháng không đúng!");
        } catch (Exception e) {
            System.out.println("Lỗi không xác định: " + e.getMessage());
        }
    }

    private static void deleteSubject() {
        System.out.print("Nhập mã cần xóa: ");
        String code = sc.nextLine();
        if (manager.deleteByCode(code)) {
            System.out.println("Xóa thành công.");
        } else {
            System.out.println("Lỗi: Không tìm thấy môn học có mã " + code);
        }
    }

    private static void searchSubject() {
        System.out.print("Nhập tên môn học cần tìm: ");
        String name = sc.nextLine();
        manager.searchByName(name);
    }
}

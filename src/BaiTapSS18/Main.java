package BaiTapSS18;

import java.sql.Date;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static ProductDAO dao = new ProductDAO();
    // Giả sử ProductService của bạn xử lý logic kiểm tra dữ liệu
    static ProductService service = new ProductService();

    public static void main(String[] args) {
        while (true) {
            try {
                System.out.println("\n********************PRODUCT MANAGEMENT****************");
                System.out.println("1. Danh sách sản phẩm");
                System.out.println("2. Thêm mới sản phẩm");
                System.out.println("3. Cập nhật sản phẩm");
                System.out.println("4. Xóa sản phẩm");
                System.out.println("5. Tìm kiếm sản phẩm theo tên");
                System.out.println("6. Sắp xếp sản phẩm theo giá tăng dần (Demo)");
                System.out.println("7. Thống kê số lượng theo danh mục (Demo)");
                System.out.println("8. Thoát");
                System.out.print("Lựa chọn của bạn: ");

                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1:
                        System.out.println("--- Danh sách sản phẩm ---");
                        dao.getAll().forEach(System.out::println);
                        break;
                    case 2:
                        Product pNew = inputProduct(0); // ID tự tăng nên để 0
                        service.validate(pNew);
                        dao.add(pNew);
                        System.out.println("Thêm mới thành công!");
                        break;
                    case 3:
                        updateProductUI();
                        break;
                    case 4:
                        System.out.print("Nhập ID cần xóa: ");
                        int idDel = Integer.parseInt(sc.nextLine());
                        dao.delete(idDel);
                        System.out.println("Đã xóa sản phẩm!");
                        break;
                    case 5:
                        System.out.print("Nhập tên tìm kiếm: ");
                        String searchName = sc.nextLine();
                        dao.search(searchName).forEach(System.out::println);
                        break;
                    case 8:
                        System.out.println("Tạm biệt!");
                        System.exit(0);
                    default:
                        System.out.println("Lựa chọn không hợp lệ!");
                }
            } catch (NumberFormatException e) {
                System.err.println("Lỗi: Vui lòng nhập số!");
            } catch (IllegalArgumentException e) {
                System.err.println("Lỗi định dạng ngày tháng (yyyy-mm-dd)!");
            } catch (Exception e) {
                System.err.println("Có lỗi xảy ra: " + e.getMessage());
                e.printStackTrace(); // Để bạn dễ debug khi code
            }
        }
    }

    // Tách riêng hàm nhập để tái sử dụng
    public static Product inputProduct(int id) {
        System.out.print("Tên sản phẩm: ");
        String name = sc.nextLine();

        System.out.print("Giá sản phẩm: ");
        float price = Float.parseFloat(sc.nextLine());

        System.out.print("Tiêu đề: ");
        String title = sc.nextLine();

        System.out.print("Ngày tạo (yyyy-mm-dd): ");
        Date date = Date.valueOf(sc.nextLine());

        System.out.print("Danh mục: ");
        String catalog = sc.nextLine();

        // Mặc định status là true (1) khi thêm mới
        return new Product(id, name, price, title, date, catalog, true);
    }

    public static void updateProductUI() throws Exception {
        System.out.print("Nhập ID sản phẩm cần sửa: ");
        int id = Integer.parseInt(sc.nextLine());

        // Bạn nên kiểm tra ID có tồn tại trong DB không trước khi cho nhập thông tin mới
        Product p = inputProduct(id);

        service.validate(p);
        dao.update(p);
        System.out.println("Cập nhật thành công!");
    }

}
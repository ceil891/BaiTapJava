package BaiTapSS17.Gioi01;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookManager {

    // ✔ kiểm tra tồn tại theo id
    private boolean existsById(int id) {
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(
                    "SELECT 1 FROM books WHERE id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (Exception e) {
            return false;
        }
    }

    // ✔ kiểm tra trùng title + author
    private boolean isDuplicate(String title, String author) {
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(
                    "SELECT 1 FROM books WHERE title = ? AND author = ?");
            ps.setString(1, title);
            ps.setString(2, author);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (Exception e) {
            return false;
        }
    }

    // 🔹 Thêm sách
    public void addBook(Book book) {
        if (isDuplicate(book.getTitle(), book.getAuthor())) {
            System.out.println("Sách đã tồn tại!");
            return;
        }

        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(
                    "INSERT INTO books(title, author, published_year, price) VALUES (?, ?, ?, ?)"
            );

            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setInt(3, book.getPublishedYear());
            ps.setDouble(4, book.getPrice());

            ps.executeUpdate();
            System.out.println("Thêm thành công!");

        } catch (Exception e) {
            System.out.println("Lỗi thêm: " + e.getMessage());
        }
    }

    // 🔹 Update
    public void updateBook(int id, Book book) {
        if (!existsById(id)) {
            System.out.println("Không tìm thấy sách!");
            return;
        }

        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(
                    "UPDATE books SET title=?, author=?, published_year=?, price=? WHERE id=?"
            );

            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setInt(3, book.getPublishedYear());
            ps.setDouble(4, book.getPrice());
            ps.setInt(5, id);

            ps.executeUpdate();
            System.out.println("Cập nhật thành công!");

        } catch (Exception e) {
            System.out.println("Lỗi update");
        }
    }

    // 🔹 Delete
    public void deleteBook(int id) {
        if (!existsById(id)) {
            System.out.println("Không tồn tại!");
            return;
        }

        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(
                    "DELETE FROM books WHERE id=?"
            );
            ps.setInt(1, id);
            ps.executeUpdate();

            System.out.println("Xóa thành công!");

        } catch (Exception e) {
            System.out.println("Lỗi xóa");
        }
    }

    // 🔹 Tìm theo author
    public void findBooksByAuthor(String author) {
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(
                    "SELECT * FROM books WHERE author LIKE ?"
            );
            ps.setString(1, "%" + author + "%");

            ResultSet rs = ps.executeQuery();

            boolean found = false;
            while (rs.next()) {
                found = true;
                System.out.println(
                        rs.getInt("id") + " | " +
                                rs.getString("title") + " | " +
                                rs.getString("author") + " | " +
                                rs.getInt("published_year") + " | " +
                                rs.getDouble("price")
                );
            }

            if (!found) System.out.println("Không tìm thấy!");

        } catch (Exception e) {
            System.out.println("Lỗi tìm kiếm");
        }
    }

    // 🔹 List all
    public void listAllBooks() {
        try (Connection conn = DBConnection.getConnection()) {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM books");

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " | " +
                                rs.getString("title") + " | " +
                                rs.getString("author") + " | " +
                                rs.getInt("published_year") + " | " +
                                rs.getDouble("price")
                );
            }

        } catch (Exception e) {
            System.out.println("Lỗi hiển thị");
        }
    }
}
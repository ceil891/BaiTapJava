package BaiTapSS17.Kha01;

import java.sql.*;

public class MovieManagement {

    // ➤ Thêm phim
    public void addMovie(String title, String director, int year) {
        try (Connection conn = DBConnection.getConnection()) {
            CallableStatement cs = conn.prepareCall("{call add_movie(?, ?, ?)}");
            cs.setString(1, title);
            cs.setString(2, director);
            cs.setInt(3, year);
            cs.execute();
            System.out.println("Thêm phim thành công!");
        } catch (Exception e) {
            System.out.println(" Lỗi thêm phim: " + e.getMessage());
        }
    }

    // ➤ Liệt kê phim
    public void listMovies() {
        try (Connection conn = DBConnection.getConnection()) {
            CallableStatement cs = conn.prepareCall("{call list_movies()}");
            ResultSet rs = cs.executeQuery();

            System.out.println("=== DANH SÁCH PHIM ===");
            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " | " +
                                rs.getString("title") + " | " +
                                rs.getString("director") + " | " +
                                rs.getInt("year")
                );
            }
        } catch (Exception e) {
            System.out.println(" Lỗi hiển thị: " + e.getMessage());
        }
    }

    // ➤ Sửa phim
    public void updateMovie(int id, String title, String director, int year) {
        try (Connection conn = DBConnection.getConnection()) {
            CallableStatement cs = conn.prepareCall("{call update_movie(?, ?, ?, ?)}");
            cs.setInt(1, id);
            cs.setString(2, title);
            cs.setString(3, director);
            cs.setInt(4, year);
            cs.execute();
            System.out.println("Cập nhật thành công!");
        } catch (Exception e) {
            System.out.println(" Lỗi cập nhật: " + e.getMessage());
        }
    }

    // ➤ Xóa phim
    public void deleteMovie(int id) {
        try (Connection conn = DBConnection.getConnection()) {
            CallableStatement cs = conn.prepareCall("{call delete_movie(?)}");
            cs.setInt(1, id);
            cs.execute();
            System.out.println("Xóa thành công!");
        } catch (Exception e) {
            System.out.println(" Lỗi xóa: " + e.getMessage());
        }
    }
}
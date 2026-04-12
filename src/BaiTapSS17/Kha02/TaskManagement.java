package BaiTapSS17.Kha02;

import java.sql.*;

public class TaskManagement {

    // ➤ Thêm
    public void addTask(String name, String status) {
        try (Connection conn = DBConnection.getConnection()) {
            CallableStatement cs = conn.prepareCall("CALL add_task(?, ?)");
            cs.setString(1, name);
            cs.setString(2, status);
            cs.execute();
            System.out.println(" Thêm thành công");
        } catch (Exception e) {
            System.out.println(" Lỗi: " + e.getMessage());
        }
    }

    // ➤ List
    public void listTasks() {
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM list_tasks()");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " | " +
                                rs.getString("task_name") + " | " +
                                rs.getString("status")
                );
            }
        } catch (Exception e) {
            System.out.println(" Lỗi: " + e.getMessage());
        }
    }

    // ➤ Update
    public void updateTaskStatus(int id, String status) {
        try (Connection conn = DBConnection.getConnection()) {
            CallableStatement cs = conn.prepareCall("CALL update_task_status(?, ?)");
            cs.setInt(1, id);
            cs.setString(2, status);
            cs.execute();
            System.out.println("Cập nhật thành công");
        } catch (Exception e) {
            System.out.println(" Lỗi");
        }
    }

    // ➤ Delete
    public void deleteTask(int id) {
        try (Connection conn = DBConnection.getConnection()) {
            CallableStatement cs = conn.prepareCall("CALL delete_task(?)");
            cs.setInt(1, id);
            cs.execute();
            System.out.println("Xóa thành công");
        } catch (Exception e) {
            System.out.println(" Lỗi");
        }
    }

    // ➤ Search
    public void searchTaskByName(String name) {
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(
                    "SELECT * FROM search_task_by_name(?)"
            );
            ps.setString(1, name);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " | " +
                                rs.getString("task_name") + " | " +
                                rs.getString("status")
                );
            }
        } catch (Exception e) {
            System.out.println("Lỗi");
        }
    }

    // ➤ Statistics
    public void taskStatistics() {
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(
                    "SELECT * FROM task_statistics()"
            );
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("Đã hoàn thành: " + rs.getInt("completed"));
                System.out.println("Chưa hoàn thành: " + rs.getInt("not_completed"));
            }
        } catch (Exception e) {
            System.out.println("Lỗi");
        }
    }
}
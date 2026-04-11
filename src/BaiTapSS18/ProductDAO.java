package BaiTapSS18;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    // =========================
    // GET ALL
    // =========================
    public List<Product> getAll() throws Exception {
        Connection conn = DBConnection.getConnection();
        CallableStatement cs = conn.prepareCall("{call get_all_products()}");
        ResultSet rs = cs.executeQuery();
        List<Product> list = new ArrayList<>();

        try {
            while (rs.next()) {
                list.add(new Product(
                        rs.getInt("Product_Id"), // Lưu ý: Tên cột phải khớp với DB (Product_Id)
                        rs.getString("Product_Name"),
                        rs.getFloat("Product_Price"),
                        rs.getString("Product_Title"),
                        rs.getDate("Product_created"),
                        rs.getString("Product_catalog"),
                        rs.getBoolean("Product_Status")
                ));
            }
        } finally {
            if (rs != null) rs.close();
            if (cs != null) cs.close();
            conn.close();
        }
        return list;
    }

    // =========================
    // ADD (TRANSACTION)
    // =========================
    public void add(Product p) throws Exception {
        Connection conn = DBConnection.getConnection();
        conn.setAutoCommit(false); // Bắt đầu Transaction

        try {
            // Giả sử procedure: add_product(name, price, title, created, catalog)
            CallableStatement cs = conn.prepareCall("{call add_product(?,?,?,?,?)}");

            cs.setString(1, p.getName());
            // FIX: Dùng tham số 'p' truyền vào, ép kiểu float nếu cần
            cs.setFloat(2, (float) p.getPrice());
            cs.setString(3, p.getTitle());
            cs.setDate(4, p.getCreated());
            cs.setString(5, p.getCatalog());

            cs.execute();
            conn.commit(); // Thành công thì commit
            cs.close();
        } catch (Exception e) {
            conn.rollback(); // Lỗi thì rollback
            throw e;
        } finally {
            conn.setAutoCommit(true);
            conn.close();
        }
    }

    // =========================
    // UPDATE
    // =========================
    public void update(Product p) throws Exception {
        Connection conn = DBConnection.getConnection();
        // Giả sử procedure: update_product(id, name, price, title, catalog)
        CallableStatement cs = conn.prepareCall("{call update_product(?,?,?,?,?)}");

        cs.setInt(1, p.getId());
        cs.setString(2, p.getName());
        cs.setFloat(3, (float) p.getPrice());
        cs.setString(4, p.getTitle());
        cs.setString(5, p.getCatalog());

        cs.execute();
        cs.close();
        conn.close();
    }

    // =========================
    // DELETE
    // =========================
    public void delete(int id) throws Exception {
        Connection conn = DBConnection.getConnection();
        CallableStatement cs = conn.prepareCall("{call delete_product(?)}");

        cs.setInt(1, id);
        cs.execute();

        cs.close();
        conn.close();
    }
    public List<Product> search(String name) throws Exception {
        Connection conn = DBConnection.getConnection();
        // Chú ý: Tên procedure phải khớp với database của bạn
        CallableStatement cs = conn.prepareCall("{call search_product(?)}");
        cs.setString(1, "%" + name + "%"); // Tìm kiếm tương đối

        ResultSet rs = cs.executeQuery();
        List<Product> list = new ArrayList<>();
        try {
            while (rs.next()) {
                list.add(new Product(
                        rs.getInt("Product_Id"),
                        rs.getString("Product_Name"),
                        rs.getFloat("Product_Price"),
                        rs.getString("Product_Title"),
                        rs.getDate("Product_created"),
                        rs.getString("Product_catalog"),
                        rs.getBoolean("Product_Status")
                ));
            }
        } finally {
            if (rs != null) rs.close();
            if (cs != null) cs.close();
            conn.close();
        }
        return list;
    }
}
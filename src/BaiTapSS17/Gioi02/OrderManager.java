package BaiTapSS17.Gioi02;

import java.sql.*;
import java.util.Scanner;

public class OrderManager {

    // ✔ Check product trùng
    private boolean productExists(String name) {
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(
                    "SELECT 1 FROM products WHERE name=?"
            );
            ps.setString(1, name);
            return ps.executeQuery().next();
        } catch (Exception e) {
            return false;
        }
    }

    // 🔹 Add product
    public void addProduct(Product p) {
        if (productExists(p.getName())) {
            System.out.println("Trùng sản phẩm!");
            return;
        }

        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(
                    "INSERT INTO products(name, price) VALUES (?, ?)"
            );
            ps.setString(1, p.getName());
            ps.setDouble(2, p.getPrice());
            ps.executeUpdate();

            System.out.println("Thêm thành công!");
        } catch (Exception e) {
            System.out.println("Lỗi thêm");
        }
    }

    // ✔ Check customer tồn tại
    private boolean customerExists(int id) {
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(
                    "SELECT 1 FROM customers WHERE id=?"
            );
            ps.setInt(1, id);
            return ps.executeQuery().next();
        } catch (Exception e) {
            return false;
        }
    }

    // 🔹 Update customer
    public void updateCustomer(int id, Customer c) {
        if (!customerExists(id)) {
            System.out.println("Không tồn tại!");
            return;
        }

        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(
                    "UPDATE customers SET name=?, email=? WHERE id=?"
            );
            ps.setString(1, c.getName());
            ps.setString(2, c.getEmail());
            ps.setInt(3, id);
            ps.executeUpdate();

            System.out.println("Update thành công!");
        } catch (Exception e) {
            System.out.println("Email trùng!");
        }
    }

    // 🔥 Create order (transaction chuẩn)
    public void createOrder() {
        Scanner sc = new Scanner(System.in);

        try (Connection conn = DBConnection.getConnection()) {
            conn.setAutoCommit(false);

            System.out.print("Customer ID: ");
            int customerId = Integer.parseInt(sc.nextLine());

            if (!customerExists(customerId)) {
                System.out.println("KH không tồn tại!");
                return;
            }

            // insert order
            PreparedStatement orderStmt = conn.prepareStatement(
                    "INSERT INTO orders(customer_id, order_date, total_amount) VALUES (?, CURRENT_DATE, 0)",
                    Statement.RETURN_GENERATED_KEYS
            );

            orderStmt.setInt(1, customerId);
            orderStmt.executeUpdate();

            ResultSet rs = orderStmt.getGeneratedKeys();
            rs.next();
            int orderId = rs.getInt(1);

            double total = 0;

            while (true) {
                System.out.print("Product ID (0 để dừng): ");
                int pid = Integer.parseInt(sc.nextLine());
                if (pid == 0) break;

                System.out.print("Quantity: ");
                int qty = Integer.parseInt(sc.nextLine());

                PreparedStatement ps = conn.prepareStatement(
                        "SELECT price FROM products WHERE id=?"
                );
                ps.setInt(1, pid);
                ResultSet pr = ps.executeQuery();

                if (pr.next()) {
                    double price = pr.getDouble("price");
                    total += price * qty;

                    PreparedStatement item = conn.prepareStatement(
                            "INSERT INTO order_items(order_id, product_id, quantity, price) VALUES (?, ?, ?, ?)"
                    );
                    item.setInt(1, orderId);
                    item.setInt(2, pid);
                    item.setInt(3, qty);
                    item.setDouble(4, price);
                    item.executeUpdate();
                }
            }

            // update total
            PreparedStatement update = conn.prepareStatement(
                    "UPDATE orders SET total_amount=? WHERE id=?"
            );
            update.setDouble(1, total);
            update.setInt(2, orderId);
            update.executeUpdate();

            conn.commit();
            System.out.println("Tạo đơn thành công!");

        } catch (Exception e) {
            System.out.println("Lỗi transaction!");
        }
    }

    // 🔹 List orders
    public void listAllOrders() {
        try (Connection conn = DBConnection.getConnection()) {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(
                    "SELECT o.id, c.name, o.order_date, o.total_amount " +
                            "FROM orders o JOIN customers c ON o.customer_id = c.id"
            );

            while (rs.next()) {
                System.out.println(
                        rs.getInt(1) + " | " +
                                rs.getString(2) + " | " +
                                rs.getDate(3) + " | " +
                                rs.getDouble(4)
                );
            }
        } catch (Exception e) {
            System.out.println("Lỗi");
        }
    }

    // 🔹 Search
    public void getOrdersByCustomer(int customerId) {
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(
                    "SELECT * FROM orders WHERE customer_id=?"
            );
            ps.setInt(1, customerId);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " | " +
                                rs.getDate("order_date") + " | " +
                                rs.getDouble("total_amount")
                );
            }
        } catch (Exception e) {
            System.out.println("Lỗi");
        }
    }
}
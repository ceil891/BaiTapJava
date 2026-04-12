package BaiTapSS17.Gioi02;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        OrderManager om = new OrderManager();

        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Update khách hàng");
            System.out.println("3. Tạo đơn");
            System.out.println("4. Danh sách đơn");
            System.out.println("5. Tìm theo KH");
            System.out.println("0. Thoát");

            int c = Integer.parseInt(sc.nextLine());

            switch (c) {
                case 1:
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Price: ");
                    double price = Double.parseDouble(sc.nextLine());
                    om.addProduct(new Product(name, price));
                    break;

                case 2:
                    System.out.print("ID: ");
                    int id = Integer.parseInt(sc.nextLine());
                    System.out.print("Name: ");
                    String cname = sc.nextLine();
                    System.out.print("Email: ");
                    String email = sc.nextLine();
                    om.updateCustomer(id, new Customer(cname, email));
                    break;

                case 3:
                    om.createOrder();
                    break;

                case 4:
                    om.listAllOrders();
                    break;

                case 5:
                    System.out.print("Customer ID: ");
                    int cid = Integer.parseInt(sc.nextLine());
                    om.getOrdersByCustomer(cid);
                    break;

                case 0:
                    return;
            }
        }
    }
}
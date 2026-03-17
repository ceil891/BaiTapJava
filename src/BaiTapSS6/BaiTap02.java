package BaiTapSS6;


import java.util.ArrayList;
import java.util.Scanner;

class User {
    String name;
    String email;
    String phone;
    String password;

    public User(String name, String email, String phone, String password) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }
}

public class BaiTap02 {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<User> list = new ArrayList<>();

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n===== QUAN LY USER =====");
            System.out.println("1. Nhap user");
            System.out.println("2. Chuan hoa ten");
            System.out.println("3. Check email");
            System.out.println("4. Check sdt");
            System.out.println("5. Check password");
            System.out.println("6. Thoat");

            System.out.print("Chon: ");
            int chon = Integer.parseInt(sc.nextLine());

            switch (chon) {
                case 1:
                    nhapUser();
                    break;
                case 2:
                    chuanHoaTatCaTen();
                    break;
                case 3:
                    checkEmail();
                    break;
                case 4:
                    checkPhone();
                    break;
                case 5:
                    checkPassword();
                    break;
                case 6:
                    System.out.println("Thoat!");
                    return;
                default:
                    System.out.println("Chon sai!");
            }
        }
    }


    static void nhapUser() {
        System.out.print("Ten: ");
        String name = sc.nextLine();

        System.out.print("Email: ");
        String email = sc.nextLine();

        System.out.print("SDT: ");
        String phone = sc.nextLine();

        System.out.print("Password: ");
        String pass = sc.nextLine();

        list.add(new User(name, email, phone, pass));
        System.out.println("Da them user!");
    }

    static void chuanHoaTatCaTen() {
        if (list.isEmpty()) {
            System.out.println("Danh sach rong!");
            return;
        }

        for (User u : list) {
            u.name = chuanHoaTen(u.name);
        }
        System.out.println("Da chuan hoa ten!");
    }

    static String chuanHoaTen(String name) {
        name = name.trim().toLowerCase();
        String[] arr = name.split("\\s+");
        String result = "";

        for (String w : arr) {
            result += Character.toUpperCase(w.charAt(0)) + w.substring(1) + " ";
        }
        return result.trim();
    }

    static void checkEmail() {
        if (list.isEmpty()) {
            System.out.println("Danh sach rong!");
            return;
        }

        String regex = "^[\\w.-]+@[\\w.-]+\\.\\w+$";

        for (User u : list) {
            if (u.email.matches(regex)) {
                System.out.println(u.email + " hop le");
            } else {
                System.out.println(u.email + " khong hop le");
            }
        }
    }

    static void checkPhone() {
        if (list.isEmpty()) {
            System.out.println("Danh sach rong!");
            return;
        }

        String regex = "^0\\d{9}$";

        for (User u : list) {
            if (u.phone.matches(regex)) {
                System.out.println(u.phone + " hop le");
            } else {
                System.out.println(u.phone + " khong hop le");
            }
        }
    }

    static void checkPassword() {
        if (list.isEmpty()) {
            System.out.println("Danh sach rong!");
            return;
        }

        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=]).{8,}$";

        for (User u : list) {
            if (u.password.matches(regex)) {
                System.out.println("Password hop le");
            } else {
                System.out.println("Password khong hop le");
            }
        }
    }
}

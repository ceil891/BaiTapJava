package BaiTapSS12.BaiTap01;

import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Staff> list = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Add Staff");
            System.out.println("2. Show List");
            System.out.println("3. Update");
            System.out.println("4. Delete");
            System.out.println("5. Exit");
            System.out.print("Choose: ");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    addStaff();
                    break;
                case 2:
                    showList();
                    break;
                case 3:
                    updateStaff();
                    break;
                case 4:
                    deleteStaff();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid!");
            }
        }
    }

    // 🔹 Add
    static void addStaff() {
        System.out.println("1. Lecturer");
        System.out.println("2. AdminStaff");
        int type = Integer.parseInt(sc.nextLine());

        System.out.print("ID: ");
        int id = Integer.parseInt(sc.nextLine());

        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Base Salary: ");
        double base = Double.parseDouble(sc.nextLine());

        if (type == 1) {
            System.out.print("Teaching Hours: ");
            int hours = Integer.parseInt(sc.nextLine());
            list.add(new Lecturer(id, name, base, hours));
        } else {
            System.out.print("Bonus: ");
            double bonus = Double.parseDouble(sc.nextLine());
            list.add(new AdminStaff(id, name, base, bonus));
        }
    }

    // 🔹 Show
    static void showList() {
        for (Staff s : list) {
            s.showInfo();
            System.out.println("Salary: " + s.calculateTotalSalary());

            if (s instanceof ICapability) {
                ((ICapability) s).checkPerformance();
            }

            System.out.println("----------------");
        }
    }

    // 🔹 Update
    static void updateStaff() {
        System.out.print("Enter ID: ");
        int id = Integer.parseInt(sc.nextLine());

        for (Staff s : list) {
            if (s.getId() == id) {
                if (s instanceof Lecturer) {
                    System.out.print("New teaching hours: ");
                    int h = Integer.parseInt(sc.nextLine());
                    ((Lecturer) s).update(h);
                } else if (s instanceof AdminStaff) {
                    System.out.print("New bonus: ");
                    double b = Double.parseDouble(sc.nextLine());
                    ((AdminStaff) s).update(b);
                }
                return;
            }
        }
        System.out.println("Not found!");
    }

    // 🔹 Delete
    static void deleteStaff() {
        System.out.print("Enter ID: ");
        int id = Integer.parseInt(sc.nextLine());

        list.removeIf(s -> s.getId() == id);
    }
}
package BaiTapSS12.BaiTap02;

import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Asset> list = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Add Asset");
            System.out.println("2. Show All");
            System.out.println("3. Search");
            System.out.println("4. Update Price");
            System.out.println("5. Exit");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1: add(); break;
                case 2: showAll(); break;
                case 3: searchMenu(); break;
                case 4: update(); break;
                case 5: return;
            }
        }
    }

    // 🔹 Add
    static void add() {
        System.out.println("1. Computer");
        System.out.println("2. NetworkDevice");
        int type = Integer.parseInt(sc.nextLine());

        System.out.print("Code: ");
        String code = sc.nextLine();

        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Price: ");
        double price = Double.parseDouble(sc.nextLine());

        if (type == 1) {
            System.out.print("RAM: ");
            int ram = Integer.parseInt(sc.nextLine());

            System.out.print("CPU: ");
            String cpu = sc.nextLine();

            list.add(new Computer(code, name, price, ram, cpu));
        } else {
            System.out.print("Ports: ");
            int ports = Integer.parseInt(sc.nextLine());

            list.add(new NetworkDevice(code, name, price, ports));
        }
    }

    // 🔹 Show
    static void showAll() {
        for (Asset a : list) {
            showValue(a);
        }
    }

    // 🔹 Polymorphism
    static void showValue(Asset a) {
        if (a instanceof Computer) {
            ((Computer) a).show();
        } else if (a instanceof NetworkDevice) {
            ((NetworkDevice) a).show();
        }
    }

    // 🔥 Overloading Search
    static void searchMenu() {
        System.out.println("1. By Code");
        System.out.println("2. By Price > X");
        int c = Integer.parseInt(sc.nextLine());

        if (c == 1) {
            System.out.print("Enter code: ");
            search(sc.nextLine());
        } else {
            System.out.print("Enter price: ");
            search(Double.parseDouble(sc.nextLine()));
        }
    }

    // Overload 1
    static void search(String code) {
        for (Asset a : list) {
            if (a.getAssetCode().equalsIgnoreCase(code)) {
                showValue(a);
            }
        }
    }

    // Overload 2
    static void search(double price) {
        for (Asset a : list) {
            if (a.getPurchasePrice() > price) {
                showValue(a);
            }
        }
    }

    // 🔹 Update
    static void update() {
        System.out.print("Enter code: ");
        String code = sc.nextLine();

        for (Asset a : list) {
            if (a.getAssetCode().equalsIgnoreCase(code)) {
                System.out.print("New price: ");
                double p = Double.parseDouble(sc.nextLine());
                a.setPurchasePrice(p);
                return;
            }
        }
        System.out.println("Not found!");
    }
}
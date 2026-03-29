package BaiTapSS12.BaiTap03;
import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Drink> menu = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n===== COFFEE SHOP MENU =====");
            System.out.println("1. Add Drink");
            System.out.println("2. Show Menu");
            System.out.println("3. Apply Discount");
            System.out.println("4. Delete Drink");
            System.out.println("5. Average Price");
            System.out.println("6. Exit");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1: addDrink(); break;
                case 2: showMenu(); break;
                case 3: applyDiscount(); break;
                case 4: deleteDrink(); break;
                case 5: averagePrice(); break;
                case 6: return;
            }
        }
    }

    // 🔹 Add
    static void addDrink() {
        System.out.println("1. Coffee");
        System.out.println("2. FruitTea");
        int type = Integer.parseInt(sc.nextLine());

        System.out.print("ID: ");
        int id = Integer.parseInt(sc.nextLine());

        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Price: ");
        double price = Double.parseDouble(sc.nextLine());

        if (type == 1) {
            menu.add(new Coffee(id, name, price));
        } else {
            menu.add(new FruitTea(id, name, price));
        }
    }

    // 🔹 Show
    static void showMenu() {
        for (Drink d : menu) {
            d.showInfo();
            d.prepare();
            System.out.println("----------------");
        }
    }

    // 🔹 Apply Discount
    static void applyDiscount() {
        System.out.print("Enter % discount: ");
        double percent = Double.parseDouble(sc.nextLine());

        for (Drink d : menu) {
            if (d instanceof IPromotion) {
                ((IPromotion) d).applyDiscount(percent);
            }
        }
        System.out.println("Discount applied!");
    }

    // 🔹 Delete
    static void deleteDrink() {
        System.out.print("Enter ID: ");
        int id = Integer.parseInt(sc.nextLine());

        menu.removeIf(d -> d.getId() == id);
    }

    // 🔹 Average Price
    static void averagePrice() {
        if (menu.isEmpty()) {
            System.out.println("No data!");
            return;
        }

        double sum = 0;
        for (Drink d : menu) {
            sum += d.getPrice();
        }

        System.out.println("Average price: " + (sum / menu.size()));
    }
}
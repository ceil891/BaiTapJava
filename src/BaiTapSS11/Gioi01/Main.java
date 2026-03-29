package BaiTapSS11.Gioi01;
public class Main {
    public static void main(String[] args) {

        Employee[] employees = {
                new FullTimeEmployee(1, "Alice", 1000),
                new PartTimeEmployee(2, "Bob", 20, 10)
        };

        for (Employee e : employees) {
            e.showInfo();

            double salary = e.calculateSalary();
            System.out.println("Salary: " + salary);

            // Nếu có thưởng
            if (e instanceof BonusEligible) {
                double bonus = ((BonusEligible) e).calculateBonus();
                System.out.println("Bonus: " + bonus);
            }

            System.out.println("------------------");
        }
    }
}
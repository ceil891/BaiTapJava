package BaiTapSS12.BaiTap01;

abstract class Staff {
    protected int id;
    protected String name;
    protected double baseSalary;

    public Staff(int id, String name, double baseSalary) {
        this.id = id;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public int getId() {
        return id;
    }

    public abstract double calculateTotalSalary();

    public void showInfo() {
        System.out.println("ID: " + id + ", Name: " + name);
    }
}
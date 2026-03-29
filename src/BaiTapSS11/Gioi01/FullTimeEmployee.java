package BaiTapSS11.Gioi01;

class FullTimeEmployee extends Employee implements BonusEligible {
    private double baseSalary;

    public FullTimeEmployee(int id, String name, double baseSalary) {
        super(id, name);
        this.baseSalary = baseSalary;
    }

    @Override
    public double calculateSalary() {
        return baseSalary;
    }

    @Override
    public double calculateBonus() {
        return baseSalary * 0.1; // thưởng 10%
    }
}

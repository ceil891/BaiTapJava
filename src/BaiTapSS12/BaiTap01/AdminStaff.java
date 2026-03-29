package BaiTapSS12.BaiTap01;

class AdminStaff extends Staff implements ICapability {
    private double bonus;

    public AdminStaff(int id, String name, double baseSalary, double bonus) {
        super(id, name, baseSalary);
        this.bonus = bonus;
    }

    @Override
    public double calculateTotalSalary() {
        return baseSalary + bonus;
    }

    @Override
    public void checkPerformance() {
        System.out.println("Admin performance evaluated by KPI");
    }

    public void update(double bonus) {
        this.bonus = bonus;
    }
}
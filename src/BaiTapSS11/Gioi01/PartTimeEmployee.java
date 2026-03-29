package BaiTapSS11.Gioi01;

class PartTimeEmployee extends Employee {
    private int workingHour;
    private double hourlyRate;

    public PartTimeEmployee(int id, String name, int workingHour, double hourlyRate) {
        super(id, name);
        this.workingHour = workingHour;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary() {
        return workingHour * hourlyRate;
    }
}
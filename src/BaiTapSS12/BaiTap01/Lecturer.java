package BaiTapSS12.BaiTap01;

class Lecturer extends Staff implements ICapability {
    private int teachingHours;

    public Lecturer(int id, String name, double baseSalary, int teachingHours) {
        super(id, name, baseSalary);
        this.teachingHours = teachingHours;
    }

    @Override
    public double calculateTotalSalary() {
        return baseSalary + (teachingHours * 200000);
    }

    @Override
    public void checkPerformance() {
        System.out.println("Lecturer performance evaluated by teaching hours");
    }

    public void update(int teachingHours) {
        this.teachingHours = teachingHours;
    }
}

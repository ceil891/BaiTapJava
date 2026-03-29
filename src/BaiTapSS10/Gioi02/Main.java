package BaiTapSS10.Gioi02;

public class Main {
    public static void main(String[] args) {
        Car car = new Car();

        car.accelerate();
        car.printStatus();

        System.out.println();

        car.accelerate(20);
        car.printStatus();

        System.out.println();

        car.accelerate(10, 2);
        car.printStatus();
    }
}

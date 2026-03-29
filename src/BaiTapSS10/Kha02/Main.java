package BaiTapSS10.Kha02;

public class Main {
    public static void main(String[] args) {
        Shape s1 = new Rectangle(2, 3);
        Shape s2 = new Circle(1);

        System.out.println("Rectangle area: " + s1.area());
        System.out.println("Circle area: " + s2.area());
    }
}
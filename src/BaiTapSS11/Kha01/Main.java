package BaiTapSS11.Kha01;

public class Main {
    public static void main(String[] args) {

        Shape[] shapes = {
                new Rectangle(2, 3),
                new Circle(1)
        };

        for (Shape s : shapes) {
            s.displayInfo();
            System.out.println("Area: " + s.getArea());
            System.out.println("Perimeter: " + s.getPerimeter());

            // Ép kiểu để gọi draw()
            ((Drawable) s).draw();

            System.out.println("------------------");
        }
    }
}
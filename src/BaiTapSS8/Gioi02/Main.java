package BaiTapSS8.Gioi02;

class Rectangle {
    double width;
    double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getArea() {
        return width * height;
    }

    public double getPerimeter() {
        return 2 * (width + height);
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "Rectangle(width=" + width +
                ", height=" + height +
                ", area=" + getArea() +
                ", perimeter=" + getPerimeter() + ")";
    }
}

public class Main {
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(3, 4);
        Rectangle r2 = new Rectangle(5, 2);
        Rectangle r3 = new Rectangle(4.5, 3.5);

        System.out.println(r1);
        System.out.println(r2);
        System.out.println(r3);

        double a1 = r1.getArea();
        double a2 = r2.getArea();
        double a3 = r3.getArea();

        double max = Math.max(a1, Math.max(a2, a3));

        int count = 0;
        if (a1 == max) count++;
        if (a2 == max) count++;
        if (a3 == max) count++;

        if (count > 1) {
            System.out.println("Có nhiều hình có diện tích lớn nhất: " + max);
        } else {
            System.out.println("Hình có diện tích lớn nhất:");
            if (a1 == max) System.out.println(r1);
            if (a2 == max) System.out.println(r2);
            if (a3 == max) System.out.println(r3);
        }
    }
}
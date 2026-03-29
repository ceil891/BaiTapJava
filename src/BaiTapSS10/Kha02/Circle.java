package BaiTapSS10.Kha02;

class Circle extends Shape {
    private double radius;

    // Constructor
    public Circle(double radius) {
        this.radius = radius;
    }

    // Override area()
    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}


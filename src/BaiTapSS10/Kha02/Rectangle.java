package BaiTapSS10.Kha02;

class Rectangle extends Shape {
    private double width;
    private double height;

    // Constructor
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    // Override area()
    @Override
    public double area() {
        return width * height;
    }
}

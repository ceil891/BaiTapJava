package BaiTapSS9.LuyenTap02;

public class Main {
    public static void main(String[] args) {

        Book b1 = new Book("Java", "James", 100.0);
        Book b2 = new Book("Python", "Guido", 120.0);
        Book b3 = new Book("C++", "Bjarne", 150.0);

        Book[] list = {b1, b2, b3};

        System.out.println("----- LIST OF BOOKS -----");

        for (Book b : list) {
            b.printInfo();
        }
    }
}
package BaiTapSS8;

public class Kha02 {
        public static void main(String[] args) {
            Book b1 = new Book("Java Basic", "Nguyen Van A", 99.5);

            System.out.println("Title: " + b1.title
                    + ", Author: " + b1.author
                    + ", Price: " + b1.price);
        }
    }

    class Book {
        String title;
        String author;
        double price;

        public Book(String title, String author, double price) {
            this.title = title;
            this.author = author;
            this.price = price;
        }
    }


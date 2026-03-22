package BaiTapSS8;

public class Kha01 {
    public static void main(String[] args) {
        Student sv1 = new Student(1, "Hung", 20);

        System.out.println("ID: " + sv1.id);
        System.out.println("Name: " + sv1.name);
        System.out.println("Age: " + sv1.age);
    }
}

class Student {
    int id;
    String name;
    int age;

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
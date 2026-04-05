package BaiTapSS13.Kha01;

public class Person {
    private String name;
    private String email;
    private String phone;

    public Person(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Tên: " + name +
                ", Email: " + email +
                ", SĐT: " + phone;
    }
}
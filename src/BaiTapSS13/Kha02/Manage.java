package BaiTapSS13.Kha02;

public interface Manage<T> {
    void add(T item);
    void update(int id, T item);
    void delete(int id);
    void display();
}
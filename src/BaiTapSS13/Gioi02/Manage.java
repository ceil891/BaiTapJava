package BaiTapSS13.Gioi02;

public interface Manage<T> {
    void add(T item);
    void update(int index, T item); // Lưu ý: Trong logic này index sẽ được dùng để tìm theo mã
    void delete(int index);        // Hoặc xóa theo mã dựa trên yêu cầu thực tế của hình ảnh
    void display();
}
package BaiTapSS15.BaiTap01;

import java.util.ArrayList;
import java.util.List;

public class MovieManager<T extends Movie> {
    private List<T> list = new ArrayList<>();

    public void add(T item) {
        list.add(item);
        System.out.println("Phim đã được thêm thành công.");
    }

    public void displayAll() {
        if (list.isEmpty()) {
            System.out.println("Danh sách phim trống.");
        } else {
            System.out.println("Danh sách phim:");
            for (T item : list) {
                System.out.println(item);
            }
        }
    }

    public T findById(int id) {
        for (T item : list) {
            if (item.getId() == id) return item;
        }
        return null;
    }

    public void delete(int id) {
        T movie = findById(id);
        if (movie != null) {
            list.remove(movie);
            System.out.println("Phim đã được xóa thành công.");
        } else {
            System.out.println("Không tìm thấy phim với ID = " + id);
        }
    }

    public void searchByTitle(String title) {
        boolean found = false;
        for (T item : list) {
            if (item.getTitle().toLowerCase().contains(title.toLowerCase())) {
                System.out.println(item);
                found = true;
            }
        }
        if (!found) System.out.println("Không tìm thấy phim có tên: " + title);
    }

    public void filterByRating(double minRating) {
        boolean found = false;
        for (T item : list) {
            if (item.getRating() >= minRating) {
                System.out.println(item);
                found = true;
            }
        }
        if (!found) System.out.println("Không có phim nào đạt rating >= " + minRating);
    }
}
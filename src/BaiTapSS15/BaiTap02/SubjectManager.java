package BaiTapSS15.BaiTap02;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class SubjectManager<T extends Subject> {
    private List<T> subjects = new ArrayList<>();

    public void add(T subject) {
        subjects.add(subject);
        System.out.println("Thêm môn học thành công!");
    }

    public void displayAll() {
        if (subjects.isEmpty()) {
            System.out.println("Danh sách môn học đang trống.");
        } else {
            subjects.forEach(System.out::println);
        }
    }

    public boolean deleteByCode(String code) {
        return subjects.removeIf(s -> s.getCode().equalsIgnoreCase(code));
    }

    // Sử dụng Stream và Optional để tìm kiếm
    public void searchByName(String name) {
        Optional<T> result = subjects.stream()
                .filter(s -> s.getName().toLowerCase().contains(name.toLowerCase()))
                .findFirst();

        result.ifPresentOrElse(
                System.out::println,
                () -> System.out.println("Không có môn học phù hợp.")
        );
    }

    // Lọc môn học bằng Stream API
    public void filterHighCredits() {
        List<T> filtered = subjects.stream()
                .filter(s -> s.getCredits() > 3)
                .collect(Collectors.toList());

        if (filtered.isEmpty()) {
            System.out.println("Không có môn học nào trên 3 tín chỉ.");
        } else {
            filtered.forEach(System.out::println);
        }
    }
}
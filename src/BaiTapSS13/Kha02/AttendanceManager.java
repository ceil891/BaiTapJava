package BaiTapSS13.Kha02;
import java.util.ArrayList;

public class AttendanceManager implements Manage<Student> {
    private ArrayList<Student> studentList = new ArrayList<>();

    @Override
    public void add(Student item) {
        studentList.add(item);
        System.out.println("Sinh viên đã được thêm thành công.");
    }

    @Override
    public void update(int id, Student newItem) {
        for (Student s : studentList) {
            if (s.getId() == id) {
                s.setName(newItem.getName());
                System.out.println("Sinh viên đã được sửa thành công.");
                return;
            }
        }
        System.out.println("Không tìm thấy ID sinh viên.");
    }

    @Override
    public void delete(int id) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId() == id) {
                studentList.remove(i);
                System.out.println("Đã xóa thành công sinh viên !");
                return;
            }
        }
        System.out.println("Không tìm thấy ID sinh viên để xóa.");
    }

    @Override
    public void display() {
        if (studentList.isEmpty()) {
            System.out.println("Danh sách trống.");
        } else {
            for (Student s : studentList) {
                System.out.println(s.toString());
            }
        }
    }
}
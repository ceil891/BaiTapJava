package BaiTapSS16.Gioi01;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.util.stream.Collectors;

public class ChatApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Message> messages = new ArrayList<>();

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        while (true) {
            System.out.println("\n===== CHAT MENU =====");
            System.out.println("1. Gửi tin nhắn");
            System.out.println("2. Xem lịch sử chat");
            System.out.println("3. Lọc theo người gửi");
            System.out.println("4. Lọc theo ngày");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Tên người gửi: ");
                    String sender = sc.nextLine();

                    System.out.print("Nội dung: ");
                    String content = sc.nextLine();

                    messages.add(new Message(sender, content, LocalDateTime.now()));
                    System.out.println(" Đã gửi!");
                    break;

                case 2:
                    if (messages.isEmpty()) {
                        System.out.println("Không có tin nhắn!");
                    } else {
                        messages.forEach(System.out::println);
                    }
                    break;

                case 3:
                    System.out.print("Nhập tên người gửi cần lọc: ");
                    String name = sc.nextLine();

                    List<Message> filteredBySender = messages.stream()
                            .filter(m -> m.getSender().equalsIgnoreCase(name))
                            .collect(Collectors.toList());

                    if (filteredBySender.isEmpty()) {
                        System.out.println("Không tìm thấy!");
                    } else {
                        filteredBySender.forEach(System.out::println);
                    }
                    break;

                case 4:
                    try {
                        System.out.print("Nhập ngày (dd/MM/yyyy): ");
                        String dateStr = sc.nextLine();

                        LocalDate date = LocalDate.parse(dateStr, dateFormatter);

                        List<Message> filteredByDate = messages.stream()
                                .filter(m -> m.getTimestamp().toLocalDate().equals(date))
                                .collect(Collectors.toList());

                        if (filteredByDate.isEmpty()) {
                            System.out.println("Không có tin nhắn trong ngày này!");
                        } else {
                            filteredByDate.forEach(System.out::println);
                        }

                    } catch (DateTimeParseException e) {
                        System.out.println("Sai định dạng ngày! (dd/MM/yyyy)");
                    }
                    break;

                case 0:
                    System.out.println("Thoát...");
                    return;

                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }
}
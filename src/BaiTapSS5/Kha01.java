package BaiTapSS5;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Kha01 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String email;
        System.out.println("Nhập email :");
        email = input.nextLine();
        String trimemail =  email.trim();
        String regex = "^[a-zA-Z0-9._]+@[a-zA-Z0-9.]+\\.[a-zA-Z]{2,6}$";        Pattern pat = Pattern.compile(regex);
        Matcher mat = pat.matcher(trimemail);
        if (mat.matches()) {
            System.out.println("Email hợp lệ");
        } else {
            System.out.println("Email không hợp lệ");
        }
    }
}

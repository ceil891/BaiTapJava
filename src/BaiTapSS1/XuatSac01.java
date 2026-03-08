package BaiTapSS1;
import java.util.Scanner;
public class XuatSac01 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        double cannang;
        double chieucao;
        double bmi;

        System.out.print("Nhập cân nặng (kg): ");
        cannang = input.nextDouble();

        System.out.print("Nhập chiều cao (m): ");
        chieucao = input.nextDouble();

        bmi = cannang / (chieucao * chieucao);

        System.out.println("Chỉ số BMI của bạn là: " + bmi);
    }
}

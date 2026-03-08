package BaiTapSS1;
import java.util.Scanner;
public class XuatSac02 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        double vantoc;
        double thoigian;
        double quangduong;

        System.out.print("Nhập vận tốc (km/h): ");
        vantoc = input.nextDouble();

        System.out.print("Nhập thời gian (giờ): ");
        thoigian = input.nextDouble();

        if (vantoc < 0 || thoigian < 0) {
            System.out.println("Vận tốc và thời gian không được nhỏ hơn 0!");
        } else {
            quangduong = vantoc * thoigian;
            System.out.println("Quãng đường đi được là: " + quangduong + " km");
        }
    }
}

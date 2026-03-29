package BaiTapSS11.Gioi02;

public class Main {
    public static void main(String[] args) {

        Device[] devices = {
                new SmartPhone(1, "iPhone"),
                new Laptop(2, "Dell XPS"),
                new Television(3, "Samsung TV")
        };

        for (Device d : devices) {
            d.turnOn();

            // Nếu có WiFi
            if (d instanceof Connectable) {
                ((Connectable) d).connectWifi();
            }

            // Nếu sạc được
            if (d instanceof Chargeable) {
                ((Chargeable) d).charge();
            }

            d.turnOff();

            System.out.println("------------------");
        }
    }
}
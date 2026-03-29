package BaiTapSS11.Gioi02;
class Television extends Device implements Connectable {

    public Television(int id, String name) {
        super(id, name);
    }

    @Override
    public void turnOn() {
        System.out.println(name + " is turning ON (TV)");
    }

    @Override
    public void turnOff() {
        System.out.println(name + " is turning OFF (TV)");
    }

    @Override
    public void connectWifi() {
        System.out.println(name + " connected to WiFi");
    }
}

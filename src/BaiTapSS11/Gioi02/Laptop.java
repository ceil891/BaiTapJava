package BaiTapSS11.Gioi02;

class Laptop extends Device implements Connectable, Chargeable {

    public Laptop(int id, String name) {
        super(id, name);
    }

    @Override
    public void turnOn() {
        System.out.println(name + " is turning ON (Laptop)");
    }

    @Override
    public void turnOff() {
        System.out.println(name + " is turning OFF (Laptop)");
    }

    @Override
    public void connectWifi() {
        System.out.println(name + " connected to WiFi");
    }

    @Override
    public void charge() {
        System.out.println(name + " is charging");
    }
}
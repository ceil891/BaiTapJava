package BaiTapSS11.Gioi02;
class SmartPhone extends Device implements Connectable, Chargeable {

    public SmartPhone(int id, String name) {
        super(id, name);
    }

    @Override
    public void turnOn() {
        System.out.println(name + " is turning ON (SmartPhone)");
    }

    @Override
    public void turnOff() {
        System.out.println(name + " is turning OFF (SmartPhone)");
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

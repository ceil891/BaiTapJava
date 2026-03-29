package BaiTapSS12.BaiTap02;

class Computer extends Asset {
    private int ram;
    private String cpu;

    public Computer(String code, String name, double price, int ram, String cpu) {
        super(code, name, price);
        this.ram = ram;
        this.cpu = cpu;
    }

    @Override
    public double getMarketValue() {
        return purchasePrice * 0.8; // giảm 20%
    }

    public void show() {
        System.out.println("Computer - " + assetCode + " | " + name +
                " | Price: " + purchasePrice + " | Value: " + getMarketValue());
    }
}
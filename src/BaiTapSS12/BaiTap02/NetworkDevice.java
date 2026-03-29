package BaiTapSS12.BaiTap02;

class NetworkDevice extends Asset {
    private int numberOfPorts;

    public NetworkDevice(String code, String name, double price, int ports) {
        super(code, name, price);
        this.numberOfPorts = ports;
    }

    @Override
    public double getMarketValue() {
        return purchasePrice * 0.9; // giảm 10%
    }

    public void show() {
        System.out.println("NetworkDevice - " + assetCode + " | " + name +
                " | Price: " + purchasePrice + " | Value: " + getMarketValue());
    }
}
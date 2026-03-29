package BaiTapSS12.BaiTap02;

abstract class Asset {
    protected String assetCode;
    protected String name;
    protected double purchasePrice;

    public Asset(String assetCode, String name, double purchasePrice) {
        this.assetCode = assetCode;
        this.name = name;
        this.purchasePrice = purchasePrice;
    }

    public String getAssetCode() {
        return assetCode;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double price) {
        this.purchasePrice = price;
    }

    public abstract double getMarketValue();
}
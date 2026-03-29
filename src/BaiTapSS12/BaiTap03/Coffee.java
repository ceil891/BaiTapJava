package BaiTapSS12.BaiTap03;

class Coffee extends Drink implements IPromotion {

    public Coffee(int id, String name, double price) {
        super(id, name, price);
    }

    @Override
    public void prepare() {
        System.out.println("Pha bằng máy");
    }

    @Override
    public void applyDiscount(double percentage) {
        double newPrice = getPrice() * (1 - percentage / 100);
        setPrice(newPrice);
    }
}
package BaiTapSS10.Gioi01;

class Computer {

    // 1. Chỉ giá gốc
    public double calculatePrice(double basePrice) {
        System.out.println("Using base price only");
        return basePrice;
    }

    // 2. Giá + thuế
    public double calculatePrice(double basePrice, double tax) {
        System.out.println("Using base price + tax");
        return basePrice + (basePrice * tax);
    }

    // 3. Giá + thuế - giảm giá
    public double calculatePrice(double basePrice, double tax, double discount) {
        System.out.println("Using base price + tax - discount");
        double priceWithTax = basePrice + (basePrice * tax);
        return priceWithTax - discount;
    }
}
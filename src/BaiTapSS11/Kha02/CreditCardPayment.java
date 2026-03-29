package BaiTapSS11.Kha02;
class CreditCardPayment extends Payment implements Refundable {

    public CreditCardPayment(double amount) {
        super(amount);
    }

    @Override
    public void pay() {
        System.out.println("Paying with Credit Card");
    }

    @Override
    public void refund() {
        System.out.println("Refund to Credit Card");
    }
}


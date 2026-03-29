package BaiTapSS11.Kha02;

class CashPayment extends Payment {

    public CashPayment(double amount) {
        super(amount);
    }

    @Override
    public void pay() {
        System.out.println("Paying with Cash");
    }
}

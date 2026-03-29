package BaiTapSS11.Kha02;

class EWalletPayment extends Payment implements Refundable {

    public EWalletPayment(double amount) {
        super(amount);
    }

    @Override
    public void pay() {
        System.out.println("Paying with E-Wallet");
    }

    @Override
    public void refund() {
        System.out.println("Refund to E-Wallet");
    }
}

package BaiTapSS11.Kha02;

public class Main {
    public static void main(String[] args) {

        Payment[] payments = {
                new CashPayment(100),
                new CreditCardPayment(200),
                new EWalletPayment(150)
        };

        for (Payment p : payments) {
            p.printAmount();
            p.pay();

            // Kiểm tra nếu có thể refund
            if (p instanceof Refundable) {
                ((Refundable) p).refund();
            }

            System.out.println("------------------");
        }
    }
}
package BaiTapSS8.Gioi01;

public class Main {
    public static void main(String[] args) {
        CurrencyConverter.setRate(24000);

        double usd = CurrencyConverter.toUSD(48000);

        System.out.println(CurrencyConverter.formatUSD(usd));
    }
}
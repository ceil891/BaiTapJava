package BaiTapSS13.Gioi01;

public class Invoice {
    private static int count = 0;
    private int id;
    private String code;
    private double amount;

    public Invoice(String code, double amount) {
        this.id = ++count;
        this.code = code;
        this.amount = amount;
    }

    // Getters và Setters
    public int getId() { return id; }
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    @Override
    public String toString() {
        return "ID : " + id + " , Mã hóa đơn: " + code + ", Số tiền: " + amount;
    }
}
package BaiTapSS14.Gioi02;

public class InvalidPhoneNumberException extends Exception {

    public InvalidPhoneNumberException(String message) {
        super(message);
    }

    // Phương thức kiểm tra tính hợp lệ theo yêu cầu
    public static void validate(String phone) throws InvalidPhoneNumberException {
        // 1. Kiểm tra chứa ký tự không phải số (bao gồm khoảng trắng, chữ, ký tự đặc biệt)
        if (!phone.matches("\\d+")) {
            throw new InvalidPhoneNumberException("Chứa ký tự không hợp lệ (chữ cái, khoảng trắng hoặc ký tự đặc biệt)");
        }

        // 2. Kiểm tra độ dài (phải đúng 10 số)
        if (phone.length() != 10) {
            throw new InvalidPhoneNumberException("Sai độ dài (yêu cầu đúng 10 chữ số, hiện có " + phone.length() + ")");
        }
    }
}
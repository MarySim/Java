public class SmsMessage {
    private String phoneNumber;
    private String message;

    // Конструктор
    public SmsMessage(String phoneNumber, String message) {
        this.phoneNumber = phoneNumber;
        this.message = message;
    }

    // Геттеры
    public String getPhoneNumber() { return phoneNumber; }
    public String getMessage() { return message; }

    // Сеттеры
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public void setMessage(String message) { this.message = message; }

    public static void execute() {
        // ваш код
    }
}
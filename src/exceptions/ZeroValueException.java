package exceptions;

// Собственное исключение для нулевых значений
public class ZeroValueException extends RuntimeException {
    public ZeroValueException(String message) {
        super(message);
    }
}
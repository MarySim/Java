package exceptions;

// Собственное исключение для отрицательных значений
public class NegativeValueException extends RuntimeException {
    public NegativeValueException(String message) {
        super(message);
    }
}
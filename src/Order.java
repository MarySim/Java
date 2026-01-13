// ==================== ЗАДАНИЕ 2 ====================
// Запись для хранения информации о заказе
public record Order(int id, String shoeType, int quantity) {
    @Override
    public String toString() {
        return String.format("Заказ #%d: %s (кол-во: %d)", id, shoeType, quantity);
    }
}
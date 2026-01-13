// ==================== ЗАДАНИЕ 2 ====================
// Склад обуви с использованием wait()/notifyAll()
import java.util.ArrayList;
import java.util.List;

public class ShoeWarehouse {
    public static final List<String> AVAILABLE_SHOE_TYPES = List.of(
            "Nike Air Force", "Adidas Ultraboost", "Converse Chuck Taylor",
            "Vans Old Skool", "New Balance 574", "Puma Suede"
    );

    private final List<Order> orders = new ArrayList<>();
    private static final int MAX_CAPACITY = 5;

    // Добавление заказа (используется Producer)
    public synchronized void receiveOrder(Order order) {
        while (orders.size() >= MAX_CAPACITY) {
            try {
                System.out.println("Склад заполнен! Producer ждет...");
                wait(); // Ждем пока Consumer заберет заказы
            } catch (InterruptedException e) {
                System.out.println("Producer был прерван: " + e.getMessage());
            }
        }

        orders.add(order);
        System.out.println("Добавлен: " + order);
        System.out.println("Заказов на складе: " + orders.size());

        notifyAll(); // Будим все ожидающие потоки
    }

    // Выполнение заказа (используется Consumer)
    public synchronized Order fulfillOrder() {
        while (orders.isEmpty()) {
            try {
                System.out.println("Склад пуст! Consumer ждет...");
                wait(); // Ждем пока Producer добавит заказы
            } catch (InterruptedException e) {
                System.out.println("Consumer был прерван: " + e.getMessage());
            }
        }

        Order order = orders.remove(0);
        System.out.println("Выполнен: " + order);
        System.out.println("Заказов на складе: " + orders.size());

        notifyAll(); // Будим все ожидающие потоки
        return order;
    }

    public synchronized int getCurrentOrdersCount() {
        return orders.size();
    }
}
// ==================== ЗАДАНИЕ 3 ====================
// Усовершенствованный склад с использованием ExecutorService
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ShoeWarehouseWithExecutor {
    public static final List<String> AVAILABLE_SHOE_TYPES = List.of(
            "Nike Air Force", "Adidas Ultraboost", "Converse Chuck Taylor",
            "Vans Old Skool", "New Balance 574", "Puma Suede"
    );

    private final List<Order> orders = new ArrayList<>();
    private static final int MAX_CAPACITY = 5;

    // Внутренний ExecutorService для асинхронной обработки заказов
    private final ExecutorService processingExecutor = Executors.newFixedThreadPool(2);

    public synchronized void receiveOrder(Order order) {
        while (orders.size() >= MAX_CAPACITY) {
            try {
                System.out.println("Склад заполнен! Producer ждет...");
                wait();
            } catch (InterruptedException e) {
                System.out.println("Producer был прерван: " + e.getMessage());
            }
        }

        orders.add(order);
        System.out.println("Добавлен: " + order);
        System.out.println("Заказов на складе: " + orders.size());

        notifyAll();
    }

    // Асинхронное выполнение заказа через ExecutorService
    public synchronized void fulfillOrderAsync(String consumerName) {
        processingExecutor.submit(() -> {
            try {
                Order order = fulfillOrder();
                System.out.println("Consumer " + consumerName + " асинхронно обработал: " + order);
                Thread.sleep(800);
                System.out.println("Consumer " + consumerName + " завершил обработку: " + order);
            } catch (InterruptedException e) {
                System.out.println(consumerName + " был прерван при обработке");
            }
        });
    }

    private synchronized Order fulfillOrder() {
        while (orders.isEmpty()) {
            try {
                System.out.println("Склад пуст! Consumer ждет...");
                wait();
            } catch (InterruptedException e) {
                System.out.println("Consumer был прерван: " + e.getMessage());
            }
        }

        Order order = orders.remove(0);
        System.out.println("Выполнен: " + order);
        System.out.println("Заказов на складе: " + orders.size());

        notifyAll();
        return order;
    }

    public synchronized int getCurrentOrdersCount() {
        return orders.size();
    }

    // Завершение работы внутреннего ExecutorService
    public void shutdown() {
        processingExecutor.shutdown();
    }
}
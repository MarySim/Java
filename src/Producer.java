// ==================== ЗАДАНИЕ 2 ====================
// Producer - создает заказы и отправляет на склад
import java.util.Random;

public class Producer implements Runnable {
    private final ShoeWarehouse warehouse;
    private final int numberOfOrders;
    private final Random random = new Random();

    public Producer(ShoeWarehouse warehouse, int numberOfOrders) {
        this.warehouse = warehouse;
        this.numberOfOrders = numberOfOrders;
    }

    @Override
    public void run() {
        System.out.println("Producer начал работу. Создаст " + numberOfOrders + " заказов");

        for (int i = 1; i <= numberOfOrders; i++) {
            try {
                String shoeType = ShoeWarehouse.AVAILABLE_SHOE_TYPES.get(
                        random.nextInt(ShoeWarehouse.AVAILABLE_SHOE_TYPES.size())
                );
                int quantity = random.nextInt(10) + 1;
                Order order = new Order(i, shoeType, quantity);
                warehouse.receiveOrder(order);
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Producer был прерван: " + e.getMessage());
                break;
            }
        }

        System.out.println("Producer завершил работу");
    }
}
// ==================== ЗАДАНИЕ 2 ====================
// Consumer - забирает заказы со склада и обрабатывает их
public class Consumer implements Runnable {
    private final ShoeWarehouse warehouse;
    private final String consumerName;
    private final int ordersToProcess;

    public Consumer(ShoeWarehouse warehouse, String consumerName, int ordersToProcess) {
        this.warehouse = warehouse;
        this.consumerName = consumerName;
        this.ordersToProcess = ordersToProcess;
    }

    @Override
    public void run() {
        System.out.println("Consumer " + consumerName + " начал работу. Обработает " + ordersToProcess + " заказов");

        int processed = 0;
        while (processed < ordersToProcess) {
            try {
                Order order = warehouse.fulfillOrder();
                System.out.println("Consumer " + consumerName + " обрабатывает: " + order);
                processed++;
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(consumerName + " был прерван: " + e.getMessage());
                break;
            }
        }

        System.out.println("Consumer " + consumerName + " завершил работу");
    }
}
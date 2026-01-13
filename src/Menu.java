import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Menu {
    private final Scanner scanner = new Scanner(System.in);

    public void showMenu() {
        while (true) {
            System.out.println("1 - Задание 1");
            System.out.println("2 - Задание 2");
            System.out.println("3 - Задание 3");
            System.out.println("0 - Выход");
            System.out.print("Выберите: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> runTask1();
                case 2 -> runTask2();
                case 3 -> runTask3();
                case 0 -> System.exit(0);
                default -> System.out.println("Неверный выбор");
            }
        }
    }

    private void runTask1() {
        Thread evenThread = new EvenThread();
        Thread oddThread = new Thread(new OddRunnable());

        evenThread.start();
        oddThread.start();

        try {
            evenThread.join();
            oddThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        waitForEnter();
    }

    private void runTask2() {
        ShoeWarehouse warehouse = new ShoeWarehouse();

        Producer producer = new Producer(warehouse, 15);
        Consumer consumer1 = new Consumer(warehouse, "Consumer-1", 5);
        Consumer consumer2 = new Consumer(warehouse, "Consumer-2", 5);
        Consumer consumer3 = new Consumer(warehouse, "Consumer-3", 5);

        Thread producerThread = new Thread(producer);
        Thread consumerThread1 = new Thread(consumer1);
        Thread consumerThread2 = new Thread(consumer2);
        Thread consumerThread3 = new Thread(consumer3);

        producerThread.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        consumerThread1.start();
        consumerThread2.start();
        consumerThread3.start();

        try {
            producerThread.join();
            consumerThread1.join();
            consumerThread2.join();
            consumerThread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        waitForEnter();
    }

    private void runTask3() {
        ShoeWarehouseWithExecutor warehouse = new ShoeWarehouseWithExecutor();
        ExecutorService executor = Executors.newFixedThreadPool(4);

        executor.submit(() -> {
            try {
                for (int i = 1; i <= 10; i++) {
                    String shoeType = ShoeWarehouseWithExecutor.AVAILABLE_SHOE_TYPES.get(
                            (int)(Math.random() * ShoeWarehouseWithExecutor.AVAILABLE_SHOE_TYPES.size())
                    );
                    int quantity = (int)(Math.random() * 5) + 1;

                    Order order = new Order(i, shoeType, quantity);
                    warehouse.receiveOrder(order);
                    Thread.sleep(300);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        for (int i = 1; i <= 3; i++) {
            final int consumerId = i;
            executor.submit(() -> {
                try {
                    for (int j = 0; j < 4; j++) {
                        warehouse.fulfillOrderAsync("Consumer-" + consumerId);
                        Thread.sleep(800);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        executor.shutdown();

        try {
            executor.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }

        warehouse.shutdown();
        waitForEnter();
    }

    private void waitForEnter() {
        System.out.println("Нажмите Enter для продолжения...");
        scanner.nextLine();
        scanner.nextLine();
    }
}
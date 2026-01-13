// ==================== ЗАДАНИЕ 1 ====================
// Поток для вывода четных чисел (наследник Thread)
public class EvenThread extends Thread {

    @Override
    public void run() {
        try {
            for (int i = 2; i <= 10; i += 2) {
                System.out.println("Чётный поток: " + i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.err.println("Чётный поток был прерван: " + e.getMessage());
        }
    }
}
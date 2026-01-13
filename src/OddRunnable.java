// ==================== ЗАДАНИЕ 1 ====================
// Задача для вывода нечетных чисел (реализация Runnable)
public class OddRunnable implements Runnable {

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 9; i += 2) {
                System.out.println("Нечётный поток: " + i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.err.println("Нечётный поток был прерван: " + e.getMessage());
        }
    }
}
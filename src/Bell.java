public class Bell {
    private boolean isDing = true;  // Переменная для отслеживания состояния

    public void sound() {
        if (isDing) {
            System.out.println("ding");
        } else {
            System.out.println("dong");
        }
        isDing = !isDing;  // Меняем состояние на противоположное
    }
}
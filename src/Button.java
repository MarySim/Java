public class Button {
    private int clicks;

    public Button() {
        this.clicks = 0;
    }

    public void click() {
        clicks++;
        System.out.println("Нажатий: " + clicks);
    }

    // Дополнительный метод для получения текущего значения
    public int getClicks() {
        return clicks;
    }
}
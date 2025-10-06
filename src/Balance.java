public class Balance {
    private int leftWeight;   // Вес на левой чаше
    private int rightWeight;  // Вес на правой чаше

    // Конструктор
    public Balance() {
        this.leftWeight = 0;
        this.rightWeight = 0;
    }

    // Добавить вес на правую чашу
    public void addRight(int weight) {
        rightWeight += weight;
    }

    // Добавить вес на левую чашу
    public void addLeft(int weight) {
        leftWeight += weight;
    }

    // Определить результат взвешивания
    public void result() {
        if (leftWeight > rightWeight) {
            System.out.println("L");  // Левая чаша перевесила
        } else if (rightWeight > leftWeight) {
            System.out.println("R");  // Правая чаша перевесила
        } else {
            System.out.println("=");  // Чаши в равновесии
        }
    }
}
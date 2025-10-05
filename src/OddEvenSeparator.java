public class OddEvenSeparator {
    private int[] numbers;      // Массив для хранения всех чисел
    private int count;          // Количество добавленных чисел

    // Конструктор
    public OddEvenSeparator() {
        numbers = new int[10];  // Начальный размер массива
        count = 0;
    }

    // Метод для добавления числа
    public void addNumber(int number) {
        // Если массив заполнен, увеличиваем его размер
        if (count == numbers.length) {
            int[] newArray = new int[numbers.length * 2];
            for (int i = 0; i < numbers.length; i++) {
                newArray[i] = numbers[i];
            }
            numbers = newArray;
        }
        numbers[count] = number;
        count++;
    }

    // Метод для печати четных чисел
    public void even() {
        System.out.print("Четные числа: ");
        boolean first = true;
        for (int i = 0; i < count; i++) {
            if (numbers[i] % 2 == 0) {
                if (!first) {
                    System.out.print(", ");
                }
                System.out.print(numbers[i]);
                first = false;
            }
        }
        System.out.println();
    }

    // Метод для печати нечетных чисел
    public void odd() {
        System.out.print("Нечетные числа: ");
        boolean first = true;
        for (int i = 0; i < count; i++) {
            if (numbers[i] % 2 != 0) {
                if (!first) {
                    System.out.print(", ");
                }
                System.out.print(numbers[i]);
                first = false;
            }
        }
        System.out.println();
    }

    // Дополнительный метод для получения количества чисел
    public int getCount() {
        return count;
    }
}
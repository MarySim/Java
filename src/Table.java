public class Table {
    private int[][] data;  // Двумерный массив для хранения данных
    private int rows;      // Количество строк
    private int cols;      // Количество столбцов

    // Конструктор
    public Table(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.data = new int[rows][cols];
        // Таблица автоматически заполняется нулями (по умолчанию в Java)
    }

    // Получить значение из ячейки
    public int getValue(int row, int col) {
        if (row >= 0 && row < rows && col >= 0 && col < cols) {
            return data[row][col];
        } else {
            System.out.println("Ошибка: неверные координаты (" + row + ", " + col + ")");
            return 0;
        }
    }

    // Установить значение в ячейку
    public void setValue(int row, int col, int value) {
        if (row >= 0 && row < rows && col >= 0 && col < cols) {
            data[row][col] = value;
        } else {
            System.out.println("Ошибка: неверные координаты (" + row + ", " + col + ")");
        }
    }

    // Получить количество строк
    public int rows() {
        return rows;
    }

    // Получить количество столбцов
    public int cols() {
        return cols;
    }

    // Среднее арифметическое всех значений
    public double average() {
        int sum = 0;
        int totalCells = rows * cols;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sum += data[i][j];
            }
        }

        return (double) sum / totalCells;
    }

    // Представление таблицы в виде строки
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sb.append(data[i][j]);
                if (j < cols - 1) {
                    sb.append("\t"); // Табуляция между столбцами
                }
            }
            if (i < rows - 1) {
                sb.append("\n"); // Переход на новую строку
            }
        }

        return sb.toString();
    }
}
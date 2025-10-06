import geometry2d.Circle;
import geometry2d.Rectangle;
import geometry3d.Cylinder;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== ЛАБОРАТОРНАЯ РАБОТА ПО JAVA ===");
        System.out.println("Демонстрация всех заданий\n");

        // Задание 1: Button
        System.out.println("1. ТЕСТИРОВАНИЕ КЛАССА BUTTON");
        Button myButton = new Button();
        System.out.print("Нажимаем кнопку 3 раза: ");
        myButton.click();
        myButton.click();
        myButton.click();
        System.out.println();

        // Задание 2: Balance
        System.out.println("2. ТЕСТИРОВАНИЕ КЛАССА BALANCE");
        Balance balance = new Balance();
        balance.addLeft(10);
        balance.addRight(5);
        System.out.print("Левая: 10, Правая: 5 -> ");
        balance.result();

        balance.addRight(5);
        System.out.print("Левая: 10, Правая: 10 -> ");
        balance.result();

        balance.addRight(3);
        System.out.print("Левая: 10, Правая: 13 -> ");
        balance.result();
        System.out.println();

        // Задание 3: Bell
        System.out.println("3. ТЕСТИРОВАНИЕ КЛАССА BELL");
        Bell bell = new Bell();
        System.out.print("Звонок 5 раз: ");
        bell.sound();
        bell.sound();
        bell.sound();
        bell.sound();
        bell.sound();
        System.out.println();

        // Задание 4: OddEvenSeparator
        System.out.println("4. ТЕСТИРОВАНИЕ КЛАССА ODD EVEN SEPARATOR");
        OddEvenSeparator separator = new OddEvenSeparator();
        separator.addNumber(1);
        separator.addNumber(2);
        separator.addNumber(3);
        separator.addNumber(4);
        separator.addNumber(5);
        separator.addNumber(6);
        separator.addNumber(7);
        separator.addNumber(8);
        separator.even();
        separator.odd();
        System.out.println();

        // Задание 5: Table
        System.out.println("5. ТЕСТИРОВАНИЕ КЛАССА TABLE");
        Table table = new Table(3, 4);

        // Заполняем таблицу значениями
        table.setValue(0, 0, 1);
        table.setValue(0, 1, 2);
        table.setValue(0, 2, 3);
        table.setValue(0, 3, 4);
        table.setValue(1, 0, 5);
        table.setValue(1, 1, 6);
        table.setValue(1, 2, 7);
        table.setValue(1, 3, 8);
        table.setValue(2, 0, 9);
        table.setValue(2, 1, 10);
        table.setValue(2, 2, 11);
        table.setValue(2, 3, 12);

        System.out.println("Таблица 3x4:");
        System.out.println(table.toString());
        System.out.println("Среднее арифметическое: " + table.average());
        System.out.println("Размеры: " + table.rows() + " строк, " + table.cols() + " столбцов");
        System.out.println();

        // Задание 6: Geometry фигуры - ПРАВИЛЬНЫЙ ВАРИАНТ
        System.out.println("6. ТЕСТИРОВАНИЕ ГЕОМЕТРИЧЕСКИХ ФИГУР");

        // 2D фигуры
        System.out.println("--- 2D фигуры ---");
        Circle circle = new Circle(3.0);
        Rectangle rectangle = new Rectangle(4.0, 5.0);

        System.out.println("Круг с радиусом 3:");
        System.out.println("  Area: " + circle.area());
        System.out.println("  Perimeter: " + circle.perimeter());

        System.out.println("Прямоугольник 4x5:");
        System.out.println("  Area: " + rectangle.area());
        System.out.println("  Perimeter: " + rectangle.perimeter());

        // 3D фигуры
        System.out.println("\n--- 3D фигуры ---");
        Cylinder cylinder1 = new Cylinder(circle, 7.0);
        System.out.println("Цилиндр (circle base, height 7):");
        System.out.println("  Volume: " + cylinder1.volume());

        Cylinder cylinder2 = new Cylinder(rectangle, 6.0);
        System.out.println("Цилиндр (rectangle base, height 6):");
        System.out.println("  Volume: " + cylinder2.volume());

        // Задание 7: FileAnalyzer
        System.out.println("\n7. FILE ANALYZER");

        // Создаем тестовый файл
        createTestFile();

        // Анализируем файл
        FileAnalyzer fileAnalyzer = new FileAnalyzer();
        fileAnalyzer.analyze("test.txt");

        // Пытаемся анализировать несуществующий файл
        System.out.println("\nПопытка открыть несуществующий файл:");
        fileAnalyzer.analyze("non_existent_file.txt");
    }

    // Метод для создания тестового файла
    private static void createTestFile() {
        try {

            try (java.io.FileWriter writer = new java.io.FileWriter("test.txt")) {
                writer.write("Это тестовый файл.\n");
                writer.write("Для проверки работы FileAnalyzer.");
            }
            System.out.println("Создан тестовый файл 'test.txt'");
        } catch (Exception e) {
            System.out.println("Ошибка создания файла: " + e.getMessage());
        }

        // Задание 8: StudentGrades
        System.out.println("\n8. STUDENT GRADES");

        // Создаем тестовый файл с оценками
        createGradesFile();

        // Анализируем оценки
        StudentGrades grades = new StudentGrades();
        grades.analyze("grades.txt");

        System.out.println("Все студенты и их средние баллы:");
        grades.printAllStudents();

        System.out.println("\nЛучший студент: " + grades.bestStudent());
        System.out.println("Худший студент: " + grades.worstStudent());
        System.out.println("Всего студентов: " + grades.getStudentCount());
    }

        private static void createGradesFile() {
            try {

                try (java.io.FileWriter writer = new java.io.FileWriter("grades.txt")) {

                    writer.write("Иванов 5 4 3 5\n");
                    writer.write("Петров 4 4 4\n");
                    writer.write("Сидоров 5 5 5 5\n");
                    writer.write("Кузнецова 3 4 4 5 4\n");
                    writer.write("Смирнов 2 3 4 3\n");
                    writer.close();
                }

                System.out.println("Создан файл с оценками 'grades.txt'");
            } catch (Exception e) {
                System.out.println("Ошибка создания файла с оценками: " + e.getMessage());
            }
    }
}
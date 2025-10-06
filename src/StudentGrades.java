import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class StudentGrades {

    // Внутренний класс для хранения информации о студенте
    private static class Student {
        String name;
        double averageGrade;

        Student(String name, double averageGrade) {
            this.name = name;
            this.averageGrade = averageGrade;
        }
    }

    private List<Student> students;

    public StudentGrades() {
        students = new ArrayList<>();
    }

    /*
     * Анализирует файл с оценками студентов
     */
    public void analyze(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;

            while ((line = reader.readLine()) != null) {
                // Разбиваем строку на части
                String[] parts = line.split(" ");

                if (parts.length > 1) {
                    String name = parts[0];
                    int sum = 0;

                    // Суммируем оценки (начиная со второго элемента)
                    for (int i = 1; i < parts.length; i++) {
                        sum += Integer.parseInt(parts[i]);
                    }

                    // Вычисляем средний балл
                    double average = (double) sum / (parts.length - 1);

                    // Добавляем студента в список
                    students.add(new Student(name, average));
                }
            }

        } catch (Exception e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }

    /*
     * Выводит всех студентов и их средние баллы
     */
    public void printAllStudents() {
        for (Student student : students) {
            System.out.printf("%s: %.2f\n", student.name, student.averageGrade);
        }
    }

    /*
     * Возвращает имя студента с наивысшим средним баллом
     */
    public String bestStudent() {
        if (students.isEmpty()) {
            return "Нет данных";
        }

        Student best = students.get(0);
        for (Student student : students) {
            if (student.averageGrade > best.averageGrade) {
                best = student;
            }
        }
        return best.name;
    }

    /*
     * Возвращает имя студента с наименьшим средним баллом
     */
    public String worstStudent() {
        if (students.isEmpty()) {
            return "Нет данных";
        }

        Student worst = students.get(0);
        for (Student student : students) {
            if (student.averageGrade < worst.averageGrade) {
                worst = student;
            }
        }
        return worst.name;
    }

    /*
     * Возвращает количество студентов
     */
    public int getStudentCount() {
        return students.size();
    }
}
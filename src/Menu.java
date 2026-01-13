import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("\n" + "1. Задание 1 " );
            System.out.print("\n" + "2. Задание 2 ");
            System.out.print("\n" + "0. Выход ");
            System.out.print("\n" + "Введите номер задания (1-2) или 0 для выхода: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 0:
                    return;
                case 1:
                    System.out.println("\n" + "=== Задание 1 ===");
                    Invoker.invokeAnnotatedMethods();
                    break;
                case 2:
                    System.out.println("\n" + "=== Задание 2 ===");
                    FileSystemTask.run();
                    break;
                default:
                    System.out.println("\n" + "Неверный ввод");
            }
        }
    }
}
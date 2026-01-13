import java.util.Scanner;

public class Menu {

    public static void runLabMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n" + "=".repeat(50));
            System.out.println("        ЛАБОРАТОРНАЯ РАБОТА 4 - МЕНЮ");
            System.out.println("=".repeat(50));
            System.out.println("1. Задание 1 - Список посетителей и их количество");
            System.out.println("2. Задание 2 - Уникальные книги (без повторений)");
            System.out.println("3. Задание 3 - Книги по году издания");
            System.out.println("4. Задание 4 - Поиск книг Джейн Остин");
            System.out.println("5. Задание 5 - Максимальное число книг у посетителя");
            System.out.println("6. Задание 6 - Генерация SMS сообщений");
            System.out.println("7. Запустить все задания последовательно");
            System.out.println("0. Назад в главное меню");
            System.out.println("-".repeat(50));
            System.out.print("Выберите задание: ");

            choice = scanner.nextInt();

            switch(choice) {
                case 1:
                    System.out.println("\n--- ЗАДАНИЕ 1 ---");
                    VisitorsList.execute();
                    break;
                case 2:
                    System.out.println("\n--- ЗАДАНИЕ 2 ---");
                    UniqueBooks.execute();
                    break;
                case 3:
                    System.out.println("\n--- ЗАДАНИЕ 3 ---");
                    BooksByYear.execute();
                    break;
                case 4:
                    System.out.println("\n--- ЗАДАНИЕ 4 ---");
                    JaneAustenBooks.execute();
                    break;
                case 5:
                    System.out.println("\n--- ЗАДАНИЕ 5 ---");
                    MaxBooksPerVisitor.execute();
                    break;
                case 6:
                    System.out.println("\n--- ЗАДАНИЕ 6 ---");
                    SmsMessage.execute();
                    break;
                case 7:
                    runAllTasks();
                    break;
                case 0:
                    System.out.println("Возврат в главное меню...");
                    break;
                default:
                    System.out.println("Неверный выбор! Попробуйте снова.");
            }

            if (choice != 0 && choice != 7) {
                System.out.println("\nНажмите Enter чтобы продолжить...");
                scanner.nextLine();
                scanner.nextLine();
            }

        } while(choice != 0);
    }

    private static void runAllTasks() {
        System.out.println("\n--- ЗАПУСК ВСЕХ ЗАДАНИЙ ПОСЛЕДОВАТЕЛЬНО ---");

        try {
            VisitorsList.execute();
            Thread.sleep(1000);

            UniqueBooks.execute();
            Thread.sleep(1000);

            BooksByYear.execute();
            Thread.sleep(1000);

            JaneAustenBooks.execute();
            Thread.sleep(1000);

            MaxBooksPerVisitor.execute();
            Thread.sleep(1000);

            SmsMessage.execute();

            System.out.println("\n--- ВСЕ ЗАДАНИЯ УСПЕШНО ВЫПОЛНЕНЫ! ---");

        } catch (InterruptedException e) {
            System.out.println("Ошибка при выполнении заданий: " + e.getMessage());
        }
    }
}
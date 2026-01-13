import java.nio.file.*;
import java.io.IOException;
import java.util.Comparator;

public class FileSystemTask {
    private static final String SURNAME = "Ivanov";
    private static final String NAME = "Ivan";

    public static void run() {
        try {
            // 1. Создаем основную директорию
            Path mainDir = Paths.get(SURNAME);
            Files.createDirectories(mainDir);
            System.out.println("Создана директория: " + mainDir.toAbsolutePath());

            // 2. Создаем файл с именем
            Path nameFile = mainDir.resolve(NAME + ".txt");
            Files.createFile(nameFile);
            System.out.println("Создан файл: " + nameFile.getFileName());

            // 3. Создаем вложенные директории и копируем файл
            Path nestedDir = mainDir.resolve("dir1/dir2/dir3");
            Files.createDirectories(nestedDir);
            Path copiedFile = nestedDir.resolve(NAME + ".txt");
            Files.copy(nameFile, copiedFile, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Файл скопирован в: " + copiedFile);

            // 4. Создаем file1 в dir1
            Path file1 = mainDir.resolve("dir1/file1.txt");
            Files.createFile(file1);
            System.out.println("Создан файл: " + file1.getFileName());

            // 5. Создаем file2 в dir2
            Path file2 = mainDir.resolve("dir1/dir2/file2.txt");
            Files.createFile(file2);
            System.out.println("Создан файл: " + file2.getFileName());

            // 6. Рекурсивный обход и вывод структуры
            System.out.println("\nСтруктура директории " + SURNAME + ":");
            printDirectoryTree(mainDir);

            // 7. Удаляем dir1 со всем содержимым
            Path dir1 = mainDir.resolve("dir1");
            deleteDirectoryRecursively(dir1);
            System.out.println("Директория dir1 удалена");

            // Финальная структура
            System.out.println("\nФинальная структура:");
            printDirectoryTree(mainDir);

        } catch (IOException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    private static void printDirectoryTree(Path startDir) throws IOException {
        Files.walk(startDir)
                .sorted()
                .forEach(path -> {
                    String prefix = Files.isDirectory(path) ? "D: " : "F: ";
                    String indent = "  ".repeat(
                            Math.max(0, path.getNameCount() - startDir.getNameCount())
                    );
                    System.out.println(indent + prefix + path.getFileName());
                });
    }

    private static void deleteDirectoryRecursively(Path dir) throws IOException {
        if (Files.exists(dir)) {
            Files.walk(dir)
                    .sorted(Comparator.reverseOrder())
                    .forEach(path -> {
                        try {
                            Files.delete(path);
                            System.out.println("Удален: " + path);
                        } catch (IOException e) {
                            System.out.println("Не удалось удалить: " + path);
                        }
                    });
        }
    }
}
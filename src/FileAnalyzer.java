import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileAnalyzer {

    public void analyze(String filename) {
        int lines = 0;
        int words = 0;
        int chars = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;

            while ((line = reader.readLine()) != null) {
                lines++;

                // Считаем слова
                String[] wordArray = line.split(" ");
                for (String word : wordArray) {
                    if (!word.isEmpty()) {
                        words++;
                    }
                }

                // Считаем символы (без пробелов)
                for (char c : line.toCharArray()) {
                    if (c != ' ') {
                        chars++;
                    }
                }
            }

            // Выводим результаты
            System.out.println("Строк: " + lines);
            System.out.println("Слов: " + words);
            System.out.println("Символов: " + chars);

        } catch (IOException e) {
            System.out.println("Файл не найден!");
        }
    }
}
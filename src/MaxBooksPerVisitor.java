import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

public class MaxBooksPerVisitor {
    public static void execute() {
        try {
            Gson gson = new Gson();
            FileReader reader = new FileReader("books.json");
            Type visitorListType = new TypeToken<List<Visitor>>(){}.getType();
            List<Visitor> visitors = gson.fromJson(reader, visitorListType);

            System.out.println("МАКСИМАЛЬНОЕ ЧИСЛО КНИГ У ОДНОГО ПОСЕТИТЕЛЯ\n");

            Optional<Visitor> visitorWithMaxBooks = visitors.stream()
                    .reduce((v1, v2) ->
                            v1.getFavoriteBooks().size() > v2.getFavoriteBooks().size() ? v1 : v2);

            if (visitorWithMaxBooks.isPresent()) {
                Visitor maxVisitor = visitorWithMaxBooks.get();
                int maxBookCount = maxVisitor.getFavoriteBooks().size();

                System.out.println(" РЕКОРДСМЕН ПО КОЛИЧЕСТВУ КНИГ:");
                System.out.printf(" %s %s%n", maxVisitor.getName(), maxVisitor.getSurname());
                System.out.printf(" Количество книг: %d%n", maxBookCount);

                System.out.println("\n СПИСОК КНИГ:");
                maxVisitor.getFavoriteBooks().forEach(book ->
                        System.out.printf("   • \"%s\" - %s%n", book.getName(), book.getAuthor())
                );
            } else {
                System.out.println(" Посетители не найдены");
            }

        } catch (Exception e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }
}
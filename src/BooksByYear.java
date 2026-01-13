import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.List;
import java.util.stream.Collectors;

public class BooksByYear {
    public static void execute() {
        try {
            Gson gson = new Gson();
            FileReader reader = new FileReader("books.json");
            Type visitorListType = new TypeToken<List<Visitor>>(){}.getType();
            List<Visitor> visitors = gson.fromJson(reader, visitorListType);

            System.out.println("СПИСОК КНИГ ОТСОРТИРОВАННЫЙ ПО ГОДУ ИЗДАНИЯ:");

            List<Book> sortedBooks = visitors.stream()
                    .flatMap(visitor -> visitor.getFavoriteBooks().stream())
                    .sorted((b1, b2) -> Integer.compare(b1.getPublishingYear(), b2.getPublishingYear()))
                    .collect(Collectors.toList());

            sortedBooks.forEach(book ->
                    System.out.printf("%d: \"%s\" - %s%n",
                            book.getPublishingYear(),
                            book.getName(),
                            book.getAuthor())
            );

            System.out.println("\nВсего книг в списке: " + sortedBooks.size());

        } catch (Exception e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }
}
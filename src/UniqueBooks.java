import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.List;
import java.util.stream.Collectors;

public class UniqueBooks {
    public static void execute() {
        try {
            Gson gson = new Gson();
            FileReader reader = new FileReader("books.json");
            Type visitorListType = new TypeToken<List<Visitor>>(){}.getType();
            List<Visitor> visitors = gson.fromJson(reader, visitorListType);

            System.out.println("СПИСОК УНИКАЛЬНЫХ КНИГ:");

            List<Book> uniqueBooks = visitors.stream()
                    .flatMap(visitor -> visitor.getFavoriteBooks().stream())
                    .collect(Collectors.toMap(
                            book -> book.getIsbn() != null && !book.getIsbn().isEmpty() ?
                                    book.getIsbn() : book.getName() + "|" + book.getAuthor(),
                            book -> book,
                            (existing, replacement) -> existing
                    ))
                    .values()
                    .stream()
                    .collect(Collectors.toList());

            uniqueBooks.stream()
                    .map(book -> String.format("\"%s\" - %s (%d г.)",
                            book.getName(), book.getAuthor(), book.getPublishingYear()))
                    .forEach(System.out::println);

            System.out.println("\nОБЩЕЕ КОЛИЧЕСТВО УНИКАЛЬНЫХ КНИГ: " + uniqueBooks.size());

        } catch (Exception e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }
}
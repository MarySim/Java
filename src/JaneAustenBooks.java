import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.List;
import java.util.stream.Collectors;

public class JaneAustenBooks {
    public static void execute() {
        try {
            Gson gson = new Gson();
            FileReader reader = new FileReader("books.json");
            Type visitorListType = new TypeToken<List<Visitor>>(){}.getType();
            List<Visitor> visitors = gson.fromJson(reader, visitorListType);

            System.out.println("ПОИСК КНИГ ДЖЕЙН ОСТИН У ПОСЕТИТЕЛЕЙ\n");

            List<Visitor> visitorsWithJaneAusten = visitors.stream()
                    .filter(visitor -> visitor.getFavoriteBooks().stream()
                            .anyMatch(book -> "Jane Austen".equalsIgnoreCase(book.getAuthor())))
                    .collect(Collectors.toList());

            if (visitorsWithJaneAusten.isEmpty()) {
                System.out.println(" У посетителей нет книг Джейн Остин");
            } else {
                System.out.println(" Найдены посетители с книгами Джейн Остин:");

                visitorsWithJaneAusten.forEach(visitor -> {
                    System.out.printf("\n %s %s:%n", visitor.getName(), visitor.getSurname());

                    visitor.getFavoriteBooks().stream()
                            .filter(book -> "Jane Austen".equalsIgnoreCase(book.getAuthor()))
                            .forEach(book -> System.out.printf(" \"%s\" (%d г.)%n",
                                    book.getName(), book.getPublishingYear()));
                });
            }

            long totalBooks = visitors.stream()
                    .flatMap(visitor -> visitor.getFavoriteBooks().stream())
                    .filter(book -> "Jane Austen".equalsIgnoreCase(book.getAuthor()))
                    .count();

            System.out.println("\nВсего книг Джейн Остин в библиотеке: " + totalBooks);

        } catch (Exception e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }
}
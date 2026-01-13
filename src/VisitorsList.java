import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.List;

public class VisitorsList {
    public static void execute() {
        try {
            Gson gson = new Gson();
            FileReader reader = new FileReader("books.json");
            Type visitorListType = new TypeToken<List<Visitor>>(){}.getType();
            List<Visitor> visitors = gson.fromJson(reader, visitorListType);

            System.out.println("СПИСОК ПОСЕТИТЕЛЕЙ:");

            visitors.stream()
                    .map(visitor -> visitor.getName() + " " + visitor.getSurname())
                    .forEach(System.out::println);

            long count = visitors.stream().count();
            System.out.println("\nОБЩЕЕ КОЛИЧЕСТВО ПОСЕТИТЕЛЕЙ: " + count);

        } catch (Exception e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }
}
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.List;
import java.util.stream.Collectors;

public class SmsMessagesTask {
    public static void execute() {
        try {
            Gson gson = new Gson();
            FileReader reader = new FileReader("books.json");
            Type visitorListType = new TypeToken<List<Visitor>>(){}.getType();
            List<Visitor> visitors = gson.fromJson(reader, visitorListType);

            System.out.println("ГЕНЕРАЦИЯ SMS-СООБЩЕНИЙ ДЛЯ ПОДПИСЧИКОВ\n");

            double averageBooks = visitors.stream()
                    .mapToInt(visitor -> visitor.getFavoriteBooks().size())
                    .average()
                    .orElse(0);

            System.out.printf(" СРЕДНЕЕ КОЛИЧЕСТВО КНИГ: %.2f%n%n", averageBooks);

            List<SmsMessage> smsMessages = visitors.stream()
                    .filter(Visitor::isSubscribed)
                    .map(visitor -> {
                        int bookCount = visitor.getFavoriteBooks().size();
                        String message;

                        if (bookCount > averageBooks) {
                            message = "you are a bookworm";
                        } else if (bookCount < averageBooks) {
                            message = "read more";
                        } else {
                            message = "fine";
                        }

                        return new SmsMessage(visitor.getPhone(), message);
                    })
                    .collect(Collectors.toList());

            System.out.println(" СПИСОК SMS-СООБЩЕНИЙ:");
            smsMessages.forEach(sms ->
                    System.out.printf(" %s: \"%s\"%n",
                            sms.getPhoneNumber(), sms.getMessage())
            );

            System.out.println("\nВсего сгенерировано SMS: " + smsMessages.size());

        } catch (Exception e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }
}
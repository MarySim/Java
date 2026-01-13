import java.util.List;

public class Visitor {
    private String name;
    private String surname;
    private String phone;
    private List<Book> favoriteBooks;
    private boolean subscribed;

    // Конструкторы
    public Visitor() {}

    public Visitor(String name, String surname, String phone, List<Book> favoriteBooks, boolean subscribed) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.favoriteBooks = favoriteBooks;
        this.subscribed = subscribed;
    }

    // Геттеры
    public String getName() { return name; }
    public String getSurname() { return surname; }
    public String getPhone() { return phone; }
    public List<Book> getFavoriteBooks() { return favoriteBooks; }
    public boolean isSubscribed() { return subscribed; }

    // Сеттеры
    public void setName(String name) { this.name = name; }
    public void setSurname(String surname) { this.surname = surname; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setFavoriteBooks(List<Book> favoriteBooks) { this.favoriteBooks = favoriteBooks; }
    public void setSubscribed(boolean subscribed) { this.subscribed = subscribed; }
}
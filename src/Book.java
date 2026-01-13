public class Book {
    private String name;
    private String author;
    private int publishingYear;
    private String isbn;
    private String publisher;

    // Конструкторы
    public Book() {}

    public Book(String name, String author, int publishingYear, String isbn, String publisher) {
        this.name = name;
        this.author = author;
        this.publishingYear = publishingYear;
        this.isbn = isbn;
        this.publisher = publisher;
    }

    // Геттеры
    public String getName() { return name; }
    public String getAuthor() { return author; }
    public int getPublishingYear() { return publishingYear; }
    public String getIsbn() { return isbn; }
    public String getPublisher() { return publisher; }

    // Сеттеры
    public void setName(String name) { this.name = name; }
    public void setAuthor(String author) { this.author = author; }
    public void setPublishingYear(int publishingYear) { this.publishingYear = publishingYear; }
    public void setIsbn(String isbn) { this.isbn = isbn; }
    public void setPublisher(String publisher) { this.publisher = publisher; }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", publishingYear=" + publishingYear +
                ", isbn='" + isbn + '\'' +
                ", publisher='" + publisher + '\'' +
                '}';
    }
}
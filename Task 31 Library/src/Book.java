public class Book {
    private int id;
    private String isbn;
    private String title;
    private String author;
    private int publishedYear;
    private double price;

    public Book(int id, String isbn, String title, String author, int publishedYear, double price) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publishedYear = publishedYear;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublishedYear() {
        return publishedYear;
    }

    public double getPrice() {
        return price;
    }
}

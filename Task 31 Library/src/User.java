import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private List<Book> books;

    public User(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void borrowBook(Book book) {
        books.remove(book);
    }

    public void donateBook(Book book, Library library) {
        library.addBook(book);
    }
}

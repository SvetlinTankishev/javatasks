import javax.xml.bind.JAXB;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public List<Book> searchBook(String search) {
        List<Book> results = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().contains(search) || book.getAuthor().contains(search)) {
                results.add(book);
            }
        }
        return results;
    }

    public void addBook(Book book) {
        books.add(book);
        saveBooksToXml();
    }

    public void lendBook(Book book, User user) {
        books.remove(book);
        user.borrowBook(book);
        saveBooksToXml();
    }

    public void updateBook(Book oldBook, Book newBook) {
        books.set(books.indexOf(oldBook), newBook);
        saveBooksToXml();
    }

    public void deleteBook(Book book) {
        books.remove(book);
        saveBooksToXml();
    }

    public void loadBooksFromXml() {
        File file = new File("books.xml");
        if (file.exists()) {
            books = JAXB.unmarshal(file, BookList.class).getBooks();
        }
    }

    private void saveBooksToXml() {
        BookList bookList = new BookList(books);
        JAXB.marshal(bookList, new File("books.xml"));
    }
}
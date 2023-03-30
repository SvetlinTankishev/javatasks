public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        library.loadBooksFromXml();

        Book book1 = new Book(1, "978-1-56619-909-4", "Everyday Italian", "Giada De Laurentiis", 2005, 30.00);
        Book book2 = new Book(2, "978-1-4028-9462-6", "Harry Potter", "J K. Rowling", 2005, 29.99);
        library.addBook(book1);
        library.addBook(book2);

        User user1 = new User("Alice");
        User user2 = new User("Bob");

        library.lendBook(book1, user1);

        System.out.println(user1.getName() + " has borrowed the following books:");
        for (Book book : library.searchBook("")) {
            System.out.println(book.getTitle() + " by " + book.getAuthor());
        }

        Book newBook2 = new Book(2, "978-1-4028-9462-6", "Harry Potter", "J K. Rowling", 2005, 39.99);
        library.updateBook(book2, newBook2);

        System.out.println(user1.getName() + " has borrowed the following books:");
        for (Book book : user1.getBooks()) {
            System.out.println(book.getTitle());
        }
        System.out.println(user2.getName() + " has borrowed the following books:");
        for (Book book : user2.getBooks()) {
            System.out.println(book.getTitle());
        }

        Book book3 = new Book(3, "978-0-670-06262-6", "To Kill a Mockingbird", "Harper Lee", 1960, 9.99);
        user1.donateBook(book3, library);

        System.out.println("Books currently in the library:");
        for (Book book : library.searchBook("")) {
            System.out.println(book.getTitle() + " by " + book.getAuthor() + ", $" + book.getPrice());
        }
    }
}
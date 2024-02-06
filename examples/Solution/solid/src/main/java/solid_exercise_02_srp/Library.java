package solid_exercise_02_srp;

import java.util.ArrayList;
import java.util.List;

import augurdb.AugurDatabase;
import solid_exercise_01_starter_kit.Book;
import solid_exercise_01_starter_kit.BookGenre;

public class Library {
	
	private List<Book> books;
    private AugurDatabase database;
    private BookManager bookManager;
    private BookDisplayer bookDisplayer;
    private BookSaver bookSaver;

    public Library(AugurDatabase database) {
    	books = new ArrayList<>();
        this.database = database;
	    books.add(new Book("1", "The Catcher in the Rye", "J.D. Salinger", BookGenre.FICTION));
	    books.add(new Book("2", "To Kill a Mockingbird", "Harper Lee", BookGenre.FICTION));
	    books.add(new Book("3", "Pride and Prejudice", "Jane Austen", BookGenre.FICTION));
        bookManager = new BookManager();
        bookDisplayer = new BookDisplayer();
        bookSaver = new BookSaver(bookManager.getBooks());
    }

    public void addBook(Book book) {
        bookManager.addBook(book);
    }

    public void removeBook(Book book) {
        bookManager.removeBook(book);
    }

    public void displayBooks() {
        bookDisplayer.displayBooks(books);
    }

    public void saveBooks() {
        bookSaver.saveBooks(database);
    }
}







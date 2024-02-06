package solid_exercise_03_ocp;

import java.util.ArrayList;
import java.util.List;

import augurdb.AugurDatabase;
import solid_exercise_01_starter_kit.Book;
import solid_exercise_01_starter_kit.BookGenre;
import solid_exercise_02_srp.BookDisplayer;
import solid_exercise_02_srp.BookManager;
import solid_exercise_02_srp.BookSaver;

public class Library {
	private List<Book> books;
	private AugurDatabase database;
    private SortingStrategy sortingStrategy;
    private BookManager bookManager;
    private BookDisplayer bookDisplayer;
    private BookSaver bookSaver;

    public Library(AugurDatabase database, SortingStrategy sortingStrategy) {
    	books = new ArrayList<>();
        this.database = database;
	    books.add(new Book("1", "The Catcher in the Rye", "J.D. Salinger", BookGenre.FICTION));
	    books.add(new Book("2", "To Kill a Mockingbird", "Harper Lee", BookGenre.FICTION));
	    books.add(new Book("3", "Pride and Prejudice", "Jane Austen", BookGenre.FICTION));
        bookManager = new BookManager();
        bookDisplayer = new BookDisplayer();
        bookSaver = new BookSaver(bookManager.getBooks());
		this.sortingStrategy = sortingStrategy;

    }
    
    public void setSortingStrategy(SortingStrategy sortingStrategy) {
    	this.sortingStrategy = sortingStrategy;
    }
    
    public void sortBooks() {
        sortingStrategy.sort(books);
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







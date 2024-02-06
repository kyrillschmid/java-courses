package solid_exercise_01_starter_kit;

import java.util.ArrayList;
import java.util.List;

import augurdb.AugurDatabase;

public class Library {
	
    private List<Book> books;
    private AugurDatabase database;


    public Library(AugurDatabase database) {
        books = new ArrayList<>();
        this.database = database;
	    books.add(new Book("1", "The Catcher in the Rye", "J.D. Salinger", BookGenre.FICTION));
	    books.add(new Book("2", "To Kill a Mockingbird", "Harper Lee", BookGenre.FICTION));
	    books.add(new Book("3", "Pride and Prejudice", "Jane Austen", BookGenre.FICTION));
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public void displayBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void saveBooks() {
        for (Book book : books) {
        	database.startTransaction();
            database.storeField(book.getId(), "Title", book.getTitle());
            database.commitTransaction();
        }
        
    }
}



package solid_exercise_02_srp;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import augurdb.AugurDatabase;
import solid_exercise_01_starter_kit.Book;

public class BookSaver {
    private List<Book> books;
    private AugurDatabase database;

    public BookSaver(List<Book> books) {
        this.books = books;
    }

    public void saveBooks(AugurDatabase database) {
        for (Book book : books) {
        	database.startTransaction();
            database.storeField(book.getId(), "Title", book.getTitle());
            database.commitTransaction();
        }
    }
}
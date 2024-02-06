package solid_exercise_02_srp;

import java.util.ArrayList;
import java.util.List;

import solid_exercise_01_starter_kit.Book;

public class BookManager {
    private List<Book> books;

    public BookManager() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public List<Book> getBooks() {
        return books;
    }
}

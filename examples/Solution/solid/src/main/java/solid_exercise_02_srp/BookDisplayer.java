package solid_exercise_02_srp;

import java.util.List;

import solid_exercise_01_starter_kit.Book;

public class BookDisplayer {
   

    public void displayBooks(List<Book> books) {
        for (Book book : books) {
            System.out.println(book);
        }
    }
}

package solid_exercise_03_ocp;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import solid_exercise_01_starter_kit.Book;

public class SortByAuthorStrategy implements SortingStrategy {
	
    @Override
    public void sort(List<Book> books) {
        Collections.sort(books, Comparator.comparing(Book::getAuthor));
    }
    
}

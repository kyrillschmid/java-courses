package solid_exercise_03_ocp;

import java.util.List;

import solid_exercise_01_starter_kit.Book;

public interface SortingStrategy {
    void sort(List<Book> books);
}

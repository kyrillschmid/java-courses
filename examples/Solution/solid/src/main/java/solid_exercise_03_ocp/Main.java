package solid_exercise_03_ocp;

import augurdb.AugurDatabase;

public class Main {
	
    public static void main(String[] args) {
    	
    	AugurDatabase db = new AugurDatabase();
        Library library = new Library(db, new SortByTitleStrategy());
        library.sortBooks(); // Sortiert Bücher nach Titel
        library.displayBooks();

        library.setSortingStrategy(new SortByAuthorStrategy());
        library.sortBooks(); // Sortiert Bücher nach Preis
        library.displayBooks();
        
    }
}

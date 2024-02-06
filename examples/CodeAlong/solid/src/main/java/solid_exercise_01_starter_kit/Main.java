package solid_exercise_01_starter_kit;

import augurdb.AugurDatabase;

public class Main {
	
    public static void main(String[] args) {
    	
    	AugurDatabase db = new AugurDatabase();
        Library library = new Library(db);
        library.displayBooks();
        
        library.saveBooks();
        System.out.println(db.records.toString());
        
    }
}

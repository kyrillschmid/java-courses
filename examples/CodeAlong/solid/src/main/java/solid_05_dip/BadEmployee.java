package solid_05_dip;

import augurdb.AugurDatabase;

public class BadEmployee {
    private int id;
    private String name;
    private AugurDatabase database;

    public BadEmployee(int id, String name, AugurDatabase database) {
        this.id = id;
        this.name = name;
        this.database = database;
    }

    public void save() {
        database.startTransaction();
        database.storeField(Integer.toString(id), "name", name);
        database.commitTransaction();
    }
    
    
    public static void main(String[] args) {
    	
    	AugurDatabase db = new AugurDatabase();
        BadEmployee be = new BadEmployee(123, "Joe", db);
        
        be.save();
    }
    
}

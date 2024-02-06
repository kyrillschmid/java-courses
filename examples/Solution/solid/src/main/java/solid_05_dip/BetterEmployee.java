package solid_05_dip;

import java.lang.String;

public class BetterEmployee {
    private int id;
	private String name;
    private DatabaseInterface database;

    public BetterEmployee(int id, String name, DatabaseInterface database) {
        this.id = id;
        this.name = name;
        this.database = database;
    }

    public void save() {
        database.save(this);
    }
    
    public int getId() {
		return id;
	}
    
    public String getName() {
		return name;
	}

    public void setDatabase(DatabaseInterface database) {
        this.database = database;
    }
}


package solid_05_dip;

import augurdb.AugurDatabase;

public class AugurDatabaseInterface implements DatabaseInterface {
    private AugurDatabase database;

    public AugurDatabaseInterface() {
        this.database = new AugurDatabase();
    }

    public AugurDatabaseInterface(AugurDatabase database) {
        this.database = database;
    }

    @Override
    public void save(BetterEmployee e) {
        database.startTransaction();
        database.storeField(Integer.toString(e.getId()), "name", e.getName());
        database.commitTransaction();
    }

    // Getter and Setter methods
    public AugurDatabase getDatabase() {
        return database;
    }

    public void setDatabase(AugurDatabase database) {
        this.database = database;
    }
}


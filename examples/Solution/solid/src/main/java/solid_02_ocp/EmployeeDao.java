package solid_02_ocp;

import augurdb.AugurDatabase;

public class EmployeeDao {
	
    private AugurDatabase database;

    public EmployeeDao(AugurDatabase database) {
        this.database = database;
    }

    
    public void saveEmployee(Employee employee) {
        database.startTransaction();
        database.storeField(Integer.toString(employee.getId()), "name", employee.getName());
        database.storeField(Integer.toString(employee.getId()), "employment", employee.getEmployment());
        database.commitTransaction();
    }
}

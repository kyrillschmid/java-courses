package solid_01_srp;

import augurdb.AugurDatabase;

public class AugurEmployeeDao implements EmployeeDao {
	
    private AugurDatabase database;
    
    public AugurEmployeeDao(AugurDatabase db){
        this.database = db;
    }

    public void saveEmployee(Employee employee) {
        database.startTransaction();
        database.storeField(Integer.toString(employee.id), "name", employee.name);
        database.storeField(Integer.toString(employee.id), "salary", employee.salary);
        database.storeField(Integer.toString(employee.id), "overtime", employee.overtime);
        database.storeField(Integer.toString(employee.id), "employee_type", employee.employeeType);
        database.storeField(Integer.toString(employee.id), "project", employee.project);
        database.commitTransaction();
    }
    
}

public class EmployeeV0 extends Employee {


    public AugurDatabase database;
    
    
    public EmployeeV0(int id, String name, float salary, int overtime, EmployeeType employeeType, Project project, AugurDatabase database) { 
       super(id, name, salary, overtime, employeeType, project);
        this.database = database;
    }
    
    public double calculatePay() {
        if (employeeType == EmployeeType.REGULAR) {
            return salary + 60.0f * overtime;
        } else if (employeeType == EmployeeType.COMMISSIONED) {
            return (float) (project.assets * 0.1);
        } else if (employeeType == EmployeeType.HOURED) {
            return 50.0f * overtime;
        }
        throw new IllegalArgumentException(employeeType + " is not valid.");
    }

    public int reportHours() {
        if (employeeType == EmployeeType.REGULAR) {
            return 40 + overtime;
        } else if (employeeType == EmployeeType.COMMISSIONED) {
            return 40;
        } else if (employeeType == EmployeeType.HOURED) {
            return overtime;
        }
        throw new IllegalArgumentException(employeeType + " is not valid.");
    }

    public void printReport() {
        System.out.println(name + " worked " + reportHours() + " hours.");
    }

    public void saveEmployee() {
        database.startTransaction();
        database.storeField(String.valueOf(id), "name", name);
        database.storeField(String.valueOf(id), "salary", salary);
        database.storeField(String.valueOf(id), "overtime", overtime);
        database.storeField(String.valueOf(id), "employee_type", employeeType);
        database.storeField(String.valueOf(id), "project", project);
        database.commitTransaction();
    }

}
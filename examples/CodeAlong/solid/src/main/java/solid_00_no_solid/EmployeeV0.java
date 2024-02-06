package solid_00_no_solid;

import augurdb.AugurDatabase;
import project.Project;
import utils.EmployeeType;

public class EmployeeV0 {

    private int id;
    private String name;
    private float salary;
    private int overtime;
    private EmployeeType employeeType;
    private Project project;
    private AugurDatabase database;
    
    
	public EmployeeV0(int id, String name, float salary, int overtime, EmployeeType employeeType, Project project, AugurDatabase database) { 
    	this.id = id;
        this.name = name;
        this.salary = salary;
        this.overtime = overtime;
        this.employeeType = employeeType;
        this.project = project;
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
    
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public int getOvertime() {
		return overtime;
	}

	public void setOvertime(int overtime) {
		this.overtime = overtime;
	}

	public EmployeeType getEmployeeType() {
		return employeeType;
	}

	public void setEmployeeType(EmployeeType employeeType) {
		this.employeeType = employeeType;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public AugurDatabase getDatabase() {
		return database;
	}

	public void setDatabase(AugurDatabase database) {
		this.database = database;
	}

}


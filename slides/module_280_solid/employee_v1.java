// %% {{ employee_v1_tags }}
%jars ./AugurDatabase.jar

// %% {{ employee_v1_tags }}
import augurdb.AugurDatabase


// %% {{ employee_v1_tags }}
public abstract class Employee {
    public int id;
    public String name;
    public float salary;
    public int overtime;
    public EmployeeType employeeType;
    public Project project;
    

    public Employee(int id, String name, float salary, int overtime, EmployeeType employeeType, Project project) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.overtime = overtime;
        this.employeeType = employeeType;
        this.project = project;
    }
    
    
    public abstract double calculatePay();
    
    public abstract int reportHours();
    
    public abstract void printReport();
    
    public abstract void saveEmployee();

}

// %% {{ employee_v1_tags }}
public class PaymentCalculator {
    public double calculatePay(Employee employee) {
        EmployeeType employeeType = employee.employeeType;
        if (employeeType == EmployeeType.REGULAR) {
            return employee.salary + 60.0 * employee.overtime;
        } else if (employeeType == EmployeeType.COMMISSIONED) {
            return employee.project.assets * 0.1;
        } else if (employeeType == EmployeeType.HOURED) {
            return 50.0 * employee.overtime;
        }
        throw new IllegalArgumentException(employeeType + " is not valid.");
    }
}


// %% {{ employee_v1_tags }}
public class HourReporter {
    public int reportHours(Employee employee) {
        EmployeeType employeeType = employee.employeeType;
        if (employeeType == EmployeeType.REGULAR) {
            return 40 + employee.overtime;
        } else if (employeeType == EmployeeType.COMMISSIONED) {
            // Commissioned employees always work 40 hours
            return 40;
        } else if (employeeType == EmployeeType.HOURED) {
            // We use overtime for the billed hours
            return employee.overtime;
        }
        throw new IllegalArgumentException(employeeType + " is not valid.");
    }
}


// %% {{ employee_v1_tags }}
public class ReportPrinter {
    public void printReport(Employee employee) {
        System.out.printf("%s worked %d hours.%n", employee.name, employee.reportHours());
    }
}


// %% {{ employee_v1_tags }}
public class EmployeeDao {
    private AugurDatabase database;
    
    public EmployeeDao(AugurDatabase db){
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


// %% {{ employee_v1_tags }}
public class EmployeeV1 extends Employee {

    public PaymentCalculator paymentCalculator;
    public HourReporter hourReporter;
    public ReportPrinter reportPrinter;
    public EmployeeDao dao;
    
    
    public EmployeeV1(int id,
                      String name,
                      float salary,
                      int overtime,
                      EmployeeType employeeType,
                      Project project,
                      PaymentCalculator pc, 
                      HourReporter hr, 
                      ReportPrinter rp, 
                      EmployeeDao ed) {
       super(id, name, salary, overtime, employeeType, project);
       this.paymentCalculator = pc;
       this.hourReporter = hr;
       this.reportPrinter = rp;
       this.dao = ed;
    }

    public double calculatePay() {
        return paymentCalculator.calculatePay(this);
    }

    public int reportHours() {
        return hourReporter.reportHours(this);
    }

    public void printReport() {
        reportPrinter.printReport(this);
    }

    public void saveEmployee() {
        dao.saveEmployee(this);
    }
}



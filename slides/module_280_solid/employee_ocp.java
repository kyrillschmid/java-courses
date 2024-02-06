// %% {{ employee_ocp_tags }}
public abstract class Employment {
    abstract double calculatePay();
    abstract int reportHours();
}

// %% {{ employee_ocp_tags }}
public class RegularEmployment extends Employment {
    private double salary;
    private int overtime;

    public RegularEmployment(double salary, int overtime) {
        this.salary = salary;
        this.overtime = overtime;
    }

    @Override
    double calculatePay() {
        return salary + 60.0 * overtime;
    }

    @Override
    int reportHours() {
        return 40 + overtime;
    }
}

// %% {{ employee_ocp_tags }}
public class CommissionedEmployment extends Employment {
    private Project project;

    public CommissionedEmployment(Project project) {
        this.project = project;
    }

    @Override
    double calculatePay() {
        return project.getAssets() * 0.1;
    }

    @Override
    int reportHours() {
        return 40;
    }
}

// %% {{ employee_ocp_tags }}
public class HouredEmployment extends Employment {
    private int billableHours;

    public HouredEmployment(int billableHours) {
        this.billableHours = billableHours;
    }

    @Override
    double calculatePay() {
        return 50.0 * billableHours;
    }

    @Override
    int reportHours() {
        return billableHours;
    }
}

// %% {{ employee_ocp_tags }}
public abstract class ReportPrinter {
    public abstract void printReport(Employee employee);
}

// %% {{ employee_ocp_tags }}
public class SimpleReportPrinter extends ReportPrinter {
    @Override
    public void printReport(Employee employee) {
        System.out.printf("%s worked %d hours.%n", employee.getName(), employee.reportHours());
    }
}

// %% {{ employee_ocp_tags }}
public abstract class DatabaseAdapter {
    public abstract void saveEmployee(Employee employee);
}

// %% {{ employee_ocp_tags }}
public class AugurDbAdapter extends DatabaseAdapter {
    private AugurDatabase database;

    public AugurDbAdapter(AugurDatabase database) {
        this.database = database;
    }

    @Override
    public void saveEmployee(Employee employee) {
        database.startTransaction();
        database.storeField(Integer.toString(employee.getId()), "name", employee.getName());
        database.storeField(Integer.toString(employee.getId()), "employment", employee.getEmployment());
        database.commitTransaction();
    }
}

// %% {{ employee_ocp_tags }}
public class EmployeeOcp {
    private int id;
    private String name;
    private Employment employment;
    private ReportPrinter reportPrinter;
    private DatabaseAdapter dao;

    public EmployeeOcp(int id, String name, Employment employment, ReportPrinter reportPrinter, DatabaseAdapter dao) {
        this.id = id;
        this.name = name;
        this.employment = employment;
        this.reportPrinter = reportPrinter;
        this.dao = dao;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Employment getEmployment() {
        return employment;
    }

    public double calculatePay() {
        return employment.calculatePay();
    }

    public int reportHours() {
        return employment.reportHours();
    }

    public void printReport() {
        reportPrinter.printReport(this);
    }

    public void saveEmployee() {
        dao.saveEmployee(this);
    }
}

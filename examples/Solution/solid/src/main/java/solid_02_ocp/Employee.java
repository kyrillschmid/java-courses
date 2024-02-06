package solid_02_ocp;

public class Employee {
    private int id;
    private String name;
    private Employment employment;
    private ReportPrinter reportPrinter;
    private EmployeeDao dao;

    public Employee(int id, String name, Employment employment, ReportPrinter reportPrinter, EmployeeDao dao) {
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

package solid_01_srp;

import project.Project;
import utils.EmployeeType;

public class Employee {

    public int id;
    public String name;
    public float salary;
    public int overtime;
    public EmployeeType employeeType;
    public Project project;
    public PaymentCalculator paymentCalculator;
    public HourReporter hourReporter;
    public ReportPrinter reportPrinter;
    public EmployeeDao dao;
    
    
    public Employee(int id,
                      String name,
                      float salary,
                      int overtime,
                      EmployeeType employeeType,
                      Project project,
                      PaymentCalculator pc, 
                      HourReporter hr, 
                      ReportPrinter rp, 
                      EmployeeDao ed) {
    	this.id = id;
        this.name = name;
        this.salary = salary;
        this.overtime = overtime;
        this.employeeType = employeeType;
        this.project = project;
        this.paymentCalculator = pc;
        this.hourReporter = hr;
        this.reportPrinter = rp;
        this.dao = ed;
    }

    public double calculatePay() {
        return paymentCalculator.calculatePay(this);
    }

    public int reportHours() {
        return hourReporter.report(this);
    }

    public void printReport() {
        reportPrinter.printReport(this);
    }

    public void saveEmployee() {
        dao.saveEmployee(this);
    }
}




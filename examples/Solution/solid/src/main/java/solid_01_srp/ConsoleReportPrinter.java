package solid_01_srp;

public class ConsoleReportPrinter implements ReportPrinter {
	
    public void printReport(Employee employee) {
        System.out.printf("%s worked %d hours.%n", employee.name, employee.reportHours());
    }
    
}

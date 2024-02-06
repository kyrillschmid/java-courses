package solid_02_ocp;

public class ReportPrinter {
	
	public void printReport(Employee employee) {
        System.out.printf("%s worked %d hours.%n", employee.getName(), employee.reportHours());
    }
    
}

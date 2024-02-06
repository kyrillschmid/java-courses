package solid_01_srp;

import java.util.ArrayList;
import java.util.List;

import augurdb.AugurDatabase;
import project.Project;
import utils.EmployeeType;

public class Main {
	
	public static void main(String[] args) {
		
		Project p1 = new Project("Project 1", 10_000);
		Project p2 = new Project("Project 2", 12_000);
		
		AugurDatabase db = new AugurDatabase();
		
		PaymentCalculator defaultPaymentCalculator = new PaymentCalculator();
		HourReporter defaultHourReporter = new HourReporter();
		ConsoleReportPrinter defaultReportPrinter = new ConsoleReportPrinter();
		AugurEmployeeDao defaultEmployeeDao = new AugurEmployeeDao(db);
		
		
		Employee e1 = new Employee(
			    123,
			    "Joe Random",
			    1000,
			    5,
			    EmployeeType.REGULAR,
			    p1,
			    defaultPaymentCalculator,
			    defaultHourReporter,
			    defaultReportPrinter,
			    defaultEmployeeDao
			);
		
		Employee e2 = new Employee(
			    124,
			    "Jane Ransom",
			    1500,
			    43,
			    EmployeeType.HOURED,
			    p1,
			    defaultPaymentCalculator,
			    defaultHourReporter,
			    defaultReportPrinter,
			    defaultEmployeeDao
			);
		
		Employee e3 = new Employee(
			    125,
			    "Jill Chance",
			    2500,
			    2,
			    EmployeeType.COMMISSIONED,
			    p2,
			    defaultPaymentCalculator,
			    defaultHourReporter,
			    defaultReportPrinter,
			    defaultEmployeeDao
			);

		List<Employee> employees = new ArrayList<>();
		employees.add(e1);
		employees.add(e2);
		employees.add(e3);
		
		for (Employee e : employees) {
		    System.out.println("=".repeat(35));
		    System.out.printf("%s has a salary of %.2f%n", e.name, e.calculatePay());
		    e.printReport();
		    e.saveEmployee();
		}
		System.out.println("=".repeat(35));
		
		System.out.println(db.records.toString());
	
		
	}
}

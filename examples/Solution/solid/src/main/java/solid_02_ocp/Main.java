package solid_02_ocp;

import java.util.ArrayList;
import java.util.List;

import augurdb.AugurDatabase;
import project.Project;

public class Main {
	
	public static void main(String[] args) {
		
		Project p1 = new Project("Project 1", 10000.0);
		Project p2 = new Project("Project 2", 12000.0);

		AugurDatabase db = new AugurDatabase();


		ReportPrinter defaultReportPrinter = new ReportPrinter();
		EmployeeDao defaultEmployeeDao = new EmployeeDao(db);

		
		Employee e1 = new Employee(
		        123,
		        "Joe Random",
		        new RegularEmployment(1000.0, 5),
		        defaultReportPrinter,
		        defaultEmployeeDao
		);

		
		Employee e2 = new Employee(
		        124,
		        "Jane Ransom",
		        new HouredEmployment(43),
		        defaultReportPrinter,
		        defaultEmployeeDao
		);

		
		Employee e3 = new Employee(
		        125,
		        "Jill Chance",
		        new CommissionedEmployment(p2),
		        defaultReportPrinter,
		        defaultEmployeeDao
		);

		
		List<Employee> employees = new ArrayList<>();
		employees.add(e1);
		employees.add(e2);
		employees.add(e3);

		
		for (Employee e : employees) {
		    System.out.println("=".repeat(35));
		    System.out.printf("%s has a salary of %.2f%n", e.getName(), e.calculatePay());
		    e.printReport();
		    e.saveEmployee();
		}
		System.out.println("=".repeat(35));

	
		System.out.println(db.records.toString());
	}

}

package solid_00_no_solid;

import java.util.ArrayList;
import java.util.List;

import augurdb.AugurDatabase;
import project.Project;
import utils.EmployeeType;

public class Main {
	
	public static void main(String[] args) {
		Project p1 = new Project("Project 1", 10000);
		Project p2 = new Project("Project 2", 12000);
		
		AugurDatabase db = new AugurDatabase();
		
		EmployeeV0 e1 = new EmployeeV0(
			    123,
			    "Joe Random",
			    1000,
			    5,
			    EmployeeType.REGULAR,
			    p1,
			    db
			);
		
		EmployeeV0 e2 = new EmployeeV0(
			    124,
			    "Jane Ransom",
			    1500,
			    43,
			    EmployeeType.HOURED,
			    p1,
			    db
			);
		
		EmployeeV0 e3 = new EmployeeV0(
			    125,
			    "Jill Chance",
			    2500,
			    2,
			    EmployeeType.COMMISSIONED,
			    p2,
			    db
			);
		
		List<EmployeeV0> employees = new ArrayList<>();
		employees.add(e1);
		employees.add(e2);
		employees.add(e3);
		
		for (EmployeeV0 e : employees) {
		    System.out.println("==================================");
		    System.out.printf("%s has a salary of %.2f%n", e.getName(), e.calculatePay());
		    e.printReport();
		    e.saveEmployee();
		}
		System.out.println("==================================");
		
		System.out.println(db.records.toString());
		
	}

}

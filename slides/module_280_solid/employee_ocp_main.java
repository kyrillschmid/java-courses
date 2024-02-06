// %% {{ employee_ocp_tags }}
Project p1 = new Project("Project 1", 10000.0);
Project p2 = new Project("Project 2", 12000.0);

// %% {{ employee_ocp_tags }}
AugurDatabase db = new AugurDatabase();

// %% {{ employee_ocp_tags }}
ReportPrinter defaultReportPrinter = new SimpleReportPrinter();
DatabaseAdapter defaultEmployeeDao = new AugurDbAdapter(db);

// %% {{ employee_ocp_tags }}
EmployeeOcp e1 = new EmployeeOcp(
        123,
        "Joe Random",
        new RegularEmployment(1000.0, 5),
        defaultReportPrinter,
        defaultEmployeeDao
);

// %% {{ employee_ocp_tags }}
EmployeeOcp e2 = new EmployeeOcp(
        124,
        "Jane Ransom",
        new HouredEmployment(43),
        defaultReportPrinter,
        defaultEmployeeDao
);

// %% {{ employee_ocp_tags }}
EmployeeOcp e3 = new EmployeeOcp(
        125,
        "Jill Chance",
        new CommissionedEmployment(p2),
        defaultReportPrinter,
        defaultEmployeeDao
);

// %% {{ employee_ocp_tags }}
List<EmployeeOcp> employees = new ArrayList<>();
employees.add(e1);
employees.add(e2);
employees.add(e3);

// %% {{ employee_ocp_tags }}
for (EmployeeOcp e : employees) {
    System.out.println("=".repeat(35));
    System.out.printf("%s has a salary of %.2f%n", e.getName(), e.calculatePay());
    e.printReport();
    e.saveEmployee();
}
System.out.println("=".repeat(35));

// %% {{ employee_ocp_tags }}
System.out.println(db.getRecords());

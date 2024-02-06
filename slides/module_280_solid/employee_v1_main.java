
// %% {{ employee_v1_tags }}
Project p1 = new Project("Project 1", 10_000);
Project p2 = new Project("Project 2", 12_000);

// %% {{ employee_v1_tags }}
AugurDatabase db = new AugurDatabase();

// %% {{ employee_v1_tags }}
PaymentCalculator defaultPaymentCalculator = new PaymentCalculator();
HourReporter defaultHourReporter = new HourReporter();
ReportPrinter defaultReportPrinter = new ReportPrinter();
EmployeeDao defaultEmployeeDao = new EmployeeDao(db);

// %% {{ employee_v1_tags }}
EmployeeV1 e1 = new EmployeeV1(
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

// %% {{ employee_v1_tags }}
EmployeeV1 e2 = new EmployeeV1(
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

// %% {{ employee_v1_tags }}
EmployeeV1 e3 = new EmployeeV1(
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



// %% {{ employee_v1_tags }}
List<EmployeeV1> employees = new ArrayList<>();
employees.add(e1);
employees.add(e2);
employees.add(e3);

// %% {{ employee_v1_tags }}
for (EmployeeV1 e : employees) {
    System.out.println("=".repeat(35));
    System.out.printf("%s has a salary of %.2f%n", e.name, e.calculatePay());
    e.printReport();
    e.saveEmployee();
}
System.out.println("=".repeat(35));

// %% {{ employee_v1_tags }}
System.out.println(db.records.toString());


// %%  
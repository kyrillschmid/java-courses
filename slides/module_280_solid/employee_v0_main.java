// %% tags=["keep"]
Project p1 = new Project("Project 1", 10000);
Project p2 = new Project("Project 2", 12000);

// %% tags=["keep"]
AugurDatabase db = new AugurDatabase();

// %% tags=["keep"]
EmployeeV0 e1 = new EmployeeV0(
    123,
    "Joe Random",
    1000,
    5,
    EmployeeType.REGULAR,
    p1,
    db
);

// %% tags=["keep"]
EmployeeV0 e2 = new EmployeeV0(
    124,
    "Jane Ransom",
    1500,
    43,
    EmployeeType.HOURED,
    p1,
    db
);

// %% tags=["keep"]
EmployeeV0 e3 = new EmployeeV0(
    125,
    "Jill Chance",
    2500,
    2,
    EmployeeType.COMMISSIONED,
    p2,
    db
);

// %% tags=["keep"]
List<EmployeeV0> employees = new ArrayList<>();
employees.add(e1);
employees.add(e2);
employees.add(e3);

// %% tags=["keep"]
for (EmployeeV0 e : employees) {
    System.out.println("==================================");
    System.out.printf("%s has a salary of %.2f%n", e.name, e.calculatePay());
    e.printReport();
    e.saveEmployee();
}
System.out.println("==================================");

// %% tags=["keep"]
System.out.println(db.records.toString());

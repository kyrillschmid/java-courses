public abstract class Employee {
    public int id;
    public String name;
    public float salary;
    public int overtime;
    public EmployeeType employeeType;
    public Project project;
    

    public Employee(int id, String name, float salary, int overtime, EmployeeType employeeType, Project project) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.overtime = overtime;
        this.employeeType = employeeType;
        this.project = project;
    }
    
    
    public abstract double calculatePay();
    
    public abstract int reportHours();
    
    public abstract void printReport();
    
    public abstract void saveEmployee();

}
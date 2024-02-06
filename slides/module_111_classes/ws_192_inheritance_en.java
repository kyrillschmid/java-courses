// %% tags=["subslide"]
public class Employee {
    String name;
    String id;
    double baseSalary;

    Employee(String name, String id, double baseSalary) {
        this.name = name;
        this.id = id;
        this.baseSalary = baseSalary;
    }

    double salary() {
        return 13.0 / 12.0 * baseSalary;
    }
}

// %% 
public class Worker extends Employee {
    double overtime = 0.0;
    double hourlyWage = 0.0;
    
    Worker(String name, String id, double baseSalary, double overtime, double hourlyWage) {
        super(name, id, baseSalary);
        this.overtime = overtime;
        this.hourlyWage = hourlyWage;
    }
    
    double salary() {
        return super.salary() + this.overtime * this.hourlyWage;
    }
}

// %% 
public class Manager extends Employee {
    double bonus;

    Manager(String name, String id, double baseSalary, double bonus) {
        super(name, id, baseSalary);
        this.bonus = bonus;
    }

    double salary() {
        return super.salary() + this.bonus;
    }
}

// %% [markdown]
// Create a worker named Hans, personnel number 123, a base salary of
// 36000.0 Euros, who worked 3.5 hours of overtime at 40.0 euros each.
// Print out the salary.

// %%
Worker a = new Worker("Hans", "123", 36000.0, 3.5, 40.0);
System.out.println(a.salary());

// %% [markdown]
// Assert statements to test the functionality of the class `Worker`.

// %%
a.name.equals("Hans");
a.id.equals("123");
a.baseSalary == 36000.0;
a.overtime == 3.5;
a.hourlyWage == 40.0;
a.salary() == 39140.0;

// %% [markdown] lang="en"
// Create a manager named Sepp, personnel number 834, who is a
// base salary of 60000.0 euros and a bonus of 30000.0 euros. Print out
// the salary.

// %%
Manager m = new Manager("Sepp", "834", 60000.0, 30000.0);
System.out.println(m.salary());

// %% [markdown] lang="en"
// Test the functionality of the class `Manager`.

// %%
m.salary() == 95000.0;



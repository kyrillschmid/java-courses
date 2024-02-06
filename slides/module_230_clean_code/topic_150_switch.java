// j2 from 'macros.j2' import header
// {{ header("Ersetzen von Switch-Case Ausdrücken", "Replacing Switch-Case Expressions") }}

// %% [markdown] lang="de" tags=["slide"]
//
// ## Switch-Anweisungen und Abstraktion
//
// Switch-Anweisungen führen oft Operationen auf der gleichen Abstraktionsebene aus.
// (für "Subtypen" anstelle des ursprünglichen Typs).
//
// "Subtypen" werden oft durch Typ-Tags unterschieden.

// %% [markdown] lang="en" tags=["slide"]
//
// ## Switches and abstraction
//
// Switch statements often perform operations on the same level of abstraction
// (for “subtypes” instead of the original type).
//
// “Subtypes” are often distinguished by type tags

// %% tags=["subslide", "keep"]
public enum EmployeeType {
    COMMISSIONED,
    HOURLY,
    SALARIED
}

// %% tags=["keep"]
public class Money {
    private final double amountInEuros;

    public Money(double amountInEuros) {
        this.amountInEuros = amountInEuros;
    }

    public Money add(Money other) {
        return new Money(this.amountInEuros + other.amountInEuros);
    }
    
    public double getAmountInEuros(){
        return this.amountInEuros;
    }
}

// %% tags=["keep"]
System.out.println(new Money(100.0).add(new Money(50.0)).getAmountInEuros());


// %% tags=["keep"]
public class EmployeeV1 {
    private final EmployeeType type;
    
    public EmployeeV1(EmployeeType type){
        this.type = type;
    }
    
    public EmployeeType getType(){
        return this.type;
    }
}


// %% tags=["subslide", "keep"]
public Money calculateCommissionedPay(EmployeeV1 e) {
    return new Money(100.0);
}


// %% tags=["keep"]
public Money calculateHourlyPay(EmployeeV1 e) {
    return new Money(120.0);
}


// %% tags=["keep"]
public Money calculateSalariedPay(EmployeeV1 e) {
    return new Money(80.0);
}


// %% tags=["subslide", "keep"]
public static Money calculatePay(EmployeeV1 e) {
    switch (e.getType()) {
        case COMMISSIONED:
            return calculateCommissionedPay(e);
        case HOURLY:
            return calculateHourlyPay(e);
        case SALARIED:
            return calculateSalariedPay(e);
        default:
            throw new IllegalArgumentException("No valid employee type.");
    }
}


// %% tags=["keep"]
EmployeeV1 e1 = new EmployeeV1(EmployeeType.HOURLY);
EmployeeV1 e2 = new EmployeeV1(EmployeeType.SALARIED);

// %% tags=["keep"]
System.out.println(calculatePay(e1).getAmountInEuros());
System.out.println(calculatePay(e2).getAmountInEuros());

// %% [markdown] lang="de" tags=["subslide"]
//
// ## Ersetze Switch-Anweisung durch Polymorphie
//
// Es ist oft besser, switch-Anweisungen durch "echtes" Subtyping und
// Polymorphismus zu ersetzen:

// %% [markdown] lang="en" tags=["subslide"]
//
// ## Replace switch with polymorphism
//
// It is often better to replace switches with “real” subtyping and polymorphism:


// %% tags=["keep"]
public abstract class Employee {
    public abstract double calculatePay();
}

// %% tags=["keep"]
public class CommissionedEmployee extends Employee {
    public double calculatePay() {
        return 100.0;
    }
}

// %% tags=["keep"]
public class HourlyEmployee extends Employee {
    public double calculatePay() {
        return 120.0;
    }
}

// %% tags=["keep"]
public class SalariedEmployee extends Employee {
    public double calculatePay() {
        return 80.0;
    }
}


// %% tags=["subslide", "keep"]
public static Employee createEmployee(EmployeeType employeeType) {
    switch (employeeType) {
        case COMMISSIONED:
            return new CommissionedEmployee();
        case HOURLY:
            return new HourlyEmployee();
        case SALARIED:
            return new SalariedEmployee();
        default:
            throw new IllegalArgumentException("Not a valid employee type.");
    }
}

// %% tags=["subslide", "keep"]
Employee e1 = createEmployee(EmployeeType.HOURLY);
Employee e2 = createEmployee(EmployeeType.SALARIED);

// %% tags=["keep"]
System.out.println(e1.calculatePay());
System.out.println(e2.calculatePay());


// %% tags=["subslide", "keep"]
public class EmployeeFactory {
    public static Employee createEmployee(EmployeeType employeeType) {
        switch (employeeType) {
            case COMMISSIONED:
                return new CommissionedEmployee();
            case HOURLY:
                return new HourlyEmployee();
            case SALARIED:
                return new SalariedEmployee();
            default:
                throw new IllegalArgumentException("Not a valid employee type.");
        }
    }
}

// %% tags=["subslide", "keep"]
EmployeeFactory factory = new EmployeeFactory();
Employee e1 = factory.createEmployee(EmployeeType.HOURLY);
Employee e2 = factory.createEmployee(EmployeeType.SALARIED);

// %% tags=["keep"]
System.out.println(e1.calculatePay());
System.out.println(e2.calculatePay());
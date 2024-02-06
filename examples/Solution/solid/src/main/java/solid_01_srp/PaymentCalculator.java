package solid_01_srp;

import utils.EmployeeType;

public class PaymentCalculator {
	
    public double calculatePay(Employee employee) {
    
    	EmployeeType employeeType = employee.employeeType;
    	
    	if (employeeType == EmployeeType.REGULAR) {
            return employee.salary + 60.0 * employee.overtime;
        } else if (employeeType == EmployeeType.COMMISSIONED) {
            return employee.project.assets * 0.1;
        } else if (employeeType == EmployeeType.HOURED) {
            return 50.0 * employee.overtime;
        }
        throw new IllegalArgumentException(employeeType + " is not valid.");
    }
    
}

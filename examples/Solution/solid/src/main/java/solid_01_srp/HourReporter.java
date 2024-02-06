package solid_01_srp;

import utils.EmployeeType;

public class HourReporter {
	
    public int report(Employee employee) {
        EmployeeType employeeType = employee.employeeType;
        if (employeeType == EmployeeType.REGULAR) {
            return 40 + employee.overtime;
        } else if (employeeType == EmployeeType.COMMISSIONED) {
            // Commissioned employees always work 40 hours
            return 40;
        } else if (employeeType == EmployeeType.HOURED) {
            // We use overtime for the billed hours
            return employee.overtime;
        }
        throw new IllegalArgumentException(employeeType + " is not valid.");
    }
    
}
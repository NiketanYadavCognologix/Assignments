package com.cognologix.mapper;

import com.cognologix.model.Employee;

public class EmployeeMapper implements CSVToPojoMapper<Employee> {
	
	Integer employeeId;
	String employeeame;
	String employeeDepartment;
	Integer salary;

	@Override
	public Employee map(String[] values) {
		if (values == null || values.length != 4) {
            throw new RuntimeException("invalid values to map");
        }
		try {
			employeeId=Integer.parseInt(values[0].trim());
		} catch (NumberFormatException e) {
			throw new RuntimeException("Invalid employee id", e);
		}
		employeeame=values[1].trim();
		employeeDepartment=values[2].trim();
		try {
			salary=Integer.parseInt(values[3].trim());
		} catch (NumberFormatException e) {
			throw new RuntimeException("Invalid salary",e);
		}

		Employee empployee = new Employee(employeeId, employeeame, employeeDepartment, salary);

		return empployee;
	}
}

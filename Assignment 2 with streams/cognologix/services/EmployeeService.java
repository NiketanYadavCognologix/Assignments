package com.cognologix.services;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.maxBy;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.cognologix.model.Employee;


public class EmployeeService {

	List<Employee> employees;

	public EmployeeService(List<Employee> employeesList) {
		this.employees = employeesList;
	}
	public Map<String, Employee> getHighestPayEmployeeInEachDepartment() {		
		Map<String, Employee> highestPayEmployees = employees.stream()
				.collect(groupingBy(employee -> employee.getEmplyeeDept(),
						collectingAndThen(maxBy(comparingInt(c -> c.getSalary())), Optional::get)));
		return highestPayEmployees;
	}

}


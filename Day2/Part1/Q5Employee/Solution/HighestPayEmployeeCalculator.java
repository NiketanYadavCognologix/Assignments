package com.cognologix.Part1.Q5Employee.Solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.cognologix.Part1.Q5Employee.Model.Employee;

public class HighestPayEmployeeCalculator {

	List<Employee> employeesList;

	public HighestPayEmployeeCalculator(List<Employee> employeesList) {
		this.employeesList = employeesList;
	}

	public Set<String> getDepatments() {
		Set<String> departmentNames = new TreeSet<String>();

		for (Employee employee : employeesList) {
			departmentNames.add(employee.getEmplyeeDept());
		}
		return departmentNames;
	}

	public List<Employee> getHighestPayEmployeeInEachDepartment(Set<String> departmentNamesSet) {

		List<Employee> highestPayEmployees = new ArrayList<Employee>();

		for (String department : departmentNamesSet) {
			Integer maximumSalary = 0;
			Employee maximumSalaryEmployee = null;
			for (Employee employeeFromEmployeeList: employeesList) {

				Integer salary = employeeFromEmployeeList.getSalary();

				if (employeeFromEmployeeList.getEmplyeeDept().equals(department)) {
					if (maximumSalary < salary) {
						maximumSalary = salary;
						maximumSalaryEmployee = employeeFromEmployeeList;
					}
				}
			}
			highestPayEmployees.add(maximumSalaryEmployee);
		}
		return highestPayEmployees;
	}

	public void printResult(List<Employee> highestPayEmployeesList) {
		for (Employee employee : highestPayEmployeesList) {
			System.out.println(employee.getEmplyeeDept() + " ---> " + employee.getEmployeeId());
		}
	}
}

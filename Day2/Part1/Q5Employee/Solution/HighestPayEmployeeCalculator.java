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
			for (int i = 0; i < employeesList.size(); i++) {

				String salaryString = "";
				String inputSalaryString = employeesList.get(i).getSalary();

				/*
				 * we can use trim method but if any alphabet's or symbol is skipped by this
				 * method
				 */
				salaryString = getOnlyNumbers(salaryString, inputSalaryString);

				Integer salary = Integer.parseInt(salaryString);

				if (employeesList.get(i).getEmplyeeDept().equals(department)) {
					if (maximumSalary < salary) {
						maximumSalary = salary;
						maximumSalaryEmployee = employeesList.get(i);
					}
				}
			}

//			System.out.println(maximumSalaryEmployee.getEmplyeeDept()+" : "+maximumSalaryEmployee.getEmployeeId());
			highestPayEmployees.add(maximumSalaryEmployee);
		}
		return highestPayEmployees;
	}

	private String getOnlyNumbers(String salaryString, String inputSalaryString) {
		for (int j = 0; j < inputSalaryString.length(); j++) {
			if (inputSalaryString.charAt(j) >= 48 && inputSalaryString.charAt(j) <= 57)
				salaryString += (char) (inputSalaryString.charAt(j));
		}
		return salaryString;
	}

	public void printResult(List<Employee> highestPayEmployeesList) {
		for (Employee employee : highestPayEmployeesList) {
			System.out.println(employee.getEmplyeeDept() + " ---> " + employee.getEmployeeId());
		}
	}
}

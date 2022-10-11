package com.cognologix;

import java.util.List;
import java.util.Map;

import com.cognologix.mapper.EmployeeMapper;
import com.cognologix.model.Employee;
import com.cognologix.parser.InputParser;
import com.cognologix.services.EmployeeService;

/*    5. Highest Salary in Dept

22, Rajan Anand, Engineering, 1600000
23, Swati Patil, Testing, 800000
27, Vijay Chawda, Engineering, 800000
29, Basant Mahapatra, Engineering, 600000
32, Ajay Patel, Testing, 350000
34, Swaraj Birla, Testing, 350000

Each string consists of 4 fields: "Employee ID," "Name," "Department," and "Salary." Here, "Employee ID" and "Salary" are integers,
 while "Name" and "Department" are strings that do not contain commas or newlines. 
Write a program to find the Employee IDs of the highest paid employee in each department. Specifically, processData should 
return a Dictionary where each key is the name of a department, and the value is the Employee ID of the employee in that 
department who has the highest salary. If your program is run with the input given above, it should produce this output:
Engineering: 22
Testing: 23
This is because Employee ID 22 (Rajan Anand) is the highest paid employee in the Engineering department, and 
Employee ID 23 (Swati Patil) is the highest paid employee in the Testing department.*/
public class EmployeeSalaryTest {

	
	public static void main(String[] args) {
		
		String [] employeeInformation= {
				"22, Rajan Anand, Engineering, 1600000",
				"23, Swati Patil, Testing, 800000",
				"27, Vijay Chawda, Engineering, 800000",
				"29, Basant Mahapatra, Engineering, 600000",
				"32, Ajay Patel, Testing, 350000",
				"34, Swaraj Birla, Testing, 350000"
				
		};
		// class for parsing CSV file and Map with ArrayList of customer
		InputParser<Employee> parser=new InputParser<Employee>(new EmployeeMapper());
		
		// method in EmployeeInputParser class getting list of employees
		List<Employee> employees=parser.parseArray(employeeInformation);
				
		// class for calculating the highest pay
		EmployeeService highestPayCalculator=new EmployeeService(employees);
		
		// method to get highest pay employee from employee from each department arrayList
		final Map<String, Employee> highestPayEmployeesList=highestPayCalculator.getHighestPayEmployeeInEachDepartment();
		highestPayEmployeesList.entrySet().stream().forEach(n -> System.out.println(n.getKey()+" : "+n.getValue().getEmployeeId()));
		
		
			
	}
}

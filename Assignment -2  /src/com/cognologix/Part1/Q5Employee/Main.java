package com.cognologix.Part1.Q5Employee;

import java.util.List;
import java.util.Set;

import com.cognologix.Part1.Q5Employee.Model.Employee;
import com.cognologix.Part1.Q5Employee.Solution.HighestPayEmployeeCalculator;
import com.cognologix.Part1.Q5Employee.parser.EmployeeInputParser;

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
public class Main {

	
	public static void main(String[] args) {
		
		EmployeeInputParser inputParser=new EmployeeInputParser();
		String inputFilePath="/home/niketanyadav/eclipse-workspace/Testing/Assignment2/src/com/cognologix/Part1/Q5Employee/files/input.csv";
		
		List<Employee> employeesList=inputParser.employeeCSVParser(inputFilePath);
		
		HighestPayEmployeeCalculator highestPayCalculator=new HighestPayEmployeeCalculator(employeesList);
		
		/*Get unique department names in set*/
		final Set<String> departmentNamesSet=highestPayCalculator.getDepatments(employeesList);
		
		/*Get highest pay in each department*/
		final List<Employee> highestPayEmployeesList=highestPayCalculator.getHighestPayEmployeeInEachDepartment(employeesList,departmentNamesSet);
		
		/*Print the result */
		highestPayCalculator.printResult(highestPayEmployeesList);
			
	}
}

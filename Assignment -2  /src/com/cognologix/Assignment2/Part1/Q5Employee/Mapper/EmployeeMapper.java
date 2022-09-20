package com.cognologix.Assignment2.Part1.Q5Employee.Mapper;

import com.cognologix.Assignment2.Part1.Q5Employee.Model.Employee;

public class EmployeeMapper {
	public static Employee map(String data)
	{
		String [] empployeeInsert=data.split(",");
		
		Employee empployee=new Employee();
		
		empployee.setEmployeeId(empployeeInsert[0].trim());
		empployee.setEmployeeName(empployeeInsert[1]);
		empployee.setEmplyeeDept(empployeeInsert[2]);
		empployee.setSalary(empployeeInsert[3].trim());
		
		return empployee;

	}
}

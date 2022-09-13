package com.cognologix.Day1.Q2EmployeeManagement;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class EmployeeDBForSet {
	
	
	Set<Employee> employeeSet=new HashSet<>();
	
	public boolean addEmployee(Employee e) {
		return employeeSet.add(e);
		
	}
	boolean deleteEmployee(int empId) {
		boolean remove= false;
		Iterator<Employee> iterable= employeeSet.iterator();
		while((iterable).hasNext())
		{
			Employee emp=iterable.next();
			if(emp.getEmpId() == empId)
			{
				iterable.remove();
				remove=true;
			}
		}
		return remove;
				
	}
	String showPaySlip(int empId) {
		
		String paySlip="Please Enter valid employeeId";
		
		for (Employee employee : employeeSet) 
		{
			if(employee.getEmpId()==empId)
				paySlip="Employee  have "+employee.getEmpSalary()+" salary...";
		}
		return paySlip;
		
	}
	Employee[] listAll() {
		Employee [] employeeArryay= new Employee[employeeSet.size()];
		int index=0;
		for (Employee employee : employeeSet) {
			employeeArryay[index++]=employee;
//			System.out.println(employee);			//we can print on EmployeeManagement Also
		}
		

		
		return employeeArryay;
		
	}


}

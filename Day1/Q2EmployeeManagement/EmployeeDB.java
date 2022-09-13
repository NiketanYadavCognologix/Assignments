package com.cognologix.Day1.Q2EmployeeManagement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class EmployeeDB{
	
	List<Employee> employeeArrayList=new ArrayList<>();
	
	public boolean addEmployee(Employee e) {
		return employeeArrayList.add(e);
		
	}
	boolean deleteEmployee(int empId) {
		boolean remove= false;
		Iterator<Employee> iterable= employeeArrayList.iterator();
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
		
		for (Employee employee : employeeArrayList) 
		{
			if(employee.getEmpId()==empId)
				paySlip="Employee "+employeeArrayList.get(empId).getEmpName()+" have "+employee.getEmpSalary()+" salary...";
		}
		return paySlip;
		
	}
	Employee[] listAll() {
		Employee [] employeeArryay= new Employee[employeeArrayList.size()];
		for (int i = 0; i < employeeArryay.length; i++) 
		{
			employeeArryay[i]=employeeArrayList.get(i);
//			System.out.println(employeeArryay[i].getEmployeeDetails());			//we can print on EmployeeManagement Also
		}
		
		return employeeArryay;
		
	}
}

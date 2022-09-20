package com.cognologix.Assignment2.Part1.Q5Employee.Model;

public class Employee {

	private String EmployeeId;
	private String EmployeeName;
	private String EmplyeeDept;
	private String Salary;
	public Employee() {}
	public Employee(String employeeId, String employeeName, String emplyeeDept, String salary) {
		EmployeeId = employeeId;
		EmployeeName = employeeName;
		EmplyeeDept = emplyeeDept;
		Salary = salary;
	}
	public String getEmployeeId() {
		return EmployeeId;
	}
	public void setEmployeeId(String employeeId) {
		EmployeeId = employeeId;
	}
	public String getEmployeeName() {
		return EmployeeName;
	}
	public void setEmployeeName(String employeeName) {
		EmployeeName = employeeName;
	}
	public String getEmplyeeDept() {
		return EmplyeeDept;
	}
	public void setEmplyeeDept(String emplyeeDept) {
		EmplyeeDept = emplyeeDept;
	}
	public String getSalary() {
		return Salary;
	}
	public void setSalary(String salary) {
		Salary = salary;
	}
	@Override
	public String toString() {
		return "QFiveEmployee [EmployeeId=" + EmployeeId + ", EmployeeName=" + EmployeeName + ", EmplyeeDept="
				+ EmplyeeDept + ", Salary=" + Salary + "]";
	}
}

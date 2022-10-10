package com.cognologix.model;

public class Employee {

	private Integer employeeId;
	private String employeeName;
	private String emplyeeDept;
	private Integer salary;
	public Employee() {}
	public Employee(Integer employeeId, String employeeName, String emplyeeDept, Integer salary) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.emplyeeDept = emplyeeDept;
		this.salary = salary;
	}
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmplyeeDept() {
		return emplyeeDept;
	}
	public void setEmplyeeDept(String emplyeeDept) {
		this.emplyeeDept = emplyeeDept;
	}
	public Integer getSalary() {
		return salary;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		String placeHolder="EmployeeId : {0} | EmployeeName : {1} | EmplyeeDept : {2} | Salary : {3} ";
		return java.text.MessageFormat.format(placeHolder, employeeId, employeeName, emplyeeDept, salary);
	}
}

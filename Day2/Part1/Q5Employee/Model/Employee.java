package com.cognologix.Part1.Q5Employee.Model;

public class Employee {

	private Integer EmployeeId;
	private String EmployeeName;
	private String EmplyeeDept;
	private Integer Salary;
	public Employee() {}
	public Employee(Integer employeeId, String employeeName, String emplyeeDept, Integer salary) {
		EmployeeId = employeeId;
		EmployeeName = employeeName;
		EmplyeeDept = emplyeeDept;
		Salary = salary;
	}
	public Integer getEmployeeId() {
		return EmployeeId;
	}
	public void setEmployeeId(Integer employeeId) {
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
	public Integer getSalary() {
		return Salary;
	}
	public void setSalary(Integer salary) {
		Salary = salary;
	}
	@Override
	public String toString() {
		return "QFiveEmployee [EmployeeId=" + EmployeeId + ", EmployeeName=" + EmployeeName + ", EmplyeeDept="
				+ EmplyeeDept + ", Salary=" + Salary + "]";
	}
}

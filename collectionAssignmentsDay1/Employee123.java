package collectionAssignmentsDay1;

public class Employee123 {
	private int EmpId;
	private String EmpName;
	private String EmpEmail;
	private char EmpGender;
	private float EmpSalary;
	public Employee123() {}
	public Employee123(int empId, String empName, String empEmail, char empGender, float empSalary) {
		EmpId = empId;
		EmpName = empName;
		EmpEmail = empEmail;
		EmpGender = empGender;
		EmpSalary = empSalary;
	}
	public int getEmpId() {
		return EmpId;
	}
	public void setEmpId(int empId) {
		EmpId = empId;
	}
	public String getEmpName() {
		return EmpName;
	}
	public void setEmpName(String empName) {
		EmpName = empName;
	}
	public String getEmpEmail() {
		return EmpEmail;
	}
	public void setEmpEmail(String empEmail) {
		EmpEmail = empEmail;
	}
	public char getEmpGender() {
		return EmpGender;
	}
	public void setEmpGender(char empGender) {
		EmpGender = empGender;
	}
	public float getEmpSalary() {
		return EmpSalary;
	}
	public void setEmpSalary(float empSalary) {
		EmpSalary = empSalary;
	}
	@Override
	public String toString() {
		return "Employee123 [EmpId=" + EmpId + ", EmpName=" + EmpName + ", EmpEmail=" + EmpEmail + ", EmpGender="
				+ EmpGender + ", EmpSalary=" + EmpSalary + "]";
	}
}

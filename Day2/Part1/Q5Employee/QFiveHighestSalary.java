package com.cognologix.Day2.Part1.Q5Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

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
public class QFiveHighestSalary {
	
	List<QFiveEmployee> arrayList=new ArrayList<QFiveEmployee>();
	Set<String> set=new TreeSet<String>();
	
	public static void main(String[] args) {
		String [] input= {"22, Rajan Anand, Engineering, 1600000",
							"23, Swati Patil, Testing, 800000",
							"27, Vijay Chawda, Engineering, 800000",
							"29, Basant Mahapatra, Engineering, 600000",
							"32, Ajay Patel, Testing, 350000",
							"34, Swaraj Birla, Testing, 350000"};
		
		QFiveHighestSalary object=new QFiveHighestSalary();
		/*Input reading method*/
		object.inputReading(input);

		/*Getting unique department names in set*/
		object.setOfDepartment();
		
		/*Getting final result*/
		object.finalResult();
			
	}

	private void finalResult() {
		for (String oneEmpdept : set) 
		{
			Integer maxSalary=0;
			QFiveEmployee maxSalaryEmployee=null;
			for (int i = 0; i < arrayList.size(); i++) {
				
				String onlySalary="";
				String takenSalary= arrayList.get(i).getSalary();
				for (int j = 0; j <takenSalary.length(); j++) 
				{
					if(takenSalary.charAt(j)>=48 && takenSalary.charAt(j)<=57)
						onlySalary+=(char)(takenSalary.charAt(j));
				}
				Integer salary=Integer.parseInt(onlySalary);
//				System.out.println(n);
				
				if(arrayList.get(i).getEmplyeeDept().equals(oneEmpdept))
				{
					if(maxSalary<salary)
					{
						maxSalary=salary;
						maxSalaryEmployee=arrayList.get(i);
					}
				}
			}
			
			System.out.println(maxSalaryEmployee.getEmplyeeDept()+" : "+maxSalaryEmployee.getEmployeeId());
		}
		
	}

	private void setOfDepartment() {
		
		for (QFiveEmployee employee : arrayList) {
			set.add(employee.getEmplyeeDept());
		}
		
		//********You can also use Iterator************ 		
		/*
		Iterator<QFiveEmployee> it=arrayList.iterator();
		while(it.hasNext())
		{
			QFiveEmployee employee=it.next();
			set.add(employee.getEmplyeeDept());
		}
		*/
		
	}

	private void inputReading(String[] input) {
		for (int i = 0; i < input.length; i++) 
		{
			String inputOneString=input[i];
			
			String [] empInsert=inputOneString.split(",");
			
			QFiveEmployee emp=new QFiveEmployee();
			
			emp.setEmployeeId(empInsert[0]);
			emp.setEmployeeName(empInsert[1]);
			emp.setEmplyeeDept(empInsert[2]);
			emp.setSalary(empInsert[3]);
			
			arrayList.add(emp);
		}
		
	}
}

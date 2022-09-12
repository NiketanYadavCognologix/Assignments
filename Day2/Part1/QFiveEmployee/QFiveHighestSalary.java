package com.cognologix.Day2.Part1.QFiveEmployee;

import java.util.ArrayList;
import java.util.Iterator;
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
	
	static List<QFiveEmployee> arrayList=new ArrayList<QFiveEmployee>();
	static Set<String> set=new TreeSet<String>();
	
	public static void main(String[] args) {
		String [] input= {"22, Rajan Anand, Engineering, 1600000",
							"23, Swati Patil, Testing, 800000",
							"27, Vijay Chawda, Engineering, 800000",
							"29, Basant Mahapatra, Engineering, 600000",
							"32, Ajay Patel, Testing, 350000",
							"34, Swaraj Birla, Testing, 350000"};
		
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
		
		Iterator<QFiveEmployee> it=arrayList.iterator();
		while(it.hasNext())
		{
			QFiveEmployee employee=it.next();
			set.add(employee.getEmplyeeDept());
		}
		
		for (String oneEmpdept : set) 
		{
			int maxSalary=0;
			QFiveEmployee maxSalaryEmployee=null;
			for (int i = 0; i < input.length; i++) {
				
				String onlySalary="";
				String takenSalary= arrayList.get(i).getSalary();
				for (int j = 0; j <takenSalary.length(); j++) 
				{
					if(takenSalary.charAt(j)>=48 && takenSalary.charAt(j)<=57)
						onlySalary+=(char)(takenSalary.charAt(j));
				}
				int salary=Integer.parseInt(onlySalary);
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
		
//		while()
		
	}
}

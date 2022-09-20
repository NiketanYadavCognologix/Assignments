package com.cognologix.Day2.Part1.Q5Employee.Solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.cognologix.Day2.Part1.Q5Employee.Model.QFiveEmployee;

public class QFiveSolution {
	
	
	List<QFiveEmployee> arrayList=new ArrayList<QFiveEmployee>();
	Set<String> set=new TreeSet<String>();
	
	public void finalResult() {
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

	public void setOfDepartment() {
		
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

	public void inputReading(String[] input) {
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

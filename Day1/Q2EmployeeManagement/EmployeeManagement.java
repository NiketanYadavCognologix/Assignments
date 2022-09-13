package com.cognologix.Day1.Q2EmployeeManagement;

import java.util.Scanner;

/*     2. Create an application for employee management having following classes: 
        a. Create an Employee class with following attributes and behaviors 
        : i) EmpId Int ii) EmpName String iii) EmpEmail String iv) EmpGender char v) EmpSalary float vi) GetEmployeeDetails() -> prints employee details
        b. Create one more class EmployeeDB which has the following methods.
         i) boolean addEmployee(Employee e) ii) boolean deleteEmployee(int empId) iii) String showPaySlip(int empId) iv) Employee[] listAll()
Do implementation of the above application with below two methods :
I. Use an ArrayList which will be used to store the employees and use enumeration/iterator to process the employees.
II. Use a TreeSet Object to store employees on the basis of their EmpId and use enumeration/iterator to process employees.
[Hint: Use Comparable interface] Write a Test Program to test that all functionalities are operational. */
public class EmployeeManagement {
	
	
	public static void main(String[] args) {
		
		
		Scanner sc=new Scanner(System.in);
		System.out.println("1.Add \n2.Delete \n3.Show pay slip \n4.Show all \n5.Exit");
		
//		EmployeeDB database=new EmployeeDB();
		EmployeeDBForSet database=new EmployeeDBForSet();
		String continueStatus=null;
		
		
		do
		{
			System.out.print("Enter the number which operation do you want to perform : ");
			int EnteringValue=sc.nextInt();

			switch(EnteringValue)
			{
			case 1 :
				Employee emp1= new Employee(1, "Niketan", "cksacsdachs", 'M', 12547.54f);
				Employee emp2= new Employee(2, "Somu", "cksacsfsdfdachs", 'f', 12545.54f);
				Employee emp3= new Employee(3, "Gomu", "cksasefwecsdachs", 'M', 22547.54f);
				Employee emp4= new Employee(4, "Tomu", "cksacsmjdachs", 'f', 36547.54f);
				
				database.addEmployee(emp1);
				database.addEmployee(emp2);
				database.addEmployee(emp3);
				database.addEmployee(emp4);
				break;
			case 2: 
				boolean result=database.deleteEmployee(4);
				System.out.println(result);
				break;
			case 3:
				System.out.print("Enter employee id to show pay slip : ");
				int EmpId=sc.nextInt();
				String paySlip=database.showPaySlip(EmpId);
				System.out.println(paySlip);
				break;
			case 4: 
				Employee[] results= database.listAll();
				for (Employee employee : results) 
				{
					System.out.println(employee);
				}
				break;

			case 5 :
				System.out.println("Exiting........");
				break;
				
			default :
				System.out.println("Error : Enter correct option");
			}
			
			System.out.print("Do you want to cotinue press(y-yes/n-any character) : ");
			try {
				continueStatus=sc.next();
			}catch (Exception e) {
			System.out.println("Plese entre correct option");}
		}
		while(continueStatus.equalsIgnoreCase("y"));
		
		System.out.println("Shutting down the application....Thank you");
		
		sc.close();
		
	
	}

}
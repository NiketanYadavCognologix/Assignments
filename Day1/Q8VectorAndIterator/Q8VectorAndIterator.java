package com.cognologix.Day1.Q8VectorAndIterator;

import java.util.Iterator;
import java.util.Vector;

/*Write a program that will have a Vector which is capable of storing emp objects. 
Use an Iterator and enumeration to list all the elements of the Vector.*/

class Employee12 {
	private int id;
	private String name;
	private String address;
	private Double salary;
	
	public Employee12(int id, String name, String address, Double salary) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.salary = salary;
	}	
	
	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", address=" + address + ", salary=" + salary + "]";
	}
}

public class Q8VectorAndIterator {

	public static void main(String[] args) {
		Vector<Employee12> list = new Vector<>();
		
		list.add(new Employee12(101, "Niketan", "Satara, India", 20000.0));
		list.add(new Employee12(102, "Onkar", "Buldhana, India", 30000.0));
		list.add(new Employee12(103, "Manjula", "Solapur, India", 25000.0));
		list.add(new Employee12(104, "Poorva", "Yerawda, India", 40000.0));
		
		Iterator<Employee12> it = list.iterator();
		while (it.hasNext()) 
			System.out.println(it.next());
		

	}

}
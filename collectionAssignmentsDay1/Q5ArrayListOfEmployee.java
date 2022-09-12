package collectionAssignmentsDay1;

/*Create an ArrayList of Employee( id,name,address,sal) objects and search for particular Employee object based on id number.*/

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Employee1 {
	private int id;
	private String name;
	private String address;
	private Double salary;
	
	public Employee1(int id, String name, String address, Double salary) {
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

public class Q5ArrayListOfEmployee
{

	public static void main(String[] args) {
		List<Employee1> list = new ArrayList<>();
		
		list.add(new Employee1(101, "Niketan", "Satara, India", 60000.0));
		list.add(new Employee1(102, "Onkar", "Buldhana, India", 65000.0));
		list.add(new Employee1(103, "Manjula", "3Solapur, India", 83000.0));
		list.add(new Employee1(104, "Poorva", "Yerawda India", 70000.0));
		
		Iterator<Employee1> it = list.iterator();
		
		int searchId = 103;
		
		while (it.hasNext()) 
		{
			Employee1 emp = it.next();
			if (emp.getId() == searchId)
				System.out.println(emp);
		}
	}

}
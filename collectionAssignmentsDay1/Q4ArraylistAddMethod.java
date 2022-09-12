package collectionAssignmentsDay1;

import java.util.ArrayList;
import java.util.List;

/*Create an ArrayList which will be able to store only numbers like int, float, double, etc, but
  not any other data type.*/

class MyArrayList<E> extends ArrayList<E> {
	@Override
	public boolean add(E e) {
		if (e instanceof Integer || e instanceof Float || e instanceof Double) 
		{
			super.add(e);							/*this super indicates the parentalClass(Arraylist's) add method
			 												with single argument.*/
			return true;
		}
		else 
		{
			throw new ClassCastException("Only Integer, Float, and Double you can add");
		}
	}
}

public class Q4ArraylistAddMethod {

	public static void main(String[] args) {
		
		List<Object> list = new MyArrayList<>();
		
		try {
			list.add(15);
			list.add(1.2F);
			list.add(3.1415D);
			list.add("Test");
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		System.out.println(list);

	}

}
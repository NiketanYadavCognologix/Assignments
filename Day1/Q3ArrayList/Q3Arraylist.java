package com.cognologix.Day1.Q3ArrayList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*Create an ArrayList which will be able to store only Strings. Create a printAll method which will print all the elements using an Iterator.*/

public class Q3Arraylist {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		
		list.add("One");
		list.add("Two");
		list.add("Three");
		list.add("Four");
		
		printAll(list);
	}

	public static void printAll(List<String> list) 
	{
		Iterator<String> it = list.iterator();
		
		while (it.hasNext())
			System.out.println(it.next());
	}
}
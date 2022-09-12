package com.cognologix.Day1.Q4ArraylistAddMethod;

import java.util.ArrayList;
import java.util.List;

/*Create an ArrayList which will be able to store only numbers like int, float, double, etc, but
  not any other data type.*/



public class Q4ArraylistAddMethod {

	public static void main(String[] args) {
		
		List<Object> list = new ArrayList<>();
		
		try {
			list.add(15);
			list.add(1.2F);
			list.add(3.1415D);
//			list.add("Test"); 						//we can add Only Numbers
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		System.out.println(list);

	}

}
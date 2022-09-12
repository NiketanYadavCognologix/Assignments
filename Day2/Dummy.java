package com.cognologix.Day2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Dummy {

	public static void main(String[] args) {
		List<Number> list = new ArrayList<>();
		
		try {
			list.add(15);
			list.add(1.2F);
			list.add(3.1415D);
			// list.add("Test");         //we can add only Numbers
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(list);

	}

}
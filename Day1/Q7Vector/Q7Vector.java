package com.cognologix.Day1.Q7Vector;

import java.util.Vector;

/*Implement the assignment 1 using Vector */

public class Q7Vector {
	private Vector<Integer> list = new Vector<Integer>();
	
	public Vector<Integer> saveEvenNumbers(int N) {
		list = new Vector<Integer>();
		
		for (int i = 2; i <= N; i++) {
			if (i % 2 == 0) list.add(i);
		}
		
		return list;
	}
	
	public Vector<Integer> printEvenNumbers() {
		Vector<Integer> newList = new Vector<Integer>();
		System.out.println("Second arrayList is ---> ");
		for (int item : list) {
			newList.add(item * 2);
			System.out.print(item * 2+" ");
		}
		
		return newList;
	}
	
	public int printEvenNumber(int N,Vector<Integer> list)
	{
		if(list.contains(N))
			return N;
		return 0;
			
	}

	public static void main(String[] args) {
		Q7Vector asg = new Q7Vector();
		asg.saveEvenNumbers(10);

		Vector<Integer> secondVector= asg.printEvenNumbers();
		System.out.println();
		int result=asg.printEvenNumber(16, secondVector);
		System.out.println("The Second Vector contins the given number ? (No-0, Yes-Number) ---> "+result);
		

	}

}
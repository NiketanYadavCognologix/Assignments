package com.cognologix.Day1.Q1EvenNumbers;

import java.util.ArrayList;
import java.util.List;

/*1. Develop a java class with a method saveEvenNumbers(int N) using ArrayList to store even numbers from 2 to N, where N is an integer which is passed 
 as a parameter to the method saveEvenNumbers().
The method should return the ArrayList (A1) created. 
In the same class create a method printEvenNumbers() which iterates through the arrayList A1 in step 1, and It should multiply each number with 2 and 
display it in format 4,8,12….2*N. and add these numbers in a new ArrayList (A2). 
The new ArrayList (A2) created needs to be returned.  Create a method printEvenNumber(int N) parameter is a number N. 
This method should search the arrayList (A1) for the existence of the number ‘N’ passed. If it exists it should return the Number else return zero.
Hint: Use instance variable for storing the ArrayList A1 and A2. 
NOTE: You can test the methods using a main method.
 */
public class SaveEvenNumbers {
	
	List<Integer> A1= new ArrayList<Integer>();

	public ArrayList<Integer> saveEvenNumbers(int N)
	{
		for (int i = 1; i <= N; i++) 
		{
			if(i%2==0)
			A1.add(i);
		}

		return (ArrayList<Integer>) A1;
	}
	
	public ArrayList<Integer> printEvenNumbers()
	{
		List<Integer> A2=new ArrayList<Integer>();

		for (int i = 0; i < A1.size(); i++) 
		{
			Integer elementForSecondArrayList=(A1.get(i)*2);
			A2.add(elementForSecondArrayList);
		}
		System.out.println("Second arrayList --->"+A2);
		
		return (ArrayList<Integer>) A2;

	}
	
	public int printEvenNumber(int N,ArrayList<Integer> A1)
	{
		if(A1.contains(N))
			return N;
		return 0;
			
	}
	
	public static void main(String[] args) {
		SaveEvenNumbers object1=new SaveEvenNumbers();
		int N=10;
		
		ArrayList<Integer> firstArrayList=new ArrayList<Integer>(object1.saveEvenNumbers(N));
		System.out.println("first ArrayList ---> "+firstArrayList);
		
		ArrayList<Integer> secondArrayList=new ArrayList<Integer>(object1.printEvenNumbers());
		
		int result1=object1.printEvenNumber(11, secondArrayList);
		System.out.println("Is the given value is present (0-No, value-Yes) ---> "+result1);
		
		int result2=object1.printEvenNumber(20, secondArrayList);
		System.out.println("Is the given value is present (0-No, value-Yes) ---> "+result2);

	}

}

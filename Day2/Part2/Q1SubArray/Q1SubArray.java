package com.cognologix.Day2.Part2.Q1SubArray;

public class Q1SubArray {

	public static void main(String[] args) {
		int [] givenArray1= {1,2,3,4,5,6};
		int [] givenArray2= {3,4,};
		

		String Array1String="";
		String Array2String="";
		for (int i = 0; i < givenArray1.length; i++) {
			Array1String+=givenArray1[i]+",";
		}
		for (int i = 0; i < givenArray2.length; i++) {
			Array2String+=givenArray2[i]+",";
		}
		
		if(Array1String.contentEquals(Array2String))
			System.out.println("A is equal to B");
		else if(Array1String.contains(Array2String))
			System.out.println("A is superlist to B");
		else if(Array2String.contains(Array1String))
			System.out.println("A is a sublist of B");
		else
			System.out.println("A is not a superlist of, sublist of or equal to B");
		
		System.out.println("Array A ---> "+Array1String);
		System.out.println("Array B ---> "+Array2String);
		
		

		
	}
}

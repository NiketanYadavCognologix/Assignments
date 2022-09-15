package com.cognologix.Day2.Part2.Q1SubArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q1SubArray {

	public static void main(String[] args) {
		Integer [] arr1= {1,2,3,4,5,6};
		Integer [] arr2= {3,4,};
	
		/*
		String Array1String="";
		String Array2String="";
		for (int i = 0; i < arr1.length; i++) {
			Array1String+=arr1[i]+",";
		}
		for (int i = 0; i < arr2.length; i++) {
			Array2String+=arr2[i]+",";
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
		*/

		
//**************************OR***************************
		
		List<Integer> givenArray1= Arrays.asList(arr1);
		List<Integer> givenArray2= Arrays.asList(arr2);	
		
		if(givenArray1.equals(givenArray2))
			System.out.println("A is equal to B");
		else if(givenArray1.containsAll(givenArray2))
			System.out.println("A is superlist to B");
		else if(givenArray2.containsAll(givenArray1))
			System.out.println("A is a sublist of B");
		else
			System.out.println("A is not a superlist of, sublist of or equal to B");
		
			
	}
}

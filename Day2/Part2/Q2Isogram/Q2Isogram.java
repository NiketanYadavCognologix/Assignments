package com.cognologix.Day2.Part2.Q2Isogram;

import java.util.Arrays;

/*Determine if a word or phrase is an isogram.
An isogram (also known as a "nonpattern word") is a word or phrase without a repeating letter,
 however spaces and hyphens are allowed to appear multiple times.
Examples of isograms:
    • lumberjacks
    • background
    • downstream
    • six-year-old
The word isograms, however, is not an isogram, because the s repeats.*/
public class Q2Isogram {
	
	public static void main(String[] args) {
//		String toCheckIsogram="lumberjacks";
		String toCheckIsogram="background";
//		String toCheckIsogram="downstream";
//		String toCheckIsogram="six-year-old";
		
		char [] charArray=toCheckIsogram.toCharArray();
		Arrays.sort(charArray);
		
		for (int i = 0; i < charArray.length-1; i++) {
			
			if(charArray[i]==' '|| charArray[i]=='-')
			{
				continue;
			}
			else if(charArray[i]==charArray[i+1])
			{
				System.out.println("Not an Isogram");
				System.exit(0);
			}
		}
		System.out.println(toCheckIsogram+" is an Isogram");
	}
}

package com.cognologix.Day2.Part2.Q3Anagram;

import java.util.Arrays;

public class Q3Anagram 
{
	public static void main(String[] args) {
		String givenString="listen";
		char [] givenCharArray=givenString.toCharArray();
		Arrays.sort(givenCharArray);
		String [] names= {"enlists", "google", "inlets", "banana", "snteli"};
		
		System.out.print("Anagrams are ---> ");
		for (String string : names) 
		{
			char [] arrayForSort =string.toLowerCase().toCharArray();
			Arrays.sort(arrayForSort);
			if(string.length()==givenString.length()) {
				int cnt=0;
				for (int i = 0; i < string.length(); i++) 
				{
					if(givenCharArray[i]==arrayForSort[i])
					{
						cnt++;
					}
				}
				if(cnt==arrayForSort.length)
					System.out.print(string+" | ");
			}
		}
	}
	
	
}
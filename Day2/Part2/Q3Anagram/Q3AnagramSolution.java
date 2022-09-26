package com.cognologix.Day2.Part2.Q3Anagram;

import java.util.Arrays;

public class Q3AnagramSolution {


	public void checkingAnagram(String[] names, String givenString, char[] givenCharArray) {
		System.out.print("Anagrams are ---> ");
		for (String string1 : names) {
			String string = "";

			/* taking the single string from array and take only Alphabets from this */
			string = onlyAlphabates(string, string1);

			/* checking Anagrams from string array */
			anagramsFromStringArray(string, givenString, givenCharArray, string1);

		}

	}

	public void anagramsFromStringArray(String string, String givenString, char[] givenCharArray,
			String string1) {
		char[] arrayForSort = string.toLowerCase().toCharArray();
		Arrays.sort(arrayForSort);
		if (string.length() == givenString.length()) {
			Integer cnt = 0;
			for (int i = 0; i < string.length(); i++) {
				if (givenCharArray[i] == arrayForSort[i]) {
					cnt++;
				}
			}
			if (cnt == arrayForSort.length)
				System.out.print(string1 + " | ");
		}

	}

	public String onlyAlphabates(String string, String string1) {
		for (int i = 0; i < string1.length(); i++) {
			Character character = string1.charAt(i);
			if ((character >= 65 && character <= 90) || (character >= 97 && character <= 122))
				string += (char) (character);
		}

		return string;
	}

	public char[] sortingInput(String givenString) {
		char[] givenCharArray = givenString.toCharArray();
		Arrays.sort(givenCharArray);
		return givenCharArray;
	}

	public String giinputWord(String givenString, String givenString1) {
		for (int i = 0; i < givenString1.length(); i++) {
			Character character = givenString1.charAt(i);
			if ((character >= 65 && character <= 90) || (character >= 97 && character <= 122))
				givenString += (char) (character);
		}
		return givenString;
	}

}
package com.cognologix.Day2.Part2.Q3Anagram;

import java.util.Arrays;

public class Q3Anagram {
	public static void main(String[] args) {

		Q3Anagram object=new Q3Anagram();
//		String givenString1="listen";
		String givenString1 = "dormitory";
		String givenString = "";
		String[] names = { "enlists", "google", "inlets", "banana", "snteli", "dirty     36362*/*/525room" };

		/* Getting String with only alphabets */
		givenString = object.giinputWord(givenString, givenString1);

		/* Sorting the given input */
		char[] givenCharArray = object.sortingInput(givenString);

		/* Checking Strings from given array */
		object.checkingAnagram(names, givenString, givenCharArray);

	}

	private void checkingAnagram(String[] names, String givenString, char[] givenCharArray) {
		System.out.print("Anagrams are ---> ");
		for (String string1 : names) {
			String string = "";

			/* taking the single string from array and take only Alphabets from this */
			string = onlyAlphabates(string, string1);

			/* checking Anagrams from string array */
			anagramsFromStringArray(string, givenString, givenCharArray, string1);

		}

	}

	private void anagramsFromStringArray(String string, String givenString, char[] givenCharArray,
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

	private String onlyAlphabates(String string, String string1) {
		for (int i = 0; i < string1.length(); i++) {
			Character character = string1.charAt(i);
			if ((character >= 65 && character <= 90) || (character >= 97 && character <= 122))
				string += (char) (character);
		}

		return string;
	}

	private char[] sortingInput(String givenString) {
		char[] givenCharArray = givenString.toCharArray();
		Arrays.sort(givenCharArray);
		return givenCharArray;
	}

	private String giinputWord(String givenString, String givenString1) {
		for (int i = 0; i < givenString1.length(); i++) {
			Character character = givenString1.charAt(i);
			if ((character >= 65 && character <= 90) || (character >= 97 && character <= 122))
				givenString += (char) (character);
		}
		return givenString;
	}

}
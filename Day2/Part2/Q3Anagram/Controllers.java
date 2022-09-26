package com.cognologix.Day2.Part2.Q3Anagram;

public class Controllers {
	public static void main(String[] args) {

		Q3AnagramSolution anagramSolution=new Q3AnagramSolution();
//		String givenString1="listen";
		String givenString1 = "dormitory";
		String givenString = "";
		String[] names = { "enlists", "google", "inlets", "banana", "snteli", "dirty     36362*/*/525room" };

		/* Getting String with only alphabets */
		givenString = anagramSolution.giinputWord(givenString, givenString1);

		/* Sorting the given input */
		char[] givenCharArray = anagramSolution.sortingInput(givenString);

		/* Checking Strings from given array */
		anagramSolution.checkingAnagram(names, givenString, givenCharArray);

	}
}

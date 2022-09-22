package com.cognologix.Part1.Q6Candidade;

import com.cognologix.Part1.Q6Candidade.Solution.QSixSolution;

/*    6. Max Votes in Constituency

22, Ravi Pawar, Aundh, 1603
23, Suvarna Kale, Baner, 803
27, Vinod Chavan, Aundh, 809
29, Vasant Mahajan, Aundh, 617
32, Aarti Patil, Baner, 351
34, Swaran Bijur, Baner, 352
Each line consists of 4 fields: "Candidate ID," "Name," "Constituency," and "Votes." 
Here, "Candidate ID" and "Votes" are integers, while "Name" and "Constituency" are 
strings that do not contain commas or newlines. Write a program to find the Candidate IDs 
of the candidate with highest votes in each constituency. Specifically, processData should 
return a Map where each key is the name of a constituency, and the value is the Candidate ID of 
the candidate in that constituency who has the highest votes.
If your program is run with the input given above, it should produce this output:
Aundh:22
Baner:23
This is because Candidate ID 22 (Ravi Pawar) has the highest votes in Aundh, and 
Candidate ID 23 (Suvarna Kale) has the highest votes in Baner*/
public class QSixMaxVoteConsist {
	
	public static void main(String[] args) {
		
		String [] input= {"22, Ravi Pawar, Aundh, 1603",
				"23, Suvarna Kale, Baner, 803",
				"27, Vinod Chavan, Aundh, 809",
				"29, Vasant Mahajan, Aundh, 617",
				"32, Aarti Patil, Baner, 351",
				"34, Swaran Bijur, Baner, 352"};
		
		QSixSolution object=new QSixSolution();
		/*Input reading method*/
		object.inputReading(input);

		/*Getting unique consistency names in set*/
		object.setOfConsistencies();
		
		/*Getting final result*/
		object.finalResult();		
	}
}

package com.cognologix;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.cognologix.mapper.ElectionCadidateMapper;
import com.cognologix.model.Candidate;
import com.cognologix.parser.InputParser;
import com.cognologix.services.ElectionVoteCalculatorService;

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
public class ElectionVoteCalculatorTest {
	
	public static void main(String[] args) {
		
		String [] candidadeInformtion= {
				"22, Ravi Pawar, Aundh, 1603",
				"23, Suvarna Kale, Baner, 803",
				"27, Vinod Chavan, Aundh, 809",
				"29, Vasant Mahajan, Aundh, 617",
				"32, Aarti Patil, Baner, 351",
				"34, Swaran Bijur, Baner, 352"
		};
		// class for parsing array and Map with ArrayList of candidate Details
		InputParser<Candidate> parser=new InputParser<>(new ElectionCadidateMapper());

		// method in CandidateInputParser class returns list of Candidate information
		final List<Candidate> candidadesList=parser.parseArray(candidadeInformtion);
		
		// class for calculating the highest Vote		
		ElectionVoteCalculatorService voteCalculator=new ElectionVoteCalculatorService(candidadesList);

		// method in class VoteCalculator returns set of consistencies
		final Set<String> consistencies=voteCalculator.getConsistencies();
		
		// method in class VoteCalculator gives the maximum getting vote candidate
		final Map<String, Candidate> getHighrstVoteCandidate=voteCalculator.getIdOfHighestVoteGettingCandidate();
		getHighrstVoteCandidate.entrySet().stream()
		.forEach(e -> System.out.println(e.getKey()+" : "+e.getValue().getCandidateID()));
	}
}

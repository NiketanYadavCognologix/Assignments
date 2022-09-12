package com.cognologix.Day2.Part1.QSixCandidade;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

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

	static List<QSixCandidade> arrayList=new ArrayList<QSixCandidade>();
	static Set<String> consistuncies=new TreeSet<String>();
	static Map<String, Integer> map=new HashMap<String, Integer>();
	
	public static void main(String[] args) {
		
		String [] input= {"22, Ravi Pawar, Aundh, 1603",
				"23, Suvarna Kale, Baner, 803",
				"27, Vinod Chavan, Aundh, 809",
				"29, Vasant Mahajan, Aundh, 617",
				"32, Aarti Patil, Baner, 351",
				"34, Swaran Bijur, Baner, 352"};
		
		for (int i = 0; i < input.length; i++) {
			String inputOne=input[i];
			String [] candidadeInfo=inputOne.split(", ");
			
			QSixCandidade candidade=new QSixCandidade();
			
			int candidadeId=Integer.valueOf(candidadeInfo[0]);
			int vote=Integer.valueOf(candidadeInfo[3]);
			
			candidade.setCandidateID(candidadeId);
			candidade.setName(candidadeInfo[1]);
			candidade.setConstituency(candidadeInfo[2]);
			candidade.setVotes(vote);
			
			arrayList.add(candidade);
		}
		
		Iterator<QSixCandidade> it=arrayList.iterator();
		while(it.hasNext())
		{
			QSixCandidade oneCandidade=it.next();
			consistuncies.add(oneCandidade.getConstituency());
		}
		
		for (String consist : consistuncies) 
		{
			int maxVotes=0;
			QSixCandidade maxVotesGetedCandidade=null;
			
			for (int i = 0; i < input.length; i++) {

				int votes=arrayList.get(i).getVotes();
				if(arrayList.get(i).getConstituency().equals(consist))
				{
					if(maxVotes<votes)
					{
						maxVotes=votes;
						maxVotesGetedCandidade=arrayList.get(i);
					}
				}
			}
			map.put(maxVotesGetedCandidade.getConstituency(), maxVotesGetedCandidade.getCandidateID());
		}
		System.out.println(map);
	}
}

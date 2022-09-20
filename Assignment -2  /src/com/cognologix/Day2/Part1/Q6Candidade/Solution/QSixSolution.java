package com.cognologix.Day2.Part1.Q6Candidade.Solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import com.cognologix.Day2.Part1.Q6Candidade.Model.QSixCandidade;

public class QSixSolution {
	

	List<QSixCandidade> arrayList=new ArrayList<QSixCandidade>();
	Set<String> consistuncies=new TreeSet<String>();
	Map<String, Integer> map=new HashMap<String, Integer>();
	
	public void finalResult() {
		for (String consist : consistuncies) 
		{
			Integer maxVotes=0;
			QSixCandidade maxVotesGetedCandidade=null;
			
			for (int i = 0; i < arrayList.size(); i++) {

				Integer votes=arrayList.get(i).getVotes();
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

	public void setOfConsistencies() {
		
		for (QSixCandidade oneCandidade : arrayList) {
			consistuncies.add(oneCandidade.getConstituency());
		}
		
		//********You can also use Iterator************ 		
		/*
		Iterator<QSixCandidade> it=arrayList.iterator();
		while(it.hasNext())
		{
			QSixCandidade oneCandidade=it.next();
			consistuncies.add(oneCandidade.getConstituency());
		}
		*/
		
	}

	public void inputReading(String[] input) {
		for (int i = 0; i < input.length; i++) {
			String inputOne=input[i];
			String [] candidadeInfo=inputOne.split(", ");
			
			QSixCandidade candidade=new QSixCandidade();
			
			Integer candidadeId=Integer.valueOf(candidadeInfo[0]);
			Integer vote=Integer.valueOf(candidadeInfo[3]);
			
			candidade.setCandidateID(candidadeId);
			candidade.setName(candidadeInfo[1]);
			candidade.setConstituency(candidadeInfo[2]);
			candidade.setVotes(vote);
			
			arrayList.add(candidade);
		}
		
	}
}

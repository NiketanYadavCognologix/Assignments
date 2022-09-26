package com.cognologix.Part1.Q6Candidade.Solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.cognologix.Part1.Q6Candidade.Model.Candidade;

public class VoteCalculator {

	List<Candidade> candidadesList;

	public VoteCalculator(List<Candidade> candidadesList) {
		this.candidadesList = candidadesList;
	}

	public Set<String> getConsistencies() {
		Set<String> consistunciesSet = new TreeSet<String>();
		for (Candidade oneCandidade : candidadesList) {
			consistunciesSet.add(oneCandidade.getConstituency());
		}
		return consistunciesSet;
	}

	public void getMaximumGettingVoteCandidates(Set<String> consistencies) {
		List<Candidade> maxVoteGettingCandidates = new ArrayList<Candidade>();

		for (String consist : consistencies) {
			Integer maxVotes = 0;
			Candidade maxVotesGetedCandidade = new Candidade();

			for (Candidade candidade : candidadesList) {
				Integer votes = candidade.getVotes();
				if (candidade.getConstituency().equals(consist)) {
					if (maxVotes < votes) {
						maxVotes = votes;
						maxVotesGetedCandidade = candidade;
					}
				}
			}

			maxVoteGettingCandidates.add(maxVotesGetedCandidade);
		}
		printResult(maxVoteGettingCandidates);
	}

	private void printResult(List<Candidade> maxVoteGettingCandidates) {
		for (Candidade candidade : maxVoteGettingCandidates) {
			System.out.println(candidade.getConstituency() + " : " + candidade.getCandidateID());
		}

	}
}

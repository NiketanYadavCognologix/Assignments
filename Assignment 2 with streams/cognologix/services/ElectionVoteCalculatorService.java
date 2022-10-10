package com.cognologix.services;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import com.cognologix.model.Candidate;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.*;

public class ElectionVoteCalculatorService {

	List<Candidate> candidates;

	public ElectionVoteCalculatorService(List<Candidate> candidadesList) {
		this.candidates = candidadesList;
	}

	public Set<String> getConsistencies() {
		return candidates.stream().map(candidades -> candidades.getConstituency()).collect(Collectors.toSet());
	}

	public Map<String, Candidate> getIdOfHighestVoteGettingCandidate() {
		Map<String, Candidate> highestVoteCandidate = candidates.stream()
				.collect(groupingBy(candidate -> candidate.getConstituency(),
						collectingAndThen(maxBy(comparingInt(c -> c.getVotes())), Optional::get)));
		return highestVoteCandidate;

	}

}

package com.cognologix.mapper;

import com.cognologix.model.Candidate;

public class ElectionCadidateMapper implements CSVToPojoMapper<Candidate> {

	private Integer candidateID;
	private String name;
	private String constituency;
	private Integer votes;

	@Override
	public Candidate map(String[] input) {
		
		candidateID=Integer.parseInt(input[0].trim());
		name=input[1].trim();
		constituency=input[2].trim();
		votes=Integer.parseInt(input[3].trim());
		Candidate candidade=new Candidate(candidateID, name, constituency, votes);
		return candidade;
	}

}

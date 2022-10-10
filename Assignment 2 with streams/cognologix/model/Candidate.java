package com.cognologix.model;

public class Candidate {
	private Integer candidateID;
	private String name;
	private String constituency;
	private Integer votes;

	public Candidate() {
	}

	public Candidate(Integer candidateID, String name, String constituency, Integer votes) {
		super();
		this.candidateID = candidateID;
		this.name = name;
		this.constituency = constituency;
		this.votes = votes;
	}

	public Integer getCandidateID() {
		return candidateID;
	}

	public void setCandidateID(Integer candidateID) {
		this.candidateID = candidateID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getConstituency() {
		return constituency;
	}

	public void setConstituency(String constituency) {
		this.constituency = constituency;
	}

	public Integer getVotes() {
		return votes;
	}

	public void setVotes(Integer votes) {
		this.votes = votes;
	}

	@Override
	public String toString() {
		String dataHolder = "CandidateID : {0} | Name : {1} | Constituency : {2} | Votes : {3}";
		return java.text.MessageFormat.format(dataHolder, candidateID, name, constituency, votes);
	}
}

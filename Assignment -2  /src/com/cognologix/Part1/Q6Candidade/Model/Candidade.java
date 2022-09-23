package com.cognologix.Part1.Q6Candidade.Model;


public class Candidade {
	private Integer CandidateID;
	private String Name;
	private String Constituency;
	private Integer Votes;
	public Candidade() {}
	public Candidade(int candidateID, String name, String constituency, int votes) {
		CandidateID = candidateID;
		Name = name;
		Constituency = constituency;
		Votes = votes;
	}
	public Integer getCandidateID() {
		return CandidateID;
	}
	public void setCandidateID(int candidateID) {
		CandidateID = candidateID;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getConstituency() {
		return Constituency;
	}
	public void setConstituency(String constituency) {
		Constituency = constituency;
	}
	public Integer getVotes() {
		return Votes;
	}
	public void setVotes(int votes) {
		Votes = votes;
	}
	@Override
	public String toString() {
		return "QSixCandidade [CandidateID=" + CandidateID + ", Name=" + Name + ", Constituency=" + Constituency
				+ ", Votes=" + Votes + "]";
	}
}

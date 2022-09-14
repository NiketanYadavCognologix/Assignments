package com.cognologix.Day2.Part1.Q6Candidade;


public class QSixCandidade {
	private int CandidateID;
	private String Name;
	private String Constituency;
	private int Votes;
	public QSixCandidade() {}
	public QSixCandidade(int candidateID, String name, String constituency, int votes) {
		CandidateID = candidateID;
		Name = name;
		Constituency = constituency;
		Votes = votes;
	}
	public int getCandidateID() {
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
	public int getVotes() {
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

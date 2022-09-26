package com.cognologix.Part1.Q6Candidade.mapper;

import com.cognologix.Part1.Q6Candidade.Model.Candidade;

public class CandidateInputMapper {
	public static Candidade map(String inputData) {
		String[] candidadeInfo = inputData.split(",");

		Candidade candidade = new Candidade();

		candidade.setCandidateID(Integer.valueOf(candidadeInfo[0].trim()));
		candidade.setName(candidadeInfo[1]);
		candidade.setConstituency(candidadeInfo[2]);
		candidade.setVotes(Integer.valueOf(candidadeInfo[3].trim()));
		return candidade;
	}
}

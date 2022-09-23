package com.cognologix.Part1.Q6Candidade.mapper;

import com.cognologix.Part1.Q6Candidade.Model.Candidade;

public class CandidateInputMapper {
	public static Candidade map(String inputData) {
		String[] candidadeInfo = inputData.split(",");

		Candidade candidade = new Candidade();

		Integer candidadeId = Integer.valueOf(candidadeInfo[0].trim());
		Integer vote = Integer.valueOf(candidadeInfo[3].trim());

		candidade.setCandidateID(candidadeId);
		candidade.setName(candidadeInfo[1]);
		candidade.setConstituency(candidadeInfo[2]);
		candidade.setVotes(vote);
		return candidade;
	}
}

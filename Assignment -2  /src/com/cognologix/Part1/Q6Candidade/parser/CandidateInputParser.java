package com.cognologix.Part1.Q6Candidade.parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.cognologix.Part1.Q6Candidade.Model.Candidade;
import com.cognologix.Part1.Q6Candidade.mapper.CandidateInputMapper;

public class CandidateInputParser {

	public List<Candidade> candidadeCSVPaser(String inputFilePath) {
		List<Candidade> candidadesList = new ArrayList<Candidade>();

		File file = new File(inputFilePath);

		try (FileReader fileReader = new FileReader(file)) {
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String inputCndidadeString;
			while ((inputCndidadeString = bufferedReader.readLine()) != null) {
				Candidade candidade = CandidateInputMapper.map(inputCndidadeString);
				candidadesList.add(candidade);
			}
		} catch (FileNotFoundException fileNotFoundException) {
			throw new RuntimeException(fileNotFoundException);
		} catch (IOException ioException) {
			throw new RuntimeException(ioException);
		}

		return candidadesList;
	}
}

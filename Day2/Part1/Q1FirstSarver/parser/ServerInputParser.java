package com.cognologix.Part1.Q1FirstSarver.parser;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.cognologix.Part1.Q1FirstSarver.Model.Server;
import com.cognologix.Part1.Q1FirstSarver.mapper.ServerInputMapper;

public class ServerInputParser {
	public List<Server> ServerCSVParser(String inputFilePath)
	{
		List<Server> serversList=new ArrayList<Server>();
		
		try (FileReader fileReader=new FileReader(inputFilePath)){
			BufferedReader bufferedReader=new BufferedReader(fileReader);
			String inputServerString;

			while((inputServerString=bufferedReader.readLine())!=null)
			{
				Server server=ServerInputMapper.mapInputDataToServerObject(inputServerString);
				serversList.add(server);
			}
		} 
		catch (FileNotFoundException fileNotFoundException) {
			throw new RuntimeException(fileNotFoundException);
		}
		catch (IOException ioException) {
			throw new RuntimeException(ioException);
		}
		return serversList;
	}
}

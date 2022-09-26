package com.cognologix.Part1.Q1FirstSarver.mapper;

import com.cognologix.Part1.Q1FirstSarver.Model.Server;

public class ServerInputMapper {

	public static Server mapInputDataToServerObject(String inputData)
	{
		String[] splittedString = inputData.split(",");

		Server server = new Server();
		server.setServerName(splittedString[0].trim());
		server.setSoftwareType(splittedString[1].trim());
		server.setSoftwreName(splittedString[2].trim());
		server.setVersion(splittedString[3].trim());
		return server;
	}
}

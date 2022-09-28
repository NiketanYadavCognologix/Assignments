package com.cognologix.Q2.mapper;

import com.cognologix.Q2.module.Server;

public class ServerInputMapper {

	public static Server map(String inputData)
	{
		String [] inputSplittedServerData=inputData.split(",");
		Server server=new Server();
		server.setServerName(inputSplittedServerData[0]);
		server.setSoftwareType(inputSplittedServerData[1]);
		server.setSoftwareName(inputSplittedServerData[2]);
		server.setSoftwareVersion(inputSplittedServerData[3]);
		return server;
	}
}

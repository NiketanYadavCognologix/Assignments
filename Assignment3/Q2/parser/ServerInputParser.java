package com.cognologix.Q2.parser;

import java.util.ArrayList;
import java.util.List;

import com.cognologix.Q2.mapper.ServerInputMapper;
import com.cognologix.Q2.module.Server;

public class ServerInputParser {

	public List<Server> parseInputArray(String [] inputArrayOfString)
	{
		List<Server> serversList=new ArrayList<Server>();
		for (String serverString : inputArrayOfString) {
			Server server=ServerInputMapper.map(serverString);
			serversList.add(server);
		}
		return serversList;
	}
}

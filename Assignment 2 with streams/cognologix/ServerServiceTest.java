package com.cognologix;

import java.lang.module.ModuleDescriptor.Version;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;

import com.cognologix.mapper.ServerMapper;
import com.cognologix.model.Server;
import com.cognologix.parser.InputParser;
import com.cognologix.services.ServerService;

public class ServerServiceTest {
	public static void main(String[] args) {
		String[] serversInformation = { "Server1, Database, MySQL,5.5", 
				"Server2, Database, MySQL,5.1",
				"Server3, OS, Ubuntu,12.04", 
				"Server1, OS, Ubuntu,12.04", 
				"Server2, OS, Ubuntu,18.04",
				"Server3, Language, Python,2.6.3", 
				"Server4, Language, Python,3.10.14",
				"Server4, Language, Python,3.9.4" };
		
		InputParser<Server> parser=new InputParser<Server>(new ServerMapper());
		
		List<Server> servers=parser.parseArray(serversInformation);
		
		ServerService versionCaculator=new ServerService(servers);
		
		System.out.println("**********************sorted List By Server Name*************************");
		List<Server> sortedListByServerName=versionCaculator.getSortedListByServerName();
		sortedListByServerName.stream().forEach(System.out::println);
		
		System.out.println("**********************sorted By Name Software And Version*************************");
		List<Server> sortedByNameSoftwareAndVersion=versionCaculator.getSortedByNameSoftwareAndVersion();
		sortedByNameSoftwareAndVersion.stream().forEach(System.out::println);
		
		System.out.println("**********************distinct Server Names*************************");
		List<String> distinctServerNames=versionCaculator.getDistinctServerNames();
		distinctServerNames.stream().forEach(System.out::println);
		
		System.out.println("**********************records For Given Server Name*************************");
		String inputServerName="Server1";
		List<Server> recordsForGivenServerName=versionCaculator.getRecordsForGivenServerName(inputServerName);
		recordsForGivenServerName.stream().forEach(System.out::println);

		System.out.println("**********************creating the Map*************************");
		Map<String, SortedSet<String>> mapOfSoftwareersionsSet=versionCaculator.getMapOfSoftwareersionsSet();
		System.out.println(mapOfSoftwareersionsSet);

	}
}

package com.cognologix.services;

import java.lang.module.ModuleDescriptor.Version;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.cognologix.model.Server;

public class ServerService {
	List<Server> serversList;

	public ServerService(List<Server> serversList) {
		this.serversList = serversList;
	}

	public List<Server> getSortedListByServerName() {
		List<Server> sortedListByServerName=new ArrayList<Server>();
		sortedListByServerName=serversList.stream()
				.sorted(Comparator.comparing(Server::getServerName))
				.collect(Collectors.toList());
		return sortedListByServerName;
	}

	public List<Server> getSortedByNameSoftwareAndVersion() {
		List<Server> sortedByNameSoftwareAndVersion=new ArrayList<Server>();
		sortedByNameSoftwareAndVersion=serversList.stream()
				.sorted(Comparator.comparing(Server::getServerName).thenComparing(Server::getSoftwareName).thenComparing(Server::getSoftwareVersion))

//				.map(Server::getSoftwareVersion -> Version::parse)
//				
//				.sorted(Comparator.comparing(Server::getServerName).thenComparing(Server::getSoftwareName).new SoftwarVersionComparator())
				
				.collect(Collectors.toList());
		return sortedByNameSoftwareAndVersion;
	}

	public List<String> getDistinctServerNames() {
		List<String> distinctServerNames=new ArrayList<String>();
		distinctServerNames=serversList.stream()
				.map(server -> server.getServerName())
				.distinct()
				.collect(Collectors.toList());
				return distinctServerNames;
	}

	public List<Server> getRecordsForGivenServerName(String inputServerName) {
		List<Server> recordsForGivenServerName=new ArrayList<Server>();
		recordsForGivenServerName=serversList.stream()
				.filter(server->inputServerName.equals(server.getServerName()))
				.collect(Collectors.toList());
		return recordsForGivenServerName;
	}

	public Map<String, List<Version>> getMapOfSoftwareersionsSet(Set<String> softwareNameSet) {
		Map<String, List<Version>> mapOfSoftwareersionsSet=new HashMap<String, List<Version>>();
		for (String softwareName : softwareNameSet) 
		{
			List<Version> versionsSetOfSoftware=new ArrayList<>();
			versionsSetOfSoftware=serversList.stream()
					.filter(server -> server.getSoftwareName().equals(softwareName))
					.map(server-> server.getSoftwareVersion())
					.map(Version::parse)
					.distinct()
					.sorted()
					.collect(Collectors.toList());

			mapOfSoftwareersionsSet.put(softwareName, versionsSetOfSoftware);
		}
		return mapOfSoftwareersionsSet;
	}

	public Set<String> getSoftwareNameSet() {

		Set<String> softwareNameSet=new HashSet<String>();
		softwareNameSet=serversList.stream()
				.map(server -> server.getSoftwareName())
				.distinct()
				.collect(Collectors.toSet());
				return softwareNameSet;
	} 
}

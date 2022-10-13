package com.cognologix.services;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.*;

import com.cognologix.model.Employee;
import com.cognologix.model.Server;

public class ServerService {
	List<Server> servers;

	public ServerService(List<Server> serversList) {
		this.servers = serversList;
	}

	public List<Server> getSortedListByServerName() {
		List<Server> sortedListByServerName = new ArrayList<Server>();
		sortedListByServerName = servers.stream().sorted(Comparator.comparing(Server::getServerName))
				.collect(Collectors.toList());
		return sortedListByServerName;
	}

	public List<Server> getSortedByNameSoftwareAndVersion() {
		List<Server> sortedByNameSoftwareAndVersion = new ArrayList<Server>();
		sortedByNameSoftwareAndVersion = servers.stream().sorted(Comparator.comparing(Server::getServerName)
				.thenComparing(Server::getSoftwareName).thenComparing(Server::getSoftwareVersion))
				.collect(Collectors.toList());
		return sortedByNameSoftwareAndVersion;
	}

	public List<String> getDistinctServerNames() {
		List<String> distinctServerNames = new ArrayList<String>();
		distinctServerNames = servers.stream().map(server -> server.getServerName()).distinct()
				.collect(Collectors.toList());
		return distinctServerNames;
	}

	public List<Server> getRecordsForGivenServerName(String inputServerName) {
		List<Server> recordsForGivenServerName = new ArrayList<Server>();
		recordsForGivenServerName = servers.stream().filter(server -> inputServerName.equals(server.getServerName()))
				.collect(Collectors.toList());
		return recordsForGivenServerName;
	}

	public Map<String, SortedSet<String>> getMapOfSoftwareersionsSet() {
		Map<String, SortedSet<String>> softwareNameVersions = servers.stream()
				.collect(Collectors.toMap(Server::getSoftwareName, server -> {
					SortedSet<String> versions = new TreeSet<String>(new SoftwarVersionComparator());
					versions.add(server.getSoftwareVersion());
					return versions;
				}, (prev, current) -> {
					prev.addAll(current);
					return prev;
				}));
		return softwareNameVersions;

	}

	public Set<String> getSoftwareNameSet() {

		Set<String> softwareNameSet = new HashSet<String>();
		softwareNameSet = servers.stream().map(server -> server.getSoftwareName()).distinct()
				.collect(Collectors.toSet());
		return softwareNameSet;
	}
}

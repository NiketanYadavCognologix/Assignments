package com.cognologix.Part1.Q1FirstSarver.Solution;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.cognologix.Part1.Q1FirstSarver.Model.Server;

public class OutdatedVersionCalculator {

	List<Server> serverList;

	public OutdatedVersionCalculator(List<Server> serversList) {
		this.serverList = serversList;
	}

	public Set<String> setOfSoftwareNames() {
		Set<String> softwareNamesSet = new HashSet<String>();
		for (Server server : serverList) {
			softwareNamesSet.add(server.getSoftwreName());
		}
		return softwareNamesSet;
	}

	public List<Server> getLatestVersionUsingServer(Set<String> softwareSet) {
		List<Server> latestVersionUsingServer = new ArrayList<>();
		for (String software : softwareSet) {
			String maximumVersion = "";
			Server maximumVersionSoftware = null;
			for (Server serverFromListOfServer :serverList) {
				if (serverFromListOfServer.getSoftwreName().equals(software)) {
					for (int j = 0; j < serverList.size(); j++) {

						if (serverFromListOfServer.getVersion().compareTo(maximumVersion) > 0) {
							maximumVersion = serverFromListOfServer.getVersion();
							maximumVersionSoftware = serverFromListOfServer;
						}
					}
				}
			}

			latestVersionUsingServer.add(maximumVersionSoftware);
		}

		return latestVersionUsingServer;
	}

	public void printOutDatedVersionServer(List<Server> latestVersionServer) {
		List<Server> outDatedVersionSoftwareList=new ArrayList<Server>();
		for (Server server : latestVersionServer) {
			Integer count = 0;
			for (Server serverFromListOfServer :serverList) {
				if(server.getSoftwreName().equals(serverFromListOfServer.getSoftwreName()))
				{
					if(!server.getVersion().equals(serverFromListOfServer.getVersion())&&count<1)
						count++;
					else if(!server.getVersion().equals(serverFromListOfServer.getVersion()))
						outDatedVersionSoftwareList.add(server);
				}
			}
		}
		
		printResult(outDatedVersionSoftwareList);

	}

	public void printResult(List<Server> outDatedVersionSoftwareList) {

		for (Server server : outDatedVersionSoftwareList) 
		System.out.println("Outdated Version is ---> " + server.getSoftwreName());
	}

}

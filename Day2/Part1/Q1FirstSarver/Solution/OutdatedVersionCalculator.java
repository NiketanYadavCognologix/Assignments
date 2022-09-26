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
			String maxVersion = "";
			Server maxVersionSoftware = null;
			for (int i = 0; i < serverList.size(); i++) {
				if (serverList.get(i).getSoftwreName().equals(software)) {
					for (int j = 0; j < serverList.size(); j++) {

						if (serverList.get(i).getVersion().compareTo(maxVersion) > 0) {
							maxVersion = serverList.get(i).getVersion();
							maxVersionSoftware = serverList.get(i);
						}
					}
				}
			}

			latestVersionUsingServer.add(maxVersionSoftware);
		}

		return latestVersionUsingServer;
	}

	public void printOutDatedVersionServer(List<Server> latestVersionServer) {
		List<Server> outDatedVersionSoftwareList=new ArrayList<Server>();
		for (Server server : latestVersionServer) {
			Integer cnt = 0;
			for (int i = 0; i < serverList.size(); i++) {
				if(server.getSoftwreName().equals(serverList.get(i).getSoftwreName()))
				{
					if(!server.getVersion().equals(serverList.get(i).getVersion())&&cnt<1)
						cnt++;
					else if(!server.getVersion().equals(serverList.get(i).getVersion()))
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

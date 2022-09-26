package com.cognologix.Part1.Q1FirstSarver;

import java.util.List;
import java.util.Set;

import com.cognologix.Part1.Q1FirstSarver.Model.Server;
import com.cognologix.Part1.Q1FirstSarver.Solution.OutdatedVersionCalculator;
import com.cognologix.Part1.Q1FirstSarver.parser.ServerInputParser;

/*1. Out of Date Software

Consider the following data in array of strings
Server1, Database, MySQL, 5.5
Server2, Database, MySQL, 5.1
Server3, OS, Ubuntu, 12.04
Server1, OS, Ubuntu, 12.04
Server2, OS, Ubuntu, 18.04
Server3, Language, Python, 2.6.3

Server1 has version 5.5 of MySQL installed, Server2 has version 5.1 installed, and Server3 has version 12.04 of Ubuntu installed.
For the purposes of this program, assume that all version numbers are of the form X.Y or X.Y.Z where X, Y, and Z are made up of only digits.

Write a java program to display a list of software package names for which an out-of-date version  (i.e. a version which is not the latest version)
 is installed on at least 2 different servers. 
Thus, in this case, the output of your program should be:
Ubuntu
Because Ubuntu 12.04 is an out-of-date version (the latest version is 18.04), and it is installed on two servers (Server 3, and Server 1).*/
public class Main {
	
	public static void main(String[] args) {
		
		// class for parsing the input data
		ServerInputParser inputParser=new ServerInputParser();

		String inputFilePath="/home/niketanyadav/eclipse-workspace/Testing/Assignment2/src/com/cognologix/Part1/Q1FirstSarver/files/input.csv";
		
		// method in ServerInputParser class returns list of server's
		List<Server> serversList=inputParser.ServerCSVParser(inputFilePath);
		
		// class calculates the versions
		OutdatedVersionCalculator  versionCalculator=new OutdatedVersionCalculator(serversList);
		
		// method in class OutdatedVersionCalculator returns the set of versions
		Set<String> softwareSet=versionCalculator.setOfSoftwareNames();
		
		// method in lass OutdatedVersionCalculator returns the latest version software server 
		List<Server> latestVersionServer=versionCalculator.getLatestVersionUsingServer(softwareSet);

		// method in lass OutdatedVersionCalculator  prints the out dated version used minimum two times
		versionCalculator.printOutDatedVersionServer(latestVersionServer);
		
	}

}

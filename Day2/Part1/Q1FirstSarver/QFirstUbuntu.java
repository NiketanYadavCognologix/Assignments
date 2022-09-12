package com.cognologix.Day2.Part1.Q1FirstSarver;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.cognologix.Day2.Q1FirstSarver.QFirstSarver;

/*    1. Out of Date Software

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
public class QFirstUbuntu {
	
	static List<QFirstSarver> list=new ArrayList<QFirstSarver>();
	static Set<String> softwareNameSet=new TreeSet<String>();
	
	public static void main(String[] args) {
		String [] inputArray= {
				"Server1, Database, MySQL, 5.5",
				"Server2, Database, MySQL, 5.1",
				"Server3, OS, Ubuntu, 12.04",
				"Server1, OS, Ubuntu, 12.04",
				"Server2, OS, Ubuntu, 18.04",
				"Server3, Language, Python, 2.6.3"
			};
		
		for (int i = 0; i < inputArray.length; i++)
		{
			String  oneInput=inputArray[i];
			
			String [] splittedString=oneInput.split(", ");
			
			QFirstSarver infoServer= new QFirstSarver();
			infoServer.setServerName(splittedString[0]);
			infoServer.setSoftwareType(splittedString[1]);
			infoServer.setSoftwreName(splittedString[2]);
			infoServer.setVersion(splittedString[3]);
			
			list.add(infoServer);
//			System.out.println(list);
		
		}
		
		Iterator<QFirstSarver> it=list.iterator();
		while(it.hasNext())
		{
			QFirstSarver serverData=it.next();
			softwareNameSet.add(serverData.getSoftwreName());
		}
		
		for (String software : softwareNameSet) 
		{
			int maxVersion=0;
			for (int i = 0; i < inputArray.length; i++) 
			{
				if(list.get(i).getSoftwreName().equals(software))
				{
					for (int j = 0; j < inputArray.length; j++) {
						
						if(list.get(i).getVersion().compareTo())
					}
				}
			}
		}
		
		
		
		
		
		
		
		
		
		/*
		String technology="";
		String repeatingTechnologyMoreThanTwo="";
		for (int i = 0; i < givenArray.length; i++) {
			
			int cnt=0;

			for (int j = 0; j < givenArray[0].length; j++) {
					technology=givenArray[i][2];
					for (int k = 0; k < givenArray.length; k++) {
						if(technology.equals(givenArray[k][j]) && cnt>1)
						{
							technology=givenArray[k][j];
							break;
						}
						else
							cnt++;
					}
			
			}
		}
		System.out.println(technology);
		*/
	}

}
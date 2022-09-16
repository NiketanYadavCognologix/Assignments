package com.cognologix.Day2.Part1.Q1FirstSarver;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

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
	List<QFirstSarver> list = new ArrayList<QFirstSarver>();
	 Set<String> softwareNameSet = new TreeSet<String>();
	 List<String> softwares = new ArrayList<String>();

	public static void main(String[] args) {
		

		String[] inputArray = { "Server1, Database, MySQL, 5.5", "Server2, Database, MySQL, 5.1",
				"Server3, OS, Ubuntu, 12.04", "Server1, OS, Ubuntu, 12.04", "Server2, OS, Ubuntu, 18.04",
				"Server3, Language, Python, 2.6.3" };
		
		QFirstUbuntu ubuntu=new QFirstUbuntu();
		/*Getting input in arrayList*/
		ubuntu.inputInModule(inputArray);
		
		/*Get unique software names in set by using treeSet*/
		ubuntu.uniqueSoftwares();	
		
		/*To find maximum version and getting into one object to compare with others*/
		ubuntu.maxVersionSoftware();
		
		/*Final result getting method*/
		ubuntu.finalResult();
	}

	private void finalResult() {

		for (String oneSoftware : softwares) {
			Integer cnt = 0;
			String result = "";
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getSoftwreName().equals(oneSoftware) && cnt <= 1) {
					cnt++;
				} else if (list.get(i).getSoftwreName().equals(oneSoftware)) {
					result = oneSoftware;
				}
			}

			System.out.print(result + " ");
		}
	}

	private void maxVersionSoftware() {

		for (String software : softwareNameSet) {
			String maxVersion = "";
			QFirstSarver maxVersionSoftware = null;
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getSoftwreName().equals(software)) {
					for (int j = 0; j < list.size(); j++) {

						if (list.get(i).getVersion().compareTo(maxVersion) > 0) {
							maxVersion = list.get(i).getVersion();
							maxVersionSoftware = list.get(i);
						}
					}
				}
			}

			softwares.add(maxVersionSoftware.getSoftwreName());

//			System.out.println(maxVersionSoftware.getSoftwreName()+" ---> "+maxVersion);
		}

	}

	private void uniqueSoftwares() {
		
		Iterator<QFirstSarver> it = list.iterator();
		while (it.hasNext()) {
			QFirstSarver serverData = it.next();
			softwareNameSet.add(serverData.getSoftwreName());
		}

	}

	private void inputInModule(String[] inputArray) {
		for (int i = 0; i < inputArray.length; i++) {
			String oneInput = inputArray[i];

			String[] splittedString = oneInput.split(", ");

			QFirstSarver infoServer = new QFirstSarver();
			infoServer.setServerName(splittedString[0]);
			infoServer.setSoftwareType(splittedString[1]);
			infoServer.setSoftwreName(splittedString[2]);
			infoServer.setVersion(splittedString[3]);

			list.add(infoServer);
//			System.out.println(infoServer); 		//This is just for check the java.text.MassageFormate works. 
//			System.out.println(list);

		}

	}

}

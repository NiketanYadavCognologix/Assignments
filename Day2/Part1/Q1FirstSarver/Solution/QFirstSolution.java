package com.cognologix.Day2.Part1.Q1FirstSarver.Solution;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.cognologix.Day2.Part1.Q1FirstSarver.Model.QFirstSarver;

public class QFirstSolution {

	List<QFirstSarver> list = new ArrayList<QFirstSarver>();
	 Set<String> softwareNameSet = new TreeSet<String>();
	 List<String> softwares = new ArrayList<String>();

	public void finalResult() {

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

	public void maxVersionSoftware() {

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

	public void uniqueSoftwares() {
		
		Iterator<QFirstSarver> it = list.iterator();
		while (it.hasNext()) {
			QFirstSarver serverData = it.next();
			softwareNameSet.add(serverData.getSoftwreName());
		}

	}

	public void inputInModule(String[] inputArray) {
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

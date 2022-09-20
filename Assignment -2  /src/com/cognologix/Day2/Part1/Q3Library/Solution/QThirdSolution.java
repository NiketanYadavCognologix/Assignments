package com.cognologix.Day2.Part1.Q3Library.Solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.cognologix.Day2.Part1.Q3Library.Module.QThirdLibrary;

public class QThirdSolution {

	List<QThirdLibrary> arrayListOfLibraryProduct = new ArrayList<QThirdLibrary>();
	Set<String> treeSetOfLibraryName = new TreeSet<String>();
	List<QThirdLibrary> letestVersionArrayList = new ArrayList<>();
	Set<String> finalAnswer = new TreeSet<String>();
	
	public void finalResult() {
		for (int i = 0; i < arrayListOfLibraryProduct.size(); i++) {
			for (int j = 0; j < letestVersionArrayList.size(); j++) {
				if ((letestVersionArrayList.get(j).getLibraryName()
						.equals(arrayListOfLibraryProduct.get(i).getLibraryName()))
						&& (!letestVersionArrayList.get(j).getLibraryVersion()
								.equals(arrayListOfLibraryProduct.get(i).getLibraryVersion()))) {
					finalAnswer.add(arrayListOfLibraryProduct.get(i).getProductName());

				}
			}

		}

		System.out.println(finalAnswer);
	
	}

	public void letestVersionOfLibrary() {
		for (String set : treeSetOfLibraryName) {

			Integer letestVersion = 0;

			QThirdLibrary letestVersionProduct = null;

			for (int i = 0; i < arrayListOfLibraryProduct.size(); i++) {

				if (set.contentEquals(arrayListOfLibraryProduct.get(i).getLibraryName())) {

					String versionString = arrayListOfLibraryProduct.get(i).getLibraryVersion();
					String letestVersionString = "";
					for (int j = 0; j < versionString.length(); j++) {
						if (versionString.charAt(j) >= 48 && versionString.charAt(j) <= 57)
							letestVersionString += (char) (versionString.charAt(j));

					}
					Integer maxVersion = Integer.valueOf(letestVersionString);

					if (maxVersion > letestVersion) {
						letestVersion = maxVersion;
						letestVersionProduct = arrayListOfLibraryProduct.get(i);
					}
				}
			}
			letestVersionArrayList.add(letestVersionProduct);

		}
	}

	public void setOfLibraryName() {
		for (QThirdLibrary Object : arrayListOfLibraryProduct) {
			treeSetOfLibraryName.add(Object.getLibraryName());
		}
		
		
//********You can also use Iterator************ 		
		/*
		Iterator<QThirdLibrary> it = arrayListOfLibraryProduct.iterator();

		while (it.hasNext()) {
			QThirdLibrary Object = it.next();
			treeSetOfLibraryName.add(Object.getLibraryName());
		}*/
	}

	public List<QThirdLibrary> inputReading(String[] input) {
		for (int i = 0; i < input.length; i++) {
			String inputOneString = input[i];

			String[] productInformationArray = inputOneString.split(",");

			QThirdLibrary libraryProduct = new QThirdLibrary();

			libraryProduct.setProductName(productInformationArray[0]);
			libraryProduct.setLibraryName(productInformationArray[1]);
			libraryProduct.setLibraryVersion(productInformationArray[2]);

			arrayListOfLibraryProduct.add(libraryProduct);
		}
		return arrayListOfLibraryProduct;
	}
}

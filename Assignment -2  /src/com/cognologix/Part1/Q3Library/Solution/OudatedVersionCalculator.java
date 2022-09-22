package com.cognologix.Part1.Q3Library.Solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.cognologix.Part1.Q3Library.Module.Product;

public class OudatedVersionCalculator {

	List<Product> arrayListOfLibraryProduct = new ArrayList<Product>();
	List<Product> letestVersionArrayList = new ArrayList<>();
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

			Product letestVersionProduct = null;

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

	public Set<String> setOfLibraryName(List<Product> productList) {
		Set<String> treeSetOfLibraryName = new TreeSet<String>();
		for (Product Object : productList) {
			treeSetOfLibraryName.add(Object.getLibraryName());
		}
		return treeSetOfLibraryName;
	}

	public List<Product> inputReading(String[] input) {
		for (int i = 0; i < input.length; i++) {
			String inputOneString = input[i];

		}
		return arrayListOfLibraryProduct;
	}
}

package com.cognologix.Part1.Q3Library.Solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.cognologix.Part1.Q3Library.Module.Product;

public class OudatedVersionCalculator {

	List<Product> productsList;
	public OudatedVersionCalculator(List<Product> productsList) {
		this.productsList = productsList;
	}

	public Set<String> setOfLibraryName() {
		Set<String> treeSetOfLibraryName = new TreeSet<String>();
		for (Product Object : productsList) {
			treeSetOfLibraryName.add(Object.getLibraryName());
		}
		return treeSetOfLibraryName;
	}

	public List<Product> getLetestVersionLibrary(Set<String> librariesName) {
		List<Product> letestVersionLibrariesList = new ArrayList<>();

		for (String set : librariesName) {

			Integer letestVersion = 0;

			Product letestVersionProduct = null;

			for (int i = 0; i < productsList.size(); i++) {

				if (set.contentEquals(productsList.get(i).getLibraryName())) {
					Integer maxVersion = productsList.get(i).getLibraryVersion();

					if (maxVersion > letestVersion) {
						letestVersion = maxVersion;
						letestVersionProduct = productsList.get(i);
					}
				}
			}
			letestVersionLibrariesList.add(letestVersionProduct);
		}
		return letestVersionLibrariesList;
	}

	public Set<String> getOutDatedVerions(List<Product> letestVersionLibrariesList) {
		Set<String> finalAnswer = new TreeSet<String>();

		for (Product product: productsList) {
			for (int j = 0; j < letestVersionLibrariesList.size(); j++) {
				if ((letestVersionLibrariesList.get(j).getLibraryName().equals(product.getLibraryName()))
						&& (!letestVersionLibrariesList.get(j).getLibraryVersion()
								.equals(product.getLibraryVersion()))) {
					finalAnswer.add(product.getProductName());

				}
			}
		}
		
		return finalAnswer;
	}

	public void printOutdatedLibraries(Set<String> outdatedVersionProducts) {
		for (String outatedLibrary : outdatedVersionProducts) {
			System.out.println(outatedLibrary);
		}
	}
}

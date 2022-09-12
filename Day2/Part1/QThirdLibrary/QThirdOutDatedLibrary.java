package com.cognologix.Day2.Part1.QThirdLibrary;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/*    3. At Least One Outdated Library

A company has a number of products that they sell to customers, and each product uses one or more internal libraries.
 All internal libraries are given version numbers like v1, v2, v3, ... ete. which are incremented each time the internal 
 library team releases a new version of the library to the product teams

Consider the following data in array of strings which contains information about which versions of the various libraries 
are being used by the current release of each product of the company

Mail Server, Authentication Library, v6
Video Call Server, Authentication Library, v7
Mail Server, Data Storage Library, v10
Chat Server, Data Storage Library, v11
Mail Server, Search Library, v6
Chat Server, Authentication Library, v8
Chat Server, Presence Library, v2
Video Call Server, Data Storage Library, v10
Video Call Server, Video Compression Library, v3

Each line of the input consists of 3 comma-separated fields. The first field is a product name, the second field is a library name, 
and the third field is the library version number used by that product. The example given above indicates that the Mail Server uses 
version v6 of the Authentication Library, and the Video Call Server uses version v7 of the Authentication Library, and 
the Mail Server also uses version v10 of the Data Storage Library. and so on. For the
purposes of this program, assume that all version numbers are of the form v<digits> where <digits> represents one or more decimal digits. 
Write a program to  processes the input data, figures out which is the latest version number of each library, 
and then prints the names of products which are using an outdated version (i.e. a version that is not the latest version) of at least one library, 
to standard output (console). Thus, in case of the example input given above, the output of your program should be
Mail Server
Video Call Server
because Mail Server is using older versions of the Authentication Library and the Data
Storage Library, and Video Call Server ts using an older version of the Authentication
Library. */
public class QThirdOutDatedLibrary {

	static List<QThirdLibrary> arrayListOfLibraryProduct = new ArrayList<QThirdLibrary>();
	static Set<String> treeSetOfLibraryName = new TreeSet<String>();
	static List<QThirdLibrary> letestVersionArrayList = new ArrayList<>();
	static Set<String> finalAnswer = new TreeSet<String>();

	public static void main(String[] args) {

		String[] input = { "Mail Server, Authentication Library, v6", "Video Call Server, Authentication Library, v7",
				"Mail Server, Data Storage Library, v10", "Chat Server, Data Storage Library, v11",
				"Mail Server, Search Library, v6", "Chat Server, Authentication Library, v8",
				"Chat Server, Presence Library, v2", "Video Call Server, Data Storage Library, v10",
				"Video Call Server, Video Compression Library, v3" };

		for (int i = 0; i < input.length; i++) {
			String inputOneString = input[i];

			String[] productInformationArray = inputOneString.split(",");

			QThirdLibrary libraryProduct = new QThirdLibrary();

			libraryProduct.setProductName(productInformationArray[0]);
			libraryProduct.setLibraryName(productInformationArray[1]);
			libraryProduct.setLibraryVersion(productInformationArray[2]);

			arrayListOfLibraryProduct.add(libraryProduct);
		}
		Iterator<QThirdLibrary> it = arrayListOfLibraryProduct.iterator();

		while (it.hasNext()) {
			QThirdLibrary Object = it.next();
			treeSetOfLibraryName.add(Object.getLibraryName());
		}

		for (String set : treeSetOfLibraryName) {

			int letestVersion = 0;

			QThirdLibrary letestVersionProduct = null;

			for (int i = 0; i < input.length; i++) {

				if (set.contentEquals(arrayListOfLibraryProduct.get(i).getLibraryName())) {

					String versionString = arrayListOfLibraryProduct.get(i).getLibraryVersion();
					String letestVersionString = "";
					for (int j = 0; j < versionString.length(); j++) {
						if (versionString.charAt(j) >= 48 && versionString.charAt(j) <= 57)
							letestVersionString += (char) (versionString.charAt(j));

					}
					int maxVersion = Integer.valueOf(letestVersionString);

					if (maxVersion > letestVersion) {
						letestVersion = maxVersion;
						letestVersionProduct = arrayListOfLibraryProduct.get(i);
					}
				}
			}
			letestVersionArrayList.add(letestVersionProduct);

		}

		for (int i = 0; i < input.length; i++) {
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
}

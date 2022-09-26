package com.cognologix.Part1.Q3Library;

import java.util.List;
import java.util.Set;

import com.cognologix.Part1.Q3Library.Module.Product;
import com.cognologix.Part1.Q3Library.Solution.OudatedVersionCalculator;
import com.cognologix.Part1.Q3Library.parser.ProductInputParser;

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
public class Main {

	public static void main(String[] args) {
		try {
			String inputFilePath = "/home/niketanyadav/eclipse-workspace/Testing/Assignment2/src/com/cognologix/Part1/Q3Library/file/input.csv";
			
			// class for parsing CSV file and Map with ArrayList of product
			ProductInputParser inputParser = new ProductInputParser();

			// method getting list of Products into arrayList
			List<Product> productsList = inputParser.productCSVParser(inputFilePath);

			// class for calculate required operation on product
			OudatedVersionCalculator poductVersionCalculator = new OudatedVersionCalculator(productsList);

			// method of get unique library names in ArrrayList
			final Set<String> librariesName = poductVersionCalculator.setOfLibraryName();

			// method to get all updated versions libraries into arrayList
			final List<Product> letestVersionLibrariesList = poductVersionCalculator
					.getLetestVersionLibrary(librariesName);

			// method for get out dated version on server have
			final Set<String> outdatedVersionProducts = poductVersionCalculator.getOutDatedVerions(letestVersionLibrariesList);

			// method for print the result
			poductVersionCalculator.printOutdatedLibraries(outdatedVersionProducts);

		} catch (Exception exception) {
			throw new RuntimeException(exception);
		}

	}

}

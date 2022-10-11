package com.cognologix;

import java.util.List;
import java.util.Set;


import com.cognologix.mapper.LibraryVersionMapper;
import com.cognologix.model.LibraryVersion;
import com.cognologix.parser.InputParser;
import com.cognologix.services.libraryVrsionCalculatorService;

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
public class libraryVersionTest {

	public static void main(String[] args) {

		String [] libraryVresionInput= {
				"Mail Server, Authentication Library, v6",
				"Video Call Server, Authentication Library, v7",
				"Mail Server, Data Storage Library, v10",
				"Chat Server, Data Storage Library, v11",
				"Mail Server, Search Library, v6",
				"Chat Server, Authentication Library, v8",
				"Chat Server, Presence Library, v2",
				"Video Call Server, Data Storage Library, v10",
				"Video Call Server, Video Compression Library, v3"	
		};

		// class for parsing CSV file and Map with ArrayList of product
		InputParser<LibraryVersion> parser = new InputParser<>(new LibraryVersionMapper());

		List<LibraryVersion> products=parser.parseArray(libraryVresionInput);

		// class for calculate required operation on product
		libraryVrsionCalculatorService poductVersionCalculator = new libraryVrsionCalculatorService(products);

		// method to get all updated versions libraries into arrayList
		final Set<String> letestVersionLibrariesList = poductVersionCalculator.getLetestVersionLibrary();
		letestVersionLibrariesList.stream().forEach(System.out::println);
		
	}

}

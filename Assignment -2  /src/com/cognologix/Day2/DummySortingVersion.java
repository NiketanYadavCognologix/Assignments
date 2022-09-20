package com.cognologix.Day2;

import java.lang.module.ModuleDescriptor.Version;
import java.util.Arrays;

public class DummySortingVersion {

	public static void main(String[] args) {
//		 var versions = Arrays.asList(
//				 "5.5",
//				 "5.1",
//				 "2.6.3",
//				 "18.04",
//				 "12.04",
//				 "12.04"
//			    );
//			   versions.stream()
//			      .map(Version::parse)                            //This is used for versions
//			      .sorted()										  //used for sorting
//			      .forEach(System.out::println);				  //used for print
//		
//		var versions= Arrays.asList("5.1","5.6");
//		versions.stream()
//		.map(Version::parse)
		
		
			   String a="5.5";
			   String b="5.1";
			   String c="2.6.3";
			   String t="2.6.4";
			   String d="18.04";
			   String e="12.04";
			   String f="12.04";
			   
			   System.out.println(c.compareTo(t));
	}
}

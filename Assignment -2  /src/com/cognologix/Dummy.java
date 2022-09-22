package com.cognologix;

import java.util.Arrays;

public class Dummy {

	public static void main(String[] args) {

		String[] versions = { "5.5", "5.1", "2.6.3", "18.04", "12.04", "12.04" };

		for (int i = 0; i < versions.length; i++) 
		{
			String version=versions[i];
			String [] a=version.split(".");
			
			if(a.length==2)
			{
				String b=version.replace(".", "");
				System.out.println(b);
			}
		}
	}

}
package com.cognologix.Part1.Q3Library.mapper;

import com.cognologix.Part1.Q3Library.Module.Product;

public class ProductMapper {

	public static Product map(String inputData)
	{
		String[] productInformationArray = inputData.split(",");

		Product libraryProduct = new Product();

		libraryProduct.setProductName(productInformationArray[0]);
		libraryProduct.setLibraryName(productInformationArray[1]);
		libraryProduct.setLibraryVersion(productInformationArray[2]);

		return libraryProduct;
		
	}
}

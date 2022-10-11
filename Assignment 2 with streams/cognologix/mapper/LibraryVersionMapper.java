package com.cognologix.mapper;

import com.cognologix.model.LibraryVersion;

public class LibraryVersionMapper implements CSVToPojoMapper<LibraryVersion>{

	@Override
	public LibraryVersion map(String[] productInformationArray) {
		LibraryVersion libraryProduct = new LibraryVersion();

		libraryProduct.setProductName(productInformationArray[0]);
		libraryProduct.setLibraryName(productInformationArray[1]);
		libraryProduct.setLibraryVersion(Integer.parseInt(productInformationArray[2].replace("v", "").trim()));

		return libraryProduct;
	}
}

package com.cognologix.model;

public class LibraryVersion {

	private String productName;
	private String libraryName;
	private Integer libraryVersion;
	public LibraryVersion() {}
	public LibraryVersion(String productName, String libraryName, Integer libraryVersion) {
		this.productName = productName;
		this.libraryName = libraryName;
		this.libraryVersion = libraryVersion;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getLibraryName() {
		return libraryName;
	}
	public void setLibraryName(String libraryName) {
		this.libraryName = libraryName;
	}
	public Integer getLibraryVersion() {
		return libraryVersion;
	}
	public void setLibraryVersion(Integer libraryVersion) {
		this.libraryVersion = libraryVersion;
	}
	@Override
	public String toString() {
		return java.text.MessageFormat.format("productName : {0} | libraryName : {1} | libraryVersion : {2}",
				productName,libraryName,libraryVersion);
	}
}

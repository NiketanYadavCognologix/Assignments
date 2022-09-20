package com.cognologix.Day2.Part1.Q3Library.Module;

public class QThirdLibrary {

	private String productName;
	private String libraryName;
	private String libraryVersion;
	public QThirdLibrary() {}
	public QThirdLibrary(String productName, String libraryName, String libraryVersion) {
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
	public String getLibraryVersion() {
		return libraryVersion;
	}
	public void setLibraryVersion(String libraryVersion) {
		this.libraryVersion = libraryVersion;
	}
	@Override
	public String toString() {
		return java.text.MessageFormat.format("productName : {0} | libraryName : {1} | libraryVersion : {2}",
				productName,libraryName,libraryVersion);
	}
}

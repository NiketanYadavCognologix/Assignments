package com.cognologix.Day2.Part1.Q1FirstSarver;

public class QFirstSarver {
	
	private String serverName;
	private String softwareType;
	private String softwreName;
	private String version;
	public QFirstSarver() {
		super();
		// TODO Auto-generated constructor stub
	}
	public QFirstSarver(String serverName, String softwareType, String softwreName, String version) {
		super();
		this.serverName = serverName;
		this.softwareType = softwareType;
		this.softwreName = softwreName;
		this.version = version;
	}
	public String getServerName() {
		return serverName;
	}
	public void setServerName(String serverName) {
		this.serverName = serverName;
	}
	public String getSoftwareType() {
		return softwareType;
	}
	public void setSoftwareType(String softwareType) {
		this.softwareType = softwareType;
	}
	public String getSoftwreName() {
		return softwreName;
	}
	public void setSoftwreName(String softwreName) {
		this.softwreName = softwreName;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	@Override
	public String toString() {
		return "QFirstSarver [serverName=" + serverName + ", softwareType=" + softwareType + ", softwreName="
				+ softwreName + ", version=" + version + "]";
	}

}

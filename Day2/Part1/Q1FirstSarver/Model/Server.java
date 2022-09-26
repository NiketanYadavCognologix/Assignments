package com.cognologix.Part1.Q1FirstSarver.Model;

public class Server {
	
	private String serverName;
	private String softwareType;
	private String softwreName;
	private String version;
	public Server() {}
	public Server(String serverName, String softwareType, String softwreName, String version) {
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
		return java.text.MessageFormat.format("serverName : {0} | softwareType : {1} | softwreName : {2} | version : {3}"
				, serverName,softwareType,softwreName,version);
	}

}

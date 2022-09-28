package com.cognologix.Q2.module;

public class Server {
	private String serverName;
	private String platform;
	private String softwareName;
	private String softwareVersion;
	public Server() {}
	public Server(String serverName, String softwareType, String softwareName, String softwareVersion) {
		this.serverName = serverName;
		this.platform = softwareType;
		this.softwareName = softwareName;
		this.softwareVersion = softwareVersion;
	}
	public String getServerName() {
		return serverName;
	}
	public void setServerName(String serverName) {
		this.serverName = serverName;
	}
	public String getSoftwareType() {
		return platform;
	}
	public void setSoftwareType(String softwareType) {
		this.platform = softwareType;
	}
	public String getSoftwareName() {
		return softwareName;
	}
	public void setSoftwareName(String softwareName) {
		this.softwareName = softwareName;
	}
	public String getSoftwareVersion() {
		return softwareVersion;
	}
	public void setSoftwareVersion(String softwareVersion) {
		this.softwareVersion = softwareVersion;
	}
	@Override
	public String toString() {
		return "Server [serverName=" + serverName + ", softwareType=" + platform + ", softwareName=" + softwareName
				+ ", softwareVersion=" + softwareVersion + "]";
	}
}


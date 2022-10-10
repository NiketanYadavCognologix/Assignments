package com.cognologix.model;

public class Server {
    private String serverName;
    private String softwareCategory;
    private String softwareName;
    private String softwareVersion;

    public Server(String serverName, String softwareCategory, String softwareName, String softwareVersion) {
        this.serverName = serverName;
        this.softwareCategory = softwareCategory;
        this.softwareName = softwareName;
        this.softwareVersion = softwareVersion;
    }

    public String getServerName() {
        return serverName;
    }

    public String getSoftwareCategory() {
        return softwareCategory;
    }

    public String getSoftwareName() {
        return softwareName;
    }

    public String getSoftwareVersion() {
        return softwareVersion;
    }

    @Override
    public String toString() {
        String placeHolder = "Name: {0}, Software Category: {1}, Software Name: {2}, Software Version: {3}";
        return java.text.MessageFormat.format(placeHolder, serverName, softwareCategory, softwareName, softwareVersion);
    }
}

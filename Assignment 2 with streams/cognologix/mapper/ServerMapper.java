package com.cognologix.mapper;

import com.cognologix.model.Server;

public class ServerMapper implements CSVToPojoMapper<Server>{
    @Override
    public Server map(String[] values) {
        if (values == null || values.length != 4) {
            throw new RuntimeException("invalid values to map");
        }
        String serverName = values[0].trim();
        String softwareCategory = values[1].trim();
        String softwareName = values[2].trim();
        String softwareVersion = values[3].trim();
        Server server = new Server(serverName, softwareCategory, softwareName, softwareVersion);
        return server;
    }
}

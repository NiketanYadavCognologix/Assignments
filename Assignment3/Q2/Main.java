package com.cognologix.Q2;

import java.lang.module.ModuleDescriptor.Version;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.cognologix.Q2.module.Server;
import com.cognologix.Q2.parser.ServerInputParser;
import com.cognologix.Q2.solution.VersionCalculator;

/*String[] serversInformation = {
	"Server1, Database, MySQL, 5.5",
	"Server2, Database, MySQL, 5.1",
	"Server3, OS, Ubuntu, 12.04",
	"Server1, OS, Ubuntu, 12.04",
	"Server2, OS, Ubuntu, 18.04",
	"Server3, Language, Python, 2.6.3",
	"Server4, Language, Python, 3.9.14",
	"Server4, Language, Python, 3.10.4"
};

create a list of Server from serversInformation.
Sort the list on Server name.
Sort the list on Server name, software, software version numbesortedListByServerNamer.
get distinct server names.
filter records for a given server name.
create a map as follows
Key: Software.
value: sorted set of Software Version.
*/
public class Main {
	public static void main(String[] args) {
		String[] serversInformation = { "Server1, Database, MySQL,5.5", "Server2, Database, MySQL,5.1",
				"Server3, OS, Ubuntu,12.04", "Server1, OS, Ubuntu,12.04", "Server2, OS, Ubuntu,18.04",
				"Server3, Language, Python,2.6.3", "Server4, Language, Python,3.9.14",
				"Server4, Language, Python,3.10.4" };
		
		ServerInputParser serveParser=new ServerInputParser();
		
		List<Server> serversList=serveParser.parseInputArray(serversInformation);
		
		VersionCalculator versionCaculator=new VersionCalculator(serversList);
		
		System.out.println("**********************sorted List By Server Name*************************");
		List<Server> sortedListByServerName=versionCaculator.getSortedListByServerName();
		
		System.out.println("**********************sorted By Name Software And Version*************************");
		List<Server> sortedByNameSoftwareAndVersion=versionCaculator.getSortedByNameSoftwareAndVersion();
		
		System.out.println("**********************distinct Server Names*************************");
		List<String> distinctServerNames=versionCaculator.getDistinctServerNames();
		
		System.out.println("**********************records For Given Server Name*************************");
		String inputServerName="Server1";
		List<Server> recordsForGivenServerName=versionCaculator.getRecordsForGivenServerName(inputServerName);

		System.out.println("**********************creating the Map*************************");
		Set<String> softwareNameSet=versionCaculator.getSoftwareNameSet();
		Map<String, List<Version>> mapOfSoftwareersionsSet=versionCaculator.getMapOfSoftwareersionsSet(softwareNameSet);

	}
}

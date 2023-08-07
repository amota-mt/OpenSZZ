package com.SZZ.app;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
// import org.apache.logging.log4j.LogManager;
// import org.apache.logging.log4j.Logger;

import com.SZZ.jiraAnalyser.Application;
import com.SZZ.jiraAnalyser.git.Git;
import com.SZZ.jiraAnalyser.git.JiraRetriever;

public class SZZApplication {

	/* Get actual class name to be printed on */
	
	private static String jiraAPI = "/sr/jira.issueviews:searchrequest-xml/temp/SearchRequest.xml";

	public static void main(String[] args) throws Exception {

		// Logger logger = LogManager.getLogger();

		// args = new String[7];
		// args[0] = "-all";
		// args[1] = "https://github.com/apache/oozie.git";
		// args[2] = "https://issues.apache.org/jira/projects/oozie";
		// args[3] = "OOZIE";

		File results_dir = new File("results");
		if (!results_dir.exists()) {
			results_dir.mkdir();
		}

System.out.println("Number of Command Line Argument = "+args.length);
System.out.println("executing open szz with the following parameters");
		for(int i = 0; i< args.length; i++) {
			System.out.println(String.format("Argument %d is %s", i, args[i]));
		}
		
		
		
		if (args.length == 0) {
			System.out.println("Welcome to the SZZ Calculation script.");
			System.out.println("Here a guide how to use the script");
			System.out.println("szz.jar -all githubUrl, jiraUrl, jiraKey => all steps together");
		} else {
			switch (args[0]) {
			case "-all":
				Git git;
				try {
					File jiraIssuesFile = new File("jiras/" + args[3] + "_0.csv");
					if(!jiraIssuesFile.exists()) {
						String[] array = args[2].split("/projects/");
						String projectName = args[3];
						String jiraUrl = array[0] + jiraAPI;
						JiraRetriever jr1 = new JiraRetriever(jiraUrl, projectName);
						jr1.printIssues();
					}

				} catch (Exception e) {
					break;
				}
				try {
					Application a = new Application();
					a.mineData(args[1], args[2].replace("{0}", args[3]), args[3], args[3]);
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
//				clean(args[3]);
				break;
			default:
				System.out.println("Commands are not in the right form! Please retry!");
				break;

			}
		}

	}

	private static void clean(String jiraKey) {
		for (File fileEntry : new File(".").listFiles()) {
			if (fileEntry.getName().toLowerCase().contains(jiraKey.toLowerCase())) {
				if (!fileEntry.getName().contains("Commit")) {
					try {
						if (fileEntry.isFile())
							Files.deleteIfExists(fileEntry.toPath());
						else
							deleteDir(fileEntry);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}

	private static void deleteDir(File file) {
		File[] contents = file.listFiles();
		if (contents != null) {
			for (File f : contents) {
				deleteDir(f);
			}
		}
		file.delete();
	}
}

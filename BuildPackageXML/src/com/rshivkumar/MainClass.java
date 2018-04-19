package com.rshivkumar;



public class MainClass {

//	private static String reports = "report.log";
//	private static String dashboard = "dashboard.log";
//	private static String document = "document.log";
//	private static String email = "email.log";
	
	private static String[] filenames = {"report.log","dashboard.log","document.log","email.log"};
	
	public static void main(String[] args) {
		
		for(String filename : filenames)
		{
			UpdateBuildXML.updateBuildXML(BuildListMetadata.getMetaData(filename));
		}
		
	}

}

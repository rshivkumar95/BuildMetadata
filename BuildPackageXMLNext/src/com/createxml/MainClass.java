package com.createxml;

import java.io.File;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File folder = new File("retrieved/");
		File[] listOfFiles = folder.listFiles();

		    for (int i = 0; i < listOfFiles.length; i++) {
		      if (listOfFiles[i].isFile()) {
		        ReadLogs.readlogFile(listOfFiles[i].getName());
		      } 
		    }
	}

}

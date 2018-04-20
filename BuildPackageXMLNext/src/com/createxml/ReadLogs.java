package com.createxml;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class ReadLogs {
	
	public static void readlogFile(String filename)
	{
		filename="retrieved/"+filename;
		BufferedReader br = null;
		FileReader fr = null;
		String TempFilename= filename;
		System.out.println("FILENAME :"+filename);
		if(!filename.substring(filename.indexOf(".")+1,filename.length()).equalsIgnoreCase("log"))
			return;
		try {

			//br = new BufferedReader(new FileReader(FILENAME));
			fr = new FileReader(filename);
			br = new BufferedReader(fr);
			String type=null;
			String sCurrentLine;
			String MetaDataType="";
			List<String> members = new ArrayList<String>();
			//String FolderPath = "";
			//System.out.println(TempFilename);
			String temp = TempFilename.substring(0, TempFilename.indexOf("."));
			//System.out.println(temp);
			switch(temp)
			{
			case "report" :
				MetaDataType="Report";
				break;
			case "dashboard" :
				MetaDataType="Dashboard";
				break;
			case "document" : 
				MetaDataType="Document";
				break;
			case "email" :
				MetaDataType="Email";
				break;
				

			}
			
			
			while ((sCurrentLine = br.readLine()) != null) {
				//System.out.println(sCurrentLine);
				if(sCurrentLine.contains("FileName"))
				{
					String subFileName = sCurrentLine.substring(sCurrentLine.indexOf("/")+1,sCurrentLine.length());
					System.out.println(subFileName);
					if(type==null)
					{
						type=subFileName.substring(subFileName.indexOf(".")+1, subFileName.length());						
					}
					members.add(subFileName.substring(0, subFileName.indexOf(".")));
					//System.out.println(subFileName.substring(0, subFileName.indexOf(".")));
					//System.out.println(type);
				}
			}
			System.out.println(type);
			type=type.trim();
			if(!(type.equalsIgnoreCase("report") || type.equalsIgnoreCase("dashboard") || type.equalsIgnoreCase("email")))
			{
				type="document";
				
			}
			
				
			System.out.println("#############"+type+"############");
			BuildPackage.build(members, type);
			
			

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (br != null)
					br.close();

				if (fr != null)
					fr.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}

		}
		
		
	}

}

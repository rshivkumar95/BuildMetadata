package com.rshivkumar;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class BuildListMetadata {

	public static List<MetaData> getMetaData(String FILENAME)
	{
		List<MetaData> listMetaData = new ArrayList<MetaData>();
		BufferedReader br = null;
		FileReader fr = null;
		String TempFilename= FILENAME;
		try {

			//br = new BufferedReader(new FileReader(FILENAME));
			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);

			String sCurrentLine;
			String MetaDataType="";
			//String FolderPath = "";
			System.out.println(TempFilename);
			String temp = TempFilename.substring(0, TempFilename.indexOf("."));
			System.out.println(temp);
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
					String FolderName;
					String[] words;
					if(sCurrentLine.contains("reports") || sCurrentLine.contains("dashboards") || sCurrentLine.contains("documents") || sCurrentLine.contains("emails"))
					{
						words=sCurrentLine.split("/");
						FolderName = words[1];
					}
					else
					{
						words=sCurrentLine.split(" ");
						FolderName = words[1];
					}
					//System.out.println(FolderName);
					
					MetaData md=new MetaData();
					md.metadataType=MetaDataType;
					md.folder=FolderName;
					md.resultFilePath="retrieved/"+MetaDataType+FolderName+".log";
					String tag = "<sf:listMetadata username=\"${sf.username}\" password=\"${sf.password}\" sessionId=\"${sf.sessionId}\" serverurl=\"${sf.serverurl}\" metadataType=\""+MetaDataType+"\" folder=\""+FolderName+"\" resultFilePath=\"list/logs/retrieved/"+MetaDataType+FolderName+".log\"/>";
					System.out.println(tag);
					listMetaData.add(md);

				}
			}

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
		return listMetaData;

	}

}

package com.createxml;

import java.io.File;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class BuildPackage {

	public static void build(List<String> members,String type)
	{
		String newType=null;
		switch(type)
		{
			case "report" :
				newType="Report";
				break;
			case "dashboard" :
				newType="Dashboard";
				break;
			case "document" :
				newType="Document";
				break;
			case "email" :
				newType="EmailTemplate";
				break;

		}
		try{
			File inputFile = new File("retrieved/package.xml");
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.parse(inputFile);
			//NodeList listMetadata=doc.getChildNodes();

			NodeList nd = doc.getElementsByTagName("Package");
			Node rootNode=nd.item(0);
			Element rootElement = doc.createElement("types");

			for(String m : members)
			{
				Element subElement = doc.createElement("members");
				subElement.appendChild(doc.createTextNode(m));
				rootElement.appendChild(subElement);



			}
			Element subElement = doc.createElement("name");
			subElement.appendChild(doc.createTextNode(newType));
			rootElement.appendChild(subElement);
			rootNode.appendChild(rootElement);

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("retrieved/package.xml"));
			transformer.transform(source, result);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}

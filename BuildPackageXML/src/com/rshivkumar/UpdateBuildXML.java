package com.rshivkumar;

import java.util.List;
import java.io.File;
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

public class UpdateBuildXML {
	
	public static void updateBuildXML(List<MetaData> md)
	{
		try{
			File inputFile = new File("build.xml");
	         DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
	         DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
	         Document doc = docBuilder.parse(inputFile);
	         //NodeList listMetadata=doc.getChildNodes();
	         
	         NodeList nd = doc.getElementsByTagName("target");
	         Node rootNode=nd.item(0);
	         for(MetaData m : md)
	         {
	        	 Element rootElement = doc.createElement("sf:listMetadata");
	        	
	             Attr attr7 = doc.createAttribute("resultFilePath");
	             attr7.setValue(m.resultFilePath);
	             rootElement.setAttributeNode(attr7);
	             Attr attr6 = doc.createAttribute("folder");
	             attr6.setValue(m.folder);
	             rootElement.setAttributeNode(attr6);
	             Attr attr5 = doc.createAttribute("metadataType");
	             attr5.setValue(m.metadataType);
	             rootElement.setAttributeNode(attr5);
	             Attr attr4 = doc.createAttribute("serverurl");
	             attr4.setValue(m.serverurl);
	             rootElement.setAttributeNode(attr4);
	             Attr attr3 = doc.createAttribute("sessionId");
	             attr3.setValue(m.sessionId);
	             rootElement.setAttributeNode(attr3);
	             Attr attr2 = doc.createAttribute("password");
	             attr2.setValue(m.password);
	             rootElement.setAttributeNode(attr2);
	             Attr attr1 = doc.createAttribute("username");
	             attr1.setValue(m.username);
	             rootElement.setAttributeNode(attr1);
	             
	             rootNode.appendChild(rootElement);
	         }
	         
	        TransformerFactory transformerFactory = TransformerFactory.newInstance();
	 		Transformer transformer = transformerFactory.newTransformer();
	 		transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
	 		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
	 		DOMSource source = new DOMSource(doc);
	 		StreamResult result = new StreamResult(new File("build.xml"));
	 		transformer.transform(source, result);
		}catch (Exception e) {
	         e.printStackTrace();
	      }
	}
	

}

package com.rshivkumar;

public class MetaData {
	
	public final String username="${sf.username}";
	public final String password="${sf.password}";
	public final String sessionId="${sf.sessionId}";
	public final String serverurl="${sf.serverurl}";
	public String metadataType;
	public String resultFilePath;
	public String folder;
	public String getMetadataType() {
		return metadataType;
	}
	public void setMetadataType(String metadataType) {
		this.metadataType = metadataType;
	}
	public String getResultFilePath() {
		return resultFilePath;
	}
	public void setResultFilePath(String resultFilePath) {
		this.resultFilePath = resultFilePath;
	}
	public String getFolder() {
		return folder;
	}
	public void setFolder(String folder) {
		this.folder = folder;
	}
	
	
	

}

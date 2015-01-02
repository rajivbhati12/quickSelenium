package base;

import java.util.HashMap;

public class Page{	
	private HashMap<String,String> objectIdentifier = new HashMap<String,String>();
	private HashMap<String,String> objectIdentifierValue = new HashMap<String,String>();
	private String pageName = "No Name";
	public Page() {		
	}
	public void setPageName(String pageName){
		this.pageName = pageName;
	}
	public void setIdentifierName(String identifierKey, String identifierName){
		this.objectIdentifier.put(identifierKey.toLowerCase(), identifierName);
	}	
	public void setIdentifierValue(String identifierKey, String identifierValue){
		this.objectIdentifierValue.put(identifierKey.toLowerCase(), identifierValue);
	}
	public String getIdentifierName(String identifierKey){
		return this.objectIdentifier.get(identifierKey.toLowerCase());
	}
	public String getIdentifierValue(String identifierKey){
		return this.objectIdentifierValue.get(identifierKey.toLowerCase());
	}
	public String getPageName(){
		return this.pageName;
	}
}
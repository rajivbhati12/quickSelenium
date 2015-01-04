/* ****************************************************************** */
//Author:	Rajiv Bhati
//Email:	RajivBhati12@gmail.com
/* ****************************************************************** */
package data;

import java.util.HashMap;
import java.util.Set;

public class StorageCollector {
	
	private HashMap<String, Object> variables = new HashMap<String, Object>();
	
	public StorageCollector(){		
	}
	
	public String getValueReplace(String currentData){
		String returnValue = currentData;
		VariableFinder currentFinder = new VariableFinder(currentData);
		currentFinder.setDelimiter("<", ">");
		Set<String> currentVariableList = currentFinder.findKeys();
		if(! currentVariableList.isEmpty())
			for( String currentVariable : currentVariableList)
				returnValue = returnValue.replace("<" + currentVariable + ">", this.getString("<" + currentVariable + ">"));			
		return returnValue;
		
//		List<String> listTokens = new ArrayList<String>();
//		Matcher myPattern = Pattern.compile("([^\']\\S*|\'.+?\')\\s*").matcher(currentData);
//		while (myPattern.find())
//			listTokens.add(myPattern.group(1));		
		
	}
	public void setValue(String variableName,String variableValue)	{
		this.variables.put(variableName.toLowerCase(), variableValue);
	}	
	
	public void setValue(String variableName,Integer variableValue)	{
		this.variables.put(variableName.toLowerCase(), variableValue);
	}
	
	public void setValue(String variableName,Object variableValue)	{
		this.variables.put(variableName.toLowerCase(), variableValue);
	}
	
	public void setValue(String variableName,Boolean variableValue)	{
		this.variables.put(variableName.toLowerCase(), variableValue);
	}	
	
	public String getString(String variableName){
		return (String) this.getObject(variableName.toLowerCase());
	}
	
	public Integer getInteger(String variableName){
		return (Integer) this.getObject(variableName.toLowerCase());
	}
	
	public Boolean getBoolean(String variableName){
		return ((Boolean) this.getObject(variableName.toLowerCase())).booleanValue(); 
	}
	
	public Object getObject(String variableName)
	{	
		Object value = variableName;
		if(this.variables.containsKey(variableName.toLowerCase()))
			return this.variables.get(variableName.toLowerCase());
		else
		{
//			System.out.println("Variable <" + variableName + "> not found in the Storage.");
			return value;
		}
	}	
}

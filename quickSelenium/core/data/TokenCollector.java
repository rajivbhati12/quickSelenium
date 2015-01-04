/* ****************************************************************** */
//Author:	Rajiv Bhati
//Email:	RajivBhati12@gmail.com
/* ****************************************************************** */
package data;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TokenCollector {
	
	public TokenCollector(){		
	}
	
	private List<String> getTokens(String currentString){		
		List<String> listTokens = new ArrayList<String>();
		Matcher myPattern = Pattern.compile("([^\']\\S*|\'.+?\')\\s*").matcher(currentString);
		while (myPattern.find())
			listTokens.add(myPattern.group(1));
		return listTokens;		
	}
	
	public List<String> getAllAttributes(String currentString){
		return getTokens(currentString);
	}
	
	public List<String> getAttributes(String currentString){
		List<String> listAttributes = new ArrayList<String>();
		for(String currentToken : getTokens(currentString))
			if((currentToken.split("\\'",-1).length - 1) > 1)
				listAttributes.add(currentToken);
		if(listAttributes.size() == 0)
			listAttributes.add("");
		return listAttributes;				
	}
}

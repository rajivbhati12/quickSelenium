/* ****************************************************************** */
//Author:	Rajiv Bhati
//Email:	RajivBhati12@gmail.com
/* ****************************************************************** */
package data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class TextReader {
	
	public TextReader(){		
	}
	
	public List<String> getLines(String filePath){		
	    String line = null;
	    List<String> records = new ArrayList<String>();
	    try{	    
		    BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
		    while ((line = bufferedReader.readLine()) != null)
		        records.add(line);
		    bufferedReader.close();
	    }catch(Exception e)
	    {
	    	records.add("Error");
	    }
	    return records;
	}
	
}

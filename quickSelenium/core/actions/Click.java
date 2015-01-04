/* ****************************************************************** */
//Author:	Rajiv Bhati
//Email:	RajivBhati12@gmail.com
/* ****************************************************************** */
package actions;

import java.util.List;
import org.openqa.selenium.WebElement;
import start.ThisThread;
import base.Action;
import base.Element;

@SuppressWarnings("unchecked")
public class Click extends Action{
	
	String line = null;
	
	public Click(ThisThread currentThread) {		
		line = ((List<String>) currentThread.getStorage().getObject("<varFeatureList>")).remove(0);	
	}
	
	public String run(ThisThread thisThread) {
		try{			
			WebElement CurrentObject = new Element(thisThread).getElement(this.getLastToken());			
			CurrentObject.click();
			return null;
		}
		catch(Exception e)
		{
			return e.toString();
		}				
	}
	
	public String getLine() {
		return(this.line);
	}
}

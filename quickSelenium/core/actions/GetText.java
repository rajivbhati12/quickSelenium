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
public class GetText extends Action{
	
	private String line = null;
	
	public GetText(ThisThread currentThread) {
		this.line = ((List<String>) currentThread.getStorage().getObject("<varFeatureList>")).remove(0);	
	}
	
	public String run(ThisThread currentThread) {
		try{			
			WebElement CurrentObject = new Element(currentThread).getElement(this.getLastToken());			
			currentThread.getStorage().setValue(this.getQuoteRemove(this.getAttributes().get(0)), CurrentObject.getText());
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

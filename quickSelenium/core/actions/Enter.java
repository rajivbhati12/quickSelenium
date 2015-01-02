package actions;

import java.util.List;
import org.openqa.selenium.WebElement;

import start.ThisThread;
import base.Action;
import base.Element;

public class Enter extends Action{	String line = null;

@SuppressWarnings("unchecked")
public Enter(ThisThread currentThread) {
	line = ((List<String>) currentThread.getStorage().getObject("<varFeatureList>")).remove(0);	
	}
	
	public String run(ThisThread currentThread) {
		try{			
			WebElement CurrentObject = new Element(currentThread).getElement(this.getLastToken());			
			CurrentObject.click();
			CurrentObject.sendKeys(this.getData(currentThread));
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
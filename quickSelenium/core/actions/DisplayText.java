package actions;

import java.util.List;
import org.openqa.selenium.WebElement;

import start.ThisThread;
import base.Action;
import base.Element;

public class DisplayText extends Action{
	String line = null;

	@SuppressWarnings("unchecked")
	public DisplayText(ThisThread currentThread) {
		this.line = ((List<String>) currentThread.getStorage().getObject("<varFeatureList>")).remove(0);	
	}
	
	public String run(ThisThread currentThread) {
		try{			
			WebElement CurrentObject = new Element(currentThread).getElement(this.getLastToken());
			System.out.println(CurrentObject.getText());
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

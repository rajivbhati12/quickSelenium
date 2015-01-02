package actions;

import java.util.List;

import org.openqa.selenium.WebElement;

import start.ThisThread;
import base.Action;
import base.ActionCollector;
import base.Element;

public class If extends Action{
	String line = null;

	public If(List<String> lines){	
		line = lines.remove(0);
		ActionCollector currentCollector = new ActionCollector();
//		currentCollector.getCollection(currentThread, "end");
		
		
		
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

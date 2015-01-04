package actions;

import java.util.List;

import start.ThisThread;

import base.Action;
import driver.Browser;

@SuppressWarnings("unchecked")
public class Open extends Action{
	String line = null;
	
	public Open(ThisThread currentThread) {
		line = ((List<String>) currentThread.getStorage().getObject("<varFeatureList>")).remove(0);	
	}
	
	public String run(ThisThread currentThread) {
		try{
			currentThread.getStorage().setValue("varMyBrowser", this.getData(currentThread));
			new Browser(currentThread);
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

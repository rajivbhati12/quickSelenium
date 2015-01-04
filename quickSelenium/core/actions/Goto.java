package actions;

import java.util.List;
import org.openqa.selenium.WebDriver;
import start.ThisThread;
import base.Action;

@SuppressWarnings("unchecked")
public class Goto extends Action{
	String line = null;	
	public Goto(ThisThread currentThread) {
		line = ((List<String>) currentThread.getStorage().getObject("<varFeatureList>")).remove(0);	
	}
	public String run(ThisThread currentThread) {
		String currentUrl = this.getData(currentThread).get(0);
		try{			
			((WebDriver) currentThread.getStorage().getObject("<varMyBrowser>")).get(currentUrl);
			return null;
		}
		catch(Exception e)
		{
			System.out.println("Verify the url: \"" + currentUrl + "\" is currect.");
//			System.out.println(e.toString());
			return e.toString();
		}				
	}
	
	public String getLine() {
		return(this.line);
	}
}

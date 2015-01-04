/* ****************************************************************** */
//Author:	Rajiv Bhati
//Email:	RajivBhati12@gmail.com
/* ****************************************************************** */
package actions;

import java.util.List;
import org.openqa.selenium.WebDriver;
import start.ThisThread;
import base.Action;

@SuppressWarnings("unchecked")
public class Close extends Action{
	
	String line = null;
	
	public Close(ThisThread currentThread) {
		line = ((List<String>) currentThread.getStorage().getObject("<varFeatureList>")).remove(0);	
	}
	
	public String run(ThisThread currentThread) {
		try{
			((WebDriver)currentThread.getStorage().getObject("<varMyBrowser>")).quit();
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
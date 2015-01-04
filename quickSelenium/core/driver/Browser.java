/* ****************************************************************** */
//Author: Rajiv Bhati
//Email: RajivBhati12@gmail.com
/* ****************************************************************** */
package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import start.ThisThread;

public class Browser  {
	
	private ThisThread currentThread = null;	
	
	public enum currentMyBrowserTypes 
	{
	    FIREFOX,
	    PHANTOMJS,
	    NOTFOUND		    
	}
	
	public Browser(ThisThread currentThread) {
		this.currentThread = currentThread;		
		currentThread.getStorage().setValue("<varMyBrowser>", this.getBrowser());
	}
	
	public WebDriver getBrowser()
	{
		currentMyBrowserTypes currentMyBrowserType = this.getMyBrowserType(this.currentThread.getStorage().getString("<varMyBrowserType>"));
		switch(currentMyBrowserType){
		case FIREFOX:
			return (new FirefoxDriver());
		case PHANTOMJS:{
			System.setProperty("phantomjs.binary.path", this.currentThread.getStorage().getString("<varBasePath>") + "/phantomjs");
			return (new PhantomJSDriver());			
		}	
		default:
			return (new FirefoxDriver());
		}
	}
	
	private currentMyBrowserTypes getMyBrowserType(String currentMyBrowserType) {
		currentMyBrowserTypes tempMyBrowserType = null;
		try{
			tempMyBrowserType = currentMyBrowserTypes.valueOf(currentMyBrowserType.toUpperCase());			
		}catch(Exception e){
			tempMyBrowserType = currentMyBrowserTypes.valueOf("NOTFOUND"); 
		}
		return(tempMyBrowserType);		
	}
}
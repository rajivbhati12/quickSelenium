/* ****************************************************************** */
//Author: Rajiv Bhati
//Email: RajivBhati12@gmail.com
/* ****************************************************************** */
package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

import start.ThisThread;

public class Browser  {
	
	private ThisThread currentThread = null;	

	public Browser(ThisThread currentThread) {
		this.currentThread = currentThread;		
		currentThread.getStorage().setValue("<varMyBrowser>", this.getBrowser());
	}
	
	private WebDriver getBrowser()
	{
		String currentMyBrowserType = this.currentThread.getStorage().getString("<varMyBrowserType>");
		String currentSetupPath = this.currentThread.getStorage().getString("<varBasePath>") + "/externalSetup/";
		
		switch(currentMyBrowserType){
		case "FIREFOX":
			return (new FirefoxDriver());
		case "CHROME":
			System.setProperty("webdriver.chrome.driver", currentSetupPath + "chrome");
			return (new ChromeDriver());
		case "INTERNETEXPLORER":
			System.setProperty("webdriver.ie.driver", currentSetupPath + "IEDriverServer");
			return (new InternetExplorerDriver());			
		case "PHANTOMJS":
			System.setProperty("phantomjs.binary.path", this.currentThread.getStorage().getString("<varBasePath>") + "/phantomjs");
			return (new PhantomJSDriver());			
		default:
			return (new FirefoxDriver());
		}
	}
}
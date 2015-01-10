package actions;

import java.util.List;

import org.openqa.selenium.WebDriver;

import start.ThisThread;
import base.Action;

@SuppressWarnings("unchecked")
public class FrameSet extends Action{
	
	private String line = null;
	private String parentHandle = "";
	
	public FrameSet(ThisThread currentThread) {
		line = ((List<String>) currentThread.getStorage().getObject("<varFeatureList>")).remove(0);	
	}
	
	public String run(ThisThread currentThread) {
		try{
			WebDriver thisDriver = (WebDriver)currentThread.getStorage().getObject("<varMyBrowser>");			
			this.parentHandle = thisDriver.getWindowHandle();
			
			
			
			
			
			
			currentThread.getStorage().setValue("<varMyParent>", this.parentHandle);
			
			
			
			
			
			thisDriver.switchTo().window(this.getData(currentThread).get(0));
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
	
	public String getHandle(){
		return (this.parentHandle);
	}
}
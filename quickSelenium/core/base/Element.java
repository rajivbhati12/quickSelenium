/* ****************************************************************** */
//Author:	Rajiv Bhati
//Email:	RajivBhati12@gmail.com
/* ****************************************************************** */
package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import start.ThisThread;

public class Element {
	
	private ThisThread currentThread = null;
	
	public Element(ThisThread currentThread) {
		this.currentThread = currentThread;
	}	
	
	@SuppressWarnings("finally")
	public WebElement getElement(String currentIdentifierKey)
	{
		Page currentPage = (Page)this.currentThread.getStorage().getObject("<varCurrentPage>");
		WebDriver currentBrowser = (WebDriver) this.currentThread.getStorage().getObject("<varMyBrowser>");
		String objectIdentifier = currentPage.getIdentifierName(currentIdentifierKey);
		String objectValue = currentPage.getIdentifierValue(currentIdentifierKey);
		WebElement ObjectElement = null;
		try 
		{
			if (objectIdentifier.equalsIgnoreCase("class"))
				ObjectElement = currentBrowser.findElement(By.cssSelector("." + objectValue.replace(" ", ".")));
			else if (objectIdentifier.equalsIgnoreCase("id"))
				ObjectElement = currentBrowser.findElement(By.cssSelector("#" + objectValue));
			else
				ObjectElement = currentBrowser.findElement(By.cssSelector("[" + objectIdentifier.toLowerCase() + "='" + objectValue + "']"));
		}
		catch (Exception e) {	
			System.out.println(e.toString());
		}
		finally{
			return ObjectElement;
		}
	}
}

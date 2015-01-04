/* ****************************************************************** */
//Author:	Rajiv Bhati
//Email:	RajivBhati12@gmail.com
/* ****************************************************************** */
package actions;

import java.util.List;
import page.PageList;
import start.ThisThread;
import base.Action;

@SuppressWarnings("unchecked")
public class PageSet extends Action {
	
	private String line = null;
	
	public PageSet(ThisThread currentThread) {
		line = ((List<String>) currentThread.getStorage().getObject("<varFeatureList>")).remove(0);		
	}
	
	public String run(ThisThread currentThread) {
		try {
			currentThread.sleep(9000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
		try{
			currentThread.getStorage().setValue("<varCurrentPage>", (new PageList()).getPage(this.getData(currentThread).get(0)));
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

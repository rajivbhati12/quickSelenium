/* ****************************************************************** */
//Author:	Rajiv Bhati
//Email:	RajivBhati12@gmail.com
/* ****************************************************************** */
package actions;

import java.util.ArrayList;
import java.util.List;
import start.ThisThread;
import base.Action;
import base.ActionCollector;

@SuppressWarnings("unchecked")
public class If extends Action{
	
	private String line = null;
	private List<Action> ifActions = new ArrayList<Action>();
	
	public If(ThisThread currentThread) {
		this.line = ((List<String>) currentThread.getStorage().getObject("<varFeatureList>")).remove(0);	
		ActionCollector currentCollector = new ActionCollector();
		this.ifActions = currentCollector.getCollection(currentThread, "end");		
	}
	
	public String run(ThisThread currentThread) {
		try{
			List<String> currentDataList = this.getData(currentThread);
			if(currentDataList.get(0).equalsIgnoreCase(currentDataList.get(1)))
				for(Action currentAction : ifActions)
					currentAction.run(currentThread);			
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

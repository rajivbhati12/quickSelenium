/* ****************************************************************** */
//Author:	Rajiv Bhati
//Email:	RajivBhati12@gmail.com
/* ****************************************************************** */
package base;

import java.util.ArrayList;
import java.util.List;
import start.ThisThread;

@SuppressWarnings("unchecked")
public class ActionCollector{
	
	private List<Action> currentActionList = new ArrayList<Action>();
	
	public ActionCollector(){
	}
	
	public List<Action> getCollection(ThisThread currentThread, String endAction){		
		List<String> lines = ((List<String>) currentThread.getStorage().getObject("<varFeatureList>"));
		while(! lines.get(0).equalsIgnoreCase(endAction))
			this.currentActionList.add(Action.createAction(currentThread));
		if(lines.get(0).equalsIgnoreCase(endAction))
			lines.remove(0);
		return this.currentActionList;
	}
}

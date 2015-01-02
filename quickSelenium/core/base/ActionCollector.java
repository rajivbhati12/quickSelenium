package base;

import java.util.ArrayList;
import java.util.List;

import start.ThisThread;

public class ActionCollector{
	private List<Action> currentActionList = new ArrayList<Action>();
//	private String currentLine = "";
	public ActionCollector(){
	}
	public List<Action> getCollection(ThisThread currentThread, String endAction){
		@SuppressWarnings("unchecked")
		List<String> lines = (List<String>) currentThread.getStorage().getObject("<varFeatureList>");
//		currentLine = lines.remove(0);
		while(! lines.get(0).equalsIgnoreCase(endAction))
			currentActionList.add(Action.createAction(currentThread));
		return this.currentActionList;
	}
//	public String getCurrentLine(){
//		return currentLine;
//	}
}

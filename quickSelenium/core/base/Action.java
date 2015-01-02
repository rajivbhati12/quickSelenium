package base;

import java.util.List;

import start.ThisThread;
import actions.Click;
import actions.Close;
import actions.DisplayText;
import actions.Enter;
import actions.Goto;
import actions.Open;
import actions.PageSet;
import data.StorageCollector;
import data.TokenCollector;

abstract public class Action {
//	public static seleniumTest.Page CurrentPage;	
	
	public enum Actions 
	{
	    CLICK,
	    ENTER,
	    EXIST,
	    DOUBLECLICK,
	    ENABLED,
	    TYPE,
	    SYSTEM,
	    PAGESET,
	    VERIFYTEXT,
	    DO,
	    OPEN,
	    CLOSE,
	    GOTO,
	    DISPLAYTEXT,
	    NOTFOUND
		    
	}

	public Action() {
		// TODO Auto-generated constructor stub
	}
	
	public String run(ThisThread currentThread) {
		return(null);
	}
	
	abstract public String getLine();
	
	@SuppressWarnings("unchecked")
	public static Action createAction(ThisThread currentThread) {
		currentThread.getStorage().setValue("varStepFormation", true);
		List<String> lines = (List<String>) currentThread.getStorage().getObject("<varFeatureList>");
		Actions tAction = getAction(lines.get(0));
		
		
		
		switch(tAction){
			case PAGESET: 
					return(new PageSet(currentThread));
			case ENTER:
				return(new Enter(currentThread));
			case CLICK:
				return(new Click(currentThread));					
//				case DO:
//					return(new Do(lines));
//				case VERIFYTEXT:
//					return(new VerifyText(lines));
			case OPEN:
				return(new Open(currentThread));
			case CLOSE:
				return(new Close(currentThread));
			case GOTO:
				return(new Goto(currentThread));
			case DISPLAYTEXT:
				return(new DisplayText(currentThread));
			default:
				currentThread.getStorage().setValue("varStepFormation", false);
				break;			
		}
		
		return(null);
	}

	static Actions getAction(String line) {
		Actions tAction = null;
		try{
			tAction = Actions.valueOf((line.split(" ")[0]).toUpperCase());			
		}catch(Exception e){
			tAction = Actions.valueOf("NOTFOUND"); 
		}
		return(tAction);		
	}
	
//	public String updateData(String variableName)
//	{	
//		String currentStep = this.getLine();
//		
//		
////		for(String currentAttribute : this.getAttributes())
////			if(currentAttribute.contains("`"))
////				for(String tempAttribute : currentAttribute.split("`"))
//////					currentStep.replace(currentAttribute, MainTest.currentStorage.getVariable(currentAttribute));
////			;
//				
//		return currentStep;
//	}
	
	
	
//	public String updateColumnData(String ColumnHeader, String ActualValue)
//	{
//		return getLine().replaceAll(ColumnHeader, ActualValue);
//	}
	public String getData(ThisThread currentThread){
		String currentData = this.getQuoteRemove(this.getAttributes().get(0));		
		currentData = currentThread.getStorage().getValueReplace(currentData);
		return currentData;
	}
	public List<String> getTokens()
	{
		return (new TokenCollector()).getAllAttributes(this.getLine());
	}
	public List<String> getAttributes()
	{
		return (new TokenCollector()).getAttributes(this.getLine());
	}
	public String getLastToken()
	{
		List<String> currentTokens = getTokens();
		return currentTokens.get(currentTokens.size() - 1);
	}
	public String getQuoteRemove(String currentData){
		return currentData.substring(1, currentData.length() - 1);
	}
}
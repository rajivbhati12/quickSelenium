package base;

import java.util.List;

import start.ThisThread;
import actions.Click;
import actions.Close;
import actions.DisplayText;
import actions.Enter;
import actions.GetText;
import actions.Goto;
import actions.If;
import actions.Open;
import actions.PageSet;
import data.TokenCollector;
@SuppressWarnings("unchecked")
abstract public class Action {
//	public static seleniumTest.Page CurrentPage;	
	
	public Action() {
		// TODO Auto-generated constructor stub
	}
	
	public String run(ThisThread currentThread) {
		return(null);
	}
	
	abstract public String getLine();
	
	public static Action createAction(ThisThread currentThread) {
		currentThread.getStorage().setValue("varStepFormation", true);
		List<String> lines = (List<String>) currentThread.getStorage().getObject("<varFeatureList>");
		
		
		
		switch(getAction(lines.get(0))){
			case "PAGESET": 
					return(new PageSet(currentThread));
			case "ENTER":
				return(new Enter(currentThread));
			case "CLICK":
				return(new Click(currentThread));	
			case "IF":
				return(new If(currentThread));
			case "GETTEXT":
				return(new GetText(currentThread));					
//				case DO:
//					return(new Do(lines));
//				case VERIFYTEXT:
//					return(new VerifyText(lines));
			case "OPEN":
				return(new Open(currentThread));
			case "CLOSE":
				return(new Close(currentThread));
			case "GOTO":
				return(new Goto(currentThread));
			case "DISPLAYTEXT":
				return(new DisplayText(currentThread));
			default:
				currentThread.getStorage().setValue("varStepFormation", false);
				break;			
		}
		
		return(null);
	}

	static String getAction(String line) {
		String actionName = "NOTFOUND";
		try{
			actionName = (line.split(" ")[0]).toUpperCase();			
		}catch(Exception e){ 
		}
		return(actionName);		
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
	public List<String> getData(ThisThread currentThread){		
		List<String> attributeList = this.getAttributes();
		for(int i = 0 ; i < attributeList.size(); i++)
		{
			String currentData = this.getQuoteRemove(attributeList.get(i));
			currentData = currentThread.getStorage().getValueReplace(currentData);
			attributeList.set(i,currentData );
		}
		return attributeList;
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
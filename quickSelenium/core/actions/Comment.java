package actions;

import java.util.List;
import start.ThisThread;
import base.Action;

@SuppressWarnings("unchecked")
public class Comment extends Action{
	
	String line = null;
	
	public Comment(ThisThread currentThread) {		
		line = ((List<String>) currentThread.getStorage().getObject("<varFeatureList>")).remove(0);	
	}
	
	public String run(ThisThread thisThread) {
		return null;				
	}
	
	public String getLine() {
		return(this.line);
	}
}
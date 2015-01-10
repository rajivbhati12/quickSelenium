/* ****************************************************************** */
//Author:	Rajiv Bhati
//Email:	RajivBhati12@gmail.com
/* ****************************************************************** */
package start;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import base.Action;
import base.Feature;
import base.Page;
import data.StorageCollector;

@SuppressWarnings("unchecked")
public class ThisThread extends Thread implements Runnable{	

	private StorageCollector currentStorage = null;	
	
	@Override
	public void run() {
		
		String currentBasePath = System.getProperty("user.dir").substring(0, System.getProperty("user.dir").lastIndexOf("\\") + 1);
		
		currentStorage = new StorageCollector();		
		currentStorage.setValue("<varBaseUrl>", "https://usmail.cognizant.com/");
		currentStorage.setValue("<varScenarioStatus>",true);
		currentStorage.setValue("<varUserId>","190647");
		
		//This is temp solution
		String thisPassword= JOptionPane.showInputDialog("Please input password: ");
		
		currentStorage.setValue("<varPassword>",thisPassword);
		currentStorage.setValue("<varCurrentPage>",(Page)null);
		currentStorage.setValue("<varStepFormation>",true);
		currentStorage.setValue("<varBasePath>",currentBasePath);		
		currentStorage.setValue("<varFeature>","NewAppliances");
		currentStorage.setValue("<varFeatureList>",(new Feature(this)).getFeatureList());
		currentStorage.setValue("<varStepFormation>",true);

		
		List<String> featureList = (List<String>) currentStorage.getObject("<varFeatureList>"); 	
		if(! featureList.get(0).equalsIgnoreCase("Error")){
			List<Action> actions = new ArrayList<Action>();
			while (featureList.size() != 0) {
				Action NewAction = Action.createAction(this);
				if (! this.currentStorage.getBoolean("varStepFormation")) 
					break;
				actions.add(NewAction);				
			}		
			for (Action action : actions) {
				String error = action.run(this);
				if (error != null)
					break;
			}
		}
		else
			System.out.println("Error in Feature file - " + "NewAppliances");	
		System.gc();
		System.exit(0);
	}	
	
	public StorageCollector getStorage(){
		return this.currentStorage;
	}
}

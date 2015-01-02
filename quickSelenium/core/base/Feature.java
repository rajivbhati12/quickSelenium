package base;

import java.util.List;

import start.ThisThread;
import data.TextReader;

public class Feature {	
	private String currentPath = "";
	private String currentFeature = "No Feature";
	public Feature(ThisThread currentThread){
		this.currentPath = currentThread.getStorage().getString("<varBasePath>");
		this.currentFeature = currentThread.getStorage().getString("<varFeature>");
	}
	public List<String> getFeatureList(){
		TextReader currentFeatureFile = new TextReader();
		return currentFeatureFile.getLines(this.currentPath + "quickSelenium\\application\\featurefiles\\" + this.currentFeature + ".txt");
	}
}

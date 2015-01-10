package frame;

import page.HomePage;
import base.Page;

public class FrameList 
{	
	public FrameList() {
		
	}
	
	public static Page getPage(String FrameName)	{
		try {
			
			switch(FrameName.toUpperCase())
			{
				case "CONTENT":
					return (new HomePage());				
				case "APPLIANCES":
//					return (new Appliances());				
				default:
					return null;
			}
		}
		catch(Exception e)
		{
			System.out.println("Frame Not Found. - " + FrameName);			
			return null;
		}		
	}
}
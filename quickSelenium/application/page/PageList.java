package page;

import base.Page;


public class PageList 
{	
	public PageList()
	{
		
	}
	public static Page getPage(String PageName)
	{
		try {
			PageTitle tPage = PageTitle.valueOf(PageName.toUpperCase());
			switch(tPage)
			{
				case HOMEPAGE:
					return (new HomePage());				
				case APPLIANCES:
//					return (new Appliances());				
				default:
					return null;
			}
		}
		catch(Exception e)
		{
			System.out.println("Page Not Found. - " + PageName);
			
//			MainTest.ScenarioStatus = false;
			return null;
		}		
	}
	public enum PageTitle 
	{
		HOMEPAGE,
		APPLIANCES
	}	

}

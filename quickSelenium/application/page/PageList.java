/* ****************************************************************** */
//Author:	Rajiv Bhati
//Email:	RajivBhati12@gmail.com
/* ****************************************************************** */
package page;

import base.Page;

public class PageList 
{	
	public PageList() {
		
	}
	
	public static Page getPage(String PageName)	{
		try {
			
			switch(PageName.toUpperCase())
			{
				case "HOMEPAGE":
					return (new HomePage());				
				case "APPLIANCES":
//					return (new Appliances());				
				default:
					return null;
			}
		}
		catch(Exception e)
		{
			System.out.println("Page Not Found. - " + PageName);			
			return null;
		}		
	}
}

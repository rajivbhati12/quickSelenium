/* ****************************************************************** */
//Author:	Rajiv Bhati
//Email:	RajivBhati12@gmail.com
/* ****************************************************************** */
package page;

import base.Page;

public class HomePage extends Page{
	
	public void signIn(){
		this.setIdentifierName("SignIn", "class");
		this.setIdentifierValue("SignIn", "myAccount thdOrange b");	
	}
	
	public void emailAddress(){		
		this.setIdentifierName("EmailAddress", "id");
		this.setIdentifierValue("EmailAddress", "email_id");
	}
	
	public void password()	{
		this.setIdentifierName("password", "id");
		this.setIdentifierValue("password", "password");
	}	
	
	public void signInButton()	{
		this.setIdentifierName("SignInButton", "id");
		this.setIdentifierValue("SignInButton", "signIn");
	}	
	
	public void helloUser()	{
		this.setIdentifierName("helloUser", "id");
		this.setIdentifierValue("helloUser", "navUserName");
	}	
	
	public HomePage()
	{		
		this.setPageName("Login");
		signIn();
		emailAddress();
		password();
		signInButton();
		helloUser();
	}
}

package com.crm.testscripts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.basepage.BasePage;
import com.crm.pages_objectrepository.HomePage;
import com.crm.pages_objectrepository.LandingPage;
import com.crm.pages_objectrepository.LoginPage;

public class LoginTest extends BasePage {
	LoginPage lpage;
	LandingPage landpage;
	HomePage hPage;
	public LoginTest()
	{
		super();
	}
	
@BeforeMethod
public void setupTest()
{
	initialization();
	lpage=new LoginPage();
	landpage=new LandingPage();
	hPage=new HomePage();
	
}
@Test
public void loginTest()
{
	hPage=lpage.loginToAccount();
}
@AfterMethod
public void closebrowserTest()
{
	closeBrowser();
}
}

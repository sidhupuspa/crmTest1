package com.crm.testscripts;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.basepage.BasePage;
import com.crm.pages_objectrepository.CreateContactPage;
import com.crm.pages_objectrepository.HomePage;
import com.crm.pages_objectrepository.LoginPage;
import com.crm.utils.TestUtils;

public class CreateContactPageTest extends BasePage {
	LoginPage lpage;
	HomePage hpPage;
	CreateContactPage ccPage;
	public CreateContactPageTest()
	{
		super();
	}
	
@BeforeMethod
public void setup()
{
initialization();
lpage=new LoginPage();
hpPage=lpage.loginToAccount();
ccPage=new CreateContactPage();
}
@DataProvider
public Object[][] getDataFromExcelSheet()
{
	Object data[][]=TestUtils.getTestData("Sheet1");
	return data;
}
@Test(dataProvider="getDataFromExcelSheet")
public void createNewCustomerTest(String FirstName,String LastName)
{
	ccPage.createNewContact(FirstName, LastName);
}
}

package com.crm.pages_objectrepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.basepage.BasePage;

public class CreateContactPage extends BasePage {
	@FindBy(xpath="//i[@class=\"users icon\"]")
	WebElement createContactIcon;
	@FindBy(xpath="//a[@href=\"/contacts/new\"]/button[@class=\"ui linkedin button\"]")
	WebElement createNewContact;
	@FindBy(name="first_name")
	WebElement firstname;
	@FindBy(name="last_name")
	WebElement lastname;
	@FindBy(xpath="//i[@class=\"save icon\"]")
	WebElement saveIcon;
public CreateContactPage()
{
	PageFactory.initElements(driver, this);
}
public void createNewContact(String FirstName,String LastName)
{
	createContactIcon.click();
	createNewContact.click();
	firstname.sendKeys(FirstName);
	lastname.sendKeys(LastName);
	saveIcon.click();
}
}

package com.crm.pages_objectrepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.basepage.BasePage;

public class LoginPage extends BasePage{
@FindBy(xpath="//span[text()=\"Log In\"]")
WebElement logInButton;
@FindBy(name="email")
WebElement emailHolder;
@FindBy(name="password")
WebElement passwordHolder;
@FindBy(xpath="//div[text()=\"Login\"]")
WebElement finalLoginButton;

public LoginPage()
{
	PageFactory.initElements(driver, this);
}
public HomePage loginToAccount()
{
	logInButton.click();
	emailHolder.sendKeys(prop.getProperty("username"));
	passwordHolder.sendKeys(prop.getProperty("password"));
 finalLoginButton.click();	
 return new HomePage();

}
}

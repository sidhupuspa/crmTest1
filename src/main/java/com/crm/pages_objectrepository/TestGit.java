package com.crm.pages_objectrepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.crm.basepage.BasePage;

public class TestGit extends BasePage{
	@FindBy(xpath="//span[text()=\"Log In\"]")
	WebElement logInButton;
	@FindBy(name="email")
	WebElement emailHolder;
	public static void checkgit()
	{
		System.out.println("successfully checked in another file");
	}
}

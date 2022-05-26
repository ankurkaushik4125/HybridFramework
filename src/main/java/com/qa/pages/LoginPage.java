package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	@FindBy(xpath="//*[@id='email']")
	WebElement username_wl;
	@FindBy(xpath="//*[@id='password']")
	WebElement password_wl;
	@FindBy(xpath="//button[@type='submit']")
	WebElement submit_wl;
	
	public LoginPage()
	{
		
		PageFactory.initElements(driver, this);
	}
	
	public String ValidateTitleOnPage()
	{
		return driver.getTitle();
	}
	
	public Homepage Login(String username, String password)
	{
	
		username_wl.sendKeys(username);
		password_wl.sendKeys(password);
		submit_wl.click();
		
		return new Homepage();
	}
	
}

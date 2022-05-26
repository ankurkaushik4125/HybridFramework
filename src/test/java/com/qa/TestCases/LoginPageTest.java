package com.qa.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.Homepage;
import com.qa.pages.LoginPage;
import com.qa.report.Log;

public class LoginPageTest extends TestBase {
	
	LoginPage login_obj;
	Homepage home_obj;
	public LoginPageTest() {
		super();	
		}
	
	@BeforeMethod
	public void intialization()
	{
	    intitialize();
		login_obj = new LoginPage();
		Log.info("Browser invoked and url passed to webdriver");
	}
	

	@Test(priority = 1)
	public void LoginPageTitleTest() throws InterruptedException
	
	{
     String Title_expected =	login_obj.ValidateTitleOnPage();
     Assert.assertEquals("ACME System 1 -  Log In", Title_expected);
	}
	
	
	@Test(priority = 2)
	public void AppLoginTest() throws InterruptedException
	
	{
		Thread.sleep(5000);
		String username = "rishabh.vats@kmgus.com";
		String password = "Rish@bh11";		
		home_obj=login_obj.Login(username, password);
	}
	
	@AfterMethod
	public void exit() 
	{
		driver.quit();
	}
	
	

}

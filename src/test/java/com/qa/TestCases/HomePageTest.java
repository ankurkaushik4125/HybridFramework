package com.qa.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.Homepage;
import com.qa.pages.LoginPage;

public class HomePageTest extends TestBase  {
	
	public LoginPage login_obj;
	public Homepage homepage_obj;
	
	HomePageTest()
	{
		super();
	}
	
	
	@BeforeMethod()
	public void Setup()
	{		
		intitialize();
		login_obj= new LoginPage();
		String username = "ankur.sharma@kmgin.com";
		String password = "Admin@123";	
		homepage_obj=login_obj.Login(username, password);	
	}
	
	@Test(priority=1)
	public void HomePageTitleTest()
	{
		String actual_title =homepage_obj.VerfiyHomeTitle();
		Assert.assertEquals(actual_title.trim(), "CME System 1 -  Dashboard","Homepage title mismatch");
		
	}
	
	@Test(priority=2)
	public void HomePageUsernameTest()
	{
		String actual_label =homepage_obj.verifyHomeLabel();
		Assert.assertEquals(actual_label, "ankur.sharma@kmgin.com","Homepage label mismatch");
		
	}
	
	@AfterMethod
	public void teadDown()
	{
		driver.quit();
	}

}

package com.qa.TestCases;

import java.util.ArrayList;

import org.testng.annotations.BeforeMethod;


import org.testng.annotations.Test;
import com.qa.base.TestBase;
import com.qa.pages.Homepage;
import com.qa.pages.LoginPage;
import com.qa.pages.WorkitemPage;

public class WorkitemTest extends TestBase {
	
	
	LoginPage login_obj;
	Homepage homepage_obj;
	WorkitemPage Workitem_obj;
	
	WorkitemTest()
	{
		super();
	}
	
	
	@BeforeMethod
	public void setup()
	{
		intitialize();
		login_obj= new LoginPage();
		String username = "ankur.sharma@kmgin.com";
		String password = "Admin@123";	
		homepage_obj=login_obj.Login(username,password);
		
		Workitem_obj=homepage_obj.ClickonWorkItem();
		
		
	}
	
	@Test
	public void TestMet()
	{
		
		ArrayList<String> items_fromlist=new ArrayList<String>();
		items_fromlist=Workitem_obj.GetWorkItemFromWeb("78735029");
		
	}
}

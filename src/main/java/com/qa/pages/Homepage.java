package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class Homepage extends TestBase{
	
	
	@FindBy(xpath="//strong[contains(text(),'ankur.sharma@kmgin.com')]")
	private WebElement username_label_wl;
	@FindBy(xpath="//*[@id='dashmenu']//div[2]//a//button")
	private WebElement workitem_wl;
	
	
	Homepage()
	{
	   PageFactory.initElements(driver,this );	
	}
	
	public String VerfiyHomeTitle()
	{
		
          String title_homepage  =		driver.getTitle();	
          
          return title_homepage;
		
	}
	//ACME System 1 -  Dashboard

	public String  verifyHomeLabel()
	{
		
    String name_label=		username_label_wl.getText();
    return name_label;
	}
	
	public WorkitemPage ClickonWorkItem()
	{
		workitem_wl.click();
		return new WorkitemPage();
	}
	

}

package com.qa.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class WorkitemPage extends TestBase {
	
	@FindBy(xpath="//table[@class='table']")
	private WebElement table_wl;
	
	@FindBy(xpath="//table[@class='table']//tbody//tr[")
	private WebElement wiid_before_wl;
	
	@FindBy(xpath="]//td[2]")
	private WebElement wiid_after_wl;
	
	@FindBy(xpath="//table[@class='table']//tbody//tr")
	private List < WebElement > rows_table;
	
	WorkitemPage()
	{
	   PageFactory.initElements(driver,this );	
	}
	
	
	public ArrayList<String> GetWorkItemFromWeb(String WIID)
	{
		ArrayList<String> tasklist= new ArrayList<String>();
		String before_wiid_xpath="//table[@class='table']//tbody//tr[";
		String after_wiid_xpath="]//td[2]";
		
		String before_Description="//table[@class='table']//tbody//tr[";
		String after_Description="]//td[3]";
		String before_type="//table[@class='table']//tbody//tr[";
		String after_type="]//td[4]";
		String before_status="//table[@class='table']//tbody//tr[";
		String after_status="]//td[5]";
		String before_date="//table[@class='table']//tbody//tr[";
		String after_date="]//td[6]";
		String before_search="//table[@class='table']//tbody//tr[";
		String after_search="]//td[1]//a[1]";
		
	
		System.out.println(rows_table.size());
		
		for(int i=2;i<=rows_table.size();i++)
		{
        String wiid_full_xpath=before_wiid_xpath+i+after_wiid_xpath;
        
        String wiid_text=driver.findElement(By.xpath(wiid_full_xpath)).getText();
        if (wiid_text.equalsIgnoreCase(WIID))
        {
  
        	 String description_str=driver.findElement(By.xpath(before_Description+i+after_Description)).getText();
        	 String type_str=driver.findElement(By.xpath(before_type+i+after_type)).getText();
        	 String status_str=driver.findElement(By.xpath(before_status+i+after_status)).getText();
        	 String date_str=driver.findElement(By.xpath(before_date+i+after_date)).getText();
        	 
             tasklist.add(description_str); 
             tasklist.add(type_str); 
             tasklist.add(status_str); 
             tasklist.add(date_str); 
             driver.findElement(By.xpath(before_search+i+after_search)).click();
             
             System.out.println(tasklist);
             break;
        }
        
              
		}
		
		//System.out.println(tasklist);
		return tasklist;
	}
	
	
	
	

}

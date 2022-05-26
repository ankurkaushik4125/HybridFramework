package com.qa.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.qa.ExcelUtility.Xls_Reader;
import com.qa.Utility.Constant;
import com.qa.Utility.WebEventListener;

public class TestBase {
	
	
	/* .** 1. Browser configration
	    ** 2. URL configration
	    *read a excel file and check browser and get URL from this file against execution status Y
	*/
	public static WebDriver driver;
	
	public static String Browser_Sheet_Name="Browser";
	
	public static String URL_Sheet_Name="URL";
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	

	public static String GetBrowser()
	{
		Xls_Reader excel_reader = new Xls_Reader(Constant.SHEETURL);
		String browser_name=null;
		int rowCount= excel_reader.getRowCount(Browser_Sheet_Name);
		
		for (int i=1;i<=rowCount;i++)
		{
      String execute_status =excel_reader.getCellData( Browser_Sheet_Name, "Execute", i);
if (execute_status.equalsIgnoreCase("Y"))
{
	 browser_name=excel_reader.getCellData( Browser_Sheet_Name, "BrowserName", i);
	 System.out.println(browser_name);
	 break;
}
		}
				
		
		return browser_name;
	}

	
	public static String GetURL()
	{
		Xls_Reader excel_reader = new Xls_Reader(Constant.SHEETURL);
		String url=null;
		int rowCount= excel_reader.getRowCount(URL_Sheet_Name);
		
		for (int i=1;i<=rowCount;i++)
		{
      String execute_status =excel_reader.getCellData( URL_Sheet_Name, "Execute", i);
if (execute_status.equalsIgnoreCase("Y"))
{
	 url=excel_reader.getCellData( URL_Sheet_Name, "Environment", i);
	 System.out.println(url);
	 break;
}
		}	
		return url;
	}
	
	

	
	public void intitialize()
	{	
		String Browser_execute = 	TestBase.GetBrowser();
		String URL_execute = TestBase.GetURL();
		
		if(Browser_execute.equalsIgnoreCase("chrome"))
		{
			System.getProperty("user.dir");
			System.out.println(System.getProperty("user.dir"));
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\resources\\browser\\chrome\\chromedriver.exe");	
			driver = new ChromeDriver(); 
		}
		
		else if(Browser_execute.equalsIgnoreCase("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "path");	
			driver = new FirefoxDriver(); 
		}
		
		else if(Browser_execute.equalsIgnoreCase("Edge")){
			System.getProperty("user.dir");
			System.setProperty("webdriver.edge.driver", "path");	
			driver = new EdgeDriver(); 
		
		}
		
	
		e_driver = new EventFiringWebDriver(driver);
		
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		
		driver.get(URL_execute);
		driver.manage().window().maximize();
		//driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Constant.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		
		
	}
}

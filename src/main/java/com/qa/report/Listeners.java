package com.qa.report;


import org.testng.ITestListener;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestResult;
import com.qa.Utility.Util;
import com.qa.base.TestBase;
public class Listeners extends TestBase implements ITestListener{
	
	public void onStart(ITestContext context) {	
		System.out.println("onStart method started");
	}
	
	public void onFinish(ITestContext context) {
		
		System.out.println("onFinish method started");
	}
	
	public void onTestStart(ITestResult result) {
		
		System.out.println("New Test Started" +result.getName());
	}
	
	public void onTestSuccess(ITestResult result) {
		System.out.println("onTestSuccess Method" +result.getName());
	}

	public void onTestFailure(ITestResult result) {

		String path ="D://SELENIUM FRAMEWORK//HybridFramework//src//main//java//screenshot";
		try {
			Util.CaptureScreenshot( driver, path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("onTestSkipped Method" +result.getName());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("onTestFailedButWithinSuccessPercentage" +result.getName());
	}
	
	

}

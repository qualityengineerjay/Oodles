package com.oodles.generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.*;

public class BaseLib {

	
	public static WebDriver driver;   //global driver
	
	@BeforeMethod
	@Parameters({"browserName","baseurl"})
	
	public void preConditions(String browserName, String url)
	{
		driver=BrowserFactory.launch(browserName);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(url);
		Reporter.log("URL is navigated",true);
		
	}
	
	@AfterMethod
	public void postCondition()
	{
		driver.quit();
		Reporter.log("Browser closed",true);
		
	}
}

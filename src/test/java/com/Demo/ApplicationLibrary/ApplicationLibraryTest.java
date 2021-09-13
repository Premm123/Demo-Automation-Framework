package com.Demo.ApplicationLibrary;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Demo.Pages.Herokuapp;
import com.Demo.PublicLibrary.PublicLibrary;
import com.Demo.Utills.Constants;

public class ApplicationLibraryTest extends PublicLibrary
{

	 public WebDriver  driver;
	 //Herokuapp	he = new  Herokuapp(getDriver());
	
	 /**
		 * Method will launch browser with specified driver and URL
		 * 
		 * @param browserType
		 *            : browser on which the script is going to be run
		 * @param sUrl
		 *            : url of the web applications
	  **/ 
	@Parameters ({"browserType","sUrl"})
    @BeforeClass
	public WebDriver SetBrowserAndNavigateToUrl1(String browserType,String sUrl)
	{
		driver=invokeBrowser(browserType);
		getDriver().get(sUrl);
		getDriver().manage().window().maximize();
		waitForPageLoad();
		setDriver(driver);
		return getDriver();
	}
	
	
	/**
	 * Method will close all tabs in a browser window
	 */ 
	@AfterClass
	public void closeBrowser()
	{
		driver.quit();
	}
	
	
	  
	
	public void printTitleAndUrlofCurrentPage()
	{
	  System.out.println("Current Page URL::"+getCurrentPageURL());
	}
	
	
}



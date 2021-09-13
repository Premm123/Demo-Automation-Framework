
package com.Demo.ApplicationLibrary;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.Demo.PublicLibrary.PublicLibrary;


public class ApplicationLibrary extends  PublicLibrary
{
	private WebDriver  driver;
	
	
	
	
	/**
	 * Method will launch browser with specified driver and URL
	 * 
	 * @param browserType
	 *            : browser on which the script is going to be run
	 * @param sUrl
	 *            : url of the web applications
	 */ 
	
	@Parameters ({"browserType","sUrl"})
	@BeforeTest
	public WebDriver SetBrowserAndNavigateToUrl(String browserType,String sUrl)
	{
		driver = invokeBrowser(browserType);
		driver.get(sUrl);
		driver.manage().window().maximize();
		waitForPageLoad();
		return driver;
	}
	
	
	
	public String getPageTitle()
	{
		String title = getDriver().getTitle();
		return title;
	}
	public void printTitleAndUrlofCurrentPage()
	{
	  System.out.println("PageTitle::"+getPageTitle());
	  System.out.println("Current Page URL::"+getCurrentPageURL());
	  
	}

	
	

}

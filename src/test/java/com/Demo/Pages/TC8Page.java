package com.Demo.Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.Demo.ApplicationLibrary.ApplicationLibrary;
import com.Demo.PublicLibrary.PublicLibrary;
import com.Demo.Utills.Constants;



public class TC8Page 
{
	private WebDriver  driver;
	private ApplicationLibrary appLib;
	private By lnkEntryAd = By.xpath("//li//a[normalize-space(text())='Entry Ad']");
	private By btnCloseModel = By.xpath("//div[@class='modal-footer']/p[.='Close']");
	private By clickHere = By.xpath("//a[.='click here']");
	private By unAvailablePopupWindow = By.xpath("//div[@id='modal' and contains(@style,'display: none')]");
	private By availablePopupWindow = By.xpath("//div[@id='modal' and contains(@style,'display: block')]");
	
	
				
	public TC8Page()
	{
		appLib = new ApplicationLibrary();
	}
	
	
	public void tc08() 
	{
	int flag=0;
	appLib.SetBrowserAndNavigateToUrl(Constants.Chrome,Constants.herokuapp_Url);
	appLib.clickElement(lnkEntryAd);
	do
	{
	  if(appLib.verifyElementExist(unAvailablePopupWindow)!=null)
	  {
		  appLib.clickElement(clickHere);
		  appLib.waitForPageLoad();
		  appLib.Delay(500);
	  }
	if (appLib.verifyElementExist(availablePopupWindow)!=null)
	{
		appLib.clickElement(btnCloseModel);
		appLib.waitForPageLoad();
		appLib.Delay(500);
	    flag++;
	    System.out.println("Count::"+flag);
	}
	else 
		appLib.clickElement(clickHere);
	    appLib.waitForPageLoad();
	    appLib.Delay(500);
	  
	}while(flag<30);
	
	
	System.out.println("End..");
	
	appLib.closeBrowser();
	}
	
	
}

package com.Demo.Pages;
import java.util.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.remote.server.handler.GetCssProperty;

import com.Demo.ApplicationLibrary.ApplicationLibrary;
import com.Demo.Utills.Constants;


public class TC5Page 
{
	private WebDriver  driver;
	private ApplicationLibrary appLib;
	private By lnkFormAuth = By.xpath("//li//a[normalize-space(text())='Form Authentication']");
	private By txtUsernane = By.id("username");
	private By txtPassword = By.id("password");
	private By btnLogin = By.xpath("//button[@type='submit']");
	//private By successFlashMsg = By.id("flash");
	private By successFlashMsg = By.xpath("//div[@id='flash'][not(self::a)]");
	private By btnLogout  = By.xpath("//a[i[normalize-space(text())='Logout']]");
	private String username = "tomsmith";
	private String password = "SuperSecretPassword!";
	private String successMsgBackGroundColor = "#5da423";
	private String successMsgborderColor = "#457a1a";
	
				
	public TC5Page()
	{
		appLib = new ApplicationLibrary();
	}
	
	
	public void tc05()
	{
	
	driver = appLib.SetBrowserAndNavigateToUrl(Constants.Chrome,Constants.herokuapp_Url);
	appLib.clickElement(lnkFormAuth);
	appLib.setValue(txtUsernane, username);
	appLib.setValue(txtPassword, password);
	appLib.clickElement(btnLogin);
	appLib.validateElementText(successFlashMsg, "You logged into a secure area!");
	String successBackbroundColor = appLib.GetColor(successFlashMsg,"background-color");
	if (successBackbroundColor.equals(successMsgBackGroundColor))
		System.out.println("Background color matched successfully"); 
	else
		System.err.println("Background color of an element should be\""+ successMsgBackGroundColor+ "\" not \""+successBackbroundColor+"\"");
		
	appLib.clickElement(btnLogout);
	appLib.validateElementText(successFlashMsg, "You logged out of the secure area!");
	String successBorderColor = appLib.GetColor(successFlashMsg,"border-color");
	if (successBorderColor.equals(successMsgborderColor))
		System.out.println("Border color matched successfully"); 
	else
		System.err.println("Border color of an element should be\""+ successMsgborderColor+ "\" not \""+successBorderColor+"\"");

	appLib.closeBrowser();
	}
	
   
}

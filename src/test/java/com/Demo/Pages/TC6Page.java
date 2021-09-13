package com.Demo.Pages;
import java.util.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;


import com.Demo.ApplicationLibrary.ApplicationLibrary;
import com.Demo.Utills.Constants;



public class TC6Page 
{
	private WebDriver  driver;
	private ApplicationLibrary appLib;
	private By lnkJSAlerts = By.xpath("//li//a[normalize-space(text())='JavaScript Alerts']");
	private By btnJSAlert = By.xpath("//div[@class='example']//button[text()='Click for JS Alert']");
	private By btnJSConfirm = By.xpath("//div[@class='example']//button[text()='Click for JS Confirm']");
	
	
				
	public TC6Page()
	{
		appLib = new ApplicationLibrary();
	}
	
	
	public void tc06()
	{
	
	appLib.SetBrowserAndNavigateToUrl(Constants.Chrome,Constants.herokuapp_Url);
	appLib.clickElement(lnkJSAlerts);
	appLib.clickElement(btnJSAlert);
	appLib.acceptAlert();
	appLib.clickElement(btnJSConfirm);
	String textFromAlert = appLib.getTextFromAlert();
	System.out.println("Text in the alert::"+textFromAlert);
	appLib.dismissAlert();
	appLib.clickElement(btnJSConfirm);
	appLib.acceptAlert();
	
	appLib.closeBrowser();
	}
	
   
}

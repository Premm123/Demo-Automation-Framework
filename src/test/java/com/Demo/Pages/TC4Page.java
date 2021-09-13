package com.Demo.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

import com.Demo.ApplicationLibrary.ApplicationLibrary;
import com.Demo.Utills.Constants;


public class TC4Page 
{
	private WebDriver  driver;
	private ApplicationLibrary appLib;
	private By lnkDynamicControls = By.xpath("//li//a[normalize-space(text())='Dynamic Controls']");
	private By btnRemove = By.xpath("//form[@id='checkbox-example']//button[normalize-space(text())='Remove']");
	private By chkAChkBox = By.xpath("//form[@id='checkbox-example']//input[@type='checkbox']");
	private By txtChkMsg = By.xpath("//form[@id='checkbox-example']//p[@id='message']");
	private By btnAdd = By.xpath("//form[@id='checkbox-example']//button[normalize-space(text())='Add']");
	private By btnEnable = By.xpath("//form[@id='input-example']//button[normalize-space(text())='Enable']");
	private By btnDisable = By.xpath("//form[@id='input-example']//button[normalize-space(text())='Disable']");
	private By txtInputMsg = By.xpath("//form[@id='input-example']//p[@id='message']");
	
	public TC4Page()
	{
		appLib = new ApplicationLibrary();
	}
	
	
	public void tc04()
	{
	
	appLib.SetBrowserAndNavigateToUrl(Constants.Chrome,Constants.herokuapp_Url);
	appLib.clickElement(lnkDynamicControls);
	appLib.waitForElement(chkAChkBox);
	appLib.clickElement(btnRemove);
	boolean IsChkAvailable=	appLib.waitForElementIsInvisible(chkAChkBox);
	if(IsChkAvailable)
		System.out.println("Chcek box is disappeared after clicking on Remove button");
	else
		System.err.println("Chcek box should be disappeared after clicking on Remove button");
	appLib.validateElementText(txtChkMsg, "It's gone!");
	appLib.clickElement(btnAdd);
	boolean IsChkAvailableAgain=	appLib.waitForElement(chkAChkBox);
	if(IsChkAvailableAgain)
		System.out.println("Chcek box is appeared again after clicking on Add button");
	else
		System.err.println("Chcek box should be appeared after clicking on Add button");
	appLib.validateElementText(txtChkMsg, "It's back!");
	appLib.clickElement(btnEnable);
	appLib.validateElementText(txtInputMsg,"It's enabled!");
	appLib.clickElement(btnDisable);
	appLib.validateElementText(txtInputMsg,"It's disabled!");
	
	
	appLib.closeBrowser();
	}
	

}

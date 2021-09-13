package com.Demo.Pages;
import java.util.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.Demo.ApplicationLibrary.ApplicationLibrary;
import com.Demo.Utills.Constants;



public class TC7Page 
{
	private WebDriver  driver;
	private ApplicationLibrary appLib;
	private By lnkHover = By.xpath("//li//a[normalize-space(text())='Hovers']");
	private String user1 = "user1";
	private String user2 = "user2";
	private String user3 = "user3";
	
	private By imgUser1 = By.xpath("//div[div[h5[text()='name: user1']]]/img[@alt='User Avatar']");
	private By imgUser2 = By.xpath("//div[div[h5[text()='name: user1']]]/img[@alt='User Avatar']");
	private By imgUser3 = By.xpath("//div[div[h5[text()='name: user1']]]/img[@alt='User Avatar']");

	
				
	public TC7Page()
	{
		appLib = new ApplicationLibrary();
	}
	
	
	public void tc07()
	{
	
	appLib.SetBrowserAndNavigateToUrl(Constants.Chrome,Constants.herokuapp_Url);
	appLib.clickElement(lnkHover);
	appLib.hoverMouseonElement(imageUserLocator(user1));
	verifyNameandProfileOfaUser(user1);
	appLib.hoverMouseonElement(imageUserLocator(user2));
	verifyNameandProfileOfaUser(user2);
	appLib.hoverMouseonElement(imageUserLocator(user3));
	verifyNameandProfileOfaUser(user3);
	
	appLib.closeBrowser();
	}
	
	public void verifyNameandProfileOfaUser(String user)
	{
		String username= appLib.getText(userNameLocator(user));
		System.out.println(username);
		WebElement element = appLib.verifyElementExist(userProfileLocator(user));
		String userProfileLink = element.getAttribute("href");
		System.out.println("User Profile Link::"+userProfileLink);
		
	}
	
	
	public By imageUserLocator(String user)
	{
		By imgUser = By.xpath("//div[div[h5[text()='name: "+user+"']]]/img[@alt='User Avatar']");
		return imgUser;
		
	}
	public By userNameLocator(String user)
	{
		By nameOfUser = By.xpath("//div[@class='figcaption']//h5[text()='name: "+user+"']");
		return nameOfUser;
		
	}
	public By userProfileLocator(String user)
	{
		By userProfile = By.xpath("//div[@class='figcaption']//h5[text()='name: "+user+"']/following-sibling::a");
		return userProfile;
		
	}
   
}

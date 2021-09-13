package com.Demo.Listners;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base
{

	 public WebDriver driver;
	
	

	public void initilization()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.godaddy.com/");
		System.out.println(driver.getTitle());
			
	}
	
	public void failed()
	{
			
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try
		{
			FileUtils.copyFile(srcFile, new File(System.getProperty("user.dir")+File.separator+"Screenshots/testfailure.jpg"));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	
	public void quit()
	{
		driver.quit();
	
	}
	
	
}

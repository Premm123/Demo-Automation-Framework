package com.Demo.Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.Demo.ApplicationLibrary.ApplicationLibrary;
import com.Demo.Utills.Constants;



public class TC9Page 
{
	private WebDriver  driver;
	private ApplicationLibrary appLib;
	
	private By lnkfileUpload = By.xpath("//li//a[normalize-space(text())='File Upload']");
	private By lnkfileDownload = By.xpath("//li//a[normalize-space(text())='File Download']");
	private By lnkNestedFrames = By.xpath("//li//a[normalize-space(text())='Nested Frames']");
	private By lnkFrames = By.xpath("//li//a[normalize-space(text())='Frames']");
	private By lnkIFrames = By.xpath("//li//a[normalize-space(text())='iFrame']");
	
	private By chooseFile = By.id("file-upload");
	private By bthUpload = By.id("file-submit");
	private String fileName = "fileUpload.jpg";
	private By fileUploaded= By.xpath("//div[@class='example']/h3");
	private By uploadedFileName = By.id("uploaded-files");
	private String downloadFileName = "//div[@class='example']//a[text()='";
	
	private By topFrame = By.xpath("//frame[@name='frame-top']");
	private By bottomFrame = By.xpath("//frame[@name='frame-bottom']");
	private By leftFrame = By.xpath("//frame[@name='frame-left']");
	private By rightFrame = By.xpath("//frame[@name='frame-right']");
	private By middleFrame = By.xpath("//frame[@name='frame-middle']");
	private By body = By.xpath("//body");
	private By middleFrameContent  = By.xpath("//div[@id='content']");
	
	private By iFrameContent  = By.xpath("//body[@id='tinymce']//p");
	private By eleIFrame  = By.xpath("//iframe[@id='mce_0_ifr']");
	
				
	public TC9Page()
	{
		appLib = new ApplicationLibrary();
	}
	
	
	public void tc09() 
	{
		uploadAndDownloadFiles();
		nestedFrames();
		iFrames();
		
	}
	
	public void uploadAndDownloadFiles()
	{
		appLib.SetBrowserAndNavigateToUrl(Constants.Chrome,Constants.herokuapp_Url);
		appLib.clickElement(lnkfileUpload);
		appLib.fileUpload(chooseFile, fileName);
		appLib.clickElement(bthUpload);
		appLib.validateElementText(fileUploaded, "File Uploaded!");
		appLib.validateElementText(uploadedFileName, fileName);
		
		appLib.getDriver().get(Constants.herokuapp_Url);
		appLib.clickElement(lnkfileDownload);
		appLib.doubleClickElement(By.xpath(downloadFileName+fileName+Constants.LocEnd));
		appLib.cleanDirectory(Constants.DownloadFolderPath);
		boolean isDownloaded = appLib.isFileDownloaded(fileName);
		if(isDownloaded)
			System.out.println("Downloaded Sucessfully..");
		else
			System.err.println("There is a problem in downloading a file..");
		appLib.closeBrowser();
	}
	public void nestedFrames()
	{
		appLib.SetBrowserAndNavigateToUrl(Constants.Chrome,Constants.herokuapp_Url);
		appLib.clickElement(lnkNestedFrames);
		appLib.switchToFrame(topFrame);
		appLib.switchToFrame(leftFrame);
		System.out.println("Currently in "+appLib.getText(body)+ " frame");
		String ParentpageSource = appLib.getDriver().switchTo().parentFrame().getPageSource();
		System.out.println("ParentpageSource:: "+ParentpageSource);
		appLib.switchToFrame(rightFrame);
		System.out.println("Currently in "+appLib.getText(body)+ " frame");
		String DefaultpageSource = appLib.getDriver().switchTo().defaultContent().getPageSource();
		System.out.println("DefaultpageSource:: "+DefaultpageSource);
		appLib.switchToFrame(topFrame);
		appLib.switchToFrame(middleFrame);
		System.out.println("Currently in "+appLib.getText(middleFrameContent)+ " frame");
		ParentpageSource= appLib.getDriver().switchTo().defaultContent().getPageSource();
		System.out.println("DefaultpageSource:: "+DefaultpageSource);
		appLib.switchToFrame(bottomFrame);
		System.out.println("Currently in "+appLib.getText(body)+ "Frame");
		
		
	}
	
	public void iFrames()
	{
		appLib.getDriver().get(Constants.herokuapp_Url);
		appLib.clickElement(lnkFrames);
		appLib.clickElement(lnkIFrames);
		appLib.switchToFrame(eleIFrame);
		System.out.println("Text inside Iframe is "+appLib.getText(iFrameContent));
		WebElement ele= appLib.setValue(iFrameContent,"abc");
		ele.sendKeys(Keys.BACK_SPACE);
		appLib.closeBrowser();
		
	}
	
}

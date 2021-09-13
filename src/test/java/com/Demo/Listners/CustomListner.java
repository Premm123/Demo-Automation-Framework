package com.Demo.Listners;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.Demo.PublicLibrary.PublicLibrary;

public class CustomListner  extends PublicLibrary implements  ITestListener
{
	
	
	public void onTestFailure(ITestResult  result)
	{
		System.out.println("Failed Test");
		failed();
		
	}
	
	

}

package com.Demo.Listners;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.Listeners;

@Listeners(CustomListner.class)
public class Screenshot  extends Base
{
	
	
	@BeforeClass
	public void setup()
	{
		initilization();
	}
	
	@Test
	public void Test()
	{
		assertEquals(false, true);
	}
	
	@AfterClass
	public void teardown()
	{
		quit();
		
	}
	
	
	
	
	
	
	

}

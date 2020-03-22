package com.Way2Automation1.testcases;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.Way2Automation1.base.TestBase;
import com.Way2Automation1.pages.ResourcePage;

public class ResourcePageTest extends TestBase {
	
	ResourcePage resourcepage;
	
	public ResourcePageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		Initialization();
		resourcepage=new ResourcePage();
	}

	@Test(priority=1)
	public void validateResourceTab() throws Throwable
	{
		resourcepage.ClickOnResource();
	}
    
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}


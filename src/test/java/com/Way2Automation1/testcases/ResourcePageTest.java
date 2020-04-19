package com.Way2Automation1.testcases;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.Way2Automation1.base.TestBase;
import com.Way2Automation1.pages.ResourcePage;

public class ResourcePageTest extends TestBase {
	
	private ResourcePage resourcePage;
	String sheetName = "Resources";	
	TestUtil testUtil;
	@BeforeMethod
	public void init()
	{
		 resourcePage=new ResourcePage(driver);
		 testUtil = new TestUtil(driver);
	}
	//I have accessed data using following entity and provide dataProvider to TestCase validateCustmor but it
	//not working.
	/*
	 * @DataProvider public Object[][] getResourceTestData() throws
	 * InvalidFormatException{ Object data[][] = TestUtil.getTestData(sheetName);
	 * return data; }
	 */
	
	//@Test(priority =1,dataProvider = "getResourceTestData")
	////Public void validateCustmor(String FirstName, String LastName, String postalCode)
	@Test(priority =1)
	public void validateCustmor()throws Throwable
	{
		 String FirstName="Sonal" ;
		 String LastName="Londhe";
		 String postalCode="747045";
		 String name = resourcePage.validateCustmor(FirstName, LastName, postalCode);
		//resourcePage.validateCustmor(FirstName, LastName, postalCode);
		
		assertEquals(FirstName, name);
	}
}


package com.Way2Automation1.pages;

import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Way2Automation1.base.TestBase;

public class ResourcePage extends TestBase {
	
	//PageFactory:OR
	
	@FindBy(xpath="//a[text()='Resources']")
	WebElement resourceLink;
	
	@FindBy(xpath="//a[text()='Practice site 2']")
	WebElement option2;
	
	@FindBy(xpath="//img[@src='demo/images/bank.jpg']")
	WebElement BankOption;
	
	@FindBy(xpath="//button[contains(text(),'Bank Manager Login')]")
	WebElement BankManagerLogIn;
	
	@FindBy(xpath="//button[@ng-class='btnClass1']")
	WebElement AddCust;
	
	@FindBy(xpath="//input[@ng-model='fName']")
	WebElement FirstName;
	
	@FindBy(xpath="//input[@ng-model='lName']")
	WebElement LastName;
	
	@FindBy(xpath="//input[@ng-model='postCd']")
	WebElement PostCode;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement submitClick;
	
	@FindBy(xpath="//button[@ng-class='btnClass3']")
	WebElement searchElement;
	
	@FindBy(xpath="//input[@class='form-control ng-valid ng-dirty ng-valid-parse ng-touched']")
	WebElement insertData;
		
	//Initializing the page objects:
	public ResourcePage()
	{		
		PageFactory.initElements(driver, this);
	}
	public void ClickOnResource() throws Throwable
	{
		Actions action=new Actions(driver);
		action.moveToElement(resourceLink).build().perform();
		WebDriverWait Wait = new WebDriverWait(driver,50);
		Wait.until(ExpectedConditions.visibilityOf(option2));
		action.moveToElement(option2).click().build().perform();
		Wait.until(ExpectedConditions.visibilityOf(BankOption));
		BankOption.click();
		String mainWindowHandle=driver.getWindowHandle();
		 Set<String> allWindowHandles=driver.getWindowHandles();
		 
		 for(String currentWindowHandle:allWindowHandles)
		 {
			 if(!currentWindowHandle.equals(mainWindowHandle))
			 
			 {
				 driver.switchTo().window(currentWindowHandle);
				
			 }
		 }
		Wait.until(ExpectedConditions.elementToBeClickable(BankManagerLogIn));
		BankManagerLogIn.click();
		Wait.until(ExpectedConditions.visibilityOf(AddCust));
		AddCust.click();
		Wait.until(ExpectedConditions.visibilityOf(FirstName));
		FirstName.sendKeys("Sonal");
		Wait.until(ExpectedConditions.visibilityOf(LastName));
		LastName.sendKeys("Londhe");
		Wait.until(ExpectedConditions.visibilityOf(PostCode));
		PostCode.sendKeys("411011");
		Wait.until(ExpectedConditions.visibilityOf(submitClick));
		submitClick.click();
		Alert alert=driver.switchTo().alert();
		alert.accept();
		System.out.println("Records inserted successfully");
		Wait.until(ExpectedConditions.visibilityOf(searchElement));
		searchElement.click();
		String searchText=FirstName.getText();
		Wait.until(ExpectedConditions.visibilityOf(insertData));
		insertData.sendKeys(searchText);
		System.out.println("Records found");
	}
}


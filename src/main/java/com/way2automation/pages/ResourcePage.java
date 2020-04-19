package com.way2automation.pages;

import com.way2automation.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ResourcePage extends BasePage {

    @FindBy(xpath = "//a[text()='Resources']")
    private WebElement lnk_resource;

    @FindBy(xpath = "//a[text()='Practice site 2']")
    private WebElement lnk_option2;

    @FindBy(xpath = "//img[@src='demo/images/bank.jpg']")
    private WebElement btn_bankOption;

    @FindBy(xpath = "//button[contains(text(),'Bank Manager Login')]")
    private WebElement btn_bankManagerLogIn;

    @FindBy(xpath = "//button[@ng-class='btnClass1']")
    private WebElement btn_addCustomer;

    @FindBy(xpath = "//input[@ng-model='fName']")
    private WebElement txt_firstName;

    @FindBy(xpath = "//input[@ng-model='lName']")
    private WebElement txt_lastName;

    @FindBy(xpath = "//input[@ng-model='postCd']")
    private WebElement txt_postalCode;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement btn_submitClick;

    @FindBy(xpath = "//input[@placeholder='Search Customer']")
    private WebElement txt_searchElement;

    @FindBy(xpath = "//button[@ng-class='btnClass3']")
    private WebElement btn_customers;

    @FindBy(xpath = "//input[@placeholder='Search Customer']")
    private WebElement txt_searchCustomer;

    @FindBy(xpath = "//tbody/tr/td[@class='ng-binding'][1]")
    private WebElement lbl_name;

    //Initializing the page objects:
    public ResourcePage(WebDriver driver) {
        super(driver);
    }

    public String validateCustomer(String firstName, String lastName, String postalCode) throws Throwable {
        moveToElement(lnk_resource);

        waitForElement(lnk_option2);
		clickOnElement(lnk_option2);

		waitForElement(btn_bankOption);
		btn_bankOption.click();

        switchToWindow();

        waitForElementClickable(btn_bankManagerLogIn);
        btn_bankManagerLogIn.click();

        waitForElement(btn_addCustomer);
        btn_addCustomer.click();

        waitForElement(txt_firstName);
		writeText(txt_firstName, firstName);

        waitForElement(txt_lastName);
		writeText(txt_lastName, lastName);

        waitForElement(txt_postalCode);
		writeText(txt_postalCode, postalCode);

        waitForElement(btn_submitClick);
        clickOnElement(btn_submitClick);

		switchToAlert();

        clickOnElement(btn_customers);

        waitForElement(txt_searchElement);
        writeText(txt_searchCustomer, firstName);

        waitForElement(lbl_name);
        String name = readText(lbl_name);
        return name;
    }
}

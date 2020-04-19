package com.way2automation.base;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class BasePage {

    private WebDriver driver;
    private WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 50);
    }

    public void moveToElement(WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
    }

    public void waitForElement(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void clickOnElement(WebElement element) {
        element.click();
    }

    public String getWindowHandle() {
        return driver.getWindowHandle();
    }

    public Set<String> getWindowHandles() {
        return driver.getWindowHandles();
    }

    public void switchToWindow() {
        String mainWindowHandle = getWindowHandle();
        Set<String> allWindowHandles = getWindowHandles();

        for (String currentWindowHandle : allWindowHandles) {
            if (!currentWindowHandle.equals(mainWindowHandle)) {
                driver.switchTo().window(currentWindowHandle);
            }
        }
    }

    public void writeText(WebElement element, String text) {
        element.sendKeys(text);
    }

    public void switchToAlert() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public String readText(WebElement element) {
        return element.getText();
    }

    public void waitForElementClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}

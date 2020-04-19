package com.way2automation.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {

    //Change : Bcz un-necessary we are giving public access, so better make it protected
    protected static WebDriver driver;
    protected static Properties prop;

    public void loadProperties() {
        prop = new Properties();
        try {
            FileInputStream fin = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\com\\way2automation\\config\\config.properties");
            try {
                prop.load(fin);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Change: method name should be in camel case always
    @BeforeTest
    public void initialization() {
        loadProperties();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(prop.getProperty("url"));
    }

    @AfterTest
    public void tearDown() {
       driver.close();
    }
}

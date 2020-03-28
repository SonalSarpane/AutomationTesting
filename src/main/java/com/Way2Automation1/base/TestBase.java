package com.Way2Automation1.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;

	public TestBase() {
		prop = new Properties();
		try {
			FileInputStream fin = new FileInputStream(
					"C:\\Users\\sonal.sarpane\\workspace\\Way2Automation1\\src\\main\\java\\com\\Way2Automation1\\config\\config.properties");
			try {
				prop.load(fin);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void Initialization()
	{
		String browserName=prop.getProperty("browser");
		if(browserName.equals("chrome"))
		{
			//WebDriverManager.chromedriver().setup();
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\sonal.sarpane\\workspace\\ScreenshotDemo\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		/*else if(browserName.equals("FF"))
		{
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\sonal.sarpane\\workspace\\ScreenshotDemo\\gecodriver.exe");
					 driver=new FirefoxDriver();
		}*/
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		//driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}

}

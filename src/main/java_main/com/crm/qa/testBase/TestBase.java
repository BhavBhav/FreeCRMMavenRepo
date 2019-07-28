package com.crm.qa.testBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.TestUtilities;
import com.crm.qa.util.WebEventListener;

public class TestBase {
	public static Properties prop;
	public static WebDriver driver;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	public TestBase(){
		try {
			//System.out.println("Driver1 is : " +driver);
			prop = new Properties();
			FileInputStream file = new FileInputStream("C:\\Users\\Lucky\\eclipse-workspace"
					+ "\\CRMMaven\\src\\main\\java_main\\com\\crm\\qa\\cofigProperties\\config.Properties");
			prop.load(file);
			
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e){
			e.printStackTrace();
		}
		
	}	
	
	public static void initialize(){
		String browserName = prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\Lucky\\Desktop\\java and Selenium\\Selenium Vidoes\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if (browserName.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Lucky\\Desktop\\java and Selenium\\chromedriver.exe");
			driver = new FirefoxDriver();
		}
		else if (browserName.equalsIgnoreCase("IE")){
			System.setProperty("webdriver.ie.driver", "C:\\Users\\Lucky\\Desktop\\java and Selenium\\chromedriver.exe");
			driver = new InternetExplorerDriver();
		}
		 
		 e_driver= new EventFiringWebDriver(driver);
		 eventListener = new WebEventListener();
		 e_driver.register(eventListener);
		 driver= e_driver;
		 driver.manage().window().maximize();
		 //driver.manage().deleteAllCookies();
		 driver.manage().timeouts().pageLoadTimeout(TestUtilities.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		 driver.manage().timeouts().implicitlyWait(TestUtilities.IMPLICITLY_TIMEOUT, TimeUnit.SECONDS);
		 driver.get(prop.getProperty("url"));		
	}
}

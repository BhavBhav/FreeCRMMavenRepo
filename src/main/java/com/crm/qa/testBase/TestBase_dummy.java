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

public class TestBase_dummy {
	
	public static Properties prop;
	public static WebDriver driver;

	public static void main(String[] args) {
		try {
			System.out.println("Driver1 is : " +driver);
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
		intialize();
	}
	
	public static void intialize(){
		String browserName = prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\Lucky\\Desktop\\java and Selenium\\Selenium Vidoes\\chromedriver.exe");

		}
		else if (browserName.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Lucky\\Desktop\\java and Selenium\\chromedriver.exe");
			driver = new FirefoxDriver();
		}
		else if (browserName.equalsIgnoreCase("IE")){
			System.setProperty("webdriver.ie.driver", "C:\\Users\\Lucky\\Desktop\\java and Selenium\\chromedriver.exe");
			driver = new InternetExplorerDriver();
		}
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().deleteAllCookies();
		 driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 driver.get(prop.getProperty("url"));		
	}
	
	


		
	/*	System.setProperty("webdriver.chrome.driver","C:\\Users\\Lucky\\Desktop\\java and Selenium\\Selenium Vidoes\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.google.com");
	}*/
	
}





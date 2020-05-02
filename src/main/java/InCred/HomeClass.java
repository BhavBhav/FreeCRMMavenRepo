package InCred;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomeClass {
	Properties prop;
	FileInputStream fis;
	public static WebDriver driver = null;
	
	public HomeClass() {
	prop = new Properties();
	try {
		fis = new FileInputStream("C:\\Users\\Lucky\\eclipse-workspace\\CRMMaven\\src\\main\\java_main\\com\\crm\\qa\\cofigProperties\\config.Properties");
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
	try {
		prop.load(fis);
	} catch (IOException e) {
		e.printStackTrace();
	}
	}
	public void initialize() {
		if (prop.getProperty("browser").equalsIgnoreCase("Chrome")) {
	System.setProperty("webdriver.chrome.driver", "E:\\Java and Selenium Videos\\Selenium Vidoes\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get(prop.getProperty("urlInCred"));
	
		}
	}
	
}

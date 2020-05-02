package InCred;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class incredMain {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "E:\\Java and Selenium Videos\\Selenium Vidoes\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.incred.com");
		String str = driver.getTitle();
		System.out.println(str);
		List<WebElement> input=driver.findElements(By.tagName("a"));
		System.out.println(input.size());
		List<WebElement> input1=driver.findElements(By.tagName("ul"));
		System.out.println(input1.size());
		List<WebElement> input3=driver.findElements(By.tagName("li"));
		System.out.println(input3.size());
		List<WebElement> input4=driver.findElements(By.tagName("input"));
		System.out.println(input4.size());
		
		driver.findElement(By.id("apply_now")).click();
		/*
		driver.findElement(By.id("apply_now")).click();
		driver.findElement(By.id("EL")).click();
	*/}

}

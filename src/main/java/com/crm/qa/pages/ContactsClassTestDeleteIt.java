package com.crm.qa.pages;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import com.crm.qa.testBase.TestBase;

public class ContactsClassTestDeleteIt extends TestBase{
	
	public ContactsClassTestDeleteIt() {
		super();
	}
	
	

	public static void main(String[] args) {
		/*
		//Just checking methods to use Bootstap dropdowns
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Lucky\\Desktop\\java and Selenium\\Selenium Vidoes\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_1");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[@class='multiselect dropdown-toggle btn btn-default']")).click();
		List<WebElement> list = driver.findElements(By.xpath("//ul[contains(@class,'multiselect')]//li//a//label"));
		System.out.println(list.get(0).getText());
		System.out.println(list.get(1).getText());
		System.out.println(list.get(2).getText());
		System.out.println(list.get(3).getText());
		System.out.println(list.get(4).getText());
		
		
		driver.quit();*/
		
		
		TestBase testbase = new TestBase();
		testbase.initialize();
		LoginPage loginpage = new LoginPage();
		HomePage homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		ContactsPage contactspage = homepage.contactsPageLabelonHomePage();
		contactspage.createNewContact("vibhav", "Kumar", "Singh", "Accenture", "vibhavkumar94@yahoo.com");
		driver.findElement(By.xpath("//div[@name='channel_type']//i")).click();
		driver.findElement(By.xpath("//*[text()='Facebook']")).click();
		
		try {
			//Status - there are some 5 types of Statuses. tryin to find hidden status called Terminated.
			driver.findElement(By.xpath("//div[@name='status']")).click();
			//driver.findElement(By.xpath("//span[text()='Terminated']")).click();
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println("Status was not found- trying for another Status- InActive");
			driver.findElement(By.xpath("//label[text()='Source']")).click();
			driver.findElement(By.xpath("//div[@name='status']")).click();
			driver.findElement(By.xpath("//span[text()='Inactive']")).click();
		}
		
		//Select DoNotCall Toggle box
		/*WebElement donotToggleClcik = driver.findElement(By.xpath("//input[@name='do_not_call']"));
		Actions action = new Actions(driver);
		action.moveToElement(donotToggleClcik);*/
		
		//Print list of all elements present under Status--MAKE SURE THAT DROPWOWN is clicked and elements are visible
		List<WebElement> list=driver.findElements(By.xpath("//div[@name='status']//div//div"));
		System.out.println("List Size is "+list.size());
		System.out.println("1--"+list.get(0).getText());
		System.out.println("2--"+list.get(1).getText());
		for (int i=0;i<list.size();i++)
		{
			System.out.println((i+1)+" item in the list is : "+list.get(i).getText());
			break;
		}
		driver.findElement(By.xpath("//label[text()='Source']")).click();
		
		driver.findElement(By.xpath("//div[@name='hint']//i[@class='dropdown icon']")).click();
		List<WebElement> list1=driver.findElements(By.xpath("//div[@class='four fields']//div//div[@role='listbox']//div//span"));
		System.out.println("country Size is "+list1.size());
		
		for (int i=0;i<list1.size();i++)
		{
			System.out.println((i+1)+" country in the list is : "+list1.get(i).getText());
			break;
		}
		
		driver.findElement(By.xpath("//label[text()='Source']")).click();
		
		
		
	}

}

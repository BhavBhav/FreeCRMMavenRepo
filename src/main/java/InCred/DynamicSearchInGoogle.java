package InCred;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DynamicSearchInGoogle {
	public static WebDriver driver;
	public static By googleInput = By.xpath("//input[@name='q']");
	
	public static void clickAction(By var) {
		driver.findElement(var);
	}
	public static void sendText(String text) {
		driver.findElement(googleInput).sendKeys(text);
	}

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver","C:\\Users\\Lucky\\Desktop\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		clickAction(googleInput);
		sendText("how i met");
		
		List<WebElement> list = driver.findElements(By.xpath("//div[@class='aajZCb']//ul/li//descendant::div[@class='sbl1']//span"));
		List<WebElement> list1 = driver.findElements(By.tagName("a"));
		System.out.println(list1.size());
		Iterator<WebElement> iterator = list.iterator();
		System.out.println("List size is : "+ list.size());
		while (iterator.hasNext()) {
			String str = iterator.next().getText();
			System.out.println(str);
		}

	}

}

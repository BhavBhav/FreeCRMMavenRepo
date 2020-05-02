package InCred;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FirstPageTest extends HomeClass {
	
	
	@FindBy(xpath="//img[@src='img/logo-new.png']")
	static WebElement logo;
	
	@FindBy(id="apply_now")
	static WebElement applyNow;
	
	public FirstPageTest () {
		super();
		PageFactory.initElements(driver, this);
	}
	
	public void applyNow() {
		applyNow.click();
		driver.findElement(By.id("EL")).click();
	}
	public boolean logoCheck() {
		 boolean isLogoPresent = logo.isDisplayed();
		 return isLogoPresent;
	}
	
	
	
	
}

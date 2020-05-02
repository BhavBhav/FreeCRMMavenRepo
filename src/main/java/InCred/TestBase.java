package InCred;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestBase extends HomeClass {
	HomeClass homeClass;
	FirstPageTest firstPageTest;
	
	public TestBase() {
		super();
	}
	
	@BeforeMethod
	public void launchURL() {
		homeClass = new HomeClass();
		firstPageTest = new FirstPageTest();
		homeClass.initialize();
	}
	
	@Test
	public void logoCheck() {
		System.out.println("I am in Test Method");
		//Assert.assertTrue(firstPageTest.logoCheck(),"First Page test Failed");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}

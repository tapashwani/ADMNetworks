package com.ADMNetworks.Tests;

//import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverBackedSelenium;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import org.testng.Assert;
import com.ADMNetworks.Utill.CustomMethod;
import com.ADMNetworks.Utill.ReadProperty;
import com.thoughtworks.selenium.Selenium;

public class Login {
	private WebDriver driver;
	private String baseUrl;
	CustomMethod custom  = new CustomMethod();
	ReadProperty readp = new ReadProperty();
		
	@BeforeSuite
	public void setUp() throws Exception {
		driver = custom.CreateObject(driver);
		//driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	@AfterSuite
	public void tearDown() throws Exception {
		driver.quit();	
		
	}	

	@Test
	public void testLogin() throws Exception {
		
			//Random rand = new Random();
			baseUrl = readp.readApplicationFile("URL");			
			driver.get(baseUrl);	
			Selenium selenium = new WebDriverBackedSelenium(driver, baseUrl);
			//driver.get("http://acme.schemeserve.com/");
			Assert.assertTrue(custom.isElementPresent(driver, By.id("AboutUs")));
			Assert.assertTrue(custom.isElementPresent(driver, By.id("GetaQuote")));
			Assert.assertTrue(custom.isElementPresent(driver, By.id("ContactUs")));
			Assert.assertTrue(custom.isElementPresent(driver, By.linkText("Existing Users Login")));
			driver.findElement(By.linkText("Existing Users Login")).click();
			driver.findElement(By.id("Username")).clear();
			driver.findElement(By.id("Username")).sendKeys(readp.readLoginFile("User"));
			driver.findElement(By.id("Password")).clear();
			driver.findElement(By.id("Password")).sendKeys(readp.readLoginFile("Password"));
			Assert.assertTrue(custom.isElementPresent(driver, By.name("Login")));
			Assert.assertTrue(custom.isElementPresent(driver, By.linkText("I forgot my username or password")));
			Assert.assertTrue(custom.isElementPresent(driver, By.linkText("Return to My Homepage")));
			driver.findElement(By.name("Login")).click();
			Assert.assertTrue(custom.isElementPresent(driver, By.linkText("My Homepage")));
			Assert.assertTrue(selenium.isTextPresent("Get Quote"));
			Assert.assertTrue(custom.isElementPresent(driver, By.linkText("My Profile")));
			Assert.assertTrue(custom.isElementPresent(driver, By.linkText("My Company")));
			Assert.assertTrue(custom.isElementPresent(driver, By.linkText("Logout")));
			Assert.assertTrue(custom.isElementPresent(driver, By.linkText("HELP GUIDE")));
			Assert.assertTrue(custom.isElementPresent(driver, By.id("Cases")));
			Assert.assertTrue(custom.isElementPresent(driver, By.id("Clients")));
			Assert.assertTrue(custom.isElementPresent(driver, By.id("Agents")));
			Assert.assertTrue(custom.isElementPresent(driver, By.id("Claims")));
			Assert.assertTrue(custom.isElementPresent(driver, By.id("Admin")));
			Assert.assertTrue(custom.isElementPresent(driver, By.id("Reports")));
			Assert.assertTrue(custom.isElementPresent(driver, By.id("UsefulDocuments")));
			Assert.assertTrue(selenium.isTextPresent("Search for Cases"));
			// ERROR: Caught exception [ERROR: Unsupported command [isTextPresent]]
		}
	
}

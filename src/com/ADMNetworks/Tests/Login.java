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
			driver.findElement(By.id("Clients")).click();
			Assert.assertTrue(selenium.isTextPresent("List Clients"));
			Assert.assertTrue(selenium.isTextPresent("Search for clients"));
			Assert.assertTrue(selenium.isTextPresent("Search by ID, name or postal code"));
			driver.findElement(By.linkText("All")).click();
			driver.findElement(By.id("Agents")).click();
			Assert.assertTrue(selenium.isTextPresent("List Agents"));
			Assert.assertTrue(selenium.isTextPresent("Search for agents"));
			driver.findElement(By.id("Claims")).click();
			Assert.assertTrue(selenium.isTextPresent("List Claims"));
			Assert.assertTrue(selenium.isTextPresent("CLAIM TYPE"));
			Assert.assertTrue(selenium.isTextPresent("INSURER"));
			Assert.assertTrue(selenium.isTextPresent("SCHEME"));
			Assert.assertTrue(selenium.isTextPresent("AGENT"));
			Assert.assertTrue(selenium.isTextPresent("CLIENT"));
			Assert.assertTrue(selenium.isTextPresent("DATES"));
			driver.findElement(By.id("Admin")).click();
			Assert.assertTrue(custom.isElementPresent(driver, By.cssSelector("img[alt=\"Schemes\"]")));
			Assert.assertTrue(custom.isElementPresent(driver, By.cssSelector("img[alt=\"Questions\"]")));
			Assert.assertTrue(custom.isElementPresent(driver, By.cssSelector("img[alt=\"Documents\"]")));
			Assert.assertTrue(custom.isElementPresent(driver, By.cssSelector("img[alt=\"Insurers\"]")));
			Assert.assertTrue(custom.isElementPresent(driver, By.cssSelector("img[alt=\"Insurer Rates and Fees\"]")));
			Assert.assertTrue(custom.isElementPresent(driver, By.cssSelector("img[alt=\"Endorsement Library\"]")));
			Assert.assertTrue(custom.isElementPresent(driver, By.cssSelector("img[alt=\"Website\"]")));
			Assert.assertTrue(custom.isElementPresent(driver, By.cssSelector("img[alt=\"Scheme Rule Builder\"]")));
			Assert.assertTrue(custom.isElementPresent(driver, By.cssSelector("img[alt=\"GO\"]")));
			Assert.assertTrue(custom.isElementPresent(driver, By.cssSelector("img[alt=\"Data Lookups\"]")));
			Assert.assertTrue(custom.isElementPresent(driver, By.cssSelector("img[alt=\"Postcodes\"]")));
			Assert.assertTrue(custom.isElementPresent(driver, By.cssSelector("img[alt=\"Insurer Ledger\"]")));
			Assert.assertTrue(custom.isElementPresent(driver, By.cssSelector("img[alt=\"Group Editor\"]")));
			driver.findElement(By.id("Reports")).click();
			Assert.assertTrue(selenium.isTextPresent("Reports"));		
			Assert.assertTrue(selenium.isTextPresent("Filter by..."));
			Assert.assertTrue(selenium.isTextPresent("Run detailed reports"));
			Assert.assertTrue(custom.isElementPresent(driver, By.cssSelector("img[alt=\"New Report\"]")));
			driver.findElement(By.id("UsefulDocuments")).click();
		}
	
}

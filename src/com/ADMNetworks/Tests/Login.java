package com.ADMNetworks.Tests;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverBackedSelenium;
import org.testng.annotations.*;
import org.testng.Assert;
import com.ADMNetworks.Utill.CustomMethod;
import com.ADMNetworks.Utill.ReadProperty;
import com.thoughtworks.selenium.Selenium;

public class Login {
	
	private WebDriver driver;
	CustomMethod custom  = new CustomMethod();
	ReadProperty readp = new ReadProperty();
	String str = "";
	String str1 = "null";
	int Counter = 0;
	
	@DataProvider(name = "DP1")
	    public Object[][] createData() {
		  Object[][] retObjArr= custom.GetDataprovider();
		  return (retObjArr);
    	}
	
	@BeforeMethod
	public void setUp() throws Exception {
		driver = custom.CreateObject(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
	
	@AfterMethod
	public void tearDown() throws Exception {
		driver.quit();	
		
	}	

	@Test (dataProvider = "DP1")
	public void testLogin(String Url) throws Exception {		
			driver.get(Url);	
			if (Counter == 0)
			{
				System.out.println("Using test Url 1");
			}
			if (Counter == 1)
			{
				System.out.println("Using test Url 2");
			}			
			String Getstr1=readp.readDatafrom("CombinedLiability", "PolicyID1");
			System.out.println(Getstr1);
			String Getstr2=readp.readDatafrom("MotorHireReward", "PolicyID1");
			System.out.println(Getstr2);
			Selenium selenium = new WebDriverBackedSelenium(driver, Url);
			driver.findElement(By.linkText("Existing Users Login")).click();
			custom.Login(driver,selenium, "Admin");		
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
			Counter = Counter+1;
		}
	
}

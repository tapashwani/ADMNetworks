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
//import com.thoughtworks.selenium.SeleniumException;

public class CreatingNCResidentialLandlords {
	
	private WebDriver driver;
	private String baseUrl1;
	private String baseUrl2;
	CustomMethod custom  = new CustomMethod();
	ReadProperty readp = new ReadProperty();
	
	@DataProvider(name = "DP1")
    public Object[][] createData() {
	baseUrl1 = readp.readApplicationFile("URL");
	baseUrl2 = readp.readApplicationFile("URLLabs");
        Object[][] retObjArr={{baseUrl1},
                            {baseUrl2}};
        return(retObjArr);
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
	public void testCreatingNCResidentialLandlords(String Url) throws Exception {	
		
			driver.get(Url);		
			Selenium selenium = new WebDriverBackedSelenium(driver, Url);
			Assert.assertTrue(custom.isElementPresent(driver, By.id("AboutUs")));
			Assert.assertTrue(custom.isElementPresent(driver, By.id("GetaQuote")));
			Assert.assertTrue(custom.isElementPresent(driver, By.id("ContactUs")));
			driver.findElement(By.id("GetaQuote")).click();
			Thread.sleep(7000);
			Assert.assertTrue(selenium.isTextPresent("Get a quick quote"));
			driver.findElement(By.linkText("Residential Landlords")).click();
			Assert.assertTrue(custom.isElementPresent(driver, By.name("AgentRegistration")));
			Assert.assertTrue(custom.isElementPresent(driver, By.linkText("click here to sign in")));
			Assert.assertTrue(selenium.isElementPresent("name=AgentRegistration"));
			Assert.assertTrue(selenium.isTextPresent("Search for existing client (optional)"));
			Assert.assertTrue(selenium.isTextPresent("Back"));		
			Assert.assertTrue(custom.isElementPresent(driver,By.id("ctl00_MainContent_btnNext")));
			driver.findElement(By.linkText("click here to sign in")).click();
			driver.findElement(By.id("Username")).clear();
			driver.findElement(By.id("Username")).sendKeys("360logica");
			driver.findElement(By.id("Password")).clear();
			driver.findElement(By.id("Password")).sendKeys("admtest");
			Assert.assertTrue(custom.isElementPresent(driver, By.linkText("I forgot my username or password")));
			Assert.assertTrue(custom.isElementPresent(driver, By.linkText("Return to My Homepage")));
			driver.findElement(By.name("Login")).click();
			Assert.assertTrue(custom.isElementPresent(driver, By.name("SignOut")));
			Assert.assertTrue(selenium.isTextPresent("Search for existing client (optional)"));
			driver.findElement(By.id("ctl00_MainContent_btnNext")).click();
			Assert.assertTrue(custom.isElementPresent(driver, By.name("QuestionPage_Next")));
			Assert.assertTrue(custom.isElementPresent(driver, By.name("SubmitQuote")));
			Assert.assertTrue(selenium.isTextPresent("Statement of Facts"));
			Assert.assertTrue(selenium.isTextPresent("Property Details"));
			Assert.assertTrue(selenium.isTextPresent("Claims Details"));
			Assert.assertTrue(selenium.isTextPresent("Optional Extras"));
			Assert.assertTrue(selenium.isTextPresent("Client"));
			driver.findElement(By.cssSelector("#stub_page_Page2 > div.inner")).click();
			driver.findElement(By.id("Prop1AddressLine1")).clear();
			driver.findElement(By.id("Prop1AddressLine1")).sendKeys("Test1");
			driver.findElement(By.id("Prop1AddressLine2")).clear();
			driver.findElement(By.id("Prop1AddressLine2")).sendKeys("test2");
			driver.findElement(By.id("Prop1AddressTown")).clear();
			driver.findElement(By.id("Prop1AddressTown")).sendKeys("Foster CIty");
			driver.findElement(By.id("Prop1AddressCounty")).clear();
			driver.findElement(By.id("Prop1AddressCounty")).sendKeys("USA");
			driver.findElement(By.id("Prop1AddressPostCode")).clear();
			driver.findElement(By.id("Prop1AddressPostCode")).sendKeys("94404");
			selenium.select("id=Prop1TypeOfProperty", "label=Single Self Contained Flat");
			selenium.select("id=Prop1FlatRoofPercentage", "label=11-25%");
			selenium.select("id=Prop1SecurityAlarm", "label=Digital Communicator");
			driver.findElement(By.id("Prop1BuildingsSumInsured")).clear();
			driver.findElement(By.id("Prop1BuildingsSumInsured")).sendKeys("250");
			driver.findElement(By.id("Prop1ContentsSumInsured")).clear();
			driver.findElement(By.id("Prop1ContentsSumInsured")).sendKeys("275");
			selenium.select("id=Prop1Occupancy", "label=Unoccupied");
			driver.findElement(By.cssSelector("#stub_page_Page5 > div.inner")).click();
			driver.findElement(By.cssSelector("#stub_page_Page2 > div.inner")).click();
			driver.findElement(By.id("Prop1YearBuilt")).clear();
			driver.findElement(By.id("Prop1YearBuilt")).sendKeys("2010");
			driver.findElement(By.cssSelector("#stub_page_Page5 > div.inner")).click();
			driver.findElement(By.cssSelector("#stub_page_Page6 > div.inner")).click();
			driver.findElement(By.cssSelector("#stub_page_Page1 > div.inner")).click();
			driver.findElement(By.id("ctl00_MainContent_CA1_AddressLine1")).clear();
			driver.findElement(By.id("ctl00_MainContent_CA1_AddressLine1")).sendKeys("test line");
			driver.findElement(By.id("ctl00_MainContent_CA1_TownCity")).clear();
			driver.findElement(By.id("ctl00_MainContent_CA1_TownCity")).sendKeys("Foster city");
			driver.findElement(By.id("ctl00_MainContent_CA1_County")).clear();
			driver.findElement(By.id("ctl00_MainContent_CA1_County")).sendKeys("USA");
			driver.findElement(By.id("ctl00_MainContent_CA1_Postcode")).clear();
			driver.findElement(By.id("ctl00_MainContent_CA1_Postcode")).sendKeys("sg2 8bj");
			selenium.click("document.forms[0].elements[232]");
			Assert.assertEquals("Please correct the problems on the pages with an exclamation mark before we proceed", selenium.getAlert());
			selenium.select("id=ctl00_MainContent_ClientContact_Title", "label=Mr");
			driver.findElement(By.cssSelector("option[value=\"Mr\"]")).click();
			Thread.sleep(5000);
			driver.findElement(By.id("ctl00_MainContent_ClientContact_Firstname")).clear();
			driver.findElement(By.id("ctl00_MainContent_ClientContact_Firstname")).sendKeys("testing");
			driver.findElement(By.id("ctl00_MainContent_ClientContact_Surname")).clear();
			driver.findElement(By.id("ctl00_MainContent_ClientContact_Surname")).sendKeys("Client");
			driver.findElement(By.id("Next")).click();
			Assert.assertTrue(selenium.isTextPresent("Quote submitted"));
			String CaseID = driver.findElement(By.xpath("//div[@id='ctl00_MainContent_SummaryDefault']/h3/span")).getText();
			System.out.println(CaseID);
			Assert.assertTrue(selenium.isTextPresent("Your quotation reference is"));
			Assert.assertTrue(custom.isElementPresent(driver, By.id("ctl00_MainContent_btnSave")));
			Assert.assertTrue(custom.isElementPresent(driver, By.id("ctl00_MainContent_btnProceed")));
			driver.findElement(By.id("ctl00_MainContent_btnSave")).click();
			driver.findElement(By.id("Next")).click();
			Assert.assertTrue(selenium.isTextPresent("Viewing Summary for " + CaseID));
			Assert.assertTrue(custom.isElementPresent(driver, By.linkText("Endorsements")));
			Assert.assertTrue(custom.isElementPresent(driver, By.linkText("Matrix")));
			Assert.assertTrue(custom.isElementPresent(driver, By.linkText("Documents")));
			Assert.assertTrue(custom.isElementPresent(driver, By.linkText("Notes")));
			Assert.assertTrue(custom.isElementPresent(driver, By.linkText("Money")));
			Assert.assertTrue(custom.isElementPresent(driver, By.linkText("Activity")));
			Assert.assertTrue(selenium.isTextPresent("History"));
			Assert.assertTrue(custom.isElementPresent(driver, By.cssSelector("span.label")));
			Assert.assertTrue(selenium.isTextPresent("User Saved"));						
	}
	
	public void waitForElementPresent(String locator, int timeout) throws Exception {
		  for (int second = 0; second<200; second++) {
		       if (second >= timeout)
		           //throw new SeleniumException("Timout finding: " + locator);
		           try {
		                if (custom.isElementPresent(driver, By.cssSelector(locator)))
		                    break;
			            }
			            catch (Exception ex) {}
			            Thread.sleep(1000); 
			       } 
			 
			}
	public void waitForElementPresentid(String locator, int timeout) throws Exception {
		  for (int second = 0; second<200; second++) {
		       if (second >= timeout)
		           try {
		                if (custom.isElementPresent(driver, By.id(locator)))
		                    break;
			            }
			            catch (Exception ex) {}
			       } 
			 
			}
}

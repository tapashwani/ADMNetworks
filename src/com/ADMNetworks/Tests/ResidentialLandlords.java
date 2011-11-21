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

public class ResidentialLandlords {
	
	private WebDriver driver;
	CustomMethod custom  = new CustomMethod();
	ReadProperty readp = new ReadProperty();
	
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
	public void testResidentialLandlords(String Url) throws Exception {	
		
			driver.get(Url);		
			Selenium selenium = new WebDriverBackedSelenium(driver, Url);
			Assert.assertTrue(custom.isElementPresent(driver, By.id("AboutUs")));
			Assert.assertTrue(custom.isElementPresent(driver, By.id("GetaQuote")));
			Assert.assertTrue(custom.isElementPresent(driver, By.id("ContactUs")));
			driver.findElement(By.id("GetaQuote")).click();
			Thread.sleep(7000);
			Assert.assertTrue(selenium.isTextPresent("Get a quick quote"));
			driver.findElement(By.linkText("Residential Landlords")).click();
			custom.waitForElementPresentid(driver, "ctl00_MainContent_btnNext", 51);
			Assert.assertTrue(custom.isElementPresent(driver, By.name("AgentRegistration")));
			Assert.assertTrue(custom.isElementPresent(driver, By.linkText("click here to sign in")));
			Assert.assertTrue(selenium.isElementPresent("name=AgentRegistration"));
			Assert.assertTrue(selenium.isTextPresent("Search for existing client (optional)"));
			Assert.assertTrue(selenium.isTextPresent("Back"));		
			Assert.assertTrue(custom.isElementPresent(driver,By.id("ctl00_MainContent_btnNext")));
			driver.findElement(By.linkText("click here to sign in")).click();
			custom.waitForElementPresentid(driver, "Username",61);
			Assert.assertTrue(custom.isElementPresent(driver, By.linkText("I forgot my username or password")));
			Assert.assertTrue(custom.isElementPresent(driver, By.linkText("Return to My Homepage")));
			custom.Login(driver, selenium, "Admin");
			/*driver.findElement(By.id("Username")).clear();
			driver.findElement(By.id("Username")).sendKeys("360logica");
			driver.findElement(By.id("Password")).clear();
			driver.findElement(By.id("Password")).sendKeys("admtest");*/
			//driver.findElement(By.name("Login")).click();
			Assert.assertTrue(custom.isElementPresent(driver, By.name("SignOut")));
			Assert.assertTrue(selenium.isTextPresent("Search for existing client (optional)"));
			custom.waitForElementPresentid(driver, "ctl00_MainContent_btnNext", 60);
			driver.findElement(By.id("ctl00_MainContent_btnNext")).click();
			Thread.sleep(3000);
			Assert.assertTrue(custom.isElementPresent(driver, By.name("QuestionPage_Next")));
			Assert.assertTrue(custom.isElementPresent(driver, By.name("SubmitQuote")));
			Assert.assertTrue(selenium.isTextPresent("Statement of Facts"));
			Assert.assertTrue(selenium.isTextPresent("Property Details"));
			Assert.assertTrue(selenium.isTextPresent("Claims Details"));
			Assert.assertTrue(selenium.isTextPresent("Optional Extras"));
			Assert.assertTrue(selenium.isTextPresent("Client"));
			custom.waitForElementPresent(driver, "#stub_page_Page2 > div.inner", 60);
			driver.findElement(By.cssSelector("#stub_page_Page2 > div.inner")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("Prop1AddressLine1")).clear();
			driver.findElement(By.id("Prop1AddressLine1")).sendKeys("Test1");
			driver.findElement(By.id("Prop1AddressLine2")).clear();
			driver.findElement(By.id("Prop1AddressLine2")).sendKeys("test2");
			driver.findElement(By.id("Prop1AddressTown")).clear();
			driver.findElement(By.id("Prop1AddressTown")).sendKeys("Foster City");
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
			//custom.waitForElementPresent(driver, "#stub_page_Page5 > div.inner", 60);
			driver.findElement(By.cssSelector("#stub_page_Page5 > div.inner")).click();
			//custom.waitForElementPresent(driver, "#stub_page_Page6 > div.inner", 60);
			driver.findElement(By.cssSelector("#stub_page_Page6 > div.inner")).click();
			//custom.waitForElementPresent(driver, "#stub_page_Page1 > div.inner", 60);
			driver.findElement(By.cssSelector("#stub_page_Page1 > div.inner")).click();
			custom.waitForElementPresentid(driver, "ctl00_MainContent_CA1_AddressLine1", 60);
			driver.findElement(By.id("ctl00_MainContent_CA1_AddressLine1")).clear();
			driver.findElement(By.id("ctl00_MainContent_CA1_AddressLine1")).sendKeys("test line");
			driver.findElement(By.id("ctl00_MainContent_CA1_TownCity")).clear();
			driver.findElement(By.id("ctl00_MainContent_CA1_TownCity")).sendKeys("Foster city");
			driver.findElement(By.id("ctl00_MainContent_CA1_County")).clear();
			driver.findElement(By.id("ctl00_MainContent_CA1_County")).sendKeys("USA");
			driver.findElement(By.id("ctl00_MainContent_CA1_Postcode")).clear();
			driver.findElement(By.id("ctl00_MainContent_CA1_Postcode")).sendKeys("sg2 8bj");
			//selenium.click("document.forms[0].elements[232]");
			//Assert.assertEquals("Please correct the problems on the pages with an exclamation mark before we proceed", selenium.getAlert());
			selenium.select("id=ctl00_MainContent_ClientContact_Title", "label=Mr");
			driver.findElement(By.cssSelector("option[value=\"Mr\"]")).click();
			custom.waitForElementPresentid(driver, "ctl00_MainContent_ClientContact_Firstname", 51);
			driver.findElement(By.id("ctl00_MainContent_ClientContact_Firstname")).clear();
			driver.findElement(By.id("ctl00_MainContent_ClientContact_Firstname")).sendKeys("testing");
			driver.findElement(By.id("ctl00_MainContent_ClientContact_Surname")).clear();
			driver.findElement(By.id("ctl00_MainContent_ClientContact_Surname")).sendKeys("Client");
			selenium.click("document.forms[0].elements[232]");
			custom.waitForElementPresentid(driver, "ctl00_MainContent_btnSave", 51);
			Assert.assertTrue(selenium.isTextPresent("Quote submitted"));
			String CaseID = driver.findElement(By.xpath("//div[@id='ctl00_MainContent_SummaryDefault']/h3/span")).getText();
			System.out.println(CaseID);
			Assert.assertTrue(selenium.isTextPresent("Your quotation reference is"));
			Assert.assertTrue(custom.isElementPresent(driver, By.id("ctl00_MainContent_btnSave")));
			Assert.assertTrue(custom.isElementPresent(driver, By.id("ctl00_MainContent_btnProceed")));
			driver.findElement(By.id("ctl00_MainContent_btnSave")).click();
			custom.waitForElementPresentid(driver, "Next", 51);
			driver.findElement(By.id("Next")).click();
			custom.waitForElementPresent(driver, "span.label", 51);
			Assert.assertTrue(selenium.isTextPresent("Viewing Summary for " + CaseID));
			Assert.assertTrue(custom.isElementPresent(driver, By.linkText("Endorsements")));
			Assert.assertTrue(custom.isElementPresent(driver, By.linkText("Matrix")));
			Assert.assertTrue(custom.isElementPresent(driver, By.linkText("Documents")));
			Assert.assertTrue(custom.isElementPresent(driver, By.linkText("Notes")));
			Assert.assertTrue(custom.isElementPresent(driver, By.linkText("Money")));
			Assert.assertTrue(custom.isElementPresent(driver, By.linkText("Activity")));
			Assert.assertTrue(selenium.isTextPresent("History"));
			custom.waitForElementPresent(driver, "span.label", 61);
			Assert.assertTrue(custom.isElementPresent(driver, By.cssSelector("span.label")));
			Assert.assertTrue(selenium.isTextPresent("User Saved"));	
			driver.findElement(By.id("display_status")).click();
			Thread.sleep(2000);
			selenium.select("id=change_status", "label=Quotation");
			//Assert.assertTrue(custom.isElementPresent(driver, By.linkText("Change status only")));
			//Assert.assertTrue(custom.isElementPresent(driver, By.cssSelector("#StatusChangeWarning > div > img")));
			//Assert.assertTrue(custom.isElementPresent(driver, By.linkText("Cancel")));
			//driver.findElement(By.linkText("Change status only")).click();
			custom.waitForElementPresentid(driver, "img[alt=\"Re-Quote\"]", 51);
			Assert.assertTrue(custom.isElementPresent(driver, By.cssSelector("img[alt=\"Re-Quote\"]")));
			Assert.assertTrue(custom.isElementPresent(driver, By.cssSelector("img[alt=\"ACME\"]")));
			Assert.assertTrue(custom.isElementPresent(driver, By.cssSelector("img[alt=\"switch\"]")));
			driver.findElement(By.linkText("Endorsements")).click();
			Thread.sleep(3000);
			Assert.assertTrue(selenium.isTextPresent("Conditions"));
			driver.findElement(By.linkText("Add a new Conditions question")).click();
			custom.waitForElementPresent(driver, "Question.Text", 60);
			Assert.assertTrue(selenium.isTextPresent("Adding a Conditions item"));
			driver.findElement(By.id("Question.Text")).clear();
			driver.findElement(By.id("Question.Text")).sendKeys("Test Condition");
			driver.findElement(By.id("Question.Save")).click();
			Thread.sleep(3000);
			driver.findElement(By.linkText("Add a new Memorandum question")).click();
			driver.findElement(By.id("Question.Text")).clear();
			driver.findElement(By.id("Question.Text")).sendKeys("Test Memo");
			driver.findElement(By.id("Question.DefaultValue")).clear();
			driver.findElement(By.id("Question.DefaultValue")).sendKeys("testing Memorandum.");
			driver.findElement(By.id("Question.Save")).click();
			Thread.sleep(3000);
			driver.findElement(By.linkText("Matrix")).click();			
			custom.waitForElementPresent(driver, "TotalPremiumNet_result_span", 60);
			//String Totalpremium = driver.findElement(By.id("TotalPremiumNet_result_span")).getText();
			//String TP = driver.findElement(By.id("TotalPremium_result_span")).getText();
			driver.findElement(By.linkText("Documents")).click();
			driver.findElement(By.cssSelector("img.hand")).click();
			selenium.select("name=NewDocumentType", "label=Certificate - Combined Liability - Aviva");
			driver.findElement(By.id("ctl00_ctl00_MainContent_Grey_PolicyContent_btnSave")).click();
			driver.findElement(By.xpath("//div[@id='content']/table/tbody/tr/td/div[2]/div/div[9]/div/a")).click();
			Thread.sleep(3000);
			Assert.assertTrue(selenium.isTextPresent("Claims for this case"));
			Assert.assertTrue(selenium.isTextPresent("Excesses for this case"));
			
			/*driver.findElement(By.linkText("Notes")).click();
			driver.findElement(By.id("ctl00_ctl00_MainContent_Grey_PolicyContent_Img1")).click();
			this.waitForElementPresent("body.cke_show_borders", 60);
			Assert.assertTrue(selenium.isTextPresent("Add a note"));
			Thread.sleep(3000);
			Assert.assertTrue(custom.isElementPresent(driver, By.id("NewNote")));
			Assert.assertTrue(custom.isElementPresent(driver, By.linkText("Cancel")));
			driver.findElement(By.cssSelector("img[alt=\"close\"]")).click();*/
			
			driver.findElement(By.linkText("Money")).click();
			Thread.sleep(5000);
			Assert.assertTrue(custom.isElementPresent(driver, By.linkText("Take Card Payment")));
			Assert.assertTrue(custom.isElementPresent(driver, By.linkText("Record Cheque")));
			Assert.assertTrue(custom.isElementPresent(driver, By.linkText("Record Bank Payment")));
			driver.findElement(By.linkText("Take Card Payment")).click();
			custom.waitForElementPresent(driver, "img[alt=\"close\"]", 60);
			driver.findElement(By.cssSelector("img[alt=\"close\"]")).click();
			driver.findElement(By.linkText("Record Cheque")).click();
			custom.waitForElementPresent(driver, "img[alt=\"close\"]", 60);
			driver.findElement(By.cssSelector("img[alt=\"close\"]")).click();
			driver.findElement(By.linkText("Record Bank Payment")).click();
			custom.waitForElementPresent(driver, "img[alt=\"close\"]", 60);
			driver.findElement(By.cssSelector("img[alt=\"close\"]")).click();
			driver.findElement(By.linkText("Activity")).click();
			driver.findElement(By.linkText("Logout")).click();
	}
	
}

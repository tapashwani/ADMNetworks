package com.ADMNetworks.Tests;

//import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverBackedSelenium;
import org.testng.annotations.*;
import org.testng.Assert;
import com.ADMNetworks.Utill.CustomMethod;
import com.ADMNetworks.Utill.ReadProperty;
import com.ADMNetworks.Utill.WritePropertiesFile;
import com.thoughtworks.selenium.Selenium;


public class ResidentialLandlords {
	
	private WebDriver driver;
	
	//Create object
	CustomMethod custom  = new CustomMethod();
	ReadProperty readp = new ReadProperty();
	WritePropertiesFile write = new WritePropertiesFile();
	String timeout = readp.readApplicationFile("Timeout");
	
	// Variable defined
	int Counter = 0;
	String str11="";
	String str12="";
	String str21="";
	String str22="";
	String PolicyID1,PolicyID2;
	
	
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
			ResidentialLandlordstest(driver,Url,Counter);
			Counter=Counter+1;
	}
	   
	public void ResidentialLandlordstest(WebDriver driver,String Url,int Counter) throws Exception{				
		
			driver.get(Url);
			Selenium selenium = new WebDriverBackedSelenium(driver, Url);
			
			//Create new properties file or reset the value if file already exist 
			if (Counter==0){
				write.CreateNewFiles("ResidentialLandlords");
				write.WritePropertyFile("ResidentialLandlords", "PolicyID1", "NA");
				write.WritePropertyFile("ResidentialLandlords", "PolicyID2", "NA");
				write.WritePropertyFile("ResidentialLandlords", "TotalNP1", "NA");
				write.WritePropertyFile("ResidentialLandlords", "TotalGP1", "NA");
				write.WritePropertyFile("ResidentialLandlords", "TotalNP2", "NA");
				write.WritePropertyFile("ResidentialLandlords", "TotalGP2", "NA");
			}
			
			//Click on Quotes tab and fill the answer.
			driver.findElement(By.id("GetaQuote")).click();
			Thread.sleep(4000);
			driver.findElement(By.linkText("Residential Landlords")).click();
			custom.waitForElementPresentid(driver, "ctl00_MainContent_btnNext", 51);
			driver.findElement(By.linkText("click here to sign in")).click();
			custom.waitForElementPresentid(driver, "Username",61);
			custom.Login(driver, selenium, "Admin");
			custom.waitForElementPresentid(driver, "ctl00_MainContent_btnNext", 60);
			driver.findElement(By.id("ctl00_MainContent_btnNext")).click();
			Thread.sleep(3000);
			custom.waitForElementPresent(driver, "#stub_page_Page2 > div.inner", 60);
			driver.findElement(By.cssSelector("#stub_page_Page2 > div.inner")).click();
			Thread.sleep(4000);
			driver.findElement(By.id("Prop1AddressLine1")).sendKeys("Test1");
			driver.findElement(By.id("Prop1AddressLine2")).sendKeys("test2");
			driver.findElement(By.id("Prop1AddressTown")).sendKeys("Foster City");
			driver.findElement(By.id("Prop1AddressCounty")).sendKeys("USA");
			driver.findElement(By.id("Prop1AddressPostCode")).sendKeys("94404");
			selenium.select("id=Prop1TypeOfProperty", "label=Single Self Contained Flat");
			selenium.select("id=Prop1FlatRoofPercentage", "label=11-25%");
			selenium.select("id=Prop1SecurityAlarm", "label=Digital Communicator");
			driver.findElement(By.id("Prop1BuildingsSumInsured")).sendKeys("250");
			driver.findElement(By.id("Prop1ContentsSumInsured")).sendKeys("275");
			selenium.select("id=Prop1Occupancy", "label=Unoccupied");
			driver.findElement(By.cssSelector("#stub_page_Page5 > div.inner")).click();
			driver.findElement(By.cssSelector("#stub_page_Page2 > div.inner")).click();
			driver.findElement(By.id("Prop1YearBuilt")).sendKeys("2010");
			driver.findElement(By.cssSelector("#stub_page_Page5 > div.inner")).click();
			Thread.sleep(4000);
			driver.findElement(By.cssSelector("#stub_page_Page6 > div.inner")).click();
			Thread.sleep(4000);
			driver.findElement(By.cssSelector("#stub_page_Page1 > div.inner")).click();
			Thread.sleep(4000);
			custom.waitForElementPresentid(driver, "ctl00_MainContent_CA1_AddressLine1", 60);
			driver.findElement(By.id("ctl00_MainContent_CA1_AddressLine1")).sendKeys("test line");
			driver.findElement(By.id("ctl00_MainContent_CA1_TownCity")).sendKeys("Foster city");
			driver.findElement(By.id("ctl00_MainContent_CA1_County")).sendKeys("USA");
			driver.findElement(By.id("ctl00_MainContent_CA1_Postcode")).sendKeys("sg2 8bj");
			selenium.click("document.forms[0].elements[232]");
			selenium.waitForPageToLoad(timeout);
			Thread.sleep(2000);
			selenium.select("id=ctl00_MainContent_ClientContact_Title", "label=Mr");
			driver.findElement(By.cssSelector("option[value=\"Mr\"]")).click();
			custom.waitForElementPresentid(driver, "ctl00_MainContent_ClientContact_Firstname", 51);
			driver.findElement(By.id("ctl00_MainContent_ClientContact_Firstname")).sendKeys("testing");
			driver.findElement(By.id("ctl00_MainContent_ClientContact_Surname")).sendKeys("Client");
			selenium.click("document.forms[0].elements[232]");
			selenium.waitForPageToLoad("30000");
			custom.waitForElementPresentid(driver, "ctl00_MainContent_btnSave", 51);
			String CaseID = driver.findElement(By.xpath("//div[@id='ctl00_MainContent_SummaryDefault']/h3/span")).getText();
			System.out.println(CaseID);
			driver.findElement(By.id("ctl00_MainContent_btnSave")).click();
			custom.waitForElementPresentid(driver, "Next", 51);
			driver.findElement(By.id("Next")).click();
			Thread.sleep(3000);
			
			//Click on Matrix tab, store values in variables and MotorHireReward.properties file
			driver.findElement(By.linkText("Matrix")).click();	
			Thread.sleep(4000);
			String Basic_161 = driver.findElement(By.id("Basic_161_result_span")).getText();
			Basic_161 = Basic_161.replace( '\u00A3', '*' );              
			String Basic_162 = driver.findElement(By.id("Basic_162_result_span")).getText();
			Basic_162 = Basic_162.replace( '\u00A3', '*' );
			String TPNet = driver.findElement(By.id("TotalPremiumNet_result_span")).getText();
			TPNet = TPNet.replace( '\u00A3', '*' );
			
			// Execution occur when script run 1st time.
			if (Counter == 0)
			{
				str11 = Basic_161;
				str12 = Basic_162;
				PolicyID1=CaseID;
				write.WritePropertyFile("ResidentialLandlords", "PolicyID1", PolicyID1);
				write.WritePropertyFile("ResidentialLandlords", "TotalGP1", str11);
				write.WritePropertyFile("ResidentialLandlords", "TotalNP1", str12);
				write.WritePropertyFile("ResidentialLandlords", "TPNet1", TPNet);
			}
			
			// Execution occur when script run 2nd time.
			if (Counter == 1)
			{
				str21=Basic_161;
				str22=Basic_162;
				PolicyID2=CaseID;				
				write.WritePropertyFile("ResidentialLandlords", "PolicyID2", PolicyID2);
				write.WritePropertyFile("ResidentialLandlords", "TotalGP2", str21);
				write.WritePropertyFile("ResidentialLandlords", "TotalNP2", str22);
				write.WritePropertyFile("ResidentialLandlords", "TPNet2", TPNet);
				
				//Compare the stored value from the property file.
				Assert.assertEquals(str21, readp.readDatafrom("ResidentialLandlords", "TotalGP1"));
				Assert.assertEquals(str22, readp.readDatafrom("ResidentialLandlords", "TotalNP1"));
				Assert.assertEquals(TPNet, readp.readDatafrom("ResidentialLandlords", "TPNet1"));
				
			}
			
			driver.findElement(By.linkText("Logout")).click();
			
	}
	
}

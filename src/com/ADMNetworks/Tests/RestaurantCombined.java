package com.ADMNetworks.Tests;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverBackedSelenium;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import org.testng.Assert;
import com.ADMNetworks.Utill.CustomMethod;
import com.ADMNetworks.Utill.ReadProperty;
import com.ADMNetworks.Utill.WritePropertiesFile;
import com.thoughtworks.selenium.Selenium;

public class RestaurantCombined {
	
	private WebDriver driver;
	
	//Create Objects
	CustomMethod custom  = new CustomMethod();
	ReadProperty readp = new ReadProperty();
	WritePropertiesFile write = new WritePropertiesFile();
	String timeout = readp.readApplicationFile("Timeout");
	
	//Define variables
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
	public void testRestaurantCombined(String Url) throws Exception {
		
		RestaurantCombinedtest(driver, Url,Counter);
		Counter=Counter+1;
	}
	
	public void RestaurantCombinedtest(WebDriver driver, String Url,int Counter) throws Exception
	{
		
		driver.get(Url);	
		Selenium selenium = new WebDriverBackedSelenium(driver, Url);
		
		//Create new properties file or reset the value if file already exist 
		if (Counter==0){			
			write.CreateNewFiles("RestaurantCombined");
			write.WritePropertyFile("RestaurantCombined", "PolicyID1", "NA");
			write.WritePropertyFile("RestaurantCombined", "PolicyID2", "NA");
			write.WritePropertyFile("RestaurantCombined", "TotalNP1", "NA");
			write.WritePropertyFile("RestaurantCombined", "TotalGP1", "NA");
			write.WritePropertyFile("RestaurantCombined", "TotalNP2", "NA");
			write.WritePropertyFile("RestaurantCombined", "TotalGP2", "NA");		
		}
		
		//Click on Quotes tab and fill the answer.
		driver.findElement(By.id("GetaQuote")).click();
		driver.findElement(By.linkText("Restaurant Combined")).click();
		Thread.sleep(5000);
		driver.findElement(By.linkText("click here to sign in")).click();
		custom.waitForElementPresentid(driver, "Username",61);
		custom.Login(driver, selenium, "Admin");
		Thread.sleep(4000);
		driver.findElement(By.id("ctl00_MainContent_btnNext")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("#stub_page_Page1 > div.inner")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("OfficeReference")).sendKeys("NA");
		driver.findElement(By.id("PartnerName")).sendKeys("Mr. Tester Jr");
		driver.findElement(By.id("HoldingBroker_Yes")).click();
		driver.findElement(By.id("TargetPremium")).sendKeys("500");
		driver.findElement(By.id("ConfirmEmail")).sendKeys("test360.5@gmail.com");
		driver.findElement(By.id("Address1")).sendKeys("testing");
		driver.findElement(By.id("County")).sendKeys("USA");
		driver.findElement(By.id("Postcode")).sendKeys("94404");
		driver.findElement(By.id("SurveyName")).sendKeys("Tester Sr");
		driver.findElement(By.id("SurveyPosition")).sendKeys("NA");
		driver.findElement(By.cssSelector("#stub_page_Page4 > div.inner")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("ConstructionRbl_No")).click();
		driver.findElement(By.id("ConstructionRbl_Yes")).click();
		driver.findElement(By.id("FlatRoof_Yes")).click();
		driver.findElement(By.id("FlatRoof_No")).click();
		driver.findElement(By.id("CurrentDuration")).sendKeys("2010");
		driver.findElement(By.id("ElsewhereDuration")).sendKeys("2005");
		driver.findElement(By.id("ContInsuranceRbl_No")).click();
		driver.findElement(By.id("ContInsuranceRbl_Yes")).click();
		driver.findElement(By.cssSelector("#question_ContInsuranceRbl > label.radio")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("ContInsuranceRbl_No")).click();
		driver.findElement(By.id("ReasonNotCont")).sendKeys("Testing");
		driver.findElement(By.id("SeaFrontRbl_No")).click();
		driver.findElement(By.id("CliffTopRbl_No")).click();
		driver.findElement(By.id("RiverRbl_Yes")).click();
		driver.findElement(By.id("FloodRbl_No")).click();
		driver.findElement(By.id("BusinessHours")).sendKeys("9AM");
		driver.findElement(By.id("ResidentsRbl_No")).click();
		driver.findElement(By.id("ManagerDetails")).sendKeys("Mr tester Jr");
		driver.findElement(By.id("AlarmRbl_Yes")).click();
		driver.findElement(By.cssSelector("#stub_page_Page7 > div.inner")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("AlarmInstall")).sendKeys("Security Set");
		driver.findElement(By.id("InstallApproveRbl_No")).click();
		Thread.sleep(3000);
		selenium.select("id=SignallingType", "label=Digital Communicator");
		driver.findElement(By.id("PoliceResponseLevel_No")).click();
		driver.findElement(By.id("PResponseWithdrawn_No")).click();
		driver.findElement(By.name("PResponseWithdrawn_No")).sendKeys("test");
		driver.findElement(By.cssSelector("#stub_page_Page5 > div.inner")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("ClaimsHistory_No")).click();
		driver.findElement(By.cssSelector("#stub_page_PageCalculation > div.inner")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("BuildingsUpTo80")).sendKeys("110");
		driver.findElement(By.id("BuildingsOver20")).sendKeys("92");
		driver.findElement(By.id("TenantImprovements")).sendKeys("15");
		driver.findElement(By.id("Outdoor")).sendKeys("15");
		driver.findElement(By.id("SubsRequired_No")).click();
		driver.findElement(By.id("TerrorismRequired_No")).click();
		driver.findElement(By.id("OutbuildingContents")).sendKeys("35000");
		driver.findElement(By.id("StockInTrade")).sendKeys("100");
		driver.findElement(By.id("LiquerTobacco")).sendKeys("500");
		driver.findElement(By.id("BI_Required_No")).click();
		driver.findElement(By.id("GamingNumber")).sendKeys("5");
		driver.findElement(By.id("SafeMake")).sendKeys("2009");
		driver.findElement(By.id("SafeModel")).sendKeys("ACME");
		driver.findElement(By.id("EL_Required_No")).click();
		driver.findElement(By.id("PL_Required_No")).click();
		driver.findElement(By.id("TakeawaySales")).sendKeys("45");
		driver.findElement(By.cssSelector("#stub_page_Page6 > div.inner")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("AdditionalNotes")).sendKeys("Not related to any third party broker.");
		selenium.click("document.forms[0].elements[527]");
		selenium.waitForPageToLoad(timeout);
		Thread.sleep(3000);
		selenium.select("id=ctl00_MainContent_UserTitle", "label=Mr");
		driver.findElement(By.id("ctl00_MainContent_Firstname")).sendKeys("Quality");
		driver.findElement(By.id("ctl00_MainContent_Surname")).sendKeys("Tester");
		driver.findElement(By.id("ctl00_MainContent_Address_txtAddress1")).sendKeys("123 main road, 3rd floor");
		driver.findElement(By.id("ctl00_MainContent_Address_txtTown")).sendKeys("Foster City");
		driver.findElement(By.id("ctl00_MainContent_Address_txtCounty")).sendKeys("USA");
		driver.findElement(By.id("ctl00_MainContent_Address_txtPostcode")).sendKeys("94404");
		driver.findElement(By.id("Next")).click();
		Thread.sleep(3000);
		String CaseID = driver.findElement(By.cssSelector("span.policy_reference")).getText();
		System.out.println(CaseID);
		Assert.assertTrue(selenium.isTextPresent("exact:IMPORTANT: Your referral reference is " + CaseID));
		driver.findElement(By.id("ctl00_MainContent_btnViewAccount")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Endorsements")).click();
		Thread.sleep(3000);
		
		//Click on Matrix tab, store values in variables and RestaurantCombined.properties file
		driver.findElement(By.linkText("Matrix")).click();
		Thread.sleep(3000);
		String Basic128 = driver.findElement(By.id("Basic_128_result_span")).getText();
		Basic128 = Basic128.replace( '\u00A3', '*' );
		String Basic129 = driver.findElement(By.id("Basic_129_result_span")).getText();
		Basic129 = Basic129.replace( '\u00A3', '*' );
		String TPNet = driver.findElement(By.id("TotalPremiumNet_result_span")).getText();
		TPNet = TPNet.replace( '\u00A3', '*' );
		
		// Execution occur when script run 1st time.
		if (Counter == 0)
		{
			str11 = Basic128;
			str12 = Basic129;
			PolicyID1=CaseID;
			write.WritePropertyFile("RestaurantCombined", "PolicyID1", PolicyID1);
			write.WritePropertyFile("RestaurantCombined", "TotalGP1", str11);
			write.WritePropertyFile("RestaurantCombined", "TotalNP1", str12);
			write.WritePropertyFile("RestaurantCombined", "TPNet1", TPNet);
		}
		// Execution occur when script run 2nd time.
		if (Counter == 1)
		{
			str21=Basic128;
			str22=Basic129;
			PolicyID2=CaseID;				
			write.WritePropertyFile("RestaurantCombined", "PolicyID2", PolicyID2);
			write.WritePropertyFile("RestaurantCombined", "TotalGP2", str21);
			write.WritePropertyFile("RestaurantCombined", "TotalNP2", str22);
			write.WritePropertyFile("RestaurantCombined", "TPNet2", TPNet);
			
			//Compare the stored value from the property file.
			Assert.assertEquals(str21, readp.readDatafrom("RestaurantCombined", "TotalGP1"));
			Assert.assertEquals(str22, readp.readDatafrom("RestaurantCombined", "TotalNP1"));
						
		}
			
		driver.findElement(By.linkText("Logout")).click();
	}
}



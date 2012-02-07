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

public class MotorHireAndReward {
	
	private WebDriver driver;
	
	//Create object
	CustomMethod custom  = new CustomMethod();
	ReadProperty readp = new ReadProperty();
	WritePropertiesFile write = new WritePropertiesFile();
	
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
	public void testMotorHireAndReward(String Url) throws Exception {
			MotorHireAndRewardtest(driver,Url,Counter);
			Counter = Counter+1;
		}
	
	public void MotorHireAndRewardtest(WebDriver driver,String Url,int Counter) throws Exception{			
		
		driver.get(Url);	
		Selenium selenium = new WebDriverBackedSelenium(driver, Url);
		
		//Create new properties file or reset the value if file already exist 
		if (Counter==0){
			write.CreateNewFiles("MotorHireAndReward");
			write.WritePropertyFile("MotorHireAndReward", "PolicyID1", "NA");
			write.WritePropertyFile("MotorHireAndReward", "PolicyID2", "NA");
			write.WritePropertyFile("MotorHireAndReward", "TotalNP1", "NA");
			write.WritePropertyFile("MotorHireAndReward", "TotalGP1", "NA");
			write.WritePropertyFile("MotorHireAndReward", "TotalNP2", "NA");
			write.WritePropertyFile("MotorHireAndReward", "TotalGP2", "NA");
		}
		//Click on Quotes tab and fill the answer.
		driver.findElement(By.id("GetaQuote")).click();
		driver.findElement(By.linkText("Motor Hire and Reward")).click();
		custom.waitForElementPresentid(driver, "ctl00_MainContent_btnNext", 51);
		Assert.assertTrue(custom.isElementPresent(driver, By.linkText("click here to sign in")));
		driver.findElement(By.linkText("click here to sign in")).click();
		custom.waitForElementPresentid(driver, "Username", 51);
		Assert.assertTrue(custom.isElementPresent(driver, By.linkText("I forgot my username or password")));
		Assert.assertTrue(custom.isElementPresent(driver, By.linkText("Return to My Homepage")));
		custom.Login(driver, selenium, "Admin");
		custom.waitForElementPresentid(driver, "ctl00_MainContent_btnNext", 51);
		driver.findElement(By.id("ctl00_MainContent_btnNext")).click();
		custom.waitForElementPresentid(driver, "CoverReqd_Third Party Fire and Theft", 51);
		Assert.assertTrue(custom.isElementPresent(driver, By.name("QuestionPage_Back")));
		Assert.assertTrue(custom.isElementPresent(driver, By.name("QuestionPage_Next")));
		Assert.assertTrue(custom.isElementPresent(driver, By.name("SubmitQuote")));
		Assert.assertTrue(custom.isElementPresent(driver, By.name("QuestionPage_Next")));
		driver.findElement(By.id("CoverReqd_Third Party Fire and Theft")).click();
		driver.findElement(By.id("ConfirmEmail")).sendKeys("test360.5@gmail.com");
		driver.findElement(By.cssSelector("#stub_page_Page2 > div.inner")).click();
		Thread.sleep(7000);
		driver.findElement(By.id("VehiclePostcodeKeptOvernight")).sendKeys("SG2 8BJ");
		driver.findElement(By.id("VehicleMake")).sendKeys("2005");
		driver.findElement(By.id("VehicleModel")).sendKeys("Honda");
		driver.findElement(By.id("VehicleEngineCapacity")).sendKeys("2.0");
		driver.findElement(By.id("VehicleRegistration")).sendKeys("xx99 ADM");
		driver.findElement(By.id("VehicleYearOfMake")).sendKeys("2004");
		selenium.select("id=NumberSeats", "label=7");
		driver.findElement(By.id("LessThan7SeatsAdapted_No")).click();
		driver.findElement(By.id("AudioManufacturersStandard_Yes")).click();
		driver.findElement(By.id("VehicleLeftHandDrive_No")).click();
		driver.findElement(By.id("VehicleOwnedByOtherPerson_No")).click();
		driver.findElement(By.id("VehicleKeptSecure_No")).click();
		driver.findElement(By.id("VehicleAlarmed_Yes")).click();
		selenium.select("id=VehicleAlarmType", "label=Security Tracking Device");
		driver.findElement(By.cssSelector("#stub_page_Page3 > div.inner")).click();
		Thread.sleep(7000);
		driver.findElement(By.id("StatementPercentageGeneralPublic")).sendKeys("85");
		driver.findElement(By.id("StatementPercentageOther")).sendKeys("45");
		driver.findElement(By.id("StatementDetailsOfOther")).sendKeys("Bussiness Related task");
		//driver.findElement(By.id("StatementUsedPublicHire_Yes")).click();
		driver.findElement(By.cssSelector("#stub_page_Page4 > div.inner")).click();
		Thread.sleep(4000);
		selenium.select("id=ctl00_MainContent_Driver1Name_Title", "label=Mr");
		driver.findElement(By.cssSelector("option[value=\"Mr\"]")).click();
		selenium.type("id=ctl00_MainContent_Driver1Name_Firstname", selenium.getEval("\"testing\"+new Date().getMilliseconds();"));
		String Name = driver.findElement(By.id("ctl00_MainContent_Driver1Name_Firstname")).getAttribute("value");
		System.out.println(Name);
		driver.findElement(By.id("ctl00_MainContent_Driver1Name_Surname")).sendKeys("Jr");
		driver.findElement(By.id("ctl00_MainContent_Driver1Address_AddressLine1")).sendKeys("Tester");
		driver.findElement(By.id("ctl00_MainContent_Driver1Address_AddressLine2")).sendKeys("City");
		driver.findElement(By.id("ctl00_MainContent_Driver1Address_TownCity")).sendKeys("Foster city");
		driver.findElement(By.id("ctl00_MainContent_Driver1Address_County")).sendKeys("USA");
		driver.findElement(By.id("ctl00_MainContent_Driver1Address_Postcode")).sendKeys("SG2 8Bj");
		selenium.select("id=Driver1DOB_ddlDate_First", "label=17");
		selenium.select("id=Driver1DOB_ddlDate_Second", "label=Nov");
		selenium.select("id=Driver1DOB_ddlDate_Third", "label=1984");
		driver.findElement(By.id("Driver1YearsDrivingExperienceUK")).sendKeys("5");
		selenium.select("id=Driver1LicenceType", "label=Full UK");
		driver.findElement(By.id("Driver1PeriodLicenceHeld")).sendKeys("3");
		driver.findElement(By.id("Driver1ConvictionsYesNo_No")).click();
		driver.findElement(By.id("Driver1NotifiableCondition_No")).click();
		driver.findElement(By.id("HasClaimsDriver1_No")).click();
		driver.findElement(By.id("HasNonFaultClaimsDriver1_No")).click();
		driver.findElement(By.id("ClaimsWindscreenDriver1_No")).click();
		driver.findElement(By.id("Driver1AdditionalDriversReqd_Yes")).click();
		driver.findElement(By.cssSelector("#stub_page_Page5 > div.inner")).click();
		Thread.sleep(4000);
		driver.findElement(By.id("Driver2NotifiableCondition_No")).click();
		driver.findElement(By.id("HasClaimsDriver2_No")).click();
		driver.findElement(By.id("HasNonFaultClaimsDriver2_No")).click();
		driver.findElement(By.id("ClaimsWindscreenDriver2_No")).click();
		driver.findElement(By.cssSelector("#stub_page_Page8 > div.inner")).click();
		Thread.sleep(4000);
		driver.findElement(By.id("PreviouslyInsured_No")).click();
		driver.findElement(By.id("PreviouslyDeclined_No")).click();
		driver.findElement(By.id("PreviouslyDisqualified_No")).click();
		driver.findElement(By.id("UseOfAnotherVehicle_No")).click();
		driver.findElement(By.cssSelector("#stub_page_Page10 > div.inner")).click();
		Thread.sleep(4000);
		driver.findElement(By.id("AdditionalNotes")).sendKeys("Clear Additional Notes");
		driver.findElement(By.cssSelector("#stub_page_PageCalculation > div.inner")).click();
		Thread.sleep(4000);
		selenium.click("document.forms[0].elements[508]");
		Thread.sleep(6000);
		custom.waitForElementPresentid(driver, "Next", 51);
		driver.findElement(By.id("Next")).click();
		custom.waitForElementPresentid(driver, "ctl00_MainContent_btnViewAccount", 51);
		String CaseID = driver.findElement(By.cssSelector("span.policy_reference")).getText();
		System.out.println(CaseID);
		Assert.assertTrue(selenium.isTextPresent("exact:IMPORTANT: Your quotation reference is " + CaseID));
		driver.findElement(By.id("ctl00_MainContent_btnViewAccount")).click();
		Thread.sleep(5000);
		
		// Reached at the Cases page
		driver.findElement(By.linkText("Endorsements")).click();
		custom.waitForElementPresentlink(driver, "Add a new Conditions question", 51);
		driver.findElement(By.linkText("Add a new Conditions question")).click();
		custom.waitForElementPresentid(driver, "Question.Text", 51);
		driver.findElement(By.id("Question.Text")).sendKeys("New Condition");
		driver.findElement(By.id("Question.Save")).click();
		Thread.sleep(2000);
		custom.waitForElementPresentlink(driver, "Add a new Memorandum question", 51);
		driver.findElement(By.linkText("Add a new Memorandum question")).click();
		custom.waitForElementPresentid(driver, "Question.Text", 51);
		driver.findElement(By.id("Question.Text")).sendKeys("Testing");
		driver.findElement(By.id("Question.DefaultValue")).sendKeys("New Memorandum Body text");
		driver.findElement(By.id("Question.Save")).click();
		Thread.sleep(3000);
		
		//Click on Matrix tab, store values in variables and MotorHireReward.properties file
		driver.findElement(By.linkText("Matrix")).click();
		Thread.sleep(5000);
		String Basic144 = driver.findElement(By.id("Basic_144_result_span")).getText();
		Basic144 = Basic144.replace( '\u00A3', '*' );
		String Basic145 = driver.findElement(By.id("Basic_145_result_span")).getText();
		Basic145 = Basic145.replace( '\u00A3', '*' );
		String TPNet = driver.findElement(By.id("TotalPremiumNet_result_span")).getText();
		TPNet = TPNet.replace( '\u00A3', '*' );
		
		// Execution occur when script run 1st time.
		if (Counter == 0)
		{	str11 = Basic144;
			str12 = Basic145;
			PolicyID1=CaseID;
			write.WritePropertyFile("MotorHireAndReward", "PolicyID1", PolicyID1);
			write.WritePropertyFile("MotorHireAndReward", "TotalGP1", str11);
			write.WritePropertyFile("MotorHireAndReward", "TotalNP1", str12);
			write.WritePropertyFile("MotorHireAndReward", "TPNet1", TPNet);
		}
		
		// Execution occur when script run 2nd time.
		if (Counter == 1)
		{
			str21 = Basic144;
			str22 = Basic145;
			PolicyID2=CaseID;					
			write.WritePropertyFile("MotorHireAndReward", "PolicyID2", PolicyID2);
			write.WritePropertyFile("MotorHireAndReward", "TotalGP2", str21);
			write.WritePropertyFile("MotorHireAndReward", "TotalNP2", str22);
			write.WritePropertyFile("MotorHireAndReward", "TPNet2", TPNet);
			
			//Compare the stored value from the property file.
			Assert.assertEquals(str21, readp.readDatafrom("MotorHireAndReward", "TotalGP1"));
			Assert.assertEquals(str22, readp.readDatafrom("MotorHireAndReward", "TotalNP1"));
			Assert.assertEquals(TPNet, readp.readDatafrom("MotorHireAndReward", "TPNet1"));
		}
		
		driver.findElement(By.linkText("Logout")).click();		
		
	
	}
}

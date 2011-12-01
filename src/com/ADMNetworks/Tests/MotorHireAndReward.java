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
	CustomMethod custom  = new CustomMethod();
	ReadProperty readp = new ReadProperty();
	int Counter = 0;
	String str11="";
	String str12="";
	String str21="";
	String str22="";
	String PolicyID1,PolicyID2;
	WritePropertiesFile write = new WritePropertiesFile();
	
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
		driver.get(Url);		
		if (Counter==0){
			write.SetProperty1("MotorHireReward");
		}
		Selenium selenium = new WebDriverBackedSelenium(driver, Url);
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
		//driver.findElement(By.id("ConfirmEmail")).clear();
		driver.findElement(By.id("ConfirmEmail")).sendKeys("test360.5@gmail.com");
		driver.findElement(By.cssSelector("#stub_page_Page2 > div.inner")).click();
		Thread.sleep(7000);
		//driver.findElement(By.id("VehiclePostcodeKeptOvernight")).clear();
		driver.findElement(By.id("VehiclePostcodeKeptOvernight")).sendKeys("SG2 8BJ");
		//driver.findElement(By.id("VehicleMake")).clear();
		driver.findElement(By.id("VehicleMake")).sendKeys("2005");
		//driver.findElement(By.id("VehicleModel")).clear();
		driver.findElement(By.id("VehicleModel")).sendKeys("Honda");
		//driver.findElement(By.id("VehicleEngineCapacity")).clear();
		driver.findElement(By.id("VehicleEngineCapacity")).sendKeys("2.0");
		//driver.findElement(By.id("VehicleRegistration")).clear();
		driver.findElement(By.id("VehicleRegistration")).sendKeys("xx99 ADM");
		//driver.findElement(By.id("VehicleYearOfMake")).clear();
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
		//driver.findElement(By.id("StatementPercentageGeneralPublic")).clear();
		driver.findElement(By.id("StatementPercentageGeneralPublic")).sendKeys("85");
		//driver.findElement(By.id("StatementPercentageOther")).clear();
		driver.findElement(By.id("StatementPercentageOther")).sendKeys("45");
		//driver.findElement(By.id("StatementDetailsOfOther")).clear();
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
		//driver.findElement(By.id("ctl00_MainContent_Driver1Address_AddressLine1")).clear();
		driver.findElement(By.id("ctl00_MainContent_Driver1Address_AddressLine1")).sendKeys("Tester");
		//driver.findElement(By.id("ctl00_MainContent_Driver1Address_AddressLine2")).clear();
		driver.findElement(By.id("ctl00_MainContent_Driver1Address_AddressLine2")).sendKeys("City");
		//driver.findElement(By.id("ctl00_MainContent_Driver1Address_TownCity")).clear();
		driver.findElement(By.id("ctl00_MainContent_Driver1Address_TownCity")).sendKeys("Foster city");
		//driver.findElement(By.id("ctl00_MainContent_Driver1Address_County")).clear();
		driver.findElement(By.id("ctl00_MainContent_Driver1Address_County")).sendKeys("USA");
		//driver.findElement(By.id("ctl00_MainContent_Driver1Address_Postcode")).clear();
		driver.findElement(By.id("ctl00_MainContent_Driver1Address_Postcode")).sendKeys("SG2 8Bj");
		selenium.select("id=Driver1DOB_ddlDate_First", "label=17");
		selenium.select("id=Driver1DOB_ddlDate_Second", "label=Nov");
		selenium.select("id=Driver1DOB_ddlDate_Third", "label=1984");
		//driver.findElement(By.id("Driver1YearsDrivingExperienceUK")).clear();
		driver.findElement(By.id("Driver1YearsDrivingExperienceUK")).sendKeys("5");
		selenium.select("id=Driver1LicenceType", "label=Full UK");
		//driver.findElement(By.id("Driver1PeriodLicenceHeld")).clear();
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
		//driver.findElement(By.id("AdditionalNotes")).clear();
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
		custom.waitForElementPresent(driver, "#payment_box > input[type=\"button\"]", 51);
		
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
		driver.findElement(By.linkText("Matrix")).click();
		Thread.sleep(5000);	
		String Totalpremium = selenium.getText("id=TotalPremiumNet_result_span");
		String TP = selenium.getText("id=TotalPremiumNet_result_span");
		
		if (Counter == 0)
		{	
			write.WritePropertyFile("MotorHireReward", "Test1", "URL1");
			str11 = Totalpremium;
			str12 = TP;
			PolicyID1=CaseID;
			write.WritePropertyFile("MotorHireReward", "PolicyID1", PolicyID1);
			write.WritePropertyFile("MotorHireReward", "TotalGrossPremium1", str11);
			write.WritePropertyFile("MotorHireReward", "TotalNetPremium1", str12);
		}
		if (Counter == 1)
		{
			write.WritePropertyFile("MotorHireReward", "Test2", "URL2");
			str21=Totalpremium;
			str22=TP;
			PolicyID2=CaseID;				
						
			write.WritePropertyFile("MotorHireReward", "PolicyID2", PolicyID2);
			write.WritePropertyFile("MotorHireReward", "TotalGrossPremium2", str21);
			write.WritePropertyFile("MotorHireReward", "TotalNetPremium2", str22);
			
			Assert.assertEquals(str21, str11);
			Assert.assertEquals(str22, str12);			
		}
		Counter = Counter+1;
		/*custom.waitForElementPresentid(driver, "ctl00_ctl00_MainContent_Grey_PolicyContent_PageButtonsTop_btnSnapshot", 51);
		custom.waitForElementPresent(driver, "img.ViewPolicy_Save", 51);
		//Assert.assertTrue(custom.isElementPresent(driver, By.id("ctl00_ctl00_MainContent_Grey_PolicyContent_PageButtonsTop_btnSnapshot")));
		//Assert.assertTrue(custom.isElementPresent(driver, By.cssSelector("img.ViewPolicy_Save")));
		driver.findElement(By.linkText("Documents")).click();
		custom.waitForElementPresent(driver, "img.hand", 51);
		driver.findElement(By.cssSelector("img.hand")).click();
		custom.waitForElementPresentname(driver, "NewDocumentType", 51);
		selenium.select("name=NewDocumentType", "label=Auto Renewal Confirmation");
		Thread.sleep(2000);
		driver.findElement(By.id("ctl00_ctl00_MainContent_Grey_PolicyContent_btnSave")).click();
		Thread.sleep(4000);
		Assert.assertTrue(custom.isElementPresent(driver, By.cssSelector("img[alt=\"NOT visible to agent - click to change\"]")));
		Assert.assertTrue(custom.isElementPresent(driver, By.xpath("//img[@alt='Email']")));
		Assert.assertTrue(custom.isElementPresent(driver, By.xpath("//img[@alt='Delete']")));
		driver.findElement(By.xpath("//div[@id='content']/table/tbody/tr/td/div[2]/div/div[9]/div/a")).click();
		driver.findElement(By.id("ctl00_ctl00_MainContent_Grey_PolicyContent_imgCreateNew")).click();
		Thread.sleep(2000);
		custom.waitForElementPresentid(driver, "ctl00_ctl00_MainContent_Grey_PolicyContent_imgPrint", 51);
		//Assert.assertTrue(selenium.isTextPresent("Create a new claim for Policy"+ CaseID));
		//Assert.assertTrue(custom.isElementPresent(driver, By.id("ctl00_ctl00_MainContent_Grey_PolicyContent_imgPrint")));
		driver.findElement(By.id("ctl00_ctl00_MainContent_Grey_PolicyContent_imgBack")).click();
		driver.findElement(By.linkText("Notes")).click();
		driver.findElement(By.id("ctl00_ctl00_MainContent_Grey_PolicyContent_Img1")).click();
		driver.findElement(By.linkText("Cancel")).click();		
		driver.findElement(By.linkText("Money")).click();
		Thread.sleep(4000);
		custom.waitForElementPresentlink(driver, "Take Card Payment", 55);
		driver.findElement(By.linkText("Take Card Payment")).click();
		Thread.sleep(4000);
		driver.findElement(By.cssSelector("img[alt=\"close\"]")).click();
		driver.findElement(By.linkText("Record Cheque")).click();
		Thread.sleep(4000);
		//custom.waitForElementPresentid(driver, "ctl00_MainContent_ChequeControl_txtAmount", 51);
		//Assert.assertTrue(selenium.isTextPresent("Cheque Payment"));
		driver.findElement(By.cssSelector("img[alt=\"close\"]")).click();
		driver.findElement(By.linkText("Activity")).click();*/
		driver.findElement(By.linkText("Logout")).click();		
	
	}
}

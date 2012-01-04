package com.ADMNetworks.Tests;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverBackedSelenium;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;
import org.testng.Assert;
import com.ADMNetworks.Utill.*;
import com.thoughtworks.selenium.Selenium;

public class MotorHireAndRewardNew {
	private WebDriver driver;
	
	//Create object
	CustomMethod custom  = new CustomMethod();
	ReadProperty readp = new ReadProperty();
	WritePropertiesFile write = new WritePropertiesFile();
	String timeout=readp.readApplicationFile("Timeout");
	
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
		
	@BeforeSuite
	public void setUp() throws Exception {
		driver = custom.CreateObject(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@AfterSuite
	public void tearDown() throws Exception {
		driver.quit();			
	}
	
	@Test(dataProvider = "DP1")
	public void testMotorHireAndReward(String Url) throws Exception {
		MotorHireAndRewardtest(driver,Url);
		Counter=Counter+1;
	}
	
	public void MotorHireAndRewardtest(WebDriver driver,String Url) throws Exception {
		
		driver.get(Url);		
		Selenium selenium = new WebDriverBackedSelenium(driver, Url);	
		
		//Create new properties file or reset the value if file already exist 
		if (Counter==0){				
			write.CreateNewFiles("MotorHireAndRewardNew");
			write.WritePropertyFile("MotorHireAndRewardNew", "PolicyID1", "NA");
			write.WritePropertyFile("MotorHireAndRewardNew", "PolicyID2", "NA");
			write.WritePropertyFile("MotorHireAndRewardNew", "TotalNP1", "NA");
			write.WritePropertyFile("MotorHireAndRewardNew", "TotalGP1", "NA");
			write.WritePropertyFile("MotorHireAndRewardNew", "TotalNP2", "NA");
			write.WritePropertyFile("MotorHireAndRewardNew", "TotalGP2", "NA");
		}
		
		//Click on Quotes tab and fill the answer.
		driver.findElement(By.id("GetaQuote")).click();
		custom.waitForElementPresentlink(driver, "Motor Hire and Reward", 21);
		driver.findElement(By.linkText("Motor Hire and Reward")).click();
		Thread.sleep(7000);
		
		// Sign in using valid admin credential.
		driver.findElement(By.linkText("click here to sign in")).click();
		custom.waitForElementPresentid(driver, "Username",61);
		custom.Login(driver, selenium, "Admin");
		custom.waitForElementPresentid(driver, "ctl00_MainContent_btnNext", 51);
		driver.findElement(By.id("ctl00_MainContent_btnNext")).click();
		
		// Cover required Tab.
		driver.findElement(By.id("CoverReqd_Fully Comprehensive")).click();
		driver.findElement(By.id("CoverReqd_Third Party Fire and Theft")).click();
		driver.findElement(By.id("CoverReqd_Third Party Only")).click();
		new Select(driver.findElement(By.id("Business"))).selectByVisibleText("Minibus Driver");
		driver.findElement(By.id("ConfirmEmail")).clear();
		driver.findElement(By.id("ConfirmEmail")).sendKeys(readp.readLoginFile("NormalUser"));
		driver.findElement(By.name("QuestionPage_Next")).click();
		
		//Vehicle Details Tab
		driver.findElement(By.id("VehiclePostcodeKeptOvernight")).clear();
		driver.findElement(By.id("VehiclePostcodeKeptOvernight")).sendKeys("94404");
		driver.findElement(By.id("VehicleMake")).clear();
		driver.findElement(By.id("VehicleMake")).sendKeys("Honda 2009");
		driver.findElement(By.id("VehicleModel")).clear();
		driver.findElement(By.id("VehicleModel")).sendKeys("Honda City");
		driver.findElement(By.id("VehicleEngineCapacity")).clear();
		driver.findElement(By.id("VehicleEngineCapacity")).sendKeys("2.5");
		driver.findElement(By.id("VehicleRegistration")).clear();
		driver.findElement(By.id("VehicleRegistration")).sendKeys("XX99ADM");
		driver.findElement(By.id("VehicleYearOfMake")).clear();
		driver.findElement(By.id("VehicleYearOfMake")).sendKeys("2007");
		String NumberSeats = readp.readLoginFile("NumberSeats");
		new Select(driver.findElement(By.id("NumberSeats"))).selectByVisibleText(NumberSeats);
		int ns = Integer.parseInt(NumberSeats);
		if(ns <9){
			Assert.assertTrue(selenium.isTextPresent("You have selected the vehicle as having less than 9 seats. Has this vehicle been adapted for carrying wheel chairs."));
			driver.findElement(By.id("LessThan7SeatsAdapted_Yes")).click();
		}
		new Select(driver.findElement(By.id("VehicleDateOfPurchase_ddlDate_First"))).selectByVisibleText("07");
		new Select(driver.findElement(By.id("VehicleDateOfPurchase_ddlDate_Second"))).selectByVisibleText("Jul");
		new Select(driver.findElement(By.id("VehicleDateOfPurchase_ddlDate_Third"))).selectByVisibleText("2008");
		driver.findElement(By.id("VehicleValue")).clear();
		driver.findElement(By.id("VehicleValue")).sendKeys("30000");
		driver.findElement(By.id("ValueOfAudioEquipment")).clear();
		driver.findElement(By.id("ValueOfAudioEquipment")).sendKeys("2500");
		driver.findElement(By.id("AudioManufacturersStandard_Yes")).click();
		driver.findElement(By.id("VehicleLeftHandDrive_Yes")).click();
		driver.findElement(By.id("VehicleOwnedByOtherPerson_Yes")).click();
		driver.findElement(By.id("VehicleOwnerDetailsIfDifferent")).clear();
		driver.findElement(By.id("VehicleOwnerDetailsIfDifferent")).sendKeys("Mr Owner");
		driver.findElement(By.id("VehicleKeptSecure_Yes")).click();		
		String VAlarmed = readp.readLoginFile("VehicleAlarmed");
		if (VAlarmed.equals("yes")){
			driver.findElement(By.id("VehicleAlarmed_Yes")).click();
			new Select(driver.findElement(By.id("VehicleAlarmType"))).selectByVisibleText("Security Tracking Device");
		}else{
			driver.findElement(By.id("VehicleAlarmed_No")).click();
		}
		selenium.click("document.forms[0].elements[507]");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		// Passenger Use
		driver.findElement(By.id("StatementPercentageGeneralPublic")).clear();
		driver.findElement(By.id("StatementPercentageGeneralPublic")).sendKeys("50");
		driver.findElement(By.id("StatementPercentageOther")).clear();
		driver.findElement(By.id("StatementPercentageOther")).sendKeys("40");
		driver.findElement(By.id("StatementDetailsOfOther")).clear();
		driver.findElement(By.id("StatementDetailsOfOther")).sendKeys("Transporter");
		driver.findElement(By.id("StatementUsedPublicHire_Yes")).click();
		driver.findElement(By.id("StatementContinentalUse_Yes")).click();
		selenium.click("document.forms[0].elements[507]");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		// Main Driver Details
		new Select(driver.findElement(By.id("ctl00_MainContent_Driver1Name_Title"))).selectByVisibleText("Mr");
		driver.findElement(By.id("ctl00_MainContent_Driver1Name_Firstname")).clear();
		driver.findElement(By.id("ctl00_MainContent_Driver1Name_Firstname")).sendKeys("Robert");
		driver.findElement(By.id("ctl00_MainContent_Driver1Name_Surname")).clear();
		driver.findElement(By.id("ctl00_MainContent_Driver1Name_Surname")).sendKeys("Park");
		driver.findElement(By.id("ctl00_MainContent_Driver1Address_AddressLine1")).clear();
		driver.findElement(By.id("ctl00_MainContent_Driver1Address_AddressLine1")).sendKeys("Abc line1");
		driver.findElement(By.id("ctl00_MainContent_Driver1Address_AddressLine2")).clear();
		driver.findElement(By.id("ctl00_MainContent_Driver1Address_AddressLine2")).sendKeys("Adf line2");
		driver.findElement(By.id("ctl00_MainContent_Driver1Address_TownCity")).clear();
		driver.findElement(By.id("ctl00_MainContent_Driver1Address_TownCity")).sendKeys("Foster City");
		driver.findElement(By.id("ctl00_MainContent_Driver1Address_County")).clear();
		driver.findElement(By.id("ctl00_MainContent_Driver1Address_County")).sendKeys("USA");
		driver.findElement(By.id("ctl00_MainContent_Driver1Address_Postcode")).clear();
		String Postcode = readp.readLoginFile("Postcode");
		driver.findElement(By.id("ctl00_MainContent_Driver1Address_Postcode")).sendKeys(Postcode);
		new Select(driver.findElement(By.id("Driver1DOB_ddlDate_First"))).selectByVisibleText("04");
		new Select(driver.findElement(By.id("Driver1DOB_ddlDate_Second"))).selectByVisibleText("Jul");
		new Select(driver.findElement(By.id("Driver1DOB_ddlDate_Third"))).selectByVisibleText("1985");
		driver.findElement(By.id("Driver1YearsDrivingExperienceUK")).clear();
		driver.findElement(By.id("Driver1YearsDrivingExperienceUK")).sendKeys("5");
		new Select(driver.findElement(By.id("Driver1LicenceType"))).selectByVisibleText("Full PCV D1 without restriction (UK)");
		driver.findElement(By.id("Driver1PeriodLicenceHeld")).clear();
		driver.findElement(By.id("Driver1PeriodLicenceHeld")).sendKeys("6");
		
		String DC = readp.readLoginFile("Driver1Convictions");
		if (DC.equals("yes")){		
			driver.findElement(By.id("Driver1ConvictionsYesNo_Yes")).click();
			new Select(driver.findElement(By.id("Driver1ConvictionDetails_ConvictionDate_ddlDate_First"))).selectByVisibleText("05");
			driver.findElement(By.cssSelector("#Driver1ConvictionDetails_ConvictionDate_ddlDate_First > option[value=\"05\"]")).click();
			new Select(driver.findElement(By.id("Driver1ConvictionDetails_ConvictionDate_ddlDate_Second"))).selectByVisibleText("Jul");
			new Select(driver.findElement(By.id("Driver1ConvictionDetails_ConvictionDate_ddlDate_Third"))).selectByVisibleText("2007");
			driver.findElement(By.cssSelector("#Driver1ConvictionDetails_ConvictionDate_ddlDate_Third > option[value=\"2007\"]")).click();
			driver.findElement(By.id("Driver1AdditionalDriversReqd_Yes")).click();
			driver.findElement(By.id("Driver1ConvictionDetails_ConvictionCode")).clear();
			driver.findElement(By.id("Driver1ConvictionDetails_ConvictionCode")).sendKeys("1");
			driver.findElement(By.id("Driver1ConvictionDetails_Points")).clear();
			driver.findElement(By.id("Driver1ConvictionDetails_Points")).sendKeys("2");
			driver.findElement(By.id("Driver1ConvictionDetails_Fine")).clear();
			driver.findElement(By.id("Driver1ConvictionDetails_Fine")).sendKeys("120");
			new Select(driver.findElement(By.id("Driver1ConvictionDetails_Disqualified"))).selectByVisibleText("Yes");
		}else{
			driver.findElement(By.id("Driver1ConvictionsYesNo_No")).click();
		}
		
		driver.findElement(By.id("Driver1NotifiableCondition_Yes")).click();
		Assert.assertTrue(custom.isElementPresent(driver, By.id("Driver1NotifiableConditionDetails")));
		driver.findElement(By.id("Driver1NotifiableConditionDetails")).clear();
		driver.findElement(By.id("Driver1NotifiableConditionDetails")).sendKeys("For rush driving..");
		
		String CD = readp.readLoginFile("HasClaimsDriver1");
		if (CD.equals("yes")){
		
			driver.findElement(By.id("HasClaimsDriver1_Yes")).click();
			new Select(driver.findElement(By.id("ClaimsDriver1_DateofClaim_ddlDate_First"))).selectByVisibleText("07");
			new Select(driver.findElement(By.id("ClaimsDriver1_DateofClaim_ddlDate_Second"))).selectByVisibleText("Jul");
			new Select(driver.findElement(By.id("ClaimsDriver1_DateofClaim_ddlDate_Third"))).selectByVisibleText("2010");
			driver.findElement(By.id("ClaimsDriver1_TotalCosts")).clear();
			driver.findElement(By.id("ClaimsDriver1_TotalCosts")).sendKeys("500");
			driver.findElement(By.id("ClaimsDriver1_PersonalInjuryPaidorOutstanding")).clear();
			driver.findElement(By.id("ClaimsDriver1_PersonalInjuryPaidorOutstanding")).sendKeys("00");
			new Select(driver.findElement(By.id("ClaimsDriver1_ConvictionImposed"))).selectByVisibleText("Yes");
		}else{
			driver.findElement(By.id("HasClaimsDriver1_No")).click();
		}
		
		String NFCD = readp.readLoginFile("HasNonFaultClaimsDriver1");
		if (NFCD.equals("yes")){
			
			driver.findElement(By.id("HasNonFaultClaimsDriver1_Yes")).click();
			new Select(driver.findElement(By.id("ClaimsNonFaultDriver1_DateofClaim_ddlDate_First"))).selectByVisibleText("11");
			new Select(driver.findElement(By.id("ClaimsNonFaultDriver1_DateofClaim_ddlDate_Second"))).selectByVisibleText("Jul");
			new Select(driver.findElement(By.id("ClaimsNonFaultDriver1_DateofClaim_ddlDate_Third"))).selectByVisibleText("2009");
			driver.findElement(By.id("ClaimsNonFaultDriver1_TotalCosts")).clear();
			driver.findElement(By.id("ClaimsNonFaultDriver1_TotalCosts")).sendKeys("100");
			driver.findElement(By.id("ClaimsNonFaultDriver1_PersonalInjuryPaidorOutstanding")).clear();
			driver.findElement(By.id("ClaimsNonFaultDriver1_PersonalInjuryPaidorOutstanding")).sendKeys("25");
			new Select(driver.findElement(By.id("ClaimsNonFaultDriver1_ConvictionImposed"))).selectByVisibleText("No");
		}else{
			driver.findElement(By.id("HasNonFaultClaimsDriver1_No")).click();
		}
		
		String CWD = readp.readLoginFile("ClaimsWindscreenDriver1");
		if (CWD.equals("yes")){
			
			driver.findElement(By.id("ClaimsWindscreenDriver1_Yes")).click();
			new Select(driver.findElement(By.id("ClaimsWindscreenDriver1Details_DateofClaim_ddlDate_First"))).selectByVisibleText("09");
			new Select(driver.findElement(By.id("ClaimsWindscreenDriver1Details_DateofClaim_ddlDate_Second"))).selectByVisibleText("Jul");
			new Select(driver.findElement(By.id("ClaimsWindscreenDriver1Details_DateofClaim_ddlDate_Third"))).selectByVisibleText("2009");
			driver.findElement(By.id("ClaimsWindscreenDriver1Details_TotalCosts")).clear();
			driver.findElement(By.id("ClaimsWindscreenDriver1Details_TotalCosts")).sendKeys("2500");
		}else{
			driver.findElement(By.id("ClaimsWindscreenDriver1_No")).click();
		}
		selenium.click("document.forms[0].elements[507]");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		// Additional Driver Details		
		driver.findElement(By.id("Driver2Name")).sendKeys("Parker Sr");
		new Select(driver.findElement(By.id("Driver2DOB_ddlDate_First"))).selectByVisibleText("09");
		new Select(driver.findElement(By.id("Driver2DOB_ddlDate_Second"))).selectByVisibleText("Jun");
		new Select(driver.findElement(By.id("Driver2DOB_ddlDate_Third"))).selectByVisibleText("1980");
		driver.findElement(By.id("Driver2YearsDrivingExperienceUK")).clear();
		driver.findElement(By.id("Driver2YearsDrivingExperienceUK")).sendKeys("7");
		new Select(driver.findElement(By.id("Driver2LicenceType"))).selectByVisibleText("Full PCV D1 without restriction (UK)");
		driver.findElement(By.id("Driver2PeriodLicenceHeld")).clear();
		driver.findElement(By.id("Driver2PeriodLicenceHeld")).sendKeys("8");
		// #Convictions in last 5 years
		
		String D2C = readp.readLoginFile("Driver2Convictions");
		if (D2C.equals("yes")){
			driver.findElement(By.id("Driver2ConvictionsYesNo_Yes")).click();
			new Select(driver.findElement(By.id("Driver2ConvictionDetails_ConvictionDate_ddlDate_First"))).selectByVisibleText("12");
			driver.findElement(By.cssSelector("#Driver2ConvictionDetails_ConvictionDate_ddlDate_First > option[value=\"12\"]")).click();
			new Select(driver.findElement(By.id("Driver2ConvictionDetails_ConvictionDate_ddlDate_Second"))).selectByVisibleText("Jun");
			new Select(driver.findElement(By.id("Driver2ConvictionDetails_ConvictionDate_ddlDate_Third"))).selectByVisibleText("2008");
			driver.findElement(By.cssSelector("#Driver2ConvictionDetails_ConvictionDate_ddlDate_Third > option[value=\"2008\"]")).click();
			driver.findElement(By.id("Driver2ConvictionDetails_ConvictionCode")).clear();
			driver.findElement(By.id("Driver2ConvictionDetails_ConvictionCode")).sendKeys("12");
			driver.findElement(By.id("Driver2ConvictionDetails_Points")).clear();
			driver.findElement(By.id("Driver2ConvictionDetails_Points")).sendKeys("21");
			driver.findElement(By.id("Driver2ConvictionDetails_Fine")).clear();
			driver.findElement(By.id("Driver2ConvictionDetails_Fine")).sendKeys("112");
			new Select(driver.findElement(By.id("Driver2ConvictionDetails_Disqualified"))).selectByVisibleText("Yes");
		}else{
			driver.findElement(By.id("Driver2ConvictionsYesNo_No")).click();
		}
		
		String D2NC = readp.readLoginFile("Driver2NotifiableCondition");
		if (D2NC.equals("yes")){
		
		driver.findElement(By.id("Driver2NotifiableCondition_Yes")).click();
		driver.findElement(By.id("Driver2NotifiableConditionDetails")).clear();
		driver.findElement(By.id("Driver2NotifiableConditionDetails")).sendKeys("Criminal offense");
		}else{
			driver.findElement(By.id("Driver2NotifiableCondition_No")).click();
		}
		
		String HCD2 = readp.readLoginFile("HasClaimsDriver2");
		if (HCD2.equals("yes")){
		
			driver.findElement(By.id("HasClaimsDriver2_Yes")).click();
			new Select(driver.findElement(By.id("ClaimsDriver2_DateofClaim_ddlDate_First"))).selectByVisibleText("04");
			new Select(driver.findElement(By.id("ClaimsDriver2_DateofClaim_ddlDate_Second"))).selectByVisibleText("Aug");
			new Select(driver.findElement(By.id("ClaimsDriver2_DateofClaim_ddlDate_Third"))).selectByVisibleText("2010");
			driver.findElement(By.id("ClaimsDriver2_TotalCosts")).clear();
			driver.findElement(By.id("ClaimsDriver2_TotalCosts")).sendKeys("1500");
			driver.findElement(By.id("ClaimsDriver2_PersonalInjuryPaidorOutstanding")).clear();
			driver.findElement(By.id("ClaimsDriver2_PersonalInjuryPaidorOutstanding")).sendKeys("100");
			driver.findElement(By.id("ClaimsDriver2_BriefDetailsofCircumstances")).clear();
			driver.findElement(By.id("ClaimsDriver2_BriefDetailsofCircumstances")).sendKeys("na");
			new Select(driver.findElement(By.id("ClaimsDriver2_ConvictionImposed"))).selectByVisibleText("Yes");
		}else{
			driver.findElement(By.id("HasClaimsDriver2_No")).click();
		}
		
		String HNFCD2 = readp.readLoginFile("HasNonFaultClaimsDriver2");
		if (HNFCD2.equals("yes")){
		
			driver.findElement(By.id("HasNonFaultClaimsDriver2_Yes")).click();
			new Select(driver.findElement(By.id("ClaimsNonFaultDriver2_DateofClaim_ddlDate_First"))).selectByVisibleText("08");
			new Select(driver.findElement(By.id("ClaimsNonFaultDriver2_DateofClaim_ddlDate_Second"))).selectByVisibleText("Jun");
			new Select(driver.findElement(By.id("ClaimsNonFaultDriver2_DateofClaim_ddlDate_Third"))).selectByVisibleText("2010");
			driver.findElement(By.id("ClaimsNonFaultDriver2_TotalCosts")).clear();
			driver.findElement(By.id("ClaimsNonFaultDriver2_TotalCosts")).sendKeys("200");
			driver.findElement(By.id("ClaimsNonFaultDriver2_PersonalInjuryPaidorOutstanding")).clear();
			driver.findElement(By.id("ClaimsNonFaultDriver2_PersonalInjuryPaidorOutstanding")).sendKeys("51");
			driver.findElement(By.id("ClaimsNonFaultDriver2_BriefDetailsofCircumstances")).clear();
			driver.findElement(By.id("ClaimsNonFaultDriver2_BriefDetailsofCircumstances")).sendKeys("na");
			new Select(driver.findElement(By.id("ClaimsNonFaultDriver2_ConvictionImposed"))).selectByVisibleText("Yes");
		}else{
			driver.findElement(By.id("HasNonFaultClaimsDriver2_No")).click();
		}
		
		String CWD2 = readp.readLoginFile("ClaimsWindscreenDriver2");
		if (CWD2.equals("yes")){
			
			driver.findElement(By.id("ClaimsWindscreenDriver2_Yes")).click();
			new Select(driver.findElement(By.id("ClaimsWindscreenDriver2Details_DateofClaim_ddlDate_First"))).selectByVisibleText("12");
			new Select(driver.findElement(By.id("ClaimsWindscreenDriver2Details_DateofClaim_ddlDate_Second"))).selectByVisibleText("Aug");
			new Select(driver.findElement(By.id("ClaimsWindscreenDriver2Details_DateofClaim_ddlDate_Third"))).selectByVisibleText("2010");
			driver.findElement(By.id("ClaimsWindscreenDriver2Details_TotalCosts")).clear();
			driver.findElement(By.id("ClaimsWindscreenDriver2Details_TotalCosts")).sendKeys("250");
		}else{
			driver.findElement(By.id("ClaimsWindscreenDriver2_No")).click();
		}
		selenium.click("document.forms[0].elements[507]");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		// Previous Insurance
		
		driver.findElement(By.id("PreviouslyInsured_Yes")).click();
		Assert.assertTrue(custom.isElementPresent(driver, By.id("PreviouslyInsuredDetails")));
		driver.findElement(By.id("PreviouslyInsuredDetails")).clear();
		driver.findElement(By.id("PreviouslyInsuredDetails")).sendKeys("ACME");
		
		driver.findElement(By.id("PreviouslyDeclined_Yes")).click();
		Assert.assertTrue(custom.isElementPresent(driver, By.id("PreviouslyDeclinedDetails")));
		driver.findElement(By.id("PreviouslyDeclinedDetails")).clear();
		driver.findElement(By.id("PreviouslyDeclinedDetails")).sendKeys("Initial miss communication.");
		
		driver.findElement(By.id("PreviouslyDisqualified_Yes")).click();
		driver.findElement(By.id("PreviouslyDisqualifiedDetails")).clear();
		driver.findElement(By.id("PreviouslyDisqualifiedDetails")).sendKeys("Disqualified due to minor accident during learning.");
		
		driver.findElement(By.id("UseOfAnotherVehicle_Yes")).click();
		driver.findElement(By.id("UseOfAnotherVehicleDetails")).clear();
		driver.findElement(By.id("UseOfAnotherVehicleDetails")).sendKeys("BMW\nInsurer : ACME");
		selenium.click("document.forms[0].elements[507]");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//Additional Notes Section
		driver.findElement(By.id("AdditionalNotes")).clear();
		driver.findElement(By.id("AdditionalNotes")).sendKeys("Additional notes not attached yet.");
		selenium.click("document.forms[0].elements[507]");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//Cover Details
		selenium.click("document.forms[0].elements[507]");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//User Information page
		driver.findElement(By.id("Next")).click();
		selenium.waitForPageToLoad(timeout);
		
		// Policy ID information Page
		Assert.assertTrue(selenium.isTextPresent("Quotation request received"));
		Assert.assertTrue(selenium.isTextPresent("Your quotation request has been received and will be processed shortly."));
		String CaseID = driver.findElement(By.cssSelector("span.policy_reference")).getText();
		driver.findElement(By.id("ctl00_MainContent_btnViewAccount")).click();
		selenium.waitForPageToLoad(timeout);
		
		//Redirected at the cases page.
		/*if (Postcode.equals("SG2 8BJ")){
			Assert.assertTrue(selenium.isTextPresent("This client's postcode (SG2 8BJ) matched SG2 8BJ - High Risk Arson"));
		}*/
		//Store total basic premiums from the Matrix page.
		String Basic144 = driver.findElement(By.id("id=Basic_144_result_span")).getText();
		Basic144 = Basic144.replace( '\u00A3', '*' );
		String Basic145 = driver.findElement(By.id("id=Basic_145_result_span")).getText();
		Basic145 = Basic145.replace( '\u00A3', '*' );
		String TPNet = driver.findElement(By.id("id=TotalPremiumNet_result_span")).getText();
		TPNet = TPNet.replace( '\u00A3', '*' );		
		
		// Execution occur when script run 1st time.
		if (Counter == 0)
		{
			str11 = Basic144;
			str12 = Basic145;
			PolicyID1=CaseID;
			//Write the stored value in the CombinedLiabilityNew.properties file
			write.WritePropertyFile("MotorHireAndRewardNew", "PolicyID1", PolicyID1);
			write.WritePropertyFile("MotorHireAndRewardNew", "TotalGP1", str11);
			write.WritePropertyFile("MotorHireAndRewardNew", "TotalNP1", str12);
			write.WritePropertyFile("MotorHireAndRewardNew", "TPNet1", TPNet);
		}
		// Execution occur when script run 2nd time.
		if (Counter == 1)
		{
			str21=Basic144;
			str22=Basic145;
			PolicyID2=CaseID;		
			//Write the stored value in the CombinedLiabilityNew.properties file
			write.WritePropertyFile("MotorHireAndRewardNew", "PolicyID2", PolicyID2);
			write.WritePropertyFile("MotorHireAndRewardNew", "TotalGP2", str21);
			write.WritePropertyFile("MotorHireAndRewardNew", "TotalNP2", str22);
			
			//Compare the stored value from the property file.
			Assert.assertEquals(str21, readp.readDatafrom("MotorHireAndRewardNew", "TotalGP1"));
			Assert.assertEquals(str22, readp.readDatafrom("MotorHireAndRewardNew", "TotalNP1"));
			Assert.assertEquals(TPNet, readp.readDatafrom("MotorHireAndRewardNew", "TPNet1"));
		}
		driver.findElement(By.linkText("Logout")).click();
		
	}
	
}

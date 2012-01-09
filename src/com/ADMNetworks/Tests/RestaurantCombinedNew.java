package com.ADMNetworks.Tests;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverBackedSelenium;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.*;
import org.testng.Assert;
import com.ADMNetworks.Utill.*;
import com.thoughtworks.selenium.Selenium;


public class RestaurantCombinedNew {
		private WebDriver driver;
		
		//Create object
		CustomMethod custom  = new CustomMethod();
		ReadProperty readp = new ReadProperty();
		String timeout = readp.readApplicationFile("Timeout");
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
		public void testRestaurantCombinedNew(String Url) throws Exception 
		{		
			RestaurantCombinedNewtest(driver,Url,Counter);
			Counter=Counter+1;
		}
		public void RestaurantCombinedNewtest(WebDriver driver,String Url, int Counter) throws Exception{		
			
			driver.get(Url);	
			Selenium selenium = new WebDriverBackedSelenium(driver, Url);
			
			//Create new properties file or reset the value if file already exist 
			if (Counter==0)
			
			{			
				write.CreateNewFiles("RestaurantCombinedNew");
				write.WritePropertyFile("RestaurantCombinedNew", "PolicyID1", "NA");
				write.WritePropertyFile("RestaurantCombinedNew", "PolicyID2", "NA");
				write.WritePropertyFile("RestaurantCombinedNew", "TotalNP1", "NA");
				write.WritePropertyFile("RestaurantCombinedNew", "TotalGP1", "NA");
				write.WritePropertyFile("RestaurantCombinedNew", "TotalNP2", "NA");
				write.WritePropertyFile("RestaurantCombinedNew", "TotalGP2", "NA");
			}		
			
		    //Click on Quotes tab and fill the answer.			
			driver.findElement(By.id("GetaQuote")).click();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			Assert.assertTrue(custom.isElementPresent(driver, By.linkText("Restaurant Combined")));
			driver.findElement(By.linkText("Restaurant Combined")).click();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.findElement(By.linkText("click here to sign in")).click();
			custom.waitForElementPresentid(driver, "Username",61);
			custom.Login(driver, selenium, "Admin");
			custom.waitForElementPresentid(driver, "ctl00_MainContent_btnNext", 61);
			//driver.findElement(By.name("Login")).click();
			driver.findElement(By.id("ctl00_MainContent_btnNext")).click();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
			//Declaration Tab			
			Assert.assertTrue(selenium.isTextPresent("Declaration"));
			
			String DProp = readp.readLoginFile("DeclinedProp");
			if (DProp.equals("Yes")){
				driver.findElement(By.id("DeclinedPropRbl_Yes")).click();
			}else{
				driver.findElement(By.id("DeclinedPropRbl_No")).click();
			}
			
		    driver.findElement(By.id("HygieneBreachRbl_Yes")).click();
			driver.findElement(By.id("HygieneBreachRbl_No")).click();
			
			
			String CR = readp.readLoginFile("Criminalrecord");
			if (CR.equals("yes")){
				driver.findElement(By.id("CrimRecordRbl_Yes")).click();
			}else{
				driver.findElement(By.id("CrimRecordRbl_No")).click();
			}
						
			driver.findElement(By.id("BankruptCCJ_No")).click();
			driver.findElement(By.id("BankruptCCJ_Yes")).click();
			driver.findElement(By.id("DeclarationDetails")).clear();
			driver.findElement(By.id("DeclarationDetails")).sendKeys("No Reason");			
			selenium.click("document.forms[0].elements[526]");
					
			//Address and Survey Details Tab
			Assert.assertTrue(selenium.isTextPresent("Address and Survey Details"));
			Assert.assertTrue(custom.isElementPresent(driver, By.id("InceptionDate_ddlDate_First")));
			Assert.assertTrue(custom.isElementPresent(driver, By.id("InceptionDate_ddlDate_Second")));
			Assert.assertTrue(custom.isElementPresent(driver, By.id("InceptionDate_ddlDate_Third")));
			driver.findElement(By.id("OfficeReference")).clear();
			driver.findElement(By.id("OfficeReference")).sendKeys("Test Referrence");
			driver.findElement(By.id("PartnerName")).clear();
			driver.findElement(By.id("PartnerName")).sendKeys("Test Partner");
			driver.findElement(By.id("HoldingBroker_No")).click();
			driver.findElement(By.id("HoldingBroker_Yes")).click();
			driver.findElement(By.id("TargetPremium")).clear();
			driver.findElement(By.id("TargetPremium")).sendKeys("1000");
			driver.findElement(By.id("ConfirmEmail")).clear();
			driver.findElement(By.id("ConfirmEmail")).sendKeys("test360.15@gmail.com");
			driver.findElement(By.id("Address1")).clear();
			driver.findElement(By.id("Address1")).sendKeys("Test");
			driver.findElement(By.id("Address2")).clear();
			driver.findElement(By.id("Address2")).sendKeys("Test");
			driver.findElement(By.id("County")).clear();
			driver.findElement(By.id("County")).sendKeys("India");
			driver.findElement(By.id("Postcode")).clear();
			driver.findElement(By.id("Postcode")).sendKeys("201301");
			driver.findElement(By.id("SurveyName")).clear();
			driver.findElement(By.id("SurveyName")).sendKeys("Test");
			driver.findElement(By.id("SurveyPosition")).clear();
			driver.findElement(By.id("SurveyPosition")).sendKeys("Noida");
			driver.findElement(By.id("SurveyTel")).clear();
			driver.findElement(By.id("SurveyTel")).sendKeys("9637456365");			
			selenium.click("document.forms[0].elements[526]");
			
			//General Questions Tab
			Assert.assertTrue(selenium.isTextPresent("General Questions"));	
			String SContruction = readp.readLoginFile("StandardConstruction");
			if (SContruction.equals("No")){
				driver.findElement(By.id("ConstructionRbl_No")).click();
				driver.findElement(By.id("ConstructionDetails")).clear();
				driver.findElement(By.id("ConstructionDetails")).sendKeys("Test Construction");
			}else{
				driver.findElement(By.id("ConstructionRbl_Yes")).click();
			}
			
			String FRoof = readp.readLoginFile("FlatRoof");
			if (FRoof.equals("Yes")){
			    driver.findElement(By.id("FlatRoof_Yes")).click();
			    driver.findElement(By.id("RoofArea")).clear();
			    driver.findElement(By.id("RoofArea")).sendKeys("22");
			    driver.findElement(By.id("RoofAge")).clear();
			    driver.findElement(By.id("RoofAge")).sendKeys("11");
			    driver.findElement(By.id("RoofConditionRbl_Yes")).click();
			    driver.findElement(By.id("RoofConditionRbl_No")).click();
			    driver.findElement(By.id("FlatRoofCooking")).clear();
			    driver.findElement(By.id("FlatRoofCooking")).sendKeys("Test Roof");
			}else{
				driver.findElement(By.id("FlatRoof_No")).click();
			}
			    
			driver.findElement(By.id("CurrentDuration")).clear();
			driver.findElement(By.id("CurrentDuration")).sendKeys("2");
			driver.findElement(By.id("ElsewhereDuration")).clear();
			driver.findElement(By.id("ElsewhereDuration")).sendKeys("2");
			
			String ContInsurance = readp.readLoginFile("ContinuousInsurance");
			if (ContInsurance.equals("No")){
			    driver.findElement(By.id("ContInsuranceRbl_Yes")).click();
			    driver.findElement(By.id("InsurerDetails")).clear();
			    driver.findElement(By.id("InsurerDetails")).sendKeys("324232");
			}else{
				driver.findElement(By.id("ContInsuranceRbl_No")).click();
			    driver.findElement(By.id("ReasonNotCont")).clear();
			    driver.findElement(By.id("ReasonNotCont")).sendKeys("Time");
			}			    
			
			
			String SFront = readp.readLoginFile("SeaFront");
			
			if(SFront.equals("yes")){
				driver.findElement(By.id("SeaFrontRbl_Yes")).click();
			}else{
				driver.findElement(By.id("SeaFrontRbl_No")).click();
			}	
			
			driver.findElement(By.id("CliffTopRbl_Yes")).click();
			//driver.findElement(By.id("CliffTopRbl_No")).click();
			//String HFlood = readp.readLoginFile("HistoryofFlood");
			
			String River = readp.readLoginFile("RiverFront");	
			if(River.equals("yes")){
				driver.findElement(By.id("RiverRbl_Yes")).click();
			}else{
				driver.findElement(By.id("RiverRbl_No")).click();
			}	
								
			if(SFront.equals("yes")|| DProp.equals("yes")){
				driver.findElement(By.id("FloodRbl_Yes")).click();
				driver.findElement(By.id("FloodDetails")).clear();
				driver.findElement(By.id("FloodDetails")).sendKeys("Test Details");
			}else{
				driver.findElement(By.id("FloodRbl_No")).click();
			}
			
			driver.findElement(By.id("BusinessHours")).clear();
			driver.findElement(By.id("BusinessHours")).sendKeys("8");
			
			String PResident = readp.readLoginFile("PremiseResident");
			if (PResident.equals("Yes")){
			   driver.findElement(By.id("ResidentsRbl_Yes")).click();
			   driver.findElement(By.id("ResidentDetails")).clear();
			   driver.findElement(By.id("ResidentDetails")).sendKeys("Servant");
			   driver.findElement(By.id("ManagerDetails")).clear();
			   driver.findElement(By.id("ManagerDetails")).sendKeys("Manager");
			}else{
			   driver.findElement(By.id("ResidentsRbl_No")).click();
			   driver.findElement(By.id("ManagerDetails")).clear();
			   driver.findElement(By.id("ManagerDetails")).sendKeys("Manager");
		    }   
			String Alarm = readp.readLoginFile("AlarmRbl");
			if(Alarm.equals("yes")){
				driver.findElement(By.id("AlarmRbl_Yes")).click();
				selenium.click("document.forms[0].elements[526]");
							
				//Alarm and Security Tab
				Assert.assertTrue(selenium.isTextPresent("Alarm and Security"));
				driver.findElement(By.id("AlarmInstall")).clear();
				driver.findElement(By.id("AlarmInstall")).sendKeys("Testing Company");
				driver.findElement(By.id("InstallApproveRbl_Yes")).click();
				driver.findElement(By.id("InstallApproveRbl_No")).click();
				new Select(driver.findElement(By.id("SignallingType"))).selectByVisibleText("Dual Comm");
				driver.findElement(By.cssSelector("option[value=\"Dual Comm\"]")).click();
				
				String PRLevel = readp.readLoginFile("PoliceResponseLevel");
					if (PRLevel.equals("No")){
					   driver.findElement(By.id("PoliceResponseLevel_No")).click();
					   driver.findElement(By.id("PResponseWithdrawn_Yes")).click();
					   driver.findElement(By.id("PResponseWithdrawnDetails")).clear();
					   driver.findElement(By.id("PResponseWithdrawnDetails")).sendKeys("Test Details Description");
					   driver.findElement(By.id("PResponseWithdrawn_No")).click();
					   driver.findElement(By.name("PResponseWithdrawn_No")).clear();
					   driver.findElement(By.name("PResponseWithdrawn_No")).sendKeys("Details Description for testing");
					}else{
				   driver.findElement(By.id("PoliceResponseLevel_Yes")).click();
				}
			selenium.click("document.forms[0].elements[526]");	
			}else{
				driver.findElement(By.id("AlarmRbl_No")).click();
				selenium.click("document.forms[0].elements[526]");
			}
			
			//Previous Claims History Tab
			Assert.assertTrue(selenium.isTextPresent("Previous Claims History"));
			
			String CHistory = readp.readLoginFile("ClaimHistory");
			if (CHistory.equals("No")){
			   driver.findElement(By.id("ClaimsHistory_Yes")).click();
			   driver.findElement(By.id("ClaimsHistoryDetails")).clear();
			   driver.findElement(By.id("ClaimsHistoryDetails")).sendKeys("30Dec 2011, Flood, 2lac");
			}else{
			   driver.findElement(By.id("ClaimsHistory_No")).click();	
			}
		    selenium.click("document.forms[0].elements[526]");
		    
		    //Cover Details Tab
			Assert.assertTrue(selenium.isTextPresent("Cover Details"));	
			driver.findElement(By.id("BuildingsUpTo80")).clear();
			driver.findElement(By.id("BuildingsUpTo80")).sendKeys("100");
			driver.findElement(By.id("BuildingsOver20")).clear();
			driver.findElement(By.id("BuildingsOver20")).sendKeys("100");
			driver.findElement(By.id("TenantImprovements")).clear();
			driver.findElement(By.id("TenantImprovements")).sendKeys("100");
			driver.findElement(By.id("Outdoor")).clear();
			driver.findElement(By.id("Outdoor")).sendKeys("100");
			
			String SRequired = readp.readLoginFile("SubscriptionRequired");
			if (SRequired.equals("Yes")){
			    driver.findElement(By.id("SubsRequired_Yes")).click();
			    driver.findElement(By.id("Subsidence")).clear();
			    driver.findElement(By.id("Subsidence")).sendKeys("100");
			}else{
				driver.findElement(By.id("SubsRequired_No")).click();
			}
			
			
			String TR = readp.readLoginFile("TerrorismRequired");
			if (TR.equals("Yes")){
				driver.findElement(By.id("TerrorismRequired_Yes")).click();
			}else{
				driver.findElement(By.id("TerrorismRequired_No")).click();			
			}
			
			driver.findElement(By.id("ContentsBalance")).clear();
			driver.findElement(By.id("ContentsBalance")).sendKeys("100");
			driver.findElement(By.id("OutbuildingContents")).clear();
			driver.findElement(By.id("OutbuildingContents")).sendKeys("100");
			driver.findElement(By.id("StockInTrade")).clear();
			driver.findElement(By.id("StockInTrade")).sendKeys("100");
			driver.findElement(By.id("LiquerTobacco")).clear();
			driver.findElement(By.id("LiquerTobacco")).sendKeys("100");			
			driver.findElement(By.id("BI_Required_Yes")).click();
			driver.findElement(By.id("BI_Required_No")).click();
			driver.findElement(By.id("ConsequentialLoss")).clear();
			driver.findElement(By.id("ConsequentialLoss")).sendKeys("100");
			driver.findElement(By.id("AnnualCash")).clear();
			driver.findElement(By.id("AnnualCash")).sendKeys("100");
			driver.findElement(By.id("GamingNumber")).clear();
			driver.findElement(By.id("GamingNumber")).sendKeys("100");
			driver.findElement(By.id("SafeMake")).clear();
			driver.findElement(By.id("SafeMake")).sendKeys("Test");
			driver.findElement(By.id("SafeModel")).clear();
			driver.findElement(By.id("SafeModel")).sendKeys("Test");
			
			String ERequired = readp.readLoginFile("EmployerRequired");
			if (ERequired.equals("Yes")){
			    driver.findElement(By.id("EL_Required_Yes")).click();
			    driver.findElement(By.id("EmployerLiability")).clear();
			    driver.findElement(By.id("EmployerLiability")).sendKeys("100");
			}else{
				driver.findElement(By.id("EL_Required_No")).click();
			}
			
			String PRequired = readp.readLoginFile("PLRequired");
			if (PRequired.equals("Yes")){
			    driver.findElement(By.id("PL_Required_Yes")).click();
			    driver.findElement(By.id("SeatCovers")).clear();
			    driver.findElement(By.id("SeatCovers")).sendKeys("100");
			    driver.findElement(By.id("TakeawaySales")).clear();
			    driver.findElement(By.id("TakeawaySales")).sendKeys("20");
			}else{
			    driver.findElement(By.id("PL_Required_No")).click();
			}
			driver.findElement(By.id("AllRisks")).clear();
			driver.findElement(By.id("AllRisks")).sendKeys("10");
			driver.findElement(By.id("AllRiskDetails")).clear();
			driver.findElement(By.id("AllRiskDetails")).sendKeys("Test");			
		    selenium.click("document.forms[0].elements[526]");
		    
		    //Additional Broker Notes
			Assert.assertTrue(selenium.isTextPresent("Additional Broker Notes"));			
			driver.findElement(By.id("AdditionalNotes")).clear();
			driver.findElement(By.id("AdditionalNotes")).sendKeys("Additional Notes for broker");			
			selenium.click("document.forms[0].elements[526]");
			selenium.waitForPageToLoad(timeout);
			
			//Client Details
			new Select(driver.findElement(By.id("ctl00_MainContent_UserTitle"))).selectByVisibleText("Mr");
			driver.findElement(By.id("ctl00_MainContent_Firstname")).clear();
			driver.findElement(By.id("ctl00_MainContent_Firstname")).sendKeys("Test");
			driver.findElement(By.id("ctl00_MainContent_Surname")).clear();
			driver.findElement(By.id("ctl00_MainContent_Surname")).sendKeys("Test");
			driver.findElement(By.id("ctl00_MainContent_UserEmailAddress")).clear();
			driver.findElement(By.id("ctl00_MainContent_UserEmailAddress")).sendKeys("test360.15@gmail.com");
			driver.findElement(By.id("ctl00_MainContent_PhoneNumber")).clear();
			driver.findElement(By.id("ctl00_MainContent_PhoneNumber")).sendKeys("9675786786");
			driver.findElement(By.id("ctl00_MainContent_MobileNumber")).clear();
			driver.findElement(By.id("ctl00_MainContent_MobileNumber")).sendKeys("9876781234");
			driver.findElement(By.id("ctl00_MainContent_OrganisationName")).clear();
			driver.findElement(By.id("ctl00_MainContent_OrganisationName")).sendKeys("Testing");
			driver.findElement(By.id("ctl00_MainContent_Address_txtAddress1")).clear();
			driver.findElement(By.id("ctl00_MainContent_Address_txtAddress1")).sendKeys("Noida");
			driver.findElement(By.id("ctl00_MainContent_Address_txtAddress2")).clear();
			driver.findElement(By.id("ctl00_MainContent_Address_txtAddress2")).sendKeys("Noida");
			driver.findElement(By.id("ctl00_MainContent_Address_txtTown")).clear();
			driver.findElement(By.id("ctl00_MainContent_Address_txtTown")).sendKeys("Noida");
			driver.findElement(By.id("ctl00_MainContent_Address_txtCounty")).clear();
			driver.findElement(By.id("ctl00_MainContent_Address_txtCounty")).sendKeys("India");
			driver.findElement(By.id("ctl00_MainContent_Address_txtPostcode")).clear();
			driver.findElement(By.id("ctl00_MainContent_Address_txtPostcode")).sendKeys("201301");
			driver.findElement(By.id("Next")).click();			
			selenium.waitForPageToLoad(timeout);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
						
			String hf = readp.readLoginFile("Historyofflooding");
			String CaseID;
			
			if(PRequired.equals("Yes") || DProp.equals("Yes") ||CR.equals("Yes")|| FRoof.equals("Yes")||hf.equals("Yes")||TR.equals("Yes")){
				Assert.assertTrue(selenium.isTextPresent("Your quote has been referred"));
				Assert.assertTrue(selenium.isTextPresent("Your quotation has been referred to one of our underwriters and will be processed shortly."));
				CaseID = driver.findElement(By.cssSelector("span.policy_reference")).getText();
				driver.findElement(By.id("ctl00_MainContent_btnViewAccount")).click();
				driver.findElement(By.cssSelector("div[title=\"Click to view list\"] > img")).click();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				Thread.sleep(4000);
				Assert.assertTrue(selenium.isTextPresent("Referrals"));
				if(PRequired.equals("Yes")){
				    Assert.assertTrue(selenium.isTextPresent("Takeaway sales more than 15%"));}
				if(DProp.equals("Yes")){
					Assert.assertTrue(selenium.isTextPresent("Proposal previosly declined"));}
				if(CR.equals("Yes")){
					Assert.assertTrue(selenium.isTextPresent("Criminal Record"));}
				if(FRoof.equals("Yes")){
					Assert.assertTrue(selenium.isTextPresent("Flat roof bad condition"));}
				if(hf.equals("Yes")){
					Assert.assertTrue(selenium.isTextPresent("History of Flooding"));}
				if(TR.equals("Yes")){
					Assert.assertTrue(selenium.isTextPresent("Terrorism quote required"));}
				
				Assert.assertTrue(custom.isElementPresent(driver, By.linkText("Clear Referrals")));
				driver.findElement(By.cssSelector("img[alt=\"close\"]")).click();
				
			}else
			    {
				CaseID = driver.findElement(By.cssSelector("span.policy_reference")).getText();
				driver.findElement(By.id("ctl00_MainContent_btnViewAccount")).click();
			    }
			
			  
			//Store total basic premiums from the Matrix page.
			driver.findElement(By.linkText("Matrix")).click();
			
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
				write.WritePropertyFile("RestaurantCombinedNew", "PolicyID1", PolicyID1);
				write.WritePropertyFile("RestaurantCombinedNew", "TotalGP1", str11);
				write.WritePropertyFile("RestaurantCombinedNew", "TotalNP1", str12);
				write.WritePropertyFile("RestaurantCombinedNew", "TPNet1", TPNet);
			}
			// Execution occur when script run 2nd time.
			if (Counter == 1)
			{
				str21=Basic128;
				str22=Basic129;
				PolicyID2=CaseID;							
				write.WritePropertyFile("RestaurantCombinedNew", "PolicyID2", PolicyID2);
				write.WritePropertyFile("RestaurantCombinedNew", "TotalGP2", str21);
				write.WritePropertyFile("RestaurantCombinedNew", "TotalNP2", str22);
				write.WritePropertyFile("RestaurantCombinedNew", "TPNet2", TPNet);
				
				//Compare the stored value from the property file.
				Assert.assertEquals(str21, readp.readDatafrom("RestaurantCombinedNew", "TotalGP1"));
				Assert.assertEquals(str22, readp.readDatafrom("RestaurantCombinedNew", "TotalNP1"));	
				Assert.assertEquals(TPNet, readp.readDatafrom("RestaurantCombinedNew", "TPNet1"));
			}
			
			driver.findElement(By.linkText("Logout")).click();
		}
}
		
			
			
			
			

















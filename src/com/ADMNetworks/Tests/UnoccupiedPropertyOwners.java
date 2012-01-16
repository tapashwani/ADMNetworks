package com.ADMNetworks.Tests;

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

public class UnoccupiedPropertyOwners {
	
	private WebDriver driver;
	
	//Create Object
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
	public void testUnoccupiedPropertyOwners(String Url) throws Exception
		{		
			UnoccupiedPropertyOwnerstest(driver,Url,Counter);
			Counter=Counter+1;
		}
		public void UnoccupiedPropertyOwnerstest(WebDriver driver,String Url, int Counter) throws Exception{		
			
			driver.get(Url);	
			Selenium selenium = new WebDriverBackedSelenium(driver, Url);
			
			//Create new properties file or reset the value if file already exist 
			if (Counter==0)
			
			{			
				write.CreateNewFiles("UnoccupiedPropertyOwner");
				write.WritePropertyFile("UnoccupiedPropertyOwner", "PolicyID1", "NA");
				write.WritePropertyFile("UnoccupiedPropertyOwner", "PolicyID2", "NA");
				write.WritePropertyFile("UnoccupiedPropertyOwner", "TotalNP1", "NA");
				write.WritePropertyFile("UnoccupiedPropertyOwner", "TotalGP1", "NA");
				write.WritePropertyFile("UnoccupiedPropertyOwner", "TotalNP2", "NA");
				write.WritePropertyFile("UnoccupiedPropertyOwner", "TotalGP2", "NA");
			}		
		
		//Click on Quotes tab and fill the answer.
			driver.findElement(By.id("GetaQuote")).click();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.findElement(By.linkText("Unoccupied Property Owners")).click();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.findElement(By.linkText("click here to sign in")).click();
			custom.waitForElementPresentid(driver, "Username",61);
			custom.Login(driver, selenium, "Admin");
			custom.waitForElementPresentid(driver, "ctl00_MainContent_btnNext", 61);
			//driver.findElement(By.name("Login")).click();
			driver.findElement(By.id("ctl00_MainContent_btnNext")).click();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
						
			//General Declaration tab.	
	    	Assert.assertTrue(selenium.isTextPresent("General Declaration"));
			driver.findElement(By.id("HygieneBreachRbl_No")).click();
			driver.findElement(By.id("DeclinedPropRbl_No")).click();
			driver.findElement(By.id("CrimRecordRbl_No")).click();
			driver.findElement(By.id("BankruptCCJ_No")).click();
			driver.findElement(By.id("DeclarationDetails")).clear();
			driver.findElement(By.id("DeclarationDetails")).sendKeys("Test Issues");
			selenium.click("document.forms[0].elements[559]");
			
			//Quotation and Client Details tab.
			
			Assert.assertTrue(selenium.isTextPresent("Quotation and Client Details"));
			
			//new Select(driver.findElement(By.id("InceptionDate_ddlDate_First"))).selectByVisibleText("03");
			//new Select(driver.findElement(By.id("InceptionDate_ddlDate_Second"))).selectByVisibleText("Feb");
			
			selenium.select("id=InceptionDate_ddlDate_First", "label=03");
			selenium.select("id=InceptionDate_ddlDate_Second", "label=Feb");
			//selenium.select("id=InceptionDate_ddlDate_Second", "label=2012");
			driver.findElement(By.id("OfficeReference")).clear();
			driver.findElement(By.id("OfficeReference")).sendKeys("Test Reference");
			driver.findElement(By.id("PartnerName")).clear();
			driver.findElement(By.id("PartnerName")).sendKeys("Test Directors");
			driver.findElement(By.id("Address1")).clear();
			driver.findElement(By.id("Address1")).sendKeys("Test Address");
			driver.findElement(By.id("County")).clear();
			driver.findElement(By.id("County")).sendKeys("India");
			driver.findElement(By.id("Postcode")).clear();
			driver.findElement(By.id("Postcode")).sendKeys("201301");
			driver.findElement(By.id("SurveyName")).clear();
			driver.findElement(By.id("SurveyName")).sendKeys("Test Name");
			driver.findElement(By.id("SurveyPosition")).clear();
			driver.findElement(By.id("SurveyPosition")).sendKeys("Noida");
			driver.findElement(By.id("SurveyTel")).clear();
			driver.findElement(By.id("SurveyTel")).sendKeys("9876565643");
			driver.findElement(By.id("Third_Party_YesNo_Yes")).click();
			selenium.click("document.forms[0].elements[559]");
			//Third Party Interest tab.
			Assert.assertTrue(selenium.isTextPresent("Third Party Interest"));
			driver.findElement(By.id("3rdParty_Name")).clear();
			driver.findElement(By.id("3rdParty_Name")).sendKeys("Test party");
			driver.findElement(By.id("3rdParty_Address")).clear();
			driver.findElement(By.id("3rdParty_Address")).sendKeys("Test Address");
			selenium.click("document.forms[0].elements[559]");
			
			//General Questions tab.
			Assert.assertTrue(selenium.isTextPresent("General Questions"));
			driver.findElement(By.id("CoverFLEA_Yes")).click();
			driver.findElement(By.id("CoverAllRisks_Yes")).click();
			//driver.findElement(By.id("CoverAllRisks_No")).click();
			
			String ConstD = readp.readLoginFile("ConstructionDetails");
			if(ConstD.equals("No")){
				driver.findElement(By.id("ConstructionRbl_No")).click();
				driver.findElement(By.id("ConstructionDetails")).clear();
				driver.findElement(By.id("ConstructionDetails")).sendKeys("Details Construction");
			}else{
				driver.findElement(By.id("ConstructionRbl_Yes")).click();
			}
			
			String FlatR = readp.readLoginFile("FlatRoof");
			if(FlatR.equals("Yes")){
				driver.findElement(By.id("FlatRoof_Yes")).click();
				driver.findElement(By.id("RoofArea")).clear();
				driver.findElement(By.id("RoofArea")).sendKeys("50");
				driver.findElement(By.id("RoofAge")).clear();
				driver.findElement(By.id("RoofAge")).sendKeys("12");
				driver.findElement(By.id("RoofConditionRbl_Yes")).click();
			}else{
				driver.findElement(By.id("FlatRoof_No")).click();
			}
			
			String OccuP = readp.readLoginFile("OccupantsPremises");
			if(OccuP.equals("Yes")){
				driver.findElement(By.id("OccupierRbl_Yes")).click();
				driver.findElement(By.id("OccupierNature")).clear();
				driver.findElement(By.id("OccupierNature")).sendKeys("Nothing");
			}else{
				driver.findElement(By.id("OccupierRbl_No")).click();
			}
			driver.findElement(By.id("HowLongInterest")).clear();
			driver.findElement(By.id("HowLongInterest")).sendKeys("11");
			
			String ContIn = readp.readLoginFile("ContinuousInsurance");
			if(ContIn.equals("Yes")){
				driver.findElement(By.id("ContInsuranceRbl_Yes")).click();
				driver.findElement(By.id("InsurerDetails")).clear();
				driver.findElement(By.id("InsurerDetails")).sendKeys("Test, 24356");
			}else{
				driver.findElement(By.id("ContInsuranceRbl_No")).click();
				driver.findElement(By.id("ReasonNotCont")).clear();
				driver.findElement(By.id("ReasonNotCont")).sendKeys("Other Constraints");
			}
			
			//driver.findElement(By.id("SeaFrontRbl_No")).click();
			driver.findElement(By.id("SeaFrontRbl_Yes")).click();
			//driver.findElement(By.id("CliffTopRbl_Yes")).click();
			driver.findElement(By.id("CliffTopRbl_No")).click();
			driver.findElement(By.id("RiverRbl_Yes")).click();
			//driver.findElement(By.id("RiverRbl_No")).click();
			
			String FloodH = readp.readLoginFile("HistoryFlooding");
			if(FloodH.equals("Yes")){
				driver.findElement(By.id("FloodRbl_Yes")).click();
				driver.findElement(By.cssSelector("#question_FloodRbl > label.radio")).click();
				driver.findElement(By.id("FloodDetails")).clear();
				driver.findElement(By.id("FloodDetails")).sendKeys("History Of Flooding");
			}else{
				driver.findElement(By.id("FloodRbl_No")).click();
			}
			driver.findElement(By.id("BuiltDetails")).clear();
			driver.findElement(By.id("BuiltDetails")).sendKeys("11");
			                                      //Premises Grade Listed 
			String GradeL = readp.readLoginFile("PremisesGrade");
			if(GradeL.equals("Yes")){
				driver.findElement(By.id("GradeListed_Yes")).click();
				driver.findElement(By.id("GradeListingDetails")).clear();
				driver.findElement(By.id("GradeListingDetails")).sendKeys("A");
			}else{
				driver.findElement(By.id("GradeListed_No")).click();
			}
			driver.findElement(By.id("DoorWindowLocks_Yes")).click();
			//driver.findElement(By.id("DoorWindowLocks_No")).click();
			driver.findElement(By.id("ShuttersGrilles_Yes")).click();
			//driver.findElement(By.id("ShuttersGrilles_No")).click();
			driver.findElement(By.id("WindowsBarred_Yes")).click();
			//driver.findElement(By.id("WindowsBarred_No")).click();
			driver.findElement(By.id("LetterBoxFlaps_Yes")).click();
			//driver.findElement(By.id("LetterBoxFlaps_No")).click();
			driver.findElement(By.id("ServicesDisconnected_Yes")).click();
			//driver.findElement(By.id("ServicesDisconnected_No")).click();
			driver.findElement(By.id("ElectCert_Yes")).click();
			//driver.findElement(By.id("ElectCert_No")).click();
			driver.findElement(By.id("WaterIsolated_No")).click();
			//driver.findElement(By.id("WaterIsolated_Yes")).click();
			//driver.findElement(By.id("Inspected_No")).click();
			driver.findElement(By.id("Inspected_Yes")).click();
			//driver.findElement(By.id("CombustibleREmoval_No")).click();
			driver.findElement(By.id("CombustibleREmoval_Yes")).click();
			//driver.findElement(By.id("Smoke__Detectors_No")).click();
			driver.findElement(By.id("Smoke__Detectors_Yes")).click();
			//driver.findElement(By.id("Sprinklers_No")).click();
			//driver.findElement(By.xpath("//div[@id='question_Sprinklers']/label[2]")).click();
			driver.findElement(By.id("Sprinklers_Yes")).click();
			
			String ResideP = readp.readLoginFile("ResidePremises");
			if(ResideP.equals("Yes")){
				driver.findElement(By.id("Reside_Yes")).click();
				driver.findElement(By.id("ResideDetails")).clear();
				driver.findElement(By.id("ResideDetails")).sendKeys("resident is also a keyholder.");
			}else{
				driver.findElement(By.id("Reside_No")).click();
			}
			//driver.findElement(By.id("Caretaker_No")).click();
			driver.findElement(By.id("Caretaker_Yes")).click();
			//driver.findElement(By.id("CCTV_No")).click();
			driver.findElement(By.id("CCTV_Yes")).click();
			//driver.findElement(By.id("AdjacentPropertyOccupied_No")).click();
			driver.findElement(By.id("AdjacentPropertyOccupied_Yes")).click();
			driver.findElement(By.id("Adjacent__PropertyPartOccupied_Yes")).click();
			//driver.findElement(By.id("Adjacent__PropertyPartOccupied_No")).click();
			driver.findElement(By.id("PartUnoccupiedDetails")).clear();
			driver.findElement(By.id("PartUnoccupiedDetails")).sendKeys("Test Details");
			                                                //Unoccupied
			String UnoccPro = readp.readLoginFile("PropertyUnoccupied");
			if(UnoccPro.equals("Yes")){
				driver.findElement(By.id("AdjacentPropertyUnoccupied_Yes")).click();
				driver.findElement(By.id("UnoccupiedDetails")).clear();
				driver.findElement(By.id("UnoccupiedDetails")).sendKeys("Test Details");
			}else{
			driver.findElement(By.id("AdjacentPropertyUnoccupied_No")).click();
			}
			driver.findElement(By.id("WhyUnoccupiedDetails")).clear();
			driver.findElement(By.id("WhyUnoccupiedDetails")).sendKeys("description for premises");
			driver.findElement(By.id("HowLongUnoccupiedDetails")).clear();
			driver.findElement(By.id("HowLongUnoccupiedDetails")).sendKeys("11");
			//driver.findElement(By.id("PlanningConsent_No")).click();
			driver.findElement(By.id("PlanningConsent_Yes")).click();
			//driver.findElement(By.id("AlarmRbl_No")).click();
			driver.findElement(By.id("AlarmRbl_Yes")).click();
			selenium.click("document.forms[0].elements[559]");
			
			//Please Provide Details of your Security System tab.
			Assert.assertTrue(selenium.isTextPresent("Please Provide Details of your Security System"));
			driver.findElement(By.id("AlarmInstall")).clear();
			driver.findElement(By.id("AlarmInstall")).sendKeys("Testing Alarm");
			driver.findElement(By.id("InstallApproveRbl_Yes")).click();
			driver.findElement(By.id("InstallApproveRbl_No")).click();
			
			selenium.select("id=SignallingType", "label=Other");
			driver.findElement(By.cssSelector("option[value=\"Other\"]")).click();
			driver.findElement(By.id("AlarmDetails")).clear();
			driver.findElement(By.id("AlarmDetails")).sendKeys("Test Detials");
			
			String PoliceR = readp.readLoginFile("PoliceResponse");
			if(PoliceR.equals("No")){
			driver.findElement(By.id("PoliceResponseLevel_No")).click();
			    String PoliceRW = readp.readLoginFile("PoliceResponseWithdrawn");
			    if(PoliceRW.equals("No")){
			driver.findElement(By.id("PResponseWithdrawn_No")).click();
			driver.findElement(By.name("PResponseWithdrawn_No")).clear();
			driver.findElement(By.name("PResponseWithdrawn_No")).sendKeys("Test");
			    }else{
			driver.findElement(By.id("PResponseWithdrawn_Yes")).click();
			driver.findElement(By.id("PResponseWithdrawnDetails")).clear();
			driver.findElement(By.id("PResponseWithdrawnDetails")).sendKeys("Details");
			    }
			}
			else{
			driver.findElement(By.id("PoliceResponseLevel_Yes")).click();
			}
			selenium.click("document.forms[0].elements[559]");
			
			//Previous Claims History tab.
			Assert.assertTrue(selenium.isTextPresent("Previous Claims History"));
			
			String ClaimsH = readp.readLoginFile("ClaimsHistory");
			if(ClaimsH.equals("Yes")){
				driver.findElement(By.id("ClaimsHistory_Yes")).click();
				driver.findElement(By.id("ClaimsHistoryDetails")).clear();
				driver.findElement(By.id("ClaimsHistoryDetails")).sendKeys("24Sept 2010, Flood, 3lac");
			}else{
			driver.findElement(By.id("ClaimsHistory_No")).click();
			}
			selenium.click("document.forms[0].elements[559]");
			//Cover Details tab
			Assert.assertTrue(selenium.isTextPresent("Cover Details"));
			driver.findElement(By.id("BuildingsUpTo80")).clear();
			driver.findElement(By.id("BuildingsUpTo80")).sendKeys("100");
			driver.findElement(By.id("BuildingsOver20")).clear();
			driver.findElement(By.id("BuildingsOver20")).sendKeys("100");
			
			String SCover = readp.readLoginFile("SubsidenceCover");
			if(SCover.equals("Yes")){
			driver.findElement(By.id("SubsRequired_Yes")).click();
			driver.findElement(By.id("Subsidence")).clear();
			driver.findElement(By.id("Subsidence")).sendKeys("100");
			}else{
				driver.findElement(By.id("SubsRequired_No")).click();
			}
			driver.findElement(By.id("BasicContents")).clear();
			driver.findElement(By.id("BasicContents")).sendKeys("100");
			driver.findElement(By.id("MachineryPlant")).clear();
			driver.findElement(By.id("MachineryPlant")).sendKeys("100");
			
			String LCover = readp.readLoginFile("LiabilityCover");
			if(LCover.equals("Yes")){
			driver.findElement(By.id("EL_Required_Yes")).click();
			driver.findElement(By.id("EmployerLiability")).clear();
			driver.findElement(By.id("EmployerLiability")).sendKeys("100");
			}else{
				driver.findElement(By.id("EL_Required_No")).click();
			}
			
			String RPCover = readp.readLoginFile("RequirePropertyOwners");
			if(RPCover.equals("Yes")){
			driver.findElement(By.id("PL_Required_Yes")).click();
			}else{
				driver.findElement(By.id("PL_Required_No")).click();
			}
			driver.findElement(By.id("ADGlass")).clear();
			driver.findElement(By.id("ADGlass")).sendKeys("3,0000");
			selenium.click("document.forms[0].elements[559]");
			
			//Additional Broker Notes tab.
			Assert.assertTrue(selenium.isTextPresent("Additional Broker Notes"));
			driver.findElement(By.id("AdditionalNotes")).clear();
			driver.findElement(By.id("AdditionalNotes")).sendKeys("Additional Notes");
			selenium.click("document.forms[0].elements[560]");
			
			//Client details page
			selenium.select("id=ctl00_MainContent_UserTitle", "label=Mr");
			driver.findElement(By.id("ctl00_MainContent_Firstname")).clear();
			driver.findElement(By.id("ctl00_MainContent_Firstname")).sendKeys("TestFirst");
			driver.findElement(By.id("ctl00_MainContent_Surname")).clear();
			driver.findElement(By.id("ctl00_MainContent_Surname")).sendKeys("TestSurname");
			driver.findElement(By.id("ctl00_MainContent_UserEmailAddress")).clear();
			driver.findElement(By.id("ctl00_MainContent_UserEmailAddress")).sendKeys("test360@gmail.com");
			driver.findElement(By.id("ctl00_MainContent_PhoneNumber")).clear();
			driver.findElement(By.id("ctl00_MainContent_PhoneNumber")).sendKeys("9876543210");
			driver.findElement(By.id("ctl00_MainContent_MobileNumber")).clear();
			driver.findElement(By.id("ctl00_MainContent_MobileNumber")).sendKeys("9087654123");
			driver.findElement(By.id("Next")).click();
			selenium.waitForPageToLoad(timeout);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			Assert.assertTrue(selenium.isTextPresent("Your quotation request has been received and will be processed shortly."));
			Assert.assertTrue(selenium.isTextPresent("In the meantime please view and print the following important documents relating to your quotation."));
			String CaseID = driver.findElement(By.cssSelector("span.policy_reference")).getText();
			driver.findElement(By.id("ctl00_MainContent_btnViewAccount")).click();
					
		  
		//Store total basic premiums from the Matrix page.
		driver.findElement(By.linkText("Matrix")).click();
		
		String Basic164 = driver.findElement(By.id("Basic_164_result_span")).getText();
		Basic164 = Basic164.replace( '\u00A3', '*' );
		String Basic165 = driver.findElement(By.id("Basic_165_result_span")).getText();
		Basic165 = Basic165.replace( '\u00A3', '*' );
		String TPNet = driver.findElement(By.id("TotalPremiumNet_result_span")).getText();
		TPNet = TPNet.replace( '\u00A3', '*' );
		
		// Execution occur when script run 1st time.
		if (Counter == 0)
		{	
			str11 = Basic164;
			str12 = Basic165;
			PolicyID1=CaseID;
			write.WritePropertyFile("UnoccupiedPropertyOwner", "PolicyID1", PolicyID1);
			write.WritePropertyFile("UnoccupiedPropertyOwner", "TotalGP1", str11);
			write.WritePropertyFile("UnoccupiedPropertyOwner", "TotalNP1", str12);
			write.WritePropertyFile("UnoccupiedPropertyOwner", "TPNet1", TPNet);
		}
		// Execution occur when script run 2nd time.
		if (Counter == 1)
		{
			str21=Basic164;
			str22=Basic165;
			PolicyID2=CaseID;							
			write.WritePropertyFile("UnoccupiedPropertyOwner", "PolicyID2", PolicyID2);
			write.WritePropertyFile("UnoccupiedPropertyOwner", "TotalGP2", str21);
			write.WritePropertyFile("UnoccupiedPropertyOwner", "TotalNP2", str22);
			write.WritePropertyFile("UnoccupiedPropertyOwner", "TPNet2", TPNet);
			
			//Compare the stored value from the property file.
			Assert.assertEquals(str21, readp.readDatafrom("UnoccupiedPropertyOwner", "TotalGP1"));
			Assert.assertEquals(str22, readp.readDatafrom("UnoccupiedPropertyOwner", "TotalNP1"));	
			Assert.assertEquals(TPNet, readp.readDatafrom("UnoccupiedPropertyOwner", "TPNet1"));
		}
		
		driver.findElement(By.linkText("Logout")).click();
		
		
	}
}
	

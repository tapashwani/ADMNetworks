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


public class HotelCombinedNew {
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
		public void testHotelCombined(String Url) throws Exception {		
			HotelCombinedtest(driver,Url, Counter);
			Counter=Counter+1;
		}
		public void HotelCombinedtest(WebDriver driver,String Url, int Counter) throws Exception{		
			
			driver.get(Url);	
			Selenium selenium = new WebDriverBackedSelenium(driver, Url);
			
			//Create new properties file or reset the value if file already exist 
			if (Counter==0){			
				write.CreateNewFiles("HotelCombinedNew");
				write.WritePropertyFile("HotelCombinedNew", "PolicyID1", "NA");
				write.WritePropertyFile("HotelCombinedNew", "PolicyID2", "NA");
				write.WritePropertyFile("HotelCombinedNew", "TotalNP1", "NA");
				write.WritePropertyFile("HotelCombinedNew", "TotalGP1", "NA");
				write.WritePropertyFile("HotelCombinedNew", "TotalNP2", "NA");
				write.WritePropertyFile("HotelCombinedNew", "TotalGP2", "NA");
			}		
			
			//Click on Quotes tab and fill the answer.
			driver.findElement(By.id("GetaQuote")).click();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.findElement(By.linkText("Hotel Combined")).click();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.findElement(By.linkText("click here to sign in")).click();
			custom.waitForElementPresentid(driver, "Username",61);
			custom.Login(driver, selenium, "Admin");
			custom.waitForElementPresentid(driver, "ctl00_MainContent_btnNext", 61);
			driver.findElement(By.id("ctl00_MainContent_btnNext")).click();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			// Declarations Tab
			if (readp.readLoginFile("CoverDeclined").equals("Yes")){
				driver.findElement(By.id("S2P5DecCvrDecYN_Yes")).click();
				Assert.assertTrue(custom.isElementPresent(driver, By.id("S2P5DecCvrDeclTxt")));
				driver.findElement(By.id("S2P5DecCvrDeclTxt")).clear();
				driver.findElement(By.id("S2P5DecCvrDeclTxt")).sendKeys("Cover Canceled");
			}
			if (readp.readLoginFile("Criminaloffence").equals("Yes")){
				driver.findElement(By.id("S2P5DeclConvctYN_Yes")).click();
				Assert.assertTrue(custom.isElementPresent(driver, By.id("S2P5ConvctTxt")));
				driver.findElement(By.id("S2P5ConvctTxt")).clear();
				driver.findElement(By.id("S2P5ConvctTxt")).sendKeys("No Criminal offence");
			}
			if (readp.readLoginFile("FinancialFailure").equals("Yes")){
				driver.findElement(By.id("S2P5DeclBanKrptYN_Yes")).click();
				driver.findElement(By.id("S2P5DeclBkrptTxt")).clear();
				driver.findElement(By.id("S2P5DeclBkrptTxt")).sendKeys("Business involvement");
			}
			driver.findElement(By.name("QuestionPage_Next")).click();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			// Contact Details Tab
			driver.findElement(By.id("S1P1RegNameTB")).clear();
			driver.findElement(By.id("S1P1RegNameTB")).sendKeys("Champ trader");
			// #Risk Location No (Condition)
			if (readp.readLoginFile("RiskLocation").equals("No")){
				driver.findElement(By.id("S1P1RiskLocAddYN_No")).click();
				driver.findElement(By.id("S1P1RiskAddLine1")).clear();
				driver.findElement(By.id("S1P1RiskAddLine1")).sendKeys("Risk line1");
				driver.findElement(By.id("S1P1RiskAddLine2")).clear();
				driver.findElement(By.id("S1P1RiskAddLine2")).sendKeys("Risk Line2");
				driver.findElement(By.id("S1P1RiskAddTown")).clear();
				driver.findElement(By.id("S1P1RiskAddTown")).sendKeys("FosterCity");
				driver.findElement(By.id("S1P1RiskAddCounty")).clear();
				driver.findElement(By.id("S1P1RiskAddCounty")).sendKeys("USA");
				driver.findElement(By.id("S1P1RiskAddPostcode")).clear();
				driver.findElement(By.id("S1P1RiskAddPostcode")).sendKeys("94404");
			}
			// General Tab
			driver.findElement(By.name("QuestionPage_Next")).click();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			new Select(driver.findElement(By.id("S1P3BusDescText"))).selectByVisibleText("Guesthouse");
			new Select(driver.findElement(By.id("S1P1YrsBusOprtd"))).selectByVisibleText("more than 3 years");
			driver.findElement(By.id("S1P3OpenYrRound_Yes")).click();
			driver.findElement(By.id("S1P3RoomNo")).clear();
			driver.findElement(By.id("S1P3RoomNo")).sendKeys("6");
			driver.findElement(By.id("S1P3FinInterestYN_Yes")).click();
			Assert.assertTrue(custom.isElementPresent(driver, By.id("S1P3FinIntTxt")));
			driver.findElement(By.id("S1P3FinIntTxt")).clear();
			driver.findElement(By.id("S1P3FinIntTxt")).sendKeys("ACME");
			// Material Damege
			selenium.click("document.forms[0].elements[361]");
			selenium.waitForPageToLoad(timeout);
			driver.findElement(By.id("S2P1BuildingSI")).clear();
			driver.findElement(By.id("S2P1BuildingSI")).sendKeys("500000");
			driver.findElement(By.id("S2P1TrContentsSI")).clear();
			driver.findElement(By.id("S2P1TrContentsSI")).sendKeys("200000");
			driver.findElement(By.id("S2P1StockInTradeSI")).clear();
			driver.findElement(By.id("S2P1StockInTradeSI")).sendKeys("200000");
			driver.findElement(By.id("S2P1BusEqptNonStdLimit")).clear();
			driver.findElement(By.id("S2P1BusEqptNonStdLimit")).sendKeys("50000");
			driver.findElement(By.id("S2P1ToWiSpNonStdLimit")).clear();
			driver.findElement(By.id("S2P1ToWiSpNonStdLimit")).sendKeys("50000");
			driver.findElement(By.id("S2P1DoSNonStdLimit")).clear();
			driver.findElement(By.id("S2P1DoSNonStdLimit")).sendKeys("40000");
			driver.findElement(By.id("S2P1ArtWorksNonStdLimit")).clear();
			driver.findElement(By.id("S2P1ArtWorksNonStdLimit")).sendKeys("30000");
			driver.findElement(By.id("S2P1HouseholdNonStdLimit")).clear();
			driver.findElement(By.id("S2P1HouseholdNonStdLimit")).sendKeys("20000");
			// Business Interruption 
			driver.findElement(By.name("QuestionPage_Next")).click();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.findElement(By.id("S2P2GrossRevSI")).clear();
			driver.findElement(By.id("S2P2GrossRevSI")).sendKeys("300000");
			new Select(driver.findElement(By.id("S2P2GrRevIndPer"))).selectByVisibleText("12 Months");
			// #Loss of Rent Receivable (condition)
			driver.findElement(By.id("S2P2LORRCoverYN_Yes")).click();
			driver.findElement(By.id("S2P2LORRSI")).clear();
			driver.findElement(By.id("S2P2LORRSI")).sendKeys("3000");
			new Select(driver.findElement(By.id("S2P2LORRecIP"))).selectByVisibleText("12 Months");
			// Liability Tab
			driver.findElement(By.name("QuestionPage_Next")).click();
			driver.findElement(By.id("S2P3AdminPayroll")).clear();
			driver.findElement(By.id("S2P3AdminPayroll")).sendKeys("50000");
			driver.findElement(By.id("S2P3GrossWageRoll")).clear();
			driver.findElement(By.id("S2P3GrossWageRoll")).sendKeys("40000");
			driver.findElement(By.id("S2P3AnnTurnover")).clear();
			driver.findElement(By.id("S2P3AnnTurnover")).sendKeys("450000");
			driver.findElement(By.name("QuestionPage_Next")).click();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			// Claims History Tab
			driver.findElement(By.id("S2P4Claims3YrsYN_Yes")).click();
			Assert.assertTrue(custom.isElementPresent(driver, By.id("S2P4Claims3YrsText")));
			driver.findElement(By.id("S2P4Claims3YrsText")).clear();
			driver.findElement(By.id("S2P4Claims3YrsText")).sendKeys("Outer wall damage due to earth quacks");
			driver.findElement(By.id("S2P4Claims3YrsYN_No")).click();
			driver.findElement(By.id("SP2P4FloodHistYN_Yes")).click();
			driver.findElement(By.id("S2P4FloodHistTxtBox")).clear();
			driver.findElement(By.id("S2P4FloodHistTxtBox")).sendKeys("water lobbing");
			driver.findElement(By.id("SP2P4FloodHistYN_No")).click();
			if (readp.readLoginFile("Prevsubshistory").equals("Yes")){			
				driver.findElement(By.id("S2P4SubsHistYN_Yes")).click();
				driver.findElement(By.id("S2P4SubsHistTB")).clear();
				driver.findElement(By.id("S2P4SubsHistTB")).sendKeys("roof repaired");
			}else{
				driver.findElement(By.id("S2P4SubsHistYN_No")).click();
			}
			driver.findElement(By.name("QuestionPage_Next")).click();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			// Premises Information Tab
			driver.findElement(By.id("S1P3BldgDate")).clear();
			driver.findElement(By.id("S1P3BldgDate")).sendKeys("2008");
			new Select(driver.findElement(By.id("S3P1StoreyNo"))).selectByVisibleText("Five");
			// #High Risk Location 
			if (readp.readLoginFile("Risklocationlstd").equals("Yes")){
				driver.findElement(By.id("S3P1PremListedYN_Yes")).click();
				new Select(driver.findElement(By.id("S3P1ListGrade"))).selectByVisibleText("Grade 1");
			}else{
				driver.findElement(By.id("S3P1PremListedYN_No")).click();
			}
			// #Constructed bricks
			if(readp.readLoginFile("NonStndwallcnstctn").equals("No")){
			driver.findElement(By.id("S3P1WallsConstYN_No")).click();
			driver.findElement(By.id("S3P1WallsConstTxt")).clear();
			driver.findElement(By.id("S3P1WallsConstTxt")).sendKeys("Tiles also used.");
			}else{
				driver.findElement(By.id("S3P1WallsConstYN_Yes")).click();
			}
			
			// #constructed of concrete
			if(readp.readLoginFile("NonStndcnstctnroof").equals("No")){
			
				driver.findElement(By.id("S3P1RoofsConstYN_No")).click();
				driver.findElement(By.id("S3P1RoofsConstText")).clear();
				driver.findElement(By.id("S3P1RoofsConstText")).sendKeys("Few parts constructed via plywood");
			}else{
				
				driver.findElement(By.id("S3P1RoofsConstYN_Yes")).click();
			}
			// #Flat Roof
			//driver.findElement(By.id("S3P1FlatRoofYN_No")).click();
			driver.findElement(By.id("S3P1FlatRoofYN_Yes")).click();
			driver.findElement(By.id("S3P1FlatRoofPerC")).clear();
			driver.findElement(By.id("S3P1FlatRoofPerC")).sendKeys("26");
			// #Timber Floors
			//driver.findElement(By.id("S3P1WoodFloorYN_No")).click();
			driver.findElement(By.id("S3P1WoodFloorYN_Yes")).click();
			driver.findElement(By.id("S3P1WoodFloorArea")).clear();
			driver.findElement(By.id("S3P1WoodFloorArea")).sendKeys("25");
			selenium.click("document.forms[0].elements[361]");
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			//selenium.waitForPageToLoad(timeout);			
			// Fire Detection tab
			if(readp.readLoginFile("FireAlarm").equals("Yes")){			
				driver.findElement(By.id("S3P2FireAlarmYN_Yes")).click();
				Assert.assertTrue(custom.isElementPresent(driver, By.id("S3P2FAlarmMainYN_Yes")));
				Assert.assertTrue(custom.isElementPresent(driver, By.id("S3P2FAlarmSignal")));
				Assert.assertTrue(custom.isElementPresent(driver, By.id("S3P2FAlarmTestFreq")));
				driver.findElement(By.id("S3P2FAlarmMainYN_Yes")).click();
				new Select(driver.findElement(By.id("S3P2FAlarmSignal"))).selectByVisibleText("Local Bell(s) or Klaxon Only");
				new Select(driver.findElement(By.id("S3P2FAlarmTestFreq"))).selectByVisibleText("Monthly");
			}else{
				driver.findElement(By.id("S3P2FireAlarmYN_No")).click();
			}
			// #SmokDetector
			if(readp.readLoginFile("FireAlarm").equals("No")){						
				driver.findElement(By.id("S3P2HandSDetectYN_No")).click();
				driver.findElement(By.id("S3P2HandSDetectTxt")).clear();
				driver.findElement(By.id("S3P2HandSDetectTxt")).sendKeys("Not in bedroom");
			}else{
				driver.findElement(By.id("S3P2HandSDetectYN_Yes")).click();
			}
			new Select(driver.findElement(By.id("S3P2FireStationDist"))).selectByVisibleText("Under 10 Miles");
			new Select(driver.findElement(By.id("S3P2FStationType"))).selectByVisibleText("Not Known");
			selenium.click("document.forms[0].elements[361]");
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			// Security
			driver.findElement(By.id("S3P3LiveInYN_Yes")).click();
			driver.findElement(By.id("S3P3LiveInYN_No")).click();
			driver.findElement(By.id("S3P3LiveInTxt")).clear();
			driver.findElement(By.id("S3P3LiveInTxt")).sendKeys("Yes");
			driver.findElement(By.id("S3P3BurglAmYN_No")).click();
			driver.findElement(By.id("S3P3BurglAmYN_Yes")).click();
			new Select(driver.findElement(By.id("S3P3BurgAmSigSy"))).selectByVisibleText("Local Bells or Klaxon");
			driver.findElement(By.id("S3P3CCTvYN_Yes")).click();
			driver.findElement(By.id("S3P3CCTvYN_Yes")).click();
			driver.findElement(By.id("S3P3CCTvYN_No")).click();
			driver.findElement(By.id("S3P3CCTvYN_No")).click();
			driver.findElement(By.id("S3P3SafeYN_Yes")).click();
			driver.findElement(By.id("S3P3SafeMakeTxt")).clear();
			driver.findElement(By.id("S3P3SafeMakeTxt")).sendKeys("Link Safe1");
			driver.findElement(By.id("S3P3SafeFixedYN_No")).click();
			driver.findElement(By.name("QuestionPage_Next")).click();
			// Electrical and Heating Systems
			driver.findElement(By.id("S3P4WireInspYN_Yes")).click();
			driver.findElement(By.id("S3P4OpenFireTB")).click();
			driver.findElement(By.id("S3P4PortElectHeatTB")).click();
			driver.findElement(By.id("S3P4PortGasHeatTB")).click();
			driver.findElement(By.name("QuestionPage_Next")).click();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			// Business Activities
			driver.findElement(By.id("S4P1SpHrsLicYN_Yes")).click();
			driver.findElement(By.id("S4P1SpHrsActTxtB")).clear();
			driver.findElement(By.id("S4P1SpHrsActTxtB")).sendKeys("business hours !");
			driver.findElement(By.id("S4P1EntertainYN_Yes")).click();
			driver.findElement(By.id("S4P1EntertainDetail")).clear();
			driver.findElement(By.id("S4P1EntertainDetail")).sendKeys("DJ");
			driver.findElement(By.id("S4P1EntertainNonResYN_Yes")).click();
			driver.findElement(By.name("QuestionPage_Next")).click();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			// Health & Safety
			driver.findElement(By.id("S4P2HSPolYN_No")).click();
			driver.findElement(By.id("S4P2HSNoticeYN_Yes")).click();
			driver.findElement(By.id("S4P2HSNoticeTB")).clear();
			driver.findElement(By.id("S4P2HSNoticeTB")).sendKeys("in 2009");
			driver.findElement(By.id("S4P2HSEmplTrainYN_Yes")).click();
			driver.findElement(By.id("S4P2AccdtBookYN_Yes")).click();
			driver.findElement(By.name("QuestionPage_Next")).click();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			// Hygiene
			driver.findElement(By.id("S4P3FdHygTrYN_Yes")).click();
			driver.findElement(By.id("S4P3FdHygTrYN_No")).click();
			driver.findElement(By.id("S4P3TempMonYN_Yes")).click();
			driver.findElement(By.id("S4P3PestConYN_Yes")).click();
			driver.findElement(By.name("QuestionPage_Next")).click();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.findElement(By.id("AdditionalNotes")).clear();
			driver.findElement(By.id("AdditionalNotes")).sendKeys("Welcome to Hotel combined Scheme");
			driver.findElement(By.name("QuestionPage_Next")).click();
			selenium.waitForPageToLoad(timeout);
			new Select(driver.findElement(By.id("ctl00_MainContent_UserTitle"))).selectByVisibleText("Mr");
			driver.findElement(By.id("ctl00_MainContent_Firstname")).clear();
			driver.findElement(By.id("ctl00_MainContent_Firstname")).sendKeys("Robert");
			driver.findElement(By.id("ctl00_MainContent_Surname")).clear();
			driver.findElement(By.id("ctl00_MainContent_Surname")).sendKeys("Park");
			driver.findElement(By.id("Next")).click();
			selenium.waitForPageToLoad(timeout);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			String cd = readp.readLoginFile("CoverDeclined");
			String co = readp.readLoginFile("Criminaloffence");
			String ff = readp.readLoginFile("FinancialFailure");
			String rl = readp.readLoginFile("RiskLocation");
			String nsc = readp.readLoginFile("NonStndwallcnstctn");
			String nscf = readp.readLoginFile("NonStndcnstctnroof");
			String fa = readp.readLoginFile("FireAlarm");
			String psh = readp.readLoginFile("Prevsubshistory");
			String sdni = readp.readLoginFile("SmokeDetectorsnotinstalled");
			String CaseID;
			
			if(cd.equals("Yes") || co.equals("Yes") ||ff.equals("Yes")|| rl.equals("No")||nsc.equals("No")|| nscf.equals("No")||fa.equals("No")||psh.equals("Yes")|| sdni.equals("No")){
				Assert.assertTrue(selenium.isTextPresent("Your quote has been referred"));
				Assert.assertTrue(selenium.isTextPresent("Your quotation has been referred to one of our underwriters and will be processed shortly."));
				CaseID = driver.findElement(By.cssSelector("span.policy_reference")).getText();
				driver.findElement(By.id("ctl00_MainContent_btnViewAccount")).click();
				driver.findElement(By.cssSelector("div[title=\"Click to view list\"] > img")).click();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				Thread.sleep(4000);
				Assert.assertTrue(selenium.isTextPresent("Referrals"));
				if(cd.equals("Yes")){
				Assert.assertTrue(selenium.isTextPresent("Past Cover Declined"));}
				if(ff.equals("Yes")){
				Assert.assertTrue(selenium.isTextPresent("Past Financial Failure"));}
				if(rl.equals("No")){
				Assert.assertTrue(selenium.isTextPresent("Listed Premises"));}
				if(nsc.equals("No")){
				Assert.assertTrue(selenium.isTextPresent("Non Standard wall construction"));}
				if(nscf.equals("No")){
				Assert.assertTrue(selenium.isTextPresent("Non Standard construction roof"));}
				if(psh.equals("Yes")){
				Assert.assertTrue(selenium.isTextPresent("Previous subsidence history"));}
				if(sdni.equals("No")){
				Assert.assertTrue(selenium.isTextPresent("Smoke Detectors not installed"));}
				
				Assert.assertTrue(custom.isElementPresent(driver, By.linkText("Clear Referrals")));
				driver.findElement(By.cssSelector("img[alt=\"close\"]")).click();
				
			}else{
				CaseID = driver.findElement(By.cssSelector("span.policy_reference")).getText();
				driver.findElement(By.id("ctl00_MainContent_btnViewAccount")).click();
			}
			driver.findElement(By.linkText("Matrix")).click();
			String Basic140 = driver.findElement(By.id("Basic_140_result_span")).getText();
			Basic140 = Basic140.replace( '\u00A3', '*' );
			String Basic141 = driver.findElement(By.id("Basic_141_result_span")).getText();
			Basic141 = Basic141.replace( '\u00A3', '*' );
			String TPNet = driver.findElement(By.id("TotalPremiumNet_result_span")).getText();
			TPNet = TPNet.replace( '\u00A3', '*' );
			
			// Execution occur when script run 1st time.
			if (Counter == 0)
			{	
				str11 = Basic140;
				str12 = Basic141;
				PolicyID1=CaseID;
				write.WritePropertyFile("HotelCombinedNew", "PolicyID1", PolicyID1);
				write.WritePropertyFile("HotelCombinedNew", "TotalGP1", str11);
				write.WritePropertyFile("HotelCombinedNew", "TotalNP1", str12);
				write.WritePropertyFile("HotelCombinedNew", "TPNet1", TPNet);
			}
			// Execution occur when script run 2nd time.
			if (Counter == 1)
			{
				str21=Basic140;
				str22=Basic141;
				PolicyID2=CaseID;							
				write.WritePropertyFile("HotelCombinedNew", "PolicyID2", PolicyID2);
				write.WritePropertyFile("HotelCombinedNew", "TotalGP2", str21);
				write.WritePropertyFile("HotelCombinedNew", "TotalNP2", str22);
				write.WritePropertyFile("HotelCombinedNew", "TPNet2", TPNet);
				
				//Compare the stored value from the property file.
				Assert.assertEquals(str21, readp.readDatafrom("HotelCombinedNew", "TotalGP1"));
				Assert.assertEquals(str22, readp.readDatafrom("HotelCombinedNew", "TotalNP1"));			
			}
			
			driver.findElement(By.linkText("Logout")).click();
		}
}

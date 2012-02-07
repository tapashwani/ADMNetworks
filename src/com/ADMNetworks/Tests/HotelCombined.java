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

public class HotelCombined {
	
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
	public void testHotelCombined(String Url) throws Exception {		
		HotelCombinedtest(driver,Url,Counter);
		Counter=Counter+1;
	}
	public void HotelCombinedtest(WebDriver driver,String Url,int Counter) throws Exception{		
		
		driver.get(Url);	
		Selenium selenium = new WebDriverBackedSelenium(driver, Url);
		
		//Create new properties file or reset the value if file already exist 
		if (Counter==0){			
			write.CreateNewFiles("HotelCombined");
			write.WritePropertyFile("HotelCombined", "PolicyID1", "NA");
			write.WritePropertyFile("HotelCombined", "PolicyID2", "NA");
			write.WritePropertyFile("HotelCombined", "TotalNP1", "NA");
			write.WritePropertyFile("HotelCombined", "TotalGP1", "NA");
			write.WritePropertyFile("HotelCombined", "TotalNP2", "NA");
			write.WritePropertyFile("HotelCombined", "TotalGP2", "NA");
		}		
		
		//Click on Quotes tab and fill the answer.
		driver.findElement(By.id("GetaQuote")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Hotel Combined")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("click here to sign in")).click();
		custom.waitForElementPresentid(driver, "Username",61);
		custom.Login(driver, selenium, "Admin");
		custom.waitForElementPresentid(driver, "ctl00_MainContent_btnNext", 61);
		driver.findElement(By.id("ctl00_MainContent_btnNext")).click();
		Thread.sleep(4000);
		driver.findElement(By.cssSelector("#stub_page_Page5 > div.inner")).click();
		driver.findElement(By.id("S1P1RegNameTB")).clear();
		driver.findElement(By.id("S1P1RegNameTB")).sendKeys("Testing details");
		driver.findElement(By.cssSelector("#stub_page_Page9 > div.inner")).click();
		Thread.sleep(4000);
		selenium.select("id=S1P3BusDescText", "label=Guesthouse");
		selenium.select("id=S1P1YrsBusOprtd", "label=1 to 3 years");
		driver.findElement(By.id("S1P3OpenYrRound_Yes")).click();
		driver.findElement(By.id("S1P3RoomNo")).sendKeys("5");
		driver.findElement(By.id("S1P3FinInterestYN_Yes")).click();
		driver.findElement(By.id("S1P3FinInterestYN_No")).click();
		driver.findElement(By.cssSelector("#stub_page_Page1 > div.inner")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("S2P1BuildingSI")).sendKeys("100");
		driver.findElement(By.id("S2P1TrContentsSI")).sendKeys("50");
		driver.findElement(By.id("S2P1StockInTradeSI")).sendKeys("500");
		driver.findElement(By.id("S2P1BusEqptNonStdLimit")).sendKeys("200");
		driver.findElement(By.id("S2P1ToWiSpNonStdLimit")).sendKeys("100");
		driver.findElement(By.id("S2P1DoSNonStdLimit")).sendKeys("26");
		driver.findElement(By.id("S2P1ArtWorksNonStdLimit")).sendKeys("51");
		driver.findElement(By.id("S2P1HouseholdNonStdLimit")).sendKeys("21");
		driver.findElement(By.cssSelector("#stub_page_Page13 > div.inner")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("S2P2GrossRevSI")).sendKeys("200");
		selenium.select("id=S2P2GrRevIndPer", "label=12 Months");
		driver.findElement(By.cssSelector("#stub_page_Page14 > div.inner")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("S2P3AdminPayroll")).sendKeys("100");
		driver.findElement(By.id("S2P3GrossWageRoll")).sendKeys("100");
		driver.findElement(By.id("S2P3AnnTurnover")).sendKeys("5000");
		driver.findElement(By.cssSelector("#stub_page_Page2 > div.inner")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("S2P4Claims3YrsYN_No")).click();
		driver.findElement(By.id("SP2P4FloodHistYN_Yes")).click();
		driver.findElement(By.id("S2P4FloodHistTxtBox")).sendKeys("testing date");
		driver.findElement(By.id("S2P4SubsHistYN_No")).click();
		driver.findElement(By.cssSelector("#stub_page_Page4 > div.inner")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("S1P3BldgDate")).sendKeys("2009");
		selenium.select("id=S3P1StoreyNo", "label=Four");
		driver.findElement(By.id("S3P1PremListedYN_No")).click();
		driver.findElement(By.id("S3P1WallsConstYN_Yes")).click();
		driver.findElement(By.id("S3P1RoofsConstYN_Yes")).click();
		driver.findElement(By.id("S3P1FlatRoofYN_Yes")).click();
		driver.findElement(By.id("S3P1FlatRoofPerC")).sendKeys("30");
		driver.findElement(By.id("S3P1WoodFloorYN_No")).click();
		driver.findElement(By.cssSelector("#stub_page_Page10 > div.inner")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("S3P2FireAlarmYN_Yes")).click();
		driver.findElement(By.id("S3P2FAlarmMainYN_No")).click();
		Thread.sleep(2000);
		selenium.select("id=S3P2FAlarmSignal", "label=Local Bells and remote signalling to a monitoring Central Station");
		selenium.select("id=S3P2FAlarmTestFreq", "label=Monthly");
		driver.findElement(By.id("S3P2HandSDetectYN_No")).click();
		driver.findElement(By.id("S3P2HandSDetectTxt")).sendKeys("Smoke detector not placed in the bedroom");
		Thread.sleep(4000);
		selenium.select("id=S3P2FireStationDist", "label=Under 5 Miles");
		selenium.select("id=S3P2FStationType", "label=Retained");
		driver.findElement(By.cssSelector("#stub_page_Page6 > div.inner")).click();
		Thread.sleep(4000);
		driver.findElement(By.id("S3P3LiveInYN_Yes")).click();
		driver.findElement(By.id("S3P3BurglAmYN_No")).click();
		driver.findElement(By.id("S3P3CCTvYN_No")).click();
		driver.findElement(By.id("S3P3SafeYN_No")).click();
		driver.findElement(By.cssSelector("#stub_page_Page11 > div.inner")).click();
		Thread.sleep(4000);
		driver.findElement(By.id("S3P4WireInspYN_Yes")).click();
		driver.findElement(By.id("S3P4FxdElectHeat")).click();
		driver.findElement(By.id("S3P4PortElectHeatTB")).click();
		driver.findElement(By.cssSelector("#stub_page_Page12 > div.inner")).click();
		Thread.sleep(4000);
		driver.findElement(By.id("S4P1SpHrsLicYN_No")).click();
		driver.findElement(By.id("S4P1EntertainYN_Yes")).click();
		driver.findElement(By.id("S4P1EntertainDetail")).sendKeys("Fun events");
		driver.findElement(By.id("S4P1EntertainNonResYN_No")).click();
		driver.findElement(By.cssSelector("#stub_page_Page7 > div.inner")).click();
		Thread.sleep(4000);
		driver.findElement(By.id("S4P2HSPolYN_Yes")).click();
		driver.findElement(By.id("S4P2HSNoticeYN_No")).click();
		driver.findElement(By.id("S4P2HSEmplTrainYN_Yes")).click();
		driver.findElement(By.id("S4P2AccdtBookYN_Yes")).click();
		driver.findElement(By.cssSelector("#stub_page_Page18 > div.inner")).click();
		Thread.sleep(4000);
		driver.findElement(By.id("S4P3FdHygTrYN_Yes")).click();
		driver.findElement(By.id("S4P3TempMonYN_Yes")).click();
		driver.findElement(By.id("S4P3PestConYN_Yes")).click();
		driver.findElement(By.cssSelector("#stub_page_Page3 > div.inner")).click();
		Thread.sleep(4000);
		driver.findElement(By.id("AdditionalNotes")).sendKeys("No other specific Notes here");
		selenium.click("document.forms[0].elements[362]");
		selenium.waitForPageToLoad("30000");
		selenium.select("id=ctl00_MainContent_UserTitle", "label=Capt");
		driver.findElement(By.id("ctl00_MainContent_Firstname")).sendKeys("Testing");
		driver.findElement(By.id("ctl00_MainContent_Surname")).sendKeys("Hotel");
		driver.findElement(By.id("ctl00_MainContent_OrganisationName")).sendKeys("360Logica");
		driver.findElement(By.id("ctl00_MainContent_Address_txtAddress1")).sendKeys("test 1/2");
		driver.findElement(By.id("ctl00_MainContent_Address_txtTown")).sendKeys("Foster City");
		driver.findElement(By.id("ctl00_MainContent_Address_txtCounty")).sendKeys("USA");
		driver.findElement(By.id("ctl00_MainContent_Address_txtPostcode")).sendKeys("SG2 8BJ");
		driver.findElement(By.id("Next")).click();
		Thread.sleep(4000);
		custom.waitForElementPresent(driver, "span.policy_reference", 62);
		String CaseID = driver.findElement(By.cssSelector("span.policy_reference")).getText();
		Assert.assertTrue(selenium.isTextPresent("exact:IMPORTANT: Your referral reference is " + CaseID));
		System.out.println(CaseID);
		driver.findElement(By.id("ctl00_MainContent_btnViewAccount")).click();
		Thread.sleep(3000);
		
		//Click on Matrix tab, store values in variables and HotelCombined.properties file
		driver.findElement(By.linkText("Matrix")).click();
		Thread.sleep(3000);	
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
			write.WritePropertyFile("HotelCombined", "PolicyID1", PolicyID1);
			write.WritePropertyFile("HotelCombined", "TotalGP1", str11);
			write.WritePropertyFile("HotelCombined", "TotalNP1", str12);
			write.WritePropertyFile("HotelCombined", "TPNet1", TPNet);
		}
		// Execution occur when script run 2nd time.
		if (Counter == 1)
		{
			str21 = Basic140;
			str22 = Basic141;
			PolicyID2=CaseID;							
			write.WritePropertyFile("HotelCombined", "PolicyID2", PolicyID2);
			write.WritePropertyFile("HotelCombined", "TotalGP2", str21);
			write.WritePropertyFile("HotelCombined", "TotalNP2", str22);
			write.WritePropertyFile("HotelCombined", "TPNet2", TPNet);
			
			//Compare the stored value from the property file.
			Assert.assertEquals(str21, readp.readDatafrom("HotelCombined", "TotalGP1"));
			Assert.assertEquals(str22, readp.readDatafrom("HotelCombined", "TotalNP1"));			
		}
		
		driver.findElement(By.linkText("Logout")).click();
		
	}
	
	}

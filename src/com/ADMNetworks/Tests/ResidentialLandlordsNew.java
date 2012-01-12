package com.ADMNetworks.Tests;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverBackedSelenium;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;
import org.testng.Assert;
import com.ADMNetworks.Utill.CustomMethod;
import com.ADMNetworks.Utill.ReadProperty;
import com.ADMNetworks.Utill.WritePropertiesFile;
import com.thoughtworks.selenium.Selenium;

public class ResidentialLandlordsNew {

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
		public void testResidentialLandlordsNew(String Url) throws Exception {
		ResidentialLandlordsNewtest(driver,Url);
			Counter=Counter+1;
		}
		
		public void ResidentialLandlordsNewtest(WebDriver driver,String Url) throws Exception{
		    driver.get(Url);		
			Selenium selenium = new WebDriverBackedSelenium(driver, Url);	
			//Create new properties file or reset the value if file already exist 
				if (Counter==0){
					write.CreateNewFiles("ResidentialLandlordsNew");
					write.WritePropertyFile("ResidentialLandlordsNew", "PolicyID1", "NA");
					write.WritePropertyFile("ResidentialLandlordsNew", "PolicyID2", "NA");
					write.WritePropertyFile("ResidentialLandlordsNew", "TotalNP1", "NA");
					write.WritePropertyFile("ResidentialLandlordsNew", "TotalGP1", "NA");
					write.WritePropertyFile("ResidentialLandlordsNew", "TotalNP2", "NA");
					write.WritePropertyFile("ResidentialLandlordsNew", "TotalGP2", "NA");
				}
			
			//Click on Quotes tab and fill the answer.
			driver.findElement(By.id("GetaQuote")).click();
			custom.waitForElementPresentlink(driver, "Residential Landlords", 21);
			driver.findElement(By.linkText("Residential Landlords")).click();
			Thread.sleep(5000);
			
			// Sign in using valid admin credential.
			driver.findElement(By.linkText("click here to sign in")).click();
			custom.waitForElementPresentid(driver, "Username",61);
			custom.Login(driver, selenium, "Admin");
			custom.waitForElementPresentid(driver, "ctl00_MainContent_btnNext", 51);
			driver.findElement(By.id("ctl00_MainContent_btnNext")).click();
			
			// Statement of Facts tab.
			Assert.assertTrue(selenium.isTextPresent("Statement of Facts"));
			driver.findElement(By.id("StatementOfFactsPart1_No")).click();
			driver.findElement(By.id("StatementOfFactsPart2_No")).click();
			driver.findElement(By.id("StatementofFactPart3_No")).click();
			driver.findElement(By.id("StatementOfFactPart4_No")).click();
			driver.findElement(By.id("StatementOfFactPart5_No")).click();
			driver.findElement(By.xpath("//td/div/div[3]/input[2]")).click();
			
			// Property Details tab.
			Assert.assertTrue(selenium.isTextPresent("Property Details"));
			new Select(driver.findElement(By.id("InceptionDate_ddlDate_First"))).selectByVisibleText("07");
			new Select(driver.findElement(By.id("InceptionDate_ddlDate_Second"))).selectByVisibleText("Apr");
			driver.findElement(By.id("Prop1AddressLine1")).clear();
			driver.findElement(By.id("Prop1AddressLine1")).sendKeys("Sec64");
			driver.findElement(By.id("Prop1AddressLine2")).clear();
			driver.findElement(By.id("Prop1AddressLine2")).sendKeys("US");
			driver.findElement(By.id("Prop1AddressTown")).clear();
			driver.findElement(By.id("Prop1AddressTown")).sendKeys("US");
			driver.findElement(By.id("Prop1AddressCounty")).sendKeys("US");
			driver.findElement(By.id("Prop1AddressPostCode")).sendKeys("123456");
			new Select(driver.findElement(By.id("Prop1TypeOfProperty"))).selectByVisibleText("Maisonette");
			new Select(driver.findElement(By.id("Prop1Occupancy"))).selectByVisibleText("Professional Let");
			driver.findElement(By.cssSelector("option[value=\"Professional Let\"]")).click();
			driver.findElement(By.id("Prop1YearBuilt")).sendKeys("2011");
			driver.findElement(By.id("Prop1Listed_No")).click();
			driver.findElement(By.id("Prop1FloodArea_Yes")).click();
			driver.findElement(By.id("Prop1GoodStateOfRepair_Yes")).click();
			driver.findElement(By.id("Prop1SubsidenceHistory_Yes")).click();
			
			//Property Construction
			String P1Construction = readp.readLoginFile("Property1Construction");
	        if(P1Construction.equals("No")){	
			driver.findElement(By.id("Property1Construction_No")).click();
			driver.findElement(By.id("Prop1ConstOther")).sendKeys("incombustible material test");
			}else{
			driver.findElement(By.id("Property1Construction_Yes")).click();
			}
			new Select(driver.findElement(By.id("Prop1FlatRoofPercentage"))).selectByVisibleText("26-50%");
			driver.findElement(By.id("Prop1SecurityStandard_No")).click();
			new Select(driver.findElement(By.id("Prop1SecurityAlarm"))).selectByVisibleText("Digital Communicator");
			driver.findElement(By.id("Prop1BuildingsSumInsured")).sendKeys("500");
			driver.findElement(By.id("Prop1BuildingsAccidentalDamage_No")).click();
			driver.findElement(By.id("Prop1BuildingsAccidentalDamage_Yes")).click();
			driver.findElement(By.id("Prop1SubsidenceCoverRequired_No")).click();
			driver.findElement(By.id("Prop1SubsidenceCoverRequired_Yes")).click();
			driver.findElement(By.id("Prop1ContentsSumInsured")).sendKeys("400");
			driver.findElement(By.id("Prop1ContentsAccidentalDamage_Yes")).click();
		    
			//Interest of a third party
			String FInterest = readp.readLoginFile("FinancialInterest");
	        if(FInterest.equals("Yes")){
			driver.findElement(By.id("Prop1FinancialInterestYN_Yes")).click();
			driver.findElement(By.id("Prop1FinancialInterest")).clear();
			driver.findElement(By.id("Prop1FinancialInterest")).sendKeys("I would like to add test third party");
			}else{
			driver.findElement(By.id("Prop1FinancialInterestYN_No")).click();
			}
			driver.findElement(By.xpath("//td/div/div[3]/input[2]")).click();
			
			//Claims Details tab.
			Assert.assertTrue(selenium.isTextPresent("Claims Details"));			                             
			String CYears = readp.readLoginFile("ClaimsInLast5Years");
	        if(CYears.equals("Yes")){
		    driver.findElement(By.id("ClaimsInLast5Years_Yes")).click();
			new Select(driver.findElement(By.id("Claim1Date_ddlDate_First"))).selectByVisibleText("09");
			new Select(driver.findElement(By.id("Claim1Date_ddlDate_Second"))).selectByVisibleText("May");
			new Select(driver.findElement(By.id("Claim1Date_ddlDate_Third"))).selectByVisibleText("2011");
			new Select(driver.findElement(By.id("Claim1Type"))).selectByVisibleText("Fire or Explosion");
			driver.findElement(By.id("Claim1Description")).clear();
			driver.findElement(By.id("Claim1Description")).sendKeys("Test Fire details");
			                                               //claim costs for claim
		        String CCost = readp.readLoginFile("ClaimCostKnown");
				if(CCost.equals("Yes")){
			    driver.findElement(By.id("Claim1CostKnown_Yes")).click();
			    driver.findElement(By.id("Claim1Costs")).clear();
			    driver.findElement(By.id("Claim1Costs")).sendKeys("100");
				}else{
			    driver.findElement(By.id("Claim1CostKnown_No")).click();
				}
			new Select(driver.findElement(By.id("Claim1Status"))).selectByVisibleText("Pending");
			                                                //Any more claims
			    String ExClaims = readp.readLoginFile("ExtraClaims");
				if(ExClaims.equals("Yes")){
			    driver.findElement(By.id("ExtraClaimsYN_Yes")).click();
			    driver.findElement(By.id("ExtraClaimsDetails")).clear();
			    driver.findElement(By.id("ExtraClaimsDetails")).sendKeys("Yes have property claim");
				}else{
			    driver.findElement(By.id("ExtraClaimsYN_No")).click();
				}
			}
			else{
			driver.findElement(By.id("ClaimsInLast5Years_No")).click();
			}
			driver.findElement(By.xpath("//td/div/div[3]/input[2]")).click();
			
			// Optional Extras
			Assert.assertTrue(selenium.isTextPresent("Optional Extras"));
			String LExpenses = readp.readLoginFile("LegalExpenses");        //Legal expenses condition
			if(LExpenses.equals("Yes")){
			driver.findElement(By.id("LegalExpensesStandard_Yes")).click();
			driver.findElement(By.id("LegalExpensesExtended_No")).click();
			}else{
			driver.findElement(By.id("LegalExpensesStandard_No")).click();
			}
			driver.findElement(By.xpath("//td/div/div[3]/input[2]")).click();
			
			// Client tab.
			Assert.assertTrue(selenium.isTextPresent("Client"));
			driver.findElement(By.id("ctl00_MainContent_CA1_AddressLine1")).clear();
			driver.findElement(By.id("ctl00_MainContent_CA1_AddressLine1")).sendKeys("Address1");
			driver.findElement(By.id("ctl00_MainContent_CA1_TownCity")).clear();
			driver.findElement(By.id("ctl00_MainContent_CA1_TownCity")).sendKeys("US");
			driver.findElement(By.id("ctl00_MainContent_CA1_County")).clear();
			driver.findElement(By.id("ctl00_MainContent_CA1_County")).sendKeys("US");
			driver.findElement(By.id("ctl00_MainContent_CA1_Postcode")).clear();
			driver.findElement(By.id("ctl00_MainContent_CA1_Postcode")).sendKeys("SG2 8BJ");
			driver.findElement(By.id("ctl00_MainContent_ctl02_CBD")).clear();
			driver.findElement(By.id("ctl00_MainContent_ctl02_CBD")).sendKeys("Test CBD");
			driver.findElement(By.id("ctl00_MainContent_ctl03_CCN")).clear();
			driver.findElement(By.id("ctl00_MainContent_ctl03_CCN")).sendKeys("Test CCN");
			new Select(driver.findElement(By.id("ctl00_MainContent_ClientContact_Title"))).selectByVisibleText("Mr");
			driver.findElement(By.id("ctl00_MainContent_ClientContact_Firstname")).clear();
			driver.findElement(By.id("ctl00_MainContent_ClientContact_Firstname")).sendKeys("Test");
			driver.findElement(By.id("ctl00_MainContent_ClientContact_Surname")).clear();
			driver.findElement(By.id("ctl00_MainContent_ClientContact_Surname")).sendKeys("Client");
			driver.findElement(By.id("ctl00_MainContent_ctl05_CMobile")).clear();
			driver.findElement(By.id("ctl00_MainContent_ctl05_CMobile")).sendKeys("3456781234");
			driver.findElement(By.id("ctl00_MainContent_ctl06_CPhone")).clear();
			driver.findElement(By.id("ctl00_MainContent_ctl06_CPhone")).sendKeys("678123412");
			driver.findElement(By.xpath("//td/div/div[3]/input[3]")).click();
			String CaseID = driver.findElement(By.cssSelector("span.policy_reference")).getText();
			driver.findElement(By.id("ctl00_MainContent_btnSave")).click();
			Assert.assertTrue(selenium.isTextPresent("Client details"));
			driver.findElement(By.id("Next")).click();
			//Store total basic premiums from the Matrix page.
			driver.findElement(By.linkText("Matrix")).click();
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
					write.WritePropertyFile("ResidentialLandlordsNew", "PolicyID1", PolicyID1);
					write.WritePropertyFile("ResidentialLandlordsNew", "TotalGP1", str11);
					write.WritePropertyFile("ResidentialLandlordsNew", "TotalNP1", str12);
					write.WritePropertyFile("ResidentialLandlordsNew", "TPNet1", TPNet);
				}
				
				// Execution occur when script run 2nd time.
				if (Counter == 1)
				{
					str21=Basic_161;
					str22=Basic_162;
					PolicyID2=CaseID;				
					write.WritePropertyFile("ResidentialLandlordsNew", "PolicyID2", PolicyID2);
					write.WritePropertyFile("ResidentialLandlordsNew", "TotalGP2", str21);
					write.WritePropertyFile("ResidentialLandlordsNew", "TotalNP2", str22);
					write.WritePropertyFile("ResidentialLandlordsNew", "TPNet2", TPNet);
					
					//Compare the stored value from the property file.
					Assert.assertEquals(str21, readp.readDatafrom("ResidentialLandlordsNew", "TotalGP1"));
					Assert.assertEquals(str22, readp.readDatafrom("ResidentialLandlordsNew", "TotalNP1"));
					Assert.assertEquals(TPNet, readp.readDatafrom("ResidentialLandlordsNew", "TPNet1"));
					
				}
				
				driver.findElement(By.linkText("Logout")).click();
			}

}

package com.ADMNetworks.Tests;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverBackedSelenium;
import org.testng.annotations.*;
import org.testng.Assert;
import com.ADMNetworks.Utill.*;
import com.thoughtworks.selenium.Selenium;

public class CombinedLiabilityNew {
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
	public void testCombinedLiability(String Url) throws Exception {
		testCombinedLiabilitytNew(driver,Url,Counter);
		Counter=Counter+1;
	}
	
	public void testCombinedLiabilitytNew(WebDriver driver,String Url, int Counter) throws Exception {
		
		driver.get(Url);		
		Selenium selenium = new WebDriverBackedSelenium(driver, Url);	
		
		//Create new properties file or reset the value if file already exist 
		if (Counter==0){				
			write.CreateNewFiles("CombinedLiabilityNew");
			write.WritePropertyFile("CombinedLiabilityNew", "PolicyID1", "NA");
			write.WritePropertyFile("CombinedLiabilityNew", "PolicyID2", "NA");
			write.WritePropertyFile("CombinedLiabilityNew", "TotalNP1", "NA");
			write.WritePropertyFile("CombinedLiabilityNew", "TotalGP1", "NA");
			write.WritePropertyFile("CombinedLiabilityNew", "TotalNP2", "NA");
			write.WritePropertyFile("CombinedLiabilityNew", "TotalGP2", "NA");
		}
		
		//Click on Quotes tab and fill the answer.
		driver.findElement(By.id("GetaQuote")).click();
		custom.waitForElementPresentlink(driver, "Combined Liability", 21);
		driver.findElement(By.linkText("Combined Liability")).click();
		Thread.sleep(7000);
		driver.findElement(By.linkText("click here to sign in")).click();
		custom.waitForElementPresentid(driver, "Username",61);
		custom.Login(driver, selenium, "Admin");
		custom.waitForElementPresentid(driver, "ctl00_MainContent_btnNext", 61);
		driver.findElement(By.id("ctl00_MainContent_btnNext")).click();
		String Bankruptcy = readp.readLoginFile("Bankruptcy");
		//Execute when Bankruptcy is set to yes.
		if(Bankruptcy.equals("yes")){			
			driver.findElement(By.id("SOF__Bankruptcy_Yes")).click();
			custom.isElementPresent(driver, By.id("SOF__Details"));
			driver.findElement(By.id("SOF__Details")).sendKeys("Due to miss communication");
		}
		driver.findElement(By.name("QuestionPage_Next")).click();
		driver.findElement(By.id("FullTradingName")).sendKeys("Mr. Traider Sr");
		selenium.select("id=Company__Type", "label=Partnership");
		driver.findElement(By.id("Trading__Duration")).sendKeys("2009");
		selenium.select("id=MainProfession", "label=Administration");
		driver.findElement(By.name("QuestionPage_Next")).click();
		String Public_Liability = readp.readLoginFile("PublicLiability");
		//Execute when Public_Liability is 1000000
		if(Public_Liability.equals("1000000")){		
			driver.findElement(By.id("UK__Turnover")).sendKeys("5000000");
			driver.findElement(By.id("Sub__Contractor__Value")).sendKeys("500000");
			selenium.select("id=Overseas__Contracts", "label=Yes");
			selenium.select("id=ExportOverseas", "label=Yes");
		}
		//Execute when Public_Liability is 2000000
		if(Public_Liability.equals("2000000")){
			selenium.select("id=Public__Liability", "label=2000000");
			driver.findElement(By.id("UK__Turnover")).sendKeys("5000000");
			driver.findElement(By.id("Sub__Contractor__Value")).sendKeys("500000");
			selenium.select("id=Overseas__Contracts", "label=Yes");
			selenium.select("id=ExportOverseas", "label=Yes");
		}
		//Execute when Public_Liability is 5000000
		if(Public_Liability.equals("5000000")){
			selenium.select("id=Public__Liability", "label=5000000");
			driver.findElement(By.id("UK__Turnover")).sendKeys("50000000");
			driver.findElement(By.id("Sub__Contractor__Value")).sendKeys("500000");
			selenium.select("id=Overseas__Contracts", "label=Yes");
			selenium.select("id=ExportOverseas", "label=Yes");
		}
		driver.findElement(By.name("QuestionPage_Next")).click();
		String value1=readp.readLoginFile("EL_YesNo");
		if(value1.equals("yes")){
			driver.findElement(By.cssSelector("#EL__YesNo > option[value=\"Yes\"]")).click();
			driver.findElement(By.id("Wages__Clerical__Employees")).sendKeys("4500");
			driver.findElement(By.id("Wages__Manual__Employees")).sendKeys("5000");
			driver.findElement(By.id("Wages__Fixed__Woodworking")).sendKeys("10000");
			driver.findElement(By.id("Wages__Warehouseman")).sendKeys("15000");
			driver.findElement(By.id("Wages__Drivers")).sendKeys("25000");
		}else{
			driver.findElement(By.cssSelector("#EL__YesNo > option[value=\"No\"]")).click();
			driver.findElement(By.id("Wages__Clerical__Employees")).sendKeys("4500");
			driver.findElement(By.id("Wages__Manual__Employees")).sendKeys("5000");
			driver.findElement(By.id("Wages__Fixed__Woodworking")).sendKeys("10000");
			driver.findElement(By.id("Wages__Warehouseman")).sendKeys("15000");
			driver.findElement(By.id("Wages__Drivers")).sendKeys("25000");
		}
		driver.findElement(By.name("QuestionPage_Next")).click();
		driver.findElement(By.id("Claims_No")).click();
		driver.findElement(By.id("Hot__Works__Away_No")).click();
		driver.findElement(By.id("Radioactive__Substances_No")).click();
		driver.findElement(By.id("High__Risk__Products_No")).click();
		
		String Employees5=readp.readLoginFile("Employees5");
		//Execute below condition when "Employees5" value is no
		if(Employees5.equals("no")){
			driver.findElement(By.id("5Employees_No")).click();
		}
		else{
			//Execute below condition when "Employees5" value is not set to no
			driver.findElement(By.id("5Employees_Yes")).click();
			Assert.assertTrue(custom.isElementPresent(driver, By.cssSelector("#question_Health__and__Safety > div.text")));
			driver.findElement(By.id("Health__and__Safety_Yes")).click();
			Assert.assertTrue(custom.isElementPresent(driver, By.cssSelector("#question_Safety__Training > div.text")));
			driver.findElement(By.id("Safety__Training_Yes")).click();
			Assert.assertTrue(custom.isElementPresent(driver, By.cssSelector("#question_High__Risk__Procedure > div.text")));
			driver.findElement(By.id("High__Risk__Procedure_Yes")).click();
		}
		selenium.click("document.forms[0].elements[207]");
		selenium.waitForPageToLoad(timeout);
		selenium.select("id=ctl00_MainContent_UserTitle", "label=Mr");
		driver.findElement(By.id("ctl00_MainContent_Firstname")).sendKeys("Quality");
		driver.findElement(By.id("ctl00_MainContent_Surname")).sendKeys("Analyst");
		driver.findElement(By.id("ctl00_MainContent_Address_txtAddress1")).sendKeys("Address line 1233");
		driver.findElement(By.id("ctl00_MainContent_Address_txtAddress2")).sendKeys("New cross roads");
		driver.findElement(By.id("ctl00_MainContent_Address_txtTown")).sendKeys("Foster City");
		driver.findElement(By.id("ctl00_MainContent_Address_txtCounty")).sendKeys("USA");
		driver.findElement(By.id("ctl00_MainContent_Address_txtPostcode")).sendKeys("94404");
		driver.findElement(By.id("Next")).click();
		selenium.waitForPageToLoad(timeout);
		String CaseID = driver.findElement(By.cssSelector("span.policy_reference")).getText();
		System.out.println(CaseID);
		//Execute when Bankruptcy value is yes
		if(Bankruptcy.equals("yes")){
			Assert.assertTrue(selenium.isTextPresent("Your quote has been referred"));
			Assert.assertTrue(selenium.isTextPresent("Your quotation has been referred to one of our underwriters and will be processed shortly."));
			driver.findElement(By.id("ctl00_MainContent_btnViewAccount")).click();
			Thread.sleep(5000);
			driver.findElement(By.cssSelector("div[title=\"Click to view list\"] > img")).click();
			Thread.sleep(5000);
			Assert.assertTrue(selenium.isTextPresent("Referrals"));
			Assert.assertTrue(selenium.isTextPresent("SOF Fail"));
			//Execute when 5Employee_YesNo value is yes
			if(Employees5.equals("yes")){
				Assert.assertTrue(selenium.isTextPresent("High Risk Procedures"));
			}
			Assert.assertTrue(selenium.isTextPresent("Previously declared Bankrupt"));
			Assert.assertTrue(custom.isElementPresent(driver, By.linkText("Clear Referrals")));
			driver.findElement(By.cssSelector("img[alt=\"close\"]")).click();
			Thread.sleep(3000);
		}else{
			//Execute when only 5Employee_YesNo value is yes
			if(Employees5.equals("yes")){
				Assert.assertTrue(selenium.isTextPresent("Your quote has been referred"));
				Assert.assertTrue(selenium.isTextPresent("Your quotation has been referred to one of our underwriters and will be processed shortly."));
				driver.findElement(By.id("ctl00_MainContent_btnViewAccount")).click();
				Thread.sleep(5000);
				driver.findElement(By.cssSelector("div[title=\"Click to view list\"] > img")).click();
				Thread.sleep(5000);
				Assert.assertTrue(selenium.isTextPresent("Referrals"));
				Assert.assertTrue(selenium.isTextPresent("High Risk Procedures"));
				Assert.assertTrue(custom.isElementPresent(driver, By.linkText("Clear Referrals")));
				driver.findElement(By.cssSelector("img[alt=\"close\"]")).click();
				Thread.sleep(3000);
			}else{
				//Execute when Bankruptcy, and 5Employee_YesNO is set to "no"
				driver.findElement(By.id("ctl00_MainContent_btnViewAccount")).click();
				Thread.sleep(5000);
			   }
		}
		driver.findElement(By.linkText("Matrix")).click();
		//Execute when Public_Liability is 1000000
		if(Public_Liability.equals("1000000")){
			Assert.assertEquals(selenium.getValue("id=Public__Liability_fixedfee"),"500.00");
		}
		//Execute when Public_Liability is 2000000
		if(Public_Liability.equals("2000000")){
			Assert.assertEquals(selenium.getValue("id=Public__Liability_fixedfee"),"750.00");
		}
		//Execute when Public_Liability is 5000000
		if(Public_Liability.equals("5000000")){
			Assert.assertEquals(selenium.getValue("id=Public__Liability_fixedfee"),"1,000.00");
		}
		//Store Basic totals from the Matrix page.
		Assert.assertEquals(selenium.getValue("id=Sub__Contractor__Value_rate"),"0.7500");		
		String Basic168 = driver.findElement(By.id("Basic_168_result_span")).getText();
		Basic168 = Basic168.replace( '\u00A3', '*' );
		String Basic169 = driver.findElement(By.id("Basic_169_result_span")).getText();
		Basic169 = Basic169.replace( '\u00A3', '*' );
		
		// Execution occur when script run 1st time.
		if (Counter == 0)
		{
			str11 = Basic168;
			str12 = Basic169;
			PolicyID1=CaseID;
			//Write the stored value in the CombinedLiabilityNew.properties file
			write.WritePropertyFile("CombinedLiabilityNew", "PolicyID1", PolicyID1);
			write.WritePropertyFile("CombinedLiabilityNew", "TotalGP1", str11);
			write.WritePropertyFile("CombinedLiabilityNew", "TotalNP1", str12);
		}
		// Execution occur when script run 2nd time.
		if (Counter == 1)
		{
			str21=Basic168;
			str22=Basic169;
			PolicyID2=CaseID;		
			//Write the stored value in the CombinedLiabilityNew.properties file
			write.WritePropertyFile("CombinedLiabilityNew", "PolicyID2", PolicyID2);
			write.WritePropertyFile("CombinedLiabilityNew", "TotalGP2", str21);
			write.WritePropertyFile("CombinedLiabilityNew", "TotalNP2", str22);
			
			//Compare the stored value from the property file.
			Assert.assertEquals(str21, readp.readDatafrom("CombinedLiabilityNew", "TotalGP1"));
			Assert.assertEquals(str22, readp.readDatafrom("CombinedLiabilityNew", "TotalNP1"));				
		}
		driver.findElement(By.linkText("Logout")).click();
		
	}
	
}

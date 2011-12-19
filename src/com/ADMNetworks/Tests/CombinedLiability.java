package com.ADMNetworks.Tests;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverBackedSelenium;
import org.testng.annotations.*;
import org.testng.Assert;
import com.ADMNetworks.Utill.*;
import com.thoughtworks.selenium.Selenium;

public class CombinedLiability {
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
		CombinedLiabilitytest(driver,Url,Counter);
		Counter=Counter+1;
	}
	public void CombinedLiabilitytest(WebDriver driver,String Url, int Counter) throws Exception{
		
			driver.get(Url);		
			Selenium selenium = new WebDriverBackedSelenium(driver, Url);	
			
			//Create new properties file or reset the value if file already exist 
			if (Counter==0){				
				write.CreateNewFiles("CombinedLiability");
				write.WritePropertyFile("CombinedLiability", "PolicyID1", "NA");
				write.WritePropertyFile("CombinedLiability", "PolicyID2", "NA");
				write.WritePropertyFile("CombinedLiability", "TotalNP1", "NA");
				write.WritePropertyFile("CombinedLiability", "TotalGP1", "NA");
				write.WritePropertyFile("CombinedLiability", "TotalNP2", "NA");
				write.WritePropertyFile("CombinedLiability", "TotalGP2", "NA");
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
			custom.waitForElementPresentname(driver, "QuestionPage_Back", 51);
			driver.findElement(By.cssSelector("#stub_page_Page1 > div.inner")).click();
			Thread.sleep(3000);
			driver.findElement(By.id("FullTradingName")).clear();
			driver.findElement(By.id("FullTradingName")).sendKeys("360logica");
			selenium.select("id=InceptDate_ddlDate_Third", "label=2011");
			selenium.select("id=Company__Type", "label=Limited Company");
			driver.findElement(By.id("Trading__Duration")).clear();
			driver.findElement(By.id("Trading__Duration")).sendKeys("2010");
			selenium.select("id=MainProfession", "label=Computer Engineers");
			driver.findElement(By.cssSelector("#stub_page_Page2 > div.inner")).click();
			Thread.sleep(3000);
			driver.findElement(By.id("UK__Turnover")).clear();
			driver.findElement(By.id("UK__Turnover")).sendKeys("50000");
			driver.findElement(By.id("Sub__Contractor__Value")).clear();
			driver.findElement(By.id("Sub__Contractor__Value")).sendKeys("510");
			selenium.select("id=Overseas__Contracts", "label=Yes");
			selenium.select("id=ExportOverseas", "label=Yes");
			driver.findElement(By.cssSelector("#stub_page_Page3 > div.inner")).click();
			Thread.sleep(3000);
			
			//Insert condition from the property file.
			String value1=readp.readLoginFile("EL_YesNo");
			if(value1.equals("yes")){
				driver.findElement(By.cssSelector("#EL__YesNo > option[value=\"Yes\"]")).click();
				driver.findElement(By.id("Wages__Clerical__Employees")).sendKeys("5000");
				driver.findElement(By.id("Wages__Manual__Employees")).sendKeys("50000");
				driver.findElement(By.id("Wages__Fixed__Woodworking")).sendKeys("50000");
				driver.findElement(By.id("Wages__Warehouseman")).sendKeys("5251");
				driver.findElement(By.id("Wages__Drivers")).sendKeys("5236");
			}
			else{
				driver.findElement(By.id("Wages__Clerical__Employees")).sendKeys("12");
				driver.findElement(By.id("Wages__Manual__Employees")).sendKeys("12");
				driver.findElement(By.id("Wages__Fixed__Woodworking")).sendKeys("12");
				driver.findElement(By.id("Wages__Warehouseman")).clear();
				driver.findElement(By.id("Wages__Warehouseman")).sendKeys("12");
			}			
			driver.findElement(By.cssSelector("#stub_page_Page5 > div.inner")).click();
			Thread.sleep(3000);
			driver.findElement(By.id("Claims_No")).click();
			driver.findElement(By.id("Hot__Works__Away_No")).click();
			driver.findElement(By.id("Radioactive__Substances_No")).click();
			driver.findElement(By.id("High__Risk__Products_Yes")).click();
			driver.findElement(By.id("High__Risk__Products_No")).click();
			driver.findElement(By.id("5Employees_No")).click();
			selenium.click("document.forms[0].elements[208]");
			selenium.waitForPageToLoad("30000");
			Thread.sleep(3000);
			custom.waitForElementPresentid(driver, "ctl00_MainContent_lnkBack", 51);
			String CaseID = driver.findElement(By.xpath("//div[@id='ctl00_MainContent_SummaryDefault']/h3/span")).getText();
			System.out.println(CaseID);
			driver.findElement(By.id("ctl00_MainContent_btnSave")).click();
			Thread.sleep(2000);
			custom.waitForElementPresentid(driver, "ctl00_MainContent_Firstname", 51);
			selenium.select("id=ctl00_MainContent_UserTitle", "label=Dr");
			driver.findElement(By.id("ctl00_MainContent_Firstname")).clear();
			driver.findElement(By.id("ctl00_MainContent_Firstname")).sendKeys("Test");
			driver.findElement(By.id("ctl00_MainContent_Surname")).clear();
			driver.findElement(By.id("ctl00_MainContent_Surname")).sendKeys("User");
			driver.findElement(By.id("ctl00_MainContent_MobileNumber")).clear();
			driver.findElement(By.id("ctl00_MainContent_MobileNumber")).sendKeys("3211");
			driver.findElement(By.id("ctl00_MainContent_Address_txtAddress1")).clear();
			driver.findElement(By.id("ctl00_MainContent_Address_txtAddress1")).sendKeys("ABD");
			driver.findElement(By.id("ctl00_MainContent_Address_txtAddress2")).clear();
			driver.findElement(By.id("ctl00_MainContent_Address_txtAddress2")).sendKeys("DBS");
			driver.findElement(By.id("ctl00_MainContent_Address_txtTown")).clear();
			driver.findElement(By.id("ctl00_MainContent_Address_txtTown")).sendKeys("Foster City, California");
			driver.findElement(By.id("ctl00_MainContent_Address_txtCounty")).clear();
			driver.findElement(By.id("ctl00_MainContent_Address_txtCounty")).sendKeys("USA");
			driver.findElement(By.id("Next")).click();
			Thread.sleep(2000);
			custom.waitForElementPresentlink(driver, "Endorsements", 51);
			driver.findElement(By.id("display_status")).click();
			selenium.select("id=change_status", "label=Quotation");
			Thread.sleep(4000);
			driver.findElement(By.linkText("Change status only")).click();
			driver.findElement(By.linkText("Endorsements")).click();
			Thread.sleep(3000);
			driver.findElement(By.linkText("Add a new Conditions question")).click();
			custom.waitForElementPresentid(driver, "Question.Text", 61);		
			driver.findElement(By.id("Question.Text")).clear();
			driver.findElement(By.id("Question.Text")).sendKeys("New Condition");
			driver.findElement(By.id("Question.Save")).click();
			Thread.sleep(3000);
			driver.findElement(By.linkText("Add a new Memorandum question")).click();
			driver.findElement(By.id("Question.Text")).clear();
			driver.findElement(By.id("Question.Text")).sendKeys("New Momo");
			custom.waitForElementPresentid(driver, "Question.DefaultValue", 61);
			driver.findElement(By.id("Question.DefaultValue")).clear();		
			driver.findElement(By.id("Question.DefaultValue")).sendKeys("Testing");
			driver.findElement(By.id("Question.Save")).click();
			Thread.sleep(3000);
			
			//Click on Matrix tab, store values in variables and CombinedLiability.properties file
			driver.findElement(By.linkText("Matrix")).click();	
			Thread.sleep(3000);
			String Totalpremium = selenium.getText("id=TotalPremiumNet_result_span");
			Totalpremium = Totalpremium.replace( '\u00A3', '*' );
			String TP = selenium.getText("id=TotalPremiumNet_result_span");
			TP = TP.replace( '\u00A3', '*' );
			
			// Execution occur when script run 1st time.
			if (Counter == 0)
			{
				str11 = Totalpremium;
				str12 = TP;
				PolicyID1=CaseID;
				write.WritePropertyFile("CombinedLiability", "PolicyID1", PolicyID1);
				write.WritePropertyFile("CombinedLiability", "TotalGP1", str11);
				write.WritePropertyFile("CombinedLiability", "TotalNP1", str12);
			}
			// Execution occur when script run 2nd time.
			if (Counter == 1)
			{
				str21=Totalpremium;
				str22=TP;
				PolicyID2=CaseID;				
				write.WritePropertyFile("CombinedLiability", "PolicyID2", PolicyID2);
				write.WritePropertyFile("CombinedLiability", "TotalGP2", str21);
				write.WritePropertyFile("CombinedLiability", "TotalNP2", str22);
				
				//Compare the stored value from the property file.
				Assert.assertEquals(str21, readp.readDatafrom("CombinedLiability", "TotalGP1"));
				Assert.assertEquals(str22, readp.readDatafrom("CombinedLiability", "TotalNP1"));				
			}
			driver.findElement(By.linkText("Logout")).click();
			
		}
	
}

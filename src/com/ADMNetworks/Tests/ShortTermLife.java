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

public class ShortTermLife {
	private WebDriver driver;
	
	CustomMethod custom  = new CustomMethod();
	ReadProperty readp = new ReadProperty();
	String timeout = readp.readApplicationFile("Timeout");
	
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
		
	
	   public void ShortTermLifetest(String Url) throws Exception{		
			
		driver.get(Url);	
		Selenium selenium = new WebDriverBackedSelenium(driver, Url);
			
		driver.findElement(By.id("GetaQuote")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Short Term Life")).click();		
		Assert.assertTrue(selenium.isTextPresent("NOTICE"));
		selenium.click("document.forms[0].elements[218]");
		Assert.assertTrue(selenium.isTextPresent("Declaration"));
		driver.findElement(By.id("DecPara2_Yes")).click();
		Assert.assertTrue(selenium.isTextPresent("Access to Medical Reports Act 1988"));
		driver.findElement(By.id("DecPara2_Yes")).click();
		selenium.click("document.forms[0].elements[218]");
		driver.findElement(By.id("AgreeMedicalReports_Yes")).click();
		selenium.click("document.forms[0].elements[218]");
		driver.findElement(By.id("AgreeDataProtection_Yes")).click();
		selenium.click("document.forms[0].elements[218]");
		Assert.assertTrue(selenium.isTextPresent("Person to be Insured"));
		driver.findElement(By.id("ProposerSex_Female")).click();
		new Select(driver.findElement(By.id("TitleDropBox"))).selectByVisibleText("Ms");
		driver.findElement(By.id("FirstNamesText")).clear();
		driver.findElement(By.id("FirstNamesText")).sendKeys("Test firstname");
		driver.findElement(By.id("LastNametext")).clear();
		driver.findElement(By.id("LastNametext")).sendKeys("test last name");
		driver.findElement(By.id("FirstNamesText")).clear();
		driver.findElement(By.id("FirstNamesText")).sendKeys("Test First name");
		driver.findElement(By.id("AddLine1")).clear();
		driver.findElement(By.id("AddLine1")).sendKeys("Test Address1");
		driver.findElement(By.id("AddLine2")).clear();
		driver.findElement(By.id("AddLine2")).sendKeys("Test Address2");
		driver.findElement(By.id("AddLine3")).clear();
		driver.findElement(By.id("AddLine3")).sendKeys("Test Address3");
		driver.findElement(By.id("ClientAddress4")).clear();
		driver.findElement(By.id("ClientAddress4")).sendKeys("Test Address4");
		driver.findElement(By.id("AddPCode")).clear();
		driver.findElement(By.id("AddPCode")).sendKeys("201301");
		new Select(driver.findElement(By.id("DoBPicker_ddlDate_First"))).selectByVisibleText("08");
		new Select(driver.findElement(By.id("DoBPicker_ddlDate_Second"))).selectByVisibleText("Sep");
		new Select(driver.findElement(By.id("DoBPicker_ddlDate_Third"))).selectByVisibleText("1986");
		driver.findElement(By.id("SmokerNonSmoker_Yes")).click();
		driver.findElement(By.id("SmokerNonSmoker_No")).click();
		driver.findElement(By.id("OccupationText")).clear();
		driver.findElement(By.id("OccupationText")).sendKeys("Service");
		driver.findElement(By.id("TeleDayText")).clear();
		driver.findElement(By.id("TeleDayText")).sendKeys("9876543210");
		driver.findElement(By.id("TeleEveText")).clear();
		driver.findElement(By.id("TeleEveText")).sendKeys("9087654321");
		driver.findElement(By.id("PrefTimeCallText")).clear();
		driver.findElement(By.id("PrefTimeCallText")).sendKeys("11.00 a.m. Saturday");
		selenium.click("document.forms[0].elements[218]");
		Assert.assertTrue(selenium.isTextPresent("Doctor Details"));
		driver.findElement(By.id("DocNametext")).clear();
		driver.findElement(By.id("DocNametext")).sendKeys("test doctor");
		driver.findElement(By.id("DocAdd1")).clear();
		driver.findElement(By.id("DocAdd1")).sendKeys("Address1");
		driver.findElement(By.id("DocAdd2")).clear();
		driver.findElement(By.id("DocAdd2")).sendKeys("Address2");
		driver.findElement(By.id("DocAdd3")).clear();
		driver.findElement(By.id("DocAdd3")).sendKeys("Address3");
		driver.findElement(By.id("DrAddress4")).clear();
		driver.findElement(By.id("DrAddress4")).sendKeys("Address4");
		driver.findElement(By.id("DocPCode")).clear();
		driver.findElement(By.id("DocPCode")).sendKeys("201301");
		driver.findElement(By.id("TeleDoc")).clear();
		driver.findElement(By.id("TeleDoc")).sendKeys("9807654321");
		driver.findElement(By.id("DrEmail")).clear();
		driver.findElement(By.id("DrEmail")).sendKeys("doctor@gmail.com");
		selenium.click("document.forms[0].elements[218]");
		Assert.assertTrue(selenium.isTextPresent("Health Questions"));
		driver.findElement(By.id("MedicineYesNo_No")).click();
		driver.findElement(By.id("MedicineYesNo_Yes")).click();
		driver.findElement(By.id("aProblemsDiseasesYesNo_No")).click();
		driver.findElement(By.id("aProblemsDiseasesYesNo_Yes")).click();
		driver.findElement(By.id("bProblemsDiseasesYesNo_No")).click();
		driver.findElement(By.id("bProblemsDiseasesYesNo_Yes")).click();
		driver.findElement(By.id("2YearsPriorYesNo_No")).click();
		driver.findElement(By.id("2YearsPriorYesNo_Yes")).click();
		driver.findElement(By.id("DeclinedYesNo_No")).click();
		driver.findElement(By.id("DeclinedYesNo_Yes")).click();
		selenium.click("document.forms[0].elements[218]");
		Assert.assertTrue(selenium.isTextPresent("The Sum to be Assured"));
		new Select(driver.findElement(By.id("InceptionDate_ddlDate_First"))).selectByVisibleText("12");
		new Select(driver.findElement(By.id("InceptionDate_ddlDate_Second"))).selectByVisibleText("Feb");
		driver.findElement(By.id("SumAssuredMoney")).clear();
		driver.findElement(By.id("SumAssuredMoney")).sendKeys("250000");
		selenium.click("document.forms[0].elements[218]");
		driver.findElement(By.id("LenderNameText")).clear();
		driver.findElement(By.id("LenderNameText")).sendKeys("test lender");
		driver.findElement(By.id("LenderAdd1")).clear();
		driver.findElement(By.id("LenderAdd1")).sendKeys("Address1");
		driver.findElement(By.id("LenderAdd2")).clear();
		driver.findElement(By.id("LenderAdd2")).sendKeys("Address2");
		driver.findElement(By.id("LenderAdd3")).clear();
		driver.findElement(By.id("LenderAdd3")).sendKeys("Address3");
		driver.findElement(By.id("LenderAddPCode")).clear();
		driver.findElement(By.id("LenderAddPCode")).sendKeys("201301");
		selenium.click("document.forms[0].elements[218]");
		Assert.assertTrue(selenium.isTextPresent("Genetic Testing Agreement"));
		driver.findElement(By.id("AgreeGeneticTesting_Yes")).click();
		selenium.click("document.forms[0].elements[218]");
		Assert.assertTrue(selenium.isTextPresent("What Happens Next"));
		selenium.click("document.forms[0].elements[218]");
		selenium.click("document.forms[0].elements[219]");
		driver.findElement(By.id("ctl00_MainContent_UserEmailAddress")).clear();
		String Email = selenium.getEval("\"test\"+new Date().getMilliseconds()+\"@gmail.com\"");		
		driver.findElement(By.id("ctl00_MainContent_UserEmailAddress")).sendKeys(Email);
	
		//selenium.type("ctl00_MainContent_UserEmailAddress", selenium.getEval("\"test\"+new Date().getMilliseconds()+\"@gmail.com\""));
		driver.findElement(By.id("ctl00_MainContent_Password")).clear();
		driver.findElement(By.id("ctl00_MainContent_Password")).sendKeys("123456");
		driver.findElement(By.id("ctl00_MainContent_ConfirmPassword")).clear();
		driver.findElement(By.id("ctl00_MainContent_ConfirmPassword")).sendKeys("123456");
		new Select(driver.findElement(By.id("ctl00_MainContent_UserTitle"))).selectByVisibleText("Miss");
		driver.findElement(By.id("ctl00_MainContent_Firstname")).clear();
		driver.findElement(By.id("ctl00_MainContent_Firstname")).sendKeys("test first");
		driver.findElement(By.id("ctl00_MainContent_Surname")).clear();
		driver.findElement(By.id("ctl00_MainContent_Surname")).sendKeys("test Sur");
		driver.findElement(By.id("Next")).click();
		Assert.assertTrue(selenium.isTextPresent("Your quote has been referred"));
		selenium.waitForPageToLoad("30000");
		Assert.assertTrue(selenium.isTextPresent("Your quotation has been referred to one of our underwriters and will be processed shortly."));
		
		//String CaseID = driver.findElement(By.cssSelector("span.policy_reference")).getText();
		driver.findElement(By.id("ctl00_MainContent_btnViewAccount")).click();
		driver.findElement(By.id("ctl00_MainContent_client_formAddress1")).clear();
		driver.findElement(By.id("ctl00_MainContent_client_formAddress1")).sendKeys("US Sec - 137, 345213");
		driver.findElement(By.id("ctl00_MainContent_client_formTownCity")).clear();
		driver.findElement(By.id("ctl00_MainContent_client_formTownCity")).sendKeys("US");
		driver.findElement(By.id("ctl00_MainContent_client_formCounty")).clear();
		driver.findElement(By.id("ctl00_MainContent_client_formCounty")).sendKeys("US");
		driver.findElement(By.id("ctl00_MainContent_client_formPostcode")).clear();
		driver.findElement(By.id("ctl00_MainContent_client_formPostcode")).sendKeys("345213");
		driver.findElement(By.id("ctl00_MainContent_client_formPhoneNo")).clear();
		driver.findElement(By.id("ctl00_MainContent_client_formPhoneNo")).sendKeys("0120-2456123");
		driver.findElement(By.id("ctl00_MainContent_client_formMobileNo")).clear();
		driver.findElement(By.id("ctl00_MainContent_client_formMobileNo")).sendKeys("9870654321");
		driver.findElement(By.id("ctl00_MainContent_client_formWebsite")).clear();
		driver.findElement(By.id("ctl00_MainContent_client_formWebsite")).sendKeys("www.test.com");
		driver.findElement(By.id("ctl00_MainContent_btnSave")).click();
		selenium.waitForPageToLoad("30000");
		driver.findElement(By.linkText("Logout")).click();
		selenium.waitForPageToLoad("30000");
	}
	
}
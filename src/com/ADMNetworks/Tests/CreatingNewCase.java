package com.ADMNetworks.Tests;

//import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverBackedSelenium;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import org.testng.Assert;
import com.ADMNetworks.Utill.CustomMethod;
import com.ADMNetworks.Utill.ReadProperty;
import com.thoughtworks.selenium.Selenium;
//import com.thoughtworks.selenium.SeleniumException;

public class CreatingNewCase {
	private WebDriver driver;
	private String baseUrl1;
	private String baseUrl2;
	CustomMethod custom  = new CustomMethod();
	ReadProperty readp = new ReadProperty();
	
	@DataProvider(name = "DP1")
    public Object[][] createData() {
	baseUrl1 = readp.readApplicationFile("URL");
	baseUrl2 = readp.readApplicationFile("URLLabs");
        Object[][] retObjArr={{baseUrl1},
                            {baseUrl2}};
        return(retObjArr);
    }
		
	@BeforeSuite
	public void setUp() throws Exception {
		driver = custom.CreateObject(driver);
		//driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	@Test(dataProvider = "DP1")
	public void testCreatingNewCase(String Url) throws Exception {
		
			//baseUrl = readp.readApplicationFile("URL");
			driver.get(Url);		
			Selenium selenium = new WebDriverBackedSelenium(driver, Url);			
			Assert.assertTrue(custom.isElementPresent(driver, By.id("AboutUs")));
			Assert.assertTrue(custom.isElementPresent(driver, By.id("GetaQuote")));
			Assert.assertTrue(custom.isElementPresent(driver, By.id("ContactUs")));
			driver.findElement(By.id("GetaQuote")).click();
			driver.findElement(By.linkText("Combined Liability")).click();
			Thread.sleep(3000);
			Assert.assertTrue(selenium.isTextPresent("Agent details"));
			driver.findElement(By.linkText("click here to sign in")).click();
			driver.findElement(By.id("Username")).clear();
			driver.findElement(By.id("Username")).sendKeys("360logica");
			driver.findElement(By.id("Password")).clear();
			driver.findElement(By.id("Password")).sendKeys("admtest");
			driver.findElement(By.name("Login")).click();
			Assert.assertTrue(custom.isElementPresent(driver, By.id("ctl00_MainContent_btnNext")));
			Assert.assertTrue(custom.isElementPresent(driver,By.id("ctl00_MainContent_lnkBack")));
			driver.findElement(By.id("ctl00_MainContent_btnNext")).click();
			Assert.assertTrue(custom.isElementPresent(driver,By.name("QuestionPage_Back")));
			Assert.assertTrue(custom.isElementPresent(driver,By.name("QuestionPage_Next")));
			Assert.assertTrue(custom.isElementPresent(driver,By.name("SubmitQuote")));
			Assert.assertTrue(selenium.isTextPresent("Statement of Fact"));
			driver.findElement(By.cssSelector("#stub_page_Page1 > div.inner")).click();
			Assert.assertTrue(selenium.isTextPresent("About You"));
			driver.findElement(By.id("FullTradingName")).clear();
			driver.findElement(By.id("FullTradingName")).sendKeys("360logica");
			selenium.select("id=InceptDate_ddlDate_Third", "label=2012");
			selenium.select("id=InceptDate_ddlDate_Third", "label=2011");
			selenium.select("id=Company__Type", "label=Limited Company");
			driver.findElement(By.id("Trading__Duration")).clear();
			driver.findElement(By.id("Trading__Duration")).sendKeys("2010");
			selenium.select("id=MainProfession", "label=Computer Engineers");
			driver.findElement(By.cssSelector("#stub_page_Page2 > div.inner")).click();
			driver.findElement(By.id("UK__Turnover")).clear();
			driver.findElement(By.id("UK__Turnover")).sendKeys("50000");
			driver.findElement(By.id("Sub__Contractor__Value")).clear();
			driver.findElement(By.id("Sub__Contractor__Value")).sendKeys("510");
			selenium.select("id=Overseas__Contracts", "label=Yes");
			selenium.select("id=ExportOverseas", "label=Yes");
			driver.findElement(By.cssSelector("#stub_page_Page3 > div.inner")).click();
			driver.findElement(By.id("Wages__Clerical__Employees")).clear();
			driver.findElement(By.id("Wages__Clerical__Employees")).sendKeys("12");
			driver.findElement(By.id("Wages__Manual__Employees")).clear();
			driver.findElement(By.id("Wages__Manual__Employees")).sendKeys("12");
			driver.findElement(By.id("Wages__Fixed__Woodworking")).clear();
			driver.findElement(By.id("Wages__Fixed__Woodworking")).sendKeys("12");
			driver.findElement(By.id("Wages__Warehouseman")).clear();
			driver.findElement(By.id("Wages__Warehouseman")).sendKeys("12");
			driver.findElement(By.cssSelector("#stub_page_Page5 > div.inner")).click();
			driver.findElement(By.id("Claims_No")).click();
			driver.findElement(By.id("Hot__Works__Away_No")).click();
			driver.findElement(By.id("Radioactive__Substances_No")).click();
			driver.findElement(By.id("High__Risk__Products_Yes")).click();
			driver.findElement(By.id("High__Risk__Products_No")).click();
			driver.findElement(By.id("5Employees_No")).click();
			selenium.click("document.forms[0].elements[208]");
			selenium.waitForPageToLoad("30000");
			/*for (int second = 0;; second++) {
				if (second >= 60) fail("timeout");
				try { if (selenium.isTextPresent("Quote submitted")) break; } catch (Exception e) {}
				Thread.sleep(1000);
			}*/
			Assert.assertTrue(selenium.isTextPresent("Your quotation reference is"));
			String CaseID = driver.findElement(By.xpath("//div[@id='ctl00_MainContent_SummaryDefault']/h3/span")).getText();
			System.out.println(CaseID);
			Assert.assertTrue(custom.isElementPresent(driver, By.id("ctl00_MainContent_lnkBack")));
			Assert.assertTrue(custom.isElementPresent(driver, By.id("ctl00_MainContent_btnSave")));
			Assert.assertTrue(custom.isElementPresent(driver, By.id("ctl00_MainContent_btnProceed")));
			driver.findElement(By.id("ctl00_MainContent_btnSave")).click();
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
			Assert.assertTrue(selenium.isTextPresent("Viewing Summary for " + CaseID));
			Assert.assertTrue(custom.isElementPresent(driver, By.linkText("Endorsements")));
			Assert.assertTrue(custom.isElementPresent(driver, By.linkText("Matrix")));
			Assert.assertTrue(custom.isElementPresent(driver, By.linkText("Documents")));
			/*for (int second = 0;; second++) {
				if (second >= 60) fail("timeout");
				try { if (selenium.isTextPresent("Claims")) break; } catch (Exception e) {}
				Thread.sleep(1000);
			}*/
			Assert.assertTrue(custom.isElementPresent(driver, By.linkText("Notes")));
			Assert.assertTrue(custom.isElementPresent(driver, By.linkText("Money")));
			Assert.assertTrue(custom.isElementPresent(driver, By.linkText("Activity")));
			Assert.assertTrue(selenium.isTextPresent("History"));
			Assert.assertTrue(custom.isElementPresent(driver, By.cssSelector("span.label")));
			Assert.assertTrue(selenium.isTextPresent("User Saved"));
			driver.findElement(By.id("display_status")).click();
			selenium.select("id=change_status", "label=Quotation");
			/*for (int second = 0;; second++) {
				if (second >= 60) fail("timeout");
				try { if (custom.isElementPresent(driver, By.linkText("Change status only"))) break; } catch (Exception e) {}
				Thread.sleep(1000);
			}*/

			// ERROR: Caught exception [ERROR: Unsupported command [isTextPresent]]
			Assert.assertTrue(custom.isElementPresent(driver, By.linkText("Change status only")));
			Assert.assertTrue(custom.isElementPresent(driver, By.cssSelector("#StatusChangeWarning > div > img")));
			Assert.assertTrue(custom.isElementPresent(driver, By.linkText("Cancel")));
			driver.findElement(By.linkText("Change status only")).click();
			Assert.assertTrue(custom.isElementPresent(driver, By.cssSelector("img[alt=\"Re-Quote\"]")));
			Assert.assertTrue(custom.isElementPresent(driver, By.cssSelector("img[alt=\"ACME\"]")));
			Assert.assertTrue(custom.isElementPresent(driver, By.cssSelector("img[alt=\"switch\"]")));
			driver.findElement(By.linkText("Endorsements")).click();
			Thread.sleep(3000);
			Assert.assertTrue(selenium.isTextPresent("Conditions"));
			driver.findElement(By.linkText("Add a new Conditions question")).click();
			this.waitForElementPresentid("Question.Text", 60);
			/*for (int second = 0;; second++) {
				if (second >= 60) fail("timeout");
				try { if (custom.isElementPresent(driver, By.id("Question.Text"))) break; } catch (Exception e) {}
				Thread.sleep(1000);
			}*/
			Assert.assertTrue(selenium.isTextPresent("Adding a Conditions item"));
			driver.findElement(By.id("Question.Text")).clear();
			driver.findElement(By.id("Question.Text")).sendKeys("Test Condition");
			driver.findElement(By.id("Question.Save")).click();
			Thread.sleep(3000);
			driver.findElement(By.linkText("Add a new Memorandum question")).click();
			driver.findElement(By.id("Question.Text")).clear();
			driver.findElement(By.id("Question.Text")).sendKeys("Test Memo");
			driver.findElement(By.id("Question.DefaultValue")).clear();
			driver.findElement(By.id("Question.DefaultValue")).sendKeys("testing Memorandum.");
			driver.findElement(By.id("Question.Save")).click();
			Thread.sleep(3000);
			driver.findElement(By.linkText("Matrix")).click();			
			this.waitForElementPresentid("TotalPremiumNet_result_span", 60);
			//Assert.assertTrue(selenium.isTextPresent("Main"));
			//String Totalpremium = driver.findElement(By.id("TotalPremiumNet_result_span")).getText();
			//String TP = driver.findElement(By.id("TotalPremium_result_span")).getText();
			driver.findElement(By.linkText("Documents")).click();
			driver.findElement(By.cssSelector("img.hand")).click();
			selenium.select("name=NewDocumentType", "label=Certificate - Combined Liability - Aviva");
			driver.findElement(By.id("ctl00_ctl00_MainContent_Grey_PolicyContent_btnSave")).click();
			driver.findElement(By.xpath("//div[@id='content']/table/tbody/tr/td/div[2]/div/div[9]/div/a")).click();
			Thread.sleep(3000);
			Assert.assertTrue(selenium.isTextPresent("Claims for this case"));
			Assert.assertTrue(selenium.isTextPresent("Excesses for this case"));
			/*driver.findElement(By.linkText("Notes")).click();
			driver.findElement(By.id("ctl00_ctl00_MainContent_Grey_PolicyContent_Img1")).click();
			this.waitForElementPresent("body.cke_show_borders", 60);
			for (int second = 0;; second++) {
				if (second >= 60) fail("timeout");
				try { if (custom.isElementPresent(driver, By.cssSelector("body.cke_show_borders"))) break; } catch (Exception e) {}
				Thread.sleep(1000);
			}

			Assert.assertTrue(selenium.isTextPresent("Add a note"));
			Thread.sleep(3000);
			//Assert.assertTrue(custom.isElementPresent(driver, By.id("NewNote")));
			//Assert.assertTrue(custom.isElementPresent(driver, By.linkText("Cancel")));
			driver.findElement(By.cssSelector("img[alt=\"close\"]")).click();*/
			driver.findElement(By.linkText("Money")).click();
			Thread.sleep(5000);
			//Assert.assertTrue(selenium.isTextPresent("Schedule"));
			//Assert.assertTrue(selenium.isTextPresent("Transactions"));
			Assert.assertTrue(custom.isElementPresent(driver, By.linkText("Take Card Payment")));
			Assert.assertTrue(custom.isElementPresent(driver, By.linkText("Record Cheque")));
			Assert.assertTrue(custom.isElementPresent(driver, By.linkText("Record Bank Payment")));
			driver.findElement(By.linkText("Take Card Payment")).click();
			this.waitForElementPresent("img[alt=\"close\"]", 60);
			driver.findElement(By.cssSelector("img[alt=\"close\"]")).click();
			driver.findElement(By.linkText("Record Cheque")).click();
			this.waitForElementPresent("img[alt=\"close\"]", 60);
			driver.findElement(By.cssSelector("img[alt=\"close\"]")).click();
			driver.findElement(By.linkText("Record Bank Payment")).click();
			this.waitForElementPresent("img[alt=\"close\"]", 60);
			driver.findElement(By.cssSelector("img[alt=\"close\"]")).click();
			driver.findElement(By.linkText("Activity")).click();
			driver.findElement(By.linkText("Logout")).click();
		}
	@AfterSuite
	public void tearDown() throws Exception {
		driver.quit();			
	}
	

	public void waitForElementPresent(String locator, int timeout) throws Exception {
		  for (int second = 0; second<200; second++) {
		       if (second >= timeout)
		           //throw new SeleniumException("Timout finding: " + locator);
		           try {
		                if (custom.isElementPresent(driver, By.cssSelector(locator)))
		                    break;
			            }
			            catch (Exception ex) {}
			            Thread.sleep(1000); 
			       } 
			 
			}
	public void waitForElementPresentid(String locator, int timeout) throws Exception {
		  for (int second = 0; second<200; second++) {
		       if (second >= timeout)
		           try {
		                if (custom.isElementPresent(driver, By.id(locator)))
		                    break;
			            }
			            catch (Exception ex) {}
			       } 
			 
			}
}

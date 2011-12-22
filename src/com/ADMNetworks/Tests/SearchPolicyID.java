package com.ADMNetworks.Tests;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverBackedSelenium;
import org.testng.annotations.*;
//import org.testng.Assert;
import com.ADMNetworks.Utill.*;
import com.thoughtworks.selenium.Selenium;


public class SearchPolicyID {
	
	private WebDriver driver;
	CustomMethod custom  = new CustomMethod();
	ReadProperty readp = new ReadProperty();
	int Counter = 0;
	
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
	
	public void testLogin(String Url) throws Exception {		
			driver.get(Url);	
			Selenium selenium = new WebDriverBackedSelenium(driver, Url);
			driver.findElement(By.linkText("Existing Users Login")).click();
			custom.waitForElementPresentid(driver, "Username",61);			
			custom.Login(driver, selenium, "Admin");						
			driver.findElement(By.id("ctl00_MainControls_formPolicyId")).sendKeys(readp.readDatafrom("CombinedLiability", "PolicyID1"));
			selenium.keyDown("id=ctl00_MainControls_formPolicyId", "\\9");
			driver.findElement(By.cssSelector("img[alt=\"GO\"]")).click();
			custom.waitForElementPresentlink(driver, "Endorsements", 51);
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
			driver.findElement(By.linkText("Matrix")).click();	
			Thread.sleep(3000);
			driver.findElement(By.linkText("Documents")).click();
			custom.waitForElementPresent(driver, "img.hand", 51);
			driver.findElement(By.cssSelector("img.hand")).click();
			Thread.sleep(2000);
			selenium.select("name=NewDocumentType", "label=New Business Invoice Payable");
			Thread.sleep(2000);
			driver.findElement(By.id("ctl00_ctl00_MainContent_Grey_PolicyContent_btnSave")).click();
			driver.findElement(By.xpath("//div[@id='content']/table/tbody/tr/td/div[2]/div/div[9]/div/a")).click();
			Thread.sleep(3000);
			driver.findElement(By.linkText("Money")).click();
			Thread.sleep(5000);
			driver.findElement(By.linkText("Take Card Payment")).click();
			Thread.sleep(4000);
			driver.findElement(By.cssSelector("img[alt=\"close\"]")).click();
			driver.findElement(By.linkText("Record Cheque")).click();
			Thread.sleep(4000);
			driver.findElement(By.cssSelector("img[alt=\"close\"]")).click();
			driver.findElement(By.linkText("Record Bank Payment")).click();
			Thread.sleep(4000);
			driver.findElement(By.cssSelector("img[alt=\"close\"]")).click();
			driver.findElement(By.linkText("Activity")).click();
			driver.findElement(By.linkText("Logout")).click();
			
	}

}

package com.ADMNetworks.Tests;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverBackedSelenium;
import org.testng.annotations.*;
import org.testng.Assert;

import com.ADMNetworks.Utill.CustomMethod;
import com.ADMNetworks.Utill.ReadProperty;
import com.thoughtworks.selenium.Selenium;

public class CasesTab {
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
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@Test(dataProvider = "DP1")
	public void testCasesTab(String Url) throws Exception {		
		//baseUrl = readp.readApplicationFile("URL");
		driver.get(Url);		
		Selenium selenium = new WebDriverBackedSelenium(driver, Url);		
		driver.findElement(By.linkText("Existing Users Login")).click();
		custom.Login(driver,selenium, "Admin");		
		Assert.assertTrue(selenium.isTextPresent("Search for Cases"));
		driver.findElement(By.id("Cases")).click();		
		selenium.select("id=ctl00_MainContent_formScheme", "label=Combined Liability");
		selenium.select("id=ctl00_MainContent_formStatus", "label=Every Status");
		Assert.assertTrue(selenium.isTextPresent("Search for Cases"));
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("img[alt=\"View\"]")).click();		
		Assert.assertTrue(selenium.isElementPresent("css=img.ViewPolicy_Save"));
		driver.findElement(By.linkText("Endorsements")).click();		
		Assert.assertTrue(selenium.isTextPresent("Conditions"));
		Assert.assertTrue(selenium.isTextPresent("Memorandum"));
		Assert.assertTrue(selenium.isElementPresent("css=img.ViewPolicy_Save"));
		driver.findElement(By.linkText("Add a new Conditions question")).click();
		Thread.sleep(3000);
		Assert.assertTrue(selenium.isTextPresent("Adding a Conditions item"));
		driver.findElement(By.name("Cancel")).click();
		driver.findElement(By.linkText("Matrix")).click();
		driver.findElement(By.linkText("Documents")).click();
		Assert.assertTrue(custom.isElementPresent(driver, By.cssSelector("img.hand")));
		driver.findElement(By.cssSelector("img.hand")).click();
		Thread.sleep(3000);
		Assert.assertTrue(selenium.isTextPresent("Create a new document"));
		driver.findElement(By.linkText("Cancel")).click();
		driver.findElement(By.xpath("//div[@id='content']/table/tbody/tr/td/div[2]/div/div[9]/div/a")).click();		
		Assert.assertTrue(selenium.isTextPresent("Claims for this case"));
		Assert.assertTrue(selenium.isTextPresent("Excesses for this case"));
		driver.findElement(By.id("ctl00_ctl00_MainContent_Grey_PolicyContent_imgCreateNew")).click();		
		Assert.assertTrue(selenium.isTextPresent("Create a new claim for Policy"));		
		driver.findElement(By.id("ctl00_ctl00_MainContent_Grey_PolicyContent_imgBack")).click();
		driver.findElement(By.linkText("Notes")).click();		
		driver.findElement(By.id("ctl00_ctl00_MainContent_Grey_PolicyContent_Img1")).click();
		Thread.sleep(3000);
		Assert.assertTrue(selenium.isTextPresent("Add a note"));
		driver.findElement(By.linkText("Cancel")).click();
		driver.findElement(By.linkText("Money")).click();		
		Assert.assertTrue(selenium.isTextPresent("Transactions"));
		driver.findElement(By.linkText("Logout")).click();
	}
	@AfterSuite
	public void tearDown() throws Exception {
		driver.quit();	
		
	}	
	
}

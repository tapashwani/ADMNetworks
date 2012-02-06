package com.ADMNetworks.Tests;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverBackedSelenium;
import org.testng.Assert;
import org.testng.annotations.*;
import com.ADMNetworks.Utill.*;
import com.thoughtworks.selenium.Selenium;

public class SearchPolicyID_MHR {

	private WebDriver driver;
	CustomMethod custom  = new CustomMethod();
	ReadProperty readp = new ReadProperty();
	int Counter = 0;
	String str11="";
	String str12="";
	
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
	
	public void testSearchPolicyID_MHR(String Url) throws Exception{
		SearchPolicyID_MHRtest(driver,Url,Counter );
		Counter= Counter+1;
	}
	
	public void SearchPolicyID_MHRtest(WebDriver driver, String Url,int Counter) throws Exception {		
			driver.get(Url);	
			Selenium selenium = new WebDriverBackedSelenium(driver, Url);
			driver.findElement(By.linkText("Existing Users Login")).click();
			custom.waitForElementPresentid(driver, "Username",61);			
			custom.Login(driver, selenium, "Admin");	
			if (Counter==0){
			driver.findElement(By.id("ctl00_MainControls_formPolicyId")).sendKeys(readp.readDatafrom("MotorHireAndReward", "PolicyID1"));
			selenium.keyDown("id=ctl00_MainControls_formPolicyId", "\\9");
			driver.findElement(By.cssSelector("img[alt=\"GO\"]")).click();
			}
			if (Counter==1){
				driver.findElement(By.id("ctl00_MainControls_formPolicyId")).sendKeys(readp.readDatafrom("MotorHireAndReward", "PolicyID2"));
				selenium.keyDown("id=ctl00_MainControls_formPolicyId", "\\9");
				driver.findElement(By.cssSelector("img[alt=\"GO\"]")).click();
			}
			
			custom.waitForElementPresentlink(driver, "Endorsements", 51);
			//driver.findElement(By.linkText("Endorsements")).click();
			//Thread.sleep(3000);
			driver.findElement(By.linkText("Matrix")).click();	
			Thread.sleep(3000);
			//stored value  at Matrix
			String Basic144 = driver.findElement(By.id("Basic_144_result_span")).getText();
			Basic144 = Basic144.replace( '\u00A3', '*' );
			str11 = Basic144;
			String Basic145 = driver.findElement(By.id("Basic_145_result_span")).getText();
			Basic145 = Basic145.replace( '\u00A3', '*' );
			str12 = Basic145;
			String TPNet = driver.findElement(By.id("TotalPremiumNet_result_span")).getText();
			TPNet = TPNet.replace( '\u00A3', '*' );
			
			//Compare the stored value from the property file.
			if(Counter==0){
			Assert.assertEquals(str11, readp.readDatafrom("MotorHireAndReward", "TotalGP1"));
			Assert.assertEquals(str12, readp.readDatafrom("MotorHireAndReward", "TotalNP1"));	
			Assert.assertEquals(TPNet, readp.readDatafrom("MotorHireAndReward", "TPNet1"));
			}
			if(Counter==1){
				Assert.assertEquals(str11, readp.readDatafrom("MotorHireAndReward", "TotalGP2"));
				Assert.assertEquals(str12, readp.readDatafrom("MotorHireAndReward", "TotalNP2"));	
				Assert.assertEquals(TPNet, readp.readDatafrom("MotorHireAndReward", "TPNet2"));
				}
			driver.findElement(By.linkText("Logout")).click();
	}
	
}

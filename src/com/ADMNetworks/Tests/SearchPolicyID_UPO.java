package com.ADMNetworks.Tests;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverBackedSelenium;
import org.testng.Assert;
import org.testng.annotations.*;
import com.ADMNetworks.Utill.CustomMethod;
import com.ADMNetworks.Utill.ReadProperty;
import com.thoughtworks.selenium.Selenium;

public class SearchPolicyID_UPO {
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
	public void testSearchPolicyID_UPO(String Url) throws Exception {
		SearchPolicyID_UPOtest(driver, Url,Counter);
		Counter=Counter+1;
	}
	
	public void SearchPolicyID_UPOtest(WebDriver driver,String Url,int Counter) throws Exception {		
			driver.get(Url);	
			Selenium selenium = new WebDriverBackedSelenium(driver, Url);
			driver.findElement(By.linkText("Existing Users Login")).click();
			custom.waitForElementPresentid(driver, "Username",61);			
			custom.Login(driver, selenium, "Admin");	
			if (Counter==0){
				driver.findElement(By.id("ctl00_MainControls_formPolicyId")).sendKeys(readp.readDatafrom("UnoccupiedPropertyOwner", "PolicyID1"));
				selenium.keyDown("id=ctl00_MainControls_formPolicyId", "\\9");
				driver.findElement(By.cssSelector("img[alt=\"GO\"]")).click();
			}
			if (Counter==1){
				driver.findElement(By.id("ctl00_MainControls_formPolicyId")).sendKeys(readp.readDatafrom("UnoccupiedPropertyOwner", "PolicyID2"));
				selenium.keyDown("id=ctl00_MainControls_formPolicyId", "\\9");
				driver.findElement(By.cssSelector("img[alt=\"GO\"]")).click();
			}
			
			custom.waitForElementPresentlink(driver, "Endorsements", 51);
			//driver.findElement(By.linkText("Endorsements")).click();
			//Thread.sleep(3000);
			driver.findElement(By.linkText("Matrix")).click();	
			Thread.sleep(3000);
			//stored value  at Matrix
			String Basic164 = driver.findElement(By.id("Basic_164_result_span")).getText();
			Basic164 = Basic164.replace( '\u00A3', '*' );
			str11 = Basic164;
			String Basic165 = driver.findElement(By.id("Basic_165_result_span")).getText();
			Basic165 = Basic165.replace( '\u00A3', '*' );
			str12 = Basic165;
			String TPNet = driver.findElement(By.id("TotalPremiumNet_result_span")).getText();
			TPNet = TPNet.replace( '\u00A3', '*' );
			
			//Compare the stored value from the property file.
			if(Counter==0){
			Assert.assertEquals(str11, readp.readDatafrom("UnoccupiedPropertyOwner", "TotalGP1"));
			Assert.assertEquals(str12, readp.readDatafrom("UnoccupiedPropertyOwner", "TotalNP1"));	
			Assert.assertEquals(TPNet, readp.readDatafrom("UnoccupiedPropertyOwner", "TPNet1"));
			}
			if(Counter==1){
				Assert.assertEquals(str11, readp.readDatafrom("UnoccupiedPropertyOwner", "TotalGP2"));
				Assert.assertEquals(str12, readp.readDatafrom("UnoccupiedPropertyOwner", "TotalNP2"));	
				Assert.assertEquals(TPNet, readp.readDatafrom("UnoccupiedPropertyOwner", "TPNet2"));
				}
			driver.findElement(By.linkText("Logout")).click();
	}

}

package com.ADMNetworks.Tests;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverBackedSelenium;
import org.testng.Assert;
import org.testng.annotations.*;
//import org.testng.Assert;
import com.ADMNetworks.Utill.*;
import com.thoughtworks.selenium.Selenium;


public class SearchPolicyID_CL {
	
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
	public void testSearchPolicyID_CL(String Url) throws Exception {
		
		SearchPolicyID_CLtest(driver,Url, Counter);
		Counter = Counter+1;
	}	
	public void SearchPolicyID_CLtest(WebDriver driver, String Url, int Counter) throws Exception {		
			driver.get(Url);	
			Selenium selenium = new WebDriverBackedSelenium(driver, Url);
			driver.findElement(By.linkText("Existing Users Login")).click();
			custom.waitForElementPresentid(driver, "Username",61);			
			custom.Login(driver, selenium, "Admin");
			if (Counter==0){
			driver.findElement(By.id("ctl00_MainControls_formPolicyId")).sendKeys(readp.readDatafrom("CombinedLiability", "PolicyID1"));
			selenium.keyDown("id=ctl00_MainControls_formPolicyId", "\\9");
			driver.findElement(By.cssSelector("img[alt=\"GO\"]")).click();
			}
			if (Counter==1){
				driver.findElement(By.id("ctl00_MainControls_formPolicyId")).sendKeys(readp.readDatafrom("CombinedLiability", "PolicyID2"));
				selenium.keyDown("id=ctl00_MainControls_formPolicyId", "\\9");
				driver.findElement(By.cssSelector("img[alt=\"GO\"]")).click();
				//if(PolicyID2.equals("NA")){
					//driver.findElement(By.linkText("Logout")).click();	
				//}
			}
			
			custom.waitForElementPresentlink(driver, "Endorsements", 51);
			//driver.findElement(By.linkText("Endorsements")).click();
			//Thread.sleep(3000);
			driver.findElement(By.linkText("Matrix")).click();	
			Thread.sleep(3000);
			//stored value  at Matrix
			String Basic168 = driver.findElement(By.id("Basic_168_result_span")).getText();
			Basic168 = Basic168.replace( '\u00A3', '*' );
			str11 = Basic168;
			String Basic169 = driver.findElement(By.id("Basic_169_result_span")).getText();
			Basic169 = Basic169.replace( '\u00A3', '*' );
			str12 = Basic169;
			String TPNet = driver.findElement(By.id("TotalPremiumNet_result_span")).getText();
			TPNet = TPNet.replace( '\u00A3', '*' );
			
			//Compare the stored value from the property file.
			if(Counter==0){
			Assert.assertEquals(str11, readp.readDatafrom("CombinedLiability", "TotalGP1"));
			Assert.assertEquals(str12, readp.readDatafrom("CombinedLiability", "TotalNP1"));	
			Assert.assertEquals(TPNet, readp.readDatafrom("CombinedLiability", "TPNet1"));
			}
			if(Counter==1){
				Assert.assertEquals(str11, readp.readDatafrom("CombinedLiability", "TotalGP2"));
				Assert.assertEquals(str12, readp.readDatafrom("CombinedLiability", "TotalNP2"));	
				Assert.assertEquals(TPNet, readp.readDatafrom("CombinedLiability", "TPNet2"));
				}
			
			driver.findElement(By.linkText("Logout")).click();
	}
}

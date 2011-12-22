package com.ADMNetworks.Tests;

import java.util.concurrent.TimeUnit;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebDriverBackedSelenium;
import org.testng.annotations.*;
//import org.testng.Assert;
import com.ADMNetworks.Utill.CustomMethod;
import com.ADMNetworks.Utill.ReadProperty;
import com.ADMNetworks.Utill.WritePropertiesFile;
//import com.thoughtworks.selenium.Selenium;


public class TestChoose {
	public WebDriver driver;
	CustomMethod custom  = new CustomMethod();
	ReadProperty readp = new ReadProperty();
	int Counter = 0;
	String str11="";
	String str12="";
	String str21="";
	String str22="";
	String PolicyID1,PolicyID2;
	WritePropertiesFile write = new WritePropertiesFile();
	
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
	public void testTestChoose(String Url) throws Exception{
		
		String scheme = custom.getScheme();
		if(scheme.equals("RestaurantCombined")){
			RestaurantCombined RC = new RestaurantCombined();
			RC.RestaurantCombinedtest(driver, Url, Counter);			
		}
		if(scheme.equals("CombinedLiability")){
			CombinedLiability CL = new CombinedLiability();
			CL.CombinedLiabilitytest(driver, Url, Counter);			
		}
		if(scheme.equals("HotelCombined")){
			HotelCombined HC = new HotelCombined();
			HC.HotelCombinedtest(driver, Url, Counter);			
		}
		if(scheme.equals("MotorHireAndReward")){
			MotorHireAndReward MHAR = new MotorHireAndReward();
			MHAR.MotorHireAndRewardtest(driver,Url, Counter);			
		}		
		if(scheme.equals("ResidentialLandlords")){
			ResidentialLandlords RL = new ResidentialLandlords();
			RL.ResidentialLandlordstest(driver,Url, Counter);			
		}
		
		Counter=Counter+1;
	}

}

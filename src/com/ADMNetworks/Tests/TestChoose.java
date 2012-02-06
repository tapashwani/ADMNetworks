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
	private int Counter = 0;
	String str11="";
	String str12="";
	String str21="";
	String str22="";
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
			RC.RestaurantCombinedtest(driver, Url,Counter);			
		}
		if(scheme.equals("CombinedLiability")){
			CombinedLiability CL = new CombinedLiability();
			CL.CombinedLiabilitytest(driver, Url,Counter);			
		}
		if(scheme.equals("HotelCombined")){
			HotelCombined HC = new HotelCombined();
			HC.HotelCombinedtest(driver, Url,Counter);			
		}
		if(scheme.equals("MotorHireAndReward")){
			MotorHireAndReward MHAR = new MotorHireAndReward();
			MHAR.MotorHireAndRewardtest(driver,Url,Counter);			
		}		
		if(scheme.equals("ResidentialLandlords")){
			ResidentialLandlords RL = new ResidentialLandlords();
			RL.ResidentialLandlordstest(driver,Url,Counter);			
		}
		if(scheme.equals("RestaurantCombinedNew")){
			RestaurantCombinedNew RCN = new RestaurantCombinedNew();
			RCN.RestaurantCombinedNewtest(driver,Url,Counter);			
		}
		
		if(scheme.equals("CombinedLiabilityNew")){
			CombinedLiabilityNew CLN = new CombinedLiabilityNew();
			CLN.CombinedLiabilitytNewtest(driver,Url,Counter);			
		}
		if(scheme.equals("HotelCombinedNew")){
			HotelCombinedNew HCN = new HotelCombinedNew();
			HCN.HotelCombinedNewtest(driver,Url,Counter);			
		}
		if(scheme.equals("MotorHireAndRewardNew")){
			MotorHireAndRewardNew MHN = new MotorHireAndRewardNew();
			MHN.MotorHireAndRewardNewtest(driver,Url,Counter);			
		}
		if(scheme.equals("ResidentialLandlorsdNew")){
			ResidentialLandlordsNew RLN = new ResidentialLandlordsNew();
			RLN.ResidentialLandlordsNewtest(driver,Url,Counter);			
		}		
		if(scheme.equals("ShortTermLife")){
			ShortTermLife STL = new ShortTermLife();
			STL.testshorttermlife(driver,Url,Counter);			
		}
		if(scheme.equals("UnoccupiedPropertyOwners")){
			UnoccupiedPropertyOwners UPO = new UnoccupiedPropertyOwners();
			UPO.UnoccupiedPropertyOwnerstest(driver,Url,Counter);			
		}
		if(scheme.equals("UnoccupiedPropertyOwnersNew")){
			UnoccupiedPropertyOwnersNew UPO = new UnoccupiedPropertyOwnersNew();
			UPO.UnoccupiedPropertyOwnersNewtest(driver,Url,Counter);			
		}
		if(scheme.equals("Login")){
			Login log = new Login();
			log.logintest(driver,Url);			
		}
		if(scheme.equals("CasesTab")){
			CasesTab CT = new CasesTab();
			CT.CasesTabtest(driver,Url);			
		}
		if(scheme.equals("SearchPolicyID_CL")){
			SearchPolicyID_CL SCL = new SearchPolicyID_CL ();
			SCL.SearchPolicyID_CLtest(driver,Url, Counter);
		}
		if(scheme.equals("SearchPolicyID_HC")){
			SearchPolicyID_HC SHC = new SearchPolicyID_HC ();
			SHC.SearchPolicyID_HCtest(driver,Url,Counter);
		}
		if(scheme.equals("SearchPolicyID_MHR")){
			SearchPolicyID_MHR SMHR = new SearchPolicyID_MHR ();
			SMHR.SearchPolicyID_MHRtest(driver,Url, Counter);
		}
		if(scheme.equals("SearchPolicyID_RC")){
			SearchPolicyID_RC SRC = new SearchPolicyID_RC ();
			SRC.SearchPolicyID_RCtest(driver,Url, Counter);
		}
		if(scheme.equals("SearchPolicyID_RL")){
			SearchPolicyID_RL SRL = new SearchPolicyID_RL ();
			SRL.SearchPolicyID_RLtest(driver,Url, Counter);
		}
		if(scheme.equals("SearchPolicyID_UPO")){
			SearchPolicyID_UPO SUPO = new SearchPolicyID_UPO ();
			SUPO.SearchPolicyID_UPOtest(driver,Url, Counter);
		}
	Counter=Counter+1;
	}
}

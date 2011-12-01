package com.ADMNetworks.Utill;

import org.openqa.selenium.WebDriver;
import java.io.File;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
//import org.testng.Assert;
import com.ADMNetworks.Utill.ReadProperty;
import com.thoughtworks.selenium.Selenium;

public class CustomMethod {
	
	ReadProperty readp;
	public WebDriver CreateObject(WebDriver driver)
	{
		readp = new ReadProperty();
		String driver_type = readp.readApplicationFile("BROWSER");
				
		if(driver_type.equals("ff") || driver_type.equals("ie")|| driver_type.equals("ch"))
		{
			if(driver_type.equals("ff")){
				driver = new FirefoxDriver();
			}
			if(driver_type.equals("ie")){
				driver = new InternetExplorerDriver(); 
			}
			
			if(driver_type.equals("ch")){
				    DesiredCapabilities dc = DesiredCapabilities.chrome();
				    String[] switches = { "--ignore-certificate-errors","--disable-popup-blocking","--disable-translate"};
				    dc.setCapability("chrome.switches", Arrays.asList(switches));    
				    System.setProperty("webdriver.chrome.driver",readp.readApplicationFile("ChromeDriverPath") );
				    driver = new ChromeDriver(dc); 
			}	
		}
		else{
			System.out.println("Please set browser type in Application.properties file");
			System.exit(0);
		}
		
		return driver;
		
	}
	public String getPath(){
		String path ="";		
		File file = new File("");
		String absolutePathOfFirstFile = file.getAbsolutePath();
		path = absolutePathOfFirstFile.replaceAll("\\\\+", "/");		
		return path;
	}
	
	public boolean isElementPresent(WebDriver driver, By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
	
	public void Login(WebDriver driver, Selenium selenium, String role) throws InterruptedException
	{
		readp = new ReadProperty();
		Thread.sleep(10000);
		//Assert.assertTrue(selenium.isTextPresent("Username"));
		//Assert.assertTrue(selenium.isTextPresent("Password"));
		driver.findElement(By.id("Username")).clear();
		driver.findElement(By.id("Username")).sendKeys(readp.readLoginFile(role+"User"));
		driver.findElement(By.id("Password")).clear();
		driver.findElement(By.id("Password")).sendKeys(readp.readLoginFile(role+"Password"));
		driver.findElement(By.name("Login")).click();
	}
	
	
	 public int getRandomInteger(int aStart, int aEnd, Random aRandom){
		    if ( aStart > aEnd ) {
		      throw new IllegalArgumentException("Start cannot exceed End.");
		    }
		    //get the range, casting to long to avoid overflow problems
		    long range = (long)aEnd - (long)aStart + 1;
		    // compute a fraction of the range, 0 <= frac < range
		    long fraction = (long)(range * aRandom.nextDouble());
		    int randomNumber =  (int)(fraction + aStart);    
		    return randomNumber;
	 }
	 
	 public void waitForElementPresent(WebDriver driver, String locator, int timeout) throws Exception {
		  for (int second = 0; second<200; second++) {
		       if (second >= timeout)
		           //throw new SeleniumException("Timout finding: " + locator);
		           try {
		                if (this.isElementPresent(driver, By.cssSelector(locator)))
		                    break;
			            }
			            catch (Exception ex) {}
			            Thread.sleep(1000); 
			       } 
			 
			}
	public void waitForElementPresentid(WebDriver driver, String locator, int timeout) throws Exception {
		  for (int second = 0; second<200; second++) {
		       if (second >= timeout)
		           try {
		                if (this.isElementPresent(driver, By.id(locator)))
		                    break;
			            }
			            catch (Exception ex) {}
			       } 
			 
			}
	public void waitForElementPresentlink(WebDriver driver, String locator, int timeout) throws Exception {
		  for (int second = 0; second<200; second++) {
		       if (second >= timeout)
		           try {
		                if (this.isElementPresent(driver, By.linkText(locator)))
		                    break;
			            }
			            catch (Exception ex) {}
			       } 
			 
			}
	public void waitForElementPresentname(WebDriver driver, String locator, int timeout) throws Exception {
		  for (int second = 0; second<200; second++) {
		       if (second >= timeout)
		           try {
		                if (this.isElementPresent(driver, By.name(locator)))
		                    break;
			            }
			            catch (Exception ex) {}
			       } 
			 
			}
	
	public Object[][] GetDataprovider()	  {
	    ReadProperty readp = new ReadProperty();
	    String RunMod= readp.readApplicationFile("RunMod");   
	    String baseUrl1, baseUrl2;
	    baseUrl1 = readp.readApplicationFile("URL");
	    baseUrl2 = readp.readApplicationFile("URLLabs");
	   
		   if(RunMod.equals("0")){     
			    Object[][] retObjArr={{baseUrl1}};
			    return(retObjArr);
			   }
		   if(RunMod.equals("1")){    
			    Object[][] retObjArr={{baseUrl2}};
			    return(retObjArr);
			   }
		   if(RunMod.equals("2")){   
			    Object[][] retObjArr={{baseUrl1},{baseUrl2}};
			    return(retObjArr);
			   }
		   else{
			    System.out.println("Please set value RunMod value in application.properties file");
			    return(null);
			   }
	
     }
}

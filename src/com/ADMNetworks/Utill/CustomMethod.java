package com.ADMNetworks.Utill;

import org.openqa.selenium.WebDriver;
import java.io.File;
import java.util.NoSuchElementException;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
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
				System.setProperty("webdriver.chrome.driver", readp.readApplicationFile("ChromeDriverPath"));
				driver = new ChromeDriver(); 
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
	
}

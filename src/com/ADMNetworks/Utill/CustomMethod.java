package com.ADMNetworks.Utill;

import org.openqa.selenium.WebDriver;
import java.io.File;
import java.util.NoSuchElementException;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import com.ADMNetworks.Utill.ReadProperty;

public class CustomMethod {
	
	ReadProperty readp;
	public WebDriver CreateObject(WebDriver driver)
	{
		readp = new ReadProperty();
		String driver_type = readp.readApplicationFile("BROWSER");
				System.out.println(driver_type);
		if(driver_type.equals("ff") || driver_type.equals("ie"))
		{
			if(driver_type.equals("ff")){
				driver = new FirefoxDriver();
			}
			if(driver_type.equals("ie")){
				driver = new InternetExplorerDriver(); 
			}			
		}
		else{
			System.out.println("Please set browser type in Application.properties file");
			driver = new FirefoxDriver();
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
	
	public void Login(WebDriver driver, String role) throws InterruptedException
	{
		readp = new ReadProperty();
		String email = driver.findElement(By.cssSelector("div.loginConent_one")).getText();
		String pass = driver.findElement(By.cssSelector("div.loginConent > div.loginConent > div.loginConent_one")).getText();
		Assert.assertEquals("Email ID:", email);
		Assert.assertEquals("Password:", pass);
		driver.findElement(By.name("userName")).clear();
		driver.findElement(By.name("userName")).sendKeys(readp.readLoginFile(role+"User"));
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys(readp.readLoginFile(role+"Password"));
		driver.findElement(By.cssSelector("input[type=\"image\"]")).click();
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

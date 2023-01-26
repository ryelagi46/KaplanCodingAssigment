package com.utility;

import java.io.File;
import java.sql.Driver;
import java.util.Set;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.google.common.io.Files;

public class Utility {
	
	

	 public void captureScreenshot(WebDriver driver,String testName) throws Exception {
	    	//Step 1. TypeCast TakesScreenshot with driver object
	    	TakesScreenshot ts=(TakesScreenshot) driver;
	    	//Step 2. call getScreenshotAs() method to create image file
	    	File src = ts.getScreenshotAs(OutputType.FILE);
	    	// Step 3. Save image file at particular location
	    	File dest=new File(System.getProperty("user.dir")+"\\Screenshot\\"+testName+".png");
	    	//Step 4. Copy image file to destination
	    	Files.copy(src, dest);
	    	
	    	
	    }
	 
	
	 
	  public void switchToWindow(WebDriver driver) {
	   Set<String> windowsIds = driver.getWindowHandles();
	   for(String windowId:windowsIds) {
		   driver.switchTo().window(windowId);
		   
	   }
	   }
	  
	  public void handleAltertPopup(WebDriver driver) {
		  try {
			  driver.switchTo().alert().accept();
		} catch (NoAlertPresentException e) {
			// TODO: handle exception
			//System.out.println(e.getMessage());
		}
		   
		   
	   }
	  public void sendTextIntoAlertPopup(WebDriver driver,String name) {
		  try {
			  driver.switchTo().alert().sendKeys(name);
		} catch (NoAlertPresentException e) {
		   //System.out.println(e.getMessage());
		
		}
		  
	 }
	  
	  
	  
	  
}

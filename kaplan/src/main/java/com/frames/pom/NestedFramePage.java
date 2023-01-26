package com.frames.pom;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NestedFramePage {

	@FindBy(xpath = "//iframe[@id='frame1']")
	WebElement childframe;

	public NestedFramePage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	public void getChileFrameText(WebDriver driver) throws Exception {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		WebElement childFrame1 = (WebElement)js.executeScript("return document.querySelector('body > p')");
		driver.switchTo().frame(childFrame1);
		Thread.sleep(3000);
		String childFrameText= (String)js.executeScript("return document.querySelector('body > p')");
		System.out.println(childFrameText);
	}

}

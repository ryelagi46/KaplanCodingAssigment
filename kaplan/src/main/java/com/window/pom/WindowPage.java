package com.window.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WindowPage {

	@FindBy(xpath = "//button[@id='windowButton']")
	WebElement newWindow;
	@FindBy(xpath = "//h1[@id='sampleHeading']")
	WebElement windowText;

	public WindowPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	public void clickOnNewWindowBtn() {
		try {
			newWindow.click();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	public String getTextInNewWindow() {
		return windowText.getText();
	}
}

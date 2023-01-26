package com.alert.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertPage {

	@FindBy(xpath = "//button[@id='alertButton']")
	WebElement alertButton;
	@FindBy(xpath = "//button[@id='timerAlertButton']")
	WebElement timerAlertButton;
	@FindBy(xpath = "//button[@id='confirmButton']")
	WebElement confirmButton;
	@FindBy(xpath = "//button[@id='promtButton']")
	WebElement promtButton;

	public AlertPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	public void clickAlterButton() {
		click(alertButton);

	}

	public void timerAlertButton() {
		click(timerAlertButton);

	}

	public void confirmButton() {
		click(confirmButton);

	}

	public void promtButton() {
		click(promtButton);

	}

	public void click(WebElement element) {
		try {
			element.click();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}

package com.draganddrop.pom;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DragAndDropPage {

	@FindBy(xpath = "//a[@id='droppableExample-tab-accept']")
	WebElement acceptbtn;
	@FindBy(xpath = "//div[@id='notAcceptable']")
	WebElement notAcceptable;
	@FindBy(xpath = "//div[@class='accept-drop-container']//div[@id='droppable']")
	WebElement dropHere;

	public DragAndDropPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}
	
	public void clickOnAcceptBtn() {
		acceptbtn.click();
	}
	
	public void dragElement(WebDriver driver) {
		try {
			Actions action=new Actions(driver);
		   action.dragAndDrop(notAcceptable, dropHere).perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}

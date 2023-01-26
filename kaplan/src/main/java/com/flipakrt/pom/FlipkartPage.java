package com.flipakrt.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlipkartPage {
	
	@FindBy(xpath="//div[text()='Fashion']") WebElement fashionSection;
	@FindBy(xpath="//div[@class='_2IjXr8']//div[@class='_3XS_gI _7qr1OC']//a[text()='Kids']") WebElement kids;
	@FindBy(xpath="//a[text()='Boys & Girls Jeans']") WebElement boysGirlsJeans;
	@FindBy(xpath="//div[@class='_5THWM1']//div[text()='Price -- Low to High']") WebElement lowPrice;
	@FindBy(xpath="//a[text()='Baby Boys Slim Mid Rise Blue Jeans']") WebElement item;
	@FindBy(xpath="//button[@class='_2KpZ6l _2doB4z']") WebElement closePopup;
	public FlipkartPage(WebDriver driver) {
		
		PageFactory.initElements(driver,this);
	}
	
	public void mouseHoverOnFashion(WebDriver driver) {
		 Actions action=new Actions(driver);
		 action.moveToElement(fashionSection).perform();
		 action.moveToElement(kids).perform();
		 action.moveToElement(boysGirlsJeans).click().perform();
	}
	
	public void clickOnLowPrice() {
		lowPrice.click();
	}
	
	public void clickOnItem() {
		item.click();
	}
	
	public void clickPopup() {
		closePopup.click();
	}
	
	
	
	
	
	
	
	

}

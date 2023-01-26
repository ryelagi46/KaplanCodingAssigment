package com.flipakrt.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	@FindBy(xpath="//span[@class='_2-ut7f _1WpvJ7']") WebElement priceInCheckout;
	@FindBy(xpath="//a[@class='_2Kn22P gBNbID']") WebElement itemNameInCheckout;
	
	public CartPage(WebDriver driver) {
		
		PageFactory.initElements(driver,this);
	}
	
	public String getPriceInCheckout() {
		return priceInCheckout.getText();
	}
	
	public String getItemNameInCheckout() {
		return itemNameInCheckout.getText();
	}
	
	
}
package com.flipakrt.pom;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ItemPage {
	
	@FindBy(xpath="//div[@class='_30jeq3 _16Jk6d']']") WebElement itemPrice;
	@FindBy(xpath="//span[@class='B_NuCI']") WebElement itemName;
	@FindBy(xpath="//input[@class='cfnctZ']") WebElement pincode;
	@FindBy(xpath="//span[@id='Size']/following-sibling::div//li[@class='_3V2wfe _31hAvz']") List<WebElement> itemSizes;
	@FindBy(xpath="//button[@class='_2KpZ6l _2U9uOA _3v1-ww']") WebElement addtocart;
	
	
	public ItemPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public String getItemPrice() {
		String actulItemPrice = itemPrice.getText();
		return actulItemPrice;
	}
	
	public String getItemName() {
		String actulItemName = itemName.getText();
		return actulItemName;
	}
	
	public void enterPincode(String cityPincode) {
		pincode.sendKeys(cityPincode,Keys.ENTER);
	}
	
	public void selectItemSize() {
		try {
			for(WebElement itemSize:itemSizes) {
				Thread.sleep(3000);
				boolean	status=itemSize.isDisplayed();
				   if(status==true) {
					   Thread.sleep(3000);
					   itemSize.click();
					   break;
				   }
				   else {
					   System.out.println("Item Size is Not Available");
				   }
					
					
				}

		} catch (Exception e) {
			   
		}
	}
	
	public void enterOnAddToCart() {
		try {
			addtocart.click();
		} catch (Exception e) {
			addtocart.click();
		}
		
	}
	
	
	
}

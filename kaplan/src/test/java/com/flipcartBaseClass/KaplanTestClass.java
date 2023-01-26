package com.flipcartBaseClass;

import java.io.FileReader;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.alert.pom.AlertPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.draganddrop.pom.DragAndDropPage;
import com.flipakrt.pom.CartPage;
import com.flipakrt.pom.FlipkartPage;
import com.flipakrt.pom.ItemPage;
import com.frames.pom.NestedFramePage;
import com.utility.Utility;
import com.window.pom.WindowPage;

import dev.failsafe.Timeout;

public class KaplanTestClass extends Base {

	// ExtentReports extent = new ExtentReports();
	// ExtentSparkReporter spark = new ExtentSparkReporter("ExtentReports.html");
	public FileReader reader = null;

	@Test(priority = 1)

	public void verifyItemPriceAndName() throws Throwable {
		confiProp = new Properties();
		reader = new FileReader(".\\src\\test\\resources\\ConfigProperties.properties");
		confiProp.load(reader);
		driver.get(confiProp.getProperty("flipkartUrl"));
		fp = new FlipkartPage(driver);
		ut = new Utility();
		ip = new ItemPage(driver);
		fp.clickPopup();
		fp.mouseHoverOnFashion(driver);
		fp.clickOnLowPrice();
		Thread.sleep(3000);
		fp.clickOnItem();
		ut.switchToWindow(driver);
		ip.enterPincode("560064");
		ip.selectItemSize();
		ip.enterOnAddToCart();
		cp = new CartPage(driver);

		String actItemName = cp.getItemNameInCheckout();
		String expItemName = ip.getItemName();
		String expItemPrice = ip.getItemPrice();
		String actPriceName = cp.getPriceInCheckout();
		Assert.assertEquals(expItemPrice, actPriceName);
		Assert.assertEquals(actItemName, expItemName);
		ExtentTest test = extent.createTest("verify Item Price And Name in Flipkart");
		test.addScreenCaptureFromBase64String("verify Item Price And Name in Flipkart");

	}

	@Test(priority = 2)
	public void handleIframe() throws Exception {

		driver.navigate().to(confiProp.getProperty("iframeurl"));
		nfp = new NestedFramePage(driver);

		ExtentTest test = extent.createTest("verify handle Iframe");
		test.addScreenCaptureFromBase64String("verify handle Iframe");

	}

	@Test(priority = 3)
	public void handleAlterPopup() throws Exception {
		driver.navigate().to(confiProp.getProperty("alertUrl"));
		ap = new AlertPage(driver);
		ap.clickAlterButton();
		ut = new Utility();
		ut.handleAltertPopup(driver);
		ap.timerAlertButton();
		Thread.sleep(5000);
		ut.handleAltertPopup(driver);
		ap.confirmButton();
		ut.handleAltertPopup(driver);
		ap.promtButton();
		ut.sendTextIntoAlertPopup(driver, "Ravikant");
		ut.handleAltertPopup(driver);
		ExtentTest test = extent.createTest("verify Alert Popup");
		test.addScreenCaptureFromBase64String("verify Alert Popup");

	}

	@Test(priority = 4)
	public void handleDragAndDrop() {
		driver.navigate().to(confiProp.getProperty("dragAndDropUrl"));
		ddp = new DragAndDropPage(driver);
		ddp.clickOnAcceptBtn();
		ddp.dragElement(driver);
		ExtentTest test = extent.createTest("verify handle Drag and Drop");
		test.addScreenCaptureFromBase64String("verify handle Drag and Drop");
	}

	@Test(priority = 5)
	public void windowHandle() {
		driver.navigate().to(confiProp.getProperty("windowHandleurl"));
		wp = new WindowPage(driver);
		wp.clickOnNewWindowBtn();
		ut = new Utility();
		ut.switchToWindow(driver);
		String expTextInNewWindow = "This is a sample page";
		String actTextInNewWindow = wp.getTextInNewWindow();
		Assert.assertEquals(expTextInNewWindow, actTextInNewWindow);
		driver.close();
		ExtentTest test = extent.createTest("verify Window Handle");
		test.addScreenCaptureFromBase64String("verify Window Handle");
	}

}

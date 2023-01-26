package com.flipcartBaseClass;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.alert.pom.AlertPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.beust.jcommander.Parameter;
import com.draganddrop.pom.DragAndDropPage;
import com.flipakrt.pom.CartPage;
import com.flipakrt.pom.FlipkartPage;
import com.flipakrt.pom.ItemPage;
import com.frames.pom.NestedFramePage;
import com.utility.Utility;
import com.window.pom.WindowPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
public WebDriver driver;
public FlipkartPage fp=null;
public ItemPage ip=null;
public CartPage cp=null;
public NestedFramePage nfp=null;
public AlertPage ap=null;
public DragAndDropPage ddp=null;
public Utility ut=null;
public WindowPage wp=null;
public ExtentReports extent = new ExtentReports();
public ExtentSparkReporter spark = null;
public Properties confiProp=null;
public FileReader reader=null;

   
   @BeforeClass
	public void setUp() throws Exception {
		WebDriverManager.chromedriver().setup();
		confiProp=new Properties();
		reader=new FileReader(".\\src\\test\\resources\\ConfigProperties.properties");
		confiProp.load(reader);
		
       if(confiProp.getProperty("browser").equals("chromeBrowser")) {
    	   driver=new ChromeDriver();
   		   driver.manage().window().maximize();
   		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
       }
       else if(confiProp.getProperty("browser").equals("firefoxBrowser")) {
    	   driver=new FirefoxDriver();
   		   driver.manage().window().maximize();
   		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
       }
       
       else if(confiProp.getProperty("browser").equals("edgeBrowser")) {
    	   driver=new FirefoxDriver();
   		   driver.manage().window().maximize();
   		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
       }
       
   
		
	}
	
   
   @AfterClass
	public void tearDown() {
		driver.quit();
		extent.flush();
	}

}

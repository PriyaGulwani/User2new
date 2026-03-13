package com.anhtester.common;

import com.anhtester.constants.FrameworkConstants;
import com.anhtester.driver.DriverManager;
import com.anhtester.driver.TargetFactory;
import com.anhtester.helpers.PropertiesHelpers;
import com.anhtester.keywords.WebUI;
import com.anhtester.listeners.AllureListener;
import com.anhtester.listeners.TestListener;
import com.anhtester.projects.cms.CommonPageCMS;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ThreadGuard;
import org.testng.annotations.*;

@Listeners({TestListener.class})
public class BaseTest extends CommonPageCMS {

   @Parameters("BROWSER")
   @BeforeMethod
   public void createDriver(@Optional("chrome") String browser) {
      WebDriver driver = ThreadGuard.protect(new TargetFactory().createInstance(browser));
      if (Boolean.valueOf(FrameworkConstants.HEADLESS) == true) {
         driver.manage().window().setSize(new Dimension(1920, 1080)); // ép Selenium resize
         System.out.println("Actual window size: " + driver.manage().window().getSize());
      } else {
         driver.manage().window().maximize();
	   System.out.println("Browser Maximized");
	   driver.navigate().back();
	   drive.navigate().forward();
	   System.out.println("new message by tanay");
	
      }
      DriverManager.setDriver(driver);
	  System.out.println("Driver Setup Done");
   }
   @AfterMethod(alwaysRun = true)
   public void closeDriver() {
      WebUI.stopSoftAssertAll();
      DriverManager.quit();
   }

   public WebDriver createBrowser(@Optional("chrome") String browser) {
      PropertiesHelpers.loadAllFiles();
      WebDriver driver = ThreadGuard.protect(new TargetFactory().createInstance(browser));
      if (Boolean.valueOf(FrameworkConstants.HEADLESS) == true) {
         driver.manage().window().setSize(new Dimension(1920, 1080)); // ép Selenium resize
         System.out.println("Actual window size: " + driver.manage().window().getSize());
      } else {
         driver.manage().window().maximize();
      }
      DriverManager.setDriver(driver);
      return DriverManager.getDriver();
   }
   
   public void printMyself(){
	   System.out.println("printMyself");
   }
   
   public void getDriverState(){
	   System.out.println("Driver Initialized");
   }

}

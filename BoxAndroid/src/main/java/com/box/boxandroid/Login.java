package com.box.boxandroid;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
//import com.relevantcodes.extentreports.ExtentReports;
//import com.relevantcodes.extentreports.ExtentTest;
//import com.relevantcodes.extentreports.LogStatus;

public class Login {
WebDriver driver;
	
	
	@BeforeClass
	public void setup()	throws MalformedURLException {
	 
	  File f=new File("src");
	  File fs=new File(f,"box-release-signed-4.8.9.apk");
	  DesiredCapabilities caps=new DesiredCapabilities();
	  caps.setCapability(MobileCapabilityType.PLATFORM_NAME,MobilePlatform.ANDROID);
	  caps.setCapability("appActivity", "com.box.android.activities.login.SplashScreenActivity");
	  caps.setCapability("appWaitActivity", "com.box.android.activities.login.WelcomeTourActivity");
	  caps.setCapability(MobileCapabilityType.DEVICE_NAME, "05f26f04");
	  caps.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
	  caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "100");
	  driver = new RemoteWebDriver(new URL("http://172.18.64.230:4723/wd/hub"),caps);
	  
	  
	}
	@Test
	public void logintest() throws InterruptedException{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.id("com.box.android:id/loginButton")));
		driver.findElement(By.id("com.box.android:id/loginButton")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("login")).clear();
		driver.findElement(By.id("login")).sendKeys("boxinternalqa2015+jbair@gmail.com");
		
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("test1234qa");
		
		
		
		driver.findElement(By.xpath("//android.widget.Button[@text='Log In']")).click();
		
		Thread.sleep(1000);
		driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();
		
		
		
}
	@AfterClass
	public void afterClass() {
		driver.quit();
		  
  }
}


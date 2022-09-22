package com.adk.webautomation;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.Test;
 
public class TechAdminSeleniumTest {
 
	@Test
	 public void testSelenium() {
		 
		URL url = LoginAutomation.class.getClassLoader().getResource("geckodriver");
		System.setProperty("webdriver.gecko.driver", url.getPath());
		File fireFoxPath = new File("/snap/bin/firefox");
		FirefoxBinary firefoxBinary = new FirefoxBinary(fireFoxPath);
		
		 firefoxBinary.addCommandLineOptions("--headless");
		 firefoxBinary.addCommandLineOptions("--no-sandbox");
		 FirefoxOptions firefoxOptions = new FirefoxOptions();
		 firefoxOptions.setBinary(firefoxBinary);
		 FirefoxDriver driver = new FirefoxDriver(firefoxOptions);
		 driver.get("https://google.com");
		 
		 try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 if (driver.getPageSource().contains("kkkI'm Feeling Lucky")) {
		 System.out.println("Pass");
		 } else {
		 System.out.println("Fail");
		 }
		 driver.quit();

	 }

}
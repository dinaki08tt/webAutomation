package com.adk.webautomation;

import java.io.File;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriverService;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginAutomation {
	@SuppressWarnings("deprecation")
	@Test
	public void login() {
		URL url = LoginAutomation.class.getClassLoader().getResource("geckodriver");
		System.setProperty("webdriver.gecko.driver", url.getPath());
		File fireFoxPath = new File("/snap/bin/firefox");
		DesiredCapabilities caps = DesiredCapabilities.htmlUnit(); //.setCapability("marionette", true);
		caps.setCapability("marionette", true);
		FirefoxOptions options = new FirefoxOptions(caps);
		
		WebDriver driver = new FirefoxDriver(options);

		
		driver.manage().window().maximize();
		driver.get("https://www.browserstack.com/users/sign_in");
		WebElement username = driver.findElement(By.id("user_email_Login"));
		WebElement password = driver.findElement(By.id("user_password"));
		WebElement login = driver.findElement(By.name("commit"));
		username.sendKeys("abc@gmail.com");
		password.sendKeys("your_password");
		login.click();
		String actualUrl = "https://live.browserstack.com/dashboard";
		String expectedUrl = driver.getCurrentUrl();
		Assert.assertEquals(expectedUrl, actualUrl);
	}
}
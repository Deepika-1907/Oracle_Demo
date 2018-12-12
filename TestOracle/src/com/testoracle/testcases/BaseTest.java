package com.testoracle.testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
	
WebDriver driver;
    
	Properties prop = new Properties();
	
	@BeforeTest
	public void setup() throws IOException {
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+ "\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		// To maximize browser
		driver.manage().window().maximize();
		// Implicit wait
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		InputStream input = new FileInputStream(System.getProperty("user.dir")+ "\\resources\\config.properties");
        prop.load(input);
		driver.get(prop.getProperty("url"));
	}	 	
	
	@AfterTest
	public void closeBrowser(){
		driver.close();
	}
	

}

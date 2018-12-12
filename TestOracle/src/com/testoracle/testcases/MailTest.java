package com.testoracle.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.testoracle.pagefactory.HomePage;
import com.testoracle.pagefactory.LoginPage;
import com.testoracle.pagefactory.MailPage;

public class MailTest extends BaseTest{

	
	 @Test
	  public void test() {
		  System.out.println(prop.getProperty("username"));
		  LoginPage loginPage = new LoginPage(driver);
		  HomePage homePage = new HomePage(driver);
		  loginPage.waitForpageLoad();
		  loginPage.setUsername(prop.getProperty("username"));
		  loginPage.setPassword(prop.getProperty("password"));
		  loginPage.clicklogin();
		  homePage.clickMailMenu();
		  Assert.assertTrue(homePage.isHomePageDisplayed());	  
	  }
	 
	 @Test
	 public void test2() {
		  MailPage mailPage = new MailPage(driver);
	   	 mailPage.clickBlankMail();
		 mailPage.selectMailType(prop.getProperty("mailType"));
		 mailPage.enterToAddress(prop.getProperty("mailTo"));
		 mailPage.enterSubject(prop.getProperty("mailSubject"));
		 mailPage.sendMail();
		  	  
	  }
	
}

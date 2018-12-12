package com.testoracle.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.testoracle.pagefactory.HomePage;
import com.testoracle.pagefactory.LoginPage;

public class HomePageTests extends BaseTest{
	
	
@Test
public void isLoginScucessfull() {		  
	 LoginPage loginPage = new LoginPage(driver);
	 HomePage homePage = new HomePage(driver);
	  loginPage.waitForpageLoad();
	  loginPage.setUsername(prop.getProperty("username"));
	  loginPage.setPassword(prop.getProperty("password"));
	  loginPage.clicklogin();	  
	  Assert.assertTrue(homePage.isHomePageDisplayed());	  
	  }
	
 @Test(dependsOnMethods = { "isLoginScucessfull" })
 public void isWorkFlows_Assigned_Org_Greater_Than_Zero() {	 
	  HomePage homePage = new HomePage(driver);
	  homePage.selectWorldGames();
	  homePage.clickWorkFlows();
	  homePage.clickAssignedToMyorg();	 
	  Assert.assertTrue(homePage.isTotalResultsGreaterThanZero());	 
  }
  
}

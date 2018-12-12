package com.testoracle.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase{


	@FindBy(how = How.ID, using = "userName")

	public WebElement userName;

	@FindBy(how = How.ID, using = "password")

	public WebElement passWord;
	
	
	@FindBy(how = How.ID, using = "login")

	public WebElement login;
	
	
// This is a constructor, as every page need a base driver to find web elements


	public LoginPage(WebDriver driver)

	{
		this.driver=driver;

		PageFactory.initElements(driver, this); 
		
		}
	
	
	public void setUsername(String username){
		enterText(userName, username);		
	}
	
	public void setPassword(String password){
		enterText(passWord, password);
	}

	public void clicklogin() {
		clickElement(login);
	}

}
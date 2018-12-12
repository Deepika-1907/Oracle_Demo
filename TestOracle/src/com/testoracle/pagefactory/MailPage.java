package com.testoracle.pagefactory;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class MailPage extends TestBase{
	
final WebDriver driver;

	@FindBy(how = How.CSS, using = "#nav-bar-CORRESPONDENCE-CORRESPONDENCE-CREATEMAIL")

	public WebElement newMail;
	
	@FindBy(how = How.ID, using = "Correspondence_correspondenceTypeID")

	public WebElement mailType;

	@FindBy(how = How.NAME, using = "SPEED_ADDRESS_TO")

	public WebElement toAddress;
	
	@FindBy(how = How.ID, using = "Correspondence_subject")

	public WebElement subject;
	
	@FindBy(how = How.TAG_NAME, using = "button")

	public WebElement sendButton;
	
	@FindBy(how = How.ID, using = "frameMain")

	public WebElement mainFrame;
	
	public MailPage(WebDriver driver)

	{
		this.driver=driver;

		PageFactory.initElements(driver, this); 
		
		}

	public void clickBlankMail() {
	 clickElement(newMail);
		
	}

	public void selectMailType(String type) {
		selectByValue(mailType, type);
	}

	public void enterToAddress(String mailTo) {
		enterText(toAddress, mailTo);
		toAddress.sendKeys(Keys.ENTER);
	}

	public void enterSubject(String mailSubject) {
		enterText(subject, mailSubject);
	}

	public void sendMail() {
		sendButton.click();
	}

}

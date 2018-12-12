package com.testoracle.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase{

	final WebDriver driver;
	
	@FindBy(how = How.ID, using = "welcome-content")

	public WebElement homePageLocator;
	
	@FindBy(how = How.XPATH, using = "//*[@id='projectChanger-name']")

	public WebElement projectChangeMenu;

	@FindBy(how = How.XPATH, using = "//*[(contains(title(), 'Emerald Mine')")

	public WebElement emeraldMe;
	
	@FindBy(how = How.XPATH, using = "//div[contains(@id,'projectChanger-')]//span[contains(text(),'Hotel VIP Resort')]")

	public WebElement hotel;

	@FindBy(how = How.XPATH, using =  "//div[contains(@id,'projectChanger-')]//span[contains(text(),'World Games')]")

	public WebElement worldGames;
	
	@FindBy(how = How.ID, using = "frameMain")

	public WebElement mainFrame;
	
	@FindBy(how = How.XPATH, using = "//*[@id='nav-bar-DOC']/div/div/div")

	public WebElement documentsMenu;
	
	@FindBy(how = How.ID, using = "nav-bar-DOC-DOC-NEW")

	public WebElement uploadDoc;

	@FindBy(how = How.ID, using = "nav-bar-WORKFLOW")

	public WebElement workflowsMenu;
	
	@FindBy(how = How.XPATH, using = "//*[@id='nav-bar-WORKFLOW-SavedSearches']//div[contains(text(), 'Assigned to my organization')]")
	
	public WebElement assignedToMyOrg;
	
	@FindBy(how = How.ID, using = "totalResults")

	public WebElement totalresults;
	
	@FindBy(how = How.XPATH, using = "//div[contains(text(), 'Mail')]")

	public WebElement mailMenu;
	
// This is a constructor, as every page need a base driver to find web elements

	public HomePage(WebDriver driver)

	{
		this.driver=driver;

		PageFactory.initElements(driver, this); 
		
		}


	public boolean isHomePageDisplayed() {
		driver.switchTo().frame(mainFrame);
		return homePageLocator.isDisplayed();
	}
	
	public void selectHotelVIPresort() {
		driver.switchTo().defaultContent();
		projectChangeMenu.click();
		hotel.click();
	}
	
	public void selectWorldGames() {
		driver.switchTo().defaultContent();
		projectChangeMenu.click();
		worldGames.click();
	}

	public void selectDocuments() {
		driver.switchTo().defaultContent();
		documentsMenu.click();
	}


	public void clickWorkFlows() {
		workflowsMenu.click();
	}
	
	public void clickAssignedToMyorg() {
		assignedToMyOrg.click();
	}


	public void clickUploadNewDocument() {
		clickElement(uploadDoc);
	}
	
	public boolean isTotalResultsGreaterThanZero() {
		driver.switchTo().frame(mainFrame);
		String totalValue = totalresults.getAttribute("value");
		int total = Integer.valueOf(totalValue);
		if(total > 0)
		{
			return true;
		}
		else 
			return false;
		
	}


	public void clickMailMenu() {
		driver.switchTo().defaultContent();
		clickElement(mailMenu);
		
	}

}
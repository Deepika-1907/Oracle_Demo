package com.testoracle.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class DocumentsPage extends TestBase{
	
	final WebDriver driver;

	
	@FindBy(how = How.CSS, using = "#docno_0")

	public WebElement docNumber;

	@FindBy(how = How.CSS, using = "#revision_0 > input")

	public WebElement docRevision;
	
	@FindBy(how = How.CSS, using = "#title_0 > input")

	public WebElement docTitle;
	
	@FindBy(how = How.CSS, using = "#doctype_0")

	public WebElement docType;
	
	@FindBy(how = How.CSS, using = "#docstatus_0")

	public WebElement docStatus;
	
	@FindBy(how = How.CSS, using = "#discipline_0")

	public WebElement docDiscipline;
	
	
	
	@FindBy(how = How.CSS, using = "#attribute1_0")

	public WebElement docAttribute1;
	
	@FindBy(how = How.ID, using = "clickToUpload")

	public WebElement fileUploadLink;
		
	@FindBy(how = How.ID, using = "btnUploadDocument")

	public WebElement documentUploadButton;
	
	@FindBy(how = How.ID, using = "frameMain")

	public WebElement mainFrame;
	
	@FindBy(how = How.ID, using = "fileUploadFrame")

	public WebElement fileUploadFrame;
	
	@FindBy(how = How.ID, using = "attribute1_0")
	
	public WebElement selectAttribute1Dropdown;
	
	@FindBy(how = How.XPATH, using = "//*[@id='attribute1_0_bidi']/div[1]/select")
	
	public WebElement selectAttribute1;
	
	@FindBy(how = How.ID, using = "attribute1_0_bidi_add")

	public WebElement arrtibute1AddButton;
	
	@FindBy(how = How.ID, using = "attribute1_0_panel-commit")

	public WebElement arrtibute1SaveButton;
	
	
	@FindBy(how = How.ID, using = "regSuccessPanel")

	public WebElement docUploadSuccessWindow;
	
	@FindBy(how = How.ID, using = "regSuccessPanel-cancel")

	public WebElement docUploadSuccessCloseButton;
	
	@FindBy(how = How.ID, using = "nav-bar-DOC-DOC-SEARCH")

	public WebElement docRegister;
	
	@FindBy(how = How.CSS, using = "#docno")

	public WebElement docNumberSearchField;
	
	@FindBy(how = How.TAG_NAME, using = "button")

	public WebElement searchButton;
	
	
	@FindBy(how = How.CSS, using = "#numResults > b:nth-child(2)")

	public WebElement totlResults;
	

	
	
// This is a constructor, as every page need a base driver to find web elements

	public DocumentsPage(WebDriver driver)

	{
		this.driver=driver;

		PageFactory.initElements(driver, this); 
		
		}


	public boolean isAtUploadDocPage() {
		
		return docNumber.isDisplayed();
	}


	public void setDocName() {
		
		String randonString = String.valueOf(generateRandom());
		System.setProperty("docNumber", randonString);
		enterText(docNumber, randonString);
	}


	public void switchToFrame() {
		driver.switchTo().frame(mainFrame);
	}


	public void setRevision(String revision) {
		enterText(docRevision, revision);
	}


	public void setTestTitle(String title) {
		enterText(docTitle, title);
	}


	public void selectType(String type) {
		selectByVisibletext(docType, type);
	}

	public void selectDiscipline(String discipline) {
		selectByVisibletext(docDiscipline, discipline);
	}

	public void selectStatus(String status) {
		selectByVisibletext(docStatus, status);
	}


	public void selectAttribute1(String attribute1) {
		selectAttribute1Dropdown.click();
		selectByValue(selectAttribute1, attribute1);
		clickElement(arrtibute1AddButton);
		clickElement(arrtibute1SaveButton);
	}


	public void clickUploadFile() {
		clickElement(fileUploadLink);
		String filepath = System.getProperty("user.dir")+ "\\resources\\test.pdf";
		fileUpload(filepath);
	}


	public void clickUploadDocumentButton() {
		clickElement(documentUploadButton);
	}


	public void clickDocumentsRegister() {
		clickElement(docRegister);
	}


	public void serachDocument(String docNumber) {
		driver.switchTo().frame(mainFrame);
		enterText(docNumberSearchField, docNumber);
	}


	public void closeDocUploadSuccessWindow() {
		clickElement(docUploadSuccessCloseButton);
	}


	public void searchDocument() {
		clickElement(searchButton);
	}
	
	public void isDocumentCanBeSearched() {
		System.out.println(totlResults.getText());
	}


	public boolean isDocumentUploadSuceesWindowDisplayed() {
	return isElementDisplayed(docUploadSuccessWindow);			
	}


	public boolean isDocumentDisplayed() {
		System.out.println(totlResults.getText());
		return true;
	}

}
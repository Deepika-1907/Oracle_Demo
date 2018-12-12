package com.testoracle.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.testoracle.pagefactory.DocumentsPage;
import com.testoracle.pagefactory.HomePage;
import com.testoracle.pagefactory.LoginPage;

public class DocumentUploadTest extends BaseTest{
	
	
  @Test
  public void IsAtUploadDocPage() {
	 LoginPage loginPage = new LoginPage(driver);
	 HomePage homePage = new HomePage(driver);
	 DocumentsPage documentsPage = new DocumentsPage(driver);
	  loginPage.setUsername(prop.getProperty("username"));
	  loginPage.setPassword(prop.getProperty("password"));
	  loginPage.clicklogin();	  
	  loginPage.waitForpageLoad();
	  homePage.selectHotelVIPresort();
	  homePage.selectDocuments();
	  homePage.clickUploadNewDocument();
	  documentsPage.switchToFrame();
	  Assert.assertTrue(documentsPage.isAtUploadDocPage());
  }
   
  @Test
  public void isUploadSuccessfull() {
	  DocumentsPage documentsPage = new DocumentsPage(driver);
	  documentsPage.setDocName();
	  documentsPage.setRevision(prop.getProperty("revision"));
	  documentsPage.setTestTitle(prop.getProperty("title"));
	  documentsPage.selectType(prop.getProperty("type"));
	  documentsPage.selectStatus(prop.getProperty("status"));
	  documentsPage.selectDiscipline(prop.getProperty("discipline"));
	  documentsPage.selectAttribute1(prop.getProperty("attribute1"));
	 documentsPage.clickUploadFile();
	 documentsPage.clickUploadDocumentButton();
	 Assert.assertTrue(documentsPage.isDocumentUploadSuceesWindowDisplayed(), "Document was not uploaded");
  }
  
}

  



package com.testoracle.pagefactory;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestBase {
	
	static WebDriver driver;
	
public void waitForpageLoad(){
	
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
}

public static long generateRandom() 
{
	    Random random = new Random();
	    int length = 12;
	    char[] digits = new char[length];
	    digits[0] = (char) (random.nextInt(9) + '1');
	    for (int i = 1; i < length; i++) {
	        digits[i] = (char) (random.nextInt(10) + '0');
	    }
	    return Long.parseLong(new String(digits));
	}

public void clickElement(WebElement element) {
	new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(element)).click();
}

public void enterText(WebElement element, String value) {
	new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(element)).clear();
	element.sendKeys(value);	
}

public void selectByValue(WebElement element, String value) {
	new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(element));
	Select select = new Select(element);
	select.selectByIndex(2);	
}

public void selectByVisibletext(WebElement element, String value) {
	new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(element));
	Select select = new Select(element);
	select.selectByVisibleText(value);	
}

public boolean isElementDisplayed(WebElement element){
  return	new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(element)).isDisplayed();
}


public void fileUpload(String filepath){	

	StringSelection stringSelection = new StringSelection(filepath);
	   Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
	   Robot robot = null;;
	try {
		robot = new Robot();
	} catch (AWTException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    robot.keyPress(KeyEvent.VK_ENTER);
    robot.keyRelease(KeyEvent.VK_ENTER);
    robot.delay(2000); 
 robot.keyPress(KeyEvent.VK_CONTROL);
 robot.keyPress(KeyEvent.VK_V);
 robot.keyRelease(KeyEvent.VK_V);
 robot.keyRelease(KeyEvent.VK_CONTROL);
 robot.keyPress(KeyEvent.VK_ENTER);
 robot.delay(150);
 robot.keyRelease(KeyEvent.VK_ENTER);

}
}



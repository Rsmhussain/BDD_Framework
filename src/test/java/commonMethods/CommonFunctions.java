package commonMethods;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.Connection;
import java.sql.Statement;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
//import org.apache.commons.mail.EmailAttachment;
//import org.apache.commons.mail.EmailException;
//import org.apache.commons.mail.MultiPartEmail;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.*;

import org.testng.TestException;
import org.testng.asserts.SoftAssert;

import ObjectRepositories.LoginPage_OR;
import commonMethods.BaseSuite;

public class CommonFunctions extends BaseSuite

{
	/* Creating Object for the Page Object Repositories Class */
	public static LoginPage_OR Login_Page;
//	public static CounterParty_OR Counterparty_Page; 
	
	
	public Wait<WebDriver> gWait;
	static Connection cConnection;
	static Statement cStatement;
	public boolean acceptNextAlert;
	String parentWindowHandle;
	public static int rowCount = 0;
	SoftAssert softAssertion = new SoftAssert();
	
	//Database 
	
	public static String DBName="PPLMAUTO";
	public static String userName="PPLMAUTO";
	public static String passWord="PPLMAUTO";
	
	/* 1. */
	public Wait mFluentWait(WebDriver pDriver)  
	{
		Wait<WebDriver> gWait = new FluentWait<WebDriver>(pDriver).withTimeout(280, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.MILLISECONDS).ignoring(NoSuchElementException.class);
		// gWait = new FluentWait(pDriver).withTimeout(180,
		// TimeUnit.SECONDS).pollingEvery(5, TimeUnit.MILLISECONDS)
		// .ignoring(NoSuchElementException.class);//
		// .ignoring(NoSuchElementException.class)
		return gWait;
	}
	
	/* 2. */
	
	public void waitUntilElementIsDisplayedOnScreen(By selector)  //2
	{
		try {
			gWait = mFluentWait(driver);
			gWait.until(ExpectedConditions.presenceOfElementLocated(selector));
			gWait.until(ExpectedConditions.visibilityOfElementLocated(selector));
			} 
		catch (Exception e) 
			{
			throw new NoSuchElementException(String.format("The following element was not visible: %s ", selector));
			}
	}

	/* 3. */
	public List<WebElement> getElement(By selector) {
		try {
			return driver.findElements(selector);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(String.format("Element %s does not exist - proceeding", selector));
		}
		return null;
	}
	
	/* 4. */
	public void sendKeys(By selector, String value) {
		waitUntilElementIsDisplayedOnScreen(selector);
		WebElement element = getElement(selector).get(0);
		// element.click();
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		actions.doubleClick();
		try {
			// element.sendKeys(value);
			actions.sendKeys(value);
			actions.build().perform();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(
					String.format("Error in sending [%s] to the following element: [%s]", value, selector.toString()));
		}
	}

	/* 5. */
	//SendKeys For Integer 
	public void sendKeys(By selector, int nvalue) {
		String number =String.valueOf(nvalue);
		waitUntilElementIsDisplayedOnScreen(selector);
		WebElement element = getElement(selector).get(0);
		// element.click();
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		actions.doubleClick();
		try {
			// element.sendKeys(value);
			actions.sendKeys(number);
			actions.build().perform();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(
					String.format("Error in sending [%s] to the following element: [%s]", number, selector.toString()));
		}
	}
	

	/* 6. */
	public void waitForElementToBeClickable(By selector) {
		try {
			gWait = mFluentWait(driver);
			gWait.until(ExpectedConditions.elementToBeClickable(selector));
		} catch (Exception e) {
			throw new TestException("The following element is not clickable: " + selector);
		}
	}

	/* 7. */
	public void click(By selector) {
		waitUntilElementIsDisplayedOnScreen(selector);
		waitForElementToBeClickable(selector);
		WebElement element = getElement(selector).get(0);
		// System.out.println(element);
		try {
			element.click();
		} catch (Exception e) {
			throw new TestException(String.format("The following element is not clickable: [%s]", selector));
		}
	}
	
	/* 8. */
	public void clickby_mouse(By selector)
	{
		waitUntilElementIsDisplayedOnScreen(selector);
		WebElement element = getElement(selector).get(0);
		// element.click();
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		actions.click();
		try {
			// element.sendKeys(value);
			Thread.sleep(1000);
			actions.build().perform();
			actions.click().build().perform();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(
					String.format("Error in sending [%s] to the following element: [%s]", selector.toString()));
		}
	}
	
	/* 9. */
	public void click_checkbox(By selector)
	{
		waitUntilElementIsDisplayedOnScreen(selector);
		waitForElementToBeClickable(selector);
		WebElement option1 = driver.findElement(selector);							

        // This will Toggle the Check box 		
        option1.click();			

        // Check whether the Check box is toggled on 		
        if (option1.isSelected()) {					
            System.out.println("Checkbox is Toggled On");					

        } else {			
            System.out.println("Checkbox is Toggled Off");					
        }		
		
	}
	
	/* 10. */
	public void Fileupload() throws InterruptedException
	{
		try
		{
			 //Click The Import Button	
			 driver.findElement(By.id("ctl00_ContentPlaceHolder1_tabCounterParty_tabupload_btnImport")).click();
             
			 Alert ChooseFileAlert = driver.switchTo().alert();
	         driver.switchTo().alert();
	 		 Thread.sleep(2000);
	 		
	 		 BufferedImage ChooseFileToImport = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
	 	     ImageIO.write(ChooseFileToImport, "jpg", new File("D:\\Day to Day Work\\Automation\\AutomationScreentShoots\\Positive Cases\\Validations\\ChooseTheFileToImportValidation.png"));
	 	    
	 	     ChooseFileAlert.accept();
			 
	 	     //Click The Browse Button
			 WebElement UploadFile =driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_tabCounterParty_tabupload_fldcounter']"));
	         UploadFile.click();
	         
	         // enter the file path onto the file-selection input field
	         UploadFile.sendKeys("D:\\Day to Day Work\\Automation\\File Format\\CP_File_Format.xlsx");
	         
	         
		
	         //Click The Import Button	
	         takeSnapShot(driver, "D:\\Day to Day Work\\Automation\\AutomationScreentShoots\\Positive Cases\\Validations\\FilePath.png") ;
	         driver.findElement(By.id("ctl00_ContentPlaceHolder1_tabCounterParty_tabupload_btnImport")).click();
	        
	         
	         Alert ImportSuccessfully = driver.switchTo().alert();
	         
	         driver.switchTo().alert();
	 		 Thread.sleep(2000);
	 		
	 		 BufferedImage Importsuccessfully = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
	 	     ImageIO.write(Importsuccessfully, "jpg", new File("D:\\Day to Day Work\\Automation\\AutomationScreentShoots\\Positive Cases\\Validations\\FileImportSuccessfully.png"));
	 	    
	 	    ImportSuccessfully.accept();
	
	        System.out.println("File Uploaded Successfully");
	       
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		     	    
	}
	
	/* 11. */
	public static void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception
	{

        	//Convert web driver object to TakeScreenshot

        	TakesScreenshot scrShot =((TakesScreenshot)webdriver);
        	
        	//Call getScreenshotAs method to create image file

        	File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

        	//Move image file to new destination

        	File DestFile=new File(fileWithPath);

        	//Copy file at destination

        	FileUtils.copyFile(SrcFile, DestFile);

    }
	
	/* 12. */
	public void dropdown_select(By selector)
	{
		try
		{
			
	
		waitUntilElementIsDisplayedOnScreen(selector);
		waitForElementToBeClickable(selector);
		WebElement option1 = driver.findElement(selector);							

        // This will Toggle the Check box 		
        option1.click();			

        Select drpCountry = new Select(driver.findElement(selector));
//        drpCountry.toString();
        drpCountry.selectByVisibleText("ISDA");
		drpCountry.selectByIndex(1);
		

		//Selecting Items in a Multiple SELECT elements
		}
		catch (Exception e)
		{
			System.out.println(String.format("Element %s does not exist - proceeding", selector));
		}
	}
	
	/* 13. */
	public String getElementText(By selector) 
	{
		waitUntilElementIsDisplayedOnScreen(selector);
		try {
			return StringUtils.trim(driver.findElement(selector).getText());
		} catch (Exception e) {
			System.out.println(String.format("Element %s does not exist - proceeding", selector));
		}
		return null;
	}
	
	/*
	 * public static void sendMail() throws EmailException {
	 * 
	 * // Create the attachment EmailAttachment attachment = new EmailAttachment();
	 * attachment.setPath("D://InvalidCredentials.png");
	 * attachment.setDisposition(EmailAttachment.ATTACHMENT);
	 * attachment.setDescription("Invalid Login"); attachment.setName("Sheik");
	 * 
	 * // Create the email message MultiPartEmail email = new MultiPartEmail();
	 * email.setHostName("smtp.gmail.com"); email.addTo("spraslam@gmail.com",
	 * "Sheik"); email.setFrom("spraslam@gmail.com", "Me");
	 * email.setSubject("The picture");
	 * email.setMsg("Here is the picture you wanted");
	 * 
	 * // add the attachment email.attach(attachment);
	 * 
	 * // send the email email.send();
	 * 
	 * }
	 */
}

package ObjectRepositories;

import commonMethods.CommonFunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.By.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.*;
import org.openqa.selenium.support.ui.ExpectedCondition; 
import org.openqa.selenium.support.ui.Select;
import org.testng.TestException;

import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import java.lang.String.*;

import cucumber.api.PendingException;

public class HomePage_OR extends CommonFunctions
{
	//Login Page WebElements 
	
	private final By HomePage_emailId = ById.id("email");
	private final By HomePage_enterimg = ById.id("enterimg");
	
	//Page Functionality Defining Methods
	
	public void signUpButton()
	{
		click(HomePage_enterimg);
	}
	
	public void enterEmail(String emailid) throws InterruptedException
	{
		try
		{
			Thread.sleep(300);
			waitUntilElementIsDisplayedOnScreen(HomePage_emailId);
			sendKeys(HomePage_emailId,emailid);
			Thread.sleep(600);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			System.out.println("Finally Block of " + Thread.currentThread().getStackTrace()[1].getMethodName());

		}
		
	}
	

}

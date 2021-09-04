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
 




public class LoginPage_OR extends CommonFunctions
{

	//Login Page WebElements 
	
	private final By Login_Id = ById.id("username");
	private final By Login_Password = ById.id("password");
	private final By Login_LoginBtn = ById.name("login");
	private final By Login_regemail = ById.id("reg_email");
	private final By Login_regpassword = ById.id("reg_password");
	private final By Login_registerbtn = ById.name("register");
	
	
	
	
	
	
	//Page Functionality Defining Methods
	
	public void loginCredentials(String username,String password) throws InterruptedException
	{
		try
		{
			Thread.sleep(300);
			waitUntilElementIsDisplayedOnScreen(Login_Id);
			waitUntilElementIsDisplayedOnScreen(Login_Password);
			sendKeys(Login_Id,username);
			sendKeys(Login_Password,password);
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
	
	
	public void clickLoginButton()
	{
		click(Login_LoginBtn);
	}
	
	
	public void enterRegisterDetails(String regemail,String regpassword)
	{
		try
		{
			Thread.sleep(300);
			waitUntilElementIsDisplayedOnScreen(Login_regemail);
			waitUntilElementIsDisplayedOnScreen(Login_regpassword);
			sendKeys(Login_regemail,regemail);
			sendKeys(Login_regpassword,regpassword);
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
	
	public void clickRegisterButton()
	{
		click(Login_registerbtn);
	}
	
	
}

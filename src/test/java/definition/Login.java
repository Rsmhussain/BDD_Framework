package definition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.en.And;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Alert;

import org.junit.Assert.*;
import org.testng.asserts.*;

import commonMethods.CommonFunctions;
import ObjectRepositories.LoginPage_OR;
import commonMethods.BaseSuite;

public class Login extends CommonFunctions
{
	@Given("^Load the login page$")
    public void load_the_login_page() throws Throwable 
	{
		Login_Page = getPageFactoryObject(LoginPage_OR.class);
    }

    @Given("^Open the chrome browser$")
    public void open_the_chrome_browser() throws Throwable 
    {
    	ApplicationDriverSetup("CH");

    }

    @When("^user enters the valid user name (.+) and password (.+)$")
    public void user_enters_the_valid_user_name_and_password(String username, String password) throws Throwable
    {
    	Login_Page.loginCredentials(username, password);
    	System.out.println("Valid Login Executed");
    }
    
    @When("^user enters the Invalid user name (.+) and password (.+)$")
    public void user_enters_the_invalid_user_name_and_password(String username, String password) throws Throwable
    {
    	Login_Page.loginCredentials(username, password);
    	System.out.println("InValid Login Executed");
    }
    
    @Then("^click on login button$")
    public void click_on_login_button() throws Throwable 
    {
    	 Login_Page.clickLoginButton();
         System.out.println("Login Button Clicked");
    }
    
    @When("^user enters the rgister username (.+) and password (.+)$")
    public void user_enters_the_rgister_username_and_password(String regemail, String regpassword) throws Throwable 
    {
    	Login_Page.enterRegisterDetails(regemail, regpassword);
    	System.out.println("Register Block Executed");
    }

    @Then("^click on Register button$")
    public void click_on_register_button() throws Throwable {
    	Login_Page.clickRegisterButton();
    }


}

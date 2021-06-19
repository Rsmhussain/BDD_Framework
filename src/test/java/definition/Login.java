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

    @When("^user enters the (.+) and (.+)$")
    public void user_enters_the_and(String username, String password) throws Throwable 
    {
    	Login_Page.loginCredentials(username, password);
    }

    @Then("^click on login button$")
    public void click_on_login_button() throws Throwable 
    {
    	 Login_Page.clickLoginButton();
         System.out.println("Login Executed");
    }

}

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
//import ObjectRepositories.LoginPage_OR;
import ObjectRepositories.HomePage_OR;
import commonMethods.BaseSuite;

public class Home extends CommonFunctions
{
	 @Given("^Load the Sign In Page$")
	 public void load_the_sign_in_page() throws Throwable
	 {
		 HomePage = getPageFactoryObject(HomePage_OR.class);
	 }
	
	
	@When("^user enters the (.+)$")
    public void user_enters_the(String emailid) throws Throwable 
    {
    	HomePage.enterEmail(emailid);
    }

    @Then("^click the register button$")
    public void click_the_register_button() throws Throwable 
    {
    	HomePage.signUpButton();
    }

    @Then("^verify register page is opened or not$")
    public void verify_register_page_is_opened_or_not() throws Throwable {

    }

}

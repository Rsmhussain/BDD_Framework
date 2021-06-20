package commonMethods;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.*;
import org.testng.annotations.*;

public class BaseSuite {
	public static WebDriver driver;

	/* GenericS Only consider the Objects*/
	static List<Object> pages = new ArrayList<Object>();
	
	public static String url= "http://practice.automationtesting.in/my-account/";

	public static String browsertype;

	public void ApplicationDriverSetup(String browsertype) {
		try 
		{
			DriverSetup setup = DriverSetup.GetDriverInstance();
			driver = setup.IntializeBrowserDriver(browsertype);
			pages = new ArrayList<Object>();
			driver.get(url);
			Thread.sleep(3000);
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

	@AfterTest
	public void ApplicationLogout() {
		try {
			driver.close();
			driver.quit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("Finally block of " + Thread.currentThread().getStackTrace()[1].getMethodName());
		}
	}

	/*
	 * Generic Method For web element pages
	 */
	
	@SuppressWarnings("unchecked")
	
	public <T> T getPageFactoryObject(Class<T> clazzname)
	{
		for(Object page : pages)
		{
			  if(page==clazzname)
			  {
				  return (T)page;
			  }
		}
		T page=PageFactory.initElements(driver, clazzname);
		pages.add(page);
		return page;
	}
	
}
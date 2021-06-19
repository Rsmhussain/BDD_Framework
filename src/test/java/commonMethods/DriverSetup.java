package commonMethods;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverSetup {

	private static WebDriver driver;
	private static DriverSetup driverSetup = new DriverSetup();

	private static File file;
	private static FileInputStream fis;
	private static Properties property;
	
	/*Constructor*/
	public DriverSetup()
	{

	}

	
	public static DriverSetup GetDriverInstance()
	{
		return driverSetup;
	}

	public WebDriver IntializeBrowserDriver(String gBrowsertype)
	{
		try 
			{
			if (driver == null) 
				{
				if (gBrowsertype.equals("IE")) 
				{
					System.setProperty("webdriver.ie.driver","src\\test\\Drivers\\chromedriver.exe"); // D:\\IEDriver\\2.45\\ie32\\IEDriverServer.exe
					DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();					
					capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
					capabilities.setCapability(InternetExplorerDriver.ENABLE_ELEMENT_CACHE_CLEANUP, "https://apps3.kgisl.com/xTrackStaticJB/Pages/Login.aspx");
					capabilities.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, true);
					driver = new InternetExplorerDriver(capabilities);
					Thread.sleep(1000);
					driver.manage().window().maximize();
				} 
				else if (gBrowsertype.equals("CH")) 
				{
					System.setProperty("webdriver.chrome.driver","src\\test\\Drivers\\chromedriver.exe");
					driver = new ChromeDriver();
					Thread.sleep(1000);
					driver.manage().window().maximize();
				}

			}
			return driver;
		} 
		catch (Exception ex) 
		{
			ex.printStackTrace();
			return null;
		}
		finally
		{
			System.out.println("Driver Initialized");
		}
	}

	public static Properties getProperty() 
	{
		return property;
	}

	public static void setProperty(Properties property) 
	{
		DriverSetup.property = property;
	}

}

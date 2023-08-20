package pBase;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;

import pUtility.Utility;

public class Base 
{
	//driver and browser setup
	
	protected static WebDriver driver;
	
	public void launchBrowser() throws IOException
	{
		ChromeOptions options = new ChromeOptions();
		
		options.addArguments("disable-notifications");
		
		driver = new ChromeDriver(options);
		
		driver.get(Utility.readDataFromPropertyFile("url"));
		
		driver.manage().window().maximize();
		
		Reporter.log("Launching browser.", true);
	}
	
	public void closeBrowser() throws InterruptedException
	{
		Utility.waitUse(1000);
		
		driver.quit();
		
		Reporter.log("Closing browser.", true);	
	}
	
	
}

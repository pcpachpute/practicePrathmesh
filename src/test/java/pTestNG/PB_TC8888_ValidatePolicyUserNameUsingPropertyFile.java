package pTestNG;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pBase.Base;
import pPOM.LoginPagePolicyBazaar;
import pPOM.MyProfilePolicyBazaar;
import pUtility.Utility;

//@Listeners(zTestNG.Listener.class)
public class PB_TC8888_ValidatePolicyUserNameUsingPropertyFile extends Base
{
	LoginPagePolicyBazaar login;
	MyProfilePolicyBazaar myProfile;
	String TCID = "PB_TC8888";
	
	@BeforeClass
	public void launchPolicyBazaar() throws InterruptedException, IOException
	{
		Utility.waitUse(1000);
		launchBrowser();
		
		login = new LoginPagePolicyBazaar(driver);
		myProfile = new MyProfilePolicyBazaar(driver);
		
		Utility.waitUse(3000);
	}
  
	@BeforeMethod
	public void signInPolicyBazaar() throws InterruptedException, EncryptedDocumentException, IOException
	{	
		login.clickOnHomePageSignInButton();
		Utility.waitUse(1000);
		
		login.enterMobileNumber(Utility.readDataFromPropertyFile("mobNum"));
		
		login.clickOnSignInWithPassword();
		Utility.waitUse(1000);
		
		login.enterPassword(Utility.readDataFromPropertyFile("pwd"));
		
		login.clickOnSignInForPasswordButton();
		Utility.waitUse(1000);
		
		login.clickOnMyAccount();
		
		login.clickOnMyProfile();
		Utility.waitUse(2000);
		
		Set<String> allWindowsID = driver.getWindowHandles();
		
		ArrayList<String> allID = new ArrayList<>(allWindowsID);
			
			//String mainpage = allID.get(0);
			String childpage = allID.get(1);
			
		driver.switchTo().window(childpage);
		
		Reporter.log("Switching to childpage.", true);
		
		Utility.waitUse(5000);
	}
	
	@Test
	public void validateUserName() throws IOException, InterruptedException 
	{
		String expectedUN = Utility.readDataFromPropertyFile("expectedUN");
		
		Utility.waitUse(5000);
		
		String actualUN = myProfile.getActualUserName();
		
		Assert.assertEquals(actualUN, expectedUN, "Actual & Expected username does not match, TC is failed.");
		
		Utility.takeScreenshot(driver, actualUN +" "+TCID);
		
		Utility.waitUse(1000);
	}
	
	@AfterMethod
	public void logOutPolicyBazaar()
	{
		myProfile.clickOnLogoutButton();
	}
	
	@AfterClass
	public void closePolicyBazaar() throws InterruptedException
	{
		Utility.waitUse(1000);
		closeBrowser();
	}
}

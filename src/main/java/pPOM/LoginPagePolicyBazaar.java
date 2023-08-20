package pPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class LoginPagePolicyBazaar 
{
	//variables
	
	@FindBy(xpath = "//a[text()='Sign in']") private WebElement signInButtonHomePage;
	
	@FindBy(xpath = "(//input[@type='number'])[2]") private WebElement mobileNumberField;
	
	@FindBy(xpath = "(//span[text()='Sign in with Password'])[2]") private WebElement signInWithPassword;
	
	@FindBy(name = "password") private WebElement passwordField;
	
	@FindBy(xpath = "//span[text()='Sign in']") private WebElement signInForPassword;
	
	@FindBy(className = "userprofile") private WebElement myAccount;
	
	@FindBy(xpath = "//ul[@class='support-ui wd5']//li[1]") private WebElement myProfile;
	
	
	//constructors
	
	public LoginPagePolicyBazaar(WebDriver diver)
	{
		PageFactory.initElements(diver, this);
	}
	
	
	//methods
	
	public void clickOnHomePageSignInButton()
	{
		signInButtonHomePage.click();
		Reporter.log("Clicking on HomePageSignInButton.", true);
	}
	
	public void enterMobileNumber(String mobNumber)
	{	
		mobileNumberField.sendKeys(mobNumber);
		Reporter.log("Entering mobileNumber.", true);
	}
	
	public void clickOnSignInWithPassword()
	{
		signInWithPassword.click();
		Reporter.log("Clicking on SignInWithPassword button.", true);
	}
	
	public void enterPassword(String password)
	{	
		passwordField.sendKeys(password);
		Reporter.log("Entering password.", true);
	}
	
	public void clickOnSignInForPasswordButton()
	{
		signInForPassword.click();
		Reporter.log("Clicking on SignInForPasswordButton button.", true);
	}
	
	public void clickOnMyAccount()
	{
		myAccount.click();
		Reporter.log("Clicking on myAccount button.", true);
		
	}
	
	public void clickOnMyProfile()
	{
		myProfile.click();
		Reporter.log("Clicking on myProfile button.", true);
	}
	
}

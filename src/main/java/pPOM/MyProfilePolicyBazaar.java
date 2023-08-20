package pPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class MyProfilePolicyBazaar 
{
	//variables
	
	@FindBy(xpath = "//div[@class='textCapitalize sc-ckVGcZ kWpXlQ']") private WebElement userName;
	
	@FindBy(className = "h_l") private WebElement logoutButton;
	
	//constructor
	
	public MyProfilePolicyBazaar(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	//methods
	
	public String getActualUserName()
	{
		Reporter.log("Getting actualUserName.", true);
		String actualUserName = userName.getText();
		return actualUserName;
	}
	
	public void clickOnLogoutButton()
	{
		logoutButton.click();
		Reporter.log("Logging out.", true);
	}
}

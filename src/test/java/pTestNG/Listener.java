package pTestNG;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import pBase.Base;
import pUtility.Utility;

public class Listener extends Base implements ITestListener
{
	@Override
	public void onTestFailure(ITestResult result) 
	{
		try 
		{
			Utility.takeScreenshot(driver, result.getName() );	
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	@Override
	public void onTestSuccess(ITestResult result) 
	{
		Reporter.log("TC "+result.getName()+" is passed successfully.", true);
	}
	
	@Override
	public void onTestStart(ITestResult result) 
	{
		Reporter.log("TC execution started for "+result.getName()+".", true);
	}
}

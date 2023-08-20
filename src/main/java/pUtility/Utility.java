package pUtility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

public class Utility 
{
	//screenshot
	//scrolling
	//excel data reading
	//wait
	
	public static void takeScreenshot(WebDriver driver, String fileName) throws IOException
	{
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		File destination = new File("C:\\Users\\PRATHMESH P\\eclipse-workspace\\PolicyBazaar\\screenshots\\"+fileName+".png");
		
		FileHandler.copy(source, destination);
		
		Reporter.log("Taking screenshot.", true);
		
		Reporter.log("Screenshot is stored in location : "+ destination, true);
	}
	
	public static void scrollIntoView(WebDriver driver, WebElement element)
	{
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true)", element);
		
		Reporter.log("Scrolling Into View.", true);
	}
	
	public static String readDataFromExcel(int row, int cell) throws EncryptedDocumentException, IOException
	{
		FileInputStream myFile = new FileInputStream("C:\\Users\\PRATHMESH P\\Desktop\\ExcelBook1.xlsx");
		
		Reporter.log("Reading excel sheet data from row num "+row+" and cell num "+cell, true);
		
		String value = WorkbookFactory.create(myFile).getSheet("Sheet1").getRow(row).getCell(cell).getStringCellValue();
		
		return value;
		
	}
	
	public static void waitUse(int waitTime) throws InterruptedException
	{
		Reporter.log("Waiting for "+waitTime+" milliseconds.", true);
		
		Thread.sleep(waitTime);
	}
	
	public static String readDataFromPropertyFile(String key) throws IOException
	{
		Properties prop = new Properties();
		
		FileInputStream myFile = new FileInputStream("C:\\Users\\PRATHMESH P\\eclipse-workspace\\seleniumhome\\zMyProperty.properties");
		
		prop.load(myFile);
		
		String value = prop.getProperty(key);
		
		Reporter.log("Reading "+key+" data from property file.", true);
		
		return value;
	}

}

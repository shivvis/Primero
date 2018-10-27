package com.primero.qa.testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.primero.qa.util.CommonUtil;
import com.primero.qa.util.ExcelUtil;



public class TestBaseClass {

	public static WebDriver driver;
	public static Properties prop;


	public TestBaseClass()
	{	
		try {
			 prop = new Properties();
			 FileInputStream file;
			file = new FileInputStream("C:\\Users\\jkasilingam\\eclipse-workspace\\MavenPrimero\\src\\main\\java\\com\\primero\\qa\\config\\config.properties");	
			prop.load(file);
		
		} 
		
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}

	public  void setExcel() {

		try {
			ExcelUtil.setExcelFile(prop.getProperty("Path_TestData") + prop.getProperty("File_TestData"), "CaseSheet");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	
	public void checkIfBrowserExists(boolean blnBrowserExist)
	{	
		if(blnBrowserExist!=true)
		{
			/*public static void intialization()
			{*/
				String browserName = prop.getProperty("browser");
				if(browserName.equals("Chrome"))
				{
					System.setProperty(prop.getProperty("ChFile_DriverClass"),prop.getProperty("ChFile_DriverPath"));
					driver = new ChromeDriver();
				}
				
				if(browserName.equals("ie"))
				{
					System.setProperty(prop.getProperty("IEFile_DriverClass"),prop.getProperty("IEFile_DriverPath"));
					driver = new ChromeDriver();
					
				}
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
				driver.manage().timeouts().pageLoadTimeout(CommonUtil.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
				driver.manage().timeouts().implicitlyWait(CommonUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);
				driver.get(prop.getProperty("URL"));
				
			//}
		
		}
		else
		{
		/*	//to run from existing browser.
			public static void RunFromOpenedBrowser()
			{
				*/String browserName = prop.getProperty("browser");
				if(browserName.equals("Chrome"))
				{
					
					System.setProperty(prop.getProperty("ChFile_DriverClass"),prop.getProperty("ChFile_DriverPath"));
					ChromeOptions cOption = new ChromeOptions();
					cOption.setExperimentalOption("debuggerAddress", prop.getProperty("File_LocalHost"));
					driver = new ChromeDriver(cOption);
				}
				
				if(browserName.equals("ie"))
				{
					ChromeOptions cOption = new ChromeOptions();
					cOption.setExperimentalOption("debuggerAddress", prop.getProperty("File_LocalHost"));
					driver = new ChromeDriver(cOption);
				}
				//not required.
				//driver.get(prop.getProperty("URL"));
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
				driver.manage().timeouts().pageLoadTimeout(CommonUtil.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
				driver.manage().timeouts().implicitlyWait(CommonUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);
				
				//return driver;
		}
	
	}
	
}

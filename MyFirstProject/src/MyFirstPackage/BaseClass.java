package MyFirstPackage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import myUtility.Constants;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

//import myUtility.Constants;

public class BaseClass {

	public static WebElement element = null;
	public static WebDriver dr;
	//public static WebDriver objdr;

	// To Launch New Browser
	public WebDriver Login() throws IOException {
		System.setProperty(Constants.File_DriverClass, Constants.File_DriverPath);

		// To launch new browser
		WebDriver drNew = new ChromeDriver();
		drNew.get(Constants.URL);
		System.out.println(drNew.getTitle());
		return drNew;

	}

	// To run from existing browser.
	public static WebDriver RunFromOpenedBrowser() throws IOException {
		System.setProperty(Constants.File_DriverClass, Constants.File_DriverPath);

		ChromeOptions cOption = new ChromeOptions();
		cOption.setExperimentalOption("debuggerAddress", Constants.File_LocalHost);
		WebDriver dr = new ChromeDriver(cOption);
		//dr.get("https://primero-qa-v1-5.dev.quoininc.com/login");
		System.out.println(dr.getTitle());
		//objdr = dr;
		return dr;
	}

	public static WebElement FindElementById(WebDriver dr, String ID) {
		element = dr.findElement(By.id(ID));
		return element;

	}
	
	public static WebElement FindElementByName(WebDriver dr, String Name) {
		element = dr.findElement(By.name(Name));
		return element;

	}
	

	public static WebElement FindElementByXpath(WebDriver dr, String xPath) {
		element = dr.findElement(By.xpath(xPath));
		return element;

	}

	public static WebElement FindElementByCSSSelector(WebDriver dr, String cssSelect) {
		element = dr.findElement(By.cssSelector(cssSelect));
		return element;

	}

	public static boolean IsDiplayed(WebElement objEle, String dispMsg) {

		boolean status = objEle.isDisplayed();
		if (status) {
			System.out.println(dispMsg + " is displayed");
			// objEle.click();
		} else {
			System.out.println(dispMsg + " is not displayed");
		}
		return status;
	}

	// select the dropdown using "select by value",
	public static void DropdownSelectByVal(WebElement objEle, String Value) {

		Select selObj = new Select(objEle);
		selObj.selectByValue(Value);
	}

	// Multi select the dropdown using "select by value",
	public static void DropdownMultiSelectByVal(WebElement objEle,String[] arrSplit) {

		Select selObj = new Select(objEle);

		for (String strval : arrSplit) {
			selObj.selectByVisibleText(strval);
		}

	}

	/*
	 * //select the dropdown using "select by visible text", so pass VisibleText as
	 * 'Yellow' to funtion public static void fn_Select(WebElement WE, String
	 * VisibleText){ Select selObj=new Select(WE);
	 * selObj.selectByVisibleText(VisibleText); }
	 * 
	 * //select the dropdown using "select by index", so pass IndexValue as '2'
	 * public static void fn_Select(WebElement WE, int IndexValue){ Select
	 * selObj=new Select(WE); selObj.selectByIndex(IndexValue); }
	 * 
	 * //select the dropdown using "select by value", so pass Value as 'thirdcolor'
	 * public static void fn_Select(WebElement WE, String Value){ Select selObj=new
	 * Select(WE); selObj.selectByValue(Value); }
	 */

}

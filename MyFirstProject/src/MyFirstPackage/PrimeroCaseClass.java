package MyFirstPackage;

import java.awt.Robot;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import PkReadExcelData.NewReadExcelData;
import myUtility.Constants;
import myUtility.ExcelUtils;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PrimeroCaseClass 
{

	public static void main(String[] args) throws Exception
	{
		
		ExcelUtils.setExcelFile( Constants.Path_TestData + Constants.File_TestData,"CaseSheet");
		
		CreateCaseClass mClass = new CreateCaseClass();
		mClass.CreateCaseMethod();
		// mClass.ReadExcelData();		 
		mClass.GetCaseData();
		
	
	}

}
//********************************************************************
//Login Class

/*import org.openqa.selenium.WebDriver;

import pageObjects.Home_Page;

import pageObjects.LogIn_Page;

import utility.ExcelUtils;*/

// Now this method does not need any arguments

/*public class SignIn_Action {

public static void Execute(WebDriver driver) throws Exception{

	//This is to get the values from Excel sheet, passing parameters (Row num &amp; Col num)to getCellData method

	String sUserName = ExcelUtils.getCellData(1, 1);

	String sPassword = ExcelUtils.getCellData(1, 2);

	Home_Page.lnk_MyAccount(driver).click();

	LogIn_Page.txtbx_UserName(driver).sendKeys(sUserName);

	LogIn_Page.txtbx_Password(driver).sendKeys(sPassword);

	LogIn_Page.btn_LogIn(driver).click();

}
*/


//********************************************************************

//Create a child case class
class CreateCaseClass extends BaseClass
{
	
	/**
	 //CreateCaseMethod
	 */
	public void CreateCaseMethod() throws Exception

	{
		//Login();
		dr = RunFromOpenedBrowser();
	
		//Click Case tab
		FindElementByCSSSelector(dr,"a[href*= 'cases?scope%5Bchild_status']").click();
		
		Thread.sleep(2000);
		//Click New Case
		
		FindElementByXpath(dr,"//a[@data-toggle='modules-dropdown']//span[text()='New Case']").click();
		
		//Wait
		 WebDriverWait wait = new WebDriverWait(dr,30);
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'CP')]")));		 
		 
		 WebElement objCP = dr.findElement(By.xpath("//a[contains(text(),'CP')]"));
		 
		 if(IsDiplayed(objCP, "CP"))
			{
			 objCP.click();
			}
		 
		 //NewCase pop up is displayed
		 		
			WebElement objNCase = FindElementByXpath(dr,"//a[contains(text(),'Create New Case')]");
			
			if(IsDiplayed(objNCase, "Pop up"))
			{
				objNCase.click();
			}
					 
		 
		 // If case form is loaded
		 WebElement objCaseLoad =  FindElementByCSSSelector(dr,"div[class='reveal tiny'][id='ids-search']");
		 
		boolean flagcaseLoad =  IsDiplayed(objCaseLoad, "Case Form");
			
	}


	//'Read data from excel'
	public  void GetCaseData() throws Exception
	{
		//WebDriver  dr = RunFromOpenedBrowser();
		
		int rowCount = ExcelUtils.ExcelWSheet.getLastRowNum();
		int row = 2;
		WebElement objWE;
		for(int i=row;i<=rowCount;i++)
		{
	 
			String strName = ExcelUtils.getStringCellData(i,1);					
			int Age = (int)ExcelUtils.getNumericCellData(i, 2);
			String strSex = ExcelUtils.getStringCellData(i,3);
			String strEstimated = ExcelUtils.getStringCellData(i,4);
			String strNationality =	 ExcelUtils.getStringCellData(i,5);
			String strMaritalStatus = ExcelUtils.getStringCellData(i,6);
			
			Thread.sleep(2000);
			FindElementByCSSSelector(dr,"input[id='basic_identity_child_name_first'][name='child[name_first]']").sendKeys(strName);
			
			Thread.sleep(2000);
		
			FindElementByName(dr,"child[age]").sendKeys(String.valueOf(Age));
			
			//checkbox
			Thread.sleep(2000);
			WebElement objch = FindElementById(dr,"basic_identity_child_estimated");	
			
			 objch.click();
			 if(objch.isSelected()) 
				 {
					 System.out.println("estimated checked");
					
				 }
			 
			//Single select
			FindElementByXpath(dr,"//*[@id=\"basic_identity_child_sex_chosen\"]/a/span").click();
			Thread.sleep(2000);
			element = FindElementByXpath(dr,"//div[@id='basic_identity_child_sex_chosen']//div//li[contains(text(),'"+strSex+"')]");		
			element.click();
			Thread.sleep(1000);
			
			//MultiSelect'//
			WebElement nt= dr.findElement(By.xpath("//*[@id=\"basic_identity_child_nationality__chosen\"]/ul/li/input"));
			nt.click();		
			String[] arrSplit = strNationality.split("\\|");
			for (String strval : arrSplit)
			{				
				nt.click();	
				Thread.sleep(2000);
				FindElementByXpath(dr,"//*[@id=\"basic_identity_child_nationality__chosen\"]/div/ul/li[contains(text(),'"+strval+"')]").click();
				
			}
			//Single select strMaritalStatus
			FindElementByXpath(dr,"//*[@id=\"basic_identity_child_maritial_status_chosen\"]/a/span").click();
			Thread.sleep(2000);
			element = FindElementByXpath(dr,"//*[@id=\"basic_identity_child_maritial_status_chosen\"]/div/ul/li[contains(text(),'"+strMaritalStatus+"')]");		
			element.click();
			Thread.sleep(1000);
				 
			/*System.out.println("data :"+strName);
			System.out.println("data :"+Age);
			System.out.println("data :"+strSex);
			System.out.println("data :"+strEstimated);
			System.out.println("data :"+strNationality);
			System.out.println("data :"+strMaritalStatus);*/
			
			ExcelUtils.setCellData("Pass", i, 7);
									
		}
	 			
	}
	
	
}

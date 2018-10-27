package com.primero.qa.testcases;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.primero.qa.pages.CaseListPage;
import com.primero.qa.pages.Homepage;
import com.primero.qa.pages.LoginPage;
import com.primero.qa.pages.NewCasePage;
import com.primero.qa.testbase.TestBaseClass;
import com.primero.qa.testdata.ReadWriteExcelData;
import com.primero.qa.util.ExcelUtil;

public class CreateCaseTest extends TestBaseClass {

	Homepage objHome;
	CaseListPage objCaseListPage;
	NewCasePage objNewCasePage;
	LoginPage objlogin;

	public CreateCaseTest() {
		super();
		// checkIfBrowserExists(false);
		// this constructor is called without child class new keyword, as
		// testng uses reflection internally which triggers class instantiation
		// internally.
	}

	@BeforeClass
	public void setup() {

		
		try {
			// Browser Initialization();
			checkIfBrowserExists(false);
			setExcel();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(priority = 1)
	public void LoginIntoPrimero() throws Exception {

		objlogin = new LoginPage();

		String strtitle = objlogin.checkLoginPageTitle();
		Assert.assertEquals(strtitle, "Login");

		objlogin.login(prop.getProperty("Username"), prop.getProperty("Password"));
		objHome = objlogin.loginClick();
		Thread.sleep(1000);
		Assert.assertEquals(objHome.checkLoggedInUsername(prop.getProperty("Username")), true);

		objCaseListPage = objHome.tabSelect("CASES");
		Thread.sleep(1000);
	}

	@Test(priority = 2)
	public void CreateNewCaseForm() throws Exception {
		try {

			objNewCasePage = objCaseListPage.pNavigatenewCPCaseForm();
			Assert.assertTrue(objNewCasePage.checkNewcaseFormLoaded(), "Form loaded successfully");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	@Test(dataProvider="getExcelCaseData",priority = 2,dataProviderClass=ReadWriteExcelData.class)
	public void FeedDatatoNewCaseForm(String str1,String str2,String str3,String str4,String str5,String str6,String str7) throws Exception
	{
	System.out.println(str1+"first iter");
	objNewCasePage.fillcpcaseform( str1, str2, str3, str4, str5, str6,str7);
	
	String strCaseId = objNewCasePage.SaveaCase();
	
	boolean blnCaseFalg =false;
	if(strCaseId!=null)
	{
	
	  blnCaseFalg = true;
	  objCaseListPage=  objHome.tabSelect("CASES");
	}
	Assert.assertTrue(blnCaseFalg, "Case"+strCaseId+"Created Successfully");
	
	//Assert.assertTrue(driver.getTitle().matches(".*TST-\\d{5}.*"));
	
	}

	@AfterClass
	public void teardown() {


		//driver.close();
	}
}




//We can pass the result directly to the pom class without dataprovider.

/*
@Test(priority = 2)
public void FeedDatatoNewCaseForm() {
	int iRow = ExcelUtil.getCellRowNum("CaseSheet", "Test_Id", "Test_1");
	Object[] obj1 = new Object[6];
	String strFlag = ExcelUtil.getCellData("CaseSheet", "RunFlag", iRow);
	String excelFlag = "Y";
	if ((strFlag.toUpperCase().trim()).equals(excelFlag)) {

		// String strName = getCellData("CaseSheet", "Name", iRow);
		obj1[0] = ExcelUtil.getCellData("CaseSheet", "Name", iRow);
		// String strAge = getCellData("CaseSheet", "Age", iRow);
		obj1[1] = ExcelUtil.getCellData("CaseSheet", "Age", iRow);
		// String strSex = getCellData("CaseSheet", "Sex", iRow);
		obj1[2] = ExcelUtil.getCellData("CaseSheet", "Sex", iRow);
		obj1[3] = ExcelUtil.getCellData("CaseSheet", "AgeEstimated", iRow);
		// String strNationality = getCellData("CaseSheet", "Nationality", iRow);
		obj1[4] = ExcelUtil.getCellData("CaseSheet", "Nationality", iRow);
		// String strMaritalStatus = getCellData("CaseSheet", "MaritalStatus", iRow);

		obj1[5] = ExcelUtil.getCellData("CaseSheet", "MaritalStatus", iRow);

		System.out.println(obj1[0]);

		objNewCasePage.fillcpcaseform(obj1);
	}*/
//}
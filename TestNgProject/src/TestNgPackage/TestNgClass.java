package TestNgPackage;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TestNgClass {


  @BeforeMethod
  public void Launch() {
	 System.out.println("Launchbrowser");
  }
  
  @Test(priority=1)
  public void Enteruser() {
	 System.out.println("enter user");
  }
  
  @Test(priority=2)
  public void Enterpwd() {
	 System.out.println("enter pwd");
  }
  
  @AfterMethod
  public void close() {
	 System.out.println("closebrowser");
  }

/*  @AfterTest
  public void afterTest() {
  }*/

  
}

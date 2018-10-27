package MyFirstPackage;

		
		
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyFirstClass {
	
	public void Method1()
	{
		System.setProperty("webdriver.chrome.driver", "C:/Eclipse/chromedriver.exe");
		
		
		//WebDriver drNew = new ChromeDriver();
		
		
		ChromeOptions cOption = new ChromeOptions();
		cOption.setExperimentalOption("debuggerAddress", "localhost:9014");
		
		WebDriver dr = new ChromeDriver(cOption);
		
		/*
		 dr.get("https://primero-qa-v1-5.dev.quoininc.com/login");
		 System.out.println(dr.getTitle());
		
		 dr.findElement(By.xpath("//input[@id='user_name']")).sendKeys("primero");
		 dr.findElement(By.xpath("//*[contains(@id,'password')]")).sendKeys("qu01n23!");
		 dr.findElement(By.cssSelector(".button")).click();*/
		
		 dr.findElement(By.cssSelector("a[href*= 'cases?scope%5Bchild_status']")).click();
		 
		// dr.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		 
		 dr.findElement(By.cssSelector("a[data-toggle='modules-dropdown']")).click();


		 //dr.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		 WebDriverWait wait = new WebDriverWait(dr,30);
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'CP')]")));

		 WebElement cpVal = dr.findElement(By.xpath("//a[contains(text(),'CP')]"));
		 boolean status = cpVal.isDisplayed();
		 if(status)
		 {
			 System.out.println("cp is displayed");
			 dr.findElement(By.xpath("//a[contains(text(),'CP')]")).click();
		 }
		 else
		 {
			 System.out.println("cp is not displayed");
		 }
		 
		 						 
		 WebElement cpVal1 = dr.findElement(By.cssSelector("div[class='reveal tiny'][id='ids-search']"));
		 
		 boolean status1 = cpVal1.isDisplayed();
		 if(status1)
		 {
			 System.out.println("pop up is displayed");
			 dr.findElement(By.xpath("//a[contains(text(),'Create New Case')]")).click();
		 }
		 else
		 {
			 System.out.println("pop up is not displayed");
		 }
		 
		 //enter case form details
		 
		 dr.findElement(By.xpath("//a[contains(text(),'Create New Case')]")).click();
		//div//span/label[contains(text(),'Case ID')]
		 
		 
		
	}
	

}



 class MainClass
{
 public static void main(String[] args)
 {
	 MyFirstClass mClass = new MyFirstClass();
	 mClass.Method1();
 }
}
 
/* 
 WebDriverWait wait = new WebDriverWait(driver, 10);
 WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id*/
		 
		 
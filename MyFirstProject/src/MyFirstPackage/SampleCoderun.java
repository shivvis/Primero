package MyFirstPackage;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class SampleCoderun extends BaseClass{

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		String strNationality = "Angola|Algeria";
		dr = RunFromOpenedBrowser();
		String[] arrSplit = strNationality.split("\\|");

		/*for (String strval : arrSplit)
		{

			WebElement nt= dr.findElement(By.xpath("//*[@id=\"basic_identity_child_nationality__chosen\"]/ul/li/input"));
			nt.click();
		
			Thread.sleep(2000);
			FindElementByXpath(dr,"//*[@id=\"basic_identity_child_nationality__chosen\"]/div/ul/li[contains(text(),'"+strval+"')]").click();
			
			//*[@id="basic_identity_child_nationality__chosen"]/div/ul/li[contains(text(),'Albania')]

		
			
		}*/
	/*	WebElement nt= dr.findElement(By.xpath("//*[@id=\"basic_identity_child_nationality__chosen\"]/ul/li/input"));
		nt.click();*/
		
	/*	Thread.sleep(2000);
		WebElement objch = FindElementById(dr,"basic_identity_child_estimated");	
		
		 objch.click();
		 if(objch.isSelected()) 
			 {
				 System.out.println("estimated checked");
				
			 }*/
		String strMaritalStatus ="Single";
		 
			FindElementByXpath(dr,"//*[@id=\"basic_identity_child_maritial_status_chosen\"]/a/span").click();
			Thread.sleep(2000);
			element = FindElementByXpath(dr,"//*[@id=\"basic_identity_child_maritial_status_chosen\"]/div/ul/li[contains(text(),'"+strMaritalStatus+"')]");		
			element.click();
			Thread.sleep(1000);
		
	}

}



//MultiSelect'//
// DropdownMultiSelectByVal(FindElementByXpath(dr,"child[nationality][]"),arrSplit);
 


/*Thread.sleep(2000);
WebElement sex= dr.findElement(By.xpath("//select[@name='child[sex]']//preceding::div[contains(@class,'chosen-container-single-nosearch')]"));
Boolean status = sex.isEnabled();
System.out.println(status);
Actions actions = new Actions(dr);

actions.moveToElement(sex).click().build().perform();

JavascriptExecutor js = (JavascriptExecutor)dr;
//This will scroll the page till the element is found		
js.executeScript("arguments[0].click()", sex);
//js.executeScript("window.scrollBy(0,1000)", "");
//  sex.click();
*/

/*element = FindElementByXpath(dr,"//*[@id='basic_identity_child_sex_chosen']");
element.click();
Thread.sleep(5000);
element = FindElementByXpath(dr,"//div[@id='basic_identity_child_sex_chosen']//div//li[@data-option-array-index='2'][contains(text(),'Female')]");

element.click();
*/
//div[@id='basic_identity_child_sex_chosen']//div//li[@data-option-array-index='2']
//div[@id='basic_identity_child_sex_chosen']//div//li[@data-option-array-index='2']

/*			Actions builder = new Actions(dr);
Action mouseOverAdmin = builder.moveToElement(obje).build();
mouseOverAdmin.perform();*/
// obje.click();
//FindElementByXpath(dr,"//*[@id=\"basic_identity_child_sex_chosen\"]").sendKeys(Keys.PAGE_DOWN); 			

//objsel = dr.findElement(By.id("basic_identity_child_sex"));

/*Select selObj = new Select(dr.findElement(By.id("basic_identity_child_sex")));
selObj.selectByValue("male");

*/

//DropdownSelectByVal(obje,"male");

	

//DropdownSelectByVal(FindElementByXpath(dr,"//select[@name='child[maritial_status]']"),strMaritalStatus);

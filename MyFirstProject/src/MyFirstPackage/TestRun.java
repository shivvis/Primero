package MyFirstPackage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
//import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class TestRun extends BaseClass {

	public static void main(String[] args) throws Exception {
		
		
		
		
		// TODO Auto-generated method stub
		/*
		 * String strNationality ="applke:Banana:Orange"; // String[] arrSplit =
		 * strNationality.split("|"); List<String> list = new ArrayList<String>();
		 * String[] arrSplit = strNationality.split(":");
		 * //System.out.println(Arrays.toString(arrSplit));
		 * System.out.println(arrSplit[0]);
		 * 
		 * 
		 * String str = "GeeksforGeeks;A Computer Science Portal"; String[] arrOfStr =
		 * str.split(";");
		 * for (String a : arrSplit) System.out.println(a);
		 * 
		 */
		dr = RunFromOpenedBrowser();
/*//1
		WebElement root1 = dr.findElement(By.tagName("app-shell"));

		WebElement ShadowR1 = (WebElement) ((JavascriptExecutor) dr).executeScript("return arguments[0].shadowRoot",
				root1);
// 2
		WebElement root2 = ShadowR1.findElement(By.cssSelector("action-points-page-main"));

		WebElement ShadowR2 = (WebElement) ((JavascriptExecutor) dr).executeScript("return arguments[0].shadowRoot",
				root2);

// 3
		
		WebElement root3 = ShadowR2.findElement(By.cssSelector("action-points-new"));

		WebElement ShadowR3 = (WebElement) ((JavascriptExecutor) dr).executeScript("return arguments[0].shadowRoot",
				root3);

// 4		
		WebElement root4 = ShadowR3.findElement(By.cssSelector("action-point-details"));

		WebElement ShadowR4 = (WebElement) ((JavascriptExecutor) dr).executeScript("return arguments[0].shadowRoot",
				root4);

// 5	
		
		WebElement root5 = ShadowR4.findElement(By.cssSelector("paper-checkbox"));

		WebElement ShadowR5 = (WebElement) ((JavascriptExecutor) dr).executeScript("return arguments[0].shadowRoot",
				root5);
		
	//checkbox
		
		WebElement echeckbox = ShadowR5.findElement(By.id("checkboxContainer"));

		echeckbox.click();*/
	
		
		/*WebElement	search_button =(WebElement) ((JavascriptExecutor) dr).executeScript("return document.querySelector('app-shell').shadowRoot.querySelector('action-points-page-main').shadowRoot.querySelector('action-points-new').shadowRoot.querySelector('action-point-details').shadowRoot.querySelector('paper-checkbox').shadowRoot.getElementById('checkboxContainer')");
		search_button.click();
		*/

		// .executeScript("return document.querySelector(').shadowRoot",
		// "paper-checkbox");

		/*
		 * WebElement ele = (WebElement) ((JavascriptExecutor)dr)
		 * .executeScript("return arguments[0].shadowRoot", "paper-checkbox");
		 */
		// .executeScript("return document.querySelector(').shadowRoot",
		// "paper-checkbox");

		/*
		 * ele.findElement(By.id("checkboxContainer"));
		 * 
		 * ele.click();
		 */
		/*
		 * WebElement Rootele=GetRootElement(element);
		 * 
		 * ele=Rootele.getElement(By.ID/cssSelector/xPATH);
		 * 
		 * ele.<ActionName>
		 */

	}

}

/*
 * public WebElement
 * 
 * IWebDriver driver;
 * 
 * public IWebElement getUIObject(params By[] shadowRoots) { IWebElement
 * currentElement = null; IWebElement parentElement = null; int i = 0; foreach
 * (var item in shadowRoots) { if (parentElement == null) { currentElement =
 * driver.FindElement(item); } else { currentElement =
 * parentElement.FindElement(item); } if(i !=(shadowRoots.Length-1)) {
 * parentElement = expandRootElement(currentElement); } i++; } return
 * currentElement; }
 * 
 * public IWebElement expandRootElement(IWebElement element) { IWebElement
 * rootElement = (IWebElement)((IJavaScriptExecutor)driver)
 * .ExecuteScript("return arguments[0].shadowRoot", element); return
 * rootElement; }
 * 
 * 
 * [TestMethod] public void test() { IWebElement searchButton=
 * getUIObject(By.CssSelector("downloads-manager"),By.CssSelector(
 * "downloads-toolbar"),By.Id("search-input"),By.Id("search-buton"));
 * searchButton.Click(); }
 * 
 * 
 */

//search_button=driver.execute_script('return document.querySelector("downloads-manager").shadowRoot.querySelector("downloads-toolbar").shadowRoot.querySelector("cr-search-field").shadowRoot.querySelector("#search-button")')search_button.click();



/*Annotations
@Test(dependsOnMethods={"Test2"})*/
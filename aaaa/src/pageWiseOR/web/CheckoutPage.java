package pageWiseOR.web;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.GlobalVar;
import utilities.Utility;

public class CheckoutPage {
	Utility utilObj = new Utility();
	Properties pageProp = utilObj.loadPageProperties(GlobalVar.CURRENT_PROJECT_PATH + "/src/pageWiseOR/web/pageProperties/checkoutPage.properties");
		
	public  static CheckoutPage getInstance()
	{	
		return new CheckoutPage();		
	}

	
	public WebElement emailCheckoutPage(WebDriver driver){
			
		WebElement element = driver.findElement(By.id(pageProp.getProperty("checkoutPage_Email")));
		return element;
	}
	
	
	public WebElement passwordCheckoutPage(WebDriver driver){
		
		WebElement element = driver.findElement(By.id(pageProp.getProperty("checkoutPage_Password")));
		return element;
	}

	
public WebElement continueCheckoutPage(WebDriver driver){
		
		WebElement element = driver.findElement(By.className(pageProp.getProperty("checkoutPage_Continue")));
		return element;
	}

}

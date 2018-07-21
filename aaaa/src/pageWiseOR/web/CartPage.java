package pageWiseOR.web;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.GlobalVar;
import utilities.Utility;

public class CartPage {
	Utility utilObj = new Utility();
	Properties pageProp = utilObj.loadPageProperties(GlobalVar.CURRENT_PROJECT_PATH + "/src/pageWiseOR/web/pageProperties/cartPage.properties");
		
	public  static CartPage getInstance()
	{	
		return new CartPage();		
	}

	
	public WebElement productNameOnCartPage(WebDriver driver){
			
		WebElement element = driver.findElement(By.cssSelector(pageProp.getProperty("cartPage_ProductName")));
		return element;
	}
		
	public WebElement placeOrderButton(WebDriver driver){
		
		WebElement element = driver.findElement(By.linkText(pageProp.getProperty("cartPage_PlaceOrder")));
		return element;
	}
	
	
	
	
	public WebElement loginButton(WebDriver driver)
	{  
		WebElement element = driver.findElement(By.cssSelector("button.btn.btn-login"));
		return element;
	}
	
	public WebElement emailTextField(WebDriver driver)
	{
		WebElement element = driver.findElement(By.id("emailid"));
		return element;
	}
	
   public WebElement passwordTextField(WebDriver driver)
   {
	   WebElement element = driver.findElement(By.id("password"));
		return element;

   }
   
   public WebElement keepMeLoggedIn(WebDriver driver){
	   WebElement element=driver.findElement(By.id("staysignin"));
	   return element;
   }
   
   public WebElement googleButton(WebDriver driver) {
	   WebElement element = driver.findElement(By
	     .xpath("//a[@id='googlePlus']/img"));

	   return element;
	  }
	  public WebElement facebookButton(WebDriver driver) {
	   WebElement element = driver.findElement(By
	     .xpath("//a[@id='FBlogin']/img"));

	   return element;
	  }
	  public WebElement linkedinButton(WebDriver driver) {
	   WebElement element = driver.findElement(By
	     .xpath("//a[@id='linkedIn']/img"));

	   return element;
	  }
  public WebElement loginErrorObject(WebDriver driver)
  {
	  WebElement element=driver.findElement(By.className("error"));
	  return element;
  }
}

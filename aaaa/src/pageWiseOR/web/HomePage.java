package pageWiseOR.web;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.GlobalVar;
import utilities.Utility;

public class HomePage {
	Utility utilObj = new Utility();
	Properties pageProp = utilObj.loadPageProperties(GlobalVar.CURRENT_PROJECT_PATH + "/src/pageWiseOR/web/pageProperties/homePage.properties");
		
	public  static HomePage getInstance()
	{	
		return new HomePage();		
	}

	
	public WebElement homePageBanner(WebDriver driver){
			
		WebElement element = driver.findElement(By.id(pageProp.getProperty("homePage_Banner_div")));
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

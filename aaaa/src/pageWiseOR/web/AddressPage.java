package pageWiseOR.web;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.GlobalVar;
import utilities.Utility;

public class AddressPage {
	Utility utilObj = new Utility();
	Properties pageProp = utilObj.loadPageProperties(GlobalVar.CURRENT_PROJECT_PATH + "/src/pageWiseOR/web/pageProperties/addressPage.properties");
		
	public  static AddressPage getInstance()
	{	
		return new AddressPage();		
	}

	
	public WebElement firstNameAddressPage(WebDriver driver){
		
		WebElement element = driver.findElement(By.id(pageProp.getProperty("addressPage_FirstName")));
		return element;
	}
		
	public WebElement continueAddressPage(WebDriver driver){
		
		WebElement element = driver.findElement(By.name(pageProp.getProperty("addressPage_Continue")));
		return element;
	}
}

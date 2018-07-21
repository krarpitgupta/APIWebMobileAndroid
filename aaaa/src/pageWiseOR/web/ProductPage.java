package pageWiseOR.web;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.GlobalVar;
import utilities.Utility;

public class ProductPage {
	Utility utilObj = new Utility();
	Properties pageProp = utilObj.loadPageProperties(GlobalVar.CURRENT_PROJECT_PATH + "/src/pageWiseOR/web/pageProperties/productPage.properties");
		
	public  static ProductPage getInstance()
	{
		return new ProductPage();
	}
	
	public WebElement buyNowButton(WebDriver driver){
		WebElement element = driver.findElement(By.className(pageProp.getProperty("productPage_buyNow_Button")));
		return element;
	}
	
	public WebElement productName(WebDriver driver){
		WebElement element = driver.findElement(By.xpath(pageProp.getProperty("productPage_productname")));
		return element;
	}
	
}

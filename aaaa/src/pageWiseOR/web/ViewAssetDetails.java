package pageWiseOR.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ViewAssetDetails {
	
	
	public  static ViewAssetDetails getInstance()
	{
		return new ViewAssetDetails();
	}
  
	public WebElement companyName(WebDriver driver)
	{
		
		WebElement companyName=driver.findElement(By.xpath("//*[@id='stockListingTbl']/tbody/tr/td[1]/a"));
		return companyName;		
	}
	
}

package pageWiseOR.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CorporateAction {

  public static CorporateAction getInstance()
  {
	  return new CorporateAction();
  }
  
  public WebElement acceptAll(WebDriver driver)
  {
	  WebElement acceptAll=driver.findElement(By.id("acceptAllButton"));
	  return acceptAll;
  }
  
  public WebElement viewAll(WebDriver driver)
  {
	  WebElement viewAll=driver.findElement(By.id("viewAllButton"));
	  return viewAll;
  }
}

package pageWiseOR.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CompanyInfo {

	public static CompanyInfo getInstance()
	{
		return new CompanyInfo();
	}
	
	public WebElement currentPrice(WebDriver driver)
	{
		
		WebElement currentPrice=driver.findElement(By.id("equityTransCurrentPrice"));
		return currentPrice;
		
	}
	
	public WebElement quantity(WebDriver driver)
	{
		WebElement quantity=driver.findElement(By.id("equityTransQuantity"));
		return quantity;
	}
	
	public WebElement investment(WebDriver driver)
	{
		WebElement investMent=driver.findElement(By.id("equityTransInvestment"));
		return investMent;
	}
	
	public WebElement avgCost(WebDriver driver)
	{
		WebElement avgCost=driver.findElement(By.id("equityTransAvgPrice"));
		return avgCost;
	}
	
	public WebElement todayGainLoss(WebDriver driver)
	{
		WebElement todayGainLoss=driver.findElement(By.id("equityTransTodaysGainLossAbs"));
		return todayGainLoss;
		
	}
	
	public WebElement overAllGainLoss(WebDriver driver)
	{
		WebElement todayGainLoss=driver.findElement(By.id("equityTransOvrlGainLossAbs"));
		return todayGainLoss;
		
		
	}
	
	public WebElement transactionCurrentValue(WebDriver driver)
	{
		WebElement transactionCurrentValue=driver.findElement(By.id("equityTransCurrentValue"));
		return transactionCurrentValue;
	}
	public WebElement listingTblMF(WebDriver driver)
	{
		WebElement element=driver.findElement(By.id("MFListingTbl"));
		return element;
	}
    
     public String getTableXpath()
    {
    	 String xpath="//*[@id='stockListingTbl']/tbody/tr";
    	 return xpath;
      }
     public String getTableXpathMF()
     {
     	 String xpath="//*[@id='MFListingTbl']/tbody/tr";
     	 return xpath;
       }
     public WebElement txnHistory(WebDriver driver)
 	{
 		
 		WebElement companyName=driver.findElement(By.xpath("//*[@id='txnHistory']/tbody/tr"));
 		return companyName;		
 	}
}

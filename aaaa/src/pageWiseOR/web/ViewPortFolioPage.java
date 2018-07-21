package pageWiseOR.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ViewPortFolioPage {



	public static ViewPortFolioPage getViewPortFolioInstance()
	{
		return new ViewPortFolioPage();
	}

	public WebElement welcomeLogo(WebDriver driver)
	{
		WebElement we=driver.findElement(By.id("wcom"));
		return we;
	}
	public WebElement newTransactionLabel(WebDriver driver)
	{
		WebElement element =  driver.findElement(By.linkText("New Transactions"));

		return element;

	}
	
	public WebElement userId(WebDriver driver)
	{
		WebElement element=driver.findElement(By.className("newtop"));
		return element;
	}
	
	public WebElement sensex(WebDriver driver)
	{
		WebElement element=driver.findElement(By.id("sensexCurrentValue"));
		return element;
	}
	
	public WebElement nifty(WebDriver driver)
	{
		WebElement element=driver.findElement(By.id("niftyCurrentValue"));
		return element;
	}
	public WebElement myNetWorth(WebDriver driver)
	{
		WebElement element = null;
		try{
		element=driver.findElement(By.id("dCurrentValuation"));
		System.out.println(element);
		}catch(Exception e){
			
		}
		return element;
	}
	public WebElement myPortfolioCurrentValue(WebDriver driver)
	{
		WebElement element=driver.findElement(By.id("dashBoardCurrentValuation"));
		return element;
	}
	public WebElement investmentsAmount(WebDriver driver)
	{
		WebElement element=driver.findElement(By.id("dashBoardInvestment"));
		return element;
	}
	public WebElement stockListing(WebDriver driver)
	{
		WebElement element=driver.findElement(By.id("stockListingTbl"));
		return element;
	}
	public WebElement stockLink(WebDriver driver)
	{
		WebElement element=driver.findElement(By.className("stockLink"));
		return element;
	}
	public WebElement stockLinkAdd(WebDriver driver)
	{
		WebElement element=driver.findElement(By.xpath("//span[@class='stockLink']/a/span[2]"));
		return element;
	}
	public WebElement mutualFundAdd(WebDriver driver)
	{
		WebElement element=driver.findElement(By.xpath("//span[@class='mfLink']/a/span[2]"));
		return element;
	}
	public WebElement etFAdd(WebDriver driver)
	{
		WebElement element=driver.findElement(By.xpath("//span[@class='etfLink']/a/span[2]"));
		return element;
	}
	public WebElement fixedIncomeAdd(WebDriver driver)
	{
		WebElement element=driver.findElement(By.xpath("//span[@class='fiLink']/a/span[2]"));
		return element;
	}
	public WebElement otherAssetsAdd(WebDriver driver)
	{
		WebElement element=driver.findElement(By.xpath("//span[@class='otherAssetLink']/a/span[2]"));
		return element;
	}
	
	public WebElement stockCurrentValuationObject(WebDriver driver)
	{
		WebElement element=driver.findElement(By.xpath("//span[@class='stockLink']/a/span[4]"));
		return element;
	}
	public WebElement todaysChange(WebDriver driver)
	{
		WebElement element=driver.findElement(By.id("dTodaysGainLossAbs"));
		return element;
	}
	public WebElement todaysChangeAbsObject(WebDriver driver)
	{
		WebElement element=driver.findElement(By.xpath("//span[@class='stockLink']/a/span[2]"));
		return element;
	}
	public WebElement uploadTransactions(WebDriver driver)
	{
		WebElement element=driver.findElement(By.id("uploadTxn"));
		return element;
	}
	public WebElement stoksRadioButton(WebDriver driver)
	{
		WebElement element=driver.findElement(By.id("stkRadio"));
		return element;
	}
	public WebElement mutualFundsRadioButton(WebDriver driver)
	{
		WebElement element=driver.findElement(By.id("mfRadio"));
		return element;
	}
	public WebElement etfRadioButton(WebDriver driver)
	{
		WebElement element=driver.findElement(By.id("etfRadio"));
		return element;
	}
	public WebElement uploadFileBrowse(WebDriver driver)
	{
		WebElement element=driver.findElement(By.id("fileupload"));
		return element;
	}
	public WebElement uploadFileBrowseButton(WebDriver driver)
	{
		WebElement element=driver.findElement(By.id("upload-btn"));
		return element;
	}
	public WebElement getStatusPageObject(WebDriver driver)
	{
		WebElement element=driver.findElement(By.id("getStatusPage"));
		return element;
	}
	public WebElement addMutualFunds(WebDriver driver)
	{
		WebElement element=driver.findElement(By.cssSelector("a[title=\"Click to add Mutual Fund to your portfolio\"]"));
		return element;
	}
	
	public WebElement corporateAction(WebDriver driver)
	{
		WebElement corporateActionLabel=driver.findElement(By.id("pendingActions"));
		return corporateActionLabel;
	}
	
	
	public WebElement pendingActionsHighlight(WebDriver driver)
	{
		WebElement element=driver.findElement(By.id("pendingActionsHighlight"));
		return element;
	}
	
	public String transactionHistory()
	{
	   String xpath="";
	   return xpath;
	}
	
}

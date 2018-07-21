package pageWiseOR.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NewTransactionPage {

	public static NewTransactionPage getInstance() {
		return new NewTransactionPage();
	}

	public WebElement createNewPortfolio(WebDriver driver) {
		WebElement element = driver.findElement(By.id("addButTxn"));
		return element;
	}

	public WebElement portfolioName(WebDriver driver) {
		WebElement element = driver.findElement(By.id("pname"));
		return element;
	}

	public WebElement portfolioPopUpButton(WebDriver driver) {
		WebElement element = driver.findElement(By.id("addButPop"));
		return element;
	}

	public WebElement selectPortfolio(WebDriver driver) {
		WebElement element = driver.findElement(By.id("portfolioSel"));

		return element;
	}

	public WebElement stocks(WebDriver driver) {
		WebElement stocks = driver.findElement(By.id("StockMarket"));
		return stocks;
	}

	public String date() {
		String id = "id=transactionDates";
		// if(row==0)
		// id=id+"";
		// else
		// id=id+row;

		return id;
	}

	public WebElement companyName(WebDriver driver) {
		String id = "stkSearch";
		// if(row==0)
		// id=id+"";
		// else
		// id=id+row;
		//

		WebElement companyName = driver.findElement(By.id(id));
		return companyName;
	}

	public WebElement exchange(WebDriver driver) {
		String id = "exchangeType";
		// if(row==0)
		// id=id+"";
		// else
		// id=id+row;
		//
		//
		WebElement exchange = driver.findElement(By.id(id));
		return exchange;
	}

	public WebElement quantity(WebDriver driver) {

		String id = "stkQty";
		// if(row==0)
		// id=id+"";
		// else
		// id=id+row;
		//
		WebElement quantity = driver.findElement(By.id(id));
		return quantity;
	}

	public WebElement price(WebDriver driver) {
		String id = "prices";
		// if(row==0)
		// id=id+"";
		// else
		// id=id+row;
		//
		WebElement price = driver.findElement(By.id(id));
		return price;
	}

	public WebElement addRowButton(WebDriver driver) {
		WebElement addRow = driver.findElement(By.id("addRow"));
		return addRow;
	}

	public WebElement referesh(WebDriver driver) {
		WebElement referesh = driver.findElement(By.className("Refresh"));
		return referesh;
	}

	public WebElement saveAndContinue(WebDriver driver) {
		WebElement saveAndContinue = driver.findElement(By
				.xpath("//*[@id='addStkForm']/div/div[5]/input[1]"));
		return saveAndContinue;
	}

	public WebElement saveAndAnotherStock(WebDriver driver) {
		WebElement saveAndAnotherStock = driver.findElement(By
				.xpath("//*[@id='addStkForm']/div/div[5]/input[2]"));
		return saveAndAnotherStock;

	}

	public WebElement transactionType(WebDriver driver) {
		WebElement type = driver.findElement(By
				.xpath("//*[@id='addStkForm']/div/div[1]/div[3]/select"));
		return type;
	}

	public WebElement exchangeType(WebDriver driver) {
		WebElement type = driver.findElement(By.id("exchangeType"));
		return type;
	}
	
	public WebElement otherCharges(WebDriver driver)
	{
		WebElement otherCharges=driver.findElement(By.xpath("//*[@id='addStkForm']/div/div[2]/div[4]/div[2]/input"));
		return otherCharges;
	}
	
	public WebElement STT(WebDriver driver)
	{
		WebElement stt=driver.findElement(By.xpath("//*[@id='addStkForm']/div/div[2]/div[1]/div[2]/input"));
		return stt;
	}
	
	public WebElement brokerAge(WebDriver driver)
	{
		WebElement brokerage=driver.findElement(By.xpath("//*[@id='addStkForm']/div/div[2]/div[2]/div[2]/input"));
		return brokerage;
	}
	
	public WebElement serviceText(WebDriver driver)
	{
		
		WebElement serviceText=driver.findElement(By.xpath("//*[@id='addStkForm']/div/div[2]/div[3]/div[2]/input"));
		return serviceText;
	}

 public WebElement notes(WebDriver driver)
 {
	 
	 WebElement notes=driver.findElement(By.xpath("//*[@id='addStkForm']/div/div[2]/div[5]/div[2]/input"));
	 return notes;
 }

	public WebElement mutualFundsTab(WebDriver driver) {
		WebElement type = driver.findElement(By
				.xpath("//a[@id='MutualFunds']/span[2]"));
		return type;
	}

	public WebElement mutualFundHouseDropDown(WebDriver driver) {
		WebElement type = driver.findElement(By.id("amcId"));
		return type;
	}

	public WebElement categoryDropDown(WebDriver driver) {
		WebElement type = driver.findElement(By.id("categoryId"));
		return type;
	}

	public WebElement schemeDropDown(WebDriver driver) {
		WebElement type = driver.findElement(By.id("scheme"));
		return type;
	}

	public WebElement normalRadioButton(WebDriver driver) {
		WebElement type = driver.findElement(By.id("nType"));
		return type;
	}

	public WebElement sipRadioButton(WebDriver driver) {
		WebElement type = driver.findElement(By.id("sipType"));
		return type;
	}

	public WebElement swpRadioButton(WebDriver driver) {
		WebElement type = driver.findElement(By.id("swpType"));
		return type;
	}
	public WebElement stpRadioButton(WebDriver driver) {
		WebElement type = driver.findElement(By.id("mfType"));
		return type;
	}
	public WebElement switchRadioButton(WebDriver driver) {
		WebElement type = driver.findElement(By.id("switchMfType"));
		return type;
	}

	public WebElement nplusSipRadioButton(WebDriver driver) {
		WebElement type = driver.findElement(By.id("nplussipType"));
		return type;
	}

	public WebElement saveNAddMFButton(WebDriver driver) {
		WebElement type = driver.findElement(By
				.xpath("//input[@value='Save & Add Another MF']"));
		return type;
	}

	public WebElement saveNContinueMFButton(WebDriver driver) {
		WebElement type = driver.findElement(By
				.xpath("(//input[@value='Save & Continue'])[3]"));
		return type;
	}

	public String dateObjectForMF() {
		String id = "id=transactionDatess";
		return id;
	}

	public WebElement unitsEditBox(WebDriver driver) {
		WebElement type = driver.findElement(By.id("qtys"));
		return type;
	}

	public WebElement navEditBox(WebDriver driver) {
		WebElement type = driver.findElement(By.id("price"));
		return type;
	}

	public WebElement mfTransactionType(WebDriver driver) {
		WebElement element = driver.findElement(By.id("mfTransactionType"));
		return element;
	}

	public WebElement addMFButton(WebDriver driver) {
		WebElement element = driver.findElement(By.xpath("(//a[@id='addMfRow'])[2]"));
		return element;
	}

	public WebElement chargesEditBox(WebDriver driver) {
		WebElement element = driver.findElement(By.name("otherChargesNSIP"));
		return element;
	}

	public WebElement entryLoad(WebDriver driver) {
		WebElement element = driver.findElement(By.id("mfloadtype"));
		return element;
	}

	public WebElement loadValueNSIP(WebDriver driver) {
		WebElement element = driver.findElement(By.id("loadValueNSIP"));
		return element;
	}

	public WebElement balanceQuantity(WebDriver driver) {
		WebElement element = driver.findElement(By.id("equityTransQuantity"));
		return element;
	}

	public WebElement lastNAVValue(WebDriver driver) {
		WebElement element = driver.findElement(By
				.id("equityTransCurrentPrice"));
		return element;
	}

	public WebElement currentValue(WebDriver driver) {
		WebElement element = driver.findElement(By
				.id("equityTransCurrentValue"));
		return element;
	}

	public WebElement activeScheme(WebDriver driver) {
		WebElement element = driver.findElement(By.id("scheme"));
		return element;
	}

	public WebElement equityTransAvgPrice(WebDriver driver) {
		WebElement element = driver.findElement(By.id("equityTransAvgPrice"));
		return element;
	}

	public String mfStartDate() {
		String id = "id=mfStartDate";
		return id;
	}

	public WebElement frequency(WebDriver driver) {
		WebElement element = driver.findElement(By.name("frequency"));
		return element;
	}

	public WebElement sipAmount(WebDriver driver) {
		WebElement element = driver.findElement(By.name("sipAmount"));
		return element;
	}

	public String mfEndDate() {
		String id = "id=mfEndDate";
		return id;
	}

	public WebElement installments(WebDriver driver) {
		WebElement element = driver.findElement(By.name("installments"));
		return element;
	}
	public WebElement withdrawalTypes(WebDriver driver) {
		WebElement element = driver.findElement(By.id("withdrawalTypes"));
		return element;
	}
	public WebElement units(WebDriver driver) {
		WebElement element = driver.findElement(By.name("units"));
		return element;
	}
	public WebElement saveNContinueMFSWPButton(WebDriver driver) {
		WebElement type = driver.findElement(By
				.xpath("(//input[@value='Save & Continue'])[4]"));
		return type;
	}
	public WebElement dividend(WebDriver driver) {
		WebElement element = driver.findElement(By.name("dividendType"));
		return element;
	}
	public WebElement mutualFundHouseSTP(WebDriver driver) {
		WebElement element = driver.findElement(By.id("stpamcId"));
		return element;
	}
	public WebElement categorySTP(WebDriver driver) {
		WebElement element = driver.findElement(By.id("stpcategoryId"));
		return element;
	}
	public WebElement schemeSTP(WebDriver driver) {
		WebElement element = driver.findElement(By.id("toScheme"));
		return element;
	}

	public WebElement loadValue(WebDriver driver) {
		WebElement element = driver.findElement(By.name("loadValue"));
		return element;
	}
	public WebElement otherChargesSIP(WebDriver driver) {
		WebElement element = driver.findElement(By.xpath("(//input[@name='otherCharges'])[2]"));
		return element;
	}
}

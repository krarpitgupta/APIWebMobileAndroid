package pageWiseOR.web;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.GlobalVar;
import utilities.Utility;

public class PaymentOptionsPage {
	Utility utilObj = new Utility();
	Properties pageProp = utilObj.loadPageProperties(GlobalVar.CURRENT_PROJECT_PATH + "/src/pageWiseOR/web/pageProperties/paymentOptionsPage.properties");
		
	public  static PaymentOptionsPage getInstance()
	{	
		return new PaymentOptionsPage();		
	}

	
	public WebElement cashBeforeDeliveryPP(WebDriver driver){
		
		WebElement element = driver.findElement(By.linkText(pageProp.getProperty("paymentOptions_CashBeforeDelivery")));
		return element;
	}
	
	public WebElement couponCodeTextPP(WebDriver driver){
		
		WebElement element = driver.findElement(By.className(pageProp.getProperty("paymentOptions_CouponCodeText")));
		return element;
	}
	
	
public WebElement cBDRadioButtionPP(WebDriver driver){
		
		WebElement element = driver.findElement(By.id(pageProp.getProperty("paymentOptions_CBDRadioButton")));
		return element;
	}

public WebElement continueButtonPP(WebDriver driver){
	
	WebElement element = driver.findElement(By.linkText(pageProp.getProperty("paymentOptions_Continue")));
	return element;
}
}

/*
 ***************************************************************************************
 * Script-Name:          src/ApplicationComponent/WebAc.java
 * Description:          Application component file, which consists of various application 
 * components to define end-to-end flow of ShopClues Front-End
 * Author:               Automators
 * Dated:                09Apr2015
 * Notes:  
 *
 ***************************************************************************************
 */
// Package name: applicationComponent
package applicationComponent;

//List of import statements to include various java classes
import java.util.HashMap;

import org.openqa.selenium.WebDriver;

import session.DriverSession;
import utilities.GlobalVar;
import action.WebAction;

/*
 ************************************************************************************************
 * Class-Name:    public class WebAC
 * Description:   Class defined to handle various reusable actions for ShopClues FrontEnd Web-Site
 * where
 *
 * Author:        Automators
 * Dated:         09Apr2015
 * Notes:  
 *
 *************************************************************************************************
 */
public class WebAC implements ApplicationComponent {

	WebDriver driver = null;
	HashMap<String, String> testData = new HashMap<String, String>();
	WebAction action = new WebAction(DriverSession.getLastExecutionDriver());

	@Override
	public void openApplication() {
		// TODO Auto-generated method stub
		action.openBrowser(GlobalVar.url);
	}
	
	@Override
	public void validateHomePage(){
		action.validateHomePage();
	}
	
	@Override
	public void closeApplication() {
		// TODO Auto-generated method stub
		action.closeBrowser();
	}
 
	@Override
	public void navigateVerifyProductPage(){
		testData = GlobalVar.TEST_DATA;
		System.out.println(testData.get("ProductUrl").trim());
		action.navigateToProductPage(testData.get("ProductUrl"));
		action.verifyProductPage();		
	}
	
	
	public void buyNowVerifyCart(){
		String productName=action.getProductName();
		action.clickonBuyNow();
		action.verifyProductCart(productName);
		action.clickonPlaceOrder();
	}
	
	// This App component verifies that checkout page is loaded 
	// then enters the email id(as guest user) mentioned in the test data 
	// Clicks on continue and verifies address page loaded   
	public void verifyCheckoutAddressPage()
	{
		action.verifyCheckoutPage();
		action.enterEmailIDCheckoutPage(testData.get("EmailID"));
		action.enterPasswordCheckoutPage(testData.get("Password"));
		action.clickContinueCheckoutPage();
		action.verifyAddressPage();
		action.clickContinueAddressPage();
	}
	
	public void paymentOptionsPage()
	{
		action.verifyPaymentOptionsPage();
		action.verifyCouponCodeApplied();
		action.clickCashBeforeDelivery();
		action.selectCBDRadioButton();
		action.clickContinuePaymentOptionsPage();		
	}
		
	
	public void reviewAndPlaceOrderPage()
	{
		
	}
	
	
	
}
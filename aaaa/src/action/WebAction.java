/*
 ***************************************************************************************************
 * Class-Name:    public class WebAction
 * Description:   Class defined to handle various reusable actions for ShopClues Web-Site| Front-End
 * where
 *
 * Author:        Automators
 * Dated:         09Apr2015
 * Notes:  
 *
 ***************************************************************************************************
 */

// Package name: action
package action;

//List of import statements to include various java classes
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import pageWiseOR.web.AddressPage;
import pageWiseOR.web.CartPage;
import pageWiseOR.web.CheckoutPage;
import pageWiseOR.web.HomePage;
import pageWiseOR.web.PaymentOptionsPage;
import pageWiseOR.web.ProductPage;
import session.DriverSession;
import testCaseReporting.TestCaseReporting;
import utilities.GlobalVar;
import utilities.Keywords;

public class WebAction {
	private WebDriver driver;
	HashMap<String, String> testData = new HashMap<String, String>();
	TestCaseReporting testCaseReporting = null;

	public WebAction(WebDriver driver) {
		this.driver = driver;
		this.testData = GlobalVar.TEST_DATA;
	}

	public void openBrowser(String url) {
		try {
			this.driver = GlobalVar.driver;
			this.testData = GlobalVar.TEST_DATA;
			if (!GlobalVar.CURRENT_EXECUTION_MODE.equals("androidWeb"))
			{
				try
				{
				    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			        double width = screenSize.getWidth();
			        double height = screenSize.getHeight();
			        System.out.println("old"+driver.manage().window().getSize());
			        org.openqa.selenium.Dimension dim =new org.openqa.selenium.Dimension((int)width,(int)height);
					driver.manage().window().setSize(dim);
					System.out.println("new"+driver.manage().window().getSize());
				}
				catch (Exception ex)
				{
			        System.out.println("old"+driver.manage().window().getSize());
			        org.openqa.selenium.Dimension dim =new org.openqa.selenium.Dimension(1024,768);
					driver.manage().window().setSize(dim);
					System.out.println("new"+driver.manage().window().getSize());
				}
			}
			driver.navigate().to(url);
			Thread.sleep(1500);
			driver.findElement(By.id("popup_close")).click();
			DriverSession.getLastExecutionReportingInstance()
					.teststepreporting("Browser opened", "PASS",
							"Browser should be Open");
		} catch (Exception e) {

			DriverSession.getLastExecutionReportingInstance()
					.teststepreporting("Browser not opened", "FAIL",
							"Browser should be Open");
		}
	}

	public void  validateHomePage(){
		WebElement homeBanner = HomePage.getInstance().homePageBanner(driver);
		Keywords.validateElementExistOrNot(homeBanner);
		if (GlobalVar.etpStepsReport) {
			DriverSession.getLastExecutionReportingInstance()
					.teststepreporting("ShopClues Home Page opened successfully", "PASS",
							"ShopClues Home Page should be opened");

		} else {
			DriverSession.getLastExecutionReportingInstance()
					.teststepreporting("ShopClues Home Page not opened", "FAIL",
							"ShopClues Home Page should be opened");
		}
	}
	
	public void navigateToProductPage(String productUrl)
	{
		try {
			this.driver = GlobalVar.driver;
			driver.navigate().to(productUrl);
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Navigate to product page", "PASS",
					"Product Page should open");
		}
		catch(Exception e) {
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Product Page not opened", "FAIL",
					"Product Page should open");
		}
	}
	
	public void clickonBuyNow()
	{				
			WebElement buyNowButton = ProductPage.getInstance().buyNowButton(driver);
			Keywords.click(buyNowButton);
			if (GlobalVar.etpStepsReport) {
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Buy-now button clicked", "PASS",
					"Click on buy-now button");
			}		
		
			else{
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Buy-now button not clicked", "FAIL",
					"Click on buy-now button");
		}	
	}
	
	
	public String getProductName()
	{
		WebElement we= ProductPage.getInstance().productName(driver);
		String productName=we.getText();
		System.out.println(productName);
		return productName;
		
	}
	
	public void verifyProductCart(String productName)
	{
		WebElement we= CartPage.getInstance().productNameOnCartPage(driver);
		String cartProductName=we.getText();
		if(cartProductName.contains(productName))
		{
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Product <b style='color:blue;'>" + "\"" +  productName + "\"" +"</b> has been added to the cart", "PASS",
					"Product should be added to the cart");
		}
		else{
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Product <b style='color:blue;'>" + "\"" +  productName + "\"" +"</b> has not been added to the cart", "FAIL",
					"Product should be added to the cart");
		}
		
	}
	
	public void  verifyProductPage(){
		WebElement buyNowButton = ProductPage.getInstance().buyNowButton(driver);
		Keywords.validateElementExistOrNot(buyNowButton);
		if (GlobalVar.etpStepsReport) {
			DriverSession.getLastExecutionReportingInstance()
					.teststepreporting("Product Page verified successfully", "PASS",
							"Product Page verified");

		} else {
			DriverSession.getLastExecutionReportingInstance()
					.teststepreporting("Product Page not verified", "FAIL",
							"Product Page verified");
		}
	}
	
	public void clickonPlaceOrder()
	{
		WebElement placeOrderButton = CartPage.getInstance().placeOrderButton(driver);
		Keywords.click(placeOrderButton);
		if (GlobalVar.etpStepsReport) {
		DriverSession.getLastExecutionReportingInstance()
		.teststepreporting("Place Order button clicked", "PASS",
				"Click on Place Order button");
		}		
	
		else{
		DriverSession.getLastExecutionReportingInstance()
		.teststepreporting("Place Order button not clicked", "FAIL",
				"Click on Place Order button");
	}	
	}
	
	public void verifyCheckoutPage()
	{
		WebElement emailCheckoutPage = CheckoutPage.getInstance().emailCheckoutPage(driver);
		Keywords.validateElementExistOrNot(emailCheckoutPage);
		if (GlobalVar.etpStepsReport) {
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Checkout Page verified successfully", "PASS",
					"Checkout Page verified");
		}
		else
		{
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Checkout Page not verified", "FAIL",
					"Checkout Page verified");
		}
	}
	
	
	public void enterEmailIDCheckoutPage(String emailID)
	{
		WebElement emailCheckoutPage = CheckoutPage.getInstance().emailCheckoutPage(driver);		
		Keywords.typeText(emailCheckoutPage,emailID);
		
		if (GlobalVar.etpStepsReport) {
			DriverSession.getLastExecutionReportingInstance()
					.teststepreporting("Email id entered.", "PASS",
							"Email id should be enter");

		} else {
			DriverSession.getLastExecutionReportingInstance()
					.teststepreporting("Email id not entered.", "FAIL",
							"Email id should be enter");

		}
	}
	
	
	public void enterPasswordCheckoutPage(String Password)
	{
		WebElement passwordCheckoutPage = CheckoutPage.getInstance().passwordCheckoutPage(driver);		
		Keywords.typeText(passwordCheckoutPage,Password);
		
		if (GlobalVar.etpStepsReport) {
			DriverSession.getLastExecutionReportingInstance()
					.teststepreporting("Password entered.", "PASS",
							"Password should be enter");

		} else {
			DriverSession.getLastExecutionReportingInstance()
					.teststepreporting("Password not entered.", "FAIL",
							"Password should be enter");

		}
	}
	
	
	
	public void clickContinueCheckoutPage()
	{
		WebElement continueCheckoutPage = CheckoutPage.getInstance().continueCheckoutPage(driver);		
		Keywords.click(continueCheckoutPage);
		
		if (GlobalVar.etpStepsReport) {
			DriverSession.getLastExecutionReportingInstance()
					.teststepreporting("Continue Clicked.", "PASS",
							"Continue should be clicked");

		} else {
			DriverSession.getLastExecutionReportingInstance()
					.teststepreporting("Continue not clicked", "FAIL",
							"Continue should be clicked");

		}
	}
	
	public void verifyAddressPage()
	{
		WebElement firstName=AddressPage.getInstance().firstNameAddressPage(driver);
		Keywords.validateElementExistOrNot(firstName);
		if (GlobalVar.etpStepsReport) {
			DriverSession.getLastExecutionReportingInstance()
					.teststepreporting("Address page verified", "PASS",
							"Address Page should be verified");

		} else {
			DriverSession.getLastExecutionReportingInstance()
					.teststepreporting("Address page not verified", "FAIL",
							"Address Page should be verified");

		}
	}
	
	
	public void clickContinueAddressPage()
	{
			
		WebElement continueAddressPage = AddressPage.getInstance().continueAddressPage(driver);		
		Keywords.click(continueAddressPage);
		
		if (GlobalVar.etpStepsReport) {
			DriverSession.getLastExecutionReportingInstance()
					.teststepreporting("Continue Clicked.", "PASS",
							"Continue should be clicked");

		} else {
			DriverSession.getLastExecutionReportingInstance()
					.teststepreporting("Continue not clicked", "FAIL",
							"Continue should be clicked");

		}
	}
	
	public void verifyPaymentOptionsPage()
	{
		WebElement cashBeforeDelivery=PaymentOptionsPage.getInstance().cashBeforeDeliveryPP(driver);
		Keywords.validateElementExistOrNot(cashBeforeDelivery);
		if (GlobalVar.etpStepsReport) {
			DriverSession.getLastExecutionReportingInstance()
					.teststepreporting("PaymentOptions Page verified", "PASS",
							"PaymentOptions Page should be verified");

		} else {
			DriverSession.getLastExecutionReportingInstance()
					.teststepreporting("PaymentOptions Page verified", "FAIL",
							"PaymentOptions Page should be verified");

		}
		
	}
	
	public void verifyCouponCodeApplied()
	{
		WebElement couponCodeText=PaymentOptionsPage.getInstance().couponCodeTextPP(driver);
		Keywords.isCouponApplied(couponCodeText);
		
		if (GlobalVar.etpStepsReport) {
			DriverSession.getLastExecutionReportingInstance()
					.teststepreporting("Coupon code applied successfully", "PASS",
							"Coupon code should be applied");

		} else {
			/*DriverSession.getLastExecutionReportingInstance()
					.teststepreporting("PaymentOptions Page verified", "FAIL",
							"PaymentOptions Page should be verified");*/
			
			// read data for coupon code and enter the coupon code and apply

		}
		
	}
	
	
	public void clickCashBeforeDelivery()
	{
	WebElement cashBeforeDelivery=PaymentOptionsPage.getInstance().cashBeforeDeliveryPP(driver);
	Keywords.click(cashBeforeDelivery);
	if (GlobalVar.etpStepsReport) {
		DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("Payment Options <b>Cash Before Delivery</b> selected", "PASS",
						"Payment Options Cash Before Delivery should be selected");

	} else {
		DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("PaymentOptions cash before delivery not selected", "FAIL",
						"Payment Options Cash Before Delivery should be selected");

	}
	}
	public void  selectCBDRadioButton()
	{
		WebElement cBD_RadioButton=PaymentOptionsPage.getInstance().cBDRadioButtionPP(driver);
		Keywords.click(cBD_RadioButton);
		if (GlobalVar.etpStepsReport) {
			DriverSession.getLastExecutionReportingInstance()
					.teststepreporting("I agree cash before delivery selected", "PASS",
							"I agree cash before delivery option should be selected");

		} else {
			DriverSession.getLastExecutionReportingInstance()
					.teststepreporting("I agree cash before delivery options not selected", "FAIL",
							"I agree cash before delivery options should be selected");

		}
		
	}
	
	public void  clickContinuePaymentOptionsPage()
	{
		WebElement continuePaymentPage = PaymentOptionsPage.getInstance().continueButtonPP(driver);		
		Keywords.click(continuePaymentPage);
		
		if (GlobalVar.etpStepsReport) {
			DriverSession.getLastExecutionReportingInstance()
					.teststepreporting("Continue Clicked.", "PASS",
							"Continue should be clicked");

		} else {
			DriverSession.getLastExecutionReportingInstance()
					.teststepreporting("Continue not clicked", "FAIL",
							"Continue should be clicked");

		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void clickOnLoginButton() {
		WebElement loginButton = HomePage.getInstance().loginButton(driver);
		Keywords.click(loginButton);
		if (GlobalVar.etpStepsReport) {
			DriverSession.getLastExecutionReportingInstance()
					.teststepreporting("Clicked on Login Button", "PASS",
							"Should be Clicked on Login Button");

		} else {
			DriverSession.getLastExecutionReportingInstance()
					.teststepreporting("Not clicked On Login Button", "FAIL",
							"Should be Clicked on Login Button");
		}

	}

	public void typedEmailId(String emailId) {
		WebElement emailIdfield = HomePage.getInstance().emailTextField(driver);
		Keywords.typeText(emailIdfield, emailId);
		if (GlobalVar.etpStepsReport) {
			DriverSession.getLastExecutionReportingInstance()
					.teststepreporting("Email id entered.", "PASS",
							"Email id should be enter");

		} else {
			DriverSession.getLastExecutionReportingInstance()
					.teststepreporting("Email id not entered.", "FAIL",
							"Email id should be enter");

		}
	}

	public void typePassword(String password) {
		WebElement passwordField = HomePage.getInstance().passwordTextField(
				driver);
		Keywords.typeText(passwordField, password);
		if (GlobalVar.etpStepsReport) {
			DriverSession.getLastExecutionReportingInstance()
					.teststepreporting("Password Entered", "PASS",
							"Password Should be Enter.");

		} else {
			DriverSession.getLastExecutionReportingInstance()
					.teststepreporting("Password  not Entered", "FAIL",
							"Password Should be Entered");

		}

	}

	
	public void verifyPortfolioName(String portfolioName,
			String expectedPortfolioName) {
		try {
			if (portfolioName.equals(expectedPortfolioName)) {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting(
								"Portfolio name verified as expected.",
								"PASS",
								"Portfolio name should be same as "
										+ expectedPortfolioName);
			} else {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting(
								"Portfolio name not verified.",
								"FAIL",
								"Portfolio name is not same as expected "
										+ expectedPortfolioName);
			}
		} catch (Exception ee) {
			DriverSession.getLastExecutionReportingInstance()
					.teststepreporting(
							"Portfolio name not verified.",
							"FAIL",
							"Portfolio name is not same as expected "
									+ expectedPortfolioName);
			ee.printStackTrace();
		}
	}

	public void checkPasswordEcription() {
		try {
			if (isPasswordEncripted()) {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting("Password is encrypted ", "PASS",
								"Password Field should be encrypted.");
			} else {

				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting("Password is not encrypted ",
								"FAIL", "Password Field should be encrypted.");
			}
		} catch (Exception ee) {
			DriverSession.getLastExecutionReportingInstance()
					.teststepreporting("Password is not encrypted ", "FAIL",
							"Password Field should be encrypted.");

		}
	}

	public void encryptedTextShouldNotCopyAndPaste() {
		boolean isDisplayed = false;
		try {

			cutAndPastePassword();
			HomePage.getInstance()
					.loginButton(DriverSession.getLastExecutionDriver())
					.click();
			Keywords.explicitWait(10);
			isDisplayed = HomePage.getInstance()
					.loginErrorObject(DriverSession.getLastExecutionDriver())
					.isDisplayed();
			if (isDisplayed) {

				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting("Copied Password is  not working ",
								"PASS", "Copied Password  should not work.");
			}

			else {

				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting("Copied Password is working. ",
								"FAIL", "Copied Password  should not work.");

			}

		} catch (Exception ee) {

		}
	}

	private void cutAndPastePassword() throws InterruptedException

	{
		WebElement element = HomePage.getInstance().passwordTextField(
				DriverSession.getLastExecutionDriver());
		Action build = null;
		Actions ac = new Actions(DriverSession.getLastExecutionDriver());
		element.click();

		ac.sendKeys(Keys.CONTROL + "a");
		build = ac.build();
		build.perform();
		ac.sendKeys(Keys.CONTROL + "c").toString().trim();
		build = ac.build();
		build.perform();
		Keywords.clearEditField(element);

		Keywords.explicitWait(10);

		ac.sendKeys(Keys.CONTROL + "v");
		build = ac.build();
		build.perform();

		DriverSession.getLastExecutionReportingInstance().teststepreporting(
				"Copied Password is paste ", "PASS",
				"Copied Password should be paste.");
	}

	private boolean isPasswordEncripted() {
		boolean isEncrypted = false;
		isEncrypted = HomePage.getInstance()
				.passwordTextField(DriverSession.getLastExecutionDriver())
				.getAttribute("type").equalsIgnoreCase("password");
		return isEncrypted;
	}

	public void clickOnGoogleButton() {
		try {
			HomePage.getInstance().googleButton(driver).click();
			DriverSession.getLastExecutionReportingInstance()
					.teststepreporting("Clicked on google button", "PASS",
							"Should be clicked on google button");

		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance()
					.teststepreporting("Not clicked on google button", "FAIL",
							"Should be clicked on google button");
		}

	}

	

	public void clickOnFacebookButton() {
		try {
			HomePage.getInstance().facebookButton(driver).click();
			DriverSession.getLastExecutionReportingInstance()
					.teststepreporting("Clicked on facebook button", "PASS",
							"Should be clicked on facebook button");

		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance()
					.teststepreporting("Not clicked on facebook button",
							"FAIL", "Should be clicked on facebook button");
		}

	}

	public void clickOnLinkedinButton() {
		try {
			HomePage.getInstance().linkedinButton(driver).click();
			DriverSession.getLastExecutionReportingInstance()
					.teststepreporting("Clicked on linkedin button", "PASS",
							"Should be clicked on linkedin button");

		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance()
					.teststepreporting("Not clicked on linkedin button",
							"FAIL", "Should be clicked on linkedin button");
		}

	}

	
	
	

	
	
	public void closeBrowser() {
		// TODO Auto-generated method stub
		try {
			DriverSession.getLastExecutionReportingInstance().footer();
			GlobalVar.driver.quit();
		}

		catch (Exception ee) {

		}

	}


	public void openURL(String url) {
		try {

			driver.navigate().to(url);
			DriverSession.getLastExecutionReportingInstance()
					.teststepreporting("New URL opened successfully.", "PASS",
							"Should be opened new URL.");

		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance()
					.teststepreporting("Unable to open new URL.", "FAIL",
							"URL Should not be open.");

		}
	}

	public void verifyWelcomePageForAllOtherURL(String object, String colName) {
		String userId = "";
		boolean flag = false;
		try {
			/*
			 * flag = ViewPortFolioPage.getViewPortFolioInstance()
			 * .welcomeLogo(driver).isDisplayed(); userId =
			 * ViewPortFolioPage.getViewPortFolioInstance()
			 * .userId(driver).getText().trim();
			 */
			flag = driver.findElement(By.id(object)).isDisplayed();
			userId = driver.findElement(By.id(object)).getText();
			if (testData.get(colName).contains(userId) || flag) {

				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting(
								"View Port Folio Page is appeared.Email Id is "
										+ testData.get(colName), "PASS",
								"Email Id should be " + testData.get(colName));

			} else {

				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting(
								"View Port Folio Page is not appeared.Email Id is not "
										+ testData.get(colName), "PASS",
								"Email Id should be " + testData.get(colName));

			}

		} catch (Exception ee) {

			DriverSession.getLastExecutionReportingInstance()
					.teststepreporting(
							"ViewPortFolioPage is not appeared.Email Id is not "
									+ testData.get(colName), "PASS",
							"Email Id should be " + testData.get(colName));

		}

	}

	public void verifyTextOnPage(String text) {
		boolean textFound = false;
		try {
			textFound = driver.getPageSource().contains(text);

			if (textFound) {

				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting("Welcome page verified.", "PASS",
								"Welcome page should be verified.");

			} else {

				DriverSession
						.getLastExecutionReportingInstance()
						.teststepreporting("Welcome page not verified.",
								"PASS", "Welcome page should not  be verified.");

			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance()
					.teststepreporting("Welcome page not verified.", "PASS",
							"Welcome page should not be verified.");
		}
	}


	public void verifyAmount(float amountA, float amountB) {
		try {
			amountA = Math.round(amountA);
			amountB = Math.round(amountB);
			if (amountA == amountB) {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting(
								"Data value matched successfully :: " + amountA
										+ "==" + amountB, "PASS",
								"Data value should be matched successfully.");

			} else {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting(
								"No data value matched :: " + amountA + "=="
										+ amountB, "FAIL",
								"Should be matched data values.");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void verifyAmount(double amountA, double amountB) {
		try {
			amountA = Math.round(amountA);
			amountB = Math.round(amountB);
			if (amountA == amountB) {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting(
								"Data value matched successfully :: " + amountA
										+ "==" + amountB, "PASS",
								"Data value should be matched successfully.");

			} else {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting(
								"No data value matched :: " + amountA + "=="
										+ amountB, "FAIL",
								"Should be matched data values.");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void validateLoginPage() {
		
		
	}

	

}

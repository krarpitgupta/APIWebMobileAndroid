/*
 ***************************************************************************************
 * Script-Name:          src/ApplicationComponent/AndroidAppAc.java
 * Description:          Application component file, which consists of various application 
 * components to define end-to-end flow of ShopClues Mobile App on Android platform
 * Author:               Sahil Jariwala
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
import utilities.Keywords;
import action.AppAction;
import action.WAPAction;

/*
 ***************************************************************************************
 * Class-Name:    public class AndroidAppAc
 * Description:   Class defined to handle various reusable actions for ShopClues Andoid App
 * where
 *
 * Author:        Sahil Jariwala
 * Dated:         09Apr2015
 * Notes:  
 *
 ****************************************************************************************
 */
public class AndroidAppAc implements ApplicationComponent{

	
	WebDriver driver = null;
	HashMap<String, String> testData = new HashMap<String, String>();
    AppAction action=new AppAction(DriverSession.getLastExecutionDriver());
    
    
    @Override
	public void openApplication() {
    	
		   action.launchApp(DriverSession.getLastExecutionDriver());
		   //action.launchAppiumApp(DriverSession.getLastExecutionAppiumDriver());
	}
    
    @Override
	public void validateHomePage(){
		action.validateHomePage();
	}
    
    
    public void verifyProductDetailPage(){
    	action.validateProductDetailPage();
    	action.validateAddToCart();
    	action.verifyQualityField();
    	action.verifyQualityDropDownValue();
    	action.verifyShoppingCart();
    	action.verifyShoppingCartQuantity();	
    	action.verifyShoppingCartAfterAddtoCart();
    	action.validateShoppingCartafterIncrementingQuality();		
    	action.validateQtyfromShoppingCart();
    	action.validateShoppingCartTotalAmouont();
    }
    
    public void clickAndVerifyProductQuantity(){
    	action.validateQtyFromProductPage();
    	action.validateShoppingCartPage();
    	action.verifyShoppingPageQuantity();
    	action.verifyShoppingPagePrice();
    	action.validateShoppingCartTotal();
    }
    
    public void placeOrderAndVerifyUser(){
    	action.validatePlaceOrderButton();
    	action.validateSingInPage();
    	action.click_AccountandPass();
    	action.enterEmailIDCheckoutPage();
    	action.enterPasswordCheckoutPage();
    	//Keywords.hideKeyBoard();
    	action.clickContinueCheckoutPage();
    	action.verifyShippingAddress();
    	action.clickContinue();
    }
    
    public void validatePaymentMethodPage(){
    	action.verifyPaymentMethodPage();
    	action.verifyPaymentOptionRadioButton();
    	action.verifySelectedRadioButton();
    	action.validateRadioButtonDefaultTextField();
    }

    
    public void clickAndValidateGiftCertificate(){
    	action.validateGiftCertificateOption();
    	action.clickToGiftCertificate();
    	action.clickToGiftCertificateCode();
    	action.clickToCluesBucks();
    	action.validateGrandTotal();
    }
    
    
    @Override
	public void navigateVerifyProductPage(){
		testData = GlobalVar.TEST_DATA;
		Keywords.swipeuntilObjectNotFound(5);
		action.clickOnProductCategory("MetaCategory");	
		action.clickOnProductCategory("Category");
		action.clickOnProductCategory("SubCategory");
		action.clickOnWesterWear("WesterWearName");
		
		
		action.clickOn_SearchButton();
		action.writeTo_SearchBox();
		//action.searchAndClickOnProduct();
		action.verifyProductName();
	}
    
    @Override
	public void buyNowVerifyCart() throws Exception {
		action.clickOnsizOption();
		action.selectSize();
		action.clickOnBuyButton();		
		action.verifyCartProductName();
	}
    
    @Override
	public void verifyCheckoutAddressPage() {		
		action.clickOnPlaceOrder();
		action.click_AccountandPass();
		action.enterEmailIDCheckoutPage(testData.get("EmailID"));		
		action.enterPasswordCheckoutPage(testData.get("Password"));
		Keywords.keyBoardEvent(4,"Linux");
		action.clickContinueCheckoutPage();
		action.clickShipping_Continue_Button();
	}

public void simpleProduct() 
	{
		action.clickOnMenuArrow();
		action.clickCatagory();
		action.shopByCategory();
		action.click_StorageDevice();
		action.validateSearchProduct();
		action.clickItem();
		
	}
	
	public void variantProduct() 
	{
		action.clickOnMenuArrow();
		action.clickOnShopByCategory();
		action.clickOnShopByCategoryComputers();
		action.clickOnShopByCategoryComputersMemoryDevices();
		action.clickOnProductSearch();
		action.ProductSearch_TypeTextName();
		action.clickOnProductSearchGo();
		action.clickOnDesiredProduct();
		action.clickQuantity();
		action.selectQuantity();
		action.clickOn_AddToCart();
		action.clickOnCart();
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    continueShopping
	 * Usage:           void continueShopping()
	 * Description:     Verify continue shopping functionality
	 * Author:          Sahil Jariwala
	 * Dated:           11May2015
	 * Notes:   
	 *************************************************************************************** **/
	public void continueShopping() throws InterruptedException
	{
		try{
			new AndroidAppAc().simpleProduct();
			new AndroidAppAc().clickAndVerifyProductQuantity();
			new AndroidAppAc().placeOrderAndVerifyUser();
		}
		catch(Exception e)
		{
			e.getMessage();
		}
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    applySingleCouponCode
	 * Usage:           void applySingleCouponCode()
	 * Description:     Verify single coupon link functionality
	 * Author:          Automators
	 * Dated:           12May2015
	 * Notes:   
	 *************************************************************************************** **/
	public void applySingleCouponCode() 
	{
		try{
		action.clickOnMenuArrow();
		action.selectProduct(GlobalVar.TEST_DATA.get("ProductString"));
		action.selectProductQuantity(GlobalVar.TEST_DATA.get("ProductQuantity"));
		action.getCouponCode();
		action.getCurrentPrice();
		action.clickOnBuyNowButton();
		action.clickOnPlaceOrderButton();	
		Thread.sleep(3000);
		action.clickScreen2ContinueButton();
		action.verifyCurrentPriceFromPaymentPage();
		action.verifyCouponCodeFromPaymentPage();
		action.verifyApplySingleCoupon();
		action.selectCODPaymentMethod();
		action.clickOnApplySingleCoupon();
		action.verifyCODCouponError();
		action.selectCreditCardPaymentMethod();
		action.clickOnApplySingleCoupon();
		action.verifyFinalPriceAfterApplyCoupon();
		action.verifyPriceAfterRemoveCoupon(GlobalVar.TEST_DATA.get("Apply Text"));
		action.verifyRemoveCoupon();
		action.clickOnRemoveCoupon();
		action.verifyApplySingleCoupon();
		action.verifyPriceAfterRemoveCoupon(GlobalVar.TEST_DATA.get("Coupon Text"));
		}
		catch(Exception e){}
	}
	
	
	
	
	/** ***************************************************************************************
	 * Keyword-Name:    applyCluesBucks
	 * Usage:           void applyCluesBucks() throws InterruptedException
	 * Description:     Verify clues bucks functionalty
	 * Author:          Automators
	 * Dated:           13May2015
	 * Notes:   
	 *************************************************************************************** **/
	public void applyCluesBucks() throws InterruptedException
	{
		action.clickOnMenuArrow();
		action.selectProduct(GlobalVar.TEST_DATA.get("Product String"));
		action.selectProductQuantity(GlobalVar.TEST_DATA.get("Product Quantity"));
		action.getCouponCode();
		action.getCurrentPrice();
		action.clickOnBuyNowButton();
		action.clickOnPlaceOrderButton();	
		Thread.sleep(3000);
		action.clickScreen2ContinueButton();
		action.typeOnCluesBucksEditBox(GlobalVar.TEST_DATA.get("Applied Bucks"));
		action.clickOnApplyCluesBucksLink();
		action.getAndVerifyAppliedCluesBucks(GlobalVar.TEST_DATA.get("Applied Bucks"));
		action.typeOnCluesBucksEditBox(GlobalVar.TEST_DATA.get("Remove Bucks"));
		action.clickOnApplyCluesBucksLink();
		action.getAndVerifyAppliedCluesBucks(GlobalVar.TEST_DATA.get("Remove Bucks"));
	}
	
	
	
	/** ***************************************************************************************
	 * Keyword-Name:    viewProfile
	 * Usage:           void viewProfile()
	 * Description:     Verify view profile functionality
	 * Author:          Automators
	 * Dated:           13May2015
	 * Notes:   
	 *************************************************************************************** **/
	public void viewProfile() throws InterruptedException
	{
		action.clickOnAppMenu();
		action.clickOnViewProfileLink();
		action.verifyLoginPage();
		action.enterAppLoginEmailID();
		action.enterAppLoginPassword();
		action.clickOnAppLoginLink();	
		action.clickOnAppMenu();
		action.clickOnViewProfileLink();
		action.verifyMyProfile();
	}
	
	
	
	public void deleteVariantProduct() {
		action.clickOnAppMenu();
		action.clickOnAppLogin();
		action.enterAppLoginEmailID();
		action.enterAppLoginPassword();
		action.clickOnAppLoginLink();
		action.clickToShoppingCart();
		action.validateDeleteButton();
		action.clickToDeleteButton();
		action.verifyItemInsideShoppingCart();
	}
	

	public void appLogin() {
		action.clickOnAppMenu();
		action.clickOnAppLogin();
		action.enterAppLoginEmailID();
		action.enterAppLoginPassword();
		action.clickOnAppLoginLink();
		action.verifyTextDate();
	}
	
	public void appRegistration() 
	{
		action.clickOnAppMenu();
		action.clickOnAppLogin();
		action.clickOnAppRegister();
		action.enterAppRegisterFirstName();
		action.enterAppRegisterLastName();
		action.enterAppRegisterEmail();
		action.enterAppRegisterPassword();
		action.enterAppRegisterConfirmPassword();
		action.clickOnCreateAccount();
		
	}
	
	public void appForgotPassword() 
	{
		action.clickOnAppMenu();
		action.clickOnAppLogin();
		action.clickOnForgotPassword();
		action.enterAppForgotPasswordEmailID();
		action.clickOnForgotPasswordSubmitButton();
		action.verifyTextOnPage("Password sent to your email address");
	}
	
	
	public void verifyAndChangePassword(){
		action.validateHomePageLogin();
		action.clickToLoginSection();
		action.validateSignInPageLogo();
		action.loginEmailField();
		action.loginPasswordField();
		action.clickLoginButton();
		action.verifyViewProfile();
		action.clickAndValidateViewProfile();
		action.validateMyProfileCredentials();
		action.validateAllMyProfileField();
		action.changeYourPasswordField();
		action.click_SaveButton();
	}
    
	
	public void validateUserNotification(){
		action.verifyHomePage();
		action.clickAndValidateNotificationsIcon();
		action.validateAndInSideNotification();
	}
	
	
	/** ***************************************************************************************
	 * Keyword-Name:    removeLinkForappliedGifts
	 * Usage:           WebElement removeLinkForappliedGifts
	 * Description:     Clues bucks used details
	 * Author:          KAutomators
	 * Dated:           13May2015
	 * Notes:   
	 *************************************************************************************** **/
	
	public void removeLinkForappliedGifts() throws InterruptedException{
	
		action.clickOnMenuArrow();
		action.selectProduct(GlobalVar.TEST_DATA.get("Product List1"));
		action.clickOnProductSearch();
		action.ProductSearch_TypeTextName(GlobalVar.TEST_DATA.get("SearchProduct1"));
		action.clickOnProductSearchGo();
		action.clickOnDesiredProduct();
		action.clickQuantity();
		action.selectQuantity();
		action.clickOn_AddToCart();
		action.clickOnCart();
		action.clickOnPlaceOrder();
		action.typeEmailID();
		action.clickOnContinue_Address();
		action.enterShippingAddress();
		action.clickState();
		action.selectState();
		action.clickContinueShippingAddressPage();
		action.clickGiftCertificateExpander();
		action.enterGiftCertificateCode();
		action.clickGiftCertificateApplyButton();
		//action.clickGiftCertificateRemoveButton();
		
	}
	
	
	/** ***************************************************************************************
	 * Keyword-Name:    applyLinkForCluesBucks
	 * Usage:           WebElement applyLinkForCluesBucks
	 * Description:     Clues bucks used details
	 * Author:          KAutomators
	 * Dated:           13May2015
	 * Notes:   
	 *************************************************************************************** **/
	
	public void applyLinkForCluesBucks() throws InterruptedException
	{
		String LoginMessage;
		action.launchApp(DriverSession.getLastExecutionDriver());
		action.clickOnAppMenu();
		action.clickOnAppLogin();
		action.enterAppLoginEmailID();
		action.enterAppLoginPassword();
		action.clickOnAppLoginLink();	
		LoginMessage=GlobalVar.TEST_DATA.get("Successful Login Messgae");
		action.verifyTextOnPage(LoginMessage);			
		action.clickOnMenuArrow();
		action.selectProduct(GlobalVar.TEST_DATA.get("Product List1"));
		action.clickOnProductSearch();
		action.ProductSearch_TypeTextName(GlobalVar.TEST_DATA.get("SearchProduct1"));
		action.clickOnProductSearchGo();
		action.clickOnDesiredProduct();		
		action.clickQuantity();
		action.selectQuantity();
		action.clickOn_AddToCart();
		action.clickOnCart();
		action.clickOnPlaceOrder();
		action.clickScreen2OnLoginContinueButton();
		action.typeOnCluesBucksEditBox(GlobalVar.TEST_DATA.get("CLUES BUCKS"));
		action.clickOnApplyCluesBucksLink();
		action.getAndVerifyAppliedCluesBucks(GlobalVar.TEST_DATA.get("CLUES BUCKS"));
		action.closeApp();
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    applyAllLinkForcouponCode
	 * Usage:           WebElement applyAllLinkForcouponCode
	 * Description:     Clues bucks used details
	 * Author:          KAutomators
	 * Dated:           13May2015
	 * Notes:   
	 *************************************************************************************** **/
	
	public void applyAllLinkForcouponCode() throws InterruptedException
	{
		action.clickOnMenuArrow();	
		action.selectProduct(GlobalVar.TEST_DATA.get("Product List1"));
		action.clickOnProductSearch();
		action.ProductSearch_TypeTextName(GlobalVar.TEST_DATA.get("SearchProduct1"));
		action.clickOnProductSearchGo();
		action.clickOnDesiredProduct();
		action.clickQuantity();
		action.selectQuantity();
		action.clickOn_AddToCart();	
		action.clickOnMenuArrow();
		action.selectProduct(GlobalVar.TEST_DATA.get("Product List2"));	
		action.clickOnProductSearch();
		action.clearProductSearch();
		action.ProductSearch_TypeTextName(GlobalVar.TEST_DATA.get("SearchProduct2"));	
		action.clickOnProductSearchGo();
		action.clickOnDesiredProduct();
		action.clickQuantity();
		action.selectQuantity();
		action.clickOn_AddToCart();	
		action.clickOnCart();
		action.clickOnPlaceOrder();
		action.typeEmailID();
		action.clickOnContinue_Address();
		action.enterShippingAddress();
		action.clickState();
		action.selectState();
		action.clickContinueShippingAddressPage();	
		action.clickOnApplyAllCouponsLink();
		action.clickOnApplyCouponsLink();	
	
	}
	
	
	/** ***************************************************************************************
	 * Keyword-Name:    addToFavorite
	 * Usage:           WebElement addToFavourite
	 * Description:     Add Favorite Product
	 * Author:          KAutomators
	 * Dated:           13May2015
	 * Notes:   
	 *************************************************************************************** **/
	
	public void addToFavourite() throws InterruptedException{
		
		String LoginMessage;	
		action.clickOnAppMenu();
		action.clickOnAppLogin();
		action.enterAppLoginEmailID();
		action.enterAppLoginPassword();
		action.clickOnAppLoginLink();	
		LoginMessage=GlobalVar.TEST_DATA.get("Successful Login Messgae");
		action.verifyTextOnPage(LoginMessage);	
		action.clickOnMenuArrow();
		action.selectProduct(GlobalVar.TEST_DATA.get("Product List1"));
		action.clickOnProductSearch();
		action.ProductSearch_TypeTextName(GlobalVar.TEST_DATA.get("SearchProduct1"));
		action.clickOnProductSearchGo();
		action.clickOnDesiredProduct();	
		action.clickOnProductFavouriteButton();
		action.clickOnProductFavouriteLink();
		action.verifyTextOnPage(GlobalVar.TEST_DATA.get("SearchProduct1")+"On Favourites Page ");
		
	}
	
	
	public void signInAndverifyOrderDetailFunctionality(){
		try{
			action.clickToLeaf();
			action.validateAndLogin();
			action.validateSignInPage();	
			action.enterAppLoginEmailID();
			action.enterAppLoginPassword();
			action.clickOnAppLoginLink();	
			action.validateLoginUser();
			action.clickToMyOrders();
			action.verifyMyOrderPage();
			action.searchMyProduct();
			action.verifySearchProduct();
			action.productBiefDetails();
			action.clickToArrowButton();
			action.validateAndClickDropDownIcons();
			action.verifyProductDetailOrderNumber();
			action.verifyProductDetailOrderDate();
			action.verifyProductDetailOrderstatus();
			action.verifyProductInformation();
			action.validateSellingPriceAndQuantity();
			action.paymentInformation();
			action.contactInformation();
			action.verifyProductShippingAddress();
		}
		catch(Exception e){
			e.getMessage();
		}
	}
	
	public void validateAndAddToFavouriteListView(){
		try{
			action.validateFavouritesButton();
			action.validateDropDownView();
			action.clickToMenuOverLay();
			action.sendProductToFavourite();
			action.clickToFavouritePage();
			action.validateFavouritePage();
			action.verifyProductInFavouritepage();
			action.validateDropDownView();
			action.removeProductFromFavourite();
			action.validateFavouritePageIsEmptyOrNot();
		}
		catch(Exception e){
			e.getMessage();
		}
	}
	public void validateAndAddToFavouriteGridView(){
		try{
			action.verifyAndClickToGridLayOut();
			action.verifyproductListGridView();
			action.clickAndVerifyFavouriteButton();
			action.verifyRemoveFromFavourites();
			action.validateFavouritePageIsEmptyOrNot();
			action.verifyCurrentViewMode();
		}
		catch(Exception e){
			e.getMessage();
		}
	}
	
	
	
	public void validateAndAddToCartListView(){
		try{
			action.validateFavouritesButton();
			action.validateDropDownView();
			action.clickCartToMenuOverLay();
			action.clickAndValidateCartValue();
			action.removeProductFromCart();
			action.validateAndClickToGridView();
			action.clickAddCartOverLay();
			action.clickAndValidateCartValue();
			action.removeProductFromCart();
			action.validateProductListView();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	
	/** ***************************************************************************************
	 * Keyword-Name:    mobileAppReOrderCancellationFunctionality
	 * Usage:           Void mobileAppReOrderCancellationFunctionality()
	 * Description:     mobile App order cancellation Functionality
	 * Author:          Automators
	 * Dated:           2ndJune2015
	 * Notes:   
	 *************************************************************************************** **/
	
	public void mobileAppReOrderCancellationFunctionality()
	{	
		action.clickOnAppMenu();
		action.clickOnMyOrdersMenuDropDown();
		action.clickOnProductExpandArrow();
		action.clickOnProductOrderDetailsButton();
		action.getStatusFromOrderDetails();
		action.clickOnProductCancelOrderButton();
		action.verifyCancellationReasonDropDown();
		action.selectCancellationReason();
		action.clickOnAppMenu();
		action.clickOnMyOrdersMenuDropDown();
		action.clickOnProductExpandArrow();
		action.clickOnProductOrderDetailsButton();
		action.verifyOrderStatusFromDetailsPage();		
	}
	
	
	
	
	public void myOrdersReorderFunctionality(){
		action.clickToLeaf();
		action.clickLogInAndEnterLoginCredentials();
		action.clickToLeaf();
		action.clickToMyOrdersList();
		action.verifyProductInMyOrders();
		action.clickArrowButtonToReOrder();
	}
	
	public void mobileAppReturnFunctionality(){
		try{
			action.clickToLeaf();
			action.clickToMyOrdersList();
			action.verifyMyOrderPage();
			action.searchMyProduct();
			action.verifyProductInMyOrders();
			action.clickArrowAndreturnButton();
			action.verifyRequestReturnLogo();
			action.verifyRequestReturnPage();
			action.fillingRequiredDetailsDropdown();
			action.fillingRequiredDetailsSubReason();
			action.clickToUploadImage();
			action.selectImageInUploadImage();
			action.verifyImageUploading();
			action.clickToReturnProcedure();
			action.refundTypeRadioButton();
			action.returnShipped();
			action.writeAComment();
			action.clickToSubmitButton();
			action.verifyReturnRequestedReceivedPage();
		}
		catch(Exception e){
			e.getMessage();
		}
	}
	
	public void reorderContinueFunctionality(){
		try{
			action.validatePlaceOrderButton();
			action.verifyShippingAddress();
	    	action.clickContinue();
	    	action.clickCODOption();
	    	action.verifyGrandTotal();
	    	action.verifyShippingAddress();
	    	action.verifyPaymentMethod();
	    	action.verifyProductInPaymentPage();
	    	action.clickToPlaceOrderButton();
	    	action.verifyConfirmationMessageAfterPlaceOrder();
	    	action.verifyAndClickToOrderSummary();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Override
	public void closeApplication() {
		action.closeApp();
	}



}

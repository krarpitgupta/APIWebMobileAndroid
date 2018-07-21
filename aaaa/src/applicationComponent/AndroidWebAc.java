/*
 ***************************************************************************************
 * Script-Name:          src/ApplicationComponent/AndroidWebAc.java
 * Description:          Application component file, which consists of various application 
 * components to define end-to-end flow of ShopClues Mobile WAP on Android platform
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
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import action.AppAction;
import action.WAPAction;
import session.DriverSession;
import utilities.GlobalVar;
import utilities.Keywords;

/*
 ***************************************************************************************
 * Class-Name:    public class AndroidWebAc
 * Description:   Class defined to handle various reusable actions for ShopClues Android WAP
 * where
 *
 * Author:        Sahil Jariwala
 * Dated:         09Apr2015
 * Notes:  
 *
 ****************************************************************************************
 */
public class AndroidWebAc implements ApplicationComponent{

	
	WebDriver driver = null;
	HashMap<String, String> testData = new HashMap<String, String>();
    WAPAction action=new WAPAction(DriverSession.getLastExecutionDriver());	
    
    
    
	@Override
	public void openApplication() {
			action.launchApp(GlobalVar.url);	
	}
	
	

	@Override
	public void closeApplication() {
		action.closeApp();
		
	}

	@Override
	public void validateHomePage() {
		action.validateHomePagePopup();  
		action.clickToHomePagePopup();
		action.validateHomepageApp();
	}

	
	public void clickAndNavigateToServiceFeeAgreement(){
		/*action.clickToStarLogo();
		action.validateAndClickSiteOptions();
		action.verifyLoginPageUserName();
		action.verifyLoginPageUserPassword();
		action.clickToLoginButton();*/
		//action.clickAndValidateServiceServiceFeeAgrment();
	}
	
	
	public void validateServiceFeeAgreementForm(){
		try{
			action.validateServiceFeeAgreementOption();
			action.validateServiceFeeCategory();
			action.sellingServiceFeeCategory();
			action.sellingServiceFeeListValidation();
			action.validateFullFillmentServiceFeeLinik();
			action.validateMemorandumOfUnderstanding();
			action.validateCheckBoxWithTearmAndCondition();
			action.acceptanceName();
			action.clickToSaveAggrement();
			action.validateAndClickToPopup();
			action.clickToSaveAndClose();
			action.validateCompleteRegistrationGreenMark();
		}
		catch(Exception e){e.getMessage();}
	}
	
	public void validateUploadProductStoreManager(){
		try{
			action.uploadProductStoreManager();
			action.clickToUploadProductCatalogLink();
			action.verifyManageProductPage();
			action.validateUploadingOptions();
			action.clickToOneByOneStartUploadingOption();
			action.verify1By1UploadProductpage();
			action.clickAndValidateToCreateNewProduct();
		}
		catch(Exception e){
			e.getMessage();
		}
	}
	public void productSellingInformationForm(){
		try{
			action.productTitleField();
			action.selectCategory();
			action.productListPrice();
			action.retailPrice();
			action.sellingPrice();
			action.FullDescription();
			action.productStatus();
			action.uploadPictureOfCurrentProduct();
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Override
	public void navigateVerifyProductPage() {}

	@Override
	public void buyNowVerifyCart() throws Exception {}

	@Override
	public void verifyCheckoutAddressPage() {}

	
	/** ***************************************************************************************
	 * Keyword-Name:    goToMerchantLoginPage
	 * Usage:           void goToMerchantLoginPage()
	 * Description:     Merchant login
	 * Author:          Automators
	 * Dated:           20May2015
	 * Notes:   
	 *************************************************************************************** **/
	public void goToMerchantLoginPage()
	{
		action.clickToHomePagePopup();
		action.clickToStarLogo();
		action.clickSellWithUsLink();
	}
	
	
	/** ***************************************************************************************
	 * Keyword-Name:    mobileWAPMerchantRegistration
	 * Usage:           void mobileWAPMerchantRegistration()
	 * Description:     Mobile wap merchant registration
	 * Author:          Automators
	 * Dated:           20May2015
	 * Notes:   
	 *************************************************************************************** **/
	public void mobileWAPMerchantRegistration() throws InterruptedException
	{
		action.clickSubmitButton();
		Thread.sleep(5000);
		action.verifyHiglightedColor_MerchantName();
		action.verifyHiglightedColor_StoreName();
		action.verifyHiglightedColor_PhnNo();
		action.verifyHiglightedColor_Email();
		action.verifyHiglightedColor_Password();
		action.typeOnMerchantName_Registration();
		action.typeOnMerchantStoreName_Registration();
		action.typeOnMerchantPhoneNo_Registration();
		action.typeOnMerchantEmail_Registration();
		action.typeOnMerchantPassword_Registration();
		action.typeOnMerchantRe_Password_Registration();
		action.selectMerchantState_Registration();
		action.typeOnMerchantCity_Registration();
		action.selectMerchantBusinessType_Registration();
		action.clickSubmitButton();
		Thread.sleep(10000);
	}
	
	
	/** ***************************************************************************************
	 * Keyword-Name:    mobileWAPFillSellerInformation
	 * Usage:           void mobileWAPFillSellerInformation()
	 * Description:     Fill seller information form
	 * Author:          Automators
	 * Dated:           20May2015
	 * Notes:   
	 *************************************************************************************** **/
	public void mobileWAPFillSellerInformation()
	{
		action.clickSellerInfoLink();
		action.clickOnSaveAndGoToNext_SellerInfoPage();
		action.typeOnCompanyLegalName_SellerInfoPage();
		action.typeStrategicBussinessEmail();
		action.checkSameAsAbove_SellerInfoPage();
		action.typeOnDispatchAddress1_SellerInfoPage();
		action.typeOnDispatchAddress2_SellerInfoPage();
		action.typeOnCity_SellerInfoPage();
		action.selectState_SellerInfoPage();
		action.typeOnPincode_SellerInfoPage(); 
		action.clickOnSaveAndGoToNext_SellerInfoPage();
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    mobileWAPFillBankDetails
	 * Usage:           void mobileWAPFillBankDetails()
	 * Description:     Mobile wap merchant fill bank details
	 * Author:          Automators
	 * Dated:           20May2015
	 * Notes:   
	 *************************************************************************************** * */
	
	public void mobileWapFillBankDetails()throws Exception{
		action.verifyBankDetailsForm();
		Thread.sleep(2000);
		action.panCardBankDetailsPage();
		action.nameOnPanCardField();
		action.dobOnPanCard();
		action.annualTurnOverField();
		action.descriptionField();
		
		action.typeOnAccHolderName_BankDetailsPage();
		action.typeOnBankName_BankDetailsPage();
		action.typeOnBankAccountNo_BankDetailsPage();
		action.selectBankAccountType_BankDetailsPage();
		action.typeOnBankIFSC_BankDetailsPage();
		action.checkAgreementStatement_BankDetailsPage();
		action.clickOnSaveAndGoToNext_SellerInfoPage();
		action.fillVATRegistrationNumber();
		action.clickOnSaveAndGoToNext_SellerInfoPage();
		//action.verifyTextOnPage(GlobalVar.TEST_DATA.get("Service Fee Page Text"));
	}
	
	public void merchantSupportform(){

		
		action.clickOnContinueToMobileSitePopUp();
		action.clickWishListIcon();
		action.clickSellWithUsLink();
		action.typeOnMerchantUserName_Login();
		action.typeOnMerchantPassword_Login();
		action.clickOnMerchantLoginButton();
		action.clickOnMerchantSupport_Link();
		action.typeOnMerchantSupport_Email();
		action.typeOnMerchantSupport_MID();
		action.typeOnMerchantSupport_Name();
		action.typeOnMerchantSupport_Phone();
		action.selectOnMerchantSupport_IssueType();
		action.typeOnMerchantSupport_Message();
		action.typeOnMerchantSupport_typeCapcha();
		action.clickOnMerchantSupport_Submit();
		
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    mobileWAPMerchantLogin
	 * Usage:           void mobileWAPMerchantLogin()
	 * Description:     Nevigate to merchant login page
	 * Author:          Automators
	 * Dated:           20May2015
	 * Notes:   
	 *************************************************************************************** **/
	public void mobileWAPMerchantLogin()
	{
		action.typeOnMerchantUserName_Login();
		action.typeOnMerchantPassword_Login();
		action.clickOnMerchantLoginButton();
		action.verifySellerInfoLink();
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    merchantRequestStoreApproval
	 * Usage:           void merchantRequestStoreApproval()
	 * Description:     Mobile wap merchant request store approval
	 * Author:          Automators
	 * Dated:           25May2015
	 * Notes:   
	 *************************************************************************************** **/
	
	public void merchantRequestStoreApproval(){
		action.clickOnRequestStoreApprovalButton();
		action.getAndVerifyRequestApprovalPendingText();
		action.verifyTextOnPage(GlobalVar.TEST_DATA.get("Success Message"));
	}
	
	
}

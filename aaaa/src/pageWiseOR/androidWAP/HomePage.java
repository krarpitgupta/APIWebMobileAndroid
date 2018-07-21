package pageWiseOR.androidWAP;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import session.DriverSession;
import utilities.GlobalVar;

public class HomePage {

	
	public static HomePage getInstance(){
		HomePage page=null;
		try{
			page=new HomePage();
		}catch(Exception e){
			e.printStackTrace();
		}
		return page;
	}

	public WebElement clickTo_HomePagePopup(WebDriver driver) {
		// TODO Auto-generated method stub
		WebElement element=driver.findElement(By.xpath("//div[contains(text(),'continue to the mobile site')]"));
		return element;
	}

	public WebElement clickAndValidateHomePage(WebDriver driver) {
		// TODO Auto-generated method stub
		WebElement element=driver.findElement(By.xpath(".//*[@id='mySwipe']/div/div[5]/a/img"));
		return element;
	}

	public WebElement clickTo_StoreLogo(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='logo']/div/a/img"));
		return element;
	}
	
	public WebElement validateTabPanes(WebDriver driver){
		WebElement element = driver.findElement(By.xpath(".//*[@id='main_column']/div[2]/div[3]/div/div[1]/ul/div[3]/li"));
		return element;
	}
	public WebElement validateMultipleTabPanes(WebDriver driver,int count){
		WebElement element=driver.findElement(By.xpath(".//*[@id='main_column']/div[2]/div[3]/div/div[1]/ul/div["+count+"]/a/li"));
		return element;
	}

	public WebElement clickTo_SellingServiceFeeCatgLogo(WebDriver driver) {
		// TODO Auto-generated method stub
		WebElement element=driver.findElement(By.xpath(".//*[@id='content_detailed']/fieldset/div/h2"));
		return element;									
	}

	public WebElement clickTo_StarButtonSign(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='wishlistHome']"));
		return element;		
	}

	public List<WebElement> clickTo_VariousOptions(WebDriver driver) {
		List<WebElement>elements=driver.findElements(By.xpath("html/body/footer/div[1]"));
		return elements;
	}

	public WebElement clickToSellWithOus(WebDriver driver) {
		// TODO Auto-generated method stub
		WebElement element=driver.findElement(By.xpath("html/body/footer/div[1]/a[2]"));
		return element;
	}

	public WebElement clickToUserNameLoginPage(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='username']"));
		return element;							
	}

	public WebElement clickTo_Password(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='password']"));
		return element;
	}

	public WebElement clickToLogin(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='main_column_login']/div/form/div[1]/div/div/span/input"));
		return element;
	}

	public WebElement clickTo_ProfileNameLogo(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='main_column']/div[2]/div/div[1]/h1[2]"));
		return element;
	}

	public WebElement clickTo_ServiceFeeArmentLink(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath("//*[@id='main_column']/div[3]/div/div[4]/div/div[1]/div[1]/div[2]/div/div[1]/div/p/a[3]"));
		return element;										
	}

	public List<WebElement> clickTo_GetDropDownValue(WebDriver driver) {
		List<WebElement> element=driver.findElements(By.xpath(".//*[@id='content_detailed']/fieldset/div/div[2]/table//table//table/tbody/tr"));
		return element;
	}

	public WebElement clickFulfillment(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='company_update_form']/div[2]/h2"));
		return element;
	}

	public WebElement ClickTo_MemorandumOptionLink(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='company_update_form']/span[1]/h1"));
		return element;
	}

	public WebElement clickTo_CheckBox(WebDriver driver) {
		WebElement element=driver.findElement(By.id("agree_check"));
		return element;
	}

	public WebElement clickToAccepter(WebDriver driver) {
		WebElement element=driver.findElement(By.name("name"));
		return element;
	}

	public WebElement clickToAcceptancer(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='name']"));
		return element;
	}

	public WebElement clickSave(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='fourth_step_button_display']/div[2]/span[1]/input"));
		return element;
	}

	public WebElement clickToLogos(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='congo_popup_show']/div[1]/div[1]"));
		return element;									
	}

	public WebElement clickToSaveAndClose(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='congo_popup_show']/div[2]/a[1]"));
		return element;
	}

	public WebElement cliclToMark(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='main_column']/div[2]/div/div[4]/div/div[1]/div[1]/div[4]/div/div[1]/div/p/a[3]/img"));
		return element;
	}

	public WebElement clickVerifyUploadProducts(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='main_column']/div[2]/div/div[4]/div/div[1]/div[1]/div[4]/div/div[2]/div/h2"));
		return element;						
	}

	public WebElement clickToProductCatalogLink(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='main_column']/div[2]/div/div[4]/div/div[1]/div[1]/div[2]/div/div[2]/div/p/a"));
		return element;									
	}													//.//*[@id='main_column']/div[2]/div/div[4]/div/div[1]/div[1]/div[4]/div/div[2]/div/p[1]/a

	public WebElement clickManageProduct(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='main_column']/h1"));
		return element;										
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    MobileWapMerchantBankDetails_BankName
	 * Usage:           WebElement MobileWapMerchantBankDetails_BankName(WebDriver driver)
	 * Description:     Merchant bank details account number
	 * Author:          Automators
	 * Dated:           21May2015
	 * Notes:   
	 *************************************************************************************** **/
	public WebElement MobileWapMerchantBankDetails_AccountNumber(WebDriver driver)
	{
		WebElement element=driver.findElement(By.id("company_bank_account_number"));
		return element;								
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    MobileWapMerchantBankDetails_AccountType
	 * Usage:           WebElement MobileWapMerchantBankDetails_AccountType(WebDriver driver)
	 * Description:     Merchant bank details account type
	 * Author:          Automators
	 * Dated:           21May2015
	 * Notes:   
	 *************************************************************************************** **/
	public WebElement MobileWapMerchantBankDetails_AccountType(WebDriver driver)
	{
		WebElement element=driver.findElement(By.id("company_bank_account_type"));
		return element;
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    dynamicwait
	 * Usage:           void dynamicwait(WebDriver driver,Integer time, WebElement element)
	 * Description:     wait for given object for given time
	 * Author:          Automators
	 * Dated:           13May2015
	 * Notes:   
	 *************************************************************************************** **/
	public void dynamicwait(WebDriver driver,Integer time, WebElement element)
	{
	
		try{
			
			(new WebDriverWait(driver, time)).until(ExpectedConditions.elementToBeClickable(element));
			
			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Wait for object successfully", "PASS",
								"Should be wait for object");

			} else {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Wait for object failed", "FAIL",
								"Should be wait for object");
			}
		
		}catch(Exception e){
			e.printStackTrace();
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Wait for object failed", "FAIL",
					"Should be wait for object");
		}
	}
	
	
	/** ***************************************************************************************
	 * Keyword-Name:    MobileWapMerchantRegistration_Submit
	 * Usage:           WebElement MobileWapMerchantRegistration_Submit(WebDriver driver)
	 * Description:     Merchant Registration Submit button
	 * Author:          Automators
	 * Dated:           19May2015
	 * Notes:   
	 *************************************************************************************** **/
	public WebElement MobileWapMerchantRegistration_Submit(WebDriver driver)
	{
		WebElement element=driver.findElement(By.xpath(".//*[@id='submit']"));
		return element;
	}
	
	
	/** ***************************************************************************************
	 * Keyword-Name:    sellWithUsLink
	 * Usage:           WebElement sellWithUsLink(WebDriver driver)
	 * Description:     Sell With Us Link
	 * Author:          Automators
	 * Dated:           19May2015
	 * Notes:   
	 *************************************************************************************** **/
	public WebElement sellWithUsLink(WebDriver driver)
	{
		WebElement element=null;
		try
		{
			element=driver.findElement(By.xpath("//a[contains(text(),'Sell with us')]"));
		}
		catch(Exception e){
			element=driver.findElement(By.xpath("//div[@class='footer-links']/a[2]"));			
		}
		return element;
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    MobileWapMerchantRegistration_MName
	 * Usage:           WebElement MobileWapMerchantRegistration_MName(WebDriver driver)
	 * Description:     Merchant Registration user name Edit field
	 * Author:          Automators
	 * Dated:           19May2015
	 * Notes:   
	 *************************************************************************************** **/
	public WebElement MobileWapMerchantRegistration_MName(WebDriver driver)
	{
		WebElement element=driver.findElement(By.id("company_admin_firstname"));
		return element;					
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    MobileWapMerchantRegistration_StoreName
	 * Usage:           WebElement MobileWapMerchantRegistration_StoreName(WebDriver driver)
	 * Description:     Merchant Registration store name Edit field
	 * Author:          Automators
	 * Dated:           19May2015
	 * Notes:   
	 *************************************************************************************** **/
	public WebElement MobileWapMerchantRegistration_StoreName(WebDriver driver)
	{
		WebElement element=driver.findElement(By.id("company_description_company"));
		return element;
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    MobileWapMerchantRegistration_PhoneNo
	 * Usage:           WebElement MobileWapMerchantRegistration_PhoneNo(WebDriver driver)
	 * Description:     Merchant Registration Phone number Edit field
	 * Author:          Automators
	 * Dated:           19May2015
	 * Notes:   
	 *************************************************************************************** **/
	public WebElement MobileWapMerchantRegistration_PhoneNo(WebDriver driver)
	{
		WebElement element=driver.findElement(By.id("company_description_phone"));
		return element;
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    MobileWapMerchantRegistration_Email
	 * Usage:           WebElement MobileWapMerchantRegistration_Email(WebDriver driver)
	 * Description:     Merchant Registration Email id Edit field
	 * Author:          Automators
	 * Dated:           19May2015
	 * Notes:   
	 *************************************************************************************** **/
	public WebElement MobileWapMerchantRegistration_Email(WebDriver driver)
	{
		WebElement element=driver.findElement(By.id("company_description_email"));
		return element;
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    MobileWapMerchantRegistration_Password
	 * Usage:           WebElement MobileWapMerchantRegistration_Password(WebDriver driver)
	 * Description:     Merchant Registration Password Edit field
	 * Author:          Automators
	 * Dated:           19May2015
	 * Notes:   
	 *************************************************************************************** **/
	public WebElement MobileWapMerchantRegistration_Password(WebDriver driver)
	{
		WebElement element=driver.findElement(By.id("registration_password"));
		return element;							
	}
	
	public WebElement MobileWapMerchantRegistration_State(WebDriver driver)
	{
		WebElement element=driver.findElement(By.id("state"));
		return element;
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    MobileWapMerchantRegistration_City
	 * Usage:           WebElement MobileWapMerchantRegistration_City(WebDriver driver)
	 * Description:     Merchant Registration City edit field
	 * Author:          Automators
	 * Dated:           19May2015
	 * Notes:   
	 *************************************************************************************** **/
	public WebElement MobileWapMerchantRegistration_City(WebDriver driver)
	{
		WebElement element=driver.findElement(By.id("company_address_city"));
		return element;
	}
	
	
	/** ***************************************************************************************
	 * Keyword-Name:    MobileWapMerchantRegistration_BusinessType
	 * Usage:           WebElement MobileWapMerchantRegistration_BusinessType(WebDriver driver)
	 * Description:     Merchant Registration Business type drop down
	 * Author:          Automators
	 * Dated:           19May2015
	 * Notes:   
	 *************************************************************************************** **/
	public WebElement MobileWapMerchantRegistration_BusinessType(WebDriver driver)
	{
		WebElement element=driver.findElement(By.id("company_description_business_type"));
		return element;
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    MobileWapMerchantRegistration_StartButton
	 * Usage:           WebElement MobileWapMerchantRegistration_StartButton(WebDriver driver)
	 * Description:     Merchant Registration Start button after registration
	 * Author:          Automators
	 * Dated:           19May2015
	 * Notes:   
	 *************************************************************************************** **/
	public WebElement MobileWapMerchantRegistration_StartButton(WebDriver driver)
	{
		WebElement element=driver.findElement(By.xpath("//*[@id='refreshMe']/div/input"));
		return element;
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    MobileWapMerchant_SellerInformationLink
	 * Usage:           WebElement MobileWapMerchant_SellerInformationLink(WebDriver driver)
	 * Description:     Seller information link afetr Merchant login
	 * Author:          Automators
	 * Dated:           19May2015
	 * Notes:   
	 *************************************************************************************** **/
	public WebElement MobileWapMerchant_SellerInformationLink(WebDriver driver)
	{
		WebElement element=driver.findElement(By.xpath("//*[@id='main_column']/div[3]/div/div[4]/div/div[1]/div[1]/div[2]/div/div[1]/div/p/a[1]/span"));
		return element;									
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    MobileWapMerchantSellerInformation_State
	 * Usage:           WebElement MobileWapMerchantSellerInformation_State(WebDriver driver)
	 * Description:     State under merchant Seller information page
	 * Author:          Automators
	 * Dated:           19May2015
	 * Notes:   
	 *************************************************************************************** **/
	public WebElement MobileWapMerchantSellerInformation_State(WebDriver driver)
	{
		WebElement element=driver.findElement(By.id("warehouse_state"));
		return element;
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    MobileWapMerchantSellerInformation_CompanyLegName
	 * Usage:           WebElement MobileWapMerchantSellerInformation_CompanyLegName(WebDriver driver)
	 * Description:     Company legal name under merchant Seller information page
	 * Author:          Automators
	 * Dated:           19May2015
	 * Notes:   
	 *************************************************************************************** **/
	public WebElement MobileWapMerchantSellerInformation_CompanyLegName(WebDriver driver)
	{
		WebElement element=driver.findElement(By.id("legal_name"));
		return element;
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    MobileWapMerchantSellerInformation_SameAsAbove
	 * Usage:           WebElement MobileWapMerchantSellerInformation_SameAsAbove(WebDriver driver)
	 * Description:     Same as above check under merchant Seller information page
	 * Author:          Automators
	 * Dated:           19May2015
	 * Notes:   
	 *************************************************************************************** **/
	public WebElement MobileWapMerchantSellerInformation_SameAsAbove(WebDriver driver)
	{
		WebElement element=driver.findElement(By.id("chkSame"));
		return element;
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    MobileWapMerchantSellerInformation_DispatchAddress1
	 * Usage:           WebElement MobileWapMerchantSellerInformation_DispatchAddress1(WebDriver driver)
	 * Description:     Pickup/dispatch address 1 under merchant Seller information page
	 * Author:          Automators
	 * Dated:           19May2015
	 * Notes:   
	 *************************************************************************************** **/
	public WebElement MobileWapMerchantSellerInformation_DispatchAddress1(WebDriver driver)
	{
		WebElement element=driver.findElement(By.id("warehouse_address1"));
		return element;
	}
	
	public WebElement MobileWapMerchantSellerInformation_DispatchAddress2(WebDriver driver)
	{
		WebElement element=driver.findElement(By.id("warehouse_address2"));
		return element;
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    MobileWapMerchantSellerInformation_City
	 * Usage:           WebElement MobileWapMerchantSellerInformation_City(WebDriver driver)
	 * Description:     City under merchant Seller information page
	 * Author:          Automators
	 * Dated:           19May2015
	 * Notes:   
	 *************************************************************************************** **/
	public WebElement MobileWapMerchantSellerInformation_City(WebDriver driver)
	{
		WebElement element=driver.findElement(By.id("warehouse_city"));
		return element;
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    MobileWapMerchantSellerInformation_PinCode
	 * Usage:           WebElement MobileWapMerchantSellerInformation_PinCode(WebDriver driver)
	 * Description:     Pin Code under merchant Seller information page
	 * Author:          Automators
	 * Dated:           19May2015
	 * Notes:   
	 *************************************************************************************** **/
	public WebElement MobileWapMerchantSellerInformation_PinCode(WebDriver driver)
	{
		WebElement element=driver.findElement(By.id("warehouse_pin"));
		return element;
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    MobileWapMerchantBankDetails_Pan
	 * Usage:           WebElement MobileWapMerchantBankDetails_Pan(WebDriver driver)
	 * Description:     Merchant bank details Pan number
	 * Author:          Automators
	 * Dated:           19May2015
	 * Notes:   
	 *************************************************************************************** **/
	public WebElement MobileWapMerchantBankDetails_Pan(WebDriver driver)
	{
		WebElement element=driver.findElement(By.xpath("//*[@id='pan_for_merchant']"));
		return element;									
	}										
	
	/** ***************************************************************************************
	 * Keyword-Name:    MobileWapMerchantBankDetails_PanName
	 * Usage:           WebElement MobileWapMerchantBankDetails_PanName(WebDriver driver)
	 * Description:     Merchant bank details Pan name
	 * Author:          Automators
	 * Dated:           21May2015
	 * Notes:   
	 *************************************************************************************** **/
	public WebElement MobileWapMerchantBankDetails_PanName(WebDriver driver)
	{
		WebElement element=driver.findElement(By.id("name_on_pan"));
		return element;
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    MobileWapMerchantBankDetails_PanDOB
	 * Usage:           WebElement MobileWapMerchantBankDetails_PanDOB(WebDriver driver)
	 * Description:     Merchant bank details Pan DOB
	 * Author:          Automators
	 * Dated:           21May2015
	 * Notes:   
	 *************************************************************************************** **/
	public WebElement MobileWapMerchantBankDetails_PanDOB(WebDriver driver)
	{
		WebElement element=driver.findElement(By.id("dob_on_pan_card"));
		return element;
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    MobileWapMerchantBankDetails_AnnualTurnOver
	 * Usage:           WebElement MobileWapMerchantBankDetails_AnnualTurnOver(WebDriver driver)
	 * Description:     Merchant bank details Pan annual turn over
	 * Author:          Automators
	 * Dated:           21May2015
	 * Notes:   
	 *************************************************************************************** **/
	public WebElement MobileWapMerchantBankDetails_AnnualTurnOver(WebDriver driver)
	{
		WebElement element=driver.findElement(By.id("annual_turnover"));
		return element;
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    MobileWapMerchantBankDetails_DescribeYou
	 * Usage:           WebElement MobileWapMerchantBankDetails_DescribeYou(WebDriver driver)
	 * Description:     Merchant bank details what best describe you
	 * Author:          Automators
	 * Dated:           21May2015
	 * Notes:   
	 *************************************************************************************** **/
	public WebElement MobileWapMerchantBankDetails_DescribeYou(WebDriver driver)
	{
		WebElement element=driver.findElement(By.id("badge_option_1"));
		return element;
	}
	
	
	/** ***************************************************************************************
	 * Keyword-Name:    MobileWapMerchantBankDetails_AccHolderName
	 * Usage:           WebElement MobileWapMerchantBankDetails_AccHolderName(WebDriver driver)
	 * Description:     Merchant bank details Account holder name
	 * Author:          Automators
	 * Dated:           21May2015
	 * Notes:   
	 *************************************************************************************** **/
	public WebElement MobileWapMerchantBankDetails_AccHolderName(WebDriver driver)
	{
		WebElement element=driver.findElement(By.id("company_bank_account_name"));
		return element;
	}
	
	
	/** ***************************************************************************************
	 * Keyword-Name:    MobileWapMerchantBankDetails_BankName
	 * Usage:           WebElement MobileWapMerchantBankDetails_BankName(WebDriver driver)
	 * Description:     Merchant bank details Bank name
	 * Author:          Automators
	 * Dated:           21May2015
	 * Notes:   
	 *************************************************************************************** **/
	public WebElement MobileWapMerchantBankDetails_BankName(WebDriver driver)
	{
		WebElement element=driver.findElement(By.id("company_bank_name"));
		return element;
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    MobileWapMerchantBankDetails_IFSCCode
	 * Usage:           WebElement MobileWapMerchantBankDetails_IFSCCode(WebDriver driver)
	 * Description:     Merchant bank details IFSC code
	 * Author:          Automators
	 * Dated:           21May2015
	 * Notes:   
	 *************************************************************************************** **/
	public WebElement MobileWapMerchantBankDetails_IFSCCode(WebDriver driver)
	{
		WebElement element=driver.findElement(By.id("company_bank_ifsc_code"));
		return element;
	}
	
	
	/** ***************************************************************************************
	 * Keyword-Name:    MobileWapMerchantBankDetails_AgreementCheck
	 * Usage:           WebElement MobileWapMerchantBankDetails_AgreementCheck(WebDriver driver)
	 * Description:     Merchant bank details Agreement check
	 * Author:          Automators
	 * Dated:           21May2015
	 * Notes:   
	 *************************************************************************************** **/
	public WebElement MobileWapMerchantBankDetails_AgreementCheck(WebDriver driver)
	{
		WebElement element=driver.findElement(By.id("company_bank_agree_cb"));
		return element;
	}

	public List<WebElement> clickToVariousUploadingOptions(WebDriver driver) {
		List<WebElement>list=driver.findElements(By.xpath(".//*[@class='prd_upld_bar']/table/tbody/tr/td"));
		return list;											
	}

	public WebElement clickTo_OneByOneBanner(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='product_update']/div/h1"));
		return element;
	}

	public WebElement clickToOneByOneOption(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='main_column']/div[3]/table/tbody/tr/td[1]/div/a"));
		return element;									
	}

	public WebElement clickCreateNewProduct(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='product_update']/div/div/span/a/input"));
		return element;
	}

	public WebElement clickToProdTitleField(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='product_description_product']"));
		return element;
	}

	public WebElement clickToSelectCatg(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='category0']"));
		return element;
	}

	public WebElement clickSubCategoryList(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='category368']"));
		return element;
	}

	public WebElement clickToThirdCatgList(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='category593']"));
		return element;
	}

	public WebElement clickToProdPrice(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='product_data_list_price']"));
		return element;
	}

	public WebElement clickToRetailPrice(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='product_data_retail_price']"));
		return element;
	}

	public WebElement clickTo_SellingPrice(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='price_price']"));
		return element;
	}

	public WebElement clickTo_FullDescription(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='product_full_descr_bold']/span"));
		return element;							
	}

	public WebElement clickToStatusBox(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='messageBox']"));
		return element;
	}

	public WebElement clickToDescCounter(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='product_descr_word_count']"));
		return element;
	}

	public WebElement clickToUploadPictureURL(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='url_608714aa73b5ced0b2509ebc3c42edd0']"));
		return element;
	}

	public WebElement clickTo_Repassword(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='registration_re-password']"));
		return element;
	}

	public WebElement SaveAndGoTONextSellerInfoPage(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath("//*[@id='company_update_form']/div[3]/div[1]/span[2]/input"));
		return element;
	}

	public WebElement clickToStraticBusiness(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath("//*[@id='company_description_key_email']"));
		return element;
	}

	/** ***************************************************************************************
	 * Keyword-Name:    MobileWapContinueToMobileSite
	 * Usage:           WebElement MobileWapContinueToMobileSite(WebDriver driver)
	 * Description:     Mobile site continue pop up
	 * Author:          Automators
	 * Dated:           22May2015
	 * Notes:   
	 *************************************************************************************** **/
	public WebElement MobileWapContinueToMobileSite(WebDriver driver)
	{
		WebElement element=driver.findElement(By.xpath("//*[@id='androidAppPopup']/div"));
		return element;
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    wishlistHomeIcon
	 * Usage:           WebElement wishlistHomeIcon(WebDriver driver)
	 * Description:     wishlist Home Icon
	 * Author:          Automators
	 * Dated:           19May2015
	 * Notes:   
	 *************************************************************************************** **/
	public WebElement wishlistHomeIcon(WebDriver driver)
	{
		WebElement element=driver.findElement(By.id("wishlistHome"));
		return element;
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    MobileWapMerchantLogin_Password
	 * Usage:           WebElement MobileWapMerchantLogin_Password(WebDriver driver)
	 * Description:     Merchant login password
	 * Author:          Automators
	 * Dated:           19May2015
	 * Notes:   
	 *************************************************************************************** **/
	public WebElement MobileWapMerchantLogin_Password(WebDriver driver)
	{
		WebElement element=driver.findElement(By.id("password"));
		return element;
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    MobileWapMerchantLogin_LoginButton
	 * Usage:           WebElement MobileWapMerchantLogin_LoginButton(WebDriver driver)
	 * Description:     Merchant login button
	 * Author:          Automators
	 * Dated:           19May2015
	 * Notes:   
	 *************************************************************************************** **/
	public WebElement MobileWapMerchantLogin_LoginButton(WebDriver driver)
	{
		WebElement element=driver.findElement(By.name("dispatch[auth.login]"));
		return element;
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    MobileWapMerchantLogin_UserName
	 * Usage:           WebElement MobileWapMerchantLogin_UserName(WebDriver driver)
	 * Description:     Merchant login user name
	 * Author:          Automators
	 * Dated:           19May2015
	 * Notes:   
	 *************************************************************************************** **/
	public WebElement MobileWapMerchantLogin_UserName(WebDriver driver)
	{
		WebElement element=driver.findElement(By.id("username"));
		return element;
	}
	
	
	/** ***************************************************************************************
	 * Keyword-Name:    merchantSupportLink
	 * Usage:           WebElement merchantSupportLink(WebDriver driver)
	 * Description:     Merchant Email Test Box
	 * Author:          KAutomators
	 * Dated:           19May2015
	 * Notes:   
	 *************************************************************************************** **/
	
	public WebElement merchantSupportLink(WebDriver driver)
	{
		WebElement element=driver.findElement(By.xpath("//a[2]/img"));
		return element;
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    merchantSupportEmail
	 * Usage:           WebElement merchantEmail(WebDriver driver)
	 * Description:     Merchant Email Test Box
	 * Author:          KAutomators
	 * Dated:           19May2015
	 * Notes:   
	 *************************************************************************************** **/
	
	public WebElement merchantSupportEmail(WebDriver driver)
	{
		WebElement element=driver.findElement(By.id("email"));
		return element;
	}
	/** ***************************************************************************************
	 * Keyword-Name:    merchantSupportID
	 * Usage:           WebElement merchantEmail(WebDriver driver)
	 * Description:     Merchant Email Test Box
	 * Author:          KAutomators
	 * Dated:           19May2015
	 * Notes:   
	 *************************************************************************************** **/
	public WebElement merchantSupportID(WebDriver driver)
	{
		WebElement element=driver.findElement(By.id("mid"));
		return element;
	}
	/** ***************************************************************************************
	 * Keyword-Name:    merchantSupportName
	 * Usage:           WebElement merchantSupportName(WebDriver driver)
	 * Description:     Merchant Email Test Box
	 * Author:          KAutomators
	 * Dated:           19May2015
	 * Notes:   
	 *************************************************************************************** **/
	public WebElement merchantSupportName(WebDriver driver)
	{
		WebElement element=driver.findElement(By.id("email"));
		return element;
	}
	/** ***************************************************************************************
	 * Keyword-Name:    merchantSupportPhone
	 * Usage:           WebElement merchantSupportPhone(WebDriver driver)
	 * Description:     Merchant Email Test Box
	 * Author:          KAutomators
	 * Dated:           19May2015
	 * Notes:   
	 *************************************************************************************** **/
	public WebElement merchantSupportPhone(WebDriver driver)
	{
		WebElement element=driver.findElement(By.id("phone"));
		return element;
	}
	/** ***************************************************************************************
	 * Keyword-Name:    merchantSupportIssueType
	 * Usage:           WebElement merchantSupportIssueType(WebDriver driver)
	 * Description:     Merchant Email Test Box
	 * Author:          KAutomators
	 * Dated:           19May2015
	 * Notes:   
	 *************************************************************************************** **/
	public WebElement merchantSupportIssueType(WebDriver driver)
	{
		WebElement element=driver.findElement(By.id("parent_issue"));
		return element;
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    merchantSupportMessage
	 * Usage:           WebElement merchantSupportMessage(WebDriver driver)
	 * Description:     Merchant Email Test Box
	 * Author:          KAutomators
	 * Dated:           19May2015
	 * Notes:   
	 *************************************************************************************** **/
	public WebElement merchantSupportMessage(WebDriver driver)
	{
		WebElement element=driver.findElement(By.id("message"));
		return element;
	}
	/** ***************************************************************************************
	 * Keyword-Name:    merchantSupportCapchaText
	 * Usage:           WebElement merchantSupportCapchaText(WebDriver driver)
	 * Description:     Merchant Email Test Box
	 * Author:          KAutomators
	 * Dated:           19May2015
	 * Notes:   
	 *************************************************************************************** **/
	public WebElement merchantSupportCapchaText(WebDriver driver)
	{
		WebElement element=driver.findElement(By.xpath("//div[10]/label"));
		return element;
	}
	/** ***************************************************************************************
	 * Keyword-Name:    merchantSupportCapchaTextBox
	 * Usage:           WebElement merchantSupportCapchaTextBox(WebDriver driver)
	 * Description:     Merchant Email Test Box
	 * Author:          KAutomators
	 * Dated:           19May2015
	 * Notes:   
	 *****************************************************************************************/
	public WebElement merchantSupportCapchaTextBox(WebDriver driver)
	{
		WebElement element=driver.findElement(By.id("verification_code"));
		return element;
	}
	/** ***************************************************************************************
	 * Keyword-Name:    merchantSupportSubmit
	 * Usage:           WebElement merchantSupportSubmit(WebDriver driver)
	 * Description:     Merchant Email Test Box
	 * Author:          KAutomators
	 * Dated:           19May2015
	 * Notes:   
	 *****************************************************************************************/
	public WebElement merchantSupportSubmit(WebDriver driver)
	{
		WebElement element=driver.findElement(By.xpath("//div[11]/input"));
		return element;
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    MobileWapRequestStoreApprovalButton
	 * Usage:           WebElement MobileWapRequestStoreApprovalButton(WebDriver driver)
	 * Description:     Request Store Approval button
	 * Author:          Automators
	 * Dated:           25May2015
	 * Notes:   
	 *************************************************************************************** **/
	public WebElement mobileWapRequestStoreApprovalButton(WebDriver driver)
	{
		WebElement element=driver.findElement(By.xpath("//*[@id='main_column']/div[2]/div/div[4]/div/div[1]/div[1]/div[1]/a[2]/span/input"));
		return element;
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    MobileWapRequestApprovalPending
	 * Usage:           WebElement MobileWapRequestApprovalPending(WebDriver driver)
	 * Description:     Request Approval pending text
	 * Author:          Automators
	 * Dated:           25May2015
	 * Notes:   
	 *************************************************************************************** **/
	public WebElement mobileWapRequestApprovalPending(WebDriver driver)
	{
		WebElement element=driver.findElement(By.xpath("//*[@id='main_column']/div[2]/div/div[4]/div/div[1]/div[1]/div[1]/span"));
		return element;
	}

	public WebElement clickToBankDetails(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath("//*[@id='company_update_form']/div[1]/ul/div[2]/li"));
		return element;
	}

	public WebElement clickToPanCardDetails(WebDriver driver) {
		WebElement element=driver.findElement(By.name("company_bank_data[PAN]"));
		return element;									
	}

	public WebElement ClickToNameOnPan(WebDriver driver) {
		WebElement element=driver.findElement(By.name("company_bank_data[name_on_pan]"));
		return element;
	}

	public WebElement clickToDOB(WebDriver driver) {
		WebElement element=driver.findElement(By.name("company_bank_data[dob_on_pan]"));
		return element;
	}

	public WebElement clickToAnnualT_Over(WebDriver driver) {
		WebElement element=driver.findElement(By.id("annual_turnover"));
		return element;
	}

	public WebElement clickToDesc(WebDriver driver) {
		WebElement element=driver.findElement(By.id("badge_option_1"));
		return element;
	}

	public WebElement getVatNumber(WebDriver driver) {
		WebElement element=driver.findElement(By.id("company_bank_vat_cst_number"));
		return element;
	}
}

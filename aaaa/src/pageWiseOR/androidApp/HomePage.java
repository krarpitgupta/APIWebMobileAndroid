/* ***************************************************************************************
 * Object Repository-Name:	pageWiseOR/androidApp/HomePage.java
 * Description:	Object Repository to define objects in ShopClues| Android App| Home Page
 * Author:		Sahil Jariwala
 * Dated:		16Mar2015
 * Notes:	
 *  
 *************************************************************************************** */
// Package name: pageWiseOR.androidApp
package pageWiseOR.androidApp;

//List of packages to be imported for androidApp/HomePage.java
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByLinkText;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import session.DriverSession;
import utilities.GlobalVar;
import utilities.Keywords;
import utilities.Utility;

// 'HomePage' class defined to include objects in ShopClues| Android App| Home Page
public class HomePage {
	
	/*Utility utilObj = new Utility();
	Properties pageProp = utilObj.loadPageProperties(GlobalVar.CURRENT_PROJECT_PATH + "/src/pageWiseOR/androidApp/pageProperties/homePage.properties");*/
	

	public static HomePage getInstance()
	{
		return new HomePage();
	}
	
	public WebElement homeBanner(WebDriver driver)
	{
		WebElement element=driver.findElement(By.id("com.shopclues:id/image"));
		return element;
	}
	
	public List<WebElement> removePopups(WebDriver driver)
	{
		List<WebElement> elements=driver.findElements(By.id(""));
		return elements;
	}
	
	
	
	public List<WebElement> productCategory(WebDriver driver)
	{
		List<WebElement> elements=driver.findElements(By.id(""));
		return elements;
	}
	
	public List<WebElement> shopByCategory(WebDriver driver)
	{
		List<WebElement> elements=driver.findElements(By.id(""));
		return elements;
	}
	
	
	public List<WebElement> menswesterWear(WebDriver driver)
	{
		List<WebElement> elements =driver.findElements(By.id(""));
		return elements;
	}
	
	public WebElement clickSearchButton(WebDriver driver)
	{
		WebElement elements=driver.findElement(By.id(""));
		return elements;
	}
	
	public WebElement writeToSearchBox(WebDriver driver)
	{
		WebElement elements=driver.findElement(By.id(""));
		return elements;
	}
	public WebElement clickOn_GoButton(WebDriver driver)
	{
		WebElement elements=driver.findElement(By.id(""));
		return elements;
	}
	public List<WebElement> clickOn_Selected_Item(WebDriver driver)
	{
		List <WebElement> elements=driver.findElements(By.id(""));
		return elements;
	}
	public List<WebElement> productHeaders(WebDriver driver)
	{
		List<WebElement> headers=driver.findElements(By.id(""));
	    return headers;
	}
		
	public WebElement productName(WebDriver driver)
	{
		WebElement productName=driver.findElement(By.id(""));
		return productName;
	}
	
	
	public WebElement buyNowButton(WebDriver driver)
	{
		WebElement buynow=driver.findElement(By.id(""));
		return buynow;
	}
	
	public List<WebElement> buyBySize(WebDriver driver)
	{
		List<WebElement> buyBySize=driver.findElements(By.className(""));
		return buyBySize;
	}
	
	public List<WebElement> sizePopup(WebDriver driver)
	{
		List<WebElement> sizePopup=driver.findElements(By.id(""));
		return sizePopup;
	}
	
	public WebElement cartProductName(WebDriver driver)
	{
		WebElement cartProductName=driver.findElement(By.id(""));
		return cartProductName;
		
		
	}

	public WebElement placeOrderButton(WebDriver driver)
	{
		WebElement placeOredrButton=driver.findElement(By.id("com.shopclues:id/place_order"));
		return placeOredrButton;
		
	}
	
	public List<WebElement>  WithPasswordRadio(WebDriver driver)
	{
		List<WebElement>  WithPasswordRadio=driver.findElements(By.className("android.widget.RadioButton"));
		return WithPasswordRadio;
		
	}
	
	public WebElement EmailField(WebDriver driver)
	{
		WebElement EmailField=driver.findElement(By.id("com.shopclues:id/nameColumn"));
		return EmailField;								
		
	}
	
	public WebElement PasswordField(WebDriver driver)
	{
		
		WebElement PasswordField=driver.findElement(By.id("com.shopclues:id/password"));                                      
		return PasswordField;
		
	}
	
	public WebElement continueButton(WebDriver driver){
		WebElement continueButton=driver.findElement(By.id("com.shopclues:id/continueButton"));
		return continueButton;								
	}
	
	public WebElement shipping_ContinueButton(WebDriver driver){
		WebElement shippingConti=driver.findElement(By.id(""));
		return shippingConti;
	}
	
	public WebElement productPage(WebDriver driver) {
		WebElement element=driver.findElement(By.id("com.shopclues:id/imageView_save"));
		return element;								 
	}
	
	public WebElement addCartButtonValidate(WebDriver driver) {
		// TODO Auto-generated method stub
		WebElement element=driver.findElement(By.id("com.shopclues:id/add_to_cart"));
		return element;								
	}

	public WebElement qualityFieldExistance(WebDriver driver) {
		// TODO Auto-generated method stub
		WebElement element=driver.findElement(By.id("com.shopclues:id/qnty_select"));
		return element;								
	}
	
	public WebElement shoppingCart(WebDriver driver) {
		WebElement element=driver.findElement(By.id("com.shopclues:id/cart"));
		return element;								 
	}

	public WebElement getCartCounter(WebDriver driver) {
		WebElement element=driver.findElement(By.id("com.shopclues:id/nom_product"));
		return element;								
	}

	public List<WebElement> getNoOfQuantities(WebDriver driver) {
		List <WebElement> al=driver.findElements(By.id("com.shopclues:id/text"));
		return al;
	}

	public WebElement getProductQuantity(WebDriver driver) {
		// TODO Auto-generated method stub
		WebElement element=driver.findElement(By.id("com.shopclues:id/quentity"));
		return element;
	}
	
	public WebElement getProductRate(WebDriver driver){
		WebElement element=driver.findElement(By.id("com.shopclues:id/calculate_selling_price"));
		return element;								 
	}

	public WebElement clickOnQTY(WebDriver driver) {
		// TODO Auto-generated method stub
		WebElement element=driver.findElement(By.id("com.shopclues:id/item_name"));
		return element;
	}
	
	public WebElement clickOn_BuyNowButton(WebDriver driver) {
		WebElement element=driver.findElement(By.id("com.shopclues:id/buynow"));
		return element;
	}

	public WebElement shoppingCart_Banner(WebDriver driver) {
		// TODO Auto-generated method stub
		WebElement element=driver.findElement(By.id("com.shopclues:id/myOrders"));
		return element;
	}

	public WebElement getGrandTotalAmount(WebDriver driver) {
		WebElement element=driver.findElement(By.id("com.shopclues:id/total_price"));
		return element;
	}
	
	
	public WebElement splashScreen_Menu(WebDriver driver)
	{
		WebElement ScreenMenu=driver.findElement(By.id("android:id/up"));
		return ScreenMenu;
	}
	
	public WebElement splashScreen_Menu_Items(WebDriver driver,String ProductName)
	{	
		WebElement ScreenMenu=driver.findElement(By.name(" + ProductName + "));
		return ScreenMenu;
		
	}
	
	public WebElement splashScreen_Menu_shopByCategory(WebDriver driver)
	{
		WebElement ScreenMenu=driver.findElement(By.name("Shop By Category"));
		return ScreenMenu;
		
	}
	
	public WebElement splashScreen_Menu_shopByCategory_Computer(WebDriver driver)
	{
		WebElement ScreenMenu=driver.findElement(By.name("Computers"));
		return ScreenMenu;
		
	}
	
	public WebElement splashScreen_Menu_shopByCategory_Computer_MemoryDevices(WebDriver driver)
	{
		WebElement ScreenMenu=driver.findElement(By.name("Memory Devices"));
		return ScreenMenu;
		
	}

	public WebElement splashScreen_Menu_shopByCategory_Computer_MemoryDevices_PenDriver(WebDriver driver)
	{
		WebElement ScreenMenu=driver.findElement(By.name("Pen Drive"));
		return ScreenMenu;
		
	}
	
	public WebElement product_Serach(WebDriver driver)
	{
		WebElement ScreenMenu=driver.findElement(By.id("com.shopclues:id/action_search_bar"));
		return ScreenMenu;
	}
	
	public WebElement product_SerachBox(WebDriver driver)
	{
		WebElement ScreenMenu=driver.findElement(By.id("com.shopclues:id/editText1"));
		return ScreenMenu;
	}
	
	public WebElement product_SearchBoxGo(WebDriver driver)
	{
		WebElement ScreenMenu=driver.findElement(By.name("GO"));
		return ScreenMenu;
		
	}
	
	
	
	public WebElement product_DesiredProduct(WebDriver driver)
	{
		WebElement ScreenMenu=driver.findElement(By.id("com.shopclues:id/header_text"));
		return ScreenMenu;
		
	}
	
	public List<WebElement> product_SearchOptions(WebDriver driver)
	{
		List<WebElement> productOptions=driver.findElements(By.className("android.widget.RelativeLayout"));
		System.out.println("productOptions");
		return productOptions;
	
	}
	
	
	public WebElement product_Quantity(WebDriver driver)
	{
		WebElement productOptions=driver.findElement(By.id("com.shopclues:id/qnty_select"));
		System.out.println("productOptions");						
		return productOptions;
	}
	
	public List<WebElement> quantityPopup(WebDriver driver)
	{
		List<WebElement> quantityPopup=driver.findElements(By.id("com.shopclues:id/text"));
		return quantityPopup;
	}
	
	public WebElement product_AddToCart(WebDriver driver)
	{
		WebElement ScreenMenu=driver.findElement(By.id("com.shopclues:id/add_to_cart"));
		return ScreenMenu;
	}
	
	public WebElement product_Cart(WebDriver driver)
	{
		WebElement ScreenMenu=driver.findElement(By.id("com.shopclues:id/cart"));
		return ScreenMenu;
	}
	
	public WebElement product_DeleteFromCart(WebDriver driver)
	{
		WebElement ScreenMenu=driver.findElement(By.id("com.shopclues:id/cancle_image"));
		return ScreenMenu;
	}
	
	public WebElement product_PlaceOrderFromCart(WebDriver driver)
	{
		WebElement ScreenMenu=driver.findElement(By.id("com.shopclues:id/place_order"));
		return ScreenMenu;
	}
	
	public WebElement product_Email(WebDriver driver)
	{
		WebElement ScreenMenu=driver.findElement(By.id("com.shopclues:id/nameColumn"));
		return ScreenMenu;
	}
	
	public WebElement product_ContinueLink(WebDriver driver)
	{
		WebElement ScreenMenu=driver.findElement(By.id("com.shopclues:id/continueButton"));
		return ScreenMenu;
	}
	
	public WebElement product_ForgotPassword(WebDriver driver)
	{
		WebElement ScreenMenu=driver.findElement(By.id("com.shopclues:id/forgot_password"));
		return ScreenMenu;
	}
	
	public WebElement product_FirstName(WebDriver driver)
	{
		WebElement ScreenMenu=driver.findElement(By.id("com.shopclues:id/firstname"));
		return ScreenMenu;
	}
	
	public WebElement product_LastName(WebDriver driver)
	{
		WebElement ScreenMenu=driver.findElement(By.id("com.shopclues:id/lastname"));
		return ScreenMenu;
	}
	public WebElement product_PinCode(WebDriver driver)
	{
		WebElement ScreenMenu=driver.findElement(By.id("com.shopclues:id/s_zipcode"));
		return ScreenMenu;
	}
	
	public WebElement product_MobileNumber(WebDriver driver)
	{
		WebElement ScreenMenu=driver.findElement(By.id("com.shopclues:id/s_phone"));
		return ScreenMenu;
	}
	
	public WebElement product_Address(WebDriver driver)
	{
		WebElement ScreenMenu=driver.findElement(By.id("com.shopclues:id/s_address"));
		return ScreenMenu;
	}
	public WebElement product_Address2(WebDriver driver)
	{
		WebElement ScreenMenu=driver.findElement(By.id("com.shopclues:id/s_address_2"));
		return ScreenMenu;
	}
	public WebElement product_City(WebDriver driver)
	{
		WebElement ScreenMenu=driver.findElement(By.id("com.shopclues:id/s_city"));
		return ScreenMenu;
	}
	public WebElement product_SelectStateDropDown(WebDriver driver)
	{
		WebElement ScreenMenu=driver.findElement(By.id("com.shopclues:id/s_state"));
		return ScreenMenu;
	}
	
	public WebElement product_ShippingAddressPageContinueLink(WebDriver driver)
	{
		WebElement ScreenMenu=driver.findElement(By.id("com.shopclues:id/continueButtonforScreen2"));
		return ScreenMenu;
	}
	
	public WebElement product_WrongPinCodeErrorMessage(WebDriver driver)
	{
		WebElement ScreenMenu=driver.findElement(By.id("com.shopclues:id/content"));
		return ScreenMenu;
	}
	
	public WebElement product_WrongPinCodeErrorClosePopUp(WebDriver driver)
	{
		WebElement ScreenMenu=driver.findElement(By.id("com.shopclues:id/close_popup"));
		return ScreenMenu;
	}
	
	public WebElement product_AppMenu(WebDriver driver)
	{
		WebElement Login=driver.findElement(By.id("com.shopclues:id/action_more"));
		return Login;							   
	}
	
	public WebElement product_AppLogin(WebDriver driver)
	{
		WebElement Login=driver.findElement(By.id("com.shopclues:id/tvUserName"));
		return Login;
	}
	
	public WebElement product_AppLogin_Email(WebDriver driver)
	{
		WebElement Login=driver.findElement(By.id("com.shopclues:id/userName"));
		return Login;
	}
	
	public WebElement product_AppLogin_Password(WebDriver driver)
	{
		WebElement Login=driver.findElement(By.id("com.shopclues:id/password"));
		return Login;								
	}
	
	public WebElement product_AppLogin_ShowPassword(WebDriver driver)
	{
		WebElement Login=driver.findElement(By.id("com.shopclues:id/remember_me"));
		return Login;
	}
	
	public WebElement product_AppLogin_LoginLink(WebDriver driver)
	{
		WebElement Login=driver.findElement(By.id("com.shopclues:id/login"));
		return Login;							   
	}
	
	public WebElement product_AppLogin_ForgotPassword(WebDriver driver)
	{
		WebElement Login=driver.findElement(By.id("com.shopclues:id/forgot_password"));
		return Login;
	}
	
	public WebElement product_AppLogin_RegisterNow(WebDriver driver)
	{
		By by = new Keywords().checkElement(driver,By.id("com.shopclues:id/register_user"));
		return driver.findElement(by);
	}
	
	public WebElement product_AppLogin_RegisterNow_FirstName(WebDriver driver)
	{
		WebElement Login=driver.findElement(By.id("com.shopclues:id/first_name"));
		return Login;
	}
	
	public WebElement product_AppLogin_RegisterNow_LastName(WebDriver driver)
	{
		WebElement Login=driver.findElement(By.id("com.shopclues:id/last_name"));
		return Login;
	}
	
	public WebElement product_AppLogin_RegisterNow_Email(WebDriver driver)
	{
		WebElement Email=driver.findElement(By.id("com.shopclues:id/email_id"));
		return Email;
	}
	
	public WebElement product_AppLogin_RegisterNow_Password(WebDriver driver)
	{
		WebElement Password=driver.findElement(By.id("com.shopclues:id/password"));
		return Password;
	}
	
	public WebElement product_AppLogin_RegisterNow_ConfirmPassword(WebDriver driver)
	{
		WebElement ConfirmPassword=driver.findElement(By.id("com.shopclues:id/confirmation"));
		return ConfirmPassword;
	}
	
	public WebElement product_AppLogin_RegisterNow_CreateAccount(WebDriver driver)
	{
		WebElement CreateAccount=driver.findElement(By.id("com.shopclues:id/account_create"));
		return CreateAccount;
	}
	
	public WebElement product_AppLogin_ForgotPassword_EmailID(WebDriver driver)
	{
		WebElement CreateAccount=driver.findElement(By.id("com.shopclues:id/email_id"));
		return CreateAccount;
	}
	
	public WebElement product_AppLogin_ForgotPassword_Submit(WebDriver driver)
	{
		WebElement CreateAccount=driver.findElement(By.id("com.shopclues:id/forgot_password"));
		return CreateAccount;
	}
	
	
	
	
	///////////////////OLA-------------
	
	public WebElement OLA_Ride_SignUp(WebDriver driver)
	{
		WebElement olaRide=driver.findElement(By.name("Sign Up"));
		return olaRide;
	}
	
	
	public WebElement OLA_Ride_Login(WebDriver driver)
	{
		WebElement olaRide=driver.findElement(By.name("Login"));
		return olaRide;
	}
	
	public WebElement OLA_Ride_Email(WebDriver driver)
	{
		WebElement olaRide=driver.findElement(By.name("Enter Email"));
		return olaRide;
	}
	
	public WebElement OLA_Ride_Password(WebDriver driver)
	{
		WebElement olaRide=driver.findElement(By.id("com.olacabs.customer:id/login_password_txt"));
		return olaRide;
	}
	
	
	
	public WebElement OLA_Ride(WebDriver driver)
	{
		WebElement olaRide=driver.findElement(By.name("RIDE NOW"));
		return olaRide;
	}
	
	public WebElement OLA_Ride_AirportDrop(WebDriver driver)
	{
		WebElement olaRide=driver.findElement(By.id("com.olacabs.customer:id/toggle_airport_drop"));
		return olaRide;
	}
	
	public WebElement OLA_Ride_Confirm(WebDriver driver)
	{
		WebElement olaRide=driver.findElement(By.id("com.olacabs.customer:id/button_ride_conform"));
		return olaRide;
	}
	
	public WebElement OLA_Ride_IAgree(WebDriver driver)
	{
		WebElement olaRide=driver.findElement(By.id("com.olacabs.customer:id/agree_text"));
		return olaRide;
	}	
	
	public WebElement getHomeBanner(WebDriver driver){
		WebElement element=driver.findElement(By.id("com.shopclues:id/dealsbanner"));
		return element;
	}

	public List<WebElement> clickShopclues_Menu(WebDriver driver) {
		// TODO Auto-generated method stub
		List <WebElement>al=driver.findElements(By.id("com.shopclues:id/text"));
		return al;
	}

	public List<WebElement> click_CategoryItems(WebDriver driver) {
		// TODO Auto-generated method stub
		List <WebElement>al=driver.findElements(By.id("com.shopclues:id/name"));
		return al;
	}

	public List<WebElement> getNoOfObjects(WebDriver driver) {
		// TODO Auto-generated method stub
		List <WebElement>al=driver.findElements(By.id("com.shopclues:id/name"));
		return al;									   
	}

	public WebElement clickToSearchBar(WebDriver driver) {
		// TODO Auto-generated method stub
		WebElement element=driver.findElement(By.id("com.shopclues:id/action_search_bar"));
		return element;								 
	}

	public WebElement getTextBox(WebDriver driver) {
		// TODO Auto-generated method stub
		WebElement element=driver.findElement(By.id("com.shopclues:id/editText1"));
		return element;
	}

	public WebElement clickTo_Go_Button(WebDriver driver) {
		// TODO Auto-generated method stub
		WebElement element=driver.findElement(By.id("com.shopclues:id/imageView1"));
		return element;
	}

	public List<WebElement> getSearchedProdName(WebDriver driver) {
		// TODO Auto-generated method stub
		List<WebElement> element=driver.findElements(By.id("com.shopclues:id/header_text"));
		return element;
	}
	public WebElement click_SelectedItem(WebDriver driver){
		WebElement element=driver.findElement(By.id("com.shopclues:id/header_text"));
		return element;
	}

	public WebElement click_ShoppingCart(WebDriver driver) {
		// TODO Auto-generated method stub
		WebElement element=driver.findElement(By.id("com.shopclues:id/cart"));
		return element;
	}

	public WebElement getShoppingCartDeleteButton(WebDriver driver) {
		// TODO Auto-generated method stub
		WebElement element=driver.findElement(By.id("com.shopclues:id/cancle_image"));
		return element;
	}

	public WebElement getProdID(WebDriver driver) {
		// TODO Auto-generated method stub
		WebElement element=driver.findElement(By.id("com.shopclues:id/item_name"));
		return element;
	}

	public WebElement getInsideCartValue(WebDriver driver) {
		// TODO Auto-generated method stub
		WebElement element=driver.findElement(By.id("com.shopclues:id/item_name"));
		return element;
	}

	public WebElement shopclues_HomeLogo(WebDriver driver) {
		// TODO Auto-generated method stub
		WebElement element=driver.findElement(By.id("com.shopclues:id/logo"));
		return element;
	}

	public WebElement click_DotsOption(WebDriver driver) {
		// TODO Auto-generated method stub
		WebElement element=null;
		try{
		element=driver.findElement(By.id("com.shopclues:id/action_more"));
		
		}catch(Exception e){e.getMessage();}
		return element;
	}

	public WebElement click_ToLogin(WebDriver driver) {
		// TODO Auto-generated method stub
		WebElement element=driver.findElement(By.id("com.shopclues:id/tvUserName"));
		return element;
	}

	public WebElement checkHomePageInstance(WebDriver driver) {
		// TODO Auto-generated method stub
		WebElement element=driver.findElement(By.id("com.shopclues:id/image"));
		return element;
	}

	public WebElement clickTo_Leaf(WebDriver driver) {
		
		WebElement element=driver.findElement(By.id("com.shopclues:id/action_more"));
		return element;
	}

	public List<WebElement> getNotificationInstance(WebDriver driver) {
		
		List<WebElement> element=driver.findElements(By.className("android.widget.TextView"));
		return element;
	}

	public WebElement notificationValue(WebDriver driver) {
		
		WebElement element=driver.findElement(By.id("com.shopclues:id/emptyBox"));
		return element;
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    productQuantity
	 * Usage:           WebElement productQuantity(WebDriver driver)
	 * Description:     Product quantity Field
	 * Author:          Automators
	 * Dated:           08May2015
	 * Notes:   
	 *************************************************************************************** **/
	public WebElement productQuantity(WebDriver driver)
	{
		WebElement element=driver.findElement(By.id("com.shopclues:id/qnty_select"));
		return element;
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    productQuantityValue
	 * Usage:           WebElement productQuantityValue(WebDriver driver)
	 * Description:     Product quantity to select
	 * Author:          Automators
	 * Dated:           08May2015
	 * Notes:   
	 *************************************************************************************** **/
	public WebElement productQuantityValue(WebDriver driver,String quanVal)
	{
		WebElement element=driver.findElement(By.name(quanVal));
		return element;
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    productSize
	 * Usage:           WebElement productSize(WebDriver driver)
	 * Description:     Product size field
	 * Author:          Automators
	 * Dated:           08May2015
	 * Notes:   
	 *************************************************************************************** **/
	public WebElement productSize(WebDriver driver)
	{
		WebElement element=driver.findElement(By.name("Size"));
		return element;
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    productBuyNowButton
	 * Usage:           WebElement productBuyNowButton(WebDriver driver)
	 * Description:     Buy now button
	 * Author:          Automators
	 * Dated:           08May2015
	 * Notes:   
	 *************************************************************************************** **/
	public WebElement productBuyNowButton(WebDriver driver)
	{
		WebElement element=driver.findElement(By.id("com.shopclues:id/buynow"));
		return element;
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    productAddToCartButton
	 * Usage:           WebElement productAddToCartButton(WebDriver driver)
	 * Description:     Add to cart button
	 * Author:          Automators
	 * Dated:           08May2015
	 * Notes:   
	 *************************************************************************************** **/
	public WebElement productAddToCartButton(WebDriver driver)
	{
		WebElement element=driver.findElement(By.id("com.shopclues:id/add_to_cart"));
		return element;
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    productCartTab
	 * Usage:           WebElement productCartTab(WebDriver driver)
	 * Description:     Product cart tab
	 * Author:          Automators
	 * Dated:           08May2015
	 * Notes:   
	 *************************************************************************************** **/		
	public WebElement productCartTab(WebDriver driver)
	{
		WebElement element=driver.findElement(By.id("com.shopclues:id/cart"));
		return element;
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    productCouponCode
	 * Usage:           WebElement productCouponCode(WebDriver driver)
	 * Description:     Coupon code text
	 * Author:          Automators
	 * Dated:           08May2015
	 * Notes:   
	 *************************************************************************************** **/
	public WebElement productCouponCode(WebDriver driver)
	{
		WebElement element=driver.findElement(By.id("com.shopclues:id/coupon_code"));
		return element;
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    productCurrentPrice
	 * Usage:           WebElement productCurrentPrice(WebDriver driver)
	 * Description:     Product price text
	 * Author:          Automators
	 * Dated:           08May2015
	 * Notes:   
	 *************************************************************************************** **/
	public WebElement productCurrentPrice(WebDriver driver)
	{
		WebElement element=driver.findElement(By.id("com.shopclues:id/current_price"));
		return element;
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    productInStockStatus
	 * Usage:           WebElement productInStockStatus(WebDriver driver)
	 * Description:     In stock text
	 * Author:          Automators
	 * Dated:           08May2015
	 * Notes:   
	 *************************************************************************************** **/
	public WebElement productInStockStatus(WebDriver driver)
	{
		WebElement element=driver.findElement(By.id("com.shopclues:id/in_stock"));
		return element;
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    productContinueShopping
	 * Usage:           WebElement productContinueShopping(WebDriver driver)
	 * Description:     Continue shopping link
	 * Author:          Automators
	 * Dated:           08May2015
	 * Notes:   
	 *************************************************************************************** **/
	public WebElement productContinueShopping(WebDriver driver)
	{
		WebElement element=driver.findElement(By.id("com.shopclues:id/continueshopping"));
		return element;
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    productPlaceOrder
	 * Usage:           WebElement productPlaceOrder(WebDriver driver)
	 * Description:     Place order button
	 * Author:          Automators
	 * Dated:           08May2015
	 * Notes:   
	 *************************************************************************************** **/
	public WebElement productPlaceOrder(WebDriver driver)
	{
		WebElement element=driver.findElement(By.id("com.shopclues:id/place_order"));
		return element;
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    productUserNameFieldToPlaceOrder
	 * Usage:           WebElement productUserNameFieldToPlaceOrder(WebDriver driver)
	 * Description:     Product name text
	 * Author:          Automators
	 * Dated:           08May2015
	 * Notes:   
	 *************************************************************************************** **/
	public WebElement productUserNameFieldToPlaceOrder(WebDriver driver)
	{
		WebElement element=driver.findElement(By.id("com.shopclues:id/nameColumn"));
		return element;
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    productContinueWithOutPasswordRadio
	 * Usage:           WebElement productContinueWithOutPasswordRadio(WebDriver driver)
	 * Description:     Continue WithOut Password Radio
	 * Author:          Automators
	 * Dated:           08May2015
	 * Notes:   
	 *************************************************************************************** **/
	public WebElement productContinueWithOutPasswordRadio(WebDriver driver)
	{
		WebElement element=driver.findElement(By.name("Continue without password"));
		return element;
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    productShopcluesAccountRadio
	 * Usage:           WebElement productShopcluesAccountRadio(WebDriver driver)
	 * Description:     I have a ShopClues account and password radio
	 * Author:          Automators
	 * Dated:           08May2015
	 * Notes:   
	 *************************************************************************************** **/
	public WebElement productShopcluesAccountRadio(WebDriver driver)
	{
		WebElement element=driver.findElement(By.name("I have a ShopClues account and password"));
		return element;
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    productSocialLoginRadio
	 * Usage:           WebElement productSocialLoginRadio(WebDriver driver)
	 * Description:     Social login radio
	 * Author:          Automators
	 * Dated:           08May2015
	 * Notes:   
	 *************************************************************************************** **/
	public WebElement productSocialLoginRadio(WebDriver driver)
	{
		WebElement element=driver.findElement(By.id("com.shopclues:id/socialMediaLogin"));
		return element;
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    productContinueToPlaceOrder
	 * Usage:           WebElement productContinueToPlaceOrder(WebDriver driver)
	 * Description:     Continue button to place order
	 * Author:          Automators
	 * Dated:           08May2015
	 * Notes:   
	 *************************************************************************************** **/
	public WebElement productContinueToPlaceOrder(WebDriver driver)
	{
		WebElement element=driver.findElement(By.id("com.shopclues:id/continueButton"));
		return element;
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    productPlaceOrderAddressFName
	 * Usage:           WebElement productPlaceOrderAddressFName(WebDriver driver)
	 * Description:     Shipping address first name field
	 * Author:          Automators
	 * Dated:           08May2015
	 * Notes:   
	 *************************************************************************************** **/
	public WebElement productPlaceOrderAddressFName(WebDriver driver)
	{
		WebElement element=driver.findElement(By.id("com.shopclues:id/firstname"));
		return element;
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    productPlaceOrderAddressLName
	 * Usage:           WebElement productPlaceOrderAddressLName(WebDriver driver)
	 * Description:     Shipping address last name field
	 * Author:          Automators
	 * Dated:           08May2015
	 * Notes:   
	 *************************************************************************************** **/
	public WebElement productPlaceOrderAddressLName(WebDriver driver)
	{
		WebElement element=driver.findElement(By.id("com.shopclues:id/lastname"));
		return element;
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    productPlaceOrderAddressZipCode
	 * Usage:           WebElement productPlaceOrderAddressZipCode(WebDriver driver)
	 * Description:     Shipping address zipcode field
	 * Author:          Automators
	 * Dated:           08May2015
	 * Notes:   
	 *************************************************************************************** **/
	public WebElement productPlaceOrderAddressZipCode(WebDriver driver)
	{
		WebElement element=driver.findElement(By.id("com.shopclues:id/s_zipcode"));
		return element;
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    productPlaceOrderAddressPhnNo
	 * Usage:           WebElement productPlaceOrderAddressPhnNo(WebDriver driver)
	 * Description:     Shipping address phone no field
	 * Author:          Automators
	 * Dated:           08May2015
	 * Notes:   
	 *************************************************************************************** **/
	public WebElement productPlaceOrderAddressPhnNo(WebDriver driver)
	{
		WebElement element=driver.findElement(By.id("com.shopclues:id/s_phone"));
		return element;
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    productPlaceOrderAddressAddress
	 * Usage:           WebElement productPlaceOrderAddressAddress(WebDriver driver)
	 * Description:     Shipping address address 1 field
	 * Author:          Automators
	 * Dated:           08May2015
	 * Notes:   
	 *************************************************************************************** **/
	public WebElement productPlaceOrderAddressAddress(WebDriver driver)
	{
		WebElement element=driver.findElement(By.id("com.shopclues:id/s_address"));
		return element;
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    productPlaceOrderAddressAddress2
	 * Usage:           WebElement productPlaceOrderAddressAddress2(WebDriver driver)
	 * Description:     Shipping address address 2 field
	 * Author:          Automators
	 * Dated:           08May2015
	 * Notes:   
	 *************************************************************************************** **/
	public WebElement productPlaceOrderAddressAddress2(WebDriver driver)
	{
		WebElement element=driver.findElement(By.id("com.shopclues:id/s_address_2"));
		return element;
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    productPlaceOrderAddressCity
	 * Usage:           WebElement productPlaceOrderAddressCity(WebDriver driver)
	 * Description:     Shipping address city field
	 * Author:          Automators
	 * Dated:           08May2015
	 * Notes:   
	 *************************************************************************************** **/
	public WebElement productPlaceOrderAddressCity(WebDriver driver)
	{
		WebElement element=driver.findElement(By.id("com.shopclues:id/s_city"));
		return element;
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    productPlaceOrderAddressStateDropDown
	 * Usage:           WebElement productPlaceOrderAddressStateDropDown(WebDriver driver)
	 * Description:     Shipping address state dropdown
	 * Author:          Automators
	 * Dated:           08May2015
	 * Notes:   
	 *************************************************************************************** **/
	public WebElement productPlaceOrderAddressStateDropDown(WebDriver driver)
	{
		WebElement element=driver.findElement(By.id("com.shopclues:id/s_state"));
		return element;
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    productPlaceOrderAddressState
	 * Usage:           List<WebElement> productPlaceOrderAddressState(WebDriver driver)
	 * Description:     Shipping address state elements list
	 * Author:          Automators
	 * Dated:           08May2015
	 * Notes:   
	 *************************************************************************************** **/
	public List<WebElement> productPlaceOrderAddressState(WebDriver driver)
	{
		List<WebElement> productOptions=driver.findElements(By.id("android:id/text1"));
		System.out.println("productOptions " + productOptions);
		return productOptions;
	
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    productPlaceOrderAddressStateBYName
	 * Usage:           WebElement productPlaceOrderAddressStateBYName(WebDriver driver,String stateName)
	 * Description:     Shipping address state by name
	 * Author:          Automators
	 * Dated:           08May2015
	 * Notes:   
	 *************************************************************************************** **/
	public WebElement productPlaceOrderAddressStateBYName(WebDriver driver,String stateName)
	{
		WebElement element=driver.findElement(By.name(stateName));
		return element;
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    productPlaceOrderAddressContinueButtonScreen2
	 * Usage:           WebElement productPlaceOrderAddressContinueButtonScreen2(WebDriver driver)
	 * Description:     Screen 2 continue button
	 * Author:          Automators
	 * Dated:           08May2015
	 * Notes:   
	 *************************************************************************************** **/
	public WebElement productPlaceOrderAddressContinueButtonScreen2(WebDriver driver)
	{
		WebElement element=driver.findElement(By.id("com.shopclues:id/continueButtonforScreen2"));
		return element;
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    productPaymentMethodGroupradio
	 * Usage:           WebElement productPaymentMethodGroupradio(WebDriver driver)
	 * Description:     Payment method group radio
	 * Author:          Automators
	 * Dated:           08May2015
	 * Notes:   
	 *************************************************************************************** **/
	public WebElement productPaymentMethodGroupradio(WebDriver driver)
	{
		WebElement element=driver.findElement(By.id("com.shopclues:id/radioGroup"));
		return element;
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    productPaymentMethodCreditCardradio
	 * Usage:           WebElement productPaymentMethodCreditCardradio(WebDriver driver)
	 * Description:     Payment method credit card radio
	 * Author:          Automators
	 * Dated:           08May2015
	 * Notes:   
	 *************************************************************************************** **/
	public WebElement productPaymentMethodCreditCardradio(WebDriver driver)
	{
		WebElement element=driver.findElement(By.name("Credit Card"));
		return element;
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    productPaymentMethodDebitCardradio
	 * Usage:           WebElement productPaymentMethodDebitCardradio(WebDriver driver)
	 * Description:     Payment method debit card radio
	 * Author:          Automators
	 * Dated:           08May2015
	 * Notes:   
	 *************************************************************************************** **/
	public WebElement productPaymentMethodDebitCardradio(WebDriver driver)
	{
		WebElement element=driver.findElement(By.name("Debit Card"));
		return element;
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    productPaymentMethodCashCardOrWalletradio
	 * Usage:           WebElement productPaymentMethodCashCardOrWalletradio(WebDriver driver)
	 * Description:     Payment method Cash Card Or Wallet radio
	 * Author:          Automators
	 * Dated:           08May2015
	 * Notes:   
	 *************************************************************************************** **/
	public WebElement productPaymentMethodCashCardOrWalletradio(WebDriver driver)
	{
		WebElement element=driver.findElement(By.name("Cash Cards/Wallets"));
		return element;
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    productPaymentMethodNetBankingradio
	 * Usage:           WebElement productPaymentMethodNetBankingradio(WebDriver driver)
	 * Description:     Payment method internet banking radio
	 * Author:          Automators
	 * Dated:           08May2015
	 * Notes:   
	 *************************************************************************************** **/
	public WebElement productPaymentMethodNetBankingradio(WebDriver driver)
	{
		WebElement element=driver.findElement(By.name("Net Banking"));
		return element;
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    productPaymentMethodCODradio
	 * Usage:           WebElement productPaymentMethodCODradio(WebDriver driver)
	 * Description:     Payment method COD radio
	 * Author:          Automators
	 * Dated:           08May2015
	 * Notes:   
	 *************************************************************************************** **/
	public WebElement productPaymentMethodCODradio(WebDriver driver)
	{
		WebElement element=driver.findElement(By.name("Cash on Delivery"));
		return element;
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    productPaymentMethodCardType
	 * Usage:           WebElement productPaymentMethodCardType(WebDriver driver)
	 * Description:     Card type field
	 * Author:          Automators
	 * Dated:           08May2015
	 * Notes:   
	 *************************************************************************************** **/
	public WebElement productPaymentMethodCardType(WebDriver driver)
	{
		WebElement element=driver.findElement(By.id("com.shopclues:id/spinnerplace"));
		return element;
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    productPaymentMethodCardTypeAmerican
	 * Usage:           WebElement productPaymentMethodCardTypeAmerican(WebDriver driver)
	 * Description:     Card type as american
	 * Author:          Automators
	 * Dated:           08May2015
	 * Notes:   
	 *************************************************************************************** **/
	public WebElement productPaymentMethodCardTypeAmerican(WebDriver driver)
	{
		WebElement element=driver.findElement(By.name("American Express"));
		return element;
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    productPaymentMethodCardTypeAmericanEZE
	 * Usage:           WebElement productPaymentMethodCardTypeAmericanEZE(WebDriver driver)
	 * Description:     Card type as american EZE
	 * Author:          Automators
	 * Dated:           08May2015
	 * Notes:   
	 *************************************************************************************** **/
	public WebElement productPaymentMethodCardTypeAmericanEZE(WebDriver driver)
	{
		WebElement element=driver.findElement(By.name("American Express ezeClick"));
		return element;
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    productPaymentMethodCardTypeDiners
	 * Usage:           WebElement productPaymentMethodCardTypeDiners(WebDriver driver)
	 * Description:     Card type as dinners
	 * Author:          Automators
	 * Dated:           08May2015
	 * Notes:   
	 *************************************************************************************** **/
	public WebElement productPaymentMethodCardTypeDiners(WebDriver driver)
	{
		WebElement element=driver.findElement(By.name("Diners Club Card"));
		return element;
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    productPaymentMethodCardTypeJCB
	 * Usage:           WebElement productPaymentMethodCardTypeJCB(WebDriver driver)
	 * Description:     Card type as JCB
	 * Author:          Automators
	 * Dated:           08May2015
	 * Notes:   
	 *************************************************************************************** **/
	public WebElement productPaymentMethodCardTypeJCB(WebDriver driver)
	{
		WebElement element=driver.findElement(By.name("JCB card"));
		return element;
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    productPaymentMethodCardTypeMaster
	 * Usage:           WebElement productPaymentMethodCardTypeMaster(WebDriver driver)
	 * Description:     Card type as master
	 * Author:          Automators
	 * Dated:           08May2015
	 * Notes:   
	 *************************************************************************************** **/
	public WebElement productPaymentMethodCardTypeMaster(WebDriver driver)
	{
		WebElement element=driver.findElement(By.name("Mastercard Credit Card"));
		return element;
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    productPaymentMethodCardTypeVISA
	 * Usage:           WebElement productPaymentMethodCardTypeVISA(WebDriver driver)
	 * Description:     Card type as Visa
	 * Author:          Automators
	 * Dated:           08May2015
	 * Notes:   
	 *************************************************************************************** **/
	public WebElement productPaymentMethodCardTypeVISA(WebDriver driver)
	{
		WebElement element=driver.findElement(By.name("VISA Credit Card"));
		return element;
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    productPaymentMethodApplyCoupon
	 * Usage:           WebElement productPaymentMethodApplyCoupon(WebDriver driver)
	 * Description:     Apply coupon link
	 * Author:          Automators
	 * Dated:           08May2015
	 * Notes:   
	 *************************************************************************************** **/
	public WebElement productPaymentMethodApplyCoupon(WebDriver driver)
	{
		WebElement element=driver.findElement(By.id("com.shopclues:id/applyButton"));
		return element;
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    productPaymentMethodProductName
	 * Usage:           WebElement productPaymentMethodProductName(WebDriver driver)
	 * Description:     Product name on product page
	 * Author:          Automators
	 * Dated:           08May2015
	 * Notes:   
	 *************************************************************************************** **/
	public WebElement productPaymentMethodProductName(WebDriver driver)
	{
		WebElement element=driver.findElement(By.id("com.shopclues:id/ProductName"));
		return element;
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    productPaymentMethodProductPrice
	 * Usage:           WebElement productPaymentMethodProductPrice(WebDriver driver)
	 * Description:     Product price on product page
	 * Author:          Automators
	 * Dated:           08May2015
	 * Notes:   
	 *************************************************************************************** **/
	public WebElement productPaymentMethodProductPrice(WebDriver driver)
	{
		WebElement element=driver.findElement(By.id("com.shopclues:id/SumTotal"));
		return element;
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    productPaymentMethodRemoveCoupon
	 * Usage:           WebElement productPaymentMethodRemoveCoupon(WebDriver driver)
	 * Description:     Remove coupon link
	 * Author:          Automators
	 * Dated:           08May2015
	 * Notes:   
	 *************************************************************************************** **/
	public WebElement productPaymentMethodRemoveCoupon(WebDriver driver)
	{
		WebElement element=driver.findElement(By.id("com.shopclues:id/coupon_cod_remove"));
		return element;
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    productPaymentMethodFinalSubTotal
	 * Usage:           WebElement productPaymentMethodFinalSubTotal(WebDriver driver)
	 * Description:     Product price after coupon apply
	 * Author:          Automators
	 * Dated:           08May2015
	 * Notes:   
	 *************************************************************************************** **/
	public WebElement productPaymentMethodFinalSubTotal(WebDriver driver)
	{
		WebElement element=driver.findElement(By.id("com.shopclues:id/finalsubtotal"));
		return element;
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    productPaymentMethodCODCouponError
	 * Usage:           WebElement productPaymentMethodCODCouponError(WebDriver driver)
	 * Description:     COD coupon error
	 * Author:          Automators
	 * Dated:           08May2015
	 * Notes:   
	 *************************************************************************************** **/
	public WebElement productPaymentMethodCODCouponError(WebDriver driver)
	{
		WebElement element=driver.findElement(By.id("com.shopclues:id/coupon_tandc_msg"));
		return element;
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    viewProfileLink
	 * Usage:           WebElement viewProfileLink(WebDriver driver)
	 * Description:     View profile link
	 * Author:          Automators
	 * Dated:           08May2015
	 * Notes:   
	 *************************************************************************************** **/

	//=============12may===========
	
	public WebElement viewProfileLink(WebDriver driver)
	{
		WebElement element=driver.findElement(By.id("com.shopclues:id/tvViewProfile"));
		return element;
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    myProfileUserEmail
	 * Usage:           WebElement myProfileUserEmail(WebDriver driver)
	 * Description:     User email on my profile page
	 * Author:          Automators
	 * Dated:           08May2015
	 * Notes:   
	 *************************************************************************************** **/
	public WebElement myProfileUserEmail(WebDriver driver)
	{
		WebElement element=driver.findElement(By.id("com.shopclues:id/email"));
		return element;
	}	
	public WebElement cluesBucksApplyLink(WebDriver driver)
	{
		WebElement element=driver.findElement(By.id("com.shopclues:id/applyButton3"));
		return element;
	}
	
	public WebElement cluesBucksInUse(WebDriver driver)
	{
		WebElement element=driver.findElement(By.id("com.shopclues:id/cluesBuckInUse"));
		return element;
	}
	
	public WebElement cluesBucksEditBox(WebDriver driver)
	{
		WebElement element=driver.findElement(By.id("com.shopclues:id/clueCode"));
		return element;
	}
	
	public List<WebElement> product_SelectStatePopup(WebDriver driver)
	{
		List<WebElement> quantityPopup=driver.findElements(By.id("android:id/text1"));
		return quantityPopup;
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    product_GiftCertificateExpand
	 * Usage:           WebElement product_GiftCertificateExpand(WebDriver driver)
	 * Description:     Clues bucks used details
	 * Author:          KAutomators
	 * Dated:           13May2015
	 * Notes:   
	 *************************************************************************************** **/
	
	public WebElement product_GiftCertificateExpand(WebDriver driver)
	{
		WebElement CreateAccount=driver.findElement(By.id("com.shopclues:id/gift_expand"));
		return CreateAccount;
	}
	public WebElement product_GiftCertificateCode(WebDriver driver)
	{
		WebElement CreateAccount=driver.findElement(By.id("com.shopclues:id/GiftCertificateCode"));
		return CreateAccount;
	}
	
	public WebElement product_GiftCertificateCodeApply(WebDriver driver)
	{
		WebElement CreateAccount=driver.findElement(By.id("com.shopclues:id/applyButton2"));
		return CreateAccount;
	}
	
	public WebElement productPlaceOrderAddressContinueButtonOnLoginScreen2(WebDriver driver)
	{
		WebElement element=driver.findElement(By.id("com.shopclues:id/continueButtonforScreen2"));
		return element;
	}
	
	public WebElement product_ApplyAllCoupon(WebDriver driver)
	{
		WebElement CreateAccount=driver.findElement(By.id("com.shopclues:id/apply_all"));
		return CreateAccount;
	}
	
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
	
	public WebElement product_Favourite(WebDriver driver)
	{
		WebElement FavouriteButton=driver.findElement(By.id("com.shopclues:id/imageView_save"));
		return FavouriteButton;
	}
	

	public WebElement clickT_SignOut(WebDriver driver) {
		WebElement element =driver.findElement(By.id("com.shopclues:id/tvSignOut"));
		return element;
	}

	public WebElement clickTo_Uname(WebDriver driver) {
		WebElement element =driver.findElement(By.id("com.shopclues:id/tvUserName"));
		return element;
	}
	/** ***************************************************************************************
	 * Keyword-Name:    product_ApplyCoupon
	 * Usage:           WebElement product_ApplyCoupon(WebDriver driver)
	 * Description:     Clues bucks used details
	 * Author:          KAutomators
	 * Dated:           13May2015
	 * Notes:   
	 *************************************************************************************** **/
	
	public WebElement product_ApplyCoupon(WebDriver driver)
	{
		WebElement CreateAccount=driver.findElement(By.id("com.shopclues:id/applyButton"));
		return CreateAccount;
	}

	
	public WebElement clickLeafOption(WebDriver driver) {
		WebElement element=driver.findElement(By.id("com.shopclues:id/action_more"));
		return element;
	}

	public WebElement clickLoginSymbol(WebDriver driver) {
		WebElement element=driver.findElement(By.id("com.shopclues:id/tvUserName"));
		return element;
	}

	public WebElement clickTOSignINLogo(WebDriver driver) {
		WebElement element=driver.findElement(By.id("com.shopclues:id/product_name"));
		return element;
	}

	public WebElement clickToMyOrderBanner(WebDriver driver) {
		WebElement element=driver.findElement(By.id("com.shopclues:id/header_val"));
		return element;
	}

	public WebElement getEditBoxValue(WebDriver driver) {
		WebElement element=driver.findElement(By.id("com.shopclues:id/search_edit"));
		return element;
	}

	public WebElement getproductNameValue(WebDriver driver) {
		WebElement element=driver.findElement(By.id("com.shopclues:id/name"));
		return element;
	}
	public WebElement orderId(WebDriver driver) {
		WebElement element=driver.findElement(By.id("com.shopclues:id/tv1"));
		return element;
	}
	
	public WebElement orderDate(WebDriver driver) {
		WebElement element=driver.findElement(By.id("com.shopclues:id/tv2"));
		return element;
	}
	public WebElement amountPaid(WebDriver driver) {
		WebElement element=driver.findElement(By.id("com.shopclues:id/tv3"));
		return element;
	}
	public WebElement status(WebDriver driver) {
		WebElement element=driver.findElement(By.id("com.shopclues:id/tv5"));
		return element;
	}
	
	public WebElement o_Number(WebDriver driver) {
		WebElement element=driver.findElement(By.id("com.shopclues:id/order_no"));
		return element;
	}
	public WebElement o_Date(WebDriver driver) {
		WebElement element=driver.findElement(By.id("com.shopclues:id/order_date"));
		return element;
	}
	public WebElement amt_paid(WebDriver driver) {
		WebElement element=driver.findElement(By.id("com.shopclues:id/amnt_paid"));
		return element;
	}
	public WebElement o_Status(WebDriver driver) {
		WebElement element=driver.findElement(By.id("com.shopclues:id/status"));
		return element;
	}

	public WebElement clickToArrowButton(WebDriver driver) {
		WebElement element=driver.findElement(By.id("com.shopclues:id/arrowImage"));
		return element;
	}

	public WebElement getOrderNumberValue(WebDriver driver) {
		WebElement element=driver.findElement(By.id("com.shopclues:id/orderNo"));
		return element;
	}

	public WebElement clickOrderDate(WebDriver driver) {
		WebElement element=driver.findElement(By.id("com.shopclues:id/orderDate"));
		return element;
	}

	public WebElement getActualProdValue(WebDriver driver) {
		WebElement element=driver.findElement(By.id("com.shopclues:id/productName111"));
		return element;
	}

	public WebElement getSellingpriceValue(WebDriver driver) {
		WebElement element=driver.findElement(By.id("com.shopclues:id/sellingPrice"));
		return element;
	}

	public WebElement getProdQty(WebDriver driver) {
		WebElement element=driver.findElement(By.id("com.shopclues:id/qty"));
		return element;
	}

	public WebElement clickSubTotal(WebDriver driver) {
		WebElement element=driver.findElement(By.id("com.shopclues:id/sub_total_tv"));
		return element;
	}

	public WebElement getContactValue(WebDriver driver) {
		WebElement element=driver.findElement(By.id("com.shopclues:id/email_tv"));
		return element;
	}


	public WebElement clickToFirstnameShipping(WebDriver driver) {
	WebElement element=driver.findElement(By.id("com.shopclues:id/first_name_ship"));
	return element;
	}

	public WebElement clickToLastnameShipping(WebDriver driver) {
		WebElement element=driver.findElement(By.id("com.shopclues:id/last_name_ship"));
		return element;
	}

	public WebElement clickToAddressShipping(WebDriver driver) {
		WebElement element=driver.findElement(By.id("com.shopclues:id/address1_ship"));
		return element;
	}

	public WebElement clickToCityShipping(WebDriver driver) {
		WebElement element=driver.findElement(By.id("com.shopclues:id/city_ship"));
		return element;
	}

	public WebElement clickToStateShipping(WebDriver driver) {
		WebElement element=driver.findElement(By.id("com.shopclues:id/state_ship"));
		return element;
	}

	public WebElement clickToPinShipping(WebDriver driver) {
		WebElement element=driver.findElement(By.id("com.shopclues:id/pincode_ship"));
		return element;
	}

	public WebElement clickToMobileShipping(WebDriver driver) {
		WebElement element=driver.findElement(By.id("com.shopclues:id/mobileNo_ship"));
		return element;
	}
	public String getListViewInstance(WebDriver driver){
		WebElement al=driver.findElement(By.className("android.widget.RelativeLayout"));
		return al.getAttribute("class");
		
	}
	public String getGridViewInstance(WebDriver driver){
		WebElement al=driver.findElement(By.className("android.widget.LinearLayout"));
		return al.getAttribute("class");
	}

	public WebElement getGridView(WebDriver driver){
		WebElement al=driver.findElement(By.className("android.widget.LinearLayout"));
		return al;
	}
	public WebElement getFavouritesOption(WebDriver driver) {
		WebElement element=driver.findElement(By.id("com.shopclues:id/action_saved_items_selected"));
		return element;								
	}
	
	public WebElement product_FavouriteLink(WebDriver driver)
	{
		WebElement FavouriteLink=driver.findElement(By.id("com.shopclues:id/action_saved_items"));
		return FavouriteLink;
	}

	public WebElement clickProductFrame(WebDriver driver) {
		WebElement elements=driver.findElement(By.className("android.widget.RelativeLayout"));
		return elements;
	}

	public WebElement clickToOverLay(WebDriver driver) {
		WebElement elements=driver.findElement(By.id("com.shopclues:id/menu_overlay"));
		return elements;							
	}

	public WebElement clickToFavButton(WebDriver driver) {
		WebElement elements=driver.findElement(By.id("com.shopclues:id/save_direct"));
		return elements;							  
	}
	public WebElement getFavouriteButtonStatus(WebDriver driver){
		WebElement element=driver.findElement(By.className("android.widget.TextView"));
		return element;
	}

	public WebElement clickTo_FavLogo(WebDriver driver) {
		WebElement element=driver.findElement(By.id("com.shopclues:id/tvBrandName"));
		return element;
	}

	public WebElement getProdNameFavouritepage(WebDriver driver) {
		WebElement element=driver.findElement(By.id("com.shopclues:id/header_text"));
		return element;
	}

	public WebElement clickToMesssage(WebDriver driver) {
		WebElement element=driver.findElement(By.id("com.shopclues:id/save_for_later_text"));
		return element;
	}

	public WebElement clickToGridIcon(WebDriver driver) {
		WebElement element=driver.findElement(By.id("com.shopclues:id/ivGridListIcon"));
		return element;
	}
	/** ***************************************************************************************
	 * Keyword-Name:    myOrder
	 * Usage:           WebElement myOrder(WebDriver driver)
	 * Description:     My Order tab under my account
	 * Author:          Automators
	 * Dated:           01June2015
	 * Notes:   
	 *************************************************************************************** **/
	
	public WebElement myOrder(WebDriver driver)
	{
		WebElement element=driver.findElement(By.id("com.shopclues:id/tvOrderHistory"));
		return element;
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    myOrder_ProductOrderArrowImage
	 * Usage:           WebElement myOrder_ProductOrderArrowImage(WebDriver driver)
	 * Description:     Products order arrow image under my order page
	 * Author:          Automators
	 * Dated:           01June2015
	 * Notes:   
	 *************************************************************************************** **/
	
	public WebElement myOrder_ProductOrderArrowImage(WebDriver driver)
	{
		WebElement element=driver.findElement(By.id("com.shopclues:id/arrowImage"));
		return element;
	}
	/** ***************************************************************************************
	 * Keyword-Name:    myOrder_DetailsButton
	 * Usage:           WebElement myOrder_DetailsButton(WebDriver driver)
	 * Description:     Details button under my order
	 * Author:          Automators
	 * Dated:           01June2015
	 * Notes:   
	 *************************************************************************************** **/
	
	public WebElement myOrder_DetailsButton(WebDriver driver)
	{
		WebElement element=driver.findElement(By.id("com.shopclues:id/buttonDetails"));
		return element;
	}
	/** ***************************************************************************************
	 * Keyword-Name:    detailsPage_OrderStatus
	 * Usage:           WebElement detailsPage_OrderStatus(WebDriver driver)
	 * Description:     Order Status under details page
	 * Author:          Automators
	 * Dated:           01June2015
	 * Notes:   
	 *************************************************************************************** **/
	
	public WebElement detailsPage_OrderStatus(WebDriver driver)
	{
		WebElement element=driver.findElement(By.id("com.shopclues:id/status"));
		return element;								 
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    detailsPage_CancelOrderButton
	 * Usage:           WebElement detailsPage_CancelOrderButton(WebDriver driver)
	 * Description:     Cancel order button under details page
	 * Author:          Automators
	 * Dated:           01June2015
	 * Notes:   
	 *************************************************************************************** **/
	
	public WebElement detailsPage_CancelOrderButton(WebDriver driver)
	{
		WebElement element=driver.findElement(By.id("com.shopclues:id/cancelButton"));
		return element;
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    detailsPage_ReasonSelect
	 * Usage:           WebElement detailsPage_ReasonSelect(WebDriver driver)
	 * Description:     Reason select under details page
	 * Author:          Automators
	 * Dated:           01June2015
	 * Notes:   
	 *************************************************************************************** **/
	
	public WebElement detailsPage_ReasonSelect(WebDriver driver)
	{
		WebElement element=driver.findElement(By.id("com.shopclues:id/reason_select"));
		return element;
	}
	/** ***************************************************************************************
	 * Keyword-Name:    detailsPage_ReasonValue
	 * Usage:           WebElement detailsPage_ReasonValue(WebDriver driver,String reason)
	 * Description:     Reason value under details page
	 * Author:          Automators
	 * Dated:           01June2015
	 * Notes:   
	 *************************************************************************************** **/
	
	public WebElement detailsPage_ReasonValue(WebDriver driver,String reason)
	{
		WebElement element=driver.findElement(By.name(reason));
		return element;
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    detailsPage_ReasonSubmit
	 * Usage:           WebElement detailsPage_ReasonSubmit(WebDriver driver)
	 * Description:     Reason submit under details page
	 * Author:          Automators
	 * Dated:           01June2015
	 * Notes:   
	 *************************************************************************************** **/
	
	public WebElement detailsPage_ReasonSubmit(WebDriver driver)
	{
		WebElement element=driver.findElement(By.id("com.shopclues:id/submitAskReson"));
		return element;
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    myOrder_ProductName
	 * Usage:           WebElement myOrder_ProductName(WebDriver driver)
	 * Description:     Products name under my order page
	 * Author:          Automators
	 * Dated:           01June2015
	 * Notes:   
	 *************************************************************************************** **/
	
	public WebElement myOrder_ProductName(WebDriver driver)
	{
		WebElement element=driver.findElement(By.id("com.shopclues:id/name"));
		return element;
	}
	
	
	/** ***************************************************************************************
	 * Keyword-Name:    myOrder_ProductOrderPrice
	 * Usage:           WebElement myOrder_ProductOrderPrice(WebDriver driver)
	 * Description:     Products order price under my order page
	 * Author:          Automators
	 * Dated:           01June2015
	 * Notes:   
	 *************************************************************************************** **/
	
	public WebElement myOrder_ProductOrderPrice(WebDriver driver)
	{
		WebElement element=driver.findElement(By.id("com.shopclues:id/amnt_paid"));
		return element;
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    myOrder_ReorderButton
	 * Usage:           WebElement myOrder_ReorderButton(WebDriver driver)
	 * Description:     Reorder button under my order
	 * Author:          Automators
	 * Dated:           01June2015
	 * Notes:   
	 *************************************************************************************** **/
	
	public WebElement myOrder_ReorderButton(WebDriver driver)
	{
		WebElement element=driver.findElement(By.id("com.shopclues:id/buttonReorder"));
		return element;
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    placeOrder_ProductName
	 * Usage:           WebElement placeOrder_ProductName(WebDriver driver)
	 * Description:     Product name under place order page
	 * Author:          Automators
	 * Dated:           01June2015
	 * Notes:   
	 *************************************************************************************** **/
	
	public WebElement placeOrder_ProductName(WebDriver driver)
	{
		WebElement element=driver.findElement(By.id("com.shopclues:id/item_name"));
		return element;
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    placeOrder_ProductPrice
	 * Usage:           WebElement placeOrder_ProductPrice(WebDriver driver)
	 * Description:     Product price under place order page
	 * Author:          Automators
	 * Dated:           01June2015
	 * Notes:   
	 *************************************************************************************** **/
	
	public WebElement placeOrder_ProductPrice(WebDriver driver)
	{
		WebElement element=driver.findElement(By.id("com.shopclues:id/selling_price"));
		return element;
	}
	
	public WebElement getAddToCart(WebDriver driver) {
		WebElement element=driver.findElement(By.id("com.shopclues:id/add_cart_direct"));
		return element;
	}
	
	public WebElement cartValue(WebDriver driver) {
			WebElement element=driver.findElement(By.id("com.shopclues:id/nom_product"));
			return element;
	}
	 
	public WebElement getProdPrice(WebDriver driver) {
			WebElement element=driver.findElement(By.id("com.shopclues:id/selling_price"));
			return element;								 
	}
	
	public WebElement clickToGridOption(WebDriver driver) {
		WebElement element=driver.findElement(By.id("com.shopclues:id/ivGridListIcon"));
		return element;
	}
	
	public WebElement clickToGridView(WebDriver driver) {
		WebElement element=driver.findElement(By.id("com.shopclues:id/mainLayout"));
		return element;
	}
	public WebElement clickToGrandTotal(WebDriver driver) {
        WebElement element=driver.findElement(By.id("com.shopclues:id/total_value"));
        return element;
    }

    public WebElement clickToContinue(WebDriver driver) {
        WebElement element=driver.findElement(By.id("com.shopclues:id/continueButtonForScreen3"));
        return element;
    }

	public WebElement clickToPaymentMethod(WebDriver driver) {
		WebElement element=driver.findElement(By.id("com.shopclues:id/card"));
		return element;
	}

	public WebElement clickToPlaceorder(WebDriver driver) {
		WebElement element=driver.findElement(By.id("com.shopclues:id/placeOrderButton"));
		return element;
	}

	public WebElement clickVerifyMessage(WebDriver driver) {
		WebElement element=driver.findElement(By.id("com.shopclues:id/message"));
		return element;
	}

	public WebElement clickToOrderSummary(WebDriver driver) {
		WebElement element=driver.findElement(By.id("com.shopclues:id/text_header"));
		return element;
	}

	public WebElement clickToOrderID(WebDriver driver) {
		WebElement element=driver.findElement(By.id("com.shopclues:id/order_id"));
		return element;
	}

	public WebElement clickToProductQty(WebDriver driver) {
		WebElement element=driver.findElement(By.id("com.shopclues:id/spinner_item"));
		return element;
	}

	public WebElement clickToDropDownField(WebDriver driver) {
		WebElement element=driver.findElement(By.id("com.shopclues:id/select_reason"));
		return element;
	}

	public List<WebElement> clickToMultipleDropDown(WebDriver driver) {
		List<WebElement> element=driver.findElements(By.className("android.widget.CheckedTextView"));
		return element;
	}

	public WebElement clickToSubreasonOption(WebDriver driver) {
		WebElement element=driver.findElement(By.id("com.shopclues:id/select_subreason"));
		return element;
	}

	public List<WebElement> clickToSubTask(WebDriver driver) {
		List<WebElement> element=driver.findElements(By.className("android.widget.CheckedTextView"));
		return element;
	}

	public WebElement clickToUploadImage(WebDriver driver) {
		WebElement element=driver.findElement(By.id("com.shopclues:id/upload_image"));
		return element;
	}

	public List<WebElement> clickToImgWiged(WebDriver driver) {
		List<WebElement> element=driver.findElements(By.className("android.widget.ImageView"));
		return element;
	}

	public WebElement clickToCheckBox(WebDriver driver) {
		WebElement element=driver.findElement(By.id("com.shopclues:id/imgQueueMultiSelected"));
		return element;
	}

	public WebElement clickToOkButton(WebDriver driver) {
		WebElement element=driver.findElement(By.id("com.shopclues:id/btnGalleryOk"));
		return element;
	}

	public WebElement clickImgName(WebDriver driver) {
		WebElement element=driver.findElement(By.id("com.shopclues:id/image_name"));
		return element;
	}

	public WebElement clickCommentBox(WebDriver driver) {
		WebElement element=driver.findElement(By.id("com.shopclues:id/comments"));
		return element;
	}

	public WebElement clickSubmit(WebDriver driver) {
		WebElement element=driver.findElement(By.id("com.shopclues:id/return_button"));
		return element;
	}
}

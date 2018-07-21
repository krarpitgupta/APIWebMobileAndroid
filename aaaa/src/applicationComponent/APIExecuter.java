/*
 ***************************************************************************************
 * Script-Name:          src/ApplicationComponent/APIExecuter.java
 * Description:          Application component file, which consists of various application 
 * components to define end-to-end flow of ShopClues APIs
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
import action.APIAction;

/*
 ***************************************************************************************
 * Class-Name:    public class APIExecuter
 * Description:   Class defined to handle various reusable actions for ShopClues APIs
 * where
 *
 * Author:        Automators
 * Dated:         09Apr2015
 * Notes:  
 *
 ***************************************************************************************
 */
public class APIExecuter implements ApplicationComponent
{
	
	WebDriver driver = null;
	HashMap<String, String> testData = new HashMap<String, String>();
	APIAction action = new APIAction(DriverSession.getLastExecutionDriver());
	
	public void loginAndAddToCart() throws Exception
	{
		try{
			
		action.loginAPI();
		
	}catch(Exception ee){
		throw new Exception("Exception raised: Invalid username/ password.");
	}
	}
	
	public void selectAddress() throws Exception{
		try{
		action.verifyCheckOutAPISelectAddress();
		}catch(Exception e){
			throw new Exception("Exception raised: CheckOut Step_2| Address not selected.");
		}
	}
	
	public void placeOrder() throws Exception{
		try{
			action.verifyCheckOutAPIPlaceOrder();
		}catch(Exception e){
			throw new Exception("Exception raised: CheckOut Step_5| Order not placed.");
		}
	}
	public void orderSummary() throws Exception{
		try{
			action.verifyCheckOutAPIOrderSummary();
		}catch(Exception e){
			throw new Exception("Exception raised: CheckOut Step_6| Order not summarized.");
		}
	}
	public void reviewOrder() throws Exception{
		try{
		action.verifyCheckOutAPIReviewOrder();
		}catch(Exception e){
			throw new Exception("Exception raised: CheckOut Step_4| Order not got reviewed.");
		}
	}
	
	public void orderHistory()
	{
		try
		{
			action.checkOrderHistory();

		}
		catch(Exception e)
		{
			
		}
	}
	
	public void orderListing()
	{
		try
		{
			action.checkOrderListing();

		}
		catch(Exception e)
		{
			
		}
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    postAddVariantProductRawJason
	 * Usage:           void postAddVariantProductRawJason()
	 * Description:     Add Variant Product 
	 * Author:          KAutomators
	 * Dated:           20Apr2015
	 * Notes:   
	 * 
	 *************************************************************************************** **/
	
	public void addVariantProduct()
	{
		try
		{
			action.addVariantProduct();

		}
		catch(Exception e)
		{
			
		}
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    postUpdateCartProductRawJason
	 * Usage:           void postUpdateCartProductRawJason()
	 * Description:     Update Product Cart 
	 * Author:          KAutomators
	 * Dated:           20Apr2015
	 * Notes:   
	 * 
	 *************************************************************************************** **/
	
	
	public void paymentMethodAsCOD() throws Exception{
		try{
		action.verifyCheckOutAPIPaymentMethod();
		}catch(Exception e){
			throw new Exception("Exception raised: CheckOut Step_3| Payment mode as COD not selected.");
		}
	}
	
	
	
	public void updateProductCart()
	{
		try
		{
			action.updateCart();

		}
		catch(Exception e)
		{
			
		}
	}
	

	/** ***************************************************************************************
	 * Keyword-Name:    putChangeProfileRawJason
	 * Usage:           void putChangeProfileRawJason()
	 * Description:     Update Profile
	 * Author:          KAutomators
	 * Dated:           20Apr2015
	 * Notes:   
	 * 
	 *************************************************************************************** **/
	
	public void updateProfile()
	{
		try
		{
			action.verifyUpdateProfile();

		}
		catch(Exception e)
		{
			
		}
	}
	
	public void giftCertificate()
	{
		try
		{
			action.verifyGiftCert();

		}
		catch(Exception e)
		{
			
		}
	}
	
	
	
	/** ***************************************************************************************
	 * Keyword-Name:    postGiftCertRawJason
	 * Usage:           void postGiftCertRawJason()
	 * Description:     Add Gift Certificate
	 * Author:          KAutomators
	 * Dated:           20Apr2015
	 * Notes:   
	 * 
	 *************************************************************************************** **/
	
	public void viewCart() throws Exception
	{
		try 
		{
			action.verifyGetCart();
		}

		catch (Exception ee) 
		{
			throw new Exception("Exception raised: CheckOut ViewAPI| Cart not available for viewing.");
		}
	}
	/** ***************************************************************************************
	 * Keyword-Name:    signUP
	 * Usage:           void signUP()
	 * Description:     Sign up
	 * Author:          Automators
	 * Dated:           16Apr2015
	 * Notes:   
	 * 
	 *************************************************************************************** **/
	public void signUP(){
		try{
		action.verifyCheckOutAPISignUP();
		}catch(Exception e){
			
		}
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    askaMerchantForm
	 * Usage:           void askaMerchantForm()
	 * Description:     Ask a merchant Form
	 * Author:          Automators
	 * Dated:           16Apr2015
	 * Notes:   
	 * 
	 *************************************************************************************** **/
	public void askaMerchantForm(){
		try{
		action.verifyAskaMerchantForm();
		}catch(Exception e){
			
		}
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    merchantUserQuery
	 * Usage:           void merchantUserQuery()
	 * Description:     Merchant user query
	 * Author:          Automators
	 * Dated:           16Apr2015
	 * Notes:   
	 * 
	 *************************************************************************************** **/
	public void merchantUserQuery(){
		try{
		action.verifyMerchantUserQuery();
		}catch(Exception e){
			
		}
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    merchantResponse
	 * Usage:           void merchantResponse()
	 * Description:     Merchant Response
	 * Author:          Automators
	 * Dated:           16Apr2015
	 * Notes:   
	 * 
	 *************************************************************************************** **/
	public void merchantResponse(){
		try{
		action.verifyMerchantResponse();
		}catch(Exception e){
			
		}
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    cluesBuck
	 * Usage:           void cluesBuck()
	 * Description:     Clues Buck
	 * Author:          Automators
	 * Dated:           16Apr2015
	 * Notes:   
	 * 
	 *************************************************************************************** **/
	public void cluesBuck(){
		try{
		action.verifyCluesBucks();
		}catch(Exception e){
			
		}
	}
	

	/** ***************************************************************************************
	 * Keyword-Name:    merchantConnect
	 * Usage:           void merchantConnect()
	 * Description:     Merchant connect
	 * Author:          Automators
	 * Dated:           16Apr2015
	 * Notes:   
	 * 
	 *************************************************************************************** **/
	public void merchantConnect(){
		try{
		action.verifyMerchantConnect();
		}catch(Exception e){
			
		}
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    merchantReply
	 * Usage:           void merchantReply()
	 * Description:     Merchant reply
	 * Author:          Automators
	 * Dated:           16Apr2015
	 * Notes:   
	 * 
	 *************************************************************************************** **/
	public void merchantReply(){
		try{
		action.verifyMerchantReply();
		}catch(Exception e){
			
		}
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    changePassword
	 * Usage:           void changePassword()
	 * Description:     Change Password
	 * Author:          Automators
	 * Dated:           20Apr2015
	 * Notes:   
	 * 
	 *************************************************************************************** **/
	public void changePassword(){
		try{
		action.verifyChangePassword();
		}catch(Exception e){
			
		}
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    placedOrderSource
	 * Usage:           void placedOrderSource()
	 * Description:     Verify placed Order Source
	 * Author:          Automators
	 * Dated:           21Apr2015
	 * Notes:   
	 * 
	 *************************************************************************************** **/
	public void placedOrderSource(){
		try{
		action.verifyOrderSource();
		}catch(Exception e){
			
		}
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    applyCoupon
	 * Usage:           void applyCoupon()
	 * Description:     Sample request for applying coupons
	 * Author:          Automators
	 * Dated:           21Apr2015
	 * Notes:   
	 * 
	 *************************************************************************************** **/
	public void applyCoupon(){
		try{
		action.verifyApplyCoupon();
		}catch(Exception e){
			
		}
	}	

	/** ***************************************************************************************
	 * Keyword-Name:    deleteProductFromCart
	 * Usage:           void deleteProductFromCart()
	 * Description:     Delete Product from cart
	 * Author:          Automators
	 * Dated:           21Apr2015
	 * Notes:   
	 * 
	 *************************************************************************************** **/
	public void deleteProductFromCart(){
		String cart_Id="";
		try{
			action.verifyOrderSource();
			cart_Id = action.getCartId();
			System.out.println("Cart_Id : "+cart_Id);
			action.verifyDeleteProductFromCart(cart_Id);
			action.verifyClearCart(cart_Id);
		}catch(Exception e){
			
		}
	}
	
	public void closeAPI() throws Exception
	{
		// TODO Auto-generated method stub
		try {
			DriverSession.getLastExecutionReportingInstance().footer();
		}

		catch (Exception ee) {
			throw new Exception("Exception raised: API not closed.");
		}
	}

	@Override
	public void openApplication() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void closeApplication() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void validateHomePage() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void navigateVerifyProductPage() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void buyNowVerifyCart() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void verifyCheckoutAddressPage() {
		// TODO Auto-generated method stub
		
	}
}

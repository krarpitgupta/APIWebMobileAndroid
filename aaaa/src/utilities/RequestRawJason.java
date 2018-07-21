package utilities;

public class RequestRawJason {

	public static String getLoginRawJson(String userName, String password,String key, String productId){
		String rawjson = "{" + "\"user\":\"" + userName + "\","
				+ "\"password\":\"" + password + "\"," + "\"key\":\"" + key
				+ "\",		" + "\"cart\":{			" + "\"0\":{	" + "	\"product_id\":"
				+ productId + "" + "     }	" + "	}		" + "}";

		return rawjson;

	}

	public static String getSecondStepRawJason(String key, String ttl,String token){
		String rawjson = "{" + "\"key\":\"" + key + "\"," + "\"ttl\":\"" + ttl
				+ "\"," + " \"token\":\"" + token + "\","
				+ "\"edit_step\":\"step_two\"," + "  \"user_id\":\""
				+ GlobalVar.UserInfoData.get("user_id") + "\","
				+ "  \"profile_id\": \""
				+ GlobalVar.UserInfoData.get("profile_id") + "\","
				+ " \"fname\": \"" + GlobalVar.UserInfoData.get("firstname")
				+ "\"," + " \"lname\": \""
				+ GlobalVar.UserInfoData.get("lastname") + "\","
				+ " \"address\": \"" + GlobalVar.UserInfoData.get("s_address")
				+ "\"," + " \"address2\": \""
				+ GlobalVar.UserInfoData.get("s_address_2") + "\","
				+ " \"city\": \"" + GlobalVar.UserInfoData.get("s_city")
				+ "\"," + " \"state\": \""
				+ GlobalVar.UserInfoData.get("s_state") + "\","
				+ " \"pincode\": \"" + GlobalVar.UserInfoData.get("s_zipcode")
				+ "\"," + " \"phone\": \""
				+ GlobalVar.UserInfoData.get("s_phone") + "\","
				+ " \"address_name\" : \""
				+ GlobalVar.UserInfoData.get("profile_name") + "\"	" + "}";
		return rawjson;
	}

	public static String getPlaceOrderRawJason(String key, String ttl,
			String token) {
		String rawJson = "{"
				+ "\"key\":\""+key+"\","
				+ "\"ttl\":\""+ttl+"\","
				+ "\"token\":\""+token+"\","
				+ " \"edit_step\" : \"place_order\","
				+ " \"user_id\": \""+GlobalVar.UserInfoData.get("user_id")+"\"," + " \"profile_id\": "+GlobalVar.UserInfoData.get("profile_id")+","
				+ " \"payment_option_id\": \"61\"" + "}";
		return rawJson;
	}

	public static String getOrderSummaryRawJason(String key,String ttl,String token) {
		String rawJason = "{"
				+ "\"key\":\""+key+"\","
				+ "\"ttl\":\""+ttl+"\","
				+ "\"token\":\""+token+"\","
				+ "\"edit_step\" : \"order_summary\","
				+ "\"user_id\": \""+GlobalVar.UserInfoData.get("user_id")+"\"," + "\"order_id\": \""+GlobalVar.orderId+"\""
				+ "}";
		return rawJason;
	}
	public static String getThirdStepRawJason(String key, String ttl,String token) {
		String rawJson = "{"
				+ "\"key\":\""+key+"\","
				+ "\"ttl\":\""+ttl+"\","
				+ " \"token\":\""+token+"\","
				+ "\"edit_step\":\"step_three\"," 
				+ "  \"user_id\":\""+GlobalVar.UserInfoData.get("user_id")+"\","
				+ "  \"profile_id\": \""+GlobalVar.UserInfoData.get("profile_id")+"\" " + "}";
		return rawJson;	  		
	}
	
	public static String getFourthStepRawJason(String key, String ttl,String token) {
		String rawJson = "{"
				+ "\"key\":\""+key+"\","
				+ "\"ttl\":\""+ttl+"\","
				+ " \"token\":\""+token+"\","
				+ "\"edit_step\":\"step_four\"," 
				+ "  \"user_id\":\""+GlobalVar.UserInfoData.get("user_id")+"\","
				+ "  \"profile_id\": \""+GlobalVar.UserInfoData.get("profile_id")+"\"," 
				+ " \"payment_option_id\": \""+GlobalVar.TEST_DATA.get("Payment ID")+"\"	" + "}";
		return rawJson;	  		
	}

	public static String getCartStepRawJason(String key, String ttl,String token ) 
	{
		String rawjson = 
				"{"
				+ "\"key\":\""+key+"\","
				+ "\"ttl\":\""+ttl+"\","
				+ " \"token\":\""+token+"\","
				+ "\"edit_step\":\"step_ViewCart\"," 
				+ "  \"user_id\":\""+GlobalVar.UserInfoData.get("user_id")+"\","
				+ "  \"profile_id\": \""+GlobalVar.UserInfoData.get("profile_id")+
				"}";
		return rawjson;
	}
	/** ***************************************************************************************
	 * Keyword-Name:    signUpRawJason
	 * Usage:           String signUpRawJason(String key) {
	 * Description:     SignUp order API
	 * Author:          Automators
	 * Dated:           16Apr2015
	 * Notes:   
	 * 
	 *************************************************************************************** **/
	public static String signUpRawJason(String key) {
		String rawJson = "{"
				+ "\"key\":\""+key+"\","
				+ "\"email\":\""+GlobalVar.TEST_DATA.get("Email ID")+"\"," 
				+ "\"firstname\":\""+GlobalVar.TEST_DATA.get("First Name")+"\"," 
				+ "  \"lastname\":\""+GlobalVar.TEST_DATA.get("Last Name")+"\","
				+ "  \"password1\": \""+GlobalVar.TEST_DATA.get("Password")+"\"," 
				+ "  \"password2\": \""+GlobalVar.TEST_DATA.get("Password")+"\"," 
				+ "\"registration_source\":\"sm_google\"	" + "}";
		return rawJson;	  		
	}
	
	public static String addToCartRawJason(String key,String ttl,String token){
		String rawJson = "{"
				+ "\"key\":\""+key+"\","
				+ "  \"user_id\":\""+GlobalVar.UserInfoData.get("user_id")+"\","
				+ "  \"product_id\": \""+GlobalVar.UserInfoData.get("product_id")+"\"," 
				+ "  \"lastname\":\""+GlobalVar.TEST_DATA.get("Last Name")+"\","
				+ "  \"password1\": \""+GlobalVar.TEST_DATA.get("Password")+"\"," 
				+ "  \"password2\": \""+GlobalVar.TEST_DATA.get("Password")+"\"," 
				+ "\"registration_source\":\"sm_google\"	" + "}";
		return rawJson;	  		
		
	}
	
	public static String getOrderListingRawJason(String key, String ttl,String token ) 
	{
		String rawjson = "{"
				+ "\"key\":\""+key+"\","
				+ "\"ttl\":\""+ttl+"\","
				+ " \"token\":\""+token+"\","
				+ "\"edit_step\":\"order_listing\"," + "  \"user_id\":\""+GlobalVar.UserInfoData.get("user_id")+"\","
				
				
				+ " \"status\": \""+GlobalVar.UserInfoData.get("s_status")+"\"," 
				+ " \"orderedproductsearch\": \""+GlobalVar.UserInfoData.get("s_orderedproductsearch")+"\"," 
				+ " \"page\": \""+GlobalVar.UserInfoData.get("s_page")+"\","
				+   "}";
		return rawjson;
	}
	
	
	public static String postAddVariantProductRawJason(String userName, String password,String key, String ttl,String token ) 
	{
		String rawjson = "{"
				+ "\"user\":\"" + userName + "\","
				+ "\"password\":\"" + password + "\"," 
				+ "\"key\":\""+key+"\","
				+ "\"ttl\":\""+ttl+"\","
				+ " \"token\":\""+token+"\"," 
				+ "\"cart\":{			" 
				+ "\"0\":{	" 
				+ "\"product_id\":\""+ GlobalVar.TEST_DATA.get("s_product_id") +"\"," 
				+ "\"options\":{	"
				+ "\"33007\":\"1056207\","
				+ "     }	" 
				+ "	}		"
				+ "     }	" 
				+   "}";
		return rawjson;
	}
	
	public static String postUpdateCartProductRawJason(String userName, String password,String key, String ttl,String token ) 
	{
		String rawjson = "{"
				+ "\"user\":\"" + userName + "\","
				+ "\"password\":\"" + password + "\"," 
				+ "\"key\":\""+key+"\","
				+ "\"ttl\":\""+ttl+"\","
				+ " \"token\":\""+token+"\"," 
				+ "\"cart\":{			" 
				+ "\"0\":{	" 
				+ "\"product_id\":\""+ GlobalVar.TEST_DATA.get("s_product_id") +"\"," 
				+ "\"amount\":\""+ GlobalVar.TEST_DATA.get("s_product_amount") +"\",	" 
				+ "	}		"
				+ "     }	" 
				+   "}";
		return rawjson;
	}
	
	public static String putChangeProfileRawJason(String key, String ttl,String token) {
		String rawJson = "{"
				+ "\"key\":\""+key+"\","
				+ "\"ttl\":\""+ttl+"\","
				+ " \"token\":\""+token+"\","
				+ "\"edit_step\":\"change_profile\"," 
				+ "  \"user_id\":\""+GlobalVar.TEST_DATA.get("user_id")+"\","
				+ "  \"firstname\": \""+GlobalVar.TEST_DATA.get("first_name")+"\"," 
				+ "  \"lastname\": \""+GlobalVar.TEST_DATA.get("last_name")+"\"," 
				+ " \"phone\": \""+GlobalVar.TEST_DATA.get("Phone_No")+"\"	" + "}";
		return rawJson;	  		
	}
	/** ***************************************************************************************
	 * Keyword-Name:    askMerchantFormRawJason
	 * Usage:           String askMerchantFormRawJason(String key, String ttl,String token) {
	 * Description:     Display Ask a merchant form
	 * Author:          Automators
	 * Dated:           17Apr2015
	 * Notes:   
	 * 
	 *************************************************************************************** **/
	
	
	public static String postGiftCertRawJason(String key, String ttl,String token) 
	{
		String rawJson = "{"
				+ "\"key\":\""+key+"\","
				+ "\"ttl\":\""+ttl+"\","
				+ " \"token\":\""+token+"\","
				+ "\"edit_step\":\"gift_cert\"," 
				+ "  \"user_id\":\""+GlobalVar.TEST_DATA.get("user_id")+"\","
				+ "  \"profile_id\": \""+GlobalVar.TEST_DATA.get("profile_id")+"\","
				+ "  \"gift_certi\": \""+GlobalVar.TEST_DATA.get("gift_cert")+"\" " + "}";
		return rawJson;	  		
	}
	
	
	public static String askMerchantFormRawJason(String key, String ttl,String token) {
		String rawJson = "{"
				+ "\"key\":\""+key+"\","
				+ "\"ttl\":\""+ttl+"\","
				+ " \"token\":\""+token+"\","
				+ "\"customer_id\":\""+GlobalVar.TEST_DATA.get("Customer ID")+"\"," 
				+ "\"product_id\":\""+GlobalVar.TEST_DATA.get("Product ID")+"\"	" + "}";
		return rawJson;	  		
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    connectMerchantRawJason
	 * Usage:           String connectMerchantRawJason(String key, String ttl,String token) {
	 * Description:     Merchant Connect (Send mail to merchant/ask que to merchant)
	 * Author:          Automators
	 * Dated:           17Apr2015
	 * Notes:   
	 * 
	 *************************************************************************************** **/
	public static String connectMerchantRawJason(String key, String ttl,String token) {
		String rawJson = "{"
				+ "\"key\":\""+key+"\","
				+ "\"ttl\":\""+ttl+"\","
				+ " \"token\":\""+token+"\","
				+ "\"customer_id\":\""+GlobalVar.TEST_DATA.get("Customer ID")+"\","
				+ "\"merchant_id\":\""+GlobalVar.TEST_DATA.get("Merchant ID")+"\"," 
				+ "\"user_message\":\""+GlobalVar.TEST_DATA.get("User Message")+"\"," 
				+ "\"message_id\":\""+GlobalVar.TEST_DATA.get("Message ID")+"\"," 
				+ "\"subject\":\""+GlobalVar.TEST_DATA.get("Subject")+"\"," 
				+ "\"user_name\":\""+GlobalVar.TEST_DATA.get("User Name")+"\"," 
				+ "\"merchant_email\":\""+GlobalVar.TEST_DATA.get("Email ID")+"\"," 
				+ "\"product_id\":\""+GlobalVar.TEST_DATA.get("Product ID")+"\"	" + "}";
		return rawJson;	  		
	}
	
	
	/** ***************************************************************************************
	 * Keyword-Name:    merchantUserQueryRawJason
	 * Usage:           String merchantUserQueryRawJason(String key, String ttl,String token) {
	 * Description:     User Query (mail list of user which sent to merchant)
	 * Author:          Automators
	 * Dated:           17Apr2015
	 * Notes:   
	 * 
	 *************************************************************************************** **/
	public static String merchantUserQueryRawJason(String key, String ttl,String token) {
		String rawJson = "{"
				+ "\"key\":\""+key+"\","
				+ "\"ttl\":\""+ttl+"\","
				+ " \"token\":\""+token+"\","
				+ "\"customer_id\":\""+GlobalVar.TEST_DATA.get("Customer ID")+"\"," 
				+ "\"user_name\":\""+GlobalVar.TEST_DATA.get("User Name")+"\"	" + "}";
		return rawJson;	  		
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    merchantResponseRawJason
	 * Usage:           String merchantResponseRawJason(String key, String ttl,String token) {
	 * Description:     Merchant Response (Mail details of user mail including merchant reply)
	 * Author:          Automators
	 * Dated:           17Apr2015
	 * Notes:   
	 * 
	 *************************************************************************************** **/
	public static String merchantResponseRawJason(String key, String ttl,String token) {
		String rawJson = "{"
				+ "\"key\":\""+key+"\","
				+ "\"ttl\":\""+ttl+"\","
				+ " \"token\":\""+token+"\","
				+ "\"customer_id\":\""+GlobalVar.TEST_DATA.get("Customer ID")+"\"," 
				+ "\"user_name\":\""+GlobalVar.TEST_DATA.get("User Name")+"\","
				+ "\"thread_id\":\""+GlobalVar.TEST_DATA.get("Thread ID")+"\"	" + "}";
		return rawJson;	  		
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    merchantReplyRawJason
	 * Usage:           String merchantReplyRawJason(String key, String ttl,String token) {
	 * Description:     Merchant Reply (User can reply to merchant response)
	 * Author:          Automators
	 * Dated:           17Apr2015
	 * Notes:   
	 * 
	 *************************************************************************************** **/
	public static String merchantReplyRawJason(String key, String ttl,String token) {
		String rawJson = "{"
				+ "\"key\":\""+key+"\","
				+ "\"ttl\":\""+ttl+"\","
				+ " \"token\":\""+token+"\","
				+ "\"customer_id\":\""+GlobalVar.TEST_DATA.get("Customer ID")+"\","
				+ "\"merchant_id\":\""+GlobalVar.TEST_DATA.get("Merchant ID")+"\","
				+ "\"user_reply\":\""+GlobalVar.TEST_DATA.get("User Reply")+"\"," 
				+ "\"message_id\":\""+GlobalVar.TEST_DATA.get("Message ID")+"\"," 
				+ "\"subject\":\""+GlobalVar.TEST_DATA.get("Subject")+"\"," 
				+ "\"user_name\":\""+GlobalVar.TEST_DATA.get("User Name")+"\"," 
				+ "\"merchant_email\":\""+GlobalVar.TEST_DATA.get("Email ID")+"\"," 
				+ "\"product_id\":\""+GlobalVar.TEST_DATA.get("Product ID")+"\","
				+ "\"product_name\":\""+GlobalVar.TEST_DATA.get("Product Name")+"\","
				+ "\"topic_id\":\""+GlobalVar.TEST_DATA.get("Topic ID")+"\","
				+ "\"thread_id\":\""+GlobalVar.TEST_DATA.get("Thread ID")+"\"	" + "}";
		return rawJson;	  		
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    changePasswordRawJason
	 * Usage:           String changePasswordRawJason(String key, String ttl,String token) {
	 * Description:     Change password
	 * Author:          Automators
	 * Dated:           20Apr2015
	 * Notes:   
	 * 
	 *************************************************************************************** **/
	public static String changePasswordRawJason(String key, String ttl,String token,String userId,String curPassword,String newPassword ) {
		String rawJson = "{"
				+ "\"key\":\""+key+"\","
				+ "\"ttl\":\""+ttl+"\","
				+ " \"token\":\""+token+"\","
				+ "\"user_id\":\""+userId+"\","
				+ "\"passwordc\":\""+curPassword+"\","
				+ " \"password1\":\""+newPassword+"\","
				+ "\"password2\":\""+newPassword+"\" "+ "}";
		return rawJson;	  		
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    cluesBucksRawJason
	 * Usage:           String cluesBucksRawJason(String key, String ttl,String token) {
	 * Description:     Apply clues bucks
	 * Author:          Automators
	 * Dated:           20Apr2015
	 * Notes:   
	 * 
	 *************************************************************************************** **/
	public static String cluesBucksRawJason(String key, String ttl,String token) {
		String rawJson = "{"
				+ "\"key\":\""+key+"\","
				+ "\"ttl\":\""+ttl+"\","
				+ " \"token\":\""+token+"\","
				+ "\"edit_step\":\""+"step_three"+"\","
				+ "\"user_id\":\""+GlobalVar.TEST_DATA.get("User ID")+"\","
				+ "\"profile_id\":\""+GlobalVar.TEST_DATA.get("Profile ID")+"\"," 
				+ "\"points_to_use\":\""+GlobalVar.TEST_DATA.get("Points To Use")+"\"	" + "}";
		return rawJson;	  		
	}

	/** ***************************************************************************************
	 * Keyword-Name:    addToCartRawJson
	 * Usage:           String addToCartRawJson(String key, String ttl,String token) {
	 * Description:     Add normal product to cart
	 * Author:          Automators
	 * Dated:           21Apr2015
	 * Notes:   
	 * 
	 *************************************************************************************** **/
	public static String addToCartRawJson(String userName, String password,String key, String ttl,String token,String productId)
	{
		String rawjson = "{" + "\"user\":\"" + userName + "\","
				+ "\"password\":\"" + password + "\"," 
				+ "\"key\":\"" + key+ "\"," 
				+ "\"ttl\":\"" + ttl+ "\","
				+ "\"token\":\"" + token+ "\","
				+ "\"cart\":{			" + "\"0\":{	" + "	\"product_id\":"
				+ productId + "" + "     }	" + "	}		" + "}";

		return rawjson;

	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    applyCouponRawJason
	 * Usage:           String applyCouponRawJason(String key, String ttl,String token) {
	 * Description:     Sample request for applying coupons
	 * Author:          Automators
	 * Dated:           21Apr2015
	 * Notes:   
	 * 
	 *************************************************************************************** **/
	public static String applyCouponRawJason(String key, String ttl,String token) {
		String rawJson = "{"
				+ "\"key\":\""+key+"\","
				+ "\"ttl\":\""+ttl+"\","
				+ " \"token\":\""+token+"\","
				+ "\"edit_step\":\""+"step_three"+"\","
				+ "\"user_id\":\""+GlobalVar.TEST_DATA.get("User ID")+"\","
				+ "\"profile_id\":\""+GlobalVar.TEST_DATA.get("Profile ID")+"\","
				+ "\"coupon_code\":{			"
				+ "\"0\":" + "	\""+GlobalVar.TEST_DATA.get("Coupon Code")+"\"	" + "	}		" + "}";
		return rawJson;	  		
	}
	
}

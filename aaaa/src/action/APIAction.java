/*
 ***************************************************************************************
 * Script-Name:          src/Action/APIAction.java
 * Description:          Action file, which consists of various methods to implement
 * ShopClues APIs as per requirements
 * Author:               Automator
 * Dated:                09Apr2015
 * Notes:  
 *
 ***************************************************************************************
 */

// Package name: action
package action;

// List of import statements to include various java classes

// Java classes for System Input/ Output, Networking Infrastructure, Utilities
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import utilities.RequestRawJason;
// Java classes for System Input/ Output, Networking Infrastructure, Utilities
import org.openqa.selenium.WebDriver;

import session.DriverSession;
import testCaseReporting.TestCaseReporting;
import utilities.GlobalVar;
import utilities.Hmac;
import utilities.MD5Hashing;
import utilities.RequestRawJason;

// List of Java libraries, to convert Java Objects into their JSON representations
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/*
 ***************************************************************************************
 * Class-Name:    public class APIAction
 * Description:   Class defined to handle various reusable actions for ShopClues APIs
 * where
 *
 * Author:             Automators
 * Dated:              09Apr2015
 * Notes:  
 *
 ********************************************************************************************
 */
public class APIAction {
	
	HttpURLConnection httpConnection = null;
	
	HashMap<String, String> testData = new HashMap<String, String>();
	TestCaseReporting testCaseReporting = null;

	public static String userID = null;

	// Factory Method

	public APIAction(WebDriver driver) {
		// this.driver = driver;
		this.testData = GlobalVar.TEST_DATA;
	}


	public HttpURLConnection openAPIConnection(String url, String requestMethod)
			throws Exception {

		try {
			URL targetUrl = new URL(url);
			httpConnection = (HttpURLConnection) targetUrl.openConnection();
			httpConnection.setDoOutput(true);
			httpConnection.setRequestMethod(requestMethod);
			httpConnection.setRequestProperty("Content-Type",
					"application/json");

			// httpConnection.disconnect();

		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance()
					.teststepreporting(
							"Exception raised: Connection not established.", "FAIL",
							"Not establish connection.");
		}

		return httpConnection;
	}

	public void closeAPIConnection() {
		try {
			httpConnection.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public StringBuffer getResponse(String url, String requestMethod, String rawJson) {
		StringBuffer response = null;

		try {

			openAPIConnection(url, requestMethod);
			if (requestMethod.equalsIgnoreCase("POST")) {
				String input = rawJson;
				OutputStream outputStream = httpConnection.getOutputStream();
				outputStream.write(input.getBytes());
				outputStream.flush();
			}

			if (httpConnection.getResponseCode() != 200) {
				GlobalVar.etpStepsReport = false;
				throw new RuntimeException("Failed : HTTP error code : "
						+ httpConnection.getResponseCode());
			}
			BufferedReader responseBuffer = new BufferedReader(
					new InputStreamReader((httpConnection.getInputStream())));
			String output;
			response=new StringBuffer();
			while ((output = responseBuffer.readLine()) != null) {
				response.append(output);
			}
			GlobalVar.etpStepsReport=true;
			closeAPIConnection();
		} catch (Exception e) {
			e.printStackTrace();
			GlobalVar.etpStepsReport=false;
		}
		return response;
	}
public void getTTL(){
	String url="";
	String ttlVal="";
	StringBuffer str=null;
	try{
		url = GlobalVar.url + "/ttl?key=" + GlobalVar.staticKey;
		str=getResponse(url, "GET", "");
		ttlVal=getValueFromParser(str, "ttl");
		GlobalVar.etpStepsReport=true;
		if(GlobalVar.etpStepsReport){
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("TTL value fetched successfully."+ttlVal,
					"PASS", "TTL value should be fetched successfully.");
		}else{
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Unable to fetch data from API." + ttlVal,
					"FAIL", "Should fetch data from API.");
		}
		GlobalVar.ttlValue=ttlVal;
	}catch(Exception e){
		e.printStackTrace();
		DriverSession.getLastExecutionReportingInstance()
		.teststepreporting("Exception raised: Enable to generate TTL",
				"FAIL", "Should not generate ttl.");
	}
}
public String getValueFromParser(StringBuffer str, String keyValue) throws Exception{
	String value="";
	Object temp;
	try{    
		JsonParser jsonParser = new JsonParser();
		JsonElement element = jsonParser.parse(str.toString());
		JsonObject jsonObject = element.getAsJsonObject();
		try{
				temp=jsonObject.get("status");
				value=temp.toString();
				if(value.contains("Failed")){
					temp=jsonObject.get("msg");
					value=temp.toString();
					throw new Exception(value);
				}
		}catch(Exception e){
			
		}
				
		temp=jsonObject.get(keyValue);
		value=temp.toString().replaceAll("\"", "");
	}catch(Exception e){
		throw new Exception(value);
	}
	return value;
	
}
public static String getValueFromParser(StringBuffer str, String parentKey, String childKey) throws Exception{
	String value="";
	Object temp=null;
	GlobalVar.etpStepsReport=false;
	try{    
		JsonParser jsonParser = new JsonParser();
		
		JsonElement element = jsonParser.parse(str.toString());
		JsonObject jsonObject = element.getAsJsonObject();
		
		try{
				temp=jsonObject.get("status");
				value=temp.toString();
				if(value.contains("Failed")){
					temp=jsonObject.get("msg");
					value=temp.toString();
					throw new Exception(value);
				}
		}catch(Exception e){
			
		}
		temp=jsonObject.get(parentKey);
		value=temp.toString();
		JsonElement element1 = jsonParser.parse(value);
		JsonObject jsonObject1 = element1.getAsJsonObject();
		temp=jsonObject1.get(childKey);
		value=temp.toString().replaceAll("\"", "");
		GlobalVar.etpStepsReport=true;
		if(GlobalVar.etpStepsReport){
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Fetched record from " +parentKey+" into "+childKey+": "+value,
					"PASS", "Records should be fetched successfully.");
		}else{
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Unable to fetch record from API" + value,
					"FAIL", "Should fetch record from API");
		}
	}catch(Exception e){
		DriverSession.getLastExecutionReportingInstance()
		.teststepreporting("Exception raised: " + value,
				"FAIL", "Should fetch records from API");
		throw new Exception(value);
	}
	return value;
	
}

public static String getValueFromParser(StringBuffer str, String parentKey, String childKey, String subChildKey,String hint) throws Exception{
	String value="";
	Object temp=null;
	GlobalVar.etpStepsReport=false;
	String val1="";
	try{    
		JsonParser jsonParser = new JsonParser();
		
		JsonElement element = jsonParser.parse(str.toString());
		JsonObject jsonObject = element.getAsJsonObject();
		
		try{
				temp=jsonObject.get("status");
				value=temp.toString();
				if(value.contains("Failed")){
					temp=jsonObject.get("msg");
					value=temp.toString();
					throw new Exception(value);
				}
		}catch(Exception e){
			
		}
		temp=jsonObject.get(parentKey);
		value=temp.toString();
		JsonElement element1 = jsonParser.parse(value);
		JsonObject jsonObject1 = element1.getAsJsonObject();
		temp=jsonObject1.get(childKey);
		value=temp.toString();
		//System.out.println("Second : "+value);
		JsonElement element2 = jsonParser.parse(value);
		JsonObject jsonObject2 = element2.getAsJsonObject();
		val1=jsonObject2.toString().split("[\",]")[1];
		JsonElement element3 = jsonParser.parse(value);
		JsonObject jsonObject3 = element3.getAsJsonObject();
		temp=jsonObject3.get(val1);	
		value=temp.toString().replaceAll("\"", "");
		GlobalVar.etpStepsReport=true;
		if(GlobalVar.etpStepsReport){
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Fetched record from " +parentKey+"into "+childKey+"into "+subChildKey+": "+value,
					"PASS", "Records should be fetched successfully.");
		}else{
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Unable to fetch record from API" + value,
					"FAIL", "Should fetch record from API");
		}
	}catch(Exception e){
		DriverSession.getLastExecutionReportingInstance()
		.teststepreporting("Exception raised: " + value,
				"FAIL", "Should fetch records from API.");
		throw new Exception(value);
	}
	return value;
	
}
public void loginAPI() throws Exception{
	String url="";
	String userId="";
	StringBuffer responseJson=null;
	String rawJason="";
	String password="";
	HashMap<String, String> userData=new HashMap<String, String>();
	try{
		url = GlobalVar.url + "/checkout";
		password=MD5Hashing.getMd5Hashing(GlobalVar.TEST_DATA.get("Password"));
		rawJason=RequestRawJason.getLoginRawJson(GlobalVar.TEST_DATA.get("User Name"), password, GlobalVar.staticKey, GlobalVar.TEST_DATA.get("Product ID"));
		responseJson=getResponse(url, "POST", rawJason);
		String responseTemp=responseJson.toString();
		if(GlobalVar.etpStepsReport && !responseTemp.contains("Failed")){
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("User logged in successfully." +responseJson,
					"PASS", " User should be logged in successfully.");
		}else{
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Unable to login in API" + responseJson,
					"FAIL", "User should be logged in successfully.");
		}
		userId=getValueFromParser(responseJson, "user_info","user_id");
		userData.put("user_id",userId);
		userData.put("firstname",getValueFromParser(responseJson, "user_info","firstname"));
		userData.put("lastname",getValueFromParser(responseJson, "user_info","lastname"));
		userData.put("profile_id",getValueFromParser(responseJson, "shipping_info","profile_id"));
		userData.put("profile_name",getValueFromParser(responseJson, "shipping_info","profile_name"));
		userData.put("s_address",getValueFromParser(responseJson, "shipping_info","s_address"));
		userData.put("s_address_2",getValueFromParser(responseJson, "shipping_info","s_address_2"));
		userData.put("s_city",getValueFromParser(responseJson, "shipping_info","s_city"));
		userData.put("s_state",getValueFromParser(responseJson, "shipping_info","s_state"));
		userData.put("s_country",getValueFromParser(responseJson, "shipping_info","s_country"));
		userData.put("s_zipcode",getValueFromParser(responseJson, "shipping_info","s_zipcode"));
		userData.put("s_phone",getValueFromParser(responseJson, "shipping_info","s_phone"));
		GlobalVar.UserInfoData=userData;
		getToken();
		
	}catch(Exception e){
		DriverSession.getLastExecutionReportingInstance()
		.teststepreporting("Unable to login in API",
				"FAIL", "User should be logged in successfully.");
		throw new Exception(e.toString());
	}
}

public void verifyCheckOutAPISelectAddress() throws Exception{
	String url="";

	StringBuffer responseJson=null;
	String rawJason="";
	
	String values="";
	String address="";
	try{
		url = GlobalVar.url + "/checkout";
		rawJason=RequestRawJason.getSecondStepRawJason(GlobalVar.staticKey, GlobalVar.ttlValue, GlobalVar.tokenValue);
		responseJson=getResponse(url, "POST", rawJason);
		values=getValueFromParser(responseJson, "msg","user_id");
		address=getValueFromParser(responseJson,  "msg","profile_id");
		if(values.equalsIgnoreCase(GlobalVar.UserInfoData.get("user_id")) && address.equalsIgnoreCase(GlobalVar.UserInfoData.get("profile_id"))){
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Check Out second step completed successfully." +responseJson,
					"PASS", "Check out second step should be completed.");
		}else{
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Check out second step is not completed." + responseJson,
					"FAIL", "Should not complete checkout second step");
		}
	
		
	}catch(Exception e){
		DriverSession.getLastExecutionReportingInstance()
		.teststepreporting("Exception raised: Checkout second step not completed.",
				"FAIL", "Should not complete checkout second step.");
		throw new Exception(e.toString());
	}
}
public void verifyCheckOutAPIPlaceOrder() throws Exception{
	String url="";

	StringBuffer responseJson=null;
	String rawJason="";
	String values="";

	try{
		url = GlobalVar.url + "/checkout";
	
		rawJason=RequestRawJason.getPlaceOrderRawJason(GlobalVar.staticKey, GlobalVar.ttlValue, GlobalVar.tokenValue);
		responseJson=getResponse(url, "POST", rawJason);
		values=getValueFromParser(responseJson, "order_id");
		GlobalVar.orderId=values;
		if(GlobalVar.etpStepsReport){
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Order placed successfully. Order ID is :- " +values,
					"PASS", "Order should be placed successfully.");
		}else{
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Order is not placed." + values,
					"FAIL", "Should not order place.");
		}
	
		
	}catch(Exception e){
		DriverSession.getLastExecutionReportingInstance()
		.teststepreporting("Exception raised: Order not placed.",
				"FAIL", "Should not place order for checkout flow.");
		throw new Exception(e.toString());
	}
}

private String getToken(){
	String msg="";
	String token="";
	String encPass="";
	try{
		getTTL();
		encPass=MD5Hashing.getMd5Hashing(GlobalVar.TEST_DATA.get("Password"));
		msg=GlobalVar.staticKey+GlobalVar.UserInfoData.get("user_id")+GlobalVar.ttlValue;
		token=Hmac.getHmacDigest(msg,encPass,"HmacSHA256");
		GlobalVar.tokenValue=token;
		DriverSession.getLastExecutionReportingInstance()
		.teststepreporting("Token created successfully." +token,
				"PASS", "Token should be created successfully.");
	}catch(Exception e){
		DriverSession.getLastExecutionReportingInstance()
		.teststepreporting("Token is not generated successfully." +token,
				"FAIL", "Token should be generated successfully.");
	}
	return token;
	
}
public void verifyCheckOutAPIOrderSummary() throws Exception{
	String url="";

	StringBuffer responseJson=null;
	String rawJason="";
	String values="";

	try{
		url = GlobalVar.url + "/checkout";
	
		rawJason=RequestRawJason.getOrderSummaryRawJason(GlobalVar.staticKey, GlobalVar.ttlValue, GlobalVar.tokenValue);
		responseJson=getResponse(url, "POST", rawJason);
		values=getValueFromParser(responseJson, "order_id");
		if(GlobalVar.orderId.equalsIgnoreCase(values)){
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Order summary verified successfully." +values,
					"PASS", "Order summary should be verified successfully.");
		}else{
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Order summary is not verified." + values,
					"FAIL", "Should not verified Order summary");
		}
	
		
	}catch(Exception e){
		DriverSession.getLastExecutionReportingInstance()
		.teststepreporting("Exception raised: Invalid input data.",
				"FAIL", "Should not verified Order summary");
		throw new Exception(e.toString());
	}
}
public void verifyCheckOutAPIReviewOrder() throws Exception{
	String url="";

	StringBuffer responseJson=null;
	String rawJason="";
	String values="";
	
	
	try{
		url = GlobalVar.url + "/checkout";
		rawJason=RequestRawJason.getFourthStepRawJason(GlobalVar.staticKey, GlobalVar.ttlValue, GlobalVar.tokenValue);
		//System.out.println("Request : " + rawJason);
		responseJson=getResponse(url, "POST", rawJason);
		//System.out.println("Respons review order : " +responseJson);
		values=getValueFromParser(responseJson, "cart","user_data","user_id","hint");
		
		if(values.contains(GlobalVar.UserInfoData.get("user_id"))){
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Review order summary successfully." +GlobalVar.UserInfoData.get("user_id"),
					"PASS", "Review order summary should be successful.");
		}else{
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Review order summary failed." + GlobalVar.UserInfoData.get("user_id"),
					"FAIL", "Review order summary should be successful");
		}

	}catch(Exception e){
		DriverSession.getLastExecutionReportingInstance()
		.teststepreporting("Exception raised: Invalid input data.",
				"FAIL", "Review order summary should be successful.");
		throw new Exception(e.toString());
	}

	
	
}

public void verifyCheckOutAPIPaymentMethod() throws Exception{
	String url="";

	StringBuffer responseJson=null;
	String rawJason="";
	
	String values="";
	
	try{
		url = GlobalVar.url + "/checkout";
		rawJason=RequestRawJason.getThirdStepRawJason(GlobalVar.staticKey, GlobalVar.ttlValue, GlobalVar.tokenValue);
		//System.out.println("Request : " + rawJason);
		responseJson=getResponse(url, "POST", rawJason);
		values=getValueFromParser(responseJson, "cart","user_data","user_id","hint");
		if(values.contains(GlobalVar.UserInfoData.get("user_id"))){
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Payment as COD completed." +GlobalVar.UserInfoData.get("user_id"),
					"PASS", "Payment as COD should be completed.");
		}else{
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Payment as COD failed." + GlobalVar.UserInfoData.get("user_id"),
					"FAIL", "Payment as COD should be completed");
		}

	}catch(Exception e){
		DriverSession.getLastExecutionReportingInstance()
		.teststepreporting("Exception raised: Invalid input data.",
				"FAIL", "Payment as COD should be completed.");
		throw new Exception(e.toString());
	}

}
public void verifyGetCart() throws Exception
{
	String url="";

	StringBuffer responseJson=null;
	String productID="";
	String values="";
	GlobalVar.etpStepsReport=true;
	try{
		url = GlobalVar.url + "/cart?user_id="+GlobalVar.UserInfoData.get("user_id")+"&key="+GlobalVar.staticKey+"&ttl="+GlobalVar.ttlValue+"&token="+GlobalVar.tokenValue;
		responseJson=getResponse(url, "GET", "");
		//System.out.println(responseJson);
		productID=getValueFromParser(responseJson, "cart","products","product_id");
		//System.out.println(values);
				
		if(GlobalVar.etpStepsReport)
		{
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Verify Get Cart completed successfully." +productID,
					"PASS", "Verify Get Cart step should be completed.");
		}
		else
		{
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Verify Get Cart step is not completed." + productID,
					"FAIL", "Should not verify the view cart.");
		}
		
	}
	catch(Exception e)
	{
		DriverSession.getLastExecutionReportingInstance().teststepreporting("Exception raised: Invalid input data.","FAIL", "Should not verify the view cart step.");
		throw new Exception(e.toString());
	}
}

/** ***************************************************************************************
 * Keyword-Name:    verifyCheckOutAPISignUP
 * Usage:           void verifyCheckOutAPISignUP()
 * Description:     Sign Up 
 * Author:          Automators
 * Dated:           16Apr2015
 * Notes:   
 * 
 *************************************************************************************** **/
public void verifyCheckOutAPISignUP() throws Exception{
	String url="";

	StringBuffer responseJson=null;
	String rawJason="";
	String values="";
	
	
	try{
		
		url=GlobalVar.url+"/signup";
		rawJason=RequestRawJason.signUpRawJason(GlobalVar.staticKey);
		//System.out.println("Request : " + rawJason);
		responseJson=getResponse(url, "POST", rawJason);
		//System.out.println("Respons review order : " +responseJson);
		values=getValueFromParser(responseJson,"user_id");
		
		if(values!=""){
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Sign up completed" +responseJson,
					"PASS", "Sign up should be completed");
		}else{
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Sign up failed." + responseJson,
					"FAIL", "Sign up should be completed");
		}

	}catch(Exception e){
		DriverSession.getLastExecutionReportingInstance()
		.teststepreporting("Exception occured : " + e.toString(),
				"FAIL", "Sign up should be completed");
		throw new Exception(e.toString());
	}

	
	
}




/** ***************************************************************************************
 * Keyword-Name:    verifyAskaMerchantForm
 * Usage:           void verifyAskaMerchantForm()
 * Description:     Display Ask a merchant form
 * Author:          Automators
 * Dated:           17Apr2015
 * Notes:   
 * 
 *************************************************************************************** **/
public void verifyAskaMerchantForm() throws Exception
{
	String url="";
	StringBuffer responseJson=null;
	String sts="";
	String custId="",prodId="",key="";
	GlobalVar.etpStepsReport=true;
	try{
		custId=GlobalVar.TEST_DATA.get("Customer ID");
		
		prodId = GlobalVar.TEST_DATA.get("Product ID");
		
		key=GlobalVar.staticKey;
		
		url = GlobalVar.url + "/askamerchantform?customer_id="+custId+"&product_id="+prodId+"&key="+key;
		
		responseJson=getResponse(url, "GET", "");
		
		sts=getValueFromParser(responseJson, "status");
		
				
		if(GlobalVar.etpStepsReport && sts.contains("success"))
		{
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Merchant form is displayed",
					"PASS", "Merchant form should be displayed");
		}
		else
		{
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Merchant form not displayed",
					"FAIL", "Merchant form should be displayed");
		}
		
	}
	catch(Exception e)
	{
		DriverSession.getLastExecutionReportingInstance().teststepreporting("Exception raised: Invalid input data.","FAIL", "Merchant form should be displayed");
		throw new Exception(e.toString());
	}
}

/** ***************************************************************************************
 * Keyword-Name:    verifyMerchantUserQuery
 * Usage:           void verifyMerchantUserQuery()
 * Description:     User Query (mail list of user which sent to merchant)
 * Author:          Automators
 * Dated:           17Apr2015
 * Notes:   
 * 
 *************************************************************************************** **/
public void verifyMerchantUserQuery() throws Exception
{
	String url="";
	String token="";
	String msg="";
	StringBuffer responseJson=null;
	String productID="";
	String values="";
	GlobalVar.etpStepsReport=true;
	try{
		token=Hmac.getHmacDigest(msg,"key","HmacSHA256");
		url = GlobalVar.url + "/askamerchantform?customer_id="+GlobalVar.UserInfoData.get("Customer ID")+"user_name="+GlobalVar.UserInfoData.get("User Name")+"&key="+GlobalVar.staticKey+"&ttl="+GlobalVar.ttlValue+"&token="+token;
		responseJson=getResponse(url, "GET", "");
		//System.out.println(responseJson);
		productID=getValueFromParser(responseJson, "cart","products","product_id");
		//System.out.println(values);
				
		if(GlobalVar.etpStepsReport)
		{
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Verify Get Cart completed successfully." +productID,
					"PASS", "Verify Get Cart step should be completed.");
		}
		else
		{
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Verify Get Cart step is not completed." + productID,
					"FAIL", "Should not verify the view cart.");
		}
		
	}
	catch(Exception e)
	{
		DriverSession.getLastExecutionReportingInstance().teststepreporting("Exception raised: Invalid input data.","FAIL", "Should not verify the view cart step.");
		throw new Exception(e.toString());
	}
}

/** ***************************************************************************************
 * Keyword-Name:    verifyMerchantResponse
 * Usage:           void verifyMerchantResponse()
 * Description:     Merchant Response (Mail details of user mail including merchant reply)
 * Author:          Automators
 * Dated:           17Apr2015
 * Notes:   
 * 
 *************************************************************************************** **/
public void verifyMerchantResponse() throws Exception
{
	String url="";
	String token="";
	String msg="";
	StringBuffer responseJson=null;
	String status="";
	String values="";
	GlobalVar.etpStepsReport=true;
	try{
		token=Hmac.getHmacDigest(msg,"key","HmacSHA256");
		url = GlobalVar.url + "/askamerchantform?customer_id="+GlobalVar.UserInfoData.get("Customer ID")+"user_name="+GlobalVar.UserInfoData.get("User Name")+"thread_id="+GlobalVar.UserInfoData.get("Thread ID")+"&key="+GlobalVar.staticKey+"&ttl="+GlobalVar.ttlValue+"&token="+token;
		
		responseJson=getResponse(url, "GET", "");
		//System.out.println(responseJson);
		status=getValueFromParser(responseJson, "status");
		//System.out.println(status);
		
		values=getValueFromParser(responseJson, "response", "user_name");
		//System.out.println(status);
				
		if(GlobalVar.etpStepsReport)
		{
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Verify merchant response completed successfully with status : " +status + " and user name : " + values,
					"PASS", "Verify Get Cart step should be completed.");
		}
		else
		{
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Verify merchant status step is not completed." + status,
					"FAIL", "Should not verify the view cart.");
		}
		
	}
	catch(Exception e)
	{
		DriverSession.getLastExecutionReportingInstance().teststepreporting("Exception raised: Invalid input data.","FAIL", "Should not verify the merchant response step.");
		throw new Exception(e.toString());
	}
}

public static String getValueFromParser(StringBuffer str, String parentKey, String childKey, String subChildKey) throws Exception{
	String value="";
	Object temp=null;
	GlobalVar.etpStepsReport=false;
	String val1="";
	try{    
		JsonParser jsonParser = new JsonParser();
		
		JsonElement element = jsonParser.parse(str.toString());
		JsonObject jsonObject = element.getAsJsonObject();
		
		try{
				temp=jsonObject.get("status");
				value=temp.toString();
				if(value.contains("Failed")){
					temp=jsonObject.get("msg");
					value=temp.toString();
					throw new Exception(value);
				}
		}catch(Exception e){
			
		}
		temp=jsonObject.get(parentKey);
		value=temp.toString();
		JsonElement element1 = jsonParser.parse(value);
		JsonObject jsonObject1 = element1.getAsJsonObject();
		temp=jsonObject1.get(childKey);
		value=temp.toString();
		//System.out.println("Second : "+value);
		JsonElement element2 = jsonParser.parse(value);
		JsonObject jsonObject2 = element2.getAsJsonObject();
		val1=jsonObject2.toString().split("[\",]")[1];
		JsonElement element3 = jsonParser.parse(value);
		JsonObject jsonObject3 = element3.getAsJsonObject();
		temp=jsonObject3.get(val1);	
		value=temp.toString().replaceAll("\"", "");
		GlobalVar.etpStepsReport=true;
		if(GlobalVar.etpStepsReport){
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Fetched record from " +parentKey+"into "+childKey+"into "+subChildKey+": "+value,
					"PASS", "Records should be fetched successfully.");
		}else{
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Unable to fetch record from API" + value,
					"FAIL", "Should fetch record from API");
		}
	}catch(Exception e){
		DriverSession.getLastExecutionReportingInstance()
		.teststepreporting("Exception raised: " + value,
				"FAIL", "Should fetch records from API.");
		throw new Exception(value);
	}
	return value;
	
}	

/** ***************************************************************************************
 * Keyword-Name:    verifyMerchantConnect
 * Usage:           void verifyMerchantConnect()
 * Description:     Merchant Connect (Send mail to merchant/ask que to merchant)
 * Author:          Automators
 * Dated:           17Apr2015
 * Notes:   
 * 
 *************************************************************************************** **/
public void verifyMerchantConnect() throws Exception{
	String url="";

	StringBuffer responseJson=null;
	String rawJason="";
	String token="";
	String msg="";
	String values="";
	try{
		url = GlobalVar.url + "/mconnect";
//		msg=GlobalVar.staticKey+GlobalVar.UserInfoData.get("user_id")+GlobalVar.ttlValue;
		token=Hmac.getHmacDigest(msg,"key","HmacSHA256");
		getTTL();
		rawJason=RequestRawJason.connectMerchantRawJason(GlobalVar.staticKey, GlobalVar.ttlValue, token);
		//System.out.println("Request : " + rawJason);
		responseJson=getResponse(url, "POST", rawJason);
		//System.out.println("Respons payment method : " +responseJson);
		values=getValueFromParser(responseJson, "status");
		//System.out.println("values : " + values);
		if(values.contains("success")){
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Merchant connect step completed." +responseJson,
					"PASS", "Merchant connect step should be completed");
		}else{
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Merchant connect step not completed" + responseJson,
					"FAIL", "Merchant connect step should be completed");
		}

	}catch(Exception e){
		DriverSession.getLastExecutionReportingInstance()
		.teststepreporting("Exception occured : " + e.toString(),
				"FAIL", "Merchant connect step should be completed");
		throw new Exception(e.toString());
	}

}
/** ***************************************************************************************
 * Keyword-Name:    verifyCluesBucks
 * Usage:           void verifyCluesBucks()
 * Description:     Apply clues bucks
 * Author:          Automators
 * Dated:           20Apr2015
 * Notes:   
 * 
 *************************************************************************************** **/
public void verifyCluesBucks() throws Exception{
	String url="";

	StringBuffer responseJson=null;
	String rawJason="";
	String values="";
	try{
		url = GlobalVar.url + "/checkout";
		getTTL();
		String encPass = MD5Hashing.getMd5Hashing(GlobalVar.TEST_DATA.get("Password"));
		String msg = GlobalVar.staticKey+GlobalVar.TEST_DATA.get("User ID")+GlobalVar.ttlValue;
		String token = Hmac.getHmacDigest(msg,encPass,"HmacSHA256");
		rawJason=RequestRawJason.cluesBucksRawJason(GlobalVar.staticKey, GlobalVar.ttlValue, token);
		responseJson=getResponse(url, "POST", rawJason);
		values=getValueFromParser(responseJson, "cart");
		if(values.contains(GlobalVar.TEST_DATA.get("Clues Buck Success Message"))){
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Clues bucks applied" +responseJson,
					"PASS", "Clues bucks should be applied");
		}else{
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Clues bucks not applied" + responseJson,
					"FAIL", "Clues bucks should be applied");
		}

	}catch(Exception e){
		DriverSession.getLastExecutionReportingInstance()
		.teststepreporting("Exception occured : " + e.toString(),
				"FAIL", "Clues bucks should be applied");
		throw new Exception(e.toString());
	}

}
/** ***************************************************************************************
 * Keyword-Name:    verifyMerchantReply
 * Usage:           void verifyMerchantReply()
 * Description:     Merchant Reply (User can reply to merchant response)
 * Author:          Automators
 * Dated:           17Apr2015
 * Notes:   
 * 
 *************************************************************************************** **/
public void verifyMerchantReply() throws Exception{
	String url="";

	StringBuffer responseJson=null;
	String rawJason="";
	String token="";
	String msg="";
	String values="";
	String custId="";
	try{
		url = GlobalVar.url + "/checkout";
		msg=GlobalVar.staticKey+GlobalVar.UserInfoData.get("user_id")+GlobalVar.ttlValue;
		token=Hmac.getHmacDigest(msg,"key","HmacSHA256");
		getTTL();
		rawJason=RequestRawJason.merchantReplyRawJason(GlobalVar.staticKey, GlobalVar.ttlValue, token);
		//System.out.println("Request : " + rawJason);
		responseJson=getResponse(url, "POST", rawJason);
		//System.out.println("Respons payment method : " +responseJson);
		values=getValueFromParser(responseJson, "status","user_data");
		//System.out.println("values : " + values);
		
		custId=getValueFromParser(responseJson,  "response","customer_id");
		//System.out.println("adrress : " + custId);
		if(custId.contains(GlobalVar.UserInfoData.get("customer_id"))){
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Payment as COD completed." +responseJson,
					"PASS", "Payment as COD should be completed.");
		}else{
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Review order summary failed." + responseJson,
					"FAIL", "Payment as COD should be completed");
		}

	}catch(Exception e){
		DriverSession.getLastExecutionReportingInstance()
		.teststepreporting("Exception occured : " + e.toString(),
				"FAIL", "Payment as COD should be completed.");
		throw new Exception(e.toString());
	}

}
/** ***************************************************************************************
 * Keyword-Name:    verifyChangePassword
 * Usage:           void verifyChangePassword()
 * Description:     Change password
 * Author:          Automators
 * Dated:           20Apr2015
 * Notes:   
 * 
 *************************************************************************************** **/
public void verifyChangePassword() throws Exception{
	String url="";

	StringBuffer responseJson=null;
	String rawJason="";
	String token="";
	String msg="";
	String sts="";
	String message="";
	String curPassword="";
	String newPassword="";
	try{
		url = GlobalVar.url + "/password";
        msg=GlobalVar.staticKey+GlobalVar.TEST_DATA.get("User ID")+GlobalVar.ttlValue;
		token=Hmac.getHmacDigest(msg,GlobalVar.staticKey,"HmacSHA256");
		getTTL();
		curPassword=MD5Hashing.getMd5Hashing(GlobalVar.TEST_DATA.get("Current Password"));
		//System.out.println("Current Password : " + curPassword);
		newPassword=MD5Hashing.getMd5Hashing(GlobalVar.TEST_DATA.get("New Password"));
		//System.out.println("New Password : " + newPassword);
		rawJason=RequestRawJason.changePasswordRawJason(GlobalVar.staticKey, GlobalVar.ttlValue, token,GlobalVar.TEST_DATA.get("User ID"),curPassword,newPassword);
		//System.out.println("Request : " + rawJason);
		responseJson=getResponse(url, "POST", rawJason);
		//System.out.println("Respons payment method : " +responseJson);
		sts=getValueFromParser(responseJson, "status");
		//System.out.println("values : " + sts);
		
		message=getValueFromParser(responseJson,  "msg");
		//System.out.println("adrress : " + message);
		if(sts.contains(GlobalVar.UserInfoData.get("Status")) && message.contains(GlobalVar.UserInfoData.get("Message"))){
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Password updated successfully" +responseJson,
					"PASS", "Password should be updated successfully");
		}else{
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Password updation failed" + responseJson,
					"FAIL", "Password should be updated successfully");
		}

	}catch(Exception e){
		DriverSession.getLastExecutionReportingInstance()
		.teststepreporting("Exception occured : " + e.toString(),
				"FAIL", "Password should be updated successfully");
		throw new Exception(e.toString());
	}

}

/** ***************************************************************************************
 * Keyword-Name:    verifyOrderSource
 * Usage:           void verifyOrderSource()
 * Description:     Check Source of Order Placed
 * Author:          Automators
 * Dated:           21Apr2015
 * Notes:   
 * 
 *************************************************************************************** **/
public void verifyOrderSource() throws Exception{
	String url="";

	StringBuffer responseJson=null;
	String rawJason="";
	String token="";
	String msg="";
	String usrId="";
	String source="";
	String password="";
	
	try{
		url = GlobalVar.url + "/checkout";
//		msg=GlobalVar.staticKey+GlobalVar.UserInfoData.get("user_id")+GlobalVar.ttlValue;
		token=Hmac.getHmacDigest(msg,"key","HmacSHA256");
		getTTL();
		password=MD5Hashing.getMd5Hashing(GlobalVar.TEST_DATA.get("Current Password"));
		//System.out.println("Current Password : " + password);
		
		rawJason=RequestRawJason.addToCartRawJson(GlobalVar.TEST_DATA.get("User Name"), password,GlobalVar.staticKey, GlobalVar.ttlValue,token,GlobalVar.TEST_DATA.get("Product ID"));
		//System.out.println("Request : " + rawJason);
		
		responseJson=getResponse(url, "POST", rawJason);
		//System.out.println("Respons payment method : " +responseJson);
		
		usrId=getValueFromParser(responseJson, "user_info");
		//System.out.println("values : " + usrId);
		
		if(GlobalVar.staticKey.equalsIgnoreCase("d12121c70dda5edfgd1df6633fdb36c0"))
		{
			source="Destop";
		}
		if(GlobalVar.staticKey.equalsIgnoreCase(""))
		{
			source="Mobile APP";
		}
		if(GlobalVar.staticKey.equalsIgnoreCase(""))
		{
			source="WAP";
		}
		if(GlobalVar.etpStepsReport){
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Placed order source is verified as " +source,
					"PASS", "Source of Order Placed should be verified");
		}else{
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Placed order source is not verified" + responseJson,
					"FAIL", "Source of Order Placed should be verified");
		}

	}catch(Exception e){
		DriverSession.getLastExecutionReportingInstance()
		.teststepreporting("Exception occured : " + e.toString(),
				"FAIL", "Source of Order Placed should be verified");
		throw new Exception(e.toString());
	}

}

/** ***************************************************************************************
 * Keyword-Name:    verifyApplyCoupon
 * Usage:           void verifyApplyCoupon()
 * Description:     Sample request for applying coupons
 * Author:          Automators
 * Dated:           21Apr2015
 * Notes:   
 * 
 *************************************************************************************** **/
public void verifyApplyCoupon() throws Exception{
	String url="";

	StringBuffer responseJson=null;
	String rawJason="";
	String token="";
	String msg="";
	String usrId="";
	
	try{
		url = GlobalVar.url + "/checkout";
		token=Hmac.getHmacDigest(msg,"key","HmacSHA256");
		getTTL();
		
		rawJason=RequestRawJason.applyCouponRawJason(GlobalVar.staticKey,GlobalVar.ttlValue,token);
		
		//System.out.println("Request : " + rawJason);
		
		responseJson=getResponse(url, "POST", rawJason);
		//System.out.println("Respons payment method : " +responseJson);
		
		usrId=getValueFromParser(responseJson, "cart","user_data","user_id");
		//System.out.println("values : " + usrId);
					
		if(usrId.contains(GlobalVar.TEST_DATA.get("User ID"))){
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Coupon applied successfully" + responseJson,
					"PASS", "Coupon should be apply");
		}else{
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Coupon not applied" + responseJson,
					"FAIL", "Coupon should be apply");
		}

	}catch(Exception e){
		DriverSession.getLastExecutionReportingInstance()
		.teststepreporting("Exception occured : " + e.toString(),
				"FAIL", "Coupon should be apply");
		throw new Exception(e.toString());
	}

}
/** ***************************************************************************************
 * Keyword-Name:    getCartId
 * Usage:           String getCartId()
 * Description:     DGet cart id API 
 * Author:          Automators
 * Dated:           21Apr2015
 * Notes:   
 * 
 *************************************************************************************** **/
public String getCartId() throws Exception
{
	String url="";
	String token="";
	String msg="";
	StringBuffer responseJson=null;
	String status="";
	String[] str1=new String[3];;
	GlobalVar.etpStepsReport=true;
	try{
		getTTL();
		token=Hmac.getHmacDigest(msg,"key","HmacSHA256");

		url = GlobalVar.url + "/cart?user_id="+GlobalVar.TEST_DATA.get("User ID")+"&key="+GlobalVar.staticKey+"&ttl=1429510858&token=007920c24714f3d85e980d9bce3b20e533a10a6bbfa7ae83eaf4fc9e94984cfe";
		//System.out.println("URL : "+url);
		responseJson=getResponse(url, "GET", "");
		//System.out.println(responseJson);
		status=getValueFromParser(responseJson,"cart","products","item_id");
		//System.out.println(status);	
		str1 = status.split("item_id");
		status = str1[1];
		str1 = status.split(",");
		status = str1[0];
		str1 = status.split(":");
		status = str1[1].trim();
		
		if(GlobalVar.etpStepsReport)
		{
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Cart id fetched successfully " + status,
					"PASS", "Cart id should be fetched");
		}
		else
		{
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Unable to fetch cart id",
					"FAIL", "Cart id should be fetched");
		}
		
	}
	catch(Exception e)
	{
		DriverSession.getLastExecutionReportingInstance().teststepreporting("Exception raised: Invalid input data.","FAIL", "Cart id should be fetched");
		throw new Exception(e.toString());
	}
	return status;
}


/** ***************************************************************************************
 * Keyword-Name:    verifyDeleteProductFromCart
 * Usage:           void verifyDeleteProductFromCart()
 * Description:     Delete Product from Cart API 
 * Author:          Automators
 * Dated:           21Apr2015
 * Notes:   
 * 
 *************************************************************************************** **/
public void verifyDeleteProductFromCart(String cart_Id) throws Exception
{
	String url="";
	String token="";
	String msg="";
	StringBuffer responseJson=null;
	String status="";
	String message="";
	GlobalVar.etpStepsReport=true;
	try{
		token=Hmac.getHmacDigest(msg,"key","HmacSHA256");
		url = GlobalVar.url + "/cart?user_id="+GlobalVar.TEST_DATA.get("User ID")+"&key="+GlobalVar.staticKey+"&ttl="+GlobalVar.ttlValue+"&token="+token+"&cart_id="+cart_Id;
//		url = GlobalVar.url + "/cart?user_id="+GlobalVar.TEST_DATA.get("User ID")+"&key="+GlobalVar.staticKey+"&ttl=1429510858&token=007920c24714f3d85e980d9bce3b20e533a10a6bbfa7ae83eaf4fc9e94984cfe"+"&cart_id="+cart_Id;
		
		responseJson=getResponse(url, "DELETE", "");
		status=getValueFromParser(responseJson, "status");
		message=getValueFromParser(responseJson, "msg");
							
		if(GlobalVar.etpStepsReport)
		{
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Delete product from cart successfully with status : " +status + " and Message : " + message,
					"PASS", "Product should be deleted");
		}
		else
		{
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Product not deleted",
					"FAIL", "Product should be deleted");
		}
		
	}
	catch(Exception e)
	{
		DriverSession.getLastExecutionReportingInstance().teststepreporting("Exception raised: Invalid input data.","FAIL", "Product should be deleted");
		throw new Exception(e.toString());
	}
}

/** ***************************************************************************************
 * Keyword-Name:    verifyClearCart
 * Usage:           void verifyClearCart()
 * Description:     Clear Cart API 
 * Author:          Automators
 * Dated:           21Apr2015
 * Notes:   
 * 
 *************************************************************************************** **/
public void verifyClearCart(String cart_Id) throws Exception
{
	String url="";
	String token="";
	String msg="";
	StringBuffer responseJson=null;
	String status="";
	String message="";
	GlobalVar.etpStepsReport=true;
	try{
		token=Hmac.getHmacDigest(msg,"key","HmacSHA256");
		url = GlobalVar.url + "/cart?user_id="+GlobalVar.TEST_DATA.get("User ID")+"&key="+GlobalVar.staticKey+"&ttl="+GlobalVar.ttlValue+"&token="+token+"&cart_id=0";
//		url = GlobalVar.url + "/cart?user_id="+GlobalVar.TEST_DATA.get("User ID")+"&key="+GlobalVar.staticKey+"&ttl=1429510858&token=007920c24714f3d85e980d9bce3b20e533a10a6bbfa7ae83eaf4fc9e94984cfe"+"&cart_id=0";
		
		responseJson=getResponse(url, "DELETE", "");
		status=getValueFromParser(responseJson, "status");
		message=getValueFromParser(responseJson, "msg");
						
		if(GlobalVar.etpStepsReport)
		{
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Clear cart successfully with status : " +status + " and Message : " + message,
					"PASS", "Product should be deleted");
		}
		else
		{
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Product not deleted",
					"FAIL", "Product should be deleted");
		}
		
	}
	catch(Exception e)
	{
		DriverSession.getLastExecutionReportingInstance().teststepreporting("Exception raised: Invalid input data.","FAIL", "Product should be deleted");
		throw new Exception(e.toString());
	}
}

public void checkOrderHistory() throws Exception
{
	String url="";

	StringBuffer responseJson=null;
	String productID="";
	String values="";
	String token="";
	String msg="";
	GlobalVar.etpStepsReport=true;
	try{
		token=Hmac.getHmacDigest(msg,"key","HmacSHA256");
		
		url = GlobalVar.url + "/orders?user_id="+ "3744"+"&key="+GlobalVar.staticKey;
		//System.out.println(url);
		responseJson=getResponse(url, "GET", "");
		//System.out.println(responseJson);
		productID=getValueFromParser(responseJson, "summary");
	
		//System.out.println(productID);

				
		if(GlobalVar.etpStepsReport)
		{
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Verify Get Cart completed successfully." +productID,
					"PASS", "Verify Get Cart step should be completed.");
		}
		else
		{
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Verify Get Cart step is not completed." + productID,
					"FAIL", "Should not verify the view cart.");
		}
		
	}
	catch(Exception e)
	{
		DriverSession.getLastExecutionReportingInstance().teststepreporting("Exception raised: Invalid input data.","FAIL", "Should not verify the view cart step.");
		throw new Exception(e.toString());
	}
}

public void checkOrderListing() throws Exception
{
	String url="";
	
	
	StringBuffer responseJson=null;
	String company_id="";
	String values="";
	String token="";
	String msg="";
	GlobalVar.etpStepsReport=true;
	try{
		token=Hmac.getHmacDigest(msg,"key","HmacSHA256");
		getTTL();
		url = GlobalVar.url + "/orders?user_id="+ "3744"+"&key="+GlobalVar.staticKey+"&ttl="+GlobalVar.ttlValue+"&token="+token;
		//System.out.println(url);
		responseJson=getResponse(url, "GET", "");
		//System.out.println(responseJson);
		company_id=getValueFromParser(responseJson,company_id);
	
		//System.out.println(company_id);

				
		if(company_id.contains(GlobalVar.TEST_DATA.get("Company ID")))
		{
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Verify Order Listing completed successfully." +company_id,
					"PASS", "Verify Order Listing step should be completed.");
		}
		else
		{
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Verify Order Listing step is not completed." + company_id,
					"FAIL", "Should not verify the Order Listing.");
		}
		
	}
	catch(Exception e)
	{
		DriverSession.getLastExecutionReportingInstance().teststepreporting("Exception raised: Invalid input data.","FAIL", "Should not verify the Order Listing step.");
		throw new Exception(e.toString());
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


public void addVariantProduct() throws Exception{
	String url="";
	String userId="";
	
	StringBuffer responseJson=null;
	String rawJason="";
	String password="";
	String token="";
	String msg="";
	String values="";
	
	
	HashMap<String, String> userData=new HashMap<String, String>();
	try{
		url = GlobalVar.url + "/checkout";
		password=MD5Hashing.getMd5Hashing(GlobalVar.TEST_DATA.get("Password"));
		//System.out.println("pasasword : "+password);
		//msg=GlobalVar.staticKey+GlobalVar.UserInfoData.get("user_id")+GlobalVar.ttlValue;
		token=Hmac.getHmacDigest(msg,"key","HmacSHA256");
		getTTL();
		//System.out.println(GlobalVar.TEST_DATA.get("User Name"));
		rawJason=RequestRawJason.postAddVariantProductRawJason(GlobalVar.TEST_DATA.get("User Name"), password, GlobalVar.staticKey, GlobalVar.ttlValue,token);
		//System.out.println(rawJason);
		responseJson=getResponse(url, "POST", rawJason);
		//System.out.println(responseJson);
		
		userId=getValueFromParser(responseJson,"cart","product_id");
 		//System.out.println(userId);
 
	
		if(userId.contains(GlobalVar.TEST_DATA.get("user_id")))
		{
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("User added variant product successfully." +responseJson,
					"PASS", "User should be login.");
		}
		else
		{
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Unable to add variant product " + responseJson,
					"FAIL", "Should be able to add variant product");
		}
		
		
	}catch(Exception e)
	{
		DriverSession.getLastExecutionReportingInstance().teststepreporting("Unable to add variant product" + e.toString(),
				"FAIL", "Should be able to add variant product");
		throw new Exception(e.toString());
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

public void updateCart() throws Exception{
	String url="";
	String userId="";
	
	StringBuffer responseJson=null;
	String rawJason="";
	String password="";
	String token="";
	String msg="";
	String values="";
	
	
	HashMap<String, String> userData=new HashMap<String, String>();
	try{
		url = GlobalVar.url + "/checkout";
		password=MD5Hashing.getMd5Hashing(GlobalVar.TEST_DATA.get("Password"));
		//System.out.println("pasasword : "+password);
		//msg=GlobalVar.staticKey+GlobalVar.UserInfoData.get("user_id")+GlobalVar.ttlValue;
		token=Hmac.getHmacDigest(msg,"key","HmacSHA256");
		getTTL();
		//System.out.println(GlobalVar.TEST_DATA.get("User Name"));
		rawJason=RequestRawJason.postUpdateCartProductRawJason(GlobalVar.TEST_DATA.get("User Name"), password, GlobalVar.staticKey, GlobalVar.ttlValue,token);
		//System.out.println(rawJason);
		responseJson=getResponse(url, "POST", rawJason);
		//System.out.println(responseJson);
		
		userId=getValueFromParser(responseJson,"user_info","user_id");
 		//System.out.println(userId);
 
	
		if(userId.contains(GlobalVar.TEST_DATA.get("user_id")))
		{
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("User updated product cart successfully." +responseJson,
					"PASS", "User should be able to update product cart.");
		}
		else
		{
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Unable to update product cart " + responseJson,
					"FAIL", "Should be able to update product cart");
		}
		
		
	}catch(Exception e)
	{
		DriverSession.getLastExecutionReportingInstance().teststepreporting("Unable to add variant product" + e.toString(),
				"FAIL", "Should be able to update product cart");
		throw new Exception(e.toString());
	}
}  

public void verifyUpdateProfile() throws Exception{
	String url="";

	StringBuffer responseJson=null;
	String rawJason="";
	String token="";
	String msg="";
	String values="";
	
	
	try{
		url = GlobalVar.url + "/checkout";
		msg=GlobalVar.staticKey+GlobalVar.TEST_DATA.get("user_id")+GlobalVar.ttlValue;
		token=Hmac.getHmacDigest(msg,"key","HmacSHA256");
		getTTL();
		
		rawJason=RequestRawJason.putChangeProfileRawJason(GlobalVar.staticKey, GlobalVar.ttlValue, token);
		//System.out.println("Request : " + rawJason);
		
		responseJson=getResponse(url, "PUT", rawJason);
		//System.out.println("Respons review order : " +responseJson);
		
		values=getValueFromParser(responseJson, "msg","user_id");
		
		if(values.contains(GlobalVar.TEST_DATA.get("user_id")))
		{
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Profile Updated successfully." +responseJson,
					"PASS", "Profile Updated should be successful.");
		}else
		{
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Profile Update failed." + responseJson,
					"FAIL", "Profile Updated should be successful");
		}

	}catch(Exception e){
		DriverSession.getLastExecutionReportingInstance()
		.teststepreporting("Exception occured : " + e.toString(),
				"FAIL", "Profile Update should be successful.");
		throw new Exception(e.toString());
	}	
}

public void verifyGiftCert() throws Exception{
	String url="";

	StringBuffer responseJson=null;
	String rawJason="";
	String token="";
	String msg="";
	String values="";
	String gift_certi="";
	
	
	try{
		url = GlobalVar.url + "/checkout";
		//System.out.println("URL : " +url);
		
		msg=GlobalVar.staticKey+GlobalVar.TEST_DATA.get("user_id")+GlobalVar.ttlValue;
		token=Hmac.getHmacDigest(msg,"key","HmacSHA256");
		getTTL();
		
		rawJason=RequestRawJason.postGiftCertRawJason(GlobalVar.staticKey, GlobalVar.ttlValue, token);
		//System.out.println("Request : " + rawJason);
		
		responseJson=getResponse(url, "POST", rawJason);
		//System.out.println("Respons review order : " +responseJson);
		
		values=getValueFromParser(responseJson,"cart","user_data","user_id");
		
		if(values.contains(GlobalVar.TEST_DATA.get("user_id")))
		{
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Gift Card Applied successfully." +responseJson,
					"PASS", "Gift Card should be successfully Applied.");
		}else
		{
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Applied Gift Card failed to execute" + responseJson,
					"FAIL", "Gift Card should be successfully Applied.");
		}


	}catch(Exception e)
	{
		DriverSession.getLastExecutionReportingInstance().teststepreporting("Exception occured : " + e.toString(),
				"FAIL", "Gift Card should be successfully Applied.");
		throw new Exception(e.toString());
	}

	
	
}

}

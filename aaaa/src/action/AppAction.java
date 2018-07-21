/*
 ***************************************************************************************
 * Script-Name:          com.ShopClues/APIAction.java
 * Description:          Action file, which consists of various methods to implement
 * ShopClues Mobile App as per requirements
 * Author:               Automators
 * Dated:                09Apr2015
 * Notes:  
 *
 ***************************************************************************************
 */
// Package name: action
package action;

//List of import statements to include various Java classes including 'AppiumDriver'
import io.appium.java_client.AppiumDriver;

import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.concurrent.TimeUnit;

import net.sourceforge.htmlunit.corejs.javascript.tools.shell.Global;

import org.apache.xalan.templates.ElemApplyImport;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.remote.server.handler.SendKeys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.yaml.snakeyaml.emitter.Emitter;

import com.sun.corba.se.impl.oa.poa.ActiveObjectMap.Key;

import pageWiseOR.androidApp.HomePage;
import pageWiseOR.androidApp.PaymentMethod;
import pageWiseOR.androidApp.PlaceOrder;
import pageWiseOR.androidApp.SignInPage;
import session.DriverSession;
import sun.awt.SunToolkit;
import testCaseReporting.TestCaseReporting;
import utilities.GlobalVar;
import utilities.Keywords;

/*
 ******************************************************************************************
 * Class-Name:    public class AppAction
 * Description:   Class defined to handle various reusable actions for ShopClues Mobile App
 * where
 *
 * Author:        Automators
 * Dated:         09Apr2015
 * Notes:  
 *
 ******************************************************************************************
 */
public class AppAction {

	private WebDriver driver;
	//private AppiumDriver adriver;
	
	HashMap<String, String> testData = new HashMap<String, String>();
	TestCaseReporting testCaseReporting = null;
	public static AppiumDriver drivers=null;
	String etPortfolioName="";
	String productName="";
	
	public AppAction(WebDriver lastExecutionDriver) {
		this.driver = lastExecutionDriver;
		this.testData = GlobalVar.TEST_DATA;
	
	}
	
	public void launchApp(WebDriver driver) {

		try {
			this.driver = driver;
			this.testData = GlobalVar.TEST_DATA;
			Keywords.waitForPage(driver);
			DriverSession.getLastExecutionReportingInstance()
					.teststepreporting("App Launched", "PASS",
							"App should be Launched");
		} catch (Exception e) {

			DriverSession.getLastExecutionReportingInstance()
					.teststepreporting("App is not Launched", "FAIL",
							"App should be Launch.");
		}

	}
	/*public void launchAppiumApp(AppiumDriver aDriver)
	{
		this.adriver=aDriver;
	} */
	public void  validateHomePage(){
		WebElement homeBanner = HomePage.getInstance().homeBanner(driver);
		Keywords.validateElementExistOrNot(homeBanner);
		if (GlobalVar.etpStepsReport) {
			DriverSession.getLastExecutionReportingInstance()
					.teststepreporting("ShopClues Mobile App Home Page verified successfully", "PASS",
							"ShopClues Mobile App Home Page should be verified");

		} else {
			DriverSession.getLastExecutionReportingInstance()
					.teststepreporting("ShopClues Home Page not verified", "FAIL",
							"ShopClues Home Page should be verified");
		}
	}
	
	
	public void clickOnProductCategory(String Category) {
		try
		{
	      this.testData = GlobalVar.TEST_DATA;
		  List<WebElement> elements=HomePage.getInstance().productCategory(driver);
	
		    boolean isFound = false;
		    
		    while(elements.size()<=0){
		    	Keywords.swipeVertically(200);
		    	elements=HomePage.getInstance().productCategory(driver);
		    }
		    while(!isFound){
			    for (WebElement webElement : elements) {
					if(webElement.getText().equalsIgnoreCase(testData.get(Category))){
						Keywords.click(webElement);
						isFound = true;
						break;
					}else{
						isFound = false;
					}
				}
			    if(!isFound){
			    	Keywords.swipeVertically(200);
			    	elements=HomePage.getInstance().productCategory(driver);
			    }else{
			    	break;
			    }
			    
		    }
		    
			//Keywords.swipeTillObjectDisplayed(elements, testData.get(Category));
			
			if(GlobalVar.etpStepsReport)
			{
			 DriverSession
					.getLastExecutionReportingInstance()
					.teststepreporting(
							" Clicked on product category <b>"+ testData.get(Category)+"</b>", "PASS",
							" Should click on "+ testData.get(Category));
				
			}
			else
			{
				 DriverSession
					.getLastExecutionReportingInstance()
					.teststepreporting(
							 "Not Clicked on category "+ "", "FAIL",
							 "Should be clicked on "+"");
								
			}
		    
			Keywords.explicitWait(2);
		}
		catch(Exception e)
		{
			
		}
	}
	
	
	

public void clickOnWesterWear(String Category) {
	try
	{
      this.testData = GlobalVar.TEST_DATA;
	  List<WebElement> elements=HomePage.getInstance().menswesterWear(driver);
       Keywords.clickByText(elements, testData.get(Category)); 
       
     
	  
		if(GlobalVar.etpStepsReport)
		{
		 DriverSession
				.getLastExecutionReportingInstance()
				.teststepreporting(
						" Clicked on product category <b>"+ testData.get(Category)+"</b>", "PASS",
						" Should click on "+ testData.get(Category));
			
		}
		else
		{
			 DriverSession
				.getLastExecutionReportingInstance()
				.teststepreporting(
						 "Not Clicked on category "+ testData.get(Category), "FAIL",
						 "Should click on "+testData.get(Category));
							
		}
	    
		Keywords.explicitWait(4);
	}
	catch(Exception e)
	{
		
	}

	
}

public void searchAndClickOnProduct()
{
	
	List<WebElement> productHeaders=null;
   try
   {
	  productHeaders=HomePage.getInstance().productHeaders(driver);
	  this.productName=Keywords.getTextByIndex(productHeaders,0);
	  Keywords.clickByIndex(productHeaders,0);
	  if(GlobalVar.etpStepsReport)
	  {
           
		  DriverSession.getLastExecutionReportingInstance().teststepreporting(
					" Clicked on first one product  <b>"+ this.productName + "</b>" , "PASS",
					" Should be clicked on first product."+ this.productName );

	  }
	  else
	  {
		  
		  DriverSession
			.getLastExecutionReportingInstance()
			.teststepreporting(
					" Not Clicked on first one product  "+ this.productName , "FAIL",
					" Should be clicked on first product "+ this.productName);
		  
		  
	  }
   }
   catch(Exception ee)
   {
	   
	   ee.printStackTrace();
   }
	
	
}
	
public void clickOn_SearchButton()
{try{
	
	WebElement search=HomePage.getInstance().clickSearchButton(driver);
		Keywords.click(search);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
}


public void verifyProductName() {
    WebElement productNameObj=null;
	String expectedProductName="";
	String product_Name=null;
	try
	{
        productNameObj=HomePage.getInstance().productName(driver);
        expectedProductName=Keywords.getText(productNameObj).trim();
        
        this.testData = GlobalVar.TEST_DATA;
        product_Name=testData.get("ProductName").toString();
        //System.out.println("1"+expectedProductName);
        //System.out.println("2"+product_Name);
        
        if(product_Name.equalsIgnoreCase(expectedProductName))
        {
        	//System.out.println("1");
        	 DriverSession
 			.getLastExecutionReportingInstance()
 			.teststepreporting(
 					" Product Name is verifid ,Current product name <b>"+expectedProductName +"</b> is same as expected product name "+ product_Name  ,"PASS",
 					" Current product name "+productName+" should be same as expected product name "+this.productName);

        }
        else
        {
        	//System.out.println("2");
        	DriverSession
 			.getLastExecutionReportingInstance()
 			.teststepreporting(
 					" Product Name is not verifid ,Current product name <b>"+expectedProductName +"</b> is not same as expected product name "+product_Name  ,"FAIL",
 					" Current product name "+productName+ " should be same as expected product name "+this.productName);

        }
	}
	catch(Exception ee)
	{
		
	}
	
}
public void writeTo_SearchBox()
{
	try{
		this.testData = GlobalVar.TEST_DATA;
		WebElement element=HomePage.getInstance().writeToSearchBox(driver);
		 Keywords.typeText(element,testData.get("ProductName").toString()); 
		 WebElement goButton=HomePage.getInstance().clickOn_GoButton(driver);
		 Keywords.click(goButton);
		 Thread.sleep(10000);
		 
		 List <WebElement> select=HomePage.getInstance().clickOn_Selected_Item(driver);
		 Keywords.clickByText(select, testData.get("ProductName").toString());
		 Thread.sleep(5000);
		 
	}
	catch(Exception e){
		e.printStackTrace();
	}
}
public void clickOnBuyButton() {

WebElement buyNowButtonOb=null;	
try
{
	buyNowButtonOb=HomePage.getInstance().buyNowButton(driver);
	Keywords.click(buyNowButtonOb);
	if(GlobalVar.etpStepsReport)
	{
		
		 DriverSession
			.getLastExecutionReportingInstance()
			.teststepreporting(
					" Clicked on Buy Now Button  ","PASS",
					" Should click on  Buy Now Button.");


	}
	else{

		DriverSession
		.getLastExecutionReportingInstance()
		.teststepreporting(
				" Not Clicked on Buy Now Button  ","FAIL",
				" Should click on  Buy Now Button.");

	}
	}
catch(Exception e)
{
	e.printStackTrace();
	}
	
}

public void selectSize() {
	List<WebElement> sizes=null; 
	try
	{
		sizes=HomePage.getInstance().sizePopup(driver);
		String size=Keywords.getTextByIndex(sizes, 0);
		Keywords.clickByIndex(sizes, 0);
		if(GlobalVar.etpStepsReport)
		{
			DriverSession
			.getLastExecutionReportingInstance()
			.teststepreporting(
					" Size selected "+ size,"PASS",
					Keywords.getTextByIndex(sizes, 0)+"  Size Should be selected");
	}
	else{

		DriverSession
		.getLastExecutionReportingInstance()
		.teststepreporting(
				" Size not selected as "+size,"FAIL",
				" Size Should be selected");

	}
	}
	catch(Exception e)
	{
		
		e.printStackTrace();
	}
	
}

public void verifyCartProductName() {
WebElement productNameObj=null;
String product_Name=null;
try
{
  productNameObj=HomePage.getInstance().cartProductName(driver);
  productName=Keywords.getText(productNameObj);
  this.testData = GlobalVar.TEST_DATA;
  product_Name=testData.get("ProductName").toString();
  
  if(product_Name.equalsIgnoreCase(productName))
  {
  DriverSession
	.getLastExecutionReportingInstance()
	.teststepreporting(
			" Product Name is verifid ,Current product name <b>"+productName+"</b> is same as expected product name "+product_Name  ,"PASS",
			" Current product name "+productName+" is should be same as expected product name "+this.productName);
 
}
else
{

	DriverSession
	.getLastExecutionReportingInstance()
	.teststepreporting(
			" Product Name is not verifid ,Current product name"+product_Name+" is not same as expected product name "+product_Name ,"FAIL",
			" Current product name "+productName+ " is should be same as expected product name "+this.productName);

	
	
}

}
catch(Exception e)
{
	e.printStackTrace();
}

}





public void enterEmailIDCheckoutPage() {
	String email=GlobalVar.TEST_DATA.get("EmailID");
	WebElement emailid=HomePage.getInstance().EmailField(driver);	
	Keywords.typeText(emailid, email);
	
	
}

public void enterPasswordCheckoutPage() {
	this.testData=GlobalVar.TEST_DATA;
	String password=GlobalVar.TEST_DATA.get("Password");
	WebElement pass=HomePage.getInstance().PasswordField(driver);
	//System.out.println("password is "+password);
	Keywords.click(pass);
	Keywords.typeText(pass, password);
	Keywords.hideKeyBoard();
}




public void clickOn_AddToCart()

{
	try
	{
	
	WebElement addToCart=HomePage.getInstance().product_AddToCart(driver);
		Keywords.click(addToCart);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
}


public void closeApp() {
	try {
		DriverSession.getLastExecutionReportingInstance().footer();
		GlobalVar.driver.quit();

	}

	catch (Exception ee) {

		DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("App is not Closed", "FAIL",
						"App should be Closed");

	}

}

public void clickQuantity() 
{
	WebElement productQuantity=null;

	try
	{
		productQuantity=HomePage.getInstance().product_Quantity(driver);
		//System.out.println("productQuantity");
		Keywords.click(productQuantity);

	
		if(GlobalVar.etpStepsReport){
			DriverSession.getLastExecutionReportingInstance().
				teststepreporting(" Quantity selected ","PASS","  Quantity Should be selected");
		}
	else{

		DriverSession.getLastExecutionReportingInstance().
			teststepreporting(" Quantity not selected as "+productQuantity,"FAIL"," Quantity Should be selected");

	}
	}
	catch(Exception e)
	{
		
		e.printStackTrace();
	}
	
}

public void selectQuantity() 
{
	List<WebElement> quantities=null; 
	int prod_Qty=0;
	try
	{
		quantities=HomePage.getInstance().quantityPopup(driver);
		//System.out.println(GlobalVar.TEST_DATA.get("prodQuantity"));
		prod_Qty=Integer.parseInt(GlobalVar.TEST_DATA.get("prodQuantity"));
		String pickQuantity=Keywords.getTextByIndex(quantities, prod_Qty);
		Keywords.clickByIndex(quantities, prod_Qty);
		if(GlobalVar.etpStepsReport)
		{
			DriverSession.getLastExecutionReportingInstance().teststepreporting(" Size selected "+ pickQuantity,"PASS",Keywords.getTextByIndex(quantities, 0)+"  Size Should be selected");
		}
	else
	{

		DriverSession.getLastExecutionReportingInstance().teststepreporting(" Size not selected as "+pickQuantity,"FAIL"," Size Should be selected");

	}
	}
	catch(Exception e)
	{
		
		e.printStackTrace();
	}
	
}

public void clickOnMenuArrow() 
{

	WebElement menuArrowLink=null;	
	try
	{
		menuArrowLink=HomePage.getInstance().splashScreen_Menu(driver);
		Keywords.click(menuArrowLink);
		if(GlobalVar.etpStepsReport)
		{
			
			 DriverSession.getLastExecutionReportingInstance().teststepreporting(" Clicked on Menu Arrow Link  ","PASS"," Should click on  Menu Arrow Link");

		}
		else
		{

			DriverSession.getLastExecutionReportingInstance().teststepreporting("Not Clicked on Menu Arrow Link  ","FAIL"," Should click on  Menu Arrow Link");

		}
	}
	catch(Exception e)
		{
			e.printStackTrace();
		}
		
}

public void clickOnCart() 
{

	WebElement cartLink=null;	
	try
	{
		cartLink=HomePage.getInstance().product_Cart(driver);
		Keywords.click(cartLink);
		if(GlobalVar.etpStepsReport)
		{
			
			 DriverSession.getLastExecutionReportingInstance().teststepreporting(" Clicked on Cart Link  ","PASS"," Should click on  Cart Link Link");

		}
		else
		{

			DriverSession.getLastExecutionReportingInstance().teststepreporting("Not Clicked on Cart Link  ","FAIL"," Should click on  Cart Link Link");

		}
	}
	catch(Exception e)
		{
			e.printStackTrace();
		}
		
}

public void clickOnShopByCategory() 
{

	WebElement shopByCategory=null;	
	try
	{
		shopByCategory=HomePage.getInstance().splashScreen_Menu_shopByCategory(driver);
		Keywords.click(shopByCategory);
		if(GlobalVar.etpStepsReport)
		{
			
			 DriverSession.getLastExecutionReportingInstance().teststepreporting(" Clicked on Shop By Category Link  ","PASS"," Should click on  Shop By Category Link");

		}
		else
		{

			DriverSession.getLastExecutionReportingInstance().teststepreporting("Not Clicked on Shop By Category Link  ","FAIL"," Should click on  Shop By Category Link");

		}
	}
	catch(Exception e)
		{
			e.printStackTrace();
		}
		
}

public void clickOnShopByCategoryComputers() 
{

	WebElement shopByCategoryComputers=null;	
	try
	{
		shopByCategoryComputers=HomePage.getInstance().splashScreen_Menu_shopByCategory_Computer(driver);
		Keywords.click(shopByCategoryComputers);
		if(GlobalVar.etpStepsReport)
		{
			
			 DriverSession.getLastExecutionReportingInstance().teststepreporting(" Clicked on Computers Link  ","PASS"," Should click on Computers Link");

		}
		else
		{

			DriverSession.getLastExecutionReportingInstance().teststepreporting("Not Clicked on Computers Link  ","FAIL"," Should click on Computers Link");

		}
	}
	catch(Exception e)
		{
			e.printStackTrace();
		}
		
}

public void clickOnShopByCategoryComputersMemoryDevices() 
{

	List<WebElement> shopByCategoryComputersMemoryDevices=null;	
	try
	{
		shopByCategoryComputersMemoryDevices=HomePage.getInstance().click_CategoryItems(driver);
		String prod=GlobalVar.TEST_DATA.get("Device Catg");
		Keywords.clickByText(shopByCategoryComputersMemoryDevices, prod);
		if(GlobalVar.etpStepsReport)
		{
			
			 DriverSession.getLastExecutionReportingInstance().teststepreporting(" Clicked on Memory Devices Link  ","PASS"," Should click on  Memory Devices Link");

		}
		else
		{

			DriverSession.getLastExecutionReportingInstance().teststepreporting("Not Clicked on  Memory Devices Link  ","FAIL"," Should click on  Memory Devices Link");

		}
	}
	catch(Exception e)
		{
			e.printStackTrace();
		}
		
}

public void clickOnShopByCategoryComputersMemoryDevicesPenDriver() 
{

	WebElement shopByCategoryComputersMemoryDevicesPenDriver=null;	
	try
	{
		shopByCategoryComputersMemoryDevicesPenDriver=HomePage.getInstance().splashScreen_Menu_shopByCategory_Computer_MemoryDevices_PenDriver(driver);
		Keywords.click(shopByCategoryComputersMemoryDevicesPenDriver);
		if(GlobalVar.etpStepsReport)
		{
			
			 DriverSession.getLastExecutionReportingInstance().teststepreporting(" Clicked on Pen Drive Link  ","PASS"," Should click on  Pen Drive Link");

		}
		else
		{

			DriverSession.getLastExecutionReportingInstance().teststepreporting("Not Clicked on Pen Drive Link  ","FAIL"," Should click on  Pen Drive Link");

		}
	}
	catch(Exception e)
		{
			e.printStackTrace();
		}
		
}


public void clickOnProductSearch() 
{

	WebElement clickOnProductSearch=null;	
	try
	{
		clickOnProductSearch=HomePage.getInstance().product_Serach(driver);
		Keywords.click(clickOnProductSearch);
		if(GlobalVar.etpStepsReport)
		{
			
			 DriverSession.getLastExecutionReportingInstance().teststepreporting(" Clicked on Product Serach  ","PASS"," Should click on  Product Serach");

		}
		else
		{

			DriverSession.getLastExecutionReportingInstance().teststepreporting("Not Clicked on Product Serach  ","FAIL"," Should click on Product Serach");

		}
	}
	catch(Exception e)
		{
			e.printStackTrace();
		}
		
}

public void ProductSearch_TypeTextName() 
{
	WebElement element=null;
	try{
		element=HomePage.getInstance().product_SerachBox(driver);
	
		Keywords.typeText(element,GlobalVar.TEST_DATA.get("SearchTextName"));

		
		if (GlobalVar.etpStepsReport) 
		{
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Search Text typed succefully. :: "+GlobalVar.TEST_DATA.get("SearchTextName"), "PASS","Search Text should be entered.");

		} 
		else 
		{
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Search Text not typed.", "FAIL","Search Text should be typed.");

		}
		
		
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
		DriverSession.getLastExecutionReportingInstance().teststepreporting("Exception occured : ", "FAIL",e.toString());
	}
}

public void clickOnProductSearchGo() 
{

	WebElement clickOnProductSearchGo=null;	
	try
	{
		clickOnProductSearchGo=HomePage.getInstance().product_SearchBoxGo(driver);
		Keywords.click(clickOnProductSearchGo);
		
		if(GlobalVar.etpStepsReport)
		{
			
			 DriverSession.getLastExecutionReportingInstance().teststepreporting(" Clicked on Product Serach GO ","PASS"," Should click on  Product Serach GO");

		}
		else
		{

			DriverSession.getLastExecutionReportingInstance().teststepreporting("Not Clicked on Product Serach GO ","FAIL"," Should click on Product Serach GO");

		}
	}
	catch(Exception e)
		{
			e.printStackTrace();
		}
		
}

public void clickOnDesiredProduct() 
{
	WebElement clickOnDesiredProduct=null;	
	String prod_DataSheet=null;
	try
	{
		clickOnDesiredProduct=HomePage.getInstance().product_DesiredProduct(driver);
		prod_DataSheet=GlobalVar.TEST_DATA.get("SearchTextName");
		
		if(clickOnDesiredProduct.getText().equalsIgnoreCase(prod_DataSheet)){
			Keywords.click(clickOnDesiredProduct);
			DriverSession.getLastExecutionReportingInstance().teststepreporting(" Clicked on Desired Product ","PASS"," Should click on  Desired Product ");

		}
		else
		{

			DriverSession.getLastExecutionReportingInstance().teststepreporting("Not Clicked on Desired Product Serach GO ","FAIL"," Should click on Desired Product");

		}
	}
	catch(Exception e)
		{
			e.printStackTrace();
		}
		
}

public void clickOnsizOption() {
	//WebElement sizeOption=null;
	String option="size";
	try
	{
		List<WebElement> sizeOption=HomePage.getInstance().buyBySize(driver);		
		Keywords.clickByPartialText(sizeOption,option);
		
		if(GlobalVar.etpStepsReport)
		{
		 DriverSession
				.getLastExecutionReportingInstance()
				.teststepreporting(
						" Click on size option ", "PASS",
						" should click on size option .");
			
		}
		else
		{
			 DriverSession
				.getLastExecutionReportingInstance()
				.teststepreporting(
						 "Not Clicked on size option"+ "", "FAIL",
						 "should click on size option ");
							
		}
	    

	}
  catch(Exception ee)
	{
	  ee.printStackTrace();
	}
}

public void clickOnProductOption() {
	//WebElement sizeOption=null;
	String option="Product";
	try
	{
		List<WebElement> productOption=HomePage.getInstance().product_SearchOptions(driver);		
		Keywords.clickByPartialText(productOption,option);
		
		if(GlobalVar.etpStepsReport)
		{
		 DriverSession
				.getLastExecutionReportingInstance()
				.teststepreporting(
						" Click on Desired Product option ", "PASS",
						" should click on Desired Product option .");
			
		}
		else
		{
			 DriverSession
				.getLastExecutionReportingInstance()
				.teststepreporting(
						 "Not Clicked on Desired Product option"+ "", "FAIL",
						 "should click on Desired Product option ");
							
		}
	    

	}
  catch(Exception ee)
	{
	  ee.printStackTrace();
	}
}

public void click_AccountandPass() {
	try
	{
		
      this.testData = GlobalVar.TEST_DATA;
      String Category="I have a ShopClues account and password";
      
     // Category="SelectLo";
	  List<WebElement> elements=HomePage.getInstance().WithPasswordRadio(driver);   
       Keywords.clickByText(elements, Category); 
       
     
	    
		if(GlobalVar.etpStepsReport)
		{
		 DriverSession
				.getLastExecutionReportingInstance()
				.teststepreporting(
						" Clicked on radio Button <b>I have shopclues acc and password</b> "+ "", "PASS",
						" should click on radio Button i have shopclues acc and password .");
			
		}
		else
		{
			 DriverSession
				.getLastExecutionReportingInstance()
				.teststepreporting(
						 "Not Clicked on radio Button "+ "", "FAIL",
						 "should click on radio Button i have shopclues acc and password ");
							
		}
	    
		Keywords.explicitWait(4);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}

	 
}

public void enterEmailIDCheckoutPage(String email) {
	
	WebElement emailid=HomePage.getInstance().EmailField(driver);	
	Keywords.typeText(emailid, email);
	
	
}

public void enterPasswordCheckoutPage(String password) {
	
	WebElement pass=HomePage.getInstance().PasswordField(driver);
	//System.out.println("password is "+password);
	Keywords.keyBoardEvent(61,"Linux");
	//((AppiumDriver)driver).sendKeyEvent(66);
	Keywords.click(pass);
	Keywords.typeText(pass, password);
	
}

public void clickContinueCheckoutPage() 
{
	WebElement continueButton=HomePage.getInstance().continueButton(driver);	
	Keywords.click(continueButton);
}

public void clickShipping_Continue_Button() {
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	WebElement shippingButton=HomePage.getInstance().shipping_ContinueButton(driver);
	Keywords.click(shippingButton);
	
}

public void clickOnPlaceOrder() 
{

	WebElement placeOrderButton=null;	
	try
	{
		placeOrderButton=HomePage.getInstance().placeOrderButton(driver);
		Keywords.click(placeOrderButton);
		if(GlobalVar.etpStepsReport)
		{
			
		 DriverSession.getLastExecutionReportingInstance().teststepreporting(" Clicked on Place order button  ","PASS"," Should click on  Place order button.");

		}
		else
		{

		DriverSession.getLastExecutionReportingInstance().teststepreporting("Not Clicked on Place order button  ","FAIL"," Should click on  Place order button.");

		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
		
}

public void typeEmailID()
{
	WebElement element=null;
	try
	{
		element=HomePage.getInstance().product_Email(driver);
		
		Keywords.typeText(element,GlobalVar.TEST_DATA.get("Email_Address"));
		
		if (GlobalVar.etpStepsReport) 
		{
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Email ID typed succefully. :: "+GlobalVar.TEST_DATA.get("Email_Address"), "PASS","Email ID name should be entered.");
		} 
		else 
		{
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Email ID not typed.", "FAIL","Email ID should be typed.");
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
		DriverSession.getLastExecutionReportingInstance().teststepreporting("Exception occured : ", "FAIL",e.toString());
	}
}

public void clickOnContinue_Address() 
{

	WebElement continueButton=null;	
	try
	{
		Keywords.hideKeyBoard();
		continueButton=HomePage.getInstance().product_ContinueLink(driver);
		Keywords.click(continueButton);
		if(GlobalVar.etpStepsReport)
		{
			
		 DriverSession.getLastExecutionReportingInstance().teststepreporting(" Clicked on CONTINUE button  ","PASS"," Should click on CONTINUE button.");

		}
		else
		{

		DriverSession.getLastExecutionReportingInstance().teststepreporting("Not Clicked on CONTINUE button  ","FAIL"," Should click on CONTINUE button.");

		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
		
}

public void enterShippingAddress()
{
	WebElement element=null;
	try
	{
		element=HomePage.getInstance().product_FirstName(driver);
		Keywords.typeText(element,GlobalVar.TEST_DATA.get("First_Name"));
		
		if (GlobalVar.etpStepsReport) 
		{
			DriverSession.getLastExecutionReportingInstance().teststepreporting("First Name typed succefully. :: "+GlobalVar.TEST_DATA.get("Email_Address"), "PASS","Email ID name should be entered.");
		} 
		else 
		{
			DriverSession.getLastExecutionReportingInstance().teststepreporting("First Name not typed.", "FAIL","Email ID should be typed.");
		}
		
		element=HomePage.getInstance().product_LastName(driver);
		Keywords.typeText(element, GlobalVar.TEST_DATA.get("Last_Name"));
		
		element=HomePage.getInstance().product_PinCode(driver);
		//System.out.println(GlobalVar.TEST_DATA.get("Pin_Code"));
		Keywords.typeText(element, GlobalVar.TEST_DATA.get("Pin_Code"));
		
		element=HomePage.getInstance().product_MobileNumber(driver);
		Keywords.typeText(element, GlobalVar.TEST_DATA.get("Mobile_Number"));
		
		element=HomePage.getInstance().product_Address(driver);
		Keywords.typeText(element, GlobalVar.TEST_DATA.get("Address"));
		Keywords.hideKeyBoard();
		
		
		element=HomePage.getInstance().product_Address2(driver);
		Keywords.typeText(element, GlobalVar.TEST_DATA.get("Address_2"));		
		Keywords.hideKeyBoard();
		
		element=HomePage.getInstance().product_City(driver);
		Keywords.typeText(element, GlobalVar.TEST_DATA.get("City"));
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
		DriverSession.getLastExecutionReportingInstance().teststepreporting("Exception occured : ", "FAIL",e.toString());
	}
}

public void clickContinueShippingAddressPage() 
{
	WebElement continueButtonShippingAddressPage=HomePage.getInstance().product_ShippingAddressPageContinueLink(driver);	
	Keywords.click(continueButtonShippingAddressPage);
}


public void clickOnAppMenu() 
{

	WebElement menuLink=null;	
	try
	{
		//menuLink=HomePage.getInstance().product_AppMenu(driver);
		menuLink=HomePage.getInstance().click_DotsOption(driver);
		Keywords.click(menuLink);
		if(GlobalVar.etpStepsReport)
		{
			
			 DriverSession.getLastExecutionReportingInstance().teststepreporting(" Clicked on Menu Link  ","PASS"," Should click on  Menu  Link");

		}
		else
		{

			DriverSession.getLastExecutionReportingInstance().teststepreporting("Not Clicked on Menu Link  ","FAIL"," Should click on  Menu  Link");

		}
	}
	catch(Exception e)
		{
			e.printStackTrace();
		}
		
}

public void clickOnAppLogin() 
{

	WebElement loginLink=null;	
	try
	{
		loginLink=HomePage.getInstance().product_AppLogin(driver);
		Keywords.click(loginLink);
		if(GlobalVar.etpStepsReport)
		{
			 DriverSession.getLastExecutionReportingInstance().teststepreporting(" Clicked on Login Link  ","PASS"," Should click on  Login  Link");
		}
		else
		{
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Not Clicked on Login Link  ","FAIL"," Should click on  Login  Link");
		}
	}
	catch(Exception e)
		{
			e.printStackTrace();
		}
		
}

public void enterAppLoginEmailID()
{
	WebElement element=null;
	try
	{
		element=HomePage.getInstance().product_AppLogin_Email(driver);
		Keywords.clearEditField(element);
		Keywords.typeText(element,GlobalVar.TEST_DATA.get("AppLogin_Email_Address"));
		
		if (GlobalVar.etpStepsReport) 
		{
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Email ID typed succefully. :: <b><i>"+GlobalVar.TEST_DATA.get("AppLogin_Email_Address")+"</i></b>", "PASS","Email ID name should be entered.");
		} 
		else 
		{
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Email ID not typed.", "FAIL","Email ID should be typed.");
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
		DriverSession.getLastExecutionReportingInstance().teststepreporting("Exception occured : ", "FAIL",e.toString());
	}
}

public void enterAppLoginPassword()
{
	WebElement element=null;
	try
	{
		element=HomePage.getInstance().product_AppLogin_Password(driver);
		Keywords.clearEditField(element);
		Keywords.typeText(element,GlobalVar.TEST_DATA.get("AppLogin_Password"));
		
		
		if (GlobalVar.etpStepsReport) 
		{
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Password typed succefully. :: <b><i>"+GlobalVar.TEST_DATA.get("AppLogin_Password")+"</i></b>", "PASS","Email ID name should be entered.");
		} 
		else 
		{
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Password not typed.", "FAIL","Email ID should be typed.");
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
		DriverSession.getLastExecutionReportingInstance().teststepreporting("Exception occured : ", "FAIL",e.toString());
	}
}

public void clickOnAppLoginShowPassword() 
{

	WebElement showPasswordLink=null;	
	try
	{
		showPasswordLink=HomePage.getInstance().product_AppLogin_ShowPassword(driver);
		Keywords.click(showPasswordLink);
		if(GlobalVar.etpStepsReport)
		{
			
			 DriverSession.getLastExecutionReportingInstance().teststepreporting(" Clicked on Show Password Link  ","PASS"," Should click on  Show Password Link");

		}
		else
		{

			DriverSession.getLastExecutionReportingInstance().teststepreporting("Not Clicked on Show Password Link  ","FAIL"," Should click on  Show Password Link");

		}
	}
	catch(Exception e)
		{
			e.printStackTrace();
		}
		
}

public void clickOnAppLoginLink() 
{

	WebElement loginLink=null;	
	try
	{
		loginLink=HomePage.getInstance().product_AppLogin_LoginLink(driver);
		Keywords.click(loginLink);
		if(GlobalVar.etpStepsReport){
			 DriverSession.getLastExecutionReportingInstance().teststepreporting(" Clicked on App Login Link  ","PASS"," Should click on  Show Password Link");

		}
		else{

			DriverSession.getLastExecutionReportingInstance().teststepreporting("Not Clicked on App Login Link  ","FAIL"," Should click on  Show Password Link");

		}
	}
	catch(Exception e)
		{
			e.printStackTrace();
		}
		
}

public void clickOnAppRegister() 
{

	WebElement registerNowLink=null;	
	try
	{
		
		registerNowLink=HomePage.getInstance().product_AppLogin_RegisterNow(driver);
		Keywords.click(registerNowLink);
		if(GlobalVar.etpStepsReport)
		{
			
			 DriverSession.getLastExecutionReportingInstance().teststepreporting(" Clicked on Register Now Link  ","PASS"," Should click on  Register  Link");

		}
		else
		{

			DriverSession.getLastExecutionReportingInstance().teststepreporting("Not Clicked on Register Now Link  ","FAIL"," Should click on  Register  Link");

		}
	}
	catch(Exception e)
		{
			e.printStackTrace();
		}
		
}

public void enterAppRegisterFirstName()
{
	WebElement element=null;
	try
	{
		element=HomePage.getInstance().product_AppLogin_RegisterNow_FirstName(driver);
		
		Keywords.typeText(element,GlobalVar.TEST_DATA.get("Register_firstName"));
		
		if (GlobalVar.etpStepsReport) 
		{
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Register First Name typed succefully. :: <b>"+GlobalVar.TEST_DATA.get("Register_firstName")+"</b>","PASS","Email ID name should be entered.");
		} 
		else 
		{
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Register First Namenot typed.", "FAIL","Email ID should be typed.");
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
		DriverSession.getLastExecutionReportingInstance().teststepreporting("Exception occured : ", "FAIL",e.toString());
	}
}

public void enterAppRegisterLastName()
{
	WebElement element=null;
	try
	{
		element=HomePage.getInstance().product_AppLogin_RegisterNow_LastName(driver);
		
		Keywords.typeText(element,GlobalVar.TEST_DATA.get("Register_lastName"));
		
		if (GlobalVar.etpStepsReport) 
		{
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Register Last Name typed succefully. :: <b>"+GlobalVar.TEST_DATA.get("Register_lastName")+"</b>","PASS","Email ID name should be entered.");
			
		} 
		else 
		{
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Register Last Name not typed.", "FAIL","Email ID should be typed.");
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
		DriverSession.getLastExecutionReportingInstance().teststepreporting("Exception occured : ", "FAIL",e.toString());
	}
}

public void enterAppRegisterEmail()
{
	WebElement element=null;
	String e_Mail=null;
	try
	{
		element=HomePage.getInstance().product_AppLogin_RegisterNow_Email(driver);
		String domain=GlobalVar.TEST_DATA.get("Register_Email_Address");
		String fName=GlobalVar.TEST_DATA.get("Register_firstName");
		String lName=GlobalVar.TEST_DATA.get("Register_lastName");
		
		e_Mail=Keywords.getRandomizedString(fName, lName, domain);
		Keywords.typeText(element,e_Mail);
		
		if (GlobalVar.etpStepsReport) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Register Email ID typed succefully. :: <b>"+e_Mail+"</b>","PASS","Email ID name should be entered.");
		} 
		else 
		{
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Register Email ID not typed.", "FAIL","Email ID should be typed.");
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
		DriverSession.getLastExecutionReportingInstance().teststepreporting("Exception occured : ", "FAIL",e.toString());
	}
}

public void enterAppRegisterPassword()
{
	WebElement element=null;
	try
	{
		element=HomePage.getInstance().product_AppLogin_RegisterNow_Password(driver);
		
		Keywords.typeText(element,GlobalVar.TEST_DATA.get("Register_Password"));
		Keywords.hideKeyBoard();
		if (GlobalVar.etpStepsReport) 
		{
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Register Password typed succefully. :: <b>"+GlobalVar.TEST_DATA.get("Register_Password")+"</b>","PASS","Email ID name should be entered.");
		} 
		else 
		{
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Register Password not typed.", "FAIL","Email ID should be typed.");
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
		DriverSession.getLastExecutionReportingInstance().teststepreporting("Exception occured : ", "FAIL",e.toString());
	}
}

public void enterAppRegisterConfirmPassword()
{
	WebElement element=null;
	try
	{
		if(HomePage.getInstance().product_AppLogin_RegisterNow_ConfirmPassword(driver).isDisplayed()){
			
		element=HomePage.getInstance().product_AppLogin_RegisterNow_ConfirmPassword(driver);
		Keywords.typeText(element,GlobalVar.TEST_DATA.get("Register_ConfirmPassword"));
		Keywords.hideKeyBoard();
		}else{
			
			Keywords.hideKeyBoard();
			element=HomePage.getInstance().product_AppLogin_RegisterNow_ConfirmPassword(driver);
			Keywords.typeText(element,GlobalVar.TEST_DATA.get("Register_ConfirmPassword"));
			
		}
		if (GlobalVar.etpStepsReport) 
		{
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Register Confirm Password typed succefully. :: <b>"+GlobalVar.TEST_DATA.get("Register_ConfirmPassword")+"</b>","PASS","Email ID name should be entered.");
		} 
		else 
		{
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Register Confirm Password not typed.", "FAIL","Email ID should be typed.");
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
		DriverSession.getLastExecutionReportingInstance().teststepreporting("Exception occured : ", "FAIL",e.toString());
	}
}

public void clickOnCreateAccount() 
{

	WebElement createAccount=null;	
	try
	{
		createAccount=HomePage.getInstance().product_AppLogin_RegisterNow_CreateAccount(driver);
		Keywords.click(createAccount);
		Keywords.explicitWait(5);
		if(GlobalVar.etpStepsReport)
		{
			
			 DriverSession.getLastExecutionReportingInstance().teststepreporting(" Clicked on Create Account Link  ","PASS"," Should click on  CreateAccount  Link");

		}
		else
		{

			DriverSession.getLastExecutionReportingInstance().teststepreporting("Not Clicked on Create Account Link  ","FAIL"," Should click on  Create Account  Link");

		}
	}
	catch(Exception e)
		{
			e.printStackTrace();
		}
		
}

public void clickOnForgotPassword() 
{

	WebElement forgotPassword=null;	
	try
	{
		forgotPassword=HomePage.getInstance().product_AppLogin_ForgotPassword(driver);
		Keywords.click(forgotPassword);
		if(GlobalVar.etpStepsReport)
		{
			
			 DriverSession.getLastExecutionReportingInstance().teststepreporting(" Clicked on Forgot Password Link  ","PASS"," Should click on  CreateAccount  Link");

		}
		else
		{

			DriverSession.getLastExecutionReportingInstance().teststepreporting("Not Clicked on Forgot Password Link  ","FAIL"," Should click on  Create Account  Link");

		}
	}
	catch(Exception e)
		{
			e.printStackTrace();
		}
		
}

public void enterAppForgotPasswordEmailID()
{
	WebElement element=null;
	try
	{
		element=HomePage.getInstance().product_AppLogin_ForgotPassword_EmailID(driver);
		
		Keywords.typeText(element,GlobalVar.TEST_DATA.get("AppLogin_Email_Address"));
		
		if (GlobalVar.etpStepsReport) 
		{
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Email ID typed succefully. :: ", "PASS","Email ID name should be entered.");
		} 
		else 
		{
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Email ID not typed.", "FAIL","Email ID should be typed.");
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
		DriverSession.getLastExecutionReportingInstance().teststepreporting("Exception occured : ", "FAIL",e.toString());
	}
}

public void clickOnForgotPasswordSubmitButton() 
{

	WebElement forgotPasswordSubmitButton=null;	
	try
	{
		forgotPasswordSubmitButton=HomePage.getInstance().product_AppLogin_ForgotPassword(driver);
		Keywords.click(forgotPasswordSubmitButton);
		if(GlobalVar.etpStepsReport)
		{
			
			 DriverSession.getLastExecutionReportingInstance().teststepreporting(" Clicked on Forgot Password Submit Link  ","PASS"," Should click on  CreateAccount  Link");

		}
		else
		{

			DriverSession.getLastExecutionReportingInstance().teststepreporting("Not Clicked on Forgot Password Submit Link  ","FAIL"," Should click on  Create Account  Link");

		}
	}
	catch(Exception e)
		{
			e.printStackTrace();
		}
		
}

public void verifyTextOnPage(String text) {
	boolean textFound = false;
	text=text+"";
	WebElement leaf=null;
	WebElement check_SignOut=null;
	try {
		textFound = driver.getPageSource().contains(text);
		Keywords.explicitWait(7);
		
		if (GlobalVar.etpStepsReport){
			DriverSession.getLastExecutionReportingInstance().teststepreporting(text + "  Text is verified successfully .<b><i>"+text+"</i></b>", "PASS", "Text should be verified.");
		} 
		else{
			DriverSession.getLastExecutionReportingInstance().teststepreporting(text + "  Text is not verified.", "FAIL","Text should be verified.");
		}
		
	} 
	catch (Exception e) 
	{
		DriverSession.getLastExecutionReportingInstance().teststepreporting(text + "  Text not verified.", "PASS","Text should not be verified.");
	}
}


public void validateProductDetailPage() {
	
	try{
		 this.testData = GlobalVar.TEST_DATA;
		WebElement productPages = HomePage.getInstance().productPage(driver);
		Keywords.validateElementExistOrNot(productPages);
		if (GlobalVar.etpStepsReport) {
			DriverSession.getLastExecutionReportingInstance()
					.teststepreporting("ShopClues ProductDetailPage verified successfully", "PASS",
							"ShopClues ProductDetailPage should be verified");

		} else {
			DriverSession.getLastExecutionReportingInstance()
					.teststepreporting("ShopClues ProductDetailPage doesnot verified successfully", "FAIL",
							"ShopClues Home Page should be verified");
		}
	}
	catch(Exception e){
		e.printStackTrace();
	}
}


public void validateAddToCart() {
	
	try{
		 this.testData = GlobalVar.TEST_DATA;
		WebElement cartValidate=HomePage.getInstance().addCartButtonValidate(driver);
		Keywords.validateElementExistOrNot(cartValidate);
		if (GlobalVar.etpStepsReport) {
			DriverSession.getLastExecutionReportingInstance()
					.teststepreporting("Availability of AddToCart button verified successfully", "PASS",
							"Availability of AddToCart button should be verified");

		} else {
			DriverSession.getLastExecutionReportingInstance()
					.teststepreporting("Availability of AddToCart button doesnot verified successfully", "FAIL",
							"Availability of AddToCart button should be verified");
		}
		
	}
	catch(Exception e){
		
	}
}

public void verifyQualityField() {
	
	try{
		 this.testData = GlobalVar.TEST_DATA;
		WebElement existanceofQualityField=HomePage.getInstance().qualityFieldExistance(driver);
		Keywords.validateElementExistOrNot(existanceofQualityField);
		if (GlobalVar.etpStepsReport) {
			DriverSession.getLastExecutionReportingInstance()
					.teststepreporting("Quantity Field is visible successfully", "PASS",
							"Quantity Field should be visible successfully");

		} else {
			DriverSession.getLastExecutionReportingInstance()
					.teststepreporting("Quantity Field does not visible successfully", "FAIL",
							"Quantity Field should be visible successfully");
		}
	}
	catch(Exception e){
		e.printStackTrace();
	}
}

public void verifyQualityDropDownValue(){
	try{
		this.testData=GlobalVar.TEST_DATA;
		WebElement verifyDropDown=HomePage.getInstance().qualityFieldExistance(driver);
		String qtyText=Keywords.getText(verifyDropDown);
		Keywords.verifyTextfromDropDown(verifyDropDown, qtyText);
		
		if (GlobalVar.etpStepsReport) {
			DriverSession.getLastExecutionReportingInstance()
					.teststepreporting("Default name<b> "+ verifyDropDown.getText()+"</b> is successfully Visible", "PASS",
							"Default name<b> "+ verifyDropDown.getText()+"</b> should be visible successfully");

		} else {
			DriverSession.getLastExecutionReportingInstance()
					.teststepreporting("Default name<b> "+ verifyDropDown.getText()+"</b> does not visible successfully", "FAIL",
							"Default name<b> "+ verifyDropDown.getText()+"</b> should be visible successfully");
		}
	}
	catch(Exception e){
		e.printStackTrace();
	}
}


public void verifyShoppingCart() {

	try{
		this.testData=GlobalVar.TEST_DATA;
		WebElement vShoppingCart=HomePage.getInstance().shoppingCart(driver);
		Keywords.validateElementExistOrNot(vShoppingCart);
		if (GlobalVar.etpStepsReport) {
			DriverSession.getLastExecutionReportingInstance()
					.teststepreporting("Shopping Cart is visible successfully", "PASS",
							"Shopping Cart should be visible successfully");

		} else {
			DriverSession.getLastExecutionReportingInstance()
					.teststepreporting("Shopping Cart does not visible successfully", "FAIL",
							"Shopping Cart should be visible successfully");
		}
	}
	catch(Exception e){
		e.printStackTrace();
	}
}


public void verifyShoppingCartQuantity() {

	
	try{
		this.testData=GlobalVar.TEST_DATA;
		WebElement vShoppingCart=HomePage.getInstance().getCartCounter(driver);
		String cartUnit1=Keywords.verifyTextfromDropDown(vShoppingCart,"0");
		GlobalVar.productCartInitialValue=cartUnit1;
		
		if (GlobalVar.etpStepsReport) {
			DriverSession.getLastExecutionReportingInstance()
					.teststepreporting("Shopping Cart is ZERO ", "PASS",
							"Shopping Cart should be ZERO");

		} else {
			DriverSession.getLastExecutionReportingInstance()
					.teststepreporting("Shopping Cart does not appear zero", "FAIL",
							"Shopping Cart should be ZERO");
		}

	}catch(Exception e){
		e.printStackTrace();
	}
}

public void verifyShoppingCartAfterAddtoCart() {
	try{
		this.testData=GlobalVar.TEST_DATA;
		
		int rangeofCart1=Integer.valueOf(GlobalVar.productCartInitialValue);
		WebElement AddToCart=HomePage.getInstance().addCartButtonValidate(driver);
		AddToCart.click();
		
		WebElement secCartValue=HomePage.getInstance().getCartCounter(driver);
		String cartUnit2=Keywords.getText(secCartValue);
		GlobalVar.productAddToCartValue=cartUnit2;
		
		int rangeofCart2=Keywords.getCartValue(secCartValue);
		WebElement pPage=HomePage.getInstance().productPage(driver);
		
		if((rangeofCart1<rangeofCart2) && pPage.isDisplayed()!=false){				// check
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Shopping Cart is incremented by <b> "+rangeofCart2+"", "PASS",
					"Shopping Cart should be incremented by <b> "+rangeofCart2);
		}else {
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Shopping Cart counter doesnot increments ", "FAIL",
					"Shopping Cart should be incremented");
		}
		
	}catch(Exception e){
		e.printStackTrace();
	}
	
}

public void validateShoppingCartafterIncrementingQuality() {
	
	try{
		this.driver = GlobalVar.driver;
		this.testData = GlobalVar.TEST_DATA;
		String qtyNo=GlobalVar.TEST_DATA.get("Product_UpdateQty");		
		
		WebElement clickToQuality=HomePage.getInstance().qualityFieldExistance(driver);
		clickToQuality.click();
		Keywords.explicitWait(1);
		
		List<WebElement> al=HomePage.getInstance().getNoOfQuantities(driver);
		Keywords.clickByText(al, qtyNo);  
		
		Keywords.explicitWait(1);
		WebElement clickCart=HomePage.getInstance().addCartButtonValidate(driver);
		Keywords.click(clickCart);
		WebElement CartValue=HomePage.getInstance().getCartCounter(driver);
		String count=Keywords.getText(CartValue);
		
		if(GlobalVar.etpStepsReport){		
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Shopping Cart is incremented successfully after selecting from Quantity DropDown and Product successfully added to cart by <b> "+count+" ", "PASS",
					"Shopping Cart should be incremented after selecting from Quantity DropDown by <b> "+count);
		}else {
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Shopping Cart is not incremented after selecting from Quantity DropDown ", "FAIL",
					"Shopping Cart should not be incremented after selecting from Quantity DropDown by <b> "+count);
		}
		
	}catch(Exception e){
		e.printStackTrace();
	}
}


public void validateQtyfromShoppingCart() {
	
	try{
		this.testData=GlobalVar.TEST_DATA;
		WebElement clickCart=HomePage.getInstance().shoppingCart(driver);
		Keywords.click(clickCart);
		
		WebElement pQty=HomePage.getInstance().getProductQuantity(driver);
		WebElement pAmt=HomePage.getInstance().getProductRate(driver);
		
		String totalQty=Keywords.getText(pQty);
		GlobalVar.AddToCart_ProdQty=totalQty;
		
		
		int expectedValue=Keywords.expectedCalculation(GlobalVar.productCartInitialValue,GlobalVar.AddToCart_ProdQty);
		//System.out.println("expected value : "+expectedValue);
		
		int shopingCartValue=Integer.parseInt(GlobalVar.AddToCart_ProdQty);
		//System.out.println("shopping cart value : "+shopingCartValue);
		
		if(shopingCartValue==expectedValue){
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Shopping Cart Quantity is successfully validated by <b> "+shopingCartValue+"", "PASS",
					"Shopping Cart Quantity should be successfully validated by <b> "+shopingCartValue);
		}else {
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Shopping Cart Quantity doesnot successfully validated ", "FAIL",
					"Shopping Cart Quantity should be successfully validated by <b> "+shopingCartValue);
		}	
	}
	catch(Exception e){
		e.printStackTrace();
	}
}

public void validateShoppingCartTotalAmouont() {
	
	try{
		WebElement pQty=HomePage.getInstance().getProductQuantity(driver);
		WebElement pAmt=HomePage.getInstance().getProductRate(driver);
		
		float cartTotal=Keywords.verifyShoppingCartPageDetails(pQty, pAmt);
		
		WebElement element=HomePage.getInstance().clickOnQTY(driver);
		Keywords.click(element);
		
		if(GlobalVar.etpStepsReport){
			DriverSession.getLastExecutionReportingInstance()
			 .teststepreporting("Shopping Cart Total amount is successfully validated is "+cartTotal, "PASS",
					"Shopping Cart Total amount should be successfully validated ");

		} else {
				DriverSession.getLastExecutionReportingInstance()
					.teststepreporting("Shopping Cart Total amount is not successfully validated", "FAIL",
						"Shopping Cart Total amount should be successfully validated");
			}
		
	}
	catch(Exception e){
		e.printStackTrace();
	}
}

public void validateQtyFromProductPage() {
	
	try{
		this.driver = GlobalVar.driver;
		this.testData = GlobalVar.TEST_DATA;
		String qtyNo=GlobalVar.TEST_DATA.get("Product_Quantity");
		
		WebElement existanceofQualityField=HomePage.getInstance().qualityFieldExistance(driver);
		Keywords.click(existanceofQualityField);
		Keywords.explicitWait(1);
		List<WebElement> al=HomePage.getInstance().getNoOfQuantities(driver);
		Keywords.clickByText(al, qtyNo);		
		
		WebElement cart_Count=HomePage.getInstance().getCartCounter(driver);
		String count=Keywords.getText(cart_Count);
	
		WebElement buyNow=HomePage.getInstance().clickOn_BuyNowButton(driver);
		Keywords.click(buyNow);
		
		if(GlobalVar.etpStepsReport){
			DriverSession.getLastExecutionReportingInstance()
			 .teststepreporting("Product Quantity Page option is successfully Clicked and Shopping Cart Count  is "+count+"", "PASS",
					"Product Quantity Page option should be successfully validated ");

		} else {
				DriverSession.getLastExecutionReportingInstance()
					.teststepreporting("Product Quantity Page option should not successfully validated", "FAIL",
						"Product Quantity Page option should be successfully validated ");
			}
		
	}
	catch(Exception e){
		e.printStackTrace();
	}
}

public void validateShoppingCartPage() {
	
	try{
		this.driver = GlobalVar.driver;
		this.testData = GlobalVar.TEST_DATA;
		
		WebElement cart_Check=HomePage.getInstance().getCartCounter(driver);
		String count=Keywords.getText(cart_Check);
		
		WebElement shopping_Cart=HomePage.getInstance().shoppingCart_Banner(driver);
		Keywords.validateElementExistOrNot(shopping_Cart);
		
		if(GlobalVar.etpStepsReport){
			if(GlobalVar.etpStepsReport){
				DriverSession.getLastExecutionReportingInstance()
				 .teststepreporting("Shopping Cart Page is successfully Validated and Cart incremented to "+count+" ", "PASS",
						"Shopping Cart Page should be successfully validated ");

			} else {
					DriverSession.getLastExecutionReportingInstance()
						.teststepreporting("Shopping Cart Page should not be successfully validated ed", "FAIL",
							"Shopping Cart Page should be successfully validated ");
				}
		}
	}
	catch(Exception e){
		e.printStackTrace();
	}
}

public void verifyShoppingPageQuantity() {
	
	try{
		this.driver = GlobalVar.driver;
		this.testData = GlobalVar.TEST_DATA;
		String qtyNo=GlobalVar.TEST_DATA.get("Product_Quantity");
		
		WebElement getQty=HomePage.getInstance().getProductQuantity(driver);
		String actualQty=Keywords.getText(getQty);
		
		if(qtyNo.equalsIgnoreCase(actualQty)){
				DriverSession.getLastExecutionReportingInstance()
				 .teststepreporting("Shopping Cart Product Quantity is successfully Validated  ", "PASS",
						"Shopping Cart Product Quantity should be successfully validated ");

			} else {
					DriverSession.getLastExecutionReportingInstance()
						.teststepreporting("Shopping Cart Product Quantity should not be successfully validated ed", "FAIL",
							"Shopping Cart Product Quantity should be successfully validated ");
				}
		}
	catch(Exception e){
		e.printStackTrace();
	}
}

public void verifyShoppingPagePrice() {

	try{
		
		this.driver = GlobalVar.driver;
		this.testData = GlobalVar.TEST_DATA;
		String pMRP=GlobalVar.TEST_DATA.get("Product_Rate");
		
		WebElement pPrice=HomePage.getInstance().getProductRate(driver);
		String prodPrice=Keywords.getText(pPrice);
		
		if(pMRP.equalsIgnoreCase(prodPrice)){
			DriverSession.getLastExecutionReportingInstance()
			 .teststepreporting("Shopping Cart Product MRP is successfully Validated  ", "PASS",
					"Shopping Cart Product MRP should be successfully validated ");

		} else {
				DriverSession.getLastExecutionReportingInstance()
					.teststepreporting("Shopping Cart Product MRP should not be successfully validated ed", "FAIL",
						"Shopping Cart Product MRP should be successfully validated ");
			}
		}
	catch(Exception e){
		e.printStackTrace();
	}
	
	
	
}

public void validateShoppingCartTotal() {
	
	try{
		this.driver = GlobalVar.driver;
		this.testData = GlobalVar.TEST_DATA;
		
		WebElement pQty=HomePage.getInstance().getProductQuantity(driver);
		WebElement pAmt=HomePage.getInstance().getProductRate(driver);
		
		float cartTotal=Keywords.verifyShoppingCartPageDetails(pQty, pAmt);
		WebElement grandTotal=HomePage.getInstance().getGrandTotalAmount(driver);
		float actualGTotal=Keywords.floatParser(grandTotal);
		
		if(cartTotal==actualGTotal && GlobalVar.etpStepsReport){ 
			DriverSession.getLastExecutionReportingInstance()
			 .teststepreporting("Shopping Cart Product GrandTotal is successfully Validated  <b>"+cartTotal+"</b>", "PASS",
					"Shopping Cart Product GrandTotal should be successfully validated ");

		} else {
				DriverSession.getLastExecutionReportingInstance()
					.teststepreporting("Shopping Cart Product GrandTotal should not be successfully validated ed", "FAIL",
						"Shopping Cart Product GrandTotal should be successfully validated ");
		}
		
	}
	catch(Exception e){
		e.printStackTrace();
	}
}

public void validatePlaceOrderButton() {
	
	try{
		this.driver=GlobalVar.driver;
		this.testData=GlobalVar.TEST_DATA;
		
		WebElement placeOrder=PlaceOrder.getInstance().clickAndValidatePlaceOdrButton(driver);
		Keywords.validateElementExistOrNot(placeOrder);
		Keywords.click(placeOrder);
		if(GlobalVar.etpStepsReport){
			DriverSession.getLastExecutionReportingInstance()
			 .teststepreporting("Place Order Button is successfully Validated and Clicked  ", "PASS",
					"Place Order Button should be successfully Validated and Clicked ");

		} else {
				DriverSession.getLastExecutionReportingInstance()
					.teststepreporting("Place Order Button should not be be successfully Validated and Clicked", "FAIL",
						"Place Order Button should be successfully Validated and Clicked ");
		}
	}
	catch(Exception e){
		e.printStackTrace();
	}
}

public void validateSingInPage() {
	
	try{
		WebElement signIn=PlaceOrder.getInstance().fetchSignInPage(driver);
		Keywords.validateElementExistOrNot(signIn);
		Keywords.explicitWait(4);
		if(GlobalVar.etpStepsReport){
			DriverSession.getLastExecutionReportingInstance()
			 .teststepreporting("Sign-In Page is successfully Loaded and Validated  ", "PASS",
					"Sign-In Page should be successfully Loaded and Validated ");

		} else {
				DriverSession.getLastExecutionReportingInstance()
					.teststepreporting("Sign-In Page should not be Loaded and Validated", "FAIL",
						"Sign-In Page should be successfully Loaded and Validated ");
		}
	}
	catch(Exception e){
		e.printStackTrace();
	}
}
public void verifyShippingAddress() {
	
	try{
	this.testData=GlobalVar.TEST_DATA;
	this.driver=GlobalVar.driver;

	
	String u_Phno=GlobalVar.TEST_DATA.get("user_PhoneNumber");
	String city=GlobalVar.TEST_DATA.get("city/State");
	String user_Pincode=GlobalVar.TEST_DATA.get("userPinCode");
	
	WebElement ph_No=PlaceOrder.getInstance().getUserPhoneNumber(driver);
	WebElement city_State=PlaceOrder.getInstance().user_City_State(driver);
	WebElement pin=PlaceOrder.getInstance().user_PinCode(driver);
	
	List<String>al=Keywords.validatCredentials(ph_No,city_State,pin);
	
	if(u_Phno.equalsIgnoreCase(ph_No.getText()) && (city.equalsIgnoreCase(city_State.getText())
				&& (user_Pincode.equalsIgnoreCase(pin.getText())))){
		
		DriverSession.getLastExecutionReportingInstance()
		 .teststepreporting("Shipping Address is successfully Verified By<b> "+ph_No.getText()+" "+city_State.getText()+"  "+pin.getText(), "PASS",
				"Sign-In Page should be successfully Loaded and Validated ");

	} else {
			DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("Shipping Address is successfully Verified should not be Loaded and Validated", "FAIL",
					"Sign-In Page should be successfully Loaded and Validated ");
	}
	
	}
	catch(Exception e){
		e.printStackTrace();
	}
}
	public void clickContinue() {
		
		try{
			WebElement contnue=PlaceOrder.getInstance().clickContinue(driver);
			Keywords.click(contnue);
			if(GlobalVar.etpStepsReport){
				DriverSession.getLastExecutionReportingInstance()
				 .teststepreporting("Continue Button Successfully Clicked  ", "PASS",
						"Continue Button should be successfully Clicked ");

			} else {
					DriverSession.getLastExecutionReportingInstance()
						.teststepreporting("Continue Button should not be Clicked", "FAIL",
							"Continue Button should be successfully Clicked ");
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	
}

	public void verifyTextDate() {
		
		
		try{
		Keywords.waitForPage(driver);
		WebElement home_Banner=HomePage.getInstance().getHomeBanner(driver);
		Keywords.validateElementExistOrNot(home_Banner);
		if(GlobalVar.etpStepsReport){
			DriverSession.getLastExecutionReportingInstance()
			 .teststepreporting("Login Successfully Done  ", "PASS",
					"Login should be successfully Done ");

		} else {
				DriverSession.getLastExecutionReportingInstance()
					.teststepreporting("Login unsuccessfull ", "FAIL",
						"Login should be successfully Done ");
		}
		}
		catch(Exception e){e.printStackTrace();}
	}

	public void clickCatagory() {
		
		try{
			this.testData=GlobalVar.TEST_DATA;
			this.driver=GlobalVar.driver;
			String cat=GlobalVar.TEST_DATA.get("MenuProductName");
			
			List<WebElement> click_Catalog=HomePage.getInstance().clickShopclues_Menu(driver);
			Keywords.clickByText(click_Catalog, cat);
			if(GlobalVar.etpStepsReport){
				DriverSession.getLastExecutionReportingInstance()
				 .teststepreporting("Shop By Catagory is successfully clicked  ", "PASS",
						"Shop By Catagory should be successfully clicked ");

			} else {
					DriverSession.getLastExecutionReportingInstance()
						.teststepreporting("Shop By Catagory is not clicked successfully ", "FAIL",
							"Shop By Catagory should be successfully clicked ");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public void shopByCategory() {
		try{
			this.testData=GlobalVar.TEST_DATA;
			this.driver=GlobalVar.driver;
			
			String catg=GlobalVar.TEST_DATA.get("MenuProductName1");
			List<WebElement> click_Catalog=HomePage.getInstance().click_CategoryItems(driver);
			Keywords.clickByText(click_Catalog, catg);
			if(GlobalVar.etpStepsReport){
				DriverSession.getLastExecutionReportingInstance()
				 .teststepreporting("Shop By Catagory to <b>"+catg+"</b> is successfully clicked  ", "PASS",
						"Shop By Catagory should be successfully clicked ");

			} else {
					DriverSession.getLastExecutionReportingInstance()
						.teststepreporting("Shop By Catagory is not clicked successfully ", "FAIL",
							"Shop By Catagory should be successfully clicked ");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public void click_StorageDevice() {
		
		try{
			this.testData=GlobalVar.TEST_DATA;
			this.driver=GlobalVar.driver;
			String catg=GlobalVar.TEST_DATA.get("MenuProductName2");
			List<WebElement>al=HomePage.getInstance().getNoOfObjects(driver);
			Keywords.clickByText(al, catg);
			
			WebElement search_Bar=HomePage.getInstance().clickToSearchBar(driver);
			Keywords.click(search_Bar);
			
			WebElement sendKey=HomePage.getInstance().getTextBox(driver);
			Keywords.clearEditField(sendKey);
			
			String typTxt=GlobalVar.TEST_DATA.get("SelectPendriveName");
			Keywords.typeText(sendKey,typTxt);
			
			WebElement go_Button=HomePage.getInstance().clickTo_Go_Button(driver);
			Keywords.click(go_Button);
			Keywords.explicitWait(7);
			if(GlobalVar.etpStepsReport){
				DriverSession.getLastExecutionReportingInstance()
				 .teststepreporting("Shop By Catagory item <b>"+typTxt+"</b> is successfully searched and clicked  ", "PASS",
						"Shop By Catagory should be successfully clicked ");

			} else {
					DriverSession.getLastExecutionReportingInstance()
						.teststepreporting("Shop By Catagory is not searched successfully ", "FAIL",
							"Shop By Catagory should be successfully clicked ");
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public void validateSearchProduct() {
	
		try{
			String expectedProd=GlobalVar.TEST_DATA.get("SelectPendriveName");
			List<WebElement> actualProd=HomePage.getInstance().getSearchedProdName(driver);
			Keywords.validateSingleElementWithMultiple(actualProd, expectedProd);
			if(GlobalVar.etpStepsReport){
				DriverSession.getLastExecutionReportingInstance()
				 .teststepreporting("In Shop By Catagory item<b>"+expectedProd+"</b> is successfully verified  ", "PASS",
						"In Shop By Catagory item<b>"+expectedProd+"</b> should be successfully verified ");

			} else {
					DriverSession.getLastExecutionReportingInstance()
						.teststepreporting("Shop By Catagory is not searched successfully ", "FAIL",
								"In Shop By Catagory item <b>"+expectedProd+" </b> should be successfully verified ");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public void clickItem() {
	
		WebElement element=HomePage.getInstance().click_SelectedItem(driver);
		Keywords.click(element);
		if(GlobalVar.etpStepsReport){
			DriverSession.getLastExecutionReportingInstance()
			 .teststepreporting("Item is successfully clicked  ", "PASS",
					"Item should be successfully clicked ");

		} else {
				DriverSession.getLastExecutionReportingInstance()
					.teststepreporting("Item is not Clicked successfully ", "FAIL",
							"Item should be successfully clicked ");
		}
		
		
	}

	public void clickToShoppingCart() {
	
		try{
			WebElement clickCart=HomePage.getInstance().click_ShoppingCart(driver);
			Keywords.click(clickCart);
			if(GlobalVar.etpStepsReport){
				DriverSession.getLastExecutionReportingInstance()
				 .teststepreporting("Shopping Cart successfully clicked  ", "PASS",
						"Shopping Cart should be successfully clicked ");

			} else {
					DriverSession.getLastExecutionReportingInstance()
						.teststepreporting("Shopping Cart is not Clicked successfully ", "FAIL",
								"Shopping Cart should be successfully clicked ");
			}
		}
		catch(Exception e){
			e.getMessage();
		}
	}

	public void validateDeleteButton() {
		
		try{
			WebElement cart_Banner=HomePage.getInstance().getShoppingCartDeleteButton(driver);
			Keywords.validateElementExistOrNot(cart_Banner);
			if(GlobalVar.etpStepsReport){
				DriverSession.getLastExecutionReportingInstance()
				 .teststepreporting("Shopping Cart Delete Button is successfully visible  ", "PASS",
						"Shopping Cart Delete Button should be successfully visible ");

			} else {
					DriverSession.getLastExecutionReportingInstance()
						.teststepreporting("Shopping Cart Delete Button is not Visible successfully ", "FAIL",
								"Shopping Cart Delete Button should be successfully visible ");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public void clickToDeleteButton() {
		
		try{
			String expected_Prod=GlobalVar.TEST_DATA.get("SearchTextName");
			WebElement prod_Name=HomePage.getInstance().getProdID(driver);
			String actual_Prod=Keywords.getText(prod_Name);
			
			if(expected_Prod.equalsIgnoreCase(actual_Prod)){
				WebElement delete_Item=HomePage.getInstance().getShoppingCartDeleteButton(driver);
				Keywords.click(delete_Item);
				
				DriverSession.getLastExecutionReportingInstance()
				 .teststepreporting("Shopping Cart Delete Button is successfully clicked  ", "PASS",
						"Shopping Cart Delete Button should be successfully clicked ");
			}
			else{
				DriverSession.getLastExecutionReportingInstance()
				 .teststepreporting("Shopping Cart Delete Button is not successfully clicked  ", "FAIL",
						"Shopping Cart Delete Button should be successfully clicked ");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public void verifyItemInsideShoppingCart() {
	
		try{
			WebElement validate_Prod=HomePage.getInstance().getInsideCartValue(driver);
			Keywords.validateElementExistOrNot(validate_Prod);
			
			DriverSession.getLastExecutionReportingInstance()
			 .teststepreporting("Shopping Cart Item is not Deleted successfully  ", "FAIL",
					"Shopping Cart Item should be successfully Deleted ");
			
		}
		catch(Exception e){
			
			DriverSession.getLastExecutionReportingInstance()
			 .teststepreporting("Shopping Cart Item is Deleted successfully  ", "PASS",
					"Shopping Cart Item should be successfully Deleted ");
		}
	}

	public void validateHomePageLogin() {
		
		try{
			WebElement clues_Logo=HomePage.getInstance().shopclues_HomeLogo(driver);
			Keywords.validateElementExistOrNot(clues_Logo);
			if(GlobalVar.etpStepsReport){
				DriverSession.getLastExecutionReportingInstance()
				 .teststepreporting("Shopclues Home Page is successfully visible and Validated ", "PASS",
						"Shopclues Home Page should be successfully visible and Validated ");

			} else {
					DriverSession.getLastExecutionReportingInstance()
						.teststepreporting("Shopclues Home Page is not successfully visible and Validated ", "FAIL",
								"Shopclues Home Page should be successfully visible and Validated ");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public void clickToLoginSection() {
	
		try{
			WebElement click_Dots=HomePage.getInstance().click_DotsOption(driver);
			Keywords.click(click_Dots);
			WebElement clickLogin=HomePage.getInstance().click_ToLogin(driver);
			Keywords.click(clickLogin);
			if(GlobalVar.etpStepsReport){
				DriverSession.getLastExecutionReportingInstance()
				 .teststepreporting("Shopclues Home Page Login Button is successfully Clicked and Validated ", "PASS",
						"Shopclues Home Page Login Button should be successfully Clicked and Validated ");

			} else {
					DriverSession.getLastExecutionReportingInstance()
						.teststepreporting("Shopclues Home Page Login Button is not successfully visible and Validated ", "FAIL",
								"Shopclues Home Page Login Button should be successfully Clicked and Validated ");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public void validateSignInPageLogo() {
		try{
			WebElement validat_SignIn=SignInPage.getInstance().SignIn_HomePage(driver);
			Keywords.validateElementExistOrNot(validat_SignIn);
			if(GlobalVar.etpStepsReport){
				DriverSession.getLastExecutionReportingInstance()
				 .teststepreporting("Shopclues Home Page Sign-In is successfully Validated ", "PASS",
						"Shopclues Home Page Sign-In should be successfully Validated ");

			} else {
					DriverSession.getLastExecutionReportingInstance()
						.teststepreporting("Shopclues Home Page Sign-In is not successfully Validated ", "FAIL",
								"Shopclues Home Page Sign-In should be successfully Validated ");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public void loginEmailField() {
		
		WebElement userName=null;
		String uName=null;
		try{
			userName=SignInPage.getInstance().userNameTextField(driver);
			uName=GlobalVar.TEST_DATA.get("User_Name");
			Keywords.clearEditField(userName);
			Keywords.typeText(userName, uName);
			if(GlobalVar.etpStepsReport){
				DriverSession.getLastExecutionReportingInstance()
				 .teststepreporting("Email <b><i><u>"+uName+"</i></u></b> is successfully entered into EmailTextField", "PASS",
						"Email should be successfully Entered ");

			} else {
					DriverSession.getLastExecutionReportingInstance()
						.teststepreporting("Email <b>"+uName+"</b> is not successfully Validated ", "FAIL",
								"Email should be successfully Entered ");
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public void loginPasswordField() {
	
		WebElement pass=null;
		String uPass=null;
		try{
			pass=SignInPage.getInstance().passwordTextField(driver);
			//uPass=GlobalVar.TEST_DATA.get("Password");
			uPass=Keywords.getChangePasswordProperties("New_Password");
			Keywords.clearEditField(pass);
			Keywords.typeText(pass, uPass);
			if(GlobalVar.etpStepsReport){
				DriverSession.getLastExecutionReportingInstance()
				 .teststepreporting("Password <b><i><u>"+uPass+"</i></u></b> is successfully entered into PasswordTextField", "PASS",
						"Email should be successfully Entered ");

			} else {
					DriverSession.getLastExecutionReportingInstance()
						.teststepreporting("Password <b>"+uPass+"</b> is not successfully Validated ", "FAIL",
								"Email should be successfully Entered ");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public void clickLoginButton() {
		WebElement login=null;
		try{
			login=SignInPage.getInstance().clickTo_Login(driver);
			Keywords.click(login);
			if(GlobalVar.etpStepsReport){
				DriverSession.getLastExecutionReportingInstance()
				 .teststepreporting("Shopclues Home Page Login Button is successfully Clicked ", "PASS",
						"Shopclues Home Page Login Button should be successfully Clicked ");

			} else {
					DriverSession.getLastExecutionReportingInstance()
						.teststepreporting("Shopclues Home Page LoginButton is not successfully Clicked ", "FAIL",
								"Shopclues Home Page LoginButton should be successfully Clicked ");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public void verifyViewProfile() {
	
		WebElement click_Dot=null;
		WebElement view_Prof=null;
		try{
			click_Dot=SignInPage.getInstance().clickTo_DotMenu(driver);
			Keywords.click(click_Dot);
			view_Prof=SignInPage.getInstance().clickViewprofile(driver);
			Keywords.validateElementExistOrNot(view_Prof);
			if(GlobalVar.etpStepsReport){
				DriverSession.getLastExecutionReportingInstance()
				 .teststepreporting("Shopclues HomePage Login <b><i><u>View Profile</i></u></b> is Visible successfully in DropDown  ", "PASS",
						"Shopclues HomePage Login <b>View Profile</b> should be successfully Visible ");

			} else {
					DriverSession.getLastExecutionReportingInstance()
						.teststepreporting("Shopclues HomePage Login <b>View Profile</b> is not successfully Clicked ", "FAIL",
								"Shopclues HomePage Login <b>View Profile</b> should be successfully Visible ");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public void clickAndValidateViewProfile() {
	
		WebElement viewprofile=null;
		WebElement myProfile=null;
		try{
			viewprofile=SignInPage.getInstance().clickViewprofile(driver);
			Keywords.click(viewprofile);
			myProfile=SignInPage.getInstance().clickOn_MyProfile(driver);
			Keywords.validateElementExistOrNot(myProfile);
			if(GlobalVar.etpStepsReport){
				DriverSession.getLastExecutionReportingInstance()
				 .teststepreporting("Shopclues <b><i><u>My Profile</i></u></b> is Visible successfully  ", "PASS",
						"Shopclues <b>My Profile</b> should be successfully Visible ");

			} else {
					DriverSession.getLastExecutionReportingInstance()
						.teststepreporting("Shopclues <b>My Profile</b> is not successfully Loaded ", "FAIL",
								"Shopclues <b>My Profile</b> should be successfully Visible ");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public void validateMyProfileCredentials() {
		
		String u_phone=null;
		String e_ID=null;
		WebElement phone_Field=null;
		WebElement email_Field=null;
		try{
			 u_phone=GlobalVar.TEST_DATA.get("PhoneNumber");
			 e_ID=GlobalVar.TEST_DATA.get("User_Name");
			 phone_Field=SignInPage.getInstance().phoneNo_Field(driver);
			 email_Field=SignInPage.getInstance().email_Field(driver);
			 
			 String asActualPhoneValue=Keywords.getText(phone_Field);
			 String asActualEmailValue=Keywords.getText(email_Field);
			 
			 if((u_phone.equalsIgnoreCase(asActualPhoneValue)) && (e_ID.equalsIgnoreCase(asActualEmailValue))){
				 DriverSession.getLastExecutionReportingInstance()
				 .teststepreporting("Shopclues My Profile PhoneNumber <b><i><u>"+asActualPhoneValue+"</i></u></b> and Email Address "+asActualEmailValue+"is successfully validated  ", "PASS",
						"Shopclues My Profile Phone Number and Email Address should be successfully validated ");
			 }
			 else{
				 DriverSession.getLastExecutionReportingInstance()
				 .teststepreporting("Shopclues My Profile PhoneNumber <b>"+asActualPhoneValue+"</b> and Email Address <b>"+asActualEmailValue+" </b> is not successfully validated  ", "FAIL",
						"Shopclues My Profile Phone Number and Email Address should be successfully validated ");
			 }
			 
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public void validateAllMyProfileField() {
		
		WebElement edit_Button=null;
		WebElement actual_FirstName=null;
		WebElement actual_LastName=null;
		
		String f_Name=null;
		String l_Name=null;
		String p_Name=null;
		String email=null;
		
		try{
			edit_Button=SignInPage.getInstance().clickTo_EditButton(driver);
			Keywords.click(edit_Button);
			actual_FirstName=SignInPage.getInstance().firstName_TextField(driver);
			actual_LastName=SignInPage.getInstance().lastName_TextField(driver);
			WebElement phone_Field=SignInPage.getInstance().phoneNo_TextField(driver);
			WebElement email_Field=SignInPage.getInstance().email_TextField(driver);
			
			f_Name=Keywords.getText(actual_FirstName);
			l_Name=Keywords.getText(actual_LastName);
			p_Name=Keywords.getText(phone_Field);
			email=Keywords.getText(email_Field);
			
			if(
				(f_Name.equalsIgnoreCase(GlobalVar.TEST_DATA.get("First_Name"))) && 
				(l_Name.equalsIgnoreCase(GlobalVar.TEST_DATA.get("Last_Name"))) && 
				(p_Name.equalsIgnoreCase(GlobalVar.TEST_DATA.get("PhoneNumber"))) && 
				(email.equalsIgnoreCase(GlobalVar.TEST_DATA.get("User_Name"))))
				{
				DriverSession.getLastExecutionReportingInstance()
				 .teststepreporting("Shopclues MyProfile First Name <b><i><u>"+f_Name+"</i></u></b> , LastName <b><i><u>"+l_Name+"</i></u></b> , Phone Number <b><i><u>"+p_Name+"</i></u></b> Email Address <b><i><u>"+email+" </i></u></b>is successfully verified  ", "PASS",
						"Shopclues MyProfile FirstName,LastName,Phone Number and Email Address should be successfully validated ");
					}
			else{
				DriverSession.getLastExecutionReportingInstance()
				 .teststepreporting("Shopclues MyProfile First Name <b>"+f_Name+"</b> , LastName <b>"+l_Name+"</b> , Phone Number <b>"+p_Name+"</b> Email Address <b>"+email+" </b>is not successfully verified  ", "FAIL",
						"Shopclues MyProfile FirstName,LastName,Phone Number and Email Address should be successfully validated ");
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public void changeYourPasswordField() {
		
		String new_Pswd=null;
		WebElement current_Password=null;
		WebElement new_Password=null;
		WebElement confirm_Password=null;
		try{
			WebElement change_Password=SignInPage.getInstance().clickTo_ChangePassword(driver);
			Keywords.click(change_Password);
			
			current_Password=SignInPage.getInstance().clickTo_CurrentPassword(driver);
			new_Password=SignInPage.getInstance().clickTo_NewPassword(driver);
			confirm_Password=SignInPage.getInstance().clickTo_ConfirmPassword(driver);
			
			String c_Pass=Keywords.getChangePasswordProperties("New_Password");
			Keywords.typeText(current_Password, c_Pass);
			
			// creates a random password
			new_Pswd=Keywords.getRandomData();
			
			Keywords.typeText(new_Password, new_Pswd);
			Keywords.typeText(confirm_Password, new_Pswd);	
			
			Keywords.setChangePasswordProperties(new_Pswd);
			
			if(
					(new_Password.isDisplayed()==true) && 
						 (confirm_Password.isDisplayed()==true) && (current_Password.isDisplayed()==true)){
						
				DriverSession.getLastExecutionReportingInstance()
				 .teststepreporting("Shopclues Update Password Page : Current Password <b><i><u>"+c_Pass+"</i></u></b> , New Password <b><i><u>"+new_Pswd+"</i></u></b> , Confirm Password <b><i><u>"+new_Pswd+"</i></u></b> is successfully verified  ", "PASS",
						"Shopclues Update Password Page :  Current Password,New Password and Confirm Password should be successfully verified ");
					}
			else{
				DriverSession.getLastExecutionReportingInstance()
				 .teststepreporting("Shopclues Update Password Page : Current Password <b>"+c_Pass+"</b> , New Password <b>"+new_Pswd+"</b> , Confirm Password <b>"+new_Pswd+"</b> is Type Mis-Match   ", "FAIL",
						"Shopclues Update Password Page :  Current Password,New Password and Confirm Password should be successfully verified ");
					}
			Keywords.explicitWait(3);
		}
		catch(Exception e){
			
		}
		
	}

	public void click_SaveButton() {
		
		try{
				WebElement save=SignInPage.getInstance().clickTo_SavePassword(driver);
				Keywords.validateElementExistOrNot(save);
				Keywords.click(save);
				if(GlobalVar.etpStepsReport){
					DriverSession.getLastExecutionReportingInstance()
					 .teststepreporting("Shopclues <b><i><u>SAVE BUTTON</i></u></b> page is successfully Clicked and Verified ", "PASS",
							"Shopclues <b>PAYMENT METHOD</b> page should be successfully validated ");

				} else {
						DriverSession.getLastExecutionReportingInstance()
							.teststepreporting("Shopclues <b>PAYMENT METHOD</b> is not successfully Loaded ", "FAIL",
									"Shopclues <b>PAYMENT METHOD</b> page should be successfully validated ");
				}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}

	public void verifyPaymentMethodPage() {
		WebElement payment_Method=null;
		try{
			this.testData=GlobalVar.TEST_DATA;
			this.driver=GlobalVar.driver;
			payment_Method=PaymentMethod.getInstance().verifyPaymentPage(driver);
			Keywords.validateElementExistOrNot(payment_Method);
			if(GlobalVar.etpStepsReport){
				DriverSession.getLastExecutionReportingInstance()
				 .teststepreporting("Shopclues <b>PAYMENT METHOD</b> page is successfully validated ", "PASS",
						"Shopclues <b>PAYMENT METHOD</b> page should be successfully validated ");

			} else {
					DriverSession.getLastExecutionReportingInstance()
						.teststepreporting("Shopclues <b>PAYMENT METHOD</b> is not successfully Loaded ", "FAIL",
								"Shopclues <b>PAYMENT METHOD</b> page should be successfully validated ");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public void verifyPaymentOptionRadioButton() {
		// TODO Auto-generated method stub
		List<WebElement> radio_Option=null;
		int count=0;
		try{
			radio_Option=PaymentMethod.getInstance().verifyRadioButton(driver);
			ArrayList<String> ar=Keywords.verifyMultipleClickableObjects(radio_Option);
			count=radio_Option.size();
			if(GlobalVar.etpStepsReport){
				DriverSession.getLastExecutionReportingInstance()
				 .teststepreporting("All Shopclues <b>PAYMENT METHOD</b> Option is successfully visible <b><br> (a) "+ar.get(0)+"</b><br><b> (b) "+ar.get(1)+"</b><br><b> (c) "+ar.get(2)+"</b><br><b> (d) "+ar.get(3)+"</b><br><b> (d) "+ar.get(4)+"</b>", "PASS",			 
						"Shopclues <b>PAYMENT METHOD</b> options should be successfully visible ");

			} else {
					DriverSession.getLastExecutionReportingInstance()
						.teststepreporting("Shopclues <b>PAYMENT METHOD</b> option is not successfully visible ", "FAIL",
								"Shopclues <b>PAYMENT METHOD</b> options should be successfully visible ");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public void verifySelectedRadioButton() {
		
		List<WebElement> radio_Option=null;
		String focused_RadioButton=null;
		try{
			radio_Option=PaymentMethod.getInstance().verifyRadioButton(driver);
			focused_RadioButton=Keywords.verifyMultipleIsEnabledObjects(radio_Option);
			GlobalVar.radioButton=focused_RadioButton;
			if(GlobalVar.etpStepsReport){
				DriverSession.getLastExecutionReportingInstance()
				 .teststepreporting("Default <b>"+focused_RadioButton+"</b> Payment option is successfully visible ", "PASS",
						"Default Shopclues PAYMENT METHOD <b>"+focused_RadioButton+"</b> options should be successfully visible ");

			} else {
					DriverSession.getLastExecutionReportingInstance()
						.teststepreporting("Default Shopclues PAYMENT METHOD <b>"+focused_RadioButton+"</b> options is not successfully visible ", "FAIL",
								"Default Shopclues PAYMENT METHOD <b>"+focused_RadioButton+"</b> options should be successfully visible ");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public void validateRadioButtonDefaultTextField(){

		List<WebElement>payment_RaddioButtons=null;
		String payment_Options=null;
		String payment_OptionTextFieldValue=null;
		try{
			payment_RaddioButtons=PaymentMethod.getInstance().verifyRadioButton(driver);
			payment_Options=GlobalVar.TEST_DATA.get("PaymentOption");
			payment_OptionTextFieldValue=GlobalVar.TEST_DATA.get("PaymentOptionTextValue");
			
			try{
				Keywords.validateAndFetchRadioButtonValue(payment_RaddioButtons,payment_OptionTextFieldValue,payment_Options);
			}
			catch(Exception innerExcep){innerExcep.printStackTrace();}
		}
		catch(Exception e)
		{System.out.println("");}
		
	}

	public void verifyHomePage() {
		WebElement homePage_Validate=null;
		try{
			
			homePage_Validate=HomePage.getInstance().checkHomePageInstance(driver);
			Keywords.waitForObject(homePage_Validate);
			Keywords.validateElementExistOrNot(homePage_Validate);
			if(GlobalVar.etpStepsReport){
				DriverSession.getLastExecutionReportingInstance()
				 .teststepreporting("Shopclues <b>Home Page</b>  is successfully validated ", "PASS",
						"Shopclues <b>Home Page</b> should be successfully validated ");

			} else {
					DriverSession.getLastExecutionReportingInstance()
						.teststepreporting("Shopclues <b>Home Page</b> is not successfully Loaded ", "FAIL",
								"Shopclues <b>Home Page</b> should be successfully validated ");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public void clickAndValidateNotificationsIcon() {
		WebElement leaf=null;
		List<WebElement> notification=null;
		String dropDown_Text=null;
		try{
			leaf=HomePage.getInstance().clickTo_Leaf(driver);
			Keywords.click(leaf);
			notification=HomePage.getInstance().getNotificationInstance(driver);
			dropDown_Text=GlobalVar.TEST_DATA.get("DropDown_Text");
			Keywords.clickByText(notification, dropDown_Text);
			if(GlobalVar.etpStepsReport){
				DriverSession.getLastExecutionReportingInstance()
				 .teststepreporting("Shopclues <b><i>"+dropDown_Text+" </i></b> is successfully Clicked ", "PASS",
						"Shopclues <b><i>"+dropDown_Text+" </i></b> should be successfully clicked ");

			} else {
					DriverSession.getLastExecutionReportingInstance()
						.teststepreporting("Shopclues <b><i>"+dropDown_Text+" </i></b> is not successfully Clicked ", "FAIL",
								"Shopclues <b><i>"+dropDown_Text+" </i></b> should be successfully validated ");
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public void validateAndInSideNotification() {
		WebElement notification=null;
		String notifyMsgFromDataSheet=null;
		String notifyMsgFromObject=null;
	try{
		notification=HomePage.getInstance().notificationValue(driver);
		notifyMsgFromDataSheet=GlobalVar.TEST_DATA.get("notifications_Message");
		notifyMsgFromObject=Keywords.getText(notification);
		
		if(notifyMsgFromDataSheet.equalsIgnoreCase(notifyMsgFromObject)){
			DriverSession.getLastExecutionReportingInstance()
			 .teststepreporting("No New <b><i>"+notifyMsgFromObject+" </i></b> is visible successfully ", "FAIL",
					"Shopclues <b><i>"+notifyMsgFromObject+" </i></b> should be successfully visible ");
		}else{
			DriverSession.getLastExecutionReportingInstance()
			 .teststepreporting("New <b><i>"+notifyMsgFromObject+" </i></b> is successfully visible  ", "PASS",
					"Shopclues <b><i>"+notifyMsgFromObject+" </i></b> should be successfully visible ");
		}
	}catch(Exception e){
		e.printStackTrace();
	}
		
	}


/** ***************************************************************************************
 * Keyword-Name:    verifyContinueShoppingButton_Negative
 * Usage:           void verifyContinueShoppingButton_Negative()
 * Description:     Verify continue shopping button negative
 * Author:          Automators
 * Dated:           11May2015
 * Notes:   
 *************************************************************************************** **/
public void verifyContinueShoppingButton_Negative()
{
	WebElement element=null;	
	try
	{
		element=HomePage.getInstance().productQuantity(driver);
		Keywords.isElementPresent(element);
								
		if(GlobalVar.etpStepsReport)
		{			
			 DriverSession.getLastExecutionReportingInstance().teststepreporting("Continue shopping functionality working","PASS","Continue shopping button should not display ");
		}
		else
		{
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Continue shopping functionality not working","FAIL","Continue shopping button should not display");
		}
	}
	catch(Exception e)
		{
		DriverSession.getLastExecutionReportingInstance().teststepreporting("Exception occured..", "FAIL","Continue shopping button should not display");
		}
		
}

/** ***************************************************************************************
 * Keyword-Name:    clickOnPlaceOrderButton
 * Usage:           void clickOnPlaceOrderButton()
 * Description:     Click on place order button
 * Author:          Automators
 * Dated:           11May2015
 * Notes:   
 *************************************************************************************** **/
public void clickOnPlaceOrderButton()
{
	WebElement element=null;
	try
	{
		element=HomePage.getInstance().productPlaceOrder(driver);
		//HomePage.getInstance().dynamicwait(driver, 20, element);
		Keywords.dynamicwait(driver, 20, element);
		Keywords.click(element);
				
		if(GlobalVar.etpStepsReport)
		{			
			 DriverSession.getLastExecutionReportingInstance().teststepreporting("Clicked on place order successfully","PASS","Should click on place order button");
		}
		else
		{
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Place order not clicked","FAIL","Should click on place order button");
		}
	}
	catch(Exception e)
		{
		DriverSession.getLastExecutionReportingInstance().teststepreporting("Exception occured..", "FAIL","Should click on place order button");
		}
}


/** ***************************************************************************************
 * Keyword-Name:    getCouponCode
 * Usage:           void getCouponCode()
 * Description:     Get coupon code
 * Author:          Automators
 * Dated:           11May2015
 * Notes:   
 *************************************************************************************** **/
public void getCouponCode()
{
	WebElement element=null;
	String couponCode;
	try
	{
		element=HomePage.getInstance().productCouponCode(driver);
		
		couponCode = Keywords.getText(element);
		GlobalVar.COUPON_CODE = couponCode;
		
		//System.out.println("Coupon Code " + couponCode );
		
		if(GlobalVar.etpStepsReport)
		{			
			 DriverSession.getLastExecutionReportingInstance().teststepreporting("Get coupon code successfully","PASS","Should Get coupon code");
		}
		else
		{
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Unable to get coupon code","FAIL","Should Get coupon code");
		}
	}
	catch(Exception e)
		{
		DriverSession.getLastExecutionReportingInstance().teststepreporting("Exception occured..", "FAIL","Should Get coupon code");
		}
}

/** ***************************************************************************************
 * Keyword-Name:    getCurrentPrice
 * Usage:           void getCurrentPrice()
 * Description:     Get product price
 * Author:          Automators
 * Dated:           11May2015
 * Notes:   
 *************************************************************************************** **/
public void getCurrentPrice()
{
	WebElement element=null;
	String currentPrice;
	String[] str;
	try
	{
		element=HomePage.getInstance().productCurrentPrice(driver);
		
		currentPrice = Keywords.getText(element);
		str = currentPrice.split("Rs");
		currentPrice = str[1].replace(",", "");
		currentPrice = currentPrice.replace(".", "");
		GlobalVar.CURRENT_PRICE = currentPrice;
		//System.out.println("Current price " + currentPrice);
		
		if(GlobalVar.etpStepsReport)
		{			
			 DriverSession.getLastExecutionReportingInstance().teststepreporting("Get current price successfully","PASS","Should Get current price");
		}
		else
		{
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Unable to current price code","FAIL","Should Get current price");
		}
	}
	catch(Exception e)
		{
		DriverSession.getLastExecutionReportingInstance().teststepreporting("Exception occured..", "FAIL","Should Get current price");
		}
}


/** ***************************************************************************************
 * Keyword-Name:    clickOnBuyNowButton
 * Usage:           void clickOnBuyNowButton()
 * Description:     Click on buy now button
 * Author:          Automators
 * Dated:           11May2015
 * Notes:   
 *************************************************************************************** **/
public void clickOnBuyNowButton()
{
	WebElement element=null;	
	try
	{
		element=HomePage.getInstance().productBuyNowButton(driver);
		Keywords.click(element);
		if(GlobalVar.etpStepsReport)
		{			
			 DriverSession.getLastExecutionReportingInstance().teststepreporting(" Clicked on Buy Now button","PASS","Should click on  Buy Now button");
		}
		else
		{
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Not Clicked on Buy Now","FAIL","Should click on  Buy Now button");
		}
	}
	catch(Exception e)
		{
		DriverSession.getLastExecutionReportingInstance().teststepreporting("Exception occured..", "FAIL","Should click on  Buy Now button");
		}
		
}

/** ***************************************************************************************
 * Keyword-Name:    clickScreen2ContinueButton
 * Usage:           void clickScreen2ContinueButton()
 * Description:     Click on screen 2 continue button
 * Author:          Automators
 * Dated:           11May2015
 * Notes:   
 *************************************************************************************** **/
public void clickScreen2ContinueButton()
{
	WebElement element=null;
	try
	{
		element=HomePage.getInstance().productPlaceOrderAddressContinueButtonScreen2(driver);
		Keywords.click(element);
				
		if(GlobalVar.etpStepsReport)
		{			
			 DriverSession.getLastExecutionReportingInstance().teststepreporting("click on continue button successfully","PASS","Should click on continue button");
		}
		else
		{
			DriverSession.getLastExecutionReportingInstance().teststepreporting("click on continue button failed","FAIL","Should click on continue button");
		}
	}
	catch(Exception e)
		{
		DriverSession.getLastExecutionReportingInstance().teststepreporting("Exception occured..", "FAIL","Should click on continue button");
		}
}

/** ***************************************************************************************
 * Keyword-Name:    verifyCurrentPriceFromPaymentPage
 * Usage:           void verifyCurrentPriceFromPaymentPage()
 * Description:     Verify current price from payment page
 * Author:          Automators
 * Dated:           11May2015
 * Notes:   
 *************************************************************************************** **/
public void verifyCurrentPriceFromPaymentPage()
{
	WebElement element=null;
	String currentPrice;
	String[] str;
	try
	{
		element=HomePage.getInstance().productPaymentMethodProductPrice(driver);
		
		currentPrice = Keywords.getText(element);
		str = currentPrice.split("Rs.");
		currentPrice = str[1].replace(",", "");
		
		//System.out.println("current price " + currentPrice + "global product price " + GlobalVar.CURRENT_PRICE);
				
		if(GlobalVar.etpStepsReport && Integer.parseInt(currentPrice) > Integer.parseInt(GlobalVar.CURRENT_PRICE))
		{			
			 DriverSession.getLastExecutionReportingInstance().teststepreporting("Product price is verified from payment Page","PASS","Should verify product price");
		}
		else
		{
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Product Price is verified from payment Page","FAIL","Should verify Product price");
		}
	}
	catch(Exception e)
		{
		DriverSession.getLastExecutionReportingInstance().teststepreporting("Exception occured..", "FAIL","Should verify Product price");
		}
}

/** ***************************************************************************************
 * Keyword-Name:    verifyCouponCodeFromPaymentPage
 * Usage:           void verifyCouponCodeFromPaymentPage()
 * Description:     Verify coupon code from payment page
 * Author:          Automators
 * Dated:           11May2015
 * Notes:   
 *************************************************************************************** **/
public void verifyCouponCodeFromPaymentPage()
{
	WebElement element=null;
	String couponCode;
	try
	{
		element=HomePage.getInstance().productCouponCode(driver);
		//HomePage.getInstance().dynamicwait(driver, 20, element);
		Keywords.dynamicwait(driver, 20, element);
		couponCode = Keywords.getText(element);
		
		//System.out.println("Coupon Code " + couponCode + "global coupon value " + GlobalVar.COUPON_CODE);
				
		if(GlobalVar.etpStepsReport && couponCode.equalsIgnoreCase(GlobalVar.COUPON_CODE))
		{			
			 DriverSession.getLastExecutionReportingInstance().teststepreporting("Coupon code is verified from payment Page","PASS","Should verify coupon code from payment page");
		}
		else
		{
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Coupon code is not verified from payment Page","FAIL","Should verify coupon code from payment page");
		}
	}
	catch(Exception e)
		{
		DriverSession.getLastExecutionReportingInstance().teststepreporting("Exception occured..", "FAIL","Should verify coupon code from payment page");
		}
}

/** ***************************************************************************************
 * Keyword-Name:    verifyApplySingleCoupon
 * Usage:           void verifyApplySingleCoupon()
 * Description:     Verify apply single coupon link
 * Author:          Automators
 * Dated:           11May2015
 * Notes:   
 *************************************************************************************** **/
public void verifyApplySingleCoupon()
{
	WebElement element=null;
	try
	{
		element=HomePage.getInstance().productPaymentMethodApplyCoupon(driver);
		
		Keywords.isElementPresent(element);
				
		if(GlobalVar.etpStepsReport)
		{			
			 DriverSession.getLastExecutionReportingInstance().teststepreporting("Apply coupon link verified successfully","PASS","Should verify Apply coupon link");
		}
		else
		{
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Apply coupon link not verified","FAIL","Should click verify coupon link");
		}
	}
	catch(Exception e)
		{
		DriverSession.getLastExecutionReportingInstance().teststepreporting("Exception occured..", "FAIL","Should click verify coupon link");
		}
}

/** ***************************************************************************************
 * Keyword-Name:    selectCODPaymentMethod
 * Usage:           void selectCODPaymentMethod()
 * Description:     Select COD payment mode
 * Author:          Automators
 * Dated:           11May2015
 * Notes:   
 *************************************************************************************** **/
public void selectCODPaymentMethod()
{
	WebElement element=null;
	try
	{
		element=HomePage.getInstance().productPaymentMethodCODradio(driver);
		//HomePage.getInstance().dynamicwait(driver, 20, element);
		Keywords.dynamicwait(driver, 20, element);
		Keywords.click(element);
				
		if(GlobalVar.etpStepsReport)
		{			
			 DriverSession.getLastExecutionReportingInstance().teststepreporting("COD payment method selected successfully","PASS","Should select COD payment method");
		}
		else
		{
			DriverSession.getLastExecutionReportingInstance().teststepreporting("COD payment method not selected","FAIL","Should select COD payment method");
		}
	}
	catch(Exception e)
		{
		DriverSession.getLastExecutionReportingInstance().teststepreporting("Exception occured..", "FAIL","Should select COD payment method");
		}
}

/** ***************************************************************************************
 * Keyword-Name:    clickOnApplySingleCoupon
 * Usage:           void clickOnApplySingleCoupon()
 * Description:     Click on apply single coupon
 * Author:          Automators
 * Dated:           11May2015
 * Notes:   
 *************************************************************************************** **/
public void clickOnApplySingleCoupon()
{
	WebElement element=null;
	try
	{
		element=HomePage.getInstance().productPaymentMethodApplyCoupon(driver);
		//HomePage.getInstance().dynamicwait(driver, 20, element);
		Keywords.dynamicwait(driver, 20, element);
		Keywords.click(element);
				
		if(GlobalVar.etpStepsReport)
		{			
			 DriverSession.getLastExecutionReportingInstance().teststepreporting("Apply coupon link clicked successfully","PASS","Should click Apply coupon link");
		}
		else
		{
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Apply coupon link not clicked","FAIL","Should click Apply coupon link");
		}
	}
	catch(Exception e)
		{
		DriverSession.getLastExecutionReportingInstance().teststepreporting("Exception occured..", "FAIL","Should click Apply coupon link");
		}
}

/** ***************************************************************************************
 * Keyword-Name:    verifyCODCouponError
 * Usage:           void verifyCODCouponError()
 * Description:     Verify COD coupon error
 * Author:          Automators
 * Dated:           11May2015
 * Notes:   
 *************************************************************************************** **/
public void verifyCODCouponError()
{
	WebElement element=null;
	String errText;
	try
	{
		element=HomePage.getInstance().productPaymentMethodCODCouponError(driver);
		errText=Keywords.getText(element);
		
		//System.out.println("Error message " + errText);
				
		if(GlobalVar.etpStepsReport && errText.contains(GlobalVar.TEST_DATA.get("COD Coupon Error")))
		{			
			 DriverSession.getLastExecutionReportingInstance().teststepreporting("COD Coupon Error verified successfully","PASS","Should verify COD Coupon Error");
		}
		else
		{
			DriverSession.getLastExecutionReportingInstance().teststepreporting("COD Coupon Error not verified","FAIL","Should verify COD Coupon Error");
		}
	}
	catch(Exception e)
		{
		DriverSession.getLastExecutionReportingInstance().teststepreporting("Exception occured..", "FAIL","Should verify COD Coupon Error");
		}
}


/** ***************************************************************************************
 * Keyword-Name:    selectCreditCardPaymentMethod
 * Usage:           void selectCreditCardPaymentMethod()
 * Description:     Select credit card payment mode
 * Author:          Automators
 * Dated:           11May2015
 * Notes:   
 *************************************************************************************** **/
public void selectCreditCardPaymentMethod()
{
	WebElement element=null;
	try
	{
		element=HomePage.getInstance().productPaymentMethodCreditCardradio(driver);
		//HomePage.getInstance().dynamicwait(driver, 20, element);
		Keywords.dynamicwait(driver, 20, element);
		Keywords.click(element);
				
		if(GlobalVar.etpStepsReport)
		{			
			 DriverSession.getLastExecutionReportingInstance().teststepreporting("Credit Card payment method selected successfully","PASS","Should select Credit Card payment method");
		}
		else
		{
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Credit Card method not selected","FAIL","Should select Credit Card payment method");
		}
	}
	catch(Exception e)
		{
		DriverSession.getLastExecutionReportingInstance().teststepreporting("Exception occured..", "FAIL","Should select Credit Card payment method");
		}
}


/** ***************************************************************************************
 * Keyword-Name:    verifyFinalPriceAfterApplyCoupon
 * Usage:           void verifyFinalPriceAfterApplyCoupon()
 * Description:     Verify product price after apply coupon
 * Author:          Automators
 * Dated:           11May2015
 * Notes:   
 *************************************************************************************** **/
public void verifyFinalPriceAfterApplyCoupon()
{
	WebElement element=null;
	String finalPrice;
	String[] str; 
	try
	{
		element=HomePage.getInstance().productPaymentMethodFinalSubTotal(driver);
		finalPrice=Keywords.getText(element);
		//System.out.println("Final price " + finalPrice);
		
		str = finalPrice.split("Rs.");
		finalPrice = str[1].trim();
		//System.out.println("Final price after split " + finalPrice);
				
		if(GlobalVar.etpStepsReport && Integer.parseInt(GlobalVar.CURRENT_PRICE) == Integer.parseInt(finalPrice))
		{			
			 DriverSession.getLastExecutionReportingInstance().teststepreporting("Product price verified successfully","PASS","Should verify Product price after apply single coupon");
		}
		else
		{
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Product price not verified","FAIL","Should verify Product price after apply single coupon");
		}
	}
	catch(Exception e)
		{
		DriverSession.getLastExecutionReportingInstance().teststepreporting("Exception occured..", "FAIL","Should verify Product price after apply single coupon");
		}
}

/** ***************************************************************************************
 * Keyword-Name:    verifyPriceAfterRemoveCoupon
 * Usage:           void verifyPriceAfterRemoveCoupon()
 * Description:     Verify product price after remove coupon
 * Author:          Automators
 * Dated:           12May2015
 * Notes:   
 *************************************************************************************** **/
public void verifyPriceAfterRemoveCoupon(String str)
{
	WebElement element=null;
	String code;
	try
	{
		element=HomePage.getInstance().productPlaceOrderAddressStateBYName(driver,str);
		
		code = Keywords.getText(element);
				
		if(GlobalVar.etpStepsReport && code.equalsIgnoreCase(str))
		{		
			if(str.equalsIgnoreCase(" COUPON "))
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Remove coupon functionality verified","PASS","Should Remove coupon functionality");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Apply single coupon functionality verified","PASS","Should Apply single coupon functionality");
				
		}
		else
		{
			if(str.equalsIgnoreCase(" COUPON "))
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Remove coupon functionality not verified","FAIL","Should Remove coupon functionality");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Apply single coupon functionality not verified","FAIL","Should Apply single coupon functionality");
			
		}
	}
	catch(Exception e)
		{
		DriverSession.getLastExecutionReportingInstance().teststepreporting("Exception occured..", "FAIL","Should Apply single coupon functionality");
		}
}


/** ***************************************************************************************
 * Keyword-Name:    verifyRemoveCoupon
 * Usage:           void verifyRemoveCoupon()
 * Description:     Verify remove coupon functionality
 * Author:          Automators
 * Dated:           11May2015
 * Notes:   
 *************************************************************************************** **/
public void verifyRemoveCoupon()
{
	WebElement element=null;
	try
	{
		element=HomePage.getInstance().productPaymentMethodRemoveCoupon(driver);
		
		Keywords.isElementPresent(element);
				
		if(GlobalVar.etpStepsReport)
		{			
			 DriverSession.getLastExecutionReportingInstance().teststepreporting("Remove coupon link verified successfully","PASS","Should verify Remove coupon link");
		}
		else
		{
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Remove coupon link not verified","FAIL","Should verify Remove coupon link");
		}
	}
	catch(Exception e)
		{
		DriverSession.getLastExecutionReportingInstance().teststepreporting("Exception occured..", "FAIL","Should verify Remove coupon link");
		}
}

/** ***************************************************************************************
 * Keyword-Name:    clickOnRemoveCoupon
 * Usage:           void clickOnRemoveCoupon()
 * Description:     Click on Remove coupon
 * Author:          Automators
 * Dated:           11May2015
 * Notes:   
 *************************************************************************************** **/
public void clickOnRemoveCoupon()
{
	WebElement element=null;
	try
	{
		element=HomePage.getInstance().productPaymentMethodRemoveCoupon(driver);
		
		Keywords.click(element);
				
		if(GlobalVar.etpStepsReport)
		{			
			 DriverSession.getLastExecutionReportingInstance().teststepreporting("Remove coupon link clicked successfully","PASS","Should click Remove coupon link");
		}
		else
		{
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Remove coupon link not clicked","FAIL","Should click Remove coupon link");
		}
	}
	catch(Exception e)
		{
		DriverSession.getLastExecutionReportingInstance().teststepreporting("Exception occured..", "FAIL","Should click Remove coupon link");
		}
}


/** ***************************************************************************************
 * Keyword-Name:    clickOnViewProfileLink
 * Usage:           void clickOnViewProfileLink()
 * Description:     Click on view profile link
 * Author:          Automators
 * Dated:           12May2015
 * Notes:   
 *************************************************************************************** **/
public void clickOnViewProfileLink()
{
	WebElement element=null;
	try
	{
		element=HomePage.getInstance().viewProfileLink(driver);
		//HomePage.getInstance().dynamicwait(driver, 20, element);
		Keywords.dynamicwait(driver, 20, element);
		Keywords.click(element);
				
		if(GlobalVar.etpStepsReport)
		{			
			 DriverSession.getLastExecutionReportingInstance().teststepreporting("Clicked on View profile successfully","PASS","Should click on View profile");
		}
		else
		{
			DriverSession.getLastExecutionReportingInstance().teststepreporting("View profile not clicked","FAIL","Should click on View profile");
		}
	}
	catch(Exception e)
		{
		DriverSession.getLastExecutionReportingInstance().teststepreporting("Exception occured..", "FAIL","Should click on View profile");
		}
}

/** ***************************************************************************************
 * Keyword-Name:    verifyLoginPage
 * Usage:           void verifyLoginPage()
 * Description:     Verify login page
 * Author:          Automators
 * Dated:           12May2015
 * Notes:   
 *************************************************************************************** **/
public void verifyLoginPage()
{
	WebElement element=null;
	try
	{
		element=HomePage.getInstance().product_AppLogin_Email(driver);
		//HomePage.getInstance().dynamicwait(driver, 20, element);
		Keywords.dynamicwait(driver, 20, element);
		Keywords.isElementPresent(element);
				
		if(GlobalVar.etpStepsReport)
		{			
			 DriverSession.getLastExecutionReportingInstance().teststepreporting("Login page verified successfully","PASS","Should verify login page");
		}
		else
		{
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Login page not verified","FAIL","Should verify login page");
		}
	}
	catch(Exception e)
		{
		DriverSession.getLastExecutionReportingInstance().teststepreporting("Exception occured..", "FAIL","Should verify login page");
		}
}

/** ***************************************************************************************
 * Keyword-Name:    typeOnCluesBucksEditBox
 * Usage:           void typeOnCluesBucksEditBox()
 * Description:     Type on clues bucks edit box
 * Author:          Automators
 * Dated:           13May2015
 * Notes:   
 *************************************************************************************** **/
public void typeOnCluesBucksEditBox(String val)
{
	WebElement element=null;
	try
	{
		element=HomePage.getInstance().cluesBucksEditBox(driver);
		//HomePage.getInstance().dynamicwait(driver, 20, element);
		Keywords.dynamicwait(driver, 20, element);
		Keywords.typeText(element, val);
				
		if(GlobalVar.etpStepsReport)
		{			
			 DriverSession.getLastExecutionReportingInstance().teststepreporting("Clues bucks typed successfully","PASS","Should type on Clues bucks");
		}
		else
		{
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Clues bucks not typed","FAIL","Should type on Clues bucks");
		}
	}
	catch(Exception e)
		{
		DriverSession.getLastExecutionReportingInstance().teststepreporting("Exception occured..", "FAIL","Should type on Clues bucks");
		}
}

/** ***************************************************************************************
 * Keyword-Name:    clickOnApplyCluesBucksLink
 * Usage:           void clickOnApplyCluesBucksLink()
 * Description:     Click on apply clues bucks link
 * Author:          Automators
 * Dated:           13May2015
 * Notes:   
 *************************************************************************************** **/
public void clickOnApplyCluesBucksLink()
{
	WebElement element=null;
	try
	{
		element=HomePage.getInstance().cluesBucksApplyLink(driver);
		//HomePage.getInstance().dynamicwait(driver, 20, element);
		Keywords.dynamicwait(driver, 20, element);
		Keywords.click(element);
				
		if(GlobalVar.etpStepsReport)
		{			
			 DriverSession.getLastExecutionReportingInstance().teststepreporting("Clicked on Apply clues bucks Link successfully","PASS","Should click on Apply clues bucks Link");
		}
		else
		{
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Apply clues bucks Link not clicked","FAIL","Should click on Apply clues bucks Link");
		}
	}
	catch(Exception e)
		{
		DriverSession.getLastExecutionReportingInstance().teststepreporting("Exception occured..", "FAIL","Should click on Apply clues bucks Link");
		}
}

/** ***************************************************************************************
 * Keyword-Name:    getAndVerifyAppliedCluesBucks
 * Usage:           void getAndVerifyAppliedCluesBucks()
 * Description:     Get and verify applied clues bucks
 * Author:          Automators
 * Dated:           13May2015
 * Notes:   
 *************************************************************************************** **/
public void getAndVerifyAppliedCluesBucks(String val)
{
	WebElement element=null;
	String[] str;
	String CluesBucks;
	try
	{
		element=HomePage.getInstance().cluesBucksApplyLink(driver);
		//HomePage.getInstance().dynamicwait(driver, 20, element);
		Keywords.dynamicwait(driver, 20, element);
		element=HomePage.getInstance().cluesBucksInUse(driver);
		CluesBucks = Keywords.getText(element);
		str = CluesBucks.split("Rs.");
		CluesBucks = str[1].trim();
						
		if(GlobalVar.etpStepsReport && Integer.parseInt(CluesBucks) == Integer.parseInt(val))
		{			
			 DriverSession.getLastExecutionReportingInstance().teststepreporting("Applied clues bucks verified successfully","PASS","Should verify Applied clues bucks");
		}
		else
		{
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Applied clues bucks not verified","FAIL","Should verify Applied clues bucks");
		}
	}
	catch(Exception e)
		{
		DriverSession.getLastExecutionReportingInstance().teststepreporting("Exception occured..", "FAIL","Should verify Applied clues bucks");
		}
}

/** ***************************************************************************************
 * Keyword-Name:    verifyMyProfile
 * Usage:           void verifyMyProfile()
 * Description:     Verify my profile page
 * Author:          Automators
 * Dated:           11May2015
 * Notes:   
 *************************************************************************************** **/
public void verifyMyProfile()
{
	WebElement element=null;
	String email;
	try
	{
		element=HomePage.getInstance().myProfileUserEmail(driver);
		//HomePage.getInstance().dynamicwait(driver, 20, element);
		Keywords.dynamicwait(driver, 20, element);
		email = Keywords.getText(element);
				
		if(GlobalVar.etpStepsReport && email.contains(GlobalVar.TEST_DATA.get("AppLogin_Email_Address")))
		{			
			 DriverSession.getLastExecutionReportingInstance().teststepreporting("My profile verified successfully","PASS","Should verify My profile");
		}
		else
		{
			DriverSession.getLastExecutionReportingInstance().teststepreporting("My profile not verified","FAIL","Should verify My profile");
		}
	}
	catch(Exception e)
		{
		DriverSession.getLastExecutionReportingInstance().teststepreporting("Exception occured..", "FAIL","Should verify My profile");
		}
}

public void selectProduct(String productName) throws InterruptedException
{
	int count=0,i;
	try {
		String[] str=productName.split("##");
		count=str.length;
		//System.out.println("Count value" + count);
		for(i=0;i<str.length;i++)
		{
			//System.out.println("Going to click on " + str[i]);
			WebDriverWait wait = new WebDriverWait(driver,60);
			wait.until(ExpectedConditions.elementToBeClickable(By.name(str[i])));
			driver.findElement(By.name(str[i])).click();
		}
		productName = productName.replace("##", "---->");
		if(GlobalVar.etpStepsReport)
		{
			
			 DriverSession.getLastExecutionReportingInstance().teststepreporting("Product selected successfully i.e., " + productName,"PASS","Product Should be selected");

		}
		else
		{

			DriverSession.getLastExecutionReportingInstance().teststepreporting("Product not found i. e., " + productName,"FAIL","Product Should be selected");

		}
	}
	catch(Exception e)
		{
		DriverSession.getLastExecutionReportingInstance().teststepreporting("Exception occured..", "FAIL","Product Should be selected");
		}
}
/** ***************************************************************************************
 * Keyword-Name:    selectProductQuantity
 * Usage:           void selectProductQuantity(String quan)
 * Description:     Select product quantity
 * Author:          Automators
 * Dated:           11May2015
 * Notes:   
 *************************************************************************************** **/
public void selectProductQuantity(String quan)
{
	WebElement element=null;	
	try
	{
		element=HomePage.getInstance().productQuantity(driver);
		Keywords.click(element);
		
		element=HomePage.getInstance().productQuantityValue(driver,quan);
		Keywords.click(element);
		
		if(GlobalVar.etpStepsReport)
		{			
			 DriverSession.getLastExecutionReportingInstance().teststepreporting("Product quantity selected","PASS","Should select product quantity");
		}
		else
		{
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Product quantity not selected","FAIL","Should select product quantity");
		}
	}
	catch(Exception e)
		{
		DriverSession.getLastExecutionReportingInstance().teststepreporting("Exception occured..", "FAIL","Should select product quantity");
		}
		
}



/** ***************************************************************************************
 * Keyword-Name:    ProductSearch_TypeTextName(String ProductName)
 * Usage:           void ProductSearch_TypeTextName(String ProductName)
 * Description:     wait for given object for given time
 * Author:          KAutomators
 * Dated:           13 May 2015
 * Notes:   
 *************************************************************************************** **/



public void ProductSearch_TypeTextName(String ProductName) 
{
	WebElement element=null;
	try{
		element=HomePage.getInstance().product_SerachBox(driver);
	
		Keywords.typeText(element,ProductName);

		
		if (GlobalVar.etpStepsReport) 
		{
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Search Text typed succefully. :: "+GlobalVar.TEST_DATA.get("SearchProduct1"), "PASS",GlobalVar.TEST_DATA.get("SearchProduct1") + "Text should be entered.");

		} 
		else 
		{
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Search Text not typed.", "FAIL","Search Text should be typed.");

		}
		
		
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
		DriverSession.getLastExecutionReportingInstance().teststepreporting("Exception occured : ", "FAIL",e.toString());
	}
}



/** ***************************************************************************************
 * Keyword-Name:    clickState
 * Usage:           void clickState
 * Description:     wait for given object for given time
 * Author:          KAutomators
 * Dated:           13 May 2015
 * Notes:   
 *************************************************************************************** **/


public void clickState() 
{
	WebElement productState=null;

	try
	{
		productState=HomePage.getInstance().product_SelectStateDropDown(driver);
		//System.out.println("productQuantity");
		Keywords.click(productState);

	
		if(GlobalVar.etpStepsReport)
		{
			DriverSession.getLastExecutionReportingInstance().teststepreporting(" State Dropdown selected "+ productState,"PASS","  State Dropdown Should be selected");
		}
	else
	{

		DriverSession.getLastExecutionReportingInstance().teststepreporting(" State Dropdown not selected as "+productState,"FAIL"," State Dropdown Should be selected");

	}
	}
	catch(Exception e)
	{
		
		e.printStackTrace();
	}
	
}

/** ***************************************************************************************
 * Keyword-Name:    selectState
 * Usage:           void selectState
 * Description:     wait for given object for given time
 * Author:          KAutomators
 * Dated:           13 May 2015
 * Notes:   
 *************************************************************************************** **/


public void selectState() 
{
	List<WebElement> state=null; 
	try
	{
		state=HomePage.getInstance().product_SelectStatePopup(driver);
		String pickState=Keywords.getTextByIndex(state, 10);
		
	//	scrollObject = dict(direction="down", text="some_text", element=appium_driver_elem.id)
	//	self.driver.execute_script("mobile: scrollTo", scrollObject)
		
		Keywords.clickByIndex(state, 10);
		if(GlobalVar.etpStepsReport)
		{
			DriverSession.getLastExecutionReportingInstance().teststepreporting(" State selected "+ pickState,"PASS",Keywords.getTextByIndex(state, 0)+"  State Should be selected");
		}
	else
	{

		DriverSession.getLastExecutionReportingInstance().teststepreporting(" State not selected as "+pickState,"FAIL"," State Should be selected");

	}
	}
	catch(Exception e)
	{
		
		e.printStackTrace();
	}
	
}

public void clickGiftCertificateExpander() 
{
	WebElement giftCertificateLink=null;

	try
	{
		
		
		
		giftCertificateLink=HomePage.getInstance().product_GiftCertificateExpand(driver);
		//System.out.println("Clicked on Gift Certificate Successfully");
		Keywords.click(giftCertificateLink);

	
		if(GlobalVar.etpStepsReport)
		{
			DriverSession.getLastExecutionReportingInstance().teststepreporting(" Gift Certificate selected "+ giftCertificateLink,"PASS","  Gift Certificate Should be selected");
		}
		else
		{
			DriverSession.getLastExecutionReportingInstance().teststepreporting(" Gift Certificate not selected as "+giftCertificateLink,"FAIL"," Gift Certificate Should be selected");
		}
	}
	catch(Exception e)
	{
		
		e.printStackTrace();
	}
	
}

/** ***************************************************************************************
 * Keyword-Name:    enterGiftCertificateCode
 * Usage:           void enterGiftCertificateCode
 * Description:     wait for given object for given time
 * Author:          KAutomators
 * Dated:           13 May 2015
 * Notes:   
 *************************************************************************************** **/


public void enterGiftCertificateCode()
{
	WebElement element=null;
	try
	{
		element=HomePage.getInstance().product_GiftCertificateCode(driver);
		
		Keywords.typeText(element,GlobalVar.TEST_DATA.get("Gift_Certifictae_Code"));
		
		if (GlobalVar.etpStepsReport) 
		{
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Gift Certifictae Code typed succefully. :: "+GlobalVar.TEST_DATA.get("Gift_Certifictae_Code"), "PASS","Gift Certifictae Code should be entered.");
		} 
		else 
		{
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Gift Certifictae Code not typed.", "FAIL","Gift Certifictae Code should be typed.");
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
		DriverSession.getLastExecutionReportingInstance().teststepreporting("Exception occured : ", "FAIL",e.toString());
	}
}

/** ***************************************************************************************
 * Keyword-Name:    clickGiftCertificateApplyButton
 * Usage:           void clickGiftCertificateApplyButton
 * Description:     wait for given object for given time
 * Author:          KAutomators
 * Dated:           13 May 2015
 * Notes:   
 *************************************************************************************** **/


public void clickGiftCertificateApplyButton() 
{
	WebElement giftCertificateLink=null;

	try
	{
		giftCertificateLink=HomePage.getInstance().product_GiftCertificateCodeApply(driver);
		//System.out.println("Clicked on Gift Certificate Apply Button Successfully");
		Keywords.click(giftCertificateLink);

	
		if(GlobalVar.etpStepsReport)
		{
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Apply Button selected "+ giftCertificateLink,"PASS","  Apply Button Should be selected");
		}
		else
		{
			DriverSession.getLastExecutionReportingInstance().teststepreporting(" Apply Button not selected as "+giftCertificateLink,"FAIL"," Apply Button Should be selected");
		}
	}
	catch(Exception e)
	{
		
		e.printStackTrace();
	}
	
}

/** ***************************************************************************************
 * Keyword-Name:    clickScreen2ContinueButton
 * Usage:           void clickScreen2ContinueButton()
 * Description:     Click on screen 2 continue button
 * Author:          Automators
 * Dated:           11May2015
 * Notes:   
 *************************************************************************************** **/
public void clickScreen2OnLoginContinueButton()
{
	WebElement element=null;
	try
	{
		element=HomePage.getInstance().productPlaceOrderAddressContinueButtonOnLoginScreen2(driver);
		Keywords.click(element);
				
		if(GlobalVar.etpStepsReport)
		{			
			 DriverSession.getLastExecutionReportingInstance().teststepreporting("click on continue button successfully","PASS","Should click on continue button");
		}
		else
		{
			DriverSession.getLastExecutionReportingInstance().teststepreporting("click on continue button failed","FAIL","Should click on continue button");
		}
	}
	catch(Exception e)
		{
		DriverSession.getLastExecutionReportingInstance().teststepreporting("Exception occured..", "FAIL","Should click on continue button");
		}
}

/** ***************************************************************************************
 * Keyword-Name:    clickOnProductSearch
 * Usage:           void clickOnProductSearch
 * Description:     wait for given object for given time
 * Author:          KAutomators
 * Dated:           13 May 2015
 * Notes:   
 *************************************************************************************** **/


public void clearProductSearch() 
{

	WebElement clearProductSearch=null;	
	try
	{
		clearProductSearch=HomePage.getInstance().product_Serach(driver);
		clearProductSearch.clear();
		
		if(GlobalVar.etpStepsReport)
		{
			
			 DriverSession.getLastExecutionReportingInstance().teststepreporting(" Clear Text Field of Product Serach  ","PASS"," Should Clear Text Field of Product Serach");

		}
		else
		{

			DriverSession.getLastExecutionReportingInstance().teststepreporting("Not Clear Text Field of Product Serach  ","FAIL"," Should Clear Text Field of Product Serach");

		}
	}
	catch(Exception e)
		{
			e.printStackTrace();
		}
		
}

/** ***************************************************************************************
 * Keyword-Name:    clickOnApplyAllCouponsLink
 * Usage:           void clickOnApplyAllCouponsLink()
 * Description:     Click on apply clues bucks link
 * Author:          KAutomators
 * Dated:           13May2015
 * Notes:   
 *************************************************************************************** **/


public void clickOnApplyAllCouponsLink()
{
	WebElement element=null;
	try
	{
		element=HomePage.getInstance().product_ApplyAllCoupon(driver);
		HomePage.getInstance().dynamicwait(driver, 20, element);
		Keywords.click(element);
				
		if(GlobalVar.etpStepsReport)
		{			
			 DriverSession.getLastExecutionReportingInstance().teststepreporting("Clicked on Apply All Coupon Link successfully","PASS","Should click on Apply All Coupon Link");
		}
		else
		{
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Apply All Coupon Link not clicked","FAIL","Should click on Apply All Coupon Link");
		}
	}
	catch(Exception e)
		{
		DriverSession.getLastExecutionReportingInstance().teststepreporting("Exception occured..", "FAIL","Should click on Apply All Coupon Link");
		}
}

/** ***************************************************************************************
 * Keyword-Name:    clickOnProductFavouriteButton
 * Usage:           void clickOnProductFavouriteButton
 * Description:     wait for given object for given time
 * Author:          KAutomators
 * Dated:           13 May 2015
 * Notes:   
 *************************************************************************************** **/


public void clickOnProductFavouriteButton() 
{

	WebElement favouriteButton=null;	
	try
	{
		favouriteButton=HomePage.getInstance().product_Favourite(driver);
		Keywords.click(favouriteButton);
		if(GlobalVar.etpStepsReport)
		{
			
			 DriverSession.getLastExecutionReportingInstance().teststepreporting(" Clicked on Favourite Button ","PASS"," Should click on  Menu  Link");

		}
		else
		{

			DriverSession.getLastExecutionReportingInstance().teststepreporting("Not Clicked on Favourite Button  ","FAIL"," Should click on  Menu  Link");

		}
	}
	catch(Exception e)
		{
			e.printStackTrace();
		}
		
}

/** ***************************************************************************************
 * Keyword-Name:    clickOnProductFavouriteLink
 * Usage:           void clickOnProductFavouriteLink
 * Description:     wait for given object for given time
 * Author:          KAutomators
 * Dated:           13 May 2015
 * Notes:   
 *************************************************************************************** **/


public void clickOnProductFavouriteLink() 
{

	WebElement favouriteLink=null;	
	try{
		favouriteLink=HomePage.getInstance().product_FavouriteLink(driver);
		Keywords.click(favouriteLink);
		
		if(GlobalVar.etpStepsReport){
			
			 DriverSession.getLastExecutionReportingInstance().teststepreporting(" Clicked on Favourite Link ","PASS"," Should click on  Menu  Link");

		}else{

			DriverSession.getLastExecutionReportingInstance().teststepreporting("Not Clicked on Favourite Link  ","FAIL"," Should click on  Menu  Link");

		}
	}
	catch(Exception e){
			e.printStackTrace();
		}
		
}

/** ***************************************************************************************
 * Keyword-Name:    clickOnApplyCouponsLink
 * Usage:           void clickOnApplyCouponsLink()
 * Description:     Click on apply clues bucks link
 * Author:          KAutomators
 * Dated:           13May2015
 * Notes:   
 *************************************************************************************** **/


public void clickOnApplyCouponsLink()
{
	WebElement element=null;
	try{
		element=HomePage.getInstance().product_ApplyCoupon(driver);
		HomePage.getInstance().dynamicwait(driver, 20, element);
		Keywords.click(element);
				
		if(GlobalVar.etpStepsReport){			
			 DriverSession.getLastExecutionReportingInstance().teststepreporting("Clicked on Apply Coupon Link successfully","PASS","Should click on Apply Coupon Link");
		}
		else{
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Apply Coupon Link not clicked","FAIL","Should click on Apply Coupon Link");
		}
	}
	catch(Exception e){
		DriverSession.getLastExecutionReportingInstance().teststepreporting("Exception occured..", "FAIL","Should click on Apply Coupon Link");
		}
}

public void clickPlaceOrderButton() {
	
	WebElement place_Order=null;
	try{
		place_Order=HomePage.getInstance().product_PlaceOrderFromCart(driver);
		Keywords.click(place_Order);
		
	}catch(Exception e){
		e.printStackTrace();
	}
	
}

public void validateGiftCertificateOption() {
	List<WebElement> gift_Certificate=null;
	String coupensFromDataSheet=null;
	List<String>coupensAfterParsing=null;
	try{
		gift_Certificate=PaymentMethod.getInstance().verifyGiftCertificate(driver);
		coupensFromDataSheet=GlobalVar.TEST_DATA.get("CoupenSection");
		coupensAfterParsing=Keywords.splitRowDataWithPipeOperator(coupensFromDataSheet);
		
		
		for(WebElement element : gift_Certificate){
			if(element.getText().equalsIgnoreCase(coupensAfterParsing.get(1))){
				Keywords.validateElementExistOrNot(element);
				if(GlobalVar.etpStepsReport){
					DriverSession.getLastExecutionReportingInstance()
					 .teststepreporting("Shopclues Payment Option <b><i> "+element.getText()+" </i></b>  is successfully validated ", "PASS",
							"Shopclues Payment Option <b><i> "+element.getText()+" </i></b> should be successfully validated ");

				} else {
						DriverSession.getLastExecutionReportingInstance()
							.teststepreporting("Shopclues Payment Option <b><i> "+element.getText()+" </i></b>  is not successfully Loaded ", "FAIL",
									"Shopclues Payment Option <b><i> "+element.getText()+" </i></b> should be successfully validated ");
				}
				break;
			}else{
				continue;
			}
		}
				
	}catch(Exception e){
		e.printStackTrace();
	}
}

public void clickToGiftCertificate() {
	List<WebElement> gift_Certificate=null;
	String coupensFromDataSheet=null;
	List<String>coupensAfterParsing=null;
	try{
		
		gift_Certificate=PaymentMethod.getInstance().verifyGiftCertificate(driver);
		coupensFromDataSheet=GlobalVar.TEST_DATA.get("CoupenSection");
		coupensAfterParsing=Keywords.splitRowDataWithPipeOperator(coupensFromDataSheet);
		
		for(WebElement element : gift_Certificate){
			if(element.getText().equalsIgnoreCase(coupensAfterParsing.get(1))){
				
					Keywords.click(element);
					Keywords.explicitWait(5);
					
					if(GlobalVar.etpStepsReport){
						DriverSession.getLastExecutionReportingInstance()
						 .teststepreporting("Shopclues Payment Option <b><i> "+element.getText()+" </i></b>  is successfully Clicked ", "PASS",
								"Shopclues Payment Option <b><i> "+element.getText()+" </i></b> should be successfully Clicked ");

					} else {
							DriverSession.getLastExecutionReportingInstance()
								.teststepreporting("Shopclues Payment Option <b><i> "+element.getText()+" </i></b>  is not successfully Clicked ", "FAIL",
										"Shopclues Payment Option <b><i> "+element.getText()+" </i></b> should be successfully Clicked ");
					}
					break;
			}
			else{
				continue;
			}
			}
		
	}
	catch(Exception e){
		e.getMessage();
	}
}

public void clickToGiftCertificateCode() {
	WebElement giftCertificateCodeText=null;
	String GiftCertificateCodeDataSheet=null;
	WebElement applyLink=null;
	try{
		giftCertificateCodeText=PaymentMethod.getInstance().clickToGiftCertificateCode(driver);
		GiftCertificateCodeDataSheet=GlobalVar.TEST_DATA.get("GiftCertificateCode");
		Keywords.typeText(giftCertificateCodeText, GiftCertificateCodeDataSheet);
		
		applyLink=PaymentMethod.getInstance().clickToApplyLink(driver);
		Keywords.click(applyLink);
		Keywords.explicitWait(5);
		
		if(GlobalVar.etpStepsReport){
			DriverSession.getLastExecutionReportingInstance()
			 .teststepreporting("Shopclues Payment Option Gift Certificate <b><i> Gift Certificate Code </i></b>  is successfully entered and Clicked to Apply Link ", "PASS",
					"Shopclues Payment Option Gift Certificate <b><i> Gift Certificate Code </i></b> should be successfully Clicked ");

		} else {
				DriverSession.getLastExecutionReportingInstance()
					.teststepreporting("Shopclues Payment Option Gift Certificate <b><i> Gift Certificate Code </i></b>  is not successfully entered and Clicked ", "FAIL",
							"Shopclues Payment Option Gift Certificate <b><i> Gift Certificate Code </i></b> should be successfully Clicked ");
		}
		
		
	}catch(Exception e){
		e.getMessage();
	}
	
}

public void clickToCluesBucks() {
	WebElement cluesBucks=null;
	String cluesBucksCode=null;
	WebElement applyLink=null;
	try{
		cluesBucks=PaymentMethod.getInstance().clickToCluesBucksTextField(driver);
		cluesBucksCode=GlobalVar.TEST_DATA.get("CluesBucksCode");
		Keywords.typeText(cluesBucks, cluesBucksCode);
		
		applyLink=PaymentMethod.getInstance().clickToApplyLinkCluesBucks(driver);
		Keywords.click(applyLink);
		Keywords.explicitWait(5);
		
		if(GlobalVar.etpStepsReport){
			DriverSession.getLastExecutionReportingInstance()
			 .teststepreporting("Shopclues Payment Option Gift Certificate <b><i> CLUESBUCKS </i></b>  is successfully entered and Clicked to Apply Link ", "PASS",
					"Shopclues Payment Option Gift Certificate <b><i> CLUESBUCKS </i></b> should be successfully Clicked ");

		} else {
				DriverSession.getLastExecutionReportingInstance()
					.teststepreporting("Shopclues Payment Option Gift Certificate <b><i> CLUESBUCKS </i></b>  is not successfully entered and Clicked ", "FAIL",
							"Shopclues Payment Option Gift Certificate <b><i> CLUESBUCKS </i></b> should be successfully Clicked ");
		}
		
		
	}catch(Exception e){
		e.getMessage();
	}
	
}

public void validateGrandTotal() {
	WebElement subTotal=null;
	WebElement grandTotal=null;
	WebElement cluesBucksInUse=null;
	WebElement giftCertificateInUse=null;
	String cbucksCode=null,cluesBucksToken=null;
	try{
		grandTotal=PaymentMethod.getInstance().clickToGrandTotal(driver);
		subTotal=PaymentMethod.getInstance().clickToSubtotal(driver);
		cluesBucksInUse=PaymentMethod.getInstance().clickToCluesInUse(driver);
		giftCertificateInUse=PaymentMethod.getInstance().clickToGiftCertiInUse(driver);
		cbucksCode=cluesBucksInUse.getText();
		StringTokenizer split=new StringTokenizer(cbucksCode,"Rs.");
		while(split.hasMoreTokens()){
			cluesBucksToken=(String)(split.nextToken());
		}
		//System.out.println(cluesBucksToken);
		if((subTotal.isDisplayed()) && (grandTotal.isDisplayed()) && 
				(cluesBucksToken.equalsIgnoreCase(GlobalVar.TEST_DATA.get("CluesBucksCode"))) 
						&& (giftCertificateInUse.isDisplayed())){
			
			if(GlobalVar.etpStepsReport){
				DriverSession.getLastExecutionReportingInstance()
				 .teststepreporting("Shopclues Payment Option <b><i><br>Subtotal : "+subTotal.getText()+"<br> Clues Bucks in Use : "+cluesBucksInUse.getText()+" " +
				 		"<br> Gift Certificate in use : "+giftCertificateInUse.getText()+" <br> Grand Total : "+grandTotal.getText()+" </i></b>  is successfully validated ", "PASS",
						"Shopclues Payment Option Gift Certificate <b><i> Payment Form </i></b> should be successfully Clicked ");

			} else {
					DriverSession.getLastExecutionReportingInstance()
						.teststepreporting("Shopclues Payment Option Gift Certificate Payment Form  is not successfully entered and Clicked ", "FAIL",
								"Shopclues Payment Option Gift Certificate <b><i> CLUESBUCKS </i></b> should be successfully Clicked ");
			}
		}
		
	}catch(Exception e){
		e.printStackTrace();
	}
	
}

public void clickToLeaf() {
	WebElement leaf=null;
	try{
		leaf=HomePage.getInstance().clickLeafOption(driver);
		Keywords.click(leaf);
		if (GlobalVar.etpStepsReport) {
			DriverSession.getLastExecutionReportingInstance()
					.teststepreporting("ShopClues Mobile App Home Page leaf is successfully clicked", "PASS",
							"ShopClues Mobile App Home Page leaf should be successfully clicked");

		} else {
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("ShopClues Mobile App Home Page leaf is not successfully clicked", "FAIL",
					"ShopClues Mobile App Home Page leaf should be successfully clicked");
		}
	}
	catch(Exception e){
		e.getMessage();
	}
}

public void validateAndLogin() {
	WebElement login_Caption=null;
	String signal;
	try{
		login_Caption=HomePage.getInstance().clickLoginSymbol(driver);
		signal=login_Caption.getAttribute("enabled");
				
		if(signal.equalsIgnoreCase(GlobalVar.flag)){
			
			if(login_Caption.isDisplayed()){
				
					DriverSession.getLastExecutionReportingInstance()
							.teststepreporting("ShopClues MobileApp HomePage <b><i>LOGIN </i></b> caption is successfully validated", "PASS",
									"ShopClues MobileApp HomePage <b><i>LOGIN </i></b> should be successfully validated");

				} else {
					DriverSession.getLastExecutionReportingInstance()
					.teststepreporting("ShopClues MobileApp HomePage <b><i>LOGIN </i></b> caption is not successfully validated", "FAIL",
							"ShopClues MobileApp HomePage <b><i>LOGIN </i></b> should be successfully validated");
				}
			}
		Keywords.click(login_Caption);
	}
	catch(Exception e){
		e.printStackTrace();
	}
	
}

public void validateSignInPage() {
	WebElement signIN=null;
	try{
		signIN=HomePage.getInstance().clickTOSignINLogo(driver);
		Keywords.validateElementExistOrNot(signIN);
		
		if (GlobalVar.etpStepsReport) {
			DriverSession.getLastExecutionReportingInstance()
					.teststepreporting("ShopClues MobileApp HomePage <b><i>"+signIN.getText()+"</i></b> caption is successfully validated", "PASS",
							"ShopClues MobileApp HomePage <b><i>"+signIN.getText()+" </i></b> should be successfully validated");

		} else {
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("ShopClues MobileApp HomePage <b><i>"+signIN.getText()+"</i></b> caption is not successfully validated", "FAIL",
					"ShopClues MobileApp HomePage <b><i>"+signIN.getText()+" </i></b> should be successfully validated");
		}
	}
	catch(Exception e){
		e.getMessage();
	}
	
}

public void validateLoginUser() {
	WebElement leaf=null;
	String txt=null;
	try{
		leaf=HomePage.getInstance().clickLeafOption(driver);
		Keywords.click(leaf);
		txt=HomePage.getInstance().click_ToLogin(driver).getText();
		
		if(!txt.equalsIgnoreCase("Login")){
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("ShopClues MobileApp HomePage <b><i>"+txt+"</i></b> is successfully Logged-IN", "PASS",
					"ShopClues MobileApp HomePage <b><i>"+txt+" </i></b> should be successfully Logged-IN");

		} else {
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("ShopClues MobileApp HomePage <b><i>"+txt+"</i></b> is not successfully Logged-IN", "FAIL",
					"ShopClues MobileApp HomePage <b><i>"+txt+" </i></b> should be successfully Logged-IN");
		}
	}
	catch(Exception e){
		e.printStackTrace();
	}
	
}

public void clickToMyOrders() {
	List<WebElement>homePageOptions=null;
	String options_DataSheet=null;
	List<String>split_Data=null;
	try{
		homePageOptions=HomePage.getInstance().getNotificationInstance(driver);
		options_DataSheet=GlobalVar.TEST_DATA.get("HomePageLeafOptions");
		split_Data=Keywords.splitRowDataWithPipeOperator(options_DataSheet);
		
		for(WebElement options : homePageOptions){
			if(options.getText().equalsIgnoreCase(split_Data.get(0))){
				
				options.click();
				Keywords.explicitWait(1);
				
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("ShopClues MobileApp HomePage <b><i>"+split_Data.get(0)+"</i></b> is successfully clicked", "PASS",
						"ShopClues MobileApp HomePage <b><i>"+split_Data.get(0)+" </i></b> should be successfully clicked");
				
				break;
			}
			else{
				
				continue;
			}
		}
	}
	catch(Exception e){
		DriverSession.getLastExecutionReportingInstance()
		.teststepreporting("ShopClues MobileApp HomePage <b><i>"+split_Data.get(0)+"</i></b> is not successfully clicked", "FAIL",
				"ShopClues MobileApp HomePage <b><i>"+split_Data.get(0)+" </i></b> should be successfully clicked");
	}
}

public void verifyMyOrderPage() {
	WebElement my_Order_Banner=null;
	try{
		my_Order_Banner=HomePage.getInstance().clickToMyOrderBanner(driver);
		Keywords.validateElementExistOrNot(my_Order_Banner);
		
		if (GlobalVar.etpStepsReport) {
			DriverSession.getLastExecutionReportingInstance()
					.teststepreporting("ShopClues MobileApp  <b><i>"+my_Order_Banner.getText()+"</i></b>page is successfully validated", "PASS",
							"ShopClues MobileApp  <b><i>"+my_Order_Banner.getText()+"</i></b>page should be successfully validated");

		} else {
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("ShopClues MobileApp  <b><i>"+my_Order_Banner.getText()+"</i></b>page is not successfully validated", "FAIL",
					"ShopClues MobileApp  <b><i>"+my_Order_Banner.getText()+"</i></b>page should be successfully validated");
		}
	}
	catch(Exception e){
		e.printStackTrace();
	}
}

public void searchMyProduct() {
	WebElement my_Prod=null;
	WebElement clickToSearch=null;
	String productName=null;
	try{
		my_Prod=HomePage.getInstance().getEditBoxValue(driver);
		clickToSearch=HomePage.getInstance().clickTo_Go_Button(driver);
		productName=GlobalVar.TEST_DATA.get("MyOrders");
		
		Keywords.clearEditField(my_Prod);
		Keywords.typeText(my_Prod, productName);
		Keywords.click(clickToSearch);
		
		if (GlobalVar.etpStepsReport) {
			DriverSession.getLastExecutionReportingInstance()
					.teststepreporting("ShopClues MyOrderPage ProductName : <b><i>"+productName+"</i></b> page is successfully entered into Textfield", "PASS",
							"ShopClues MyOrder Page Product Name : <b><i>"+productName+"</i></b> page should be successfully validated");

		} else {
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("ShopClues MyOrderPage ProductName : <b><i>"+productName+"</i></b> page is not successfully entered into Textfield", "FAIL",
					"ShopClues MyOrder Page Product Name : <b><i>"+productName+"</i></b> page should be successfully validated");
		}
	}
	catch(Exception e){
		e.getMessage();
	}
}

public void verifySearchProduct() {
	WebElement search_product=null;
	String productName=null;
	try{
		search_product=HomePage.getInstance().getproductNameValue(driver);
		productName=GlobalVar.TEST_DATA.get("MyOrders");

		if(productName.equalsIgnoreCase(Keywords.getTextFromObject(search_product))){
			
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("ShopClues MyOrderPage Product : <b><i>"+productName+"</i></b> is successfully verified", "PASS",
					"ShopClues MyOrderPage Product : <b><i>"+productName+"</i></b> should be successfully verified");

		}
		else{
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("ShopClues MyOrderPage Product : <b><i>"+productName+"</i></b> is not successfully verified", "FAIL",
					"ShopClues MyOrderPage Product : <b><i>"+productName+"</i></b> should be successfully verified");
		}
	}
	catch(Exception e){
		e.getMessage();
	}
}

public void productBiefDetails() {
	Map<String, String> map=new LinkedHashMap<String, String>();
	try{
		
		map=Keywords.getProductDetails(driver);
		Set<String>set=map.keySet();
		Iterator <String>itr=set.iterator();
		
		while(itr.hasNext()){
			String key=(String)itr.next();
			String value=map.get(key);
			
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("<u>ShopClues MyOrderPage Product Details: </u><br><b><i>"+key+"  :\t "+value+" </i></b> is successfully verified", "PASS",
					"ShopClues MyOrderPage Product Details: <br><b><i>"+key+"  :\t "+value+" </i></b><br> should be successfully verified");
			
		}
		GlobalVar.prodDetails=map;
		
	}
	catch(Exception e){
		DriverSession.getLastExecutionReportingInstance()
		.teststepreporting("ShopClues MyOrderPage Product Details is not successfully verified", "FAIL",
				"ShopClues MyOrderPage Product Details should be successfully verified");
	}
}

public void clickToArrowButton() {
	WebElement arrow_Bttn=null;
	try{
		arrow_Bttn=HomePage.getInstance().clickToArrowButton(driver);
		Keywords.click(arrow_Bttn);
		if(GlobalVar.etpStepsReport){
		DriverSession.getLastExecutionReportingInstance()
		.teststepreporting("ShopClues MyOrderPage Product Arrow Button is successfully clicked", "PASS",
				"ShopClues MyOrderPage Product Arrow Button should be successfully clicked");
		}
		else{
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("ShopClues MyOrderPage Product Arrow Button is not successfully clicked", "FAIL",
					"ShopClues MyOrderPage Product Arrow Button should be successfully clicked");
		}
	}
	catch(Exception e){
		e.printStackTrace();
	}
}

public void validateAndClickDropDownIcons() {
	List <WebElement> drop_Down=null;
	List<String>options=null;
	try{
		drop_Down=HomePage.getInstance().getNotificationInstance(driver);
		options=Keywords.splitRowDataWithPipeOperator(GlobalVar.TEST_DATA.get("DropDownIcon"));
		
		for(WebElement element : drop_Down){
			if(element.getText().equalsIgnoreCase(options.get(2))){
				element.click();
				
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("ShopClues MyOrderPage ImageDropDown :"+element.getText()+" is successfully clicked", "PASS",
						"ShopClues MyOrderPage ImageDropDown :"+element.getText()+" should be successfully clicked");
				break;
			}
			else{
				
				continue;
			}
		}
	}
	catch(Exception e){
		DriverSession.getLastExecutionReportingInstance()
		.teststepreporting("ShopClues MyOrderPage ImageDropDown :"+options.get(2)+" is successfully clicked", "PASS",
				"ShopClues MyOrderPage ImageDropDown :"+options.get(2)+" should be successfully clicked");
	}
}

public void verifyProductDetailOrderNumber() {
	WebElement order_Number=null;
	try{
		order_Number=HomePage.getInstance().getOrderNumberValue(driver);
		Keywords.validateElementExistOrNot(order_Number);
		//System.out.println(GlobalVar.prodDetails.get("Order ID"));
		
			if(order_Number.getText().equalsIgnoreCase(GlobalVar.prodDetails.get("Order ID")))
			{
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("ShopClues MyOrderDetailsPage order Number : <i><b>"+order_Number.getText()+"</b></i> is successfully verified", "PASS",
						"ShopClues MyOrderDetailsPage order Number : "+order_Number.getText()+" should be successfully verified");
			}
			else{
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("ShopClues MyOrderDetailsPage order Number : <i><b>"+order_Number.getText()+"</b></i> is not successfully verified", "FAIL",
						"ShopClues MyOrderDetailsPage order Number : "+order_Number.getText()+" should be successfully clicked");
			}
		
	}
	catch(Exception e){
		e.printStackTrace();
	}
}

public void verifyProductDetailOrderDate() {
	WebElement order_Date=null;
	try{
		order_Date=HomePage.getInstance().clickOrderDate(driver);
		Keywords.validateElementExistOrNot(order_Date);
		
		if(order_Date.isDisplayed())
		{
			try{
					if(order_Date.getText().equalsIgnoreCase(GlobalVar.prodDetails.get("Order Date"))){
						
						DriverSession.getLastExecutionReportingInstance()
						.teststepreporting("ShopClues MyOrderDetailsPage Order Date : <i><b>"+order_Date.getText()+"</b></i> is successfully verified", "PASS",
								"ShopClues MyOrderDetailsPage Order Date : "+order_Date.getText()+" should be successfully verified");
					
					}
					else{
						DriverSession.getLastExecutionReportingInstance()
						.teststepreporting("ShopClues MyOrderDetailsPage Order Date : <i><b>"+order_Date.getText()+"</b></i> is not successfully verified", "FAIL",
								"ShopClues MyOrderDetailsPage Order Date : "+order_Date.getText()+" should be successfully verified");
					}
			}
			catch(Exception innerExcp){
				innerExcp.getMessage();
			}
		}
	}
	catch(Exception e){
		e.printStackTrace();
	}
}

public void verifyProductDetailOrderstatus() {
	WebElement prod_Status=null;
	try{
		prod_Status=HomePage.getInstance().o_Status(driver);
		Keywords.validateElementExistOrNot(prod_Status);
		if(prod_Status.isDisplayed())
		{
				if(prod_Status.getText().equalsIgnoreCase(GlobalVar.prodDetails.get("Status"))){
						
						DriverSession.getLastExecutionReportingInstance()
						.teststepreporting("ShopClues MyOrderDetailsPage Order Date : <i><b>"+prod_Status.getText()+"</b></i> is successfully verified", "PASS",
								"ShopClues MyOrderDetailsPage Order Date : "+prod_Status.getText()+" should be successfully verified");
					
					}
					else{
						DriverSession.getLastExecutionReportingInstance()
						.teststepreporting("ShopClues MyOrderDetailsPage Order Date : <i><b>"+prod_Status.getText()+"</b></i> is not successfully verified", "FAIL",
								"ShopClues MyOrderDetailsPage Order Date : "+prod_Status.getText()+" should be successfully verified");
					}
			}
	}
	catch(Exception e){
		e.getMessage();
	}
	
}

public void verifyProductInformation() {
	WebElement prod_Info=null;
	try{
		prod_Info=HomePage.getInstance().getActualProdValue(driver);
		Keywords.validateElementExistOrNot(prod_Info);
		
		if(prod_Info.getText().equalsIgnoreCase(GlobalVar.TEST_DATA.get("MyOrders"))){
			
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("ShopClues MyOrderDetailsPage PRODUCT INFORMATION : <i><b>"+prod_Info.getText()+"</b></i> is successfully verified", "PASS",
					"ShopClues MyOrderDetailsPage PRODUCT INFORMATION : "+prod_Info.getText()+" should be successfully verified");
		}
		else{
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("ShopClues MyOrderDetailsPage PRODUCT INFORMATION : <i><b>"+prod_Info.getText()+"</b></i> is not successfully verified", "FAIL",
					"ShopClues MyOrderDetailsPage PRODUCT INFORMATION : "+prod_Info.getText()+" should be successfully verified");
		}
	}
	catch(Exception e){
		e.printStackTrace();
	}
}

public void validateSellingPriceAndQuantity() {
	WebElement sellingprice=null;
	WebElement quantity=null;
	float total=0.0f;
	try{
		sellingprice=HomePage.getInstance().getSellingpriceValue(driver);
		quantity=HomePage.getInstance().getProdQty(driver);
		total=Keywords.verifyShoppingCartPageDetails(quantity,sellingprice);
		GlobalVar.subTotal=total;
		if(GlobalVar.etpStepsReport){
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("ShopClues MyOrderDetailsPage PRODUCT INFORMATION <br>selling price: <i><b>"+sellingprice.getText()+"</b></i><br>Quantity: <i><b>"+quantity.getText()+"</i></b><br>SUB TOTAl is: <u><i><b>"+Math.round(total)+"</u></i></b> <br> successfully verified", "PASS",
					"ShopClues MyOrderDetailsPage PRODUCT INFORMATION should be successfully verified");
		}
		else{
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("ShopClues MyOrderDetailsPage PRODUCT INFORMATION <br>selling price: <i><b>"+sellingprice.getText()+"</b></i><br>Quantity: <i><b>"+quantity.getText()+"</i></b><br>SUB TOTAl is: "+Math.round(total)+" <br> is not successfully verified", "FAIL",
					"ShopClues MyOrderDetailsPage PRODUCT INFORMATION should be successfully verified");
		}
		
	}
	catch(Exception e){
		e.printStackTrace();
	}
}

public void paymentInformation() {
	WebElement subTotal=null;
	float grandTotal=0.0f;
	try{
		subTotal=HomePage.getInstance().clickSubTotal(driver);
		grandTotal=Keywords.valueAfterCODCharges(GlobalVar.subTotal,Integer.parseInt(GlobalVar.TEST_DATA.get("CODCharges")));
				
		if(subTotal.getText().equalsIgnoreCase(String.valueOf(Math.round(GlobalVar.subTotal)))){
			
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("ShopClues MyOrderDetailsPage PRODUCT INFORMATION <br>Sub Total : <i><b>"+subTotal.getText()+"</i></b> <br>COD Charges" +
					" <i><b>"+GlobalVar.TEST_DATA.get("CODCharges")+" </i></u><br> GRAND TOTAL : <i><b>"+grandTotal+"</i></b> successfully verified", "PASS",
					"ShopClues MyOrderDetailsPage PRODUCT INFORMATION GRAND TOTAL should be successfully verified");
		}
		else{
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("ShopClues MyOrderDetailsPage PRODUCT INFORMATION <br>Sub Total : <i><b>"+subTotal.getText()+"</i></b> <br>COD Charges" +
					" <i><b>"+GlobalVar.TEST_DATA.get("CODCharges")+" </i></u><br> GRAND TOTAL : <i><b>"+grandTotal+"</i></b> is not successfully verified", "FAIL",
					"ShopClues MyOrderDetailsPage PRODUCT INFORMATION GRAND TOTAL should be successfully verified");
		}
	}
	catch(Exception e){
		e.getMessage();
	}
	
}

public void contactInformation() {
	WebElement email=null;
	try{
		email=HomePage.getInstance().getContactValue(driver);
		if(email.getText().trim().equalsIgnoreCase(GlobalVar.TEST_DATA.get("EmailID"))){
			
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("ShopClues MyOrderDetailsPage CONTACT INFORMATION : <i><b>"+email.getText()+"</b></i> is successfully verified", "PASS",
					"ShopClues MyOrderDetailsPage CONTACT INFORMATION : <i><b>"+email.getText()+" should be successfully verified");
		}
		else{
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("ShopClues MyOrderDetailsPage CONTACT INFORMATION : <i><b>"+email.getText()+"</b></i> is not successfully verified", "FAIL",
					"ShopClues MyOrderDetailsPage CONTACT INFORMATION : <i><b>"+email.getText()+" should be successfully verified");
		}
	}
	catch(Exception e){
		e.printStackTrace();
	}
}

public void verifyProductShippingAddress() {
	WebElement f_Name=null,l_Name=null,address=null,city=null,state=null,pin_code=null,mobile=null;
	List<String> split_ShippingAddress=null;
	try{
		f_Name=HomePage.getInstance().clickToFirstnameShipping(driver); l_Name=HomePage.getInstance().clickToLastnameShipping(driver);
		address=HomePage.getInstance().clickToAddressShipping(driver);	city=HomePage.getInstance().clickToCityShipping(driver);
		state=HomePage.getInstance().clickToStateShipping(driver); 		pin_code=HomePage.getInstance().clickToPinShipping(driver);
		mobile=HomePage.getInstance().clickToMobileShipping(driver);
		
		split_ShippingAddress=Keywords.splitRowDataWithPipeOperator(GlobalVar.TEST_DATA.get("ShippingAddress"));
		if(f_Name.getText().equalsIgnoreCase(split_ShippingAddress.get(0)) && l_Name.getText().equalsIgnoreCase(split_ShippingAddress.get(1)) && address.getText().equalsIgnoreCase(split_ShippingAddress.get(2)) && 
				city.getText().equalsIgnoreCase(split_ShippingAddress.get(3)) && state.getText().equalsIgnoreCase(split_ShippingAddress.get(4)) && 
				pin_code.getText().equalsIgnoreCase(split_ShippingAddress.get(5)) && mobile.getText().equalsIgnoreCase(split_ShippingAddress.get(6))){
			
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("ShopClues MyOrderDetailsPage SHIPPING ADDRESS : <br>First Name : <i><b>"+f_Name.getText()+"</b></i><br>Last Name : <i><b>"+l_Name.getText()+"</i></b><br>" +
					"Address : <i><b>"+address.getText()+"</i></b><br>City : <i><b>"+city.getText()+"</i></b><br>" +
							"State : <i><b>"+state.getText()+"</i></b><br>PinCode : <i><b>"+pin_code.getText()+"</i></b><br>" +
									"Mobile Number : <i><b>"+mobile.getText()+"</i></b> is successfully verified", "PASS",
					"ShopClues MyOrderDetailsPage SHIPPING ADDRESS should be successfully verified");
			
		}
		else{
			
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("ShopClues MyOrderDetailsPage SHIPPING ADDRESS : <br>First Name : <i><b>"+f_Name.getText()+"</b></i><br>Last Name : <i><b>"+l_Name.getText()+"</i></b><br>" +
					"Address : <i><b>"+address.getText()+"</i></b><br>City : <i><b>"+city.getText()+"</i></b><br>" +
							"State : <i><b>"+state.getText()+"</i></b><br>PinCode : <i><b>"+pin_code.getText()+"</i></b><br>" +
									"Mobile Number : <i><b>"+mobile.getText()+"</i></b> is not successfully verified", "FAIL",
					"ShopClues MyOrderDetailsPage SHIPPING ADDRESS should be successfully verified");
		}
	}
	catch(Exception e){
		e.getMessage();
	}
}

public void validateDropDownView() {
	WebElement list_Type=null;
	
	try{
		list_Type=HomePage.getInstance().clickProductFrame(driver);
		if(list_Type!=null){
			
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("ShopClues PRODUCT LIST is in <i><b>List Format</b></i> is successfully verified", "PASS",
					"ShopClues PRODUCT LIST is in <i><b>List Format</b></i> should be successfully verified");
		}
		else{
			if(HomePage.getInstance().getGridViewInstance(driver)!=null){
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("ShopClues PRODUCT LIST is in <i><b>GRID Format</b></i> is successfully verified", "PASS",
						"ShopClues PRODUCT LIST is in <i><b>GRID Format</b></i> should be successfully verified");
			}
		}

	}
	catch(Exception e){}
}

public void validateFavouritesButton() {
	WebElement fav=null;
	boolean flag=false;
	int count=2;
	try{
		try{
			if(!flag){
			if(HomePage.getInstance().getFavouritesOption(driver) != null){
				flag=true;
				for(int i=0;i<count;i++){
					Keywords.hideKeyBoard();
				}
			}
			}
		}
		catch(Exception innerException){
			for(int i=0;i<count;i++){
				Keywords.hideKeyBoard();
		}
		}
		
		if(HomePage.getInstance().getFavouritesOption(driver)!=null){
			fav=HomePage.getInstance().getFavouritesOption(driver);
			
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("ShopClues Product Detail Page <i><b>Favourite Cart is Empty </b></i> is successfully verified", "PASS",
					"ShopClues Product Detail Page <i><b>Favourite Cart is Empty </b></i> should be successfully verified");
		}
		else{
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("ShopClues Product Detail Page <i><b>Favourite Cart is not Empty </b></i> is successfully verified", "FAIL",
					"ShopClues Product Detail Page <i><b>Favourite Cart is Empty </b></i> should be successfully verified");
		}
}
	catch(Exception e){
		e.printStackTrace();
	}
}

public void clickToMenuOverLay() {
	WebElement overLay=null;
	WebElement list_Type=null;
	WebElement addToFavButton=null;
	try{
		overLay=HomePage.getInstance().clickToOverLay(driver);
		list_Type=HomePage.getInstance().clickProductFrame(driver);
		
		if(list_Type!=null){
			Keywords.click(overLay);
			addToFavButton=HomePage.getInstance().clickToFavButton(driver);
			Keywords.click(addToFavButton);
			
				if(GlobalVar.etpStepsReport){
					DriverSession.getLastExecutionReportingInstance()
						.teststepreporting("ShopClues Various ProductList <br>Menu OverLay <i><b> successfully clicked", "PASS",
								"ShopClues Various ProductList <br>Menu OverLay <i><b> should be successfully clicked");
				}
				else{
					DriverSession.getLastExecutionReportingInstance()
						.teststepreporting("ShopClues Various ProductList <br>Menu OverLay <i><b> is not successfully clicked", "FAIL",
								"ShopClues Various ProductList <br>Menu OverLay <i><b> should be successfully clicked");
				}
		}
	}
	catch(Exception e){
		e.getMessage();
	}
}

public void sendProductToFavourite() {
	WebElement overLay=null;
	WebElement list_Type=null;
	WebElement addToFavButton=null,fav=null;
	try{
		list_Type=HomePage.getInstance().clickProductFrame(driver);
		
		if(list_Type!=null){
			
			overLay=HomePage.getInstance().clickToOverLay(driver);
					
			if(GlobalVar.TEST_DATA.get("FavouriteCart").equalsIgnoreCase(HomePage.getInstance().click_SelectedItem(driver).getText())){
				fav=HomePage.getInstance().product_FavouriteLink(driver);
			}
			if(fav!=null){
						
				DriverSession.getLastExecutionReportingInstance()
					.teststepreporting("ShopClues Various ProductList <br>Favourite Cart is not Empty <i><b> successfully Validated", "PASS",
							"ShopClues Various ProductList <br>Favourite Cart is not Empty <i><b> should be successfully Validated");
			}
			else{
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("ShopClues Various ProductList <br>Favourite Cart is Empty <i><b> successfully Validated", "FAIL",
						"ShopClues Various ProductList <br>Favourite Cart is not Empty <i><b> should be successfully Validated");
	
			}
			
		}
	}
	catch(Exception e){
		e.printStackTrace();
	}
}

public void clickToFavouritePage() {
	WebElement clickToFavButton=null;
	try{
		clickToFavButton=HomePage.getInstance().product_FavouriteLink(driver);
		Keywords.click(clickToFavButton);
		
		Keywords.explicitWait(2);
		if(GlobalVar.etpStepsReport){
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("ShopClues <i><b>MyFavourite</b></i> button successfully clicked", "PASS",
					"ShopClues <i><b>MyFavourite</b></i> button should be successfully clicked");
		}
		else{
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("ShopClues <i><b>MyFavourite</b></i> button is not successfully clicked", "FAIL",
					"ShopClues <i><b>MyFavourite</b></i> button should be successfully clicked");
		}
	}
	catch(Exception e){
		e.printStackTrace();
	}
}

public void validateFavouritePage() {
	WebElement fav_Page=null;
	try{
		fav_Page=HomePage.getInstance().clickTo_FavLogo(driver);
		Keywords.validateElementExistOrNot(fav_Page);
		
		if(GlobalVar.etpStepsReport){
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("ShopClues <i><b>MyFavourite</b></i> page successfully validated", "PASS",
					"ShopClues <i><b>MyFavourite</b></i> page should be successfully validated");
		}
		else{
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("ShopClues <i><b>MyFavourite</b></i> page is not successfully validated", "FAIL",
					"ShopClues <i><b>MyFavourite</b></i> page should be successfully validated");
		}
	}
	catch(Exception e){
		e.printStackTrace();
	}
}

public void verifyProductInFavouritepage() {
	WebElement prod_Name=null;
	String p_Name=null,p_Name_DataSheet=null;
	try{
		prod_Name=HomePage.getInstance().getProdNameFavouritepage(driver);
		p_Name=Keywords.getTextFromObject(prod_Name);
		p_Name_DataSheet=GlobalVar.TEST_DATA.get("FavouriteCart");
		
		if(p_Name.equalsIgnoreCase(p_Name_DataSheet)){
			
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Inside <i><b>MyFavourite</b></i> page product <i><b>"+p_Name+"</b></i> successfully validated", "PASS",
					"ShopClues <i><b>MyFavourite</b></i> page product <i><b>"+p_Name+"</b></i> should be successfully validated");
		}
		else{
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Inside <i><b>MyFavourite</b></i> page product <i><b>"+p_Name+"</b></i> is not successfully validated", "FAIL",
					"ShopClues <i><b>MyFavourite</b></i> page product <i><b>"+p_Name+"</b></i> should be successfully validated");
		}
	}
	catch(Exception e){
		
	}
}

public void removeProductFromFavourite() {
	WebElement favLinkPopup=null;
	WebElement unFavourite=null;
	try{
		favLinkPopup=HomePage.getInstance().clickToOverLay(driver);
		Keywords.click(favLinkPopup);
		unFavourite=HomePage.getInstance().clickToFavButton(driver);
		Keywords.click(unFavourite);
		
		if(GlobalVar.etpStepsReport){
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("ShopClues <i><b>MyFavourite</b></i> page product name : "+GlobalVar.TEST_DATA.get("FavouriteCart")+"successfully removed fromo Favourite Cart", "PASS",
					"ShopClues <i><b>MyFavourite</b></i> page should be successfully validated");
		}
		else{
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("ShopClues <i><b>MyFavourite</b></i> page is not successfully validated", "FAIL",
					"ShopClues <i><b>MyFavourite</b></i> page should be successfully validated");
		}
		
	}
	catch(Exception e){
		e.printStackTrace();
	}
}

public void validateFavouritePageIsEmptyOrNot() {
	WebElement validate_Favouritepage=null;
	WebElement empty_FavouriteCartmessage=null;
	try{
		Keywords.hideKeyBoard();
		validate_Favouritepage=HomePage.getInstance().getFavouritesOption(driver);
		Keywords.click(validate_Favouritepage);
		
			
			empty_FavouriteCartmessage=HomePage.getInstance().clickToMesssage(driver);
			if(empty_FavouriteCartmessage.getText().equalsIgnoreCase(GlobalVar.TEST_DATA.get("EmptyFavouriteCartMessage"))){
			
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("No Product : "+GlobalVar.TEST_DATA.get("FavouriteCart")+" is found in Favourite Cart with this message :<br><i><b>"+empty_FavouriteCartmessage.getText()+"", "PASS",
						"No Product : "+GlobalVar.TEST_DATA.get("FavouriteCart")+" is found in Favourite Cart");
			}
			
			else{
				if(HomePage.getInstance().clickProductFrame(driver)!=null){
					
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("Product : "+GlobalVar.TEST_DATA.get("FavouriteCart")+" is found in Favourite Cart ", "FAIL",
						"No Product : "+GlobalVar.TEST_DATA.get("FavouriteCart")+" is found in Favourite Cart");
				}
			}
			Keywords.hideKeyBoard();
			
	}
	catch(Exception e){
		
	}
}

public void verifyAndClickToGridLayOut() {
WebElement list_Type=null;
WebElement grid_Icon=null;
	try{

		list_Type=HomePage.getInstance().clickProductFrame(driver);
		if(list_Type!=null){
			grid_Icon=HomePage.getInstance().clickToGridIcon(driver);
			Keywords.click(grid_Icon);
			
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("ShopClues PRODUCT LIST is in <i><b>List Format</b></i> and now successfully clicked to <b><i>GRID VIEW</i></b> verified", "PASS",
					"ShopClues PRODUCT LIST is in <i><b>List Format</b></i> should be successfully verified");
		}
		else{
			if(HomePage.getInstance().getGridViewInstance(driver)!=null){
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("ShopClues PRODUCT LIST is in <i><b>GRID Format</b></i> is successfully verified", "PASS",
						"ShopClues PRODUCT LIST is in <i><b>GRID Format</b></i> should be successfully verified");
			}
		}

	}
	catch(Exception e){}
}

public void verifyproductListGridView() {
	WebElement prod_GridView=null;
	WebElement list_Type=null;
	List<WebElement> options=null;
	try{
		list_Type=HomePage.getInstance().clickProductFrame(driver);
		prod_GridView=HomePage.getInstance().getGridView(driver);
		options=HomePage.getInstance().getNotificationInstance(driver);
		
		for(WebElement element : options)
		{
			if(element.getText().equalsIgnoreCase(GlobalVar.TEST_DATA.get("FavouriteCart"))){
				
				if(prod_GridView!=null){
					Keywords.explicitWait(1);
					Keywords.click(HomePage.getInstance().clickToOverLay(driver));
					Keywords.click(HomePage.getInstance().clickToFavButton(driver));
							
					DriverSession.getLastExecutionReportingInstance()
						.teststepreporting("ShopClues PRODUCT LIST is in <i><b><u>GRID Format</u></b></i> and Successfully Enter to <i><b> FAVOURITE </i></b> is successfully verified", "PASS",
							"ShopClues PRODUCT LIST is in <i><b>GRID Format</b></i> should be successfully verified");
							
							break;
						}
				else{
					DriverSession.getLastExecutionReportingInstance()
					.teststepreporting("ShopClues PRODUCT LIST is not in <i><b><u>GRID Format</u></b></i> successfully verified", "FAIL",
							"ShopClues PRODUCT LIST is in <i><b>GRID Format</b></i> should be successfully verified");
				}
						
				}
			}
	}
	catch(Exception e){
		e.printStackTrace();
	}
}

public void clickAndVerifyFavouriteButton() {
	WebElement click_Fav=null,prod_GridView=null,prodInsideFavourite=null;
	String item_Name=null;
	
	try{
		click_Fav=HomePage.getInstance().product_FavouriteLink(driver);
		Keywords.click(click_Fav);
		
		prod_GridView=HomePage.getInstance().getGridView(driver);
		prodInsideFavourite=HomePage.getInstance().clickTOSignINLogo(driver);
		
		item_Name=GlobalVar.TEST_DATA.get("FavouriteCart");
		if(prod_GridView!=null){
								
				if(prodInsideFavourite.getText().equalsIgnoreCase(item_Name)){
					
					DriverSession.getLastExecutionReportingInstance()
					.teststepreporting("Product in Favourite Page is in <i><b><u>GRID VIEW</u></b></i> and Product name : "+prodInsideFavourite.getText()+" is Successfully verified", "PASS",
						"Product in Favourite Page is in <i><b>GRID Format</b></i> should be successfully verified");
				}
				else{
					
					DriverSession.getLastExecutionReportingInstance()
					.teststepreporting("Product in Favourite Page is in <i><b><u>GRID VIEW</u></b></i> and Product name : "+prodInsideFavourite.getText()+" is not Successfully verified", "FAIL",
						"Product in Favourite Page is in <i><b>GRID Format</b></i> should be successfully verified");
				}
			}
	}
	catch(Exception e){
		e.getMessage();
	}
}

public void verifyRemoveFromFavourites() {
	WebElement clickOverLay=null;
	
	try{
		clickOverLay=HomePage.getInstance().clickToOverLay(driver);
		Keywords.click(clickOverLay);
		Keywords.click(HomePage.getInstance().clickToFavButton(driver));
		
		if(GlobalVar.etpStepsReport){
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Product Favourites Page , product nname : "+GlobalVar.TEST_DATA.get("FavouriteCart")+" is successfully removed from favourites cart", "PASS",
					"ShopClues <i><b>MyFavourite</b></i> page should be successfully validated");
		}
		else{
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("ShopClues <i><b>MyFavourite</b></i> page is not successfully validated", "FAIL",
					"ShopClues <i><b>MyFavourite</b></i> page should be successfully validated");
		}
	}
	catch(Exception e){
		e.printStackTrace();
	}
}

public void verifyCurrentViewMode() {
	WebElement gridView=null,listView=null;
	try{
		gridView=HomePage.getInstance().getGridView(driver);
		listView=HomePage.getInstance().clickProductFrame(driver);
		
		if(gridView!=null){
			
			Keywords.click(HomePage.getInstance().clickToGridIcon(driver));
			Keywords.explicitWait(1);
			
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Shopclues Product ListPage back to <b><i> LIST VIEW </b></i> is successfully verified", "PASS",
					"Shopclues Product List Page back to <b><i> LIST VIEW </b></i> should be successfully validated");
		}
		else{
			if(listView!=null)
			{
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("Shopclues Product ListPage is already in <b><i> LIST VIEW </b></i> is not successfully verified", "FAIL",
						"Shopclues Product List Page back to <b><i> LIST VIEW </b></i> should be successfully validated");
			}
		}
	}
	catch(Exception e){
		
	}
}
/** ***************************************************************************************
 * Keyword-Name:    clickOnMyOrdersMenuDropDown
 * Usage:           void clickOnMyOrdersMenuDropDown()
 * Description:     Click on my orders menu 
 * Author:          Automators
 * Dated:           2nd June 2015
 * Notes:   
 *************************************************************************************** **/
public void clickOnMyOrdersMenuDropDown()
{
	WebElement element=null;
	try
	{
		element=HomePage.getInstance().myOrder(driver);
		Keywords.dynamicwait(driver, 20, element);
		Keywords.click(element);
				
		if(GlobalVar.etpStepsReport)
		{			
			 DriverSession.getLastExecutionReportingInstance().teststepreporting("My orders dropdown item clicked successfully","PASS","Should click on my orders dropdown items");
		}
		else
		{
			DriverSession.getLastExecutionReportingInstance().teststepreporting("My orders dropdown item not clicked","FAIL","Should click on my orders dropdown items");
		}
	}
	catch(Exception e)
		{
		DriverSession.getLastExecutionReportingInstance().teststepreporting("My Orders object not found", "FAIL","Should click on my orders dropdown items");
		}
}

/** ***************************************************************************************
 * Keyword-Name:    clickOnProductExpandArrow
 * Usage:           void clickOnProductExpandArrow()
 * Description:     Click on order expand details side arrow under my orders page
 * Author:          Automators
 * Dated:           2nd June 2015
 * Notes:   
 *************************************************************************************** **/
public void clickOnProductExpandArrow()
{
	WebElement element=null;
	try
	{
		element=HomePage.getInstance().myOrder_ProductOrderArrowImage(driver);
//		Keywords.dynamicwait(driver, 20, element);
		Keywords.click(element);
				
		if(GlobalVar.etpStepsReport)
		{			
			 DriverSession.getLastExecutionReportingInstance().teststepreporting("My orders arrow clicked successfully","PASS","Should click on my orders arrow");
		}
		else
		{
			DriverSession.getLastExecutionReportingInstance().teststepreporting("My orders arrow not clicked","FAIL","Should click on my orders arrow");
		}
	}
	catch(Exception e)
		{
		DriverSession.getLastExecutionReportingInstance().teststepreporting("My Orders object not found", "FAIL","Should click on my orders arrow");
		}
}

/** ***************************************************************************************
 * Keyword-Name:    clickOnProductOrderDetailsButton
 * Usage:           void clickOnProductOrderDetailsButton()
 * Description:     Click on order details button under my orders page
 * Author:          Automators
 * Dated:           2nd June 2015
 * Notes:   
 *************************************************************************************** **/
public void clickOnProductOrderDetailsButton()
{
	WebElement element=null;
	try
	{
		element=HomePage.getInstance().myOrder_DetailsButton(driver);
		Keywords.dynamicwait(driver, 20, element);
		Keywords.click(element);
				
		if(GlobalVar.etpStepsReport)
		{			
			 DriverSession.getLastExecutionReportingInstance().teststepreporting("Order Details button clicked successfully","PASS","Should click on Order Details button");
		}
		else
		{
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Order Details button not clicked","FAIL","Should click on Order Details button");
		}
	}
	catch(Exception e)
		{
		DriverSession.getLastExecutionReportingInstance().teststepreporting("Order Details button object not found", "FAIL","Should click on Order Details button");
		}
}


/** ***************************************************************************************
 * Keyword-Name:    getStatusFromOrderDetails
 * Usage:           void getStatusFromOrderDetails()
 * Description:     Get status from order details
 * Author:          Automators
 * Dated:           2nd June 2015
 * Notes:   
 *************************************************************************************** **/
public void getStatusFromOrderDetails()
{
	WebElement element=null;
	String sts;
	try
	{
		
		element=HomePage.getInstance().detailsPage_OrderStatus(driver);
		Keywords.waitForObject(element);
		sts = Keywords.getText(element);
		
		GlobalVar.OrderStatus = sts;
		
		if(GlobalVar.etpStepsReport)
		{			
			 DriverSession.getLastExecutionReportingInstance().teststepreporting("Order status fetched successfully","PASS","Should fetch Order status");
		}
		else
		{
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Order status not fetched","FAIL","Should fetch Order status");
		}
	}
	catch(Exception e)
		{
		DriverSession.getLastExecutionReportingInstance().teststepreporting("Order status object not found", "FAIL","Should fetch Order status");
		}
}


/** ***************************************************************************************
 * Keyword-Name:    clickOnProductCancelOrderButton
 * Usage:           void clickOnProductCancelOrderButton()
 * Description:     Click on cancel order button under my orders page
 * Author:          Automators
 * Dated:           2nd June 2015
 * Notes:   
 *************************************************************************************** **/
public void clickOnProductCancelOrderButton()
{
	WebElement element=null;
	try
	{
		element=HomePage.getInstance().detailsPage_CancelOrderButton(driver);
		Keywords.dynamicwait(driver, 20, element);
		Keywords.click(element);
				
		if(GlobalVar.etpStepsReport)
		{			
			 DriverSession.getLastExecutionReportingInstance().teststepreporting("Cancel Order button clicked successfully","PASS","Should click on Cancel Order button");
		}
		else
		{
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Cancel Order button not clicked","FAIL","Should click on Cancel Order button");
		}
	}
	catch(Exception e)
		{
		DriverSession.getLastExecutionReportingInstance().teststepreporting("Cancel Order button object not found", "FAIL","Should click on Cancel Order button");
		}
}

/** ***************************************************************************************
 * Keyword-Name:    verifyCancellationReasonDropDown
 * Usage:           void verifyCancellationReasonDropDown()
 * Description:     verify Cancellation Reason DropDown
 * Author:          Automators
 * Dated:           2nd June 2015
 * Notes:   
 *************************************************************************************** **/
public void verifyCancellationReasonDropDown()
{
	WebElement element=null;
	try
	{
		element=HomePage.getInstance().detailsPage_ReasonSelect(driver);
		Keywords.dynamicwait(driver, 20, element);
		Keywords.isElementPresent(element);
				
		if(GlobalVar.etpStepsReport)
		{			
			 DriverSession.getLastExecutionReportingInstance().teststepreporting("Cancellation reason dropdown verified successfully","PASS","Should verify cancellation reason dropdown");
		}
		else
		{
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Cancellation reason dropdown not verified","FAIL","Should verify cancellation reason dropdown");
		}
	}
	catch(Exception e)
		{
		DriverSession.getLastExecutionReportingInstance().teststepreporting("Cancellation reason dropdown object not found", "FAIL","Should verify cancellation reason dropdown");
		}
}

/** ***************************************************************************************
 * Keyword-Name:    selectCancellationReason
 * Usage:           void selectCancellationReason()
 * Description:     Select Cancellation Reason
 * Author:          Automators
 * Dated:           2nd June 2015
 * Notes:   
 *************************************************************************************** **/
public void selectCancellationReason()
{
	WebElement element=null;
	String reason;
	try
	{
		element=HomePage.getInstance().detailsPage_ReasonSelect(driver);
		Keywords.dynamicwait(driver, 20, element);
		Keywords.click(element);
		
		reason = GlobalVar.TEST_DATA.get("Cancellation Reason");
		element=HomePage.getInstance().detailsPage_ReasonValue(driver,reason);
		Keywords.click(element);
		
		element=HomePage.getInstance().detailsPage_ReasonSubmit(driver);
		Keywords.click(element);
		
				
		if(GlobalVar.etpStepsReport)
		{			
			 DriverSession.getLastExecutionReportingInstance().teststepreporting("Cancellation reason selected successfully","PASS","Should select cancellation reason");
		}
		else
		{
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Cancellation reason  not selected","FAIL","Should select cancellation reason");
		}
	}
	catch(Exception e)
		{
		DriverSession.getLastExecutionReportingInstance().teststepreporting("Cancellation reason dropdown object not found", "FAIL","Should select cancellation reason");
		}
}

/** ***************************************************************************************
 * Keyword-Name:    verifyOrderStatusFromDetailsPage
 * Usage:           void verifyOrderStatusFromDetailsPage()
 * Description:     Verify Order status
 * Author:          Automators
 * Dated:           2nd June 2015
 * Notes:   
 *************************************************************************************** **/
public void verifyOrderStatusFromDetailsPage()
{
	WebElement element=null;
	String name = null;
	boolean flag = false;
	try
	{
		element=HomePage.getInstance().detailsPage_OrderStatus(driver);
		Keywords.dynamicwait(driver, 20, element);
		name = Keywords.getText(element);
		//System.out.println("Status  : " + name + " orderstatus" + GlobalVar.OrderStatus);
		
		if(name.trim().equalsIgnoreCase(GlobalVar.OrderStatus))
			flag = false;
		else
			flag = true;			
		
		if(GlobalVar.etpStepsReport && flag == true)
		{			
			 DriverSession.getLastExecutionReportingInstance().teststepreporting(name + " Order status verified successfully","PASS","Should verify Order status");
		}
		else
		{
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Order status not verified","FAIL","Should verify Order status");
		}
	}
	catch(Exception e)
		{
		DriverSession.getLastExecutionReportingInstance().teststepreporting("Order status object not found", "FAIL","Should verify Order status");
		}
	
}
/** ***************************************************************************************
 * Keyword-Name:    getProductNameFromMyOrders
 * Usage:           void getProductNameFromMyOrders()
 * Description:     Get product Name from my orders page
 * Author:          Automators
 * Dated:           2nd June 2015
 * Notes:   
 *************************************************************************************** **/
public void getProductNameFromMyOrders()
{
	WebElement element=null;
	String Name = null;
	try
	{
		element=HomePage.getInstance().myOrder_ProductName(driver);
		Keywords.dynamicwait(driver, 20, element);
		Name = Keywords.getText(element);
		//System.out.println("Price  : " + Name);
		
		GlobalVar.OrderName = Name;
		if(GlobalVar.etpStepsReport)
		{			
			 DriverSession.getLastExecutionReportingInstance().teststepreporting(Name + " Product Name fetched successfully","PASS","Should fetch product Name");
		}
		else
		{
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Product Name not fetched","FAIL","Should fetch product Name");
		}
	}
	catch(Exception e)
		{
		DriverSession.getLastExecutionReportingInstance().teststepreporting("Product Name object not found", "FAIL","Should fetch product Name");
		}
	
}

/** ***************************************************************************************
 * Keyword-Name:    getProductPriceFromMyOrders
 * Usage:           void getProductPriceFromMyOrders()
 * Description:     Get product price from my orders page
 * Author:          Automators
 * Dated:           2nd June 2015
 * Notes:   
 *************************************************************************************** **/
public void getProductPriceFromMyOrders()
{
	WebElement element=null;
	String price = null;
	try
	{
		element=HomePage.getInstance().myOrder_ProductOrderPrice(driver);
		Keywords.dynamicwait(driver, 20, element);
		price = Keywords.getText(element);
		//System.out.println("Price  : " + price);
		
		GlobalVar.OrderPrice = price;
		if(GlobalVar.etpStepsReport)
		{			
			 DriverSession.getLastExecutionReportingInstance().teststepreporting(price + " Product price fetched successfully","PASS","Should fetch product price");
		}
		else
		{
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Product price not fetched","FAIL","Should fetch product price");
		}
	}
	catch(Exception e)
		{
		DriverSession.getLastExecutionReportingInstance().teststepreporting("Product price object not found", "FAIL","Should fetch product price");
		}
	
}

/** ***************************************************************************************
 * Keyword-Name:    clickOnProductReOderButton
 * Usage:           void clickOnProductReOderButton()
 * Description:     Click on Reorder button under my orders page
 * Author:          Automators
 * Dated:           2nd June 2015
 * Notes:   
 *************************************************************************************** **/
public void clickOnProductReOderButton()
{
	WebElement element=null;
	try
	{
		element=HomePage.getInstance().myOrder_ReorderButton(driver);
		Keywords.dynamicwait(driver, 20, element);
		Keywords.click(element);
				
		if(GlobalVar.etpStepsReport)
		{			
			 DriverSession.getLastExecutionReportingInstance().teststepreporting("Reorder button clicked successfully","PASS","Should click on Reorder button");
		}
		else
		{
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Reorder button not clicked","FAIL","Should click on Reorder button");
		}
	}
	catch(Exception e)
		{
		DriverSession.getLastExecutionReportingInstance().teststepreporting("Reorder button object not found", "FAIL","Should click on Reorder button");
		}
}

/** ***************************************************************************************
 * Keyword-Name:    verifyOrderNameFromShoppingCart
 * Usage:           void verifyOrderNameFromShoppingCart()
 * Description:     Verify my orders page order name from shopping cart page
 * Author:          Automators
 * Dated:           2nd June 2015
 * Notes:   
 *************************************************************************************** **/
public void verifyOrderNameFromShoppingCart ()
{
	WebElement element=null;
	String name = null;
	try
	{
		element=HomePage.getInstance().placeOrder_ProductName(driver);
		Keywords.dynamicwait(driver, 20, element);
		name = Keywords.getText(element);
		//System.out.println("name  : " + name);
		
		if(GlobalVar.etpStepsReport && name.trim().equalsIgnoreCase(GlobalVar.OrderName))
		{			
			 DriverSession.getLastExecutionReportingInstance().teststepreporting(name + " Product name verified successfully","PASS","Should verify product name");
		}
		else
		{
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Product name not verified","FAIL","Should verify product name");
		}
	}
	catch(Exception e)
		{
		DriverSession.getLastExecutionReportingInstance().teststepreporting("Product name object not found", "FAIL","Should verify product name");
		}
	
}

/** ***************************************************************************************
 * Keyword-Name:    verifyOrderPriceFromShoppingCart
 * Usage:           void verifyOrderPriceFromShoppingCart()
 * Description:     Verify my orders page order price from shopping cart page
 * Author:          Automators
 * Dated:           2nd June 2015
 * Notes:   
 *************************************************************************************** **/
public void verifyOrderPriceFromShoppingCart ()
{
	WebElement element=null;
	String price = null;
	String price1;
	try
	{
		
		element=HomePage.getInstance().placeOrder_ProductPrice(driver);
		Keywords.dynamicwait(driver, 20, element);
		price = Keywords.getText(element);
		//System.out.println("name  : " + price);
		price1 = price.replace(",", "");
				
		//System.out.println("Price1New : " + price1 + " Price2Old : " + GlobalVar.OrderPrice);
		
		if(GlobalVar.etpStepsReport && GlobalVar.OrderPrice.contains(price1))
		{			
			 DriverSession.getLastExecutionReportingInstance().teststepreporting(price1 +" Product price verified successfully","PASS","Should verify product price");
		}
		else
		{
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Product price not verified","FAIL","Should verify product price");
		}
	}
	catch(Exception e)
		{
		DriverSession.getLastExecutionReportingInstance().teststepreporting("Product price object not found", "FAIL","Should verify product price");
		}
	
}

public void clickCartToMenuOverLay() {
	WebElement overLay=null;
	WebElement list_Type=null;
	String cart_Value=null;
	try{
		overLay=HomePage.getInstance().clickToOverLay(driver);
		list_Type=HomePage.getInstance().clickProductFrame(driver);
		
		if(list_Type!=null){
			
			Keywords.click(overLay);
			Keywords.click(HomePage.getInstance().getAddToCart(driver));
			Keywords.explicitWait(1);
			cart_Value=Keywords.getText(HomePage.getInstance().cartValue(driver));
			
			if(GlobalVar.etpStepsReport){
					DriverSession.getLastExecutionReportingInstance()
						.teststepreporting("ShopClues Various ProductList <br><i><b>Menu OverLay </i></b> and <i><b> AddToCart </i></b>successfully clicked and Cart Value <b><i>"+cart_Value+" is updated successfully ", "PASS",
								"ShopClues Various ProductList <br>Menu OverLay <i><b> and <i><b> AddToCart </i></b> should be successfully clicked");
				}
				else{
					DriverSession.getLastExecutionReportingInstance()
					.teststepreporting("ShopClues Various ProductList <br><i><b>Menu OverLay </i></b> and <i><b> AddToCart </i></b> is not successfully clicked", "FAIL",
							"ShopClues Various ProductList <br>Menu OverLay <i><b> and <i><b> AddToCart </i></b> should be successfully clicked");
			}
		}
	}
	catch(Exception e){
		e.getMessage();
	}
}


public void clickAndValidateCartValue() {
	WebElement shopping_Cart=null;
	String prodNameDataSheet=null;
	String prod_Price=null;
	float grandTotal=0.0f;
	try{
		shopping_Cart=HomePage.getInstance().click_ShoppingCart(driver);
		Keywords.click(shopping_Cart);
		prodNameDataSheet=GlobalVar.TEST_DATA.get("ProductName");
		prod_Price=GlobalVar.TEST_DATA.get("ProductPrice");
		if(HomePage.getInstance().getInsideCartValue(driver).getText().equalsIgnoreCase(prodNameDataSheet)){
			//System.out.println(HomePage.getInstance().getProdPrice(driver).getText());
			if(HomePage.getInstance().getProdPrice(driver).getText().equalsIgnoreCase(prod_Price))
			{
				
				grandTotal=Keywords.verifyShoppingCartPageDetails(HomePage.getInstance().getProductQuantity(driver), HomePage.getInstance().getProductRate(driver));
				
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("Shopping Cart ProductName <br><i><b>"+prodNameDataSheet+"</i></b> <i><b><br>Product Quantity<i><b> "+HomePage.getInstance().getProductQuantity(driver).getText()+
						"</i></b><br>Product Rate <i><b>"+HomePage.getInstance().getProductRate(driver).getText()+"</i></b><br>GRAND TOTAL <i><b>"+grandTotal+" </i></b>successfully Validated", "PASS",
							"ShopClues Various ProductName <br>"+prodNameDataSheet+" <i><b> and Rate and Quantity should be successfully Validated");
			}
		}
		else{
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Shopping Cart ProductName <br><i><b>"+prodNameDataSheet+"</i></b> <i><b><br>Product Quantity<i><b> "+HomePage.getInstance().getProductQuantity(driver).getText()+
					"</i></b><br>Product Rate <i><b>"+HomePage.getInstance().getProductRate(driver).getText()+"</i></b> successfully Validated", "PASS",
						"ShopClues Various ProductName <br>"+prodNameDataSheet+" <i><b> and Rate and Quantity should be successfully Validated");
		}
	}
	catch(Exception e){
		e.printStackTrace();
	}
}


public void removeProductFromCart() {
	WebElement deletFromCart=null;
	try{
		deletFromCart=HomePage.getInstance().product_DeleteFromCart(driver);
		Keywords.click(deletFromCart);
		Keywords.explicitWait(2);
		if(GlobalVar.etpStepsReport){
		DriverSession.getLastExecutionReportingInstance()
		.teststepreporting("Shopping Cart ProductName <br><i><b>"+GlobalVar.TEST_DATA.get("ProductName")+"</i></b>  successfully  <b><i>Product removed from cart </b></i>from cart", "PASS",
					"ShopClues Various ProductName <br>"+GlobalVar.TEST_DATA.get("ProductName")+" <i><b> should be removed successfully Validated");
		
		}
		else{
			
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Shopping Cart ProductName <br><i><b>"+GlobalVar.TEST_DATA.get("ProductName")+"</i></b> is not successfully Removed from cart", "FAIL",
						"ShopClues Various ProductName <br>"+GlobalVar.TEST_DATA.get("ProductName")+" <i><b> should be removed successfully Validated");
		}
		Keywords.hideKeyBoard();
	}
	catch(Exception e){
		e.printStackTrace();
	}
}


public void validateAndClickToGridView() {
	WebElement list_Type=null;
	
	try{
		list_Type=HomePage.getInstance().clickProductFrame(driver);
		if(list_Type!=null){
			Keywords.click(HomePage.getInstance().clickToGridOption(driver));
			Keywords.explicitWait(1);
			
			if(GlobalVar.etpStepsReport){
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Product List is now in  <br><i><b>GRID VIEW</i></b>  successfully validated ", "PASS",
						"Product List is now in  <br><i><b>GRID VIEW</i></b> should be removed successfully Validated");
			}
			else{
				
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("Product List is now in  <br><i><b>LIST VIEW</i></b>  is not successfully validated ", "FAIL",
							"Product List is now in  <br><i><b>GRID VIEW</i></b> should be removed successfully Validated");
			}
		}
	}
	catch(Exception e){
		e.printStackTrace();
	}
}


public void clickAddCartOverLay() {
	WebElement frameType=null;
	WebElement overLay=null;
	List<WebElement>options=null;
	try{
		frameType=HomePage.getInstance().clickToGridView(driver);
		options=HomePage.getInstance().getNotificationInstance(driver);
		
		if(frameType!=null)
		{
			for(WebElement elements : options){
				
				if(elements.getText().equalsIgnoreCase(GlobalVar.TEST_DATA.get("ProductName"))){
					
					overLay=HomePage.getInstance().clickToOverLay(driver);
					Keywords.click(overLay);
					Keywords.click(HomePage.getInstance().getAddToCart(driver));
					String cart_Value = Keywords.getText(HomePage.getInstance().cartValue(driver));
					
					
					DriverSession.getLastExecutionReportingInstance()
					.teststepreporting("ShopClues Various ProductList <br><i><b>Menu OverLay </i></b> and <i><b> AddToCart </i></b>successfully clicked and Cart Value <b><i>"+cart_Value+" is updated successfully ", "PASS",
							"ShopClues Various ProductList <br>Menu OverLay <i><b> and <i><b> AddToCart </i></b> should be successfully clicked");
					
					break;
				}
			}
			
		}
	}
	catch(Exception e){
		DriverSession.getLastExecutionReportingInstance()
		.teststepreporting("ShopClues Various ProductList <br><i><b>Menu OverLay </i></b> and <i><b> AddToCart </i></b> is not successfully clicked", "FAIL",
				"ShopClues Various ProductList <br>Menu OverLay <i><b> and <i><b> AddToCart </i></b> should be successfully clicked");
	}
}


public void validateProductListView() {
	
	WebElement frameType=null;
	try{
		frameType=HomePage.getInstance().clickToGridView(driver);
		
		
		if(frameType!=null)
		{
			Keywords.click(HomePage.getInstance().clickToGridOption(driver));
			Keywords.explicitWait(1);
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("ShopClues Various ProductList is again in <br><i><b>LIST VIEW </i></b>is successfully Verified", "PASS",
					"ShopClues Various ProductList is again in <br><i><b>LIST VIEW </i></b> should be successfully clicked");
		}
		else{
			
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("ShopClues Various ProductList is in <br><i><b>GRID VIEW </i></b>is not successfully Verified", "FAIL",
					"ShopClues Various ProductList is again in <br><i><b>LIST VIEW </i></b> should be successfully clicked");
		}
	}
	catch(Exception e){
		
	}
}



public void clickLogInAndEnterLoginCredentials() {
	WebElement login=null,u_NameField=null,passwordfield=null;
	String loginLogoText=null;
	try{
		login=HomePage.getInstance().product_AppLogin(driver);
		loginLogoText=Keywords.getText(login);
		
		
		
		if(loginLogoText.equalsIgnoreCase(GlobalVar.TEST_DATA.get("LoginStatus"))){
			
			Keywords.click(login);
			
			u_NameField=HomePage.getInstance().product_AppLogin_Email(driver);
			passwordfield=HomePage.getInstance().product_AppLogin_Password(driver);
			
			Keywords.clearEditField(u_NameField);
			Keywords.typeText(u_NameField, GlobalVar.TEST_DATA.get("EmailID"));
			
		
			Keywords.clearEditField(passwordfield);
			Keywords.typeText(passwordfield, GlobalVar.TEST_DATA.get("Password"));
			
			Keywords.click(HomePage.getInstance().product_AppLogin_LoginLink(driver));
			
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Sign-In Page  Username : <br><i><b>"+GlobalVar.TEST_DATA.get("EmailID")+" </i></b><br>Password :<i><b> "+GlobalVar.TEST_DATA.get("Password")+" </i></b>is successfully Entered and Verified", "PASS",
					"ShopClues Sign-In Page should be successfully validate and clicked");
		}
		else{
			
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Sign-In Page  Username : <br><i><b>"+GlobalVar.TEST_DATA.get("EmailID")+" </i></b><br>Password :<i><b> "+GlobalVar.TEST_DATA.get("Password")+" </i></b>is not successfully Entered and Verified", "FAIL",
					"ShopClues Sign-In Page should be successfully validate and clicked");
		}
	}
	catch(Exception e){
		e.printStackTrace();
	}
}

public void clickToMyOrdersList() {
	List<WebElement> myOrder_ListDown=null;
	try{
		myOrder_ListDown=HomePage.getInstance().getNotificationInstance(driver);
		
		for(WebElement option : myOrder_ListDown){
			
			if(option.getText().equalsIgnoreCase(GlobalVar.TEST_DATA.get("OptionName")))
			{
				Keywords.click(option);
				
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("My-Order option is successfully Clicked and Verified", "PASS",
						"My-Order option should be successfully validate and clicked");
				break;
			}
		}
	}
	catch(Exception e){
		DriverSession.getLastExecutionReportingInstance()
		.teststepreporting("My-Order option is not successfully Clicked and Verified", "FAIL",
				"My-Order option should be successfully validate and clicked");
	}
}

public void verifyProductInMyOrders() {
	List<String>prod_Desc=null;
	try{
		prod_Desc=Keywords.splitRowDataWithPipeOperator(GlobalVar.TEST_DATA.get("ProductDescription"));
		
		if(prod_Desc.get(0).equalsIgnoreCase(HomePage.getInstance().getproductNameValue(driver).getText())){

				if(prod_Desc.get(1).equalsIgnoreCase(HomePage.getInstance().o_Number(driver).getText()) && 
					prod_Desc.get(2).equalsIgnoreCase(HomePage.getInstance().o_Date(driver).getText()) && 
						prod_Desc.get(3).equalsIgnoreCase(HomePage.getInstance().amt_paid(driver).getText())){
			
					DriverSession.getLastExecutionReportingInstance()
						.teststepreporting("My-Order Product <b><i><u>"+prod_Desc.get(0)+"</b></i></u> is successfully Verified", "PASS",
								"My-Order option should be successfully validate and clicked");
			
				}
		}
		else{
			
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("My-Order Product <b><i><u>"+prod_Desc.get(0)+"</b></i></u> is not successfully Verified", "FAIL",
					"My-Order option should be successfully validate and clicked");
			
		}
	}
	catch(Exception e){
		e.printStackTrace();
	}
}

public void clickArrowButtonToReOrder() {
	List<String>prod_Desc=null;
	try{
		prod_Desc=Keywords.splitRowDataWithPipeOperator(GlobalVar.TEST_DATA.get("ProductDescription"));
		
		if(prod_Desc.get(0).equalsIgnoreCase(HomePage.getInstance().getproductNameValue(driver).getText())){

				if(prod_Desc.get(1).equalsIgnoreCase(HomePage.getInstance().o_Number(driver).getText()) && 
					prod_Desc.get(2).equalsIgnoreCase(HomePage.getInstance().o_Date(driver).getText()) && 
						prod_Desc.get(3).equalsIgnoreCase(HomePage.getInstance().amt_paid(driver).getText())){
					
					Keywords.click(HomePage.getInstance().clickToArrowButton(driver));
					Keywords.click(HomePage.getInstance().myOrder_ReorderButton(driver));
					
					DriverSession.getLastExecutionReportingInstance()
					.teststepreporting("My-Orders Page Arrow Button and <b><i>RE-ORDER</i></b> option is successfully Clicked", "PASS",
							"My-Order option should be successfully validate and clicked");
				}
		}
		else{
			
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("My-Orders Page Arrow Button and <b><i>RE-ORDER</i></b> option is not successfully Clicked", "FAIL",
					"My-Order option should be successfully validate and clicked");
		}
	}
	catch(Exception e){
		e.printStackTrace();
	}
	
}

public void clickCODOption() {
	List<WebElement>types=null;
	List<String> pay_Options=null;
	try{
		types=HomePage.getInstance().WithPasswordRadio(driver);
		pay_Options=Keywords.splitRowDataWithPipeOperator(GlobalVar.TEST_DATA.get("PaymentOption"));
		
		for(WebElement options : types){
			if(options.getText().equalsIgnoreCase(pay_Options.get(4))){
				Keywords.click(options);
				
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("Cash On Delivery Option is successfully clicked ", "PASS",
						"Cash On Delivery Option should be successfully validate and clicked");
			}
		}
	}
	catch(Exception e){
		DriverSession.getLastExecutionReportingInstance()
		.teststepreporting("Cash On Delivery Option is not successfully clicked ", "FAIL",
				"Cash On Delivery Option should be successfully validate and clicked");
	}
}

public void verifyGrandTotal() {
	   
    try{
        if(HomePage.getInstance().clickToGrandTotal(driver).getText().equalsIgnoreCase(GlobalVar.TEST_DATA.get("Gtotal"))){
           
            Keywords.click(HomePage.getInstance().clickToContinue(driver));
           
            DriverSession.getLastExecutionReportingInstance()
            .teststepreporting("Grand Total : <b><i>"+GlobalVar.TEST_DATA.get("Gtotal")+" </i></b> is successfully verified ", "PASS",
                    "Grand Total : "+GlobalVar.TEST_DATA.get("Gtotal")+"   should be successfully validate ");
           
        }
        else{
           
            DriverSession.getLastExecutionReportingInstance()
            .teststepreporting("Grand Total : "+GlobalVar.TEST_DATA.get("Gtotal")+"  is not successfully verified ", "FAIL",
                    "Grand Total : "+GlobalVar.TEST_DATA.get("Gtotal")+"   should be successfully validate ");
           
        }
    }
    catch(Exception e){
        e.getMessage();
    }
   
}

public void verifyPaymentMethod() {
	WebElement pay_Method=null;
	List<String>pay_Options=null;
	try{
		pay_Method=HomePage.getInstance().clickToPaymentMethod(driver);
		pay_Options=Keywords.splitRowDataWithPipeOperator(GlobalVar.TEST_DATA.get("PaymentOption"));
		
		if(pay_Method.getText().equalsIgnoreCase(pay_Options.get(4).trim())){
			
			 DriverSession.getLastExecutionReportingInstance()
	            .teststepreporting("PAYMENT METHOD : "+pay_Method.getText()+"  is successfully verified ", "PASS",
	            		"PAYMENT METHOD : "+pay_Method.getText()+"  should be successfully validate ");
			
		}
		else{
			
			DriverSession.getLastExecutionReportingInstance()
            .teststepreporting("PAYMENT METHOD : "+pay_Method.getText()+"  is not successfully verified ", "FAIL",
            		"PAYMENT METHOD : "+pay_Method.getText()+"  should be successfully validate ");
		}
	}
	catch(Exception e){
		e.getMessage();
	}
}

public void verifyProductInPaymentPage() {
	WebElement verifyProd=null;
	List<String> prod_Desc=null;
	try{
		verifyProd=HomePage.getInstance().getInsideCartValue(driver);
		prod_Desc=Keywords.splitRowDataWithPipeOperator(GlobalVar.TEST_DATA.get("ProductDescription"));
		
		if(verifyProd.getText().equalsIgnoreCase(prod_Desc.get(0))){
			
				
				 DriverSession.getLastExecutionReportingInstance()
		            .teststepreporting("PRODUCT DESCRIPTION : <br>Product Name : <b><i>"+verifyProd.getText()+" </i></b><br>Product Price :"+HomePage.getInstance().placeOrder_ProductPrice(driver).getText()+" is successfully verified ", "PASS",
		            		"PRODUCT DESCRIPTION  should be successfully validate ");
			}
		else{
			
			DriverSession.getLastExecutionReportingInstance()
            .teststepreporting("PRODUCT DESCRIPTION : <br>Product Name : <b><i>"+verifyProd.getText()+" </i></b><br>Product Price :"+HomePage.getInstance().placeOrder_ProductPrice(driver).getText()+" is not successfully verified ", "FAIL",
            		"PRODUCT DESCRIPTION  should be successfully validate ");
		}
		
	}
	catch(Exception e){
		e.getMessage();
	}
}

public void clickToPlaceOrderButton() {
	WebElement placeOrder=null;
	try{
		placeOrder=HomePage.getInstance().clickToPlaceorder(driver);
		Keywords.click(placeOrder);
		if(GlobalVar.etpStepsReport){
			DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("Place Order Button is successfully verified and Clicked ", "PASS",
						"Place Order Button should be successfully verified and Clicked ");
		}
		else{
			
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Place Order Button is not successfully verified and Clicked ", "FAIL",
					"Place Order Button should be successfully verified and Clicked ");
		}
	}
	catch(Exception e){
		e.getMessage();
	}
}

public void verifyConfirmationMessageAfterPlaceOrder() {
	WebElement verifyMessage=null;
	try{
		verifyMessage=HomePage.getInstance().clickVerifyMessage(driver);
		//Keywords.validateElementExistOrNot(verifyMessage);
		//System.out.println(verifyMessage.getText());
		//System.out.println(GlobalVar.TEST_DATA.get("confirmationMessage"));
		
		if(verifyMessage.getText().equalsIgnoreCase(GlobalVar.TEST_DATA.get("confirmationMessage"))){
			
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Confirmation Message after Place Order : <br><i><b>"+verifyMessage.getText()+"</i></b><br> is successfully verified and Clicked ", "PASS",
					"Confirmation Message should be successfully verified  ");
		}
		else{

			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Confirmation Message after Place Order : <br><i><b>"+verifyMessage.getText()+"</i></b><br> is not successfully verified and Clicked ", "FAIL",
					"Confirmation Message should be successfully verified  ");
		}
	}
	catch(Exception e){
		e.printStackTrace();
	}
}

public void verifyAndClickToOrderSummary() {
	WebElement orderSummary=null;
	List<String>prod_Desc=null;
	try{
		orderSummary=HomePage.getInstance().clickToOrderSummary(driver);
		prod_Desc=Keywords.splitRowDataWithPipeOperator(GlobalVar.TEST_DATA.get("ProductDescription"));
		
		Keywords.click(orderSummary);
		Keywords.explicitWait(1);
		if(prod_Desc.get(0).equalsIgnoreCase(HomePage.getInstance().productPaymentMethodProductName(driver).getText())){
			
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Order Summary Product Name  : <br><i><b>"+prod_Desc.get(0)+"</i></b><br> is successfully verified ", "PASS",
					"Order Summary Product Name should be successfully verified  ");
			
		}
		else{
			
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Order Summary Product Name  : <br><i><b>"+prod_Desc.get(0)+"</i></b><br> is not successfully verified ", "FAIL",
					"Order Summary Product Name should be successfully verified  ");
			
		}
		Keywords.click(orderSummary);
	}
	catch(Exception e){
		e.printStackTrace();
	}
}

public void clickArrowAndreturnButton() {
	List<String>prod_Desc=null;
	List<String>prod_Status=null;
	List<String>prod_SupportOptions=null;
	List<WebElement>prod_ObjectSupport=null;
	boolean flag=false;
	
	try{
		prod_Desc=Keywords.splitRowDataWithPipeOperator(GlobalVar.TEST_DATA.get("ProductDescription"));
		prod_Status=Keywords.splitRowDataWithPipeOperator(GlobalVar.TEST_DATA.get("ProductStatus"));
		prod_SupportOptions=Keywords.splitRowDataWithPipeOperator(GlobalVar.TEST_DATA.get("ProductOptions"));
		
		
			if(prod_Desc.get(0).equalsIgnoreCase(HomePage.getInstance().getproductNameValue(driver).getText())){
				if(prod_Desc.get(1).equalsIgnoreCase(HomePage.getInstance().o_Number(driver).getText()) && 		
					prod_Desc.get(2).equalsIgnoreCase(HomePage.getInstance().o_Date(driver).getText()) && 
						prod_Desc.get(3).equalsIgnoreCase(HomePage.getInstance().amt_paid(driver).getText())){
					
							
							for(String p_Status : prod_Status){
								
									if(HomePage.getInstance().detailsPage_OrderStatus(driver).getText().equalsIgnoreCase(p_Status.trim())){
										
											Keywords.click(HomePage.getInstance().clickToArrowButton(driver));
											prod_ObjectSupport=HomePage.getInstance().getNotificationInstance(driver);
											
											for(WebElement prod_Options : prod_ObjectSupport)
											{
												if(prod_SupportOptions.get(1).equalsIgnoreCase(prod_Options.getText())){
												
													Keywords.click(prod_Options);
													
													DriverSession.getLastExecutionReportingInstance()
													.teststepreporting("Product Name  : <br><i><b>"+prod_Desc.get(0)+"</i></b> with <i><b>"+prod_Options.getText()+"</i></b> is successfully verified and clicked ", "PASS",
															"Product Name  : <br><i><b>"+prod_Desc.get(0)+"</i></b> with <i><b>"+prod_Options.getText()+"</i></b> should be successfully verified  ");
													
													flag=true;
													break;	
												}
												else{	
													continue;
												}
											}	
											break;
									}
									else{
										
										continue;
									}
				}
			}
			}
			if(!flag){
				
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("Product Name  : <br><i><b>"+prod_Desc.get(0)+"</i></b> with <i><b> Return Button</i></b> is not successfully verified and clicked ", "FAIL",
						"Product Name  : <br><i><b>"+prod_Desc.get(0)+"</i></b> with <i><b> Return Button</i></b> should be successfully verified  ");
			}
	}
	catch(Exception e){
		e.printStackTrace();
				}
	}

public void verifyRequestReturnLogo() {
	List<WebElement> requestReturnPage=null;
	
	try{
		requestReturnPage=HomePage.getInstance().getNotificationInstance(driver);
		
		
		for(WebElement banner : requestReturnPage){
			
			if(banner.getText().equalsIgnoreCase(GlobalVar.TEST_DATA.get("RequestReturnPage"))){
				
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("Request Return Page is successfully validated  ", "PASS",
						"Confirmation Message should be successfully verified  ");
				
				break;
			}
		}
	}
	catch(Exception e){
		DriverSession.getLastExecutionReportingInstance()
		.teststepreporting("Request Return Page is not successfully validated  ", "FAIL",
				"Confirmation Message should be successfully verified  ");
	}
}

public void verifyRequestReturnPage() {
	WebElement prod_Name=null;
	
	List <String> prod_Name_DataSheet=null;
	try{
		prod_Name=HomePage.getInstance().getproductNameValue(driver);
		
		prod_Name_DataSheet=Keywords.splitRowDataWithPipeOperator(GlobalVar.TEST_DATA.get("ProductDescription"));
		
		if(prod_Name.getText().equalsIgnoreCase(prod_Name_DataSheet.get(0).trim())){
			
			if(HomePage.getInstance().clickToOrderID(driver).getText().equalsIgnoreCase(prod_Name_DataSheet.get(1))){
					
				if(HomePage.getInstance().placeOrder_ProductPrice(driver).getText().equalsIgnoreCase(Keywords.getRoundValue(prod_Name_DataSheet.get(3)))){
					
					if(HomePage.getInstance().clickToProductQty(driver).getText().equalsIgnoreCase(prod_Name_DataSheet.get(4))){
						
						DriverSession.getLastExecutionReportingInstance()
						.teststepreporting("Request Return Page Product Name :<b><i>"+prod_Name.getText()+" </b></i><br>Order-ID :<b><i>"+prod_Name_DataSheet.get(1)+"</b></i><br>product Quantity :<b><i>"+prod_Name_DataSheet.get(4)+" </b></i><br>Selling Price :<b><i>"+prod_Name_DataSheet.get(3)+"is successfully validated  ", "PASS",
								"Request Return Page should be successfully verified  ");
						
					}
					else{
						
						DriverSession.getLastExecutionReportingInstance()
						.teststepreporting("Request Return Page Product Name :<b><i>"+prod_Name.getText()+" </b></i><br>Order-ID :<b><i>"+prod_Name_DataSheet.get(1)+"</b></i><br>product Quantity :<b><i>"+prod_Name_DataSheet.get(4)+" </b></i><br>Selling Price :<b><i>"+prod_Name_DataSheet.get(3)+"is not successfully validated  ", "FAIL",
								"Request Return Page should be successfully verified  ");
						
					}
					
				}
			}
			
		}
		
	}
	catch(Exception e){
		e.printStackTrace();
	}
}

public void fillingRequiredDetailsDropdown() {
	WebElement clickDropdown=null;
	List<WebElement> dropDown=null;
	List<String> type=null;
	try{
		clickDropdown=HomePage.getInstance().clickToDropDownField(driver);
		Keywords.click(clickDropdown);
		Keywords.explicitWait(1);
		dropDown=HomePage.getInstance().clickToMultipleDropDown(driver);
		type=Keywords.splitRowDataWithPipeOperator(GlobalVar.TEST_DATA.get("ProductDropDownDetails"));
		
		for(WebElement options : dropDown){
			
			if(options.getText().equalsIgnoreCase(type.get(2)))
			{
				Keywords.click(options);
				
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("Drop-Down Value :<b><i>"+type.get(2)+"/b></i> is successfully validated clicked ", "PASS",
						"Drop-Down Value :<b><i>"+type.get(2)+" should be successfully clicked  ");
				
				break;
			}
		}
		
		
	}
	catch(Exception e){
		DriverSession.getLastExecutionReportingInstance()
		.teststepreporting("Drop-Down Value is not successfully validated clicked ", "FAIL",
				"Drop-Down Value  should be successfully clicked  ");
	}
}

public void fillingRequiredDetailsSubReason() {
	WebElement subReason=null;
	List<String>options=null;
	List<WebElement>dropDownObjects=null;
	try{
		subReason=HomePage.getInstance().clickToSubreasonOption(driver);
		Keywords.click(subReason);
		options=Keywords.splitRowDataWithPipeOperator(GlobalVar.TEST_DATA.get("SubReason"));
		
		dropDownObjects=HomePage.getInstance().clickToSubTask(driver);
		
		for(WebElement elementsOption : dropDownObjects){
			
			if(elementsOption.getText().equalsIgnoreCase(options.get(2))){
				
				Keywords.click(elementsOption);
				
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("Drop-Down Sub-Task :<b><i>"+options.get(2)+" is successfully validated clicked ", "PASS",
						"Drop-Down Value  should be successfully clicked   ");
				
				break;
			}
		}
	}
	catch(Exception e){
		DriverSession.getLastExecutionReportingInstance()
		.teststepreporting("Drop-Down Value is not successfully validated clicked ", "FAIL",
				"Drop-Down Value  should be successfully clicked  ");
	}
}

public void clickToUploadImage() {
	WebElement prod_uploadImage=null;
	try{
		prod_uploadImage=HomePage.getInstance().clickToUploadImage(driver);
		Keywords.click(prod_uploadImage);
		
		if(GlobalVar.etpStepsReport){
			
			DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("Upload Image button successfully clicked ", "PASS",
						"Upload Image button should be successfully clicked   ");
		}
		else{
			
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Upload Image button is not successfully clicked ", "FAIL",
					"Upload Image button should be successfully clicked   ");
		}
	}
	catch(Exception e){
		e.getMessage();
	}
}

public void selectImageInUploadImage() {
	List<WebElement>imageGrid=null;
	String value="";
	try{
		imageGrid=HomePage.getInstance().clickToImgWiged(driver);
		value=imageGrid.get(0).getAttribute("enabled");
		
		if(value.equalsIgnoreCase(GlobalVar.flag)){
			
			Keywords.click(HomePage.getInstance().clickToCheckBox(driver));
			Keywords.click(HomePage.getInstance().clickToOkButton(driver));
			
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Product Image is successfully uploaded ", "PASS",
					"Product Image should be successfully uploaded   ");
		}
		else{
			
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Product Image is not successfully uploaded ", "FAIL",
					"Product Image should be successfully uploaded   ");
		}
	}
	catch(Exception e){
		e.getMessage();
	}
}

public void verifyImageUploading() {
	WebElement imgName=null;
	String textImg=null;
	List<String>imgUploadMessage=null;
	try{
		imgName=HomePage.getInstance().clickImgName(driver);
		textImg=Keywords.getText(imgName);
		
		imgUploadMessage=Keywords.splitRowDataWithPipeOperator(GlobalVar.TEST_DATA.get("ProductUpload"));
		Keywords.explicitWait(5);
		
		if(textImg.equalsIgnoreCase(imgUploadMessage.get(1))){
			
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Image is successfully uploaded with message : <br><i><b><u>"+imgUploadMessage.get(1)+"</i></b></u> ", "PASS",
					"Product Image should be successfully uploaded   ");
			
		}
		else{
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Image is not successfully uploaded ", "FAIL",
					"Product Image should be successfully uploaded   ");
		}
		
	}
	catch(Exception e){
		e.printStackTrace();
	}
}

public void clickToReturnProcedure() {
	List<WebElement> radioButtonFirst=null;
	List<String>radioMessage=null;
	try{
		radioButtonFirst=HomePage.getInstance().WithPasswordRadio(driver);
		radioMessage=Keywords.splitRowDataWithPipeOperator(GlobalVar.TEST_DATA.get("RadioButtonMessage"));
		
		for(WebElement options : radioButtonFirst){
			
			if(options.getText().equalsIgnoreCase(radioMessage.get(0))){
				
				Keywords.click(options);
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("Radio Button  : <br><i><b><u>"+options.getText()+"</i></b></u> is successfully clicked ", "PASS",
						"Radio Button should be successfully clicked   ");
				break;
			}
			else{
				
				continue;
			}
		}
	}
	catch(Exception e){
		DriverSession.getLastExecutionReportingInstance()
		.teststepreporting("Radio Button  is not  successfully clicked ", "FAIL",
				"Radio Button should be successfully clicked   ");
	}
}

public void refundTypeRadioButton() {
	List<WebElement> radioButtonFirst=null;
	List<String>radioMessage=null;
	
	try{
		radioButtonFirst=HomePage.getInstance().WithPasswordRadio(driver);
		radioMessage=Keywords.splitRowDataWithPipeOperator(GlobalVar.TEST_DATA.get("RadioButtonMessage"));
		
		for(WebElement options : radioButtonFirst){
			if(options.getText().equalsIgnoreCase(radioMessage.get(4))){
				
				Keywords.click(options);
				
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("Radio Button  : <br><i><b><u>"+options.getText()+"</i></b></u> is successfully clicked ", "PASS",
						"Radio Button should be successfully clicked   ");
			}
		}
	}
	catch(Exception e){
		DriverSession.getLastExecutionReportingInstance()
		.teststepreporting("Radio Button  is not  successfully clicked ", "FAIL",
				"Radio Button should be successfully clicked   ");
	}
}

public void returnShipped() {
	List<WebElement> radioButtonFirst=null;
	List<String>radioMessage=null;
	try{
		radioButtonFirst=HomePage.getInstance().WithPasswordRadio(driver);
		radioMessage=Keywords.splitRowDataWithPipeOperator(GlobalVar.TEST_DATA.get("RadioButtonMessage"));
		
		for(WebElement options : radioButtonFirst){
			if(options.getText().equalsIgnoreCase(radioMessage.get(2))){
				
				Keywords.click(options);
				
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("Radio Button  : <br><i><b><u>"+options.getText()+"</i></b></u> is successfully clicked ", "PASS",
						"Radio Button should be successfully clicked   ");
			}
		}
	}
	catch(Exception e){
		DriverSession.getLastExecutionReportingInstance()
		.teststepreporting("Radio Button  is not  successfully clicked ", "FAIL",
				"Radio Button should be successfully clicked   ");
	}
}

public void writeAComment() {
	WebElement commentBox=null;
	try{
		commentBox=HomePage.getInstance().clickCommentBox(driver);
		Keywords.clearEditField(commentBox);
		Keywords.typeText(commentBox, GlobalVar.TEST_DATA.get("Comment"));
		
		if(GlobalVar.etpStepsReport){
			
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Comment successfully written to text Field ", "PASS",
					"Comment should be successfully written to text Field   ");
		}
		else{
			
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Comment is not successfully written to text Field ", "FAIL",
					"Comment should be successfully written to text Field   ");
		}
		Keywords.hideKeyBoard();
	}
	catch(Exception e){
		e.getMessage();
	}
}

public void clickToSubmitButton() {
	
	WebElement submit=null;
	try{
		submit=HomePage.getInstance().clickSubmit(driver);
		Keywords.click(submit);
		
		if(GlobalVar.etpStepsReport){
			
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Submit button is successfully clicked ", "PASS",
					"Submit button should be successfully clicked   ");
		}
		else{
			
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Submit button is not successfully clicked ", "FAIL",
					"Submit button should be successfully clicked  ");
			
		}
	}
	catch(Exception e){
		e.getStackTrace();
	}
}

public void verifyReturnRequestedReceivedPage() {
	WebElement clickObjectStatus=null;
	WebElement messageReturn=null;
	try{
		clickObjectStatus=HomePage.getInstance().getFavouriteButtonStatus(driver);
		messageReturn=HomePage.getInstance().clickVerifyMessage(driver);
		
				
			if(clickObjectStatus.getText().equalsIgnoreCase(GlobalVar.TEST_DATA.get("Banner"))){
				
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("RETURN REQUEST RECIEVED banner page <br><i><b>"+messageReturn.getText()+"</i></b><br>  is successfully validated ", "PASS",
						"RETURN REQUEST RECIEVED banner page should be successfully validated   ");
			}
		
	}
	catch(Exception e){
		
		DriverSession.getLastExecutionReportingInstance()
		.teststepreporting("RETURN REQUEST RECIEVED banner page is not successfully validated ", "FAIL",
				"RETURN REQUEST RECIEVED banner page should be successfully validated   ");
	}
}

}
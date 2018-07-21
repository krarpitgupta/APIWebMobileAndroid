/*
 ***************************************************************************************
 * Class-Name:    public class WAPAction
 * Description:   Class defined to handle various reusable actions for ShopClues Mobile WAP
 * where
 *
 * Author:        Automators
 * Dated:         09Apr2015
 * Notes:  
 *
 ****************************************************************************************
 */

// Package name: action
package action;

//List of import statements to include various java classes
import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;
import java.util.concurrent.TimeUnit;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import net.sourceforge.htmlunit.corejs.javascript.tools.shell.Global;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.support.ui.Select;

//import pageWiseOR.androidWeb.HomePage;

import session.DriverSession;
import testCaseReporting.TestCaseReporting;
import utilities.GlobalVar;
import utilities.Keywords;
//import utilities.Toolkit;

import org.openqa.selenium.Keys;

import pageWiseOR.androidWAP.HomePage;

/*
 ***************************************************************************************
 * Class-Name:    public class WAPAction
 * Description:   Class defined to handle various reusable actions for ShopClues APIs
 * where
 *
 * Author:        Sahil Jariwala
 * Dated:         09Apr2015
 * Notes:  
 *
 ********************************************************************************************
 */
public class WAPAction {
	
	private WebDriver driver;
	//private AppiumDriver adriver;
	
	HashMap<String, String> testData = new HashMap<String, String>();
	TestCaseReporting testCaseReporting = null;

	public static WAPAction getInstance(){
		return new WAPAction();
	}
	public WAPAction(){}
	
	public WAPAction(WebDriver lastExecutionDriver){
		this.driver = lastExecutionDriver;
		this.testData = GlobalVar.TEST_DATA;
	}
	
	public void launchApp(String url) {
		try {
			
			this.driver = GlobalVar.driver;
			this.testData = GlobalVar.TEST_DATA;
			if(!GlobalVar.CURRENT_EXECUTION_MODE.equals("androidApp"))
			Keywords.waitForPage(driver);
			//String urlNew=GlobalVar.TEST_DATA.get("URL_HomePage_Verification");
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.MINUTES);
			driver.navigate().to(url);
			DriverSession.getLastExecutionReportingInstance()
					.teststepreporting("Shopclues MobileWAP Launched on Chrome Browser Successfully ", "PASS",
							"Shopclues MobileWAP should be Launched on Chrome Browser Successfully ");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance()
					.teststepreporting("No Internet Connection is startup and Shopclues Mobile WAP is not Launched on Browser", "FAIL",
							"Internet Connection to current device should be successfull and Shopclues Mobile WAP should be Launched on Browser.");
		}

	}
	
	public void closeApp() {
		// TODO Auto-generated method stub
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
	public void validateHomePagePopup() {
		WebElement remove_Popup;
		try{
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		remove_Popup=HomePage.getInstance().clickTo_HomePagePopup(driver);
		Keywords.validateElementExistOrNot(remove_Popup);
		if(GlobalVar.etpStepsReport){
			DriverSession.getLastExecutionReportingInstance()
			 .teststepreporting("Shopclues Home Page popup : <b><i>"+remove_Popup.getText()+" </i></b> is successfully Validated", "PASS",
					"Shopclues Home Page popup : <b><i>"+remove_Popup.getText()+" </i></b> should be successfully Validated ");

		} else {
				DriverSession.getLastExecutionReportingInstance()
					.teststepreporting("Shopclues Home Page popup : <b><i>"+remove_Popup.getText()+" </i></b> is not successfully Validated ", "FAIL",
							"Shopclues Home Page popup : <b><i>"+remove_Popup.getText()+" </i></b> should be successfully Validated ");
		}
	    
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void clickToHomePagePopup() {
		// TODO Auto-generated method stub
		WebElement remove_Popup;
		try{
			remove_Popup=HomePage.getInstance().clickTo_HomePagePopup(driver);
			Keywords.click(remove_Popup);
			if(GlobalVar.etpStepsReport){
				DriverSession.getLastExecutionReportingInstance()
				 .teststepreporting("Shopclues Home Page popup : <b><i>"+remove_Popup.getText()+" </i></b> is successfully Clicked", "PASS",
						"Shopclues Home Page popup : <b><i>"+remove_Popup.getText()+" </i></b> should be successfully clicked ");

			} else {
					DriverSession.getLastExecutionReportingInstance()
						.teststepreporting("Shopclues Home Page popup : <b><i>"+remove_Popup.getText()+" </i></b> is not successfully clicked ", "FAIL",
								"Shopclues Home Page popup : <b><i>"+remove_Popup.getText()+" </i></b> should be successfully clicked ");
			}
		}catch(Exception e){
			//e.printStackTrace();
		}
	}
	public void validateHomepageApp() {
		// TODO Auto-generated method stub
		WebElement home_Page=null;
		try{
			home_Page=HomePage.getInstance().clickAndValidateHomePage(driver);
			Keywords.validateElementExistOrNot(home_Page);
			if(GlobalVar.etpStepsReport){
				DriverSession.getLastExecutionReportingInstance()
				 .teststepreporting("Shopclues Home Page is successfully Validated", "PASS",
						"Shopclues Home Page should be successfully Validated ");

			} else {
					DriverSession.getLastExecutionReportingInstance()
						.teststepreporting("Shopclues Home Page is not successfully Validated ", "FAIL",
								"Shopclues Home Page should be successfully Validated ");
			}
		}
		catch(Exception e){
			//e.printStackTrace();
		}
	}
	
	public void validateServiceFeeAgreementOption() {
		WebElement serviceFeeAgreement=null;
		WebElement  seller_Information=null, bank_Details=null;
		List<String>listFrom_DataSheet=null;
		String rawData_FromSheet=null;
		try{
			serviceFeeAgreement=HomePage.getInstance().validateTabPanes(driver);
			seller_Information=HomePage.getInstance().validateMultipleTabPanes(driver,1);
			bank_Details=HomePage.getInstance().validateMultipleTabPanes(driver,2);
			rawData_FromSheet=GlobalVar.TEST_DATA.get("TabPanes");
			
			listFrom_DataSheet=Keywords.splitRowDataWithPipeOperator(rawData_FromSheet);
			if(serviceFeeAgreement.getText().equalsIgnoreCase(listFrom_DataSheet.get(2).toString()) && 
					seller_Information.getText().equalsIgnoreCase(listFrom_DataSheet.get(0)) && 
					    bank_Details.getText().equalsIgnoreCase(listFrom_DataSheet.get(1))){
				
				DriverSession.getLastExecutionReportingInstance()
				 .teststepreporting("Shopclues Step-1 StoreSetUp Page Tab-Panes <br><b><i>"+seller_Information.getText()+"</i></b>, <br><i><b>"+bank_Details.getText()+"</i></b>, <br><i><b>"+serviceFeeAgreement.getText()+"</i></b> is visible and successfully Validated", "PASS",
						"Shopclues Step-1 StoreSetUp Page should be successfully Validated ");
			}else{
				
				DriverSession.getLastExecutionReportingInstance()
				 .teststepreporting("Shopclues Step-1 StoreSetUp Page Tab-Panes <b><i>"+seller_Information.getText()+"</i></b>, "+bank_Details.getText()+", "+serviceFeeAgreement.getText()+"is not successfully Validated", "FAIL",
						"Shopclues Step-1 StoreSetUp Page should be successfully Validated ");
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void validateServiceFeeCategory() {
		// TODO Auto-generated method stub
		WebElement serviceFeeAgreement=null;
		String cssValue=null;
		try{
			serviceFeeAgreement=HomePage.getInstance().validateTabPanes(driver);
			cssValue=serviceFeeAgreement.getCssValue("background-color");
			System.out.println("111"+cssValue);	
			//System.out.println(cssValue);
			if(cssValue.equalsIgnoreCase("rgba(153, 153, 153, 1)")){
			
				DriverSession.getLastExecutionReportingInstance()
				 .teststepreporting("Shopclues <b><i> Service Fee Agreement </i></b> Option is successfully Selected", "PASS",
						"Shopclues <b><i> Service Fee Agreement </i></b> Option should be successfully Validated ");

			} else {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("Shopclues <b><i> Service Fee Agreement </i></b> Option is not successfully Validated ", "FAIL",
						"Shopclues <b><i> Service Fee Agreement </i></b> Option should be successfully Validated ");
			}
		}catch(Exception e){
			e.getMessage();
		}
	}
	public void sellingServiceFeeCategory() {
		// TODO Auto-generated method stub
		WebElement selling_ServiceFeeCateg=null;
		String logoText_DataSheet=null;
		try{
			selling_ServiceFeeCateg=HomePage.getInstance().clickTo_SellingServiceFeeCatgLogo(driver);
			
			logoText_DataSheet=GlobalVar.TEST_DATA.get("SellingServiceFeeCategoryLogo");
			if(logoText_DataSheet.equalsIgnoreCase(selling_ServiceFeeCateg.getText())){
				
				DriverSession.getLastExecutionReportingInstance()
				 .teststepreporting("Shopclues <b><i> "+selling_ServiceFeeCateg.getText()+" </i></b> LOGO is successfully validated", "PASS",
						"Shopclues <b><i> "+selling_ServiceFeeCateg.getText()+" </i></b> LOGO should be successfully Validated ");
			}else{
				
				DriverSession.getLastExecutionReportingInstance()
				 .teststepreporting("Shopclues <b><i> "+selling_ServiceFeeCateg.getText()+" </i></b> LOGO is not successfully validated", "FAIL",
						"Shopclues <b><i> "+selling_ServiceFeeCateg.getText()+" </i></b> LOGO should be successfully Validated ");
			}
			
		}catch(Exception e){
			DriverSession.getLastExecutionReportingInstance()
			 .teststepreporting("Shopclues <b><i> "+selling_ServiceFeeCateg.getText()+" </i></b> LOGO is not successfully validated", "FAIL",
					"Shopclues <b><i> "+selling_ServiceFeeCateg.getText()+" </i></b> LOGO should be successfully Validated ");
		}
	}
	public void sellingServiceFeeListValidation() {
		
		List <WebElement> prod_List=null;
		String default_DataSheet=null;
		ArrayList <String>al=new ArrayList<String>();
		try{
			prod_List=HomePage.getInstance().clickTo_GetDropDownValue(driver);
			default_DataSheet=GlobalVar.TEST_DATA.get("DefaultRadioClick");
			
			for(WebElement element : prod_List){
				al.add(element.getText());
			}
			//System.out.println("Selling Service Fee by Category are : \n");
			//System.out.println(al);
			
			for(WebElement element : prod_List){
				if(element.getText().equalsIgnoreCase(default_DataSheet.trim())){
						DriverSession.getLastExecutionReportingInstance()
						 .teststepreporting("Shopclues <b><i>Selling Service Fee by Category</i></b> and has <b><i>"+prod_List.size()+"</i></b> " +
						 		"elements and Default value <b><i><u>"+element.getText()+"</u></i></b> is selected ", "PASS",
								 		"Shopclues <b><i>Selling Service Fee by Category</i></b> should be successfully Validated ");
						break;
					} else {
						continue;		
					}
			}			
		}catch(Exception e){
				DriverSession.getLastExecutionReportingInstance()
				 .teststepreporting("Shopclues <b><i>Selling Service Fee by Category</i></b> and has <b><i>"+prod_List.size()+"</i></b> " +
				 		"elements and Default value is not selected ", "FAIL",
						 		"Shopclues <b><i>Selling Service Fee by Category</i></b> should be successfully Validated ");
				}
	}
	
	public void clickToStarLogo() {
		WebElement homePage_Star_Logo=null;
		try{
			homePage_Star_Logo=HomePage.getInstance().clickTo_StarButtonSign(driver);
			Keywords.click(homePage_Star_Logo);
			if(GlobalVar.etpStepsReport){
				DriverSession.getLastExecutionReportingInstance()
				 .teststepreporting("Shopclues Home Page  <b><i> Favourate Button </i></b> is successfully Clicked", "PASS",
						"Shopclues Home Page  <b><i> Favourate Button </i></b> should be successfully clicked ");

			} else {
					DriverSession.getLastExecutionReportingInstance()
						.teststepreporting("Shopclues Home Page  <b><i> Favourate Button </i></b> is not successfully clicked ", "FAIL",
								"Shopclues Home Page  <b><i> Favourate Button </i></b>  should be successfully clicked ");
			}
			
		}catch(Exception e){
			e.getMessage();
		}
		
	}
	public void validateAndClickSiteOptions() {
		List<WebElement>option_Site=null;
		String sellwithUsDataSheet=null;
		String mltiple_Options=null;
		try{
			option_Site=HomePage.getInstance().clickTo_VariousOptions(driver);
			sellwithUsDataSheet=GlobalVar.TEST_DATA.get("sellWithUs");
			
			for(WebElement options : option_Site){
				mltiple_Options=options.getText();
			}
			String split[]=mltiple_Options.split("\n");
	
			for(int i=0;i<split.length;i++){
				if(split[i].equalsIgnoreCase(sellwithUsDataSheet)){
					WebElement sellwithous=HomePage.getInstance().clickToSellWithOus(driver);
					Keywords.click(sellwithous);

					if(GlobalVar.etpStepsReport){
						DriverSession.getLastExecutionReportingInstance()
						 .teststepreporting("Shopclues Home Page  Multiple options are : <b><i><br>"+mltiple_Options+" .<br><u>Sell with Us </u></i></b> option is successfully Clicked", "PASS",
								"Shopclues Home Page  <b><i> Sell with us </i></b> option should be successfully clicked ");

					} else {
							DriverSession.getLastExecutionReportingInstance()
								.teststepreporting("Shopclues Home Page  <b><i> Sell with Us </i></b> option is not successfully clicked ", "FAIL",
										"Shopclues Home Page  <b><i> Sell with us </i></b> option should be successfully clicked  ");
					}
					break;
				}
				else{
					continue;
				}
			}
		}catch(Exception e){
			e.getMessage();
		}
		
	}
	public void verifyLoginPageUserName() {
		WebElement login_PageUName=null;
		String uNameDataSheet=null;
		try{
			login_PageUName=HomePage.getInstance().clickToUserNameLoginPage(driver);
			uNameDataSheet=GlobalVar.TEST_DATA.get("E-MailID");
			Keywords.clearEditField(login_PageUName);
			Keywords.typeText(login_PageUName, uNameDataSheet);
			if(GlobalVar.etpStepsReport){
				DriverSession.getLastExecutionReportingInstance()
				 .teststepreporting("Shopclues Login Page : <b><i>Email Field </i></b> is successfully validated and Email-ID : <b><i>"+uNameDataSheet+"</i></b> is Typed successfully ", "PASS",
						"Shopclues Login Page : <b><i>Email Field </i></b> should be successfully validated and Typed ");

			} else {
					DriverSession.getLastExecutionReportingInstance()
						.teststepreporting("Shopclues Login Page : <b><i>Email Field </i></b> is not successfully validated and Email-ID : "+uNameDataSheet+"  is not successfully clicked ", "FAIL",
								"Shopclues Login Page : <b><i>Email Field </i></b> should be successfully validated and Typed ");
			}
		}
		catch(Exception e){
			e.getMessage();
		}
		
	}
	public void verifyLoginPageUserPassword() {
		WebElement password=null;
		String passFromDataSheet=null;
		try{
				password=HomePage.getInstance().clickTo_Password(driver);
				passFromDataSheet=GlobalVar.TEST_DATA.get("Password");
				Keywords.clearEditField(password);
				Keywords.typeText(password, passFromDataSheet);
				if(GlobalVar.etpStepsReport){
					DriverSession.getLastExecutionReportingInstance()
					 .teststepreporting("Shopclues Login Page : <b><i>Password Field </i></b> is successfully validated and Password : <b><i>"+passFromDataSheet+"</i></b> is Typed successfully ", "PASS",
							"Shopclues Login Page : <b><i>Password Field </i></b> should be successfully validated and Typed ");

				} else {
						DriverSession.getLastExecutionReportingInstance()
							.teststepreporting("Shopclues Login Page : <b><i>Password Field </i></b> is not successfully validated and Password : "+passFromDataSheet+"  is not successfully clicked ", "FAIL",
									"Shopclues Login Page : <b><i>Password Field </i></b> should be successfully validated and Typed ");
				}
				
		}catch(Exception e){
			e.getMessage();
		}
	}
	public void clickToLoginButton() {
		WebElement logIN=null;
		try{
			logIN=HomePage.getInstance().clickToLogin(driver);
			Keywords.click(logIN);
			if(GlobalVar.etpStepsReport){
				DriverSession.getLastExecutionReportingInstance()
				 .teststepreporting("Shopclues Login Page : <b><i>LOG-IN </i></b> button is successfully validated and clicked ", "PASS",
						"Shopclues Login Page : <b><i>LOG-IN </i></b> button should be successfully validated and clicked ");

			} else {
					DriverSession.getLastExecutionReportingInstance()
						.teststepreporting("Shopclues Login Page : <b><i>LOG-IN </i></b> button  is not successfully validated and Clicked ", "FAIL",
								"Shopclues Login Page : <b><i>LOG-IN </i></b> button should be successfully validated and clicked ");
			}
			
		}catch(Exception e){
			e.getMessage();
		}
		
	}
	public void validateAfterLoginUserpage() {
		WebElement user_ProfileName=null;
		String u_Profile_DataSheet=null;
		String modified=null;
		try{
			
			user_ProfileName=HomePage.getInstance().clickTo_ProfileNameLogo(driver);
			Keywords.validateElementExistOrNot(user_ProfileName);
			u_Profile_DataSheet=GlobalVar.TEST_DATA.get("CompanyLegalName");
			
			modified=Keywords.ltrim(user_ProfileName.getText());
			
			//System.out.println(modified.trim());
			if(u_Profile_DataSheet.equalsIgnoreCase(modified.trim())){
				DriverSession.getLastExecutionReportingInstance()
				 .teststepreporting("Shopclues Profile Page : <b><i>"+u_Profile_DataSheet+"</i></b>  is successfully validated ", "PASS",
						"Shopclues Login Page : <b><i>LOG-IN </i></b> button should be successfully validated and clicked ");

			}else{
				DriverSession.getLastExecutionReportingInstance()
				 .teststepreporting("Shopclues Profile Page : <b><i>"+u_Profile_DataSheet+"</i></b>  is not successfully validated ", "FAIL",
						"Shopclues Login Page : <b><i>LOG-IN </i></b> button should be successfully validated and clicked ");

			}
		}catch(Exception e){
			e.getMessage();
		}
		
	}
	public void clickAndValidateServiceServiceFeeAgrment() {
		WebElement clickTo_Link=null;
		try{
			clickTo_Link=HomePage.getInstance().clickTo_ServiceFeeArmentLink(driver);
			Keywords.click(clickTo_Link);
			if(GlobalVar.etpStepsReport){
				DriverSession.getLastExecutionReportingInstance()
				 .teststepreporting("Shopclues Profile Page : <b><i>Service Fee Agreement </i></b> link is successfully validated and clicked ", "PASS",
						"Shopclues Profile Page : <b><i>Service Fee Agreement </i></b> button should be successfully validated and clicked ");

			} else {
					DriverSession.getLastExecutionReportingInstance()
						.teststepreporting("Shopclues Profile Page : <b><i>Service Fee Agreement </i></b> link is not successfully validated and Clicked ", "FAIL",
								"Shopclues Profile Page : <b><i>Service Fee Agreement </i></b> button should be successfully validated and clicked ");
			}
		}catch(Exception e){
			e.getMessage();
		}
		
	}
	public void validateFullFillmentServiceFeeLinik() {
		WebElement full_Service_Fee=null;
		try{
			full_Service_Fee=HomePage.getInstance().clickFulfillment(driver);
			Keywords.validateElementExistOrNot(full_Service_Fee);
			
			if(GlobalVar.etpStepsReport){
				DriverSession.getLastExecutionReportingInstance()
				 .teststepreporting("Shopclues <b><i><br> Fulfillment Service Fees </b></i> option is successfully Validated", "PASS",
						"Shopclues <b><i><br> Fulfillment Service Fees </b></i> option should be successfully clicked ");

			} else {
				DriverSession.getLastExecutionReportingInstance()
				 .teststepreporting("Shopclues <b><i><br> Fulfillment Service Fees </b></i> option is not successfully Validated", "FAIL",
						"Shopclues <b><i><br> Fulfillment Service Fees </b></i> option should be successfully clicked ");
			}
		}
		catch(Exception e){
			e.getMessage();
		}
		
	}
	public void validateMemorandumOfUnderstanding() {
		WebElement memo=null;
		try{
			memo=HomePage.getInstance().ClickTo_MemorandumOptionLink(driver);
			Keywords.validateElementExistOrNot(memo);
			if(GlobalVar.etpStepsReport){
				DriverSession.getLastExecutionReportingInstance()
				 .teststepreporting("Shopclues <b><i><br> Memorandum of Understanding </b></i> option is successfully Validated", "PASS",
						"Shopclues <b><i><br> Memorandum of Understanding </b></i> option should be successfully clicked ");

			} else {
				DriverSession.getLastExecutionReportingInstance()
				 .teststepreporting("Shopclues <b><i><br> Memorandum of Understanding </b></i> option is not successfully Validated", "FAIL",
						"Shopclues <b><i><br> Memorandum of Understanding </b></i> option should be successfully clicked ");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	public void validateCheckBoxWithTearmAndCondition() {
		WebElement check=null;
		
		try{
			check=HomePage.getInstance().clickTo_CheckBox(driver);
						
			
			if(check.isSelected()==true){
				
				DriverSession.getLastExecutionReportingInstance()
				 .teststepreporting("Shopclues Agreement check-box is <b><i><br> CHECKED </b></i> by Default is successfully Validated", "PASS",
						"Shopclues Agreement check-box is <b><i><br> CHECKED </b></i> by Default should be successfully clicked ");
			}else{
				
				DriverSession.getLastExecutionReportingInstance()
				 .teststepreporting("Shopclues Agreement check-box is <b><i><br> UN-CHECKED </b></i> by Default is not successfully Validated", "PASS",
						"Shopclues Agreement check-box is <b><i><br> CHECKED </b></i> by Default should be successfully clicked ");
				Keywords.click(check);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	public void acceptanceName() {
		WebElement acceptance_Name=null;
		String value=null;
		try{
			acceptance_Name=HomePage.getInstance().clickToAccepter(driver);
			value=acceptance_Name.getAttribute("value");
			System.out.println("ddd "+value);
			if(acceptance_Name.isDisplayed()){
				
				DriverSession.getLastExecutionReportingInstance()
				 .teststepreporting("Shopclues Agreement acceptance nominee with Dated is <b><i><br> "+value+" </b></i> is successfully Validated", "PASS",
						"Shopclues Agreement acceptance nominee with Dated is <b><i><br> "+value+" </b></i>  should be successfully clicked ");
			}else{
				DriverSession.getLastExecutionReportingInstance()
				 .teststepreporting("Shopclues Agreement acceptance nominee with Dated is <b><i><br> "+value+" </b></i> is not successfully Validated", "FAIL",
						"Shopclues Agreement acceptance nominee with Dated is <b><i><br> "+value+" </b></i>  should be successfully clicked ");
			}
		}catch(Exception e){
			DriverSession.getLastExecutionReportingInstance()
			 .teststepreporting("Shopclues Agreement acceptance nominee with Dated is <b><i><br> "+value+" </b></i> is not successfully Validated", "PASS",
					"Shopclues Agreement acceptance nominee with Dated is <b><i><br> "+value+" </b></i>  should be successfully clicked ");
		}
		
	}
	public void validateAcceptanceNameInTextField() {
		WebElement acceptancer_Name=null;
		String value="";
		String dataSheetvalue=null;
		try{
			acceptancer_Name=HomePage.getInstance().clickToAcceptancer(driver);
			value=acceptancer_Name.getAttribute("value");
			dataSheetvalue=GlobalVar.TEST_DATA.get("AcceptancePerson");
			
			if(dataSheetvalue.equalsIgnoreCase(value)){
				DriverSession.getLastExecutionReportingInstance()
				 .teststepreporting("Shopclues Agreement acceptance nominee name is <b><i><br> "+value+" </b></i> is successfully Validated", "PASS",
						"Shopclues Agreement acceptance nominee name is <b><i><br> "+value+" </b></i>  should be successfully clicked ");
			}else{
				DriverSession.getLastExecutionReportingInstance()
				 .teststepreporting("Shopclues Agreement acceptance nominee name is <b><i><br> "+value+" </b></i> is not successfully Validated", "FAIL",
						"Shopclues Agreement acceptance nominee name is <b><i><br> "+value+" </b></i>  should be successfully clicked ");
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	public void clickToSaveAggrement() {
		WebElement save=null;
		try{
			save=HomePage.getInstance().clickSave(driver);
			Keywords.click(save);
		
			DriverSession.getLastExecutionReportingInstance()
			 .teststepreporting("Shopclues save agreement button is successfully clicked", "PASS",
					"Shopclues save agreement button should be successfully clicked ");

		}catch(Exception e){
			DriverSession.getLastExecutionReportingInstance()
			 .teststepreporting("Shopclues save agreement button is not successfully clicked", "FAIL",
					"Shopclues save agreement button should be successfully clicked ");
		}
		
	}
	public void validateAndClickToPopup() {
		WebElement logo=null;
		String value=null;
		try{
			logo=HomePage.getInstance().clickToLogos(driver);
			value=logo.getText();
			Keywords.validateElementExistOrNot(logo);
			if(GlobalVar.etpStepsReport){
				DriverSession.getLastExecutionReportingInstance()
				 .teststepreporting("Shopclues Agreement page popup : <b><i><u>"+logo.getText()+"</i></b></u> is successfully validated", "PASS",
						"Shopclues Agreement page popup : "+logo.getText()+" should be successfully validated ");
			}else{
				DriverSession.getLastExecutionReportingInstance()
				 .teststepreporting("Shopclues Agreement page popup : "+logo.getText()+" is not successfully validated", "FAIL",
						"Shopclues Agreement page popup : "+logo.getText()+" should be successfully validated ");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	public void clickToSaveAndClose() {
		WebElement saveAndClose=null;
		try{
			saveAndClose=HomePage.getInstance().clickToSaveAndClose(driver);
			Keywords.click(saveAndClose);
			if(GlobalVar.etpStepsReport){
				DriverSession.getLastExecutionReportingInstance()
				 .teststepreporting("Shopclues Agreement page popup is successfully clicked", "PASS",
						"Shopclues Agreement page popup should be successfully clicked ");
			}else{
				DriverSession.getLastExecutionReportingInstance()
				 .teststepreporting("Shopclues Agreement page popup is not successfully clicked", "FAIL",
						"Shopclues Agreement page popup should be successfully clicked ");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	public void validateCompleteRegistrationGreenMark() {
		WebElement mark=null;
		try{
			mark=HomePage.getInstance().cliclToMark(driver);
			Keywords.validateElementExistOrNot(mark);
			if(GlobalVar.etpStepsReport){
				DriverSession.getLastExecutionReportingInstance()
				 .teststepreporting("Service Fee Agreement flow is successfully completed and validated", "PASS",
						"Service Fee Agreement flow should be successfully completed and validated ");
			}else{
				DriverSession.getLastExecutionReportingInstance()
				 .teststepreporting("Service Fee Agreement flow is not successfully completed and validated", "FAIL",
						"Service Fee Agreement flow should be successfully completed and validated ");
			}
		}catch(Exception we){
			we.getMessage();
		}
		
	}
	public void uploadProductStoreManager() {
		WebElement validate_Uploadproducts=null;
		String rawData_StartSelling=null;
		List<String>split_StartSelling=null;
		
		try{
			validate_Uploadproducts=HomePage.getInstance().clickVerifyUploadProducts(driver);
			rawData_StartSelling=GlobalVar.TEST_DATA.get("ThreeStepsForstartSelling");
			split_StartSelling=Keywords.splitRowDataWithPipeOperator(rawData_StartSelling);
			
			if(validate_Uploadproducts.getText().equalsIgnoreCase(split_StartSelling.get(1))){
				DriverSession.getLastExecutionReportingInstance()
				 .teststepreporting("Store Manager Home Page "+split_StartSelling.get(1)+" is successfully Validated", "PASS",
						"Store Manager Home Page "+split_StartSelling.get(1)+"  should be successfully completed and validated ");
			}
			else{
				DriverSession.getLastExecutionReportingInstance()
				 .teststepreporting("Store Manager Home Page "+split_StartSelling.get(1)+" is not successfully Validated", "FAIL",
						"Store Manager Home Page "+split_StartSelling.get(1)+"  should be successfully completed and validated ");
			}
			
		}catch(Exception e){
			e.getMessage();
		}
		
	}
	public void clickToUploadProductCatalogLink() {
		WebElement productCatalogLink=null;
		try{
			productCatalogLink=HomePage.getInstance().clickToProductCatalogLink(driver);
			Keywords.click(productCatalogLink);
			
			if(GlobalVar.etpStepsReport){
				DriverSession.getLastExecutionReportingInstance()
				 .teststepreporting("Upload Product Catalog is successfully validated and Clicked ", "PASS",
						"Upload Product Catalog should be successfully validated and Clicked ");
			}else{
				DriverSession.getLastExecutionReportingInstance()
				 .teststepreporting("Upload Product Catalog is not successfully validated and Clicked ", "FAIL",
						"Upload Product Catalog should be successfully validated and Clicked ");
			}			
		}catch(Exception e){
			e.getMessage();
		}
		
	}
	public void verifyManageProductPage() {
		WebElement manageProductPage=null;
		try{
			manageProductPage=HomePage.getInstance().clickManageProduct(driver);
			Keywords.validateElementExistOrNot(manageProductPage);
			if(GlobalVar.etpStepsReport){
				DriverSession.getLastExecutionReportingInstance()
				 .teststepreporting("<b><i> Manage products </i></b>is successfully visible and validated ", "PASS",
						"<b><i> Manage products </i></b> should be successfully visible and validated ");
			}else{
				DriverSession.getLastExecutionReportingInstance()
				 .teststepreporting("<b><i> Manage products </i></b>is not successfully visible and validated ", "FAIL",
						"<b><i> Manage products </i></b> should be successfully visible and validated ");
			}	
			
		}catch(Exception e){
			e.getMessage();
		}
		
	}
	/** ***************************************************************************************
	 * Keyword-Name:    clickSellWithUsLink
	 * Usage:           void clickSellWithUsLink()
	 * Description:     Click on sell with us link
	 * Author:          Automators
	 * Dated:           19May2015
	 * Notes:   
	 *************************************************************************************** **/
	public void clickSellWithUsLink()
	{
		try {
			WebElement element = pageWiseOR.androidWAP.HomePage.getInstance().sellWithUsLink(driver);
			pageWiseOR.androidWAP.HomePage.getInstance().dynamicwait(driver, 20, element);
			Keywords.click(element);
			
			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting("sell with us link Clicked.", "PASS",
								"sell with us link should be clicked");
	
			} else {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting("sell with us link not clicked", "FAIL",
								"sell with us link should be clicked");
	
			}
		}
		catch(Exception e)
		{
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting(
					"Exception occured....", "FAIL",
					"sell with us link should be clicked");
		}
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    clickSubmitButton
	 * Usage:           void clickSubmitButton()
	 * Description:     Click on Submit button
	 * Author:          Automators
	 * Dated:           19May2015
	 * Notes:   
	 *************************************************************************************** **/
	public void clickSubmitButton()
	{
		try {
			WebElement element = pageWiseOR.androidWAP.HomePage.getInstance().MobileWapMerchantRegistration_Submit(driver);
			Keywords.click(element);
			
			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting("Submit button Clicked.", "PASS",
								"Submit button should be clicked");
	
			} else {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting("Submit button not clicked", "FAIL",
								"Submit button should be clicked");
	
			}
		}
		catch(Exception e)
		{
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting(
					"Exception occured....", "FAIL",
					"Submit button should be clicked");
		}
	}
	
	
	/** ***************************************************************************************
	 * Keyword-Name:    verifyHiglightedColor_MerchantName
	 * Usage:           void verifyHiglightedColor_MerchantName()
	 * Description:     Highlight color for merchant name field
	 * Author:          Automators
	 * Dated:           22May2015
	 * Notes:   
	 * 
	 *************************************************************************************** **/
	public void verifyHiglightedColor_MerchantName() {
		WebElement element = null;;
		String colorval="";
		try {
			Actions act=new Actions(driver);
			element = pageWiseOR.androidWAP.HomePage.getInstance().MobileWapMerchantRegistration_MName(driver);
			act.moveToElement(element).perform();
			Keywords.explicitWait(2);
			
			colorval=element.getCssValue("background-color");
			//System.out.println("Row Color " + colorval);
			
			if (GlobalVar.etpStepsReport && colorval.equalsIgnoreCase("rgba(255, 255, 255, 1)")) {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting("merchant name field not highlighted Red",
								"FAIL",
								"merchant name field should be highlighted Red");

			} else {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting(
								"merchant name field highlighted Red successfully", "PASS",
								"merchant name field should be highlighted Red");
			}

		} catch (Exception e) {
			
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting(
					"Exception occured....", "FAIL",
					"merchant name field should be highlighted Red");
		}
	}
	
	
	/** ***************************************************************************************
	 * Keyword-Name:    verifyHiglightedColor_StoreName
	 * Usage:           void verifyHiglightedColor_StoreName()
	 * Description:     Highlight color for store name field
	 * Author:          Automators
	 * Dated:           22May2015
	 * Notes:   
	 * 
	 *************************************************************************************** **/
	public void verifyHiglightedColor_StoreName() {
		WebElement element = null;;
		String colorval="";
		try {
			Actions act=new Actions(driver);
			element = pageWiseOR.androidWAP.HomePage.getInstance().MobileWapMerchantRegistration_StoreName(driver);
			act.moveToElement(element).perform();
			Keywords.explicitWait(2);
			colorval=element.getCssValue("background-color");
			//System.out.println("Row Color " + colorval);
			if (GlobalVar.etpStepsReport && colorval.equalsIgnoreCase("rgba(255, 255, 255, 1)")) {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting("Store name field not highlighted Red",
								"FAIL",
								"Store name field should be highlighted Red");

			} else {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting(
								"Store name field highlighted Red successfully", "PASS",
								"Store name field should be highlighted Red");
			}

		} catch (Exception e) {
			// TODO: handle exception
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting(
					"Exception occured....", "FAIL",
					"Store name field should be highlighted Red");
		}
	}

	
	/** ***************************************************************************************
	 * Keyword-Name:    verifyHiglightedColor_PhnNo
	 * Usage:           void verifyHiglightedColor_PhnNo()
	 * Description:     Highlight color for phone no field
	 * Author:          Automators
	 * Dated:           22May2015
	 * Notes:   
	 * 
	 *************************************************************************************** **/
	public void verifyHiglightedColor_PhnNo() {
		WebElement element = null;;
		String colorval="";
		try {
			Actions act=new Actions(driver);
			element = pageWiseOR.androidWAP.HomePage.getInstance().MobileWapMerchantRegistration_PhoneNo(driver);
			act.moveToElement(element).perform();
			Keywords.explicitWait(2);
			colorval=element.getCssValue("background-color");
			//System.out.println("Row Color " + colorval);
			if (GlobalVar.etpStepsReport && colorval.equalsIgnoreCase("rgba(255, 255, 255, 1)")) {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting("Phone number field not highlighted Red",
								"FAIL",
								"Phone number field should be highlighted Red");

			} else {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting(
								"Phone number field highlighted Red successfully", "PASS",
								"Phone number field should be highlighted Red");
			}

		} catch (Exception e) {
			// TODO: handle exception
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting(
					"Exception occured....", "FAIL",
					"Phone number field should be highlighted Red");
		}
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    verifyHiglightedColor_Email
	 * Usage:           void verifyHiglightedColor_Email()
	 * Description:     Highlight color for Email Id field
	 * Author:          Automators
	 * Dated:           22May2015
	 * Notes:   
	 * 
	 *************************************************************************************** **/
	public void verifyHiglightedColor_Email() {
		WebElement element = null;;
		String colorval="";
		try {
			Actions act=new Actions(driver);
			element = pageWiseOR.androidWAP.HomePage.getInstance().MobileWapMerchantRegistration_Email(driver);
			act.moveToElement(element).perform();
			Keywords.explicitWait(2);
			colorval=element.getCssValue("background-color");
			//System.out.println("Row Color " + colorval);
			if (GlobalVar.etpStepsReport && colorval.equalsIgnoreCase("rgba(255, 255, 255, 1)")) {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting("Email Id field not highlighted Red",
								"FAIL",
								"Email Id field should be highlighted Red");

			} else {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting(
								"Email Id field highlighted Red successfully", "PASS",
								"Email Id field should be highlighted Red");
			}

		} catch (Exception e) {
			// TODO: handle exception
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting(
					"Exception occured....", "FAIL",
					"Email Id field should be highlighted Red");
		}
	}

	
	/** ***************************************************************************************
	 * Keyword-Name:    verifyHiglightedColor_Password
	 * Usage:           void verifyHiglightedColor_Password()
	 * Description:     Highlight color for Password field
	 * Author:          Automators
	 * Dated:           22May2015
	 * Notes:   
	 * 
	 *************************************************************************************** **/
	public void verifyHiglightedColor_Password() {
		WebElement element = null;;
		String colorval="";
		try {
			Actions act=new Actions(driver);
			element = pageWiseOR.androidWAP.HomePage.getInstance().MobileWapMerchantRegistration_Password(driver);
			act.moveToElement(element).perform();
			Keywords.explicitWait(2);
			colorval=element.getCssValue("background-color");
			//System.out.println("Row Color " + colorval);
			if (GlobalVar.etpStepsReport && colorval.equalsIgnoreCase("rgba(255, 255, 255, 1)")) {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting("Password field not highlighted Red",
								"FAIL",
								"Password field should be highlighted Red");

			} else {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting(
								"Password field highlighted Red successfully", "PASS",
								"Password field should be highlighted Red");
			}

		} catch (Exception e) {
			// TODO: handle exception
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting(
					"Exception occured....", "FAIL",
					"Password field should be highlighted Red");
		}
	}

	/** ***************************************************************************************
	 * Keyword-Name:    typeOnMerchantName_Registration
	 * Usage:           void typeOnMerchantName_Registration()
	 * Description:     Type on merchant name
	 * Author:          Automators
	 * Dated:           19May2015
	 * Notes:   
	 *************************************************************************************** **/
	public void typeOnMerchantName_Registration()
	{
		String val = null;
		String rand_Value=null;
		List<String>alpha_Value=new ArrayList<String>();
		try {
			WebElement element = pageWiseOR.androidWAP.HomePage.getInstance().MobileWapMerchantRegistration_MName(driver);
			val = GlobalVar.TEST_DATA.get("MerchantName");
			String []split=val.split(" ");
			rand_Value=Keywords.getRandomizedString(split[0], split[1], "");
			alpha_Value=Keywords.convertAlphaNumericToAlphabetical(rand_Value);
			Keywords.typeText(element, alpha_Value.get(0));
			
			GlobalVar.companyName=alpha_Value.get(0);
			
			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting(val + " Merchant Name typed successfully", "PASS",
								val + " Merchant name should be typed");
	
			} else {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting(val + " Merchant name not typed", "FAIL",
								val + " Merchant name should be typed");
	
			}
		}
		catch(Exception e)
		{
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting(
					"Exception occured....", "FAIL",
					val + " Merchant name should be typed");
		}
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    typeOnMerchantStoreName_Registration
	 * Usage:           void typeOnMerchantStoreName_Registration()
	 * Description:     Type store name
	 * Author:          Automators
	 * Dated:           19May2015
	 * Notes:   
	 *************************************************************************************** **/
	public void typeOnMerchantStoreName_Registration()
	{
		String val = null;
		
		try {
			WebElement element = pageWiseOR.androidWAP.HomePage.getInstance().MobileWapMerchantRegistration_StoreName(driver);
			val=GlobalVar.TEST_DATA.get("Existing Store");
			//System.out.println(val);
			
			Keywords.clearEditField(element);
			Keywords.typeText(element, GlobalVar.companyName);
			
			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting(val +" Store Name typed successfully", "PASS",
								val + " Store name should be typed");
	
			} else {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting(val +" Store name not typed", "FAIL",
								val +" Store name should be typed");
	
			}
		}
		catch(Exception e)
		{
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting(
					"Exception occured....", "FAIL",
					val + " Store name should be typed");
		}
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    typeOnMerchantPhoneNo_Registration
	 * Usage:           void typeOnMerchantPhoneNo_Registration()
	 * Description:     Type Phone Number
	 * Author:          Automators
	 * Dated:           19May2015
	 * Notes:   
	 *************************************************************************************** **/
	public void typeOnMerchantPhoneNo_Registration()
	{
		String val = null;
		try {
			WebElement element = pageWiseOR.androidWAP.HomePage.getInstance().MobileWapMerchantRegistration_PhoneNo(driver);
			val = GlobalVar.TEST_DATA.get("Phone Number");
			Keywords.typeText(element, val);
			
			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting(val + " Phone Number typed successfully", "PASS",
								val +" Phone Number should be typed");
	
			} else {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting(val + " Phone Number not typed", "FAIL",
								val + " Phone Number should be typed");
	
			}
		}
		catch(Exception e)
		{
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting(
					"Exception occured....", "FAIL",
					val + " Phone Number should be typed");
		}
	}

	/** ***************************************************************************************
	 * Keyword-Name:    typeOnMerchantEmail_Registration
	 * Usage:           void typeOnMerchantEmail_Registration()
	 * Description:     Type Email id
	 * Author:          Automators
	 * Dated:           19May2015
	 * Notes:   
	 *************************************************************************************** **/
	public void typeOnMerchantEmail_Registration()
	{
		String val_RandomData = null;
		String val_EmailDomain=null;
		String val_MerchantName=null;
		try {
			WebElement element = pageWiseOR.androidWAP.HomePage.getInstance().MobileWapMerchantRegistration_Email(driver);
			val_EmailDomain=GlobalVar.TEST_DATA.get("EmailDomain");
			val_MerchantName=GlobalVar.TEST_DATA.get("MerchantName");
			String split[]=val_MerchantName.split(" ");
			
			val_RandomData=Keywords.getRandomizedString("", split[1], val_EmailDomain);
			//System.out.println(val_RandomData);
			
			GlobalVar.MerchantEmail=(val_RandomData.toLowerCase());
			//System.out.println("Merchent Email - :"+GlobalVar.MerchantEmail);
			Keywords.clearEditField(element);
			Keywords.typeText(element, val_RandomData.toLowerCase());
			
			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting(val_RandomData + " Email ID typed successfully", "PASS",
								val_RandomData + " Email ID should be typed");
	
			} else {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting(val_RandomData + " Email ID not typed", "FAIL",
								val_RandomData + " Email ID should be typed");
	
			}
		}
		catch(Exception e)
		{
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting(
					"Exception occured....", "FAIL",
					val_RandomData + " Email ID should be typed");
		}
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    typeOnMerchantPassword_Registration
	 * Usage:           void typeOnMerchantPassword_Registration()
	 * Description:     Type password
	 * Author:          Automators
	 * Dated:           19May2015
	 * Notes:   
	 *************************************************************************************** **/
	public void typeOnMerchantPassword_Registration()
	{
		String val = null;
		try {
			WebElement element = pageWiseOR.androidWAP.HomePage.getInstance().MobileWapMerchantRegistration_Password(driver);
			val = GlobalVar.TEST_DATA.get("Password");
			Keywords.typeText(element, val);
			
			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting(val + " Password typed successfully", "PASS",
								val + " Password should be typed");
	
			} else {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting(val + " Password not typed", "FAIL",
								val + " Password should be typed");
	
			}
		}
		catch(Exception e)
		{
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting(
					"Exception occured....", "FAIL",
					val + " Password should be typed");
		}
	}
	
	public void selectMerchantState_Registration()
	{
		String val = null;
		try {
			WebElement element = pageWiseOR.androidWAP.HomePage.getInstance().MobileWapMerchantRegistration_State(driver);
			
			Select st = new Select(element);
			val = GlobalVar.TEST_DATA.get("State");
			st.selectByVisibleText(val);
						
			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting(val + " State Slected successfully", "PASS",
								val + " State should be Slected");
	
			} else {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting(val + " State not Slected", "FAIL",
								val + " State should be Slected");
	
			}
		}
		catch(Exception e)
		{
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting(
					"Exception occured....", "FAIL",
					val + " State should be Slected");
		}
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    typeOnMerchantCity_Registration
	 * Usage:           void typeOnMerchantCity_Registration()
	 * Description:     Type City
	 * Author:          Automators
	 * Dated:           19May2015
	 * Notes:   
	 *************************************************************************************** **/
	public void typeOnMerchantCity_Registration()
	{
		String val = null;
		try {
			WebElement element = pageWiseOR.androidWAP.HomePage.getInstance().MobileWapMerchantRegistration_City(driver);
			val = GlobalVar.TEST_DATA.get("City");
			Keywords.typeText(element, val);
			
			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting(val + " City typed successfully", "PASS",
								val + " City should be typed");
	
			} else {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting(val + " City not typed", "FAIL",
								val +" City should be typed");
	
			}
		}
		catch(Exception e)
		{
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting(
					"Exception occured....", "FAIL",
					val + " City should be typed");
		}
	}
	
	public void selectMerchantBusinessType_Registration()
	{
		String val = null;
		try {
			WebElement element = pageWiseOR.androidWAP.HomePage.getInstance().MobileWapMerchantRegistration_BusinessType(driver);
			val = GlobalVar.TEST_DATA.get("Business Type");
			Select st = new Select(element);
			st.selectByVisibleText(val);
						
			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting(val + " Business Type Slected successfully", "PASS",
								val + " Business Type should be Slected");
	
			} else {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting(val + " Business Type not Slected", "FAIL",
								val + " Business Type should be Slected");
	
			}
		}
		catch(Exception e)
		{
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting(
					"Exception occured....", "FAIL",
					val + " Business Type should be Slected");
		}
	}
	public void verifyTextOnPage(String text) {
		boolean textFound = false;
		try {
			textFound = driver.getPageSource().contains(text);

			if (textFound) {

				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting(text + " verified.", "PASS", text + " should be verified.");

			} else {

				DriverSession
						.getLastExecutionReportingInstance()
						.teststepreporting(text + " not verified.",
								"FAIL", text + " should be verified.");

			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance()
					.teststepreporting(text + " not verified.", "FAIL",text + 
							" should be verified.");
		}
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    typeOnMerchantDynamicEmail_Registration
	 * Usage:           void typeOnMerchantDynamicEmail_Registration()
	 * Description:     Type Email id
	 * Author:          Automators
	 * Dated:           20May2015
	 * Notes:   
	 *************************************************************************************** **/
	public void typeOnMerchantDynamicEmail_Registration()
	{
		String dynEmail = null;
		try {
			//System.out.println("Time stamp value " + (Long.toHexString(System.currentTimeMillis())));
			dynEmail = (GlobalVar.TEST_DATA.get("Existing Store") + (Long.toHexString(System.currentTimeMillis())) + "@gmail.com").toLowerCase();
			//System.out.println("Dynamic Email " + dynEmail);
			GlobalVar.dynamicEmail = dynEmail;
			WebElement element = pageWiseOR.androidWAP.HomePage.getInstance().MobileWapMerchantRegistration_Email(driver);
			Keywords.clearEditField(element);
			Keywords.typeText(element, dynEmail);
			
			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting(dynEmail + " Email ID typed successfully", "PASS",
								dynEmail + " Email ID should be typed");
	
			} else {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting(dynEmail + " Email ID not typed", "FAIL",
								dynEmail + " Email ID should be typed");
	
			}
		}
		catch(Exception e)
		{
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting(
					"Exception occured....", "FAIL",
					dynEmail + " Email ID should be typed");
		}
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    typeOnMerchantDynamicStoreName_Registration
	 * Usage:           void typeOnMerchantDynamicStoreName_Registration()
	 * Description:     Type store name
	 * Author:          Automators
	 * Dated:           19May2015
	 * Notes:   
	 *************************************************************************************** **/
	public void typeOnMerchantDynamicStoreName_Registration()
	{
		String dynStore = null;
		try {
			dynStore = GlobalVar.TEST_DATA.get("Store Name") + (Long.toHexString(System.currentTimeMillis()));
			WebElement element = pageWiseOR.androidWAP.HomePage.getInstance().MobileWapMerchantRegistration_StoreName(driver);
			Keywords.clearEditField(element);
			Keywords.typeText(element, dynStore);
			
			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting(dynStore + " Store Name typed successfully", "PASS",
								dynStore + " Store name should be typed");
	
			} else {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting(dynStore + " Store name not typed", "FAIL",
								dynStore + " Store name should be typed");
	
			}
		}
		catch(Exception e)
		{
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting(
					"Exception occured....", "FAIL",
					dynStore + " Store name should be typed");
		}
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    verifyStartButton
	 * Usage:           void verifyStartButton()
	 * Description:     verify on start button
	 * Author:          Automators
	 * Dated:           19May2015
	 * Notes:   
	 *************************************************************************************** **/
	public void verifyStartButton()
	{
		try {
			WebElement element = pageWiseOR.androidWAP.HomePage.getInstance().MobileWapMerchantRegistration_StartButton(driver);
			pageWiseOR.androidWAP.HomePage.getInstance().dynamicwait(driver, 60, element);
			Keywords.isElementPresent(element);
			
			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting("Start button Verified successfully.", "PASS",
								"Start button should be verified");
	
			} else {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting("Start button not verified", "FAIL",
								"Start button should be verified");
	
			}
		}
		catch(Exception e)
		{
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting(
					"Start button not verified", "FAIL",
					"Start button should be verified");
		}
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    clickStartButton
	 * Usage:           void clickStartButton()
	 * Description:     Click on Start button
	 * Author:          Automators
	 * Dated:           19May2015
	 * Notes:   
	 *************************************************************************************** **/
	public void clickStartButton()
	{
		try {
			WebElement element = pageWiseOR.androidWAP.HomePage.getInstance().MobileWapMerchantRegistration_StartButton(driver);
			pageWiseOR.androidWAP.HomePage.getInstance().dynamicwait(driver, 20, element);
			Keywords.click(element);
			
			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting("Start button Clicked.", "PASS",
								"Start button should be clicked");
	
			} else {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting("Start button not clicked", "FAIL",
								"Start button should be clicked");
	
			}
		}
		catch(Exception e)
		{
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting(
					"Exception occured....", "FAIL",
					"Start button should be clicked");
		}
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    verifySellerInfoLink
	 * Usage:           void verifySellerInfoLink()
	 * Description:     verify on seller info link
	 * Author:          Automators
	 * Dated:           19May2015
	 * Notes:   
	 *************************************************************************************** **/
	public void verifySellerInfoLink()
	{
		try {
			WebElement element = pageWiseOR.androidWAP.HomePage.getInstance().MobileWapMerchant_SellerInformationLink(driver);
			pageWiseOR.androidWAP.HomePage.getInstance().dynamicwait(driver, 20, element);
			Keywords.isElementPresent(element);
			
			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting("Seller info link Verified successfully.", "PASS",
								"Seller info link should be verified");
	
			} else {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting("Seller info link not verified", "FAIL",
								"Seller info link should be verified");
	
			}
		}
		catch(Exception e)
		{
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting(
					"Seller info link not verified", "FAIL",
					"Seller info link should be verified");
		}
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    clickSellerInfoLink
	 * Usage:           void clickSellerInfoLink()
	 * Description:     Click on seller information link
	 * Author:          Automators
	 * Dated:           19May2015
	 * Notes:   
	 *************************************************************************************** **/
	public void clickSellerInfoLink()
	{
		try {
			WebElement element = pageWiseOR.androidWAP.HomePage.getInstance().MobileWapMerchant_SellerInformationLink(driver);
			pageWiseOR.androidWAP.HomePage.getInstance().dynamicwait(driver, 60, element);
			Keywords.click(element);
			
			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting("seller information link Clicked.", "PASS",
								"sell with us link should be clicked");
	
			} else {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting("seller information link not clicked", "FAIL",
								"sell with us link should be clicked");
	
			}
		}
		catch(Exception e)
		{
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting(
					"Exception occured....", "FAIL",
					"seller information link should be clicked");
		}
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    clickOnSaveAndGoToNext_SellerInfoPage
	 * Usage:           void clickOnSaveAndGoToNext_SellerInfoPage()
	 * Description:     Click on on fill seller information
	 * Author:          Automators
	 * Dated:           20May2015
	 * Notes:   
	 *************************************************************************************** **/
	public void clickOnSaveAndGoToNext_SellerInfoPage()
	{
		
		try {
			WebElement element = pageWiseOR.androidWAP.HomePage.getInstance().SaveAndGoTONextSellerInfoPage(driver);
//			pageWiseOR.androidWAP.HomePage.getInstance().dynamicwait(driver, 20, element);
			Keywords.click(element);
						
			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting("Save and go to next step clicked successfully", "PASS",
								"Save and go to next step should be clicked");
	
			} else {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting("Save and go to next step not clicked", "FAIL",
								"Save and go to next step should be clicked");
	
			}
		}
		
		
		catch(Exception e)
		{
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting(
					"Exception occured....", "FAIL",
					"Save and go to next step should be clicked");
		}
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    typeOnCompanyLegalName_SellerInfoPage
	 * Usage:           void typeOnCompanyLegalName_SellerInfoPage()
	 * Description:     Type on company legal name on fill seller information
	 * Author:          Automators
	 * Dated:           20May2015
	 * Notes:   
	 *************************************************************************************** **/
	public void typeOnCompanyLegalName_SellerInfoPage()
	{
		String val = null;
		try {
			WebElement element = pageWiseOR.androidWAP.HomePage.getInstance().MobileWapMerchantSellerInformation_CompanyLegName(driver);
//			pageWiseOR.androidWAP.HomePage.getInstance().dynamicwait(driver, 20, element);
			val = GlobalVar.TEST_DATA.get("Company Name");
			Keywords.typeText(element, val);
			
			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting(val + " company legal name typed successfully", "PASS",
								val + " company legal name should be typed");
	
			} else {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting(val + " company legal name not typed", "FAIL",
								val + " company legal name should be typed");
	
			}
		}
		catch(Exception e)
		{
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting(
					"Exception occured....", "FAIL",
					val + " company legal name should be typed");
		}
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    checkSameAsAbove_SellerInfoPage
	 * Usage:           void checkSameAsAbove_SellerInfoPage()
	 * Description:     Check same as above on fill seller information
	 * Author:          Automators
	 * Dated:           21May2015
	 * Notes:   
	 *************************************************************************************** **/
	public void checkSameAsAbove_SellerInfoPage()
	{
		try {
			WebElement element = pageWiseOR.androidWAP.HomePage.getInstance().MobileWapMerchantSellerInformation_SameAsAbove(driver);
			Keywords.click(element);
						
			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting("Same as above checkbox checked successfully", "PASS",
								"Same as above checkbox should be checked");
	
			} else {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting("Same as above checkbox not checked", "FAIL",
								"Same as above checkbox should be checked");
	
			}
		}
		
		
		catch(Exception e)
		{
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting(
					"Exception occured....", "FAIL",
					"Same as above checkbox should be checked");
		}
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    typeOnDispatchAddress1_SellerInfoPage
	 * Usage:           void typeOnDispatchAddress1_SellerInfoPage()
	 * Description:     Type on PickUp/Dispatch address 1 on fill seller information
	 * Author:          Automators
	 * Dated:           20May2015
	 * Notes:   
	 *************************************************************************************** **/
	public void typeOnDispatchAddress1_SellerInfoPage()
	{
		String val = null;
		try {
			WebElement element = pageWiseOR.androidWAP.HomePage.getInstance().MobileWapMerchantSellerInformation_DispatchAddress1(driver);
//			pageWiseOR.androidWAP.HomePage.getInstance().dynamicwait(driver, 20, element);
			val = GlobalVar.TEST_DATA.get("PickUpOrDispatch address 1");
			Keywords.typeText(element, val);
			
			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting(val + " PickUp/Dispatch address 1 typed successfully", "PASS",
								val + " PickUp/Dispatch address 1 should be typed");
	
			} else {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting(val + " PickUp/Dispatch address 1 not typed", "FAIL",
								val + " PickUp/Dispatch address 1 should be typed");
	
			}
		}
		catch(Exception e)
		{
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting(
					"Exception occured....", "FAIL",
					val + " PickUp/Dispatch address 1 should be typed");
		}
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    typeOnDispatchAddress2_SellerInfoPage
	 * Usage:           void typeOnDispatchAddress2_SellerInfoPage()
	 * Description:     Type on PickUp/Dispatch address 2 on fill seller information
	 * Author:          Automators
	 * Dated:           20May2015
	 * Notes:   
	 *************************************************************************************** **/
	public void typeOnDispatchAddress2_SellerInfoPage()
	{
		String val = null;
		try {
			WebElement element = pageWiseOR.androidWAP.HomePage.getInstance().MobileWapMerchantSellerInformation_DispatchAddress2(driver);
//			pageWiseOR.androidWAP.HomePage.getInstance().dynamicwait(driver, 20, element);
			val = GlobalVar.TEST_DATA.get("PickUpOrDispatch address 2");
			Keywords.typeText(element, val);
			
			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting(val + " PickUp/Dispatch address 2 typed successfully", "PASS",
								val + " PickUp/Dispatch address 2 should be typed");
	
			} else {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting(val + " PickUp/Dispatch address 2 not typed", "FAIL",
								val + " PickUp/Dispatch address 2 should be typed");
	
			}
		}
		catch(Exception e)
		{
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting(
					"Exception occured....", "FAIL",
					val + " PickUp/Dispatch address 2 should be typed");
		}
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    typeOnCity_SellerInfoPage
	 * Usage:           void typeOnCity_SellerInfoPage()
	 * Description:     Type on city on fill seller information
	 * Author:          Automators
	 * Dated:           20May2015
	 * Notes:   
	 *************************************************************************************** **/
	public void typeOnCity_SellerInfoPage()
	{
		String val = null;
		try {
			WebElement element = pageWiseOR.androidWAP.HomePage.getInstance().MobileWapMerchantSellerInformation_City(driver);
//			pageWiseOR.androidWAP.HomePage.getInstance().dynamicwait(driver, 20, element);
			val =  GlobalVar.TEST_DATA.get("City");
			Keywords.typeText(element,val);
			
			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting(val + " City typed successfully", "PASS",
								val + " City should be typed");
	
			} else {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting(val + " City not typed", "FAIL",
								val + " City should be typed");
	
			}
		}
		catch(Exception e)
		{
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting(
					"Exception occured....", "FAIL",
					val + " City should be typed");
		}
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    selectState_SellerInfoPage
	 * Usage:           void selectState_SellerInfoPage()
	 * Description:     Select state on fill seller information
	 * Author:          Automators
	 * Dated:           20May2015
	 * Notes:   
	 *************************************************************************************** **/
	public void selectState_SellerInfoPage()
	{
		String val = null;
		try {
			WebElement element = pageWiseOR.androidWAP.HomePage.getInstance().MobileWapMerchantSellerInformation_State(driver);
			val = GlobalVar.TEST_DATA.get("State");
			Select st = new Select(element);
			st.selectByVisibleText(val);
						
			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting(val + " State Slected successfully", "PASS",
								val + " State should be Slected");
	
			} else {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting(val + " State not Slected", "FAIL",
								val + " State should be Slected");
	
			}
		}
		catch(Exception e)
		{
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting(
					"Exception occured....", "FAIL",
					val + " State should be Slected");
		}
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    typeOnPincode_SellerInfoPage
	 * Usage:           void typeOnPincode_SellerInfoPage()
	 * Description:     Type on Pin code on fill seller information
	 * Author:          Automators
	 * Dated:           20May2015
	 * Notes:   
	 *************************************************************************************** **/
	public void typeOnPincode_SellerInfoPage()
	{
		String val = null;
		try {
			WebElement element = pageWiseOR.androidWAP.HomePage.getInstance().MobileWapMerchantSellerInformation_PinCode(driver);
//			pageWiseOR.androidWAP.HomePage.getInstance().dynamicwait(driver, 20, element);
			val = GlobalVar.TEST_DATA.get("Pin Code");
			Keywords.typeText(element, val);
			
			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting(val + " Pin Code typed successfully", "PASS",
								val + " Pin Code should be typed");
	
			} else {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting(val + " Pin Code not typed", "FAIL",
								val + " Pin Code should be typed");
	
			}
		}
		catch(Exception e)
		{
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting(
					"Exception occured....", "FAIL",
					val + " Pin Code should be typed");
		}
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    verifyBankDetailsPage
	 * Usage:           void verifyBankDetailsPage()
	 * Description:     verify on bank details page
	 * Author:          Automators
	 * Dated:           20May2015
	 * Notes:   
	 *************************************************************************************** **/
	public void verifyBankDetailsPage()
	{
		try {
			WebElement element = pageWiseOR.androidWAP.HomePage.getInstance().MobileWapMerchantBankDetails_Pan(driver);
//			pageWiseOR.androidWAP.HomePage.getInstance().dynamicwait(driver, 20, element);
			Keywords.isElementPresent(element);
			
			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting("Bank details page Verified successfully.", "PASS",
								"Bank details page should be verified");
	
			} else {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting("Bank details page not verified", "FAIL",
								"Bank details page should be verified");
	
			}
		}
		catch(Exception e)
		{
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting(
					"Bank details page not verified", "FAIL",
					"Bank details page should be verified");
		}
	}
	
	 /** ***************************************************************************************
	 * Keyword-Name:    typeOnPanNumber_BankDetailsPage
	 * Usage:           void typeOnPanNumber_BankDetailsPage()
	 * Description:     Type on pan number field on bank details page
	 * Author:          Automators
	 * Dated:           21May2015
	 * Notes:   
	 *************************************************************************************** **/
	public void typeOnPanNumber_BankDetailsPage()
	{
		String val = null;
		try {
			WebElement element = pageWiseOR.androidWAP.HomePage.getInstance().MobileWapMerchantBankDetails_Pan(driver);
//			pageWiseOR.androidWAP.HomePage.getInstance().dynamicwait(driver, 20, element);
			val = GlobalVar.TEST_DATA.get("Pan Number");
			Keywords.typeText(element, val);
			
			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting(val + " Pan number typed successfully", "PASS",
								val + " Pan number should be typed");
	
			} else {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting(val + " Pan number not typed", "FAIL",
								val + " Pan number should be typed");
	
			}
		}
		catch(Exception e)
		{
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting(
					"Exception occured....", "FAIL",
					val + " Pan number should be typed");
		}
	}
	
	
	/** ***************************************************************************************
	 * Keyword-Name:    typeOnPanName_BankDetailsPage
	 * Usage:           void typeOnPanName_BankDetailsPage()
	 * Description:     Type on pan name field on bank details page
	 * Author:          Automators
	 * Dated:           21May2015
	 * Notes:   
	 *************************************************************************************** **/
	public void typeOnPanName_BankDetailsPage()
	{
		String val = null;
		try {
			WebElement element = pageWiseOR.androidWAP.HomePage.getInstance().MobileWapMerchantBankDetails_PanName(driver);

			val = GlobalVar.TEST_DATA.get("Pan Name");
			Keywords.typeText(element, val);
			
			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting(val + " Pan Name typed successfully", "PASS",
								val + " Pan Name should be typed");
	
			} else {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting(val + " Pan Name not typed", "FAIL",
								val + " Pan Name should be typed");
	
			}
		}
		catch(Exception e)
		{
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting(
					"Exception occured....", "FAIL",
					val + " Pan Name should be typed");
		}
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    typeOnPanDOB_BankDetailsPage
	 * Usage:           void typeOnPanDOB_BankDetailsPage()
	 * Description:     Type on pan DOB field on bank details page
	 * Author:          Automators
	 * Dated:           21May2015
	 * Notes:   
	 *************************************************************************************** **/
	public void typeOnPanDOB_BankDetailsPage()
	{
		String val = null;
		try {
			WebElement element = pageWiseOR.androidWAP.HomePage.getInstance().MobileWapMerchantBankDetails_PanDOB(driver);
//			pageWiseOR.androidWAP.HomePage.getInstance().dynamicwait(driver, 20, element);
			val = GlobalVar.TEST_DATA.get("Pan DOB");
			Keywords.typeText(element, val);
			
			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting(val + " Pan DOB typed successfully", "PASS",
								val + " Pan DOB should be typed");
	
			} else {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting(val + " Pan DOB not typed", "FAIL",
								val + " Pan DOB should be typed");
	
			}
		}
		catch(Exception e)
		{
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting(
					"Exception occured....", "FAIL",
					val + " Pan DOB should be typed");
		}
	}

	
	/** ***************************************************************************************
	 * Keyword-Name:    selectPanAnnualTurnOver_BankDetailsPage
	 * Usage:           void selectPanAnnualTurnOver_BankDetailsPage()
	 * Description:     Select Annual turn over field on bank details page
	 * Author:          Automators
	 * Dated:           21May2015
	 * Notes:   
	 *************************************************************************************** **/
	public void selectPanAnnualTurnOver_BankDetailsPage()
	{
		String val = null;
		try {
			WebElement element = pageWiseOR.androidWAP.HomePage.getInstance().MobileWapMerchantBankDetails_AnnualTurnOver(driver);
//			pageWiseOR.androidWAP.HomePage.getInstance().dynamicwait(driver, 20, element);
			val = GlobalVar.TEST_DATA.get("Annual TurnOver");
			Select st = new Select(element);
			st.selectByVisibleText(val);
			
			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting(val + " Annual TurnOver selected successfully", "PASS",
								val + " Annual TurnOver should be selected");
	
			} else {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting(val + " Annual TurnOver not selected", "FAIL",
								val + " Annual TurnOver should be selected");
	
			}
		}
		catch(Exception e)
		{
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting(
					"Exception occured....", "FAIL",
					val + " Annual TurnOver should be selected");
		}
	}

	/** ***************************************************************************************
	 * Keyword-Name:    selectDescribesYou_BankDetailsPage
	 * Usage:           void selectDescribesYou_BankDetailsPage()
	 * Description:     Select what best describes you field on bank details page
	 * Author:          Automators
	 * Dated:           21May2015
	 * Notes:   
	 *************************************************************************************** **/
	public void selectDescribesYou_BankDetailsPage()
	{
		String val = null;
		try {
			WebElement element = pageWiseOR.androidWAP.HomePage.getInstance().MobileWapMerchantBankDetails_DescribeYou(driver);
//			pageWiseOR.androidWAP.HomePage.getInstance().dynamicwait(driver, 20, element);
			val = GlobalVar.TEST_DATA.get("Describes You");
			Select st = new Select(element);
			st.selectByVisibleText(val);
			
			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting(val + " What best describes you selected successfully", "PASS",
								val + " What best describes you should be selected");
	
			} else {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting(val + " What best describes you not selected", "FAIL",
								val + " What best describes you should be selected");
	
			}
		}
		catch(Exception e)
		{
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting(
					"Exception occured....", "FAIL",
					val + " What best describes you should be selected");
		}
	}

	
	/** ***************************************************************************************
	 * Keyword-Name:    typeOnAccHolderName_BankDetailsPage
	 * Usage:           void typeOnAccHolderName_BankDetailsPage()
	 * Description:     Type on Account holderName field on bank details page
	 * Author:          Automators
	 * Dated:           21May2015
	 * Notes:   
	 *************************************************************************************** **/
	public void typeOnAccHolderName_BankDetailsPage()
	{
		String val = null;
		try {
			WebElement element = pageWiseOR.androidWAP.HomePage.getInstance().MobileWapMerchantBankDetails_AccHolderName(driver);
			val = GlobalVar.TEST_DATA.get("Account HolderName");
			Keywords.typeText(element, val);
			
			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting(val + " Account holder name typed successfully", "PASS",
								val + " Account holder name should be typed");
	
			} else {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting(val + " Account holder name not typed", "FAIL",
								val + " Account holder name should be typed");
	
			}
		}
		catch(Exception e)
		{
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting(
					"Exception occured....", "FAIL",
					val + " Account holder name should be typed");
		}
	}
	
	
	/** ***************************************************************************************
	 * Keyword-Name:    typeOnBankName_BankDetailsPage
	 * Usage:           void typeOnBankName_BankDetailsPage()
	 * Description:     Type on Bank Name field on bank details page
	 * Author:          Automators
	 * Dated:           21May2015
	 * Notes:   
	 *************************************************************************************** **/
	public void typeOnBankName_BankDetailsPage()
	{
		String val = null;
		try {
			WebElement element = pageWiseOR.androidWAP.HomePage.getInstance().MobileWapMerchantBankDetails_BankName(driver);
//			pageWiseOR.androidWAP.HomePage.getInstance().dynamicwait(driver, 20, element);
			val = GlobalVar.TEST_DATA.get("Bank Name");
			Keywords.typeText(element, val);
			
			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting(val + " Bank name typed successfully", "PASS",
								val + " Bank name should be typed");
	
			} else {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting(val + " Bank name not typed", "FAIL",
								val + " Bank name should be typed");
	
			}
		}
		catch(Exception e)
		{
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting(
					"Exception occured....", "FAIL",
					val + " Bank name should be typed");
		}
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    typeOnBankAccountNo_BankDetailsPage
	 * Usage:           void typeOnBankAccountNo_BankDetailsPage()
	 * Description:     Type on Bank account number field on bank details page
	 * Author:          Automators
	 * Dated:           21May2015
	 * Notes:   
	 *************************************************************************************** **/
	public void typeOnBankAccountNo_BankDetailsPage()
	{
		String val = null;
		try {
			WebElement element = pageWiseOR.androidWAP.HomePage.getInstance().MobileWapMerchantBankDetails_AccountNumber(driver);
			val = GlobalVar.TEST_DATA.get("Bank AccountNo");
			Keywords.typeText(element, val);
			
			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting(val + " Bank AccountNo typed successfully", "PASS",
								val + " Bank AccountNo should be typed");
	
			} else {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting(val + " Bank AccountNo not typed", "FAIL",
								val + " Bank AccountNo should be typed");
	
			}
		}
		catch(Exception e)
		{
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting(
					"Exception occured....", "FAIL",
					val + " Bank AccountNo should be typed");
		}
	}

	/** ***************************************************************************************
	 * Keyword-Name:    selectBankAccountType_BankDetailsPage
	 * Usage:           void selectBankAccountType_BankDetailsPage()
	 * Description:     Type on Bank account type field on bank details page
	 * Author:          Automators
	 * Dated:           21May2015
	 * Notes:   
	 *************************************************************************************** **/
	public void selectBankAccountType_BankDetailsPage()
	{
		String val = null;
		try {
			WebElement element = pageWiseOR.androidWAP.HomePage.getInstance().MobileWapMerchantBankDetails_AccountType(driver);
//			pageWiseOR.androidWAP.HomePage.getInstance().dynamicwait(driver, 20, element);
			val = GlobalVar.TEST_DATA.get("Account Type");
			Select st = new Select(element);
			st.selectByVisibleText(val);
			
			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting(val + " Bank Account Type selected successfully", "PASS",
								val + " Bank Account Type should be selected");
	
			} else {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting(val + " Bank Account Type not selected", "FAIL",
								val + " Bank Account Type should be selected");
	
			}
		}
		catch(Exception e)
		{
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting(
					"Exception occured....", "FAIL",
					val + " Bank Account Type should be selected");
		}
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    typeOnBankIFSC_BankDetailsPage
	 * Usage:           void typeOnBankIFSC_BankDetailsPage()
	 * Description:     Type on Bank IFSC field on bank details page
	 * Author:          Automators
	 * Dated:           21May2015
	 * Notes:   
	 *************************************************************************************** **/
	public void typeOnBankIFSC_BankDetailsPage()
	{
		String val = null;
		try {
			WebElement element = pageWiseOR.androidWAP.HomePage.getInstance().MobileWapMerchantBankDetails_IFSCCode(driver);
//			pageWiseOR.androidWAP.HomePage.getInstance().dynamicwait(driver, 20, element);
			val = GlobalVar.TEST_DATA.get("Bank IFSC");
			Keywords.typeText(element, val);
			
			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting(val + " Bank IFSC typed successfully", "PASS",
								val + " Bank IFSC should be typed");
	
			} else {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting(val + " Bank IFSC not typed", "FAIL",
								val + " Bank IFSC should be typed");
	
			}
		}
		catch(Exception e)
		{
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting(
					"Exception occured....", "FAIL",
					val + " Bank IFSC should be typed");
		}
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    checkAgreementStatement_BankDetailsPage
	 * Usage:           void checkAgreementStatement_BankDetailsPage()
	 * Description:     Check Bank agreement field on bank details page
	 * Author:          Automators
	 * Dated:           21May2015
	 * Notes:   
	 *************************************************************************************** **/
	public void checkAgreementStatement_BankDetailsPage()
	{
		
		try {
			WebElement element = pageWiseOR.androidWAP.HomePage.getInstance().MobileWapMerchantBankDetails_AgreementCheck(driver);
//			pageWiseOR.androidWAP.HomePage.getInstance().dynamicwait(driver, 20, element);
			
			Keywords.click(element);
			
			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting("Bank agreement checked successfully", "PASS",
								"Bank agreement should be checked");
	
			} else {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting("Bank agreement not checked", "FAIL",
								"Bank agreement should be checked");
	
			}
		}
		catch(Exception e)
		{
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting(
					"Exception occured....", "FAIL",
					"Bank agreement should be checked");
		}
	}
	public void validateUploadingOptions() {
		List<WebElement>upload_Options=null;
		String uploadOptionDataSheet=null;
		List<String>splitToMultiple=null;
		String value=null;
		try{
			upload_Options=HomePage.getInstance().clickToVariousUploadingOptions(driver);
			uploadOptionDataSheet=GlobalVar.TEST_DATA.get("uploadingOption");
			splitToMultiple=Keywords.splitRowDataWithPipeOperator(uploadOptionDataSheet);
			
			
			for(WebElement option : upload_Options)
			{
				value=option.findElement(By.className("prd_heading")).getText();
				for(int i=0;i<splitToMultiple.size();i++){
					
					if(value.equalsIgnoreCase(splitToMultiple.get(i))){
						
						DriverSession.getLastExecutionReportingInstance()
						.teststepreporting("Various uploading options are : <b><i>"+value+"</i></b> is successfully validated ", "PASS",
								"Various uploading options are : <b><i>"+value+"</i></b> should be successfully validated");
						
						value=null;
						break;
					}else{
						continue;
					}
				}
				
			}
			
		}catch(Exception e){
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Various uploading options are : <b><i>"+value+"</i></b> is not successfully validated ", "FAIL",
					"Various uploading options are : <b><i>"+value+"</i></b> should be successfully validated");
		}
		
	}
	public void verify1By1UploadProductpage() {
		WebElement uploadProduct_Banner=null;
		try{
			uploadProduct_Banner=HomePage.getInstance().clickTo_OneByOneBanner(driver);
			Keywords.validateElementExistOrNot(uploadProduct_Banner);
			
			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting("Inside Various Uploading option : "+uploadProduct_Banner.getText()+" is successfully validated ", "PASS",
								"Inside Various Uploading option : "+uploadProduct_Banner.getText()+" should be successfully validated");
	
			} else {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("Inside Various Uploading option : "+uploadProduct_Banner.getText()+" is not successfully validated ", "FAIL",
						"Inside Various Uploading option : "+uploadProduct_Banner.getText()+" should be successfully validated");
	
			}
			
		}catch(Exception e){
			e.getMessage();
		}
		
	}
	public void clickToOneByOneStartUploadingOption() {
		WebElement click_oneByOneOption=null;
		try{
			click_oneByOneOption=HomePage.getInstance().clickToOneByOneOption(driver);
			Keywords.click(click_oneByOneOption);
			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting(" <b><i> 1-by-1 Upload </i></b> is successfully clicked ", "PASS",
								"<b><i> 1-by-1 Upload </i></b>  should be successfully clicked");
	
			} else {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting(" <b><i> 1-by-1 Upload </i></b> is not successfully clicked ", "FAIL",
						"<b><i> 1-by-1 Upload </i></b>  should be successfully clicked");
	
			}
		}
		catch(Exception e){
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting(" <b><i> 1-by-1 Upload </i></b> is not successfully clicked ", "FAIL",
					"<b><i> 1-by-1 Upload </i></b>  should be successfully clicked");
			
		}
	}
	public void clickAndValidateToCreateNewProduct() {
		WebElement createnewproduct=null;
		try{
			createnewproduct=HomePage.getInstance().clickCreateNewProduct(driver);
			Keywords.validateElementExistOrNot(createnewproduct);
			Keywords.click(createnewproduct);
			
			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting("In-Side <b><i> 1-by-1 Product Upload and Successfully validated and Clicked to "+createnewproduct.getText()+" ", "PASS",
								"In-Side <b><i> 1-by-1 Product Upload and should be Successfully validated and Clicked to "+createnewproduct.getText());
	
			} else {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("In-Side <b><i> 1-by-1 Product Upload and not Successfully validated and Clicked to "+createnewproduct.getText()+" ", "FAIL",
						"In-Side <b><i> 1-by-1 Product Upload and should be Successfully validated and Clicked to "+createnewproduct.getText());
	
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	public void productTitleField() {
		WebElement prod_Title=null;
		String prodTitle_DataSheet=null;
		try{
			prod_Title=HomePage.getInstance().clickToProdTitleField(driver);
			prodTitle_DataSheet=GlobalVar.TEST_DATA.get("prodTitle");
			Keywords.clearEditField(prod_Title);
			Keywords.typeText(prod_Title, prodTitle_DataSheet);
			
			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting("Product Title Field is successfully validated and text <b><i>"+prodTitle_DataSheet+" </i</b> is successfully Entered ", "PASS",
								"Product Title Field is successfully validated and text <b><i>"+prodTitle_DataSheet+" </i</b> should be successfully Entered ");
	
			} else {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("Product Title Field is successfully validated and text <b><i>"+prodTitle_DataSheet+" </i</b> is not successfully Entered ", "FAIL",
						"Product Title Field is successfully validated and text <b><i>"+prodTitle_DataSheet+" </i</b> should be successfully Entered ");
	
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}
	public void selectCategory() {
		WebElement select_Catag=null,sub_CatgList=null,third_CatgList=null;
		String s_Catg_DataSheet_RawData=null;
		List<String>splitData=null;
		try{
			s_Catg_DataSheet_RawData=GlobalVar.TEST_DATA.get("ProdCategory");
			splitData=Keywords.splitRowDataWithPipeOperator(s_Catg_DataSheet_RawData);
			
			select_Catag=HomePage.getInstance().clickToSelectCatg(driver);
			Keywords.click(select_Catag);
			Keywords.selectByVisibleText(select_Catag, splitData.get(0));
			
			Keywords.explicitWait(1);
			sub_CatgList=HomePage.getInstance().clickSubCategoryList(driver);
			Keywords.click(sub_CatgList);
			Keywords.selectByVisibleText(sub_CatgList, splitData.get(1));
			
			Keywords.explicitWait(1);
			third_CatgList=HomePage.getInstance().clickToThirdCatgList(driver);
			Keywords.click(third_CatgList);
			Keywords.selectByVisibleText(third_CatgList, splitData.get(2));
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	public void productListPrice() {
		WebElement prod_Price=null;
		String prodDataListprice=null;
		List<String>options=null;
		try{
			prod_Price=HomePage.getInstance().clickToProdPrice(driver);
			Keywords.clearEditField(prod_Price);
			prodDataListprice=GlobalVar.TEST_DATA.get("ProductDataListprice");
			options=Keywords.splitRowDataWithPipeOperator(prodDataListprice);
			
			Keywords.typeText(prod_Price, options.get(0));
			
			if(GlobalVar.etpStepsReport){
				DriverSession.getLastExecutionReportingInstance()
				 .teststepreporting("Product Category MRP : "+options.get(0)+" is successfully entered and Verified ", "PASS",
						 "Product Category MRP : "+options.get(0)+" should be successfully entered and Verified ");
			}
			else{
				DriverSession.getLastExecutionReportingInstance()
				 .teststepreporting("Product Category MRP : "+options.get(0)+" is not successfully entered and Verified ", "FAIL",
						 "Product Category MRP : "+options.get(0)+" should be successfully entered and Verified ");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public void retailPrice() {
		WebElement r_price=null;
		String prodDataListprice=null;
		List<String>options=null;
		try{
			r_price=HomePage.getInstance().clickToRetailPrice(driver);
			Keywords.clearEditField(r_price);
			prodDataListprice=GlobalVar.TEST_DATA.get("ProductDataListprice");
			options=Keywords.splitRowDataWithPipeOperator(prodDataListprice);
			
			Keywords.typeText(r_price, options.get(1));
			if(GlobalVar.etpStepsReport){
				DriverSession.getLastExecutionReportingInstance()
				 .teststepreporting("Product Category Retail Price : "+options.get(1)+" is successfully entered and Verified ", "PASS",
						 "Product Category Retail Price : "+options.get(1)+" should be successfully entered and Verified ");
			}
			else{
				DriverSession.getLastExecutionReportingInstance()
				 .teststepreporting("Product Category Retail Price : "+options.get(1)+" is not successfully entered and Verified ", "FAIL",
						 "Product Category Retail Price : "+options.get(1)+" should be successfully entered and Verified ");
			}
			
		}
		catch(Exception e){
			
		}
		
	}
	public void sellingPrice() {
		WebElement sellin_price=null;
		String prodDataListprice=null;
		List<String>options=null;
		try{
			sellin_price=HomePage.getInstance().clickTo_SellingPrice(driver);
			Keywords.clearEditField(sellin_price);
			prodDataListprice=GlobalVar.TEST_DATA.get("ProductDataListprice");
			options=Keywords.splitRowDataWithPipeOperator(prodDataListprice);
		
			Keywords.typeText(sellin_price, options.get(2));
			if(GlobalVar.etpStepsReport){
				DriverSession.getLastExecutionReportingInstance()
				 .teststepreporting("Product Category Retail Price : "+options.get(2)+" is successfully entered and Verified ", "PASS",
						 "Product Category Retail Price : "+options.get(1)+" should be successfully entered and Verified ");
			}
			else{
				DriverSession.getLastExecutionReportingInstance()
				 .teststepreporting("Product Category Retail Price : "+options.get(2)+" is not successfully entered and Verified ", "FAIL",
						 "Product Category Retail Price : "+options.get(1)+" should be successfully entered and Verified ");
			}
			
		}catch(Exception e){
			e.getMessage();
		}
		
	}
	public void FullDescription() {
		WebElement desc=null;
		WebElement count_Desc=null;
		String desc_DataSheet=null;
		try{
			desc=HomePage.getInstance().clickTo_FullDescription(driver);
			count_Desc=HomePage.getInstance().clickToDescCounter(driver);
			Keywords.click(desc);
			desc_DataSheet=GlobalVar.TEST_DATA.get("FullDescription");
			Keywords.typeText(desc, desc_DataSheet+" - "+GlobalVar.TEST_DATA.get("prodTitle"));
			
			if(GlobalVar.etpStepsReport){
				DriverSession.getLastExecutionReportingInstance()
				 .teststepreporting("Product Category Full Description  : "+desc_DataSheet+" with "+count_Desc.getText()+"is successfully entered and Verified ", "PASS",
						 "Product Category Full Description : "+desc_DataSheet+" should be successfully entered and Verified ");
			}
			else{
				DriverSession.getLastExecutionReportingInstance()
				 .teststepreporting("Product Category Full Description : "+desc_DataSheet+" is not successfully entered and Verified ", "FAIL",
						 "Product Category Full Description : "+desc_DataSheet+" should be successfully entered and Verified ");
			}
			
		}
		catch(Exception e){
			e.getMessage();
		}
		
	}
	public void productStatus() {
		WebElement status=null;
		String status_Datasheet=null;
		try{
			status=HomePage.getInstance().clickToStatusBox(driver);
			Keywords.click(status);
			status_Datasheet=GlobalVar.TEST_DATA.get("statusType");
			Keywords.selectByVisibleText(status, status_Datasheet);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}
	public void uploadPictureOfCurrentProduct() {
		WebElement upload=null;
		String urlAddress_DataSheet=null;
		try{
			upload=HomePage.getInstance().clickToUploadPictureURL(driver);
			urlAddress_DataSheet=GlobalVar.TEST_DATA.get("Url_UploadmainPicture");
			Keywords.click(upload);
			
			 Toolkit toolkit = Toolkit.getDefaultToolkit();
			 Clipboard clipboard = toolkit.getSystemClipboard();
 
			 clipboard.setContents(new StringSelection(urlAddress_DataSheet),null);
			 
			 Robot robot = new Robot();
			 robot.keyPress(KeyEvent.VK_CONTROL);
			 robot.keyPress(KeyEvent.VK_V);
	         robot.keyRelease(KeyEvent.VK_CONTROL);
	         robot.keyRelease(KeyEvent.VK_V);
	         
	         robot.delay(5000);
	         robot.keyPress(KeyEvent.VK_ENTER);
	         robot.keyRelease(KeyEvent.VK_ENTER);
             Thread.sleep(2000);

		}
				/*driver.switchTo().alert().sendKeys(urlAddress_DataSheet);
				driver.switchTo().alert().accept();*/
				
			catch(NoAlertPresentException ex){
				ex.getMessage();
			}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}
	public void typeOnMerchantRe_Password_Registration() {
		WebElement re_Pass=null;
		String val=null;
		try{
			re_Pass=HomePage.getInstance().clickTo_Repassword(driver);
			val = GlobalVar.TEST_DATA.get("Password");
			Keywords.typeText(re_Pass, val);
			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting(val + "Re- Password typed successfully", "PASS",
								val + " Re- Password should be typed");
	
			} else {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting(val + " Re- Password not typed", "FAIL",
								val + " Re- Password should be typed");
	
			}
		}
		catch(Exception e){
			e.getMessage();
		}
		
	}
	public void enterUsername() {
		WebElement u_Name=null;
	
		String option=null;
		try{
			u_Name=HomePage.getInstance().clickToUserNameLoginPage(driver);
			option=GlobalVar.TEST_DATA.get("testemail");
			Keywords.typeText(u_Name, option);
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}
	public void enterPassword() {
		WebElement password=null;
		String pwd=null;
		try{
			password=HomePage.getInstance().clickTo_Password(driver);
			pwd=GlobalVar.TEST_DATA.get("Password");
			Keywords.typeText(password, pwd);
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}
	public void clickLogin() {
		WebElement submit=null;
		try{
			submit=HomePage.getInstance().clickToLogin(driver);
			Keywords.click(submit);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}
	public void typeStrategicBussinessEmail() {
		WebElement s_business=null;
		try{
			s_business=HomePage.getInstance().clickToStraticBusiness(driver);
			Keywords.clearEditField(s_business);
			Keywords.typeText(s_business,GlobalVar.MerchantEmail);
			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting("Strategic Business Email is : " +GlobalVar.MerchantEmail + " successfully typed", "PASS",
								"Strategic Business Email is : " +GlobalVar.MerchantEmail + " should be typed");
	
			} else {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("Strategic Business Email is : " +GlobalVar.MerchantEmail + " is not successfully typed", "FAIL",
						"Strategic Business Email is : " +GlobalVar.MerchantEmail + " should be typed");
	
			}
			
		}
		catch(Exception e){
			e.getMessage();
		}
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    clickOnContinueToMobileSitePopUp
	 * Usage:           void clickOnContinueToMobileSitePopUp()
	 * Description:     Click on continue to mobile site popup
	 * Author:          Automators
	 * Dated:           22May2015
	 * Notes:   
	 *************************************************************************************** **/
	public void clickOnContinueToMobileSitePopUp()
	{
		try {
			WebElement element = pageWiseOR.androidWAP.HomePage.getInstance().MobileWapContinueToMobileSite(driver);
//			pageWiseOR.androidWAP.HomePage.getInstance().dynamicwait(driver, 20, element);
			
			Keywords.click(element);
			
			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting("Continue to mobile site pop up clicked successfully", "PASS",
								"Continue to mobile site pop up should be Clicked");
	
			} else {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting("Continue to mobile site pop up not clicked", "FAIL",
								"Continue to mobile site pop up should be clicked");
	
			}
		}
		catch(Exception e)
		{
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting(
					"Exception occured....", "FAIL",
					"Continue to mobile site pop up should be clicked");
		}
	}

	/** ***************************************************************************************
	 * Keyword-Name:    clickWishListIcon
	 * Usage:           void clickWishListIcon()
	 * Description:     Click on wishlist Icon
	 * Author:          Automators
	 * Dated:           19May2015
	 * Notes:   
	 *************************************************************************************** **/
	public void clickWishListIcon()
	{
		try {
			WebElement element = pageWiseOR.androidWAP.HomePage.getInstance().wishlistHomeIcon(driver);
//			pageWiseOR.androidWAP.HomePage.getInstance().dynamicwait(driver, 20, element);
			Keywords.click(element);
			
			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting("WishList icon Clicked.", "PASS",
								"WishList icon should be clicked");
	
			} else {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting("WishList icon not clicked", "FAIL",
								"WishList icon should be clicked");
	
			}
		}
		catch(Exception e)
		{
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting(
					"Exception occured....", "FAIL",
					"WishList icon should be clicked");
		}
	}
	
	
	/** ***************************************************************************************
	 * Keyword-Name:    typeOnMerchantUserName_Login
	 * Usage:           void typeOnMerchantUserName_Login()
	 * Description:     Type on user name for login
	 * Author:          Automators
	 * Dated:           20May2015
	 * Notes:   
	 *************************************************************************************** **/
	public void typeOnMerchantUserName_Login()
	{
		String val = null;
		try {
			WebElement element = pageWiseOR.androidWAP.HomePage.getInstance().MobileWapMerchantLogin_UserName(driver);
//			pageWiseOR.androidWAP.HomePage.getInstance().dynamicwait(driver, 20, element);
			val = GlobalVar.TEST_DATA.get("User Name");
			Keywords.typeText(element, val);
			
			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting(val + " User Name typed successfully", "PASS",
								val + " User name should be typed");
	
			} else {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting(val + " User name not typed", "FAIL",
								val + " User name should be typed");
	
			}
		}
		catch(Exception e)
		{
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting(
					"Exception occured....", "FAIL",
					val + " User name should be typed");
		}
	}
	/** ***************************************************************************************
	 * Keyword-Name:    typeOnMerchantPassword_Login
	 * Usage:           void typeOnMerchantPassword_Login()
	 * Description:     Type on password for login
	 * Author:          Automators
	 * Dated:           20May2015
	 * Notes:   
	 *************************************************************************************** **/
	public void typeOnMerchantPassword_Login()
	{
		String val = null;
		try {
			WebElement element = pageWiseOR.androidWAP.HomePage.getInstance().MobileWapMerchantLogin_Password(driver);
//			pageWiseOR.androidWAP.HomePage.getInstance().dynamicwait(driver, 20, element);
			val = GlobalVar.TEST_DATA.get("Login Password");
			Keywords.typeText(element, val);
			
			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting(val + " Password typed successfully", "PASS",
								val + " Password should be typed");
	
			} else {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting(val + " Password not typed", "FAIL",
								val + " Password should be typed");
	
			}
		}
		catch(Exception e)
		{
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting(
					"Exception occured....", "FAIL",
					val + " Password should be typed");
		}
	}
	/** ***************************************************************************************
	 * Keyword-Name:    clickOnMerchantLoginButton
	 * Usage:           void clickOnMerchantLoginButton()
	 * Description:     Click on Login button
	 * Author:          Automators
	 * Dated:           20May2015
	 * Notes:   
	 *************************************************************************************** **/
	public void clickOnMerchantLoginButton()
	{
		try {
			WebElement element = pageWiseOR.androidWAP.HomePage.getInstance().MobileWapMerchantLogin_LoginButton(driver);
//			pageWiseOR.androidWAP.HomePage.getInstance().dynamicwait(driver, 20, element);
			Keywords.click(element);
			
			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting("Login button Clicked.", "PASS",
								"Login button should be clicked");
	
			} else {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting("Login button not clicked", "FAIL",
								"Login button should be clicked");
	
			}
		}
		catch(Exception e)
		{
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting(
					"Exception occured....", "FAIL",
					"Login button should be clicked");
		}
	}
	
	public void clickOnMerchantSupport_Link()
	{
		
		try {
			WebElement element = pageWiseOR.androidWAP.HomePage.getInstance().merchantSupportLink(driver);
			
			Keywords.click(element);
			
			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting("Continue to mobile site pop up clicked successfully", "PASS",
								"Continue to mobile site pop up should be Clicked");
	
			} else {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting("Continue to mobile site pop up not clicked", "FAIL",
								"Continue to mobile site pop up should be clicked");
	
			}
		}
		catch(Exception e)
		{
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting(
					"Exception occured....", "FAIL",
					"Continue to mobile site pop up should be clicked");
		}
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    typeOnMerchantSupport_Email
	 * Usage:           void typeOnMerchantSupport_Email()
	 * Description:     Type on user name for login
	 * Author:          KAutomators
	 * Dated:           20May2015
	 * Notes:   
	 *************************************************************************************** **/
	public void typeOnMerchantSupport_Email()
	{
		String val = null;
		try {
			WebElement element = pageWiseOR.androidWAP.HomePage.getInstance().merchantSupportEmail(driver);
//			pageWiseOR.androidWAP.HomePage.getInstance().dynamicwait(driver, 20, element);
			val = GlobalVar.TEST_DATA.get("Email");
			Keywords.typeText(element, val);
			
			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting(val + " User Name typed successfully", "PASS",
								val + " User name should be typed");
	
			} else {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting(val + " User name not typed", "FAIL",
								val + " User name should be typed");
	
			}
		}
		catch(Exception e)
		{
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting(
					"Exception occured....", "FAIL",
					val + " User name should be typed");
		}
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    typeOnMerchantSupport_MID
	 * Usage:           void typeOnMerchantSupport_MID()
	 * Description:     Type on user name for login
	 * Author:          KAutomators
	 * Dated:           20May2015
	 * Notes:   
	 *************************************************************************************** **/
	public void typeOnMerchantSupport_MID()
	{
		String val = null;
		try {
			WebElement element = pageWiseOR.androidWAP.HomePage.getInstance().merchantSupportID(driver);
//			pageWiseOR.androidWAP.HomePage.getInstance().dynamicwait(driver, 20, element);
			val = GlobalVar.TEST_DATA.get("MID");
			Keywords.typeText(element, val);
			
			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting(val + " User Name typed successfully", "PASS",
								val + " User name should be typed");
	
			} else {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting(val + " User name not typed", "FAIL",
								val + " User name should be typed");
	
			}
		}
		catch(Exception e)
		{
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting(
					"Exception occured....", "FAIL",
					val + " User name should be typed");
		}
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    typeOnMerchantSupport_Name
	 * Usage:           void typeOnMerchantSupport_Name()
	 * Description:     Type on user name for login
	 * Author:          KAutomators
	 * Dated:           20May2015
	 * Notes:   
	 *************************************************************************************** **/
	public void typeOnMerchantSupport_Name()
	{
		String val = null;
		try {
			WebElement element = pageWiseOR.androidWAP.HomePage.getInstance().merchantSupportName(driver);
//			pageWiseOR.androidWAP.HomePage.getInstance().dynamicwait(driver, 20, element);
			val = GlobalVar.TEST_DATA.get("Name");
			Keywords.typeText(element, val);
			
			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting(val + " User Name typed successfully", "PASS",
								val + " User name should be typed");
	
			} else {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting(val + " User name not typed", "FAIL",
								val + " User name should be typed");
	
			}
		}
		catch(Exception e)
		{
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting(
					"Exception occured....", "FAIL",
					val + " User name should be typed");
		}
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    typeOnMerchantSupport_Phone
	 * Usage:           void typeOnMerchantSupport_Phone()
	 * Description:     Type on user name for login
	 * Author:         	KAutomators
	 * Dated:           20May2015
	 * Notes:   
	 *************************************************************************************** **/
	public void typeOnMerchantSupport_Phone()
	{
		String val = null;
		try {
			WebElement element = pageWiseOR.androidWAP.HomePage.getInstance().merchantSupportPhone(driver);
//			pageWiseOR.androidWAP.HomePage.getInstance().dynamicwait(driver, 20, element);
			val = GlobalVar.TEST_DATA.get("Phone");
			Keywords.typeText(element, val);
			
			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting(val + " User Name typed successfully", "PASS",
								val + " User name should be typed");
	
			} else {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting(val + " User name not typed", "FAIL",
								val + " User name should be typed");
	
			}
		}
		catch(Exception e)
		{
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting(
					"Exception occured....", "FAIL",
					val + " User name should be typed");
		}
	}
	public void selectOnMerchantSupport_IssueType()
	{
		String val = null;
		try {
			
			Select st = new Select(pageWiseOR.androidWAP.HomePage.getInstance().merchantSupportIssueType(driver));
			st.selectByVisibleText(GlobalVar.TEST_DATA.get("Issue Type"));
			
			
			
			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting(val + " User Name typed successfully", "PASS",
								val + " User name should be typed");
	
			} else {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting(val + " User name not typed", "FAIL",
								val + " User name should be typed");
	
			}
		}
		catch(Exception e)
		{
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting(
					"Exception occured....", "FAIL",
					val + " User name should be typed");
		}
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    typeOnMerchantSupport_Message
	 * Usage:           void typeOnMerchantSupport_Message()
	 * Description:     Type on user name for login
	 * Author:          KAutomators
	 * Dated:           20May2015
	 * Notes:   
	 *************************************************************************************** **/
	public void typeOnMerchantSupport_Message()
	{
		String val = null;
		try {
			WebElement element = pageWiseOR.androidWAP.HomePage.getInstance().merchantSupportMessage(driver);
//			pageWiseOR.androidWAP.HomePage.getInstance().dynamicwait(driver, 20, element);
			val = GlobalVar.TEST_DATA.get("Message");
			Keywords.typeText(element, val);
			
			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting(val + " User Name typed successfully", "PASS",
								val + " User name should be typed");
	
			} else {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting(val + " User name not typed", "FAIL",
								val + " User name should be typed");
	
			}
		}
		catch(Exception e)
		{
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting(
					"Exception occured....", "FAIL",
					val + " User name should be typed");
		}
	}
	
	public void typeOnMerchantSupport_typeCapcha()
	{
		WebElement element=null;
		String val = null;
		try {
			element = pageWiseOR.androidWAP.HomePage.getInstance().merchantSupportCapchaText(driver);
			val=Keywords.getAttributeVal(element, "value");
			
			 element = pageWiseOR.androidWAP.HomePage.getInstance().merchantSupportCapchaTextBox(driver);
			 Keywords.typeText(element, val);
			
			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting(val + " User Name typed successfully", "PASS",
								val + " User name should be typed");
	
			} else {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting(val + " User name not typed", "FAIL",
								val + " User name should be typed");
	
			}
		}
		catch(Exception e)
		{
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting(
					"Exception occured....", "FAIL",
					val + " User name should be typed");
		}
	}
	
	public void clickOnMerchantSupport_Submit()
	{
		
		try {
			WebElement element = pageWiseOR.androidWAP.HomePage.getInstance().merchantSupportSubmit(driver);
			
			Keywords.click(element);
			
			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting("Continue to mobile site pop up clicked successfully", "PASS",
								"Continue to mobile site pop up should be Clicked");
	
			} else {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting("Continue to mobile site pop up not clicked", "FAIL",
								"Continue to mobile site pop up should be clicked");
	
			}
		}
		catch(Exception e)
		{
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting(
					"Exception occured....", "FAIL",
					"Continue to mobile site pop up should be clicked");
		}
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    clickOnRequestStoreApprovalButton
	 * Usage:           void clickOnRequestStoreApprovalButton()
	 * Description:     Click on request store approval button
	 * Author:          Automators
	 * Dated:           25May2015
	 * Notes:   
	 *************************************************************************************** **/
	public void clickOnRequestStoreApprovalButton()
	{
		
		try {
			WebElement element = pageWiseOR.androidWAP.HomePage.getInstance().mobileWapRequestStoreApprovalButton(driver);
			pageWiseOR.androidWAP.HomePage.getInstance().dynamicwait(driver, 20, element);
			
			Keywords.click(element);
			
			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting("Request store approval button clicked successfully", "PASS",
								"Request store approval button should be Clicked");
	
			} else {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting("Request store approval button not clicked", "FAIL",
								"Request store approval button should be clicked");
	
			}
		}
		catch(Exception e)
		{
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting(
					"Exception occured....", "FAIL",
					"Request store approval button should be clicked");
		}
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    getAndVerifyRequestApprovalPendingText
	 * Usage:           void getAndVerifyRequestApprovalPendingText()
	 * Description:     Get text of request approval pending
	 * Author:          Automators
	 * Dated:           25May2015
	 * Notes:   
	 *************************************************************************************** **/
	public void getAndVerifyRequestApprovalPendingText()
	{
		String txt,txt1 = null;
		try {
			WebElement element = pageWiseOR.androidWAP.HomePage.getInstance().mobileWapRequestApprovalPending(driver);
			pageWiseOR.androidWAP.HomePage.getInstance().dynamicwait(driver, 20, element);
			txt1= GlobalVar.TEST_DATA.get("Request Pending Text");
			txt = Keywords.getText(element);
			
			if (GlobalVar.etpStepsReport && txt.trim().equalsIgnoreCase(GlobalVar.TEST_DATA.get("Request Pending Text"))) {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting(txt1 + " text verified successfully", "PASS",
								txt1 + " text should be verified");
	
			} else {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting(txt1 + " text not verified", "FAIL",
								txt1 + " text should be verified");
	
			}
		}
		catch(Exception e)
		{
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting(
					"Exception occured....", "FAIL",
					txt1 + " text should be verified");
		}
	}
	public void verifyBankDetailsForm() {
		WebElement validate_BankDetailsPage=null;
		String cssSelector=null;
		try{
			validate_BankDetailsPage=HomePage.getInstance().clickToBankDetails(driver);
			cssSelector=validate_BankDetailsPage.getCssValue("background-color");
			System.out.println("1111111111111   : "+cssSelector);
			if(cssSelector.equalsIgnoreCase("rgba(153, 153, 153, 1)")){
											 
				if (GlobalVar.etpStepsReport) {
					DriverSession.getLastExecutionReportingInstance()
							.teststepreporting("<b><i> Bank Details </b></i>" + " Page is successfully verified  ", "PASS",
									"<b><i> Bank Details </b></i>" + " Page text should be verified");
		
				} else {
					DriverSession.getLastExecutionReportingInstance()
					.teststepreporting("<b><i> Bank Details </b></i>" + " Page is not successfully verified  ", "FAIL",
							"<b><i> Bank Details </b></i>" + " Page text should be verified");
		
				}
			}
		}
		catch(Exception we){
			we.getMessage();
		}
	}
	public void panCardBankDetailsPage() {
		WebElement panCard=null;
		String pan_DataSheet=null;
		try{
			panCard=HomePage.getInstance().clickToPanCardDetails(driver);
			pan_DataSheet=GlobalVar.TEST_DATA.get("PanNumber");
			Keywords.clearEditField(panCard);
			Keywords.typeText(panCard, pan_DataSheet);
			
			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting("<b><i> Pan Card Details </b></i>" + " is successfully typed  ", "PASS",
								"<b><i> Pan Card Details </b></i>" + " should successfully typed");
	
			} else {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("<b><i> Pan Card Details </b></i>" + " is not successfully typed  ", "FAIL",
						"<b><i> Pan Card Details </b></i>" + " should successfully typed");
	
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}
	public void nameOnPanCardField() {
		WebElement name_ONPanCard=null;
		String p_Name=null;
		try{
			name_ONPanCard=HomePage.getInstance().ClickToNameOnPan(driver);
			p_Name=GlobalVar.TEST_DATA.get("PanName");
			Keywords.clearEditField(name_ONPanCard);
			Keywords.typeText(name_ONPanCard, p_Name);
			
			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting("<b><i> name on PAN card </b></i>" + " is successfully verified and typed  ", "PASS",
								"<b><i> name on PAN card </b></i>" + " should successfully typed");
	
			} else {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("<b><i> Pan Card Details </b></i>" + " is not successfully typed  ", "FAIL",
						"<b><i> Pan Card Details </b></i>" + " should successfully typed");
	
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public void dobOnPanCard() {
		WebElement dob=null;
		String dob_DataSheet=null;
		try{
			dob=HomePage.getInstance().clickToDOB(driver);
			dob_DataSheet=GlobalVar.TEST_DATA.get("PanDOB");
			Keywords.clearEditField(dob);
			Keywords.typeText(dob, dob_DataSheet);
			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting("<b><i> "+dob_DataSheet+" </b></i>" + " is successfully verified and typed  ", "PASS",
								"<b><i> "+dob_DataSheet+" </b></i>" + " should successfully typed");
	
			} else {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("<b><i> "+dob_DataSheet+" </b></i>" + " is not successfully typed  ", "FAIL",
						"<b><i> "+dob_DataSheet+" </b></i>" + " should successfully typed");
	
			}
		}catch(Exception e){
			e.getMessage();
		}
		
	}
	public void annualTurnOverField() {
		WebElement annualTurnOver=null;
		String val=null;
		try{
			annualTurnOver=HomePage.getInstance().clickToAnnualT_Over(driver);
			val = GlobalVar.TEST_DATA.get("Annual TurnOver");
			Select st = new Select(annualTurnOver);
			st.selectByVisibleText(val);
			
			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting(val + " Annual TurnOver selected successfully", "PASS",
								val + " Annual TurnOver should be selected");
	
			} else {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting(val + " Annual TurnOver not selected", "FAIL",
								val + " Annual TurnOver should be selected");
	
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public void descriptionField() {
		WebElement description=null;
		String val=null;
		try{
			description=HomePage.getInstance().clickToDesc(driver);
			val = GlobalVar.TEST_DATA.get("Describes You");
			Select st = new Select(description);
			st.selectByVisibleText(val);
			
			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting(val + " What best describes you selected successfully", "PASS",
								val + " What best describes you should be selected");
	
			} else {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting(val + " What best describes you not selected", "FAIL",
								val + " What best describes you should be selected");
	
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}
	public void fillVATRegistrationNumber() {
		WebElement vatNumber=null;
		try{
			vatNumber=HomePage.getInstance().getVatNumber(driver);
			Keywords.clearEditField(vatNumber);
			Keywords.typeText(vatNumber, "0123456789");
			
		}
		catch(Exception e){
			e.getMessage();
		}
	}
}




package utilities;

import io.appium.java_client.AppiumDriver;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.concurrent.TimeUnit;

import org.eclipse.jdt.core.compiler.InvalidInputException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import action.AppAction;

import pageWiseOR.androidApp.HomePage;
import pageWiseOR.androidApp.PaymentMethod;
import session.DriverSession;


public class Keywords {

	public static WebDriver driver;
	public static AppiumDriver a_Driver;
	//private static Logger logger = Logger.getLogger(Keywords.class.getName());
	long strt_time, end_time, totalTime;
 
	static AppAction action=new AppAction(DriverSession.getLastExecutionDriver());
	public Keywords(){}
	static{
		Keywords.driver=DriverSession.getLastExecutionDriver();
	}
	public Keywords(AppiumDriver A_driver){
		try{
			a_Driver=A_driver;
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//	public void clickAction(WebElement element, String objectName)
//			throws IOException {
//		try {
//
//			element.click();
//
//		} catch (org.openqa.selenium.TimeoutException ex) {
//			// if click is perform more than 15 sec
//			logger.finer("clickAction: org.openqa.selenium.TimeoutException ");
//		} catch (Exception e) {
//			e.printStackTrace();
//			end_time = Calendar.getInstance().getTimeInMillis();
//			totalTime = end_time - strt_time;
//		}
//	}

	public static void isCouponApplied(WebElement element) {

		String couponText;
		try {
			couponText = element.getText();
			if (couponText.contains("Successfully applied Coupon Code")) {
				GlobalVar.etpStepsReport = true;
			} else {

				GlobalVar.etpStepsReport = false;
			}
		} catch (Exception ee) {
			GlobalVar.etpStepsReport = false;
		}
	}
	
	
	
	public static void clearEditField(WebElement element) {
		try {
			element.clear();
			GlobalVar.etpStepsReport = true;
		} catch (Exception ee) {

			GlobalVar.etpStepsReport = false;
		}
	}

	public static void validateElementExistOrNot(WebElement element){
		try{
			element.isDisplayed();
			GlobalVar.etpStepsReport = true;
		}catch (Exception e) {
			GlobalVar.etpStepsReport = false;
			e.printStackTrace();
		}
	}
	// public boolean isElementExist(WebElement element) throws IOException {
	// try {
	// strt_time = Calendar.getInstance().getTimeInMillis();
	// waitForPageLoad();
	// element.isEnabled();
	// end_time = Calendar.getInstance().getTimeInMillis();
	// totalTime = end_time - strt_time;
	// return true;
	// } catch (Exception e) {
	// e.printStackTrace();
	// end_time = Calendar.getInstance().getTimeInMillis();
	// totalTime = end_time - strt_time;
	// return false;
	// }
	//
	// }

	// public static void waitForPageLoad() throws InterruptedException {
	// logger.finer("Waiting for page load...");
	//
	// driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
	// while (!checkPageReadyState()) {
	// Thread.sleep(2000);// we need to wait for this much
	// }

	// }

	public static void waitForPageLoad(WebDriver driver) {
		driver.manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
	}

	public static void waitForPage(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
	}

	public static void keyBoardEvent(int eventNumber,String Environment) {
		try {
		if(Environment.equalsIgnoreCase("windows")){
			Thread.sleep(1000);
			Runtime.getRuntime().exec(
					"cmd /C adb shell input keyevent " + eventNumber);	
			Thread.sleep(3000);
		}
		
		else if(Environment.equalsIgnoreCase("Linux")){
			
		Process process = Runtime.getRuntime().exec(new String[] {"/usr/bin/adb", "shell input keyevent "+eventNumber});
		}
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}

	


	public static double getCurrentPriceFromBSESite(WebDriver driver) {

		String currentPrice = "";
		try {

			String currentUrl = driver.getCurrentUrl();
			driver.navigate().to(GlobalVar.TEST_DATA.get("CompanyUrl"));
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			currentPrice = driver.findElement(By.className("tbmainred"))
					.getText().trim();
			driver.navigate().to(currentUrl);
			//System.out.println("value is " + currentPrice);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		} catch (Exception ee) {
			ee.printStackTrace();
		}
		return Double.parseDouble(currentPrice.replace(",", ""));
	}

	public static double addOnePercentInValue(double value) {
		value = value + ((value * 1) / 100);
		return value;
	}

	public static double subtractOnePersentInValue(double value) {

		value = value - ((value * 1) / 100);
		return value;
	}

	public static void explicitWait(int timeInSec) {
		try {
			Thread.sleep(1000 * timeInSec);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
	public static void clickByText(List<WebElement> elements, String text) {
		try {
			for (WebElement elemnt : elements) {
				if (elemnt.getText().equalsIgnoreCase(text)) {
					elemnt.click();
					GlobalVar.etpStepsReport = true;
					break;
				}
			}
		}

		catch (Exception ee) {
			GlobalVar.etpStepsReport = false;
		}

	}
	
	public static void clickByPartialText(List<WebElement> elements, String text) {
		try {
			for (WebElement elemnt : elements) {
				if (elemnt.getText().toLowerCase().contains(text)) {
					elemnt.click();
					GlobalVar.etpStepsReport = true;
					break;
				}
			}
		}

		catch (Exception ee) {
			GlobalVar.etpStepsReport = false;
		}

	}

	
	public static void click(WebElement element) {
		try {
			element.click();
			GlobalVar.etpStepsReport = true;
		}

		catch (Exception ee) {
			GlobalVar.etpStepsReport = false;
		}
	}

	public static void typeText(WebElement elemet, String text) {
		try {
			elemet.sendKeys(text);
			GlobalVar.etpStepsReport = true;

		} catch (Exception ee) {
			GlobalVar.etpStepsReport = false;
			ee.printStackTrace();
		}
	}

	public static void typeTextByIndex(List<WebElement> elements,int index,String text)
	{
		try {
			int i = 0;

			for (WebElement element : elements) {
				if (i == index) {
					element.sendKeys(text);
					GlobalVar.etpStepsReport = true;
					break;
				}
				i++;
			}
		}
			catch(Exception ee)
			{
				}
	}		
	
	public static Properties loadPropertiesOfNiftyAndSensex() {

		InputStream input = null;
		Properties prop = null;
		String filePath = "";
		try {
			filePath = GlobalVar.CURRENT_PROJECT_PATH + "\\"
					+ "sensexAndNiftyValues.properties";
			prop = new Properties();
			input = new FileInputStream(new File(filePath));
			prop.load(input);

		} catch (Exception ee) {
			ee.printStackTrace();
		}
		return prop;

	}

	public static double getNiftyValueFromSite() {
		Properties p = null;
		double currentNiftyPrice = 0;
		try {
			p = loadPropertiesOfNiftyAndSensex();
			currentNiftyPrice = Double.parseDouble(p
					.getProperty("currentNiftPrice"));
		} catch (Exception ee) {

		}
		return currentNiftyPrice;
	}

	public static double getSensexValueFromSite() {

		Properties p = null;
		double currentSensexPrice = 0;
		try {
			p = loadPropertiesOfNiftyAndSensex();
			currentSensexPrice = Double.parseDouble(p
					.getProperty("currentSensexPrice"));
		} catch (Exception ee) {

		}
		return currentSensexPrice;
	}

	

	public static String getTextByIndex(List<WebElement> elements, int index) {
		// TODO Auto-generated method stub

		String text = "";
		try {
			int i = 0;

			for (WebElement element : elements) {
				if (i == index) {
					text = element.getText();
					GlobalVar.etpStepsReport = true;
					break;
				}
				i++;
			}

		} catch (Exception ee) {
			GlobalVar.etpStepsReport = false;
		}
		return text;
	}

	public boolean isProcessRunging(String serviceName) {
		try {
			Process p = Runtime.getRuntime().exec("TASKLIST");
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					p.getInputStream()));
			String line;
			while ((line = reader.readLine()) != null) {
				if (line.contains(serviceName)) {
					return true;
				}
			}
		} catch (Exception e) {

		}
		return false;
	}

//	public static void swipeVertically(int ScreenHightValue) {
//		try {
//			
//			Dimension screenSize = DriverSession.getLastExecutionDriver()
//					.manage().window().getSize();
//			Double screenWidth = Double.valueOf(String.valueOf(screenSize
//					.getWidth())) / 2;
//			Double screenHight = Double.valueOf(String.valueOf(screenSize
//					.getHeight())) / 2;
//			JavascriptExecutor js = (JavascriptExecutor) DriverSession
//					.getLastExecutionDriver();
//
//			HashMap<String, Object> swipeObject = new HashMap<String, Object>();
//			
//			swipeObject.put("startX", screenWidth);
//			swipeObject.put("startY", screenHight + ScreenHightValue);
//			swipeObject.put("endX", screenWidth);
//			swipeObject.put("endY", screenHight);
//			swipeObject.put("duration", 1.8);
//			js.executeScript("mobile: swipe", swipeObject);
//
//		} catch (Exception ex) {
//
//			ex.printStackTrace();
//
//		}
//
//	}
	
	
		public static void swipeVertically(int swipeValue) {
		
		try {
			Double swipeHight =0.0;
			swipeHight = (double) swipeValue;
			Dimension screenSize = DriverSession.getLastExecutionDriver().manage().window().getSize();
			Double screenWidth = Double.valueOf(String.valueOf(screenSize
					.getWidth())) / 2;
			Double screenHight = Double.valueOf(String.valueOf(screenSize
					.getHeight())) / 2;
			
			if(screenHight + swipeValue > screenHight*2 || swipeValue == 0){
				swipeHight = screenHight/2;
				
			}
			
			JavascriptExecutor js = (JavascriptExecutor) DriverSession
			.getLastExecutionDriver();
			HashMap<String, Object> swipeObject = new HashMap<String, Object>();
			swipeObject.put("startX", screenWidth);
			swipeObject.put("startY", screenHight + swipeHight);
			swipeObject.put("endX", screenWidth);
			swipeObject.put("endY", screenHight);
			swipeObject.put("duration", 1.8);
			js.executeScript("mobile: swipe", swipeObject);
			
		} catch (Exception ex) {
			
			ex.printStackTrace();
			
		}

	}

	public static void swipeMultipleIteration(int iteration) {
		int i = 0;
		try {
			while (i < iteration) {
				// //System.out.println(element.getText());
				// if(element.getText().equals(text))
				// break;
				swipeVertically(300);
				i++;
				// elements=ViewPortFolioPage.getInstance().listCreatedPortFolios(DriverSession.getLastExecutionDriver());
			}

		}

		catch (Exception e) {
			GlobalVar.etpStepsReport = false;
		}

	}

	public static String getText(WebElement elemet) {
		String textVal = "";
		try {
			textVal = elemet.getText();
			GlobalVar.etpStepsReport = true;

		} catch (Exception ee) {
			GlobalVar.etpStepsReport = false;
		}
		return textVal;
	}

	public static void isElementPresent(WebElement elemet) {
		boolean flag = false;
		try {
			flag = elemet.isDisplayed();
			GlobalVar.etpStepsReport = flag;

		} catch (Exception ee) {
			GlobalVar.etpStepsReport = flag;
		}

	}

	public static String getAttributeVal(WebElement elemet, String text) {
		String textVal = "";
		try {
			textVal = elemet.getAttribute(text);
			GlobalVar.etpStepsReport = true;

		} catch (Exception ee) {
			GlobalVar.etpStepsReport = false;
		}
		return textVal;
	}

	public static void refreshBrowser() {
		DriverSession.getLastExecutionDriver().navigate().refresh();
	}

	public static String getTextByText(List<WebElement> elements, String text) {
		String value = "";
		try {
			for (WebElement element : elements) {
			
				if (element.getText().equals(text)) {
					value = element.getText();
					GlobalVar.etpStepsReport = true;
					return value;
				}

			}
			GlobalVar.etpStepsReport = false;
		}

		catch (Exception e) {
			GlobalVar.etpStepsReport = false;
		}
		return text;
	}

	@SuppressWarnings("deprecation")
	public static void typeTextInEditBox(String element, String text) {
		try {
			GlobalVar.selenium.type(element, text);
			GlobalVar.etpStepsReport = true;
		} catch (Exception e) {

			GlobalVar.etpStepsReport = false;
		}
	}

	public static void verifyValues(double v1, double v2) {
		try {
			v1 = Math.round(v1);
			v2 = Math.round(v2);
			if (v1 == v2) {
				GlobalVar.etpStepsReport = true;
			}

			else {
				GlobalVar.etpStepsReport = false;
			}
		}

		catch (Exception ee) {
			GlobalVar.etpStepsReport = false;
		}
	}

	public static void selectText(WebElement element, String text) {
		try {
			new Select(element).selectByVisibleText(text);
			GlobalVar.etpStepsReport = true;
		} catch (Exception ee) {
			GlobalVar.etpStepsReport = false;
		}
	}

	public void javaScriptExecuter() {
		((JavascriptExecutor) driver)
				.executeScript("document.getElementByClass('ui-datepicker-month').value = '3';");
		;
		((JavascriptExecutor) driver)
				.executeScript("document.getElementByClass('datepicker-year').value = '1998';");
		((JavascriptExecutor) driver)
				.executeScript("document.getElementByClass('ui-datepicker-current-day').value = '1998';");
		((JavascriptExecutor) driver)
				.executeScript("document.getElementsById('transactionDate').removeAttribute('readonly');");

	}

	public static double getTextFromPage(List<WebElement> elements) {
		String text = "";
		double currentAmount = 0;
		try {
			for (WebElement element : elements) {
				text = element.getText();
				//System.out.println("getTextFromPage" + text);
				if (text.equalsIgnoreCase("Current Value")
						|| text.equalsIgnoreCase("Today's Change"))
					continue;
				
				if (text.contains("K")) {
					text = text.substring(0, text.length() - 1);
				} 
				else {
					//System.out.println("R u mad ?");
				}
				currentAmount += Double.parseDouble(text);
			}
			//System.out.println("currentAmount " + currentAmount);
			GlobalVar.etpStepsReport = true;
		} catch (Exception ee) {
			GlobalVar.etpStepsReport = false;
		}
		return currentAmount;
	}

	public static String changeDateFormate(String oldDate) {
		String newDate = "";

		try {
			final String OLD_FORMAT = "dd/MM/yyyy";
			final String NEW_FORMAT = "dd-MM-yyyy";
			SimpleDateFormat sdf = new SimpleDateFormat(OLD_FORMAT);
			Date d = sdf.parse(oldDate);
			sdf.applyPattern(NEW_FORMAT);
			newDate = sdf.format(d);
			//System.out.println(newDate);

		} catch (ParseException e) {
			e.printStackTrace();

		}
		return newDate;
	}

	public static void isColorRed(WebElement element) {

		String color;
		try {
			color = element.getAttribute("class");
			if (color.contains("red")) {
				GlobalVar.etpStepsReport = true;
			} else {

				GlobalVar.etpStepsReport = false;
			}
		} catch (Exception ee) {
			GlobalVar.etpStepsReport = false;
		}
	}

	public static void waitForObject(WebElement element) {
		WebDriverWait wait = new WebDriverWait(
				DriverSession.getLastExecutionDriver(), 90);
		wait.until(ExpectedConditions.visibilityOf(element));

	}

	
	  public static void fetchTableMFRowValues(WebDriver driver,String expectedCompanyName,String tableObject)
      {
      	 int counter=9;
      	TableHeaders t[]=TableHeaders.values();
      	HashMap<TableHeaders, String> tableRowValues=new HashMap<TableHeaders, String>();
      	int row;
      	String CompanyName="";
      	
      	try
      	{
      	   row=driver.findElements(By.xpath(tableObject)).size();
      	   for(int i=1;i<=row;i++)   
      	   {
      		   String xpath1=tableObject+"["+i+"]/td[1]";
      		  CompanyName=driver.findElement(By.xpath(xpath1)).getText();
      		if(CompanyName.contains(expectedCompanyName))
      		{
      	      for(int j=1;j<=9;j++)
      	      {
      	    	       	    
      	    	  String text=driver.findElement(By.xpath(tableObject+"["+i+"]/td["+j+"]")).getText();
      	    	  //System.out.println("value is ......"+text);
      	    	  tableRowValues.put(t[counter],text);
      	    	  counter++;
      	    	 
      	      }
      	   }
      	   }
      	 //GlobalVar.MFtableRowdData=tableRowValues;;
      	}
      	catch(Exception ee)
      	{
      		}
      	}

	  
	
	public static void swipeuntilObjectNotFound(int iterator) {
		try
		{
			for(int i=0;i<iterator;i++)
			  swipeVertically(300);
		}
		catch(Exception ee)
		{
			
		}
		
	}

	public static void clickByIndex(List<WebElement> elements, int index) {
	
		int idx=0;
		try
		{
			for(WebElement elem:elements)
			{
				if(idx==index)
				{
					elem.click();
					GlobalVar.etpStepsReport=true;
					break;
				}
				idx++;
			}
			
		}
		catch(Exception ee)
		{
			GlobalVar.etpStepsReport=false;
		}
		
		
	}
	public static String getCssValue(WebElement element,String attributeName){
		String value="";
		try{
			value=element.getCssValue(attributeName);
			GlobalVar.etpStepsReport=true;
		}catch(Exception e){
			GlobalVar.etpStepsReport=false;
		}
		return value;
		
	}
	
	 public static List <String> validatCredentials(WebElement ph_No,
				WebElement city_State, WebElement pin) {
			// TODO Auto-generated method stub
			List <String>al =new ArrayList<String>();
			try{
				
				al.add(ph_No.getText());al.add(city_State.getText());al.add(pin.getText());
			}
			catch(Exception e){
				e.printStackTrace();
			}
			return al;
		}
	 
	 
	 public static float floatParser(WebElement element){
			String elements="";
			float value=0.0f;
			GlobalVar.etpStepsReport = false;
			try{
				elements=element.getText();
				value=Float.parseFloat(elements);
				GlobalVar.etpStepsReport = true;
			}
			catch(Exception e){
				GlobalVar.etpStepsReport = false;
				e.printStackTrace();
			}
			return value;
		}
	 
	 public static int integerParser(WebElement element){
			String elements="";
			int value=0;
			GlobalVar.etpStepsReport = false;
			try{
				elements=element.getText();
				value=Integer.parseInt(elements);
				GlobalVar.etpStepsReport = true;
			}
			catch(Exception e){
				GlobalVar.etpStepsReport = false;
				e.printStackTrace();
			}
			return value;
		}
	 // This method calculates total qty rate inside Shopping cart
		public static float verifyShoppingCartPageDetails(WebElement Quantity,WebElement rate)
		{
			int qty=0;
			float amt=0.0f;
			float total=0;
			GlobalVar.etpStepsReport = false;
			try{
				String qty1=Quantity.getText();
				String amt1=rate.getText();
				
				qty=Integer.parseInt(qty1);
				amt=Float.parseFloat(amt1);
				total=qty*amt;
				GlobalVar.etpStepsReport = true;
			}
			catch(Exception e){
				GlobalVar.etpStepsReport = false;
				e.printStackTrace();
			}
			return total;
		}
		
		 public static int expectedCalculation(String first,String middle)
			{
				int val1=0;
				int val2=0;
				int val3=0;
				int total=0;
				try{
					val1=Integer.parseInt(first);
					val2=Integer.parseInt(middle);
					total=val1+val2;
					GlobalVar.etpStepsReport = true;
				}
				catch(Exception e){
					GlobalVar.etpStepsReport = false;
					e.printStackTrace();
				}
				return total;
				
			}
		 
		 public static int getCartValue(WebElement element)
			{
				int cartValue=0;
				try{
				String value=element.getText();
				cartValue=Integer.valueOf(value);
				GlobalVar.etpStepsReport = true;
				
				}catch(Exception e){
					GlobalVar.etpStepsReport = false;
					e.printStackTrace();
				}
				return cartValue;
			}
		 
		 public static String verifyTextfromDropDown(WebElement element,String textName)
			{
				String textDropDownField="";
				GlobalVar.etpStepsReport=false;
				try{
					textDropDownField=element.getText();
					if(textDropDownField.equalsIgnoreCase(textName))
					{
						GlobalVar.etpStepsReport=true;
					}
				}catch(Exception e){
					GlobalVar.etpStepsReport=false;
				}
				return textDropDownField;
			}
		 
			public static String getRandomizedString(String fName,String lName,String domain){
				int a=0;
				String result=null;
				GlobalVar.etpStepsReport=false;
				
				try{
					a=(int)(Math.random()*1000);
					result=fName+""+lName+""+(Long.toHexString(System.currentTimeMillis()))+domain;
					GlobalVar.etpStepsReport=true;
				}
				catch(Exception e){
					GlobalVar.etpStepsReport=false;
					e.printStackTrace();
				}
				return result;
			}
		 
			public static void verifyTextOnPage(String text) {
				boolean textFound = false;
				try {
					textFound = driver.getPageSource().contains(text);

					if (textFound) 
					{
						DriverSession.getLastExecutionReportingInstance().teststepreporting(text + "  Text verified.", "PASS","Text should be verified.");
					} 
					else 
					{
						DriverSession.getLastExecutionReportingInstance().teststepreporting(text + "  Text not verified.","FAIL", "Text should not  be verified.");
					}
				} 
				catch (Exception e) 
				{
					DriverSession.getLastExecutionReportingInstance().teststepreporting(text + "  Text not verified.", "PASS","Text should not be verified.");
				}
			}
			
			public static void validateSingleElementWithMultiple(List<WebElement>element,String option){
				try{
					GlobalVar.etpStepsReport=false;
					for(WebElement element2 : element){
						if(element2.getText().equalsIgnoreCase(option)){
							GlobalVar.etpStepsReport=true;
							break;
						}
						else{
							GlobalVar.etpStepsReport=false;
						}
					}
				}
				catch(Exception e){
					e.printStackTrace();
				}
				
			}
			
			
			public static String getRandomData(){
				String result=null;
				GlobalVar.etpStepsReport=false;
				
				try{
					result=""+System.currentTimeMillis();
					GlobalVar.etpStepsReport=true;
				}
				catch(Exception e){
					GlobalVar.etpStepsReport=false;
					e.printStackTrace();
				}
				return result;
			}
			
			public static void setChangePasswordProperties(String randomPassword){
				try{
					Properties prop = new Properties();
					OutputStream output = null;
					try {
						output = new FileOutputStream(GlobalVar.PROJECT_ROOT_PATH+"Regression Suite - crestech/ShopcluesMobileAutomation/TestRepository/ChangePassword.properties");
						prop.setProperty("New_Password", randomPassword);
						prop.store(output, null);
				 
					} catch (IOException io) {
						io.printStackTrace();
					} finally {
						if (output != null) {
							try {
								output.close();
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
				 
					}
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
			public static String getChangePasswordProperties(String value){
				FileInputStream fileInput=null;
				Properties prop=new Properties();
				try{
					File file = new File(GlobalVar.PROJECT_ROOT_PATH+"Regression Suite - crestech/ShopcluesMobileAutomation/TestRepository/ChangePassword.properties");
					fileInput=new FileInputStream(file);
					
					try{
						prop.load(fileInput);
					}catch(Exception e){
						e.printStackTrace();
					}
					
				}
				catch(Exception e){
					e.printStackTrace();
				}
				return(prop.getProperty(value));
			}
			
			public static ArrayList<String> verifyMultipleClickableObjects(List<WebElement>element){
				ArrayList<String> al=new ArrayList<String>();
				try{
					GlobalVar.etpStepsReport=false;
					for(WebElement elements : element){
						if(elements.isDisplayed()){
							GlobalVar.etpStepsReport=true;
							al.add(elements.getText());
						}
						else{
							GlobalVar.etpStepsReport=false;
						}
					}
				}catch(Exception e){
					e.printStackTrace();
				}
				return al;
			}
			public static String verifyMultipleIsEnabledObjects(List<WebElement> element){
				String object_Name=null;
				try{
					GlobalVar.etpStepsReport=false;
					//System.out.println(element.size());
					for(WebElement elements : element){
						if(elements.getAttribute("checked").equalsIgnoreCase("true")){
							
							GlobalVar.etpStepsReport=true;
							object_Name=elements.getText();
							break;
						}
						else{
							GlobalVar.etpStepsReport=false;
						}
					}
				}
				catch(Exception e){
					e.printStackTrace();
				}
				return object_Name;
			}

			public static List<String> splitRowDataWithPipeOperator(String dataSheet){
				List<String> al=new ArrayList<String>();
				try{
					StringTokenizer split_Data=new StringTokenizer(dataSheet, GlobalVar.tokenType);
					while(split_Data.hasMoreTokens()){
						al.add(split_Data.nextToken());
					}
				}
				catch(Exception e){
					e.printStackTrace();
				}
				return al;
			}
			
			
			
			public static void validateAndFetchRadioButtonValue(List<WebElement> payment_RaddioButtons,
					String pmtTextFieldValue,String payment_Options){
				
				GlobalVar.etpStepsReport=false;
				int count=0;
				String actual=null;
				List <String> options=new ArrayList<String>();
				List<String>option2=new ArrayList<String>();
				try{
					GlobalVar.etpStepsReport=true;
					options=Keywords.splitRowDataWithPipeOperator(payment_Options);
					option2=Keywords.splitRowDataWithPipeOperator(pmtTextFieldValue);
					
					for(WebElement paymentOption : payment_RaddioButtons){
						for(int i=count;i<options.size();i++){
								if(paymentOption.getText().equalsIgnoreCase(options.get(i))){
									GlobalVar.etpStepsReport=true;
									
									paymentOption.click();
									
									count++;
									try{
										actual=PaymentMethod.getInstance().getStringFromTextField(driver);
										
									if(actual.equalsIgnoreCase(option2.get(i)));{
										GlobalVar.etpStepsReport=true;
										
										DriverSession.getLastExecutionReportingInstance()
										 .teststepreporting("<u>PaymentMethod Page : </u><br> By clicking to <b>"+paymentOption.getText()+"</b> value is  <b><i> "+actual+"</b><br>options is successfully validated ", "PASS",
												"<u>PaymentMethod Page : </u><br> clicking to <b>"+paymentOption.getText()+"</b> - <b><i> "+actual+" </b><br>options should be successfully validated Clicked");
									}
										break;
									}catch(Exception oo){
										DriverSession.getLastExecutionReportingInstance()
										 .teststepreporting("<u>PaymentMethod Page : </u><br> By clicking to <b> "+paymentOption.getText()+" </b>no option in text field is visible successfully validated ", "PASS",
												"<u>PaymentMethod Page : </u><br> By clicking to <b> Cash on Delivery </b>no option in text field should be successfully validated Clicked");
									}
								}else{
									DriverSession.getLastExecutionReportingInstance()
									 .teststepreporting("<u>PaymentMethod Page : </u><br> By clicking to <b>"+paymentOption.getText()+" </b>value is <b><i> "+actual+" </b><br>options is not successfully validated ", "FAIL",
											"<u>PaymentMethod Page : </u><br> clicking to <b>"+paymentOption.getText()+"</b> - <b><i> "+actual+" </b><br>options should be successfully validated Clicked");
									continue;
									
								}}
							}
				}
				catch(Exception e){
					GlobalVar.etpStepsReport=false;
				}
			}
			
			/** ***************************************************************************************
			 * Keyword-Name:    dynamicwait
			 * Usage:           void dynamicwait(WebDriver driver,Integer time, WebElement element)
			 * Description:     wait for given object for given time
			 * Author:          Automators
			 * Dated:           13May2015
			 * Notes:   
			 *************************************************************************************** **/
			public static void dynamicwait(WebDriver driver,Integer time, WebElement element)
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
			
			public static void hideKeyBoard(){
				try{
					a_Driver.hideKeyboard();
				//	driver.navigate().back();
				}catch(Exception e){
					//e.printStackTrace();
				}
			}
			
			public  static  String ltrim(String name){
				String option="";
				String split[]=name.split(" ");
				for(int i=1;i<split.length;i++){
					option=option+" "+split[i];
				}
				return option;
			}
			
			public static void setValueToProperties(String key_Name,String value_Name){
				try{
					Properties prop = new Properties();
					OutputStream output = null;
					try {
						output = new FileOutputStream(GlobalVar.PROJECT_ROOT_PATH+"Regression Suite - crestech/ShopcluesMobileAutomation/TestRepository/MerchantEmailID.properties");
						prop.setProperty(key_Name, value_Name);
						prop.store(output, null);
				 
					} catch (IOException io) {
						io.printStackTrace();
					} finally {
						if (output != null) {
							try {
								output.close();
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
				 
					}
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
			
			
			public static String getValueFromPropertiesFile(String key){
				FileInputStream fileInput=null;
				Properties prop=new Properties();
				try{
					File file = new File(GlobalVar.PROJECT_ROOT_PATH+"Regression Suite - crestech/ShopcluesMobileAutomation/TestRepository/MerchantEmailID.properties");
					fileInput=new FileInputStream(file);
					
					try{
						prop.load(fileInput);
					}catch(Exception e){
						e.printStackTrace();
					}
					
				}
				catch(Exception e){
					e.printStackTrace();
				}
				return(prop.getProperty(key));
			}
			
			public static List<String> convertAlphaNumericToAlphabetical(String name){
				GlobalVar.etpStepsReport=false;
				char array[]=new char[26];
				List<String>list=new ArrayList<String>();
				int flag=0,c=0;
				try{
					char ch[]=name.toCharArray();
					for(int i=0;i<ch.length;i++){
						flag=0;
						for(char j='0';j<='9';j++){
							if(ch[i]==j){
								flag++;
							}
							else{
								continue;
							}
						}if(flag==0){
							array[c]=ch[i];
							c++;
						}
					}
					String str=new String(array);
					list.add(str.trim());
					GlobalVar.etpStepsReport=true;
				}
				catch(Exception e){
					e.printStackTrace();
					GlobalVar.etpStepsReport=false;
				}
				return list;
			}
			
			
			public static void selectByVisibleText(WebElement element,String name){
				GlobalVar.etpStepsReport=false;
				try{
					Select select1 = new Select(element);
					select1.selectByVisibleText(name);
					GlobalVar.etpStepsReport=true;
					
					if(GlobalVar.etpStepsReport){
						DriverSession.getLastExecutionReportingInstance()
						 .teststepreporting("Product : "+element.getText()+" is successfully clicked and "+name+" is selected successfully ", "PASS",
								"Product : "+element.getText()+" should be successfully clicked and "+name+" should be selected successfully ");
					}
					else{
						DriverSession.getLastExecutionReportingInstance()
						 .teststepreporting("Product : "+element.getText()+" is not successfully clicked and "+name+" is not selected successfully ", "FAIL",
								"Product : "+element.getText()+" should be successfully clicked and "+name+" should be selected successfully ");
					}
				}
				catch(Exception e){
					DriverSession.getLastExecutionReportingInstance()
					 .teststepreporting("Product : "+element.getText()+" is not successfully clicked and "+name+" is not selected successfully ", "FAIL",
							"Product : "+element.getText()+" should be successfully clicked and "+name+" should be selected successfully ");
				}
			} 
			
			public static void keyEnter(WebElement element){
				GlobalVar.etpStepsReport=false;
				try{
					element.sendKeys(Keys.TAB);
					element.sendKeys(Keys.RETURN);
					GlobalVar.etpStepsReport=true;
				}
				catch(Exception e){
					GlobalVar.etpStepsReport=false;
					e.printStackTrace();
				}
			}
			
			public static String getTextFromObject(WebElement element){
				String message="";
				GlobalVar.etpStepsReport=false;
				try{
					message=element.getText();
					GlobalVar.etpStepsReport=true;
				}
				catch(Exception e){
					GlobalVar.etpStepsReport=false;
					e.getMessage();
				}
				return message;
			}
			
			public static Map<String,String> getProductDetails(WebDriver driver){
				Map<String,String> map=new LinkedHashMap<String, String>();
				GlobalVar.etpStepsReport=false;
				try{
					while(true){
					map.put(HomePage.getInstance().orderId(driver).getText().replaceAll(":","").trim(), HomePage.getInstance().o_Number(driver).getText().trim());
					map.put(HomePage.getInstance().orderDate(driver).getText().replaceAll(":","").trim(), HomePage.getInstance().o_Date(driver).getText().trim());
					map.put(HomePage.getInstance().amountPaid(driver).getText().replaceAll(":","").trim(), HomePage.getInstance().amt_paid(driver).getText().trim());
					map.put(HomePage.getInstance().status(driver).getText().replaceAll(":","").trim(), HomePage.getInstance().o_Status(driver).getText().trim());
					GlobalVar.etpStepsReport=true;
					break;
					}
				}
				catch(Exception e){
					GlobalVar.etpStepsReport=false;
					e.getMessage();
				}
				return map;
			}



			public static float valueAfterCODCharges(float subTotal,int CODCharges) {
				float total=0.0f;
				GlobalVar.etpStepsReport=false;
				try{
					total=(subTotal+CODCharges);
					GlobalVar.etpStepsReport=true;
				}
				catch(Exception e){
					GlobalVar.etpStepsReport=false;
					e.getMessage();
				}
				return total;
			}
			
			public static boolean getDropDownType(WebElement element,WebDriver driver){
				String listView=HomePage.getInstance().getListViewInstance(driver);
				String gridView=HomePage.getInstance().getGridViewInstance(driver);
				//System.out.println(listView+""+gridView);
				GlobalVar.etpStepsReport=false;
				boolean flag=false;
				try{
						if(element.getAttribute("class").equalsIgnoreCase(listView)){
							flag=true;
							GlobalVar.etpStepsReport=true;
						}
						
						else{
								if(element.getAttribute("class").equalsIgnoreCase(gridView)){
									flag=false;
									GlobalVar.etpStepsReport=true;
							}
						}
				}
				catch(Exception e){
					e.getMessage();
				}
				return flag;
			}
			
			public static String getRoundValue(String value){
				GlobalVar.etpStepsReport=false;
				String actualResult="";
				int exp=0;
				try{
					exp=Math.round(Float.parseFloat(value));
					actualResult=exp+"";
					GlobalVar.etpStepsReport=true;
				}
				catch(NumberFormatException e){
					GlobalVar.etpStepsReport=false;
					e.getMessage();
				}
				return actualResult;
			}
			
			public static void moveToElementClick(WebElement element,WebDriver driver,int value){
				try{
					GlobalVar.etpStepsReport=false;
					switch(value){
					
					case 1:
						Actions action1 = new Actions(driver);
						action1.moveToElement(element).perform();
						GlobalVar.etpStepsReport=true;
						break;
						
					case 2:
						Actions action2 = new Actions(driver);
						action2.moveToElement(element).click();
						GlobalVar.etpStepsReport=true;
						break;
						
					case 3:
						element.click();
						GlobalVar.etpStepsReport=true;
						break;
					
					default:
						GlobalVar.etpStepsReport=false;
						throw new InvalidInputException();
				}
				}
				catch(Exception e){
					GlobalVar.etpStepsReport=false;
					e.getMessage();
				}
			}
			
			public static List<String> getDropDownValue(WebElement element){
				List<String>value=new ArrayList<String>();
				try{
					
					Select st=new Select(element);
					List<WebElement>al=st.getOptions();
					
					for(WebElement option : al){
						value.add(option.getText());
					}
				}
				catch(Exception e){
					e.getMessage();
				}
				return value;
			}
			
			public static void getDefaultDropDownValue(String tabName,WebElement element,WebDriver driver)
			{
				List<String>value=new ArrayList<String>();
				try{
					Select st=new Select(element);
					List<WebElement>al=st.getAllSelectedOptions();
					for(WebElement all : al){
						
						value.add(all.getText());
						if(all.getText()!=null){
							DriverSession.getLastExecutionReportingInstance().
								teststepreporting("<b> "+tabName+" </b> with default Value is <br><b><i>"+all.getText()+"</b></i><br> is selected and validated successfully <br>", "PASS",
										"Search Field should be successfully typed and clicked");
							break;
						}
						else{
							DriverSession.getLastExecutionReportingInstance().
							teststepreporting("<b> "+tabName+" </b> with default Value is <br><b><i>"+all.getText()+"</b></i><br> is not selected and validated successfully <br>", "FAIL",
									"Search Field should be successfully typed and clicked");
							
						}
					}
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}



			public static void clickSelectTypetext(WebElement type,
					String string) {
					GlobalVar.etpStepsReport=false;
					try{
						Select selectByIndex = new Select(type);
						selectByIndex.selectByVisibleText(string);
						GlobalVar.etpStepsReport=true;
					}
					catch(Exception e){
						GlobalVar.etpStepsReport=false;
						e.printStackTrace();
					}
			}



			public static void closeAlertpopup(WebDriver driver2) {
				GlobalVar.etpStepsReport=false;
				try{
					Alert alert = driver.switchTo().alert();
					alert.accept();
					GlobalVar.etpStepsReport=true;
				}
				catch(Exception e){
					GlobalVar.etpStepsReport=false;
					e.printStackTrace();
				}
				
			}



			public static void validatePageContents(WebElement elements,List<String> val) {
				
				GlobalVar.etpStepsReport=false;
				try{
					for(int i=0;i<val.size();i++){
						
						if(elements.getText().contains(val.get(i))){
							
							DriverSession.getLastExecutionReportingInstance().
							teststepreporting("<b><i>"+val.get(i)+"</i></b> is successfully Verified<br>", "PASS",
									"<b><i>"+val.get(i)+"</i></b> should be successfully Verified");
							GlobalVar.etpStepsReport=true;
							
					}else{
						DriverSession.getLastExecutionReportingInstance().
						teststepreporting("<b><i>"+val.get(i)+"</i></b> is not Verified", "FAIL",
								"<b><i>Task</i></b> should be successfully Verified");
						GlobalVar.etpStepsReport=false;
						continue;
					}
					}
				}
				catch(Exception e){
					e.getMessage();
				}
			}
			
			public static boolean isTextPresent(String text){
		        try{
		            boolean b = driver.getPageSource().contains(text);
		            return b;
		        }
		        catch(Exception e){
		            return false;
		        }
			}
			
			/*public static void aswiper(){
				try
				{
				System.out.println("sd");
				a_Driver.swipe(500, 1000, 1000, 1000, 10);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}*/
			
			public static void scrollingToBottomofAPage(WebDriver driver) {
				 ((JavascriptExecutor) driver)
		         .executeScript("window.scrollTo(0, document.body.scrollHeight)");
			}
			
			public  By checkElement(WebDriver driver,By web)
			{
				
				 WebDriverWait wait = new WebDriverWait(driver,3);
				 for(int i=0; i<6;i++)
				 {
				try
				{
				 wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(web));
				 driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS); 
				 return web;
				}
				catch(Exception e)
				{
					 driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS); 
					 a_Driver.swipe(50,500,50,50,100);
				}
				 }
				 driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS); 
				return web;
			}
}
			
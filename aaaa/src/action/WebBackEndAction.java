/*
 ***************************************************************************************************
 * Class-Name:    public class WebBackEndAction
 * Description:   Class defined to handle various reusable actions for ShopClues Web-Site| Back-End
 * including Admin Panel and Vendor Panel
 * where
 *
 * Author:        Automators
 * Dated:         09Apr2015
 * Notes:  
 *
 ***************************************************************************************************
 */

// Package name: action
package action;

//List of import statements to include various java classes
import java.awt.Dimension;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import net.sourceforge.htmlunit.corejs.javascript.tools.shell.Global;

import org.apache.commons.codec.language.bm.Rule;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sun.corba.se.impl.oa.poa.ActiveObjectMap.Key;

import pageWiseOR.BackendWeb.BackEnd1by1Upload;
import pageWiseOR.BackendWeb.BackEndLoginPage;
import pageWiseOR.BackendWeb.BackEndManageProductPage;
import pageWiseOR.BackendWeb.BackendCounterfeitCheckOut;
import pageWiseOR.BackendWeb.BackendOutletSelection;
import pageWiseOR.BackendWeb.HomePage;
import session.DriverSession;
import testCaseReporting.TestCaseReporting;
import utilities.GlobalVar;
import utilities.Keywords;
import utilities.RobotAction;

public class WebBackEndAction {
	private WebDriver driver;
	HashMap<String, String> testData = new HashMap<String, String>();
	TestCaseReporting testCaseReporting = null;

	public WebBackEndAction(WebDriver driver) {
		this.driver = driver;
		this.testData = GlobalVar.TEST_DATA;
	}

	public void openBrowser(String url) {
		try {
			this.driver = GlobalVar.driver;
			this.testData = GlobalVar.TEST_DATA;
			if (!GlobalVar.CURRENT_EXECUTION_MODE.equals("androidWeb"))
			{
				try
				{
					Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
					double width = screenSize.getWidth();
					double height = screenSize.getHeight();
					System.out.println("old"+driver.manage().window().getSize());
					org.openqa.selenium.Dimension dim =new org.openqa.selenium.Dimension((int)width,(int)height);
					driver.manage().window().setSize(dim);
					System.out.println("new"+driver.manage().window().getSize());
				}
				catch (Exception ex)
				{
					System.out.println("old"+driver.manage().window().getSize());
					org.openqa.selenium.Dimension dim =new org.openqa.selenium.Dimension(1024,768);
					driver.manage().window().setSize(dim);
					System.out.println("new"+driver.manage().window().getSize());
				}
			}
			driver.navigate().to(url);
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.MINUTES);

			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Browser opened", "PASS",
					"Browser should be Open");
		} catch (Exception e) {

			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Browser not opened", "FAIL",
					"Browser should be Open");
		}
	}

	public void closeBrowser() {
		// TODO Auto-generated method stub
		try {
			DriverSession.getLastExecutionReportingInstance().footer();
			GlobalVar.driver.quit();
		}

		catch (Exception ee) {

		}

	}

	public void typeUserName() {
		WebElement element = null;
		try {
			element = BackEndLoginPage.getInstance().usernameEditBox(driver);
			Keywords.typeText(element, GlobalVar.TEST_DATA.get("User Name"));
			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting(
						"User name typed succefully. :: "
								+ GlobalVar.TEST_DATA.get("User Name"),
								"PASS", "User name should be entered.");

			} else {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("User name not typed.", "FAIL",
						"User name should be typed.");

			}
		} catch (Exception e) {
			e.printStackTrace();
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Exception occured : ", "FAIL",
					e.toString());
		}
	}

	public void typePassword() {
		WebElement element = null;
		try {
			element = BackEndLoginPage.getInstance().passwordEditbox(driver);
			Keywords.typeText(element, GlobalVar.TEST_DATA.get("Password"));
			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting(
						"Password typed succefully. :: "
								+ GlobalVar.TEST_DATA.get("Password"),
								"PASS", "Password should be entered.");

			} else {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("Password not typed.", "FAIL",
						"Password should be typed.");

			}
		} catch (Exception e) {
			e.printStackTrace();
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Exception occured : ", "FAIL",
					e.toString());
		}
	}

	public void clickOnLoginButton() {
		WebElement element = null;
		try {
			element = BackEndLoginPage.getInstance().submitButton(driver);
			Keywords.click(element);
			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("Clicked on Login Button", "PASS",
						"Should be Clicked on Login Button");

			} else {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("Not clicked On Login Button",
						"FAIL", "Should be Clicked on Login Button");
			}

		} catch (Exception e) {
			e.printStackTrace();
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Not clicked On Login Button", "FAIL",
					"Should be Clicked on Login Button");
		}
	}

	public void verifyValidCredentials() throws Exception {
		WebElement element = null;
		String text = "";
		try {
			element = BackEndLoginPage.getInstance().errorMsg(driver);

			if (element.isDisplayed()) {
				text = Keywords.getText(element);
				if (text.contains("invalid")) {
					DriverSession.getLastExecutionReportingInstance()
					.teststepreporting(text, "FAIL",
							"Should be present error message.");
					GlobalVar.ExitTestCase=true;
					throw new Exception(
							"The username or password you have entered is invalid");
				}

			} else {
				DriverSession
				.getLastExecutionReportingInstance()
				.teststepreporting(
						"The username or password you have entered is valid.",
						"PASS", "Should be provide valid credentials.");
			}
		} catch (Exception e) {
			GlobalVar.ExitTestCase=true;
			throw new Exception(e.getMessage());
		}
	}

	public void verifyWelcomePage() {
		WebElement element = null;
		String text = "";
		try {
			element = BackEndLoginPage.getInstance().userProfile(driver);
			text = Keywords.getText(element);
			if (text.equalsIgnoreCase(GlobalVar.TEST_DATA.get("User Name"))) {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting(
						"Welcome page verified successfully. :: "
								+ text + "=="
								+ GlobalVar.TEST_DATA.get("User Name"),
								"PASS", "Welcome page should be verified.");

			} else {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting(
						"Welcome page not verified " + text + "=="
								+ GlobalVar.TEST_DATA.get("User Name"),
								"FAIL", "Welcome should be verified.");

			}
		} catch (Exception e) {
			e.printStackTrace();
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Exception occured : ", "FAIL",
					e.toString());
		}

	}

	public void clickOnManageProductLink() {
		WebElement element = null;
		try {
			element = BackEndManageProductPage.getInstance()
					.catalogLink(driver);
			Actions act = new Actions(driver);
			Keywords.explicitWait(5);
			act.moveToElement(element).perform();
			element = BackEndManageProductPage.getInstance().manageProductLink(
					driver);
			Keywords.click(element);
			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("Clicked on manage product link",
						"PASS",
						"Should be clicked on manage product link");

			} else {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting(
						"Not clicked On manage product link", "FAIL",
						"Should be clicked on manage product link");
			}

		} catch (Exception e) {
			e.printStackTrace();
			DriverSession
			.getLastExecutionReportingInstance()
			.teststepreporting("Not clicked On manage product link.",
					"FAIL", "Should be Clicked on manage product link.");
		}
	}

	public void typeResultsNameInSearchBox() {
		WebElement element = null;
		try {
			element = BackEndManageProductPage.getInstance()
					.findResultsWithName(driver);
			Keywords.typeText(element, GlobalVar.TEST_DATA.get("Name"));
			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting(
						"Name typed succefully in serachbox. :: "
								+ GlobalVar.TEST_DATA.get("Name"),
								"PASS", "Name should be entered.");

			} else {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("Name not typed.", "FAIL",
						"Name should be typed.");

			}
		} catch (Exception e) {
			e.printStackTrace();
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Exception occured : ", "FAIL",
					e.toString());
		}
	}

	public void typeURL() {
		WebElement element = null;
		try {
			if (!GlobalVar.TEST_DATA.get("URL").equalsIgnoreCase("")) {
				element = BackEndManageProductPage.getInstance().searchWithURL(
						driver);
				Keywords.typeText(element, GlobalVar.TEST_DATA.get("URL"));
				if (GlobalVar.etpStepsReport) {
					DriverSession.getLastExecutionReportingInstance()
					.teststepreporting(
							"URL typed succefully in serachbox. :: "
									+ GlobalVar.TEST_DATA.get("URL"),
									"PASS", "URL should be entered.");

				} else {
					DriverSession.getLastExecutionReportingInstance()
					.teststepreporting("URL not typed.", "FAIL",
							"URL should be typed.");

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Exception occured : ", "FAIL",
					e.toString());
		}
	}

	public void typeCode() {
		WebElement element = null;
		try {
			if (!GlobalVar.TEST_DATA.get("Code").equalsIgnoreCase("")) {
				element = BackEndManageProductPage.getInstance()
						.searchWithCode(driver);
				Keywords.typeText(element, GlobalVar.TEST_DATA.get("Code"));
				if (GlobalVar.etpStepsReport) {
					DriverSession.getLastExecutionReportingInstance()
					.teststepreporting(
							"Code typed succefully in serachbox. :: "
									+ GlobalVar.TEST_DATA.get("Code"),
									"PASS", "Code should be entered.");

				} else {
					DriverSession.getLastExecutionReportingInstance()
					.teststepreporting("Code not typed.", "FAIL",
							"Code should be typed.");

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Exception occured : ", "FAIL",
					e.toString());
		}
	}

	public void selectStatus() {
		WebElement element = null;
		try {
			if (!GlobalVar.TEST_DATA.get("Status").equalsIgnoreCase("")) {
				element = BackEndManageProductPage.getInstance().selectStatus(
						driver);
				Keywords.selectText(element, GlobalVar.TEST_DATA.get("Status"));
				if (GlobalVar.etpStepsReport) {
					DriverSession
					.getLastExecutionReportingInstance()
					.teststepreporting(
							"Status selected succefully in serachbox. :: "
									+ GlobalVar.TEST_DATA.get("Status"),
									"PASS", "Status should be entered.");

				} else {
					DriverSession.getLastExecutionReportingInstance()
					.teststepreporting("Status not typed.", "FAIL",
							"Status should be typed.");

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Exception occured : ", "FAIL",
					e.toString());
		}
	}

	public void selectMerchant() {
		WebElement element = null;
		try {
			if (!GlobalVar.TEST_DATA.get("Merchant DropDown").equalsIgnoreCase(
					"All Merchants")) {
				element = BackEndManageProductPage.getInstance()
						.selectMerchant(driver);
				Keywords.click(element);
				Keywords.explicitWait(2);
				element = BackEndManageProductPage.getInstance()
						.merchantEditBox(driver);
				Keywords.clearEditField(element);
				Keywords.click(element);
				Keywords.typeText(element,
						GlobalVar.TEST_DATA.get("Merchant DropDown"));
				Keywords.explicitWait(2);
				element = BackEndManageProductPage.getInstance()
						.merchantEditBoxLink(driver);
				Keywords.click(element);

				if (GlobalVar.etpStepsReport) {
					DriverSession
					.getLastExecutionReportingInstance()
					.teststepreporting(
							"Given merchant selected successfully. :: "
									+ GlobalVar.TEST_DATA
									.get("Merchant DropDown"),
									"PASS", "Merchant should be selected.");

				} else {
					DriverSession.getLastExecutionReportingInstance()
					.teststepreporting("Merchant not selected.",
							"FAIL", "Merchant should not be selected.");

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Exception occured : ", "FAIL",
					e.toString());
		}
	}

	public void selectCategories() {
		WebElement element = null;
		try {
			if (!GlobalVar.TEST_DATA.get("Category Drop Down")
					.equalsIgnoreCase("All Categories")) {
				element = BackEndManageProductPage.getInstance()
						.selectCategory(driver);
				Keywords.selectText(element,
						GlobalVar.TEST_DATA.get("Category Drop Down"));
				if (GlobalVar.etpStepsReport) {
					DriverSession
					.getLastExecutionReportingInstance()
					.teststepreporting(
							"Status selected succefully in serachbox. :: "
									+ GlobalVar.TEST_DATA
									.get("Category Drop Down"),
									"PASS", "Status should be entered.");

				} else {
					DriverSession.getLastExecutionReportingInstance()
					.teststepreporting("Status not typed.", "FAIL",
							"Status should be typed.");

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Exception occured : ", "FAIL",
					e.toString());
		}
	}

	public void clickOnSearchButton() {
		WebElement element = null;
		try {
			element = BackEndManageProductPage.getInstance().searchButton(
					driver);
			Keywords.click(element);
			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("Clicked on search button", "PASS",
						"Should be clicked on search button");

			} else {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("Not clicked On search button",
						"FAIL", "Should be clicked on search button");
			}

		} catch (Exception e) {
			e.printStackTrace();
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Not clicked On search button.", "FAIL",
					"Should be clicked on search button.");
		}
	}

	public void verifyCheckAllCheckBox() {
		WebElement element = null;
		try {
			element = BackEndManageProductPage.getInstance().checkAllCheckBox(
					driver);
			Keywords.isElementPresent(element);
			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting(
						"Check All checkbox checkbox present", "PASS",
						"Should be present check all checkbox.");

			} else {
				DriverSession
				.getLastExecutionReportingInstance()
				.teststepreporting("Not present check all checkbox.",
						"FAIL", "Should be present check all checkbox.");
			}

		} catch (Exception e) {
			e.printStackTrace();
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Exception occured : " + e.toString(),
					"FAIL", "Should be present check all checkbox.");
		}
	}

	public void verifySearchStringinTable() {

		int rows = 0;
		String object = "";
		String objectNew = "";
		String tableColVal = "";
		try {
			object = BackEndManageProductPage.getInstance()
					.listingTableObject();
			rows = driver.findElements(By.xpath(object)).size();
			for (int i = 3; i < rows; i++) {
				objectNew = object + "[2]/td[" + i + "]/div/a";
				tableColVal = driver.findElement(By.xpath(objectNew)).getText();
				if (tableColVal.contains(GlobalVar.TEST_DATA.get("Name"))) {
					GlobalVar.etpStepsReport = true;
					break;
				}
			}

			if (GlobalVar.etpStepsReport) {
				DriverSession
				.getLastExecutionReportingInstance()
				.teststepreporting(
						"Search string matched with table data.",
						"PASS",
						"Should be matched search string with table data.");

			} else {
				DriverSession
				.getLastExecutionReportingInstance()
				.teststepreporting(
						"Not matched search string  with table data.",
						"FAIL",
						"Should not be matched search string with table data.");
			}

		} catch (Exception e) {
			e.printStackTrace();
			DriverSession
			.getLastExecutionReportingInstance()
			.teststepreporting("Exception occured : " + e.toString(),
					"FAIL",
					"Should not be matched search string with table data.");
		}
	}

	public void verifyMerchantDropDown() {
		WebElement element = null;
		try {
			element = BackEndManageProductPage.getInstance().selectMerchant(
					driver);
			String val = Keywords.getText(element);

			if (val.contains(GlobalVar.TEST_DATA.get("Merchant DropDown"))) {
				DriverSession
				.getLastExecutionReportingInstance()
				.teststepreporting(
						"Merchant dropdown verified."
								+ val
								+ "::"
								+ GlobalVar.TEST_DATA
								.get("Merchant DropDown"),
								"PASS", "Should be verified merchant.");

			} else {
				DriverSession
				.getLastExecutionReportingInstance()
				.teststepreporting("Not verified merchant dropdown.",
						"FAIL", "Should be verified merchant dropdown.");
			}

		} catch (Exception e) {
			e.printStackTrace();
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Exception occured : " + e.toString(),
					"FAIL", "Should be verified merchant dropdown.");
		}
	}

	public void selectStatusDropdownValue() {
		WebElement element = null;
		String Code;
		try {
			element = BackEndManageProductPage.getInstance().NameHeader(driver);

			Keywords.explicitWait(10);
			element = BackEndManageProductPage.getInstance()
					.FirstRowShopCluesCode_EditBox(driver);

			Keywords.click(element);
			Code = Keywords.getAttributeVal(element, "value");
			//System.out.println("ShopClues Code   " + Code);
			element = BackEndManageProductPage.getInstance()
					.FirstStatusDropDown(driver, Code);
			Keywords.click(element);
			Keywords.explicitWait(1);
			element = BackEndManageProductPage.getInstance()
					.FirstStatusDropDownValues(driver, Code, 3);
			Keywords.click(element);
			Keywords.explicitWait(5);
			element = BackEndManageProductPage.getInstance()
					.FirstStatusDropDown(driver, Code);
			Keywords.click(element);
			Keywords.explicitWait(1);
			element = BackEndManageProductPage.getInstance()
					.FirstStatusDropDownValues(driver, Code, 1);
			Keywords.click(element);

			if (GlobalVar.etpStepsReport) {
				DriverSession
				.getLastExecutionReportingInstance()
				.teststepreporting("﻿DropDown value is selected",
						"PASS", "Should be selected on status dropdown");

			} else {
				DriverSession
				.getLastExecutionReportingInstance()
				.teststepreporting("DropDown value is not selected",
						"FAIL", "Should be selected on status dropdown");
			}

		} catch (Exception e) {
			e.printStackTrace();
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting(
					"DropDown value is not selected exception", "FAIL",
					"Should be selected on status dropdown");
		}
	}

	public void VerifyStatusDropDownInProductTable() {
		WebElement element = null;
		String Code;
		Integer count, i;
		try {
			element = BackEndManageProductPage.getInstance().NameHeader(driver);

			count = BackEndManageProductPage.getInstance()
					.CountProductTableSize(driver);
			//System.out.println(count);
			for (i = 2; i <= count; i++) {
				element = BackEndManageProductPage.getInstance()
						.ShopCluesCodeByRow_EditBox(driver, i);
				Keywords.click(element);
				Code = Keywords.getAttributeVal(element, "value");
				//System.out.println("ShopClues Code   " + Code);
				element = BackEndManageProductPage.getInstance()
						.FirstStatusDropDown(driver, Code);
			}

			if (GlobalVar.etpStepsReport) {
				DriverSession
				.getLastExecutionReportingInstance()
				.teststepreporting(
						"﻿Status DropDown exists for every product  ",
						"PASS",
						"Status DropDown should be exists for every product ");

			} else {
				DriverSession
				.getLastExecutionReportingInstance()
				.teststepreporting(
						"Status DropDown does not exists for every product",
						"FAIL",
						"Status DropDown should be exists for every product ");
			}

		} catch (Exception e) {
			e.printStackTrace();
			DriverSession
			.getLastExecutionReportingInstance()
			.teststepreporting(
					"Status DropDown does not exists for every product",
					"FAIL",
					"Status DropDown should be exists for every product ");
		}
	}

	public void verifyTextOnPage(String text) {
		boolean textFound = false;
		try {					
			textFound = driver.getPageSource().contains(text);

			if (textFound) {

				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting(text + "  Text verified.", "PASS",
						"Text should be verified.");

			} else {

				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting(text + "  Text not verified.",
						"PASS", "Text should not  be verified.");

			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting(text + "  Text not verified.", "PASS",
					"Text should not be verified.");
		}
	}

	public void countStatusDropdownValue() {
		WebElement element = null;
		String Code;
		Integer count;
		try {
			element = BackEndManageProductPage.getInstance().NameHeader(driver);

			Keywords.explicitWait(10);
			element = BackEndManageProductPage.getInstance()
					.FirstRowShopCluesCode_EditBox(driver);

			Keywords.click(element);
			Code = Keywords.getAttributeVal(element, "value");
			//System.out.println("ShopClues Code   " + Code);
			element = BackEndManageProductPage.getInstance()
					.FirstStatusDropDown(driver, Code);
			Keywords.click(element);
			Keywords.explicitWait(1);
			count = BackEndManageProductPage.getInstance()
					.FirstStatusDropDownList(driver, Code);
			//System.out.println(count);

			if (GlobalVar.etpStepsReport) {
				DriverSession
				.getLastExecutionReportingInstance()
				.teststepreporting(
						"﻿Status DropDown contains  " + count
						+ " Values", "PASS",
						"Should be contained status dropdown multiple values");

			} else {
				DriverSession
				.getLastExecutionReportingInstance()
				.teststepreporting("DropDown value not found", "FAIL",
						"Should be contained status dropdown multiple values");
			}

		} catch (Exception e) {
			e.printStackTrace();
			DriverSession
			.getLastExecutionReportingInstance()
			.teststepreporting("DropDown value not found", "FAIL",
					"Should be contained status dropdown multiple values");
		}
	}

	// Manage Product Page to click on advance search Button
	public void ClickAdvanceSearchIcon() {
		WebElement element = null;
		try {
			element = BackEndManageProductPage.getInstance().AdvanceSearchIcon(
					driver);
			Keywords.click(element);
			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("Clicked on Advance Search Icon",
						"PASS",
						"Should be Clicked on Advance Search Icon");

			} else {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting(
						"Not clicked On Advance Search Icon", "FAIL",
						"Should be Clicked on Advance Search Icon");
			}

		} catch (Exception e) {
			e.printStackTrace();
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Not clicked On Advance Search Icon",
					"FAIL", "Should be Clicked on Advance Search Icon");
		}
	}

	public void TypeOnSalesAmountFrom() {
		WebElement element = null;
		try {
			element = BackEndManageProductPage.getInstance()
					.SalesAmountFrom_EditBox(driver);
			Keywords.typeText(element,
					GlobalVar.TEST_DATA.get("Sales Amount From"));

			if (GlobalVar.etpStepsReport) {
				DriverSession
				.getLastExecutionReportingInstance()
				.teststepreporting(
						"Sales amount from typed successfully. :: "
								+ GlobalVar.TEST_DATA
								.get("Sales Amount From"),
								"PASS", "Sales amount from should be entered.");

			} else {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("Sales amount from not typed.",
						"FAIL", "Sales amount from should be typed.");

			}
		} catch (Exception e) {
			e.printStackTrace();
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Exception occured : ", "FAIL",
					e.toString());
		}
	}

	public void TypeOnSalesAmountTo() {
		WebElement element = null;
		try {
			element = BackEndManageProductPage.getInstance()
					.SalesAmountTo_EditBox(driver);
			Keywords.typeText(element,
					GlobalVar.TEST_DATA.get("Sales Amount To"));

			if (GlobalVar.etpStepsReport) {
				DriverSession
				.getLastExecutionReportingInstance()
				.teststepreporting(
						"Sales amount to typed successfully. :: "
								+ GlobalVar.TEST_DATA
								.get("Sales Amount To"),
								"PASS", "Sales amount to should be entered.");

			} else {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("Sales amount to not typed.",
						"FAIL", "Sales amount to should be typed.");

			}
		} catch (Exception e) {
			e.printStackTrace();
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Exception occured : ", "FAIL",
					e.toString());
		}
	}

	public void TypeOnDateTo() {
		WebElement element = null;
		try {
			element = BackEndManageProductPage.getInstance().EndDate_EditBox(
					driver);
			Keywords.clearEditField(element);
			Keywords.typeText(element, GlobalVar.TEST_DATA.get("To Date"));

			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting(
						"To date typed successfully. :: "
								+ GlobalVar.TEST_DATA.get("To Date"),
								"PASS", "To date should be entered.");

			} else {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("To date not typed.", "FAIL",
						"To date should be typed.");

			}
		} catch (Exception e) {
			e.printStackTrace();
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Exception occured : ", "FAIL",
					e.toString());
		}
	}

	public void TypeOnDateFrom() {
		WebElement element = null;
		try {
			element = BackEndManageProductPage.getInstance().StartDate_EditBox(
					driver);
			Keywords.clearEditField(element);
			Keywords.typeText(element, GlobalVar.TEST_DATA.get("From Date"));

			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting(
						"From date typed successfully. :: "
								+ GlobalVar.TEST_DATA.get("From Date"),
								"PASS", "From date should be entered.");

			} else {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("From date not typed.", "FAIL",
						"From date should be typed.");

			}
		} catch (Exception e) {
			e.printStackTrace();
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Exception occured : ", "FAIL",
					e.toString());
		}
	}

	public void ClickAdvanceSearch() {
		WebElement element = null;
		try {
			element = BackEndManageProductPage.getInstance()
					.AdvanceSearchButton(driver);
			Keywords.click(element);
			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("Clicked on Advance Search Button",
						"PASS",
						"Should be Clicked on Advance Search Button");

			} else {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting(
						"Not clicked On Advance Search Button", "FAIL",
						"Should be Clicked on Advance Search Button");
			}

		} catch (Exception e) {
			e.printStackTrace();
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Not clicked On Advance Search Button",
					"FAIL",
					"Should be Clicked on Advance Search Button");
		}
	}

	public void VerifyAdvanceSearchButton() {
		WebElement element = null;
		try {

			element = BackEndManageProductPage.getInstance()
					.AdvanceSearchButton(driver);
			Keywords.isElementPresent(element);

			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting(
						"﻿Advance search button is verified", "PASS",
						"Advance search button  should be exist");
			} else {
				DriverSession
				.getLastExecutionReportingInstance()
				.teststepreporting(
						"Advance search button is not verified",
						"FAIL", "Advance search button should be exist");
			}

		} catch (Exception e) {
			e.printStackTrace();
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Advance search button does not exist",
					"FAIL", "Advance search button should be exist");
		}
	}


	// / Don't add this keyword

	public void EditProductTableColumn(Integer col, String val) {
		WebElement element = null;
		Integer RowVal;
		try {
			element = BackEndManageProductPage.getInstance().NameHeader(driver);

			RowVal = Integer.parseInt(GlobalVar.TEST_DATA.get("Row"));
			element = BackEndManageProductPage.getInstance()
					.ProductTableEditField(driver, RowVal, col);
			Keywords.clearEditField(element);
			Keywords.typeText(element, GlobalVar.TEST_DATA.get("val"));
			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("Products are in Sorted Order  ",
						"PASS", "Products are in Sorted Order  ");

			} else {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("Products are not in Sorted Order ",
						"FAIL", "Products are not in Sorted Order ");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Manage Product Page Type text in Search Box
	public void TypeTextOnSearch_Name() {
		WebElement element = null;
		try {
			element = BackEndManageProductPage.getInstance()
					.FindResultWithName_EditBox(driver);
			Keywords.typeText(element,
					GlobalVar.TEST_DATA.get("SearchTextName"));

			if (GlobalVar.etpStepsReport) {
				DriverSession
				.getLastExecutionReportingInstance()
				.teststepreporting(
						"Search Text typed succefully. :: "
								+ GlobalVar.TEST_DATA
								.get("SearchTextName"),
								"PASS", "Search Text should be entered.");

			} else {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("Search Text not typed.", "FAIL",
						"Search Text should be typed.");

			}
		} catch (Exception e) {
			e.printStackTrace();
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Exception occured : ", "FAIL",
					e.toString());
		}
	}

	// Manage Product Page to click on search Button
	public void ClickSearch() {
		WebElement element = null;
		try {
			element = BackEndManageProductPage.getInstance().SearchButton(
					driver);
			Keywords.click(element);
			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("Clicked on Search Button", "PASS",
						"Should be Clicked on Search Button");

			} else {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("Not clicked On Search Button",
						"FAIL", "Should be Clicked on Search Button");
			}

		} catch (Exception e) {
			e.printStackTrace();
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Not clicked On Search Button", "FAIL",
					"Should be Clicked on Search Button");
		}
	}

	// Manage Product Page to click on search Button
	public void CatalogDropdown() {
		WebElement element = null;
		try {
			element = BackEndManageProductPage.getInstance().CatalogDropdown(
					driver);
			Actions act = new Actions(driver);
			act.moveToElement(element).perform();
			Keywords.explicitWait(5);
			element = BackEndManageProductPage.getInstance().manageProductLink(
					driver);
			Keywords.click(element);

			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("Clicked on Catalog Button", "PASS",
						"Should be Clicked on Catalog Button");

			} else {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("Not clicked On Catalog Button",
						"FAIL", "Should be Clicked on Catalog Button");
			}

		} catch (Exception e) {
			e.printStackTrace();
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Not clicked On Catalog Button", "FAIL",
					"Should be Clicked on Catalog Button");
		}
	}

	// ////

	// Manage Product Page to click on Image_Link Button
	public void ClickImage_Link() {
		WebElement element = null;
		try {
			element = BackEndManageProductPage.getInstance().Image_Link(driver);
			Keywords.click(element);
			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("Clicked on Image_Link Button",
						"PASS",
						"Should be Clicked on Image_Link Button");

			} else {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("Not clicked On Image_Link Button",
						"FAIL",
						"Should be Clicked on Image_Link Button");
			}

		} catch (Exception e) {
			e.printStackTrace();
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Not clicked On Image_Link Button",
					"FAIL", "Should be Clicked on Image_Link Button");
		}
	}

	// Manage Product Page to click on Name_Link Button
	public void ClickName_Link() {
		WebElement element = null;
		try {
			element = BackEndManageProductPage.getInstance().Name_Link(driver);
			Keywords.click(element);
			if (GlobalVar.etpStepsReport) {
				DriverSession
				.getLastExecutionReportingInstance()
				.teststepreporting("Clicked on Name_Link Button",
						"PASS", "Should be Clicked on Name_Link Button");

			} else {
				DriverSession
				.getLastExecutionReportingInstance()
				.teststepreporting("Not clicked On Name_Link Button",
						"FAIL", "Should be Clicked on Name_Link Button");
			}

		} catch (Exception e) {
			e.printStackTrace();
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Not clicked On Name_Link Button",
					"FAIL", "Should be Clicked on Name_Link Button");
		}
	}

	// Manage Product Page to click on MRP_Link Button
	public void ClickMrp_Link() {
		WebElement element = null;
		try {
			element = BackEndManageProductPage.getInstance().MRP_Link(driver);
			Keywords.click(element);
			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("Clicked on MRP_Link Button",
						"PASS", "Should be Clicked on MRP_Link Button");

			} else {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("Not clicked On MRP_Link Button",
						"FAIL", "Should be Clicked on MRP_Link Button");
			}

		} catch (Exception e) {
			e.printStackTrace();
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Not clicked On MRP_Link Button",
					"FAIL", "Should be Clicked on MRP_Link Button");
		}
	}

	// Manage Product Page to click on Selling Price Link Button
	public void ClickSellingPrice_Link() {
		WebElement element = null;
		try {
			element = BackEndManageProductPage.getInstance().SellingPrice_Link(
					driver);
			Keywords.click(element);
			if (GlobalVar.etpStepsReport) {
				DriverSession
				.getLastExecutionReportingInstance()
				.teststepreporting(
						"Clicked on SellingPrice_Link Button", "PASS",
						"Should be Clicked on SellingPrice_Link Button");

			} else {
				DriverSession
				.getLastExecutionReportingInstance()
				.teststepreporting(
						"Not clicked On SellingPrice_Link Button",
						"FAIL",
						"Should be Clicked on SellingPrice_Link Button");
			}

		} catch (Exception e) {
			e.printStackTrace();
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting(
					"Not clicked On SellingPrice_Link Button", "FAIL",
					"Should be Clicked on SellingPrice_Link Button");
		}
	}

	// Manage Product Page to click on Committed Quantity Link Button
	public void ClickCommittedQuantity_Link() {
		WebElement element = null;
		try {
			element = BackEndManageProductPage.getInstance()
					.CommittedQuantity_Link(driver);
			Keywords.click(element);
			if (GlobalVar.etpStepsReport) {
				DriverSession
				.getLastExecutionReportingInstance()
				.teststepreporting(
						"Clicked on CommittedQuantity_Link Button",
						"PASS",
						"Should be Clicked on CommittedQuantity_Link Button");

			} else {
				DriverSession
				.getLastExecutionReportingInstance()
				.teststepreporting(
						"Not clicked On CommittedQuantity_Link Button",
						"FAIL",
						"Should be Clicked on CommittedQuantity_Link Button");
			}

		} catch (Exception e) {
			e.printStackTrace();
			DriverSession
			.getLastExecutionReportingInstance()
			.teststepreporting(
					"Not clicked On CommittedQuantity_Link Button",
					"FAIL",
					"Should be Clicked on CommittedQuantity_Link Button");
		}
	}

	// Manage Product Page to click on Status SubHeader Link Button
	public void ClickStatusSubHeader_Link() {
		WebElement element = null;
		try {
			element = BackEndManageProductPage.getInstance()
					.StatusSubHeader_Link(driver);
			Keywords.click(element);
			if (GlobalVar.etpStepsReport) {
				DriverSession
				.getLastExecutionReportingInstance()
				.teststepreporting(
						"Clicked on StatusSubHeader_Link Button",
						"PASS",
						"Should be Clicked on StatusSubHeader_Link Button");

			} else {
				DriverSession
				.getLastExecutionReportingInstance()
				.teststepreporting(
						"Not clicked On StatusSubHeader_Link Button",
						"FAIL",
						"Should be Clicked on StatusSubHeader_Link Button");
			}

		} catch (Exception e) {
			e.printStackTrace();
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting(
					"Not clicked On StatusSubHeader_Link Button",
					"FAIL",
					"Should be Clicked on StatusSubHeader_Link Button");
		}
	}

	// Manage Product Page to click on Delete Product Link Button
	public void deleteProductLink() {
		WebElement element = null;
		try {
			element = BackEndManageProductPage.getInstance()
					.DeleteProduct_Link(driver);
			Keywords.click(element);

			Alert alert = driver.switchTo().alert();
			alert.accept();

			if (GlobalVar.etpStepsReport) {
				DriverSession
				.getLastExecutionReportingInstance()
				.teststepreporting(
						"Clicked on DeleteProduct_Link Button", "PASS",
						"Should be Clicked on DeleteProduct_Link Button");

			} else {
				DriverSession
				.getLastExecutionReportingInstance()
				.teststepreporting(
						"Not clicked On DeleteProduct_Link Button",
						"FAIL",
						"Should be Clicked on DeleteProduct_Link Button");
			}

		} catch (Exception e) {
			e.printStackTrace();
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting(
					"Not clicked On DeleteProduct_Link Button", "FAIL",
					"Should be Clicked on DeleteProduct_Link Button");
		}
	}

	// /////////////////
	// SortColumn

	/*public void SortProductTable() {
		WebElement element = null;
		WebElement element1 = null;
		String Name2, Name1;
		Integer count, i;
		boolean flag = false;
		try {
			element = BackEndManageProductPage.getInstance().Name_Link(driver);

			count = BackEndManageProductPage.getInstance()
					.CountProductTableSize(driver);
			//System.out.println(count);
			for (i = 2; i < count; i++) {
				element = BackEndManageProductPage.getInstance()
						.ProductNameByRow_EditBox(driver, i);
				Name1 = Keywords.getText(element);
				//System.out.println("Product Name   " + Name1);

				element1 = BackEndManageProductPage.getInstance()
						.ProductNameByRow_EditBox(driver, i + 1);
				Name2 = Keywords.getText(element1);
				//System.out.println("Product Name   " + Name2);

				if (Name1.compareTo(Name2) >= 0) {
					flag = true;
				} else if (Name1.compareTo(Name2) <= 0) {
					flag = true;
				}

				else
					break;
				flag = false;
			}

			if (GlobalVar.etpStepsReport && flag == true) {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting("Products are in Sorted Order  ",
								"PASS", "Products are in Sorted Order  ");

			} else {
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting("Products are not in Sorted Order ",
								"FAIL", "Products are not in Sorted Order ");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	// ////////////////////
	public void verifyViewAllButton() {
		WebElement element = null;

		try {

			element = BackEndManageProductPage.getInstance()
					.ViewAllButton_Link(driver);
			Keywords.isElementPresent(element);

			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("﻿View All button is verified",
						"PASS", "View All button  should be exist");
			} else {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("View All button is not verified",
						"FAIL", "View All button should be exist");
			}

		} catch (Exception e) {
			e.printStackTrace();
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("View All button does not exist",
					"FAIL", "View All button should be exist");
		}

	}

	public void ViewAllClick() {
		WebElement element = null;

		try {
			element = BackEndManageProductPage.getInstance()
					.ViewAllButton_Link(driver);
			Keywords.click(element);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void VerifyProductTableItems() {

		Integer count;
		try {

			count = BackEndManageProductPage.getInstance()
					.CountProductTableSize(driver);
			//System.out.println(count);
			if (GlobalVar.etpStepsReport && count > 0) {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("﻿Product table contains product",
						"PASS", "Products Should be exist");

			} else {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("Product not found", "FAIL",
						"Products Should be exist");
			}

		} catch (Exception e) {
			e.printStackTrace();
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("DropDown value not found", "FAIL",
					"Products Should be exist");
		}
	}

	public void GotoPage() {
		WebElement element = null;

		try {
			// enter Desired Page Number
			element = BackEndManageProductPage.getInstance().GoToPage_Input(
					driver);
			Keywords.clearEditField(element);
			Keywords.typeText(element,
					GlobalVar.TEST_DATA.get("EnterDesiredNumber"));

			// click on Left arrow
			element = BackEndManageProductPage.getInstance().LeftArrow_Click(
					driver);
			Keywords.click(element);

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void verifyHiglightedColor() {
		WebElement element = null;
		;
		String colorValBefore = "";
		String colorValAfter = "";
		try {
			Actions act = new Actions(driver);
			element = BackEndManageProductPage.getInstance().tableMouseHover(
					driver, 3);
			colorValBefore = Keywords.getCssValue(element, "background-color");
			//System.out.println(colorValBefore);
			act.moveToElement(element).perform();
			Keywords.explicitWait(2);
			colorValAfter = Keywords.getCssValue(element, "background-color");
			//System.out.println(colorValAfter);
			if (colorValBefore.equalsIgnoreCase(colorValAfter)) {
				//System.out.println("Same as it was.");
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}





	public void Period() 
	{
		WebElement element=null;
		String periodVal;
		try{
			element=BackEndManageProductPage.getInstance().PeriodDropDown(driver);
			Select se=new Select(element);
			periodVal = GlobalVar.TEST_DATA.get("Period");
			se.selectByVisibleText(periodVal);
			if (periodVal.equalsIgnoreCase("Custom"))
			{
				element=BackEndManageProductPage.getInstance().StartDate_EditBox(driver);
				Keywords.clearEditField(element);
				Keywords.typeText(element,GlobalVar.TEST_DATA.get("From Date"));
				element=BackEndManageProductPage.getInstance().EndDate_EditBox(driver);
				Keywords.clearEditField(element);
				Keywords.typeText(element,GlobalVar.TEST_DATA.get("To Date"));

			}

			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("Period selected successfully", "PASS",
						"Period should be selected");

			} else {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("Period not selected", "FAIL",
						"Period should be selected");

			}
		}catch(Exception e){
			e.printStackTrace();
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Exception occured : ", "FAIL",
					e.toString());
		}
	}

	/// 01/03/2015


	public void editProductTableColumn(String colName,String val)
	{
		WebElement element=null;
		Integer RowVal, colVal,i,curCol = 0;
		String colText;
		try{
			element=BackEndManageProductPage.getInstance().NameHeader(driver);
			(new WebDriverWait(driver, 20)).until(ExpectedConditions.elementToBeClickable(element));
			colVal = BackEndManageProductPage.getInstance().CountProductTableColumn(driver);
			//System.out.println("Column count  " + colVal);
			for(i=1; i<=colVal; i++)
			{
				element=BackEndManageProductPage.getInstance().ProductTableColumnValue(driver,i);
				colText = Keywords.getText(element);
				//System.out.println("Col text  " + colText);

				if (colText.trim().equalsIgnoreCase(colName.trim()))
				{
					curCol = i;
					break;

				}

			}
			//System.out.println("Current col  " + curCol);
			RowVal = Integer.parseInt(GlobalVar.TEST_DATA.get("Row"));
			element=BackEndManageProductPage.getInstance().ProductTableEditField(driver,RowVal,curCol);
			Keywords.click(element);
			Keywords.clearEditField(element);
			Keywords.typeText(element,val);
			if (GlobalVar.etpStepsReport) 
			{
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting(colName + " column value changed successfully", "PASS","Column value should be changed");

			} 
			else 
			{
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting(colName + " column value not changed successfully", "FAIL","Column value should be changed");
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public void verifyEditColumn(String colName,String val)
	{
		WebElement element=null;
		Integer RowVal, colVal,i,curCol = 0;
		String colText, colValue = "";
		boolean flag = false;
		try{
			element=BackEndManageProductPage.getInstance().NameHeader(driver);
			(new WebDriverWait(driver, 20)).until(ExpectedConditions.elementToBeClickable(element));
			colVal = BackEndManageProductPage.getInstance().CountProductTableColumn(driver);
			for(i=1;i<=colVal;i++)
			{
				element=BackEndManageProductPage.getInstance().ProductTableColumnValue(driver,i);
				colText = Keywords.getText(element);
				if (colText.trim().equalsIgnoreCase(colName.trim()))
				{
					curCol = i;
					break;
				}
			}

			RowVal = Integer.parseInt(GlobalVar.TEST_DATA.get("Row"));
			element=BackEndManageProductPage.getInstance().ProductTableEditField(driver,RowVal,curCol);
			Keywords.click(element);
			colValue = Keywords.getAttributeVal(element, "value");
			if(colValue.trim().contains(val.trim()))
			{

				flag = true;
			}
			//System.out.println("Compare values  " + colValue.trim() + "  " + val.trim());
			if (GlobalVar.etpStepsReport && flag == true) 
			{
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting(colName + " column value verified successfully", "PASS","Column value should be verified");

			} 
			else 
			{
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting(colName + " column value not verified", "FAIL","Column value should be verified");
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void clickSave() 
	{
		WebElement element=null;
		try{
			element=BackEndManageProductPage.getInstance().saveButton(driver);
			Keywords.click(element);
			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Clicked on save Button", "PASS",
						"Should be Clicked on save Button");

			} else {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Not clicked On save Button", "FAIL",
						"Should be Clicked on save Button");
			}

		}catch(Exception e){
			e.printStackTrace();
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Not clicked On save Button", "FAIL",
					"Should be Clicked on save Button");
		}
	}

	public void clickNameHeader() 
	{
		WebElement element=null;
		try{
			element=BackEndManageProductPage.getInstance().nameHeaderLink(driver);
			Keywords.click(element);
			Thread.sleep(5000);
			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Clicked on Name_Link Button", "PASS",
						"Should be Clicked on Name_Link Button");

			} else {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Not clicked On Name_Link Button", "FAIL",
						"Should be Clicked on Name_Link Button");
			}

		}catch(Exception e){
			e.printStackTrace();
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Not clicked On Name_Link Button", "FAIL",
					"Should be Clicked on Name_Link Button");
		}
	}

	// 02/004/2015


	//Select first product row
	public void selectProductRow()
	{
		WebElement element=null;
		try{
			element=BackEndManageProductPage.getInstance().FirstRowShopCluesCode_EditBox(driver);
			Actions action = new Actions(driver);
			//System.out.println("Before mouse hover " + element.getAttribute("class"));
			//System.out.println("Before mouse hover " + element.isEnabled());
			action.moveToElement(element).build().perform();
			//System.out.println("After mouse hover " + element.getAttribute("class"));
			//System.out.println("Before mouse hover " + element.isEnabled());
			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("﻿Row selected", "PASS",
						"Row should be selected");
			} else {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("Row selection failed", "FAIL",
						"Row should be selected");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Row selection failed", "FAIL",
					"Row should be selected");
		}
	}
	/** ***************************************************************************************
	 * Keyword-Name:    click1by1UploadButton
	 * Usage:           void click1by1UploadButton()
	 * Description:     Click on 1-by-1 Upload button under manage product page
	 * Author:          Automators
	 * Dated:           06Apr2015
	 * Notes:   
	 * 
	 *************************************************************************************** **/
	public void click1by1UploadButton()
	{
		WebElement element=null;
		try{
			element=BackEnd1by1Upload.getInstance().onebyOneUploadButton(driver);
			BackEnd1by1Upload.getInstance().dynamicwait(driver, 20, element);
			Keywords.click(element);
			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Clicked on 1-by-1 Upload Button", "PASS",
						"Should be Clicked on 1-by-1 Upload Button");

			} else {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Not clicked On 1-by-1 Upload Button", "FAIL",
						"Should be Clicked on 1-by-1 Upload Button");
			}

		}catch(Exception e){
			e.printStackTrace();
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Not clicked On 1-by-1 Upload Button", "FAIL",
					"Should be Clicked on 1-by-1 Upload Button");
		}
	}

	/** ***************************************************************************************
	 * Keyword-Name:    clickCategoryLink
	 * Usage:           void clickCategoryLink()
	 * Description:     Click on category link under manage product page
	 * Author:          Automators
	 * Dated:           06Apr2015
	 * Notes:   
	 * 
	 *************************************************************************************** **/
	public void clickCategoryLink()
	{
		WebElement element=null;
		try{
			element=BackEnd1by1Upload.getInstance().categoryLink(driver);
			BackEnd1by1Upload.getInstance().dynamicwait(driver, 20, element);
			Keywords.click(element);
			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Clicked on category link", "PASS",
						"Should be Clicked on category link");

			} else {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Not clicked On category link", "FAIL",
						"Should be Clicked on category link");
			}

		}catch(Exception e){
			e.printStackTrace();
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Not clicked On category link", "FAIL",
					"Should be Clicked on category link");
		}
	}

	/** ***************************************************************************************
	 * Keyword-Name:    clickCancelLink
	 * Usage:           void clickCancelLink()
	 * Description:     Click on category link under manage product page
	 * Author:          Automators
	 * Dated:           06Apr2015
	 * Notes:   
	 * 
	 *************************************************************************************** **/
	public void clickCancelLink()
	{
		WebElement element=null;
		try{
			element=BackEnd1by1Upload.getInstance().cancelLink(driver);
			BackEnd1by1Upload.getInstance().dynamicwait(driver, 20, element);
			Keywords.click(element);
			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Clicked on cancel link", "PASS",
						"Should be Clicked on cancel link");

			} else {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Not clicked On cancel link", "FAIL",
						"Should be Clicked on cancel link");
			}

		}catch(Exception e){
			e.printStackTrace();
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Not clicked On cancel link", "FAIL",
					"Should be Clicked on cancel link");
		}
	}

	/** ***************************************************************************************
	 * Keyword-Name:    clickAddCategoriesAndCloseButton
	 * Usage:           void clickAddCategoriesAndCloseButton()
	 * Description:     Click on Add Categories And Close Button
	 * Author:          Automators
	 * Dated:           06Apr2015
	 * Notes:   
	 * 
	 *************************************************************************************** **/
	public void clickAddCategoriesAndCloseButton()
	{
		WebElement element=null;
		try{
			element=BackEnd1by1Upload.getInstance().addCategoriesAndCloseButton(driver);
			BackEnd1by1Upload.getInstance().dynamicwait(driver, 20, element);
			Keywords.click(element);
			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Clicked on add Categories And Close Button", "PASS",
						"Should be Clicked on add Categories And Close Button");

			} else {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Not clicked On add Categories And Close Button", "FAIL",
						"Should be Clicked on add Categories And Close Button");
			}

		}catch(Exception e){
			e.printStackTrace();
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Not clicked On add Categories And Close Button", "FAIL",
					"Should be Clicked on add Categories And Close Button");
		}
	}

	/** ***************************************************************************************
	 * Keyword-Name:    clickCategoryButton
	 * Usage:           void clickCategoryButton()
	 * Description:     Click on Add Categories And Close Button
	 * Author:          Automators
	 * Dated:           06Apr2015
	 * Notes:   
	 * 
	 *************************************************************************************** **/
	public void clickCategoryButton()
	{
		WebElement element=null;
		try{
			element=BackEnd1by1Upload.getInstance().categoryButton(driver);
			BackEnd1by1Upload.getInstance().dynamicwait(driver, 20, element);
			Keywords.click(element);
			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Clicked on category Button", "PASS",
						"Should be Clicked on category Button");

			} else {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Not clicked On category Button", "FAIL",
						"Should be Clicked on category Button");
			}

		}catch(Exception e){
			e.printStackTrace();
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Not clicked On category Button", "FAIL",
					"Should be Clicked on category Button");
		}
	}
	/** ***************************************************************************************
	 * Keyword-Name:    verifyCategoryLink
	 * Usage:           void verifyCategoryLink()
	 * Description:     Verify category link under manage product page
	 * Author:          Automators
	 * Dated:           06Apr2015
	 * Notes:   
	 * 
	 *************************************************************************************** **/
	public void verifyCategoryLinkVisible()
	{
		WebElement element=null;
		boolean flag;
		try{
			element=BackEnd1by1Upload.getInstance().categoryLink(driver);
			flag= element.isDisplayed();

			if (GlobalVar.etpStepsReport && flag == true) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Category link is visible", "PASS",
						"Category link should be visible");

			} else {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Category link is not visible", "FAIL",
						"Category link should be visible");
			}

		}catch(Exception e){
			e.printStackTrace();
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Category link is not visible", "FAIL",
					"Category link should be visible");
		}
	}

	/** ***************************************************************************************
	 * Keyword-Name:    verifyCategoryPopUp
	 * Usage:           void verifyCategoryPopUp()
	 * Description:     Verify category pop up under manage product page
	 * Author:          Automators
	 * Dated:           06Apr2015
	 * Notes:   
	 * 
	 *************************************************************************************** **/
	public void verifyCategoryPopUp()
	{
		WebElement element=null;
		boolean flag;
		try{
			element=BackEnd1by1Upload.getInstance().addCategoriesAndCloseButton(driver);
			BackEnd1by1Upload.getInstance().dynamicwait(driver, 20, element);
			flag= element.isDisplayed();

			if (GlobalVar.etpStepsReport && flag == true) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Category pop up is visible", "PASS",
						"Category pop up should be visible");

			} else {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Category pop up is not visible", "FAIL",
						"Category pop up should be visible");
			}

		}catch(Exception e){
			e.printStackTrace();
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Category pop up is not visible", "FAIL",
					"Category pop up should be visible");
		}
	}

	/** ***************************************************************************************
	 * Keyword-Name:    verifyCategoryPopUp_Negative
	 * Usage:           void verifyCategoryPopUp_Negative()
	 * Description:     Verify category pop up under manage product page
	 * Author:          Automators
	 * Dated:           06Apr2015
	 * Notes:   
	 * 
	 *************************************************************************************** **/
	public void verifyCategoryPopUp_Negative()
	{
		WebElement element=null;
		boolean flag;
		try{
			element=BackEnd1by1Upload.getInstance().addCategoriesAndCloseButton(driver);
			flag= element.isDisplayed();

			if (GlobalVar.etpStepsReport && flag == true) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Category pop up is visible", "FAIL",
						"Category pop up should not be visible");

			} else {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Category pop up is not visible", "PASS",
						"Category pop up should not be visible");
			}

		}catch(Exception e){
			e.printStackTrace();
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Category pop up is not visible", "FAIL",
					"Category pop up should not be visible");
		}
	}

	/** ***************************************************************************************
	 * Keyword-Name:    verifyCategoryPopUp
	 * Usage:           void verifyCategoryPopUp()
	 * Description:     Verify category pop up under manage product page
	 * Author:          Automators
	 * Dated:           06Apr2015
	 * Notes:   
	 * 
	 *************************************************************************************** **/
	public void verifyCategoryPopUp_CategoryButton()
	{
		WebElement element=null;
		boolean flag;
		try{
			element=BackEnd1by1Upload.getInstance().categoryButton(driver);
			flag= element.isDisplayed();

			if (GlobalVar.etpStepsReport && flag == true) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Category Button is visible", "PASS",
						"Category Button should be visible");

			} else {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Category Button is not visible", "FAIL",
						"Category Button should be visible");
			}

		}catch(Exception e){
			e.printStackTrace();
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Category Button is not visible", "FAIL",
					"Category Button should be visible");
		}
	}

	/** ***************************************************************************************
	 * Keyword-Name:    verifyCategoryPopUp
	 * Usage:           void verifyCategoryPopUp_CancelLink()
	 * Description:     Verify cancel link in category pop up
	 * Author:          Automators
	 * Dated:           06Apr2015
	 * Notes:   
	 * 
	 *************************************************************************************** **/
	public void verifyCategoryPopUp_CancelLink()
	{
		WebElement element=null;
		boolean flag;
		try{
			element=BackEnd1by1Upload.getInstance().cancelLink(driver);
			flag= element.isDisplayed();

			if (GlobalVar.etpStepsReport && flag == true) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Cancel Link is visible", "PASS",
						"Cancel Link should be visible");

			} else {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Cancel Link is not visible", "FAIL",
						"Cancel Link should be visible");
			}

		}catch(Exception e){
			e.printStackTrace();
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Cancel Link is not visible", "FAIL",
					"Cancel Link should be visible");
		}
	}

	/** ***************************************************************************************
	 * Keyword-Name:    pressEnter
	 * Usage:           void pressEnter()
	 * Description:     press Enter
	 * Author:          Automators
	 * Dated:           06Apr2015
	 * Notes:   
	 * 
	 *************************************************************************************** **/
	public void pressEnter()
	{
		try{
			Robot robot = new Robot();

			robot.delay(2000);

			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Enter pressed", "PASS",
						"Enter should be pressed");

			} else {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Enter not pressed", "FAIL",
						"Enter should be pressed");
			}

		}catch(Exception e){
			e.printStackTrace();
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Enter not pressed", "FAIL",
					"Enter should be pressed");
		}
	}

	/** ***************************************************************************************
	 * Keyword-Name:    getCountOfCategoryPopUp
	 * Usage:           void getCountOfCategoryPopUp()
	 * Description:     Verify category pop up under manage product page
	 * Author:          Automators
	 * Dated:           06Apr2015
	 * Notes:   
	 * 
	 *************************************************************************************** **/
	public void getCountOfCategoryPopUp()
	{
		Integer count= 0;
		try
		{
			count = BackEnd1by1Upload.getInstance().categoryCount(driver);
			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Category pop up window contains " + count + " categories", "PASS",
						"Category pop up window should be contained multiple categories");

			} else {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Categories not found", "FAIL",
						"Category pop up window should be contained multiple categories");
			}

		}catch(Exception e){
			e.printStackTrace();
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Categories not found", "FAIL",
					"Category pop up window should be contained multiple categories");
		}

	}

	/** ***************************************************************************************
	 * Keyword-Name:    selectCategoryByName 
	 * Usage:           void selectCategoryByName()
	 * Description:     Select category from category pop up
	 * Author:          Automators
	 * Dated:           07Apr2015
	 * Notes:   
	 * 
	 *************************************************************************************** **/
	public void selectCategoryByName()
	{
		WebElement element=null;
		String catName, catValue,val;
		Integer count= 0,i,j;
		boolean flag = false;
		try
		{
			element = BackEnd1by1Upload.getInstance().categoryTable(driver);
			BackEnd1by1Upload.getInstance().dynamicwait(driver, 20, element);
			count = BackEnd1by1Upload.getInstance().categoryCount(driver);
			//System.out.println("No of columns " + count);
			catValue = GlobalVar.TEST_DATA.get("Category Name");
			String textStr[] = catValue.split("##");
			for(j=0;j<textStr.length;j++)
			{
				val = textStr[j];
				for (i=1;i<=count;i++)
				{
					element = BackEnd1by1Upload.getInstance().categoryNameInCategoryPopUp(driver,i);
					catName = Keywords.getText(element);
					//System.out.println("Category Name " + catName);
					if(catName.trim().contains(val.trim()))
					{
						element = BackEnd1by1Upload.getInstance().categoryCheckBoxInCategoryPopUp(driver,i);
						Keywords.click(element);
						flag = true;
						break;
					}

				}
			}
			if (GlobalVar.etpStepsReport && flag == true) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(catValue + " Category selected successfully", "PASS",
						"Category should be selected");

			} else {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Categories not selected", "FAIL",
						"Category should be selected");
			}

		}catch(Exception e){
			e.printStackTrace();
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Categories not selected", "FAIL",
					"Category should be selected");
		}

	}

	/** ***************************************************************************************
	 * Keyword-Name:    verifyAndSelectAddedCategory 
	 * Usage:           void verifyAndSelectAddedCategory()
	 * Description:     verify and select Added Category
	 * Author:          Automators
	 * Dated:           07Apr2015
	 * Notes:   
	 * 
	 *************************************************************************************** **/
	public void verifyAndSelectAddedCategory()
	{
		WebElement element=null;
		String catName, catValue,val;
		Integer count= 0,i,j;
		boolean flag = false;
		try
		{
			count = BackEnd1by1Upload.getInstance().addedCategoryCount(driver);
			//System.out.println("No of columns " + count);
			catValue = GlobalVar.TEST_DATA.get("Category Name");
			String textStr[] = catValue.split("##");
			for(j=0;j<textStr.length;j++)
			{
				val = textStr[j];
				for (i=2;i<=count;i++)
				{
					element = BackEnd1by1Upload.getInstance().addedCategoryByRow(driver,i);
					catName = Keywords.getText(element);
					//System.out.println("Category Name " + catName);
					if(catName.trim().equalsIgnoreCase(val.trim()))
					{
						element = BackEnd1by1Upload.getInstance().addedCategoryRadioByRow(driver,i);
						Keywords.click(element);
						flag = true;
						break;
					}

				}
			}
			if (GlobalVar.etpStepsReport && flag == true) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(catValue + " Category verified and selected successfully", "PASS",
						"Category should be verified");

			} else {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Categories not verified", "FAIL",
						"Category should be verified");
			}

		}catch(Exception e){
			e.printStackTrace();
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Categories not verified", "FAIL",
					"Category should be verified");
		}

	}


	/** ***************************************************************************************
	 * Keyword-Name:    verifyAndSelectAddedCategory_Negative 
	 * Usage:           void verifyAndSelectAddedCategory_Negative()
	 * Description:     verify and select Added Category for negative scenario
	 * Author:          Automators
	 * Dated:           07Apr2015
	 * Notes:   
	 * 
	 *************************************************************************************** **/
	public void verifyAndSelectAddedCategory_Negative()
	{
		WebElement element=null;
		String catName, catValue,val;
		Integer count= 0,i,j;
		boolean flag = false;
		try
		{
			count = BackEnd1by1Upload.getInstance().addedCategoryCount(driver);
			//System.out.println("No of columns " + count);
			catValue = GlobalVar.TEST_DATA.get("Category Name");
			String textStr[] = catValue.split("##");
			for(j=0;j<textStr.length;j++)
			{
				val = textStr[j];
				for (i=2;i<=count;i++)
				{
					element = BackEnd1by1Upload.getInstance().addedCategoryByRow(driver,i);
					catName = Keywords.getText(element);
					//System.out.println("Category Name " + catName);
					if(catName.trim().contains(val.trim()))
					{
						element = BackEnd1by1Upload.getInstance().addedCategoryRadioByRow(driver,i);
						Keywords.click(element);
						flag = true;
						break;
					}

				}
			}
			if (GlobalVar.etpStepsReport && flag == true) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(catValue + " Category displayed", "FAIL",
						"Category should not be displayed");

			} else {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Categories not displayed", "PASS",
						"Category should not be displayed");
			}

		}catch(Exception e){
			e.printStackTrace();
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Categories not displayed", "FAIL",
					"Category should not be displayed");
		}

	}

	/** ***************************************************************************************
	 * Keyword-Name:    deleteAddCategory
	 * Usage:           void deleteAddCategory()
	 * Description:     Delete added category
	 * Author:          Automators
	 * Dated:           07Apr2015
	 * Notes:   
	 * 
	 *************************************************************************************** **/
	public void deleteAddCategory()
	{
		WebElement element=null;
		String catName, catValue,val;
		Integer count= 0,i,j;
		boolean flag = false;
		try{
			count = BackEnd1by1Upload.getInstance().addedCategoryCount(driver);
			//System.out.println("No of columns " + count);
			catValue = GlobalVar.TEST_DATA.get("Category Name");
			String textStr[] = catValue.split("##");
			for(j=0;j<textStr.length;j++)
			{
				val = textStr[j];
				for (i=2;i<=count;i++)
				{
					element = BackEnd1by1Upload.getInstance().addedCategoryByRow(driver,i);
					catName = Keywords.getText(element);
					//System.out.println("Category Name " + catName);
					if(catName.trim().contains(val.trim()))
					{
						element=BackEnd1by1Upload.getInstance().addedCategoryCrossByRow(driver,i);
						Keywords.click(element);
						flag = true;
						break;
					}
				}
			}

			if (GlobalVar.etpStepsReport && flag == true) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Category is deleted", "PASS",
						"Category should be deleted");

			} else {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Category is not deleted", "FAIL",
						"Category should be deleted");
			}

		}catch(Exception e){
			e.printStackTrace();
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Category is not deleted", "FAIL",
					"Category should be deleted");
		}
	}

	/** ***************************************************************************************
	 * Keyword-Name:    clickOnCheckAll
	 * Usage:           void clickOnCheckAll()
	 * Description:     Check all categories
	 * Author:          Automators
	 * Dated:           07Apr2015
	 * Notes:   
	 * 
	 *************************************************************************************** **/
	public void clickOnCheckAll()
	{
		WebElement element=null;
		try{
			//			element=BackEnd1by1Upload.getInstance().categoryButton(driver);
			//			BackEnd1by1Upload.getInstance().dynamicwait(driver, 20, element);
			element = BackEnd1by1Upload.getInstance().checkUncheckAll(driver);
			Keywords.click(element);
			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Clicked on checkAll check box", "PASS",
						"Should be Clicked on checkAll check box");

			} else {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Not clicked On checkAll check box", "FAIL",
						"Should be Clicked on checkAll check box");
			}

		}catch(Exception e){
			e.printStackTrace();
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Not clicked On checkAll check box", "FAIL",
					"Should be Clicked on checkAll check box");
		}
	}


	/** ***************************************************************************************
	 * Keyword-Name:    verifyCategoriesAddedToNewProduct 
	 * Usage:           void verifyCategoriesAddedToNewProduct()
	 * Description:     verify Added Category
	 * Author:          Automators
	 * Dated:           07Apr2015
	 * Notes:   
	 * 
	 *************************************************************************************** **/
	public void verifyCategoriesAddedToNewProduct()
	{
		Integer count = 0;
		try
		{
			count = BackEnd1by1Upload.getInstance().addedCategoryCount(driver);
			//System.out.println("No of columns " + count);

			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(count + " Categories is added to new product", "PASS",
						"All categories should be added");

			} else {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(count + " Categories is added to new product", "FAIL",
						"All categories should be added");
			}

		}catch(Exception e){
			e.printStackTrace();
			DriverSession.getLastExecutionReportingInstance().teststepreporting(count + " Categories is added to new product", "FAIL",
					"All categories should be added");
		}

	}

	/** ***************************************************************************************
	 * Keyword-Name:    clickOnSearchInCategory
	 * Usage:           void clickOnSearchInCategory()
	 * Description:     Click on search in category
	 * Author:          Automators
	 * Dated:           08Apr2015
	 * Notes:   
	 * 
	 *************************************************************************************** **/
	public void clickOnSearchInCategory()
	{
		WebElement element=null;
		try{
			element=BackEndManageProductPage.getInstance().searchInCategory(driver);
			BackEnd1by1Upload.getInstance().dynamicwait(driver, 20, element);
			Keywords.click(element);
			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Clicked on search in category", "PASS",
						"Should be Clicked on search in category");

			} else {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Not clicked On search in category", "FAIL",
						"Should be Clicked on search in category");
			}

		}catch(Exception e){
			e.printStackTrace();
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Not clicked On search in category", "FAIL",
					"Should be Clicked on search in category");
		}
	}


	/** ***************************************************************************************
	 * Keyword-Name:    selectCategory
	 * Usage:           void selectCategory()
	 * Description:     select category from category pop up window
	 * Author:          Automators
	 * Dated:           06Apr2015
	 * Notes:   
	 * 
	 *************************************************************************************** **/
	public void selectCategory() 
	{
		WebElement element=null;
		String catName, catValue,val;
		int count= 0,i,j,k = 1,l;

		boolean flag = false;
		try
		{
			element = BackEnd1by1Upload.getInstance().categoryTable(driver);
			BackEnd1by1Upload.getInstance().dynamicwait(driver, 20, element);
			count = BackEnd1by1Upload.getInstance().categoryCount(driver);
			//System.out.println("No of columns " + count);
			catValue = GlobalVar.TEST_DATA.get("Category Name");
			String textStr[] = catValue.split("####");
			j=textStr.length;
			val = textStr[0].trim().replace(" ", "");
			for (i=1;i<=count;i++)
			{
				element = driver.findElement(By.xpath("//div[@class='items-container multi-level']/table[" + i + "]/tbody/tr/td[2]"));
				catName = Keywords.getText(element).trim().replace(" ", "");
				//System.out.println("Category Name " + catName +": "+val);
				if(val.equalsIgnoreCase(catName))
				{
					if(j>k)
					{
						element = driver.findElement(By.xpath("//div[@class='items-container multi-level']/table[" + i + "]/tbody/tr/td[2]/table/tbody/tr/td[1]"));
						Keywords.click(element);
						k++;
						val = textStr[1];
						count = driver.findElements(By.xpath("//div[@class='items-container multi-level']/div/table")).size();
						for (l=1;l<=count;l++)
						{
							element = driver.findElement(By.xpath("//div[@class='items-container multi-level']/div/table[" + l + "]/tbody/tr/td[2]"));
							catName = Keywords.getText(element);
							//System.out.println("Category Name " + catName);
							if(catName.trim().contains(val.trim()))
							{
								if(j>k)
								{
									element = driver.findElement(By.xpath("//div[@class='items-container multi-level']/div/table[" + l + "]/tbody/tr/td[2]/table/tbody/tr/td[1]"));
									Keywords.click(element);
									k++;
									val = textStr[2];
									count = driver.findElements(By.xpath("//div[@class='items-container multi-level']/div/div/table")).size();
									for (l=1;l<=count;l++)
									{
										element = driver.findElement(By.xpath("//div[@class='items-container multi-level']/div/div/table[" + l + "]/tbody/tr/td[2]"));
										catName = Keywords.getText(element);
										//System.out.println("Category Name " + catName);
										if(catName.trim().contains(val.trim()))
										{
											if(j>k)
											{
												element = driver.findElement(By.xpath("//div[@class='items-container multi-level']/div/div/table[" + l + "]/tbody/tr/td[2]/table/tbody/tr/td[1]"));
												Keywords.click(element);
												k++;
												val = textStr[3];
												count = driver.findElements(By.xpath("//div[@class='items-container multi-level']/div/div/div/table")).size();
												for (l=1;l<=count;l++)
												{
													element = driver.findElement(By.xpath("//div[@class='items-container multi-level']/div/div/table[" + l + "]/tbody/tr/td[2]"));
													catName = Keywords.getText(element);
													//System.out.println("Category Name " + catName);
													if(catName.trim().contains(val.trim()))
													{
														element = driver.findElement(By.xpath("//div[@class='items-container multi-level']/div/div/div/table[" + l + "]/tbody/tr/td[1]/input"));
														Keywords.click(element);
													}
												}
											}
											else
											{
												element = driver.findElement(By.xpath("//div[@class='items-container multi-level']/div/div/table[" + l + "]/tbody/tr/td[1]/input"));
												Keywords.click(element);
											}
										}

									}
								}
								else
								{
									element = driver.findElement(By.xpath("//div[@class='items-container multi-level']/div/table[" + l + "]/tbody/tr/td[1]/input"));
									Keywords.click(element);
								}
							}
							else
							{
								element = driver.findElement(By.xpath("//div[@class='items-container multi-level']/table[" + i + "]/tbody/tr/td[1]/input"));
								Keywords.click(element);	
							}


						}

					}
				}
			}

			if (GlobalVar.etpStepsReport && flag == true) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(catValue + " Category selected successfully", "PASS",
						"Category should be selected");

			} else {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Categories not selected", "FAIL",
						"Category should be selected");
			}

		}catch(Exception e){
			e.printStackTrace();
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Categories not selected", "FAIL",
					"Category should be selected");
		}

	}

	/** ***************************************************************************************
	 * Keyword-Name:    verifyCreateButton
	 * Usage:           void verifyCreateButton()
	 * Description:     Verify object is visible or not
	 * Author:          Automators
	 * Dated:           06Apr2015
	 * Notes:   
	 * 
	 *************************************************************************************** **/
	public void verifyCreateButton()
	{
		WebElement element = null;
		boolean flag;
		try{
			element=BackEnd1by1Upload.getInstance().NewProduct_Create_Button(driver);
			BackEnd1by1Upload.getInstance().dynamicwait(driver, 20, element);
			flag= element.isDisplayed();

			if (GlobalVar.etpStepsReport && flag == true) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Create button is visible", "PASS",
						"Create button should be visible");

			} else {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Create button is not visible", "FAIL",
						"Create button should be visible");
			}

		}catch(Exception e){
			e.printStackTrace();
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Create button is not visible", "FAIL",
					"Create button should be visible");
		}
	}

	/** ***************************************************************************************
	 * Keyword-Name:    verifyCreateAndCloseButton
	 * Usage:           void verifyCreateAndCloseButton()
	 * Description:     Verify object is visible or not
	 * Author:          Automators
	 * Dated:           08Apr2015
	 * Notes:   
	 * 
	 *************************************************************************************** **/
	public void verifyCreateAndCloseButton()
	{
		WebElement element = null;
		boolean flag;
		try{
			element=BackEnd1by1Upload.getInstance().NewProduct_Create_And_Close_Button(driver);
			BackEnd1by1Upload.getInstance().dynamicwait(driver, 20, element);
			flag= element.isDisplayed();

			if (GlobalVar.etpStepsReport && flag == true) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Create and close button is visible", "PASS",
						"Create and close button should be visible");

			} else {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Create and close button is not visible", "FAIL",
						"Create and close button should be visible");
			}

		}catch(Exception e){
			e.printStackTrace();
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Create and close button is not visible", "FAIL",
					"Create and close button should be visible");
		}
	}

	/** ***************************************************************************************
	 * Keyword-Name:    verifyCancelButton
	 * Usage:           void verifyCancelButton()
	 * Description:     Verify object is visible or not
	 * Author:          Automators
	 * Dated:           08Apr2015
	 * Notes:   
	 * 
	 *************************************************************************************** **/
	public void verifyCancelButton()
	{
		WebElement element = null;
		boolean flag;
		try{
			element=BackEnd1by1Upload.getInstance().NewProduct_Cancel_Button(driver);
			BackEnd1by1Upload.getInstance().dynamicwait(driver, 20, element);
			flag= element.isDisplayed();

			if (GlobalVar.etpStepsReport && flag == true) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Cancel button is visible", "PASS",
						"Cancel button should be visible");

			} else {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Cancel button is not visible", "FAIL",
						"Cancel button should be visible");
			}

		}catch(Exception e){
			e.printStackTrace();
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Cancel button is not visible", "FAIL",
					"Cancel button should be visible");
		}
	}

	/** ***************************************************************************************
	 * Keyword-Name:    verifyOneBy1UploadButton
	 * Usage:           void verifyOneBy1UploadButton()
	 * Description:     Verify object is visible or not
	 * Author:          Automators
	 * Dated:           08Apr2015
	 * Notes:   
	 * 
	 *************************************************************************************** **/
	public void verifyOneBy1UploadButton()
	{
		WebElement element = null;
		boolean flag;
		try{
			element=BackEnd1by1Upload.getInstance().onebyOneUploadButton(driver);
			BackEnd1by1Upload.getInstance().dynamicwait(driver, 20, element);
			flag= element.isDisplayed();

			if (GlobalVar.etpStepsReport && flag == true) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("1-by-1 Upload button is visible", "PASS",
						"1-by-1 Upload button should be visible");

			} else {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("1-by-1 Upload button is not visible", "FAIL",
						"1-by-1 Upload button should be visible");
			}

		}catch(Exception e){
			e.printStackTrace();
			DriverSession.getLastExecutionReportingInstance().teststepreporting("1-by-1 Upload button is not visible", "FAIL",
					"1-by-1 Upload button should be visible");
		}
	}

	//Enter NewProduct Title
	public void NewProduct_ProductTitle() 
	{
		WebElement element=null;
		try{
			element=BackEnd1by1Upload.getInstance().NewProduct_Product_Title(driver);
			BackEnd1by1Upload.getInstance().dynamicwait(driver, 20, element);
			Keywords.typeText(element,GlobalVar.TEST_DATA.get("NewProduct_Input_ProductTitle"));

			if (GlobalVar.etpStepsReport) 
			{
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("Product Title Text typed succefully. :: "+GlobalVar.TEST_DATA.get("NewProduct_Input_ProductTitle"), "PASS",
						"Product Title Text should be entered.");

			} else {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("Product Title Text not typed.", "FAIL",
						"Product Title Text should be typed.");

			}
		}

		catch(Exception e)
		{
			e.printStackTrace();
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Exception occured : ", "FAIL",	e.toString());
		}
	}



	//Enter NewProduct Selling Price
	public void NewProduct_EnterSellingPrice() 
	{
		WebElement element=null;
		try{
			element=BackEnd1by1Upload.getInstance().NewProduct_Selling_Price(driver);
			Keywords.clearEditField(element);
			Keywords.typeText(element,GlobalVar.TEST_DATA.get("NewProduct_Input_SellingPrice"));
			JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			jsExecutor.executeScript("arguments[0].innerHTML = '<h1>Heading</h1>Hello World'", element);


			if (GlobalVar.etpStepsReport) 
			{
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("SellingPrice typed succefully. :: "+GlobalVar.TEST_DATA.get("NewProduct_Input_SellingPrice"), "PASS",
						"SellingPrice Text should be entered.");

			} else {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("SellingPrice Text not typed.", "FAIL",
						"SellingPrice Text should be typed.");

			}
		}

		catch(Exception e)
		{
			e.printStackTrace();
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Exception occured : ", "FAIL",	e.toString());
		}
	}


	@SuppressWarnings("deprecation")
	public void NewProduct_EnterFullDescription() 
	{
		try{
			driver.switchTo().frame(0);
			GlobalVar.selenium.type("id=tinymce", GlobalVar.TEST_DATA.get("NewProduct_Input_FullDescription"));
			driver.switchTo().defaultContent();

			if (GlobalVar.etpStepsReport) 
			{
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("Full Description typed succefully. :: "+GlobalVar.TEST_DATA.get("NewProduct_Input_FullDescription"), "PASS",
						" Full Description Text should be entered.");

			} else {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting(" Full Description Text not typed.", "FAIL",
						"Full Description Text should be typed.");

			}
		}

		catch(Exception e)
		{
			e.printStackTrace();
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Exception occured : ", "FAIL",	e.toString());
		}
	}


	public void NewProduct_AttachImage()
	{


		WebElement element=null;
		try 
		{
			element=BackEnd1by1Upload.getInstance().NewProduct_Images_AttachFile(driver);

			//System.out.println(Keywords.getText(element));

			Keywords.click(element);

			//				element.sendKeys("/home/crestech/Desktop/Screenshot - Tuesday 31 March 2015 - 10:47:22  IST.png");

			Toolkit toolkit = Toolkit.getDefaultToolkit();
			Clipboard clipboard = toolkit.getSystemClipboard();

			clipboard.setContents(new StringSelection(GlobalVar.TEST_DATA.get("File Path")),null);

			Robot robot = new Robot();

			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_V);
			Thread.sleep(2000);
			robot.keyPress(KeyEvent.VK_ALT);
			robot.keyPress(KeyEvent.VK_O);
			robot.keyRelease(KeyEvent.VK_ALT);
			robot.keyRelease(KeyEvent.VK_O);
			if (GlobalVar.etpStepsReport) 
			{
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("File attached successfully", "PASS",
						"File attached should be attached.");

			} else {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("File not attached.", "FAIL",
						"File attached should be attached.");

			}

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			DriverSession.getLastExecutionReportingInstance().teststepreporting("File not attached", "FAIL",
					"File attached should be attached");
		}
	}

	//Click on NewProduct Create 
	public void NewProductclickCreate() 
	{
		WebElement element=null;
		try{
			element=BackEnd1by1Upload.getInstance().NewProduct_Create_Button(driver);
			Keywords.click(element);

			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Clicked on Create Button", "PASS",
						"Should be Clicked on Create Button");

			} else {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Not clicked On Create Button", "FAIL",
						"Should be Clicked on Create Button");
			}

		}catch(Exception e){
			e.printStackTrace();
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Not clicked On Create Button", "FAIL",
					"Should be Clicked on Create Button");
		}
	}

	/** ***************************************************************************************
	 * Keyword-Name:    NewProductclickCreateAndClose
	 * Usage:           WebElement Click_On_1by1_Upload()
	 * Description:     Click on "Create and Close" button on New Product Details under manage product page
	 * Author:          KAutomators
	 * Dated:           06 Apr 2015
	 * Notes:   
	 * 
	 *************************************************************************************** **/

	//Click on NewProduct Create and Close
	public void NewProductclickCreateAndClose() 
	{
		WebElement element=null;
		try{
			element=BackEnd1by1Upload.getInstance().NewProduct_Create_And_Close_Button(driver);
			Keywords.click(element);

			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Clicked on Create And Close Button", "PASS",
						"Should be Clicked on Create And Close Button");

			} else {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Not clicked On Create And Close Button", "FAIL",
						"Should be Clicked on Create And Close Button");
			}

		}catch(Exception e){
			e.printStackTrace();
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Not clicked On Create And Close Button", "FAIL",
					"Should be Clicked on Create And Close Button");
		}
	}

	//Click on NewProduct Cancel
	public void NewProductclickCancel() 

	{
		WebElement element=null;
		try{
			element=BackEnd1by1Upload.getInstance().NewProduct_Cancel_Button(driver);
			Keywords.click(element);
			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Clicked on Cancel Button", "PASS",
						"Should be Clicked on Cancel Button");

			} else {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Not clicked On Cancel Button", "FAIL",
						"Should be Clicked on Cancel Button");
			}

		}catch(Exception e){
			e.printStackTrace();
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Not clicked On Cancel Button", "FAIL",
					"Should be Clicked on Cancel Button");
		}

	}
	/** ***************************************************************************************
	 * Keyword-Name:    verifyNewProductAddMessage
	 * Usage:           void verifyNewProductAddMessage()
	 * Description:     Verify newly added product message
	 * Author:          Automators
	 * Dated:           09Apr2015
	 * Notes:   
	 * 
	 *************************************************************************************** **/
	public void verifyNewProductAddMessage() 

	{
		WebElement element=null;
		String text="";
		try{
			element=BackEnd1by1Upload.getInstance().newProductAddedMessage(driver);
			BackEnd1by1Upload.getInstance().dynamicwait(driver, 20, element);
			text=Keywords.getText(element);
			if (text.equalsIgnoreCase(GlobalVar.TEST_DATA.get("Message"))) {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("New product add message verified successfully. :: "+text+"=="+GlobalVar.TEST_DATA.get("Message"), "PASS",
						"New product add message should be verified.");

			} else {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("New product add message not verified "+text+"=="+GlobalVar.TEST_DATA.get("Message"), "FAIL",
						"New product add message should be verified.");

			}
		}catch(Exception e){
			e.printStackTrace();
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Exception occured : ", "FAIL",
					e.toString());
		}

	}

	//=============================Nazim=====================

	public void clickOnManageProductLinkForVendor() {
		WebElement element = null;
		try {
			element = BackEndManageProductPage.getInstance()
					.catalogLinkForVendor(driver);
			Actions act = new Actions(driver);
			Keywords.explicitWait(5);
			act.moveToElement(element).perform();
			element = BackEndManageProductPage.getInstance()
					.manageProductLinkForVendor(driver);
			Keywords.click(element);
			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("Clicked on manage product link",
						"PASS",
						"Should be clicked on manage product link");

			} else {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting(
						"Not clicked On manage product link", "FAIL",
						"Should be clicked on manage product link");
			}

		} catch (Exception e) {
			e.printStackTrace();
			DriverSession
			.getLastExecutionReportingInstance()
			.teststepreporting("Not clicked On manage product link.",
					"FAIL", "Should be Clicked on manage product link.");
		}
	}

	public void verifyHeaderForVendor() {
		WebElement element = null;
		String val = "";
		boolean flag = true;
		try {

			for (int i = 3; i < 7; i++) {
				element = BackEndManageProductPage.getInstance()
						.listingTableHeaderObject(driver, i);
				val = element.getAttribute("href");
				//System.out.println(val);
				if (val.equals("")) {
					flag = false;
				}

			}
			if (flag) {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting(
						"Table header verified successfully.", "PASS",
						"Should be verified header table.");

			} else {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("Not verified header table.",
						"FAIL", "Should be verified header table.");
			}

		} catch (Exception e) {
			e.printStackTrace();
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Exception occured. " + e.toString(),
					"FAIL", "Should be verified header table.");
		}
	}

	public void verifySortingHeaderForVendor() {
		WebElement element = null;
		String val = "";
		boolean flag = true;
		try {

			for (int i = 3; i < 7; i++) {
				element = BackEndManageProductPage.getInstance()
						.listingTableHeaderObject(driver, i);
				val = element.getAttribute("href");
				//System.out.println(val);
				if (val.equals("")) {
					flag = false;
				}

			}
			if (flag) {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting(
						"Table header verified successfully.", "PASS",
						"Should be verified header table.");

			} else {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("Not verified header table.",
						"FAIL", "Should be verified header table.");
			}

		} catch (Exception e) {
			e.printStackTrace();
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Exception occured. " + e.toString(),
					"FAIL", "Should be verified header table.");
		}
	}

	public void verifyDeleteLinkForVendor() {
		WebElement element = null;
		try {
			element = BackEndManageProductPage.getInstance()
					.DeleteProduct_Link(driver);
			Keywords.isElementPresent(element);
			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("Delete link present", "PASS",
						"Should be present element on page.");

			} else {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("Not present element on page.",
						"FAIL",
						"Should not be present element on page.");
			}

		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Exception occured : " + e.toString(),
					"FAIL", "Should not be present element on page.");
		}
	}
	//==============================Nazim====================================

	/** ***************************************************************************************
	 * Keyword-Name:    clickOnPreviousPageLinkForVendor
	 * Usage:           void clickOnPreviousPageLinkForVendor()
	 * Description:     Click on previous page link
	 * Author:          Automators
	 * Dated:           10Apr2015
	 * Notes:   
	 * 
	 *************************************************************************************** **/
	public void clickOnPreviousPageLinkForVendor() {
		WebElement element = null;
		try {
			element = BackEndManageProductPage.getInstance()
					.vendorPreviousPage_Link(driver);
			Keywords.click(element);
			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("Clicked on previous page link",
						"PASS",
						"Should be clicked on previous page link");

			} else {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting(
						"Not clicked On previous page link", "FAIL",
						"Should be clicked on previous page link");
			}

		} catch (Exception e) {
			e.printStackTrace();
			DriverSession
			.getLastExecutionReportingInstance()
			.teststepreporting("Not clicked On previous page link.",
					"FAIL", "Should be Clicked on previous page link.");
		}
	}
	/** ***************************************************************************************
	 * Keyword-Name:    clickOnNextPageLinkForVendor
	 * Usage:           void clickOnNextPageLinkForVendor()
	 * Description:     Click on next page link
	 * Author:          Automators
	 * Dated:           10Apr2015
	 * Notes:   
	 * 
	 *************************************************************************************** **/
	public void clickOnNextPageLinkForVendor() {
		WebElement element = null;
		try {
			element = BackEndManageProductPage.getInstance()
					.vendorNextPage_Link(driver);
			Keywords.click(element);
			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("Clicked on next page link",
						"PASS",
						"Should be clicked on next page link");

			} else {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting(
						"Not clicked On next page link", "FAIL",
						"Should be clicked on next page link");
			}

		} catch (Exception e) {
			e.printStackTrace();
			DriverSession
			.getLastExecutionReportingInstance()
			.teststepreporting("Not clicked On next page link.",
					"FAIL", "Should be Clicked on next page link.");
		}
	}
	/** ***************************************************************************************
	 * Keyword-Name:    clickOnGivenPageNoLinkForVendor
	 * Usage:           void clickOnGivenPageNoLinkForVendor()
	 * Description:     Click on given page link
	 * Author:          Automators
	 * Dated:           10Apr2015
	 * Notes:   
	 * 
	 *************************************************************************************** **/
	public void clickOnGivenPageNoLinkForVendor() {
		WebElement element = null;
		String page = "";
		try {
			page = GlobalVar.TEST_DATA.get("Page Number");
			element = BackEndManageProductPage.getInstance()
					.vendorGivenPageNo_Link(driver, page);
			BackEnd1by1Upload.getInstance().dynamicwait(driver, 20, element);
			Keywords.click(element);
			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("Clicked on " + page + " link",
						"PASS",
						"Should be clicked on " + page + " link");

			} else {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting(
						"Not clicked On " + page + " link", "FAIL",
						"Should be clicked on " + page + "  link");
			}

		} catch (Exception e) {
			e.printStackTrace();
			DriverSession
			.getLastExecutionReportingInstance()
			.teststepreporting("Not clicked On " + page + " link.",
					"FAIL", "Should be Clicked on " + page + " link.");
		}
	}

	/** ***************************************************************************************
	 * Keyword-Name:    getAndVerifyGoToPageValue
	 * Usage:           void getAndVerifyGoToPageValue()
	 * Description:     Get go to page edit text and verify
	 * Author:          Automators
	 * Dated:           10Apr2015
	 * Notes:   
	 * 
	 *************************************************************************************** **/
	public void getAndVerifyGoToPageValue(String pageNo) 
	{
		WebElement element = null;
		String str;
		try {
			element = BackEndManageProductPage.getInstance()
					.goToPage_Edit(driver);
			BackEnd1by1Upload.getInstance().dynamicwait(driver, 20, element);

			Thread.sleep(5000);
			str = Keywords.getAttributeVal(element, "value");
			//System.out.println("get value " + str);
			if (GlobalVar.etpStepsReport || str.trim().equalsIgnoreCase(pageNo.trim())) {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting(pageNo + " page is selected and verified",
						"PASS",
						"Page should be selected");

			} else {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting(
						pageNo + " page is not selected", "FAIL",
						"Page should be selected");
			}

		} catch (Exception e) {
			e.printStackTrace();
			DriverSession
			.getLastExecutionReportingInstance()
			.teststepreporting(pageNo + " page is not selected", "FAIL","Page should be selected");
		}
	}

	/** ***************************************************************************************
	 * Keyword-Name:    clickOnViewAllButtonForVendor
	 * Usage:           void clickOnViewAllButtonForVendor()
	 * Description:     Click on viewall button
	 * Author:          Automators
	 * Dated:           10Apr2015
	 * Notes:   
	 * 
	 *************************************************************************************** **/
	public void clickOnViewAllButtonForVendor() {
		WebElement element = null;
		String page = "";
		try {
			page = GlobalVar.TEST_DATA.get("Page Number");
			element = BackEndManageProductPage.getInstance()
					.vendorViewAll_Button(driver);
			BackEnd1by1Upload.getInstance().dynamicwait(driver, 20, element);
			Keywords.click(element);
			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("Clicked on viewall link",
						"PASS",
						"Should be clicked on viewall link");

			} else {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting(
						"Not clicked On viewall link", "FAIL",
						"Should be clicked on viewall  link");
			}

		} catch (Exception e) {
			e.printStackTrace();
			DriverSession
			.getLastExecutionReportingInstance()
			.teststepreporting("Not clicked On viewall link.",
					"FAIL", "Should be Clicked on viewall link.");
		}
	}
	public void NewProduct_URLImage()
	{


		WebElement element=null;
		try 
		{
			element=BackEndManageProductPage.getInstance().NewProduct_Images_URL(driver);
			//System.out.println(Keywords.getText(element));
			Keywords.click(element);


			Toolkit toolkit = Toolkit.getDefaultToolkit();
			Clipboard clipboard = toolkit.getSystemClipboard();

			clipboard.setContents(new StringSelection(GlobalVar.TEST_DATA.get("URLPath")),null);
			//System.out.println(GlobalVar.TEST_DATA.get("URLPath"));

			Robot robot = new Robot();

			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_V);
			Thread.sleep(2000);

			Alert alert = driver.switchTo().alert();
			//System.out.println(alert.getText());
			Thread.sleep(5000);
			alert.accept();



			if(GlobalVar.etpStepsReport)
			{
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Image URL value is Passed by the user", "PASS",
						"Image URL value should be selected by the user");
			}
			else
			{
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Image URL value is not Passed by the user", "FAIL",
						"Image URL value should be selected by the user");
			}

		} 
		catch (Exception e) 
		{
			// TODO: handle exception
		}
	}

	public void loginButton() {
		WebElement clickButton=null;
		try{
			clickButton=HomePage.getInstance().clickToLoginButton(driver);
			Keywords.click(clickButton);

			if(GlobalVar.etpStepsReport){

				DriverSession.getLastExecutionReportingInstance().teststepreporting("Login Button successfully clicked", "PASS",
						"Login Button should be successfully clicked");
			}
			else{
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Login Button is not successfully clicked", "FAIL",
						"Login Button should be successfully clicked");
			}
		}
		catch(Exception e){
			e.getMessage();
		}
	}

	public void validateHomepage() {
		WebElement validate=null;
		try{
			validate=HomePage.getInstance().validateHomeBanner(driver);
			Keywords.validateElementExistOrNot(validate);

			if(GlobalVar.etpStepsReport){

				DriverSession.getLastExecutionReportingInstance().teststepreporting("HomePage successfully validated", "PASS",
						"HomePage should be successfully Validated");
			}
			else{
				DriverSession.getLastExecutionReportingInstance().teststepreporting("HomePage is not successfully validated", "FAIL",
						"HomePage should be successfully Validated");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public void clickCatalogPane() {
		WebElement clickCatalog=null;
		WebElement catg_Quality=null;
		WebElement search_KeyRedirection=null;
		try{
			clickCatalog=HomePage.getInstance().clickToCatalogOption(driver);
			Keywords.click(clickCatalog);
			Keywords.explicitWait(1);

			catg_Quality=HomePage.getInstance().clickToCatalogQuality(driver);
			Keywords.moveToElementClick(catg_Quality, driver, 1);
			Keywords.explicitWait(1);

			search_KeyRedirection=HomePage.getInstance().clickToSearchRedirection(driver);
			Keywords.moveToElementClick(search_KeyRedirection, driver, 3);

			if(GlobalVar.etpStepsReport){
				DriverSession.getLastExecutionReportingInstance().
				teststepreporting("<b><i>Search Keyword Re-Direction </i></b> is successfully clicked", "PASS",
						"<b><i>Search Keyword Re-Direction </i></b> should be successfully clicked");
			}
			else{
				DriverSession.getLastExecutionReportingInstance().
				teststepreporting("<b><i>Search Keyword Re-Direction </i></b> is not successfully clicked", "FAIL",
						"<b><i>Search Keyword Re-Direction </i></b> should be successfully clicked");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public void validateAndSearchProduct() {
		WebElement validateSearchButton=null;
		WebElement searchField=null;
		try{
			validateSearchButton=HomePage.getInstance().clickToSearchButton(driver);
			Keywords.validateElementExistOrNot(validateSearchButton);
			Keywords.click(validateSearchButton);
			Keywords.explicitWait(1);

			searchField=HomePage.getInstance().clickSearchField(driver);
			Keywords.clearEditField(searchField);
			Keywords.typeText(searchField, GlobalVar.TEST_DATA.get("SearchProduct"));
			Keywords.click(HomePage.getInstance().clickToSubSearchBtn(driver));

			if(GlobalVar.etpStepsReport){
				DriverSession.getLastExecutionReportingInstance().
				teststepreporting("<b> Search by Keyword </b>field is successfully visible and <b><i><u>"+GlobalVar.TEST_DATA.get("SearchProduct")+"</u></i></b>  is successfully typed and Clicked", "PASS",
						"Search Field should be successfully typed and clicked");
			}
			else{
				DriverSession.getLastExecutionReportingInstance().
				teststepreporting("<b> Search by Keyword </b>field is not successfully visible and<b><i>"+GlobalVar.TEST_DATA.get("SearchProduct")+"</i></b>  is not successfully typed and Clicked", "FAIL",
						"Search Field should be successfully typed and clicked");
			}


		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public void validateSearchField() {
		List<WebElement> table_Headers=null;
		List<String>valuesDataSheet=null;
		List<String>prod_Details=null;
		try{
			table_Headers=HomePage.getInstance().getAllTableVisibleFields(driver);
			valuesDataSheet=Keywords.splitRowDataWithPipeOperator(GlobalVar.TEST_DATA.get("TabPanes"));
			prod_Details=Keywords.splitRowDataWithPipeOperator(GlobalVar.TEST_DATA.get("ProductDetails"));

			for(WebElement elements : table_Headers){

				if(elements.getText().contains(valuesDataSheet.get(0))){

					Keywords.getDefaultDropDownValue(valuesDataSheet.get(0),HomePage.getInstance().clickToKeywordType(driver) , driver);
				}

				if(elements.getText().contains(valuesDataSheet.get(1))){
					Keywords.getDefaultDropDownValue(valuesDataSheet.get(1),HomePage.getInstance().clickToSearchCondition(driver) , driver);
				}

				if(elements.getText().contains(valuesDataSheet.get(2))){

					if(HomePage.getInstance().clickToProduct(driver).getText().equalsIgnoreCase(GlobalVar.TEST_DATA.get("SearchProduct"))){

						DriverSession.getLastExecutionReportingInstance().
						teststepreporting("Search product : <b>"+GlobalVar.TEST_DATA.get("SearchProduct")+"</b> is successfully verified <br>", "PASS",
								"Search Field should be successfully typed and clicked");
					}
					else{
						DriverSession.getLastExecutionReportingInstance().
						teststepreporting("Search product : <b>"+GlobalVar.TEST_DATA.get("SearchProduct")+"</b> is not successfully verified ", "FAIL",
								"Search Field should be successfully typed and clicked");
					}
				}
				if(elements.getText().contains(valuesDataSheet.get(3))){

					if(HomePage.getInstance().clickToRedirectURLLogo(driver).getText().equalsIgnoreCase(prod_Details.get(0))){

						DriverSession.getLastExecutionReportingInstance().
						teststepreporting("Re-direct (to URL) : <br><b><u>"+prod_Details.get(0)+"</b></u><br> is successfully verified <br>", "PASS",
								"Search Field should be successfully typed and clicked");

					}
					else{

						DriverSession.getLastExecutionReportingInstance().
						teststepreporting("Re-direct (to URL) : <br><b><u>"+prod_Details.get(0)+"</b></u><br> is not successfully verified <br>", "FAIL",
								"Search Field should be successfully typed and clicked");
					}
				}
				if(elements.getText().contains(valuesDataSheet.get(4))){

					if(HomePage.getInstance().clickToMIDs(driver).getText().equalsIgnoreCase(prod_Details.get(1))){

						DriverSession.getLastExecutionReportingInstance().
						teststepreporting("MIDs Exempted : <br><b><u>"+prod_Details.get(1)+"</b></u><br> is successfully verified <br>", "PASS",
								"MIDs Exempted should be successfully verified");
					}
					else{

						DriverSession.getLastExecutionReportingInstance().
						teststepreporting("MIDs Exempted : <br><b><u>"+prod_Details.get(1)+"</b></u><br> is not successfully verified <br>", "FAIL",
								"MIDs Exempted should be successfully verified");
					}
				}
				if(elements.getText().contains(valuesDataSheet.get(5))){

					if(HomePage.getInstance().clickToSubState(driver).getText().equalsIgnoreCase("")){

						DriverSession.getLastExecutionReportingInstance().
						teststepreporting("Substate field is black is successfully verified <br>", "PASS",
								"Substate Field should be successfully Blank");

					}
					else{

						DriverSession.getLastExecutionReportingInstance().
						teststepreporting("Substate field is black is not successfully verified <br>", "FAIL",
								"Substate Field should be successfully Blank");
					}

				}
				if(elements.getText().contains(valuesDataSheet.get(6))){

					List<String> type_Options=Keywords.splitRowDataWithPipeOperator(GlobalVar.TEST_DATA.get("Section"));
					if(HomePage.getInstance().clickSection(driver).getText().equalsIgnoreCase(type_Options.get(0)) ||
							HomePage.getInstance().clickSection(driver).getText().equalsIgnoreCase(type_Options.get(1))){

						DriverSession.getLastExecutionReportingInstance().
						teststepreporting("Status is : "+HomePage.getInstance().clickSection(driver).getText()+" is successfully verified <br>", "PASS",
								"Status Field should be successfully Validated");
					}
					else{
						DriverSession.getLastExecutionReportingInstance().
						teststepreporting("Status is : "+HomePage.getInstance().clickSection(driver).getText()+" is not successfully verified <br>", "FAIL",
								"Status Field should be successfully Validated");
					}

				}
				if(elements.getText().contains(valuesDataSheet.get(7))){
					if(HomePage.getInstance().clickURL(driver).isDisplayed()){

						DriverSession.getLastExecutionReportingInstance().
						teststepreporting("Action field is <b><i><u>"+HomePage.getInstance().clickURL(driver).getText()+"</b></i></u> is successfully verified <br>", "PASS",
								"Action field Field should be successfully verified");
					}
					else{

						DriverSession.getLastExecutionReportingInstance().
						teststepreporting("Action field is "+HomePage.getInstance().clickURL(driver).getText()+" is not successfully verified <br>", "FAIL",
								"Action field Field should be successfully verified");
					}
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public void verifyKeywordTypeDropDown() {
		WebElement addRedirectLogo=null;
		WebElement dropDownValue=null;
		List<String>dropDownVal=null;
		try{
			addRedirectLogo=HomePage.getInstance().clickRedirectLogo(driver);
			if(addRedirectLogo.isDisplayed()){

				dropDownValue=HomePage.getInstance().clickKeywordTypeDropDown(driver);
				Keywords.click(dropDownValue);

				dropDownVal=Keywords.getDropDownValue(dropDownValue);
				DriverSession.getLastExecutionReportingInstance().
				teststepreporting("<b>Keyword Type</b> DropDown Default value is <b><i>"+dropDownVal.get(0)+"</i></b><br><u>All Enable Option in list are :</u> <br><b><i> "+dropDownVal+"</i></b> is successfully visible and validated", "PASS",
						"Keyword Type DropDown option should be successfully visibled");
			}
			else{
				DriverSession.getLastExecutionReportingInstance().
				teststepreporting("Keyword Type DropDown Default value is not enable in list ", "FAIL",
						"Keyword Type DropDown option should be successfully visibled");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public void verifySearchConditionDropDown() {
		WebElement condition=null;
		WebElement addRedirectLogo=null;
		List<String>dropDownVal=null;
		try{
			addRedirectLogo=HomePage.getInstance().clickRedirectLogo(driver);
			if(addRedirectLogo.isDisplayed()){

				condition=HomePage.getInstance().clickToCondition(driver);
				Keywords.click(condition);

				dropDownVal=Keywords.getDropDownValue(condition);
				DriverSession.getLastExecutionReportingInstance().
				teststepreporting("<b>Keyword Type</b> DropDown Default value is <b><i>"+dropDownVal.get(0)+"</i></b><br><u>All Enable Option in list are :</u> <br><b><i> "+dropDownVal+"</i></b> is successfully visible and validated", "PASS",
						"Keyword Type DropDown option should be successfully visibled");
			}
			else{
				DriverSession.getLastExecutionReportingInstance().
				teststepreporting("Keyword Type DropDown Default value is not enable in list ", "FAIL",
						"Keyword Type DropDown option should be successfully visibled");
			}

		}
		catch(Exception e){
			e.getMessage();
		}
	}

	public void verifyStatusAndSubStatus() {
		WebElement status=null;
		WebElement subStatus=null;
		WebElement addRedirectLogo=null;
		List<String>dropDownVal=null,subStatusDropDown=null;
		try{
			addRedirectLogo=HomePage.getInstance().clickRedirectLogo(driver);
			if(addRedirectLogo.isDisplayed()){

				status=HomePage.getInstance().clickToStatus(driver);
				Keywords.click(status);
				dropDownVal=Keywords.getDropDownValue(status);

				subStatus=HomePage.getInstance().clickToSubstatus(driver);
				Keywords.click(subStatus);
				subStatusDropDown=Keywords.getDropDownValue(subStatus);

				DriverSession.getLastExecutionReportingInstance().
				teststepreporting("<b>STATUS</b> DropDown Default value is <b><i>"+dropDownVal.get(0)+"</i></b><br><u>All Enable Option in list are :</u> <br><b><i> "+dropDownVal+"</i></b>" +
						"<br><b>SUB-STATUS</b> DropDown Default value is <b><i>"+subStatusDropDown.get(0)+"</i></b><br><u>All Enable Option in list are :</u> <br><b><i> "+subStatusDropDown+"</i></b> is successfully visible and validated", "PASS",
						"Keyword Type DropDown option should be successfully visibled");
			}
			else{
				DriverSession.getLastExecutionReportingInstance().
				teststepreporting("STATUS Type DropDown Default value is not enable in list ", "FAIL",
						"Keyword Type DropDown option should be successfully visibled");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public void verifyTextFields() {
		WebElement keywordField=null;
		WebElement redirectURLField=null;
		WebElement exempt=null;
		try{
			keywordField=HomePage.getInstance().clickToTextField(driver);
			redirectURLField=HomePage.getInstance().clickToRedirectURL(driver);
			exempt=HomePage.getInstance().clickToExempt(driver);

			if((keywordField.getText().equalsIgnoreCase("")) && (redirectURLField.getText().equalsIgnoreCase("")) &&
					exempt.getText().equalsIgnoreCase("")){

				DriverSession.getLastExecutionReportingInstance().
				teststepreporting("<b>Keyword Field, Re-direct (to URL):, MIDs Exempted: </b> is enabled and Blank is successfully visible and validated", "PASS",
						"Keyword Fields should be successfully visibled");

			}
			else{
				DriverSession.getLastExecutionReportingInstance().
				teststepreporting("<b>Keyword Field, Re-direct (to URL):, MIDs Exempted: </b> is not enabled and Blank is not successfully visible and validated", "FAIL",
						"Keyword Fields should be successfully visibled");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public void clickProductFeature() {
		WebElement clickCatalog=null;
		WebElement catg_Quality=null;
		WebElement product_feature=null;
		try{
			clickCatalog=HomePage.getInstance().clickToCatalogOption(driver);
			Keywords.click(clickCatalog);
			Keywords.explicitWait(1);

			catg_Quality=HomePage.getInstance().clickToCatalogQuality(driver);
			Keywords.moveToElementClick(catg_Quality, driver, 1);
			Keywords.explicitWait(1);

			product_feature=HomePage.getInstance().clickProductFeature(driver);
			Keywords.moveToElementClick(product_feature, driver, 3);

			if(GlobalVar.etpStepsReport){
				DriverSession.getLastExecutionReportingInstance().
				teststepreporting("<b><i>Product Feature </i></b> is successfully clicked", "PASS",
						"<b><i>Product Feature </i></b> should be successfully clicked");
			}
			else{
				DriverSession.getLastExecutionReportingInstance().
				teststepreporting("<b><i>Product Feature </i></b> is not successfully clicked", "FAIL",
						"<b><i>Product Feature </i></b> should be successfully clicked");
			}
		}
		catch(Exception e){
			e.getMessage();
		}
	}

	public void verifyproductFeaturepage() {
		WebElement logo=null;
		try{
			logo=HomePage.getInstance().clickFeaturePageLogo(driver);
			Keywords.validateElementExistOrNot(logo);
			if(GlobalVar.etpStepsReport){
				DriverSession.getLastExecutionReportingInstance().
				teststepreporting("<b><i>Product Features Page </i></b> is successfully loaded and verified", "PASS",
						"<b><i>Product Feature Page</i></b> should be successfully clicked");
			}
			else{
				DriverSession.getLastExecutionReportingInstance().
				teststepreporting("<b><i>Product Features Page </i></b> is not successfully loaded and verified", "FAIL",
						"<b><i>Product Feature Page</i></b> should be successfully clicked");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public void addFeature() {
		WebElement addFeature=null;
		WebElement pop_Up=null;
		try{
			addFeature=HomePage.getInstance().clickToAddFeature(driver);
			Keywords.click(addFeature);
			pop_Up=HomePage.getInstance().getLogoPopup(driver);
			Keywords.validateElementExistOrNot(pop_Up);

			if(GlobalVar.etpStepsReport){
				DriverSession.getLastExecutionReportingInstance().
				teststepreporting("<b><i>Add New Features Popup </i></b> is successfully loaded and verified", "PASS",
						"<b><i>Add New Features Popup</i></b> should be successfully Verified");
			}
			else{
				DriverSession.getLastExecutionReportingInstance().
				teststepreporting("<b><i>Add New Features Popup </i></b> is not successfully loaded and verified", "FAIL",
						"<b><i>Add New Features Popup</i></b> should be successfully clicked");
			}

		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public void verifyMandatoryFields() {
		WebElement creat=null;
		List<String> mandFieldDataSheet=null;
		List<String> mandTypesDataSheet=null;
		WebElement name=null,type=null,group=null;
		try{
			creat=HomePage.getInstance().clickCreateButton(driver);
			mandFieldDataSheet=Keywords.splitRowDataWithPipeOperator(GlobalVar.TEST_DATA.get("MandatoryFields"));
			mandTypesDataSheet=Keywords.splitRowDataWithPipeOperator(GlobalVar.TEST_DATA.get("MandatoryTypes"));

			Keywords.click(creat);
			Keywords.explicitWait(1);

			name=HomePage.getInstance().clickToNameOption(driver);
			type=HomePage.getInstance().clickToTypeOption(driver);
			group=HomePage.getInstance().clickToGroupOption(driver);


			if(name.getText().trim().equalsIgnoreCase(mandFieldDataSheet.get(0).trim()) && 
					(HomePage.getInstance().clickeToNamePopup(driver).getText().trim().equalsIgnoreCase(mandTypesDataSheet.get(0).trim()))){

				DriverSession.getLastExecutionReportingInstance().
				teststepreporting("<b><i> "+name.getText().trim()+" </i></b> is a mandatory field is successfully verified", "PASS",
						"<b><i> "+name.getText().trim()+" </i></b> should be a mandatory field and should be successfully Verified");
			}
			else{

				DriverSession.getLastExecutionReportingInstance().
				teststepreporting("<b><i> "+name.getText().trim()+" </i></b> is not selected as a mandatory field is successfully verified", "FAIL",
						"<b><i> "+name.getText().trim()+" </i></b> should be a mandatory field and should be successfully Verified");
			}

			if(type.getText().trim().equalsIgnoreCase(mandFieldDataSheet.get(1).trim()) && 
					(HomePage.getInstance().clickeToTypePopup(driver).getText().trim().equalsIgnoreCase(mandTypesDataSheet.get(1).trim()))){

				DriverSession.getLastExecutionReportingInstance().
				teststepreporting("<b><i> "+type.getText().trim()+" </i></b> is a mandatory field is successfully verified", "PASS",
						"<b><i> "+type.getText().trim()+" </i></b> should be a mandatory field and should be successfully Verified");

			}

			if(group.getText().trim().equalsIgnoreCase(mandFieldDataSheet.get(2).trim()) && 
					(HomePage.getInstance().clickeToGroupPopup(driver).getText().trim().equalsIgnoreCase(mandTypesDataSheet.get(2).trim()))){

				DriverSession.getLastExecutionReportingInstance().
				teststepreporting("<b><i> "+group.getText().trim()+" </i></b> is a mandatory field is successfully verified", "PASS",
						"<b><i> "+group.getText().trim()+" </i></b> should be a mandatory field and should be successfully Verified");

			}


		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public void enterNameFields() {
		WebElement name=null;
		String r_Name=null;
		List<String>split=null;
		try{
			split=Keywords.splitRowDataWithPipeOperator(GlobalVar.TEST_DATA.get("NameConvention"));
			r_Name=Keywords.getRandomizedString(split.get(0), split.get(1),"");
			GlobalVar.AddFeaturename=r_Name;
			name=HomePage.getInstance().clickToName(driver);
			Keywords.clearEditField(name);
			Keywords.typeText(name, r_Name);

			if(GlobalVar.etpStepsReport){
				DriverSession.getLastExecutionReportingInstance().
				teststepreporting("Name Field is : <b><i>"+r_Name+" </i></b> is successfully Entered and verified", "PASS",
						"Name Field is : <b><i>"+r_Name+" </i></b> should be successfully Verified");
			}
			else{
				DriverSession.getLastExecutionReportingInstance().
				teststepreporting("Name Field is : <b><i>"+r_Name+" </i></b> is not successfully Entered and verified", "FAIL",
						"Name Field is : <b><i>"+r_Name+" </i></b> should be successfully Verified");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public void enterTypeField() {
		WebElement type=null;
		List<String>type_DropDown=null;
		try{
			type_DropDown=Keywords.splitRowDataWithPipeOperator(GlobalVar.TEST_DATA.get("TypeDropDown"));
			type=HomePage.getInstance().clickToTypeDropdown(driver);

			Keywords.clickSelectTypetext(type,type_DropDown.get(0));
			Keywords.explicitWait(1);
			if(GlobalVar.etpStepsReport){
				DriverSession.getLastExecutionReportingInstance().
				teststepreporting("Type Field Drop-Down Value : <b><i>"+type_DropDown.get(0)+" </i></b> is successfully Selected and verified", "PASS",
						"Type Field Drop-Down Value : <b><i>"+type_DropDown.get(0)+" </i></b> should be successfully Verified");
			}
			else{
				DriverSession.getLastExecutionReportingInstance().
				teststepreporting("Type Field Drop-Down Value : <b><i>"+type_DropDown.get(0)+" </i></b> is not successfully Selected and verified", "FAIL",
						"Type Field Drop-Down Value : <b><i>"+type_DropDown.get(0)+" </i></b> should be successfully Verified");
			}

		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public void entergroupField() {
		WebElement group=null;
		List<String>group_DropDown=null;
		try{
			group_DropDown=Keywords.splitRowDataWithPipeOperator(GlobalVar.TEST_DATA.get("GroupDropDown"));
			group=HomePage.getInstance().clickGroupDropDown(driver);

			Keywords.clickSelectTypetext(group,group_DropDown.get(0));
			if(GlobalVar.etpStepsReport){
				DriverSession.getLastExecutionReportingInstance().
				teststepreporting("Group Field Drop-Down Value : <b><i>"+group_DropDown.get(0)+" </i></b> is successfully Selected and verified", "PASS",
						"Group Field Drop-Down Value : <b><i>"+group_DropDown.get(0)+" </i></b> should be successfully Verified");
			}
			else{
				DriverSession.getLastExecutionReportingInstance().
				teststepreporting("Group Field Drop-Down Value : <b><i>"+group_DropDown.get(0)+" </i></b> is not successfully Selected and verified", "FAIL",
						"Group Field Drop-Down Value : <b><i>"+group_DropDown.get(0)+" </i></b> should be successfully Verified");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public void clickToCreate() {
		WebElement create=null;
		try{
			create=HomePage.getInstance().clickToCreate(driver);
			Keywords.click(create);

			if(GlobalVar.etpStepsReport){
				DriverSession.getLastExecutionReportingInstance().
				teststepreporting("Feature Click Button clicked Successfully ", "PASS",
						"Feature Click Button clicked Successfully should be clicked Successfully");
			}
			else{
				DriverSession.getLastExecutionReportingInstance().
				teststepreporting("Feature Click Button is not clicked Successfully ", "FAIL",
						"Feature Click Button clicked Successfully should be clicked Successfully");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public void verifyAddFeaturename() {
		WebElement feature=null;
		WebElement clickSearch=null;
		WebElement feature_GroupName=null;
		try{
			feature=HomePage.getInstance().clickToFeaturetext(driver);
			Keywords.clearEditField(feature);
			Keywords.typeText(feature, GlobalVar.AddFeaturename);
			feature.sendKeys(Keys.ENTER);


			if(HomePage.getInstance().clickResultGroupName(driver).getText().equalsIgnoreCase(GlobalVar.AddFeaturename)){

				DriverSession.getLastExecutionReportingInstance().
				teststepreporting("Feature Name : <b><i>"+GlobalVar.AddFeaturename+"</b></i> is Successfully verified", "PASS",
						"Feature Name : "+GlobalVar.AddFeaturename+" should be clicked verified");
			}else{

				DriverSession.getLastExecutionReportingInstance().
				teststepreporting("Feature Name : "+GlobalVar.AddFeaturename+" is not Successfully verified", "FAIL",
						"Feature Name : "+GlobalVar.AddFeaturename+" should be clicked verified");
			}


		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public void clickAddFeaturegroupAndVerifyPopup() {
		WebElement f_group=null;
		WebElement popup=null;
		try{
			f_group=HomePage.getInstance().clickeToFeatureGroup(driver);
			Keywords.click(f_group);
			popup=HomePage.getInstance().clickAddNewGrouppopup(driver);

			if(popup.isDisplayed()){
				DriverSession.getLastExecutionReportingInstance().
				teststepreporting("Add New Feature Button clicked and "+popup.getText()+" popup is successfully verified ", "PASS",
						"Add New Feature Button clicked and "+popup.getText()+" popup should be clicked Successfully");
			}
			else{
				DriverSession.getLastExecutionReportingInstance().
				teststepreporting("Add New Feature Button clicked and "+popup.getText()+" popup is not successfully verified ", "FAIL",
						"Add New Feature Button clicked and "+popup.getText()+" popup should be clicked Successfully");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public void verifyAddNewgroupMandatoryField() {
		WebElement create=null;
		WebElement m_name=null;
		List<String>mand_Field=null;
		List<String>mand_types=null;
		try{
			mand_Field=Keywords.splitRowDataWithPipeOperator(GlobalVar.TEST_DATA.get("MandatoryTypes"));
			mand_types=Keywords.splitRowDataWithPipeOperator(GlobalVar.TEST_DATA.get("MandatoryFields"));

			create=HomePage.getInstance().clickToCreategroup(driver);
			Keywords.click(create);
			Thread.sleep(1500);
			Keywords.closeAlertpopup(driver);
			Keywords.explicitWait(1);

			m_name=HomePage.getInstance().clickNameHighlighter(driver);


			if(m_name.getText().equalsIgnoreCase(mand_Field.get(0)) && HomePage.getInstance().getNameField(driver).getText().equalsIgnoreCase(mand_types.get(0))){

				DriverSession.getLastExecutionReportingInstance().
				teststepreporting("<b><i> "+m_name.getText().trim()+" </i></b> is a mandatory field is successfully verified", "PASS",
						"<b><i> "+m_name.getText().trim()+" </i></b> should be a mandatory field and should be successfully Verified");

			}
			else{

				DriverSession.getLastExecutionReportingInstance().
				teststepreporting("<b><i> "+m_name.getText().trim()+" </i></b> is a mandatory field is not successfully verified", "FAIL",
						"<b><i> "+m_name.getText().trim()+" </i></b> should be a mandatory field and should be successfully Verified");
			}

		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public void enterNameField() {
		WebElement n_textname=null;
		String rand_name=null;
		List<String>nameDataSheet=null;
		try{
			n_textname=HomePage.getInstance().clickTextnameField(driver);
			nameDataSheet=Keywords.splitRowDataWithPipeOperator(GlobalVar.TEST_DATA.get("NameConvention"));
			rand_name=Keywords.getRandomizedString(nameDataSheet.get(0), nameDataSheet.get(1), "");
			GlobalVar.FeatureGroupName=rand_name;

			Keywords.typeText(n_textname, rand_name);

			if(GlobalVar.etpStepsReport){
				DriverSession.getLastExecutionReportingInstance().
				teststepreporting("Feature group Name <b><i>"+GlobalVar.FeatureGroupName+"</b></i> is Successfully typed and Verified ", "PASS",
						"Feature group Name <b><i>"+GlobalVar.FeatureGroupName+"</b></i> should be clicked Successfully");
			}
			else{
				DriverSession.getLastExecutionReportingInstance().
				teststepreporting("Feature group Name <b><i>"+GlobalVar.FeatureGroupName+"</b></i> is not Successfully typed and Verified ", "FAIL",
						"Feature group Name <b><i>"+GlobalVar.FeatureGroupName+"</b></i> should be clicked Successfully");

			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public void selectCatagory() {
		WebElement catag=null;
		WebElement catg_DropDown=null;
		WebElement checkBox=null;
		WebElement addCatgAndClose=null;
		List<String> id_Number=null;
		try{
			catag=HomePage.getInstance().clickToCategories(driver);
			Keywords.click(catag);

			catg_DropDown=HomePage.getInstance().clickCatgDropDown(driver);
			Keywords.click(catg_DropDown);

			checkBox=HomePage.getInstance().clickCheckBox(driver);
			Keywords.click(checkBox);

			addCatgAndClose=HomePage.getInstance().clickToAddCatg(driver);
			Keywords.click(addCatgAndClose);

			if(GlobalVar.etpStepsReport){
				DriverSession.getLastExecutionReportingInstance().
				teststepreporting("Feature group Name <b><i>Categories</i></b> is selected and clicked Successfully ", "PASS",
						"Feature group Name <b><i>Categories</i></b> should be clicked Successfully");
			}
			else{
				DriverSession.getLastExecutionReportingInstance().
				teststepreporting("Feature group Name <b><i>Categories</i></b> is not selected and clicked Successfully ", "FAIL",
						"Feature group Name <b><i>Categories</i></b> should be clicked Successfully");
			}

		}
		catch(Exception e){
			e.printStackTrace();
		}
	}


	public void verifyAddFeatureGroup() {
		WebElement create=null;
		try{

			Thread.sleep(1500);
			create=HomePage.getInstance().clickCreate(driver);
			Keywords.click(create);
			Thread.sleep(1500);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public void clickManagCounterfeitProducts() {
		WebElement clickCatalog=null;
		WebElement catg_Quality=null;
		WebElement manag_Counterfeit=null;
		try{
			clickCatalog=HomePage.getInstance().clickToCatalogOption(driver);
			Keywords.click(clickCatalog);
			Keywords.explicitWait(1);

			catg_Quality=HomePage.getInstance().clickToCatalogQuality(driver);
			Keywords.moveToElementClick(catg_Quality, driver, 1);
			Keywords.explicitWait(1);

			Keywords.explicitWait(1);
			manag_Counterfeit=HomePage.getInstance().clickmanagCounterfeitprod(driver);
			Keywords.moveToElementClick(manag_Counterfeit, driver, 1);
			Keywords.moveToElementClick(manag_Counterfeit, driver, 3);

			if(GlobalVar.etpStepsReport){
				DriverSession.getLastExecutionReportingInstance().
				teststepreporting("<b><i>Manage Counterfeit Products</i></b> is successfully clicked", "PASS",
						"<b><i> Manage Counterfeit Products </i></b> should be successfully clicked");
			}
			else{
				DriverSession.getLastExecutionReportingInstance().
				teststepreporting("<b><i> Manage Counterfeit Products </i></b> is not successfully clicked", "FAIL",
						"<b><i>Manage Counterfeit Products</i></b> should be successfully clicked");
			}
		}
		catch(Exception e){
			e.getMessage();
		}
	}

	public void validateManageCounterfeitProducts() {
		WebElement logo=null;
		try{
			logo=HomePage.getInstance().clickToManagCounterFit(driver);
			Keywords.validateElementExistOrNot(logo);
			if(GlobalVar.etpStepsReport){
				DriverSession.getLastExecutionReportingInstance().
				teststepreporting("<b><i>Manage Counterfeit Products Page</i></b> is successfully loaded and Validated", "PASS",
						"<b><i> Manage Counterfeit Products Page</i></b> should be successfully loaded and Validated");
			}
			else{
				DriverSession.getLastExecutionReportingInstance().
				teststepreporting("<b><i>Manage Counterfeit Products Page</i></b> is not successfully loaded and Validated", "FAIL",
						"<b><i> Manage Counterfeit Products Page</i></b> should be successfully loaded and Validated");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public void validatemandatoryFields() {
		WebElement search=null;
		WebElement name=null,mand_Popup=null;
		try{
			search=HomePage.getInstance().clickSearch(driver);
			Keywords.click(search);
			name=HomePage.getInstance().clickToNameField(driver);
			mand_Popup=HomePage.getInstance().clickMandpopup(driver);

			if(name.getText().equalsIgnoreCase(GlobalVar.TEST_DATA.get("MandatoryFieldName")) && 
					(mand_Popup.getText().equalsIgnoreCase(GlobalVar.TEST_DATA.get("MandatoryAlert")))){

				DriverSession.getLastExecutionReportingInstance().
				teststepreporting("<b><i>"+name.getText()+"</i></b> is a Mandatory Field is successfully Validated", "PASS",
						"<b><i>"+name.getText()+"</i></b> should be successfully Validated");
			}
			else{

				DriverSession.getLastExecutionReportingInstance().
				teststepreporting("<b><i>"+name.getText()+"</i></b> is a Mandatory Field is not successfully Validated", "FAIL",
						"<b><i>"+name.getText()+"</i></b> should be successfully Validated");
			}
		}
		catch(Exception e){
			e.getMessage();
		}
	}

	public void enterProductIdAndValidate() {
		WebElement textField=null,search=null;
		try{
			textField=HomePage.getInstance().clickProdIdTextField(driver);
			Keywords.clearEditField(textField);
			Keywords.typeText(textField, GlobalVar.TEST_DATA.get("Product-ID"));

			search=HomePage.getInstance().clickSearch(driver);
			Keywords.click(search);

			if(GlobalVar.etpStepsReport){
				DriverSession.getLastExecutionReportingInstance().
				teststepreporting("Product - ID : <b><i>"+GlobalVar.TEST_DATA.get("Product-ID")+"</i></b> is successfully entered Validated", "PASS",
						"Product - ID : <b><i>"+GlobalVar.TEST_DATA.get("Product-ID")+"</i></b> should be successfully entered and Validated");
			}
			else{
				DriverSession.getLastExecutionReportingInstance().
				teststepreporting("Product - ID : <b><i>"+GlobalVar.TEST_DATA.get("Product-ID")+"</i></b> is not successfully entered Validated", "FAIL",
						"Product - ID : <b><i>"+GlobalVar.TEST_DATA.get("Product-ID")+"</i></b> should be successfully entered and Validated");
			}

		}
		catch(Exception e){
			e.getMessage();
		}
	}

	public void clickAndValidateCounterfeitSearchPanel1() {
		WebElement clickCatalog=null;
		WebElement catg_Quality=null;
		WebElement CounterfeitSearchPanel1=null;
		try{
			clickCatalog=HomePage.getInstance().clickToCatalogOption(driver);
			Keywords.click(clickCatalog);
			Keywords.explicitWait(1);

			catg_Quality=HomePage.getInstance().clickToCatalogQuality(driver);
			Keywords.moveToElementClick(catg_Quality, driver, 1);
			Keywords.explicitWait(1);

			CounterfeitSearchPanel1=HomePage.getInstance().clickCounterfeitSearchPanel1(driver);
			Keywords.moveToElementClick(CounterfeitSearchPanel1, driver, 1);
			Keywords.moveToElementClick(CounterfeitSearchPanel1, driver, 3);


			if(HomePage.getInstance().clickSearchpanelLogo(driver).isDisplayed()){
				DriverSession.getLastExecutionReportingInstance().
				teststepreporting("<b><i>CounterfeitSearchPanel1</i></b> is successfully clicked and Page is Verified", "PASS",
						"<b><i> CounterfeitSearchPanel1 </i></b> should be successfully clicked and Verified");
			}
			else{
				DriverSession.getLastExecutionReportingInstance().
				teststepreporting("<b><i> CounterfeitSearchPanel1 </i></b> is not successfully clicked and Not Verified", "FAIL",
						"<b><i>CounterfeitSearchPanel1</i></b> should be successfully clicked");
			}

		}
		catch(Exception e){
			e.getMessage();
		}
	}

	public void verifyContentsInSideCounterfeitproductTool() {
		List<String>rulesDescription=null;
		List<String>subState=null;
		WebElement searchCounterfeitProducts=null;
		try{

			rulesDescription=Keywords.splitRowDataWithPipeOperator(GlobalVar.TEST_DATA.get("RulesDescription"));
			subState=Keywords.splitRowDataWithPipeOperator(GlobalVar.TEST_DATA.get("SubStates"));
			searchCounterfeitProducts=HomePage.getInstance().clickTopageLayOut(driver);

			Keywords.validatePageContents(searchCounterfeitProducts,rulesDescription);
			Keywords.validatePageContents(searchCounterfeitProducts, subState);

		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public void clickAndValidateCounterfeitSearchPanel2() {

		WebElement clickCatalog=null;
		WebElement catg_Quality=null;
		String panel=null;
		WebElement CounterfeitSearchPanel2=null;
		try{


			clickCatalog=HomePage.getInstance().clickToCatalogOption(driver);
			Keywords.click(clickCatalog);
			Keywords.explicitWait(1);

			catg_Quality=HomePage.getInstance().clickToCatalogQuality(driver);
			Keywords.moveToElementClick(catg_Quality, driver, 1);
			Keywords.explicitWait(1);

			CounterfeitSearchPanel2=HomePage.getInstance().clickCounterfeitSearchPanel2(driver);
			panel=CounterfeitSearchPanel2.getText();
			Keywords.moveToElementClick(CounterfeitSearchPanel2, driver, 1);
			Keywords.moveToElementClick(CounterfeitSearchPanel2, driver, 3);

			if(HomePage.getInstance().counterfitCheckTool(driver).isDisplayed()){
				DriverSession.getLastExecutionReportingInstance().
				teststepreporting("<b><i>"+panel+"</i></b> is successfully clicked and Page <b>"+HomePage.getInstance().counterfitCheckTool(driver).getText()+" </b>is Verified", "PASS",
						"<b><i> "+panel+" </i></b> should be successfully clicked and Verified");
			}
			else{
				DriverSession.getLastExecutionReportingInstance().
				teststepreporting("<b><i> "+panel+" </i></b> is not successfully clicked and Not Verified", "FAIL",
						"<b><i>"+panel+"</i></b> should be successfully clicked");
			}

		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public void validateInstructionToUseThispannel() {
		WebElement panel=null;
		List<String>value_DataSheet=null;
		try{
			panel=BackendCounterfeitCheckOut.getInstance().getAllPanelLayOut(driver);
			value_DataSheet=Keywords.splitRowDataWithPipeOperator(GlobalVar.TEST_DATA.get("Instructions"));
			Keywords.validatePageContents(panel, value_DataSheet);
		}
		catch(Exception e){
			e.getMessage();
		}
	}

	public void validateCriteriaType() {
		List<String>val=null;
		WebElement counterFitCriteria=null;
		WebElement lowLevelCriteria=null;

		try{
			val=Keywords.splitRowDataWithPipeOperator(GlobalVar.TEST_DATA.get("CriteriaType"));
			counterFitCriteria=BackendCounterfeitCheckOut.getInstance().clickToCCriteria(driver);
			lowLevelCriteria=BackendCounterfeitCheckOut.getInstance().clickLowLevelCriteria(driver);

			if(counterFitCriteria.getText().equalsIgnoreCase(val.get(0))){

				if(lowLevelCriteria.getText().equalsIgnoreCase(val.get(1))){

					DriverSession.getLastExecutionReportingInstance().
					teststepreporting("<b><i>"+counterFitCriteria.getText()+"</i></b> and <b><i>"+lowLevelCriteria.getText()+"</i></b> is successfully is Verified", "PASS",
							"<b><i>"+counterFitCriteria.getText()+"</i></b> and <b><i>"+lowLevelCriteria.getText()+" should be successfully Verified");

				}
			}
			else{
				DriverSession.getLastExecutionReportingInstance().
				teststepreporting("<b><i>"+counterFitCriteria.getText()+"</i></b> and <b><i>"+lowLevelCriteria.getText()+"</i></b> is not successfully Verified", "FAIL",
						"<b><i>"+counterFitCriteria.getText()+"</i></b> and <b><i>"+lowLevelCriteria.getText()+" should be successfully Verified");
			}
		}
		catch(Exception e){
			e.getMessage();
		}

	}

	public void selectByCatagory() {
		WebElement select=null;
		try{
			select=BackendCounterfeitCheckOut.getInstance().clickToLink(driver);
			Keywords.click(select);

			if(GlobalVar.etpStepsReport){
				DriverSession.getLastExecutionReportingInstance().
				teststepreporting("<b><i>Category</i></b> is successfully Clicked and Validated", "PASS",
						"<b><i>Category</i></b> should be successfully Clicked and Validated");
			}
			else{
				DriverSession.getLastExecutionReportingInstance().
				teststepreporting("<b><i>Category</i></b> is not successfully Clicked and Validated", "FAIL",
						"<b><i>Category</i></b> should be successfully Clicked and Validated");
			}
		}
		catch(Exception e){
			e.getMessage();
		}
	}

	public void selectFashionEyeWear() {
		WebElement clickfashionExpand=null;
		WebElement eyeWear=null;
		WebElement sunglass=null;
		WebElement addCatgAndClose=null;
		String fashion=null,eyewear=null,sunglasses=null;
		List<String>values=null;
		try{
			clickfashionExpand=BackendCounterfeitCheckOut.getInstance().clickFashionExpand(driver);
			fashion=Keywords.getText(clickfashionExpand);
			Keywords.click(clickfashionExpand);
			Keywords.explicitWait(1);

			eyeWear=BackendCounterfeitCheckOut.getInstance().clickToEyeWear(driver);
			eyewear=Keywords.getText(eyeWear);
			Keywords.click(eyeWear);
			Keywords.explicitWait(1);

			sunglass=BackendCounterfeitCheckOut.getInstance().clickToSunglass(driver);
			sunglasses=Keywords.getText(sunglass);
			Keywords.click(sunglass);
			Keywords.explicitWait(1);

			addCatgAndClose=BackendCounterfeitCheckOut.getInstance().clickToAddCatg(driver);
			Keywords.click(addCatgAndClose);
			values=Keywords.splitRowDataWithPipeOperator(GlobalVar.TEST_DATA.get("ProdList"));

			if(GlobalVar.etpStepsReport){
				DriverSession.getLastExecutionReportingInstance().
				teststepreporting("<b><i>"+values.get(0)+" -> "+values.get(1)+" -> "+values.get(2)+" </i></b> is successfully Clicked and Validated", "PASS",
						"<b><i>Category</i></b> should be successfully Clicked and Validated");
			}
			else{
				DriverSession.getLastExecutionReportingInstance().
				teststepreporting("<b><i>"+fashion+" -> "+eyewear+" -> "+sunglasses+" </i></b> is not successfully Clicked and Validated", "FAIL",
						"<b><i>Category</i></b> should be successfully Clicked and Validated");
			}
		}
		catch(Exception e){
			e.getMessage();
		}
	}

	// Manage Product Page to click on Check All Button
	public void ClickcheckAll_Link() {
		WebElement element = null;
		try {
			element = BackEndManageProductPage.getInstance().Catalog_CheckAll(driver);
			Keywords.click(element);
			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Clicked on CheckAll_Link Button","PASS","Should be Clicked on Image_Link Button");
			}
			else 
			{
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Not clicked On CheckAll_Link Button","FAIL","Should be Clicked on Image_Link Button");
			}

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Not clicked On CheckAll_Link Button","FAIL", "Should be Clicked on Image_Link Button");
		}
	}

	// Manage Product Page to click on Image_Link Button
	public void ClickBulkPRoductEdit_Link() {
		WebElement element = null;
		try {
			element = BackEndManageProductPage.getInstance().Catalog_BulkEditProductSettings(driver);
			Keywords.click(element);
			if (GlobalVar.etpStepsReport) 
			{
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Clicked on BulkPRoductEdit_Link Button","PASS","Should be Clicked on Bulk ProductEdit_Link Button");
			} 
			else 
			{
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Not clicked On Bulk Product Edit_Link Button","FAIL","Should be Clicked on Bulk Product Edit_Link Button");
			}

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Not clicked On Bulk Product Edit_Link Button","FAIL", "Should be Clicked on  Bulk Product Edit_Link Button");
		}
	}

	//Click on UnSelect All
	public void ClickUnselectAll_Link() {
		WebElement element = null;
		try {
			element = BackEndManageProductPage.getInstance().Catalog_BulkEditProduct_Unselect(driver);
			Keywords.click(element);
			if (GlobalVar.etpStepsReport) 
			{
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Clicked on Bulk Product Unselect All_Link Button","PASS","Should be Clicked on Bulk ProductEdit_Link Button");
			} 
			else 
			{
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Not clicked On Bulk Product Unselect All_Link Button","FAIL","Should be Clicked on Bulk Product Edit_Link Button");
			}

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Not clicked On Bulk Product Unselect All Link Button","FAIL", "Should be Clicked on  Bulk Product Edit_Link Button");
		}
	}

	//Click on Edit List Price All
	public void ClickEditListPrice_Link() {
		WebElement element = null;
		try {
			element = BackEndManageProductPage.getInstance().Catalog_BulkEditProduct_ListPrice(driver);
			Keywords.click(element);
			if (GlobalVar.etpStepsReport) 
			{
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Clicked on List Price Link Button","PASS","Should be Clicked on List Price Link Button");
			} 
			else 
			{
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Not clicked On List Price Link Button","FAIL","Should be Clicked on List Price Link Button");
			}

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Not clicked On List Price Link Button","FAIL", "Should be Clicked on  List Price Link Button");
		}
	}

	//Click on Edit List Price All
	public void ClickEditSellingPrice_Link() {
		WebElement element = null;
		try {
			element = BackEndManageProductPage.getInstance().Catalog_BulkEditProduct_SellingPrice(driver);
			Keywords.click(element);
			if (GlobalVar.etpStepsReport) 
			{
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Clicked on Selling Price Link Button","PASS","Should be Clicked on Selling Price Link Button");
			} 
			else 
			{
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Not clicked On Selling Price Link Button","FAIL","Should be Clicked on Selling Price Link Button");
			}

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Not clicked On Selling Price Link Button","FAIL", "Should be Clicked on Selling Price Link Button");
		}
	}

	//Click on Edit List Price All
	public void ClickOnModifySelected_Link() {
		WebElement element = null;
		try {
			element = BackEndManageProductPage.getInstance().Catalog_BulkEditProduct_ModifySelected(driver);
			Keywords.click(element);
			if (GlobalVar.etpStepsReport) 
			{
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Clicked on Modify Selected Link Button","PASS","Should be Clicked on Modify Selected Link Button");
			} 
			else 
			{
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Not clicked On Modify Selected Link Button","FAIL","Should be Clicked on Modify Selected Link Button");
			}

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Not clicked On Modify Selected Link Button","FAIL", "Should be Clicked on Modify Selected Link Button");
		}
	}


	public void editListPrice() {
		WebElement element = null;
		int count,i;
		float value;
		String val=null;
		try {
			count = BackEndManageProductPage.getInstance()
					.manageProductVendorLinkTable(driver);
			//System.out.println("Table size " + count);
			for(i=2;i<count;i++)
			{
				element = BackEndManageProductPage.getInstance().manageProductVendorLinkListPrice(driver, i);
				val = Keywords.getAttributeVal(element, "value");
				//System.out.println(val);
				value=Float.parseFloat(val) + 1;
				val = String.valueOf(value);
				//System.out.println(val);
				Keywords.clearEditField(element);
				Keywords.typeText(element,val);

				//System.out.println("value : " + value);
			}


			if (GlobalVar.etpStepsReport) {
				DriverSession
				.getLastExecutionReportingInstance()
				.teststepreporting(
						"Search Text typed succefully. :: "
								+ GlobalVar.TEST_DATA
								.get("SearchTextName"),
								"PASS", "Search Text should be entered.");

			} else {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("Search Text not typed.", "FAIL",
						"Search Text should be typed.");

			}
		} catch (Exception e) {
			e.printStackTrace();
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Exception occured : ", "FAIL",
					e.toString());
		}
	}

	//Click on Edit List Price All
	public void ClickOnSaveTable_Link() {
		WebElement element = null;
		try {
			element = BackEndManageProductPage.getInstance().manageProductVendorSaveButton(driver);
			Keywords.click(element);
			if (GlobalVar.etpStepsReport) 
			{
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Clicked on Save Selected Link Button","PASS","Should be Clicked on Modify Selected Link Button");
			} 
			else 
			{
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Not clicked On Save Selected Link Button","FAIL","Should be Clicked on Modify Selected Link Button");
			}

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Not clicked On Save Selected Link Button","FAIL", "Should be Clicked on Modify Selected Link Button");
		}
	}


	// Manage Product Page to click on search Button
	public void CatalogDropdownVendor() {
		WebElement element = null;
		try {
			element = BackEndManageProductPage.getInstance().CatalogDropdown(driver);
			Actions act = new Actions(driver);
			act.moveToElement(element).perform();
			Keywords.explicitWait(5);
			element = BackEndManageProductPage.getInstance().manageProductVendorLink(driver);
			Keywords.click(element);

			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("Clicked on Catalog Button", "PASS",
						"Should be Clicked on Catalog Button");

			} else {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("Not clicked On Catalog Button",
						"FAIL", "Should be Clicked on Catalog Button");
			}

		} catch (Exception e) {
			e.printStackTrace();
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Not clicked On Catalog Button", "FAIL",
					"Should be Clicked on Catalog Button");
		}
	}

	public void verifyAndTypeProductDetails() {
		String RuleNo=null,matchCase=null,keywords=null;

		WebElement searchField=null;
		WebElement dropDown=null;
		WebElement searchIn=null;
		List<String>dropDownValue=null,search_In=null;
		try{

			RuleNo=GlobalVar.TEST_DATA.get("RuleNo");
			matchCase=GlobalVar.TEST_DATA.get("MatchCase");
			keywords=GlobalVar.TEST_DATA.get("Keywords");
			//System.out.println(RuleNo);
			//System.out.println(matchCase);
			//System.out.println(keywords);

			searchField=HomePage.getInstance().clickToSearchPane(driver);
			dropDown=HomePage.getInstance().clickToSelectrule(driver);
			searchIn=HomePage.getInstance().ClickToSearchIn(driver);

			dropDownValue=Keywords.splitRowDataWithPipeOperator(GlobalVar.TEST_DATA.get("DropDownValue"));
			search_In=Keywords.splitRowDataWithPipeOperator(GlobalVar.TEST_DATA.get("SearchIn"));

			if(RuleNo.equalsIgnoreCase(dropDownValue.get(0))){

				//System.out.println("Inside rule 1");
				Keywords.typeText(searchField, keywords);
				Keywords.selectText(dropDown, dropDownValue.get(0));
				Keywords.selectText(searchIn, search_In.get(1));

			}
			//System.out.println(RuleNo);
			//System.out.println(dropDownValue.get(1));

			if(RuleNo.equalsIgnoreCase(dropDownValue.get(1))){
				try{
					//System.out.println("Inside rule 2");
					Keywords.typeText(searchField, keywords);
					Keywords.selectText(dropDown, dropDownValue.get(1));
					Keywords.selectText(searchIn, search_In.get(1));
					Keywords.explicitWait(1);
					//System.out.println("Rule 2 Check 1");
					String split[]=GlobalVar.TEST_DATA.get("Keywords").split(" ");
					WebElement ele1=HomePage.getInstance().clickFirstSearch(driver);
					Keywords.clearEditField(ele1);
					Keywords.typeText(ele1, split[0]);
					//System.out.println("Rule 2 Check 2");
					Keywords.clearEditField(HomePage.getInstance().clickLastField(driver));
					Keywords.typeText(HomePage.getInstance().clickLastField(driver),split[1]);
					Keywords.clearEditField(HomePage.getInstance().clickSpace(driver));
					Keywords.typeText(HomePage.getInstance().clickSpace(driver),GlobalVar.TEST_DATA.get("SpaceCount"));
				}
				catch(Exception e){
					e.printStackTrace();
				}

			}
			if(RuleNo.equalsIgnoreCase(dropDownValue.get(2))){

				//System.out.println("Inside rule 3");
				Keywords.typeText(searchField, keywords);
				Keywords.selectText(dropDown, dropDownValue.get(2));
				Keywords.selectText(searchIn, search_In.get(1));

			}
			if(RuleNo.equalsIgnoreCase(dropDownValue.get(3))){

				//System.out.println("Inside rule 4");
				Keywords.typeText(searchField, keywords);
				Keywords.selectText(dropDown, dropDownValue.get(3));
				Keywords.selectText(searchIn, search_In.get(1));

			}

		}
		catch(Exception e){
			e.getMessage();
		}
	}

	public void clickSubmit() {
		WebElement submit=null;
		try{
			submit=BackEndManageProductPage.getInstance().clickToSubmit(driver);
			Keywords.click(submit);
			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("Clicked Button is clicked successfully ", "PASS",
						"Clicked Button Should be Clicked ");

			} else {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("Clicked Button is not clicked successfully ", "FAIL",
						"Clicked Button Should be Clicked ");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public void validateSearchResults() {
		WebElement product_Header=null;
		List<String>productTabPane=null;
		WebElement search_Results=null;
		try{
			product_Header=BackEndManageProductPage.getInstance().clickProdHeader(driver);
			productTabPane=Keywords.splitRowDataWithPipeOperator(GlobalVar.TEST_DATA.get("ProductTabPane"));
			search_Results=BackEndManageProductPage.getInstance().clickToSearchResult(driver);

			if(product_Header!=null){
				if(product_Header.getText().contains(productTabPane.get(0))){

					if(product_Header.getText().contains(productTabPane.get(1))){

						if(product_Header.getText().contains(productTabPane.get(2))){

							if(product_Header.getText().contains(productTabPane.get(3))&& search_Results.getText().contains(GlobalVar.TEST_DATA.get("Keywords").replace(" ",""))){

								if(search_Results.getText().contains(GlobalVar.TEST_DATA.get("RuleNo"))){


									DriverSession.getLastExecutionReportingInstance()
									.teststepreporting("<b><i><u>"+GlobalVar.TEST_DATA.get("RuleNo")+"</b></i></u><br> is successfully applied with Keywords <b><i><u>"+GlobalVar.TEST_DATA.get("Keywords")+"</b></i></u> " +
											"and Search Product <br><b><i><u>"+GlobalVar.TEST_DATA.get("Keywords")+"</b></i></u><br> with Tabs <br><b><i> : "+productTabPane.get(0)+" - "+BackEndManageProductPage.getInstance().getResult(driver, 1).getText()+"<br>"+productTabPane.get(1)+
											" - "+BackEndManageProductPage.getInstance().getResult(driver, 2).getText()+"<br>"+productTabPane.get(2)+" - "+BackEndManageProductPage.getInstance().getResult(driver, 3).getText()+"<br>"+productTabPane.get(3)+" - "+BackEndManageProductPage.getInstance().getResult(driver, 4).getText()+
											"<br>"+productTabPane.get(4)+" - "+BackEndManageProductPage.getInstance().getResult(driver, 5).getText()+"</i></b> is successfully verified", "PASS",
											"product Tab-Panes Should be successfully verified ");

								}

							}
						}
					}
				}
			}
			else{
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("Search Product Tabs <br><b><i>"+productTabPane.get(0)+"<br>"+productTabPane.get(1)+
						"<br>"+productTabPane.get(2)+"<br>"+productTabPane.get(3)+"" +
						"<br></i></b> is not successfully verified", "FAIL",
						"product Tab-Panes Should be successfully verified ");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public void clickToManageOutletBrand() {
		WebElement clickCatalog=null;
		WebElement factoryOutlet=null;
		WebElement newBrand=null;
		List<String>flowDataSheet=null;
		try{

			clickCatalog=HomePage.getInstance().clickToCatalogOption(driver);
			Keywords.click(clickCatalog);
			Keywords.explicitWait(1);

			factoryOutlet=BackendOutletSelection.getInstance().clickFactoryOutlet(driver);
			Keywords.moveToElementClick(factoryOutlet, driver, 1);
			Keywords.explicitWait(1);

			newBrand=BackendOutletSelection.getInstance().clickNewBrand(driver);
			Keywords.moveToElementClick(newBrand, driver, 1);
			Keywords.moveToElementClick(newBrand, driver, 3);
			flowDataSheet=Keywords.splitRowDataWithPipeOperator(GlobalVar.TEST_DATA.get("Flow"));

			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("<b><i>"+flowDataSheet.get(0)+" ->  "+flowDataSheet.get(1)+" -> "+flowDataSheet.get(2)+"</b></i></u> is Clicked successfully ", "PASS",
						"Page Content Should be Successfully clicked");

			} else {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("<b><i>"+flowDataSheet.get(0)+" ->  "+flowDataSheet.get(1)+" -> "+flowDataSheet.get(2)+"</b></i></u> is Clicked successfully ", "PASS",
						"Page Should be validated Successfully ");
			}

		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public void validatemanageOutletBrandsPage() {
		WebElement pageLogo=null;
		try{
			pageLogo=BackendOutletSelection.getInstance().clickManageLogo(driver);
			Keywords.validateElementExistOrNot(pageLogo);

			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("<b><i><u>"+pageLogo.getText()+"</b></i></u> is validated successfully ", "PASS",
						"Page Should be validated Successfully ");

			} else {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("<b><i><u>"+pageLogo.getText()+"</b></i></u> is not validated successfully ", "FAIL",
						"Page Should be validated Successfully ");
			}

		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public void clickAddNewBrand() {
		WebElement addNewBrand=null;
		try{
			addNewBrand=BackendOutletSelection.getInstance().clickAddNewBrand(driver);
			Keywords.click(addNewBrand);
			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("<b><i><u> AddNewBrand </b></i></u> is clicked successfully ", "PASS",
						"<b><i><u> AddNewBrand </b></i></u> Should be clicked successfully ");

			} else {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("<b><i><u> AddNewBrand </b></i></u> is not clicked successfully ", "FAIL",
						"<b><i><u> AddNewBrand </b></i></u> Should be clicked successfully ");
			}

		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public void validateMandatoryFields() {
		WebElement clickSubmit=null;
		List<String>fieldname=null;
		List<String>alertField=null;
		try{
			clickSubmit=BackendOutletSelection.getInstance().clickSubmitButton(driver);
			Keywords.click(clickSubmit);
			fieldname=Keywords.splitRowDataWithPipeOperator(GlobalVar.TEST_DATA.get("BrandTextFieldName"));
			alertField=Keywords.splitRowDataWithPipeOperator(GlobalVar.TEST_DATA.get("AlertField"));

			if(BackendOutletSelection.getInstance().getField1(driver).getText().equalsIgnoreCase(fieldname.get(0)) && 
					BackendOutletSelection.getInstance().getAlert1(driver).getText().equalsIgnoreCase(alertField.get(0))){


				if(BackendOutletSelection.getInstance().getField2(driver).getText().equalsIgnoreCase(fieldname.get(1)) && 
						BackendOutletSelection.getInstance().getAlert2(driver).getText().equalsIgnoreCase(alertField.get(1))){


					if(BackendOutletSelection.getInstance().getField3(driver).getText().equalsIgnoreCase(fieldname.get(2)) && 
							BackendOutletSelection.getInstance().getAlert3(driver).getText().equalsIgnoreCase(alertField.get(2))){

						if(BackendOutletSelection.getInstance().getField4(driver).getText().equalsIgnoreCase(fieldname.get(3)) && 
								BackendOutletSelection.getInstance().getAlert4(driver).getText().equalsIgnoreCase(alertField.get(3))){


							if(BackendOutletSelection.getInstance().getField5(driver).getText().equalsIgnoreCase(fieldname.get(4)) && 
									BackendOutletSelection.getInstance().getAlert5(driver).getText().equalsIgnoreCase(alertField.get(4))){


								DriverSession.getLastExecutionReportingInstance()
								.teststepreporting("<u>Mandatory Fields Are : </u><br><b><i>"+fieldname.get(0)+" </b></i><br><b><i>"+fieldname.get(1)+"</b></i>" +
										"<br><b><i> "+fieldname.get(2)+"</b></i><br><b><i>"+fieldname.get(3)+"</b></i><br><b><i>"+fieldname.get(4)+"</b></i><br> is validated successfully ", "PASS",
										"Fields Should be validated successfully ");

							}
							else{

								DriverSession.getLastExecutionReportingInstance()
								.teststepreporting("<u>Mandatory Fields Are : </u><br><b><i>"+fieldname.get(0)+" </b></i><br><b><i>"+fieldname.get(1)+"</b></i>" +
										"<br><b><i> "+fieldname.get(2)+"</b></i><br><b><i>"+fieldname.get(3)+"</b></i><br><b><i>"+fieldname.get(4)+"</b></i> is not clicked successfully ", "FAIL",
										"<b><i><u> AddNewBrand </b></i></u> Should be validated successfully ");
							}

						}
					}
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public void enterBrandname() {
		WebElement b_Name=null;
		String rand_Data=null;
		List<String>err_Msg=null;
		try{
			b_Name=BackendOutletSelection.getInstance().ClickB_Name(driver);
			Keywords.clearEditField(b_Name);
			rand_Data=Keywords.getRandomizedString(GlobalVar.TEST_DATA.get("BrandName"), "", "");
			Keywords.typeText(b_Name, rand_Data);
			err_Msg=Keywords.splitRowDataWithPipeOperator(GlobalVar.TEST_DATA.get("ErrorMessage"));

			if(BackendOutletSelection.getInstance().getErrorMsg(driver).getText().equalsIgnoreCase(err_Msg.get(0))){

				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("Brand Name :<br><b><i><u>"+GlobalVar.TEST_DATA.get("BrandName")+"</b></i></u> is Available successfully ", "PASS",
						"BrandName Should be Available Successfully ");
			}

			else if(BackendOutletSelection.getInstance().getErrorMsg(driver).getText().equalsIgnoreCase(err_Msg.get(1))){
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("Brand Name :<br><b><i><u>"+GlobalVar.TEST_DATA.get("BrandName")+"</b></i></u> is not Available successfully ", "FAIL",
						"BrandName Should be Available Successfully ");

			}
		}
		catch(Exception e){
			e.getMessage();
		}
	}

	public void UploadBrandLogoForDeskTop() {
		WebElement browse=null;
		try{
			browse=BackendOutletSelection.getInstance().clickBrowseButton(driver);
			Keywords.click(browse);


			Toolkit toolkit = Toolkit.getDefaultToolkit();
			Clipboard clipboard = toolkit.getSystemClipboard();

			clipboard.setContents(new StringSelection(GlobalVar.TEST_DATA.get("ImagePath")),null);

			Robot robot = new Robot();
			robot.delay(5000);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_V);
			robot.delay(5000);    
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);         
			Thread.sleep(2000);

			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("<b>Brand Logo Image For Desktop <b> is successfully uploaded ", "PASS",
						"Image Should be Successfully Uploaded");

			} else {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("<b>Brand Logo Image For Desktop <b> is not successfully uploaded ", "FAIL",
						"Image Should be Successfully Uploaded");
			}


		}
		catch(Exception e){
			e.getMessage();
		}
	}

	public void UploadbrandLogoForMobile() {
		WebElement smallLogo=null;
		try{
			smallLogo=BackendOutletSelection.getInstance().clickSmallLogo(driver);
			Keywords.click(smallLogo);

			Toolkit toolkit = Toolkit.getDefaultToolkit();
			Clipboard clipboard = toolkit.getSystemClipboard();

			clipboard.setContents(new StringSelection(GlobalVar.TEST_DATA.get("ImagePath")),null);

			Robot robot = new Robot();
			robot.delay(5000);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_V);
			robot.delay(5000);    
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);         
			Thread.sleep(2000);

			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("<b>Brand Logo Image For Mobile <b> is successfully uploaded ", "PASS",
						"Image Should be Successfully Uploaded");

			} else {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("<b>Brand Logo Image For Mobile <b> is not successfully uploaded ", "FAIL",
						"Image Should be Successfully Uploaded");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public void smallDescription() {
		WebElement desc=null;
		try{
			desc=BackendOutletSelection.getInstance().clickDesc(driver);
			Keywords.clearEditField(desc);
			Keywords.typeText(desc, GlobalVar.TEST_DATA.get("Desc"));
			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("<b>Small Description <b><br>"+GlobalVar.TEST_DATA.get("Desc")+"<br> is successfully Entered ", "PASS",
						"Product Description Should be Successfully Entered");

			} else {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("<b>Small Description <b><br>"+GlobalVar.TEST_DATA.get("Desc")+"<br> is not successfully Entered ", "FAIL",
						"Product Description Should be Successfully Entered");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public void brandpriority() {
		WebElement priority=null;
		WebElement submit=null;
		String priorityString=null;
		try{
			priority=BackendOutletSelection.getInstance().clickBrandPriority(driver);
			Keywords.clearEditField(priority);
			priorityString=Keywords.getRandomData();
			//Keywords.typeText(priority, GlobalVar.TEST_DATA.get("BrandPriority"));
			Keywords.typeText(priority, priorityString);
			Keywords.click(BackendOutletSelection.getInstance().clickSubmit(driver));
			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("<b>Priority <b><br>"+GlobalVar.TEST_DATA.get("BrandPriority")+"<br> is successfully Entered ", "PASS",
						"Product Description Should be Successfully Entered");

			} else {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("<b>Priority <b><br>"+GlobalVar.TEST_DATA.get("BrandPriority")+"<br> is not successfully Entered ", "FAIL",
						"Product Description Should be Successfully Entered");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public void clickToFactoryOutletAddNewProduct() {
		WebElement clickCatalog=null;
		WebElement factoryOutlet=null;
		WebElement newBrand=null;
		List<String>flowDataSheet=null;
		try{
			clickCatalog=HomePage.getInstance().clickToCatalogOption(driver);
			Keywords.click(clickCatalog);
			Keywords.explicitWait(1);

			factoryOutlet=BackendOutletSelection.getInstance().clickFactoryOutlet(driver);
			Keywords.moveToElementClick(factoryOutlet, driver, 1);
			Keywords.explicitWait(1);

			newBrand=BackendOutletSelection.getInstance().clickNewProduct(driver);
			Keywords.moveToElementClick(newBrand, driver, 1);
			Keywords.moveToElementClick(newBrand, driver, 3);
			flowDataSheet=Keywords.splitRowDataWithPipeOperator(GlobalVar.TEST_DATA.get("Flow"));

			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("<b><i>"+flowDataSheet.get(0)+" ->  "+flowDataSheet.get(1)+" -> "+flowDataSheet.get(2)+"</b></i></u> is Clicked successfully ", "PASS",
						"Page Content Should be Successfully clicked");

			} else {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("<b><i>"+flowDataSheet.get(0)+" ->  "+flowDataSheet.get(1)+" -> "+flowDataSheet.get(2)+"</b></i></u> is Clicked successfully ", "PASS",
						"Page Should be validated Successfully ");
			}

		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public void verifyFactoryOutletproductpage() {
		WebElement logoType=null;
		try{
			logoType=BackendOutletSelection.getInstance().clickToHomeLogo(driver);
			Keywords.validateElementExistOrNot(logoType);
			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("<b><i> "+logoType.getText()+"</b></i> is validate successfully ", "PASS",
						"<b><i> "+logoType.getText()+"</b></i> Should be Successfully validate");

			} else {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("<b><i> "+logoType.getText()+"</b></i> is not validate successfully ", "FAIL",
						"<b><i> "+logoType.getText()+"</b></i> Should be Successfully validate");
			}

		}
		catch(Exception e){
			e.getMessage();
		}
	}

	public void clickAddNewOutLetProduct() {
		WebElement click=null;
		try{
			click=BackendOutletSelection.getInstance().clickAddNewOutletButton(driver);
			Keywords.click(click);
			Keywords.validateElementExistOrNot(BackendOutletSelection.getInstance().clickToNewprod(driver));

			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("<b><i> New Product </b></i>page is validate successfully ", "PASS",
						"<b><i> New Product Page</b></i> Should be Successfully validate");

			} else {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("<b><i> "+BackendOutletSelection.getInstance().clickToNewprod(driver).getText()+"</b></i> is not validate successfully ", "FAIL",
						"<b><i> "+BackendOutletSelection.getInstance().clickToNewprod(driver).getText()+"</b></i> Should be Successfully validate");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public void verifyNewProductMandatoryFields() {
		WebElement creste=null;
		WebElement prod_Title=null,image=null;
		WebElement catg=null,selling_Price=null,full_Desc=null,status=null,outletBrand=null;
		List<String>mand_Fields=null;
		List<String>f_Name=null,class_N=null;
		try{
			creste=BackendOutletSelection.getInstance().clickToCreate(driver);
			Keywords.click(creste);
			Keywords.closeAlertpopup(driver);
			prod_Title=BackendOutletSelection.getInstance().clickProdTitle(driver);
			catg=BackendOutletSelection.getInstance().clickCategory(driver);
			selling_Price=BackendOutletSelection.getInstance().clickSellingPrice(driver);
			class_N=Keywords.splitRowDataWithPipeOperator(GlobalVar.TEST_DATA.get("className"));
			full_Desc=BackendOutletSelection.getInstance().clickFullDesc(driver);
			status=BackendOutletSelection.getInstance().getStatus(driver);
			outletBrand=BackendOutletSelection.getInstance().clickOuterBrand(driver);
			image=BackendOutletSelection.getInstance().clickToImage(driver);

			mand_Fields=Keywords.splitRowDataWithPipeOperator(GlobalVar.TEST_DATA.get("MandatoryFields"));
			f_Name=Keywords.splitRowDataWithPipeOperator(GlobalVar.TEST_DATA.get("FieldsName"));

			if(prod_Title.getText().trim().contains(mand_Fields.get(0))){

				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("<b><i> "+f_Name.get(0).replace("(?):", "")+" </b></i> is Mandatory Field and successfully validated", "PASS",
						"Mandatory Field Should be Successfully validate");
			}

			if(catg.getText().trim().contains(mand_Fields.get(1))){

				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("<b><i> "+f_Name.get(1).replace("(?):", "")+" </b></i> is Mandatory Field and successfully validated", "PASS",
						"Mandatory Field Should be Successfully validate");
			}


			if(selling_Price.getAttribute("class").trim().contains(class_N.get(1))){

				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("<b><i> "+f_Name.get(2).replace("(?):", "")+" </b></i> is Mandatory Field and successfully validated", "PASS",
						"Mandatory Field Should be Successfully validate");
			}

			if(full_Desc.getText().trim().contains(mand_Fields.get(2))){

				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("<b><i> "+f_Name.get(3).replace("(?):", "")+" </b></i> is Mandatory Field and successfully validated", "PASS",
						"Mandatory Field Should be Successfully validate");
			}

			if(status.getAttribute("class").trim().contains(class_N.get(1))){

				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("<b><i> "+f_Name.get(4).replace("(?):", "")+" </b></i> is Mandatory Field and successfully validated", "PASS",
						"Mandatory Field Should be Successfully validate");
			}

			if(outletBrand.getAttribute("class").trim().contains(class_N.get(1))){

				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("<b><i> "+f_Name.get(5).replace("(?):", "")+" </b></i> is Mandatory Field and successfully validated", "PASS",
						"Mandatory Field Should be Successfully validate");
			}

			if(image.getAttribute("class").trim().contains(class_N.get(1))){

				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("<b><i> "+f_Name.get(6).replace("(?):", "")+" </b></i> is Mandatory Field and successfully validated", "PASS",
						"Mandatory Field Should be Successfully validate");
			}

		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	//// Manage Product Page to click on Manage Outlet Products Button
	public void catalogDropdown_ManageOutletBrand() 
	{
		WebElement element=null;

		try{
			element = BackEndManageProductPage.getInstance().CatalogDropdown(driver);
			Actions act = new Actions(driver);
			act.moveToElement(element).perform();
			Keywords.explicitWait(5);

			element=BackEndManageProductPage.getInstance().Catalog_BulkEditProductSettings_ShopCluesFactoryOutlet(driver);
			Keywords.waitForObject(element);
			Actions builder = new Actions(driver); 
			Actions hoverOverRegistrar = builder.moveToElement(element);
			hoverOverRegistrar.perform();

			element=BackEndManageProductPage.getInstance().Catalog_BulkEditProductSettings_ManageOutletBrand(driver);
			Keywords.click(element);	

			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("Feature Variant clean panel drop down menu clicked successfully", "PASS",
						"Feature Variant clean panel drop down menu should be clicked");

			} else {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("Feature Variant clean panel drop down menu not clicked", "FAIL",
						"Feature Variant clean panel drop down menu should be clicked");

			}
		}catch(Exception e){
			e.printStackTrace();
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Feature Variant clean panel object not found", "FAIL",
					"Feature Variant clean panel drop down menu should be clicked");
		}
	}

	//Click on Edit List Price All
	public void ClickEdit_ProductInformation() {
		WebElement element = null;
		try {
			element = BackEndManageProductPage.getInstance().Catalog_ProductSettings_ManageOutletBrand_Edit(driver);
			Keywords.click(element);
			if (GlobalVar.etpStepsReport) 
			{
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Clicked on Selling Price Link Button","PASS","Should be Clicked on Selling Price Link Button");
			} 
			else 
			{
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Not clicked On Selling Price Link Button","FAIL","Should be Clicked on Selling Price Link Button");
			}

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Not clicked On Selling Price Link Button","FAIL", "Should be Clicked on Selling Price Link Button");
		}
	}

	/** ***************************************************************************************
	 * Keyword-Name:    clickOnProductDescription
	 * Usage:           void clickOnProductDescription()
	 * Description:     Click on given page link
	 * Author:          KAutomators
	 * Dated:           10Apr2015
	 * Notes:   
	 * 
	 *************************************************************************************** **/
	public void editProductDescription() {
		WebElement element = null;

		try 
		{

			element = BackEndManageProductPage.getInstance().Catalog_ProductSettings_ManageOutletBrand_Edit_BrandDescription(driver);
			BackEnd1by1Upload.getInstance().dynamicwait(driver, 20, element);

			Keywords.clearEditField(element);
			Keywords.typeText(element,GlobalVar.TEST_DATA.get("Brand Description"));

			if (GlobalVar.etpStepsReport)
			{
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Clicked on  link","PASS","Should be clicked on link");

			} 
			else 
			{
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting(
						"Not clicked On  link", "FAIL",
						"Should be clicked on  link");
			}

		} catch (Exception e) 
		{
			e.printStackTrace();
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Not clicked On link.","FAIL", "Should be Clicked on  link.");
		}
	}

	/** ***************************************************************************************
	 * Keyword-Name:    editBrandSubmit
	 * Usage:           void editBrandSubmit()
	 * Description:     Click on given page link
	 * Author:          KAutomators
	 * Dated:           10Apr2015
	 * Notes:   
	 * 
	 *************************************************************************************** **/
	public void editBrandSubmit() 
	{
		WebElement element = null;

		try 
		{

			element = BackEndManageProductPage.getInstance().Catalog_ProductSettings_ManageOutletBrand_Submit(driver);
			BackEnd1by1Upload.getInstance().dynamicwait(driver, 20, element);

			Keywords.click(element);

			if (GlobalVar.etpStepsReport)
			{
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Clicked on  link","PASS","Should be clicked on link");

			} 
			else 
			{
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Not clicked On  link", "FAIL",
						"Should be clicked on  link");
			}

		} catch (Exception e) 
		{
			e.printStackTrace();
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Not clicked On link.","FAIL", "Should be Clicked on  link.");
		}
	}

	//// Manage Product Page to click on Manage Outlet Products Button
	public void catalogDropdown_ManageOutletProduct() 
	{
		WebElement element=null;

		try{
			element = BackEndManageProductPage.getInstance().CatalogDropdown(driver);
			Actions act = new Actions(driver);
			act.moveToElement(element).perform();
			Keywords.explicitWait(5);

			element=BackEndManageProductPage.getInstance().Catalog_BulkEditProductSettings_ShopCluesFactoryOutlet(driver);
			Keywords.waitForObject(element);
			Actions builder = new Actions(driver); 
			Actions hoverOverRegistrar = builder.moveToElement(element);
			hoverOverRegistrar.perform();

			element=BackEndManageProductPage.getInstance().Catalog_BulkEditProductSettings_ManageOutletProducts(driver);
			Keywords.click(element);	

			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("Feature Variant clean panel drop down menu clicked successfully", "PASS",
						"Feature Variant clean panel drop down menu should be clicked");

			} else {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("Feature Variant clean panel drop down menu not clicked", "FAIL",
						"Feature Variant clean panel drop down menu should be clicked");

			}
		}catch(Exception e){
			e.printStackTrace();
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Feature Variant clean panel object not found", "FAIL",
					"Feature Variant clean panel drop down menu should be clicked");
		}
	}

	public void enterProductTitle() {
		WebElement prod_Title=null;
		String prod_Name=null;
		try{
			prod_Title=BackendOutletSelection.getInstance().clickToProdTitletextField(driver);
			Keywords.clearEditField(prod_Title);
			prod_Name=Keywords.getRandomizedString(GlobalVar.TEST_DATA.get("ProductTitle"),"","");
			Keywords.typeText(prod_Title, prod_Name);

			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("product Title "+prod_Name+" is successfully Entered ", "PASS",
						"Product Title Should be Entered Successfully");

			} else {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("product Title "+prod_Name+" is not successfully Entered ", "FAIL",
						"Product Title Should be Entered Successfully");

			}
		}
		catch(Exception e){
			e.printStackTrace();
		}

	}

	public void selectSellingPrice() {
		WebElement selling_Price=null;
		try{
			selling_Price=BackendOutletSelection.getInstance().clickSellingPrices(driver);
			Keywords.clearEditField(selling_Price);
			Keywords.typeText(selling_Price, GlobalVar.TEST_DATA.get("SellingPrice"));

			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("Selling Price <b><i>"+GlobalVar.TEST_DATA.get("SellingPrice")+"</b></i> is successfully Entered ", "PASS",
						"Selling Price Should be Entered Successfully");

			} else {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("Selling Price <b><i>"+GlobalVar.TEST_DATA.get("SellingPrice")+"</b></i> is not successfully Entered ", "FAIL",
						"Selling Price Should be Entered Successfully");

			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public void enterFullDescription() {
		WebElement desc=null;
		try{
			desc=BackendOutletSelection.getInstance().typeFullDesc(driver);
			Keywords.click(desc);

			driver.switchTo().frame("product_full_descr_ifr");
			Keywords.typeText(BackendOutletSelection.getInstance().clickField(driver),GlobalVar.TEST_DATA.get("ProdDescription"));
			driver.switchTo().defaultContent();


			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("Full Description <b><i>"+GlobalVar.TEST_DATA.get("ProdDescription")+"</b></i> is successfully Entered ", "PASS",
						"Selling Price Should be Entered Successfully");

			} else {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("Selling Price <b><i>"+GlobalVar.TEST_DATA.get("SellingPrice")+"</b></i> is not successfully Entered ", "FAIL",
						"Selling Price Should be Entered Successfully");

			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public void enterStatus() {
		WebElement status=null;
		List<String>statusDataSheet=null;
		try{
			status=BackendCounterfeitCheckOut.getInstance().clickStatus(driver);
			statusDataSheet=Keywords.splitRowDataWithPipeOperator(GlobalVar.TEST_DATA.get("Status"));
			Keywords.selectByVisibleText(status, statusDataSheet.get(0));


			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("Status <b><i>"+statusDataSheet.get(0)+"</b></i> is successfully Entered ", "PASS",
						"Selling Price Should be Entered Successfully");

			} else {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("Selling Price <b><i>"+statusDataSheet.get(0)+"</b></i> is not successfully Entered ", "FAIL",
						"Selling Price Should be Entered Successfully");

			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public void enterOutLetBrand() {
		WebElement outlet=null;
		try{
			outlet=BackendOutletSelection.getInstance().clickOutlt(driver);
			Keywords.selectByVisibleText(outlet, GlobalVar.TEST_DATA.get("OutletBrand"));
			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("OutLet Brand  <b><i>"+GlobalVar.TEST_DATA.get("OutletBrand")+"</b></i> is successfully Entered ", "PASS",
						"Selling Price Should be Entered Successfully");

			} else {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("Selling Price <b><i>"+GlobalVar.TEST_DATA.get("OutletBrand")+"</b></i> is not successfully Entered ", "FAIL",
						"Selling Price Should be Entered Successfully");

			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public void clickUploadImage() {
		WebElement img=null;
		try{


			driver.findElement(By.id("_local_608714aa73b5ced0b2509ebc3c42edd0")).click();

			Toolkit toolkit = Toolkit.getDefaultToolkit();
			Clipboard clipboard = toolkit.getSystemClipboard();

			clipboard.setContents(new StringSelection(GlobalVar.TEST_DATA.get("ImagePath")),null);

			Robot robot = new Robot();
			robot.delay(5000);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_V);
			robot.delay(5000);    
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);         
			Thread.sleep(2000);

			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("<b>Attach File <b> is successfully uploaded ", "PASS",
						"Image Should be Successfully Uploaded");

			} else {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("<b>Attach File <b> is not successfully uploaded ", "FAIL",
						"Image Should be Successfully Uploaded");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public void clickCreateAndHandelAlert() {
		WebElement create=null;
		try{
			create=BackendOutletSelection.getInstance().clickCreate(driver);
			Keywords.click(create);
			Keywords.explicitWait(1);
			Keywords.closeAlertpopup(driver);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public void nevigateToDesiredPage(String url) {

		try {
			this.driver = GlobalVar.driver;
			this.testData = GlobalVar.TEST_DATA;
			if (!GlobalVar.CURRENT_EXECUTION_MODE.equals("androidWeb"))
				driver.manage().window().maximize();

			//								url = GlobalVar.url + GlobalVar.TEST_DATA.get("Url String");
			System.out.println(url);

			driver.navigate().to(url);
			Thread.sleep(1500);


			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Page Navigated successfully", "PASS",
					"page should be navigated to desired url");
		} catch (Exception e) {

			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("page not navigated", "FAIL",
					"page should be navigated to desired url");
		}
	}

	/** ***************************************************************************************
	 * Keyword-Name:    clickOnAddNewBrand_ManageOutletBrandPage
	 * Usage:           void clickOnAddNewBrand_ManageOutletBrandPage()
	 * Description:    	Click on add new brand link on Merchant Store Setup Page
	 * Author:          Automators
	 * Dated:           26 June 2015
	 * Notes:   
	 * 
	 *************************************************************************************** **/
	public void clickOnAddNewBrand_ManageOutletBrandPage() 
	{
		WebElement element=null;

		try{
			element=BackEndManageProductPage.getInstance().addNewBrand_ManageOutletBrandPage(driver);
			Keywords.waitForObject(element);
			Keywords.click(element);

			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("Add new brand link clicked successfully", "PASS",
						"Add new brand link should be clicked");

			} else {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("Add new brand link not clicked", "FAIL",
						"Add new brand link should be clicked");

			}
		}catch(Exception e){
			e.printStackTrace();
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Add new brand link object not found", "FAIL",
					"Add new brand link should be clicked");
		}
	}

	/** ***************************************************************************************
	 * Keyword-Name:    typeOnBrandName_ManageOutletBrandPage
	 * Usage:           void typeOnBrandName_ManageOutletBrandPage()
	 * Description:    	Type On Brand Name edit box on Merchant Store Setup Page
	 * Author:          Automators
	 * Dated:           26 June 2015
	 * Notes:   
	 * 
	 *************************************************************************************** **/
	public void typeOnBrandName_ManageOutletBrandPage() 
	{
		WebElement element=null;
		String str;
		try{
			element=BackEndManageProductPage.getInstance().brandName_ManageOutletBrandPage(driver);
			Keywords.waitForObject(element);
			str = GlobalVar.TEST_DATA.get("Brand Name") + " " + (Long.toHexString(System.currentTimeMillis()));
			Keywords.typeText(element, str);

			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting(str + " Brand Name typed successfully", "PASS",
						"Brand Name should be Typed");

			} else {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("Brand name not typed", "FAIL",
						"Brand Name should be Typed");

			}
		}catch(Exception e){
			e.printStackTrace();
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Brand name object not found", "FAIL",
					"Brand Name should be Typed");
		}
	}

	/** ***************************************************************************************
	 * Keyword-Name:    typeBrandPriority_ManageOutletBrandPage
	 * Usage:           void typeBrandPriority_ManageOutletBrandPage()
	 * Description:    	Type brand priority on Merchant Store Setup Page
	 * Author:          Automators
	 * Dated:           26 June 2015
	 * Notes:   
	 * 
	 *************************************************************************************** **/
	public void typeBrandPriority_ManageOutletBrandPage() 
	{
		WebElement element=null;

		try{
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("MMddyyyyhhmmssmmm");
			String formattedDate = sdf.format(date);
			System.out.println(formattedDate);

			element=BackEndManageProductPage.getInstance().brandPriority_ManageOutletBrandPage(driver);
			Keywords.waitForObject(element);
			Keywords.typeText(element, formattedDate);

			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting(formattedDate + " Brand Priority typed successfully", "PASS",
						"Brand Priority should be typed");

			} else {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("Brand Priority not typed", "FAIL",
						"Brand Priority should be typed");

			}
		}catch(Exception e){
			e.printStackTrace();
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Brand Priority object not found", "FAIL",
					"Brand Priority should be typed");
		}
	}

	/** ***************************************************************************************
	 * Keyword-Name:    selectMobileLogo_ManageOutletBrandPage
	 * Usage:           void selectMobileLogo_ManageOutletBrandPage()
	 * Description:    	select Mobile Logo on Merchant Store Setup Page
	 * Author:          Automators
	 * Dated:           26 June 2015
	 * Notes:   
	 * 
	 *************************************************************************************** **/
	public void selectMobileLogo_ManageOutletBrandPage() 
	{
		WebElement element=null;

		try{
			element=BackEndManageProductPage.getInstance().mobileLogo_ManageOutletBrandPage(driver);
			Keywords.waitForObject(element);
			Keywords.typeText(element, GlobalVar.TEST_DATA.get("Mobile Logo Path"));

			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting(GlobalVar.TEST_DATA.get("Mobile Logo Path") + " Mobile logo path selected successfully", "PASS",
						"Mobile logo path should be selected");

			} else {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("Mobile logo path not selected", "FAIL",
						"Mobile logo path should be selected");

			}
		}catch(Exception e){
			e.printStackTrace();
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Mobile Logo object not found", "FAIL",
					"Mobile logo path should be selected");
		}
	}


	/** ***************************************************************************************
	 * Keyword-Name:    selectDestopLogo_ManageOutletBrandPage
	 * Usage:           void selectDestopLogo_ManageOutletBrandPage()
	 * Description:    	select Destop Logo on Merchant Store Setup Page
	 * Author:          Automators
	 * Dated:           26 June 2015
	 * Notes:   
	 * 
	 *************************************************************************************** **/
	public void selectDestopLogo_ManageOutletBrandPage() 
	{
		WebElement element=null;

		try{
			element=BackEndManageProductPage.getInstance().destopLogo_ManageOutletBrandPage(driver);
			Keywords.waitForObject(element);
			Keywords.typeText(element, GlobalVar.TEST_DATA.get("Destop Logo Path"));

			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting(GlobalVar.TEST_DATA.get("Destop Logo Path") + " Destop logo path selected successfully", "PASS",
						"Destop logo path should be selected");

			} else {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("Destop logo path not selected", "FAIL",
						"Destop logo path should be selected");

			}
		}catch(Exception e){
			e.printStackTrace();
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Destop Logo object not found", "FAIL",
					"Destop logo path should be selected");
		}
	}
	/** ***************************************************************************************
	 * Keyword-Name:    TypeBrandDesc_ManageOutletBrandPage
	 * Usage:           void TypeBrandDesc_ManageOutletBrandPage()
	 * Description:    	Type brand desc on Merchant Store Setup Page
	 * Author:          Automators
	 * Dated:           26 June 2015
	 * Notes:   
	 * 
	 *************************************************************************************** **/
	public void TypeBrandDesc_ManageOutletBrandPage() 
	{
		WebElement element=null;

		try{
			element=BackEndManageProductPage.getInstance().brandDesc_ManageOutletBrandPage(driver);
			Keywords.waitForObject(element);
			Keywords.typeText(element, GlobalVar.TEST_DATA.get("Brand Desc"));

			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting(GlobalVar.TEST_DATA.get("Brand Desc") + " Brand Desc typed successfully", "PASS",
						"Brand Desc should be typed");

			} else {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("Brand Desc not typed", "FAIL",
						"Brand Desc should be typed");

			}
		}catch(Exception e){
			e.printStackTrace();
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Brand Desc object not found", "FAIL",
					"Brand Desc should be typed");
		}
	}

	/** ***************************************************************************************
	 * Keyword-Name:    clickOnSubmit_ManageOutletBrandPage
	 * Usage:           void clickOnSubmit_ManageOutletBrandPage()
	 * Description:    	Click on submit button on Merchant Store Setup Page
	 * Author:          Automators
	 * Dated:           26 June 2015
	 * Notes:   
	 * 
	 *************************************************************************************** **/
	public void clickOnSubmit_ManageOutletBrandPage() 
	{
		WebElement element=null;

		try{
			element=BackEndManageProductPage.getInstance().submitButton_ManageOutletBrandPage(driver);
			Keywords.waitForObject(element);
			Keywords.click(element);

			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("Submit button clicked successfully", "PASS",
						"Submit button should be clicked");

			} else {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("Submit button not clicked", "FAIL",
						"Submit button should be clicked");

			}
		}catch(Exception e){
			e.printStackTrace();
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Submit button object not found", "FAIL",
					"Submit button should be clicked");
		}
	}

	/** ***************************************************************************************
	 * Keyword-Name:    clickOnStoreSetUpTab_MerchantStoreSetupPage
	 * Usage:           void clickOnStoreSetUpTab_MerchantStoreSetupPage()
	 * Description:    	Click on Store SetUp Tab on Merchant Store Setup Page
	 * Author:          Automators
	 * Dated:           18 June 2015
	 * Notes:   
	 * 
	 *************************************************************************************** **/
	public void clickOnStoreSetUpTab_MerchantStoreSetupPage() 
	{
		WebElement element=null;

		try{
			element=BackEndManageProductPage.getInstance().storeSetUpTab_MerchantStoreSetupPage(driver);
			Keywords.waitForObject(element);
			Keywords.click(element);

			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("Store setup tab clicked successfully", "PASS",
						"Store setup tab should be clicked");

			} else {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("Store setup tab not clicked", "FAIL",
						"Store setup tab should be clicked");

			}
		}catch(Exception e){
			e.printStackTrace();
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Store setup tab object not found", "FAIL",
					"Store setup tab should be clicked");
		}
	}
	/** ***************************************************************************************
	 * Keyword-Name:    GetOnlineStoreText_MerchantStoreSetupPage
	 * Usage:           void GetOnlineStoreText_MerchantStoreSetupPage()
	 * Description:    	Get online store name on Merchant Store Setup Page
	 * Author:          Automators
	 * Dated:           18 June 2015
	 * Notes:   
	 * 
	 *************************************************************************************** **/
	public void GetOnlineStoreText_MerchantStoreSetupPage() 
	{
		WebElement element=null;
		String str;
		try{
			element=BackEndManageProductPage.getInstance().onlineStoreName_MerchantStoreSetupPage(driver);
			Keywords.waitForObject(element);

			str = Keywords.getAttributeVal(element, "value");
			GlobalVar.companyName = str;

			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting(str + " Online Store name fetched successfully", "PASS",
						"Online Store name should be fetched");

			} else {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("Online Store name not fetched", "FAIL",
						"Online Store name should be fetched");

			}
		}catch(Exception e){
			e.printStackTrace();
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Online Store name object not found", "FAIL",
					"Online Store name should be fetched");
		}
	}

	/** ***************************************************************************************
	 * Keyword-Name:    typeOnMicrositeURL_MerchantStoreSetupPage
	 * Usage:           void typeOnMicrositeURL_MerchantStoreSetupPage()
	 * Description:    	Type on microsite url field on Merchant Store Setup Page
	 * Author:          Automators
	 * Dated:           18 June 2015
	 * Notes:   
	 * 
	 *************************************************************************************** **/
	public void typeOnMicrositeURL_MerchantStoreSetupPage() 
	{
		WebElement element=null;
		String str;
		try{
			element=BackEndManageProductPage.getInstance().micrositeURL_MerchantStoreSetupPage(driver);
			Keywords.waitForObject(element);

			str = GlobalVar.companyName;
			Keywords.clearEditField(element);
			Keywords.typeText(element, str);


			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting(str + " Microsite url typed successfully", "PASS",
						"Microsite url should be typed");

			} else {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("Microsite url not typed", "FAIL",
						"Microsite url should be typed");

			}
		}catch(Exception e){
			e.printStackTrace();
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Microsite url object not found", "FAIL",
					"Microsite url should be typed");
		}
	}


	/** ***************************************************************************************
	 * Keyword-Name:    selectAndVerifyFactoryOutletDescription_MerchantStoreSetupPage
	 * Usage:           void selectAndVerifyFactoryOutletDescription_MerchantStoreSetupPage()
	 * Description:    	Select and verify factory outlet description on Merchant Store Setup Page
	 * Author:          Automators
	 * Dated:           18 June 2015
	 * Notes:   
	 * 
	 *************************************************************************************** **/

	public void selectAndVerifyFactoryOutletDescription_MerchantStoreSetupPage() 
	{
		WebElement element=null;
		String periodVal;
		try{
			element=BackEndManageProductPage.getInstance().factoryOutletDescription_MerchantStoreSetupPage(driver);
			Keywords.waitForObject(element);
			Keywords.isElementPresent(element);


			Select se=new Select(element);
			periodVal = GlobalVar.TEST_DATA.get("Factory Outlet Description");
			List<WebElement> list=se.getOptions();

			for(WebElement e1 : list){

				if(e1.getText().equalsIgnoreCase(GlobalVar.TEST_DATA.get("Factory Outlet Description"))){
					Keywords.click(element);
					DriverSession.getLastExecutionReportingInstance()
					.teststepreporting("Factory outlet description drop down value <b>" +e1.getText() +"</b> successfully validated", "PASS",
							"Factory outlet description drop down value should be Validated");
					break;

				}
				else{
					continue;
				}
			}



		}catch(Exception e){
			e.printStackTrace();
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Factory outlet description drop down object not found", "FAIL",
					"Factory outlet description drop down should be selected");
		}
	}


	/** ***************************************************************************************
	 * Keyword-Name:    clickOnSaveAndCloseButton_MerchantStoreSetupPage
	 * Usage:           void clickOnSaveAndCloseButton_MerchantStoreSetupPage()
	 * Description:    	Click on Save and close button on Merchant Store Setup Page
	 * Author:          Automators
	 * Dated:           25 June 2015
	 * Notes:   
	 * 
	 *************************************************************************************** **/
	public void clickOnSaveAndCloseButton_MerchantStoreSetupPage() 
	{
		WebElement element=null;

		try{
			element=BackEndManageProductPage.getInstance().saveAndClose_MerchantStoreSetupPage(driver);
			Keywords.waitForObject(element);
			Keywords.click(element);

			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("Save and close button clicked successfully", "PASS",
						"Save and close button should be clicked");

			} else {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("Save and close button not clicked", "FAIL",
						"Save and close button should be clicked");

			}
		}catch(Exception e){
			e.printStackTrace();
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Save and close button object not found", "FAIL",
					"Save and close button should be clicked");
		}
	}

	public void validateAlertpopup() {
		WebElement popup=null;
		try{
			popup=BackendOutletSelection.getInstance().clickAndValidateField(driver);
			System.out.println(" ***** 3423456 *****"+popup.getText());
			if(popup.getText().contains(GlobalVar.TEST_DATA.get("MessageAlert"))){
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("Message : "+GlobalVar.TEST_DATA.get("MessageAlert")+" successfully validated", "PASS",
						"Message should be successfully validated");
			}
			else{
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("Message : "+GlobalVar.TEST_DATA.get("MessageAlert")+" is not successfully validated", "FAIL",
						"Message should be successfully validated");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	/** ***************************************************************************************
	 * Keyword-Name:    typeOnCustomerID_ManageOutletBrandPage
	 * Usage:           void typeOnCustomerID_ManageOutletBrandPage()
	 * Description:    	Type on customer id on factory oulet manager
	 * Author:          Automators
	 * Dated:           29 June 2015
	 * Notes:   
	 * 
	 *************************************************************************************** **/
	public void typeOnCustomerID_ManageOutletBrandPage() 
	{
		WebElement element=null;

		try{
			element=BackEndManageProductPage.getInstance().companyID_ManageOutletPage(driver);
			Keywords.waitForObject(element);
			Keywords.typeText(element, GlobalVar.TEST_DATA.get("Customer ID"));

			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting(GlobalVar.TEST_DATA.get("Customer ID") + "Customer Id typed successfully", "PASS",
						"Customer Id should be typed");

			} else {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("Customer Id not typed", "FAIL",
						"Customer Id should be typed");

			}
		}catch(Exception e){
			e.printStackTrace();
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Customer Id object not found", "FAIL",
					"Customer Id should be typed");
		}
	}

	/** ***************************************************************************************
	 * Keyword-Name:    clickOnSearchButton_ManageOutletBrandPage
	 * Usage:           void clickOnSearchButton_ManageOutletBrandPage()
	 * Description:    	Click on search button on factory oulet manager
	 * Author:          Automators
	 * Dated:           29 June 2015
	 * Notes:   
	 * 
	 *************************************************************************************** **/
	public void clickOnSearchButton_ManageOutletBrandPage() 
	{
		WebElement element=null;

		try{
			element=BackEndManageProductPage.getInstance().merchantSearchButton_ManageOutletPage(driver);
			Keywords.waitForObject(element);
			Keywords.click(element);

			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("Click on search button successfully", "PASS",
						"Search button should be clicked");

			} else {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("Search button not clicked", "FAIL",
						"Search button should be clicked");

			}
		}catch(Exception e){
			e.printStackTrace();
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Search button object not found", "FAIL",
					"Search button should be clicked");
		}
	}

	/** ***************************************************************************************
	 * Keyword-Name:    verifySearchedCustomerName_ManageOutletBrandPage
	 * Usage:           void verifySearchedCustomerName_ManageOutletBrandPage()
	 * Description:    	Verify searched Customer Name on factory oulet manager
	 * Author:          Automators
	 * Dated:           29 June 2015
	 * Notes:   
	 * 
	 *************************************************************************************** **/
	public void verifySearchedCustomerName_ManageOutletBrandPage() 
	{
		WebElement element=null;
		String str;
		try{
			element=BackEndManageProductPage.getInstance().searchCustomerName_ManageOutletBrandPage(driver);
			Keywords.waitForObject(element);
			str = Keywords.getText(element);

			if (GlobalVar.etpStepsReport && str.contains(GlobalVar.TEST_DATA.get("Customer Name"))) {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("Search customer Name verified successfully", "PASS",
						"Search customer Name should be verified");

			} else {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("Search customer Name not verified", "FAIL",
						"Search customer Name should be verified");

			}
		}catch(Exception e){
			e.printStackTrace();
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Search customer Name object not found", "FAIL",
					"Search customer Name should be verified");
		}
	}

	/** ***************************************************************************************
	 * Keyword-Name:    verifySearchedCustomerId_ManageOutletBrandPage
	 * Usage:           void verifySearchedCustomerId_ManageOutletBrandPage()
	 * Description:    	Verify searched Customer Id on factory oulet manager
	 * Author:          Automators
	 * Dated:           29 June 2015
	 * Notes:   
	 * 
	 *************************************************************************************** **/
	public void verifySearchedCustomerId_ManageOutletBrandPage() 
	{
		WebElement element=null;
		String str;
		try{
			element=BackEndManageProductPage.getInstance().searchCustomerId_ManageOutletBrandPage(driver);
			Keywords.waitForObject(element);
			str = Keywords.getText(element);

			if (GlobalVar.etpStepsReport && str.contains(GlobalVar.TEST_DATA.get("Customer ID"))) {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("Search customer id verified successfully", "PASS",
						"Search customer id should be verified");

			} else {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("Search customer id not verified", "FAIL",
						"Search customer id should be verified");

			}
		}catch(Exception e){
			e.printStackTrace();
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Search customer id object not found", "FAIL",
					"Search customer id should be verified");
		}
	}

	/** ***************************************************************************************
	 * Keyword-Name:    countMerchantPendingApproval_ManageOutletBrandPage
	 * Usage:           void countMerchantPendingApproval_ManageOutletBrandPage()
	 * Description:    	Count Merchant Pending Approval on factory oulet manager
	 * Author:          Automators
	 * Dated:           29 June 2015
	 * Notes:   
	 * 
	 *************************************************************************************** **/
	public void countMerchantPendingApproval_ManageOutletBrandPage() 
	{
		WebElement element=null;
		String count;
		try{
			element=BackEndManageProductPage.getInstance().merchantPendingApprovalCount_ManageOutletPage(driver);
			Keywords.waitForObject(element);
			count = Keywords.getText(element);

			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting(count + " Fetch merchant pending approval count successfully", "PASS",
						"Merchant pending approval count should be fetched");

			} else {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("Merchant pending approval count not fetched", "FAIL",
						"Merchant pending approval count should be fetched");

			}
		}catch(Exception e){
			e.printStackTrace();
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Merchant pending approval object not found", "FAIL",
					"Merchant pending approval count should be fetched");
		}
	}

	/** ***************************************************************************************
	 * Keyword-Name:    countFactoryOutletApprovedMerchants_ManageOutletBrandPage
	 * Usage:           void countFactoryOutletApprovedMerchants_ManageOutletBrandPage()
	 * Description:    	Count Factory Outlet approved Merchant on factory oulet manager
	 * Author:          Automators
	 * Dated:           29 June 2015
	 * Notes:   
	 * 
	 *************************************************************************************** **/
	public void countFactoryOutletApprovedMerchants_ManageOutletBrandPage() 
	{
		WebElement element=null;
		String count;
		try{
			element=BackEndManageProductPage.getInstance().factoryOutletApprovedMerchantsCount_ManageOutletPage(driver);
			Keywords.waitForObject(element);
			count = Keywords.getText(element);

			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting(count + " Fetch Factory Outlet approved Merchant count successfully", "PASS",
						"Factory Outlet approved Merchant count should be fetched");

			} else {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("Factory Outlet approved Merchant count not fetched", "FAIL",
						"Factory Outlet approved Merchant count should be fetched");

			}
		}catch(Exception e){
			e.printStackTrace();
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Factory Outlet approved Merchant object not found", "FAIL",
					"Factory Outlet approved Merchant count should be fetched");
		}
	}

	/** ***************************************************************************************
	 * Keyword-Name:    countFactoryOutletDisapprovedMerchants_ManageOutletBrandPage
	 * Usage:           void countFactoryOutletDisapprovedMerchants_ManageOutletBrandPage()
	 * Description:    	Count Factory Outlet disapproved Merchant on factory oulet manager
	 * Author:          Automators
	 * Dated:           29 June 2015
	 * Notes:   
	 * 
	 *************************************************************************************** **/
	public void countFactoryOutletDisapprovedMerchants_ManageOutletBrandPage() 
	{
		WebElement element=null;
		String count;
		try{
			element=BackEndManageProductPage.getInstance().factoryOutletDisapprovedMerchantsCount_ManageOutletPage(driver);
			Keywords.waitForObject(element);
			count = Keywords.getText(element);

			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting(count + " Fetch Factory Outlet disapproved Merchant count successfully", "PASS",
						"Factory Outlet disapproved Merchant count should be fetched");

			} else {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("Factory Outlet disapproved Merchant count not fetched", "FAIL",
						"Factory Outlet disapproved Merchant count should be fetched");

			}
		}catch(Exception e){
			e.printStackTrace();
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Factory Outlet disapproved Merchant object not found", "FAIL",
					"Factory Outlet disapproved Merchant count should be fetched");
		}
	}

	/** ***************************************************************************************
	 * Keyword-Name:    selectApprovedStatus_ManageOutletBrandPage
	 * Usage:           void selectApprovedStatus_ManageOutletBrandPage()
	 * Description:    	Select approve status on factory oulet manager
	 * Author:          Automators
	 * Dated:           29 June 2015
	 * Notes:   
	 * 
	 *************************************************************************************** **/
	public void selectApprovedStatus_ManageOutletBrandPage() 
	{
		WebElement element=null;

		try{
			element=BackEndManageProductPage.getInstance().approvedStatus_ManageOutletBrandPage(driver);
			Keywords.waitForObject(element);
			Keywords.click(element);

			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("Approved status selected successfully", "PASS",
						"Approve status should be selected");

			} else {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("Approved status not selected", "FAIL",
						"Approve status should be selected");

			}
		}catch(Exception e){
			e.printStackTrace();
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Approved status object not found", "FAIL",
					"Approve status should be selected");
		}
	}

	/** ***************************************************************************************
	 * Keyword-Name:    selectDisapprovedStatus_ManageOutletBrandPage
	 * Usage:           void selectDisapprovedStatus_ManageOutletBrandPage()
	 * Description:    	Select disapprove status on factory oulet manager
	 * Author:          Automators
	 * Dated:           29 June 2015
	 * Notes:   
	 * 
	 *************************************************************************************** **/
	public void selectDisapprovedStatus_ManageOutletBrandPage() 
	{
		WebElement element=null;

		try{
			element=BackEndManageProductPage.getInstance().disapprovedStatus_ManageOutletBrandPage(driver);
			Keywords.waitForObject(element);
			Keywords.click(element);

			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("Disapproved status selected successfully", "PASS",
						"Disapprove status should be selected");

			} else {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("Disapprove status not selected", "FAIL",
						"Disapprove status should be selected");

			}
		}catch(Exception e){
			e.printStackTrace();
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Disapprove status object not found", "FAIL",
					"Disapprove status should be selected");
		}
	}

	/** ***************************************************************************************
	 * Keyword-Name:    clickOnCatalogTab_FactoryOutletRelatedInformationPage
	 * Usage:           void clickOnCatalogTab_FactoryOutletRelatedInformationPage()
	 * Description:    	click On Catalog Tab Factory Outlet Related Information Page
	 * Author:          Automators
	 * Dated:           29 June 2015
	 * Notes:   
	 * 
	 *************************************************************************************** **/
	public void clickOnCatalogTab_FactoryOutletRelatedInformationPage() 
	{
		WebElement element=null;

		try{
			element=BackEndManageProductPage.getInstance().catalogTab_FactoryOutletRelatedInformationPage(driver);
			Keywords.waitForObject(element);
			Keywords.click(element);

			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("Catalog tab clicked successfully", "PASS",
						"Catalog tab should be clicked");

			} else {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("Catalog tab not clicked", "FAIL",
						"Catalog tab should be clicked");

			}
		}catch(Exception e){
			e.printStackTrace();
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Catalog tab object not found", "FAIL",
					"Catalog tab should be clicked");
		}
	}

	/** ***************************************************************************************
	 * Keyword-Name:    verifyDownloadBrandLink_FactoryOutletRelatedInformationPage
	 * Usage:           void verifyDownloadBrandLink_FactoryOutletRelatedInformationPage()
	 * Description:    	verify Download Brand Link on Factory Outlet Related Information Page
	 * Author:          Automators
	 * Dated:           29 June 2015
	 * Notes:   
	 * 
	 *************************************************************************************** **/
	public void verifyDownloadBrandLink_FactoryOutletRelatedInformationPage() 
	{
		WebElement element=null;

		try{
			element=BackEndManageProductPage.getInstance().downloadBrandLink_FactoryOutletRelatedInformationPage(driver);
			Keywords.waitForObject(element);
			Keywords.isElementPresent(element);

			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("Download brand link displayed successfully", "PASS",
						"Download brand link should be displayed");

			} else {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("Download brand link not displayed", "FAIL",
						"Download brand link should be displayed");

			}
		}catch(Exception e){
			e.printStackTrace();
			DriverSession.getLastExecutionReportingInstance()
			.teststepreporting("Download brand link object not found", "FAIL",
					"Download brand link should be displayed");
		}
	}

	public void clickMilkRunReceiving() {
		WebElement fullFilment=null;
		WebElement manageMilkRuns=null;
		WebElement milkrunReceiving=null;
		List<String>flowDataSheet=null;
		try{
			fullFilment=BackendOutletSelection.getInstance().clickToFullFillment(driver);
			Keywords.click(fullFilment);
			Keywords.explicitWait(1);

			manageMilkRuns=BackendOutletSelection.getInstance().clickMangMilkRun(driver);
			Keywords.moveToElementClick(manageMilkRuns, driver, 1);
			Keywords.explicitWait(1);

			milkrunReceiving=BackendOutletSelection.getInstance().clickMilkrunReceiving(driver);
			Keywords.moveToElementClick(milkrunReceiving, driver, 1);
			Keywords.moveToElementClick(milkrunReceiving, driver, 3);
			flowDataSheet=Keywords.splitRowDataWithPipeOperator(GlobalVar.TEST_DATA.get("Flow"));

			if (GlobalVar.etpStepsReport) {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("<b><i>"+flowDataSheet.get(0)+" ->  "+flowDataSheet.get(1)+" -> "+flowDataSheet.get(2)+"</b></i></u> is Clicked successfully ", "PASS",
						"Page Content Should be Successfully clicked");

			} else {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("<b><i>"+flowDataSheet.get(0)+" ->  "+flowDataSheet.get(1)+" -> "+flowDataSheet.get(2)+"</b></i></u> is Clicked successfully ", "PASS",
						"Page Should be validated Successfully ");
			}

		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	/*
	 * new code add by Krishna
	 */
	public void SortProductTable() {
		WebElement element = null;
		WebElement element1 = null;
		String Name2, Name1;
		Integer count, i;
		boolean flag = false;
		try {
			element = BackEndManageProductPage.getInstance().Name_Link(driver);

			count = BackEndManageProductPage.getInstance()
					.CountProductTableSize(driver);
			//System.out.println(count);
			for (i = 2; i < count; i++) {
				element = BackEndManageProductPage.getInstance()
						.ProductNameByRow_EditBox(driver, i);
				Name1 = Keywords.getText(element);
				//System.out.println("Product Name   " + Name1);

				element1 = BackEndManageProductPage.getInstance()
						.ProductNameByRow_EditBox(driver, i + 1);
				//////krishna//////
				/*Name2 = Keywords.getText(element1);
									//System.out.println("Product Name   " + Name2);

									if (Name1.compareTo(Name2) >= 0) {
										flag = true;
									} else if (Name1.compareTo(Name2) <= 0) {
										flag = true;
									}

									else
										break;
									flag = false;*/
				Name2 = Keywords.getText(element1);
				System.out.println("Product Name   " + Name2);
				Name1 = Name1.toLowerCase();
				Name2 = Name2.toLowerCase();

				if (Name1.compareTo(Name2) > 0) {
					flag = false;
					break;
				} else {
					flag = true;
				}
			}

			if (GlobalVar.etpStepsReport && flag == true) {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("Products are in Sorted Order  ",
						"PASS", "Products are in Sorted Order  ");

			} else {
				DriverSession.getLastExecutionReportingInstance()
				.teststepreporting("Products are not in Sorted Order ",
						"FAIL", "Products are not in Sorted Order ");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}						
}


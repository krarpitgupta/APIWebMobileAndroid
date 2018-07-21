/*
 ***************************************************************************************
 * Script-Name:          src/ApplicationComponent/BackEndWebAc.java
 * Description:          Application component file, which consists of various application 
 * components to define end-to-end flow of ShopClues BackEnd| Admin & Vendor Panel
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
import utilities.GlobalVar;
import action.WebBackEndAction;

/*
 ************************************************************************************************
 * Class-Name:    public class BackEndWebAC
 * Description:   Class defined to handle various reusable actions for ShopClues BackEnd Web-Site
 * where
 *
 * Author:        Automators
 * Dated:         09Apr2015
 * Notes:  
 *
 *************************************************************************************************
 */
public class BackEndWebAC implements ApplicationComponent {

	WebDriver driver = null;
	HashMap<String, String> testData = new HashMap<String, String>();
	WebBackEndAction action = new WebBackEndAction(
			DriverSession.getLastExecutionDriver());

	@Override
	public void openApplication() {
		action.openBrowser(GlobalVar.url);

	}

	@Override
	public void closeApplication() {
		action.closeBrowser();

	}

	@Override
	public void validateHomePage() {

	}

	@Override
	public void navigateVerifyProductPage() {

	}

	public void login() {
		try {
			action.typeUserName();
			action.typePassword();
			action.clickOnLoginButton();
			action.verifyValidCredentials();
			action.verifyWelcomePage();
		} catch (Exception e) {
			// e.printStackTrace();
		}

	}

	public void loginForVendor() {
		try {
			String vendorUrl=GlobalVar.vendorUrl;
			vendorUrl=vendorUrl.replaceFirst("buildDeployServer",GlobalVar.serverName); 
			action.openBrowser(vendorUrl);
			action.typeUserName();
			action.typePassword();
			action.clickOnLoginButton();
			action.verifyValidCredentials();
			action.verifyWelcomePage();
		} catch (Exception e) {
			// e.printStackTrace();
		}

	}

	public void loginApplication() {
		try {
			action.typeUserName();
			action.typePassword();
			action.loginButton();
			action.validateHomepage();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void buyNowVerifyCart() throws Exception {

	}

	@Override
	public void verifyCheckoutAddressPage() {

	}

	public void verifySearchProductOnTheBasisOfName() {
		action.clickOnManageProductLink();
		action.typeResultsNameInSearchBox();
		action.typeURL();
		action.typeCode();
		action.selectStatus();
		action.selectMerchant();
		action.selectCategories();
		action.clickOnSearchButton();
		action.verifyCheckAllCheckBox();
		action.verifySearchStringinTable();
	}

	public void verifySearchProductOnTheBasisOfStatus() {
		action.clickOnManageProductLink();
		action.typeResultsNameInSearchBox();
		action.typeURL();
		action.typeCode();
		action.selectStatus();
		action.selectMerchant();
		action.selectCategories();
		action.clickOnSearchButton();
		action.verifyCheckAllCheckBox();
		action.verifySearchStringinTable();
	}

	public void verifyProductOnTheBasisOfFuzzySearch() {
		action.clickOnManageProductLink();
		action.typeResultsNameInSearchBox();
		action.typeURL();
		action.typeCode();
		action.selectStatus();
		action.selectMerchant();
		action.selectCategories();
		action.clickOnSearchButton();
		action.verifyCheckAllCheckBox();
		action.verifySearchStringinTable();
	}

	public void verifyProductOnTheBasisOfMerchant() {
		action.clickOnManageProductLink();
		action.typeResultsNameInSearchBox();
		action.typeURL();
		action.typeCode();
		action.selectStatus();
		action.selectMerchant();
		action.selectCategories();
		action.clickOnSearchButton();
		action.verifyHiglightedColor();
		action.verifyMerchantDropDown();

	}

	public void ChangeStatusDropDownValue() {
		try {
			action.selectStatusDropdownValue();
			action.verifyTextOnPage("Status has been changed");
		} catch (Exception e) {
			// e.printStackTrace();
		}

	}

	public void EditableStatusDropDownValue() {
		try {
			action.selectStatusDropdownValue();
		} catch (Exception e) {
			// e.printStackTrace();
		}

	}

	public void CountStatusDropDownValues() {
		try {
			action.countStatusDropdownValue();
			Thread.sleep(5000);
		} catch (Exception e) {
			// e.printStackTrace();
		}

	}

	public void VerifyStatusFieldForProducts() {
		try {
			action.VerifyStatusDropDownInProductTable();
			Thread.sleep(5000);
		} catch (Exception e) {
			// e.printStackTrace();
		}

	}

	public void VerifyAdvanceSearchPage() {
		try {
			System.out.println("last driver is "
					+ DriverSession.getLastExecutionDriver());
			action.CatalogDropdown();
			action.ClickAdvanceSearchIcon();
			Thread.sleep(5000);
			action.VerifyAdvanceSearchButton();

		} catch (Exception e) {
			// e.printStackTrace();
		}

	}

	public void verifySearchKeywordRedirection() {
		try {
			action.clickCatalogPane();
			action.verifyKeywordTypeDropDown();
			action.verifySearchConditionDropDown();
			action.verifyStatusAndSubStatus();
			action.verifyTextFields();
			action.validateAndSearchProduct();
			action.validateSearchField();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyAddNewFeatureFunctionality() {
		try {
			action.clickProductFeature();
			action.addFeature();
			action.verifyMandatoryFields();
			action.enterNameFields();
			action.enterTypeField();
			action.entergroupField();
			action.clickToCreate();
			action.verifyAddFeaturename();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyAddNewFeatureGroupFunctionality() {

		try {
			action.clickProductFeature();
			action.clickAddFeaturegroupAndVerifyPopup();
			action.verifyAddNewgroupMandatoryField();
			action.enterNameField();
			action.selectCatagory();
			action.verifyAddFeatureGroup();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyCounterfeitSearchPanel1Functionality() {

		try {
			action.clickAndValidateCounterfeitSearchPanel1();
			action.verifyContentsInSideCounterfeitproductTool();
			action.verifyAndTypeProductDetails();
			action.selectByCatagory();
			action.selectFashionEyeWear();
			action.clickSubmit();
			action.validateSearchResults();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyCounterfeitSearchPanel2Functionality() {
		try {
			action.clickAndValidateCounterfeitSearchPanel2();
			action.validateInstructionToUseThispannel();
			action.validateCriteriaType();
			action.selectByCatagory();
			action.selectFashionEyeWear();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyCounterfeitManagePanelFunctionality() {
		try {
			action.clickManagCounterfeitProducts();
			action.validateManageCounterfeitProducts();
			action.validatemandatoryFields();
			action.enterProductIdAndValidate();

		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void VerifyAdvanceSearchBySalesAmount() {
		try {
			action.CatalogDropdown();
			action.ClickAdvanceSearchIcon();
			Thread.sleep(5000);
			action.VerifyAdvanceSearchButton();
			action.TypeOnSalesAmountFrom();
			action.TypeOnSalesAmountTo();
			action.ClickAdvanceSearch();
			action.VerifyProductTableItems();

		} catch (Exception e) {
			// e.printStackTrace();
		}

	}

	public void VerifyAdvanceSearchByPeriod() {
		try {
			action.CatalogDropdown();
			action.ClickAdvanceSearchIcon();
			Thread.sleep(5000);
			action.VerifyAdvanceSearchButton();
			action.Period();
			action.ClickAdvanceSearch();
			action.VerifyProductTableItems();

		} catch (Exception e) {
			// e.printStackTrace();
		}

	}

	// @Override
	// Manage Product Search
	public void SearchProduct() {
		try {

			action.CatalogDropdown();
			action.TypeTextOnSearch_Name();
			action.ClickSearch();
			action.ClickName_Link();

		} catch (Exception e) {
			// e.printStackTrace();
		}

	}

	// Manage Product Delete
	public void DeleteProduct() {
		try {
			System.out.println("last driver is "
					+ DriverSession.getLastExecutionDriver());
			action.deleteProductLink();

		} catch (Exception e) {
			// e.printStackTrace();
		}

	}

	// Sort Product column
	public void SortProductColumn() {
		try {
			System.out.println("last driver is "
					+ DriverSession.getLastExecutionDriver());
			action.SortProductTable();
		} catch (Exception e) {
			// e.printStackTrace();
		}
	}

	// BackEnd View All
	public void ViewAll() {
		try {
			System.out.println("last driver is "
					+ DriverSession.getLastExecutionDriver());
			action.CatalogDropdown();
			action.verifyViewAllButton();

		} catch (Exception e) {
			// e.printStackTrace();
		}
	}

	// /Verify Product Table
	public void VerifyProductTable() {
		try {
			System.out.println("last driver is "
					+ DriverSession.getLastExecutionDriver());
			action.CatalogDropdown();
			action.verifyViewAllButton();
			action.ViewAllClick();
			action.VerifyProductTableItems();

		} catch (Exception e) {
			// e.printStackTrace();
		}
	}

	// /GoToPage
	public void GoToPage() {
		try {
			System.out.println("last driver is "
					+ DriverSession.getLastExecutionDriver());
			action.CatalogDropdown();
			action.verifyViewAllButton();
			action.ViewAllClick();
			action.GotoPage();
			action.VerifyProductTableItems();
		} catch (Exception e) {
			// e.printStackTrace();
		}
	}

	public void verifySortProductForVendor() {
		action.clickOnManageProductLinkForVendor();
		action.typeResultsNameInSearchBox();
		action.clickOnSearchButton();
		action.verifyHeaderForVendor();

	}

	public void verifySearchForVendor() {
		action.clickOnManageProductLinkForVendor();
		action.typeResultsNameInSearchBox();
		action.typeURL();
		action.typeCode();
		action.selectStatus();
		action.selectMerchant();
		action.selectCategories();
		action.clickOnSearchButton();
		action.verifyHiglightedColor();
		// action.verifyMerchantDropDown();

	}

	public void verifyDeleteProductForVendor() {
		action.clickOnManageProductLinkForVendor();
		action.typeResultsNameInSearchBox();
		action.clickOnSearchButton();
		action.verifyDeleteLinkForVendor();
		action.deleteProductLink();

	}

	public void addNewOutletBrandSelection() {
		try {
			action.clickToManageOutletBrand();
			action.validatemanageOutletBrandsPage();
			action.clickAddNewBrand();
			action.validateMandatoryFields();
			action.enterBrandname();
			action.UploadBrandLogoForDeskTop();
			action.UploadbrandLogoForMobile();
			action.smallDescription();
			action.brandpriority();
			action.validateAlertpopup();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addNewOutletProductSelection() {

		try {
			action.clickToFactoryOutletAddNewProduct();
			action.verifyFactoryOutletproductpage();
			action.clickAddNewOutLetProduct();
			action.verifyNewProductMandatoryFields();
			action.enterProductTitle();
			action.selectByCatagory();
			action.selectFashionEyeWear();
			action.selectSellingPrice();
			action.enterFullDescription();
			action.enterStatus();
			action.enterOutLetBrand();
			action.clickUploadImage();
			action.clickCreateAndHandelAlert();
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyViewAllForVendor() {
		action.clickOnManageProductLinkForVendor();
		action.verifyViewAllButton();
	}

	public void EditFields() {
		String colName1, colValue1, colName2, colValue2, colName3, colValue3, colName4, colValue4, colName5, colValue5;
		try {
			System.out.println("last driver is "
					+ DriverSession.getLastExecutionDriver());
			
			/*
			 *  Element not Found
			 */
			//action.clickNameHeader();
			colValue1 = GlobalVar.TEST_DATA.get("Column Value1");
			colName1 = GlobalVar.TEST_DATA.get("Column Name1");

			action.editProductTableColumn(colName1, colValue1);
			colValue2 = GlobalVar.TEST_DATA.get("Column Value2");
			colName2 = GlobalVar.TEST_DATA.get("Column Name2");

			action.editProductTableColumn(colName2, colValue2);
			colValue3 = GlobalVar.TEST_DATA.get("Column Value3");
			colName3 = GlobalVar.TEST_DATA.get("Column Name3");

			action.editProductTableColumn(colName3, colValue3);
			colValue4 = GlobalVar.TEST_DATA.get("Column Value4");
			colName4 = GlobalVar.TEST_DATA.get("Column Name4");

			action.editProductTableColumn(colName4, colValue4);
			colValue5 = GlobalVar.TEST_DATA.get("Column Value5");
			colName5 = GlobalVar.TEST_DATA.get("Column Name5");

			action.editProductTableColumn(colName5, colValue5);
		} catch (Exception e) {
			// e.printStackTrace();
		}

	}

	// 02/04/2015

	public void verifyHighlightedRow() {
		try {
			System.out.println("last driver is "
					+ DriverSession.getLastExecutionDriver());
			action.selectProductRow();
		} catch (Exception e) {
			// e.printStackTrace();
		}

	}

	/**
	 * *************************************************************************
	 * ************** Keyword-Name: verifyCategoryButton Usage: void
	 * verifyCategoryButton() Description: category button on category pop up
	 * window Author: Automators Dated: 06Apr2015 Notes:
	 * 
	 *************************************************************************************** **/
	public void verifyCategoryButton() {

		try {
			System.out.println("last driver is "
					+ DriverSession.getLastExecutionDriver());
			action.CatalogDropdown();
			action.click1by1UploadButton();
			action.verifyCategoryLinkVisible();
		} catch (Exception e) {
			// e.printStackTrace();
		}

	}

	/**
	 * *************************************************************************
	 * ************** Keyword-Name: verifyCategoryPopUp Usage: void
	 * verifyCategoryPopUp() Description: Category pop up window Author: Arvind
	 * Katheriya Dated: 06Apr2015 Notes:
	 * 
	 *************************************************************************************** **/
	public void verifyCategoryPopUp() {

		try {
			System.out.println("last driver is "
					+ DriverSession.getLastExecutionDriver());
			action.CatalogDropdown();
			action.click1by1UploadButton();
			action.clickCategoryLink();
			action.verifyCategoryPopUp();
		} catch (Exception e) {
			// e.printStackTrace();
		}

	}

	/**
	 * *************************************************************************
	 * ************** Keyword-Name: verifyCategoryPopUpButtons Usage: void
	 * verifyCategoryPopUpButtons() Description: Category pop up window Author:
	 * Automators Dated: 06Apr2015 Notes:
	 * 
	 *************************************************************************************** **/
	public void verifyCategoryPopUpButtons() {

		try {
			System.out.println("last driver is "
					+ DriverSession.getLastExecutionDriver());
			action.CatalogDropdown();
			action.click1by1UploadButton();
			action.clickCategoryLink();
			action.verifyCategoryPopUp();
			action.verifyCategoryPopUp_CategoryButton();
			action.verifyCategoryPopUp_CancelLink();
		} catch (Exception e) {
			// e.printStackTrace();
		}

	}

	/**
	 * *************************************************************************
	 * ************** Keyword-Name: verifyCategoryCancelLink Usage: void
	 * verifyCategoryCancelLink() Description: Category pop up window Author:
	 * Automators Dated: 06Apr2015 Notes:
	 * 
	 *************************************************************************************** **/
	public void verifyCategoryCancelLink() {

		try {
			System.out.println("last driver is "
					+ DriverSession.getLastExecutionDriver());
			action.CatalogDropdown();
			action.click1by1UploadButton();
			action.clickCategoryLink();
			action.clickCancelLink();
			action.verifyCategoryPopUp_Negative();
		} catch (Exception e) {
			// e.printStackTrace();
		}

	}

	/**
	 * *************************************************************************
	 * ************** Keyword-Name: verifyCategoryPopUpError Usage: void
	 * verifyCategoryPopUpError() Description: Category pop up window Author:
	 * Automators Dated: 06Apr2015 Notes:
	 * 
	 *************************************************************************************** **/
	public void verifyCategoryPopUpError() {
		String errMsg;
		try {
			System.out.println("last driver is "
					+ DriverSession.getLastExecutionDriver());
			action.CatalogDropdown();
			action.click1by1UploadButton();
			action.clickCategoryLink();
			action.clickAddCategoriesAndCloseButton();
			errMsg = GlobalVar.TEST_DATA.get("PopUp Error");
			action.verifyTextOnPage(errMsg);
			action.pressEnter();
			action.clickCategoryButton();
			action.verifyTextOnPage(errMsg);
			action.pressEnter();
		} catch (Exception e) {
			// e.printStackTrace();
		}

	}

	/**
	 * *************************************************************************
	 * ************** Keyword-Name: verifyCategoriesInCategoryPopUp Usage: void
	 * verifyCategoriesInCategoryPopUp() Description: Categories count in
	 * Category pop up window Author: Automators Dated: 06Apr2015 Notes:
	 * 
	 *************************************************************************************** **/
	public void verifyCategoriesInCategoryPopUp() {
		try {
			System.out.println("last driver is "
					+ DriverSession.getLastExecutionDriver());
			action.CatalogDropdown();
			action.click1by1UploadButton();
			action.clickCategoryLink();
			action.getCountOfCategoryPopUp();
		} catch (Exception e) {
			// e.printStackTrace();
		}

	}

	/**
	 * *************************************************************************
	 * ************** Keyword-Name: selectCategoryFromCategoryPopUp Usage: void
	 * selectCategoryFromCategoryPopUp() Description: Select Category From pop
	 * up window(By click on Add Categories And Close Button) Author: Arvind
	 * Katheriya Dated: 07Apr2015 Notes:
	 * 
	 *************************************************************************************** **/
	public void selectCategoryFromCategoryPopUp() {
		String mess;
		try {
			System.out.println("last driver is "
					+ DriverSession.getLastExecutionDriver());
			action.CatalogDropdown();
			action.click1by1UploadButton();
			action.clickCategoryLink();
			action.selectCategoryByName();
			action.clickAddCategoriesAndCloseButton();
			mess = GlobalVar.TEST_DATA.get("Message");
			action.verifyTextOnPage(mess);
			action.verifyAndSelectAddedCategory();
		} catch (Exception e) {
			// e.printStackTrace();
		}

	}

	/**
	 * *************************************************************************
	 * ************** Keyword-Name: selectByCategoryButton Usage: void
	 * selectByCategoryButton() Description: Select Category From pop up
	 * window(By click on Category Button) Author: Automators Dated:
	 * 07Apr2015 Notes:
	 * 
	 *************************************************************************************** **/
	public void selectByCategoryButton() {
		String mess;
		try {
			System.out.println("last driver is "
					+ DriverSession.getLastExecutionDriver());
			action.CatalogDropdown();
			action.click1by1UploadButton();
			action.clickCategoryLink();
			action.selectCategoryByName();
			action.clickCategoryButton();
			action.clickCancelLink();
			mess = GlobalVar.TEST_DATA.get("Message");
			action.verifyTextOnPage(mess);
			action.verifyAndSelectAddedCategory();
		} catch (Exception e) {
			// e.printStackTrace();
		}

	}

	/**
	 * *************************************************************************
	 * ************** Keyword-Name: selectByCategoryButton Usage: void
	 * selectByCategoryButton() Description: Select Category From pop up
	 * window(By click on Category Button) Author: Automators Dated:
	 * 07Apr2015 Notes:
	 * 
	 *************************************************************************************** **/
	public void verifyAddCategoryCancel() {
		try {
			System.out.println("last driver is "
					+ DriverSession.getLastExecutionDriver());
			action.CatalogDropdown();
			action.click1by1UploadButton();
			action.clickCategoryLink();
			action.selectCategoryByName();
			action.clickCancelLink();
			action.verifyAndSelectAddedCategory_Negative();
		} catch (Exception e) {
			// e.printStackTrace();
		}

	}

	/**
	 * *************************************************************************
	 * ************** Keyword-Name: selectCategoryFromCategoryPopUp Usage: void
	 * selectCategoryFromCategoryPopUp() Description: Select Category From pop
	 * up window(By click on Add Categories And Close Button) Author: Arvind
	 * Katheriya Dated: 07Apr2015 Notes:
	 * 
	 *************************************************************************************** **/
	public void deleteAddedCategory() {
		String mess;
		try {
			System.out.println("last driver is "
					+ DriverSession.getLastExecutionDriver());
			action.CatalogDropdown();
			action.click1by1UploadButton();
			action.clickCategoryLink();
			action.selectCategoryByName();
			action.clickAddCategoriesAndCloseButton();
			mess = GlobalVar.TEST_DATA.get("Message");
			action.verifyTextOnPage(mess);
			action.deleteAddCategory();
			action.verifyAndSelectAddedCategory_Negative();
		} catch (Exception e) {
			// e.printStackTrace();
		}

	}

	/**
	 * *************************************************************************
	 * ************** Keyword-Name: addAllCategories Usage: void
	 * addAllCategories() Description: Add all categories to new product page
	 * Author: Automators Dated: 07Apr2015 Notes:
	 * 
	 *************************************************************************************** **/
	public void addAllCategories() {
		String mess;
		try {
			System.out.println("last driver is "
					+ DriverSession.getLastExecutionDriver());
			action.CatalogDropdown();
			action.click1by1UploadButton();
			action.clickCategoryLink();
			action.clickOnCheckAll();
			action.clickAddCategoriesAndCloseButton();
			mess = GlobalVar.TEST_DATA.get("Message");
			action.verifyTextOnPage(mess);
			action.verifyCategoriesAddedToNewProduct();
		} catch (Exception e) {
			// e.printStackTrace();
		}

	}

	/**
	 * *************************************************************************
	 * ************** Keyword-Name: verifyAddCategoryProduct Usage: void
	 * verifyAddCategoryProduct() Description: Verify added product category
	 * Author: Automators Dated: 08Apr2015 Notes:
	 * 
	 *************************************************************************************** **/
	public void verifyAddCategoryProduct() {
		try {
			System.out.println("last driver is "
					+ DriverSession.getLastExecutionDriver());
			action.CatalogDropdown();
			action.TypeTextOnSearch_Name();
			action.clickOnSearchInCategory();
			action.selectCategoryByName();
			action.clickAddCategoriesAndCloseButton();
			action.ClickSearch();
			action.VerifyProductTableItems();
		} catch (Exception e) {
			// e.printStackTrace();
		}

	}

	/**
	 * *************************************************************************
	 * ************** Keyword-Name: verifyNewProductActionButton Usage: void
	 * verifyNewProductActionButton() Description: Verify new product action
	 * button Author: Automators Dated: 08Apr2015 Notes:
	 * 
	 *************************************************************************************** **/
	public void verifyNewProductActionButton() {

		try {
			System.out.println("last driver is "
					+ DriverSession.getLastExecutionDriver());
			action.CatalogDropdown();
			action.click1by1UploadButton();
			action.verifyCreateButton();
			action.verifyCreateAndCloseButton();
			action.verifyCancelButton();

		} catch (Exception e) {
			// e.printStackTrace();
		}

	}

	/**
	 * *************************************************************************
	 * ************** Keyword-Name: verifyCancelButtonFuctionality Usage: void
	 * verifyCancelButtonFuctionality() Description: Verify new product action
	 * button Author: Automators Dated: 08Apr2015 Notes:
	 * 
	 *************************************************************************************** **/
	public void verifyCancelButtonFuctionality() {

		try {
			System.out.println("last driver is "
					+ DriverSession.getLastExecutionDriver());
			action.CatalogDropdown();
			action.click1by1UploadButton();
			action.NewProductclickCancel();
			action.verifyOneBy1UploadButton();

		} catch (Exception e) {
			// e.printStackTrace();
		}

	}

	/**
	 * *************************************************************************
	 * ************** Keyword-Name: fillNewProductMandatoryFields Usage: void
	 * fillNewProductMandatoryFields() Description: Fill new product mandatory
	 * fields Author: Automators Dated: 08Apr2015 Notes:
	 * 
	 *************************************************************************************** **/
	public void fillNewProductMandatoryFields() {

		try {
			System.out.println("last driver is "
					+ DriverSession.getLastExecutionDriver());
			action.CatalogDropdown();
			action.click1by1UploadButton();
			action.NewProduct_ProductTitle();
			action.clickCategoryLink();
			action.selectCategoryByName();
			action.clickAddCategoriesAndCloseButton();
			action.NewProduct_EnterSellingPrice();
			action.NewProduct_EnterFullDescription();
			action.NewProduct_AttachImage();
		} catch (Exception e) {
			// e.printStackTrace();
		}

	}

	/**
	 * *************************************************************************
	 * ************** Keyword-Name: addNPByClickOnCreate Usage: void
	 * addNPByClickOnCreate() Description: add new product Author: Arvind
	 * Katheriya Dated: 08Apr2015 Notes:
	 * 
	 *************************************************************************************** **/
	public void addNPByClickOnCreate() {

		try {
			System.out.println("last driver is "
					+ DriverSession.getLastExecutionDriver());
			action.CatalogDropdown();
			action.click1by1UploadButton();
			action.NewProduct_ProductTitle();
			action.clickCategoryLink();
			action.selectCategoryByName();
			action.clickAddCategoriesAndCloseButton();
			action.verifyAndSelectAddedCategory();
			action.NewProduct_EnterSellingPrice();
			action.NewProduct_EnterFullDescription();
			action.NewProduct_AttachImage();
			action.NewProductclickCreate();
			action.verifyNewProductAddMessage();
		} catch (Exception e) {
			// e.printStackTrace();
		}

	}

	/**
	 * *************************************************************************
	 * ************** Keyword-Name: addNPByClickOnCreateAndClose Usage: void
	 * addNPByClickOnCreateAndClose() Description: Add new product Author:
	 * Automators Dated: 10Apr2015 Notes:
	 * 
	 *************************************************************************************** **/
	public void addNPByClickOnCreateAndClose() {

		try {
			System.out.println("last driver is "
					+ DriverSession.getLastExecutionDriver());
			action.CatalogDropdown();
			action.click1by1UploadButton();
			action.NewProduct_ProductTitle();
			action.clickCategoryLink();
			action.selectCategoryByName();
			action.clickAddCategoriesAndCloseButton();
			action.verifyAndSelectAddedCategory();
			action.NewProduct_EnterSellingPrice();
			action.NewProduct_EnterFullDescription();
			action.NewProduct_AttachImage();
			action.NewProductclickCreateAndClose();
			// action.verifyNewProductAddMessage();
			action.verifyOneBy1UploadButton();
		} catch (Exception e) {
			// e.printStackTrace();
		}

	}

	/**
	 * *************************************************************************
	 * ************** Keyword-Name: paginationVendor Usage: void
	 * paginationVendor() Description: Vendor page pagination Author: Arvind
	 * Katheriya Dated: 08Apr2015 Notes:
	 * 
	 *************************************************************************************** **/
	public void paginationVendor() {
		String str;
		int no;
		try {
			System.out.println("last driver is "
					+ DriverSession.getLastExecutionDriver());
			action.clickOnManageProductLinkForVendor();
			action.clickOnViewAllButtonForVendor();
			action.clickOnGivenPageNoLinkForVendor();
			str = GlobalVar.TEST_DATA.get("Page Number");
			action.getAndVerifyGoToPageValue(str);
			action.clickOnNextPageLinkForVendor();
			no = Integer.parseInt(str);
			no = no + 1;
			str = Integer.toString(no);
			action.getAndVerifyGoToPageValue(str);
			action.clickOnPreviousPageLinkForVendor();
			no = Integer.parseInt(str);
			no = no - 1;
			str = Integer.toString(no);
			action.getAndVerifyGoToPageValue(str);
		} catch (Exception e) {
			// e.printStackTrace();
		}

	}

	/**
	 * *************************************************************************
	 * ************** Keyword-Name: verifyAdvanceSearch Usage: void
	 * verifyAdvanceSearch() Description: Verify advance search fuctionality
	 * Author: Automators Dated: 10Apr2015 Notes:
	 * 
	 *************************************************************************************** **/
	public void verifyVendorAdvanceSearch() {
		try {
			System.out.println("last driver is "
					+ DriverSession.getLastExecutionDriver());
			action.clickOnManageProductLinkForVendor();
			action.ClickAdvanceSearchIcon();
			Thread.sleep(5000);
			action.VerifyAdvanceSearchButton();
			action.Period();
			action.ClickAdvanceSearch();
			action.VerifyProductTableItems();
		}

		catch (Exception e) {
			// e.printStackTrace();
		}

	}

	/**
	 * *************************************************************************
	 * ************** Keyword-Name: verifyVendorStatusChange Usage: void
	 * verifyVendorStatusChange() Description: Verify status change fuctionality
	 * Author: Automators Dated: 10Apr2015 Notes:
	 * 
	 *************************************************************************************** **/
	public void verifyVendorStatusChange() {
		try {
			System.out.println("last driver is "
					+ DriverSession.getLastExecutionDriver());
			action.clickOnManageProductLinkForVendor();
			action.TypeTextOnSearch_Name();
			action.ClickSearch();
			// action.VerifyStatusDropDownInProductTable();
			action.selectStatusDropdownValue();
			action.countStatusDropdownValue();
		}

		catch (Exception e) {
			// e.printStackTrace();
		}

	}

	/**
	 * *************************************************************************
	 * ************** Keyword-Name: verifyVendorEditFields Usage: void
	 * verifyVendorEditFields() Description: Verify status change fuctionality
	 * Author: Automators Dated: 10Apr2015 Notes:
	 * 
	 *************************************************************************************** **/
	public void verifyVendorEditFields() {
		String colName1, colValue1, colName2, colValue2, colName3, colValue3;
		try {
			System.out.println("last driver is "
					+ DriverSession.getLastExecutionDriver());
			action.clickOnManageProductLinkForVendor();
			action.TypeTextOnSearch_Name();
			action.ClickSearch();
			action.verifyHiglightedColor();

			colValue1 = GlobalVar.TEST_DATA.get("Column Value1");
			colName1 = GlobalVar.TEST_DATA.get("Column Name1");

			action.editProductTableColumn(colName1, colValue1);

			colValue2 = GlobalVar.TEST_DATA.get("Column Value2");
			colName2 = GlobalVar.TEST_DATA.get("Column Name2");

			action.editProductTableColumn(colName2, colValue2);

			colValue3 = GlobalVar.TEST_DATA.get("Column Value3");
			colName3 = GlobalVar.TEST_DATA.get("Column Name3");

			action.editProductTableColumn(colName3, colValue3);

			action.clickSave();
			action.verifyEditColumn(colName1, colValue1);
			action.verifyEditColumn(colName2, colValue2);
			action.verifyEditColumn(colName3, colValue3);

		}

		catch (Exception e) {
			// e.printStackTrace();
		}

	}

	/**
	 * *************************************************************************
	 * ************** Keyword-Name: verifyAdminBulkProductEdit Usage: void
	 * verifyAdminBulkProductEdit() Description: Category pop up window Author:
	 * KAutomators Dated: 25June2015 Notes:
	 *************************************************************************************** **/
	public void verifyAdminBulkProductEdit() {

		try {
			System.out.println("last driver is "
					+ DriverSession.getLastExecutionDriver());
			action.CatalogDropdown();
			action.TypeTextOnSearch_Name();
			action.ClickSearch();
			action.ClickcheckAll_Link();
			action.ClickBulkPRoductEdit_Link();
			action.ClickUnselectAll_Link();
			action.ClickEditListPrice_Link();
			action.ClickEditSellingPrice_Link();
			action.ClickOnModifySelected_Link();
			action.editListPrice();
			action.ClickOnSaveTable_Link();

		} catch (Exception e) {
			// e.printStackTrace();
		}
	}

	/**
	 * *************************************************************************
	 * ************** Keyword-Name: verifyVendorBulkProductEdit Usage: void
	 * verifyVendorBulkProductEdit() Description: Category pop up window Author:
	 * KAutomators Dated: 25June2015 Notes:
	 *************************************************************************************** **/
	public void verifyVendorBulkProductEdit() {

		try {
			System.out.println("last driver is "
					+ DriverSession.getLastExecutionDriver());
			action.CatalogDropdownVendor();
			action.TypeTextOnSearch_Name();
			action.ClickSearch();
			action.ClickcheckAll_Link();
			action.ClickBulkPRoductEdit_Link();
			action.ClickUnselectAll_Link();
			action.ClickEditListPrice_Link();
			action.ClickEditSellingPrice_Link();
			action.ClickOnModifySelected_Link();
			action.editListPrice();
			action.ClickOnSaveTable_Link();

		} catch (Exception e) {
			// e.printStackTrace();
		}
	}

	/**
	 * *************************************************************************
	 * ************** Keyword-Name: verifyManageOutletBrand Usage: void
	 * verifyManageOutletBrand() Description: Category pop up window Author:
	 * KAutomators Dated: 25June2015 Notes:
	 *************************************************************************************** **/
	public void verifyManageOutletBrand() {

		try {
			System.out.println("last driver is "
					+ DriverSession.getLastExecutionDriver());
			action.catalogDropdown_ManageOutletBrand();
			action.ClickEdit_ProductInformation();
			action.editProductDescription();
			action.editBrandSubmit();
			action.verifyTextOnPage("Success The selected brand was updated successfully. ");
		} catch (Exception e) {
			// e.printStackTrace();
		}
	}

	/**
	 * *************************************************************************
	 * ************** Keyword-Name: verifyManageOutletProducts Usage: void
	 * verifyManageOutletProducts() Description: Category pop up window Author:
	 * KAutomators Dated: 25June2015 Notes:
	 *************************************************************************************** **/
	public void verifyManageOutletProducts() {

		try {
			System.out.println("last driver is "
					+ DriverSession.getLastExecutionDriver());
			action.catalogDropdown_ManageOutletProduct();
			action.TypeTextOnSearch_Name();
			action.ClickSearch();
			action.ClickcheckAll_Link();
			action.ClickBulkPRoductEdit_Link();
			action.ClickUnselectAll_Link();
			action.ClickEditListPrice_Link();
			action.ClickEditSellingPrice_Link();
			action.ClickOnModifySelected_Link();
			action.editListPrice();
			action.ClickOnSaveTable_Link();

		} catch (Exception e) {
			// e.printStackTrace();
		}
	}

	/**
	 * *************************************************************************
	 * ************** Keyword-Name: addNewBrandFunctionality Usage: void
	 * addNewBrandFunctionality() Description: Store setup Functionality Author:
	 * Automators Dated: 25June2015 Notes:
	 * 
	 *************************************************************************************** **/
	public void addNewBrandFunctionality() {
		String url;
		try {
			System.out.println("last driver is "
					+ DriverSession.getLastExecutionDriver());
			url = GlobalVar.url + GlobalVar.TEST_DATA.get("Url Sting");
			action.nevigateToDesiredPage(url);
			action.clickOnAddNewBrand_ManageOutletBrandPage();
			action.typeOnBrandName_ManageOutletBrandPage();
			action.typeBrandPriority_ManageOutletBrandPage();
			action.selectMobileLogo_ManageOutletBrandPage();
			action.selectDestopLogo_ManageOutletBrandPage();
			action.TypeBrandDesc_ManageOutletBrandPage();
			action.clickOnSubmit_ManageOutletBrandPage();
			action.verifyTextOnPage(GlobalVar.TEST_DATA.get("Message"));

		}

		catch (Exception e) {
			// e.printStackTrace();
		}

	}

	/**
	 * *************************************************************************
	 * ************** Keyword-Name: storeSetUpFunctionality Usage: void
	 * storeSetUpFunctionality() Description: Store setup Functionality Author:
	 * Automators Dated: 25June2015 Notes:
	 * 
	 *************************************************************************************** **/
	public void storeSetUpFunctionality() {
		String url;
		try {
			System.out.println("last driver is "+ DriverSession.getLastExecutionDriver());
			url = GlobalVar.url + GlobalVar.TEST_DATA.get("Url Sting")+ GlobalVar.TEST_DATA.get("Customer ID");
			
			action.nevigateToDesiredPage(url);
			action.clickOnStoreSetUpTab_MerchantStoreSetupPage();
			action.GetOnlineStoreText_MerchantStoreSetupPage();
			action.typeOnMicrositeURL_MerchantStoreSetupPage();
			action.selectAndVerifyFactoryOutletDescription_MerchantStoreSetupPage();
			action.clickOnSaveAndCloseButton_MerchantStoreSetupPage();
			action.verifyTextOnPage(GlobalVar.TEST_DATA.get("Message"));
		}

		catch (Exception e) {
			 e.printStackTrace();
		}

	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    manageOutletFunctionality
	 * Usage:           void manageOutletFunctionality()
	 * Description:     Manage Outlet Functionality
	 * Author:          Automators
	 * Dated:           29June2015
	 * Notes:   
	 * 
	 *************************************************************************************** **/
	public void manageOutletFunctionality() 
	{	
		String url;
		try
		{
		System.out.println("last driver is "+ DriverSession.getLastExecutionDriver());
		url = GlobalVar.url + GlobalVar.TEST_DATA.get("Url Sting");
		action.nevigateToDesiredPage(url);
		action.typeOnCustomerID_ManageOutletBrandPage();
		action.clickOnSearchButton_ManageOutletBrandPage();
		action.verifySearchedCustomerName_ManageOutletBrandPage();
		action.verifySearchedCustomerId_ManageOutletBrandPage();
		action.countMerchantPendingApproval_ManageOutletBrandPage();
		action.countFactoryOutletApprovedMerchants_ManageOutletBrandPage();
		
		action.countFactoryOutletDisapprovedMerchants_ManageOutletBrandPage();
		action.selectApprovedStatus_ManageOutletBrandPage();
		Thread.sleep(2000);
		action.selectDisapprovedStatus_ManageOutletBrandPage();
		Thread.sleep(5000);
		url = GlobalVar.url + GlobalVar.TEST_DATA.get("Url Sting2") + GlobalVar.TEST_DATA.get("Customer ID") + GlobalVar.TEST_DATA.get("Url Sting3") + GlobalVar.TEST_DATA.get("Brand ID");
		System.out.println(url);
		url = url.replace(" ", "_");
		System.out.println(url);
		action.nevigateToDesiredPage(url);
		action.clickOnCatalogTab_FactoryOutletRelatedInformationPage();
		action.verifyDownloadBrandLink_FactoryOutletRelatedInformationPage();
		}
		catch(Exception e){
			//e.printStackTrace();
		}
	}
	
	
	public void milkRunFullFillmentPanel(){
		try{
			action.clickMilkRunReceiving();
			
		}
		catch(Exception e){
			e.getMessage();
		}
	}
}

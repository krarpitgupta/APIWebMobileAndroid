package pageWiseOR.BackendWeb;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.By.ByLinkText;
import org.openqa.selenium.By.ByName;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ByIdOrName;

public class BackEndManageProductPage {

	public static BackEndManageProductPage getInstance(){
		return new BackEndManageProductPage();
	}
	
public WebElement catalogLink(WebDriver driver){
	WebElement element=driver.findElement(By.xpath("//div[2]/div/ul/li[5]/a"));
	return element;
}

public WebElement findResultsWithName(WebDriver driver){
	WebElement element=driver.findElement(By.name("q"));
	return element;
}
public WebElement searchWithURL(WebDriver driver){
	WebElement element=driver.findElement(By.name("url"));
	return element;
}
public WebElement searchWithCode(WebDriver driver){
	WebElement element=driver.findElement(By.id("pcode"));
	return element;
}
public WebElement selectStatus(WebDriver driver){
	WebElement element=driver.findElement(By.id("status"));
	return element;
}
public WebElement selectMerchant(WebDriver driver){
	WebElement element=driver.findElement(By.id("sw_company_id_selector_wrap_"));
	return element;
}
public WebElement selectCategory(WebDriver driver){
	WebElement element=driver.findElement(By.name("category_name"));
	return element;
}
public WebElement searchButton(WebDriver driver){
	WebElement element=driver.findElement(By.name("dispatch[products.manage]"));
	return element;
}
public WebElement checkAllCheckBox(WebDriver driver){
	WebElement element=driver.findElement(By.name("check_all"));
	return element;
}
public List<WebElement> listingTable(WebDriver driver){
	List<WebElement> elements=driver.findElements(By.xpath("//div[@id='pagination_contents']/table/tbody/tr"));
	return elements;
}
public String listingTableObject(){
	String object="//div[@id='pagination_contents']/table/tbody/tr";
	return object;
}
public WebElement merchantEditBox(WebDriver driver){
	WebElement element=driver.findElement(By.xpath("//div[@id='company_id_selector_wrap_']/div/input"));
	return element;
}
public WebElement merchantEditBoxLink(WebDriver driver){
	WebElement element=driver.findElement(By.xpath("//ul[@id='company_id_selector']/li/a"));
	return element;
	
}
public WebElement CatalogDropdown(WebDriver driver)
{
	WebElement element=driver.findElement(ByLinkText.linkText("Catalog"));
	return element;
	
}

public WebElement manageProductLink(WebDriver driver)
{
	WebElement element=driver.findElement(ByXPath.xpath("//ul[@id='menu']/li[5]/div/div/ul/li[2]/a/span"));
	return element;
	
}


public WebElement FindResultWithName_EditBox(WebDriver driver)
{
	WebElement element=driver.findElement(ByXPath.xpath("//input[@name='q']"));
	return element;
}

public WebElement ShopCluesURL_EditBox(WebDriver driver) 
{
	WebElement element=driver.findElement(ByXPath.xpath("//input[@name='url']"));
	return element;
}

public WebElement ShopCluesCode_EditBox(WebDriver driver) 
{
	WebElement element=driver.findElement(ByXPath.xpath("//input[@id='pcode']"));
	return element;
}

public WebElement Status_DropDown(WebDriver driver)
{
	WebElement element = driver.findElement(ByCssSelector.cssSelector("#status"));
	return element;
}

public WebElement SearchButton(WebDriver driver)
{
	WebElement element = driver.findElement(ByName.name("dispatch[products.manage]"));
	return element;
}

public WebElement CheckAll_Selector(WebDriver driver)
{
	WebElement element = driver.findElement(ByIdOrName.name("check_all"));
	return element;
}
/// Manage product ---- Product table first row shopclues edit box----- 30 mar,2015

public WebElement FirstRowShopCluesCode_EditBox(WebDriver driver)
{
	WebElement element = driver.findElement(ByXPath.xpath("//*[@id='pagination_contents']/table/tbody/tr[2]/td[3]/div[1]/div/input"));
	return element;
}

///Manage Product --- Product table name header -- 30 mar,2015
public WebElement NameHeader(WebDriver driver)
{
	WebElement element = driver.findElement(ByXPath.xpath("//*[@id='pagination_contents']/table/tbody/tr[1]/th[3]/a"));
	return element;
}

///Manage Product --- Product table First status drop down -- 30 mar,2015
public WebElement FirstStatusDropDown(WebDriver driver,String Code)
{
	WebElement element = driver.findElement(ById.id("sw_select_" + Code + "_wrap"));
	return element;
}
///Manage Product --- Product table First status drop down values -- 30 mar,2015
public WebElement FirstStatusDropDownValues(WebDriver driver,String Code, Integer id)
{
	WebElement element = driver.findElement(ByXPath.xpath("//*[@id='select_" + Code + "_wrap']/div/ul/li[" + id + "]/a"));
	return element;
}

///Manage Product --- Product table First status drop down values -- 30 mar,2015
	public Integer FirstStatusDropDownList(WebDriver driver,String Code)
	{
		Integer element = driver.findElements(ByXPath.xpath("//*[@id='select_" + Code + "_wrap']/div/ul/li")).size();
		return element;
	}
	///Manage Product --- Count product table size
	public Integer CountProductTableSize(WebDriver driver)
	{
		Integer element = driver.findElements(ByXPath.xpath("//*[@id='pagination_contents']/table/tbody/tr")).size();
		return element;
	}
	
	///Manage Product --- Get shopclues code by row number -- 31 mar,2015
	public WebElement ShopCluesCodeByRow_EditBox(WebDriver driver,Integer row)
	{
		WebElement element = driver.findElement(ByXPath.xpath("//*[@id='pagination_contents']/table/tbody/tr[" + row + "]/td[3]/div[1]/div/input"));
		return element;
	}

	///Manage Product(Advance search) --- Advance search icon-- 31 mar,2015
	public WebElement AdvanceSearchIcon(WebDriver driver)
	{
		WebElement element = driver.findElement(ById.id("on_s_3898538751"));
		return element;
	}

	///Manage Product(Advance search)  --- Sales amount from editbox-- 31 mar,2015
	public WebElement SalesAmountFrom_EditBox(WebDriver driver)
	{
		WebElement element = driver.findElement(ById.id("sales_amount_from"));
		return element;
	}
	///Manage Product(Advance search)  --- sales amount to editbox-- 31 mar,2015
	public WebElement SalesAmountTo_EditBox(WebDriver driver)
	{
		WebElement element = driver.findElement(ByName.name("sales_amount_to"));
		return element;
	}

	///Manage Product(Advance search)  --- Period dropdown-- 31 mar,2015
	public WebElement PeriodDropDown(WebDriver driver)
	{
		WebElement element = driver.findElement(ById.id("period_selects"));
		return element;
	}
	///Manage Product(Advance search)  --- Start date-- 31 mar,2015
	public WebElement StartDate_EditBox(WebDriver driver)
	{
		WebElement element = driver.findElement(ById.id("f_date"));
		return element;
	}
	///Manage Product(Advance search)  --- Start date-- 31 mar,2015
	public WebElement EndDate_EditBox(WebDriver driver)
	{
		WebElement element = driver.findElement(ById.id("t_date"));
		return element;
	}
	///Manage Product(Advance search)  --- Start date-- 31 mar,2015
	public WebElement AdvanceSearchButton(WebDriver driver)
	{
		WebElement element = driver.findElement(ByXPath.xpath("(//input[@name='dispatch[products.manage]'])[2]"));
		return element;
	}
	public WebElement ProductTableEditField(WebDriver driver,Integer Row, Integer Col)
	{
		WebElement element = driver.findElement(ByXPath.xpath("//*[@id='pagination_contents']/table/tbody/tr[" + Row + "]/td[" + Col + "]/input"));
		return element;
	}
	public WebElement Image_Link(WebDriver driver)
	{
		WebElement element = driver.findElement(ByXPath.xpath("//div[@id='pagination_contents']/table/tbody/tr/th[2]"));
		return element;
	}
	
	public WebElement Name_Link(WebDriver driver)
	{
		WebElement element = driver.findElement(ByLinkText.linkText("Name"));
		return element;
	}
	
	public WebElement MRP_Link(WebDriver driver)
	{
		WebElement element = driver.findElement(ByLinkText.linkText("MRP (Rs.)"));
		return element;
	}
	
	public WebElement SellingPrice_Link(WebDriver driver)
	{
		WebElement element = driver.findElement(ByXPath.xpath("//div[@id='pagination_contents']/table/tbody/tr/th[5]/a"));
		return element;
	}
	
	public WebElement CommittedQuantity_Link(WebDriver driver)
	{
		WebElement element = driver.findElement(ByXPath.xpath("//div[@id='pagination_contents']/table/tbody/tr/th[6]/a"));
		return element;
	}
	
	public WebElement StatusSubHeader_Link(WebDriver driver)
	{
		WebElement element = driver.findElement(ByLinkText.linkText("Status"));
		return element;
	}
	
	public WebElement DeleteProduct_Link(WebDriver driver)
	{
		WebElement element = driver.findElement(ByLinkText.linkText("Delete"));
		return element;
	}
	
	public WebElement ViewAllButton_Link(WebDriver driver)
	{
		WebElement element = driver.findElement(ByIdOrName.name("view_all"));
		return element;
	}
	
	public WebElement GoToPage_Input(WebDriver driver)
	{
		WebElement element = driver.findElement(ByXPath.xpath("(//input[@value='1'])[2]"));
		return element;
	}
	
	public WebElement LeftArrow_Click(WebDriver driver)
	{
		WebElement element = driver.findElement(ByXPath.xpath("//div[@id='pagination_contents']/div/div/img"));
		return element;
	}
	public WebElement RightArrow_Click(WebDriver driver)
	{
		WebElement element = driver.findElement(ByXPath.xpath(""));
		return element;
	}
	 
 public WebElement ProductNameByRow_EditBox(WebDriver driver,Integer Row)
	{
		WebElement element = driver.findElement(ByXPath.xpath("//*[@id='pagination_contents']/table/tbody/tr[" + Row + "]/td[3]/div/a"));
		return element;
	}
 
 public WebElement catalogLinkForVendor(WebDriver driver){
	 WebElement element=driver.findElement(By.xpath("//div[2]/div/ul/li[3]/a"));
	 return element;
 }
 public WebElement manageProductLinkForVendor(WebDriver driver){
	 WebElement element=driver.findElement(By.xpath("//li[3]/div/div/ul/li/a/span"));
	 return element;
 }
 public List<WebElement> listingTableHeader(WebDriver driver){
		List<WebElement> elements=driver.findElements(By.xpath("//div[@id='pagination_contents']/table/tbody/tr/th"));
		return elements;
	}
 public WebElement listingTableHeaderObject(WebDriver driver,int index){
	 WebElement element=driver.findElement(By.xpath("//div[@id='pagination_contents']/table/tbody/tr/th["+index+"]/a"));
	 return element;
 }
 public WebElement nameHeaderLink(WebDriver driver)
	{
		WebElement element = driver.findElement(ByLinkText.linkText("Name"));
		return element;
	}

	
	public Integer CountProductTableColumn(WebDriver driver)
	{
		Integer element = driver.findElements(ByXPath.xpath("//*[@id='pagination_contents']/table/tbody/tr[1]/th")).size();
		return element;
	}
	
	public WebElement ProductTableColumnValue(WebDriver driver,Integer col)
	{
		WebElement element = driver.findElement(ByXPath.xpath("//*[@id='pagination_contents']/table/tbody/tr[1]/th[" + col + "]"));
		return element;
	}
	public WebElement saveButton(WebDriver driver)
	{
		WebElement element = driver.findElement(ByName.name("dispatch[products.m_update]"));
		return element;
	}
	 /** ***************************************************************************************
	 * Keyword-Name:    searchInCategory
	 * Usage:           WebElement searchInCategory(WebDriver driver)
	 * Description:     Search in category on manage product page
	 * Author:          Automators
	 * Dated:           08Apr2015
	 * Notes:   
	 * 
	 *************************************************************************************** **/
	public WebElement searchInCategory(WebDriver driver)
	{
		WebElement element = driver.findElement(ByXPath.xpath("//img[@alt='Choose']"));
		return element;
	}

	 /** ***************************************************************************************
		 * Keyword-Name:    vendorPreviousPage_Link
		 * Usage:           WebElement vendorPreviousPage_Link(WebDriver driver)
		 * Description:     Vendor pagination previous link
		 * Author:          Automators
		 * Dated:           10Apr2015
		 * Notes:   
		 * 
		 *************************************************************************************** **/
	 public WebElement vendorPreviousPage_Link(WebDriver driver)
		{
			WebElement element = driver.findElement(ByXPath.xpath("//*[@id='pagination_contents']/div[1]/div[2]/span[1]/a"));
			return element;
		}
	 /** ***************************************************************************************
		 * Keyword-Name:    vendorPreviousPage_Link
		 * Usage:           WebElement vendorPreviousPage_Link(WebDriver driver)
		 * Description:     Vendor pagination previous link
		 * Author:          Automators
		 * Dated:           10Apr2015
		 * Notes:   
		 * 
		 *************************************************************************************** **/
	 public WebElement vendorNextPage_Link(WebDriver driver)
		{
			WebElement element = driver.findElement(ByXPath.xpath("//*[@id='pagination_contents']/div[1]/div[2]/span[3]/a"));
			return element;
		}
	 /** ***************************************************************************************
		 * Keyword-Name:    vendorGivenPageNo_Link
		 * Usage:           WebElement vendorGivenPageNo_Link(WebDriver driver)
		 * Description:     Vendor pagination given page link
		 * Author:          Automators
		 * Dated:           10Apr2015
		 * Notes:   
		 * 
		 *************************************************************************************** **/
	 public WebElement vendorGivenPageNo_Link(WebDriver driver,String pageNo)
		{
			WebElement element = driver.findElement(ByLinkText.linkText(pageNo));
			return element;
		}
	 /** ***************************************************************************************
		 * Keyword-Name:    vendorViewAll_Button
		 * Usage:           WebElement vendorViewAll_Button(WebDriver driver)
		 * Description:     Vendor viewall button
		 * Author:          Automators
		 * Dated:           10Apr2015
		 * Notes:   
		 * 
		 *************************************************************************************** **/
	 public WebElement vendorViewAll_Button(WebDriver driver)
		{
			WebElement element = driver.findElement(ByName.name("view_all"));
			return element;
		}
	 /** ***************************************************************************************
		 * Keyword-Name:    goToPage_Edit
		 * Usage:           WebElement goToPage_Edit(WebDriver driver)
		 * Description:     Go to page edit box
		 * Author:          Automators
		 * Dated:           10Apr2015
		 * Notes:   
		 * 
		 *************************************************************************************** **/
	 public WebElement goToPage_Edit(WebDriver driver)
		{
			WebElement element = driver.findElement(ByXPath.xpath("//div[@id='pagination_contents']/div[1]/div[1]/input"));
			return element;
		}
	 /** ***************************************************************************************
		 * Keyword-Name:    tableMouseHover
		 * Usage:           WebElement tableMouseHover(WebDriver driver,int row)
		 * Description:     Given row in table
		 * Author:          Automators
		 * Dated:           13Apr2015
		 * Notes:   
		 * 
		 *************************************************************************************** **/
	 public WebElement tableMouseHover(WebDriver driver,int row){
		 WebElement element=driver.findElement(By.cssSelector("div#pagination_contents>table.table.sortable.hidden-inputs>tbody>tr:nth-child("+row+")>td"));
		 return element;
	 }
	 
	 public WebElement NewProduct_Images_URL(WebDriver driver)
		{
			WebElement element = driver.findElement(By.xpath("(//a[contains(text(),'URL')])[2]"));
			return element;
		}
	//CheckBox
		 public WebElement Catalog_CheckAll(WebDriver driver)
			{
				WebElement element = driver.findElement(By.name("check_all"));
				return element;
			}
		//Bulk Edit
		 public WebElement Catalog_BulkEditProductSettings(WebDriver driver)
			{
				WebElement element = driver.findElement(By.linkText("Bulk Edit Product Settings"));
				return element;
			}
		 
		 //UnSelect All
		 public WebElement Catalog_BulkEditProduct_Unselect(WebDriver driver)
			{
				WebElement element = driver.findElement(By.xpath("(//a[contains(text(),'Unselect all')])[2]"));
				return element;
			} 
		 
		 //Edit List Price
		 public WebElement Catalog_BulkEditProduct_ListPrice(WebDriver driver)
			{
				WebElement element = driver.findElement(By.name("selected_fields[data][list_price]"));
				return element;
			} 
		 
		 //Edit Selling Price
		 public WebElement Catalog_BulkEditProduct_SellingPrice(WebDriver driver)
			{
				WebElement element = driver.findElement(By.name("selected_fields[data][price]"));
				return element;
			} 
		 
		 //Click on Modify Selected
		 public WebElement Catalog_BulkEditProduct_ModifySelected(WebDriver driver)
			{
				WebElement element = driver.findElement(By.name("dispatch[products.store_selection]"));
				return element;
			} 

		//Table of Bulk Edit
		 public int manageProductVendorLinkTable(WebDriver driver)
		 {
		 	int element=driver.findElements(ByXPath.xpath("//*[@id='scrolled_div']/table/tbody/tr")).size();
		 	return element;
		 	
		 }
		 
		//Table List Price
		 public WebElement manageProductVendorLinkListPrice(WebDriver driver,int i)
		 {
		 	WebElement element=driver.findElement(ByXPath.xpath("//*[@id='scrolled_div']/table/tbody/tr[" + i + "]/td[2]/table/tbody/tr[2]/td[2]/input"));
		 	return element;
		 	
		 }
		 
		//Save Table List Price
		 public WebElement manageProductVendorSaveButton(WebDriver driver)
		 {
		 	WebElement element=driver.findElement(By.name("dispatch[products.m_update]"));
		 	return element;
		 	
		 }
		 
		 public WebElement manageProductVendorLink(WebDriver driver)
		 {
		 	WebElement element=driver.findElement(ByXPath.xpath("//ul[@id='menu']/li[3]/div/div/ul/li/a/span"));
		 	return element;
		 	
		 }

		public WebElement clickToSubmit(WebDriver driver) {
			WebElement element=driver.findElement(ByXPath.xpath(".//*[@id='show_data']"));
			return element;
		}

		public WebElement clickProdHeader(WebDriver driver) {
			WebElement element=driver.findElement(ByXPath.xpath(".//*[@id='containing_search']/tbody/tr[1]"));
			return element;
		}

		public WebElement clickToSearchResult(WebDriver driver) {
			WebElement element=driver.findElement(ByXPath.xpath(".//*[@id='containing_search']/tbody/tr[2]"));
			return element;
		}
		 
		public WebElement getResult(WebDriver driver,int index){
			WebElement element=driver.findElement(By.xpath(".//*[@id='containing_search']/tbody/tr[2]/td["+String.valueOf(index)+"]"));
			return element;
		}
		 //ShopClues Factory Outlet
		 public WebElement Catalog_BulkEditProductSettings_ShopCluesFactoryOutlet(WebDriver driver)
		{
				WebElement element = driver.findElement(By.linkText("ShopClues Factory Outlet"));
				return element;
		} 
		 
		 //Manage Outlet Brand
		 public WebElement Catalog_BulkEditProductSettings_ManageOutletBrand(WebDriver driver)
			{
				WebElement element = driver.findElement(By.linkText("Manage Outlet Brand"));
				return element;
			} 
		//Manage Outlet Brand Edit Product
		 public WebElement Catalog_ProductSettings_ManageOutletBrand_Edit(WebDriver driver)
			{
				WebElement element = driver.findElement(By.xpath("(//a[contains(text(),'Edit')])[3]"));
				return element;
			} 
		 
		//Manage Outlet Brand Description Edit Product
		 public WebElement Catalog_ProductSettings_ManageOutletBrand_Edit_BrandDescription(WebDriver driver)
			{
				WebElement element = driver.findElement(By.name("brand_desc"));
				return element;
			} 
		 
			//Manage Outlet Brand Edit Product
			public WebElement Catalog_ProductSettings_ManageOutletBrand_Submit(WebDriver driver)
					{
						WebElement element = driver.findElement(By.xpath("//input[@value='Submit']"));
						return element;
					}  
	 
			 //Manage Outlet Products
			 public WebElement Catalog_BulkEditProductSettings_ManageOutletProducts(WebDriver driver)
				{
					WebElement element = driver.findElement(By.linkText("Manage Outlet Products"));
					return element;
				} 
			 
			 /** ***************************************************************************************
				 * Keyword-Name:    addNewBrand_ManageOutletBrandPage
				 * Usage:           WebElement addNewBrand_ManageOutletBrandPage(WebDriver driver)
				 * Description:     Click on add new brand button on merchant store setup page
				 * Author:          Automators
				 * Dated:           26 June 2015
				 * Notes:   
				 * 
				 *************************************************************************************** **/
			 public WebElement addNewBrand_ManageOutletBrandPage(WebDriver driver){
				 WebElement element=driver.findElement(By.xpath("//a[contains(text(),'Add New Brand')]"));
				 return element;
			 }
			 
			 /** ***************************************************************************************
				 * Keyword-Name:    brandDesc_ManageOutletBrandPage
				 * Usage:           WebElement brandDesc_ManageOutletBrandPage(WebDriver driver)
				 * Description:     Brand Desc Edit Box on merchant store setup page
				 * Author:          Automators
				 * Dated:           26 June 2015
				 * Notes:   
				 * 
				 *************************************************************************************** **/
			 public WebElement brandDesc_ManageOutletBrandPage(WebDriver driver){
				 WebElement element=driver.findElement(By.id("add_brand_desc"));
				 return element;
			 }
			 
			 /** ***************************************************************************************
				 * Keyword-Name:    submitButton_ManageOutletBrandPage
				 * Usage:           WebElement submitButton_ManageOutletBrandPage(WebDriver driver)
				 * Description:     Submit button on merchant store setup page
				 * Author:          Automators
				 * Dated:           26 June 2015
				 * Notes:   
				 * 
				 *************************************************************************************** **/
			 public WebElement submitButton_ManageOutletBrandPage(WebDriver driver){
				 WebElement element=driver.findElement(By.xpath("//input[@value='Submit']"));
				 return element;
			 }
			 
			 /** ***************************************************************************************
				 * Keyword-Name:    brandName_ManageOutletBrandPage
				 * Usage:           WebElement brandName_ManageOutletBrandPage(WebDriver driver)
				 * Description:     Brand Name Edit Box on merchant store setup page
				 * Author:          Automators
				 * Dated:           26 June 2015
				 * Notes:   
				 * 
				 *************************************************************************************** **/
			 public WebElement brandName_ManageOutletBrandPage(WebDriver driver){
				 WebElement element=driver.findElement(By.id("add_brand_name"));
				 return element;
			 }
			 
			 /** ***************************************************************************************
				 * Keyword-Name:    brandPriority_ManageOutletBrandPage
				 * Usage:           WebElement brandPriority_ManageOutletBrandPage(WebDriver driver)
				 * Description:     Brand Priority Edit Box on merchant store setup page
				 * Author:          Automators
				 * Dated:           26 June 2015
				 * Notes:   
				 * 
				 *************************************************************************************** **/
			 public WebElement brandPriority_ManageOutletBrandPage(WebDriver driver){
				 WebElement element=driver.findElement(By.id("add_brand_priority"));
				 return element;
			 }
			 
			 /** ***************************************************************************************
				 * Keyword-Name:    mobileLogo_ManageOutletBrandPage
				 * Usage:           WebElement mobileLogo_ManageOutletBrandPage(WebDriver driver)
				 * Description:     Mobile logo link on merchant store setup page
				 * Author:          Automators
				 * Dated:           26 June 2015
				 * Notes:   
				 * 
				 *************************************************************************************** **/
			 public WebElement mobileLogo_ManageOutletBrandPage(WebDriver driver){
				 WebElement element=driver.findElement(By.id("add_small_brand_logo"));
				 return element;
			 }
			 
			 /** ***************************************************************************************
				 * Keyword-Name:    destopLogo_ManageOutletBrandPage
				 * Usage:           WebElement destopLogo_ManageOutletBrandPage(WebDriver driver)
				 * Description:     Destop logo link on merchant store setup page
				 * Author:          Automators
				 * Dated:           26 June 2015
				 * Notes:   
				 * 
				 *************************************************************************************** **/
			 public WebElement destopLogo_ManageOutletBrandPage(WebDriver driver){
				 WebElement element=driver.findElement(By.id("add_brand_logo"));
				 return element;
			 }
			 
			 /** ***************************************************************************************
				 * Keyword-Name:    storeSetUpTab_MerchantStoreSetupPage
				 * Usage:           WebElement storeSetUpTab_MerchantStoreSetupPage(WebDriver driver)
				 * Description:     Store setup tab on merchant store setup page
				 * Author:          Automators
				 * Dated:           23 June 2015
				 * Notes:   
				 * 
				 *************************************************************************************** **/
			 public WebElement storeSetUpTab_MerchantStoreSetupPage(WebDriver driver){
				 WebElement element=driver.findElement(By.id("storeSetup"));
				 return element;
			 }
			 
			 
			 /** ***************************************************************************************
				 * Keyword-Name:    onlineStoreName_MerchantStoreSetupPage
				 * Usage:           WebElement onlineStoreName_MerchantStoreSetupPage(WebDriver driver)
				 * Description:     Online store name edit box on merchant store setup page
				 * Author:          Automators
				 * Dated:           23 June 2015
				 * Notes:   
				 * 
				 *************************************************************************************** **/
			 public WebElement onlineStoreName_MerchantStoreSetupPage(WebDriver driver){
				 WebElement element=driver.findElement(By.id("compa_description_company"));
				 return element;
			 }
			 
			 /** ***************************************************************************************
				 * Keyword-Name:    micrositeURL_MerchantStoreSetupPage
				 * Usage:           WebElement micrositeURL_MerchantStoreSetupPage(WebDriver driver)
				 * Description:     Microsite url edit box on merchant store setup page
				 * Author:          Automators
				 * Dated:           23 June 2015
				 * Notes:   
				 * 
				 *************************************************************************************** **/
			 public WebElement micrositeURL_MerchantStoreSetupPage(WebDriver driver){
				 WebElement element=driver.findElement(By.id("company_seo_name"));
				 return element;
			 }
			 
			 /** ***************************************************************************************
				 * Keyword-Name:    factoryOutletDescription_MerchantStoreSetupPage
				 * Usage:           WebElement factoryOutletDescription_MerchantStoreSetupPage(WebDriver driver)
				 * Description:     Factory outlet description dropdown on merchant store setup page
				 * Author:          Automators
				 * Dated:           23 June 2015
				 * Notes:   
				 * 
				 *************************************************************************************** **/
			 public WebElement factoryOutletDescription_MerchantStoreSetupPage(WebDriver driver){
				 WebElement element=driver.findElement(By.id("brand_factory"));
				 return element;
			 }
			 
			 /** ***************************************************************************************
				 * Keyword-Name:    saveAndClose_MerchantStoreSetupPage
				 * Usage:           WebElement saveAndClose_MerchantStoreSetupPage(WebDriver driver)
				 * Description:     Click on save and close button on merchant store setup page
				 * Author:          Automators
				 * Dated:           23 June 2015
				 * Notes:   
				 * 
				 *************************************************************************************** **/
			 public WebElement saveAndClose_MerchantStoreSetupPage(WebDriver driver){
				 WebElement element=driver.findElement(By.xpath("(//input[@name='dispatch[companies.update]'])[2]"));
				 return element;
			 }
			 
			 /** ***************************************************************************************
				 * Keyword-Name:    companyID_ManageOutletPage
				 * Usage:           WebElement companyID_ManageOutletPage(WebDriver driver)
				 * Description:     Company ID on manage outlet page
				 * Author:          Automators
				 * Dated:           23 June 2015
				 * Notes:   
				 * 
				 *************************************************************************************** **/
			 public WebElement companyID_ManageOutletPage(WebDriver driver){
				 WebElement element=driver.findElement(By.id("company_id"));
				 return element;
			 }
			 /** ***************************************************************************************
				 * Keyword-Name:    merchantSearchButton_ManageOutletPage
				 * Usage:           WebElement merchantSearchButton_ManageOutletPage(WebDriver driver)
				 * Description:     Search Button on manage outlet page
				 * Author:          Automators
				 * Dated:           23 June 2015
				 * Notes:   
				 * 
				 *************************************************************************************** **/
			 public WebElement merchantSearchButton_ManageOutletPage(WebDriver driver){
				 WebElement element=driver.findElement(By.xpath("//input[@value='Search']"));
				 return element;
			 }
			 
			 /** ***************************************************************************************
				 * Keyword-Name:    searchCustomerName_ManageOutletBrandPage
				 * Usage:           WebElement searchCustomerName_ManageOutletBrandPage(WebDriver driver)
				 * Description:     Search Customer Name on factory outlet manage page
				 * Author:          Automators
				 * Dated:           29 June 2015
				 * Notes:   
				 * 
				 *************************************************************************************** **/
			 public WebElement searchCustomerName_ManageOutletBrandPage(WebDriver driver){
				 WebElement element=driver.findElement(By.xpath("//*[@id='pagination_contents']/table/tbody/tr[2]/td[2]/a"));
				 return element;
			 }
			 
			 /** ***************************************************************************************
				 * Keyword-Name:    searchCustomerId_ManageOutletBrandPage
				 * Usage:           WebElement searchCustomerId_ManageOutletBrandPage(WebDriver driver)
				 * Description:     Search Customer ID on factory outlet manage page
				 * Author:          Automators
				 * Dated:           29 June 2015
				 * Notes:   
				 * 
				 *************************************************************************************** **/
			 public WebElement searchCustomerId_ManageOutletBrandPage(WebDriver driver){
				 WebElement element=driver.findElement(By.xpath("//*[@id='pagination_contents']/table/tbody/tr[2]/td[1]/a"));
				 return element;
			 }
			 
			 /** ***************************************************************************************
				 * Keyword-Name:    merchantPendingApprovalCount_ManageOutletPage
				 * Usage:           WebElement merchantPendingApprovalCount_ManageOutletPage(WebDriver driver)
				 * Description:     Merchant pending approval count on manage outlet page
				 * Author:          Automators
				 * Dated:           23 June 2015
				 * Notes:   
				 * 
				 *************************************************************************************** **/
			 public WebElement merchantPendingApprovalCount_ManageOutletPage(WebDriver driver){
				 WebElement element=driver.findElement(By.xpath("//div[@id='statistics_box']/div/div/ul/li/span/a"));
				 return element;
			 }
			 
			 /** ***************************************************************************************
				 * Keyword-Name:    factoryOutletApprovedMerchantsCount_ManageOutletPage
				 * Usage:           WebElement factoryOutletApprovedMerchantsCount_ManageOutletPage(WebDriver driver)
				 * Description:     Factory outlet approved merchants count on manage outlet page
				 * Author:          Automators
				 * Dated:           23 June 2015
				 * Notes:   
				 * 
				 *************************************************************************************** **/
			 public WebElement factoryOutletApprovedMerchantsCount_ManageOutletPage(WebDriver driver){
				 WebElement element=driver.findElement(By.xpath("//div[@id='statistics_box']/div/div/ul/li[2]/span/a"));
				 return element;
			 }
			 
			 /** ***************************************************************************************
				 * Keyword-Name:    downloadBrandLink_FactoryOutletRelatedInformationPage
				 * Usage:           WebElement downloadBrandLink_FactoryOutletRelatedInformationPage(WebDriver driver)
				 * Description:     Catalog tab on factory outlet related information page
				 * Author:          Automators
				 * Dated:           29 June 2015
				 * Notes:   
				 * 
				 *************************************************************************************** **/
			 public WebElement downloadBrandLink_FactoryOutletRelatedInformationPage(WebDriver driver){
				 WebElement element=driver.findElement(By.xpath("//*[@id='content_catalog_info']/p/a"));
				 return element;
			 }
			 
			 /** ***************************************************************************************
				 * Keyword-Name:    catalogTab_FactoryOutletRelatedInformationPage
				 * Usage:           WebElement catalogTab_FactoryOutletRelatedInformationPage(WebDriver driver)
				 * Description:     Catalog tab on factory outlet related information page
				 * Author:          Automators
				 * Dated:           29 June 2015
				 * Notes:   
				 * 
				 *************************************************************************************** **/
			 public WebElement catalogTab_FactoryOutletRelatedInformationPage(WebDriver driver){
				 WebElement element=driver.findElement(By.xpath("//*[@id='catalog_info']/a"));
				 return element;
			 }
			 /** ***************************************************************************************
				 * Keyword-Name:    disapprovedStatus_ManageOutletBrandPage
				 * Usage:           WebElement disapprovedStatus_ManageOutletBrandPage(WebDriver driver)
				 * Description:     DisApproved status on factory outlet manage page
				 * Author:          Automators
				 * Dated:           29 June 2015
				 * Notes:   
				 * 
				 *************************************************************************************** **/
			 public WebElement disapprovedStatus_ManageOutletBrandPage(WebDriver driver){
				 WebElement element=driver.findElement(By.xpath("//a[contains(text(),'Disapproved')]"));
				 return element;
			 }
			 
			 /** ***************************************************************************************
				 * Keyword-Name:    approvedStatus_ManageOutletBrandPage
				 * Usage:           WebElement approvedStatus_ManageOutletBrandPage(WebDriver driver)
				 * Description:     Approved status on factory outlet manage page
				 * Author:          Automators
				 * Dated:           29 June 2015
				 * Notes:   
				 * 
				 *************************************************************************************** **/
			 public WebElement approvedStatus_ManageOutletBrandPage(WebDriver driver){
				 WebElement element=driver.findElement(By.xpath("//a[contains(text(),'Approved')]"));
				 return element;
			 }
			 /** ***************************************************************************************
				 * Keyword-Name:    factoryOutletDisapprovedMerchantsCount_ManageOutletPage
				 * Usage:           WebElement factoryOutletDisapprovedMerchantsCount_ManageOutletPage(WebDriver driver)
				 * Description:     Factory outlet disapproved merchants count on manage outlet page
				 * Author:          Automators
				 * Dated:           23 June 2015
				 * Notes:   
				 * 
				 *************************************************************************************** **/
			 public WebElement factoryOutletDisapprovedMerchantsCount_ManageOutletPage(WebDriver driver){
				 WebElement element=driver.findElement(By.xpath("//div[@id='statistics_box']/div/div/ul/li[3]/span/a"));
				 return element;
			 }
}

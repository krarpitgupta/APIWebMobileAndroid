package pageWiseOR.BackendWeb;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BackendOutletSelection {

	
	public static BackendOutletSelection getInstance(){
		BackendOutletSelection back=null;
		try{
			back=new BackendOutletSelection();
		}
		catch(Exception e){
			e.getMessage();
		}
		return back;
	}

	public WebElement clickFactoryOutlet(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='menu']/li[5]/div/div/ul/li[17]/a/span"));
		return element;									
	}

	public WebElement clickNewBrand(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='menu']/li[5]/div/div/ul/li[17]/div/ul/li[3]/a"));
		return element;
	}

	public WebElement clickManageLogo(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[contains(text(),'Manage Outlet Brands')]"));
		return element;
	}

	public WebElement clickAddNewBrand(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[contains(text(),'Add New Brand')]"));
		return element;
	}

	public WebElement clickSubmitButton(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='main_column']/form/div[6]/input"));
		return element;
	}

	public WebElement getField1(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='main_column']/form/div[1]/label"));
		return element;
	}

	public WebElement getAlert1(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='main_column']/form/div[1]/div[3]/div[2]/p"));
		return element;
	}

	public WebElement getField2(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='main_column']/form/div[2]/label"));
		return element;
	}

	public WebElement getAlert2(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='main_column']/form/div[2]/div[2]/div[2]/p"));
		return element;
	}
	
	public WebElement getField3(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='main_column']/form/div[3]/label"));
		return element;
	}

	public WebElement getAlert3(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='main_column']/form/div[3]/div[2]/div[2]/p"));
		return element;
	}
	
	public WebElement getField4(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='main_column']/form/div[4]/label"));
		return element;
	}

	public WebElement getAlert4(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='main_column']/form/div[4]/div/div[2]/p"));
		return element;
	}
	
	public WebElement getField5(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='main_column']/form/div[5]/label"));
		return element;
	}

	public WebElement getAlert5(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='main_column']/form/div[5]/div[3]/div[2]/p"));
		return element;
	}

	public WebElement ClickB_Name(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='add_brand_name']"));
		return element;
	}

	public WebElement getErrorMsg(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='new_brand_errrr']"));
		return element;
	}

	public WebElement clickBrowseButton(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='add_brand_logo']"));
		return element;
	}

	public WebElement clickSmallLogo(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='add_small_brand_logo']"));
		return element;
	}

	public WebElement clickDesc(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='add_brand_desc']"));
		return element;
	}

	public WebElement clickBrandPriority(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='add_brand_priority']"));
		return element;
	}

	public WebElement clickSubmit(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='main_column']/form/div[6]/input"));
		return element;
	}

	public WebElement clickNewProduct(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='menu']/li[5]/div/div/ul/li[17]/div/ul/li[1]/a"));
		return element;
	}

	public WebElement clickToHomeLogo(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[contains(text(),'Add New Factory Outlet Product')]"));
		return element;
	}

	public WebElement clickAddNewOutletButton(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[contains(text(),'Add New Outlet Product')]"));
		return element;
	}

	public WebElement clickToNewprod(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[contains(text(),'Add new product')]"));
		return element;
	}

	public WebElement clickToCreate(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='product_update_form']/div[11]/div/div/div/span[1]/span/input"));
		return element;
	}

	public WebElement click1(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='content_detailed']/fieldset[1]/div[1]/div/div[2]/p"));
		return element;
	}

	public WebElement clickProdTitle(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='content_detailed']/fieldset[1]/div[1]"));
		return element;									
	}

	public WebElement clickCategory(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='content_detailed']/fieldset[1]/div[2]"));
		return element;
	}

	public WebElement clickSellingPrice(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='content_detailed']/fieldset[1]/div[6]"));
		return element;
	}

	public WebElement clickFullDesc(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='content_detailed']/fieldset[1]/div[7]"));
		return element;									
	}

	public WebElement getStatus(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='content_detailed']/fieldset[1]/div[8]"));
		return element;
	}

	public WebElement clickOuterBrand(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='content_detailed']/fieldset[1]/div[16]"));
		return element;
	}

	public WebElement clickToImage(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='content_detailed']/fieldset[1]/div[17]"));
		return element;
	}

	public WebElement clickToProdTitletextField(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='product_description_product']"));
		return element;
	}

	public WebElement clickSellingPrices(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='price_price']"));
		return element;
	}

	public WebElement typeFullDesc(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='product_full_descr_toolbar1']/tbody/tr/td[4]"));
		return element;
	}

	public WebElement clickField(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='tinymce']"));
		return element;
	}

	public WebElement clickOutlt(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='outlet_brand_text']"));
		return element;
	}

	public WebElement clickAttachFile(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[contains(text(),'Attach File')]"));
		return element;
	}

	public WebElement clickCreate(WebDriver driver) {
		WebElement element=driver.findElement(By.name("dispatch[products.add]"));
		return element;
	}

	public WebElement clickAndValidateField(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[contains(text(),'The new brand was created successfully.')]"));
		return element;
	}

	public WebElement clickToFullFillment(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[contains(text(),'Fulfillment')]"));
		return element;
	}

	public WebElement clickMangMilkRun(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='menu']/li[4]/div/div/ul/li[3]/a/span"));
		return element;
	}

	public WebElement clickMilkrunReceiving(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='menu']/li[4]/div/div/ul/li[3]/div/ul/li[3]/a"));
		return element;
	}	
}

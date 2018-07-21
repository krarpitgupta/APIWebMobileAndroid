package pageWiseOR.BackendWeb;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	/**
	 * @param args
	 */
	
	public static HomePage getInstance(){
		HomePage homePage=null;
		try{
			homePage=new HomePage();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return homePage;
	}
	
	public WebElement clickToLoginButton(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='pre_login_allowed']/span/input"));
		return element;
	}

	public WebElement validateHomeBanner(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='menu']/li[1]/a"));
		return element;
	}

	public WebElement clickToCatalogOption(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='menu']/li[5]/a"));
		return element;
	}

	public WebElement clickToCatalogQuality(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='menu']/li[5]/div/div/ul/li[3]/a/span"));
		return element;
	}

	public WebElement clickToSearchRedirection(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='menu']/li[5]/div/div/ul/li[3]/div/ul/li[10]/a"));
		return element;
	}

	public WebElement clickToSearchButton(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='search']"));
		return element;
	}

	public WebElement clickSearchField(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='search_word']"));
		return element;									
	}

	public WebElement clickToSubSearchBtn(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='sub_button']"));
		return element;
	}

	public List<WebElement> getAllTableVisibleFields(WebDriver driver) {
		List<WebElement>al=driver.findElements(By.xpath(".//*[@id='pro_table']/tbody/tr[1]"));
		return al;
	}

	public WebElement clickRedirectLogo(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='add_redirect_rule']/legend"));
		return element;
	}

	public WebElement clickKeywordTypeDropDown(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='add_redirect_rule']/form/div/select[1]"));
		return element;
	}

	public WebElement clickToCondition(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='add_redirect_rule']/form/div/select[2]"));
		return element;
	}

	public WebElement clickToStatus(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='add_redirect_rule']/form/div/div/select[1]"));
		return element;
	}

	public WebElement clickToSubstatus(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='add_redirect_rule']/form/div/div/select[2]"));
		return element;
	}

	public WebElement clickToTextField(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='redirect_keyword']"));
		return element;
	}

	public WebElement clickToRedirectURL(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='add_redirect_rule']/form/div/input[2]"));
		return element;
	}

	public WebElement clickToExempt(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='exempt_mid']"));
		return element;
	}

	public WebElement clickToKeywordType(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='data']/td[1]/select"));
		return element;
	}

	public WebElement clickToSearchCondition(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='data']/td[2]/select"));
		return element;
	}

	public WebElement clickToProduct(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='data']/td[3]/div"));
		return element;
	}

	public WebElement clickToRedirectURLLogo(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='data']/td[4]/div"));
		return element;
	}

	public WebElement clickToMIDs(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='data']/td[5]/div"));
		return element;
	}

	public WebElement clickToSubState(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='data']/td[6]"));
		return element;
	}

	public WebElement clickSection(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='sw_select_214_wrap']"));
		return element;
	}

	public WebElement clickURL(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='data']/td[8]/a"));
		return element;
	}

	public WebElement clickProductFeature(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='menu']/li[5]/div/div/ul/li[3]/div/ul/li[1]/a"));
		return element;
	}

	public WebElement clickFeaturePageLogo(WebDriver driver) {
		WebElement element=null;
		try{
		element=driver.findElement(By.xpath(".//*[@id='main_column']/div[3]/div[1]"));
		}
		catch(Exception e){e.getMessage();}
		return element;									
	}

	public WebElement clickToAddFeature(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='opener_add_new_feature']"));
		return element;
	}

	public WebElement getLogoPopup(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='ui-dialog-title-content_add_new_feature']"));
		return element;
	}

	public WebElement clickCreateButton(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='tabs_content_0']/div[5]/span[1]/input"));
		return element;
	}

	public WebElement clickToNameOption(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='content_tab_details_0']/fieldset/div[1]/label"));
		return element;									
	}

	public WebElement clickToTypeOption(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='content_tab_details_0']/fieldset/div[7]/label"));
		return element;
	}

	public WebElement clickToGroupOption(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='org_group']/label"));
		return element;
	}

	public WebElement clickeToNamePopup(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='content_tab_details_0']/fieldset/div[1]/div/div[2]/p"));
		return element;									
	}

	public WebElement clickeToTypePopup(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='content_tab_details_0']/fieldset/div[7]/div/div[2]/p"));
		return element;
	}

	public WebElement clickeToGroupPopup(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='org_group']/div/div[2]/p"));
		return element;
	}

	public WebElement clickToName(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='feature_name_0']"));
		return element;
	}

	public WebElement clickToTypeDropdown(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='feature_type_0']"));
		return element;
	}

	public WebElement clickGroupDropDown(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='feature_group_0']"));
		return element;
	}

	public WebElement clickToCreate(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='tabs_content_0']/div[5]/span[1]/input"));
		return element;								
	}		

	public WebElement clickToFeaturetext(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='fname']"));
		return element;
	}

	public WebElement clickSearchButton(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='ds_1280529838']/div/form/table/tbody/tr/td[3]/span/input"));
		return element;									
	}

	public WebElement clickResultGroupName(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='update_features_list']/div[2]/div[4]/div/span[1]/a"));
		return element;
	}

	public WebElement clickeToFeatureGroup(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='opener_add_new_group']"));
		return element;
	}

	public WebElement clickAddNewGrouppopup(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='ui-dialog-title-content_add_new_group']"));
		return element;
	}

	public WebElement clickToCreategroup(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='tabs_content_0G']/div[5]/span[1]/input"));
		return element;
	}

	public WebElement clickNameHighlighter(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='content_tab_details_0G']/fieldset/div[1]/div/div[2]/p"));
		return element;
	}

	public WebElement getNameField(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='content_tab_details_0G']/fieldset/div[1]/label"));
		return element;
	}

	public WebElement clickTextnameField(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='feature_name_0G']"));
		return element;
	}

	public WebElement clickCreate(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='tabs_content_0G']/div[5]/span[1]/input"));
		return element;									
	}

	public WebElement clickToCategories(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='tab_categories_0G']/a"));
		return element;
	}

	public WebElement clickCatgDropDown(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath("//a[contains(@href,'root=&except_id=&data_id=category_ids_0G_')]"));
		return element;									
	}											

	public WebElement clickCheckBox(WebDriver driver) {
		WebElement element=driver.findElement(By.cssSelector("input.checkbox.cm-item"));
		return element;											
	}

	public WebElement clickToAddCatg(WebDriver driver) {
		WebElement element=driver.findElement(By.cssSelector("input.cm-process-items.cm-dialog-closer"));
		return element;									
	}

	public WebElement clickmanagCounterfeitprod(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='menu']/li[5]/div/div/ul/li[3]/div/ul/li[15]/a"));
		return element;									
	}

	public WebElement clickToManagCounterFit(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='main_column']/div[2]/h1"));
		return element;
	}

	public WebElement clickSearch(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='product_lookup']/span/input"));
		return element;
	}

	public WebElement clickToNameField(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='product_lookup']/div[2]/label"));
		return element;
	}

	public WebElement clickMandpopup(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='product_lookup']/div[2]/div/div[2]/p"));
		return element;
	}

	public WebElement clickProdIdTextField(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='real_product_id']"));
		return element;
	}

	public WebElement clickCounterfeitSearchPanel1(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='menu']/li[5]/div/div/ul/li[3]/div/ul/li[13]/a"));
		return element;
	}

	public WebElement clickSearchpanelLogo(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='main_column']/div[2]/h1"));
		return element;									
	}

	public WebElement clickTopageLayOut(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='main_column']"));
		return element;
	}

	public WebElement clickCounterfeitSearchPanel2(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='menu']/li[5]/div/div/ul/li[3]/div/ul/li[14]/a"));
		return element;
	}

	public WebElement counterfitCheckTool(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='main_column']/div[2]/h1"));
		return element;
	}

	public WebElement clickToSearchPane(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='search_word']"));
		return element;
	}

	public WebElement clickToSelectrule(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='counterfeit_seach_rule']"));
		return element;
	}

	public WebElement ClickToSearchIn(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='seach_criteria']"));
		return element;								
	}

	public WebElement clickFirstSearch(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='first_psearch_word']"));
		return element;
	}

	public WebElement clickLastField(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='last_psearch_word']"));
		return element;
	}

	public WebElement clickSpace(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='proximity']"));
		return element;
	}

	

	
}

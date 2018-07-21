package pageWiseOR.BackendWeb;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.By.ByLinkText;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByName;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import session.DriverSession;
import utilities.GlobalVar;

/** ***************************************************************************************
 * Script-Name:    pageWiseOR.BackendWeb/BackEnd1by1Upload
 * Description:    OR to add objects related to 1-by-1 Upload functionality
 * Author:         Automators
 * Dated:          03Apr2015
 * Notes:   
 * 
 *************************************************************************************** **/

public class BackEnd1by1Upload {
	
	public static BackEnd1by1Upload getInstance()
	{
		return new BackEnd1by1Upload();
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    onebyOneUploadButton
	 * Usage:           WebElement onebyOneUploadButton(WebDriver driver)
	 * Description:     1-by-1 Upload button on manage product page
	 * Author:          Automators
	 * Dated:           03Apr2015
	 * Notes:   
	 * 
	 *************************************************************************************** **/
	public WebElement onebyOneUploadButton(WebDriver driver)
	{
		WebElement element = driver.findElement(ByLinkText.linkText("1-by-1 Upload"));
		return element;
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    categoryLink
	 * Usage:           WebElement categoryLink(WebDriver driver)
	 * Description:     category link on new product page
	 * Author:          Automators
	 * Dated:           03Apr2015
	 * Notes:   
	 * changed by krishna  (Object Change)
	 *************************************************************************************** **/
	public WebElement categoryLink(WebDriver driver)
	{
	//	WebElement element = driver.findElement(ByXPath.xpath("//a[contains(text(),'Select Category')]"));
		WebElement element = driver.findElement(ByXPath
			    .xpath("//a[contains(@id, 'opener_picker_categories_')]"));
		return element;
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    addCategoriesAndCloseButton
	 * Usage:           WebElement addCategoriesAndCloseButton(WebDriver driver)
	 * Description:     Add Categories And Close button on category pop up window
	 * Author:          Automators
	 * Dated:           03Apr2015
	 * Notes:   
	 * 
	 *************************************************************************************** **/
	public WebElement addCategoriesAndCloseButton(WebDriver driver)
	{
		WebElement element = driver.findElement(ByName.name("submit"));
		return element;
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    categoryButton
	 * Usage:           WebElement categoryButton(WebDriver driver)
	 * Description:     category button on category pop up window
	 * Author:          Automators
	 * Dated:           03Apr2015
	 * Notes:   
	 * 
	 *************************************************************************************** **/
	public WebElement categoryButton(WebDriver driver)
	{
		WebElement element = driver.findElement(ByXPath.xpath("//input[@value='Category']"));
		return element;
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    cancelLink
	 * Usage:           WebElement cancelLink(WebDriver driver)
	 * Description:     cancel link on category pop up window
	 * Author:          Automators
	 * Dated:           03Apr2015
	 * Notes:   
	 * 
	 *************************************************************************************** **/
	public WebElement cancelLink(WebDriver driver)
	{
		WebElement element = driver.findElement(ByXPath.xpath("(//a[contains(text(),'Cancel')])[6]"));
		return element;
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    checkUncheckAll
	 * Usage:           WebElement checkUncheckAll(WebDriver driver)
	 * Description:     checkUncheckAll check box on category pop up window
	 * Author:          Automators
	 * Dated:           06Apr2015
	 * Notes:   
	 * 
	 *************************************************************************************** **/
	public WebElement checkUncheckAll(WebDriver driver)
	{
		WebElement element = driver.findElement(ByXPath.xpath("//div[5]/div[2]/div/form/div/table/tbody/tr/th/input"));
		return element;
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    categoryTable
	 * Usage:           WebElement categoryTable(WebDriver driver)
	 * Description:     Category table under category pop up window
	 * Author:          Automators
	 * Dated:           06Apr2015
	 * Notes:   
	 * 
	 *************************************************************************************** **/
	public WebElement categoryTable(WebDriver driver)
	{
		WebElement element = driver.findElement(ByXPath.xpath("//div[@class='items-container multi-level']"));
		return element;
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    categoryCount
	 * Usage:           Integer categoryCount(WebDriver driver)
	 * Description:     Category table count under category pop up window
	 * Author:          Automators
	 * Dated:           06Apr2015
	 * Notes:   
	 * 
	 *************************************************************************************** **/
	public Integer categoryCount(WebDriver driver)
	{	Integer count = 0;
		count = driver.findElements(ByXPath.xpath("//div[@class='items-container multi-level']/table")).size();
		return count;
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    dynamicwait
	 * Usage:           void dynamicwait(WebDriver driver,Integer time, WebElement element)
	 * Description:     wait for given object for given time
	 * Author:          Automators
	 * Dated:           06Apr2015
	 * Notes:   
	 * 
	 *************************************************************************************** **/
	public void dynamicwait(WebDriver driver,Integer time, WebElement element)
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
	
	/** ***************************************************************************************
	 * Keyword-Name:    categoryNameInCategoryPopUp
	 * Usage:           WebElement categoryNameInCategoryPopUp(WebDriver driver)
	 * Description:     Category name with respected row
	 * Author:          Automators
	 * Dated:           07Apr2015
	 * Notes:   
	 * 
	 *************************************************************************************** **/
	public WebElement categoryNameInCategoryPopUp(WebDriver driver,Integer tableRow)
	{
		WebElement element = driver.findElement(ByXPath.xpath("//div[@class='items-container multi-level']/table[" + tableRow + "]/tbody/tr/td[2]"));
		return element;
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    categoryCheckBoxInCategoryPopUp
	 * Usage:           WebElement categoryCheckBoxInCategoryPopUp(WebDriver driver)
	 * Description:     Category check box with respected row
	 * Author:          Automators
	 * Dated:           07Apr2015
	 * Notes:   
	 * 
	 *************************************************************************************** **/
	public WebElement categoryCheckBoxInCategoryPopUp(WebDriver driver,Integer tableRow)
	{
		WebElement element = driver.findElement(ByXPath.xpath("//div[@class='items-container multi-level']/table[" + tableRow + "]/tbody/tr/td[1]/input"));
		return element;
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    addedCategory
	 * Usage:           Integer addedCategory(WebDriver driver)
	 * Description:     Added category count
	 * Author:          Automators
	 * Dated:           07Apr2015
	 * Notes:   
	 * 
	 *************************************************************************************** **/
	public Integer addedCategoryCount(WebDriver driver)
	{
		Integer element = driver.findElements(ByXPath.xpath("//div[@class='categories']/div/p")).size();
		return element;
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    addedCategoryByRow
	 * Usage:           WebElement addedCategoryByRow(WebDriver driver,Integer row)
	 * Description:     Added category by row
	 * Author:          Automators
	 * Dated:           07Apr2015
	 * Notes:   
	 * 
	 *************************************************************************************** **/
	public WebElement addedCategoryByRow(WebDriver driver,Integer row)
	{
		WebElement element = driver.findElement(ByXPath.xpath("//div[@class='categories']/div/p[" +  row + "]"));
		return element;
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    addedCategoryRadioByRow
	 * Usage:           WebElement addedCategoryRadioByRow(WebDriver driver,Integer row)
	 * Description:     Added category radio by row
	 * Author:          Automators
	 * Dated:           07Apr2015
	 * Notes:   
	 * 
	 *************************************************************************************** **/
	public WebElement addedCategoryRadioByRow(WebDriver driver,Integer row)
	{
		WebElement element = driver.findElement(ByXPath.xpath("//div[@class='categories']/div/p[" +  row + "]/input"));
		return element;
	}
	
	/** ***************************************************************************************
	 * Keyword-Name:    addedCategoryCrossByRow
	 * Usage:           WebElement addedCategoryCrossByRow(WebDriver driver,Integer row)
	 * Description:     Added category cross by row
	 * Author:          Automators
	 * Dated:           07Apr2015
	 * Notes:   
	 * 
	 *************************************************************************************** **/
	public WebElement addedCategoryCrossByRow(WebDriver driver,Integer row)
	{
		WebElement element = driver.findElement(ByXPath.xpath("//div[@class='categories']/div/p[" +  row + "]/a/img"));
		return element;
	}
	/** ***************************************************************************************
	 * Keyword-Name:    newProductAddedMessage
	 * Usage:           WebElement newProductAddedMessage(WebDriver driver)
	 * Description:     Successfully added product message
	 * Author:          Automators
	 * Dated:           09Apr2015
	 * Notes:   
	 * 
	 *************************************************************************************** **/
	public WebElement newProductAddedMessage(WebDriver driver)
	{
		WebElement element = driver.findElement(ByXPath.xpath("//div[@id='product_update']/div/div[3]/div[2]/b"));
		return element;
	}
	
	
	//=================================keshav
	
	 //NewProduct Create Button
	 public WebElement NewProduct_Create_Button(WebDriver driver) 
	    {
		    WebElement element = driver.findElement(By.xpath("(//input[@name='dispatch[products.add]'])[1]"));
			return element;
	    }
	 
	 //NewProduct Create and Close
	 public WebElement NewProduct_Create_And_Close_Button(WebDriver driver) 
	    {
		    WebElement element = driver.findElement(By.xpath("(//input[@name='dispatch[products.add]'])[2]"));
			return element;
	    }
	 
	 //NewProduct Cancel Button
	 public WebElement NewProduct_Cancel_Button(WebDriver driver) 
	    {
		    WebElement element = driver.findElement(ByLinkText.linkText("Cancel"));
			return element;
	    }
	 
	  //Product_Title Input Field
	 public WebElement NewProduct_Product_Title (WebDriver driver)
		{
			WebElement element = driver.findElement(By.xpath("//input[@id='product_description_product']"));
			return element;
		}

	 //Selling_Price Input
	 public WebElement NewProduct_Selling_Price(WebDriver driver)
		{
			WebElement element = driver.findElement(ByCssSelector.cssSelector("#price_price"));
			return element;
		}

	 //Full_Description Field on NewProduct
	 public WebElement NewProduct_Full_Description(WebDriver driver)
		{
			WebElement element = driver.findElement(By.id("tinymce"));
			return element;
		}

	 //Upload Main Picture Attach_File of the NewProduct
	 public WebElement NewProduct_Images_AttachFile(WebDriver driver)
		{
			WebElement element = driver.findElement(By.xpath("//div[@id='link_container_608714aa73b5ced0b2509ebc3c42edd0']/div/input"));
			return element;
		}
}

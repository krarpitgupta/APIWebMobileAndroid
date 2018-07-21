package pageWiseOR.BackendWeb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BackendCounterfeitCheckOut {

	
	
	public static BackendCounterfeitCheckOut getInstance(){
		BackendCounterfeitCheckOut backend=null;
		try{
			backend=new BackendCounterfeitCheckOut();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return backend;
	}

	public WebElement getAllPanelLayOut(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='main_column']/div[3]"));
		return element;
	}

	public WebElement clickToCCriteria(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='main_column']/div[4]/div[1]"));
		return element;									
	}

	public WebElement clickLowLevelCriteria(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='main_column']/div[4]/div[2]"));
		return element;
	}

	public WebElement clickToLink(WebDriver driver) {
		WebElement element=driver.findElement(By.linkText("Category"));
		return element;
	}

	public WebElement clickFashionExpand(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath("//td[.//strong[contains(text(), 'Fashion')]]/preceding-sibling::td/img"));
		return element;
	}

	public WebElement clickToEyeWear(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath("//td[.//strong[contains(text(), 'Eye Wear')]]/preceding-sibling::td/img"));
		return element;
	}
	
	public WebElement clickAddCatgAndClose(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='content_categories_1249534072']/div/form/div[2]/span[1]/input"));
		return element;
	}

	public WebElement clickToSunglass(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath("//table[.//strong[contains(text(), 'Sunglasses')]]/parent::td/preceding-sibling::td/input"));
		return element;
	}
	
	public WebElement clickToAddCatg(WebDriver driver) {
		WebElement element=driver.findElement(By.cssSelector("input.cm-process-items.cm-dialog-closer"));
		return element;									
	}

	public WebElement clickStatus(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath(".//*[@id='messageBox']"));
		return element;
	}

	
}

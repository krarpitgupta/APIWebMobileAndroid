package pageWiseOR.BackendWeb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BackEndLoginPage {

	public static BackEndLoginPage getInstance(){
		return new BackEndLoginPage();
	}
	public WebElement usernameEditBox(WebDriver driver){
		WebElement element=driver.findElement(By.id("username"));
		return element;
	}
	public WebElement passwordEditbox(WebDriver driver){
		WebElement element=driver.findElement(By.id("password"));
		return element;
	}
	public WebElement submitButton(WebDriver driver){
		WebElement element=driver.findElement(By.name("dispatch[auth.login]"));
		return element;
	}
	public WebElement userProfile(WebDriver driver){
		WebElement element=driver.findElement(By.xpath("//div[@id='top_quick_links']/div/a/span"));
		return element;
	}
	public WebElement errorMsg(WebDriver driver){
		WebElement element=driver.findElement(By.xpath("//div/div[2]"));
		return element;
	}
}

/* ***************************************************************************************
 * Object Repository-Name:	pageWiseOR/androidApp/LoginPage.java
 * Description:	Object Repository to define objects in ShopClues| Android App| Login Page
 * Author:		Sahil Jariwala
 * Dated:		16Mar2015
 * Notes:	
 *  
 *************************************************************************************** */
// Package name: pageWiseOR.androidApp
package pageWiseOR.androidApp;

//List of packages to be imported for androidApp/LoginPage.java
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//'LoginPage' class defined to include objects in ShopClues| Android App| Login Page
public class LoginPage {
	
	public static LoginPage getInstance()
	{
		return new LoginPage();
	}

	public WebElement emailField(WebDriver driver)
	{
		WebElement element=driver.findElement(By.id("com.et.reader.activities:id/b.login.details.email"));
		return element;
	}
	
	public WebElement passwordField(WebDriver driver)
	{
		WebElement element=driver.findElement(By.id("com.et.reader.activities:id/b.login.details.password"));
		
		
		   return element;
	}
	
	public WebElement loginButton(WebDriver driver)
	{
		WebElement element=driver.findElement(By.id("com.et.reader.activities:id/b.login.login"));
		return element;
	}
	
	
}

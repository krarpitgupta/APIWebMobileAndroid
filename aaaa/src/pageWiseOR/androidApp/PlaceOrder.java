package pageWiseOR.androidApp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PlaceOrder {

	public static PlaceOrder getInstance(){
		return new PlaceOrder();
	}

	public WebElement clickAndValidatePlaceOdrButton(WebDriver driver) {
		// TODO Auto-generated method stub
		WebElement element=driver.findElement(By.id("com.shopclues:id/place_order"));
		return element;
	}

	public WebElement fetchSignInPage(WebDriver driver) {
		// TODO Auto-generated method stub
		WebElement element=driver.findElement(By.id("com.shopclues:id/userInformation"));
		return element;								
	}

	public WebElement getUserPhoneNumber(WebDriver driver) {
		WebElement element=driver.findElement(By.id("com.shopclues:id/phone"));
		return element;								 
	}

	public WebElement user_City_State(WebDriver driver) {
		WebElement element=driver.findElement(By.id("com.shopclues:id/city"));
		return element;								  
	}

	public WebElement user_PinCode(WebDriver driver) {
		WebElement element=driver.findElement(By.id("com.shopclues:id/pincode"));
		return element;								 
	}

	public WebElement clickContinue(WebDriver driver) {
		WebElement element=driver.findElement(By.id("com.shopclues:id/continueButtonforScreen2"));
		return element;
	}
	
	
}
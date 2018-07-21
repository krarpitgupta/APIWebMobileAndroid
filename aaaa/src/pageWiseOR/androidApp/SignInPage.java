package pageWiseOR.androidApp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignInPage {

	/**
	 * @param args
	 */
	
	public static SignInPage getInstance(){
		return new SignInPage();
	}

	public WebElement SignIn_HomePage(WebDriver driver) {
		// TODO Auto-generated method stub
		WebElement element=driver.findElement(By.id("com.shopclues:id/product_name"));
		return element;
	}

	public WebElement userNameTextField(WebDriver driver) {
		// TODO Auto-generated method stub
		WebElement element=driver.findElement(By.id("com.shopclues:id/userName"));
		return element;
	}

	public WebElement passwordTextField(WebDriver driver) {
		// TODO Auto-generated method stub
		WebElement element=driver.findElement(By.id("com.shopclues:id/password"));
		return element;
	}

	public WebElement clickTo_Login(WebDriver driver) {
		WebElement element=driver.findElement(By.id("com.shopclues:id/login"));
		return element;
	}

	public WebElement clickTo_DotMenu(WebDriver driver) {
		// TODO Auto-generated method stub
		WebElement element=driver.findElement(By.id("com.shopclues:id/action_more"));
		return element;
	}

	public WebElement clickViewprofile(WebDriver driver) {
		// TODO Auto-generated method stub
		WebElement element=driver.findElement(By.id("com.shopclues:id/tvViewProfile"));
		return element;
	}

	public WebElement clickOn_MyProfile(WebDriver driver) {
		// TODO Auto-generated method stub
		WebElement element=driver.findElement(By.id("com.shopclues:id/myProfile"));
		return element;
	}

	public WebElement phoneNo_Field(WebDriver driver) {
		WebElement element=driver.findElement(By.id("com.shopclues:id/mobile"));
		return element;								 
	}

	public WebElement email_Field(WebDriver driver) {
		// TODO Auto-generated method stub
		WebElement element=driver.findElement(By.id("com.shopclues:id/email"));
		return element;
	}

	public WebElement clickTo_EditButton(WebDriver driver) {
		// TODO Auto-generated method stub
		WebElement element=driver.findElement(By.id("com.shopclues:id/edit_button"));
		return element;
	}

	public WebElement firstName_TextField(WebDriver driver) {
		// TODO Auto-generated method stub
		WebElement element=driver.findElement(By.id("com.shopclues:id/firstName"));
		return element;
	}

	public WebElement lastName_TextField(WebDriver driver) {
		// TODO Auto-generated method stub
		WebElement element=driver.findElement(By.id("com.shopclues:id/lastName"));
		return element;
	}

	public WebElement phoneNo_TextField(WebDriver driver) {
		// TODO Auto-generated method stub
		WebElement element=driver.findElement(By.id("com.shopclues:id/phone"));
		return element;
	}

	public WebElement email_TextField(WebDriver driver) {
		// TODO Auto-generated method stub
		WebElement element=driver.findElement(By.id("com.shopclues:id/email"));
		return element;
	}

	public WebElement clickTo_ChangePassword(WebDriver driver) {
		// TODO Auto-generated method stub
		WebElement element=driver.findElement(By.id("com.shopclues:id/password_change"));
		return element;
	}

	public WebElement clickTo_CurrentPassword(WebDriver driver) {
		// TODO Auto-generated method stub
		WebElement element=driver.findElement(By.id("com.shopclues:id/current_pwd"));
		return element;
	}

	public WebElement clickTo_NewPassword(WebDriver driver) {
		// TODO Auto-generated method stub
		WebElement element=driver.findElement(By.id("com.shopclues:id/new_pwd"));
		return element;
	}

	public WebElement clickTo_ConfirmPassword(WebDriver driver) {
		// TODO Auto-generated method stub
		WebElement element=driver.findElement(By.id("com.shopclues:id/cuonfirm_pwd"));
		return element;
	}

	public WebElement clickTo_SavePassword(WebDriver driver) {
		// TODO Auto-generated method stub
		WebElement element=driver.findElement(By.id("com.shopclues:id/save"));
		return element;								 
	}
	

}

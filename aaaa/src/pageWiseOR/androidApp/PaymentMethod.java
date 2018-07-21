package pageWiseOR.androidApp;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PaymentMethod {

	
	public static PaymentMethod getInstance(){
		return new PaymentMethod();
	}

	public WebElement verifyPaymentPage(WebDriver driver) {
		// TODO Auto-generated method stub
		WebElement element=driver.findElement(By.id("com.shopclues:id/CreditCard"));
		return element;
	}

	public List<WebElement> verifyRadioButton(WebDriver driver) {
		// TODO Auto-generated method stub
		List<WebElement> list=driver.findElements(By.className("android.widget.RadioButton"));
		return list;
	}
	
	public WebElement getDropDownTextFieldObject(WebDriver driver){
		WebElement element=driver.findElement(By.id("android:id/text1"));
		return element;
	}
	
	public String getStringFromTextField(WebDriver driver){
		WebElement element=null;
		try{
			element=driver.findElement(By.id("android:id/text1"));
		
		}catch(Exception e){e.printStackTrace();}
		return element.getText();
	}

	public List<WebElement> verifyGiftCertificate(WebDriver driver) {
		List<WebElement> element=driver.findElements(By.className("android.widget.TextView"));
		return element;
	}

	public WebElement clickToGiftCertificateCode(WebDriver driver) {
		WebElement element=driver.findElement(By.id("com.shopclues:id/GiftCertificateCode"));
		return element;
	}

	public WebElement clickToApplyLink(WebDriver driver) {
		WebElement element=driver.findElement(By.id("com.shopclues:id/applyButton2"));
		return element;
	}

	public WebElement clickToCluesBucksTextField(WebDriver driver) {
		WebElement element=driver.findElement(By.id("com.shopclues:id/clueCode"));
		return element;
	}

	public WebElement clickToApplyLinkCluesBucks(WebDriver driver) {
		WebElement element=driver.findElement(By.id("com.shopclues:id/applyButton3"));
		return element;
	}

	public WebElement clickToGrandTotal(WebDriver driver) {
		WebElement element=driver.findElement(By.id("com.shopclues:id/total_value"));
		return element;
	}

	public WebElement clickToSubtotal(WebDriver driver) {
		WebElement element=driver.findElement(By.id("com.shopclues:id/subtotal_value"));
		return element;
	}

	public WebElement clickToCluesInUse(WebDriver driver) {
		WebElement element=driver.findElement(By.id("com.shopclues:id/cluesBuckInUse"));
		return element;
	}

	public WebElement clickToGiftCertiInUse(WebDriver driver) {
		WebElement element=driver.findElement(By.id("com.shopclues:id/GFInUse"));
		return element;
	}
	
}

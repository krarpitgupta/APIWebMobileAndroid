package pageWiseOR.androidApp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SettingsPage {
	
	
	public static SettingsPage getInstance()
	{
		return new SettingsPage();
	}
    
	public WebElement loginStatus(WebDriver driver)
	{
		WebElement element=driver.findElement(By.id("com.et.reader.activities:id/tv.settings.loginstatus"));
		return element;
	}
	
	public WebElement loginButton(WebDriver driver)
	{
		WebElement element=driver.findElement(By.id("com.et.reader.activities:id/b.settings.login"));
		return element;
	}
}

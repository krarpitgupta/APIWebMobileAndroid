package pageWiseOR.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PopUpOnHomePage {

 public static PopUpOnHomePage getInstance(){
  return new PopUpOnHomePage();
  
 }
 public WebElement acceptButton(WebDriver driver){
  WebElement element=driver.findElement(By.id("submit_deny_access"));
  return element;
  
 }
 public WebElement gmailTextField(WebDriver driver)
 {
  WebElement element = driver.findElement(By.id("Email"));
  return element;

 }
   public WebElement gmailPasswordTextField(WebDriver driver)
   {
    WebElement element = driver.findElement(By.id("Passwd"));
  return element;

   }
   public WebElement gmailLoginButton(WebDriver driver){
    WebElement element =driver.findElement(By.id("signIn"));
    return element;
   }
   public WebElement linkedinTextField(WebDriver driver)
 {
  WebElement element = driver.findElement(By.id("session_key-oauth2SAuthorizeForm"));
  return element;

 }
  public WebElement linkedinPasswordTextField(WebDriver driver)
  {
    WebElement element = driver.findElement(By.id("session_password-oauth2SAuthorizeForm"));
  return element;

  }
  public WebElement linkedinLoginButton(WebDriver driver){
    WebElement element =driver.findElement(By.name("authorize"));
    return element;
  }
  public WebElement facebookTextField(WebDriver driver)
 {
  WebElement element = driver.findElement(By.id("email"));
  return element;

 }
public WebElement facebookPasswordTextField(WebDriver driver)
{
    WebElement element = driver.findElement(By.id("pass"));
  return element;

}
public WebElement facebookLoginButton(WebDriver driver){
    WebElement element =driver.findElement(By.name("login"));
    return element;
}
public WebElement facebookSkipButton(WebDriver driver){
    WebElement element =driver.findElement(By.name("__SKIP__"));
    return element;
}
}
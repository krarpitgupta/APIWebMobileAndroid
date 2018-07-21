package session;

import io.appium.java_client.AppiumDriver;  
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.Enumeration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.GlobalVar;
import utilities.Keywords;

import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;

public class DriverFactory {

	private Properties masterProp = null;
	private WebDriver driver = null;
	private AppiumDriver drivers=null;
	private DesiredCapabilities driverCapabilities = null;
	private WebDriverWait driverWait = null;
	private String flavour = null;
//	private WebDriverBackedSelenium selenium;
	private Properties environment;
	
	public DriverFactory() {
		// TODO Auto-generated constructor stub
	}

	public DriverFactory(String flavour) {
		this.flavour = flavour;
		loadMasterProperties(flavour);
		loadDesiredCapabilities();
		initDriver();
	}

	public static DriverFactory getInstance(){
		return new DriverFactory();
	}
	
	void initDriver() {
		try {
			
			if (flavour.equals("iosApp") || flavour.equals("androidApp")
					|| flavour.equals("androidWeb")) 
			{
				drivers =new AndroidDriver(new URL(
						masterProp.getProperty("baseURL")), driverCapabilities) {
					
					@Override
					public MobileElement scrollToExact(String arg0) {
						// TODO Auto-generated method stub
						return null;
					}
					
					@Override
					public MobileElement scrollTo(String arg0) {
						// TODO Auto-generated method stub
						return null;
					}
				};
				
				driver=drivers;
				new Keywords(drivers);
				
			} else if (flavour.equals("DesktopWeb") || flavour.equals("backEndWeb")) {	
				 String seleniumServer=masterProp.getProperty("seleniumServer");
				    System.out.println("*******seleniumServer*******************************************"+seleniumServer);
				    
				    if(seleniumServer.isEmpty())
				    	seleniumServer="localhost";
				    String PLATFORM = loadMasterEnvironment("PLATFORM","suiteExecution");
				    Platform platform = null;
				    
				    if(PLATFORM.equalsIgnoreCase("linux"))
				    	platform=platform.LINUX;
				    
				    else if(PLATFORM.equalsIgnoreCase("mac"))
				    	platform=platform.MAC;
				    
				    else if(PLATFORM.equalsIgnoreCase("windows"))
				    	platform=platform.WINDOWS;
				    
				    else
				    	platform=platform.ANY;
				    
				if (GlobalVar.BrowserName.equalsIgnoreCase("firefox")) {
					DesiredCapabilities    capability = DesiredCapabilities.firefox();
					capability.setPlatform(platform);
				    
				    RemoteWebDriver driver1 = new RemoteWebDriver(new URL("http://"+seleniumServer+":5555/wd/hub"), capability);
				    driver=driver1;
					
					driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				//	selenium= new WebDriverBackedSelenium(driver1, getUrl(GlobalVar.serverName));
					
					
				}else if(GlobalVar.BrowserName.equalsIgnoreCase("chrome")){
					String driverPath = loadMasterEnvironment("WEB_DRIVER_CHROME","suiteExecution");
					DesiredCapabilities    capability = DesiredCapabilities.chrome();
					capability.setPlatform(platform);
					System.setProperty("webdriver.chrome.driver",driverPath);
					RemoteWebDriver driver1 = new RemoteWebDriver(new URL("http://"+seleniumServer+":5555/wd/hub"), capability);
				    driver=driver1;
					//driver = new FirefoxDriver();
					driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				//	selenium= new WebDriverBackedSelenium(driver1, getUrl(GlobalVar.serverName));
					
				}else if(GlobalVar.BrowserName.equalsIgnoreCase("ie")){
					String driverPath=loadMasterEnvironment("WEB_DRIVER_INTERNET","suiteExecution");
					
					DesiredCapabilities    capability = DesiredCapabilities.internetExplorer();
					capability.setPlatform(platform);
					System.setProperty("webdriver.ie.driver",driverPath);
					RemoteWebDriver driver1 = new RemoteWebDriver(new URL("http://"+seleniumServer+":5555/wd/hub"), capability);
				    driver=driver1;
					//driver = new FirefoxDriver();
					driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				//	selenium= new WebDriverBackedSelenium(driver1, getUrl(GlobalVar.serverName));
					
				} 
				else if(GlobalVar.BrowserName.equalsIgnoreCase("safari")){
					String driverPath = loadMasterEnvironment("WEB_DRIVER_SAFARI","suiteExecution");
					DesiredCapabilities    capability = DesiredCapabilities.safari();
					capability.setPlatform(platform);
					System.setProperty("webdriver.safari.driver",driverPath);
					RemoteWebDriver driver1 = new RemoteWebDriver(new URL("http://"+seleniumServer+":5555/wd/hub"), capability);
				    driver=driver1;
					//driver = new FirefoxDriver();
					driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	// selenium= new WebDriverBackedSelenium(driver1, getUrl(GlobalVar.serverName));
					
				} else if (flavour.equals("API")) {				
						GlobalVar.url=getUrl(GlobalVar.serverName);	
						GlobalVar.staticKey=getStaticKey();
					}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	void loadDesiredCapabilities() {
		driverCapabilities = new DesiredCapabilities();
		try {
			Enumeration<?> e = masterProp.propertyNames();
			while (e.hasMoreElements()) {
				String prop = (String) e.nextElement();
				if (prop.startsWith("cap_")) {

					String capName = prop.replaceAll("cap_", "");
					String capVal = masterProp.getProperty(prop);

					if (capName.equals("app"))
						capVal = System.getProperty("user.dir") + "/app/"
								+ capVal;

					if (capVal.equals("<NULL>"))
						capVal = "";
					driverCapabilities.setCapability(capName, capVal);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	void loadMasterProperties(String flavour) {
		masterProp = new Properties();
		String fileLoc = GlobalVar.CURRENT_PROJECT_PATH + "/" + flavour
				+ ".properties";
		try {
			File f = new File(fileLoc);
			FileInputStream fis = new FileInputStream(f);
			masterProp.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebDriverWait getWait() {
		return driverWait;
	}

	public String getUrl(String server) {
	//	System.out.println(masterProp.toString());
		  System.out.println("*******getUrl*******************************************"+server+masterProp.getProperty(server));
		return masterProp.getProperty(server);
	}
	
	public String getVendorUrl()
	{
		return masterProp.getProperty("vendorUrl");
	}
	public String getStaticKey()
	{
		return masterProp.getProperty("API_Static_Key");
	}
	
	public String loadMasterEnvironment(String key,String e_name){
		//"/home/shopclues/ShopClues/DemoTest/src/Environment.properties";
		try{
			environment=new Properties();
			
			String fileLocation=GlobalVar.CURRENT_PROJECT_PATH+"/"+ e_name +".properties";
			try{
				File file=new File(fileLocation);
				FileInputStream fis=new FileInputStream(file);
				environment.load(fis);
			}
			catch(Exception e){
				e.getMessage();
			}
			
		}
		catch(Exception e){
			e.getMessage();
		}
		return environment.getProperty(key);
		
	}

}

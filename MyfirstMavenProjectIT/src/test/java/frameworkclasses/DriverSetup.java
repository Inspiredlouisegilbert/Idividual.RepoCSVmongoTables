package frameworkclasses;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DriverSetup {
	public static WebDriver driver;
	
	//ReusableFunctions sfSelenium = new ReusableFunctions();

	/**
	 * This function will execute before each Test tag in testng.xml
	 * @param browser
	 * @throws Exception
	 */
	@BeforeClass
	@Parameters("browser")
	public void setup(String browser) throws Exception{
		
		String pdriverDir = getDataConfigProperties("driverdir");
		//Check if parameter passed from TestNG is 'firefox'
		if(browser.equalsIgnoreCase("firefox")){
		//create firefox instance
			System.setProperty("webdriver.gecko.driver", pdriverDir+"geckodriver.exe");
			driver = new FirefoxDriver();
		}
		//Check if parameter passed as 'chrome'
		else if(browser.equalsIgnoreCase("Chrome")){
			//set path to chromedriver.exe
			System.setProperty("webdriver.chrome.driver",pdriverDir+"chromedriver.exe");
			//create chrome instance
			driver = new ChromeDriver();
		}
		//Check if parameter passed as 'Edge'
//				else if(browser.equalsIgnoreCase("Edge")){
//					//set path to Edge.exe
//					System.setProperty("webdriver.edge.driver",pdriverDir+"MicrosoftWebDriver.exe");
//					//create Edge instance
//					setDriver(new EdgeDriver());
//				}
		else{
			//If no browser passed throw exception
			throw new Exception("Browser is not correct");
		}
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(1, TimeUnit.SECONDS);
	}
	
	public String getDataConfigProperties(String propertyName) {
		// Properties setup
		Properties p = new Properties();
		InputStream is = null;
		try {
			is = new FileInputStream("config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			p.load(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	return p.getProperty(propertyName);

	}

//	public WebDriver getDriver() {
//		return driver;
//	}
//
//	public void setDriver(WebDriver driver) {
//		this.driver = driver;
//	}
}

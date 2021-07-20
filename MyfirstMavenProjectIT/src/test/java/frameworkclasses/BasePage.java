package frameworkclasses;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.TestRunner;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BasePage {
    
    
    //Declare the WebDriver
    public static WebDriver driver;
   
   
    
    //constructor of base class
    public BasePage() {
    	
    	
        if (driver == null) {
        	
        	// Get parameter values
        	String browser = getDataConfigProperties("browser");
        	String systemUnderTest = getDataConfigProperties("systemUnderTestAss");
            String pdriverDir = getDataConfigProperties("driverdir");
            
    		//Check if parameter passed is 'firefox'
    		if(browser.equalsIgnoreCase("firefox")){
    		//create firefox instance
    			System.setProperty("webdriver.gecko.driver", pdriverDir+"geckodriver.exe");
    			driver     = new FirefoxDriver();
    			driver.get(systemUnderTest);
                driver.manage().window().maximize();
    			
    		}
    		//Check if parameter passed as 'chrome'
    		else if(browser.equalsIgnoreCase("chrome")){
    			//set path to chromedriver.exe
    			System.setProperty("webdriver.chrome.driver",pdriverDir+"chromedriver.exe");
    			//create chrome instance
    			driver     = new ChromeDriver();
    			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
    			//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    			driver.get(systemUnderTest);
                driver.manage().window().maximize();
    			
    		}
    		//Check if parameter passed as 'Edge'
    		else if(browser.equalsIgnoreCase("Edge")){
    			//set path to Edge.exe
    			System.setProperty("webdriver.edge.driver",pdriverDir+"MicrosoftWebDriver.exe");
    			//create Edge instance
    			driver     = new EdgeDriver();
    			driver.get(systemUnderTest);
    	        driver.manage().window().maximize();
    			
    		}
        }
            
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
	




}
    

package frameworkclasses;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.rmi.UnknownHostException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import org.bson.Document;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.pdfbox.pdmodel.PDDocument;
import org.pdfbox.util.PDFTextStripper;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

// Mongo DB imports
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.DB;



// This class manages all Selenium Functions and the Driver
public class demoTest extends DriverSetup {
	
	
	ReusableFunctions sfSelenium = new ReusableFunctions();
	int randomisednumber = sfSelenium.generateRandomData(1, 7);
	
	@Test
	public void demoRefactoredFunctions() throws InterruptedException{
		driver.get("http://demo.guru99.com/V4/");
		sfSelenium.populateInputField(By.name("uid"), "guru99",driver);
		sfSelenium.populateInputField(By.name("password"), "guru99",driver);
		sfSelenium.clickLink("Bank Project",driver);
		
		System.out.println("Random number" + randomisednumber );
		System.out.println(getDataConfigProperties("logFileDir"));
		//System.out.println(randomisednumber);
		//sfSelenium.CloseSelenium(driver);

	}
	
	@AfterClass
	public void cleanup() throws InterruptedException{
		sfSelenium.CloseSelenium(driver);

	}
}



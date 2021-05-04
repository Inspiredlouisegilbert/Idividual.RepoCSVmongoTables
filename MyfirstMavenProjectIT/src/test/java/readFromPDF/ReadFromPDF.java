package readFromPDF;

import static org.testng.Assert.fail;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.junit.AfterClass;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.pdfbox.pdmodel.PDDocument;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import frameworkclasses.SeleniumFunctions;


public class ReadFromPDF {
	String pURL = "http://demo.guru99.com/V1/index.php";
	
	SeleniumFunctions sfSelenium = new SeleniumFunctions();
	
	// driver variable
	WebDriver driver;
	
	public String getProperties(String pPropertyKey) {
		// Properties setup
				Properties p = new Properties();
				InputStream is = null;
				try {
					is = new FileInputStream("dataConfig.properties");
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
		return p.getProperty(pPropertyKey);
	}

	// Get PDF content
	public String getPDFContent() throws Exception {
        String pdfurl = "http://www.africau.edu/images/default/sample.pdf";
        int expectedNoPages = 2;
        
        this.driver.get(pdfurl);
        String pdfContent = sfSelenium.readPDFContent(this.driver.getCurrentUrl(), expectedNoPages);
        return pdfContent;
        
    }
	
	// Run Test Section
	@BeforeTest
	public void beforeClass() throws Exception {
		this.driver = sfSelenium.getDriver();
		sfSelenium.startReport("Read From PDF Report", "PDF Report");
		sfSelenium.createTest("Test Started: Read From PDF Report");
	}
	
	@Test
	public void testLookForTextInPDF() throws Exception {
		
		String returnpdfContent = getPDFContent();
		//System.out.println(returnpdfContent);
		Assert.assertTrue(returnpdfContent.contains("This is a small demonstration .pdf file"));
		

	}
	
	@Test
	public void testEnsurePDFdoesNotContain() throws Exception {
		
		String returnpdfContent = getPDFContent();
		//System.out.println(returnpdfContent);
        Assert.assertFalse(returnpdfContent.contains("Louise"));
	}
	
	@Test
	public void expectedToFail() throws Exception {
		
		String returnpdfContent = getPDFContent();
		//System.out.println(returnpdfContent);
        Assert.assertTrue(returnpdfContent.contains("Louise"));
	}
	
	public void PagesEq2() throws Exception {
		
		//int pgCount = sfSelenium.getPageCount(PDDocument doc)();
		String returnpdfContent = getPDFContent();
		//System.out.println(returnpdfContent);
        Assert.assertTrue(returnpdfContent.contains("Louise"));
	}
	
	@AfterTest
	public void afterTest() throws Exception {
		sfSelenium.CloseSelenium();
	}

}
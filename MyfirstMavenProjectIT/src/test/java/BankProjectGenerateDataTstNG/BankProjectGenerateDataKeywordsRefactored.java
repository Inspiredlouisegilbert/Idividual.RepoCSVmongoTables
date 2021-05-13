package BankProjectGenerateDataTstNG;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.NoSuchElementException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;
import frameworkclasses.DriverSetup;
import frameworkclasses.ReusableFunctions;


public class BankProjectGenerateDataKeywordsRefactored extends DriverSetup{

	//INSTANTIATE NEW INSTANCE OF SELENIUM FUNCTIONS
	ReusableFunctions sfSelenium = new ReusableFunctions();
	
	// Set URL
	String pURL = "http://demo.guru99.com";
	
	//Temp
	boolean eleDisplayed;
	
	//Set invalid data
	String sInvalidId = "test@test";
	String sInvalidPassword = "Passwo";
	
	//Create a new file
	
	String logfilename = constructFileName();
	File log = new File(logfilename);
	
	
	public String constructFileName() {
		Date date = Calendar.getInstance().getTime();  
	    DateFormat dateFormat = new SimpleDateFormat("yyyymmddhhmmss");  
	    String strDate = dateFormat.format(date);  
	    String loglogfilename = sfSelenium.getDataConfigProperties("logFileDir") + strDate + ".csv";
		return loglogfilename;
	}
	
	//NAVIGATE TO URL
	public void navigateToURL(String pURL) {
		driver.get(pURL);
		//sfSelenium.maximiseBrowserWindow();
	}
	
		//NAVIGATE TO BANK PROJECT
		public void clickBankProject() {
			sfSelenium.clickLink("Bank Project",driver);
			
		}
		
		public void validateEmailAddress(String sValidateEmailAddress) {
			//CREATE TEST TO VALIDATE EMAIL ADRESS
			sfSelenium.clickLink("here",driver);
			driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys(sValidateEmailAddress);
			driver.findElement(By.name("btnLogin")).click();
		}
	
		//GENERATE USERNAME AND PASSWORD
		public void generateValidLogins(int randomisednumber) throws IOException, InterruptedException {
			//sfSelenium.clickLink("Bank Project");
			//sfSelenium.clickLink("here");
			String cssUserID = "body:nth-child(2) table:nth-child(10) tbody:nth-child(1) tr:nth-child(4) > td:nth-child(2)";
			String sUserID = this.driver.findElement(By.cssSelector(cssUserID)).getText();
			String cssPassword = "body:nth-child(2) table:nth-child(10) tbody:nth-child(1) tr:nth-child(5) > td:nth-child(2)";
			String sPassword = this.driver.findElement(By.cssSelector(cssPassword)).getText();
			String pOutcome = "";
			
			//NAVIGATE BACK TO THE BANK PROJECT
			sfSelenium.clickLink("Bank Project",driver);
			populateInpute(sUserID,sPassword);
			successfulLogin();
			writeToFile(sUserID,sPassword,randomisednumber, eleDisplayed);
		}
			
		//POPULATE INPUT FIELDS
		public void populateInpute(String pUsersID ,String pPassword) {
			sfSelenium.populateInputField(By.name("uid"), pUsersID,driver);
			sfSelenium.populateInputField(By.name("password"), pPassword,driver);
			driver.findElement(By.name("btnLogin")).click();
			
		}
		
		//CREATE METHOD TO CLICK ON CLEAR AND ASSERT THAT INPUT FIELDS HAS BEEN REMOVED
		public void successfulLogin() {
			//ASSERT FOR IMAGE AFTER SUCCESSFUL LOGIN
			try {
				eleDisplayed = driver.findElement(By.cssSelector("table.layout:nth-child(5) tbody:nth-child(1) tr:nth-child(1) td:nth-child(1) center:nth-child(1) > img:nth-child(1)")).isDisplayed();
				System.out.println("Successful Login Assertion passed: " + eleDisplayed);
				//sfSelenium.createTest("Successful Login");
			}
			catch(NoSuchElementException e) {
				System.out.println(e);
			}
		}
		
		public void unsuccessfulPopup() throws InterruptedException {
			try {
				//HANDLE UNSUCCESSFUL POPUP ALERT
				String pExpectedMessage = "User is not valid";
				
				//CREATE AN OBJECT OF THE POPUP
				Alert alert = this.driver.switchTo().alert();
				String sAlertMessage = alert.getText();
				System.out.println(sAlertMessage);

				alert.accept();
				eleDisplayed = driver.findElement(By.cssSelector("table.layout:nth-child(5) tbody:nth-child(1) tr:nth-child(1) td:nth-child(1) center:nth-child(1) > img:nth-child(1)")).isDisplayed();
				
				Thread.sleep(500);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		}
		
		public void writeToFile (String p1, String p2, int randomisednumber, boolean pEleDisplayed) throws IOException, InterruptedException {

					    try{
					    if(log.exists()==false){
					            System.out.println("We had to make a new file.");
					            log.createNewFile();
					    }
					    PrintWriter out = new PrintWriter(new FileWriter(log, true));
					    String outCome;
					    if (pEleDisplayed) {
					    	outCome = "Testcase Successful";
					    }
					    else {
					    	outCome = "Testcase Unsuccessful";
					    }
					    
						out.append(p1 + "," + p2 + "," +randomisednumber+ ","+outCome+"\n");
					    out.close();
					    }catch(IOException e){
					        System.out.println("COULD NOT LOG!!");
					    }
	}
	
		//RUN TESTS
		@Test 
		public void testCase1 () throws IOException, InterruptedException {
			//Create a randomised email address
			int iMin = 0;
			int iMax = 1000;
			int randomisednumber = sfSelenium.generateRandomData(iMin, iMax);
			String sValidateEmailAddress = randomisednumber+"@gmail.com";
			navigateToURL(pURL);
			clickBankProject();
			validateEmailAddress(sValidateEmailAddress);
			generateValidLogins(randomisednumber);
		}
		
		@Test
		public void testCase2 () throws IOException, InterruptedException {
			navigateToURL(pURL);
			clickBankProject();
			populateInpute(sInvalidId,sInvalidPassword);
			unsuccessfulPopup();
			writeToFile(sInvalidId,sInvalidPassword,-1, eleDisplayed);
		}
		
		@AfterSuite
		public void cleanup () throws IOException, InterruptedException {
			sfSelenium.CloseSelenium(driver);
		}
}

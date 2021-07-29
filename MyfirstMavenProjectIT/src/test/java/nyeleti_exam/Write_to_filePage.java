package nyeleti_exam;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.fail;

import java.io.IOException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;



import org.testng.annotations.Parameters;



import frameworkclasses.BasePage;
import frameworkclasses.SeleniumFunctions;

public class Write_to_filePage {

	//Create a new file
		String sFormatedData = createNewCSVFile();
		File log = new File("C:\\Program Files\\Selenium\\Write_to_file"+sFormatedData+".csv");
		
		//Return the date string
		public String createNewCSVFile() {
			//Set the date string
			Date date = Calendar.getInstance().getTime();  
		    DateFormat dateFormat = new SimpleDateFormat("yyyymmddhhmmss");  
		    String strDate = dateFormat.format(date);  
		    //System.out.println("Converted String: " + strDate); 
		    return strDate;
		    
		    
		    
		    
		}
		
		 			
			
		public void writeToFile (String p1, String p2) throws IOException, InterruptedException {
			
			


					    try{
					    if(log.exists()==false){
					            System.out.println("We had to make a new file.");
					            log.createNewFile();
					    }
					    PrintWriter out = new PrintWriter(new FileWriter(log, true));
					    
				
					    
						out.append(p1 + "," + p2 +"\n");
					    out.close();
					    }catch(IOException e){
					        System.out.println("COULD NOT LOG!!");
					    }
		}

			
		@Test
		public void testCase2 () throws IOException, InterruptedException {
			
			writeToFile("p1","p2");
		}
		
		
		//write table data to file
public void WriteToFile() throws IOException {
        FileWriter myWriter = new FileWriter("StoreBillingInfo.csv");

      myWriter.write(driver.findElement(By.cssSelector(".alt")).getText());
        
        myWriter.close();
}


public class RW_File {



	 public static void main(String[] args) throws IOException {

	  //Create File In D: Driver. 

	  String TestFile = "D:\\temp.txt";

	  File FC = new File(TestFile);//Created object of java File class.

	  FC.createNewFile();//Create file.

	 

	  //Writing In to file.

	  //Create Object of java FileWriter and BufferedWriter class.

	  FileWriter FW = new FileWriter(TestFile);

	  BufferedWriter BW = new BufferedWriter(FW);

	  BW.write("This Is First Line."); //Writing In To File.

	  BW.newLine();//To write next string on new line.

	  BW.write("This Is Second Line."); //Writing In To File.

	  BW.close();



}

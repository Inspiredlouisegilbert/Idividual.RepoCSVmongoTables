package testngdemo;

import java.io.IOException;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Testngdemo2 {

//	@BeforeSuite
//	public void setUpTest() {
//		System.out.println("starting");
//	}
	
	@Test
	public void test4() throws IOException, InterruptedException {
		System.out.println("test4");
		Assert.assertTrue(false);
	}
	
	@Test
	public void test5() throws IOException, InterruptedException {
	
		System.out.println("test5");
		throw new SkipException("this is a skipped test");
	}
	
	@Test
	public void test6() throws IOException, InterruptedException {
		System.out.println("test6");
		Assert.assertTrue(true);
	}
	
//	@AfterSuite
//	public void tearDownTest() throws IOException, InterruptedException {
//		System.out.println("ending");
//	}

}
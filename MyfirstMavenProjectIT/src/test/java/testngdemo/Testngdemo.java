package testngdemo;

import java.io.IOException;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Testngdemo {

	@BeforeSuite
	public void setUpTest() {
		System.out.println("starting");
	}
	
	@Test
	public void test1() throws IOException, InterruptedException {
		System.out.println("test1");
		Assert.assertTrue(false);
	}
	
	@Test
	public void test2() throws IOException, InterruptedException {
	
		System.out.println("test2");
		throw new SkipException("this is a skipped test");
	}
	
	@Test
	public void test3() throws IOException, InterruptedException {
		System.out.println("test3");
		Assert.assertTrue(true);
	}
	
	@AfterSuite
	public void tearDownTest() throws IOException, InterruptedException {
		System.out.println("ending");
	}

}
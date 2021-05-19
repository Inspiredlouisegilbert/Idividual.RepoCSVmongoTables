
package testngListeners;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//@Listeners(testngListeners.TestNGlisteners.class)
public class TestNGListenerDemo2 {
	
	@Test
	public void test4() {
		System.out.println("I am in test 4");
	}
	
	@Test
	public void test5() {
		System.out.println("I am in test 5");
		Assert.assertTrue(false);
	}
	
	@Test
	public void test6() {
		System.out.println("I am in test 6");
		throw new SkipException("this is a skipped test");
	}

}


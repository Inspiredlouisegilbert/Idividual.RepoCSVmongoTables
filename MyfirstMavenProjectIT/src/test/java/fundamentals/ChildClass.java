package fundamentals;

import org.testng.annotations.Test;

public class ChildClass extends ParentClass {
	

	
	public void overLoadExample() {
		System.out.println("overRideExample");
	}
	
	public void overLoadExample(String inputExample) {
		System.out.println("String Overrid Example:" + inputExample);
	}
	
	public void overLoadExample(int inputIntExample) {
		System.out.println("int Overrid Example:" +inputIntExample);
	}
	
	public void overLoadExample(int inputIntExample, String inputExample) {
		System.out.println("int Overrid Example:" +inputIntExample + " String Overrid Example:" + inputExample);
	}
	
	@Test
	public void getDt()
	{
		getData();
		System.out.println("I am in child class");
		overLoadExample();
		overLoadExample("passing in data");
		overLoadExample(1);
		overLoadExample(1,"passing in data");
	}

}

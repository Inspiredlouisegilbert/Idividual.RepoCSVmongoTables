package fundamentals;

import org.testng.annotations.Test;

public class ChildClass extends ParentClass {
	String name ="QAClickAcademy";

	
	public void overRideExample() {
		System.out.println("overRideExample");
	}
	
	public void overRideExample(String inputExample) {
		System.out.println("String Overrid Example:" + inputExample);
	}
	
	public void overRideExample(int inputIntExample) {
		System.out.println("int Overrid Example:" +inputIntExample);
	}
	
	public void overRideExample(int inputIntExample, String inputExample) {
		System.out.println("int Overrid Example:" +inputIntExample + " String Overrid Example:" + inputExample);
	}
	
	@Test
	public void getDt()
	{
		getData();
		System.out.println("I am in child class");
		overRideExample();
		overRideExample("passing in data");
		overRideExample(1);
		overRideExample(1,"passing in data");
	}

}

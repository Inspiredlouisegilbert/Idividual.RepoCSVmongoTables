package fundamentals;

import org.testng.annotations.Test;

public class ChildClass extends ParentClass {
	//extents
	//super
	//this
	//overloading
	
	String aa = "String Value from Child class";
	
	public void overLoadExample() {
		System.out.println("overRideExample");
		System.out.println(this.aa);
		String aa = "I am inside the method";
		System.out.println(aa);
		
	}
	
	public void overLoadExample(String inputExample) {
		System.out.println("String Overload Example:" + inputExample);
	}
	
	public void overLoadExample(int inputIntExample) {
		System.out.println("int Overload Example:" +inputIntExample);
	}
	
	public void overLoadExample(int inputIntExample, String inputExample) {
		System.out.println("int Overload Example:" +inputIntExample + " String Overrid Example:" + inputExample);
	}
	
	public void getData()
	{
		System.out.println("I am child class");
	}
	
	@Test
	public void getDt()
	{
		super.getData();
		getData();
		System.out.println("I am in child class");
		overLoadExample();
		overLoadExample("passing in data");
		overLoadExample(1);
		overLoadExample(1,"passing in data");
		System.out.println(aa);
		System.out.println(super.aa);
	}

}

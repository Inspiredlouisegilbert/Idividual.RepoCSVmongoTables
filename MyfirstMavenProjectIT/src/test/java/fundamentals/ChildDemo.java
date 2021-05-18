package fundamentals;

import org.testng.annotations.Test;

public class ChildDemo extends ParentDemo {
	
	public void getData()
	{
		System.out.println("I am child class");
	}
	
	public void getData(String demoInput)
	{
		System.out.println("I am child class and it prints " + demoInput);
	}
	
	public void getData(int demoInt)
	{
		System.out.println("I am child class and it prints " + demoInt);
	}
	
	public void getData(int demoInt,String demoInput)
	{
		System.out.println("I am child class and it prints the int and String " + demoInt + " " + demoInput);
	}
	
	@Test
	public void testone()
	{
		System.out.println("testone");
		getData();
		getData("---print this---");
		getData(4);
		getData(4,"this is the second param");
		super.getData();
		parentDemo();
		
	}

}

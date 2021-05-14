package fundamentals;

public class Strings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		//String : it is one of the prebuilt class in java
		/* 1.String literal
		2.by creating object of string*/

		String a= " javatraining";//string 

		System.out.println(a.charAt(2));
		System.out.println(a.indexOf("e"));
		System.out.println(a.substring(3, 6));
		System.out.println(a.substring(5));
		System.out.println(a.concat("Louise teaches"));
		//a.length()
		System.out.println(a.trim());
		a.toUpperCase();
		a.toLowerCase();
		//split
		String arr[]=a.split("t");
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(a.replace("t", "s"));

		//String practice
		//Reverse the string
		String bi = "louise";
		String ti = "";
		
		for (int ii=5; ii>=0;ii--) {
			
			ti= ti + bi.charAt(ii);
			
			
		}
		System.out.println(ti);



	}

}

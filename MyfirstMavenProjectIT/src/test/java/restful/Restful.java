package restful;



import static io.restassured.RestAssured.given;
import org.json.simple.JSONObject;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification; 
import java.util.ArrayList; 
import java.util.concurrent.TimeUnit; 
import static io.restassured.RestAssured.*;

//https://medium.com/chaya-thilakumara/rest-assured-api-testing-part-1-e96a2f284a6e

public class Restful 
{
	@Parameters ({"systemUnderTest"})
	@Test //(groups= {"Include"})
	//@Test (groups= {"SmokeTest"})  
	//@Test
    public void extractall(String systemUnderTest) {
    	
    	given()
    		.when()
    		//.log()
    		//.all()
    		.get(systemUnderTest)
    		.then()
    		.log()
    		.all()
    		.extract()
    		.response();
    }
	
	@Parameters ({"systemUnderTestExample"})
	@Test (groups= {"Include"})
	public void postExample(String systemUnderTestExample)
	{
		JSONObject request = new JSONObject();
		request.put("name", "chaya");
		request.put("job", "BA");

		System.out.println(request);
		System.out.println(request.toString());

		given().
		body(request.toJSONString()).
		when().
		post(systemUnderTestExample).
		then().statusCode(201);
        
       

	}
	
	@Parameters ({"systemUnderTest"})
	@Test
    public void statusCode(String systemUnderTest) {

    	
    	given()
    	.when()
    	.get(systemUnderTest)
    	.then()
    	.statusCode(200);

    }
	@Parameters ({"systemUnderTest"})
	@Test (groups= {"SmokeTest"})
    public void pageEquals2(String systemUnderTest) {


    	given().when().get(systemUnderTest)
    			.then()
    			.assertThat()
    			.body("page",equalTo(2));

    }
	
	@Parameters ({"systemUnderTest"})
	@Test (groups= {"Include"})
    public void dataTest(String systemUnderTest) {


    	given().when().get(systemUnderTest)
    			.then()
    			.assertThat()
    			.body("page",equalTo(2),
    			"data[0].id", equalTo(7));
    	
    	int a = given().when().get(systemUnderTest)
		.then().extract().
        path("data[0].id");
    	System.out.println(a);
    	
    	String b = given().when().get(systemUnderTest)
    			.then().extract().
    	        path("data[0].email");
    	    	System.out.println(b);
    	    	

    }
	
	@Parameters ({"systemUnderTest"})
	@Test (groups= {"SmokeTest"})
    public void emailValidation(String systemUnderTest) {


    	given().when().get(systemUnderTest)
    			.then()
    			.assertThat()
    			.body("data[0].email", equalTo("michael.lawson@reqres.in"));
	}
	
	@Parameters ({"systemUnderTest"})
	@Test (groups= {"SmokeTest"})
    public void howManyDataElements(String systemUnderTest) {


    	given().when().get(systemUnderTest)
    			.then()
    			.assertThat()
    			.statusCode(200)
    			.body("size()", equalTo(6));
    	
    	
   
	}


	@Parameters ({"systemUnderTest"})
	@Test (groups= {"SmokeTest"})
    public void supporttext(String systemUnderTest) {


    	given().when().get(systemUnderTest)
    			.then()
    			.assertThat()
    			.body("support.text",equalTo("To keep ReqRes free, contributions towards server costs are appreciated!"));
    }


	@Parameters ({"systemUnderTest"})
	//@Test (groups= {"SmokeTest"})
	@Test (groups= {"SmokeTest"})  
    public void getHeaders(String systemUnderTest) {

    	System.out.println(given().when().get(systemUnderTest).then().extract().headers());
    }
	
	@Parameters ({"systemUnderTestGuru"})
	//@Test (groups= {"Include"}) 
	public static void getResponseBody(String systemUnderTestGuru){
		 
		//String strAmount = 
		given().queryParam("CUSTOMER_ID","68195")
		           .queryParam("PASSWORD","1234!")
		           .queryParam("Account_No","1")
		           .when().get(systemUnderTestGuru).then()
		           .log().all().extract().response();

		}
	
	@Parameters ({"systemUnderTestGuru"})
	@Test (groups= {"SmokeTest"})  
	//@Test 
	public static void getResponseStatus(String systemUnderTestGuru){
		   //int statusCode= 
				   given().queryParam("CUSTOMER_ID","68195")
		           .queryParam("PASSWORD","1234!")
		           .queryParam("Account_No","1")
		           .when().get(systemUnderTestGuru)
		           .then()
		           //.assertThat()
		           //.statusCode(200)
		           .log()
		    		.all()
		    		//.body("message.ErrorMsg:",equalTo("Login Credentials Incorrect"));
		    		;
				   //message["ErrorMsg:"]
		
		   //System.out.println("The response status is "+statusCode);

		   //given().when().get(systemUnderTestGuru).then().assertThat().statusCode(200);
		}	
	
	@Parameters ({"systemUnderTestAcme"})
	@Test (groups= {"SmokeTest"})  
	public void checkSiteIsUp(String systemUnderTestAcme) {
		 
		 given().when().get(systemUnderTestAcme).then().assertThat().statusCode(200);

	 }

}

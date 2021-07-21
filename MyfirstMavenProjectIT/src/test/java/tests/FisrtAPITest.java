package tests;

import static io.restassured.RestAssured.given;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

 

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class FisrtAPITest {

	 @BeforeClass
	    public static void setup() {
	        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
	    }

	 

	    @Test
	    public void getRequest() {
	        //The HTTP GET request is used to fetch a resource from a server.
	        Response response = given()
	                .contentType(ContentType.JSON)
	                .when()
	                .get("/posts")
	                .then()
	                .extract().response();

	 

	        Assert.assertEquals(response.statusCode(),200);
	        Assert.assertEquals(response.jsonPath().getString("id[2]"),"3");
	    }
	    
	    @Test
	    public void getRequestWithQueryParam() {
	        Response response = given()
	                .contentType(ContentType.JSON)
	                .param("postId", "1")
	                .when()
	                .get("/comments")
	                .then()
	                .extract().response();

	 

	        Assert.assertEquals(response.statusCode(),200);
	        Assert.assertEquals(response.jsonPath().getString("email[3]"),"Lew@alysha.tv"); 
	    }

	    @Test
	    public void getRequestWithQueryParam2() {
	        Response response = given()
	                .contentType(ContentType.JSON)
	                .param("postId", "2")
	                .when()
	                .get("/comments")
	                .then()
	                .extract().response();

	 

	        Assert.assertEquals(response.statusCode(),200);
	        Assert.assertEquals(response.jsonPath().getString("email[3]"),"Meghan_Littel@rene.us");
	    }

	    
}

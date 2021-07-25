package restful;

import static io.restassured.RestAssured.given;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
 
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
public class APIExample {

	
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
	        Assert.assertEquals(response.jsonPath().getString("title[0]"),"sunt aut facere repellat provident occaecati excepturi optio reprehenderit");
	    }

	    @Test
	    
	    public void getRequestWithQueryParam() {
	        Response response = given()
	                .contentType(ContentType.JSON)
	                .param("PostId", "2")
	                .when()
	                .get("/Comments")
	                .then()
	                .extract().response();
	 
	        Assert.assertEquals(response.statusCode(),200);
	        Assert.assertEquals(response.jsonPath().getString("name[2]"),"et omnis dolorem");
 }
}

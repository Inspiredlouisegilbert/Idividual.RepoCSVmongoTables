package restful;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification; 
import java.util.ArrayList; 
import java.util.concurrent.TimeUnit; 
import static io.restassured.RestAssured.*;


public class HTTPgetDemo 
{
    @BeforeClass
    public static void setup() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        
        //END POINTS
        //https://jsonplaceholder.typicode.com/
        //https://jsonplaceholder.typicode.com/posts
        //https://jsonplaceholder.typicode.com/comments
        //https://jsonplaceholder.typicode.com/comments?postID=2
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
                .param("postId", "2")
                .when()
                .get("/comments")
                .then()
                .extract().response();

        Assert.assertEquals(response.statusCode(),200);
        Assert.assertEquals(response.jsonPath().getString("email[3]"),"Meghan_Littel@rene.us");
        Assert.assertEquals(response.jsonPath().getString("email[4]"),"Carmen_Keeling@caroline.name");
    }
    
    @Test
    public void extractAll() {
    	given().
    	when().
    		//log().
    		//all().
    		get("https://reqres.in/api/users?page=2").
    	then().
    		log().
    		all().
    		extract().
    		response();
    }
}
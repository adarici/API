package api_practice;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.Comment1;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class PostDT01 extends JsonPlaceHolderBaseUrl {
    /*
        Given    https://jsonplaceholder.typicode.com/comments

            {
                "name": "This class has smart people",
                "postId": 82,
                "id": 501,
                "body": "Congratulations Everyone",
                "email": "techproedstudents@gmail.com"
            }

            When I send Post Request to the URL

            Then the status code should be 201
            Response should be like

                 {
                "name": "This class has smart people",
                "postId": 82,
                "id": 501,
                "body": "Congratulations Everyone",
                "email": "techproedstudents@gmail.com"
            }

         */
    @Test
    public void post01(){
        spec.pathParam("first","comments");

        Map<String, Object> expectedDataMap = new HashMap<>();
        expectedDataMap.put("name","This class has smart people");
        expectedDataMap.put("postId",85);
        expectedDataMap.put("id",501);
        expectedDataMap.put("body","Congratulations Everyone");
        expectedDataMap.put("email","techproedstudents@gmail.com");


        Response response = given().spec(spec).contentType(ContentType.JSON).body(expectedDataMap).when().post("/{first}");

        response.then().statusCode(201);

     Map<String, Object> actualData = response.as(HashMap.class);
        System.out.println("expected"+expectedDataMap);
        System.out.println("actualData"+actualData);

        assertEquals(expectedDataMap,actualData);
        assertEquals(expectedDataMap.get("id"),actualData.get("id"));
        assertEquals(expectedDataMap.get("name"),actualData.get("name"));
        assertEquals(expectedDataMap.get("postId"),actualData.get("postId"));
        assertEquals(expectedDataMap.get("body"),actualData.get("body"));
        assertEquals(expectedDataMap.get("email"),actualData.get("email"));



    }
       /*
        Given    https://jsonplaceholder.typicode.com/comments

            {
                "name": "This class has smart people",
                "postId": 82,
                "id": 501,
                "body": "Congratulations Everyone",
                "email": "techproedstudents@gmail.com"
            }

            When I send Post Request to the URL

            Then the status code should be 201
            Response should be like

                 {
                "name": "This class has smart people",
                "postId": 82,
                "id": 501,
                "body": "Congratulations Everyone",
                "email": "Congratulations Everyone"
            }
                    Make sure you use pojo
                     to make your post request
         */

    @Test
    public void post02(){
        spec.pathParam("first","comments");

        Comment1 comment1 = new Comment1();
        comment1.setPostId(85);
        comment1.setName("This class has smart people");
        comment1.setId(501);
        comment1.setBody("Congratulations Everyone");
        comment1.setEmail("Congratulations Everyone");

        Response response = given().spec(spec).contentType(ContentType.JSON).body(comment1).when().post("/{first}");
       response.then().assertThat().statusCode(201);

       Comment1 comment11 = response.as(Comment1.class);
        System.out.println("Name: "+comment11.getName());
        System.out.println("Id: "+comment11.getId());
        System.out.println("email: "+comment11.getEmail());
        System.out.println("postId: "+comment11.getPostId());
        System.out.println("body: "+comment11.getBody());

        assertEquals(comment1.getName(),comment11.getName());
        assertEquals(comment1.getId(),comment11.getId());
        assertEquals(comment1.getEmail(),comment11.getEmail());
        assertEquals(comment1.getPostId(),comment11.getPostId());
        assertEquals(comment1.getBody(),comment11.getBody());


    }

    



}

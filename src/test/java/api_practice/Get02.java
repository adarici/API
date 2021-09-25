package api_practice;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.*;

import static org.junit.Assert.*;

public class Get02 extends JsonPlaceHolderBaseUrl {
    /*
         When
		     I send a GET Request to the URL https://jsonplaceholder.typicode.com/comments
		 Then
		     HTTP Status Code should be 200
		And
		     Search all ids that are less than 30
		     the number of ids less than 30 should be 29

     */

    @Test
    public void get02(){
        spec.pathParam("first","comments");

        Response response = given().spec(spec).when().get("/{first}");
        response.prettyPrint();

        JsonPath json=response.jsonPath();
        response.then().assertThat().statusCode(200);
        List<Integer> idList= json.getList("findAll{it.id<30}.id");
        System.out.println(idList);


        assertTrue("Id list  has not expected size",idList.size()==29);



    }



}

package http_delete_request_method;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.testng.Assert.*;

public class Delete01 extends JsonPlaceHolderBaseUrl {
    /*
        Given
            https://jsonplaceholder.typicode.com/todos/198
        When
	 		I send DELETE Request to the Url
	 	Then
		 	Status code is 200
		 	And Response body is { }
     */

    @Test
    public void delete01(){
        //1.
        spec.pathParams("first","todos","second",198);
        //2.
        Map<String,Object> expectedData = new HashMap<>();
        //3.
        Response response=given().spec(spec).when().delete("/{first}/{second}");

        //4.
        Map<String,Object> actualData = response.as(HashMap.class);

        assertEquals(expectedData,actualData);
        assertTrue(actualData.isEmpty());

        assertTrue(actualData.size()==0);



    }



}

package http_patch_request_method;


import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;

import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class Patch01 extends JsonPlaceHolderBaseUrl {

    /*
        Given
	        https://jsonplaceholder.typicode.com/todos/198

	        {
                "title": "Wash the dishes",
            }

        When
	 		I send PATCH Request to the Url
	    Then
	   	   Status code is 200
	   	   And response body is like   {
									    "userId": 10,
									    "title": "Wash the dishes",
									    "completed": true,
									    "id": 198
									   }
     */

    @Test
    public void patch01(){
        //1.Step: Set the url
        spec.pathParams("first", "todos", "second", 198);

        //2.Step: Set the request body
        JsonPlaceHolderTestData requestBody = new JsonPlaceHolderTestData();
        Map<String, Object> requestBodyMap = requestBody.expectedDataSetUpWithSomeKeys(null, "Wash the dishes", null);
        System.out.println(requestBodyMap);

        //3.Step: Send the request and get the response
        Response response = given().spec(spec).contentType(ContentType.JSON).body(requestBodyMap).when().patch("/{first}/{second}");
        response.prettyPrint();

        //4.Step: Do assertions

        //1.Logic: You did not touch "userId" and "completed" so no need to do assertion for "userId" and "completed"
        response.then().assertThat().statusCode(200).body("title", equalTo(requestBodyMap.get("title")));

        //2.Logic: You did not touch "userId" and "completed" but maybe changing "title" affected the "userId" and "completed".
        //         So I need to do assertion for "userId" and "completed" as well even you did not touch them
        Map<String, Object> expectedDataMap = requestBody.expectedDataSetUpWithAllKeys(10, "Wash the dishes", true);
        response.
                then().
                assertThat().
                statusCode(200).
                body("title", equalTo(expectedDataMap.get("title")),
                        "userId", equalTo(expectedDataMap.get("userId")),
                        "completed", equalTo(expectedDataMap.get("completed")));

    }
}
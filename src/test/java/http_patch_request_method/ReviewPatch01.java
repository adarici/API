package http_patch_request_method;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;

import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ReviewPatch01 extends JsonPlaceHolderBaseUrl {
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
    public void ReviewPatch01(){
        spec.pathParams("first","todos","second",198);

        JsonPlaceHolderTestData requestBody = new JsonPlaceHolderTestData();
        Map<String,Object> requestBodyMap = requestBody.expectedDataSetUpWithSomeKeys(null,"Wash the dishes",null);
        System.out.println(requestBodyMap);

        Response response = given().
                spec(spec).
                contentType(ContentType.JSON).
                body(requestBodyMap).
                when().
                patch("/{first}/{second}");
        response.prettyPrint();

        response.then().assertThat().statusCode(200).body("title",equalTo(requestBodyMap.get("title")));

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

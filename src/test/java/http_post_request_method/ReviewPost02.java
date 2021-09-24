package http_post_request_method;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.ReviewJsonPlaceHolderTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;


public class ReviewPost02 extends JsonPlaceHolderBaseUrl {
      /*
        Given
            https://jsonplaceholder.typicode.com/todos
            {
            "userId": 55,
            "title": "Tidy your room",
            "completed": false
            }
        When
            I send POST Request to the Url
        Then
            Status code is 201
        And
            response body is like {
                                    "userId": 55,
                                    "title": "Tidy your room",
                                    "completed": false,
                                    "id": 201
                                    }
     */
    @Test
    public void post02(){
        //1.
        spec.pathParam("1","todos");
        //2.
        ReviewJsonPlaceHolderTestData expectedData = new ReviewJsonPlaceHolderTestData();
        Map<String, Object> expectedDataMap = expectedData.expectedDataSetUp();
        //3.
        Response response = given().
                spec(spec).
                contentType(ContentType.JSON).
                body(expectedDataMap).
                when().post("/{1}");
        response.prettyPrint();
                                    expectedDataMap.put("StatusCode", 201);
        //4.
        Map<String,Object> actualData = response.as(HashMap.class);
        System.out.println(actualData);

       assertEquals(expectedDataMap.get("StatusCode"),response.getStatusCode());
        assertEquals(expectedDataMap.get("userId"),actualData.get("userId"));
        assertEquals(expectedDataMap.get("title"),actualData.get("title"));
        assertEquals(expectedDataMap.get("completed"),actualData.get("completed"));





    }


}

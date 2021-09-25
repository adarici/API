package http_post_request_method;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import pojos.JsonPlaceHolderPojo;
import test_data.JsonPlaceHolderTestData;
import utils.JsonUtil;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class PostWithObjectMapperAndPojo extends JsonPlaceHolderBaseUrl {
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
    public void postWithObjectMapperAndPojo(){

        spec.pathParam("first", "todos");

        JsonPlaceHolderTestData expected = new JsonPlaceHolderTestData();
        String expectedData=expected.expectedDataInString(55,"Tidy your room", false);

      JsonPlaceHolderPojo expectedDataPojo=JsonUtil.convertJsonToJava(expectedData, JsonPlaceHolderPojo.class);
        System.out.println(expectedDataPojo);

        Response response = given().spec(spec).contentType(ContentType.JSON).body(expectedDataPojo).when().post("/{first}");
        response.prettyPrint();

        JsonPlaceHolderPojo actualDataPojo=JsonUtil.convertJsonToJava(response.asString(),JsonPlaceHolderPojo.class);
        System.out.println(actualDataPojo);

        assertEquals(201, response.getStatusCode());

        assertEquals(expectedDataPojo.getUserId(),actualDataPojo.getUserId());
        assertEquals(expectedDataPojo.getTitle(),actualDataPojo.getTitle());
        assertEquals(expectedDataPojo.getCompleted(),actualDataPojo.getCompleted());


    }

}

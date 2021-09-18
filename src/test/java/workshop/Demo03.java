package workshop;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Demo03 extends JsonPlaceHolderBaseUrl {
/*
 Given
            https://jsonplaceholder.typicode.com/todos/23
        When
            User send GET Request to the URL
        Then
            HTTP Status Code should be 200
		And
		    Response format should be “application/json”
		And
		    “title” is “et itaque necessitatibus maxime molestiae qui quas velit”,
		And
		    “completed” is false
		And
		    “userId” is 2
 */

    @Test
    public void demo03(){
       //String url =  "https://jsonplaceholder.typicode.com/todos/23";
        spec.pathParams("first","todos", "second", 23);
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();
        response.
                then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body("title", equalTo("et itaque necessitatibus maxime molestiae qui quas velit"),
                        "completed",equalTo(false),
                        "userId",equalTo(2));


    }
}

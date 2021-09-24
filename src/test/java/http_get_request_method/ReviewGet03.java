package http_get_request_method;

import base_urls.ReviewJsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ReviewGet03 extends ReviewJsonPlaceHolderBaseUrl {
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
  public void get03(){
      //1.Step: set the URL
      spec.pathParams("first", "todos", "second", 23);

      //2.Step: Set the expected data

      //3.Step: Send the request and get the response
      Response response = given().spec(spec).when().get("/{first}/{second}");
      response.prettyPrint();

        //4. Step: Do assertion
      // Instead of "application/json" you can type ContentType.JSON
      //Instead of "application/json" you can type ContentType.JSON
      //1.Way:
      response.
              then().
              assertThat().
              statusCode(200).
              contentType(ContentType.JSON).
              body("title", equalTo("et itaque necessitatibus maxime molestiae qui quas velit")).
              body("completed", equalTo(false)).
              body("userId", equalTo(2));
      //2.Way:
      response.
              then().
              assertThat().
              statusCode(200).
              contentType(ContentType.JSON).
              body("title", equalTo("et itaque necessitatibus maxime molestiae qui quas velit"),
                      "completed", equalTo(false),
                      "userId", equalTo(2));


  }


}

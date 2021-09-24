package http_get_request_method;

import base_urls.ReviewHerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.*;

public class ReviewGet02 extends ReviewHerOkuAppBaseUrl {
    /*
    Given
        https://restful-booker.herokuapp.com/booking/1001
    When
        Sent a Get Request to the URL
    Then
        HTTP Status code should be 404
    And
        Status Line should be HTTP/1.1 404 Not Found
   And
        Response body contains "Not Found"
   And
        Response body does not contain "TechProEd"
     */
    @Test
    public void get02(){
        // 1. Step: Setting URL
        spec.pathParams("first","booking","second",1001);

        // 2. Step: Set the expected data

        //3. Step: Send Request and get response from API
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        //4. Step: Do assertion
        response.then().assertThat().statusCode(404).statusLine("HTTP/1.1 404 Not Found");

        assertTrue("Body is not containing expected text",response.asString().contains("Not Found"));

        assertFalse("Even the text does not exist in response body, it says exist",response.asString().contains("TechProEd"));

        assertEquals("Server names are not matching","Cowboy",response.getHeader("Server"));


    }

}

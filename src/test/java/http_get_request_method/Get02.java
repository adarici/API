package http_get_request_method;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class Get02 extends HerOkuAppBaseUrl {

    /*
  Given
       https://restful-booker.herokuapp.com/booking/1001
  When
        User send a GET Request to the url
  Then
        HTTP Status code should be 404
  And
        Status line should be HTTP/1.1 404 Not Found
  And
        Response body contains "Not Found"
 And
        Response body does not contains "TechProEd"
And
        Server is "Cowboy"

     */
// Note: Path Parameters are used to make resource smaller
    @Test
    public void get02(){
       // 1)Step:  Set the url
        //String url = "https://restful-booker.herokuapp.com/booking/1001"; ==> Not Recommended
    spec.pathParams("first", "booking", "second",1001);

    // 2)Step: Set the expected data

        // 3) Step: Send the request and get the response
        Response response = given().spec(spec).when().get("/{first}/{second}");
response.prettyPrint();// Not Found

//        //4. Step: Assertions
//        response.then().assertThat().statusCode(404).statusLine("HTTP/1.1 404 Not Found");
//
//        //assertTrue(true) ==> Green tick            assertTrue(false) ==> Red cross
//        assertTrue(response.asString().contains("Not Found"));//If response.asString().contains("Not Found") returns true, you will get green tick
//
//        //assertFalse(false) ==> Green tick            assertFalse(true) ==> Red cross
//        assertFalse(response.asString().contains("TechProEd"));//If response.asString().contains("TechProEd") returns false, you will get green tick
//
//        //Expected Data comes from test case, Actual Data comes from API
//        //assertEquals() returns true(test passes) if the arguments match
//        assertEquals("Cowboy", response.getHeader("Server"));



    }




}

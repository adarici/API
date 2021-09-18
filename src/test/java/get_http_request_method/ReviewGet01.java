package get_http_request_method;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class ReviewGet01 {
/*
We use Gherkin Language to create test cases.
Gherkin Language has 4 main keywords; Given, When, Then, And
Given: It is used for pre-requisites
When: It is used for action
Then: It is used for outputs
And: It is used for multiple Given, When, and Then (outputs and actions)
 */

    /*
                     Test Case - get01
    Given
        https://restful-booker.herokuapp.com/booking/3
    When
        User send GET request to the URL
    Then
        HTTP status code should be 200
    And
        Content type should be application/json
   And  Status line should be like  HTTP/1.1 200 OK
     */
    @Test
    public void get01() {

        // 1. Step: Setting url
        String url = "https://restful-booker.herokuapp.com/booking/3";

        // 2. Step: Set the expected data

        //3. Step: Send Request and get response from API

        Response response = given().when().get(url);
        response.prettyPrint();

        //4. Step: Do assertion
        /*
        If you have multiple error in your functionality, Java will stop execution after the first error
        Because of that you can not see any error message for the other errors.

        If the execution stopped after the first error it is called "Hard Assertion"
        There is also "Soft Assertion (Verification)", it does not stop execution after error. It execute all codes then gives error message for all errors
         */
        response.then().assertThat().statusCode(200).contentType("application/json").statusLine("HTTP/1.1 200 OK");

        // How to print status code, line,headers etc. on the console
        System.out.println("Status code is: " + response.getStatusCode());
        System.out.println("Status Line " + response.getStatusLine());
        System.out.println("Content type is: " + response.getContentType());
        System.out.println("Headers are: \n" + response.getHeaders());
        System.out.println("Server header is: "+response.getHeader("Server"));
        System.out.println("Time is: "+response.getTime());

    }
}
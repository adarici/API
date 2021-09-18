package get_http_request_method;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

public class ReviewGet06 extends HerOkuAppBaseUrl {
    /*
        Given
            https://restful-booker.herokuapp.com/booking/5
        When
            User send a GET request to the URL
        Then
            HTTP Status Code should be 200
        And
            Response content type is “application/json”
        And
            Response body should be like;
            {
                "firstname": "Mary",
                "lastname": "Jackson",
                "totalprice": 111,
                "depositpaid": false,
                "bookingdates": { "checkin": "2017-05-23",
                                  "checkout":"2019-07-02" }
            }
     */
    @Test
    public void get06(){

        //1.Step: Set the URL
        spec.pathParams("first", "booking", "second", 5);

        //2.Step: Set the expected data

        //3.Step: Send the request get the response
        Response response = given().spec(spec).when().get("/{first}/{second}");

        //4.Step: Do assertions
        //1.Way:
//        response.
//                then().
//                assertThat().
//                statusCode(200).
//                body("firstname", equalTo("Sally"),
//                        "lastname", equalTo("Wilson"),
//                        "totalprice", equalTo(827),
//                        "depositpaid", equalTo(false),
//                        "bookingdates.checkin", equalTo("2018-05-15"),
//                        "bookingdates.checkout", equalTo("2019-11-11"));
        //2.Way: Use JsonPath Class
        JsonPath json = response.jsonPath();
//        assertEquals("Susan", json.getString("firstname"));
//        assertEquals("Brown", json.getString("lastname"));
//        assertEquals(997, json.getInt("totalprice"));
//        assertEquals(false, json.getBoolean("depositpaid"));
//        assertEquals("2016-02-11", json.getString("bookingdates.checkin"));
//        assertEquals("2018-06-23", json.getString("bookingdates.checkout"));

        //3.Way: Soft Assertion
        //i)Create a SoftAssert object
        SoftAssert softAssert = new SoftAssert();

        //ii)Do assertions by using assert methods
        softAssert.assertEquals(json.getString("firstname"), "Jim", "Firstname does not match");
        softAssert.assertEquals(json.getString("lastname"), "Jones", "Lastname does not match");
        softAssert.assertEquals(json.getInt("totalprice"), 707, "Total price does not match");
        softAssert.assertEquals(json.getBoolean("depositpaid"), false, "Deposit paid does not match");
        softAssert.assertEquals(json.getString("bookingdates.checkin"), "2019-07-22", "Check in does not match");
        softAssert.assertEquals(json.getString("bookingdates.checkout"), "2019-08-04", "Check out does not match");

        //iii)Do not forget using assertAll()
        softAssert.assertAll();

    }

}
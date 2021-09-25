package http_get_request_method;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.BookingPojo;
import pojos.BookingdatesPojo;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class GetWithPojo01 extends HerOkuAppBaseUrl {
 /*
        Given
            https://restful-booker.herokuapp.com/booking/2
        When
 		    I send GET Request to the URL
 	    Then
 		    Status code is 200
 		And
 		    Response body is like {
                                    "firstname": "Mary",
                                    "lastname": "Smith",
                                    "totalprice": 647,
                                    "depositpaid": false,
                                    "bookingdates": {
                                        "checkin": "2016-02-05",
                                        "checkout": "2021-01-16"
                                     }
                                  }
     */

    @Test
    public void getWithPojo01(){

        //1.Step: Set the URL
        spec.pathParams("first", "booking", "second", 2);

        //2.Step: Set the expected data
        BookingdatesPojo bookingdates = new BookingdatesPojo("2015-10-21", "2017-03-07");
        BookingPojo expectedData = new BookingPojo("Susan", "Brown", 444, false, bookingdates);

        //3.Step: Send the request and get the response
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        //Create actualData Pojo by using GSON
        BookingPojo actualData = response.as(BookingPojo.class);

        //4.Step: Do assertions
        assertEquals(200, response.getStatusCode());

        assertEquals(expectedData.getFirstname(),actualData.getFirstname());
        assertEquals(expectedData.getLastname(),actualData.getLastname());
        assertEquals(expectedData.getTotalprice(),actualData.getTotalprice());
        assertEquals(expectedData.getDepositpaid(),actualData.getDepositpaid());
        assertEquals(expectedData.getBookingdates().getCheckin(),actualData.getBookingdates().getCheckin());
        assertEquals(expectedData.getBookingdates().getCheckout(),actualData.getBookingdates().getCheckout());

    }

}

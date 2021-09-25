package http_post_request_method;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.BookingPojo;
import pojos.BookingPostResponseBodyPojo;
import pojos.BookingdatesPojo;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class PostWithPojo02 extends HerOkuAppBaseUrl {
    /*
        Given
            https://restful-booker.herokuapp.com/booking

            {
                "firstname": "Suleyman",
                "lastname": "Alptekin",
                "totalprice": 999,
                "depositpaid": true,
                "bookingdates": {
                    "checkin": "2021-09-21",
                    "checkout": "2021-12-21"
                 }
                 "additionalneeds": "Breakfast with white tea, Dragon juice"
             }
        When
 		    I send POST Request to the URL
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
                                     "additionalneeds": "Breakfast"
                                  }
     */
    @Test
    public void postWithPojo02(){
        spec.pathParam("first","booking");

        BookingdatesPojo bookingdates = new BookingdatesPojo("2016-02-05","2021-01-16");
        BookingPojo postRequestBody = new BookingPojo("Ali","Darici",999,true,bookingdates,"Breakfast with white tea and Dragon juice");

        Response response = given().spec(spec).contentType(ContentType.JSON).body(postRequestBody).when().post("/{first}");
        response.prettyPrint();

        BookingPostResponseBodyPojo actualData = response.as(BookingPostResponseBodyPojo.class);
        assertEquals(200, response.getStatusCode());
        assertEquals(postRequestBody.getFirstname(),actualData.getBooking().getFirstname());
        assertEquals(postRequestBody.getLastname(),actualData.getBooking().getLastname());
        assertEquals(postRequestBody.getTotalprice(),actualData.getBooking().getTotalprice());
        assertEquals(postRequestBody.getDepositpaid(),actualData.getBooking().getDepositpaid());

        assertEquals(postRequestBody.getBookingdates().getCheckin(),actualData.getBooking().getBookingdates().getCheckin());
        assertEquals(postRequestBody.getBookingdates().getCheckout(),actualData.getBooking().getBookingdates().getCheckout());
        assertEquals(postRequestBody.getAdditionalneeds(),actualData.getBooking().getAdditionalneeds());
    }

}

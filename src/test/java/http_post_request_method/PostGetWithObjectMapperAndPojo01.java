package http_post_request_method;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.BookingPojo;
import pojos.BookingPostResponseBodyPojo;
import pojos.BookingdatesPojo;
import utils.JsonUtil;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class PostGetWithObjectMapperAndPojo01 extends HerOkuAppBaseUrl {
        /*
        Given
	        https://restful-booker.herokuapp.com/booking

	        {
                "firstname": "Selim",
                "lastname": "Ak",
                "totalprice": 11111,
                "depositpaid": true,
                "bookingdates": {
                    "checkin": "2021-09-09",
                    "checkout": "2021-09-21"
                 }
              }
        When
	 		I send POST Request to the Url
	   And
	        I send POST Request to the Url
	 	Then
	 		Status code is 200
	 	And
	 	    GET response body should be like {
											        "firstname": "Selim",
											        "lastname": ""Ak"",
											        "totalprice": 11111,
											        "depositpaid": true,
											        "bookingdates": {
											            "checkin": "2020-09-09",
											            "checkout": "2020-09-21"
											        }
											        "additionalneeds": "Breakfast"
											    }
     */

    @Test
    public void postGetWithObjectMapperAndPojo01(){
     spec.pathParam("first","booking");

        BookingdatesPojo bookingDates = new BookingdatesPojo("2020-09-09","2020-09-21");
        BookingPojo requestBody = new BookingPojo("Selim","Ak",11111,true,bookingDates,"Breakfast");
        System.out.println(requestBody);

        Response response = given().spec(spec).contentType(ContentType.JSON).body(requestBody).when().post("/{first}");
        response.prettyPrint();

        BookingPostResponseBodyPojo postResponseBodyInPojo=JsonUtil.convertJsonToJava(response.asString(), BookingPostResponseBodyPojo.class);
        System.out.println(postResponseBodyInPojo);

        Integer bookingId = postResponseBodyInPojo.getBookingid();

        spec.pathParams("first","booking","second",bookingId);


        Response response1 = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        BookingPojo getRequestBodyInPojo=JsonUtil.convertJsonToJava(response1.asString(),BookingPojo.class);

        assertEquals(200, response.getStatusCode());

        assertEquals(requestBody.getFirstname(),getRequestBodyInPojo.getFirstname());
        assertEquals(requestBody.getLastname(),getRequestBodyInPojo.getLastname());
        assertEquals(requestBody.getTotalprice(),getRequestBodyInPojo.getTotalprice());
        assertEquals(requestBody.getDepositpaid(),getRequestBodyInPojo.getDepositpaid());

        assertEquals(requestBody.getBookingdates().getCheckin(),getRequestBodyInPojo.getBookingdates().getCheckin());
        assertEquals(requestBody.getBookingdates().getCheckout(),getRequestBodyInPojo.getBookingdates().getCheckout());


    }
}

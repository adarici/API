package http_post_request_method;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class ReviewPost01 extends HerOkuAppBaseUrl {
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
	 	Then
	 		Status code is 200
	 		And response body should be like {
											    "bookingid": 11,
											    "booking": {
											        "firstname": "Selim",
											        "lastname": "Ak",
											        "totalprice": 11111,
											        "depositpaid": true,
											        "bookingdates": {
											            "checkin": "2020-09-09",
											            "checkout": "2020-09-21"
											        }
											    }
											 }
     */
    @Test
    public void post01(){
        //1.
        spec.pathParam("first","booking");
        //2.
        Map<String,String> newBookingDates = new HashMap<>();
        newBookingDates.put("checkin","2020-09-09");
        newBookingDates.put("checkout","2020-09-21");

        Map<String,Object> newBookingData = new HashMap<>();
        newBookingData.put("firstname","Selim");
        newBookingData.put("lastname","Al");
        newBookingData.put("totalprice",11111);
        newBookingData.put("depositpaid",true);
        newBookingData.put("bookingdates",newBookingDates);
        //3.
        Response response = given().
                spec(spec).
                contentType(ContentType.JSON).
                body(newBookingData).when().post("/{first}");
        response.prettyPrint();
        //4.
        Map<String,Object> actualData = response.as(HashMap.class);
        System.out.println(actualData);
// What is the purpose of usage this part because no changes on console and test passes
        assertEquals(newBookingData.get("firstname"),((Map) actualData.get("booking")).get("firstname"));
        assertEquals(newBookingData.get("lastname"),((Map) actualData.get("booking")).get("lastname"));
        assertEquals(newBookingData.get("totalprice"),((Map) actualData.get("booking")).get("totalprice"));
        assertEquals(newBookingData.get("depositpaid"),((Map) actualData.get("booking")).get("depositpaid"));
// Teacher used twice (Map) Why?
        assertEquals(newBookingData.get("checkin"), ((Map)((Map)actualData.get("booking")).get("bookingdates")).get("checkin"));
        assertEquals(newBookingData.get("checkout"), ((Map)((Map)actualData.get("booking")).get("bookingdates")).get("checkout"));



    }


}

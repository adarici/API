package workshop;


import base_urls.HerOkuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class ReviewPost01 extends HerOkuAppBaseUrl {
    @Test
    public void post01(){
        //1.Step: Set the url
        spec.pathParam("first", "booking");
        //2.
        Map<String,String> expected1 = new HashMap<>();
        expected1.put("checkin","2021-09-09");
        expected1.put("checkout","2021-09-21");

        Map<String,Object> expected2 = new HashMap<>();
        expected2.put("firstname","Ali");
        expected2.put("lastname","Karaoglan");
        expected2.put("totalprice", 12345);
        expected2.put("depositpaid",true);
        expected2.put("bookingdates",expected1);

        //3.
        Response response = given().
                spec(spec).
                accept(ContentType.JSON).
                body(expected2).
                when().post("/{first}");
        response.prettyPrint();

    //4.
        Map<String,Object> actualData = response.as(TreeMap.class);
        System.out.println(actualData);

        assertEquals(expected2.get("firstname"),((Map) actualData.get("firstname")));






    }

}

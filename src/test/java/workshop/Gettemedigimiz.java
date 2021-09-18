package workshop;

import base_urls.HerOkuAppBaseUrl;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;


public class Gettemedigimiz extends HerOkuAppBaseUrl {


    @Test

    public void getiyoruz(){
        spec.pathParams("first","booking","second",1001);

        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        response.
                then().
                assertThat().
                statusCode(404).
                statusLine("HTTP/1.1 404 Not Found");
        assertTrue(response.asString().contains("Not Found"));
        assertFalse(response.asString().contains("TechProEd"));

      assertEquals("Cowboy",response.getHeader("Server"));

    }
}

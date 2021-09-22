package workshop;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertTrue;

public class Get05woerkshop extends HerOkuAppBaseUrl {
        /*
        Given
            https://restful-booker.herokuapp.com/booking
        When
            User send a request to the URL
        Then
            Status code is 200
	  	And
	  		Among the data there should be someone whose firstname is "Mary" and last name is "Ericsson"
     */
    @Test
    public void get05(){

        spec.pathParam("1","booking").
        queryParams("firstname", "Sally2","lastname","Brown");



        Response response = given().spec(spec).contentType(ContentType.JSON).when().get("/{1}");
        response.prettyPrint();

        response.then().assertThat().statusCode(200);
                assertTrue(response.asString().contains("bookingid"));

    }

}

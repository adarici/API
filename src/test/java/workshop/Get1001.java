package workshop;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;


public class Get1001 extends HerOkuAppBaseUrl {

    @Test
    public void get1001(){

        spec.pathParams("first", "booking", "second",1001);

        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();


    }


}

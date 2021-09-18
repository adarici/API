package api_practice;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class DummyDTGet04 extends DummyBaseUrl {

    /*
         When
		     I send a GET Request to the URL http://dummy.restapiexample.com/api/v1/employee
		 Then
		     HTTP Status Code should be 200
		 And
		     Content Type should be JSON
		 And
		    This user exists in the system
           {
            "status": "success",
            "data": {
                "id": 9,
                "employee_name": "Colleen Hurst",
                "employee_salary": 205500,
                "employee_age": 39,
                "profile_image": ""
            },
            "message": "Successfully! Record has been fetched."
}

     */


    @Test
    public void get04() {
        spec.pathParams("first", "api", "second", "v1", "third", "employee","final","9");

        Response response = given().spec(spec).when().get("/{first}/{second}/{third}/{final}");

        response.prettyPrint();

        response.
                then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body("status", equalTo("success"),"data.id",equalTo(9),
                        "data.employee_name",equalTo("Colleen Hurst"),
                        "data.employee_salary",equalTo(205500),
                        "data.employee_age",equalTo(39),
                        "message", equalTo("Successfully! Record has been fetched.")
                        );

    }
}
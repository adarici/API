package api_practice;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class DummyDTGet02 extends DummyBaseUrl{

     /*
         When
		     I send a GET Request to the URL http://dummy.restapiexample.com/api/v1/employees
		 Then
		     HTTP Status Code should be 200
		 And
		     Content Type should be JSON
		 And
		    This user exists in the system
            {
            "id": 15,
            "employee_name": "Tatyana Fitzpatrick",
            "employee_salary": 385750,
            "employee_age": 19,
            "profile_image": ""
        },

     */

    @Test
    public void get02() {
        spec.pathParams("first", "api", "second", "v1", "third", "employees");

        Response response = given().spec(spec).when().get("/{first}/{second}/{third}");

        response.prettyPrint();

        response.
                then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body("data.id",hasItem(15)).
                body("data.employee_name",hasItems("Tatyana Fitzpatrick"));


    }
}

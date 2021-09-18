package api_practice;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.*;

public class Get08 extends DummyBaseUrl{
    /*
         When
		     I send a GET Request to the URL http://dummy.restapiexample.com/api/v1/employee/
		 Then
		     HTTP Status Code should be 200
		 And
		     Content Type should be JSON
		 And
		    This user exists in the system
           {
            "id": 7,
            "employee_name": "Herrod Chandler",
            "employee_salary": 137500,
            "employee_age": 59,
            "profile_image": ""
        },
        {
            "id": 8,
            "employee_name": "Rhona Davidson",
            "employee_salary": 327900,
            "employee_age": 55,
            "profile_image": ""
        },

     */
    @Test
    public void get08(){

        spec.pathParams("first","api","second","v1","third","employee","final",7);

        Response response = given().spec(spec).when().get("/{first}/{second}/{third}/{final}");

        response.prettyPrint();

        response.
                then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body("data.id",hasItem(7),
                        "data.employee_name",equalTo("Herrod Chandler"),
                        "data.employee_salary",equalTo(137500),
                        "data.employee_age",equalTo(59));

        JsonPath json = response.jsonPath();

        spec.pathParams("first","api","second","v1","third","employee","final",8);
        Response response2 = given().spec(spec).when().get("/{first}/{second}/{third}/{final}");

        JsonPath json2 = response2.jsonPath();

    }


}

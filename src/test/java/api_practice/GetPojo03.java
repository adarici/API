package api_practice;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojos.Comment1;

import static io.restassured.RestAssured.*;

public class GetPojo03 extends JsonPlaceHolderBaseUrl {
   /*
         When
		     I send a GET Request to the URL https://jsonplaceholder.typicode.com/comments
		 Then
		     HTTP Status Code should be 200
		And
		     Search all ids that are less than 30
		     the number of ids less than 30 should be 29

		     Use just pojo classes for this validation

     */
    @Test
    public void getPojo03(){
        spec.pathParam("first", "comments");

        Response response = given().spec(spec).when().get("/{first}");
        //response.prettyPrint();

        Comment1 [] comments = response.as(Comment1[].class);

        int count = 0;
        for (int i =0;i<comments.length;i++){
            if(comments[i].getId()<30){
                count++;
            }
            System.out.println(i+"id"+comments[i].getId());
        }

        Assert.assertTrue(count==29);



    }

}

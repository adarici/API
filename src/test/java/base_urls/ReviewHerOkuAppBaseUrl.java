package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class ReviewHerOkuAppBaseUrl {
    // Create an object whose data type is RequestSpecification
    protected RequestSpecification spec;
    //If you use @Before annotation before a method, it means the method will be executed before every test method
    @Before
    public void setUp(){
        spec = new RequestSpecBuilder().setBaseUri("https://restful-booker.herokuapp.com").build();


    }

}

package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeEach;

public class HerOkuAppBaseUrl {

    protected RequestSpecification spec;

    @BeforeEach//JunitJupiter annotation
    public void setUp(){

        spec = new RequestSpecBuilder().setBaseUri("https://restful-booker.herokuapp.com/").build();


    }


}
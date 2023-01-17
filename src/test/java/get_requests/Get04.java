package get_requests;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Get04 extends HerOkuAppBaseUrl {
    /*
       Given
           https://restful-booker.herokuapp.com/booking/8065
       When
           User send a GET request to the URL
       Then
           HTTP Status Code should be 200
       And
           Response content type is “application/json”
       And
           Response body should be like;
                    {
                       "firstname": "Jane",
                       "lastname": "Doe",
                       "totalprice": 111,
                       "depositpaid": true,
                       "bookingdates": {
                           "checkin": "2018-01-01",
                           "checkout": "2019-01-01"
                       },
                       "additionalneeds": "Extra pillows please"
                   }
    */
    @Test
    public void get04(){
        //Set the url
        spec.pathParams("first","booking","second",8065);

        //Set the expected data

        //Send the request and get the response
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        //Do assertion
        JsonPath jsonPath = response.jsonPath();

        assertEquals(200,response.statusCode());
        assertEquals("application/json; charset=utf-8",response.contentType());
        assertEquals("Jane",jsonPath.getString("firstname"));
        assertEquals("Doe",jsonPath.getString("lastname"));
        assertEquals(111,jsonPath.getInt("totalprice"));
        assertEquals(true,jsonPath.getBoolean("depositpaid"));
        assertEquals("2018-01-01",jsonPath.getString("bookingdates.checkin"));
        assertEquals( "2019-01-01",jsonPath.getString("bookingdates.checkout"));
        assertEquals("Extra pillows please",jsonPath.getString("additionalneeds"));

    }
}
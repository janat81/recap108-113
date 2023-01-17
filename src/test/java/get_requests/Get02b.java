package get_requests;

import base_urls.PetStoreBaseUrl;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;


public class Get02b extends PetStoreBaseUrl {
    //Print all "available" pets on console by using "https://petstore.swagger.io/" documentation.

    /*
    Given
        https://petstore.swagger.io/v2/pet/findByStatus?status=available
    When
        User sends Get request to Url
    Then
        HTTP Status Code is 200
    And
        Print all "available" pets on console
     */

    @Test
    public void get02(){
        //Set the url
        spec.pathParams("first","pet","second","findByStatus").
                queryParams("status","available");

        //Set the expected data

        //Send the request and get the response
        Response response =given().spec(spec).when().get("/{first}/{second}");

        //Print all "available" pets on console
        response.prettyPrint();

        //Do Assertion
        response.then().assertThat().statusCode(200);
    }
}



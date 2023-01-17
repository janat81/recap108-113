package get_requests;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Get01 {

     /*
   Given
       https://petstore.swagger.io/v2/pet/12
   When
       User sends a GET Request to the url
   Then
       HTTP Status Code should be 200
   And
       Content Type should be JSON
   And
       Status Line should be HTTP/1.1 200 OK
*/

    public static void main(String[] args) {

        // Set the url
        String url = "https://petstore.swagger.io/v2/pet/12";

        // Set the expected data

        // Send the request and get the response
        Response response = given().when().get(url);
        response.prettyPrint();

        // Do assertion

        //
        if (response.statusCode() == 200) {
            System.out.println("Test passed: Status code is 200");

        } else {
            System.out.println("Test failed: Status code " + response.statusCode());
        }


        if (response.statusLine().equals("application/json")) {
            System.out.println("Success");
        }

        // Content type should be JSON
        if(response.contentType().equals("application/json")){
            System.out.println("Test passed: Content type is application/json");
        }else{
            System.out.println("Test failed: Content type is" + response.contentType());
        }

    }
}

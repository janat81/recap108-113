
package post_requests;

import base_urls.PetStoreBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import pojos.PetStoreUserPojo;
import pojos.PetStoreUserResponsePojo;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Post02 extends PetStoreBaseUrl {
    /*
        Given
          1) https://petstore.swagger.io/v2/user/
          2)  {
                 "id": 11234,
                 "username": "JohnDoe123",
                 "firstName": "John",
                 "lastName": "Doe",
                 "email": "j@d.com",
                 "password": "abc",
                 "phone": "1234",
                 "userStatus": 2
               }
       When
           I send POST Request to the Url

       Then
           Status code is 200
       And
           response body is like
                               {
                                   "code": 200,
                                   "type": "unknown",
                                   "message": "11234"
                               }
    */
    @Test
    public void post02(){
        //Set the url
        spec.pathParam("first","user");

        //Set the expected data
        PetStoreUserPojo expectedData = new PetStoreUserPojo(11234,"JohnDoe123","John","Doe","j@d.com","abc","1234",2);
        System.out.println("expectedData = " + expectedData);

        //Send the request and get the response
        Response response = given().spec(spec).contentType(ContentType.JSON).body(expectedData).when().post("{first}");
        response.prettyPrint();

        //Do assertion
        PetStoreUserResponsePojo actualData = response.as(PetStoreUserResponsePojo.class);
        System.out.println("actualData = " + actualData);

        assertEquals(200,response.statusCode());
        assertEquals(200,actualData.getCode());
        assertEquals("unknown",actualData.getType());
        assertEquals("11234",actualData.getMessage());

    }
}
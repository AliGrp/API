package patch_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class Patch01 extends JsonPlaceHolderBaseUrl {
       /*
        Given
           1) https://jsonplaceholder.typicode.com/todos/198
           2) {
                 "title": "Wash the dishes"
               }
        When
         I send PATCH Request to the Url
       Then
             Status code is 200
             And response body is like   {
                               "userId": 10,
                               "title": "Wash the dishes",
                               "completed": true,
                               "id": 198
                               }
     */

    @Test
    public void patch01(){//Patch kismi guncelleme
        //Set the url
        spec.pathParams("first","todos","second",198);
        //Set the expected data
        Map<String, Object> expectedData = new JsonPlaceHolderTestData().expectedDataMap(null,"Wash the dishes",null);;
        System.out.println("expectedData = " + expectedData);
        //Send the request and the request
        Response response = given(spec).body(expectedData).put("{first}/{second}");
        response.prettyPrint();
        //Do assertion
        Map<String, Object>actualData=response.as(HashMap.class);
        assertEquals(200,response.statusCode());
        assertEquals(expectedData.get("title"),actualData.get("title"));














    }
}

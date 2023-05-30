package practise;

import base_urls.RegresInAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Practise02 extends RegresInAppBaseUrl {

 /*
        Given
            https://reqres.in/api/users/23
        When
            User send a GET Request to the url
        Then
            HTTP Status code should be 404
        And
            Status Line should be HTTP/1.1 404 Not Found
        And
            Server is "cloudflare"
        And
            Response body should be empty
     */

    @Test
    public void test01() {
        //Set the url

       // spec.pathParams("first","users","second",23);
        String url ="https://reqres.in/api/users/23";
        //Set the expected data

        //Send the request and get the response
        Response response = given().get(url);
        response.prettyPrint();

        //do assertion
        response.then().
                statusCode(404).
                statusLine("HTTP/1.1 404 Not Found");
        //Response body contains "Not Found"
        assertTrue(response.asString().contains("Not Found"));
        //Server is "Cowboy"
        String server = response.header("Server");
        assertEquals("cloudflare",server);


    }





}

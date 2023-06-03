package delete_request;

import Utilities.ObjectMapperUtils;
import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import java.util.Map;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;
import org.junit.Test;
import java.util.HashMap;
import static io.restassured.RestAssured.given;


    public class Delete01 extends JsonPlaceHolderBaseUrl {
     /*
        Given
            https://jsonplaceholder.typicode.com/todos/198
        When
         I send DELETE Request to the Url
      Then
         Status code is 200
         And Response body is { }
     */

        @Test
        public void delete01() {
            //Set the url
            spec.pathParams("first", "todos", "second", 198);

            //Set the expected data
            Map<String, String> expectedData = new HashMap<>();

            //Send the request and get the response
            Response response = given(spec).delete("{first}/{second}");
            response.prettyPrint();

            //Do assertion
            Map<String, String> actualData = ObjectMapperUtils.convertJsonToJava(response.asString(), HashMap.class);
            assertEquals(200, response.statusCode());
            //1. Yol:
            assertEquals(expectedData, actualData);

            //2. Yol:
            assertTrue(actualData.isEmpty());

            //3. Yol:
            assertEquals(0, actualData.size());

        }
    }


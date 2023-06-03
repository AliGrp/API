package herokuapp_smoketest;

import base_urls.HerOkuAppBaseUrl;
import org.junit.Test;

import static herokuapp_smoketest.C01_PostRequest.bookingid;

public class C04_PatchRequest extends HerOkuAppBaseUrl {
    /*
    Given
        https://restful-booker.herokuapp.com/booking/:id
    And
        {
        "additionalneeds": "Lunch"
        }
    When
        Send patch request
    Then
        Status code is 200
    And
        Body:
        {
        "firstname": "Ali",
        "lastname": "Can",
        "totalprice": 222,
        "depositpaid": true,
        "bookingdates": {
            "checkin": "2018-01-01",
            "checkout": "2019-01-01"
        },
        "additionalneeds": "Lunch"
    }
     */

    @Test
    public void patch01(){
        //Set the url
        spec.pathParams("first","booking", "second", bookingid);

        //Set the expected data



    }
}